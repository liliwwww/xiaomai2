package androidx.compose.p004ui.graphics.vector;

import androidx.compose.runtime.Immutable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Immutable
/* loaded from: classes.dex */
public abstract class PathNode {
    private final boolean isCurve;
    private final boolean isQuad;

    /* compiled from: Taobao */
    @Immutable
    /* loaded from: classes2.dex */
    public static final class ArcTo extends PathNode {
        private final float arcStartX;
        private final float arcStartY;
        private final float horizontalEllipseRadius;
        private final boolean isMoreThanHalf;
        private final boolean isPositiveArc;
        private final float theta;
        private final float verticalEllipseRadius;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public ArcTo(float r4, float r5, float r6, boolean r7, boolean r8, float r9, float r10) {
            /*
                r3 = this;
                r0 = 0
                r1 = 3
                r2 = 0
                r3.<init>(r0, r0, r1, r2)
                r3.horizontalEllipseRadius = r4
                r3.verticalEllipseRadius = r5
                r3.theta = r6
                r3.isMoreThanHalf = r7
                r3.isPositiveArc = r8
                r3.arcStartX = r9
                r3.arcStartY = r10
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.vector.PathNode.ArcTo.<init>(float, float, float, boolean, boolean, float, float):void");
        }

        public static /* synthetic */ ArcTo copy$default(ArcTo arcTo, float f, float f2, float f3, boolean z, boolean z2, float f4, float f5, int i, Object obj) {
            if ((i & 1) != 0) {
                f = arcTo.horizontalEllipseRadius;
            }
            if ((i & 2) != 0) {
                f2 = arcTo.verticalEllipseRadius;
            }
            float f6 = f2;
            if ((i & 4) != 0) {
                f3 = arcTo.theta;
            }
            float f7 = f3;
            if ((i & 8) != 0) {
                z = arcTo.isMoreThanHalf;
            }
            boolean z3 = z;
            if ((i & 16) != 0) {
                z2 = arcTo.isPositiveArc;
            }
            boolean z4 = z2;
            if ((i & 32) != 0) {
                f4 = arcTo.arcStartX;
            }
            float f8 = f4;
            if ((i & 64) != 0) {
                f5 = arcTo.arcStartY;
            }
            return arcTo.copy(f, f6, f7, z3, z4, f8, f5);
        }

        public final float component1() {
            return this.horizontalEllipseRadius;
        }

        public final float component2() {
            return this.verticalEllipseRadius;
        }

        public final float component3() {
            return this.theta;
        }

        public final boolean component4() {
            return this.isMoreThanHalf;
        }

        public final boolean component5() {
            return this.isPositiveArc;
        }

        public final float component6() {
            return this.arcStartX;
        }

        public final float component7() {
            return this.arcStartY;
        }

        @NotNull
        public final ArcTo copy(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5) {
            return new ArcTo(f, f2, f3, z, z2, f4, f5);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ArcTo)) {
                return false;
            }
            ArcTo arcTo = (ArcTo) obj;
            return Float.compare(this.horizontalEllipseRadius, arcTo.horizontalEllipseRadius) == 0 && Float.compare(this.verticalEllipseRadius, arcTo.verticalEllipseRadius) == 0 && Float.compare(this.theta, arcTo.theta) == 0 && this.isMoreThanHalf == arcTo.isMoreThanHalf && this.isPositiveArc == arcTo.isPositiveArc && Float.compare(this.arcStartX, arcTo.arcStartX) == 0 && Float.compare(this.arcStartY, arcTo.arcStartY) == 0;
        }

        public final float getArcStartX() {
            return this.arcStartX;
        }

        public final float getArcStartY() {
            return this.arcStartY;
        }

        public final float getHorizontalEllipseRadius() {
            return this.horizontalEllipseRadius;
        }

        public final float getTheta() {
            return this.theta;
        }

        public final float getVerticalEllipseRadius() {
            return this.verticalEllipseRadius;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int floatToIntBits = ((((Float.floatToIntBits(this.horizontalEllipseRadius) * 31) + Float.floatToIntBits(this.verticalEllipseRadius)) * 31) + Float.floatToIntBits(this.theta)) * 31;
            boolean z = this.isMoreThanHalf;
            int i = z;
            if (z != 0) {
                i = 1;
            }
            int i2 = (floatToIntBits + i) * 31;
            boolean z2 = this.isPositiveArc;
            return ((((i2 + (z2 ? 1 : z2 ? 1 : 0)) * 31) + Float.floatToIntBits(this.arcStartX)) * 31) + Float.floatToIntBits(this.arcStartY);
        }

        public final boolean isMoreThanHalf() {
            return this.isMoreThanHalf;
        }

        public final boolean isPositiveArc() {
            return this.isPositiveArc;
        }

