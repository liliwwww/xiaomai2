package androidx.compose.p004ui.input;

import androidx.compose.p004ui.ExperimentalComposeUiApi;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class InputModeManagerImpl implements InputModeManager {

    @NotNull
    private final MutableState inputMode$delegate;

    @NotNull
    private final Function1<InputMode, Boolean> onRequestInputModeChange;

    /* JADX WARN: Multi-variable type inference failed */
    private InputModeManagerImpl(int i, Function1<? super InputMode, Boolean> function1) {
        this.onRequestInputModeChange = function1;
        this.inputMode$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(InputMode.m3353boximpl(i), null, 2, null);
    }

    public /* synthetic */ InputModeManagerImpl(int i, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.p004ui.input.InputModeManager
    /* renamed from: getInputMode-aOaMEAU */
    public int mo3362getInputModeaOaMEAU() {
        return ((InputMode) this.inputMode$delegate.getValue()).m3359unboximpl();
    }

    @Override // androidx.compose.p004ui.input.InputModeManager
    @ExperimentalComposeUiApi
    /* renamed from: requestInputMode-iuPiT84 */
    public boolean mo3363requestInputModeiuPiT84(int i) {
        return ((Boolean) this.onRequestInputModeChange.invoke(InputMode.m3353boximpl(i))).booleanValue();
    }

    /* renamed from: setInputMode-iuPiT84, reason: not valid java name */
    public void m3364setInputModeiuPiT84(int i) {
        this.inputMode$delegate.setValue(InputMode.m3353boximpl(i));
    }
}
