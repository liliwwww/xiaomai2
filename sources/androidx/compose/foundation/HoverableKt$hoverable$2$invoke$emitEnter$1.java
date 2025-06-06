package androidx.compose.foundation;

import androidx.compose.foundation.HoverableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.MutableState;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@DebugMetadata(c = "androidx.compose.foundation.HoverableKt$hoverable$2", f = "Hoverable.kt", i = {0, 0}, l = {androidx.appcompat.R.styleable.AppCompatTheme_dialogPreferredPadding}, m = "invoke$emitEnter", n = {"hoverInteraction$delegate", "interaction"}, s = {"L$0", "L$1"})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class HoverableKt$hoverable$2$invoke$emitEnter$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    HoverableKt$hoverable$2$invoke$emitEnter$1(Continuation<? super HoverableKt$hoverable$2$invoke$emitEnter$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return HoverableKt.hoverable.2.access$invoke$emitEnter((MutableInteractionSource) null, (MutableState) null, this);
    }
}
