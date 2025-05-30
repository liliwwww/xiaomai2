package androidx.compose.foundation;

import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class AndroidOverscrollKt$StretchOverscrollNonClippingLayer$2 extends Lambda implements Function3<MeasureScope, Measurable, Constraints, MeasureResult> {
    public static final AndroidOverscrollKt$StretchOverscrollNonClippingLayer$2 INSTANCE = new AndroidOverscrollKt$StretchOverscrollNonClippingLayer$2();

    AndroidOverscrollKt$StretchOverscrollNonClippingLayer$2() {
        super(3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return m114invoke3p2s80s((MeasureScope) obj, (Measurable) obj2, ((Constraints) obj3).m2128unboximpl());
    }

    @NotNull
    /* renamed from: invoke-3p2s80s, reason: not valid java name */
    public final MeasureResult m114invoke3p2s80s(@NotNull MeasureScope measureScope, @NotNull Measurable measurable, long j) {
        Intrinsics.checkNotNullParameter(measureScope, "$this$layout");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        final Placeable mo1521measureBRTryo0 = measurable.mo1521measureBRTryo0(j);
        final int mo319roundToPx0680j_4 = measureScope.mo319roundToPx0680j_4(Dp.m2142constructorimpl(ClipScrollableContainerKt.getMaxSupportedElevation() * 2));
        return MeasureScope.-CC.p(measureScope, mo1521measureBRTryo0.getWidth() + mo319roundToPx0680j_4, mo1521measureBRTryo0.getHeight() + mo319roundToPx0680j_4, (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.AndroidOverscrollKt$StretchOverscrollNonClippingLayer$2.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull Placeable.PlacementScope placementScope) {
                Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
                Placeable placeable = Placeable.this;
                int i = mo319roundToPx0680j_4;
                Placeable.PlacementScope.place$default(placementScope, placeable, i / 2, i / 2, 0.0f, 4, (Object) null);
            }
        }, 4, (Object) null);
    }
}
