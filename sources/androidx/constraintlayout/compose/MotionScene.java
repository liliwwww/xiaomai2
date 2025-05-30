package androidx.constraintlayout.compose;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Immutable
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\tH&J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0016\u0010\u000f\u001a\u00020\u00052\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH&J\u0012\u0010\u0010\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\b\u0010\u0012\u001a\u00020\u0011H&J\b\u0010\u0013\u001a\u00020\u0005H&J\b\u0010\u0015\u001a\u00020\u0014H&¨\u0006\u0016"}, d2 = {"Landroidx/constraintlayout/compose/MotionScene;", "", "", "name", "content", "", "setConstraintSetContent", "setTransitionContent", "getConstraintSet", "", "index", "getTransition", "Landroidx/compose/runtime/MutableState;", "", "needsUpdate", "setUpdateFlag", "setDebugName", "", "getForcedProgress", "resetForcedProgress", "Landroidx/constraintlayout/compose/MotionLayoutDebugFlags;", "getForcedDrawDebug", "compose_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public interface MotionScene {
    @Nullable
    String getConstraintSet(int index);

    @Nullable
    String getConstraintSet(@NotNull String name);

    @NotNull
    MotionLayoutDebugFlags getForcedDrawDebug();

    float getForcedProgress();

    @Nullable
    String getTransition(@NotNull String name);

    void resetForcedProgress();

    void setConstraintSetContent(@NotNull String name, @NotNull String content);

    void setDebugName(@Nullable String name);

    void setTransitionContent(@NotNull String name, @NotNull String content);

    void setUpdateFlag(@NotNull MutableState<Long> needsUpdate);
}
