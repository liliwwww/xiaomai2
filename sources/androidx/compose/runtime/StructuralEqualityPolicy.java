package androidx.compose.runtime;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.j25;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class StructuralEqualityPolicy implements SnapshotMutationPolicy<Object> {

    @NotNull
    public static final StructuralEqualityPolicy INSTANCE = new StructuralEqualityPolicy();

    private StructuralEqualityPolicy() {
    }

    @Override // androidx.compose.runtime.SnapshotMutationPolicy
    public boolean equivalent(@Nullable Object obj, @Nullable Object obj2) {
        return Intrinsics.areEqual(obj, obj2);
    }

    @Override // androidx.compose.runtime.SnapshotMutationPolicy
    public /* synthetic */ Object merge(Object obj, Object obj2, Object obj3) {
        return j25.a(this, obj, obj2, obj3);
    }

    @NotNull
    public String toString() {
        return "StructuralEqualityPolicy";
    }
}
