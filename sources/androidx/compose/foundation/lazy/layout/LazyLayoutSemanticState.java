package androidx.compose.foundation.lazy.layout;

import androidx.compose.ui.semantics.CollectionInfo;
import androidx.compose.ui.semantics.ScrollAxisRange;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public interface LazyLayoutSemanticState {
    @Nullable
    Object animateScrollBy(float f, @NotNull Continuation<? super Unit> continuation);

    @NotNull
    CollectionInfo collectionInfo();

    @NotNull
    ScrollAxisRange scrollAxisRange();

    @Nullable
    Object scrollToItem(int i, @NotNull Continuation<? super Unit> continuation);
}
