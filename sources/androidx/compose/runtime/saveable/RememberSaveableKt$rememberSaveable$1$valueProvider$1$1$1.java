package androidx.compose.runtime.saveable;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class RememberSaveableKt$rememberSaveable$1$valueProvider$1$1$1 implements SaverScope {
    final /* synthetic */ SaveableStateRegistry $registry;

    RememberSaveableKt$rememberSaveable$1$valueProvider$1$1$1(SaveableStateRegistry saveableStateRegistry) {
        this.$registry = saveableStateRegistry;
    }

    public final boolean canBeSaved(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "it");
        return this.$registry.canBeSaved(obj);
    }
}
