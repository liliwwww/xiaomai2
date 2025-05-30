package androidx.compose.runtime;

import androidx.compose.runtime.collection.MutableVector;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final /* synthetic */ class SnapshotStateKt__DerivedStateKt {

    @NotNull
    private static final SnapshotThreadLocal<Integer> calculationBlockNestedLevel = new SnapshotThreadLocal<>();

    @NotNull
    private static final SnapshotThreadLocal<MutableVector<Pair<Function1<DerivedState<?>, Unit>, Function1<DerivedState<?>, Unit>>>> derivedStateObservers = new SnapshotThreadLocal<>();

    @NotNull
    public static final <T> State<T> derivedStateOf(@NotNull Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(function0, "calculation");
        return new DerivedSnapshotState(function0, null);
    }

    private static final <R> R notifyObservers$SnapshotStateKt__DerivedStateKt(DerivedState<?> derivedState, Function0<? extends R> function0) {
        MutableVector mutableVector = (MutableVector) derivedStateObservers.get();
        int i = 0;
        if (mutableVector == null) {
            mutableVector = new MutableVector(new Pair[0], 0);
        }
        int size = mutableVector.getSize();
        if (size > 0) {
            Object[] content = mutableVector.getContent();
            int i2 = 0;
            do {
                ((Function1) ((Pair) content[i2]).component1()).invoke(derivedState);
                i2++;
            } while (i2 < size);
        }
        try {
            R r = (R) function0.invoke();
            InlineMarker.finallyStart(1);
            int size2 = mutableVector.getSize();
            if (size2 > 0) {
                Object[] content2 = mutableVector.getContent();
                do {
                    ((Function1) ((Pair) content2[i]).component2()).invoke(derivedState);
                    i++;
                } while (i < size2);
            }
            InlineMarker.finallyEnd(1);
            return r;
        } catch (Throwable th) {
            InlineMarker.finallyStart(1);
            int size3 = mutableVector.getSize();
            if (size3 > 0) {
                Object[] content3 = mutableVector.getContent();
                do {
                    ((Function1) ((Pair) content3[i]).component2()).invoke(derivedState);
                    i++;
                } while (i < size3);
            }
            InlineMarker.finallyEnd(1);
            throw th;
        }
    }

    public static final <R> void observeDerivedStateRecalculations(@NotNull Function1<? super State<?>, Unit> function1, @NotNull Function1<? super State<?>, Unit> function12, @NotNull Function0<? extends R> function0) {
        Intrinsics.checkNotNullParameter(function1, "start");
        Intrinsics.checkNotNullParameter(function12, "done");
        Intrinsics.checkNotNullParameter(function0, "block");
        SnapshotThreadLocal<MutableVector<Pair<Function1<DerivedState<?>, Unit>, Function1<DerivedState<?>, Unit>>>> snapshotThreadLocal = derivedStateObservers;
        MutableVector<Pair<Function1<DerivedState<?>, Unit>, Function1<DerivedState<?>, Unit>>> mutableVector = snapshotThreadLocal.get();
        if (mutableVector == null) {
            MutableVector<Pair<Function1<DerivedState<?>, Unit>, Function1<DerivedState<?>, Unit>>> mutableVector2 = new MutableVector<>(new Pair[16], 0);
            snapshotThreadLocal.set(mutableVector2);
            mutableVector = mutableVector2;
        }
        try {
            mutableVector.add(TuplesKt.to(function1, function12));
            function0.invoke();
        } finally {
            mutableVector.removeAt(mutableVector.getSize() - 1);
        }
    }

    @NotNull
    public static final <T> State<T> derivedStateOf(@NotNull SnapshotMutationPolicy<T> snapshotMutationPolicy, @NotNull Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(snapshotMutationPolicy, "policy");
        Intrinsics.checkNotNullParameter(function0, "calculation");
        return new DerivedSnapshotState(function0, snapshotMutationPolicy);
    }
}
