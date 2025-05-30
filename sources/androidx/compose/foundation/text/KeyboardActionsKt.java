package androidx.compose.foundation.text;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class KeyboardActionsKt {
    @NotNull
    public static final KeyboardActions KeyboardActions(@NotNull Function1<? super KeyboardActionScope, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "onAny");
        return new KeyboardActions(function1, function1, function1, function1, function1, function1);
    }
}
