package androidx.compose.p004ui.input.key;

import android.view.KeyEvent;
import androidx.compose.p004ui.ExperimentalComposeUiApi;
import androidx.compose.p004ui.Modifier;
import androidx.core.app.NotificationCompat;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@ExperimentalComposeUiApi
/* loaded from: classes.dex */
public final class KeyInputInputModifierNodeImpl extends Modifier.Node implements KeyInputModifierNode {

    @Nullable
    private Function1<? super KeyEvent, Boolean> onEvent;

    @Nullable
    private Function1<? super KeyEvent, Boolean> onPreEvent;

    public KeyInputInputModifierNodeImpl(@Nullable Function1<? super KeyEvent, Boolean> function1, @Nullable Function1<? super KeyEvent, Boolean> function12) {
        this.onEvent = function1;
        this.onPreEvent = function12;
    }

    @Nullable
    public final Function1<KeyEvent, Boolean> getOnEvent() {
        return this.onEvent;
    }

    @Nullable
    public final Function1<KeyEvent, Boolean> getOnPreEvent() {
        return this.onPreEvent;
    }

    @Override // androidx.compose.p004ui.input.key.KeyInputModifierNode
    /* renamed from: onKeyEvent-ZmokQxo, reason: not valid java name */
    public boolean mo3971onKeyEventZmokQxo(@NotNull KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(keyEvent, NotificationCompat.CATEGORY_EVENT);
        Function1<? super KeyEvent, Boolean> function1 = this.onEvent;
        if (function1 != null) {
            return ((Boolean) function1.invoke(KeyEvent.m3947boximpl(keyEvent))).booleanValue();
        }
        return false;
    }

    @Override // androidx.compose.p004ui.input.key.KeyInputModifierNode
    /* renamed from: onPreKeyEvent-ZmokQxo, reason: not valid java name */
    public boolean mo3972onPreKeyEventZmokQxo(@NotNull KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(keyEvent, NotificationCompat.CATEGORY_EVENT);
        Function1<? super KeyEvent, Boolean> function1 = this.onPreEvent;
        if (function1 != null) {
            return ((Boolean) function1.invoke(KeyEvent.m3947boximpl(keyEvent))).booleanValue();
        }
        return false;
    }

    public final void setOnEvent(@Nullable Function1<? super KeyEvent, Boolean> function1) {
        this.onEvent = function1;
    }

    public final void setOnPreEvent(@Nullable Function1<? super KeyEvent, Boolean> function1) {
        this.onPreEvent = function1;
    }
}
