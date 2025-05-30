package androidx.compose.ui.layout;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.node.ComposeUiNode;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class LayoutKt$combineAsVirtualLayouts$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ List<Function2<Composer, Integer, Unit>> $contents;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LayoutKt$combineAsVirtualLayouts$1(List<? extends Function2<? super Composer, ? super Integer, Unit>> list) {
        super(2);
        this.$contents = list;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@Nullable Composer composer, int i) {
        if ((i & 11) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1953651383, i, -1, "androidx.compose.ui.layout.combineAsVirtualLayouts.<anonymous> (Layout.kt:176)");
        }
        List<Function2<Composer, Integer, Unit>> list = this.$contents;
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            Function2<Composer, Integer, Unit> function2 = list.get(i2);
            Function0 virtualConstructor = ComposeUiNode.Companion.getVirtualConstructor();
            composer.startReplaceableGroup(-692256719);
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(virtualConstructor);
            } else {
                composer.useNode();
            }
            composer.disableReusing();
            Updater.constructor-impl(composer);
            composer.enableReusing();
            function2.invoke(composer, 0);
            composer.endNode();
            composer.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
