package androidx.compose.foundation.layout;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Immutable
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class PaddingValues$Absolute implements PaddingValues {
    private final float bottom;
    private final float left;
    private final float right;
    private final float top;

    private PaddingValues$Absolute(float f, float f2, float f3, float f4) {
        this.left = f;
        this.top = f2;
        this.right = f3;
        this.bottom = f4;
    }

    public /* synthetic */ PaddingValues$Absolute(float f, float f2, float f3, float f4, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, f3, f4);
    }

    @Stable
    /* renamed from: getBottom-D9Ej5fM$annotations, reason: not valid java name */
    private static /* synthetic */ void m341getBottomD9Ej5fM$annotations() {
    }

    @Stable
    /* renamed from: getLeft-D9Ej5fM$annotations, reason: not valid java name */
    private static /* synthetic */ void m342getLeftD9Ej5fM$annotations() {
    }

    @Stable
    /* renamed from: getRight-D9Ej5fM$annotations, reason: not valid java name */
    private static /* synthetic */ void m343getRightD9Ej5fM$annotations() {
    }

    @Stable
    /* renamed from: getTop-D9Ej5fM$annotations, reason: not valid java name */
    private static /* synthetic */ void m344getTopD9Ej5fM$annotations() {
    }

    /* renamed from: calculateBottomPadding-D9Ej5fM, reason: not valid java name */
    public float m345calculateBottomPaddingD9Ej5fM() {
        return this.bottom;
    }

    /* renamed from: calculateLeftPadding-u2uoSUM, reason: not valid java name */
    public float m346calculateLeftPaddingu2uoSUM(@NotNull LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        return this.left;
    }

    /* renamed from: calculateRightPadding-u2uoSUM, reason: not valid java name */
    public float m347calculateRightPaddingu2uoSUM(@NotNull LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        return this.right;
    }

    /* renamed from: calculateTopPadding-D9Ej5fM, reason: not valid java name */
    public float m348calculateTopPaddingD9Ej5fM() {
        return this.top;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof PaddingValues$Absolute)) {
            return false;
        }
        PaddingValues$Absolute paddingValues$Absolute = (PaddingValues$Absolute) obj;
        return Dp.equals-impl0(this.left, paddingValues$Absolute.left) && Dp.equals-impl0(this.top, paddingValues$Absolute.top) && Dp.equals-impl0(this.right, paddingValues$Absolute.right) && Dp.equals-impl0(this.bottom, paddingValues$Absolute.bottom);
    }

    public int hashCode() {
        return (((((Dp.hashCode-impl(this.left) * 31) + Dp.hashCode-impl(this.top)) * 31) + Dp.hashCode-impl(this.right)) * 31) + Dp.hashCode-impl(this.bottom);
    }

    @NotNull
    public String toString() {
        return "PaddingValues.Absolute(left=" + ((Object) Dp.toString-impl(this.left)) + ", top=" + ((Object) Dp.toString-impl(this.top)) + ", right=" + ((Object) Dp.toString-impl(this.right)) + ", bottom=" + ((Object) Dp.toString-impl(this.bottom)) + ')';
    }

    public /* synthetic */ PaddingValues$Absolute(float f, float f2, float f3, float f4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Dp.constructor-impl(0) : f, (i & 2) != 0 ? Dp.constructor-impl(0) : f2, (i & 4) != 0 ? Dp.constructor-impl(0) : f3, (i & 8) != 0 ? Dp.constructor-impl(0) : f4, null);
    }
}
