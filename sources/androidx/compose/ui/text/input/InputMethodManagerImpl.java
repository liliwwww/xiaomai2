package androidx.compose.ui.text.input;

import android.os.Build;
import android.view.View;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.InputMethodManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class InputMethodManagerImpl implements InputMethodManager {

    @NotNull
    private final ImmHelper helper;

    @NotNull
    private final Lazy imm$delegate;

    @NotNull
    private final View view;

    public InputMethodManagerImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.view = view;
        this.imm$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<InputMethodManager>() { // from class: androidx.compose.ui.text.input.InputMethodManagerImpl$imm$2
            {
                super(0);
            }

            @NotNull
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final InputMethodManager m1972invoke() {
                View view2;
                view2 = InputMethodManagerImpl.this.view;
                Object systemService = view2.getContext().getSystemService("input_method");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
                return (InputMethodManager) systemService;
            }
        });
        this.helper = Build.VERSION.SDK_INT < 30 ? new ImmHelper21(view) : new ImmHelper30(view);
    }

    private final InputMethodManager getImm() {
        return (InputMethodManager) this.imm$delegate.getValue();
    }

    public void hideSoftInput() {
        this.helper.hideSoftInput(getImm());
    }

    public void restartInput() {
        getImm().restartInput(this.view);
    }

    public void showSoftInput() {
        this.helper.showSoftInput(getImm());
    }

    public void updateExtractedText(int i, @NotNull ExtractedText extractedText) {
        Intrinsics.checkNotNullParameter(extractedText, "extractedText");
        getImm().updateExtractedText(this.view, i, extractedText);
    }

    public void updateSelection(int i, int i2, int i3, int i4) {
        getImm().updateSelection(this.view, i, i2, i3, i4);
    }
}
