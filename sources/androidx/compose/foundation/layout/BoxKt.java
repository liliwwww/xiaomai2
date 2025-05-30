package androidx.compose.foundation.layout;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MeasureScope$CC;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.on2;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class BoxKt {

    @NotNull
    private static final MeasurePolicy DefaultBoxMeasurePolicy = boxMeasurePolicy(Alignment.Companion.getTopStart(), false);

    @NotNull
    private static final MeasurePolicy EmptyBoxMeasurePolicy = new MeasurePolicy() { // from class: androidx.compose.foundation.layout.BoxKt$EmptyBoxMeasurePolicy$1
        public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
            return on2.a(this, intrinsicMeasureScope, list, i);
        }

        public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
            return on2.b(this, intrinsicMeasureScope, list, i);
        }

        @NotNull
        /* renamed from: measure-3p2s80s, reason: not valid java name */
        public final MeasureResult m301measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull List<? extends Measurable> list, long j) {
            Intrinsics.checkNotNullParameter(measureScope, "$this$MeasurePolicy");
            Intrinsics.checkNotNullParameter(list, "<anonymous parameter 0>");
            return MeasureScope$CC.p(measureScope, Constraints.getMinWidth-impl(j), Constraints.getMinHeight-impl(j), null, measure.1.INSTANCE, 4, null);
        }

        public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
            return on2.c(this, intrinsicMeasureScope, list, i);
        }

        public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
            return on2.d(this, intrinsicMeasureScope, list, i);
        }
    };

    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    public static final void Box(@Nullable Modifier modifier, @Nullable Alignment alignment, boolean z, @NotNull Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> function3, @Nullable Composer composer, int i, int i2) {
        Intrinsics.checkNotNullParameter(function3, "content");
        composer.startReplaceableGroup(733328855);
        if ((i2 & 1) != 0) {
            modifier = Modifier.Companion;
        }
        if ((i2 & 2) != 0) {
            alignment = Alignment.Companion.getTopStart();
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        int i3 = i >> 3;
        MeasurePolicy rememberBoxMeasurePolicy = rememberBoxMeasurePolicy(alignment, z, composer, (i3 & 112) | (i3 & 14));
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
        Updater.set-impl(composer2, rememberBoxMeasurePolicy, companion.getSetMeasurePolicy());
        Updater.set-impl(composer2, density, companion.getSetDensity());
        Updater.set-impl(composer2, layoutDirection, companion.getSetLayoutDirection());
        Updater.set-impl(composer2, viewConfiguration, companion.getSetViewConfiguration());
        composer.enableReusing();
        materializerOf.invoke(SkippableUpdater.m907boximpl(SkippableUpdater.m908constructorimpl(composer)), composer, Integer.valueOf((i4 >> 3) & 112));
        composer.startReplaceableGroup(2058660585);
        composer.startReplaceableGroup(-2137368960);
        if (((i4 >> 9) & 14 & 11) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
        } else {
            function3.invoke(BoxScopeInstance.INSTANCE, composer, Integer.valueOf(((i >> 6) & 112) | 6));
        }
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        composer.endNode();
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
    }

    @NotNull
    public static final MeasurePolicy boxMeasurePolicy(@NotNull final Alignment alignment, final boolean z) {
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        return new MeasurePolicy() { // from class: androidx.compose.foundation.layout.BoxKt$boxMeasurePolicy$1
            public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
                return on2.a(this, intrinsicMeasureScope, list, i);
            }

            public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
                return on2.b(this, intrinsicMeasureScope, list, i);
            }

            @NotNull
            /* renamed from: measure-3p2s80s, reason: not valid java name */
            public final MeasureResult m302measure3p2s80s(@NotNull final MeasureScope measureScope, @NotNull final List<? extends Measurable> list, long j) {
                boolean matchesParentSize;
                boolean matchesParentSize2;
                boolean matchesParentSize3;
                int i;
                final Placeable placeable;
                int i2;
                Intrinsics.checkNotNullParameter(measureScope, "$this$MeasurePolicy");
                Intrinsics.checkNotNullParameter(list, "measurables");
                if (list.isEmpty()) {
                    return MeasureScope$CC.p(measureScope, Constraints.getMinWidth-impl(j), Constraints.getMinHeight-impl(j), null, new Function1<Placeable$PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.BoxKt$boxMeasurePolicy$1$measure$1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((Placeable$PlacementScope) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(@NotNull Placeable$PlacementScope placeable$PlacementScope) {
                            Intrinsics.checkNotNullParameter(placeable$PlacementScope, "$this$layout");
                        }
                    }, 4, null);
                }
                long j2 = z ? j : Constraints.copy-Zbe2FdA$default(j, 0, 0, 0, 0, 10, (Object) null);
                if (list.size() == 1) {
                    final Measurable measurable = list.get(0);
                    matchesParentSize3 = BoxKt.getMatchesParentSize(measurable);
                    if (matchesParentSize3) {
                        i = Constraints.getMinWidth-impl(j);
                        int i3 = Constraints.getMinHeight-impl(j);
                        placeable = measurable.measure-BRTryo0(Constraints.Companion.fixed-JhjzzOo(Constraints.getMinWidth-impl(j), Constraints.getMinHeight-impl(j)));
                        i2 = i3;
                    } else {
                        Placeable placeable2 = measurable.measure-BRTryo0(j2);
                        int max = Math.max(Constraints.getMinWidth-impl(j), placeable2.getWidth());
                        i2 = Math.max(Constraints.getMinHeight-impl(j), placeable2.getHeight());
                        placeable = placeable2;
                        i = max;
                    }
                    final Alignment alignment2 = alignment;
                    final int i4 = i;
                    final int i5 = i2;
                    return MeasureScope$CC.p(measureScope, i, i2, null, new Function1<Placeable$PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.BoxKt$boxMeasurePolicy$1$measure$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((Placeable$PlacementScope) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(@NotNull Placeable$PlacementScope placeable$PlacementScope) {
                            Intrinsics.checkNotNullParameter(placeable$PlacementScope, "$this$layout");
                            BoxKt.placeInBox(placeable$PlacementScope, placeable, measurable, measureScope.getLayoutDirection(), i4, i5, alignment2);
                        }
                    }, 4, null);
                }
                final Placeable[] placeableArr = new Placeable[list.size()];
                final Ref.IntRef intRef = new Ref.IntRef();
                intRef.element = Constraints.getMinWidth-impl(j);
                final Ref.IntRef intRef2 = new Ref.IntRef();
                intRef2.element = Constraints.getMinHeight-impl(j);
                int size = list.size();
                boolean z2 = false;
                for (int i6 = 0; i6 < size; i6++) {
                    Measurable measurable2 = list.get(i6);
                    matchesParentSize2 = BoxKt.getMatchesParentSize(measurable2);
                    if (matchesParentSize2) {
                        z2 = true;
                    } else {
                        Placeable placeable3 = measurable2.measure-BRTryo0(j2);
                        placeableArr[i6] = placeable3;
                        intRef.element = Math.max(intRef.element, placeable3.getWidth());
                        intRef2.element = Math.max(intRef2.element, placeable3.getHeight());
                    }
                }
                if (z2) {
                    int i7 = intRef.element;
                    int i8 = i7 != Integer.MAX_VALUE ? i7 : 0;
                    int i9 = intRef2.element;
                    long Constraints = ConstraintsKt.Constraints(i8, i7, i9 != Integer.MAX_VALUE ? i9 : 0, i9);
                    int size2 = list.size();
                    for (int i10 = 0; i10 < size2; i10++) {
                        Measurable measurable3 = list.get(i10);
                        matchesParentSize = BoxKt.getMatchesParentSize(measurable3);
                        if (matchesParentSize) {
                            placeableArr[i10] = measurable3.measure-BRTryo0(Constraints);
                        }
                    }
                }
                int i11 = intRef.element;
                int i12 = intRef2.element;
                final Alignment alignment3 = alignment;
                return MeasureScope$CC.p(measureScope, i11, i12, null, new Function1<Placeable$PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.BoxKt$boxMeasurePolicy$1$measure$5
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((Placeable$PlacementScope) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@NotNull Placeable$PlacementScope placeable$PlacementScope) {
                        Intrinsics.checkNotNullParameter(placeable$PlacementScope, "$this$layout");
                        Placeable[] placeableArr2 = placeableArr;
                        List<Measurable> list2 = list;
                        MeasureScope measureScope2 = measureScope;
                        Ref.IntRef intRef3 = intRef;
                        Ref.IntRef intRef4 = intRef2;
                        Alignment alignment4 = alignment3;
                        int length = placeableArr2.length;
                        int i13 = 0;
                        int i14 = 0;
                        while (i14 < length) {
                            Placeable placeable4 = placeableArr2[i14];
                            Intrinsics.checkNotNull(placeable4, "null cannot be cast to non-null type androidx.compose.ui.layout.Placeable");
                            BoxKt.placeInBox(placeable$PlacementScope, placeable4, list2.get(i13), measureScope2.getLayoutDirection(), intRef3.element, intRef4.element, alignment4);
                            i14++;
                            i13++;
                        }
                    }
                }, 4, null);
            }

            public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
                return on2.c(this, intrinsicMeasureScope, list, i);
            }

            public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
                return on2.d(this, intrinsicMeasureScope, list, i);
            }
        };
    }

    private static final BoxChildData getBoxChildData(Measurable measurable) {
        Object parentData = measurable.getParentData();
        if (parentData instanceof BoxChildData) {
            return (BoxChildData) parentData;
        }
        return null;
    }

    @NotNull
    public static final MeasurePolicy getDefaultBoxMeasurePolicy() {
        return DefaultBoxMeasurePolicy;
    }

    @NotNull
    public static final MeasurePolicy getEmptyBoxMeasurePolicy() {
        return EmptyBoxMeasurePolicy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getMatchesParentSize(Measurable measurable) {
        BoxChildData boxChildData = getBoxChildData(measurable);
        if (boxChildData != null) {
            return boxChildData.getMatchParentSize();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void placeInBox(Placeable$PlacementScope placeable$PlacementScope, Placeable placeable, Measurable measurable, LayoutDirection layoutDirection, int i, int i2, Alignment alignment) {
        Alignment alignment2;
        BoxChildData boxChildData = getBoxChildData(measurable);
        Placeable$PlacementScope.m2068place70tqf50$default(placeable$PlacementScope, placeable, ((boxChildData == null || (alignment2 = boxChildData.getAlignment()) == null) ? alignment : alignment2).mo935alignKFBX0sM(IntSizeKt.IntSize(placeable.getWidth(), placeable.getHeight()), IntSizeKt.IntSize(i, i2), layoutDirection), 0.0f, 2, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0047, code lost:
    
        if (r0 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L13;
     */
    @androidx.compose.runtime.Composable
    @kotlin.PublishedApi
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final androidx.compose.ui.layout.MeasurePolicy rememberBoxMeasurePolicy(@org.jetbrains.annotations.NotNull androidx.compose.ui.Alignment r3, boolean r4, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r5, int r6) {
        /*
            java.lang.String r0 = "alignment"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            r0 = 56522820(0x35e7844, float:6.5377995E-37)
            r5.startReplaceableGroup(r0)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L17
            r1 = -1
            java.lang.String r2 = "androidx.compose.foundation.layout.rememberBoxMeasurePolicy (Box.kt:80)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r6, r1, r2)
        L17:
            androidx.compose.ui.Alignment$Companion r6 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r6 = r6.getTopStart()
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r6)
            if (r6 == 0) goto L28
            if (r4 != 0) goto L28
            androidx.compose.ui.layout.MeasurePolicy r3 = androidx.compose.foundation.layout.BoxKt.DefaultBoxMeasurePolicy
            goto L56
        L28:
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r4)
            r0 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r5.startReplaceableGroup(r0)
            boolean r0 = r5.changed(r3)
            boolean r6 = r5.changed(r6)
            r6 = r6 | r0
            java.lang.Object r0 = r5.rememberedValue()
            if (r6 != 0) goto L49
            androidx.compose.runtime.Composer$Companion r6 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r6 = r6.getEmpty()
            if (r0 != r6) goto L50
        L49:
            androidx.compose.ui.layout.MeasurePolicy r0 = boxMeasurePolicy(r3, r4)
            r5.updateRememberedValue(r0)
        L50:
            r5.endReplaceableGroup()
            r3 = r0
            androidx.compose.ui.layout.MeasurePolicy r3 = (androidx.compose.ui.layout.MeasurePolicy) r3
        L56:
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L5f
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L5f:
            r5.endReplaceableGroup()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(androidx.compose.ui.Alignment, boolean, androidx.compose.runtime.Composer, int):androidx.compose.ui.layout.MeasurePolicy");
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void Box(@NotNull Modifier modifier, @Nullable Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Composer startRestartGroup = composer.startRestartGroup(-211209833);
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 11) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-211209833, i2, -1, "androidx.compose.foundation.layout.Box (Box.kt:199)");
            }
            MeasurePolicy measurePolicy = EmptyBoxMeasurePolicy;
            startRestartGroup.startReplaceableGroup(-1323940314);
            Density density = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion = ComposeUiNode.Companion;
            Function0 constructor = companion.getConstructor();
            Function3 materializerOf = LayoutKt.materializerOf(modifier);
            int i3 = (((((i2 << 3) & 112) | 384) << 9) & 7168) | 6;
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            startRestartGroup.disableReusing();
            Composer composer2 = Updater.constructor-impl(startRestartGroup);
            Updater.set-impl(composer2, measurePolicy, companion.getSetMeasurePolicy());
            Updater.set-impl(composer2, density, companion.getSetDensity());
            Updater.set-impl(composer2, layoutDirection, companion.getSetLayoutDirection());
            Updater.set-impl(composer2, viewConfiguration, companion.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf.invoke(SkippableUpdater.m907boximpl(SkippableUpdater.m908constructorimpl(startRestartGroup)), startRestartGroup, Integer.valueOf((i3 >> 3) & 112));
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(1021196736);
            if (((i3 >> 9) & 14 & 11) == 2 && startRestartGroup.getSkipping()) {
                startRestartGroup.skipToGroupEnd();
            }
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Box.3(modifier, i));
    }
}
