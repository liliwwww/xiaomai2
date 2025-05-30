package androidx.compose.p004ui.text.input;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import android.view.ViewParent;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.compose.p004ui.window.DialogWindowProvider;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@RequiresApi(30)
/* loaded from: classes.dex */
final class ImmHelper30 implements ImmHelper {

    @Nullable
    private ImmHelper21 _immHelper21;

    @NotNull
    private final View view;

    public ImmHelper30(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.view = view;
    }

    private final Window findWindow(View view) {
        Window window;
        ViewParent parent = view.getParent();
        DialogWindowProvider dialogWindowProvider = parent instanceof DialogWindowProvider ? (DialogWindowProvider) parent : null;
        if (dialogWindowProvider != null && (window = dialogWindowProvider.getWindow()) != null) {
            return window;
        }
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return findWindow(context);
    }

    private final ImmHelper21 getImmHelper21() {
        ImmHelper21 immHelper21 = this._immHelper21;
        if (immHelper21 != null) {
            return immHelper21;
        }
        ImmHelper21 immHelper212 = new ImmHelper21(this.view);
        this._immHelper21 = immHelper212;
        return immHelper212;
    }

    private final WindowInsetsControllerCompat getInsetsControllerCompat() {
        Window findWindow = findWindow(this.view);
        if (findWindow != null) {
            return new WindowInsetsControllerCompat(findWindow, this.view);
        }
        return null;
    }

    @Override // androidx.compose.p004ui.text.input.ImmHelper
    @DoNotInline
    public void hideSoftInput(@NotNull InputMethodManager inputMethodManager) {
        Intrinsics.checkNotNullParameter(inputMethodManager, "imm");
        WindowInsetsControllerCompat insetsControllerCompat = getInsetsControllerCompat();
        if (insetsControllerCompat != null) {
            insetsControllerCompat.hide(WindowInsetsCompat.Type.ime());
        } else {
            getImmHelper21().hideSoftInput(inputMethodManager);
        }
    }

    @Override // androidx.compose.p004ui.text.input.ImmHelper
    @DoNotInline
    public void showSoftInput(@NotNull InputMethodManager inputMethodManager) {
        Intrinsics.checkNotNullParameter(inputMethodManager, "imm");
        WindowInsetsControllerCompat insetsControllerCompat = getInsetsControllerCompat();
        if (insetsControllerCompat != null) {
            insetsControllerCompat.show(WindowInsetsCompat.Type.ime());
        } else {
            getImmHelper21().showSoftInput(inputMethodManager);
        }
    }

    private final Window findWindow(Context context) {
        while (!(context instanceof Activity)) {
            if (!(context instanceof ContextWrapper)) {
                return null;
            }
            context = ((ContextWrapper) context).getBaseContext();
            Intrinsics.checkNotNullExpressionValue(context, "baseContext");
        }
        return ((Activity) context).getWindow();
    }
}
