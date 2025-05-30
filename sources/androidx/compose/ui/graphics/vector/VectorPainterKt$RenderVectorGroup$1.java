package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class VectorPainterKt$RenderVectorGroup$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Map<String, VectorConfig> $configs;
    final /* synthetic */ VectorNode $vectorNode;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    VectorPainterKt$RenderVectorGroup$1(VectorNode vectorNode, Map<String, ? extends VectorConfig> map) {
        super(2);
        this.$vectorNode = vectorNode;
        this.$configs = map;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @ComposableTarget(applier = "androidx.compose.ui.graphics.vector.VectorComposable")
    @Composable
    public final void invoke(@Nullable Composer composer, int i) {
        if ((i & 11) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1450046638, i, -1, "androidx.compose.ui.graphics.vector.RenderVectorGroup.<anonymous> (VectorPainter.kt:413)");
        }
        VectorPainterKt.RenderVectorGroup((VectorGroup) this.$vectorNode, this.$configs, composer, 64, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
