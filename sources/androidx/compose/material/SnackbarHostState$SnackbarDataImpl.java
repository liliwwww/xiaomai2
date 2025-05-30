package androidx.compose.material;

import androidx.compose.runtime.Stable;
import androidx.constraintlayout.core.motion.utils.TypedValues$TransitionType;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
@Stable
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class SnackbarHostState$SnackbarDataImpl implements SnackbarData {

    @Nullable
    private final String actionLabel;

    @NotNull
    private final CancellableContinuation<SnackbarResult> continuation;

    @NotNull
    private final SnackbarDuration duration;

    @NotNull
    private final String message;

    public SnackbarHostState$SnackbarDataImpl(@NotNull String str, @Nullable String str2, @NotNull SnackbarDuration snackbarDuration, @NotNull CancellableContinuation<? super SnackbarResult> cancellableContinuation) {
        Intrinsics.checkNotNullParameter(str, "message");
        Intrinsics.checkNotNullParameter(snackbarDuration, TypedValues$TransitionType.S_DURATION);
        Intrinsics.checkNotNullParameter(cancellableContinuation, "continuation");
        this.message = str;
        this.actionLabel = str2;
        this.duration = snackbarDuration;
        this.continuation = cancellableContinuation;
    }

    public void dismiss() {
        if (this.continuation.isActive()) {
            CancellableContinuation<SnackbarResult> cancellableContinuation = this.continuation;
            Result.Companion companion = Result.Companion;
            cancellableContinuation.resumeWith(Result.constructor-impl(SnackbarResult.Dismissed));
        }
    }

    @Nullable
    public String getActionLabel() {
        return this.actionLabel;
    }

    @NotNull
    public SnackbarDuration getDuration() {
        return this.duration;
    }

    @NotNull
    public String getMessage() {
        return this.message;
    }

    public void performAction() {
        if (this.continuation.isActive()) {
            CancellableContinuation<SnackbarResult> cancellableContinuation = this.continuation;
            Result.Companion companion = Result.Companion;
            cancellableContinuation.resumeWith(Result.constructor-impl(SnackbarResult.ActionPerformed));
        }
    }
}
