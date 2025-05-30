package androidx.compose.ui.graphics;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.geometry.Offset;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Immutable
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class Shadow {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final Shadow None = new Shadow(0, 0, 0.0f, 7, null);
    private final float blurRadius;
    private final long color;
    private final long offset;

    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Stable
        public static /* synthetic */ void getNone$annotations() {
        }

        @NotNull
        public final Shadow getNone() {
            return Shadow.None;
        }
    }

    private Shadow(long j, long j2, float f) {
        this.color = j;
        this.offset = j2;
        this.blurRadius = f;
    }

    public /* synthetic */ Shadow(long j, long j2, float f, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, f);
    }

    /* renamed from: copy-qcb84PM$default, reason: not valid java name */
    public static /* synthetic */ Shadow m1225copyqcb84PM$default(Shadow shadow, long j, long j2, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            j = shadow.color;
        }
        long j3 = j;
        if ((i & 2) != 0) {
            j2 = shadow.offset;
        }
        long j4 = j2;
        if ((i & 4) != 0) {
            f = shadow.blurRadius;
        }
        return shadow.m1228copyqcb84PM(j3, j4, f);
    }

    @Stable
    public static /* synthetic */ void getBlurRadius$annotations() {
    }

    @Stable
    /* renamed from: getColor-0d7_KjU$annotations, reason: not valid java name */
    public static /* synthetic */ void m1226getColor0d7_KjU$annotations() {
    }

    @Stable
    /* renamed from: getOffset-F1C5BW0$annotations, reason: not valid java name */
    public static /* synthetic */ void m1227getOffsetF1C5BW0$annotations() {
    }

    @NotNull
    /* renamed from: copy-qcb84PM, reason: not valid java name */
    public final Shadow m1228copyqcb84PM(long j, long j2, float f) {
        return new Shadow(j, j2, f, null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Shadow)) {
            return false;
        }
        Shadow shadow = (Shadow) obj;
        if (Color.m1051equalsimpl0(this.color, shadow.color) && Offset.m845equalsimpl0(this.offset, shadow.offset)) {
            return (this.blurRadius > shadow.blurRadius ? 1 : (this.blurRadius == shadow.blurRadius ? 0 : -1)) == 0;
        }
        return false;
    }

    public final float getBlurRadius() {
        return this.blurRadius;
    }

    /* renamed from: getColor-0d7_KjU, reason: not valid java name */
    public final long m1229getColor0d7_KjU() {
        return this.color;
    }

    /* renamed from: getOffset-F1C5BW0, reason: not valid java name */
    public final long m1230getOffsetF1C5BW0() {
        return this.offset;
    }

    public int hashCode() {
        return (((Color.m1057hashCodeimpl(this.color) * 31) + Offset.m850hashCodeimpl(this.offset)) * 31) + Float.floatToIntBits(this.blurRadius);
    }

    @NotNull
    public String toString() {
        return "Shadow(color=" + ((Object) Color.m1058toStringimpl(this.color)) + ", offset=" + ((Object) Offset.m856toStringimpl(this.offset)) + ", blurRadius=" + this.blurRadius + ')';
    }

    public /* synthetic */ Shadow(long j, long j2, float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? ColorKt.Color(4278190080L) : j, (i & 2) != 0 ? Offset.Companion.getZero-F1C5BW0() : j2, (i & 4) != 0 ? 0.0f : f, null);
    }
}
