package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier$Element;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class NodeChainKt$fillVector$1 extends Lambda implements Function1<Modifier$Element, Boolean> {
    final /* synthetic */ MutableVector<Modifier$Element> $result;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NodeChainKt$fillVector$1(MutableVector<Modifier$Element> mutableVector) {
        super(1);
        this.$result = mutableVector;
    }

    @NotNull
    public final Boolean invoke(@NotNull Modifier$Element modifier$Element) {
        Intrinsics.checkNotNullParameter(modifier$Element, "it");
        this.$result.add(modifier$Element);
        return Boolean.TRUE;
    }
}
