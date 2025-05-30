package androidx.compose.foundation;

import android.view.KeyEvent;
import android.view.ViewConfiguration;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.Key_androidKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class Clickable_androidKt {
    private static final long TapIndicationDelay = ViewConfiguration.getTapTimeout();

    public static final long getTapIndicationDelay() {
        return TapIndicationDelay;
    }

    /* renamed from: isClick-ZmokQxo, reason: not valid java name */
    public static final boolean m127isClickZmokQxo(@NotNull KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(keyEvent, "$this$isClick");
        return KeyEventType.equals-impl0(KeyEvent_androidKt.getType-ZmokQxo(keyEvent), KeyEventType.Companion.m1388getKeyUpCS__XNY()) && m128isEnterZmokQxo(keyEvent);
    }

    /* renamed from: isEnter-ZmokQxo, reason: not valid java name */
    private static final boolean m128isEnterZmokQxo(KeyEvent keyEvent) {
        int m1392getNativeKeyCodeYVgTNJs = Key_androidKt.m1392getNativeKeyCodeYVgTNJs(KeyEvent_androidKt.getKey-ZmokQxo(keyEvent));
        return m1392getNativeKeyCodeYVgTNJs == 23 || m1392getNativeKeyCodeYVgTNJs == 66 || m1392getNativeKeyCodeYVgTNJs == 160;
    }

    /* renamed from: isPress-ZmokQxo, reason: not valid java name */
    public static final boolean m129isPressZmokQxo(@NotNull KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(keyEvent, "$this$isPress");
        return KeyEventType.equals-impl0(KeyEvent_androidKt.getType-ZmokQxo(keyEvent), KeyEventType.Companion.m1387getKeyDownCS__XNY()) && m128isEnterZmokQxo(keyEvent);
    }
}
