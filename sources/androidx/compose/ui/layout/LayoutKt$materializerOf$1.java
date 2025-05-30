package androidx.compose.ui.layout;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ComposeUiNode;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class LayoutKt$materializerOf$1 extends Lambda implements Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> {
    final /* synthetic */ Modifier $modifier;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LayoutKt$materializerOf$1(Modifier modifier) {
        super(3);
        this.$modifier = modifier;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        m2056invokeDeg8D_g(((SkippableUpdater) obj).m914unboximpl(), (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    /* renamed from: invoke-Deg8D_g, reason: not valid java name */
    public final void m2056invokeDeg8D_g(@NotNull Composer composer, @Nullable Composer composer2, int i) {
        Intrinsics.checkNotNullParameter(composer, "$this$null");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1586257396, i, -1, "androidx.compose.ui.layout.materializerOf.<anonymous> (Layout.kt:189)");
        }
        Modifier materialize = ComposedModifierKt.materialize(composer2, this.$modifier);
        composer.startReplaceableGroup(509942095);
        Updater.set-impl(Updater.constructor-impl(composer), materialize, ComposeUiNode.Companion.getSetModifier());
        composer.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
