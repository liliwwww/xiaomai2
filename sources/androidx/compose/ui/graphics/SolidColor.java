package androidx.compose.ui.graphics;

import android.graphics.Shader;
import androidx.compose.runtime.Immutable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Immutable
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class SolidColor extends Brush {
    private final long value;

    private SolidColor(long j) {
        super((DefaultConstructorMarker) null);
        this.value = j;
    }

    public /* synthetic */ SolidColor(long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(j);
    }

    /* renamed from: applyTo-Pq9zytI, reason: not valid java name */
    public void m1232applyToPq9zytI(long j, @NotNull Paint paint, float f) {
        long j2;
        Intrinsics.checkNotNullParameter(paint, "p");
        paint.setAlpha(1.0f);
        if (f == 1.0f) {
            j2 = this.value;
        } else {
            long j3 = this.value;
            j2 = Color.m1049copywmQWz5c$default(j3, Color.m1052getAlphaimpl(j3) * f, 0.0f, 0.0f, 0.0f, 14, null);
        }
        paint.setColor-8_81llA(j2);
        if (paint.getShader() != null) {
            paint.setShader((Shader) null);
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SolidColor) && Color.m1051equalsimpl0(this.value, ((SolidColor) obj).value);
    }

    /* renamed from: getValue-0d7_KjU, reason: not valid java name */
    public final long m1233getValue0d7_KjU() {
        return this.value;
    }

    public int hashCode() {
        return Color.m1057hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return "SolidColor(value=" + ((Object) Color.m1058toStringimpl(this.value)) + ')';
    }
}
