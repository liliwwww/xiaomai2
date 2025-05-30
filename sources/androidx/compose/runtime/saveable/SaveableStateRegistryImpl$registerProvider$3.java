package androidx.compose.runtime.saveable;

import androidx.compose.runtime.saveable.SaveableStateRegistry;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class SaveableStateRegistryImpl$registerProvider$3 implements SaveableStateRegistry.Entry {
    final /* synthetic */ String $key;
    final /* synthetic */ Function0<Object> $valueProvider;
    final /* synthetic */ SaveableStateRegistryImpl this$0;

    SaveableStateRegistryImpl$registerProvider$3(SaveableStateRegistryImpl saveableStateRegistryImpl, String str, Function0<? extends Object> function0) {
        this.this$0 = saveableStateRegistryImpl;
        this.$key = str;
        this.$valueProvider = function0;
    }

    public void unregister() {
        List list = (List) SaveableStateRegistryImpl.access$getValueProviders$p(this.this$0).remove(this.$key);
        if (list != null) {
            list.remove(this.$valueProvider);
        }
        if (list == null || !(!list.isEmpty())) {
            return;
        }
        SaveableStateRegistryImpl.access$getValueProviders$p(this.this$0).put(this.$key, list);
    }
}
