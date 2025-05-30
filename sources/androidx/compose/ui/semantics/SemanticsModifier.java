package androidx.compose.ui.semantics;

import androidx.compose.ui.Modifier;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public interface SemanticsModifier extends Modifier.Element {
    int getId();

    @NotNull
    SemanticsConfiguration getSemanticsConfiguration();
}
