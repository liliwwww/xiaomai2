package androidx.compose.ui.tooling.preview;

import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public interface PreviewParameterProvider<T> {
    int getCount();

    @NotNull
    Sequence<T> getValues();
}
