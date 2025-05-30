package androidx.compose.ui.input.pointer;

import androidx.compose.ui.Modifier;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public interface PointerInputModifier extends Modifier.Element {
    @NotNull
    PointerInputFilter getPointerInputFilter();
}
