package androidx.compose.animation.core;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class VectorizedAnimationSpecKt {
    private static final int InfiniteIterations = Integer.MAX_VALUE;

    /* JADX INFO: Access modifiers changed from: private */
    public static final long clampPlayTime(VectorizedDurationBasedAnimationSpec<?> vectorizedDurationBasedAnimationSpec, long j) {
        return RangesKt.coerceIn(j - vectorizedDurationBasedAnimationSpec.getDelayMillis(), 0L, vectorizedDurationBasedAnimationSpec.getDurationMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <V extends AnimationVector> Animations createSpringAnimations(final V v, final float f, final float f2) {
        return v != null ? new Animations(v, f, f2) { // from class: androidx.compose.animation.core.VectorizedAnimationSpecKt$createSpringAnimations$1

            @NotNull
            private final List<FloatSpringSpec> anims;

            /* JADX WARN: Incorrect types in method signature: (TV;FF)V */
            {
                IntRange until = RangesKt.until(0, v.getSize$animation_core_release());
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(until, 10));
                IntIterator it = until.iterator();
                while (it.hasNext()) {
                    arrayList.add(new FloatSpringSpec(f, f2, v.get$animation_core_release(it.nextInt())));
                }
                this.anims = arrayList;
            }

            @Override // androidx.compose.animation.core.Animations
            @NotNull
            public FloatSpringSpec get(int i) {
                return this.anims.get(i);
            }
        } : new Animations(f, f2) { // from class: androidx.compose.animation.core.VectorizedAnimationSpecKt$createSpringAnimations$2

            @NotNull
            private final FloatSpringSpec anim;

            {
                this.anim = new FloatSpringSpec(f, f2, 0.0f, 4, null);
            }

            @Override // androidx.compose.animation.core.Animations
            @NotNull
            public FloatSpringSpec get(int i) {
                return this.anim;
            }
        };
    }

    public static final <V extends AnimationVector> long getDurationMillis(@NotNull VectorizedAnimationSpec<V> vectorizedAnimationSpec, @NotNull V v, @NotNull V v2, @NotNull V v3) {
        Intrinsics.checkNotNullParameter(vectorizedAnimationSpec, "<this>");
        Intrinsics.checkNotNullParameter(v, "initialValue");
        Intrinsics.checkNotNullParameter(v2, "targetValue");
        Intrinsics.checkNotNullParameter(v3, "initialVelocity");
        return vectorizedAnimationSpec.getDurationNanos(v, v2, v3) / AnimationKt.MillisToNanos;
    }

    @NotNull
    public static final <V extends AnimationVector> V getValueFromMillis(@NotNull VectorizedAnimationSpec<V> vectorizedAnimationSpec, long j, @NotNull V v, @NotNull V v2, @NotNull V v3) {
        Intrinsics.checkNotNullParameter(vectorizedAnimationSpec, "<this>");
        Intrinsics.checkNotNullParameter(v, "start");
        Intrinsics.checkNotNullParameter(v2, "end");
        Intrinsics.checkNotNullParameter(v3, "startVelocity");
        return vectorizedAnimationSpec.getValueFromNanos(j * AnimationKt.MillisToNanos, v, v2, v3);
    }
}
