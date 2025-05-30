package androidx.compose.foundation;

import androidx.compose.foundation.FocusableKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class FocusableKt$focusable$2$4 extends Lambda implements Function1<SemanticsPropertyReceiver, Unit> {
    final /* synthetic */ FocusRequester $focusRequester;
    final /* synthetic */ MutableState<Boolean> $isFocused$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FocusableKt$focusable$2$4(MutableState<Boolean> mutableState, FocusRequester focusRequester) {
        super(1);
        this.$isFocused$delegate = mutableState;
        this.$focusRequester = focusRequester;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SemanticsPropertyReceiver) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$semantics");
        SemanticsPropertiesKt.setFocused(semanticsPropertyReceiver, FocusableKt.focusable.2.access$invoke$lambda$2(this.$isFocused$delegate));
        final FocusRequester focusRequester = this.$focusRequester;
        final MutableState<Boolean> mutableState = this.$isFocused$delegate;
        SemanticsPropertiesKt.requestFocus$default(semanticsPropertyReceiver, (String) null, new Function0<Boolean>() { // from class: androidx.compose.foundation.FocusableKt$focusable$2$4.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @NotNull
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Boolean m151invoke() {
                FocusRequester.this.requestFocus();
                return Boolean.valueOf(FocusableKt.focusable.2.access$invoke$lambda$2(mutableState));
            }
        }, 1, (Object) null);
    }
}
