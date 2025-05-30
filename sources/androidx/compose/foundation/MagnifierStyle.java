package androidx.compose.foundation;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpSize;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.l3;

/* compiled from: Taobao */
@Stable
@ExperimentalFoundationApi
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class MagnifierStyle {

    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @NotNull
    private static final MagnifierStyle Default;

    @NotNull
    private static final MagnifierStyle TextDefault;
    private final boolean clippingEnabled;
    private final float cornerRadius;
    private final float elevation;
    private final boolean fishEyeEnabled;
    private final long size;
    private final boolean useTextDefault;

    static {
        MagnifierStyle magnifierStyle = new MagnifierStyle(0L, 0.0f, 0.0f, false, false, 31, (DefaultConstructorMarker) null);
        Default = magnifierStyle;
        TextDefault = new MagnifierStyle(true, magnifierStyle.size, magnifierStyle.cornerRadius, magnifierStyle.elevation, magnifierStyle.clippingEnabled, magnifierStyle.fishEyeEnabled, (DefaultConstructorMarker) null);
    }

    @ExperimentalFoundationApi
    public /* synthetic */ MagnifierStyle(long j, float f, float f2, boolean z, boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, f, f2, z, z2);
    }

    private MagnifierStyle(boolean z, long j, float f, float f2, boolean z2, boolean z3) {
        this.useTextDefault = z;
        this.size = j;
        this.cornerRadius = f;
        this.elevation = f2;
        this.clippingEnabled = z2;
        this.fishEyeEnabled = z3;
    }

    public /* synthetic */ MagnifierStyle(boolean z, long j, float f, float f2, boolean z2, boolean z3, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, j, f, f2, z2, z3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MagnifierStyle)) {
            return false;
        }
        MagnifierStyle magnifierStyle = (MagnifierStyle) obj;
        return this.useTextDefault == magnifierStyle.useTextDefault && DpSize.equals-impl0(this.size, magnifierStyle.size) && Dp.equals-impl0(this.cornerRadius, magnifierStyle.cornerRadius) && Dp.equals-impl0(this.elevation, magnifierStyle.elevation) && this.clippingEnabled == magnifierStyle.clippingEnabled && this.fishEyeEnabled == magnifierStyle.fishEyeEnabled;
    }

    public final boolean getClippingEnabled$foundation_release() {
        return this.clippingEnabled;
    }

    /* renamed from: getCornerRadius-D9Ej5fM$foundation_release, reason: not valid java name */
    public final float m158getCornerRadiusD9Ej5fM$foundation_release() {
        return this.cornerRadius;
    }

    /* renamed from: getElevation-D9Ej5fM$foundation_release, reason: not valid java name */
    public final float m159getElevationD9Ej5fM$foundation_release() {
        return this.elevation;
    }

    public final boolean getFishEyeEnabled$foundation_release() {
        return this.fishEyeEnabled;
    }

    /* renamed from: getSize-MYxV2XQ$foundation_release, reason: not valid java name */
    public final long m160getSizeMYxV2XQ$foundation_release() {
        return this.size;
    }

    public final boolean getUseTextDefault$foundation_release() {
        return this.useTextDefault;
    }

    public int hashCode() {
        return (((((((((l3.a(this.useTextDefault) * 31) + DpSize.hashCode-impl(this.size)) * 31) + Dp.hashCode-impl(this.cornerRadius)) * 31) + Dp.hashCode-impl(this.elevation)) * 31) + l3.a(this.clippingEnabled)) * 31) + l3.a(this.fishEyeEnabled);
    }

    public final boolean isSupported() {
        return Companion.isStyleSupported$foundation_release$default(Companion, this, 0, 2, (Object) null);
    }

    @NotNull
    public String toString() {
        if (this.useTextDefault) {
            return "MagnifierStyle.TextDefault";
        }
        return "MagnifierStyle(size=" + ((Object) DpSize.toString-impl(this.size)) + ", cornerRadius=" + ((Object) Dp.toString-impl(this.cornerRadius)) + ", elevation=" + ((Object) Dp.toString-impl(this.elevation)) + ", clippingEnabled=" + this.clippingEnabled + ", fishEyeEnabled=" + this.fishEyeEnabled + ')';
    }

    public /* synthetic */ MagnifierStyle(long j, float f, float f2, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? DpSize.Companion.m2632getUnspecifiedMYxV2XQ() : j, (i & 2) != 0 ? Dp.Companion.getUnspecified-D9Ej5fM() : f, (i & 4) != 0 ? Dp.Companion.getUnspecified-D9Ej5fM() : f2, (i & 8) != 0 ? true : z, (i & 16) != 0 ? false : z2, (DefaultConstructorMarker) null);
    }

    private MagnifierStyle(long j, float f, float f2, boolean z, boolean z2) {
        this(false, j, f, f2, z, z2, (DefaultConstructorMarker) null);
    }
}
