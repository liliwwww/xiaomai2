package androidx.fragment.app;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelStore;
import java.util.Collection;
import java.util.Map;

/* compiled from: Taobao */
@Deprecated
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class FragmentManagerNonConfig {

    @Nullable
    private final Map<String, FragmentManagerNonConfig> mChildNonConfigs;

    @Nullable
    private final Collection<Fragment> mFragments;

    @Nullable
    private final Map<String, ViewModelStore> mViewModelStores;

    FragmentManagerNonConfig(@Nullable Collection<Fragment> collection, @Nullable Map<String, FragmentManagerNonConfig> map, @Nullable Map<String, ViewModelStore> map2) {
        this.mFragments = collection;
        this.mChildNonConfigs = map;
        this.mViewModelStores = map2;
    }

    @Nullable
    Map<String, FragmentManagerNonConfig> getChildNonConfigs() {
        return this.mChildNonConfigs;
    }

    @Nullable
    Collection<Fragment> getFragments() {
        return this.mFragments;
    }

    @Nullable
    Map<String, ViewModelStore> getViewModelStores() {
        return this.mViewModelStores;
    }

    boolean isRetaining(Fragment fragment) {
        Collection<Fragment> collection = this.mFragments;
        if (collection == null) {
            return false;
        }
        return collection.contains(fragment);
    }
}
