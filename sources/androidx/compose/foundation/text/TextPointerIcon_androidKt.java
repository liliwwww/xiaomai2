package androidx.compose.foundation.text;

import androidx.compose.ui.input.pointer.PointerIcon;
import androidx.compose.ui.input.pointer.PointerIcon_androidKt;
import androidx.core.view.PointerIconCompat;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class TextPointerIcon_androidKt {

    @NotNull
    private static final PointerIcon textPointerIcon = PointerIcon_androidKt.PointerIcon(PointerIconCompat.TYPE_TEXT);

    @NotNull
    public static final PointerIcon getTextPointerIcon() {
        return textPointerIcon;
    }
}
