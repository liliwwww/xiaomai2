package androidx.compose.p004ui.draw;

import androidx.compose.p004ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: classes2.dex */
public final class DrawResult {
    public static final int $stable = 8;

    @NotNull
    private Function1<? super ContentDrawScope, Unit> block;

    public DrawResult(@NotNull Function1<? super ContentDrawScope, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        this.block = function1;
    }

    @NotNull
    public final Function1<ContentDrawScope, Unit> getBlock$ui_release() {
        return this.block;
    }

    public final void setBlock$ui_release(@NotNull Function1<? super ContentDrawScope, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.block = function1;
    }
}
