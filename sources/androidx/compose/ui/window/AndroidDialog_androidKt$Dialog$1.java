package androidx.compose.ui.window;

import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$1$invoke$;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class AndroidDialog_androidKt$Dialog$1 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {
    final /* synthetic */ DialogWrapper $dialog;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidDialog_androidKt$Dialog$1(DialogWrapper dialogWrapper) {
        super(1);
        this.$dialog = dialogWrapper;
    }

    @NotNull
    public final DisposableEffectResult invoke(@NotNull DisposableEffectScope disposableEffectScope) {
        Intrinsics.checkNotNullParameter(disposableEffectScope, "$this$DisposableEffect");
        this.$dialog.show();
        return new AndroidDialog_androidKt$Dialog$1$invoke$.inlined.onDispose.1(this.$dialog);
    }
}
