package androidx.compose.material;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Alignment$Vertical;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode$Companion;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class AppBarKt$AppBar$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Function3<RowScope, Composer, Integer, Unit> $content;
    final /* synthetic */ PaddingValues $contentPadding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    AppBarKt$AppBar$1(PaddingValues paddingValues, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, int i) {
        super(2);
        this.$contentPadding = paddingValues;
        this.$content = function3;
        this.$$dirty = i;
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
            ComposerKt.traceEventStart(-1027830352, i, -1, "androidx.compose.material.AppBar.<anonymous> (AppBar.kt:519)");
        }
        ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium(composer, 6)))};
        final PaddingValues paddingValues = this.$contentPadding;
        final Function3<RowScope, Composer, Integer, Unit> function3 = this.$content;
        final int i2 = this.$$dirty;
        CompositionLocalKt.CompositionLocalProvider(providedValueArr, ComposableLambdaKt.composableLambda(composer, 1296061040, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$1.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return Unit.INSTANCE;
            }

            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
            @Composable
            public final void invoke(@Nullable Composer composer2, int i3) {
                if ((i3 & 11) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1296061040, i3, -1, "androidx.compose.material.AppBar.<anonymous>.<anonymous> (AppBar.kt:520)");
                }
                Modifier modifier = SizeKt.height-3ABfNKs(PaddingKt.padding(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), PaddingValues.this), AppBarKt.access$getAppBarHeight$p());
                Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                Alignment$Vertical centerVertically = Alignment.Companion.getCenterVertically();
                Function3<RowScope, Composer, Integer, Unit> function32 = function3;
                int i4 = ((i2 >> 9) & 7168) | 432;
                composer2.startReplaceableGroup(693286680);
                int i5 = i4 >> 3;
                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer2, (i5 & 112) | (i5 & 14));
                composer2.startReplaceableGroup(-1323940314);
                Density density = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposeUiNode$Companion composeUiNode$Companion = ComposeUiNode.Companion;
                Function0<ComposeUiNode> constructor = composeUiNode$Companion.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(modifier);
                int i6 = ((((i4 << 3) & 112) << 9) & 7168) | 6;
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor);
                } else {
                    composer2.useNode();
                }
                composer2.disableReusing();
                Composer m747constructorimpl = Updater.m747constructorimpl(composer2);
                Updater.m754setimpl(m747constructorimpl, rowMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) composeUiNode$Companion.getSetMeasurePolicy());
                Updater.m754setimpl(m747constructorimpl, density, (Function2<? super T, ? super Density, Unit>) composeUiNode$Companion.getSetDensity());
                Updater.m754setimpl(m747constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) composeUiNode$Companion.getSetLayoutDirection());
                Updater.m754setimpl(m747constructorimpl, viewConfiguration, (Function2<? super T, ? super ViewConfiguration, Unit>) composeUiNode$Companion.getSetViewConfiguration());
                composer2.enableReusing();
                materializerOf.invoke(SkippableUpdater.box-impl(SkippableUpdater.constructor-impl(composer2)), composer2, Integer.valueOf((i6 >> 3) & 112));
                composer2.startReplaceableGroup(2058660585);
                composer2.startReplaceableGroup(-678309503);
                if (((i6 >> 9) & 14 & 11) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                } else {
                    function32.invoke(RowScopeInstance.INSTANCE, composer2, Integer.valueOf(((i4 >> 6) & 112) | 6));
                }
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), composer, 56);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
