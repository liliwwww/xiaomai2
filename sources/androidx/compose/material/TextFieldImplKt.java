package androidx.compose.material;

import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.layout.IntrinsicMeasurable;
import androidx.compose.p004ui.layout.LayoutIdParentData;
import androidx.compose.p004ui.layout.Placeable;
import androidx.compose.p004ui.text.AnnotatedString;
import androidx.compose.p004ui.text.TextStyle;
import androidx.compose.p004ui.text.input.TransformedText;
import androidx.compose.p004ui.text.input.VisualTransformation;
import androidx.compose.p004ui.unit.C0856Dp;
import androidx.compose.p004ui.unit.ConstraintsKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class TextFieldImplKt {
    public static final int AnimationDuration = 150;

    @NotNull
    private static final Modifier IconDefaultSizeModifier;

    @NotNull
    public static final String LabelId = "Label";

    @NotNull
    public static final String LeadingId = "Leading";
    private static final int PlaceholderAnimationDelayOrDuration = 67;
    private static final int PlaceholderAnimationDuration = 83;

    @NotNull
    public static final String PlaceholderId = "Hint";

    @NotNull
    public static final String TextFieldId = "TextField";

    @NotNull
    public static final String TrailingId = "Trailing";
    private static final long ZeroConstraints = ConstraintsKt.Constraints(0, 0, 0, 0);
    private static final float TextFieldPadding = C0856Dp.m5216constructorimpl(16);
    private static final float HorizontalIconPadding = C0856Dp.m5216constructorimpl(12);

    static {
        float f = 48;
        IconDefaultSizeModifier = SizeKt.m1421defaultMinSizeVpY3zN4(Modifier.Companion, C0856Dp.m5216constructorimpl(f), C0856Dp.m5216constructorimpl(f));
    }

    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    public static final void CommonDecorationBox(@NotNull final TextFieldType textFieldType, @NotNull final String str, @NotNull final Function2<? super Composer, ? super Integer, Unit> function2, @NotNull final VisualTransformation visualTransformation, @Nullable final Function2<? super Composer, ? super Integer, Unit> function22, @Nullable Function2<? super Composer, ? super Integer, Unit> function23, @Nullable Function2<? super Composer, ? super Integer, Unit> function24, @Nullable Function2<? super Composer, ? super Integer, Unit> function25, boolean z, boolean z2, boolean z3, @NotNull final InteractionSource interactionSource, @NotNull final PaddingValues paddingValues, @NotNull final TextFieldColors textFieldColors, @Nullable Function2<? super Composer, ? super Integer, Unit> function26, @Nullable Composer composer, final int i, final int i2, final int i3) {
        int i4;
        int i5;
        InputPhase inputPhase;
        Composer composer2;
        final Function2<? super Composer, ? super Integer, Unit> function27;
        final Function2<? super Composer, ? super Integer, Unit> function28;
        final Function2<? super Composer, ? super Integer, Unit> function29;
        final boolean z4;
        final boolean z5;
        final boolean z6;
        final Function2<? super Composer, ? super Integer, Unit> function210;
        Intrinsics.checkNotNullParameter(textFieldType, "type");
        Intrinsics.checkNotNullParameter(str, "value");
        Intrinsics.checkNotNullParameter(function2, "innerTextField");
        Intrinsics.checkNotNullParameter(visualTransformation, "visualTransformation");
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        Intrinsics.checkNotNullParameter(paddingValues, "contentPadding");
        Intrinsics.checkNotNullParameter(textFieldColors, "colors");
        Composer startRestartGroup = composer.startRestartGroup(-712568069);
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (startRestartGroup.changed(textFieldType) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 112) == 0) {
            i4 |= startRestartGroup.changed(str) ? 32 : 16;
        }
        if ((i3 & 4) != 0) {
            i4 |= 384;
        } else if ((i & 896) == 0) {
            i4 |= startRestartGroup.changed(function2) ? 256 : 128;
        }
        if ((i3 & 8) != 0) {
            i4 |= 3072;
        } else if ((i & 7168) == 0) {
            i4 |= startRestartGroup.changed(visualTransformation) ? 2048 : 1024;
        }
        if ((i3 & 16) != 0) {
            i4 |= 24576;
        } else if ((57344 & i) == 0) {
            i4 |= startRestartGroup.changed(function22) ? 16384 : 8192;
        }
        int i6 = i3 & 32;
        if (i6 != 0) {
            i4 |= 196608;
        } else if ((i & 458752) == 0) {
            i4 |= startRestartGroup.changed(function23) ? 131072 : 65536;
        }
        int i7 = i3 & 64;
        if (i7 != 0) {
            i4 |= 1572864;
        } else if ((i & 3670016) == 0) {
            i4 |= startRestartGroup.changed(function24) ? 1048576 : 524288;
        }
        int i8 = i3 & 128;
        if (i8 != 0) {
            i4 |= 12582912;
        } else if ((i & 29360128) == 0) {
            i4 |= startRestartGroup.changed(function25) ? 8388608 : 4194304;
        }
        int i9 = i3 & 256;
        if (i9 != 0) {
            i4 |= 100663296;
        } else if ((i & 234881024) == 0) {
            i4 |= startRestartGroup.changed(z) ? 67108864 : 33554432;
        }
        int i10 = i3 & 512;
        if (i10 != 0) {
            i4 |= 805306368;
        } else if ((i & 1879048192) == 0) {
            i4 |= startRestartGroup.changed(z2) ? 536870912 : 268435456;
        }
        int i11 = i3 & 1024;
        if (i11 != 0) {
            i5 = i2 | 6;
        } else if ((i2 & 14) == 0) {
            i5 = i2 | (startRestartGroup.changed(z3) ? 4 : 2);
        } else {
            i5 = i2;
        }
        if ((i3 & 2048) != 0) {
            i5 |= 48;
        } else if ((i2 & 112) == 0) {
            i5 |= startRestartGroup.changed(interactionSource) ? 32 : 16;
        }
        int i12 = i5;
        if ((i3 & 4096) != 0) {
            i12 |= 384;
        } else if ((i2 & 896) == 0) {
            i12 |= startRestartGroup.changed(paddingValues) ? 256 : 128;
        }
        if ((i3 & 8192) != 0) {
            i12 |= 3072;
        } else if ((i2 & 7168) == 0) {
            i12 |= startRestartGroup.changed(textFieldColors) ? 2048 : 1024;
        }
        int i13 = i3 & 16384;
        if (i13 != 0) {
            i12 |= 24576;
        } else if ((i2 & 57344) == 0) {
            i12 |= startRestartGroup.changed(function26) ? 16384 : 8192;
        }
        if ((i4 & 1533916891) == 306783378 && (46811 & i12) == 9362 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            function27 = function23;
            function28 = function24;
            function29 = function25;
            z4 = z;
            z5 = z2;
            z6 = z3;
            function210 = function26;
            composer2 = startRestartGroup;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function211 = i6 != 0 ? null : function23;
            Function2<? super Composer, ? super Integer, Unit> function212 = i7 != 0 ? null : function24;
            Function2<? super Composer, ? super Integer, Unit> function213 = i8 != 0 ? null : function25;
            boolean z7 = i9 != 0 ? false : z;
            boolean z8 = i10 != 0 ? true : z2;
            boolean z9 = i11 != 0 ? false : z3;
            Function2<? super Composer, ? super Integer, Unit> function214 = i13 != 0 ? null : function26;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-712568069, i4, i12, "androidx.compose.material.CommonDecorationBox (TextFieldImpl.kt:63)");
            }
            startRestartGroup.startReplaceableGroup(511388516);
            boolean changed = startRestartGroup.changed(str) | startRestartGroup.changed(visualTransformation);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            final String text = ((TransformedText) rememberedValue).getText().getText();
            if (FocusInteractionKt.collectIsFocusedAsState(interactionSource, startRestartGroup, (i12 >> 3) & 14).getValue().booleanValue()) {
                inputPhase = InputPhase.Focused;
            } else {
                inputPhase = text.length() == 0 ? InputPhase.UnfocusedEmpty : InputPhase.UnfocusedNotEmpty;
            }
            InputPhase inputPhase2 = inputPhase;
            final int i14 = i4;
            final boolean z10 = z8;
            final boolean z11 = z9;
            final int i15 = i12;
            Function3<InputPhase, Composer, Integer, Color> function3 = new Function3<InputPhase, Composer, Integer, Color>() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$labelColor$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    return Color.m2777boximpl(m2321invokeXeAY9LY((InputPhase) obj, (Composer) obj2, ((Number) obj3).intValue()));
                }

                @Composable
                /* renamed from: invoke-XeAY9LY, reason: not valid java name */
                public final long m2321invokeXeAY9LY(@NotNull InputPhase inputPhase3, @Nullable Composer composer3, int i16) {
                    Intrinsics.checkNotNullParameter(inputPhase3, "it");
                    composer3.startReplaceableGroup(697243846);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(697243846, i16, -1, "androidx.compose.material.CommonDecorationBox.<anonymous> (TextFieldImpl.kt:91)");
                    }
                    TextFieldColors textFieldColors2 = TextFieldColors.this;
                    boolean z12 = z10;
                    boolean z13 = inputPhase3 == InputPhase.UnfocusedEmpty ? false : z11;
                    InteractionSource interactionSource2 = interactionSource;
                    int i17 = (i14 >> 27) & 14;
                    int i18 = i15;
                    long m2797unboximpl = textFieldColors2.labelColor(z12, z13, interactionSource2, composer3, i17 | ((i18 << 3) & 896) | (i18 & 7168)).getValue().m2797unboximpl();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer3.endReplaceableGroup();
                    return m2797unboximpl;
                }
            };
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            Typography typography = materialTheme.getTypography(startRestartGroup, 6);
            TextStyle subtitle1 = typography.getSubtitle1();
            TextStyle caption = typography.getCaption();
            long m4767getColor0d7_KjU = subtitle1.m4767getColor0d7_KjU();
            Color.Companion companion = Color.Companion;
            boolean z12 = (Color.m2788equalsimpl0(m4767getColor0d7_KjU, companion.m2823getUnspecified0d7_KjU()) && !Color.m2788equalsimpl0(caption.m4767getColor0d7_KjU(), companion.m2823getUnspecified0d7_KjU())) || (!Color.m2788equalsimpl0(subtitle1.m4767getColor0d7_KjU(), companion.m2823getUnspecified0d7_KjU()) && Color.m2788equalsimpl0(caption.m4767getColor0d7_KjU(), companion.m2823getUnspecified0d7_KjU()));
            TextFieldTransitionScope textFieldTransitionScope = TextFieldTransitionScope.INSTANCE;
            startRestartGroup.startReplaceableGroup(2129141006);
            long m4767getColor0d7_KjU2 = materialTheme.getTypography(startRestartGroup, 6).getCaption().m4767getColor0d7_KjU();
            if (z12) {
                if (!(m4767getColor0d7_KjU2 != companion.m2823getUnspecified0d7_KjU())) {
                    m4767getColor0d7_KjU2 = ((Color) function3.invoke(inputPhase2, startRestartGroup, 0)).m2797unboximpl();
                }
            }
            long j = m4767getColor0d7_KjU2;
            startRestartGroup.endReplaceableGroup();
            long m4767getColor0d7_KjU3 = materialTheme.getTypography(startRestartGroup, 6).getSubtitle1().m4767getColor0d7_KjU();
            if (z12) {
                if (!(m4767getColor0d7_KjU3 != companion.m2823getUnspecified0d7_KjU())) {
                    m4767getColor0d7_KjU3 = ((Color) function3.invoke(inputPhase2, startRestartGroup, 0)).m2797unboximpl();
                }
            }
            long j2 = m4767getColor0d7_KjU3;
            final Function2<? super Composer, ? super Integer, Unit> function215 = function211;
            final boolean z13 = z9;
            final int i16 = i12;
            final boolean z14 = z8;
            final Function2<? super Composer, ? super Integer, Unit> function216 = function212;
            final Function2<? super Composer, ? super Integer, Unit> function217 = function213;
            final boolean z15 = z7;
            final boolean z16 = z12;
            final Function2<? super Composer, ? super Integer, Unit> function218 = function214;
            composer2 = startRestartGroup;
            textFieldTransitionScope.m2330TransitionDTcfvLk(inputPhase2, j, j2, function3, function22 != null, ComposableLambdaKt.composableLambda(composer2, 341865432, true, new Function6<Float, Color, Color, Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3

                /* compiled from: Taobao */
                public /* synthetic */ class WhenMappings {
                    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                    static {
                        int[] iArr = new int[TextFieldType.values().length];
                        iArr[TextFieldType.Filled.ordinal()] = 1;
                        iArr[TextFieldType.Outlined.ordinal()] = 2;
                        $EnumSwitchMapping$0 = iArr;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(6);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
                    m2319invokeRIQooxk(((Number) obj).floatValue(), ((Color) obj2).m2797unboximpl(), ((Color) obj3).m2797unboximpl(), ((Number) obj4).floatValue(), (Composer) obj5, ((Number) obj6).intValue());
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Removed duplicated region for block: B:53:0x011a  */
                /* JADX WARN: Removed duplicated region for block: B:56:0x0184  */
                /* JADX WARN: Removed duplicated region for block: B:59:0x019b  */
                /* JADX WARN: Removed duplicated region for block: B:62:0x0205  */
                /* JADX WARN: Removed duplicated region for block: B:65:0x0220  */
                /* JADX WARN: Removed duplicated region for block: B:70:0x0318  */
                /* JADX WARN: Removed duplicated region for block: B:72:? A[RETURN, SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:82:0x02d8  */
                /* JADX WARN: Removed duplicated region for block: B:83:0x0213  */
                /* JADX WARN: Removed duplicated region for block: B:84:0x01d2  */
                /* JADX WARN: Removed duplicated region for block: B:85:0x0193  */
                /* JADX WARN: Removed duplicated region for block: B:86:0x0151  */
                /* JADX WARN: Type inference failed for: r14v0 */
                /* JADX WARN: Type inference failed for: r14v1, types: [boolean, int] */
                /* JADX WARN: Type inference failed for: r14v4 */
                @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                @androidx.compose.runtime.Composable
                /* renamed from: invoke-RIQooxk, reason: not valid java name */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final void m2319invokeRIQooxk(final float r21, final long r22, final long r24, final float r26, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r27, int r28) {
                    /*
                        Method dump skipped, instructions count: 796
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3.m2319invokeRIQooxk(float, long, long, float, androidx.compose.runtime.Composer, int):void");
                }
            }), composer2, 1769472);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function27 = function211;
            function28 = function212;
            function29 = function213;
            z4 = z7;
            z5 = z8;
            z6 = z9;
            function210 = function214;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable Composer composer3, int i17) {
                TextFieldImplKt.CommonDecorationBox(TextFieldType.this, str, function2, visualTransformation, function22, function27, function28, function29, z4, z5, z6, interactionSource, paddingValues, textFieldColors, function210, composer3, i | 1, i2, i3);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0050  */
    @androidx.compose.runtime.Composable
    @androidx.compose.runtime.ComposableOpenTarget(index = 0)
    /* renamed from: Decoration-euL9pac, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m2318DecorationeuL9pac(final long r16, @org.jetbrains.annotations.Nullable androidx.compose.p004ui.text.TextStyle r18, @org.jetbrains.annotations.Nullable java.lang.Float r19, @org.jetbrains.annotations.NotNull final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r20, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r21, final int r22, final int r23) {
        /*
            Method dump skipped, instructions count: 257
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextFieldImplKt.m2318DecorationeuL9pac(long, androidx.compose.ui.text.TextStyle, java.lang.Float, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final float getHorizontalIconPadding() {
        return HorizontalIconPadding;
    }

    @NotNull
    public static final Modifier getIconDefaultSizeModifier() {
        return IconDefaultSizeModifier;
    }

    @Nullable
    public static final Object getLayoutId(@NotNull IntrinsicMeasurable intrinsicMeasurable) {
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "<this>");
        Object parentData = intrinsicMeasurable.getParentData();
        LayoutIdParentData layoutIdParentData = parentData instanceof LayoutIdParentData ? (LayoutIdParentData) parentData : null;
        if (layoutIdParentData != null) {
            return layoutIdParentData.getLayoutId();
        }
        return null;
    }

    public static final float getTextFieldPadding() {
        return TextFieldPadding;
    }

    public static final long getZeroConstraints() {
        return ZeroConstraints;
    }

    public static final int heightOrZero(@Nullable Placeable placeable) {
        if (placeable != null) {
            return placeable.getHeight();
        }
        return 0;
    }

    public static final int widthOrZero(@Nullable Placeable placeable) {
        if (placeable != null) {
            return placeable.getWidth();
        }
        return 0;
    }
}
