package androidx.compose.foundation.text;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class TextFieldScrollKt$textFieldScrollable$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ TextFieldScrollerPosition $scrollerPosition;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TextFieldScrollKt$textFieldScrollable$2(TextFieldScrollerPosition textFieldScrollerPosition, boolean z, MutableInteractionSource mutableInteractionSource) {
        super(3);
        this.$scrollerPosition = textFieldScrollerPosition;
        this.$enabled = z;
        this.$interactionSource = mutableInteractionSource;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0080, code lost:
    
        if (r3 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L24;
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00bf  */
    @androidx.compose.runtime.Composable
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final androidx.compose.ui.Modifier invoke(@org.jetbrains.annotations.NotNull androidx.compose.ui.Modifier r13, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r14, int r15) {
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
            androidx.compose.runtime.ProvidableCompositionLocal r13 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            java.lang.Object r13 = r14.consume(r13)
            androidx.compose.ui.unit.LayoutDirection r15 = androidx.compose.ui.unit.LayoutDirection.Rtl
            r0 = 1
            r1 = 0
            if (r13 != r15) goto L27
            r13 = 1
            goto L28
        L27:
            r13 = 0
        L28:
            androidx.compose.foundation.text.TextFieldScrollerPosition r15 = r12.$scrollerPosition
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
            androidx.compose.foundation.text.TextFieldScrollerPosition r13 = r12.$scrollerPosition
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
            r2.<init>(r13)
            r14.updateRememberedValue(r2)
        L5a:
            r14.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            androidx.compose.foundation.gestures.ScrollableState r13 = androidx.compose.foundation.gestures.ScrollableStateKt.rememberScrollableState(r2, r14, r1)
            androidx.compose.foundation.text.TextFieldScrollerPosition r15 = r12.$scrollerPosition
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
            r3.<init>(r13, r15)
            r14.updateRememberedValue(r3)
        L8a:
            r14.endReplaceableGroup()
            r4 = r3
            androidx.compose.foundation.text.TextFieldScrollKt$textFieldScrollable$2$wrappedScrollableState$1$1 r4 = (androidx.compose.foundation.text.TextFieldScrollKt.textFieldScrollable.2.wrappedScrollableState.1.1) r4
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.foundation.text.TextFieldScrollerPosition r13 = r12.$scrollerPosition
            androidx.compose.foundation.gestures.Orientation r5 = r13.getOrientation()
            boolean r13 = r12.$enabled
            if (r13 == 0) goto Lae
            androidx.compose.foundation.text.TextFieldScrollerPosition r13 = r12.$scrollerPosition
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
            androidx.compose.foundation.interaction.MutableInteractionSource r9 = r12.$interactionSource
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
}
