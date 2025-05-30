package androidx.compose.p004ui.text.input;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.DoNotInline;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
final class ImmHelper21 implements ImmHelper {

    @NotNull
    private final View view;

    public ImmHelper21(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.view = view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showSoftInput$lambda$0(InputMethodManager inputMethodManager, ImmHelper21 immHelper21) {
        Intrinsics.checkNotNullParameter(inputMethodManager, "$imm");
        Intrinsics.checkNotNullParameter(immHelper21, "this$0");
        inputMethodManager.showSoftInput(immHelper21.view, 0);
    }

    @Override // androidx.compose.p004ui.text.input.ImmHelper
    @DoNotInline
    public void hideSoftInput(@NotNull InputMethodManager inputMethodManager) {
        Intrinsics.checkNotNullParameter(inputMethodManager, "imm");
        inputMethodManager.hideSoftInputFromWindow(this.view.getWindowToken(), 0);
    }

    @Override // androidx.compose.p004ui.text.input.ImmHelper
    @DoNotInline
    public void showSoftInput(@NotNull final InputMethodManager inputMethodManager) {
        Intrinsics.checkNotNullParameter(inputMethodManager, "imm");
        this.view.post(new Runnable() { // from class: androidx.compose.ui.text.input.a
            @Override // java.lang.Runnable
            public final void run() {
                ImmHelper21.showSoftInput$lambda$0(inputMethodManager, this);
            }
        });
    }
}
