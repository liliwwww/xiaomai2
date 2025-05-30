package androidx.compose.animation;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.unit.IntSize;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class SizeAnimationModifier$AnimData {
    public static final int $stable = 8;

    @NotNull
    private final Animatable<IntSize, AnimationVector2D> anim;
    private long startSize;

    private SizeAnimationModifier$AnimData(Animatable<IntSize, AnimationVector2D> animatable, long j) {
        this.anim = animatable;
        this.startSize = j;
    }

    public /* synthetic */ SizeAnimationModifier$AnimData(Animatable animatable, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(animatable, j);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: copy-O0kMr_c$default, reason: not valid java name */
    public static /* synthetic */ SizeAnimationModifier$AnimData m62copyO0kMr_c$default(SizeAnimationModifier$AnimData sizeAnimationModifier$AnimData, Animatable animatable, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            animatable = sizeAnimationModifier$AnimData.anim;
        }
        if ((i & 2) != 0) {
            j = sizeAnimationModifier$AnimData.startSize;
        }
        return sizeAnimationModifier$AnimData.m64copyO0kMr_c(animatable, j);
    }

    @NotNull
    public final Animatable<IntSize, AnimationVector2D> component1() {
        return this.anim;
    }

    /* renamed from: component2-YbymL2g, reason: not valid java name */
    public final long m63component2YbymL2g() {
        return this.startSize;
    }

    @NotNull
    /* renamed from: copy-O0kMr_c, reason: not valid java name */
    public final SizeAnimationModifier$AnimData m64copyO0kMr_c(@NotNull Animatable<IntSize, AnimationVector2D> animatable, long j) {
        Intrinsics.checkNotNullParameter(animatable, "anim");
        return new SizeAnimationModifier$AnimData(animatable, j, null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SizeAnimationModifier$AnimData)) {
            return false;
        }
        SizeAnimationModifier$AnimData sizeAnimationModifier$AnimData = (SizeAnimationModifier$AnimData) obj;
        return Intrinsics.areEqual(this.anim, sizeAnimationModifier$AnimData.anim) && IntSize.equals-impl0(this.startSize, sizeAnimationModifier$AnimData.startSize);
    }

    @NotNull
    public final Animatable<IntSize, AnimationVector2D> getAnim() {
        return this.anim;
    }

    /* renamed from: getStartSize-YbymL2g, reason: not valid java name */
    public final long m65getStartSizeYbymL2g() {
        return this.startSize;
    }

    public int hashCode() {
        return (this.anim.hashCode() * 31) + IntSize.hashCode-impl(this.startSize);
    }

    /* renamed from: setStartSize-ozmzZPI, reason: not valid java name */
    public final void m66setStartSizeozmzZPI(long j) {
        this.startSize = j;
    }

    @NotNull
    public String toString() {
        return "AnimData(anim=" + this.anim + ", startSize=" + ((Object) IntSize.toString-impl(this.startSize)) + ')';
    }
}
