package androidx.compose.material;

import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.LayoutIdParentData;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import androidx.core.view.GravityCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
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
    private static final float TextFieldPadding = Dp.m2142constructorimpl(16);
    private static final float HorizontalIconPadding = Dp.m2142constructorimpl(12);

    static {
        float f = 48;
        IconDefaultSizeModifier = SizeKt.defaultMinSize-VpY3zN4(Modifier.Companion, Dp.m2142constructorimpl(f), Dp.m2142constructorimpl(f));
    }

    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    public static final void CommonDecorationBox(@NotNull TextFieldType textFieldType, @NotNull String str, @NotNull Function2<? super Composer, ? super Integer, Unit> function2, @NotNull VisualTransformation visualTransformation, @Nullable Function2<? super Composer, ? super Integer, Unit> function22, @Nullable Function2<? super Composer, ? super Integer, Unit> function23, @Nullable Function2<? super Composer, ? super Integer, Unit> function24, @Nullable Function2<? super Composer, ? super Integer, Unit> function25, boolean z, boolean z2, boolean z3, @NotNull InteractionSource interactionSource, @NotNull PaddingValues paddingValues, @NotNull TextFieldColors textFieldColors, @Nullable Function2<? super Composer, ? super Integer, Unit> function26, @Nullable Composer composer, int i, int i2, int i3) {
        int i4;
        int i5;
        InputPhase inputPhase;
        Composer composer2;
        Function2<? super Composer, ? super Integer, Unit> function27;
        Function2<? super Composer, ? super Integer, Unit> function28;
        Function2<? super Composer, ? super Integer, Unit> function29;
        boolean z4;
        boolean z5;
        boolean z6;
        Function2<? super Composer, ? super Integer, Unit> function210;
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
        int i6 = i3 & 16;
        int i7 = AccessibilityNodeInfoCompat.ACTION_COPY;
        if (i6 != 0) {
            i4 |= 24576;
        } else if ((57344 & i) == 0) {
            i4 |= startRestartGroup.changed(function22) ? AccessibilityNodeInfoCompat.ACTION_COPY : 8192;
        }
        int i8 = i3 & 32;
        if (i8 != 0) {
            i4 |= 196608;
        } else if ((i & 458752) == 0) {
            i4 |= startRestartGroup.changed(function23) ? AccessibilityNodeInfoCompat.ACTION_SET_SELECTION : AccessibilityNodeInfoCompat.ACTION_CUT;
        }
        int i9 = i3 & 64;
        if (i9 != 0) {
            i4 |= 1572864;
        } else if ((i & 3670016) == 0) {
            i4 |= startRestartGroup.changed(function24) ? AccessibilityNodeInfoCompat.ACTION_DISMISS : AccessibilityNodeInfoCompat.ACTION_COLLAPSE;
        }
        int i10 = i3 & 128;
        if (i10 != 0) {
            i4 |= 12582912;
        } else if ((i & 29360128) == 0) {
            i4 |= startRestartGroup.changed(function25) ? GravityCompat.RELATIVE_LAYOUT_DIRECTION : InputDeviceCompat.SOURCE_ROTARY_ENCODER;
        }
        int i11 = i3 & 256;
        if (i11 != 0) {
            i4 |= 100663296;
        } else if ((i & 234881024) == 0) {
            i4 |= startRestartGroup.changed(z) ? 67108864 : 33554432;
        }
        int i12 = i3 & 512;
        if (i12 != 0) {
            i4 |= 805306368;
        } else if ((i & 1879048192) == 0) {
            i4 |= startRestartGroup.changed(z2) ? 536870912 : 268435456;
        }
        int i13 = i3 & 1024;
        if (i13 != 0) {
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
        int i14 = i5;
        if ((i3 & 4096) != 0) {
            i14 |= 384;
        } else if ((i2 & 896) == 0) {
            i14 |= startRestartGroup.changed(paddingValues) ? 256 : 128;
        }
        if ((i3 & 8192) != 0) {
            i14 |= 3072;
        } else if ((i2 & 7168) == 0) {
            i14 |= startRestartGroup.changed(textFieldColors) ? 2048 : 1024;
        }
        int i15 = i3 & AccessibilityNodeInfoCompat.ACTION_COPY;
        if (i15 != 0) {
            i14 |= 24576;
        } else if ((i2 & 57344) == 0) {
            if (!startRestartGroup.changed(function26)) {
                i7 = 8192;
            }
            i14 |= i7;
        }
        if ((i4 & 1533916891) == 306783378 && (46811 & i14) == 9362 && startRestartGroup.getSkipping()) {
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
            Function2<? super Composer, ? super Integer, Unit> function211 = i8 != 0 ? null : function23;
            Function2<? super Composer, ? super Integer, Unit> function212 = i9 != 0 ? null : function24;
            Function2<? super Composer, ? super Integer, Unit> function213 = i10 != 0 ? null : function25;
            boolean z7 = i11 != 0 ? false : z;
            boolean z8 = i12 != 0 ? true : z2;
            boolean z9 = i13 != 0 ? false : z3;
            Function2<? super Composer, ? super Integer, Unit> function214 = i15 != 0 ? null : function26;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-712568069, i4, i14, "androidx.compose.material.CommonDecorationBox (TextFieldImpl.kt:63)");
            }
            startRestartGroup.startReplaceableGroup(511388516);
            boolean changed = startRestartGroup.changed(str) | startRestartGroup.changed(visualTransformation);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = visualTransformation.filter(new AnnotatedString(str, (List) null, (List) null, 6, (DefaultConstructorMarker) null));
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            String text = ((TransformedText) rememberedValue).getText().getText();
            if (((Boolean) FocusInteractionKt.collectIsFocusedAsState(interactionSource, startRestartGroup, (i14 >> 3) & 14).getValue()).booleanValue()) {
                inputPhase = InputPhase.Focused;
            } else {
                inputPhase = text.length() == 0 ? InputPhase.UnfocusedEmpty : InputPhase.UnfocusedNotEmpty;
            }
            InputPhase inputPhase2 = inputPhase;
            int i16 = i4;
            CommonDecorationBox.labelColor.1 r11 = new CommonDecorationBox.labelColor.1(textFieldColors, z8, z9, interactionSource, i16, i14);
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            Typography typography = materialTheme.getTypography(startRestartGroup, 6);
            TextStyle subtitle1 = typography.getSubtitle1();
            TextStyle caption = typography.getCaption();
            long j = subtitle1.getColor-0d7_KjU();
            Color.Companion companion = Color.Companion;
            boolean z10 = (Color.m1051equalsimpl0(j, companion.getUnspecified-0d7_KjU()) && !Color.m1051equalsimpl0(caption.getColor-0d7_KjU(), companion.getUnspecified-0d7_KjU())) || (!Color.m1051equalsimpl0(subtitle1.getColor-0d7_KjU(), companion.getUnspecified-0d7_KjU()) && Color.m1051equalsimpl0(caption.getColor-0d7_KjU(), companion.getUnspecified-0d7_KjU()));
            TextFieldTransitionScope textFieldTransitionScope = TextFieldTransitionScope.INSTANCE;
            startRestartGroup.startReplaceableGroup(2129141006);
            long j2 = materialTheme.getTypography(startRestartGroup, 6).getCaption().getColor-0d7_KjU();
            if (z10) {
                if (!(j2 != companion.getUnspecified-0d7_KjU())) {
                    j2 = ((Color) r11.invoke(inputPhase2, startRestartGroup, 0)).m1060unboximpl();
                }
            }
            long j3 = j2;
            startRestartGroup.endReplaceableGroup();
            long j4 = materialTheme.getTypography(startRestartGroup, 6).getSubtitle1().getColor-0d7_KjU();
            if (z10) {
                if (!(j4 != companion.getUnspecified-0d7_KjU())) {
                    j4 = ((Color) r11.invoke(inputPhase2, startRestartGroup, 0)).m1060unboximpl();
                }
            }
            long j5 = j4;
            composer2 = startRestartGroup;
            textFieldTransitionScope.Transition-DTcfvLk(inputPhase2, j3, j5, r11, function22 != null, ComposableLambdaKt.composableLambda(composer2, 341865432, true, new CommonDecorationBox.3(function22, function211, text, z9, i14, textFieldColors, z8, interactionSource, i16, function212, function213, textFieldType, function2, z7, paddingValues, z10, function214)), composer2, 1769472);
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
        endRestartGroup.updateScope(new CommonDecorationBox.4(textFieldType, str, function2, visualTransformation, function22, function27, function28, function29, z4, z5, z6, interactionSource, paddingValues, textFieldColors, function210, i, i2, i3));
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
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m693DecorationeuL9pac(final long r16, @org.jetbrains.annotations.Nullable androidx.compose.ui.text.TextStyle r18, @org.jetbrains.annotations.Nullable java.lang.Float r19, @org.jetbrains.annotations.NotNull final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r20, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r21, final int r22, final int r23) {
        /*
            Method dump skipped, instructions count: 257
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextFieldImplKt.m693DecorationeuL9pac(long, androidx.compose.ui.text.TextStyle, java.lang.Float, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
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
