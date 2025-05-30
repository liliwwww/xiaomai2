package androidx.compose.runtime.saveable;

import androidx.compose.runtime.saveable.SaveableStateRegistry;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
final class SaveableStateRegistryImpl implements SaveableStateRegistry {

    @NotNull
    private final Function1<Object, Boolean> canBeSaved;

    @NotNull
    private final Map<String, List<Object>> restored;

    @NotNull
    private final Map<String, List<Function0<Object>>> valueProviders;

    public SaveableStateRegistryImpl(@Nullable Map<String, ? extends List<? extends Object>> map, @NotNull Function1<Object, Boolean> function1) {
        Map<String, List<Object>> mutableMap;
        Intrinsics.checkNotNullParameter(function1, "canBeSaved");
        this.canBeSaved = function1;
        this.restored = (map == null || (mutableMap = MapsKt.toMutableMap(map)) == null) ? new LinkedHashMap<>() : mutableMap;
        this.valueProviders = new LinkedHashMap();
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    public boolean canBeSaved(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "value");
        return ((Boolean) this.canBeSaved.invoke(obj)).booleanValue();
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    @Nullable
    public Object consumeRestored(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        List<Object> remove = this.restored.remove(str);
        if (remove == null || !(!remove.isEmpty())) {
            return null;
        }
        if (remove.size() > 1) {
            this.restored.put(str, remove.subList(1, remove.size()));
        }
        return remove.get(0);
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    @NotNull
    public Map<String, List<Object>> performSave() {
        Map<String, List<Object>> mutableMap = MapsKt.toMutableMap(this.restored);
        for (Map.Entry<String, List<Function0<Object>>> entry : this.valueProviders.entrySet()) {
            String key = entry.getKey();
            List<Function0<Object>> value = entry.getValue();
            if (value.size() == 1) {
                Object invoke = value.get(0).invoke();
                if (invoke == null) {
                    continue;
                } else {
                    if (!canBeSaved(invoke)) {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                    mutableMap.put(key, CollectionsKt.arrayListOf(new Object[]{invoke}));
                }
            } else {
                int size = value.size();
                ArrayList arrayList = new ArrayList(size);
                for (int i = 0; i < size; i++) {
                    Object invoke2 = value.get(i).invoke();
                    if (invoke2 != null && !canBeSaved(invoke2)) {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                    arrayList.add(invoke2);
                }
                mutableMap.put(key, arrayList);
            }
        }
        return mutableMap;
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    @NotNull
    public SaveableStateRegistry.Entry registerProvider(@NotNull final String str, @NotNull final Function0<? extends Object> function0) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(function0, "valueProvider");
        if (!(!StringsKt.isBlank(str))) {
            throw new IllegalArgumentException("Registered key is empty or blank".toString());
        }
        Map<String, List<Function0<Object>>> map = this.valueProviders;
        List<Function0<Object>> list = map.get(str);
        if (list == null) {
            list = new ArrayList<>();
            map.put(str, list);
        }
        list.add(function0);
        return new SaveableStateRegistry.Entry() { // from class: androidx.compose.runtime.saveable.SaveableStateRegistryImpl$registerProvider$3
            @Override // androidx.compose.runtime.saveable.SaveableStateRegistry.Entry
            public void unregister() {
                Map map2;
                Map map3;
                map2 = SaveableStateRegistryImpl.this.valueProviders;
                List list2 = (List) map2.remove(str);
                if (list2 != null) {
                    list2.remove(function0);
                }
                if (list2 == null || !(!list2.isEmpty())) {
                    return;
                }
                map3 = SaveableStateRegistryImpl.this.valueProviders;
                map3.put(str, list2);
            }
        };
    }
}
