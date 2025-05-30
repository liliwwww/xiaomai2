package androidx.compose.material;

import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.State;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.d;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class RangeSliderLogic {

    @NotNull
    private final MutableInteractionSource endInteractionSource;

    @NotNull
    private final State<Function2<Boolean, Float, Unit>> onDrag;

    @NotNull
    private final State<Float> rawOffsetEnd;

    @NotNull
    private final State<Float> rawOffsetStart;

    @NotNull
    private final MutableInteractionSource startInteractionSource;

    public RangeSliderLogic(@NotNull MutableInteractionSource mutableInteractionSource, @NotNull MutableInteractionSource mutableInteractionSource2, @NotNull State<Float> state, @NotNull State<Float> state2, @NotNull State<? extends Function2<? super Boolean, ? super Float, Unit>> state3) {
        Intrinsics.checkNotNullParameter(mutableInteractionSource, "startInteractionSource");
        Intrinsics.checkNotNullParameter(mutableInteractionSource2, "endInteractionSource");
        Intrinsics.checkNotNullParameter(state, "rawOffsetStart");
        Intrinsics.checkNotNullParameter(state2, "rawOffsetEnd");
        Intrinsics.checkNotNullParameter(state3, "onDrag");
        this.startInteractionSource = mutableInteractionSource;
        this.endInteractionSource = mutableInteractionSource2;
        this.rawOffsetStart = state;
        this.rawOffsetEnd = state2;
        this.onDrag = state3;
    }

    @NotNull
    public final MutableInteractionSource activeInteraction(boolean z) {
        return z ? this.startInteractionSource : this.endInteractionSource;
    }

    public final void captureThumb(boolean z, float f, @NotNull Interaction interaction, @NotNull CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(interaction, "interaction");
        Intrinsics.checkNotNullParameter(coroutineScope, "scope");
        ((Function2) this.onDrag.getValue()).invoke(Boolean.valueOf(z), Float.valueOf(f - ((Number) (z ? this.rawOffsetStart : this.rawOffsetEnd).getValue()).floatValue()));
        d.d(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new captureThumb.1(this, z, interaction, (Continuation) null), 3, (Object) null);
    }

    public final int compareOffsets(float f) {
        return Float.compare(Math.abs(((Number) this.rawOffsetStart.getValue()).floatValue() - f), Math.abs(((Number) this.rawOffsetEnd.getValue()).floatValue() - f));
    }

    @NotNull
    public final MutableInteractionSource getEndInteractionSource() {
        return this.endInteractionSource;
    }

    @NotNull
    public final State<Function2<Boolean, Float, Unit>> getOnDrag() {
        return this.onDrag;
    }

    @NotNull
    public final State<Float> getRawOffsetEnd() {
        return this.rawOffsetEnd;
    }

    @NotNull
    public final State<Float> getRawOffsetStart() {
        return this.rawOffsetStart;
    }

    @NotNull
    public final MutableInteractionSource getStartInteractionSource() {
        return this.startInteractionSource;
    }
}
