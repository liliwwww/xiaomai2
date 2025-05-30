package androidx.compose.ui.layout;

import androidx.compose.ui.node.LookaheadDelegate;
import androidx.compose.ui.node.NodeCoordinator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class LookaheadLayoutScopeImpl$onPlaced$2$1$1 extends Lambda implements Function0<LookaheadLayoutCoordinates> {
    final /* synthetic */ LookaheadLayoutScopeImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LookaheadLayoutScopeImpl$onPlaced$2$1$1(LookaheadLayoutScopeImpl lookaheadLayoutScopeImpl) {
        super(0);
        this.this$0 = lookaheadLayoutScopeImpl;
    }

    @NotNull
    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final LookaheadLayoutCoordinates m2064invoke() {
        NodeCoordinator root = this.this$0.getRoot();
        if (root != null) {
            LookaheadDelegate lookaheadDelegate$ui_release = root.getLookaheadDelegate$ui_release();
            Intrinsics.checkNotNull(lookaheadDelegate$ui_release);
            LookaheadLayoutCoordinatesImpl lookaheadLayoutCoordinates = lookaheadDelegate$ui_release.getLookaheadLayoutCoordinates();
            if (lookaheadLayoutCoordinates != null) {
                return lookaheadLayoutCoordinates;
            }
        }
        throw new IllegalStateException("Lookahead root has not been set up yet".toString());
    }
}
