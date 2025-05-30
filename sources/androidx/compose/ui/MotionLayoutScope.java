package androidx.compose.ui;

import androidx.compose.foundation.layout.LayoutScopeMarker;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.constraintlayout.core.motion.utils.TypedValues$Custom;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@LayoutScopeMarker
@StabilityInferred(parameters = 0)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001fB\u0011\b\u0001\u0012\u0006\u0010\u001c\u001a\u00020\u0019¢\u0006\u0004\b\u001d\u0010\u001eJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002J&\u0010\r\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002J\u0016\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002J&\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0013\u0010\u0014J&\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0017\u0010\fR\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006 "}, d2 = {"Landroidx/constraintlayout/compose/MotionLayoutScope;", "", "", "id", "Landroidx/compose/runtime/MutableState;", "Landroidx/constraintlayout/compose/MotionLayoutScope$MotionProperties;", "motionProperties", "(Ljava/lang/String;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/MutableState;", "tag", "name", "Landroidx/compose/ui/graphics/Color;", "motionColor-WaAFU9c", "(Ljava/lang/String;Ljava/lang/String;)J", "motionColor", "", "motionFloat", "", "motionInt", "Landroidx/compose/ui/unit/Dp;", "motionDistance-chRvn1I", "(Ljava/lang/String;Ljava/lang/String;)F", "motionDistance", "Landroidx/compose/ui/unit/TextUnit;", "motionFontSize-5XXgJZs", "motionFontSize", "Landroidx/constraintlayout/compose/MotionMeasurer;", "myMeasurer", "Landroidx/constraintlayout/compose/MotionMeasurer;", "measurer", "<init>", "(Landroidx/constraintlayout/compose/MotionMeasurer;)V", "MotionProperties", "compose_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class MotionLayoutScope {
    public static final int $stable = 8;

    @NotNull
    private MotionMeasurer myMeasurer;

    /* compiled from: Taobao */
    @StabilityInferred(parameters = 0)
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B#\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u001d\u001a\u00020\u001a¢\u0006\u0004\b\u001e\u0010\u001fJ\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002J\u001e\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0002J\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0002J\u001e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001e\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0013\u0010\bR\u0016\u0010\u0015\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006 "}, d2 = {"Landroidx/constraintlayout/compose/MotionLayoutScope$MotionProperties;", "", "", "id", "tag", "name", "Landroidx/compose/ui/graphics/Color;", "color-vNxB06k", "(Ljava/lang/String;)J", TypedValues$Custom.S_COLOR, "", TypedValues$Custom.S_FLOAT, "", "int", "Landroidx/compose/ui/unit/Dp;", "distance-u2uoSUM", "(Ljava/lang/String;)F", "distance", "Landroidx/compose/ui/unit/TextUnit;", "fontSize-kPz2Gy4", "fontSize", "myId", "Ljava/lang/String;", "", "myTag", "Ljava/lang/Void;", "Landroidx/constraintlayout/compose/MotionMeasurer;", "myMeasurer", "Landroidx/constraintlayout/compose/MotionMeasurer;", "measurer", "<init>", "(Ljava/lang/String;Ljava/lang/String;Landroidx/constraintlayout/compose/MotionMeasurer;)V", "compose_release"}, k = 1, mv = {1, 5, 1})
    public static final class MotionProperties {
        public static final int $stable = 8;

        @NotNull
        private String myId;

        @NotNull
        private MotionMeasurer myMeasurer;

        @Nullable
        private Void myTag;

        public MotionProperties(@NotNull String str, @Nullable String str2, @NotNull MotionMeasurer motionMeasurer) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(motionMeasurer, "measurer");
            this.myId = str;
            this.myMeasurer = motionMeasurer;
        }

        /* renamed from: color-vNxB06k, reason: not valid java name */
        public final long m2299colorvNxB06k(@NotNull String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            return this.myMeasurer.m2310getCustomColorWaAFU9c(this.myId, name);
        }

        /* renamed from: distance-u2uoSUM, reason: not valid java name */
        public final float m2300distanceu2uoSUM(@NotNull String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            return Dp.m2142constructorimpl(this.myMeasurer.getCustomFloat(this.myId, name));
        }

        /* renamed from: float, reason: not valid java name */
        public final float m2301float(@NotNull String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            return this.myMeasurer.getCustomFloat(this.myId, name);
        }

        /* renamed from: fontSize-kPz2Gy4, reason: not valid java name */
        public final long m2302fontSizekPz2Gy4(@NotNull String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            return TextUnitKt.getSp(this.myMeasurer.getCustomFloat(this.myId, name));
        }

        @NotNull
        /* renamed from: id, reason: from getter */
        public final String getMyId() {
            return this.myId;
        }

        /* renamed from: int, reason: not valid java name */
        public final int m2303int(@NotNull String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            return (int) this.myMeasurer.getCustomFloat(this.myId, name);
        }

        @Nullable
        public final String tag() {
            return (String) this.myTag;
        }
    }

    @PublishedApi
    public MotionLayoutScope(@NotNull MotionMeasurer motionMeasurer) {
        Intrinsics.checkNotNullParameter(motionMeasurer, "measurer");
        this.myMeasurer = motionMeasurer;
    }

    /* renamed from: motionColor-WaAFU9c, reason: not valid java name */
    public final long m2296motionColorWaAFU9c(@NotNull String id, @NotNull String name) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        return this.myMeasurer.m2310getCustomColorWaAFU9c(id, name);
    }

    /* renamed from: motionDistance-chRvn1I, reason: not valid java name */
    public final float m2297motionDistancechRvn1I(@NotNull String id, @NotNull String name) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        return Dp.m2142constructorimpl(this.myMeasurer.getCustomFloat(id, name));
    }

    public final float motionFloat(@NotNull String id, @NotNull String name) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        return this.myMeasurer.getCustomFloat(id, name);
    }

    /* renamed from: motionFontSize-5XXgJZs, reason: not valid java name */
    public final long m2298motionFontSize5XXgJZs(@NotNull String id, @NotNull String name) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        return TextUnitKt.getSp(this.myMeasurer.getCustomFloat(id, name));
    }

    public final int motionInt(@NotNull String id, @NotNull String name) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        return (int) this.myMeasurer.getCustomFloat(id, name);
    }

    @Composable
    @NotNull
    public final MutableState<MotionProperties> motionProperties(@NotNull String str, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(str, "id");
        composer.startReplaceableGroup(-1035552373);
        composer.startReplaceableGroup(-3687241);
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = SnapshotStateKt.mutableStateOf$default(new MotionProperties(str, null, this.myMeasurer), (SnapshotMutationPolicy) null, 2, (Object) null);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        MutableState<MotionProperties> mutableState = (MutableState) rememberedValue;
        composer.endReplaceableGroup();
        return mutableState;
    }

    @NotNull
    public final MotionProperties motionProperties(@NotNull String id, @NotNull String tag) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(tag, "tag");
        return new MotionProperties(id, tag, this.myMeasurer);
    }
}
