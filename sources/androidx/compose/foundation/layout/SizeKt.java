package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.SizeKt$defaultMinSize-VpY3zN4$;
import androidx.compose.foundation.layout.SizeKt$requiredHeight-3ABfNKs$;
import androidx.compose.foundation.layout.SizeKt$requiredHeightIn-VpY3zN4$;
import androidx.compose.foundation.layout.SizeKt$requiredSize-3ABfNKs$;
import androidx.compose.foundation.layout.SizeKt$requiredSize-VpY3zN4$;
import androidx.compose.foundation.layout.SizeKt$requiredSizeIn-qDBjuR0$;
import androidx.compose.foundation.layout.SizeKt$requiredWidth-3ABfNKs$;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class SizeKt {

    @NotNull
    private static final WrapContentModifier WrapContentHeightCenter;

    @NotNull
    private static final WrapContentModifier WrapContentHeightTop;

    @NotNull
    private static final WrapContentModifier WrapContentSizeCenter;

    @NotNull
    private static final WrapContentModifier WrapContentSizeTopStart;

    @NotNull
    private static final WrapContentModifier WrapContentWidthCenter;

    @NotNull
    private static final WrapContentModifier WrapContentWidthStart;

    @NotNull
    private static final FillModifier FillWholeMaxWidth = createFillWidthModifier(1.0f);

    @NotNull
    private static final FillModifier FillWholeMaxHeight = createFillHeightModifier(1.0f);

    @NotNull
    private static final FillModifier FillWholeMaxSize = createFillSizeModifier(1.0f);

    static {
        Alignment.Companion companion = Alignment.Companion;
        WrapContentWidthCenter = createWrapContentWidthModifier(companion.getCenterHorizontally(), false);
        WrapContentWidthStart = createWrapContentWidthModifier(companion.getStart(), false);
        WrapContentHeightCenter = createWrapContentHeightModifier(companion.getCenterVertically(), false);
        WrapContentHeightTop = createWrapContentHeightModifier(companion.getTop(), false);
        WrapContentSizeCenter = createWrapContentSizeModifier(companion.getCenter(), false);
        WrapContentSizeTopStart = createWrapContentSizeModifier(companion.getTopStart(), false);
    }

    private static final FillModifier createFillHeightModifier(final float f) {
        return new FillModifier(Direction.Vertical, f, new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.SizeKt$createFillHeightModifier$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((InspectorInfo) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull InspectorInfo inspectorInfo) {
                Intrinsics.checkNotNullParameter(inspectorInfo, "$this$$receiver");
                inspectorInfo.setName("fillMaxHeight");
                inspectorInfo.getProperties().set("fraction", Float.valueOf(f));
            }
        });
    }

    private static final FillModifier createFillSizeModifier(float f) {
        return new FillModifier(Direction.Both, f, new createFillSizeModifier.1(f));
    }

    private static final FillModifier createFillWidthModifier(final float f) {
        return new FillModifier(Direction.Horizontal, f, new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.SizeKt$createFillWidthModifier$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((InspectorInfo) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull InspectorInfo inspectorInfo) {
                Intrinsics.checkNotNullParameter(inspectorInfo, "$this$$receiver");
                inspectorInfo.setName("fillMaxWidth");
                inspectorInfo.getProperties().set("fraction", Float.valueOf(f));
            }
        });
    }

    private static final WrapContentModifier createWrapContentHeightModifier(Alignment.Vertical vertical, boolean z) {
        return new WrapContentModifier(Direction.Vertical, z, new createWrapContentHeightModifier.1(vertical), vertical, new createWrapContentHeightModifier.2(vertical, z));
    }

    private static final WrapContentModifier createWrapContentSizeModifier(final Alignment alignment, final boolean z) {
        return new WrapContentModifier(Direction.Both, z, new Function2<IntSize, LayoutDirection, IntOffset>() { // from class: androidx.compose.foundation.layout.SizeKt$createWrapContentSizeModifier$1
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return IntOffset.m2634boximpl(m382invoke5SAbXVA(((IntSize) obj).m2689unboximpl(), (LayoutDirection) obj2));
            }

            /* renamed from: invoke-5SAbXVA, reason: not valid java name */
            public final long m382invoke5SAbXVA(long j, @NotNull LayoutDirection layoutDirection) {
                Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
                return Alignment.this.mo935alignKFBX0sM(IntSize.Companion.m2690getZeroYbymL2g(), j, layoutDirection);
            }
        }, alignment, new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.SizeKt$createWrapContentSizeModifier$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((InspectorInfo) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull InspectorInfo inspectorInfo) {
                Intrinsics.checkNotNullParameter(inspectorInfo, "$this$$receiver");
                inspectorInfo.setName("wrapContentSize");
                inspectorInfo.getProperties().set("align", Alignment.this);
                inspectorInfo.getProperties().set("unbounded", Boolean.valueOf(z));
            }
        });
    }

    private static final WrapContentModifier createWrapContentWidthModifier(final Alignment.Horizontal horizontal, final boolean z) {
        return new WrapContentModifier(Direction.Horizontal, z, new Function2<IntSize, LayoutDirection, IntOffset>() { // from class: androidx.compose.foundation.layout.SizeKt$createWrapContentWidthModifier$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return IntOffset.m2634boximpl(m383invoke5SAbXVA(((IntSize) obj).m2689unboximpl(), (LayoutDirection) obj2));
            }

            /* renamed from: invoke-5SAbXVA, reason: not valid java name */
            public final long m383invoke5SAbXVA(long j, @NotNull LayoutDirection layoutDirection) {
                Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
                return IntOffsetKt.IntOffset(horizontal.align(0, IntSize.m2685getWidthimpl(j), layoutDirection), 0);
            }
        }, horizontal, new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.SizeKt$createWrapContentWidthModifier$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((InspectorInfo) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull InspectorInfo inspectorInfo) {
                Intrinsics.checkNotNullParameter(inspectorInfo, "$this$$receiver");
                inspectorInfo.setName("wrapContentWidth");
                inspectorInfo.getProperties().set("align", horizontal);
                inspectorInfo.getProperties().set("unbounded", Boolean.valueOf(z));
            }
        });
    }

    @Stable
    @NotNull
    /* renamed from: defaultMinSize-VpY3zN4, reason: not valid java name */
    public static final Modifier m358defaultMinSizeVpY3zN4(@NotNull Modifier modifier, float f, float f2) {
        Intrinsics.checkNotNullParameter(modifier, "$this$defaultMinSize");
        return modifier.then(new UnspecifiedConstraintsModifier(f, f2, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SizeKt$defaultMinSize-VpY3zN4$.inlined.debugInspectorInfo.1(f, f2) : InspectableValueKt.getNoInspectorInfo(), null));
    }

    /* renamed from: defaultMinSize-VpY3zN4$default, reason: not valid java name */
    public static /* synthetic */ Modifier m359defaultMinSizeVpY3zN4$default(Modifier modifier, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.Companion.getUnspecified-D9Ej5fM();
        }
        if ((i & 2) != 0) {
            f2 = Dp.Companion.getUnspecified-D9Ej5fM();
        }
        return m358defaultMinSizeVpY3zN4(modifier, f, f2);
    }

    @Stable
    @NotNull
    public static final Modifier fillMaxHeight(@NotNull Modifier modifier, float f) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        return modifier.then((f > 1.0f ? 1 : (f == 1.0f ? 0 : -1)) == 0 ? FillWholeMaxHeight : createFillHeightModifier(f));
    }

    public static /* synthetic */ Modifier fillMaxHeight$default(Modifier modifier, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 1.0f;
        }
        return fillMaxHeight(modifier, f);
    }

    @Stable
    @NotNull
    public static final Modifier fillMaxSize(@NotNull Modifier modifier, float f) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        return modifier.then((f > 1.0f ? 1 : (f == 1.0f ? 0 : -1)) == 0 ? FillWholeMaxSize : createFillSizeModifier(f));
    }

    public static /* synthetic */ Modifier fillMaxSize$default(Modifier modifier, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 1.0f;
        }
        return fillMaxSize(modifier, f);
    }

    @Stable
    @NotNull
    public static final Modifier fillMaxWidth(@NotNull Modifier modifier, float f) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        return modifier.then((f > 1.0f ? 1 : (f == 1.0f ? 0 : -1)) == 0 ? FillWholeMaxWidth : createFillWidthModifier(f));
    }

    public static /* synthetic */ Modifier fillMaxWidth$default(Modifier modifier, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 1.0f;
        }
        return fillMaxWidth(modifier, f);
    }

    @Stable
    @NotNull
    /* renamed from: height-3ABfNKs, reason: not valid java name */
    public static final Modifier m360height3ABfNKs(@NotNull Modifier modifier, final float f) {
        Intrinsics.checkNotNullParameter(modifier, "$this$height");
        return modifier.then(new SizeModifier(0.0f, f, 0.0f, f, true, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.SizeKt$height-3ABfNKs$$inlined$debugInspectorInfo$1
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
                inspectorInfo.setName("height");
                inspectorInfo.setValue(Dp.box-impl(f));
            }
        } : InspectableValueKt.getNoInspectorInfo(), 5, (DefaultConstructorMarker) null));
    }

    @Stable
    @NotNull
    /* renamed from: heightIn-VpY3zN4, reason: not valid java name */
    public static final Modifier m361heightInVpY3zN4(@NotNull Modifier modifier, final float f, final float f2) {
        Intrinsics.checkNotNullParameter(modifier, "$this$heightIn");
        return modifier.then(new SizeModifier(0.0f, f, 0.0f, f2, true, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.SizeKt$heightIn-VpY3zN4$$inlined$debugInspectorInfo$1
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
                inspectorInfo.setName("heightIn");
                inspectorInfo.getProperties().set("min", Dp.box-impl(f));
                inspectorInfo.getProperties().set("max", Dp.box-impl(f2));
            }
        } : InspectableValueKt.getNoInspectorInfo(), 5, (DefaultConstructorMarker) null));
    }

    /* renamed from: heightIn-VpY3zN4$default, reason: not valid java name */
    public static /* synthetic */ Modifier m362heightInVpY3zN4$default(Modifier modifier, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.Companion.getUnspecified-D9Ej5fM();
        }
        if ((i & 2) != 0) {
            f2 = Dp.Companion.getUnspecified-D9Ej5fM();
        }
        return m361heightInVpY3zN4(modifier, f, f2);
    }

    @Stable
    @NotNull
    /* renamed from: requiredHeight-3ABfNKs, reason: not valid java name */
    public static final Modifier m363requiredHeight3ABfNKs(@NotNull Modifier modifier, float f) {
        Intrinsics.checkNotNullParameter(modifier, "$this$requiredHeight");
        return modifier.then(new SizeModifier(0.0f, f, 0.0f, f, false, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SizeKt$requiredHeight-3ABfNKs$.inlined.debugInspectorInfo.1(f) : InspectableValueKt.getNoInspectorInfo(), 5, (DefaultConstructorMarker) null));
    }

    @Stable
    @NotNull
    /* renamed from: requiredHeightIn-VpY3zN4, reason: not valid java name */
    public static final Modifier m364requiredHeightInVpY3zN4(@NotNull Modifier modifier, float f, float f2) {
        Intrinsics.checkNotNullParameter(modifier, "$this$requiredHeightIn");
        return modifier.then(new SizeModifier(0.0f, f, 0.0f, f2, false, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SizeKt$requiredHeightIn-VpY3zN4$.inlined.debugInspectorInfo.1(f, f2) : InspectableValueKt.getNoInspectorInfo(), 5, (DefaultConstructorMarker) null));
    }

    /* renamed from: requiredHeightIn-VpY3zN4$default, reason: not valid java name */
    public static /* synthetic */ Modifier m365requiredHeightInVpY3zN4$default(Modifier modifier, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.Companion.getUnspecified-D9Ej5fM();
        }
        if ((i & 2) != 0) {
            f2 = Dp.Companion.getUnspecified-D9Ej5fM();
        }
        return m364requiredHeightInVpY3zN4(modifier, f, f2);
    }

    @Stable
    @NotNull
    /* renamed from: requiredSize-3ABfNKs, reason: not valid java name */
    public static final Modifier m366requiredSize3ABfNKs(@NotNull Modifier modifier, float f) {
        Intrinsics.checkNotNullParameter(modifier, "$this$requiredSize");
        return modifier.then(new SizeModifier(f, f, f, f, false, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SizeKt$requiredSize-3ABfNKs$.inlined.debugInspectorInfo.1(f) : InspectableValueKt.getNoInspectorInfo(), (DefaultConstructorMarker) null));
    }

    @Stable
    @NotNull
    /* renamed from: requiredSize-6HolHcs, reason: not valid java name */
    public static final Modifier m367requiredSize6HolHcs(@NotNull Modifier modifier, long j) {
        Intrinsics.checkNotNullParameter(modifier, "$this$requiredSize");
        return m368requiredSizeVpY3zN4(modifier, DpSize.getWidth-D9Ej5fM(j), DpSize.getHeight-D9Ej5fM(j));
    }

    @Stable
    @NotNull
    /* renamed from: requiredSize-VpY3zN4, reason: not valid java name */
    public static final Modifier m368requiredSizeVpY3zN4(@NotNull Modifier modifier, float f, float f2) {
        Intrinsics.checkNotNullParameter(modifier, "$this$requiredSize");
        return modifier.then(new SizeModifier(f, f2, f, f2, false, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SizeKt$requiredSize-VpY3zN4$.inlined.debugInspectorInfo.1(f, f2) : InspectableValueKt.getNoInspectorInfo(), (DefaultConstructorMarker) null));
    }

    @Stable
    @NotNull
    /* renamed from: requiredSizeIn-qDBjuR0, reason: not valid java name */
    public static final Modifier m369requiredSizeInqDBjuR0(@NotNull Modifier modifier, float f, float f2, float f3, float f4) {
        Intrinsics.checkNotNullParameter(modifier, "$this$requiredSizeIn");
        return modifier.then(new SizeModifier(f, f2, f3, f4, false, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SizeKt$requiredSizeIn-qDBjuR0$.inlined.debugInspectorInfo.1(f, f2, f3, f4) : InspectableValueKt.getNoInspectorInfo(), (DefaultConstructorMarker) null));
    }

    /* renamed from: requiredSizeIn-qDBjuR0$default, reason: not valid java name */
    public static /* synthetic */ Modifier m370requiredSizeInqDBjuR0$default(Modifier modifier, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.Companion.getUnspecified-D9Ej5fM();
        }
        if ((i & 2) != 0) {
            f2 = Dp.Companion.getUnspecified-D9Ej5fM();
        }
        if ((i & 4) != 0) {
            f3 = Dp.Companion.getUnspecified-D9Ej5fM();
        }
        if ((i & 8) != 0) {
            f4 = Dp.Companion.getUnspecified-D9Ej5fM();
        }
        return m369requiredSizeInqDBjuR0(modifier, f, f2, f3, f4);
    }

    @Stable
    @NotNull
    /* renamed from: requiredWidth-3ABfNKs, reason: not valid java name */
    public static final Modifier m371requiredWidth3ABfNKs(@NotNull Modifier modifier, float f) {
        Intrinsics.checkNotNullParameter(modifier, "$this$requiredWidth");
        return modifier.then(new SizeModifier(f, 0.0f, f, 0.0f, false, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SizeKt$requiredWidth-3ABfNKs$.inlined.debugInspectorInfo.1(f) : InspectableValueKt.getNoInspectorInfo(), 10, (DefaultConstructorMarker) null));
    }

    @Stable
    @NotNull
    /* renamed from: requiredWidthIn-VpY3zN4, reason: not valid java name */
    public static final Modifier m372requiredWidthInVpY3zN4(@NotNull Modifier modifier, final float f, final float f2) {
        Intrinsics.checkNotNullParameter(modifier, "$this$requiredWidthIn");
        return modifier.then(new SizeModifier(f, 0.0f, f2, 0.0f, false, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.SizeKt$requiredWidthIn-VpY3zN4$$inlined$debugInspectorInfo$1
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
                inspectorInfo.setName("requiredWidthIn");
                inspectorInfo.getProperties().set("min", Dp.box-impl(f));
                inspectorInfo.getProperties().set("max", Dp.box-impl(f2));
            }
        } : InspectableValueKt.getNoInspectorInfo(), 10, (DefaultConstructorMarker) null));
    }

    /* renamed from: requiredWidthIn-VpY3zN4$default, reason: not valid java name */
    public static /* synthetic */ Modifier m373requiredWidthInVpY3zN4$default(Modifier modifier, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.Companion.getUnspecified-D9Ej5fM();
        }
        if ((i & 2) != 0) {
            f2 = Dp.Companion.getUnspecified-D9Ej5fM();
        }
        return m372requiredWidthInVpY3zN4(modifier, f, f2);
    }

    @Stable
    @NotNull
    /* renamed from: size-3ABfNKs, reason: not valid java name */
    public static final Modifier m374size3ABfNKs(@NotNull Modifier modifier, final float f) {
        Intrinsics.checkNotNullParameter(modifier, "$this$size");
        return modifier.then(new SizeModifier(f, f, f, f, true, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.SizeKt$size-3ABfNKs$$inlined$debugInspectorInfo$1
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
                inspectorInfo.setName("size");
                inspectorInfo.setValue(Dp.box-impl(f));
            }
        } : InspectableValueKt.getNoInspectorInfo(), (DefaultConstructorMarker) null));
    }

    @Stable
    @NotNull
    /* renamed from: size-6HolHcs, reason: not valid java name */
    public static final Modifier m375size6HolHcs(@NotNull Modifier modifier, long j) {
        Intrinsics.checkNotNullParameter(modifier, "$this$size");
        return m376sizeVpY3zN4(modifier, DpSize.getWidth-D9Ej5fM(j), DpSize.getHeight-D9Ej5fM(j));
    }

    @Stable
    @NotNull
    /* renamed from: size-VpY3zN4, reason: not valid java name */
    public static final Modifier m376sizeVpY3zN4(@NotNull Modifier modifier, final float f, final float f2) {
        Intrinsics.checkNotNullParameter(modifier, "$this$size");
        return modifier.then(new SizeModifier(f, f2, f, f2, true, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.SizeKt$size-VpY3zN4$$inlined$debugInspectorInfo$1
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
                inspectorInfo.setName("size");
                inspectorInfo.getProperties().set("width", Dp.box-impl(f));
                inspectorInfo.getProperties().set("height", Dp.box-impl(f2));
            }
        } : InspectableValueKt.getNoInspectorInfo(), (DefaultConstructorMarker) null));
    }

    @Stable
    @NotNull
    /* renamed from: sizeIn-qDBjuR0, reason: not valid java name */
    public static final Modifier m377sizeInqDBjuR0(@NotNull Modifier modifier, final float f, final float f2, final float f3, final float f4) {
        Intrinsics.checkNotNullParameter(modifier, "$this$sizeIn");
        return modifier.then(new SizeModifier(f, f2, f3, f4, true, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.SizeKt$sizeIn-qDBjuR0$$inlined$debugInspectorInfo$1
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
                inspectorInfo.setName("sizeIn");
                inspectorInfo.getProperties().set("minWidth", Dp.box-impl(f));
                inspectorInfo.getProperties().set("minHeight", Dp.box-impl(f2));
                inspectorInfo.getProperties().set("maxWidth", Dp.box-impl(f3));
                inspectorInfo.getProperties().set("maxHeight", Dp.box-impl(f4));
            }
        } : InspectableValueKt.getNoInspectorInfo(), (DefaultConstructorMarker) null));
    }

    /* renamed from: sizeIn-qDBjuR0$default, reason: not valid java name */
    public static /* synthetic */ Modifier m378sizeInqDBjuR0$default(Modifier modifier, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.Companion.getUnspecified-D9Ej5fM();
        }
        if ((i & 2) != 0) {
            f2 = Dp.Companion.getUnspecified-D9Ej5fM();
        }
        if ((i & 4) != 0) {
            f3 = Dp.Companion.getUnspecified-D9Ej5fM();
        }
        if ((i & 8) != 0) {
            f4 = Dp.Companion.getUnspecified-D9Ej5fM();
        }
        return m377sizeInqDBjuR0(modifier, f, f2, f3, f4);
    }

    @Stable
    @NotNull
    /* renamed from: width-3ABfNKs, reason: not valid java name */
    public static final Modifier m379width3ABfNKs(@NotNull Modifier modifier, final float f) {
        Intrinsics.checkNotNullParameter(modifier, "$this$width");
        return modifier.then(new SizeModifier(f, 0.0f, f, 0.0f, true, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.SizeKt$width-3ABfNKs$$inlined$debugInspectorInfo$1
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
                inspectorInfo.setName("width");
                inspectorInfo.setValue(Dp.box-impl(f));
            }
        } : InspectableValueKt.getNoInspectorInfo(), 10, (DefaultConstructorMarker) null));
    }

    @Stable
    @NotNull
    /* renamed from: widthIn-VpY3zN4, reason: not valid java name */
    public static final Modifier m380widthInVpY3zN4(@NotNull Modifier modifier, final float f, final float f2) {
        Intrinsics.checkNotNullParameter(modifier, "$this$widthIn");
        return modifier.then(new SizeModifier(f, 0.0f, f2, 0.0f, true, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.SizeKt$widthIn-VpY3zN4$$inlined$debugInspectorInfo$1
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
                inspectorInfo.setName("widthIn");
                inspectorInfo.getProperties().set("min", Dp.box-impl(f));
                inspectorInfo.getProperties().set("max", Dp.box-impl(f2));
            }
        } : InspectableValueKt.getNoInspectorInfo(), 10, (DefaultConstructorMarker) null));
    }

    /* renamed from: widthIn-VpY3zN4$default, reason: not valid java name */
    public static /* synthetic */ Modifier m381widthInVpY3zN4$default(Modifier modifier, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.Companion.getUnspecified-D9Ej5fM();
        }
        if ((i & 2) != 0) {
            f2 = Dp.Companion.getUnspecified-D9Ej5fM();
        }
        return m380widthInVpY3zN4(modifier, f, f2);
    }

    @Stable
    @NotNull
    public static final Modifier wrapContentHeight(@NotNull Modifier modifier, @NotNull Alignment.Vertical vertical, boolean z) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(vertical, "align");
        Alignment.Companion companion = Alignment.Companion;
        return modifier.then((!Intrinsics.areEqual(vertical, companion.getCenterVertically()) || z) ? (!Intrinsics.areEqual(vertical, companion.getTop()) || z) ? createWrapContentHeightModifier(vertical, z) : WrapContentHeightTop : WrapContentHeightCenter);
    }

    public static /* synthetic */ Modifier wrapContentHeight$default(Modifier modifier, Alignment.Vertical vertical, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            vertical = Alignment.Companion.getCenterVertically();
        }
        if ((i & 2) != 0) {
            z = false;
        }
        return wrapContentHeight(modifier, vertical, z);
    }

    @Stable
    @NotNull
    public static final Modifier wrapContentSize(@NotNull Modifier modifier, @NotNull Alignment alignment, boolean z) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(alignment, "align");
        Alignment.Companion companion = Alignment.Companion;
        return modifier.then((!Intrinsics.areEqual(alignment, companion.getCenter()) || z) ? (!Intrinsics.areEqual(alignment, companion.getTopStart()) || z) ? createWrapContentSizeModifier(alignment, z) : WrapContentSizeTopStart : WrapContentSizeCenter);
    }

    public static /* synthetic */ Modifier wrapContentSize$default(Modifier modifier, Alignment alignment, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            alignment = Alignment.Companion.getCenter();
        }
        if ((i & 2) != 0) {
            z = false;
        }
        return wrapContentSize(modifier, alignment, z);
    }

    @Stable
    @NotNull
    public static final Modifier wrapContentWidth(@NotNull Modifier modifier, @NotNull Alignment.Horizontal horizontal, boolean z) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(horizontal, "align");
        Alignment.Companion companion = Alignment.Companion;
        return modifier.then((!Intrinsics.areEqual(horizontal, companion.getCenterHorizontally()) || z) ? (!Intrinsics.areEqual(horizontal, companion.getStart()) || z) ? createWrapContentWidthModifier(horizontal, z) : WrapContentWidthStart : WrapContentWidthCenter);
    }

    public static /* synthetic */ Modifier wrapContentWidth$default(Modifier modifier, Alignment.Horizontal horizontal, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            horizontal = Alignment.Companion.getCenterHorizontally();
        }
        if ((i & 2) != 0) {
            z = false;
        }
        return wrapContentWidth(modifier, horizontal, z);
    }
}
