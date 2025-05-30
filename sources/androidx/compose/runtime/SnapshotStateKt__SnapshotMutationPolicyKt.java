package androidx.compose.runtime;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final /* synthetic */ class SnapshotStateKt__SnapshotMutationPolicyKt {
    @NotNull
    public static final <T> SnapshotMutationPolicy<T> neverEqualPolicy() {
        NeverEqualPolicy neverEqualPolicy = NeverEqualPolicy.INSTANCE;
        Intrinsics.checkNotNull(neverEqualPolicy, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutationPolicy<T of androidx.compose.runtime.SnapshotStateKt__SnapshotMutationPolicyKt.neverEqualPolicy>");
        return neverEqualPolicy;
    }

    @NotNull
    public static final <T> SnapshotMutationPolicy<T> referentialEqualityPolicy() {
        ReferentialEqualityPolicy referentialEqualityPolicy = ReferentialEqualityPolicy.INSTANCE;
        Intrinsics.checkNotNull(referentialEqualityPolicy, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutationPolicy<T of androidx.compose.runtime.SnapshotStateKt__SnapshotMutationPolicyKt.referentialEqualityPolicy>");
        return referentialEqualityPolicy;
    }

    @NotNull
    public static final <T> SnapshotMutationPolicy<T> structuralEqualityPolicy() {
        StructuralEqualityPolicy structuralEqualityPolicy = StructuralEqualityPolicy.INSTANCE;
        Intrinsics.checkNotNull(structuralEqualityPolicy, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutationPolicy<T of androidx.compose.runtime.SnapshotStateKt__SnapshotMutationPolicyKt.structuralEqualityPolicy>");
        return structuralEqualityPolicy;
    }
}
