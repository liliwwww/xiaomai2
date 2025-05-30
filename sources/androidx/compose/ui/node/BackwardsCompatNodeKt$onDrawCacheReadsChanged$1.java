package androidx.compose.ui.node;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class BackwardsCompatNodeKt$onDrawCacheReadsChanged$1 extends Lambda implements Function1<BackwardsCompatNode, Unit> {
    public static final BackwardsCompatNodeKt$onDrawCacheReadsChanged$1 INSTANCE = new BackwardsCompatNodeKt$onDrawCacheReadsChanged$1();

    BackwardsCompatNodeKt$onDrawCacheReadsChanged$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((BackwardsCompatNode) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull BackwardsCompatNode backwardsCompatNode) {
        Intrinsics.checkNotNullParameter(backwardsCompatNode, "it");
        backwardsCompatNode.onDrawCacheReadsChanged$ui_release();
    }
}
