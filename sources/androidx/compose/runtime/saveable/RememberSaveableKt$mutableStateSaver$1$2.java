package androidx.compose.runtime.saveable;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.snapshots.SnapshotMutableState;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class RememberSaveableKt$mutableStateSaver$1$2<T> extends Lambda implements Function1<MutableState<Object>, MutableState<T>> {
    final /* synthetic */ Saver<T, Object> $this_with;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RememberSaveableKt$mutableStateSaver$1$2(Saver<T, Object> saver) {
        super(1);
        this.$this_with = saver;
    }

    @Nullable
    public final MutableState<T> invoke(@NotNull MutableState<Object> mutableState) {
        T t;
        Intrinsics.checkNotNullParameter(mutableState, "it");
        if (!(mutableState instanceof SnapshotMutableState)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (mutableState.getValue() != null) {
            Saver<T, Object> saver = this.$this_with;
            Object value = mutableState.getValue();
            Intrinsics.checkNotNull(value);
            t = saver.restore(value);
        } else {
            t = null;
        }
        SnapshotMutationPolicy policy = ((SnapshotMutableState) mutableState).getPolicy();
        Intrinsics.checkNotNull(policy, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutationPolicy<T of androidx.compose.runtime.saveable.RememberSaveableKt.mutableStateSaver$lambda$2?>");
        MutableState<T> mutableStateOf = SnapshotStateKt.mutableStateOf(t, policy);
        Intrinsics.checkNotNull(mutableStateOf, "null cannot be cast to non-null type androidx.compose.runtime.MutableState<T of androidx.compose.runtime.saveable.RememberSaveableKt.mutableStateSaver$lambda$2>");
        return mutableStateOf;
    }
}
