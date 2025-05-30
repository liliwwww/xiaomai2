package androidx.compose.foundation.layout;

import androidx.compose.p004ui.unit.C0856Dp;
import androidx.compose.p004ui.unit.LayoutDirection;
import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Stable
/* loaded from: classes.dex */
public interface PaddingValues {
    /* renamed from: calculateBottomPadding-D9Ej5fM */
    float mo1374calculateBottomPaddingD9Ej5fM();

    /* renamed from: calculateLeftPadding-u2uoSUM */
    float mo1375calculateLeftPaddingu2uoSUM(@NotNull LayoutDirection layoutDirection);

    /* renamed from: calculateRightPadding-u2uoSUM */
    float mo1376calculateRightPaddingu2uoSUM(@NotNull LayoutDirection layoutDirection);

    /* renamed from: calculateTopPadding-D9Ej5fM */
    float mo1377calculateTopPaddingD9Ej5fM();

    /* compiled from: Taobao */
    @Immutable
    /* loaded from: classes2.dex */
    public static final class Absolute implements PaddingValues {
        private final float bottom;
        private final float left;
        private final float right;
        private final float top;

        private Absolute(float f, float f2, float f3, float f4) {
            this.left = f;
            this.top = f2;
            this.right = f3;
            this.bottom = f4;
        }

        public /* synthetic */ Absolute(float f, float f2, float f3, float f4, DefaultConstructorMarker defaultConstructorMarker) {
            this(f, f2, f3, f4);
        }

        @Stable
        /* renamed from: getBottom-D9Ej5fM$annotations, reason: not valid java name */
        private static /* synthetic */ void m1403getBottomD9Ej5fM$annotations() {
        }

        @Stable
        /* renamed from: getLeft-D9Ej5fM$annotations, reason: not valid java name */
        private static /* synthetic */ void m1404getLeftD9Ej5fM$annotations() {
        }

        @Stable
        /* renamed from: getRight-D9Ej5fM$annotations, reason: not valid java name */
        private static /* synthetic */ void m1405getRightD9Ej5fM$annotations() {
        }

        @Stable
        /* renamed from: getTop-D9Ej5fM$annotations, reason: not valid java name */
        private static /* synthetic */ void m1406getTopD9Ej5fM$annotations() {
        }

        @Override // androidx.compose.foundation.layout.PaddingValues
        /* renamed from: calculateBottomPadding-D9Ej5fM */
        public float mo1374calculateBottomPaddingD9Ej5fM() {
            return this.bottom;
        }

        @Override // androidx.compose.foundation.layout.PaddingValues
        /* renamed from: calculateLeftPadding-u2uoSUM */
        public float mo1375calculateLeftPaddingu2uoSUM(@NotNull LayoutDirection layoutDirection) {
            Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
            return this.left;
        }

        @Override // androidx.compose.foundation.layout.PaddingValues
        /* renamed from: calculateRightPadding-u2uoSUM */
        public float mo1376calculateRightPaddingu2uoSUM(@NotNull LayoutDirection layoutDirection) {
            Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
            return this.right;
        }

        @Override // androidx.compose.foundation.layout.PaddingValues
        /* renamed from: calculateTopPadding-D9Ej5fM */
        public float mo1377calculateTopPaddingD9Ej5fM() {
            return this.top;
        }

        public boolean equals(@Nullable Object obj) {
            if (!(obj instanceof Absolute)) {
                return false;
            }
            Absolute absolute = (Absolute) obj;
            return C0856Dp.m5221equalsimpl0(this.left, absolute.left) && C0856Dp.m5221equalsimpl0(this.top, absolute.top) && C0856Dp.m5221equalsimpl0(this.right, absolute.right) && C0856Dp.m5221equalsimpl0(this.bottom, absolute.bottom);
        }

        public int hashCode() {
            return (((((C0856Dp.m5222hashCodeimpl(this.left) * 31) + C0856Dp.m5222hashCodeimpl(this.top)) * 31) + C0856Dp.m5222hashCodeimpl(this.right)) * 31) + C0856Dp.m5222hashCodeimpl(this.bottom);
        }

        @NotNull
        public String toString() {
            return "PaddingValues.Absolute(left=" + ((Object) C0856Dp.m5227toStringimpl(this.left)) + ", top=" + ((Object) C0856Dp.m5227toStringimpl(this.top)) + ", right=" + ((Object) C0856Dp.m5227toStringimpl(this.right)) + ", bottom=" + ((Object) C0856Dp.m5227toStringimpl(this.bottom)) + ')';
        }

        public /* synthetic */ Absolute(float f, float f2, float f3, float f4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? C0856Dp.m5216constructorimpl(0) : f, (i & 2) != 0 ? C0856Dp.m5216constructorimpl(0) : f2, (i & 4) != 0 ? C0856Dp.m5216constructorimpl(0) : f3, (i & 8) != 0 ? C0856Dp.m5216constructorimpl(0) : f4, null);
        }
    }
}
