package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.PaddingKt$absolutePadding-qDBjuR0$;
import androidx.compose.foundation.layout.PaddingKt$padding-qDBjuR0$;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class PaddingKt {
    @Stable
    @NotNull
    /* renamed from: PaddingValues-0680j_4, reason: not valid java name */
    public static final PaddingValues m325PaddingValues0680j_4(float f) {
        return new PaddingValuesImpl(f, f, f, f, (DefaultConstructorMarker) null);
    }

    @Stable
    @NotNull
    /* renamed from: PaddingValues-YgX7TsA, reason: not valid java name */
    public static final PaddingValues m326PaddingValuesYgX7TsA(float f, float f2) {
        return new PaddingValuesImpl(f, f2, f, f2, (DefaultConstructorMarker) null);
    }

    /* renamed from: PaddingValues-YgX7TsA$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m327PaddingValuesYgX7TsA$default(float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.constructor-impl(0);
        }
        if ((i & 2) != 0) {
            f2 = Dp.constructor-impl(0);
        }
        return m326PaddingValuesYgX7TsA(f, f2);
    }

    @Stable
    @NotNull
    /* renamed from: PaddingValues-a9UjIt4, reason: not valid java name */
    public static final PaddingValues m328PaddingValuesa9UjIt4(float f, float f2, float f3, float f4) {
        return new PaddingValuesImpl(f, f2, f3, f4, (DefaultConstructorMarker) null);
    }

    /* renamed from: PaddingValues-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m329PaddingValuesa9UjIt4$default(float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.constructor-impl(0);
        }
        if ((i & 2) != 0) {
            f2 = Dp.constructor-impl(0);
        }
        if ((i & 4) != 0) {
            f3 = Dp.constructor-impl(0);
        }
        if ((i & 8) != 0) {
            f4 = Dp.constructor-impl(0);
        }
        return m328PaddingValuesa9UjIt4(f, f2, f3, f4);
    }

    @Stable
    @NotNull
    /* renamed from: absolutePadding-qDBjuR0, reason: not valid java name */
    public static final Modifier m330absolutePaddingqDBjuR0(@NotNull Modifier modifier, float f, float f2, float f3, float f4) {
        Intrinsics.checkNotNullParameter(modifier, "$this$absolutePadding");
        return modifier.then(new PaddingModifier(f, f2, f3, f4, false, InspectableValueKt.isDebugInspectorInfoEnabled() ? new PaddingKt$absolutePadding-qDBjuR0$.inlined.debugInspectorInfo.1(f, f2, f3, f4) : InspectableValueKt.getNoInspectorInfo(), null));
    }

    /* renamed from: absolutePadding-qDBjuR0$default, reason: not valid java name */
    public static /* synthetic */ Modifier m331absolutePaddingqDBjuR0$default(Modifier modifier, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.constructor-impl(0);
        }
        if ((i & 2) != 0) {
            f2 = Dp.constructor-impl(0);
        }
        if ((i & 4) != 0) {
            f3 = Dp.constructor-impl(0);
        }
        if ((i & 8) != 0) {
            f4 = Dp.constructor-impl(0);
        }
        return m330absolutePaddingqDBjuR0(modifier, f, f2, f3, f4);
    }

    @Stable
    public static final float calculateEndPadding(@NotNull PaddingValues paddingValues, @NotNull LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(paddingValues, "<this>");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        return layoutDirection == LayoutDirection.Ltr ? paddingValues.calculateRightPadding-u2uoSUM(layoutDirection) : paddingValues.calculateLeftPadding-u2uoSUM(layoutDirection);
    }

    @Stable
    public static final float calculateStartPadding(@NotNull PaddingValues paddingValues, @NotNull LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(paddingValues, "<this>");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        return layoutDirection == LayoutDirection.Ltr ? paddingValues.calculateLeftPadding-u2uoSUM(layoutDirection) : paddingValues.calculateRightPadding-u2uoSUM(layoutDirection);
    }

    @Stable
    @NotNull
    public static final Modifier padding(@NotNull Modifier modifier, @NotNull final PaddingValues paddingValues) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        return modifier.then(new PaddingValuesModifier(paddingValues, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.PaddingKt$padding$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((InspectorInfo) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull InspectorInfo inspectorInfo) {
                Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
                inspectorInfo.setName("padding");
                inspectorInfo.getProperties().set("paddingValues", paddingValues);
            }
        } : InspectableValueKt.getNoInspectorInfo()));
    }

    @Stable
    @NotNull
    /* renamed from: padding-3ABfNKs, reason: not valid java name */
    public static final Modifier m332padding3ABfNKs(@NotNull Modifier modifier, final float f) {
        Intrinsics.checkNotNullParameter(modifier, "$this$padding");
        return modifier.then(new PaddingModifier(f, f, f, f, true, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.PaddingKt$padding-3ABfNKs$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((InspectorInfo) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull InspectorInfo inspectorInfo) {
                Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
                inspectorInfo.setName("padding");
                inspectorInfo.setValue(Dp.box-impl(f));
            }
        } : InspectableValueKt.getNoInspectorInfo(), null));
    }

    @Stable
    @NotNull
    /* renamed from: padding-VpY3zN4, reason: not valid java name */
    public static final Modifier m333paddingVpY3zN4(@NotNull Modifier modifier, final float f, final float f2) {
        Intrinsics.checkNotNullParameter(modifier, "$this$padding");
        return modifier.then(new PaddingModifier(f, f2, f, f2, true, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.PaddingKt$padding-VpY3zN4$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((InspectorInfo) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull InspectorInfo inspectorInfo) {
                Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
                inspectorInfo.setName("padding");
                inspectorInfo.getProperties().set("horizontal", Dp.box-impl(f));
                inspectorInfo.getProperties().set("vertical", Dp.box-impl(f2));
            }
        } : InspectableValueKt.getNoInspectorInfo(), null));
    }

    /* renamed from: padding-VpY3zN4$default, reason: not valid java name */
    public static /* synthetic */ Modifier m334paddingVpY3zN4$default(Modifier modifier, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.constructor-impl(0);
        }
        if ((i & 2) != 0) {
            f2 = Dp.constructor-impl(0);
        }
        return m333paddingVpY3zN4(modifier, f, f2);
    }

    @Stable
    @NotNull
    /* renamed from: padding-qDBjuR0, reason: not valid java name */
    public static final Modifier m335paddingqDBjuR0(@NotNull Modifier modifier, float f, float f2, float f3, float f4) {
        Intrinsics.checkNotNullParameter(modifier, "$this$padding");
        return modifier.then(new PaddingModifier(f, f2, f3, f4, true, InspectableValueKt.isDebugInspectorInfoEnabled() ? new PaddingKt$padding-qDBjuR0$.inlined.debugInspectorInfo.1(f, f2, f3, f4) : InspectableValueKt.getNoInspectorInfo(), null));
    }

    /* renamed from: padding-qDBjuR0$default, reason: not valid java name */
    public static /* synthetic */ Modifier m336paddingqDBjuR0$default(Modifier modifier, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.constructor-impl(0);
        }
        if ((i & 2) != 0) {
            f2 = Dp.constructor-impl(0);
        }
        if ((i & 4) != 0) {
            f3 = Dp.constructor-impl(0);
        }
        if ((i & 8) != 0) {
            f4 = Dp.constructor-impl(0);
        }
        return m335paddingqDBjuR0(modifier, f, f2, f3, f4);
    }
}
