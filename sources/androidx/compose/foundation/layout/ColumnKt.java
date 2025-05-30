package androidx.compose.foundation.layout;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class ColumnKt {

    @NotNull
    private static final MeasurePolicy DefaultColumnMeasurePolicy;

    static {
        LayoutOrientation layoutOrientation = LayoutOrientation.Vertical;
        float mo285getSpacingD9Ej5fM = Arrangement.INSTANCE.getTop().mo285getSpacingD9Ej5fM();
        CrossAxisAlignment horizontal$foundation_layout_release = CrossAxisAlignment.Companion.horizontal$foundation_layout_release(Alignment.Companion.getStart());
        DefaultColumnMeasurePolicy = RowColumnImplKt.m349rowColumnMeasurePolicyTDGSqEk(layoutOrientation, DefaultColumnMeasurePolicy.1.INSTANCE, mo285getSpacingD9Ej5fM, SizeMode.Wrap, horizontal$foundation_layout_release);
    }

    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    public static final void Column(@Nullable Modifier modifier, @Nullable Arrangement$Vertical arrangement$Vertical, @Nullable Alignment.Horizontal horizontal, @NotNull Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, @Nullable Composer composer, int i, int i2) {
        Intrinsics.checkNotNullParameter(function3, "content");
        composer.startReplaceableGroup(-483455358);
        if ((i2 & 1) != 0) {
            modifier = Modifier.Companion;
        }
        if ((i2 & 2) != 0) {
            arrangement$Vertical = Arrangement.INSTANCE.getTop();
        }
        if ((i2 & 4) != 0) {
            horizontal = Alignment.Companion.getStart();
        }
        int i3 = i >> 3;
        MeasurePolicy columnMeasurePolicy = columnMeasurePolicy(arrangement$Vertical, horizontal, composer, (i3 & 112) | (i3 & 14));
        composer.startReplaceableGroup(-1323940314);
        Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration = (ViewConfiguration) composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
        ComposeUiNode.Companion companion = ComposeUiNode.Companion;
        Function0 constructor = companion.getConstructor();
        Function3 materializerOf = LayoutKt.materializerOf(modifier);
        int i4 = ((((i << 3) & 112) << 9) & 7168) | 6;
        if (!(composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor);
        } else {
            composer.useNode();
        }
        composer.disableReusing();
        Composer composer2 = Updater.constructor-impl(composer);
        Updater.set-impl(composer2, columnMeasurePolicy, companion.getSetMeasurePolicy());
        Updater.set-impl(composer2, density, companion.getSetDensity());
        Updater.set-impl(composer2, layoutDirection, companion.getSetLayoutDirection());
        Updater.set-impl(composer2, viewConfiguration, companion.getSetViewConfiguration());
        composer.enableReusing();
        materializerOf.invoke(SkippableUpdater.m907boximpl(SkippableUpdater.m908constructorimpl(composer)), composer, Integer.valueOf((i4 >> 3) & 112));
        composer.startReplaceableGroup(2058660585);
        composer.startReplaceableGroup(-1163856341);
        if (((i4 >> 9) & 14 & 11) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
        } else {
            function3.invoke(ColumnScopeInstance.INSTANCE, composer, Integer.valueOf(((i >> 6) & 112) | 6));
        }
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        composer.endNode();
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0053, code lost:
    
        if (r0 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L14;
     */
    @androidx.compose.runtime.Composable
    @kotlin.PublishedApi
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final androidx.compose.ui.layout.MeasurePolicy columnMeasurePolicy(@org.jetbrains.annotations.NotNull androidx.compose.foundation.layout.Arrangement$Vertical r3, @org.jetbrains.annotations.NotNull androidx.compose.ui.Alignment.Horizontal r4, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r5, int r6) {
        /*
            java.lang.String r0 = "verticalArrangement"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "horizontalAlignment"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            r0 = 1089876336(0x40f63170, float:7.693535)
            r5.startReplaceableGroup(r0)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L1d
            r1 = -1
            java.lang.String r2 = "androidx.compose.foundation.layout.columnMeasurePolicy (Column.kt:98)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r6, r1, r2)
        L1d:
            androidx.compose.foundation.layout.Arrangement r6 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Vertical r6 = r6.getTop()
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r6)
            if (r6 == 0) goto L38
            androidx.compose.ui.Alignment$Companion r6 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Horizontal r6 = r6.getStart()
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r6)
            if (r6 == 0) goto L38
            androidx.compose.ui.layout.MeasurePolicy r3 = androidx.compose.foundation.layout.ColumnKt.DefaultColumnMeasurePolicy
            goto L75
        L38:
            r6 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r5.startReplaceableGroup(r6)
            boolean r6 = r5.changed(r3)
            boolean r0 = r5.changed(r4)
            r6 = r6 | r0
            java.lang.Object r0 = r5.rememberedValue()
            if (r6 != 0) goto L55
            androidx.compose.runtime.Composer$Companion r6 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r6 = r6.getEmpty()
            if (r0 != r6) goto L6f
        L55:
            androidx.compose.foundation.layout.LayoutOrientation r6 = androidx.compose.foundation.layout.LayoutOrientation.Vertical
            float r0 = r3.mo285getSpacingD9Ej5fM()
            androidx.compose.foundation.layout.CrossAxisAlignment$Companion r1 = androidx.compose.foundation.layout.CrossAxisAlignment.Companion
            androidx.compose.foundation.layout.CrossAxisAlignment r4 = r1.horizontal$foundation_layout_release(r4)
            androidx.compose.foundation.layout.SizeMode r1 = androidx.compose.foundation.layout.SizeMode.Wrap
            androidx.compose.foundation.layout.ColumnKt$columnMeasurePolicy$1$1 r2 = new androidx.compose.foundation.layout.ColumnKt$columnMeasurePolicy$1$1
            r2.<init>(r3)
            androidx.compose.ui.layout.MeasurePolicy r0 = androidx.compose.foundation.layout.RowColumnImplKt.m349rowColumnMeasurePolicyTDGSqEk(r6, r2, r0, r1, r4)
            r5.updateRememberedValue(r0)
        L6f:
            r5.endReplaceableGroup()
            r3 = r0
            androidx.compose.ui.layout.MeasurePolicy r3 = (androidx.compose.ui.layout.MeasurePolicy) r3
        L75:
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L7e
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L7e:
            r5.endReplaceableGroup()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.ColumnKt.columnMeasurePolicy(androidx.compose.foundation.layout.Arrangement$Vertical, androidx.compose.ui.Alignment$Horizontal, androidx.compose.runtime.Composer, int):androidx.compose.ui.layout.MeasurePolicy");
    }

    @NotNull
    public static final MeasurePolicy getDefaultColumnMeasurePolicy() {
        return DefaultColumnMeasurePolicy;
    }

    @PublishedApi
    public static /* synthetic */ void getDefaultColumnMeasurePolicy$annotations() {
    }
}
