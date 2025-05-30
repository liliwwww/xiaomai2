package androidx.compose.ui.tooling;

import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.lifecycle.LifecycleRegistry;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class ComposeViewAdapter$FakeOnBackPressedDispatcherOwner$1 implements OnBackPressedDispatcherOwner {

    @NotNull
    private final OnBackPressedDispatcher onBackPressedDispatcher = new OnBackPressedDispatcher();
    final /* synthetic */ ComposeViewAdapter this$0;

    ComposeViewAdapter$FakeOnBackPressedDispatcherOwner$1(ComposeViewAdapter composeViewAdapter) {
        this.this$0 = composeViewAdapter;
    }

    @Override // androidx.activity.OnBackPressedDispatcherOwner
    @NotNull
    public OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return this.onBackPressedDispatcher;
    }

    @Override // androidx.lifecycle.LifecycleOwner
    @NotNull
    public LifecycleRegistry getLifecycle() {
        return ComposeViewAdapter.access$getFakeSavedStateRegistryOwner$p(this.this$0).getLifecycleRegistry();
    }
}