        @NotNull
        public String toString() {
            return "ArcTo(horizontalEllipseRadius=" + this.horizontalEllipseRadius + ", verticalEllipseRadius=" + this.verticalEllipseRadius + ", theta=" + this.theta + ", isMoreThanHalf=" + this.isMoreThanHalf + ", isPositiveArc=" + this.isPositiveArc + ", arcStartX=" + this.arcStartX + ", arcStartY=" + this.arcStartY + ')';
        }
    }

    /* compiled from: Taobao */
    @Immutable
    /* loaded from: classes2.dex */
    public static final class Close extends PathNode {

        @NotNull
        public static final Close INSTANCE = new Close();

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private Close() {
            /*
                r3 = this;
                r0 = 0
                r1 = 3
                r2 = 0
                r3.<init>(r0, r0, r1, r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.vector.PathNode.Close.<init>():void");
        }
    }

    /* compiled from: Taobao */
    @Immutable
    /* loaded from: classes2.dex */
    public static final class CurveTo extends PathNode {

        /* renamed from: x1 */
        private final float f130x1;

        /* renamed from: x2 */
        private final float f131x2;

        /* renamed from: x3 */
        private final float f132x3;

        /* renamed from: y1 */
        private final float f133y1;

        /* renamed from: y2 */
        private final float f134y2;

        /* renamed from: y3 */
        private final float f135y3;

        public CurveTo(float f, float f2, float f3, float f4, float f5, float f6) {
            super(true, false, 2, null);
            this.f130x1 = f;
            this.f133y1 = f2;
            this.f131x2 = f3;
            this.f134y2 = f4;
            this.f132x3 = f5;
            this.f135y3 = f6;
        }

        public static /* synthetic */ CurveTo copy$default(CurveTo curveTo, float f, float f2, float f3, float f4, float f5, float f6, int i, Object obj) {
            if ((i & 1) != 0) {
                f = curveTo.f130x1;
            }
            if ((i & 2) != 0) {
                f2 = curveTo.f133y1;
            }
            float f7 = f2;
            if ((i & 4) != 0) {
                f3 = curveTo.f131x2;
            }
            float f8 = f3;
            if ((i & 8) != 0) {
                f4 = curveTo.f134y2;
            }
            float f9 = f4;
            if ((i & 16) != 0) {
                f5 = curveTo.f132x3;
            }
            float f10 = f5;
            if ((i & 32) != 0) {
                f6 = curveTo.f135y3;
            }
            return curveTo.copy(f, f7, f8, f9, f10, f6);
        }

        public final float component1() {
            return this.f130x1;
        }

        public final float component2() {
            return this.f133y1;
        }

        public final float component3() {
            return this.f131x2;
        }

        public final float component4() {
            return this.f134y2;
        }

        public final float component5() {
            return this.f132x3;
        }

        public final float component6() {
            return this.f135y3;
        }

        @NotNull
        public final CurveTo copy(float f, float f2, float f3, float f4, float f5, float f6) {
            return new CurveTo(f, f2, f3, f4, f5, f6);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CurveTo)) {
                return false;
            }
            CurveTo curveTo = (CurveTo) obj;
            return Float.compare(this.f130x1, curveTo.f130x1) == 0 && Float.compare(this.f133y1, curveTo.f133y1) == 0 && Float.compare(this.f131x2, curveTo.f131x2) == 0 && Float.compare(this.f134y2, curveTo.f134y2) == 0 && Float.compare(this.f132x3, curveTo.f132x3) == 0 && Float.compare(this.f135y3, curveTo.f135y3) == 0;
        }

        public final float getX1() {
            return this.f130x1;
        }

        public final float getX2() {
            return this.f131x2;
        }

        public final float getX3() {
            return this.f132x3;
        }

        public final float getY1() {
            return this.f133y1;
        }

        public final float getY2() {
            return this.f134y2;
        }

        public final float getY3() {
            return this.f135y3;
        }

        public int hashCode() {
            return (((((((((Float.floatToIntBits(this.f130x1) * 31) + Float.floatToIntBits(this.f133y1)) * 31) + Float.floatToIntBits(this.f131x2)) * 31) + Float.floatToIntBits(this.f134y2)) * 31) + Float.floatToIntBits(this.f132x3)) * 31) + Float.floatToIntBits(this.f135y3);
        }

        @NotNull
        public String toString() {
            return "CurveTo(x1=" + this.f130x1 + ", y1=" + this.f133y1 + ", x2=" + this.f131x2 + ", y2=" + this.f134y2 + ", x3=" + this.f132x3 + ", y3=" + this.f135y3 + ')';
        }
    }

    /* compiled from: Taobao */
    @Immutable
    public static final class HorizontalTo extends PathNode {

        /* renamed from: x */
        private final float f136x;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public HorizontalTo(float r4) {
            /*
                r3 = this;
                r0 = 0
                r1 = 3
                r2 = 0
                r3.<init>(r0, r0, r1, r2)
                r3.f136x = r4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.vector.PathNode.HorizontalTo.<init>(float):void");
        }

        public static /* synthetic */ HorizontalTo copy$default(HorizontalTo horizontalTo, float f, int i, Object obj) {
            if ((i & 1) != 0) {
                f = horizontalTo.f136x;
            }
            return horizontalTo.copy(f);
        }

        public final float component1() {
            return this.f136x;
        }

        @NotNull
        public final HorizontalTo copy(float f) {
            return new HorizontalTo(f);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof HorizontalTo) && Float.compare(this.f136x, ((HorizontalTo) obj).f136x) == 0;
        }

        public final float getX() {
            return this.f136x;
        }

        public int hashCode() {
            return Float.floatToIntBits(this.f136x);
        }

        @NotNull
        public String toString() {
            return "HorizontalTo(x=" + this.f136x + ')';
        }
    }

    /* compiled from: Taobao */
    @Immutable
    /* loaded from: classes2.dex */
    public static final class LineTo extends PathNode {

        /* renamed from: x */
        private final float f137x;

        /* renamed from: y */
        private final float f138y;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public LineTo(float r4, float r5) {
            /*
                r3 = this;
                r0 = 0
                r1 = 3
                r2 = 0
                r3.<init>(r0, r0, r1, r2)
                r3.f137x = r4
                r3.f138y = r5
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.vector.PathNode.LineTo.<init>(float, float):void");
        }

        public static /* synthetic */ LineTo copy$default(LineTo lineTo, float f, float f2, int i, Object obj) {
            if ((i & 1) != 0) {
                f = lineTo.f137x;
            }
            if ((i & 2) != 0) {
                f2 = lineTo.f138y;
            }
            return lineTo.copy(f, f2);
        }

        public final float component1() {
            return this.f137x;
        }

        public final float component2() {
            return this.f138y;
        }

        @NotNull
        public final LineTo copy(float f, float f2) {
            return new LineTo(f, f2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LineTo)) {
                return false;
            }
            LineTo lineTo = (LineTo) obj;
            return Float.compare(this.f137x, lineTo.f137x) == 0 && Float.compare(this.f138y, lineTo.f138y) == 0;
        }

        public final float getX() {
            return this.f137x;
        }

        public final float getY() {
            return this.f138y;
        }

        public int hashCode() {
            return (Float.floatToIntBits(this.f137x) * 31) + Float.floatToIntBits(this.f138y);
        }

        @NotNull
        public String toString() {
            return "LineTo(x=" + this.f137x + ", y=" + this.f138y + ')';
        }
    }

    /* compiled from: Taobao */
    @Immutable
    public static final class MoveTo extends PathNode {

        /* renamed from: x */
        private final float f139x;

        /* renamed from: y */
        private final float f140y;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public MoveTo(float r4, float r5) {
            /*
                r3 = this;
                r0 = 0
                r1 = 3
                r2 = 0
                r3.<init>(r0, r0, r1, r2)
                r3.f139x = r4
                r3.f140y = r5
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.vector.PathNode.MoveTo.<init>(float, float):void");
        }

        public static /* synthetic */ MoveTo copy$default(MoveTo moveTo, float f, float f2, int i, Object obj) {
            if ((i & 1) != 0) {
                f = moveTo.f139x;
            }
            if ((i & 2) != 0) {
                f2 = moveTo.f140y;
            }
            return moveTo.copy(f, f2);
        }

        public final float component1() {
            return this.f139x;
        }

        public final float component2() {
            return this.f140y;
        }

        @NotNull
        public final MoveTo copy(float f, float f2) {
            return new MoveTo(f, f2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MoveTo)) {
                return false;
            }
            MoveTo moveTo = (MoveTo) obj;
            return Float.compare(this.f139x, moveTo.f139x) == 0 && Float.compare(this.f140y, moveTo.f140y) == 0;
        }

        public final float getX() {
            return this.f139x;
        }

        public final float getY() {
            return this.f140y;
        }

        public int hashCode() {
            return (Float.floatToIntBits(this.f139x) * 31) + Float.floatToIntBits(this.f140y);
        }

        @NotNull
        public String toString() {
            return "MoveTo(x=" + this.f139x + ", y=" + this.f140y + ')';
        }
    }

    /* compiled from: Taobao */
    @Immutable
    public static final class QuadTo extends PathNode {

        /* renamed from: x1 */
        private final float f141x1;

        /* renamed from: x2 */
        private final float f142x2;

        /* renamed from: y1 */
        private final float f143y1;

        /* renamed from: y2 */
        private final float f144y2;

        public QuadTo(float f, float f2, float f3, float f4) {
            super(false, true, true ? 1 : 0, null);
            this.f141x1 = f;
            this.f143y1 = f2;
            this.f142x2 = f3;
            this.f144y2 = f4;
        }

        public static /* synthetic */ QuadTo copy$default(QuadTo quadTo, float f, float f2, float f3, float f4, int i, Object obj) {
            if ((i & 1) != 0) {
                f = quadTo.f141x1;
            }
            if ((i & 2) != 0) {
                f2 = quadTo.f143y1;
            }
            if ((i & 4) != 0) {
                f3 = quadTo.f142x2;
            }
            if ((i & 8) != 0) {
                f4 = quadTo.f144y2;
            }
            return quadTo.copy(f, f2, f3, f4);
        }

        public final float component1() {
            return this.f141x1;
        }

        public final float component2() {
            return this.f143y1;
        }

        public final float component3() {
            return this.f142x2;
        }

        public final float component4() {
            return this.f144y2;
        }

        @NotNull
        public final QuadTo copy(float f, float f2, float f3, float f4) {
            return new QuadTo(f, f2, f3, f4);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof QuadTo)) {
                return false;
            }
            QuadTo quadTo = (QuadTo) obj;
            return Float.compare(this.f141x1, quadTo.f141x1) == 0 && Float.compare(this.f143y1, quadTo.f143y1) == 0 && Float.compare(this.f142x2, quadTo.f142x2) == 0 && Float.compare(this.f144y2, quadTo.f144y2) == 0;
        }

        public final float getX1() {
            return this.f141x1;
        }

        public final float getX2() {
            return this.f142x2;
        }

        public final float getY1() {
            return this.f143y1;
        }

        public final float getY2() {
            return this.f144y2;
        }

        public int hashCode() {
            return (((((Float.floatToIntBits(this.f141x1) * 31) + Float.floatToIntBits(this.f143y1)) * 31) + Float.floatToIntBits(this.f142x2)) * 31) + Float.floatToIntBits(this.f144y2);
        }

        @NotNull
        public String toString() {
            return "QuadTo(x1=" + this.f141x1 + ", y1=" + this.f143y1 + ", x2=" + this.f142x2 + ", y2=" + this.f144y2 + ')';
        }
    }

    /* compiled from: Taobao */
    @Immutable
    /* loaded from: classes2.dex */
    public static final class ReflectiveCurveTo extends PathNode {

        /* renamed from: x1 */
        private final float f145x1;

        /* renamed from: x2 */
        private final float f146x2;

        /* renamed from: y1 */
        private final float f147y1;

        /* renamed from: y2 */
        private final float f148y2;

        public ReflectiveCurveTo(float f, float f2, float f3, float f4) {
            super(true, false, 2, null);
            this.f145x1 = f;
            this.f147y1 = f2;
            this.f146x2 = f3;
            this.f148y2 = f4;
        }

        public static /* synthetic */ ReflectiveCurveTo copy$default(ReflectiveCurveTo reflectiveCurveTo, float f, float f2, float f3, float f4, int i, Object obj) {
            if ((i & 1) != 0) {
                f = reflectiveCurveTo.f145x1;
            }
            if ((i & 2) != 0) {
                f2 = reflectiveCurveTo.f147y1;
            }
            if ((i & 4) != 0) {
                f3 = reflectiveCurveTo.f146x2;
            }
            if ((i & 8) != 0) {
                f4 = reflectiveCurveTo.f148y2;
            }
            return reflectiveCurveTo.copy(f, f2, f3, f4);
        }

        public final float component1() {
            return this.f145x1;
        }

        public final float component2() {
            return this.f147y1;
        }

        public final float component3() {
            return this.f146x2;
        }

        public final float component4() {
            return this.f148y2;
        }

        @NotNull
        public final ReflectiveCurveTo copy(float f, float f2, float f3, float f4) {
            return new ReflectiveCurveTo(f, f2, f3, f4);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ReflectiveCurveTo)) {
                return false;
            }
            ReflectiveCurveTo reflectiveCurveTo = (ReflectiveCurveTo) obj;
            return Float.compare(this.f145x1, reflectiveCurveTo.f145x1) == 0 && Float.compare(this.f147y1, reflectiveCurveTo.f147y1) == 0 && Float.compare(this.f146x2, reflectiveCurveTo.f146x2) == 0 && Float.compare(this.f148y2, reflectiveCurveTo.f148y2) == 0;
        }

        public final float getX1() {
            return this.f145x1;
        }

        public final float getX2() {
            return this.f146x2;
        }

        public final float getY1() {
            return this.f147y1;
        }

        public final float getY2() {
            return this.f148y2;
        }

        public int hashCode() {
            return (((((Float.floatToIntBits(this.f145x1) * 31) + Float.floatToIntBits(this.f147y1)) * 31) + Float.floatToIntBits(this.f146x2)) * 31) + Float.floatToIntBits(this.f148y2);
        }

        @NotNull
        public String toString() {
            return "ReflectiveCurveTo(x1=" + this.f145x1 + ", y1=" + this.f147y1 + ", x2=" + this.f146x2 + ", y2=" + this.f148y2 + ')';
        }
    }

    /* compiled from: Taobao */
    @Immutable
    public static final class ReflectiveQuadTo extends PathNode {

        /* renamed from: x */
        private final float f149x;

        /* renamed from: y */
        private final float f150y;

        public ReflectiveQuadTo(float f, float f2) {
            super(false, true, true ? 1 : 0, null);
            this.f149x = f;
            this.f150y = f2;
        }

        public static /* synthetic */ ReflectiveQuadTo copy$default(ReflectiveQuadTo reflectiveQuadTo, float f, float f2, int i, Object obj) {
            if ((i & 1) != 0) {
                f = reflectiveQuadTo.f149x;
            }
            if ((i & 2) != 0) {
                f2 = reflectiveQuadTo.f150y;
            }
            return reflectiveQuadTo.copy(f, f2);
        }

        public final float component1() {
            return this.f149x;
        }

        public final float component2() {
            return this.f150y;
        }

        @NotNull
        public final ReflectiveQuadTo copy(float f, float f2) {
            return new ReflectiveQuadTo(f, f2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ReflectiveQuadTo)) {
                return false;
            }
            ReflectiveQuadTo reflectiveQuadTo = (ReflectiveQuadTo) obj;
            return Float.compare(this.f149x, reflectiveQuadTo.f149x) == 0 && Float.compare(this.f150y, reflectiveQuadTo.f150y) == 0;
        }

        public final float getX() {
            return this.f149x;
        }

        public final float getY() {
            return this.f150y;
        }

        public int hashCode() {
            return (Float.floatToIntBits(this.f149x) * 31) + Float.floatToIntBits(this.f150y);
        }

        @NotNull
        public String toString() {
            return "ReflectiveQuadTo(x=" + this.f149x + ", y=" + this.f150y + ')';
        }
    }

    /* compiled from: Taobao */
    @Immutable
    /* loaded from: classes2.dex */
    public static final class RelativeArcTo extends PathNode {
        private final float arcStartDx;
        private final float arcStartDy;
        private final float horizontalEllipseRadius;
        private final boolean isMoreThanHalf;
        private final boolean isPositiveArc;
        private final float theta;
        private final float verticalEllipseRadius;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public RelativeArcTo(float r4, float r5, float r6, boolean r7, boolean r8, float r9, float r10) {
            /*
                r3 = this;
                r0 = 0
                r1 = 3
                r2 = 0
                r3.<init>(r0, r0, r1, r2)
                r3.horizontalEllipseRadius = r4
                r3.verticalEllipseRadius = r5
                r3.theta = r6
                r3.isMoreThanHalf = r7
                r3.isPositiveArc = r8
                r3.arcStartDx = r9
                r3.arcStartDy = r10
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.vector.PathNode.RelativeArcTo.<init>(float, float, float, boolean, boolean, float, float):void");
        }

        public static /* synthetic */ RelativeArcTo copy$default(RelativeArcTo relativeArcTo, float f, float f2, float f3, boolean z, boolean z2, float f4, float f5, int i, Object obj) {
            if ((i & 1) != 0) {
                f = relativeArcTo.horizontalEllipseRadius;
            }
            if ((i & 2) != 0) {
                f2 = relativeArcTo.verticalEllipseRadius;
            }
            float f6 = f2;
            if ((i & 4) != 0) {
                f3 = relativeArcTo.theta;
            }
            float f7 = f3;
            if ((i & 8) != 0) {
                z = relativeArcTo.isMoreThanHalf;
            }
            boolean z3 = z;
            if ((i & 16) != 0) {
                z2 = relativeArcTo.isPositiveArc;
            }
            boolean z4 = z2;
            if ((i & 32) != 0) {
                f4 = relativeArcTo.arcStartDx;
            }
            float f8 = f4;
            if ((i & 64) != 0) {
                f5 = relativeArcTo.arcStartDy;
            }
            return relativeArcTo.copy(f, f6, f7, z3, z4, f8, f5);
        }

        public final float component1() {
            return this.horizontalEllipseRadius;
        }

        public final float component2() {
            return this.verticalEllipseRadius;
        }

        public final float component3() {
            return this.theta;
        }

        public final boolean component4() {
            return this.isMoreThanHalf;
        }

        public final boolean component5() {
            return this.isPositiveArc;
        }

        public final float component6() {
            return this.arcStartDx;
        }

        public final float component7() {
            return this.arcStartDy;
        }

        @NotNull
        public final RelativeArcTo copy(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5) {
            return new RelativeArcTo(f, f2, f3, z, z2, f4, f5);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RelativeArcTo)) {
                return false;
            }
            RelativeArcTo relativeArcTo = (RelativeArcTo) obj;
            return Float.compare(this.horizontalEllipseRadius, relativeArcTo.horizontalEllipseRadius) == 0 && Float.compare(this.verticalEllipseRadius, relativeArcTo.verticalEllipseRadius) == 0 && Float.compare(this.theta, relativeArcTo.theta) == 0 && this.isMoreThanHalf == relativeArcTo.isMoreThanHalf && this.isPositiveArc == relativeArcTo.isPositiveArc && Float.compare(this.arcStartDx, relativeArcTo.arcStartDx) == 0 && Float.compare(this.arcStartDy, relativeArcTo.arcStartDy) == 0;
        }

        public final float getArcStartDx() {
            return this.arcStartDx;
        }

        public final float getArcStartDy() {
            return this.arcStartDy;
        }

        public final float getHorizontalEllipseRadius() {
            return this.horizontalEllipseRadius;
        }

        public final float getTheta() {
            return this.theta;
        }

        public final float getVerticalEllipseRadius() {
            return this.verticalEllipseRadius;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int floatToIntBits = ((((Float.floatToIntBits(this.horizontalEllipseRadius) * 31) + Float.floatToIntBits(this.verticalEllipseRadius)) * 31) + Float.floatToIntBits(this.theta)) * 31;
            boolean z = this.isMoreThanHalf;
            int i = z;
            if (z != 0) {
                i = 1;
            }
            int i2 = (floatToIntBits + i) * 31;
            boolean z2 = this.isPositiveArc;
            return ((((i2 + (z2 ? 1 : z2 ? 1 : 0)) * 31) + Float.floatToIntBits(this.arcStartDx)) * 31) + Float.floatToIntBits(this.arcStartDy);
        }

        public final boolean isMoreThanHalf() {
            return this.isMoreThanHalf;
        }

        public final boolean isPositiveArc() {
            return this.isPositiveArc;
        }

        @NotNull
        public String toString() {
            return "RelativeArcTo(horizontalEllipseRadius=" + this.horizontalEllipseRadius + ", verticalEllipseRadius=" + this.verticalEllipseRadius + ", theta=" + this.theta + ", isMoreThanHalf=" + this.isMoreThanHalf + ", isPositiveArc=" + this.isPositiveArc + ", arcStartDx=" + this.arcStartDx + ", arcStartDy=" + this.arcStartDy + ')';
        }
    }

    /* compiled from: Taobao */
    @Immutable
    /* loaded from: classes2.dex */
    public static final class RelativeCurveTo extends PathNode {
        private final float dx1;
        private final float dx2;
        private final float dx3;
        private final float dy1;
        private final float dy2;
        private final float dy3;

        public RelativeCurveTo(float f, float f2, float f3, float f4, float f5, float f6) {
            super(true, false, 2, null);
            this.dx1 = f;
            this.dy1 = f2;
            this.dx2 = f3;
            this.dy2 = f4;
            this.dx3 = f5;
            this.dy3 = f6;
        }

        public static /* synthetic */ RelativeCurveTo copy$default(RelativeCurveTo relativeCurveTo, float f, float f2, float f3, float f4, float f5, float f6, int i, Object obj) {
            if ((i & 1) != 0) {
                f = relativeCurveTo.dx1;
            }
            if ((i & 2) != 0) {
                f2 = relativeCurveTo.dy1;
            }
            float f7 = f2;
            if ((i & 4) != 0) {
                f3 = relativeCurveTo.dx2;
            }
            float f8 = f3;
            if ((i & 8) != 0) {
                f4 = relativeCurveTo.dy2;
            }
            float f9 = f4;
            if ((i & 16) != 0) {
                f5 = relativeCurveTo.dx3;
            }
            float f10 = f5;
            if ((i & 32) != 0) {
                f6 = relativeCurveTo.dy3;
            }
            return relativeCurveTo.copy(f, f7, f8, f9, f10, f6);
        }

        public final float component1() {
            return this.dx1;
        }

        public final float component2() {
            return this.dy1;
        }

        public final float component3() {
            return this.dx2;
        }

        public final float component4() {
            return this.dy2;
        }

        public final float component5() {
            return this.dx3;
        }

        public final float component6() {
            return this.dy3;
        }

        @NotNull
        public final RelativeCurveTo copy(float f, float f2, float f3, float f4, float f5, float f6) {
            return new RelativeCurveTo(f, f2, f3, f4, f5, f6);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RelativeCurveTo)) {
                return false;
            }
            RelativeCurveTo relativeCurveTo = (RelativeCurveTo) obj;
            return Float.compare(this.dx1, relativeCurveTo.dx1) == 0 && Float.compare(this.dy1, relativeCurveTo.dy1) == 0 && Float.compare(this.dx2, relativeCurveTo.dx2) == 0 && Float.compare(this.dy2, relativeCurveTo.dy2) == 0 && Float.compare(this.dx3, relativeCurveTo.dx3) == 0 && Float.compare(this.dy3, relativeCurveTo.dy3) == 0;
        }

        public final float getDx1() {
            return this.dx1;
        }

        public final float getDx2() {
            return this.dx2;
        }

        public final float getDx3() {
            return this.dx3;
        }

        public final float getDy1() {
            return this.dy1;
        }

        public final float getDy2() {
            return this.dy2;
        }

        public final float getDy3() {
            return this.dy3;
        }

        public int hashCode() {
            return (((((((((Float.floatToIntBits(this.dx1) * 31) + Float.floatToIntBits(this.dy1)) * 31) + Float.floatToIntBits(this.dx2)) * 31) + Float.floatToIntBits(this.dy2)) * 31) + Float.floatToIntBits(this.dx3)) * 31) + Float.floatToIntBits(this.dy3);
        }

        @NotNull
        public String toString() {
            return "RelativeCurveTo(dx1=" + this.dx1 + ", dy1=" + this.dy1 + ", dx2=" + this.dx2 + ", dy2=" + this.dy2 + ", dx3=" + this.dx3 + ", dy3=" + this.dy3 + ')';
        }
    }

    /* compiled from: Taobao */
    @Immutable
    /* loaded from: classes2.dex */
    public static final class RelativeHorizontalTo extends PathNode {

        /* renamed from: dx */
        private final float f151dx;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public RelativeHorizontalTo(float r4) {
            /*
                r3 = this;
                r0 = 0
                r1 = 3
                r2 = 0
                r3.<init>(r0, r0, r1, r2)
                r3.f151dx = r4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.vector.PathNode.RelativeHorizontalTo.<init>(float):void");
        }

        public static /* synthetic */ RelativeHorizontalTo copy$default(RelativeHorizontalTo relativeHorizontalTo, float f, int i, Object obj) {
            if ((i & 1) != 0) {
                f = relativeHorizontalTo.f151dx;
            }
            return relativeHorizontalTo.copy(f);
        }

        public final float component1() {
            return this.f151dx;
        }

        @NotNull
        public final RelativeHorizontalTo copy(float f) {
            return new RelativeHorizontalTo(f);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof RelativeHorizontalTo) && Float.compare(this.f151dx, ((RelativeHorizontalTo) obj).f151dx) == 0;
        }

        public final float getDx() {
            return this.f151dx;
        }

        public int hashCode() {
            return Float.floatToIntBits(this.f151dx);
        }

        @NotNull
        public String toString() {
            return "RelativeHorizontalTo(dx=" + this.f151dx + ')';
        }
    }

    /* compiled from: Taobao */
    @Immutable
    /* loaded from: classes2.dex */
    public static final class RelativeLineTo extends PathNode {

        /* renamed from: dx */
        private final float f152dx;

        /* renamed from: dy */
        private final float f153dy;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public RelativeLineTo(float r4, float r5) {
            /*
                r3 = this;
                r0 = 0
                r1 = 3
                r2 = 0
                r3.<init>(r0, r0, r1, r2)
                r3.f152dx = r4
                r3.f153dy = r5
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.vector.PathNode.RelativeLineTo.<init>(float, float):void");
        }

        public static /* synthetic */ RelativeLineTo copy$default(RelativeLineTo relativeLineTo, float f, float f2, int i, Object obj) {
            if ((i & 1) != 0) {
                f = relativeLineTo.f152dx;
            }
            if ((i & 2) != 0) {
                f2 = relativeLineTo.f153dy;
            }
            return relativeLineTo.copy(f, f2);
        }

        public final float component1() {
            return this.f152dx;
        }

        public final float component2() {
            return this.f153dy;
        }

        @NotNull
        public final RelativeLineTo copy(float f, float f2) {
            return new RelativeLineTo(f, f2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RelativeLineTo)) {
                return false;
            }
            RelativeLineTo relativeLineTo = (RelativeLineTo) obj;
            return Float.compare(this.f152dx, relativeLineTo.f152dx) == 0 && Float.compare(this.f153dy, relativeLineTo.f153dy) == 0;
        }

        public final float getDx() {
            return this.f152dx;
        }

        public final float getDy() {
            return this.f153dy;
        }

        public int hashCode() {
            return (Float.floatToIntBits(this.f152dx) * 31) + Float.floatToIntBits(this.f153dy);
        }

        @NotNull
        public String toString() {
            return "RelativeLineTo(dx=" + this.f152dx + ", dy=" + this.f153dy + ')';
        }
    }

    /* compiled from: Taobao */
    @Immutable
    /* loaded from: classes2.dex */
    public static final class RelativeMoveTo extends PathNode {

        /* renamed from: dx */
        private final float f154dx;

        /* renamed from: dy */
        private final float f155dy;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public RelativeMoveTo(float r4, float r5) {
            /*
                r3 = this;
                r0 = 0
                r1 = 3
                r2 = 0
                r3.<init>(r0, r0, r1, r2)
                r3.f154dx = r4
                r3.f155dy = r5
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.vector.PathNode.RelativeMoveTo.<init>(float, float):void");
        }

        public static /* synthetic */ RelativeMoveTo copy$default(RelativeMoveTo relativeMoveTo, float f, float f2, int i, Object obj) {
            if ((i & 1) != 0) {
                f = relativeMoveTo.f154dx;
            }
            if ((i & 2) != 0) {
                f2 = relativeMoveTo.f155dy;
            }
            return relativeMoveTo.copy(f, f2);
        }

        public final float component1() {
            return this.f154dx;
        }

        public final float component2() {
            return this.f155dy;
        }

        @NotNull
        public final RelativeMoveTo copy(float f, float f2) {
            return new RelativeMoveTo(f, f2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RelativeMoveTo)) {
                return false;
            }
            RelativeMoveTo relativeMoveTo = (RelativeMoveTo) obj;
            return Float.compare(this.f154dx, relativeMoveTo.f154dx) == 0 && Float.compare(this.f155dy, relativeMoveTo.f155dy) == 0;
        }

        public final float getDx() {
            return this.f154dx;
        }

        public final float getDy() {
            return this.f155dy;
        }

        public int hashCode() {
            return (Float.floatToIntBits(this.f154dx) * 31) + Float.floatToIntBits(this.f155dy);
        }

        @NotNull
        public String toString() {
            return "RelativeMoveTo(dx=" + this.f154dx + ", dy=" + this.f155dy + ')';
        }
    }

    /* compiled from: Taobao */
    @Immutable
    /* loaded from: classes2.dex */
    public static final class RelativeQuadTo extends PathNode {
        private final float dx1;
        private final float dx2;
        private final float dy1;
        private final float dy2;

        public RelativeQuadTo(float f, float f2, float f3, float f4) {
            super(false, true, true ? 1 : 0, null);
            this.dx1 = f;
            this.dy1 = f2;
            this.dx2 = f3;
            this.dy2 = f4;
        }

        public static /* synthetic */ RelativeQuadTo copy$default(RelativeQuadTo relativeQuadTo, float f, float f2, float f3, float f4, int i, Object obj) {
            if ((i & 1) != 0) {
                f = relativeQuadTo.dx1;
            }
            if ((i & 2) != 0) {
                f2 = relativeQuadTo.dy1;
            }
            if ((i & 4) != 0) {
                f3 = relativeQuadTo.dx2;
            }
            if ((i & 8) != 0) {
                f4 = relativeQuadTo.dy2;
            }
            return relativeQuadTo.copy(f, f2, f3, f4);
        }

        public final float component1() {
            return this.dx1;
        }

        public final float component2() {
            return this.dy1;
        }

        public final float component3() {
            return this.dx2;
        }

        public final float component4() {
            return this.dy2;
        }

        @NotNull
        public final RelativeQuadTo copy(float f, float f2, float f3, float f4) {
            return new RelativeQuadTo(f, f2, f3, f4);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RelativeQuadTo)) {
                return false;
            }
            RelativeQuadTo relativeQuadTo = (RelativeQuadTo) obj;
            return Float.compare(this.dx1, relativeQuadTo.dx1) == 0 && Float.compare(this.dy1, relativeQuadTo.dy1) == 0 && Float.compare(this.dx2, relativeQuadTo.dx2) == 0 && Float.compare(this.dy2, relativeQuadTo.dy2) == 0;
        }

        public final float getDx1() {
            return this.dx1;
        }

        public final float getDx2() {
            return this.dx2;
        }

        public final float getDy1() {
            return this.dy1;
        }

        public final float getDy2() {
            return this.dy2;
        }

        public int hashCode() {
            return (((((Float.floatToIntBits(this.dx1) * 31) + Float.floatToIntBits(this.dy1)) * 31) + Float.floatToIntBits(this.dx2)) * 31) + Float.floatToIntBits(this.dy2);
        }

        @NotNull
        public String toString() {
            return "RelativeQuadTo(dx1=" + this.dx1 + ", dy1=" + this.dy1 + ", dx2=" + this.dx2 + ", dy2=" + this.dy2 + ')';
        }
    }

    /* compiled from: Taobao */
    @Immutable
    public static final class RelativeReflectiveCurveTo extends PathNode {
        private final float dx1;
        private final float dx2;
        private final float dy1;
        private final float dy2;

        public RelativeReflectiveCurveTo(float f, float f2, float f3, float f4) {
            super(true, false, 2, null);
            this.dx1 = f;
            this.dy1 = f2;
            this.dx2 = f3;
            this.dy2 = f4;
        }

        public static /* synthetic */ RelativeReflectiveCurveTo copy$default(RelativeReflectiveCurveTo relativeReflectiveCurveTo, float f, float f2, float f3, float f4, int i, Object obj) {
            if ((i & 1) != 0) {
                f = relativeReflectiveCurveTo.dx1;
            }
            if ((i & 2) != 0) {
                f2 = relativeReflectiveCurveTo.dy1;
            }
            if ((i & 4) != 0) {
                f3 = relativeReflectiveCurveTo.dx2;
            }
            if ((i & 8) != 0) {
                f4 = relativeReflectiveCurveTo.dy2;
            }
            return relativeReflectiveCurveTo.copy(f, f2, f3, f4);
        }

        public final float component1() {
            return this.dx1;
        }

        public final float component2() {
            return this.dy1;
        }

        public final float component3() {
            return this.dx2;
        }

        public final float component4() {
            return this.dy2;
        }

        @NotNull
        public final RelativeReflectiveCurveTo copy(float f, float f2, float f3, float f4) {
            return new RelativeReflectiveCurveTo(f, f2, f3, f4);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RelativeReflectiveCurveTo)) {
                return false;
            }
            RelativeReflectiveCurveTo relativeReflectiveCurveTo = (RelativeReflectiveCurveTo) obj;
            return Float.compare(this.dx1, relativeReflectiveCurveTo.dx1) == 0 && Float.compare(this.dy1, relativeReflectiveCurveTo.dy1) == 0 && Float.compare(this.dx2, relativeReflectiveCurveTo.dx2) == 0 && Float.compare(this.dy2, relativeReflectiveCurveTo.dy2) == 0;
        }

        public final float getDx1() {
            return this.dx1;
        }

        public final float getDx2() {
            return this.dx2;
        }

        public final float getDy1() {
            return this.dy1;
        }

        public final float getDy2() {
            return this.dy2;
        }

        public int hashCode() {
            return (((((Float.floatToIntBits(this.dx1) * 31) + Float.floatToIntBits(this.dy1)) * 31) + Float.floatToIntBits(this.dx2)) * 31) + Float.floatToIntBits(this.dy2);
        }

        @NotNull
        public String toString() {
            return "RelativeReflectiveCurveTo(dx1=" + this.dx1 + ", dy1=" + this.dy1 + ", dx2=" + this.dx2 + ", dy2=" + this.dy2 + ')';
        }
    }

    /* compiled from: Taobao */
    @Immutable
    /* loaded from: classes2.dex */
    public static final class RelativeReflectiveQuadTo extends PathNode {

        /* renamed from: dx */
        private final float f156dx;

        /* renamed from: dy */
        private final float f157dy;

        public RelativeReflectiveQuadTo(float f, float f2) {
            super(false, true, true ? 1 : 0, null);
            this.f156dx = f;
            this.f157dy = f2;
        }

        public static /* synthetic */ RelativeReflectiveQuadTo copy$default(RelativeReflectiveQuadTo relativeReflectiveQuadTo, float f, float f2, int i, Object obj) {
            if ((i & 1) != 0) {
                f = relativeReflectiveQuadTo.f156dx;
            }
            if ((i & 2) != 0) {
                f2 = relativeReflectiveQuadTo.f157dy;
            }
            return relativeReflectiveQuadTo.copy(f, f2);
        }

        public final float component1() {
            return this.f156dx;
        }

        public final float component2() {
            return this.f157dy;
        }

        @NotNull
        public final RelativeReflectiveQuadTo copy(float f, float f2) {
            return new RelativeReflectiveQuadTo(f, f2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RelativeReflectiveQuadTo)) {
                return false;
            }
            RelativeReflectiveQuadTo relativeReflectiveQuadTo = (RelativeReflectiveQuadTo) obj;
            return Float.compare(this.f156dx, relativeReflectiveQuadTo.f156dx) == 0 && Float.compare(this.f157dy, relativeReflectiveQuadTo.f157dy) == 0;
        }

        public final float getDx() {
            return this.f156dx;
        }

        public final float getDy() {
            return this.f157dy;
        }

        public int hashCode() {
            return (Float.floatToIntBits(this.f156dx) * 31) + Float.floatToIntBits(this.f157dy);
        }

        @NotNull
        public String toString() {
            return "RelativeReflectiveQuadTo(dx=" + this.f156dx + ", dy=" + this.f157dy + ')';
        }
    }

    /* compiled from: Taobao */
    @Immutable
    /* loaded from: classes2.dex */
    public static final class RelativeVerticalTo extends PathNode {

        /* renamed from: dy */
        private final float f158dy;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public RelativeVerticalTo(float r4) {
            /*
                r3 = this;
                r0 = 0
                r1 = 3
                r2 = 0
                r3.<init>(r0, r0, r1, r2)
                r3.f158dy = r4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.vector.PathNode.RelativeVerticalTo.<init>(float):void");
        }

        public static /* synthetic */ RelativeVerticalTo copy$default(RelativeVerticalTo relativeVerticalTo, float f, int i, Object obj) {
            if ((i & 1) != 0) {
                f = relativeVerticalTo.f158dy;
            }
            return relativeVerticalTo.copy(f);
        }

        public final float component1() {
            return this.f158dy;
        }

        @NotNull
        public final RelativeVerticalTo copy(float f) {
            return new RelativeVerticalTo(f);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof RelativeVerticalTo) && Float.compare(this.f158dy, ((RelativeVerticalTo) obj).f158dy) == 0;
        }

        public final float getDy() {
            return this.f158dy;
        }

        public int hashCode() {
            return Float.floatToIntBits(this.f158dy);
        }

        @NotNull
        public String toString() {
            return "RelativeVerticalTo(dy=" + this.f158dy + ')';
        }
    }

    /* compiled from: Taobao */
    @Immutable
    /* loaded from: classes2.dex */
    public static final class VerticalTo extends PathNode {

        /* renamed from: y */
        private final float f159y;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public VerticalTo(float r4) {
            /*
                r3 = this;
                r0 = 0
                r1 = 3
                r2 = 0
                r3.<init>(r0, r0, r1, r2)
                r3.f159y = r4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.vector.PathNode.VerticalTo.<init>(float):void");
        }

        public static /* synthetic */ VerticalTo copy$default(VerticalTo verticalTo, float f, int i, Object obj) {
            if ((i & 1) != 0) {
                f = verticalTo.f159y;
            }
            return verticalTo.copy(f);
        }

        public final float component1() {
            return this.f159y;
        }

        @NotNull
        public final VerticalTo copy(float f) {
            return new VerticalTo(f);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof VerticalTo) && Float.compare(this.f159y, ((VerticalTo) obj).f159y) == 0;
        }

        public final float getY() {
            return this.f159y;
        }

        public int hashCode() {
            return Float.floatToIntBits(this.f159y);
        }

        @NotNull
        public String toString() {
            return "VerticalTo(y=" + this.f159y + ')';
        }
    }

    private PathNode(boolean z, boolean z2) {
        this.isCurve = z;
        this.isQuad = z2;
    }

    public /* synthetic */ PathNode(boolean z, boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, z2);
    }

    public final boolean isCurve() {
        return this.isCurve;
    }

    public final boolean isQuad() {
        return this.isQuad;
    }

    public /* synthetic */ PathNode(boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, null);
    }
}
