package androidx.compose.foundation.gestures;

import androidx.compose.foundation.gestures.ScrollableKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@DebugMetadata(c = "androidx.compose.foundation.gestures.ScrollableKt$scrollableNestedScrollConnection$1", f = "Scrollable.kt", i = {0, 0}, l = {548}, m = "onPostFling-RZ2iAVY", n = {"this", "available"}, s = {"L$0", "J$0"})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class ScrollableKt$scrollableNestedScrollConnection$1$onPostFling$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ScrollableKt.scrollableNestedScrollConnection.1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ScrollableKt$scrollableNestedScrollConnection$1$onPostFling$1(ScrollableKt.scrollableNestedScrollConnection.1 r1, Continuation<? super ScrollableKt$scrollableNestedScrollConnection$1$onPostFling$1> continuation) {
        super(continuation);
        this.this$0 = r1;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.onPostFling-RZ2iAVY(0L, 0L, this);
    }
}
