package androidx.compose.p004ui.layout;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: classes.dex */
public final class VerticalAlignmentLine extends AlignmentLine {
    public static final int $stable = 0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VerticalAlignmentLine(@NotNull Function2<? super Integer, ? super Integer, Integer> function2) {
        super(function2, null);
        Intrinsics.checkNotNullParameter(function2, "merger");
    }
}
