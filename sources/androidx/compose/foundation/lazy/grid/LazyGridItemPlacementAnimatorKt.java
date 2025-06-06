package androidx.compose.foundation.lazy.grid;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.ui.unit.IntOffset;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class LazyGridItemPlacementAnimatorKt {

    @NotNull
    private static final SpringSpec<IntOffset> InterruptionSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m2634boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 1, null);
}
