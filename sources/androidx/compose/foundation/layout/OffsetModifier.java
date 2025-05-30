package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.a;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.InspectorValueInfo;
import androidx.compose.ui.unit.Dp;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.l3;
import tb.mt2;
import tb.nt2;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class OffsetModifier extends InspectorValueInfo implements LayoutModifier {
    private final boolean rtlAware;
    private final float x;
    private final float y;

    private OffsetModifier(float f, float f2, boolean z, Function1<? super InspectorInfo, Unit> function1) {
        super(function1);
        this.x = f;
        this.y = f2;
        this.rtlAware = z;
    }

    public /* synthetic */ OffsetModifier(float f, float f2, boolean z, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, z, function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ boolean all(Function1 function1) {
        return nt2.a(this, function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ boolean any(Function1 function1) {
        return nt2.b(this, function1);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        OffsetModifier offsetModifier = obj instanceof OffsetModifier ? (OffsetModifier) obj : null;
        return offsetModifier != null && Dp.m2147equalsimpl0(this.x, offsetModifier.x) && Dp.m2147equalsimpl0(this.y, offsetModifier.y) && this.rtlAware == offsetModifier.rtlAware;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ Object foldIn(Object obj, Function2 function2) {
        return nt2.c(this, obj, function2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ Object foldOut(Object obj, Function2 function2) {
        return nt2.d(this, obj, function2);
    }

    public final boolean getRtlAware() {
        return this.rtlAware;
    }

    /* renamed from: getX-D9Ej5fM, reason: not valid java name */
    public final float m212getXD9Ej5fM() {
        return this.x;
    }

    /* renamed from: getY-D9Ej5fM, reason: not valid java name */
    public final float m213getYD9Ej5fM() {
        return this.y;
    }

    public int hashCode() {
        return (((Dp.m2148hashCodeimpl(this.x) * 31) + Dp.m2148hashCodeimpl(this.y)) * 31) + l3.a(this.rtlAware);
    }

    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return a.a(this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return a.b(this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    @NotNull
    /* renamed from: measure-3p2s80s, reason: not valid java name */
    public MeasureResult m214measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull Measurable measurable, long j) {
        Intrinsics.checkNotNullParameter(measureScope, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        Placeable mo1521measureBRTryo0 = measurable.mo1521measureBRTryo0(j);
        return MeasureScope.-CC.p(measureScope, mo1521measureBRTryo0.getWidth(), mo1521measureBRTryo0.getHeight(), (Map) null, new measure.1(this, mo1521measureBRTryo0, measureScope), 4, (Object) null);
    }

    public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return a.c(this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return a.d(this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    public /* synthetic */ Modifier then(Modifier modifier) {
        return mt2.a(this, modifier);
    }

    @NotNull
    public String toString() {
        return "OffsetModifier(x=" + ((Object) Dp.m2153toStringimpl(this.x)) + ", y=" + ((Object) Dp.m2153toStringimpl(this.y)) + ", rtlAware=" + this.rtlAware + ')';
    }
}
