package androidx.compose.ui.text.style;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class LineHeightStyle {
    public static final int $stable = 0;

    @NotNull
    public static final Companion Companion;

    @NotNull
    private static final LineHeightStyle Default;
    private final float alignment;
    private final int trim;

    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final LineHeightStyle getDefault() {
            return LineHeightStyle.Default;
        }
    }

    static {
        DefaultConstructorMarker defaultConstructorMarker = null;
        Companion = new Companion(defaultConstructorMarker);
        Default = new LineHeightStyle(Alignment.Companion.getProportional-PIaL0Z0(), Trim.Companion.getBoth-EVpEnUU(), defaultConstructorMarker);
    }

    private LineHeightStyle(float f, int i) {
        this.alignment = f;
        this.trim = i;
    }

    public /* synthetic */ LineHeightStyle(float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, i);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LineHeightStyle)) {
            return false;
        }
        LineHeightStyle lineHeightStyle = (LineHeightStyle) obj;
        return Alignment.equals-impl0(this.alignment, lineHeightStyle.alignment) && Trim.equals-impl0(this.trim, lineHeightStyle.trim);
    }

    /* renamed from: getAlignment-PIaL0Z0, reason: not valid java name */
    public final float m2497getAlignmentPIaL0Z0() {
        return this.alignment;
    }

    /* renamed from: getTrim-EVpEnUU, reason: not valid java name */
    public final int m2498getTrimEVpEnUU() {
        return this.trim;
    }

    public int hashCode() {
        return (Alignment.hashCode-impl(this.alignment) * 31) + Trim.hashCode-impl(this.trim);
    }

    @NotNull
    public String toString() {
        return "LineHeightStyle(alignment=" + ((Object) Alignment.toString-impl(this.alignment)) + ", trim=" + ((Object) Trim.toString-impl(this.trim)) + ')';
    }
}
