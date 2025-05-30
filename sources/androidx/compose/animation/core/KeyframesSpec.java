package androidx.compose.animation.core;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.internal.StabilityInferred;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Immutable
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class KeyframesSpec<T> implements DurationBasedAnimationSpec<T> {

    @NotNull
    private final KeyframesSpecConfig<T> config;

    /* compiled from: Taobao */
    @StabilityInferred(parameters = 0)
    public static final class KeyframesSpecConfig<T> {
        public static final int $stable = 8;
        private int delayMillis;
        private int durationMillis = 300;

        @NotNull
        private final Map<Integer, KeyframeEntity<T>> keyframes = new LinkedHashMap();

        @NotNull
        public final KeyframeEntity<T> at(T t, int i) {
            Easing easing = null;
            KeyframeEntity<T> keyframeEntity = new KeyframeEntity<>(t, easing, 2, easing);
            this.keyframes.put(Integer.valueOf(i), keyframeEntity);
            return keyframeEntity;
        }

        @NotNull
        public final KeyframeEntity<T> atFraction(T t, float f) {
            return at(t, MathKt.roundToInt(this.durationMillis * f));
        }

        public boolean equals(@Nullable Object obj) {
            if (obj instanceof KeyframesSpecConfig) {
                KeyframesSpecConfig keyframesSpecConfig = (KeyframesSpecConfig) obj;
                if (this.delayMillis == keyframesSpecConfig.delayMillis && this.durationMillis == keyframesSpecConfig.durationMillis && Intrinsics.areEqual(this.keyframes, keyframesSpecConfig.keyframes)) {
                    return true;
                }
            }
            return false;
        }

        public final int getDelayMillis() {
            return this.delayMillis;
        }

        public final int getDurationMillis() {
            return this.durationMillis;
        }

        @NotNull
        public final Map<Integer, KeyframeEntity<T>> getKeyframes$animation_core_release() {
            return this.keyframes;
        }

        public int hashCode() {
            return (((this.durationMillis * 31) + this.delayMillis) * 31) + this.keyframes.hashCode();
        }

        public final void setDelayMillis(int i) {
            this.delayMillis = i;
        }

        public final void setDurationMillis(int i) {
            this.durationMillis = i;
        }

        public final void with(@NotNull KeyframeEntity<T> keyframeEntity, @NotNull Easing easing) {
            Intrinsics.checkNotNullParameter(keyframeEntity, "<this>");
            Intrinsics.checkNotNullParameter(easing, "easing");
            keyframeEntity.setEasing$animation_core_release(easing);
        }
    }

    public KeyframesSpec(@NotNull KeyframesSpecConfig<T> keyframesSpecConfig) {
        Intrinsics.checkNotNullParameter(keyframesSpecConfig, "config");
        this.config = keyframesSpecConfig;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof KeyframesSpec) && Intrinsics.areEqual(this.config, ((KeyframesSpec) obj).config);
    }

    @NotNull
    public final KeyframesSpecConfig<T> getConfig() {
        return this.config;
    }

    public int hashCode() {
        return this.config.hashCode();
    }

    /* compiled from: Taobao */
    @StabilityInferred(parameters = 0)
    public static final class KeyframeEntity<T> {
        public static final int $stable = 8;

        @NotNull
        private Easing easing;
        private final T value;

        public KeyframeEntity(T t, @NotNull Easing easing) {
            Intrinsics.checkNotNullParameter(easing, "easing");
            this.value = t;
            this.easing = easing;
        }

        public boolean equals(@Nullable Object obj) {
            if (obj instanceof KeyframeEntity) {
                KeyframeEntity keyframeEntity = (KeyframeEntity) obj;
                if (Intrinsics.areEqual(keyframeEntity.value, this.value) && Intrinsics.areEqual(keyframeEntity.easing, this.easing)) {
                    return true;
                }
            }
            return false;
        }

        @NotNull
        public final Easing getEasing$animation_core_release() {
            return this.easing;
        }

        public final T getValue$animation_core_release() {
            return this.value;
        }

        public int hashCode() {
            T t = this.value;
            return ((t != null ? t.hashCode() : 0) * 31) + this.easing.hashCode();
        }

        public final void setEasing$animation_core_release(@NotNull Easing easing) {
            Intrinsics.checkNotNullParameter(easing, "<set-?>");
            this.easing = easing;
        }

        @NotNull
        public final <V extends AnimationVector> Pair<V, Easing> toPair$animation_core_release(@NotNull Function1<? super T, ? extends V> function1) {
            Intrinsics.checkNotNullParameter(function1, "convertToVector");
            return TuplesKt.to(function1.invoke(this.value), this.easing);
        }

        public /* synthetic */ KeyframeEntity(Object obj, Easing easing, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(obj, (i & 2) != 0 ? EasingKt.getLinearEasing() : easing);
        }
    }

    @NotNull
    /* renamed from: vectorize, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public <V extends AnimationVector> VectorizedKeyframesSpec<V> m70vectorize(@NotNull TwoWayConverter<T, V> twoWayConverter) {
        Intrinsics.checkNotNullParameter(twoWayConverter, "converter");
        Map<Integer, KeyframeEntity<T>> keyframes$animation_core_release = this.config.getKeyframes$animation_core_release();
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(keyframes$animation_core_release.size()));
        Iterator<T> it = keyframes$animation_core_release.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(entry.getKey(), ((KeyframeEntity) entry.getValue()).toPair$animation_core_release(twoWayConverter.getConvertToVector()));
        }
        return new VectorizedKeyframesSpec<>(linkedHashMap, this.config.getDurationMillis(), this.config.getDelayMillis());
    }
}
