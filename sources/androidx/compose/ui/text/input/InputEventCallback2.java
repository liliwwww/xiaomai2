package androidx.compose.ui.text.input;

import android.view.KeyEvent;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public interface InputEventCallback2 {
    void onConnectionClosed(@NotNull RecordingInputConnection recordingInputConnection);

    void onEditCommands(@NotNull List<? extends EditCommand> list);

    /* renamed from: onImeAction-KlQnJC8, reason: not valid java name */
    void m2425onImeActionKlQnJC8(int i);

    void onKeyEvent(@NotNull KeyEvent keyEvent);
}
