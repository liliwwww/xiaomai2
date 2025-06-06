package androidx.compose.foundation.relocation;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.ui.geometry.Rect;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@ExperimentalFoundationApi
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public interface BringIntoViewRequester {
    @Nullable
    Object bringIntoView(@Nullable Rect rect, @NotNull Continuation<? super Unit> continuation);
}
