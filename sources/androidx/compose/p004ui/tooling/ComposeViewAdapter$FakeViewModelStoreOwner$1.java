package androidx.compose.p004ui.tooling;

import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class ComposeViewAdapter$FakeViewModelStoreOwner$1 implements ViewModelStoreOwner {

    @NotNull
    private final ViewModelStore viewModelStore = new ViewModelStore();

    ComposeViewAdapter$FakeViewModelStoreOwner$1() {
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    @NotNull
    public ViewModelStore getViewModelStore() {
        return this.viewModelStore;
    }
}
