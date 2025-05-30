package androidx.compose.p004ui.layout;

import androidx.compose.p004ui.ComposedModifierKt;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.node.LookaheadDelegate;
import androidx.compose.p004ui.node.NodeCoordinator;
import androidx.compose.p004ui.platform.InspectableValueKt;
import androidx.compose.p004ui.platform.InspectorInfo;
import androidx.compose.p004ui.unit.Constraints;
import androidx.compose.p004ui.unit.IntSize;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
final class LookaheadLayoutScopeImpl implements LookaheadLayoutScope {

    @Nullable
    private NodeCoordinator root;

    @Nullable
    public final NodeCoordinator getRoot() {
        return this.root;
    }

    @Override // androidx.compose.p004ui.layout.LookaheadLayoutScope
    @NotNull
    public Modifier intermediateLayout(@NotNull Modifier modifier, @NotNull final Function4<? super MeasureScope, ? super Measurable, ? super Constraints, ? super IntSize, ? extends MeasureResult> function4) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(function4, "measure");
        return modifier.then(new LookaheadIntermediateLayoutModifierImpl(function4, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.ui.layout.LookaheadLayoutScopeImpl$intermediateLayout$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((InspectorInfo) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull InspectorInfo inspectorInfo) {
                Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
                inspectorInfo.setName("intermediateLayout");
                inspectorInfo.getProperties().set("measure", function4);
            }
        } : InspectableValueKt.getNoInspectorInfo()));
    }

    @Override // androidx.compose.p004ui.layout.LookaheadLayoutScope
    @NotNull
    public Modifier onPlaced(@NotNull Modifier modifier, @NotNull final Function2<? super LookaheadLayoutCoordinates, ? super LookaheadLayoutCoordinates, Unit> function2) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(function2, "onPlaced");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.ui.layout.LookaheadLayoutScopeImpl$onPlaced$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((InspectorInfo) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull InspectorInfo inspectorInfo) {
                Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
                inspectorInfo.setName("onPlaced");
                inspectorInfo.getProperties().set("onPlaced", function2);
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.ui.layout.LookaheadLayoutScopeImpl$onPlaced$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
            }

            @Composable
            @NotNull
            public final Modifier invoke(@NotNull Modifier modifier2, @Nullable Composer composer, int i) {
                Intrinsics.checkNotNullParameter(modifier2, "$this$composed");
                composer.startReplaceableGroup(-814093691);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-814093691, i, -1, "androidx.compose.ui.layout.LookaheadLayoutScopeImpl.onPlaced.<anonymous> (LookaheadLayout.kt:176)");
                }
                Function2<LookaheadLayoutCoordinates, LookaheadLayoutCoordinates, Unit> function22 = function2;
                final LookaheadLayoutScopeImpl lookaheadLayoutScopeImpl = this;
                Object rememberedValue = composer.rememberedValue();
                if (rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new LookaheadOnPlacedModifier(function22, new Function0<LookaheadLayoutCoordinates>() { // from class: androidx.compose.ui.layout.LookaheadLayoutScopeImpl$onPlaced$2$1$1
                        {
                            super(0);
                        }

                        @NotNull
                        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                        public final LookaheadLayoutCoordinates m4201invoke() {
                            NodeCoordinator root = LookaheadLayoutScopeImpl.this.getRoot();
                            if (root != null) {
                                LookaheadDelegate lookaheadDelegate$ui_release = root.getLookaheadDelegate$ui_release();
                                Intrinsics.checkNotNull(lookaheadDelegate$ui_release);
                                LookaheadLayoutCoordinatesImpl lookaheadLayoutCoordinates = lookaheadDelegate$ui_release.getLookaheadLayoutCoordinates();
                                if (lookaheadLayoutCoordinates != null) {
                                    return lookaheadLayoutCoordinates;
                                }
                            }
                            throw new IllegalStateException("Lookahead root has not been set up yet".toString());
                        }
                    });
                    composer.updateRememberedValue(rememberedValue);
                }
                Modifier then = modifier2.then((Modifier) rememberedValue);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceableGroup();
                return then;
            }
        });
    }

    public final void setRoot(@Nullable NodeCoordinator nodeCoordinator) {
        this.root = nodeCoordinator;
    }
}
