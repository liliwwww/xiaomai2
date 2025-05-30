package androidx.appcompat.app;

import android.graphics.Rect;
import androidx.appcompat.widget.FitWindowsViewGroup;
import androidx.core.view.WindowInsetsCompat;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class AppCompatDelegateImpl$4 implements FitWindowsViewGroup.OnFitSystemWindowsListener {
    final /* synthetic */ AppCompatDelegateImpl this$0;

    AppCompatDelegateImpl$4(AppCompatDelegateImpl appCompatDelegateImpl) {
        this.this$0 = appCompatDelegateImpl;
    }

    public void onFitSystemWindows(Rect rect) {
        rect.top = this.this$0.updateStatusGuard((WindowInsetsCompat) null, rect);
    }
}
