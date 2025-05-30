package androidx.compose.animation;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.ui.unit.IntSize;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@ExperimentalAnimationApi
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public interface SizeTransform {
    @NotNull
    /* renamed from: createAnimationSpec-TemP2vQ, reason: not valid java name */
    FiniteAnimationSpec<IntSize> mo59createAnimationSpecTemP2vQ(long j, long j2);

    boolean getClip();
}
