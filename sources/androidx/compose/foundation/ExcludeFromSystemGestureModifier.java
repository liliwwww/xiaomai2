package androidx.compose.foundation;

import android.view.View;
import androidx.annotation.RequiresApi;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.RectHelper_androidKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.OnGloballyPositionedModifier;
import java.util.List;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.mt2;
import tb.nt2;

/* compiled from: Taobao */
@RequiresApi(29)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class ExcludeFromSystemGestureModifier implements OnGloballyPositionedModifier {

    @Nullable
    private final Function1<LayoutCoordinates, Rect> exclusion;

    @Nullable
    private android.graphics.Rect rect;

    @NotNull
    private final View view;

    /* JADX WARN: Multi-variable type inference failed */
    public ExcludeFromSystemGestureModifier(@NotNull View view, @Nullable Function1<? super LayoutCoordinates, Rect> function1) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.view = view;
        this.exclusion = function1;
    }

    private final android.graphics.Rect calcBounds(LayoutCoordinates layoutCoordinates, Rect rect) {
        LayoutCoordinates findRoot = findRoot(layoutCoordinates);
        long mo1523localPositionOfR5De75A = findRoot.mo1523localPositionOfR5De75A(layoutCoordinates, rect.m869getTopLeftF1C5BW0());
        long mo1523localPositionOfR5De75A2 = findRoot.mo1523localPositionOfR5De75A(layoutCoordinates, rect.m870getTopRightF1C5BW0());
        long mo1523localPositionOfR5De75A3 = findRoot.mo1523localPositionOfR5De75A(layoutCoordinates, rect.m862getBottomLeftF1C5BW0());
        long mo1523localPositionOfR5De75A4 = findRoot.mo1523localPositionOfR5De75A(layoutCoordinates, rect.m863getBottomRightF1C5BW0());
        return new android.graphics.Rect(MathKt.roundToInt(ComparisonsKt.minOf(Offset.m848getXimpl(mo1523localPositionOfR5De75A), new float[]{Offset.m848getXimpl(mo1523localPositionOfR5De75A2), Offset.m848getXimpl(mo1523localPositionOfR5De75A3), Offset.m848getXimpl(mo1523localPositionOfR5De75A4)})), MathKt.roundToInt(ComparisonsKt.minOf(Offset.m849getYimpl(mo1523localPositionOfR5De75A), new float[]{Offset.m849getYimpl(mo1523localPositionOfR5De75A2), Offset.m849getYimpl(mo1523localPositionOfR5De75A3), Offset.m849getYimpl(mo1523localPositionOfR5De75A4)})), MathKt.roundToInt(ComparisonsKt.maxOf(Offset.m848getXimpl(mo1523localPositionOfR5De75A), new float[]{Offset.m848getXimpl(mo1523localPositionOfR5De75A2), Offset.m848getXimpl(mo1523localPositionOfR5De75A3), Offset.m848getXimpl(mo1523localPositionOfR5De75A4)})), MathKt.roundToInt(ComparisonsKt.maxOf(Offset.m849getYimpl(mo1523localPositionOfR5De75A), new float[]{Offset.m849getYimpl(mo1523localPositionOfR5De75A2), Offset.m849getYimpl(mo1523localPositionOfR5De75A3), Offset.m849getYimpl(mo1523localPositionOfR5De75A4)})));
    }

    private final LayoutCoordinates findRoot(LayoutCoordinates layoutCoordinates) {
        LayoutCoordinates parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
        while (true) {
            LayoutCoordinates layoutCoordinates2 = parentLayoutCoordinates;
            LayoutCoordinates layoutCoordinates3 = layoutCoordinates;
            layoutCoordinates = layoutCoordinates2;
            if (layoutCoordinates == null) {
                return layoutCoordinates3;
            }
            parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ boolean all(Function1 function1) {
        return nt2.a(this, function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ boolean any(Function1 function1) {
        return nt2.b(this, function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ Object foldIn(Object obj, Function2 function2) {
        return nt2.c(this, obj, function2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ Object foldOut(Object obj, Function2 function2) {
        return nt2.d(this, obj, function2);
    }

    @Nullable
    public final Function1<LayoutCoordinates, Rect> getExclusion() {
        return this.exclusion;
    }

    @Nullable
    public final android.graphics.Rect getRect() {
        return this.rect;
    }

    @NotNull
    public final View getView() {
        return this.view;
    }

    public void onGloballyPositioned(@NotNull LayoutCoordinates layoutCoordinates) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "coordinates");
        Function1<LayoutCoordinates, Rect> function1 = this.exclusion;
        replaceRect(function1 == null ? RectHelper_androidKt.toAndroidRect(LayoutCoordinatesKt.boundsInRoot(layoutCoordinates)) : calcBounds(layoutCoordinates, (Rect) function1.invoke(layoutCoordinates)));
    }

    public final void removeRect() {
        replaceRect(null);
    }

    public final void replaceRect(@Nullable android.graphics.Rect rect) {
        boolean z = false;
        MutableVector mutableVector = new MutableVector(new android.graphics.Rect[16], 0);
        List<android.graphics.Rect> systemGestureExclusionRects = this.view.getSystemGestureExclusionRects();
        Intrinsics.checkNotNullExpressionValue(systemGestureExclusionRects, "view.systemGestureExclusionRects");
        mutableVector.addAll(mutableVector.getSize(), systemGestureExclusionRects);
        android.graphics.Rect rect2 = this.rect;
        if (rect2 != null) {
            mutableVector.remove(rect2);
        }
        if (rect != null && !rect.isEmpty()) {
            z = true;
        }
        if (z) {
            mutableVector.add(rect);
        }
        this.view.setSystemGestureExclusionRects(mutableVector.asMutableList());
        this.rect = rect;
    }

    public final void setRect(@Nullable android.graphics.Rect rect) {
        this.rect = rect;
    }

    public /* synthetic */ Modifier then(Modifier modifier) {
        return mt2.a(this, modifier);
    }
}
