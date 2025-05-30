package androidx.compose.material;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.graphics.Color;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Lambda;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class TextFieldImplKt$CommonDecorationBox$3 extends Lambda implements Function6<Float, Color, Color, Float, Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ int $$dirty1;
    final /* synthetic */ Function2<Composer, Integer, Unit> $border;
    final /* synthetic */ TextFieldColors $colors;
    final /* synthetic */ PaddingValues $contentPadding;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ Function2<Composer, Integer, Unit> $innerTextField;
    final /* synthetic */ InteractionSource $interactionSource;
    final /* synthetic */ boolean $isError;
    final /* synthetic */ Function2<Composer, Integer, Unit> $label;
    final /* synthetic */ Function2<Composer, Integer, Unit> $leadingIcon;
    final /* synthetic */ Function2<Composer, Integer, Unit> $placeholder;
    final /* synthetic */ boolean $shouldOverrideTextStyleColor;
    final /* synthetic */ boolean $singleLine;
    final /* synthetic */ Function2<Composer, Integer, Unit> $trailingIcon;
    final /* synthetic */ String $transformedText;
    final /* synthetic */ TextFieldType $type;

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
    TextFieldImplKt$CommonDecorationBox$3(Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, String str, boolean z, int i, TextFieldColors textFieldColors, boolean z2, InteractionSource interactionSource, int i2, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, TextFieldType textFieldType, Function2<? super Composer, ? super Integer, Unit> function25, boolean z3, PaddingValues paddingValues, boolean z4, Function2<? super Composer, ? super Integer, Unit> function26) {
        super(6);
        this.$label = function2;
        this.$placeholder = function22;
        this.$transformedText = str;
        this.$isError = z;
        this.$$dirty1 = i;
        this.$colors = textFieldColors;
        this.$enabled = z2;
        this.$interactionSource = interactionSource;
        this.$$dirty = i2;
        this.$leadingIcon = function23;
        this.$trailingIcon = function24;
        this.$type = textFieldType;
        this.$innerTextField = function25;
        this.$singleLine = z3;
        this.$contentPadding = paddingValues;
        this.$shouldOverrideTextStyleColor = z4;
        this.$border = function26;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        m869invokeRIQooxk(((Number) obj).floatValue(), ((Color) obj2).unbox-impl(), ((Color) obj3).unbox-impl(), ((Number) obj4).floatValue(), (Composer) obj5, ((Number) obj6).intValue());
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:79:0x0293, code lost:
    
        if (r5 == r4.getEmpty()) goto L87;
     */
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
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m869invokeRIQooxk(final float r21, final long r22, final long r24, float r26, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r27, int r28) {
        /*
            Method dump skipped, instructions count: 796
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3.m869invokeRIQooxk(float, long, long, float, androidx.compose.runtime.Composer, int):void");
    }
}
