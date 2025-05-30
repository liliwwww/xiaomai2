package androidx.fragment.app;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import tb.j56;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class FragmentManagerViewModel$1 implements ViewModelProvider.Factory {
    FragmentManagerViewModel$1() {
    }

    @NonNull
    public <T extends ViewModel> T create(@NonNull Class<T> cls) {
        return new FragmentManagerViewModel(true);
    }

    public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
        return j56.b(this, cls, creationExtras);
    }
}
