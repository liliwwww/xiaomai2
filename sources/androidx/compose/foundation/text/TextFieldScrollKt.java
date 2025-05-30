package androidx.compose.foundation.text;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.p004ui.ComposedModifierKt;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.draw.ClipKt;
import androidx.compose.p004ui.geometry.Rect;
import androidx.compose.p004ui.platform.InspectableValueKt;
import androidx.compose.p004ui.platform.InspectorInfo;
import androidx.compose.p004ui.text.TextLayoutResult;
import androidx.compose.p004ui.text.input.TextFieldValue;
import androidx.compose.p004ui.text.input.TransformedText;
import androidx.compose.p004ui.text.input.VisualTransformation;
import androidx.compose.p004ui.unit.Density;
import androidx.compose.runtime.Composer;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class TextFieldScrollKt {

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Orientation.values().length];
            try {
                iArr[Orientation.Vertical.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Orientation.Horizontal.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Rect getCursorRectInScroller(Density density, int i, TransformedText transformedText, TextLayoutResult textLayoutResult, boolean z, int i2) {
        Rect zero;
        if (textLayoutResult == null || (zero = textLayoutResult.getCursorRect(transformedText.getOffsetMapping().originalToTransformed(i))) == null) {
            zero = Rect.Companion.getZero();
        }
        Rect rect = zero;
        int mo1277roundToPx0680j_4 = density.mo1277roundToPx0680j_4(TextFieldCursorKt.getDefaultCursorThickness());
        return Rect.copy$default(rect, z ? (i2 - rect.getLeft()) - mo1277roundToPx0680j_4 : rect.getLeft(), 0.0f, z ? i2 - rect.getLeft() : rect.getLeft() + mo1277roundToPx0680j_4, 0.0f, 10, null);
    }

    @NotNull
    public static final Modifier textFieldScroll(@NotNull Modifier modifier, @NotNull TextFieldScrollerPosition textFieldScrollerPosition, @NotNull TextFieldValue textFieldValue, @NotNull VisualTransformation visualTransformation, @NotNull Function0<TextLayoutResultProxy> function0) {
        Modifier verticalScrollLayoutModifier;
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(textFieldScrollerPosition, "scrollerPosition");
        Intrinsics.checkNotNullParameter(textFieldValue, "textFieldValue");
        Intrinsics.checkNotNullParameter(visualTransformation, "visualTransformation");
        Intrinsics.checkNotNullParameter(function0, "textLayoutResultProvider");
        Orientation orientation = textFieldScrollerPosition.getOrientation();
        int m1797getOffsetToFollow5zctL8 = textFieldScrollerPosition.m1797getOffsetToFollow5zctL8(textFieldValue.m4956getSelectiond9O1mEE());
        textFieldScrollerPosition.m1799setPreviousSelection5zctL8(textFieldValue.m4956getSelectiond9O1mEE());
        TransformedText filterWithValidation = ValidatingOffsetMappingKt.filterWithValidation(visualTransformation, textFieldValue.getAnnotatedString());
        int i = WhenMappings.$EnumSwitchMapping$0[orientation.ordinal()];
        if (i == 1) {
            verticalScrollLayoutModifier = new VerticalScrollLayoutModifier(textFieldScrollerPosition, m1797getOffsetToFollow5zctL8, filterWithValidation, function0);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            verticalScrollLayoutModifier = new HorizontalScrollLayoutModifier(textFieldScrollerPosition, m1797getOffsetToFollow5zctL8, filterWithValidation, function0);
        }
        return ClipKt.clipToBounds(modifier).then(verticalScrollLayoutModifier);
    }

    @NotNull
    public static final Modifier textFieldScrollable(@NotNull Modifier modifier, @NotNull final TextFieldScrollerPosition textFieldScrollerPosition, @Nullable final MutableInteractionSource mutableInteractionSource, final boolean z) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(textFieldScrollerPosition, "scrollerPosition");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.text.TextFieldScrollKt$textFieldScrollable$$inlined$debugInspectorInfo$1
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
                inspectorInfo.setName("textFieldScrollable");
                inspectorInfo.getProperties().set("scrollerPosition", TextFieldScrollerPosition.this);
                inspectorInfo.getProperties().set("interactionSource", mutableInteractionSource);
                inspectorInfo.getProperties().set("enabled", Boolean.valueOf(z));
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.text.TextFieldScrollKt$textFieldScrollable$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
            }

            /* JADX WARN: Removed duplicated region for block: B:28:0x00bf  */
            @androidx.compose.runtime.Composable
            @org.jetbrains.annotations.NotNull
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final androidx.compose.p004ui.Modifier invoke(@org.jetbrains.annotations.NotNull androidx.compose.p004ui.Modifier r13, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r14, int r15) {
                /*
                    r12 = this;
                    java.lang.String r0 = "$this$composed"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
                    r13 = 805428266(0x3001dc2a, float:4.72428E-10)
                    r14.startReplaceableGroup(r13)
                    boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
                    if (r0 == 0) goto L17
                    r0 = -1
                    java.lang.String r1 = "androidx.compose.foundation.text.textFieldScrollable.<anonymous> (TextFieldScroll.kt:65)"
                    androidx.compose.runtime.ComposerKt.traceEventStart(r13, r15, r0, r1)
                L17:
                    androidx.compose.runtime.ProvidableCompositionLocal r13 = androidx.compose.p004ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
                    java.lang.Object r13 = r14.consume(r13)
                    androidx.compose.ui.unit.LayoutDirection r15 = androidx.compose.p004ui.unit.LayoutDirection.Rtl
                    r0 = 1
                    r1 = 0
                    if (r13 != r15) goto L27
                    r13 = 1
                    goto L28
                L27:
                    r13 = 0
                L28:
                    androidx.compose.foundation.text.TextFieldScrollerPosition r15 = androidx.compose.foundation.text.TextFieldScrollerPosition.this
                    androidx.compose.foundation.gestures.Orientation r15 = r15.getOrientation()
                    androidx.compose.foundation.gestures.Orientation r2 = androidx.compose.foundation.gestures.Orientation.Vertical
                    if (r15 == r2) goto L37
                    if (r13 != 0) goto L35
                    goto L37
                L35:
                    r7 = 0
                    goto L38
                L37:
                    r7 = 1
                L38:
                    androidx.compose.foundation.text.TextFieldScrollerPosition r13 = androidx.compose.foundation.text.TextFieldScrollerPosition.this
                    r15 = 1157296644(0x44faf204, float:2007.563)
                    r14.startReplaceableGroup(r15)
                    boolean r15 = r14.changed(r13)
                    java.lang.Object r2 = r14.rememberedValue()
                    if (r15 != 0) goto L52
                    androidx.compose.runtime.Composer$Companion r15 = androidx.compose.runtime.Composer.Companion
                    java.lang.Object r15 = r15.getEmpty()
                    if (r2 != r15) goto L5a
                L52:
                    androidx.compose.foundation.text.TextFieldScrollKt$textFieldScrollable$2$scrollableState$1$1 r2 = new androidx.compose.foundation.text.TextFieldScrollKt$textFieldScrollable$2$scrollableState$1$1
                    r2.<init>()
                    r14.updateRememberedValue(r2)
                L5a:
                    r14.endReplaceableGroup()
                    kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
                    androidx.compose.foundation.gestures.ScrollableState r13 = androidx.compose.foundation.gestures.ScrollableStateKt.rememberScrollableState(r2, r14, r1)
                    androidx.compose.foundation.text.TextFieldScrollerPosition r15 = androidx.compose.foundation.text.TextFieldScrollerPosition.this
                    r2 = 511388516(0x1e7b2b64, float:1.3296802E-20)
                    r14.startReplaceableGroup(r2)
                    boolean r2 = r14.changed(r13)
                    boolean r3 = r14.changed(r15)
                    r2 = r2 | r3
                    java.lang.Object r3 = r14.rememberedValue()
                    if (r2 != 0) goto L82
                    androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
                    java.lang.Object r2 = r2.getEmpty()
                    if (r3 != r2) goto L8a
                L82:
                    androidx.compose.foundation.text.TextFieldScrollKt$textFieldScrollable$2$wrappedScrollableState$1$1 r3 = new androidx.compose.foundation.text.TextFieldScrollKt$textFieldScrollable$2$wrappedScrollableState$1$1
                    r3.<init>(r15)
                    r14.updateRememberedValue(r3)
                L8a:
                    r14.endReplaceableGroup()
                    r4 = r3
                    androidx.compose.foundation.text.TextFieldScrollKt$textFieldScrollable$2$wrappedScrollableState$1$1 r4 = (androidx.compose.foundation.text.C0603x4ee6fee2) r4
                    androidx.compose.ui.Modifier$Companion r3 = androidx.compose.p004ui.Modifier.Companion
                    androidx.compose.foundation.text.TextFieldScrollerPosition r13 = androidx.compose.foundation.text.TextFieldScrollerPosition.this
                    androidx.compose.foundation.gestures.Orientation r5 = r13.getOrientation()
                    boolean r13 = r2
                    if (r13 == 0) goto Lae
                    androidx.compose.foundation.text.TextFieldScrollerPosition r13 = androidx.compose.foundation.text.TextFieldScrollerPosition.this
                    float r13 = r13.getMaximum()
                    r15 = 0
                    int r13 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
                    if (r13 != 0) goto La9
                    r13 = 1
                    goto Laa
                La9:
                    r13 = 0
                Laa:
                    if (r13 != 0) goto Lae
                    r6 = 1
                    goto Laf
                Lae:
                    r6 = 0
                Laf:
                    r8 = 0
                    androidx.compose.foundation.interaction.MutableInteractionSource r9 = r3
                    r10 = 16
                    r11 = 0
                    androidx.compose.ui.Modifier r13 = androidx.compose.foundation.gestures.ScrollableKt.scrollable$default(r3, r4, r5, r6, r7, r8, r9, r10, r11)
                    boolean r15 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
                    if (r15 == 0) goto Lc2
                    androidx.compose.runtime.ComposerKt.traceEventEnd()
                Lc2:
                    r14.endReplaceableGroup()
                    return r13
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.TextFieldScrollKt$textFieldScrollable$2.invoke(androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int):androidx.compose.ui.Modifier");
            }
        });
    }

    public static /* synthetic */ Modifier textFieldScrollable$default(Modifier modifier, TextFieldScrollerPosition textFieldScrollerPosition, MutableInteractionSource mutableInteractionSource, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            mutableInteractionSource = null;
        }
        if ((i & 4) != 0) {
            z = true;
        }
        return textFieldScrollable(modifier, textFieldScrollerPosition, mutableInteractionSource, z);
    }
}
