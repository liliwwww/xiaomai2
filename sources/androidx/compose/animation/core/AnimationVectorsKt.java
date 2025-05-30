package androidx.compose.animation.core;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class AnimationVectorsKt {
    @NotNull
    public static final AnimationVector1D AnimationVector(float f) {
        return new AnimationVector1D(f);
    }

    @NotNull
    public static final <T extends AnimationVector> T copy(@NotNull T t) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        T t2 = (T) newInstance(t);
        int size$animation_core_release = t2.getSize$animation_core_release();
        for (int i = 0; i < size$animation_core_release; i++) {
            t2.set$animation_core_release(i, t.get$animation_core_release(i));
        }
        return t2;
    }

    public static final <T extends AnimationVector> void copyFrom(@NotNull T t, @NotNull T t2) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        Intrinsics.checkNotNullParameter(t2, "source");
        int size$animation_core_release = t.getSize$animation_core_release();
        for (int i = 0; i < size$animation_core_release; i++) {
            t.set$animation_core_release(i, t2.get$animation_core_release(i));
        }
    }

    @NotNull
    public static final <T extends AnimationVector> T newInstance(@NotNull T t) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        T t2 = (T) t.newVector$animation_core_release();
        Intrinsics.checkNotNull(t2, "null cannot be cast to non-null type T of androidx.compose.animation.core.AnimationVectorsKt.newInstance");
        return t2;
    }

    @NotNull
    public static final AnimationVector2D AnimationVector(float f, float f2) {
        return new AnimationVector2D(f, f2);
    }

    @NotNull
    public static final AnimationVector3D AnimationVector(float f, float f2, float f3) {
        return new AnimationVector3D(f, f2, f3);
    }

    @NotNull
    public static final AnimationVector4D AnimationVector(float f, float f2, float f3, float f4) {
        return new AnimationVector4D(f, f2, f3, f4);
    }
}
