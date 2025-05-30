package androidx.core.view;

import android.view.WindowInsetsController;
import androidx.core.view.WindowInsetsControllerCompat;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final /* synthetic */ class b implements WindowInsetsController.OnControllableInsetsChangedListener {
    public final /* synthetic */ WindowInsetsControllerCompat.Impl30 a;
    public final /* synthetic */ WindowInsetsControllerCompat$OnControllableInsetsChangedListener b;

    public /* synthetic */ b(WindowInsetsControllerCompat.Impl30 impl30, WindowInsetsControllerCompat$OnControllableInsetsChangedListener windowInsetsControllerCompat$OnControllableInsetsChangedListener) {
        this.a = impl30;
        this.b = windowInsetsControllerCompat$OnControllableInsetsChangedListener;
    }

    @Override // android.view.WindowInsetsController.OnControllableInsetsChangedListener
    public final void onControllableInsetsChanged(WindowInsetsController windowInsetsController, int i) {
        WindowInsetsControllerCompat.Impl30.a(this.a, this.b, windowInsetsController, i);
    }
}
