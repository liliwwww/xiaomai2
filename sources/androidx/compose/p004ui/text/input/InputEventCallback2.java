package androidx.compose.p004ui.text.input;

import android.view.KeyEvent;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface InputEventCallback2 {
    void onConnectionClosed(@NotNull RecordingInputConnection recordingInputConnection);

    void onEditCommands(@NotNull List<? extends EditCommand> list);

    /* renamed from: onImeAction-KlQnJC8, reason: not valid java name */
    void mo4909onImeActionKlQnJC8(int i);

    void onKeyEvent(@NotNull KeyEvent keyEvent);
}
