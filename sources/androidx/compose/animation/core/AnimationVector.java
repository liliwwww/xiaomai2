package androidx.compose.animation.core;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public abstract class AnimationVector {
    public static final int $stable = 0;

    private AnimationVector() {
    }

    public /* synthetic */ AnimationVector(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract float get$animation_core_release(int i);

    public abstract int getSize$animation_core_release();

    @NotNull
    public abstract AnimationVector newVector$animation_core_release();

    public abstract void reset$animation_core_release();

    public abstract void set$animation_core_release(int i, float f);
}
