package androidx.compose.ui.input;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.ExperimentalComposeUiApi;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class InputModeManagerImpl implements InputModeManager {

    @NotNull
    private final MutableState inputMode$delegate;

    @NotNull
    private final Function1<InputMode, Boolean> onRequestInputModeChange;

    /* JADX WARN: Multi-variable type inference failed */
    private InputModeManagerImpl(int i, Function1<? super InputMode, Boolean> function1) {
        MutableState mutableStateOf$default;
        this.onRequestInputModeChange = function1;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(InputMode.m1351boximpl(i), null, 2, null);
        this.inputMode$delegate = mutableStateOf$default;
    }

    public /* synthetic */ InputModeManagerImpl(int i, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, function1);
    }

    /* renamed from: getInputMode-aOaMEAU, reason: not valid java name */
    public int m1358getInputModeaOaMEAU() {
        return ((InputMode) this.inputMode$delegate.getValue()).m1357unboximpl();
    }

    @ExperimentalComposeUiApi
    /* renamed from: requestInputMode-iuPiT84, reason: not valid java name */
    public boolean m1359requestInputModeiuPiT84(int i) {
        return ((Boolean) this.onRequestInputModeChange.invoke(InputMode.m1351boximpl(i))).booleanValue();
    }

    /* renamed from: setInputMode-iuPiT84, reason: not valid java name */
    public void m1360setInputModeiuPiT84(int i) {
        this.inputMode$delegate.setValue(InputMode.m1351boximpl(i));
    }
}
