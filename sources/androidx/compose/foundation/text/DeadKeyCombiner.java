package androidx.compose.foundation.text;

import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.core.app.NotificationCompat;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class DeadKeyCombiner {

    @Nullable
    private Integer deadKeyCode;

    @Nullable
    /* renamed from: consume-ZmokQxo, reason: not valid java name */
    public final Integer m393consumeZmokQxo(@NotNull KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(keyEvent, NotificationCompat.CATEGORY_EVENT);
        int i = KeyEvent_androidKt.getUtf16CodePoint-ZmokQxo(keyEvent);
        if ((Integer.MIN_VALUE & i) != 0) {
            this.deadKeyCode = Integer.valueOf(i & Integer.MAX_VALUE);
            return null;
        }
        Integer num = this.deadKeyCode;
        if (num == null) {
            return Integer.valueOf(i);
        }
        this.deadKeyCode = null;
        Integer valueOf = Integer.valueOf(KeyCharacterMap.getDeadChar(num.intValue(), i));
        Integer num2 = valueOf.intValue() == 0 ? null : valueOf;
        return num2 == null ? Integer.valueOf(i) : num2;
    }
}
