package androidx.compose.animation;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.p004ui.layout.Measurable;
import androidx.compose.p004ui.layout.MeasureResult;
import androidx.compose.p004ui.layout.MeasureScope;
import androidx.compose.p004ui.layout.Placeable;
import androidx.compose.p004ui.unit.IntSize;
import androidx.compose.p004ui.unit.IntSizeKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
final class SizeAnimationModifier extends LayoutModifierWithPassThroughIntrinsics {

    @NotNull
    private final MutableState animData$delegate;

    @NotNull
    private final AnimationSpec<IntSize> animSpec;

    @Nullable
    private Function2<? super IntSize, ? super IntSize, Unit> listener;

    @NotNull
    private final CoroutineScope scope;

    /* compiled from: Taobao */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes.dex */
    public static final class AnimData {
        public static final int $stable = 8;

        @NotNull
        private final Animatable<IntSize, AnimationVector2D> anim;
        private long startSize;

        private AnimData(Animatable<IntSize, AnimationVector2D> animatable, long j) {
            this.anim = animatable;
            this.startSize = j;
        }

        public /* synthetic */ AnimData(Animatable animatable, long j, DefaultConstructorMarker defaultConstructorMarker) {
            this(animatable, j);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: copy-O0kMr_c$default, reason: not valid java name */
        public static /* synthetic */ AnimData m1023copyO0kMr_c$default(AnimData animData, Animatable animatable, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                animatable = animData.anim;
            }
            if ((i & 2) != 0) {
                j = animData.startSize;
            }
            return animData.m1025copyO0kMr_c(animatable, j);
        }

        @NotNull
        public final Animatable<IntSize, AnimationVector2D> component1() {
            return this.anim;
        }

        /* renamed from: component2-YbymL2g, reason: not valid java name */
        public final long m1024component2YbymL2g() {
            return this.startSize;
        }

        @NotNull
        /* renamed from: copy-O0kMr_c, reason: not valid java name */
        public final AnimData m1025copyO0kMr_c(@NotNull Animatable<IntSize, AnimationVector2D> animatable, long j) {
            Intrinsics.checkNotNullParameter(animatable, "anim");
            return new AnimData(animatable, j, null);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AnimData)) {
                return false;
            }
            AnimData animData = (AnimData) obj;
            return Intrinsics.areEqual(this.anim, animData.anim) && IntSize.m5374equalsimpl0(this.startSize, animData.startSize);
        }

        @NotNull
        public final Animatable<IntSize, AnimationVector2D> getAnim() {
            return this.anim;
        }

        /* renamed from: getStartSize-YbymL2g, reason: not valid java name */
        public final long m1026getStartSizeYbymL2g() {
            return this.startSize;
        }

        public int hashCode() {
            return (this.anim.hashCode() * 31) + IntSize.m5377hashCodeimpl(this.startSize);
        }

        /* renamed from: setStartSize-ozmzZPI, reason: not valid java name */
        public final void m1027setStartSizeozmzZPI(long j) {
            this.startSize = j;
        }

        @NotNull
        public String toString() {
            return "AnimData(anim=" + this.anim + ", startSize=" + ((Object) IntSize.m5379toStringimpl(this.startSize)) + ')';
        }
    }

    public SizeAnimationModifier(@NotNull AnimationSpec<IntSize> animationSpec, @NotNull CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(animationSpec, "animSpec");
        Intrinsics.checkNotNullParameter(coroutineScope, "scope");
        this.animSpec = animationSpec;
        this.scope = coroutineScope;
        this.animData$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
    }

    /* renamed from: animateTo-mzRDjE0, reason: not valid java name */
    public final long m1022animateTomzRDjE0(long j) {
        AnimData animData = getAnimData();
        if (animData == null) {
            animData = new AnimData(new Animatable(IntSize.m5368boximpl(j), VectorConvertersKt.getVectorConverter(IntSize.Companion), IntSize.m5368boximpl(IntSizeKt.IntSize(1, 1)), null, 8, null), j, null);
        } else if (!IntSize.m5374equalsimpl0(j, animData.getAnim().getTargetValue().m5380unboximpl())) {
            animData.m1027setStartSizeozmzZPI(animData.getAnim().getValue().m5380unboximpl());
            d.d(this.scope, (CoroutineContext) null, (CoroutineStart) null, new SizeAnimationModifier$animateTo$data$1$1(animData, j, this, null), 3, (Object) null);
        }
        setAnimData(animData);
        return animData.getAnim().getValue().m5380unboximpl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public final AnimData getAnimData() {
        return (AnimData) this.animData$delegate.getValue();
    }

    @NotNull
    public final AnimationSpec<IntSize> getAnimSpec() {
        return this.animSpec;
    }

    @Nullable
    public final Function2<IntSize, IntSize, Unit> getListener() {
        return this.listener;
    }

    @NotNull
    public final CoroutineScope getScope() {
        return this.scope;
    }

    @Override // androidx.compose.p004ui.layout.LayoutModifier
    @NotNull
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo959measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull Measurable measurable, long j) {
        Intrinsics.checkNotNullParameter(measureScope, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        final Placeable mo4187measureBRTryo0 = measurable.mo4187measureBRTryo0(j);
        long m1022animateTomzRDjE0 = m1022animateTomzRDjE0(IntSizeKt.IntSize(mo4187measureBRTryo0.getWidth(), mo4187measureBRTryo0.getHeight()));
        return MeasureScope.CC.m140p(measureScope, IntSize.m5376getWidthimpl(m1022animateTomzRDjE0), IntSize.m5375getHeightimpl(m1022animateTomzRDjE0), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.SizeAnimationModifier$measure$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull Placeable.PlacementScope placementScope) {
                Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
                Placeable.PlacementScope.placeRelative$default(placementScope, Placeable.this, 0, 0, 0.0f, 4, null);
            }
        }, 4, null);
    }

    public final void setAnimData(@Nullable AnimData animData) {
        this.animData$delegate.setValue(animData);
    }

    public final void setListener(@Nullable Function2<? super IntSize, ? super IntSize, Unit> function2) {
        this.listener = function2;
    }
}
