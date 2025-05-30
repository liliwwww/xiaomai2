package androidx.compose.foundation.gestures;

import androidx.compose.runtime.Stable;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Stable
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public interface FlingBehavior {
    @Nullable
    Object performFling(@NotNull ScrollScope scrollScope, float f, @NotNull Continuation<? super Float> continuation);
}
