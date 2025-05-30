package androidx.compose.animation.core;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class VectorizedAnimationSpecKt$createSpringAnimations$1 implements Animations {

    @NotNull
    private final List<FloatSpringSpec> anims;

    /* JADX WARN: Incorrect types in method signature: (TV;FF)V */
    VectorizedAnimationSpecKt$createSpringAnimations$1(AnimationVector animationVector, float f, float f2) {
        IntRange until = RangesKt.until(0, animationVector.getSize$animation_core_release());
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(until, 10));
        IntIterator it = until.iterator();
        while (it.hasNext()) {
            arrayList.add(new FloatSpringSpec(f, f2, animationVector.get$animation_core_release(it.nextInt())));
        }
        this.anims = arrayList;
    }

    @Override // androidx.compose.animation.core.Animations
    @NotNull
    public FloatSpringSpec get(int i) {
        return this.anims.get(i);
    }
}
