package androidx.compose.material.pullrefresh;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
/* synthetic */ class PullRefreshKt$pullRefresh$2$1 extends FunctionReferenceImpl implements Function1<Float, Float> {
    PullRefreshKt$pullRefresh$2$1(Object obj) {
        super(1, obj, PullRefreshState.class, "onPull", "onPull$material_release(F)F", 0);
    }

    @NotNull
    public final Float invoke(float f) {
        return Float.valueOf(((PullRefreshState) ((CallableReference) this).receiver).onPull$material_release(f));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).floatValue());
    }
}
