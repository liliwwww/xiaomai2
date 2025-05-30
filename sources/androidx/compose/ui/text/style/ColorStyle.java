package androidx.compose.ui.text.style;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.text.style.TextForegroundStyle;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class ColorStyle implements TextForegroundStyle {
    private final long value;

    private ColorStyle(long j) {
        this.value = j;
        if (!(j != Color.Companion.getUnspecified-0d7_KjU())) {
            throw new IllegalArgumentException("ColorStyle value must be specified, use TextForegroundStyle.Unspecified instead.".toString());
        }
    }

    public /* synthetic */ ColorStyle(long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(j);
    }

    /* renamed from: copy-8_81llA$default, reason: not valid java name */
    public static /* synthetic */ ColorStyle m2008copy8_81llA$default(ColorStyle colorStyle, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = colorStyle.value;
        }
        return colorStyle.m2010copy8_81llA(j);
    }

    /* renamed from: component1-0d7_KjU, reason: not valid java name */
    public final long m2009component10d7_KjU() {
        return this.value;
    }

    @NotNull
    /* renamed from: copy-8_81llA, reason: not valid java name */
    public final ColorStyle m2010copy8_81llA(long j) {
        return new ColorStyle(j, null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ColorStyle) && Color.m1051equalsimpl0(this.value, ((ColorStyle) obj).value);
    }

    public float getAlpha() {
        return Color.m1052getAlphaimpl(m2011getColor0d7_KjU());
    }

    @Nullable
    public Brush getBrush() {
        return null;
    }

    /* renamed from: getColor-0d7_KjU, reason: not valid java name */
    public long m2011getColor0d7_KjU() {
        return this.value;
    }

    /* renamed from: getValue-0d7_KjU, reason: not valid java name */
    public final long m2012getValue0d7_KjU() {
        return this.value;
    }

    public int hashCode() {
        return Color.m1057hashCodeimpl(this.value);
    }

    public /* synthetic */ TextForegroundStyle merge(TextForegroundStyle textForegroundStyle) {
        return TextForegroundStyle.-CC.a(this, textForegroundStyle);
    }

    public /* synthetic */ TextForegroundStyle takeOrElse(Function0 function0) {
        return TextForegroundStyle.-CC.b(this, function0);
    }

    @NotNull
    public String toString() {
        return "ColorStyle(value=" + ((Object) Color.m1058toStringimpl(this.value)) + ')';
    }
}
