package androidx.compose.animation;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.p004ui.unit.IntSize;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@ExperimentalAnimationApi
/* loaded from: classes2.dex */
final class SizeTransformImpl implements SizeTransform {
    private final boolean clip;

    @NotNull
    private final Function2<IntSize, IntSize, FiniteAnimationSpec<IntSize>> sizeAnimationSpec;

    /* JADX WARN: Multi-variable type inference failed */
    public SizeTransformImpl(boolean z, @NotNull Function2<? super IntSize, ? super IntSize, ? extends FiniteAnimationSpec<IntSize>> function2) {
        Intrinsics.checkNotNullParameter(function2, "sizeAnimationSpec");
        this.clip = z;
        this.sizeAnimationSpec = function2;
    }

    @Override // androidx.compose.animation.SizeTransform
    @NotNull
    /* renamed from: createAnimationSpec-TemP2vQ */
    public FiniteAnimationSpec<IntSize> mo1028createAnimationSpecTemP2vQ(long j, long j2) {
        return (FiniteAnimationSpec) this.sizeAnimationSpec.invoke(IntSize.m5368boximpl(j), IntSize.m5368boximpl(j2));
    }

    @Override // androidx.compose.animation.SizeTransform
    public boolean getClip() {
        return this.clip;
    }

    @NotNull
    public final Function2<IntSize, IntSize, FiniteAnimationSpec<IntSize>> getSizeAnimationSpec() {
        return this.sizeAnimationSpec;
    }

    public /* synthetic */ SizeTransformImpl(boolean z, Function2 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z, function2);
    }
}
