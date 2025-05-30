package androidx.loader.app;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.loader.app.LoaderManagerImpl;
import tb.j56;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class LoaderManagerImpl$LoaderViewModel$1 implements ViewModelProvider.Factory {
    LoaderManagerImpl$LoaderViewModel$1() {
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    @NonNull
    public <T extends ViewModel> T create(@NonNull Class<T> cls) {
        return new LoaderManagerImpl.LoaderViewModel();
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
        return j56.b(this, cls, creationExtras);
    }
}
