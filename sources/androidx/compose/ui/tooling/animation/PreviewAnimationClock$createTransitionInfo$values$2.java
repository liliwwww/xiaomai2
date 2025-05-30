package androidx.compose.ui.tooling.animation;

import androidx.compose.animation.core.Transition;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class PreviewAnimationClock$createTransitionInfo$values$2<T> extends Lambda implements Function0<Map<Long, T>> {
    final /* synthetic */ long $endTimeMs;
    final /* synthetic */ Lazy<Long> $startTimeMs$delegate;
    final /* synthetic */ long $stepMs;
    final /* synthetic */ Transition<S>.TransitionAnimationState<T, V> $this_createTransitionInfo;
    final /* synthetic */ PreviewAnimationClock this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PreviewAnimationClock$createTransitionInfo$values$2(Transition<S>.TransitionAnimationState<T, V> transitionAnimationState, PreviewAnimationClock previewAnimationClock, long j, long j2, Lazy<Long> lazy) {
        super(0);
        this.$this_createTransitionInfo = transitionAnimationState;
        this.this$0 = previewAnimationClock;
        this.$endTimeMs = j;
        this.$stepMs = j2;
        this.$startTimeMs$delegate = lazy;
    }

    @NotNull
    public final Map<Long, T> invoke() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(Long.valueOf(PreviewAnimationClock.access$createTransitionInfo$lambda-21(this.$startTimeMs$delegate)), this.$this_createTransitionInfo.getAnimation().getValueFromNanos(PreviewAnimationClock.access$millisToNanos(this.this$0, PreviewAnimationClock.access$createTransitionInfo$lambda-21(this.$startTimeMs$delegate))));
        linkedHashMap.put(Long.valueOf(this.$endTimeMs), this.$this_createTransitionInfo.getAnimation().getValueFromNanos(PreviewAnimationClock.access$millisToNanos(this.this$0, this.$endTimeMs)));
        long j = PreviewAnimationClock.access$createTransitionInfo$lambda-21(this.$startTimeMs$delegate);
        long j2 = this.$stepMs;
        if (j2 <= 0) {
            throw new IllegalArgumentException("Step must be positive, was: " + this.$stepMs + '.');
        }
        long progressionLastElement = ProgressionUtilKt.getProgressionLastElement(j, this.$endTimeMs, j2);
        if (j <= progressionLastElement) {
            while (true) {
                linkedHashMap.put(Long.valueOf(j), this.$this_createTransitionInfo.getAnimation().getValueFromNanos(PreviewAnimationClock.access$millisToNanos(this.this$0, j)));
                if (j == progressionLastElement) {
                    break;
                }
                j += this.$stepMs;
            }
        }
        return linkedHashMap;
    }
}
