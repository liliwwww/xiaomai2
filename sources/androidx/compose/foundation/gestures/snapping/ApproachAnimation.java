package androidx.compose.foundation.gestures.snapping;

import androidx.compose.animation.core.AnimationVector;
import androidx.compose.foundation.gestures.ScrollScope;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
interface ApproachAnimation<T, V extends AnimationVector> {
    @Nullable
    Object approachAnimation(@NotNull ScrollScope scrollScope, T t, T t2, @NotNull Function1<? super T, Unit> function1, @NotNull Continuation<? super AnimationResult<T, V>> continuation);
}
