package androidx.compose.foundation.relocation;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.ui.geometry.Rect;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@ExperimentalFoundationApi
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public interface BringIntoViewResponder {
    @ExperimentalFoundationApi
    @Nullable
    Object bringChildIntoView(@NotNull Function0<Rect> function0, @NotNull Continuation<? super Unit> continuation);

    @ExperimentalFoundationApi
    @NotNull
    Rect calculateRectForParent(@NotNull Rect rect);
}
