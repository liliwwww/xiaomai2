package androidx.compose.ui.focus;

import androidx.compose.ui.Modifier;
import kotlin.Deprecated;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Deprecated(message = "Use FocusRequesterModifierNode instead")
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public interface FocusRequesterModifier extends Modifier.Element {
    @NotNull
    FocusRequester getFocusRequester();
}
