package androidx.compose.animation.core;

import androidx.compose.runtime.internal.StabilityInferred;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: classes2.dex */
public final class AnimationConstants {
    public static final int $stable = 0;
    public static final int DefaultDurationMillis = 300;

    @NotNull
    public static final AnimationConstants INSTANCE = new AnimationConstants();
    public static final long UnspecifiedTime = Long.MIN_VALUE;

    private AnimationConstants() {
    }
}
