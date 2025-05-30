package androidx.compose.p004ui.node;

import android.view.KeyEvent;
import androidx.compose.p004ui.ExperimentalComposeUiApi;
import androidx.compose.p004ui.semantics.SemanticsOwner;
import androidx.compose.p004ui.text.input.TextInputService;
import androidx.compose.p004ui.unit.Density;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface RootForTest {
    @NotNull
    Density getDensity();

    @NotNull
    SemanticsOwner getSemanticsOwner();

    @NotNull
    TextInputService getTextInputService();

    @ExperimentalComposeUiApi
    void measureAndLayoutForTest();

    /* renamed from: sendKeyEvent-ZmokQxo, reason: not valid java name */
    boolean mo4451sendKeyEventZmokQxo(@NotNull KeyEvent keyEvent);
}
