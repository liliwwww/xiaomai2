package androidx.compose.p004ui.text.style;

import androidx.compose.p004ui.graphics.Brush;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.text.style.TextForegroundStyle;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
final class ColorStyle implements TextForegroundStyle {
    private final long value;

    private ColorStyle(long j) {
        this.value = j;
        if (!(j != Color.Companion.m2823getUnspecified0d7_KjU())) {
            throw new IllegalArgumentException("ColorStyle value must be specified, use TextForegroundStyle.Unspecified instead.".toString());
        }
    }

    public /* synthetic */ ColorStyle(long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(j);
    }

    /* renamed from: copy-8_81llA$default, reason: not valid java name */
    public static /* synthetic */ ColorStyle m5003copy8_81llA$default(ColorStyle colorStyle, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = colorStyle.value;
        }
        return colorStyle.m5005copy8_81llA(j);
    }

    /* renamed from: component1-0d7_KjU, reason: not valid java name */
    public final long m5004component10d7_KjU() {
        return this.value;
    }

    @NotNull
    /* renamed from: copy-8_81llA, reason: not valid java name */
    public final ColorStyle m5005copy8_81llA(long j) {
        return new ColorStyle(j, null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ColorStyle) && Color.m2788equalsimpl0(this.value, ((ColorStyle) obj).value);
    }

    @Override // androidx.compose.p004ui.text.style.TextForegroundStyle
    public float getAlpha() {
        return Color.m2789getAlphaimpl(mo5002getColor0d7_KjU());
    }

    @Override // androidx.compose.p004ui.text.style.TextForegroundStyle
    @Nullable
    public Brush getBrush() {
        return null;
    }

    @Override // androidx.compose.p004ui.text.style.TextForegroundStyle
    /* renamed from: getColor-0d7_KjU */
    public long mo5002getColor0d7_KjU() {
        return this.value;
    }

    /* renamed from: getValue-0d7_KjU, reason: not valid java name */
    public final long m5006getValue0d7_KjU() {
        return this.value;
    }

    public int hashCode() {
        return Color.m2794hashCodeimpl(this.value);
    }

    @Override // androidx.compose.p004ui.text.style.TextForegroundStyle
    public /* synthetic */ TextForegroundStyle merge(TextForegroundStyle textForegroundStyle) {
        return TextForegroundStyle.CC.m170a(this, textForegroundStyle);
    }

    @Override // androidx.compose.p004ui.text.style.TextForegroundStyle
    public /* synthetic */ TextForegroundStyle takeOrElse(Function0 function0) {
        return TextForegroundStyle.CC.m171b(this, function0);
    }

    @NotNull
    public String toString() {
        return "ColorStyle(value=" + ((Object) Color.m2795toStringimpl(this.value)) + ')';
    }
}
