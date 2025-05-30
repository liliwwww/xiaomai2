package androidx.activity;

import android.view.View;
import android.view.Window;
import androidx.activity.ComponentActivity;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class ComponentActivity$3 implements LifecycleEventObserver {
    final /* synthetic */ ComponentActivity this$0;

    ComponentActivity$3(ComponentActivity componentActivity) {
        this.this$0 = componentActivity;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_STOP) {
            Window window = this.this$0.getWindow();
            View peekDecorView = window != null ? window.peekDecorView() : null;
            if (peekDecorView != null) {
                ComponentActivity.Api19Impl.cancelPendingInputEvents(peekDecorView);
            }
        }
    }
}
