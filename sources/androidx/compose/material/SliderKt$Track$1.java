package androidx.compose.material;

import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.PointMode;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.w51;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class SliderKt$Track$1 extends Lambda implements Function1<DrawScope, Unit> {
    final /* synthetic */ State<Color> $activeTickColor;
    final /* synthetic */ State<Color> $activeTrackColor;
    final /* synthetic */ State<Color> $inactiveTickColor;
    final /* synthetic */ State<Color> $inactiveTrackColor;
    final /* synthetic */ float $positionFractionEnd;
    final /* synthetic */ float $positionFractionStart;
    final /* synthetic */ float $thumbPx;
    final /* synthetic */ List<Float> $tickFractions;
    final /* synthetic */ float $trackStrokeWidth;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SliderKt$Track$1(float f, State<Color> state, float f2, float f3, float f4, State<Color> state2, List<Float> list, State<Color> state3, State<Color> state4) {
        super(1);
        this.$thumbPx = f;
        this.$inactiveTrackColor = state;
        this.$trackStrokeWidth = f2;
        this.$positionFractionEnd = f3;
        this.$positionFractionStart = f4;
        this.$activeTrackColor = state2;
        this.$tickFractions = list;
        this.$inactiveTickColor = state3;
        this.$activeTickColor = state4;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DrawScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull DrawScope drawScope) {
        Intrinsics.checkNotNullParameter(drawScope, "$this$Canvas");
        boolean z = drawScope.getLayoutDirection() == LayoutDirection.Rtl;
        long Offset = OffsetKt.Offset(this.$thumbPx, Offset.m849getYimpl(drawScope.mo1320getCenterF1C5BW0()));
        long Offset2 = OffsetKt.Offset(Size.m903getWidthimpl(drawScope.mo1321getSizeNHjbRc()) - this.$thumbPx, Offset.m849getYimpl(drawScope.mo1320getCenterF1C5BW0()));
        long j = z ? Offset2 : Offset;
        long j2 = z ? Offset : Offset2;
        long m1060unboximpl = ((Color) this.$inactiveTrackColor.getValue()).m1060unboximpl();
        float f = this.$trackStrokeWidth;
        StrokeCap.Companion companion = StrokeCap.Companion;
        long j3 = j2;
        long j4 = j;
        w51.C(drawScope, m1060unboximpl, j, j2, f, companion.getRound-KaPHkGw(), (PathEffect) null, 0.0f, (ColorFilter) null, 0, 480, (Object) null);
        w51.C(drawScope, ((Color) this.$activeTrackColor.getValue()).m1060unboximpl(), OffsetKt.Offset(Offset.m848getXimpl(j4) + ((Offset.m848getXimpl(j3) - Offset.m848getXimpl(j4)) * this.$positionFractionStart), Offset.m849getYimpl(drawScope.mo1320getCenterF1C5BW0())), OffsetKt.Offset(Offset.m848getXimpl(j4) + ((Offset.m848getXimpl(j3) - Offset.m848getXimpl(j4)) * this.$positionFractionEnd), Offset.m849getYimpl(drawScope.mo1320getCenterF1C5BW0())), this.$trackStrokeWidth, companion.getRound-KaPHkGw(), (PathEffect) null, 0.0f, (ColorFilter) null, 0, 480, (Object) null);
        List<Float> list = this.$tickFractions;
        float f2 = this.$positionFractionEnd;
        float f3 = this.$positionFractionStart;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : list) {
            float floatValue = ((Number) obj).floatValue();
            Boolean valueOf = Boolean.valueOf(floatValue > f2 || floatValue < f3);
            Object obj2 = linkedHashMap.get(valueOf);
            if (obj2 == null) {
                obj2 = new ArrayList();
                linkedHashMap.put(valueOf, obj2);
            }
            ((List) obj2).add(obj);
        }
        State<Color> state = this.$inactiveTickColor;
        State<Color> state2 = this.$activeTickColor;
        float f4 = this.$trackStrokeWidth;
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            boolean booleanValue = ((Boolean) entry.getKey()).booleanValue();
            List list2 = (List) entry.getValue();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(Offset.m837boximpl(OffsetKt.Offset(Offset.m848getXimpl(OffsetKt.lerp-Wko1d7g(j4, j3, ((Number) it.next()).floatValue())), Offset.m849getYimpl(drawScope.mo1320getCenterF1C5BW0()))));
            }
            long j5 = j3;
            long j6 = j4;
            w51.H(drawScope, arrayList, PointMode.Companion.m1190getPointsr_lszbg(), ((Color) (booleanValue ? state : state2).getValue()).m1060unboximpl(), f4, StrokeCap.Companion.getRound-KaPHkGw(), (PathEffect) null, 0.0f, (ColorFilter) null, 0, 480, (Object) null);
            j4 = j6;
            f4 = f4;
            j3 = j5;
        }
    }
}
