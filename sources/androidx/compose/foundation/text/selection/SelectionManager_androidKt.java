package androidx.compose.foundation.text.selection;

import android.annotation.SuppressLint;
import android.view.KeyEvent;
import androidx.compose.foundation.MagnifierStyle;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class SelectionManager_androidKt {
    /* renamed from: isCopyKeyEvent-ZmokQxo, reason: not valid java name */
    public static final boolean m639isCopyKeyEventZmokQxo(@NotNull KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(keyEvent, "keyEvent");
        return false;
    }

    @SuppressLint({"ModifierInspectorInfo"})
    @NotNull
    public static final Modifier selectionMagnifier(@NotNull Modifier modifier, @NotNull SelectionManager selectionManager) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(selectionManager, "manager");
        return !MagnifierStyle.Companion.getTextDefault().isSupported() ? modifier : ComposedModifierKt.composed$default(modifier, null, new selectionMagnifier.1(selectionManager), 1, null);
    }
}
