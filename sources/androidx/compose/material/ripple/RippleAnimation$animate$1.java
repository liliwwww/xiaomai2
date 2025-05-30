package androidx.compose.material.ripple;

import androidx.appcompat.R;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@DebugMetadata(c = "androidx.compose.material.ripple.RippleAnimation", f = "RippleAnimation.kt", i = {0, 1}, l = {R.styleable.AppCompatTheme_listPreferredItemHeightLarge, R.styleable.AppCompatTheme_listPreferredItemPaddingEnd, R.styleable.AppCompatTheme_listPreferredItemPaddingLeft}, m = "animate", n = {"this", "this"}, s = {"L$0", "L$0"})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class RippleAnimation$animate$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RippleAnimation this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RippleAnimation$animate$1(RippleAnimation rippleAnimation, Continuation<? super RippleAnimation$animate$1> continuation) {
        super(continuation);
        this.this$0 = rippleAnimation;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.animate(this);
    }
}
