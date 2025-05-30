package androidx.compose.ui.semantics;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class ScrollAxisRange {
    public static final int $stable = 0;

    @NotNull
    private final Function0<Float> maxValue;
    private final boolean reverseScrolling;

    @NotNull
    private final Function0<Float> value;

    public ScrollAxisRange(@NotNull Function0<Float> function0, @NotNull Function0<Float> function02, boolean z) {
        Intrinsics.checkNotNullParameter(function0, "value");
        Intrinsics.checkNotNullParameter(function02, "maxValue");
        this.value = function0;
        this.maxValue = function02;
        this.reverseScrolling = z;
    }

    @NotNull
    public final Function0<Float> getMaxValue() {
        return this.maxValue;
    }

    public final boolean getReverseScrolling() {
        return this.reverseScrolling;
    }

    @NotNull
    public final Function0<Float> getValue() {
        return this.value;
    }

    @NotNull
    public String toString() {
        return "ScrollAxisRange(value=" + ((Number) this.value.invoke()).floatValue() + ", maxValue=" + ((Number) this.maxValue.invoke()).floatValue() + ", reverseScrolling=" + this.reverseScrolling + ')';
    }

    public /* synthetic */ ScrollAxisRange(Function0 function0, Function0 function02, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(function0, function02, (i & 4) != 0 ? false : z);
    }
}
