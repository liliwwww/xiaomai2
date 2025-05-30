package androidx.compose.ui.layout;

import androidx.compose.ui.node.ComposeUiNode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class LayoutKt$Layout$$inlined$ReusableComposeNode$1 extends Lambda implements Function0<ComposeUiNode> {
    final /* synthetic */ Function0 $factory;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LayoutKt$Layout$$inlined$ReusableComposeNode$1(Function0 function0) {
        super(0);
        this.$factory = function0;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.compose.ui.node.ComposeUiNode, java.lang.Object] */
    @NotNull
    public final ComposeUiNode invoke() {
        return this.$factory.invoke();
    }
}
