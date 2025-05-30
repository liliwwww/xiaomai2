package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.State;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class LazyLayoutKt$LazyLayout$1$itemContentFactory$1$1 extends Lambda implements Function0<LazyLayoutItemProvider> {
    final /* synthetic */ State<LazyLayoutItemProvider> $currentItemProvider;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LazyLayoutKt$LazyLayout$1$itemContentFactory$1$1(State<? extends LazyLayoutItemProvider> state) {
        super(0);
        this.$currentItemProvider = state;
    }

    @NotNull
    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final LazyLayoutItemProvider m489invoke() {
        return this.$currentItemProvider.getValue();
    }
}
