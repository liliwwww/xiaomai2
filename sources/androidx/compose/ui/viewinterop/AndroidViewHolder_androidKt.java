package androidx.compose.ui.viewinterop;

import android.view.View;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.node.LayoutNode;
import kotlin.math.MathKt;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class AndroidViewHolder_androidKt {
    private static final int Unmeasured = Integer.MIN_VALUE;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void layoutAccordingTo(View view, LayoutNode layoutNode) {
        long positionInRoot = LayoutCoordinatesKt.positionInRoot(layoutNode.getCoordinates());
        int roundToInt = MathKt.roundToInt(Offset.getX-impl(positionInRoot));
        int roundToInt2 = MathKt.roundToInt(Offset.getY-impl(positionInRoot));
        view.layout(roundToInt, roundToInt2, view.getMeasuredWidth() + roundToInt, view.getMeasuredHeight() + roundToInt2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float toComposeOffset(int i) {
        return i * (-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float toComposeVelocity(float f) {
        return f * (-1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int toNestedScrollSource(int i) {
        return i == 0 ? NestedScrollSource.Companion.getDrag-WNlRxjI() : NestedScrollSource.Companion.getFling-WNlRxjI();
    }
}
