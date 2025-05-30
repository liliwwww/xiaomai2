package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.saveable.SaveableStateRegistry;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class LazySaveableStateHolder$Companion$saver$2 extends Lambda implements Function1<Map<String, ? extends List<? extends Object>>, LazySaveableStateHolder> {
    final /* synthetic */ SaveableStateRegistry $parentRegistry;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LazySaveableStateHolder$Companion$saver$2(SaveableStateRegistry saveableStateRegistry) {
        super(1);
        this.$parentRegistry = saveableStateRegistry;
    }

    @Nullable
    public final LazySaveableStateHolder invoke(@NotNull Map<String, ? extends List<? extends Object>> map) {
        Intrinsics.checkNotNullParameter(map, "restored");
        return new LazySaveableStateHolder(this.$parentRegistry, map);
    }
}
