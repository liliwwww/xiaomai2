package androidx.compose.ui.node;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class DepthSortedSet$mapOfOriginalDepth$2 extends Lambda implements Function0<Map<LayoutNode, Integer>> {
    public static final DepthSortedSet$mapOfOriginalDepth$2 INSTANCE = new DepthSortedSet$mapOfOriginalDepth$2();

    DepthSortedSet$mapOfOriginalDepth$2() {
        super(0);
    }

    @NotNull
    public final Map<LayoutNode, Integer> invoke() {
        return new LinkedHashMap();
    }
}
