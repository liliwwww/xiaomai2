package androidx.compose.ui.geometry;

import androidx.compose.ui.util.MathHelpersKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class RoundRectKt {
    @NotNull
    public static final RoundRect RoundRect(float f, float f2, float f3, float f4, float f5, float f6) {
        long CornerRadius = CornerRadiusKt.CornerRadius(f5, f6);
        return new RoundRect(f, f2, f3, f4, CornerRadius, CornerRadius, CornerRadius, CornerRadius, null);
    }

    @NotNull
    /* renamed from: RoundRect-ZAM2FJo, reason: not valid java name */
    public static final RoundRect m886RoundRectZAM2FJo(@NotNull Rect rect, long j, long j2, long j3, long j4) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        return new RoundRect(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom(), j, j2, j3, j4, null);
    }

    @NotNull
    /* renamed from: RoundRect-gG7oq9Y, reason: not valid java name */
    public static final RoundRect m888RoundRectgG7oq9Y(float f, float f2, float f3, float f4, long j) {
        return RoundRect(f, f2, f3, f4, CornerRadius.getX-impl(j), CornerRadius.getY-impl(j));
    }

    @NotNull
    /* renamed from: RoundRect-sniSvfs, reason: not valid java name */
    public static final RoundRect m889RoundRectsniSvfs(@NotNull Rect rect, long j) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        return RoundRect(rect, CornerRadius.getX-impl(j), CornerRadius.getY-impl(j));
    }

    @NotNull
    public static final Rect getBoundingRect(@NotNull RoundRect roundRect) {
        Intrinsics.checkNotNullParameter(roundRect, "<this>");
        return new Rect(roundRect.getLeft(), roundRect.getTop(), roundRect.getRight(), roundRect.getBottom());
    }

    public static final long getCenter(@NotNull RoundRect roundRect) {
        Intrinsics.checkNotNullParameter(roundRect, "<this>");
        return OffsetKt.Offset(roundRect.getLeft() + (roundRect.getWidth() / 2.0f), roundRect.getTop() + (roundRect.getHeight() / 2.0f));
    }

    public static final float getMaxDimension(@NotNull RoundRect roundRect) {
        Intrinsics.checkNotNullParameter(roundRect, "<this>");
        return Math.max(Math.abs(roundRect.getWidth()), Math.abs(roundRect.getHeight()));
    }

    public static final float getMinDimension(@NotNull RoundRect roundRect) {
        Intrinsics.checkNotNullParameter(roundRect, "<this>");
        return Math.min(Math.abs(roundRect.getWidth()), Math.abs(roundRect.getHeight()));
    }

    @NotNull
    public static final Rect getSafeInnerRect(@NotNull RoundRect roundRect) {
        Intrinsics.checkNotNullParameter(roundRect, "<this>");
        return new Rect(roundRect.getLeft() + (Math.max(CornerRadius.getX-impl(roundRect.m882getBottomLeftCornerRadiuskKHJgLs()), CornerRadius.getX-impl(roundRect.m884getTopLeftCornerRadiuskKHJgLs())) * 0.29289323f), roundRect.getTop() + (Math.max(CornerRadius.getY-impl(roundRect.m884getTopLeftCornerRadiuskKHJgLs()), CornerRadius.getY-impl(roundRect.m885getTopRightCornerRadiuskKHJgLs())) * 0.29289323f), roundRect.getRight() - (Math.max(CornerRadius.getX-impl(roundRect.m885getTopRightCornerRadiuskKHJgLs()), CornerRadius.getX-impl(roundRect.m883getBottomRightCornerRadiuskKHJgLs())) * 0.29289323f), roundRect.getBottom() - (Math.max(CornerRadius.getY-impl(roundRect.m883getBottomRightCornerRadiuskKHJgLs()), CornerRadius.getY-impl(roundRect.m882getBottomLeftCornerRadiuskKHJgLs())) * 0.29289323f));
    }

    public static final boolean isCircle(@NotNull RoundRect roundRect) {
        Intrinsics.checkNotNullParameter(roundRect, "<this>");
        return ((roundRect.getWidth() > roundRect.getHeight() ? 1 : (roundRect.getWidth() == roundRect.getHeight() ? 0 : -1)) == 0) && isEllipse(roundRect);
    }

    public static final boolean isEllipse(@NotNull RoundRect roundRect) {
        Intrinsics.checkNotNullParameter(roundRect, "<this>");
        if (CornerRadius.getX-impl(roundRect.m884getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.getX-impl(roundRect.m885getTopRightCornerRadiuskKHJgLs())) {
            if (CornerRadius.getY-impl(roundRect.m884getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.getY-impl(roundRect.m885getTopRightCornerRadiuskKHJgLs())) {
                if (CornerRadius.getX-impl(roundRect.m885getTopRightCornerRadiuskKHJgLs()) == CornerRadius.getX-impl(roundRect.m883getBottomRightCornerRadiuskKHJgLs())) {
                    if (CornerRadius.getY-impl(roundRect.m885getTopRightCornerRadiuskKHJgLs()) == CornerRadius.getY-impl(roundRect.m883getBottomRightCornerRadiuskKHJgLs())) {
                        if (CornerRadius.getX-impl(roundRect.m883getBottomRightCornerRadiuskKHJgLs()) == CornerRadius.getX-impl(roundRect.m882getBottomLeftCornerRadiuskKHJgLs())) {
                            if ((CornerRadius.getY-impl(roundRect.m883getBottomRightCornerRadiuskKHJgLs()) == CornerRadius.getY-impl(roundRect.m882getBottomLeftCornerRadiuskKHJgLs())) && roundRect.getWidth() <= CornerRadius.getX-impl(roundRect.m884getTopLeftCornerRadiuskKHJgLs()) * 2.0d && roundRect.getHeight() <= CornerRadius.getY-impl(roundRect.m884getTopLeftCornerRadiuskKHJgLs()) * 2.0d) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public static final boolean isEmpty(@NotNull RoundRect roundRect) {
        Intrinsics.checkNotNullParameter(roundRect, "<this>");
        return roundRect.getLeft() >= roundRect.getRight() || roundRect.getTop() >= roundRect.getBottom();
    }

    public static final boolean isFinite(@NotNull RoundRect roundRect) {
        Intrinsics.checkNotNullParameter(roundRect, "<this>");
        float left = roundRect.getLeft();
        if ((Float.isInfinite(left) || Float.isNaN(left)) ? false : true) {
            float top = roundRect.getTop();
            if ((Float.isInfinite(top) || Float.isNaN(top)) ? false : true) {
                float right = roundRect.getRight();
                if ((Float.isInfinite(right) || Float.isNaN(right)) ? false : true) {
                    float bottom = roundRect.getBottom();
                    if ((Float.isInfinite(bottom) || Float.isNaN(bottom)) ? false : true) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x004a, code lost:
    
        if ((androidx.compose.ui.geometry.CornerRadius.getY-impl(r6.m885getTopRightCornerRadiuskKHJgLs()) == 0.0f) != false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x006c, code lost:
    
        if ((androidx.compose.ui.geometry.CornerRadius.getY-impl(r6.m882getBottomLeftCornerRadiuskKHJgLs()) == 0.0f) != false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0028, code lost:
    
        if ((androidx.compose.ui.geometry.CornerRadius.getY-impl(r6.m884getTopLeftCornerRadiuskKHJgLs()) == 0.0f) != false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean isRect(@org.jetbrains.annotations.NotNull androidx.compose.ui.geometry.RoundRect r6) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            long r0 = r6.m884getTopLeftCornerRadiuskKHJgLs()
            float r0 = androidx.compose.ui.geometry.CornerRadius.getX-impl(r0)
            r1 = 0
            r2 = 1
            r3 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L16
            r0 = 1
            goto L17
        L16:
            r0 = 0
        L17:
            if (r0 != 0) goto L2a
            long r4 = r6.m884getTopLeftCornerRadiuskKHJgLs()
            float r0 = androidx.compose.ui.geometry.CornerRadius.getY-impl(r4)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L27
            r0 = 1
            goto L28
        L27:
            r0 = 0
        L28:
            if (r0 == 0) goto L91
        L2a:
            long r4 = r6.m885getTopRightCornerRadiuskKHJgLs()
            float r0 = androidx.compose.ui.geometry.CornerRadius.getX-impl(r4)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L38
            r0 = 1
            goto L39
        L38:
            r0 = 0
        L39:
            if (r0 != 0) goto L4c
            long r4 = r6.m885getTopRightCornerRadiuskKHJgLs()
            float r0 = androidx.compose.ui.geometry.CornerRadius.getY-impl(r4)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L49
            r0 = 1
            goto L4a
        L49:
            r0 = 0
        L4a:
            if (r0 == 0) goto L91
        L4c:
            long r4 = r6.m882getBottomLeftCornerRadiuskKHJgLs()
            float r0 = androidx.compose.ui.geometry.CornerRadius.getX-impl(r4)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L5a
            r0 = 1
            goto L5b
        L5a:
            r0 = 0
        L5b:
            if (r0 != 0) goto L6e
            long r4 = r6.m882getBottomLeftCornerRadiuskKHJgLs()
            float r0 = androidx.compose.ui.geometry.CornerRadius.getY-impl(r4)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L6b
            r0 = 1
            goto L6c
        L6b:
            r0 = 0
        L6c:
            if (r0 == 0) goto L91
        L6e:
            long r4 = r6.m883getBottomRightCornerRadiuskKHJgLs()
            float r0 = androidx.compose.ui.geometry.CornerRadius.getX-impl(r4)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L7c
            r0 = 1
            goto L7d
        L7c:
            r0 = 0
        L7d:
            if (r0 != 0) goto L92
            long r4 = r6.m883getBottomRightCornerRadiuskKHJgLs()
            float r6 = androidx.compose.ui.geometry.CornerRadius.getY-impl(r4)
            int r6 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r6 != 0) goto L8d
            r6 = 1
            goto L8e
        L8d:
            r6 = 0
        L8e:
            if (r6 == 0) goto L91
            goto L92
        L91:
            r2 = 0
        L92:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.geometry.RoundRectKt.isRect(androidx.compose.ui.geometry.RoundRect):boolean");
    }

    public static final boolean isSimple(@NotNull RoundRect roundRect) {
        Intrinsics.checkNotNullParameter(roundRect, "<this>");
        if (CornerRadius.getX-impl(roundRect.m884getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.getY-impl(roundRect.m884getTopLeftCornerRadiuskKHJgLs())) {
            if (CornerRadius.getX-impl(roundRect.m884getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.getX-impl(roundRect.m885getTopRightCornerRadiuskKHJgLs())) {
                if (CornerRadius.getX-impl(roundRect.m884getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.getY-impl(roundRect.m885getTopRightCornerRadiuskKHJgLs())) {
                    if (CornerRadius.getX-impl(roundRect.m884getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.getX-impl(roundRect.m883getBottomRightCornerRadiuskKHJgLs())) {
                        if (CornerRadius.getX-impl(roundRect.m884getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.getY-impl(roundRect.m883getBottomRightCornerRadiuskKHJgLs())) {
                            if (CornerRadius.getX-impl(roundRect.m884getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.getX-impl(roundRect.m882getBottomLeftCornerRadiuskKHJgLs())) {
                                if (CornerRadius.getX-impl(roundRect.m884getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.getY-impl(roundRect.m882getBottomLeftCornerRadiuskKHJgLs())) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    @NotNull
    public static final RoundRect lerp(@NotNull RoundRect roundRect, @NotNull RoundRect roundRect2, float f) {
        Intrinsics.checkNotNullParameter(roundRect, "start");
        Intrinsics.checkNotNullParameter(roundRect2, "stop");
        return new RoundRect(MathHelpersKt.lerp(roundRect.getLeft(), roundRect2.getLeft(), f), MathHelpersKt.lerp(roundRect.getTop(), roundRect2.getTop(), f), MathHelpersKt.lerp(roundRect.getRight(), roundRect2.getRight(), f), MathHelpersKt.lerp(roundRect.getBottom(), roundRect2.getBottom(), f), CornerRadiusKt.m836lerp3Ry4LBc(roundRect.m884getTopLeftCornerRadiuskKHJgLs(), roundRect2.m884getTopLeftCornerRadiuskKHJgLs(), f), CornerRadiusKt.m836lerp3Ry4LBc(roundRect.m885getTopRightCornerRadiuskKHJgLs(), roundRect2.m885getTopRightCornerRadiuskKHJgLs(), f), CornerRadiusKt.m836lerp3Ry4LBc(roundRect.m883getBottomRightCornerRadiuskKHJgLs(), roundRect2.m883getBottomRightCornerRadiuskKHJgLs(), f), CornerRadiusKt.m836lerp3Ry4LBc(roundRect.m882getBottomLeftCornerRadiuskKHJgLs(), roundRect2.m882getBottomLeftCornerRadiuskKHJgLs(), f), null);
    }

    @NotNull
    /* renamed from: translate-Uv8p0NA, reason: not valid java name */
    public static final RoundRect m890translateUv8p0NA(@NotNull RoundRect roundRect, long j) {
        Intrinsics.checkNotNullParameter(roundRect, "$this$translate");
        return new RoundRect(roundRect.getLeft() + Offset.m848getXimpl(j), roundRect.getTop() + Offset.m849getYimpl(j), roundRect.getRight() + Offset.m848getXimpl(j), roundRect.getBottom() + Offset.m849getYimpl(j), roundRect.m884getTopLeftCornerRadiuskKHJgLs(), roundRect.m885getTopRightCornerRadiuskKHJgLs(), roundRect.m883getBottomRightCornerRadiuskKHJgLs(), roundRect.m882getBottomLeftCornerRadiuskKHJgLs(), null);
    }

    @NotNull
    public static final RoundRect RoundRect(@NotNull Rect rect, float f, float f2) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        return RoundRect(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom(), f, f2);
    }
}
