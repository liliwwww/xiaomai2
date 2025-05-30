package androidx.compose.foundation;

import android.view.View;
import androidx.annotation.RequiresApi;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.geometry.Offset;
import androidx.compose.p004ui.geometry.Rect;
import androidx.compose.p004ui.graphics.RectHelper_androidKt;
import androidx.compose.p004ui.layout.LayoutCoordinates;
import androidx.compose.p004ui.layout.LayoutCoordinatesKt;
import androidx.compose.p004ui.layout.OnGloballyPositionedModifier;
import androidx.compose.runtime.collection.MutableVector;
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
/* loaded from: classes.dex */
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
        long mo4192localPositionOfR5De75A = findRoot.mo4192localPositionOfR5De75A(layoutCoordinates, rect.m2591getTopLeftF1C5BW0());
        long mo4192localPositionOfR5De75A2 = findRoot.mo4192localPositionOfR5De75A(layoutCoordinates, rect.m2592getTopRightF1C5BW0());
        long mo4192localPositionOfR5De75A3 = findRoot.mo4192localPositionOfR5De75A(layoutCoordinates, rect.m2584getBottomLeftF1C5BW0());
        long mo4192localPositionOfR5De75A4 = findRoot.mo4192localPositionOfR5De75A(layoutCoordinates, rect.m2585getBottomRightF1C5BW0());
        return new android.graphics.Rect(MathKt.roundToInt(ComparisonsKt.minOf(Offset.m2556getXimpl(mo4192localPositionOfR5De75A), new float[]{Offset.m2556getXimpl(mo4192localPositionOfR5De75A2), Offset.m2556getXimpl(mo4192localPositionOfR5De75A3), Offset.m2556getXimpl(mo4192localPositionOfR5De75A4)})), MathKt.roundToInt(ComparisonsKt.minOf(Offset.m2557getYimpl(mo4192localPositionOfR5De75A), new float[]{Offset.m2557getYimpl(mo4192localPositionOfR5De75A2), Offset.m2557getYimpl(mo4192localPositionOfR5De75A3), Offset.m2557getYimpl(mo4192localPositionOfR5De75A4)})), MathKt.roundToInt(ComparisonsKt.maxOf(Offset.m2556getXimpl(mo4192localPositionOfR5De75A), new float[]{Offset.m2556getXimpl(mo4192localPositionOfR5De75A2), Offset.m2556getXimpl(mo4192localPositionOfR5De75A3), Offset.m2556getXimpl(mo4192localPositionOfR5De75A4)})), MathKt.roundToInt(ComparisonsKt.maxOf(Offset.m2557getYimpl(mo4192localPositionOfR5De75A), new float[]{Offset.m2557getYimpl(mo4192localPositionOfR5De75A2), Offset.m2557getYimpl(mo4192localPositionOfR5De75A3), Offset.m2557getYimpl(mo4192localPositionOfR5De75A4)})));
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

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.p004ui.Modifier
    public /* synthetic */ boolean all(Function1 function1) {
        return nt2.a(this, function1);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.p004ui.Modifier
    public /* synthetic */ boolean any(Function1 function1) {
        return nt2.b(this, function1);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.p004ui.Modifier
    public /* synthetic */ Object foldIn(Object obj, Function2 function2) {
        return nt2.c(this, obj, function2);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.p004ui.Modifier
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

    @Override // androidx.compose.p004ui.layout.OnGloballyPositionedModifier
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
        mutableVector.addAll(mutableVector.getSize(), (List) systemGestureExclusionRects);
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

    @Override // androidx.compose.p004ui.Modifier
    public /* synthetic */ Modifier then(Modifier modifier) {
        return mt2.a(this, modifier);
    }
}
