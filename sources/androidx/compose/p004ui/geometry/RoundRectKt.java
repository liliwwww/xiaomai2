package androidx.compose.p004ui.geometry;

import android.taobao.windvane.extra.p002uc.AliRequestAdapter;
import androidx.compose.p004ui.util.MathHelpersKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class RoundRectKt {
    @NotNull
    public static final RoundRect RoundRect(float f, float f2, float f3, float f4, float f5, float f6) {
        long CornerRadius = CornerRadiusKt.CornerRadius(f5, f6);
        return new RoundRect(f, f2, f3, f4, CornerRadius, CornerRadius, CornerRadius, CornerRadius, null);
    }

    @NotNull
    /* renamed from: RoundRect-ZAM2FJo, reason: not valid java name */
    public static final RoundRect m2608RoundRectZAM2FJo(@NotNull Rect rect, long j, long j2, long j3, long j4) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        return new RoundRect(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom(), j, j2, j3, j4, null);
    }

    @NotNull
    /* renamed from: RoundRect-gG7oq9Y, reason: not valid java name */
    public static final RoundRect m2610RoundRectgG7oq9Y(float f, float f2, float f3, float f4, long j) {
        return RoundRect(f, f2, f3, f4, CornerRadius.m2531getXimpl(j), CornerRadius.m2532getYimpl(j));
    }

    @NotNull
    /* renamed from: RoundRect-sniSvfs, reason: not valid java name */
    public static final RoundRect m2611RoundRectsniSvfs(@NotNull Rect rect, long j) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        return RoundRect(rect, CornerRadius.m2531getXimpl(j), CornerRadius.m2532getYimpl(j));
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
        return new Rect(roundRect.getLeft() + (Math.max(CornerRadius.m2531getXimpl(roundRect.m2604getBottomLeftCornerRadiuskKHJgLs()), CornerRadius.m2531getXimpl(roundRect.m2606getTopLeftCornerRadiuskKHJgLs())) * 0.29289323f), roundRect.getTop() + (Math.max(CornerRadius.m2532getYimpl(roundRect.m2606getTopLeftCornerRadiuskKHJgLs()), CornerRadius.m2532getYimpl(roundRect.m2607getTopRightCornerRadiuskKHJgLs())) * 0.29289323f), roundRect.getRight() - (Math.max(CornerRadius.m2531getXimpl(roundRect.m2607getTopRightCornerRadiuskKHJgLs()), CornerRadius.m2531getXimpl(roundRect.m2605getBottomRightCornerRadiuskKHJgLs())) * 0.29289323f), roundRect.getBottom() - (Math.max(CornerRadius.m2532getYimpl(roundRect.m2605getBottomRightCornerRadiuskKHJgLs()), CornerRadius.m2532getYimpl(roundRect.m2604getBottomLeftCornerRadiuskKHJgLs())) * 0.29289323f));
    }

    public static final boolean isCircle(@NotNull RoundRect roundRect) {
        Intrinsics.checkNotNullParameter(roundRect, "<this>");
        return ((roundRect.getWidth() > roundRect.getHeight() ? 1 : (roundRect.getWidth() == roundRect.getHeight() ? 0 : -1)) == 0) && isEllipse(roundRect);
    }

    public static final boolean isEllipse(@NotNull RoundRect roundRect) {
        Intrinsics.checkNotNullParameter(roundRect, "<this>");
        if (CornerRadius.m2531getXimpl(roundRect.m2606getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m2531getXimpl(roundRect.m2607getTopRightCornerRadiuskKHJgLs())) {
            if (CornerRadius.m2532getYimpl(roundRect.m2606getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m2532getYimpl(roundRect.m2607getTopRightCornerRadiuskKHJgLs())) {
                if (CornerRadius.m2531getXimpl(roundRect.m2607getTopRightCornerRadiuskKHJgLs()) == CornerRadius.m2531getXimpl(roundRect.m2605getBottomRightCornerRadiuskKHJgLs())) {
                    if (CornerRadius.m2532getYimpl(roundRect.m2607getTopRightCornerRadiuskKHJgLs()) == CornerRadius.m2532getYimpl(roundRect.m2605getBottomRightCornerRadiuskKHJgLs())) {
                        if (CornerRadius.m2531getXimpl(roundRect.m2605getBottomRightCornerRadiuskKHJgLs()) == CornerRadius.m2531getXimpl(roundRect.m2604getBottomLeftCornerRadiuskKHJgLs())) {
                            if ((CornerRadius.m2532getYimpl(roundRect.m2605getBottomRightCornerRadiuskKHJgLs()) == CornerRadius.m2532getYimpl(roundRect.m2604getBottomLeftCornerRadiuskKHJgLs())) && roundRect.getWidth() <= CornerRadius.m2531getXimpl(roundRect.m2606getTopLeftCornerRadiuskKHJgLs()) * 2.0d && roundRect.getHeight() <= CornerRadius.m2532getYimpl(roundRect.m2606getTopLeftCornerRadiuskKHJgLs()) * 2.0d) {
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
    
        if ((androidx.compose.p004ui.geometry.CornerRadius.m2532getYimpl(r6.m2607getTopRightCornerRadiuskKHJgLs()) == 0.0f) != false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x006c, code lost:
    
        if ((androidx.compose.p004ui.geometry.CornerRadius.m2532getYimpl(r6.m2604getBottomLeftCornerRadiuskKHJgLs()) == 0.0f) != false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0028, code lost:
    
        if ((androidx.compose.p004ui.geometry.CornerRadius.m2532getYimpl(r6.m2606getTopLeftCornerRadiuskKHJgLs()) == 0.0f) != false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final boolean isRect(@org.jetbrains.annotations.NotNull androidx.compose.p004ui.geometry.RoundRect r6) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            long r0 = r6.m2606getTopLeftCornerRadiuskKHJgLs()
            float r0 = androidx.compose.p004ui.geometry.CornerRadius.m2531getXimpl(r0)
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
            long r4 = r6.m2606getTopLeftCornerRadiuskKHJgLs()
            float r0 = androidx.compose.p004ui.geometry.CornerRadius.m2532getYimpl(r4)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L27
            r0 = 1
            goto L28
        L27:
            r0 = 0
        L28:
            if (r0 == 0) goto L91
        L2a:
            long r4 = r6.m2607getTopRightCornerRadiuskKHJgLs()
            float r0 = androidx.compose.p004ui.geometry.CornerRadius.m2531getXimpl(r4)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L38
            r0 = 1
            goto L39
        L38:
            r0 = 0
        L39:
            if (r0 != 0) goto L4c
            long r4 = r6.m2607getTopRightCornerRadiuskKHJgLs()
            float r0 = androidx.compose.p004ui.geometry.CornerRadius.m2532getYimpl(r4)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L49
            r0 = 1
            goto L4a
        L49:
            r0 = 0
        L4a:
            if (r0 == 0) goto L91
        L4c:
            long r4 = r6.m2604getBottomLeftCornerRadiuskKHJgLs()
            float r0 = androidx.compose.p004ui.geometry.CornerRadius.m2531getXimpl(r4)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L5a
            r0 = 1
            goto L5b
        L5a:
            r0 = 0
        L5b:
            if (r0 != 0) goto L6e
            long r4 = r6.m2604getBottomLeftCornerRadiuskKHJgLs()
            float r0 = androidx.compose.p004ui.geometry.CornerRadius.m2532getYimpl(r4)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L6b
            r0 = 1
            goto L6c
        L6b:
            r0 = 0
        L6c:
            if (r0 == 0) goto L91
        L6e:
            long r4 = r6.m2605getBottomRightCornerRadiuskKHJgLs()
            float r0 = androidx.compose.p004ui.geometry.CornerRadius.m2531getXimpl(r4)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L7c
            r0 = 1
            goto L7d
        L7c:
            r0 = 0
        L7d:
            if (r0 != 0) goto L92
            long r4 = r6.m2605getBottomRightCornerRadiuskKHJgLs()
            float r6 = androidx.compose.p004ui.geometry.CornerRadius.m2532getYimpl(r4)
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
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.p004ui.geometry.RoundRectKt.isRect(androidx.compose.ui.geometry.RoundRect):boolean");
    }

    public static final boolean isSimple(@NotNull RoundRect roundRect) {
        Intrinsics.checkNotNullParameter(roundRect, "<this>");
        if (CornerRadius.m2531getXimpl(roundRect.m2606getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m2532getYimpl(roundRect.m2606getTopLeftCornerRadiuskKHJgLs())) {
            if (CornerRadius.m2531getXimpl(roundRect.m2606getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m2531getXimpl(roundRect.m2607getTopRightCornerRadiuskKHJgLs())) {
                if (CornerRadius.m2531getXimpl(roundRect.m2606getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m2532getYimpl(roundRect.m2607getTopRightCornerRadiuskKHJgLs())) {
                    if (CornerRadius.m2531getXimpl(roundRect.m2606getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m2531getXimpl(roundRect.m2605getBottomRightCornerRadiuskKHJgLs())) {
                        if (CornerRadius.m2531getXimpl(roundRect.m2606getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m2532getYimpl(roundRect.m2605getBottomRightCornerRadiuskKHJgLs())) {
                            if (CornerRadius.m2531getXimpl(roundRect.m2606getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m2531getXimpl(roundRect.m2604getBottomLeftCornerRadiuskKHJgLs())) {
                                if (CornerRadius.m2531getXimpl(roundRect.m2606getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m2532getYimpl(roundRect.m2604getBottomLeftCornerRadiuskKHJgLs())) {
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
        Intrinsics.checkNotNullParameter(roundRect2, AliRequestAdapter.PHASE_STOP);
        return new RoundRect(MathHelpersKt.lerp(roundRect.getLeft(), roundRect2.getLeft(), f), MathHelpersKt.lerp(roundRect.getTop(), roundRect2.getTop(), f), MathHelpersKt.lerp(roundRect.getRight(), roundRect2.getRight(), f), MathHelpersKt.lerp(roundRect.getBottom(), roundRect2.getBottom(), f), CornerRadiusKt.m2542lerp3Ry4LBc(roundRect.m2606getTopLeftCornerRadiuskKHJgLs(), roundRect2.m2606getTopLeftCornerRadiuskKHJgLs(), f), CornerRadiusKt.m2542lerp3Ry4LBc(roundRect.m2607getTopRightCornerRadiuskKHJgLs(), roundRect2.m2607getTopRightCornerRadiuskKHJgLs(), f), CornerRadiusKt.m2542lerp3Ry4LBc(roundRect.m2605getBottomRightCornerRadiuskKHJgLs(), roundRect2.m2605getBottomRightCornerRadiuskKHJgLs(), f), CornerRadiusKt.m2542lerp3Ry4LBc(roundRect.m2604getBottomLeftCornerRadiuskKHJgLs(), roundRect2.m2604getBottomLeftCornerRadiuskKHJgLs(), f), null);
    }

    @NotNull
    /* renamed from: translate-Uv8p0NA, reason: not valid java name */
    public static final RoundRect m2612translateUv8p0NA(@NotNull RoundRect roundRect, long j) {
        Intrinsics.checkNotNullParameter(roundRect, "$this$translate");
        return new RoundRect(roundRect.getLeft() + Offset.m2556getXimpl(j), roundRect.getTop() + Offset.m2557getYimpl(j), roundRect.getRight() + Offset.m2556getXimpl(j), roundRect.getBottom() + Offset.m2557getYimpl(j), roundRect.m2606getTopLeftCornerRadiuskKHJgLs(), roundRect.m2607getTopRightCornerRadiuskKHJgLs(), roundRect.m2605getBottomRightCornerRadiuskKHJgLs(), roundRect.m2604getBottomLeftCornerRadiuskKHJgLs(), null);
    }

    @NotNull
    public static final RoundRect RoundRect(@NotNull Rect rect, float f, float f2) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        return RoundRect(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom(), f, f2);
    }
}
