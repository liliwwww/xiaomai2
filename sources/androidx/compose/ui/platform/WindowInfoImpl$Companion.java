package androidx.compose.ui.platform;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.input.pointer.PointerKeyboardModifiers;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class WindowInfoImpl$Companion {
    private WindowInfoImpl$Companion() {
    }

    public /* synthetic */ WindowInfoImpl$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @NotNull
    public final MutableState<PointerKeyboardModifiers> getGlobalKeyboardModifiers$ui_release() {
        return WindowInfoImpl.access$getGlobalKeyboardModifiers$cp();
    }
}
