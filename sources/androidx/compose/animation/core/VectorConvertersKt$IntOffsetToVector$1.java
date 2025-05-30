package androidx.compose.animation.core;

import androidx.compose.ui.unit.IntOffset;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class VectorConvertersKt$IntOffsetToVector$1 extends Lambda implements Function1<IntOffset, AnimationVector2D> {
    public static final VectorConvertersKt$IntOffsetToVector$1 INSTANCE = new VectorConvertersKt$IntOffsetToVector$1();

    VectorConvertersKt$IntOffsetToVector$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return m104invokegyyYBs(((IntOffset) obj).unbox-impl());
    }

    @NotNull
    /* renamed from: invoke--gyyYBs, reason: not valid java name */
    public final AnimationVector2D m104invokegyyYBs(long j) {
        return new AnimationVector2D(IntOffset.getX-impl(j), IntOffset.getY-impl(j));
    }
}
