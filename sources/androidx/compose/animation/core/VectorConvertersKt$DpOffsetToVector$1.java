package androidx.compose.animation.core;

import androidx.compose.ui.unit.DpOffset;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class VectorConvertersKt$DpOffsetToVector$1 extends Lambda implements Function1<DpOffset, AnimationVector2D> {
    public static final VectorConvertersKt$DpOffsetToVector$1 INSTANCE = new VectorConvertersKt$DpOffsetToVector$1();

    VectorConvertersKt$DpOffsetToVector$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return m102invokejoFl9I(((DpOffset) obj).unbox-impl());
    }

    @NotNull
    /* renamed from: invoke-jo-Fl9I, reason: not valid java name */
    public final AnimationVector2D m102invokejoFl9I(long j) {
        return new AnimationVector2D(DpOffset.getX-D9Ej5fM(j), DpOffset.getY-D9Ej5fM(j));
    }
}
