package androidx.compose.foundation.text;

import androidx.compose.foundation.relocation.BringIntoViewRequester;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextInputService;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.d;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class CoreTextFieldKt$CoreTextField$focusModifier$1 extends Lambda implements Function1<FocusState, Unit> {
    final /* synthetic */ BringIntoViewRequester $bringIntoViewRequester;
    final /* synthetic */ CoroutineScope $coroutineScope;
    final /* synthetic */ ImeOptions $imeOptions;
    final /* synthetic */ TextFieldSelectionManager $manager;
    final /* synthetic */ OffsetMapping $offsetMapping;
    final /* synthetic */ TextFieldState $state;
    final /* synthetic */ TextInputService $textInputService;
    final /* synthetic */ TextFieldValue $value;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CoreTextFieldKt$CoreTextField$focusModifier$1(TextFieldState textFieldState, TextInputService textInputService, TextFieldValue textFieldValue, ImeOptions imeOptions, TextFieldSelectionManager textFieldSelectionManager, CoroutineScope coroutineScope, BringIntoViewRequester bringIntoViewRequester, OffsetMapping offsetMapping) {
        super(1);
        this.$state = textFieldState;
        this.$textInputService = textInputService;
        this.$value = textFieldValue;
        this.$imeOptions = imeOptions;
        this.$manager = textFieldSelectionManager;
        this.$coroutineScope = coroutineScope;
        this.$bringIntoViewRequester = bringIntoViewRequester;
        this.$offsetMapping = offsetMapping;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((FocusState) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull FocusState focusState) {
        TextLayoutResultProxy layoutResult;
        Intrinsics.checkNotNullParameter(focusState, "it");
        if (this.$state.getHasFocus() == focusState.isFocused()) {
            return;
        }
        this.$state.setHasFocus(focusState.isFocused());
        TextInputService textInputService = this.$textInputService;
        if (textInputService != null) {
            CoreTextFieldKt.access$notifyTextInputServiceOnFocusChange(textInputService, this.$state, this.$value, this.$imeOptions);
            if (focusState.isFocused() && (layoutResult = this.$state.getLayoutResult()) != null) {
                d.d(this.$coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new 1.1(this.$bringIntoViewRequester, this.$value, this.$state, layoutResult, this.$offsetMapping, (Continuation) null), 3, (Object) null);
            }
        }
        if (focusState.isFocused()) {
            return;
        }
        TextFieldSelectionManager.deselect-_kEHs6E$foundation_release$default(this.$manager, (Offset) null, 1, (Object) null);
    }
}
