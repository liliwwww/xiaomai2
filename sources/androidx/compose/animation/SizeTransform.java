package androidx.compose.animation;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.p004ui.unit.IntSize;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@ExperimentalAnimationApi
/* loaded from: classes2.dex */
public interface SizeTransform {
    @NotNull
    /* renamed from: createAnimationSpec-TemP2vQ, reason: not valid java name */
    FiniteAnimationSpec<IntSize> mo1028createAnimationSpecTemP2vQ(long j, long j2);

    boolean getClip();
}
