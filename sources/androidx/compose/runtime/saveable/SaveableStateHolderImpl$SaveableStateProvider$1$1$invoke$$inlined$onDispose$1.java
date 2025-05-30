package androidx.compose.runtime.saveable;

import androidx.compose.runtime.DisposableEffectResult;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class SaveableStateHolderImpl$SaveableStateProvider$1$1$invoke$$inlined$onDispose$1 implements DisposableEffectResult {
    final /* synthetic */ Object $key$inlined;
    final /* synthetic */ SaveableStateHolderImpl$RegistryHolder $registryHolder$inlined;
    final /* synthetic */ SaveableStateHolderImpl this$0;

    public SaveableStateHolderImpl$SaveableStateProvider$1$1$invoke$$inlined$onDispose$1(SaveableStateHolderImpl$RegistryHolder saveableStateHolderImpl$RegistryHolder, SaveableStateHolderImpl saveableStateHolderImpl, Object obj) {
        this.$registryHolder$inlined = saveableStateHolderImpl$RegistryHolder;
        this.this$0 = saveableStateHolderImpl;
        this.$key$inlined = obj;
    }

    public void dispose() {
        this.$registryHolder$inlined.saveTo(SaveableStateHolderImpl.access$getSavedStates$p(this.this$0));
        SaveableStateHolderImpl.access$getRegistryHolders$p(this.this$0).remove(this.$key$inlined);
    }
}
