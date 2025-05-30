package androidx.compose.ui.draw;

import androidx.compose.runtime.Immutable;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Immutable
@JvmInline
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class BlurredEdgeTreatment {

    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @NotNull
    private static final Shape Rectangle = m937constructorimpl(RectangleShapeKt.getRectangleShape());

    @NotNull
    private static final Shape Unbounded = m937constructorimpl(null);

    @Nullable
    private final Shape shape;

    private /* synthetic */ BlurredEdgeTreatment(Shape shape) {
        this.shape = shape;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ BlurredEdgeTreatment m936boximpl(Shape shape) {
        return new BlurredEdgeTreatment(shape);
    }

    @NotNull
    /* renamed from: constructor-impl, reason: not valid java name */
    public static Shape m937constructorimpl(@Nullable Shape shape) {
        return shape;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m938equalsimpl(Shape shape, Object obj) {
        return (obj instanceof BlurredEdgeTreatment) && Intrinsics.areEqual(shape, ((BlurredEdgeTreatment) obj).m942unboximpl());
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m939equalsimpl0(Shape shape, Shape shape2) {
        return Intrinsics.areEqual(shape, shape2);
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m940hashCodeimpl(Shape shape) {
        if (shape == null) {
            return 0;
        }
        return shape.hashCode();
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m941toStringimpl(Shape shape) {
        return "BlurredEdgeTreatment(shape=" + shape + ')';
    }

    public boolean equals(Object obj) {
        return m938equalsimpl(this.shape, obj);
    }

    @Nullable
    public final Shape getShape() {
        return this.shape;
    }

    public int hashCode() {
        return m940hashCodeimpl(this.shape);
    }

    public String toString() {
        return m941toStringimpl(this.shape);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ Shape m942unboximpl() {
        return this.shape;
    }
}
