package androidx.compose.p004ui.layout;

import androidx.compose.p004ui.node.LookaheadDelegate;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class LookaheadLayoutCoordinatesKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final LookaheadDelegate getRootLookaheadDelegate(LookaheadDelegate lookaheadDelegate) {
        LookaheadDelegate lookaheadDelegate$ui_release = lookaheadDelegate.getLookaheadScope().getRoot().getOuterCoordinator$ui_release().getLookaheadDelegate$ui_release();
        Intrinsics.checkNotNull(lookaheadDelegate$ui_release);
        return lookaheadDelegate$ui_release;
    }
}
