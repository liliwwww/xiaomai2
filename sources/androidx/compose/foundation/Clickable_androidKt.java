package androidx.compose.foundation;

import android.view.KeyEvent;
import android.view.ViewConfiguration;
import androidx.compose.p004ui.input.key.KeyEventType;
import androidx.compose.p004ui.input.key.KeyEvent_androidKt;
import androidx.compose.p004ui.input.key.Key_androidKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class Clickable_androidKt {
    private static final long TapIndicationDelay = ViewConfiguration.getTapTimeout();

    public static final long getTapIndicationDelay() {
        return TapIndicationDelay;
    }

    /* renamed from: isClick-ZmokQxo, reason: not valid java name */
    public static final boolean m1161isClickZmokQxo(@NotNull KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(keyEvent, "$this$isClick");
        return KeyEventType.m3957equalsimpl0(KeyEvent_androidKt.m3965getTypeZmokQxo(keyEvent), KeyEventType.Companion.m3962getKeyUpCS__XNY()) && m1162isEnterZmokQxo(keyEvent);
    }

    /* renamed from: isEnter-ZmokQxo, reason: not valid java name */
    private static final boolean m1162isEnterZmokQxo(KeyEvent keyEvent) {
        int m3973getNativeKeyCodeYVgTNJs = Key_androidKt.m3973getNativeKeyCodeYVgTNJs(KeyEvent_androidKt.m3964getKeyZmokQxo(keyEvent));
        return m3973getNativeKeyCodeYVgTNJs == 23 || m3973getNativeKeyCodeYVgTNJs == 66 || m3973getNativeKeyCodeYVgTNJs == 160;
    }

    /* renamed from: isPress-ZmokQxo, reason: not valid java name */
    public static final boolean m1163isPressZmokQxo(@NotNull KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(keyEvent, "$this$isPress");
        return KeyEventType.m3957equalsimpl0(KeyEvent_androidKt.m3965getTypeZmokQxo(keyEvent), KeyEventType.Companion.m3961getKeyDownCS__XNY()) && m1162isEnterZmokQxo(keyEvent);
    }
}
