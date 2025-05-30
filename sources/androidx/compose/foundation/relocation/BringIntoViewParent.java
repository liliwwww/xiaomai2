package androidx.compose.foundation.relocation;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public interface BringIntoViewParent {
    @Nullable
    Object bringChildIntoView(@NotNull LayoutCoordinates layoutCoordinates, @NotNull Function0<Rect> function0, @NotNull Continuation<? super Unit> continuation);
}
