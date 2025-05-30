package androidx.compose.material;

import androidx.compose.ui.unit.IntSize;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class SwipeableV2Kt$swipeAnchors$1 extends Lambda implements Function1<IntSize, Unit> {
    final /* synthetic */ Function2<Map<T, Float>, Map<T, Float>, Unit> $anchorsChanged;
    final /* synthetic */ Function2<T, IntSize, Float> $calculateAnchor;
    final /* synthetic */ Set<T> $possibleStates;
    final /* synthetic */ SwipeableV2State<T> $state;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    SwipeableV2Kt$swipeAnchors$1(SwipeableV2State<T> swipeableV2State, Set<? extends T> set, Function2<? super Map<T, Float>, ? super Map<T, Float>, Unit> function2, Function2<? super T, ? super IntSize, Float> function22) {
        super(1);
        this.$state = swipeableV2State;
        this.$possibleStates = set;
        this.$anchorsChanged = function2;
        this.$calculateAnchor = function22;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        m829invokeozmzZPI(((IntSize) obj).m2689unboximpl());
        return Unit.INSTANCE;
    }

    /* renamed from: invoke-ozmzZPI, reason: not valid java name */
    public final void m829invokeozmzZPI(long j) {
        Function2<Map<T, Float>, Map<T, Float>, Unit> function2;
        Map anchors$material_release = this.$state.getAnchors$material_release();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Collection collection = this.$possibleStates;
        Function2<T, IntSize, Float> function22 = this.$calculateAnchor;
        for (Object obj : collection) {
            Float f = (Float) function22.invoke(obj, IntSize.m2677boximpl(j));
            if (f != null) {
                linkedHashMap.put(obj, f);
            }
        }
        if (Intrinsics.areEqual(anchors$material_release, linkedHashMap)) {
            return;
        }
        this.$state.updateAnchors$material_release(linkedHashMap);
        if (!(!anchors$material_release.isEmpty()) || (function2 = this.$anchorsChanged) == 0) {
            return;
        }
        function2.invoke(anchors$material_release, linkedHashMap);
    }
}
