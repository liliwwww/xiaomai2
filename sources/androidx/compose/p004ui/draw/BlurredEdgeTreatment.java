package androidx.compose.p004ui.draw;

import androidx.compose.p004ui.graphics.RectangleShapeKt;
import androidx.compose.p004ui.graphics.Shape;
import androidx.compose.runtime.Immutable;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Immutable
@JvmInline
/* loaded from: classes2.dex */
public final class BlurredEdgeTreatment {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final Shape Rectangle = m2457constructorimpl(RectangleShapeKt.getRectangleShape());

    @NotNull
    private static final Shape Unbounded = m2457constructorimpl(null);

    @Nullable
    private final Shape shape;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        /* renamed from: getRectangle---Goahg, reason: not valid java name */
        public final Shape m2463getRectangleGoahg() {
            return BlurredEdgeTreatment.Rectangle;
        }

        @NotNull
        /* renamed from: getUnbounded---Goahg, reason: not valid java name */
        public final Shape m2464getUnboundedGoahg() {
            return BlurredEdgeTreatment.Unbounded;
        }
    }

    private /* synthetic */ BlurredEdgeTreatment(Shape shape) {
        this.shape = shape;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ BlurredEdgeTreatment m2456boximpl(Shape shape) {
        return new BlurredEdgeTreatment(shape);
    }

    @NotNull
    /* renamed from: constructor-impl, reason: not valid java name */
    public static Shape m2457constructorimpl(@Nullable Shape shape) {
        return shape;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m2458equalsimpl(Shape shape, Object obj) {
        return (obj instanceof BlurredEdgeTreatment) && Intrinsics.areEqual(shape, ((BlurredEdgeTreatment) obj).m2462unboximpl());
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2459equalsimpl0(Shape shape, Shape shape2) {
        return Intrinsics.areEqual(shape, shape2);
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m2460hashCodeimpl(Shape shape) {
        if (shape == null) {
            return 0;
        }
        return shape.hashCode();
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m2461toStringimpl(Shape shape) {
        return "BlurredEdgeTreatment(shape=" + shape + ')';
    }

    public boolean equals(Object obj) {
        return m2458equalsimpl(this.shape, obj);
    }

    @Nullable
    public final Shape getShape() {
        return this.shape;
    }

    public int hashCode() {
        return m2460hashCodeimpl(this.shape);
    }

    public String toString() {
        return m2461toStringimpl(this.shape);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ Shape m2462unboximpl() {
        return this.shape;
    }
}
