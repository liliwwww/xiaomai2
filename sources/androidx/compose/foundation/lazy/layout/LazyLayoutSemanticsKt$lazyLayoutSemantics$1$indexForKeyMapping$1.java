package androidx.compose.foundation.lazy.layout;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class LazyLayoutSemanticsKt$lazyLayoutSemantics$1$indexForKeyMapping$1 extends Lambda implements Function1<Object, Integer> {
    final /* synthetic */ LazyLayoutItemProvider $itemProvider;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LazyLayoutSemanticsKt$lazyLayoutSemantics$1$indexForKeyMapping$1(LazyLayoutItemProvider lazyLayoutItemProvider) {
        super(1);
        this.$itemProvider = lazyLayoutItemProvider;
    }

    @NotNull
    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final Integer m493invoke(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "needle");
        int itemCount = this.$itemProvider.getItemCount();
        int i = 0;
        while (true) {
            if (i >= itemCount) {
                i = -1;
                break;
            }
            if (Intrinsics.areEqual(this.$itemProvider.getKey(i), obj)) {
                break;
            }
            i++;
        }
        return Integer.valueOf(i);
    }
}
