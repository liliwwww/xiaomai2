package androidx.compose.runtime;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.j25;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class ReferentialEqualityPolicy implements SnapshotMutationPolicy<Object> {

    @NotNull
    public static final ReferentialEqualityPolicy INSTANCE = new ReferentialEqualityPolicy();

    private ReferentialEqualityPolicy() {
    }

    public boolean equivalent(@Nullable Object obj, @Nullable Object obj2) {
        return obj == obj2;
    }

    public /* synthetic */ Object merge(Object obj, Object obj2, Object obj3) {
        return j25.a(this, obj, obj2, obj3);
    }

    @NotNull
    public String toString() {
        return "ReferentialEqualityPolicy";
    }
}
