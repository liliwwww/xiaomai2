package androidx.compose.material;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class TextFieldMeasurePolicy implements MeasurePolicy {
    private final float animationProgress;

    @NotNull
    private final PaddingValues paddingValues;
    private final boolean singleLine;

    public TextFieldMeasurePolicy(boolean z, float f, @NotNull PaddingValues paddingValues) {
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        this.singleLine = z;
        this.animationProgress = f;
        this.paddingValues = paddingValues;
    }

    private final int intrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> function2) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        int m696calculateHeightO3s9Psw;
        for (Object obj5 : list) {
            if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj5), TextFieldImplKt.TextFieldId)) {
                int intValue = ((Number) function2.invoke(obj5, Integer.valueOf(i))).intValue();
                Iterator<T> it = list.iterator();
                while (true) {
                    obj = null;
                    if (!it.hasNext()) {
                        obj2 = null;
                        break;
                    }
                    obj2 = it.next();
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj2), TextFieldImplKt.LabelId)) {
                        break;
                    }
                }
                IntrinsicMeasurable intrinsicMeasurable = (IntrinsicMeasurable) obj2;
                int intValue2 = intrinsicMeasurable != null ? ((Number) function2.invoke(intrinsicMeasurable, Integer.valueOf(i))).intValue() : 0;
                Iterator<T> it2 = list.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        obj3 = null;
                        break;
                    }
                    obj3 = it2.next();
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj3), TextFieldImplKt.TrailingId)) {
                        break;
                    }
                }
                IntrinsicMeasurable intrinsicMeasurable2 = (IntrinsicMeasurable) obj3;
                int intValue3 = intrinsicMeasurable2 != null ? ((Number) function2.invoke(intrinsicMeasurable2, Integer.valueOf(i))).intValue() : 0;
                Iterator<T> it3 = list.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        obj4 = null;
                        break;
                    }
                    obj4 = it3.next();
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj4), TextFieldImplKt.LeadingId)) {
                        break;
                    }
                }
                IntrinsicMeasurable intrinsicMeasurable3 = (IntrinsicMeasurable) obj4;
                int intValue4 = intrinsicMeasurable3 != null ? ((Number) function2.invoke(intrinsicMeasurable3, Integer.valueOf(i))).intValue() : 0;
                Iterator<T> it4 = list.iterator();
                while (true) {
                    if (!it4.hasNext()) {
                        break;
                    }
                    Object next = it4.next();
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) next), TextFieldImplKt.PlaceholderId)) {
                        obj = next;
                        break;
                    }
                }
                IntrinsicMeasurable intrinsicMeasurable4 = (IntrinsicMeasurable) obj;
                m696calculateHeightO3s9Psw = TextFieldKt.m696calculateHeightO3s9Psw(intValue, intValue2 > 0, intValue2, intValue4, intValue3, intrinsicMeasurable4 != null ? ((Number) function2.invoke(intrinsicMeasurable4, Integer.valueOf(i))).intValue() : 0, TextFieldImplKt.getZeroConstraints(), intrinsicMeasureScope.getDensity(), this.paddingValues);
                return m696calculateHeightO3s9Psw;
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    private final int intrinsicWidth(List<? extends IntrinsicMeasurable> list, int i, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> function2) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        int m697calculateWidthVsPV1Ek;
        for (Object obj5 : list) {
            if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj5), TextFieldImplKt.TextFieldId)) {
                int intValue = ((Number) function2.invoke(obj5, Integer.valueOf(i))).intValue();
                Iterator<T> it = list.iterator();
                while (true) {
                    obj = null;
                    if (!it.hasNext()) {
                        obj2 = null;
                        break;
                    }
                    obj2 = it.next();
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj2), TextFieldImplKt.LabelId)) {
                        break;
                    }
                }
                IntrinsicMeasurable intrinsicMeasurable = (IntrinsicMeasurable) obj2;
                int intValue2 = intrinsicMeasurable != null ? ((Number) function2.invoke(intrinsicMeasurable, Integer.valueOf(i))).intValue() : 0;
                Iterator<T> it2 = list.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        obj3 = null;
                        break;
                    }
                    obj3 = it2.next();
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj3), TextFieldImplKt.TrailingId)) {
                        break;
                    }
                }
                IntrinsicMeasurable intrinsicMeasurable2 = (IntrinsicMeasurable) obj3;
                int intValue3 = intrinsicMeasurable2 != null ? ((Number) function2.invoke(intrinsicMeasurable2, Integer.valueOf(i))).intValue() : 0;
                Iterator<T> it3 = list.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        obj4 = null;
                        break;
                    }
                    obj4 = it3.next();
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj4), TextFieldImplKt.LeadingId)) {
                        break;
                    }
                }
                IntrinsicMeasurable intrinsicMeasurable3 = (IntrinsicMeasurable) obj4;
                int intValue4 = intrinsicMeasurable3 != null ? ((Number) function2.invoke(intrinsicMeasurable3, Integer.valueOf(i))).intValue() : 0;
                Iterator<T> it4 = list.iterator();
                while (true) {
                    if (!it4.hasNext()) {
                        break;
                    }
                    Object next = it4.next();
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) next), TextFieldImplKt.PlaceholderId)) {
                        obj = next;
                        break;
                    }
                }
                IntrinsicMeasurable intrinsicMeasurable4 = (IntrinsicMeasurable) obj;
                m697calculateWidthVsPV1Ek = TextFieldKt.m697calculateWidthVsPV1Ek(intValue4, intValue3, intValue, intValue2, intrinsicMeasurable4 != null ? ((Number) function2.invoke(intrinsicMeasurable4, Integer.valueOf(i))).intValue() : 0, TextFieldImplKt.getZeroConstraints());
                return m697calculateWidthVsPV1Ek;
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int maxIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(list, "measurables");
        return intrinsicHeight(intrinsicMeasureScope, list, i, new Function2<IntrinsicMeasurable, Integer, Integer>() { // from class: androidx.compose.material.TextFieldMeasurePolicy$maxIntrinsicHeight$1
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return invoke((IntrinsicMeasurable) obj, ((Number) obj2).intValue());
            }

            @NotNull
            public final Integer invoke(@NotNull IntrinsicMeasurable intrinsicMeasurable, int i2) {
                Intrinsics.checkNotNullParameter(intrinsicMeasurable, "intrinsicMeasurable");
                return Integer.valueOf(intrinsicMeasurable.maxIntrinsicHeight(i2));
            }
        });
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int maxIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(list, "measurables");
        return intrinsicWidth(list, i, new Function2<IntrinsicMeasurable, Integer, Integer>() { // from class: androidx.compose.material.TextFieldMeasurePolicy$maxIntrinsicWidth$1
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return invoke((IntrinsicMeasurable) obj, ((Number) obj2).intValue());
            }

            @NotNull
            public final Integer invoke(@NotNull IntrinsicMeasurable intrinsicMeasurable, int i2) {
                Intrinsics.checkNotNullParameter(intrinsicMeasurable, "intrinsicMeasurable");
                return Integer.valueOf(intrinsicMeasurable.maxIntrinsicWidth(i2));
            }
        });
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    @NotNull
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo16measure3p2s80s(@NotNull final MeasureScope measureScope, @NotNull List<? extends Measurable> list, long j) {
        Object obj;
        Object obj2;
        Object obj3;
        int i;
        Object obj4;
        final int m697calculateWidthVsPV1Ek;
        final int m696calculateHeightO3s9Psw;
        Intrinsics.checkNotNullParameter(measureScope, "$this$measure");
        Intrinsics.checkNotNullParameter(list, "measurables");
        final int mo319roundToPx0680j_4 = measureScope.mo319roundToPx0680j_4(this.paddingValues.mo219calculateTopPaddingD9Ej5fM());
        int mo319roundToPx0680j_42 = measureScope.mo319roundToPx0680j_4(this.paddingValues.mo216calculateBottomPaddingD9Ej5fM());
        final int mo319roundToPx0680j_43 = measureScope.mo319roundToPx0680j_4(TextFieldKt.getTextFieldTopPadding());
        long m2113copyZbe2FdA$default = Constraints.m2113copyZbe2FdA$default(j, 0, 0, 0, 0, 10, null);
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) obj), TextFieldImplKt.LeadingId)) {
                break;
            }
        }
        Measurable measurable = (Measurable) obj;
        final Placeable mo1521measureBRTryo0 = measurable != null ? measurable.mo1521measureBRTryo0(m2113copyZbe2FdA$default) : null;
        int widthOrZero = TextFieldImplKt.widthOrZero(mo1521measureBRTryo0) + 0;
        Iterator<T> it2 = list.iterator();
        while (true) {
            if (!it2.hasNext()) {
                obj2 = null;
                break;
            }
            obj2 = it2.next();
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) obj2), TextFieldImplKt.TrailingId)) {
                break;
            }
        }
        Measurable measurable2 = (Measurable) obj2;
        Placeable mo1521measureBRTryo02 = measurable2 != null ? measurable2.mo1521measureBRTryo0(ConstraintsKt.m2139offsetNN6EwU$default(m2113copyZbe2FdA$default, -widthOrZero, 0, 2, null)) : null;
        int i2 = -mo319roundToPx0680j_42;
        int i3 = -(widthOrZero + TextFieldImplKt.widthOrZero(mo1521measureBRTryo02));
        long m2138offsetNN6EwU = ConstraintsKt.m2138offsetNN6EwU(m2113copyZbe2FdA$default, i3, i2);
        Iterator<T> it3 = list.iterator();
        while (true) {
            if (!it3.hasNext()) {
                obj3 = null;
                break;
            }
            obj3 = it3.next();
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) obj3), TextFieldImplKt.LabelId)) {
                break;
            }
        }
        Measurable measurable3 = (Measurable) obj3;
        Placeable mo1521measureBRTryo03 = measurable3 != null ? measurable3.mo1521measureBRTryo0(m2138offsetNN6EwU) : null;
        if (mo1521measureBRTryo03 != null) {
            i = mo1521measureBRTryo03.get(AlignmentLineKt.getLastBaseline());
            if (i == Integer.MIN_VALUE) {
                i = mo1521measureBRTryo03.getHeight();
            }
        } else {
            i = 0;
        }
        final int max = Math.max(i, mo319roundToPx0680j_4);
        long m2138offsetNN6EwU2 = ConstraintsKt.m2138offsetNN6EwU(Constraints.m2113copyZbe2FdA$default(j, 0, 0, 0, 0, 11, null), i3, mo1521measureBRTryo03 != null ? (i2 - mo319roundToPx0680j_43) - max : (-mo319roundToPx0680j_4) - mo319roundToPx0680j_42);
        for (Measurable measurable4 : list) {
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable4), TextFieldImplKt.TextFieldId)) {
                final Placeable mo1521measureBRTryo04 = measurable4.mo1521measureBRTryo0(m2138offsetNN6EwU2);
                long m2113copyZbe2FdA$default2 = Constraints.m2113copyZbe2FdA$default(m2138offsetNN6EwU2, 0, 0, 0, 0, 14, null);
                Iterator<T> it4 = list.iterator();
                while (true) {
                    if (!it4.hasNext()) {
                        obj4 = null;
                        break;
                    }
                    obj4 = it4.next();
                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) obj4), TextFieldImplKt.PlaceholderId)) {
                        break;
                    }
                }
                Measurable measurable5 = (Measurable) obj4;
                final Placeable mo1521measureBRTryo05 = measurable5 != null ? measurable5.mo1521measureBRTryo0(m2113copyZbe2FdA$default2) : null;
                m697calculateWidthVsPV1Ek = TextFieldKt.m697calculateWidthVsPV1Ek(TextFieldImplKt.widthOrZero(mo1521measureBRTryo0), TextFieldImplKt.widthOrZero(mo1521measureBRTryo02), mo1521measureBRTryo04.getWidth(), TextFieldImplKt.widthOrZero(mo1521measureBRTryo03), TextFieldImplKt.widthOrZero(mo1521measureBRTryo05), j);
                m696calculateHeightO3s9Psw = TextFieldKt.m696calculateHeightO3s9Psw(mo1521measureBRTryo04.getHeight(), mo1521measureBRTryo03 != null, max, TextFieldImplKt.heightOrZero(mo1521measureBRTryo0), TextFieldImplKt.heightOrZero(mo1521measureBRTryo02), TextFieldImplKt.heightOrZero(mo1521measureBRTryo05), j, measureScope.getDensity(), this.paddingValues);
                final Placeable placeable = mo1521measureBRTryo03;
                final int i4 = i;
                final Placeable placeable2 = mo1521measureBRTryo02;
                return MeasureScope.-CC.p(measureScope, m697calculateWidthVsPV1Ek, m696calculateHeightO3s9Psw, (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.TextFieldMeasurePolicy$measure$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj5) {
                        invoke((Placeable.PlacementScope) obj5);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@NotNull Placeable.PlacementScope placementScope) {
                        boolean z;
                        PaddingValues paddingValues;
                        boolean z2;
                        float f;
                        Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
                        if (Placeable.this == null) {
                            int i5 = m697calculateWidthVsPV1Ek;
                            int i6 = m696calculateHeightO3s9Psw;
                            Placeable placeable3 = mo1521measureBRTryo04;
                            Placeable placeable4 = mo1521measureBRTryo05;
                            Placeable placeable5 = mo1521measureBRTryo0;
                            Placeable placeable6 = placeable2;
                            z = this.singleLine;
                            float density = measureScope.getDensity();
                            paddingValues = this.paddingValues;
                            TextFieldKt.placeWithoutLabel(placementScope, i5, i6, placeable3, placeable4, placeable5, placeable6, z, density, paddingValues);
                            return;
                        }
                        int coerceAtLeast = RangesKt.coerceAtLeast(mo319roundToPx0680j_4 - i4, 0);
                        int i7 = m697calculateWidthVsPV1Ek;
                        int i8 = m696calculateHeightO3s9Psw;
                        Placeable placeable7 = mo1521measureBRTryo04;
                        Placeable placeable8 = Placeable.this;
                        Placeable placeable9 = mo1521measureBRTryo05;
                        Placeable placeable10 = mo1521measureBRTryo0;
                        Placeable placeable11 = placeable2;
                        z2 = this.singleLine;
                        int i9 = mo319roundToPx0680j_43 + max;
                        f = this.animationProgress;
                        TextFieldKt.placeWithLabel(placementScope, i7, i8, placeable7, placeable8, placeable9, placeable10, placeable11, z2, coerceAtLeast, i9, f, measureScope.getDensity());
                    }
                }, 4, (Object) null);
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int minIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(list, "measurables");
        return intrinsicHeight(intrinsicMeasureScope, list, i, minIntrinsicHeight.1.INSTANCE);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int minIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(list, "measurables");
        return intrinsicWidth(list, i, minIntrinsicWidth.1.INSTANCE);
    }
}
