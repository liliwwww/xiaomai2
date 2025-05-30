package androidx.compose.p004ui.platform;

import androidx.compose.p004ui.MotionDurationScale;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.ju2;

/* compiled from: Taobao */
/* loaded from: classes.dex */
final class MotionDurationScaleImpl implements MotionDurationScale {

    @NotNull
    private final MutableState scaleFactor$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(1.0f), null, 2, null);

    public <R> R fold(R r, @NotNull Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        return (R) MotionDurationScale.DefaultImpls.fold(this, r, function2);
    }

    @Nullable
    public <E extends CoroutineContext.Element> E get(@NotNull CoroutineContext.Key<E> key) {
        return (E) MotionDurationScale.DefaultImpls.get(this, key);
    }

    @Override // androidx.compose.p004ui.MotionDurationScale
    public /* synthetic */ CoroutineContext.Key getKey() {
        return ju2.a(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.p004ui.MotionDurationScale
    public float getScaleFactor() {
        return ((Number) this.scaleFactor$delegate.getValue()).floatValue();
    }

    @NotNull
    public CoroutineContext minusKey(@NotNull CoroutineContext.Key<?> key) {
        return MotionDurationScale.DefaultImpls.minusKey(this, key);
    }

    @NotNull
    public CoroutineContext plus(@NotNull CoroutineContext coroutineContext) {
        return MotionDurationScale.DefaultImpls.plus(this, coroutineContext);
    }

    public void setScaleFactor(float f) {
        this.scaleFactor$delegate.setValue(Float.valueOf(f));
    }
}
