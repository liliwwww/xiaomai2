package androidx.activity;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class ComponentActivity$5 implements LifecycleEventObserver {
    final /* synthetic */ ComponentActivity this$0;

    ComponentActivity$5(ComponentActivity componentActivity) {
        this.this$0 = componentActivity;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
        this.this$0.ensureViewModelStore();
        this.this$0.getLifecycle().removeObserver(this);
    }
}
