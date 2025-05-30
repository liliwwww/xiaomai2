package androidx.compose.p004ui.input.key;

import android.view.KeyEvent;
import androidx.compose.p004ui.ExperimentalComposeUiApi;
import androidx.compose.p004ui.node.DelegatableNode;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@ExperimentalComposeUiApi
/* loaded from: classes2.dex */
public interface KeyInputModifierNode extends DelegatableNode {
    /* renamed from: onKeyEvent-ZmokQxo */
    boolean mo3971onKeyEventZmokQxo(@NotNull KeyEvent keyEvent);

    /* renamed from: onPreKeyEvent-ZmokQxo */
    boolean mo3972onPreKeyEventZmokQxo(@NotNull KeyEvent keyEvent);
}
