package androidx.compose.material.pullrefresh;

import androidx.compose.animation.core.EasingKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.unit.IntSize;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class PullRefreshIndicatorTransformKt$pullRefreshIndicatorTransform$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ boolean $scale;
    final /* synthetic */ PullRefreshState $state;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PullRefreshIndicatorTransformKt$pullRefreshIndicatorTransform$2(PullRefreshState pullRefreshState, boolean z) {
        super(3);
        this.$state = pullRefreshState;
        this.$scale = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-1, reason: not valid java name */
    public static final int m717invoke$lambda1(MutableState<Integer> mutableState) {
        return ((Number) mutableState.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-2, reason: not valid java name */
    public static final void m718invoke$lambda2(MutableState<Integer> mutableState, int i) {
        mutableState.setValue(Integer.valueOf(i));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    @Composable
    @NotNull
    public final Modifier invoke(@NotNull Modifier modifier, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(modifier, "$this$composed");
        composer.startReplaceableGroup(1223983161);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1223983161, i, -1, "androidx.compose.material.pullrefresh.pullRefreshIndicatorTransform.<anonymous> (PullRefreshIndicatorTransform.kt:48)");
        }
        composer.startReplaceableGroup(-492369756);
        Object rememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.Companion;
        if (rememberedValue == companion.getEmpty()) {
            rememberedValue = SnapshotStateKt.mutableStateOf$default(0, (SnapshotMutationPolicy) null, 2, (Object) null);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        final MutableState mutableState = (MutableState) rememberedValue;
        Modifier.Companion companion2 = Modifier.Companion;
        composer.startReplaceableGroup(1157296644);
        boolean changed = composer.changed(mutableState);
        Object rememberedValue2 = composer.rememberedValue();
        if (changed || rememberedValue2 == companion.getEmpty()) {
            rememberedValue2 = new Function1<IntSize, Unit>() { // from class: androidx.compose.material.pullrefresh.PullRefreshIndicatorTransformKt$pullRefreshIndicatorTransform$2$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    m719invokeozmzZPI(((IntSize) obj).unbox-impl());
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke-ozmzZPI, reason: not valid java name */
                public final void m719invokeozmzZPI(long j) {
                    PullRefreshIndicatorTransformKt$pullRefreshIndicatorTransform$2.m718invoke$lambda2(mutableState, IntSize.getHeight-impl(j));
                }
            };
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceableGroup();
        Modifier onSizeChanged = OnRemeasuredModifierKt.onSizeChanged(companion2, (Function1) rememberedValue2);
        final PullRefreshState pullRefreshState = this.$state;
        final boolean z = this.$scale;
        Modifier graphicsLayer = GraphicsLayerModifierKt.graphicsLayer(onSizeChanged, new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.material.pullrefresh.PullRefreshIndicatorTransformKt$pullRefreshIndicatorTransform$2.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((GraphicsLayerScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull GraphicsLayerScope graphicsLayerScope) {
                Intrinsics.checkNotNullParameter(graphicsLayerScope, "$this$graphicsLayer");
                graphicsLayerScope.setTranslationY(pullRefreshState.getPosition$material_release() - PullRefreshIndicatorTransformKt$pullRefreshIndicatorTransform$2.m717invoke$lambda1(mutableState));
                if (!z || pullRefreshState.getRefreshing$material_release()) {
                    return;
                }
                float coerceIn = RangesKt.coerceIn(EasingKt.getLinearOutSlowInEasing().transform(pullRefreshState.getPosition$material_release() / pullRefreshState.getThreshold$material_release()), 0.0f, 1.0f);
                graphicsLayerScope.setScaleX(coerceIn);
                graphicsLayerScope.setScaleY(coerceIn);
            }
        });
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return graphicsLayer;
    }
}
