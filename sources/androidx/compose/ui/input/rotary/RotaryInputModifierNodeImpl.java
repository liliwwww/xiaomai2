package androidx.compose.ui.input.rotary;

import androidx.compose.ui.Modifier;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class RotaryInputModifierNodeImpl extends Modifier.Node implements RotaryInputModifierNode {

    @Nullable
    private Function1<? super RotaryScrollEvent, Boolean> onEvent;

    @Nullable
    private Function1<? super RotaryScrollEvent, Boolean> onPreEvent;

    public RotaryInputModifierNodeImpl(@Nullable Function1<? super RotaryScrollEvent, Boolean> function1, @Nullable Function1<? super RotaryScrollEvent, Boolean> function12) {
        this.onEvent = function1;
        this.onPreEvent = function12;
    }

    @Nullable
    public final Function1<RotaryScrollEvent, Boolean> getOnEvent() {
        return this.onEvent;
    }

    @Nullable
    public final Function1<RotaryScrollEvent, Boolean> getOnPreEvent() {
        return this.onPreEvent;
    }

    public boolean onPreRotaryScrollEvent(@NotNull RotaryScrollEvent rotaryScrollEvent) {
        Intrinsics.checkNotNullParameter(rotaryScrollEvent, "event");
        Function1<? super RotaryScrollEvent, Boolean> function1 = this.onPreEvent;
        if (function1 != null) {
            return ((Boolean) function1.invoke(rotaryScrollEvent)).booleanValue();
        }
        return false;
    }

    public boolean onRotaryScrollEvent(@NotNull RotaryScrollEvent rotaryScrollEvent) {
        Intrinsics.checkNotNullParameter(rotaryScrollEvent, "event");
        Function1<? super RotaryScrollEvent, Boolean> function1 = this.onEvent;
        if (function1 != null) {
            return ((Boolean) function1.invoke(rotaryScrollEvent)).booleanValue();
        }
        return false;
    }

    public final void setOnEvent(@Nullable Function1<? super RotaryScrollEvent, Boolean> function1) {
        this.onEvent = function1;
    }

    public final void setOnPreEvent(@Nullable Function1<? super RotaryScrollEvent, Boolean> function1) {
        this.onPreEvent = function1;
    }
}
