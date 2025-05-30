package androidx.compose.foundation.gestures.snapping;

import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.ui.unit.Density;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@DebugMetadata(c = "androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt", f = "SnapFlingBehavior.kt", i = {0, 0}, l = {313}, m = "approach", n = {"snapLayoutInfoProvider", "density"}, s = {"L$0", "L$1"})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class SnapFlingBehaviorKt$approach$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    SnapFlingBehaviorKt$approach$1(Continuation<? super SnapFlingBehaviorKt$approach$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return SnapFlingBehaviorKt.access$approach((ScrollScope) null, 0.0f, 0.0f, (ApproachAnimation) null, (SnapLayoutInfoProvider) null, (Density) null, (Function1) null, this);
    }
}
