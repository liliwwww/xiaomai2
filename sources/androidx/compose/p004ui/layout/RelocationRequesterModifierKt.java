package androidx.compose.p004ui.layout;

import androidx.compose.p004ui.ExperimentalComposeUiApi;
import androidx.compose.p004ui.Modifier;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class RelocationRequesterModifierKt {
    @Deprecated(level = DeprecationLevel.ERROR, message = "Please use bringIntoViewRequester instead.", replaceWith = @ReplaceWith(expression = "bringIntoViewRequester", imports = {"androidx.compose.foundation.relocation.bringIntoViewRequester"}))
    @ExperimentalComposeUiApi
    @NotNull
    public static final Modifier relocationRequester(@NotNull Modifier modifier, @NotNull Object obj) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(obj, "relocationRequester");
        return modifier;
    }
}
