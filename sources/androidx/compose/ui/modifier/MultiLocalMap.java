package androidx.compose.ui.modifier;

import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class MultiLocalMap extends ModifierLocalMap {

    @NotNull
    private final SnapshotStateMap<ModifierLocal<?>, Object> map;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiLocalMap(@NotNull Pair<? extends ModifierLocal<?>, ? extends Object>... pairArr) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(pairArr, "entries");
        SnapshotStateMap<ModifierLocal<?>, Object> mutableStateMapOf = SnapshotStateKt.mutableStateMapOf();
        this.map = mutableStateMapOf;
        mutableStateMapOf.putAll(MapsKt.toMap(pairArr));
    }

    public boolean contains$ui_release(@NotNull ModifierLocal<?> modifierLocal) {
        Intrinsics.checkNotNullParameter(modifierLocal, "key");
        return this.map.containsKey(modifierLocal);
    }

    @Nullable
    public <T> T get$ui_release(@NotNull ModifierLocal<T> modifierLocal) {
        Intrinsics.checkNotNullParameter(modifierLocal, "key");
        T t = (T) this.map.get(modifierLocal);
        if (t == null) {
            return null;
        }
        return t;
    }

    public <T> void set$ui_release(@NotNull ModifierLocal<T> modifierLocal, T t) {
        Intrinsics.checkNotNullParameter(modifierLocal, "key");
        this.map.put(modifierLocal, t);
    }
}
