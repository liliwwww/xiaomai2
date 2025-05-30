package androidx.compose.foundation.text;

import android.view.KeyEvent;
import androidx.compose.p004ui.input.key.KeyEventType;
import androidx.compose.p004ui.input.key.KeyEvent_androidKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class KeyEventHelpers_androidKt {
    /* renamed from: cancelsTextSelection-ZmokQxo, reason: not valid java name */
    public static final boolean m1727cancelsTextSelectionZmokQxo(@NotNull KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(keyEvent, "$this$cancelsTextSelection");
        return keyEvent.getKeyCode() == 4 && KeyEventType.m3957equalsimpl0(KeyEvent_androidKt.m3965getTypeZmokQxo(keyEvent), KeyEventType.Companion.m3962getKeyUpCS__XNY());
    }

    public static final void showCharacterPalette() {
    }
}
