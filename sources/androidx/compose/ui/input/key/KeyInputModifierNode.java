package androidx.compose.ui.input.key;

import androidx.compose.ui.ExperimentalComposeUiApi;
import androidx.compose.ui.node.DelegatableNode;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@ExperimentalComposeUiApi
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public interface KeyInputModifierNode extends DelegatableNode {
    /* renamed from: onKeyEvent-ZmokQxo, reason: not valid java name */
    boolean m1957onKeyEventZmokQxo(@NotNull android.view.KeyEvent keyEvent);

    /* renamed from: onPreKeyEvent-ZmokQxo, reason: not valid java name */
    boolean m1958onPreKeyEventZmokQxo(@NotNull android.view.KeyEvent keyEvent);
}
