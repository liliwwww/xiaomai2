package androidx.compose.runtime.saveable;

import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class SaveableStateHolderImpl$RegistryHolder {

    @NotNull
    private final Object key;

    @NotNull
    private final SaveableStateRegistry registry;
    private boolean shouldSave;
    final /* synthetic */ SaveableStateHolderImpl this$0;

    public SaveableStateHolderImpl$RegistryHolder(@NotNull final SaveableStateHolderImpl saveableStateHolderImpl, Object obj) {
        Intrinsics.checkNotNullParameter(obj, "key");
        this.this$0 = saveableStateHolderImpl;
        this.key = obj;
        this.shouldSave = true;
        this.registry = SaveableStateRegistryKt.SaveableStateRegistry((Map) SaveableStateHolderImpl.access$getSavedStates$p(saveableStateHolderImpl).get(obj), new Function1<Object, Boolean>() { // from class: androidx.compose.runtime.saveable.SaveableStateHolderImpl$RegistryHolder$registry$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @NotNull
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Boolean m924invoke(@NotNull Object obj2) {
                Intrinsics.checkNotNullParameter(obj2, "it");
                SaveableStateRegistry parentSaveableStateRegistry = saveableStateHolderImpl.getParentSaveableStateRegistry();
                return Boolean.valueOf(parentSaveableStateRegistry != null ? parentSaveableStateRegistry.canBeSaved(obj2) : true);
            }
        });
    }

    @NotNull
    public final Object getKey() {
        return this.key;
    }

    @NotNull
    public final SaveableStateRegistry getRegistry() {
        return this.registry;
    }

    public final boolean getShouldSave() {
        return this.shouldSave;
    }

    public final void saveTo(@NotNull Map<Object, Map<String, List<Object>>> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        if (this.shouldSave) {
            Map<String, List<Object>> performSave = this.registry.performSave();
            if (performSave.isEmpty()) {
                map.remove(this.key);
            } else {
                map.put(this.key, performSave);
            }
        }
    }

    public final void setShouldSave(boolean z) {
        this.shouldSave = z;
    }
}
