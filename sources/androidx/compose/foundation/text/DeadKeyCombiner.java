package androidx.compose.foundation.text;

import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import androidx.compose.p004ui.input.key.KeyEvent_androidKt;
import androidx.core.app.NotificationCompat;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class DeadKeyCombiner {

    @Nullable
    private Integer deadKeyCode;

    @Nullable
    /* renamed from: consume-ZmokQxo, reason: not valid java name */
    public final Integer m1726consumeZmokQxo(@NotNull KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(keyEvent, NotificationCompat.CATEGORY_EVENT);
        int m3966getUtf16CodePointZmokQxo = KeyEvent_androidKt.m3966getUtf16CodePointZmokQxo(keyEvent);
        if ((Integer.MIN_VALUE & m3966getUtf16CodePointZmokQxo) != 0) {
            this.deadKeyCode = Integer.valueOf(m3966getUtf16CodePointZmokQxo & Integer.MAX_VALUE);
            return null;
        }
        Integer num = this.deadKeyCode;
        if (num == null) {
            return Integer.valueOf(m3966getUtf16CodePointZmokQxo);
        }
        this.deadKeyCode = null;
        Integer valueOf = Integer.valueOf(KeyCharacterMap.getDeadChar(num.intValue(), m3966getUtf16CodePointZmokQxo));
        Integer num2 = valueOf.intValue() == 0 ? null : valueOf;
        return num2 == null ? Integer.valueOf(m3966getUtf16CodePointZmokQxo) : num2;
    }
}
