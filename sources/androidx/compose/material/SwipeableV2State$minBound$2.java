package androidx.compose.material;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class SwipeableV2State$minBound$2 extends Lambda implements Function0<Float> {
    final /* synthetic */ SwipeableV2State<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SwipeableV2State$minBound$2(SwipeableV2State<T> swipeableV2State) {
        super(0);
        this.this$0 = swipeableV2State;
    }

    @NotNull
    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final Float m832invoke() {
        Float access$minOrNull = SwipeableV2Kt.access$minOrNull(this.this$0.getAnchors$material_release());
        return Float.valueOf(access$minOrNull != null ? access$minOrNull.floatValue() : Float.NEGATIVE_INFINITY);
    }
}
