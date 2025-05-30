package androidx.compose.ui.text;

import androidx.compose.runtime.Immutable;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Immutable
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class Placeholder {
    private final long height;
    private final int placeholderVerticalAlign;
    private final long width;

    private Placeholder(long j, long j2, int i) {
        this.width = j;
        this.height = j2;
        this.placeholderVerticalAlign = i;
        if (!(!TextUnitKt.m2231isUnspecifiedR2X_6o(j))) {
            throw new IllegalArgumentException("width cannot be TextUnit.Unspecified".toString());
        }
        if (!(!TextUnitKt.m2231isUnspecifiedR2X_6o(j2))) {
            throw new IllegalArgumentException("height cannot be TextUnit.Unspecified".toString());
        }
    }

    public /* synthetic */ Placeholder(long j, long j2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, i);
    }

    /* renamed from: copy-K8Q-__8$default, reason: not valid java name */
    public static /* synthetic */ Placeholder m1853copyK8Q__8$default(Placeholder placeholder, long j, long j2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = placeholder.width;
        }
        long j3 = j;
        if ((i2 & 2) != 0) {
            j2 = placeholder.height;
        }
        long j4 = j2;
        if ((i2 & 4) != 0) {
            i = placeholder.placeholderVerticalAlign;
        }
        return placeholder.m1854copyK8Q__8(j3, j4, i);
    }

    @NotNull
    /* renamed from: copy-K8Q-__8, reason: not valid java name */
    public final Placeholder m1854copyK8Q__8(long j, long j2, int i) {
        return new Placeholder(j, j2, i, null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Placeholder)) {
            return false;
        }
        Placeholder placeholder = (Placeholder) obj;
        return TextUnit.m2210equalsimpl0(this.width, placeholder.width) && TextUnit.m2210equalsimpl0(this.height, placeholder.height) && PlaceholderVerticalAlign.m1861equalsimpl0(this.placeholderVerticalAlign, placeholder.placeholderVerticalAlign);
    }

    /* renamed from: getHeight-XSAIIZE, reason: not valid java name */
    public final long m1855getHeightXSAIIZE() {
        return this.height;
    }

    /* renamed from: getPlaceholderVerticalAlign-J6kI3mc, reason: not valid java name */
    public final int m1856getPlaceholderVerticalAlignJ6kI3mc() {
        return this.placeholderVerticalAlign;
    }

    /* renamed from: getWidth-XSAIIZE, reason: not valid java name */
    public final long m1857getWidthXSAIIZE() {
        return this.width;
    }

    public int hashCode() {
        return (((TextUnit.m2214hashCodeimpl(this.width) * 31) + TextUnit.m2214hashCodeimpl(this.height)) * 31) + PlaceholderVerticalAlign.m1862hashCodeimpl(this.placeholderVerticalAlign);
    }

    @NotNull
    public String toString() {
        return "Placeholder(width=" + ((Object) TextUnit.m2220toStringimpl(this.width)) + ", height=" + ((Object) TextUnit.m2220toStringimpl(this.height)) + ", placeholderVerticalAlign=" + ((Object) PlaceholderVerticalAlign.m1863toStringimpl(this.placeholderVerticalAlign)) + ')';
    }
}
