package androidx.compose.p004ui.platform;

import androidx.compose.p004ui.ExperimentalComposeUiApi;
import androidx.compose.p004ui.input.pointer.PointerEvent_androidKt;
import androidx.compose.p004ui.input.pointer.PointerKeyboardModifiers;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class WindowInfoImpl implements WindowInfo {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final MutableState<PointerKeyboardModifiers> GlobalKeyboardModifiers = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(PointerKeyboardModifiers.m4129boximpl(PointerEvent_androidKt.EmptyPointerKeyboardModifiers()), null, 2, null);

    @NotNull
    private final MutableState<Boolean> _isWindowFocused = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final MutableState<PointerKeyboardModifiers> getGlobalKeyboardModifiers$ui_release() {
            return WindowInfoImpl.GlobalKeyboardModifiers;
        }
    }

    /* renamed from: getKeyboardModifiers-k7X9c1A$annotations, reason: not valid java name */
    public static /* synthetic */ void m4569getKeyboardModifiersk7X9c1A$annotations() {
    }

    @Override // androidx.compose.p004ui.platform.WindowInfo
    @ExperimentalComposeUiApi
    /* renamed from: getKeyboardModifiers-k7X9c1A */
    public int mo4568getKeyboardModifiersk7X9c1A() {
        return GlobalKeyboardModifiers.getValue().m4135unboximpl();
    }

    @Override // androidx.compose.p004ui.platform.WindowInfo
    public boolean isWindowFocused() {
        return this._isWindowFocused.getValue().booleanValue();
    }

    /* renamed from: setKeyboardModifiers-5xRPYO0, reason: not valid java name */
    public void m4570setKeyboardModifiers5xRPYO0(int i) {
        GlobalKeyboardModifiers.setValue(PointerKeyboardModifiers.m4129boximpl(i));
    }

    public void setWindowFocused(boolean z) {
        this._isWindowFocused.setValue(Boolean.valueOf(z));
    }
}
