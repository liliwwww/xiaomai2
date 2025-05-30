package androidx.compose.material.pullrefresh;

import androidx.compose.material.ExperimentalMaterialApi;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.d;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
@ExperimentalMaterialApi
/* loaded from: classes2.dex */
public final class PullRefreshState {
    public static final int $stable = 8;

    @NotNull
    private final MutableState _position$delegate;

    @NotNull
    private final MutableState _refreshing$delegate;

    @NotNull
    private final State adjustedDistancePulled$delegate;

    @NotNull
    private final CoroutineScope animationScope;

    @NotNull
    private final MutableState distancePulled$delegate;

    @NotNull
    private final State<Function0<Unit>> onRefreshState;
    private final float refreshingOffset;
    private final float threshold;

    public PullRefreshState(@NotNull CoroutineScope coroutineScope, @NotNull State<? extends Function0<Unit>> state, float f, float f2) {
        Intrinsics.checkNotNullParameter(coroutineScope, "animationScope");
        Intrinsics.checkNotNullParameter(state, "onRefreshState");
        this.animationScope = coroutineScope;
        this.onRefreshState = state;
        this.refreshingOffset = f;
        this.threshold = f2;
        this.adjustedDistancePulled$delegate = SnapshotStateKt.derivedStateOf(new Function0<Float>() { // from class: androidx.compose.material.pullrefresh.PullRefreshState$adjustedDistancePulled$2
            {
                super(0);
            }

            @NotNull
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Float m2363invoke() {
                float distancePulled;
                distancePulled = PullRefreshState.this.getDistancePulled();
                return Float.valueOf(distancePulled * 0.5f);
            }
        });
        this._refreshing$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        Float valueOf = Float.valueOf(0.0f);
        this._position$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(valueOf, null, 2, null);
        this.distancePulled$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(valueOf, null, 2, null);
    }

    private final Job animateIndicatorTo(float f) {
        return d.d(this.animationScope, (CoroutineContext) null, (CoroutineStart) null, new PullRefreshState$animateIndicatorTo$1(this, f, null), 3, (Object) null);
    }

    private final float calculateIndicatorPosition() {
        if (getAdjustedDistancePulled() <= this.threshold) {
            return getAdjustedDistancePulled();
        }
        float coerceIn = RangesKt.coerceIn(Math.abs(getProgress()) - 1.0f, 0.0f, 2.0f);
        float pow = coerceIn - (((float) Math.pow(coerceIn, 2)) / 4);
        float f = this.threshold;
        return (pow * f) + f;
    }

    private final float getAdjustedDistancePulled() {
        return ((Number) this.adjustedDistancePulled$delegate.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final float getDistancePulled() {
        return ((Number) this.distancePulled$delegate.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final float get_position() {
        return ((Number) this._position$delegate.getValue()).floatValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean get_refreshing() {
        return ((Boolean) this._refreshing$delegate.getValue()).booleanValue();
    }

    private final void setDistancePulled(float f) {
        this.distancePulled$delegate.setValue(Float.valueOf(f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void set_position(float f) {
        this._position$delegate.setValue(Float.valueOf(f));
    }

    private final void set_refreshing(boolean z) {
        this._refreshing$delegate.setValue(Boolean.valueOf(z));
    }

    public final float getPosition$material_release() {
        return get_position();
    }

    public final float getProgress() {
        return getAdjustedDistancePulled() / this.threshold;
    }

    public final boolean getRefreshing$material_release() {
        return get_refreshing();
    }

    public final float getThreshold$material_release() {
        return this.threshold;
    }

    public final float onPull$material_release(float f) {
        if (get_refreshing()) {
            return 0.0f;
        }
        float coerceAtLeast = RangesKt.coerceAtLeast(getDistancePulled() + f, 0.0f);
        float distancePulled = coerceAtLeast - getDistancePulled();
        setDistancePulled(coerceAtLeast);
        set_position(calculateIndicatorPosition());
        return distancePulled;
    }

    public final void onRelease$material_release() {
        if (!get_refreshing()) {
            if (getAdjustedDistancePulled() > this.threshold) {
                this.onRefreshState.getValue().invoke();
            } else {
                animateIndicatorTo(0.0f);
            }
        }
        setDistancePulled(0.0f);
    }

    public final void setRefreshing$material_release(boolean z) {
        if (get_refreshing() != z) {
            set_refreshing(z);
            setDistancePulled(0.0f);
            animateIndicatorTo(z ? this.refreshingOffset : 0.0f);
        }
    }
}
