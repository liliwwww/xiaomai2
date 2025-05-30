package androidx.compose.p004ui.layout;

import androidx.compose.p004ui.ExperimentalComposeUiApi;
import androidx.compose.p004ui.geometry.Rect;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
@Deprecated(level = DeprecationLevel.ERROR, message = "Please use BringIntoViewRequester instead.", replaceWith = @ReplaceWith(expression = "BringIntoViewRequester", imports = {"androidx.compose.foundation.relocation.BringIntoViewRequester"}))
@ExperimentalComposeUiApi
/* loaded from: classes.dex */
public final class RelocationRequester {
    public static final int $stable = 0;

    public static /* synthetic */ Object bringIntoView$default(RelocationRequester relocationRequester, Rect rect, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            rect = null;
        }
        return relocationRequester.bringIntoView(rect, continuation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Please use BringIntoViewRequester instead.", replaceWith = @ReplaceWith(expression = "bringIntoView", imports = {"androidx.compose.foundation.relocation.BringIntoViewRequester"}))
    @Nullable
    public final Object bringIntoView(@Nullable Rect rect, @NotNull Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }
}
