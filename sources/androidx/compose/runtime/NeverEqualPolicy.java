package androidx.compose.runtime;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.j25;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class NeverEqualPolicy implements SnapshotMutationPolicy<Object> {

    @NotNull
    public static final NeverEqualPolicy INSTANCE = new NeverEqualPolicy();

    private NeverEqualPolicy() {
    }

    public boolean equivalent(@Nullable Object obj, @Nullable Object obj2) {
        return false;
    }

    public /* synthetic */ Object merge(Object obj, Object obj2, Object obj3) {
        return j25.a(this, obj, obj2, obj3);
    }

    @NotNull
    public String toString() {
        return "NeverEqualPolicy";
    }
}
