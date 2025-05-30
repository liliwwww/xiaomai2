package androidx.compose.ui.focus;

import androidx.compose.ui.Modifier$Element;
import kotlin.Deprecated;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Deprecated(message = "Use FocusEventModifierNode instead")
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public interface FocusEventModifier extends Modifier$Element {
    void onFocusEvent(@NotNull FocusState focusState);
}
