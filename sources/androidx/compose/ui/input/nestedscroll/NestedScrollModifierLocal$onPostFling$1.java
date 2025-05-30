package androidx.compose.ui.input.nestedscroll;

import androidx.appcompat.R;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@DebugMetadata(c = "androidx.compose.ui.input.nestedscroll.NestedScrollModifierLocal", f = "NestedScrollModifierLocal.kt", i = {0, 0, 0, 1}, l = {R.styleable.AppCompatTheme_ratingBarStyleSmall, R.styleable.AppCompatTheme_seekBarStyle}, m = "onPostFling-RZ2iAVY", n = {"this", "consumed", "available", "selfConsumed"}, s = {"L$0", "J$0", "J$1", "J$0"})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class NestedScrollModifierLocal$onPostFling$1 extends ContinuationImpl {
    long J$0;
    long J$1;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NestedScrollModifierLocal this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NestedScrollModifierLocal$onPostFling$1(NestedScrollModifierLocal nestedScrollModifierLocal, Continuation<? super NestedScrollModifierLocal$onPostFling$1> continuation) {
        super(continuation);
        this.this$0 = nestedScrollModifierLocal;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.onPostFling-RZ2iAVY(0L, 0L, this);
    }
}
