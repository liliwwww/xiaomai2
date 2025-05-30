package androidx.compose.foundation.text;

import android.view.KeyEvent;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class KeyEventHelpers_androidKt {
    /* renamed from: cancelsTextSelection-ZmokQxo, reason: not valid java name */
    public static final boolean m395cancelsTextSelectionZmokQxo(@NotNull KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(keyEvent, "$this$cancelsTextSelection");
        return keyEvent.getKeyCode() == 4 && KeyEventType.equals-impl0(KeyEvent_androidKt.getType-ZmokQxo(keyEvent), KeyEventType.Companion.m1388getKeyUpCS__XNY());
    }

    public static final void showCharacterPalette() {
    }
}
