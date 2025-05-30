package androidx.compose.foundation.lazy.grid;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.unit.IntOffset;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class PlaceableInfo {

    @NotNull
    private final Animatable<IntOffset, AnimationVector2D> animatedOffset;

    @NotNull
    private final MutableState inProgress$delegate;
    private int mainAxisSize;
    private long targetOffset;

    private PlaceableInfo(long j, int i) {
        MutableState mutableStateOf$default;
        this.mainAxisSize = i;
        this.animatedOffset = new Animatable<>(IntOffset.m2634boximpl(j), VectorConvertersKt.getVectorConverter(IntOffset.Companion), (Object) null, 4, (DefaultConstructorMarker) null);
        this.targetOffset = j;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        this.inProgress$delegate = mutableStateOf$default;
    }

    public /* synthetic */ PlaceableInfo(long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, i);
    }

    @NotNull
    public final Animatable<IntOffset, AnimationVector2D> getAnimatedOffset() {
        return this.animatedOffset;
    }

    public final boolean getInProgress() {
        return ((Boolean) this.inProgress$delegate.getValue()).booleanValue();
    }

    public final int getMainAxisSize() {
        return this.mainAxisSize;
    }

    /* renamed from: getTargetOffset-nOcc-ac, reason: not valid java name */
    public final long m487getTargetOffsetnOccac() {
        return this.targetOffset;
    }

    public final void setInProgress(boolean z) {
        this.inProgress$delegate.setValue(Boolean.valueOf(z));
    }

    public final void setMainAxisSize(int i) {
        this.mainAxisSize = i;
    }

    /* renamed from: setTargetOffset--gyyYBs, reason: not valid java name */
    public final void m488setTargetOffsetgyyYBs(long j) {
        this.targetOffset = j;
    }
}
