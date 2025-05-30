package androidx.compose.animation;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MeasureScope$CC;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class SizeAnimationModifier extends LayoutModifierWithPassThroughIntrinsics {

    @NotNull
    private final MutableState animData$delegate;

    @NotNull
    private final AnimationSpec<IntSize> animSpec;

    @Nullable
    private Function2<? super IntSize, ? super IntSize, Unit> listener;

    @NotNull
    private final CoroutineScope scope;

    public SizeAnimationModifier(@NotNull AnimationSpec<IntSize> animationSpec, @NotNull CoroutineScope coroutineScope) {
        MutableState mutableStateOf$default;
        Intrinsics.checkNotNullParameter(animationSpec, "animSpec");
        Intrinsics.checkNotNullParameter(coroutineScope, "scope");
        this.animSpec = animationSpec;
        this.scope = coroutineScope;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.animData$delegate = mutableStateOf$default;
    }

    /* renamed from: animateTo-mzRDjE0, reason: not valid java name */
    public final long m58animateTomzRDjE0(long j) {
        AnimData animData = getAnimData();
        if (animData == null) {
            animData = new AnimData(new Animatable(IntSize.m2677boximpl(j), VectorConvertersKt.getVectorConverter(IntSize.Companion), IntSize.m2677boximpl(IntSizeKt.IntSize(1, 1)), (String) null, 8, (DefaultConstructorMarker) null), j, (DefaultConstructorMarker) null);
        } else if (!IntSize.m2683equalsimpl0(j, ((IntSize) animData.getAnim().getTargetValue()).m2689unboximpl())) {
            animData.setStartSize-ozmzZPI(((IntSize) animData.getAnim().getValue()).m2689unboximpl());
            d.d(this.scope, (CoroutineContext) null, (CoroutineStart) null, new SizeAnimationModifier$animateTo$data$1$1(animData, j, this, null), 3, (Object) null);
        }
        setAnimData(animData);
        return ((IntSize) animData.getAnim().getValue()).m2689unboximpl();
    }

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

    @Override // androidx.compose.ui.layout.LayoutModifier
    @NotNull
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo49measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull Measurable measurable, long j) {
        Intrinsics.checkNotNullParameter(measureScope, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        Placeable placeable = measurable.measure-BRTryo0(j);
        long m58animateTomzRDjE0 = m58animateTomzRDjE0(IntSizeKt.IntSize(placeable.getWidth(), placeable.getHeight()));
        return MeasureScope$CC.p(measureScope, IntSize.m2685getWidthimpl(m58animateTomzRDjE0), IntSize.m2684getHeightimpl(m58animateTomzRDjE0), null, new measure.1(placeable), 4, null);
    }

    public final void setAnimData(@Nullable AnimData animData) {
        this.animData$delegate.setValue(animData);
    }

    public final void setListener(@Nullable Function2<? super IntSize, ? super IntSize, Unit> function2) {
        this.listener = function2;
    }
}
