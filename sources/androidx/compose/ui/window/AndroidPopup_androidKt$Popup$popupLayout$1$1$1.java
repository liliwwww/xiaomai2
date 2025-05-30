package androidx.compose.ui.window;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MeasureScope$CC;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.on2;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class AndroidPopup_androidKt$Popup$popupLayout$1$1$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ State<Function2<Composer, Integer, Unit>> $currentContent$delegate;
    final /* synthetic */ PopupLayout $this_apply;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidPopup_androidKt$Popup$popupLayout$1$1$1(PopupLayout popupLayout, State<? extends Function2<? super Composer, ? super Integer, Unit>> state) {
        super(2);
        this.$this_apply = popupLayout;
        this.$currentContent$delegate = state;
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
            ComposerKt.traceEventStart(1302892335, i, -1, "androidx.compose.ui.window.Popup.<anonymous>.<anonymous>.<anonymous> (AndroidPopup.android.kt:243)");
        }
        Modifier semantics$default = SemanticsModifierKt.semantics$default(Modifier.Companion, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$popupLayout$1$1$1.1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((SemanticsPropertyReceiver) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
                Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$semantics");
                SemanticsPropertiesKt.popup(semanticsPropertyReceiver);
            }
        }, 1, (Object) null);
        final PopupLayout popupLayout = this.$this_apply;
        Modifier alpha = AlphaKt.alpha(OnRemeasuredModifierKt.onSizeChanged(semantics$default, new Function1<IntSize, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$popupLayout$1$1$1.2
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                m2727invokeozmzZPI(((IntSize) obj).m2689unboximpl());
                return Unit.INSTANCE;
            }

            /* renamed from: invoke-ozmzZPI, reason: not valid java name */
            public final void m2727invokeozmzZPI(long j) {
                PopupLayout.this.m2731setPopupContentSizefhxjrPA(IntSize.m2677boximpl(j));
                PopupLayout.this.updatePosition();
            }
        }), this.$this_apply.getCanCalculatePosition() ? 1.0f : 0.0f);
        final State<Function2<Composer, Integer, Unit>> state = this.$currentContent$delegate;
        ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer, 606497925, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$popupLayout$1$1$1.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return Unit.INSTANCE;
            }

            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
            @Composable
            public final void invoke(@Nullable Composer composer2, int i2) {
                if ((i2 & 11) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(606497925, i2, -1, "androidx.compose.ui.window.Popup.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AndroidPopup.android.kt:254)");
                }
                AndroidPopup_androidKt.access$Popup$lambda$1(state).invoke(composer2, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        });
        composer.startReplaceableGroup(1406149896);
        AndroidPopup_androidKt$SimpleStack$1 androidPopup_androidKt$SimpleStack$1 = new MeasurePolicy() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$SimpleStack$1
            public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i2) {
                return on2.a(this, intrinsicMeasureScope, list, i2);
            }

            public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i2) {
                return on2.b(this, intrinsicMeasureScope, list, i2);
            }

            @NotNull
            /* renamed from: measure-3p2s80s, reason: not valid java name */
            public final MeasureResult m2728measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull List<? extends Measurable> list, long j) {
                int i2;
                int i3;
                Intrinsics.checkNotNullParameter(measureScope, "$this$Layout");
                Intrinsics.checkNotNullParameter(list, "measurables");
                int size = list.size();
                if (size == 0) {
                    return MeasureScope$CC.p(measureScope, 0, 0, null, measure.1.INSTANCE, 4, null);
                }
                int i4 = 0;
                if (size == 1) {
                    Placeable placeable = list.get(0).measure-BRTryo0(j);
                    return MeasureScope$CC.p(measureScope, placeable.getWidth(), placeable.getHeight(), null, new measure.2(placeable), 4, null);
                }
                ArrayList arrayList = new ArrayList(list.size());
                int size2 = list.size();
                for (int i5 = 0; i5 < size2; i5++) {
                    arrayList.add(list.get(i5).measure-BRTryo0(j));
                }
                int lastIndex = CollectionsKt.getLastIndex(arrayList);
                if (lastIndex >= 0) {
                    int i6 = 0;
                    int i7 = 0;
                    while (true) {
                        Placeable placeable2 = (Placeable) arrayList.get(i4);
                        i6 = Math.max(i6, placeable2.getWidth());
                        i7 = Math.max(i7, placeable2.getHeight());
                        if (i4 == lastIndex) {
                            break;
                        }
                        i4++;
                    }
                    i2 = i6;
                    i3 = i7;
                } else {
                    i2 = 0;
                    i3 = 0;
                }
                return MeasureScope$CC.p(measureScope, i2, i3, null, new measure.3(arrayList), 4, null);
            }

            public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i2) {
                return on2.c(this, intrinsicMeasureScope, list, i2);
            }

            public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i2) {
                return on2.d(this, intrinsicMeasureScope, list, i2);
            }
        };
        composer.startReplaceableGroup(-1323940314);
        Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration = (ViewConfiguration) composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
        ComposeUiNode.Companion companion = ComposeUiNode.Companion;
        Function0 constructor = companion.getConstructor();
        Function3 materializerOf = LayoutKt.materializerOf(alpha);
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
        Updater.set-impl(composer2, androidPopup_androidKt$SimpleStack$1, companion.getSetMeasurePolicy());
        Updater.set-impl(composer2, density, companion.getSetDensity());
        Updater.set-impl(composer2, layoutDirection, companion.getSetLayoutDirection());
        Updater.set-impl(composer2, viewConfiguration, companion.getSetViewConfiguration());
        composer.enableReusing();
        materializerOf.invoke(SkippableUpdater.m907boximpl(SkippableUpdater.m908constructorimpl(composer)), composer, 0);
        composer.startReplaceableGroup(2058660585);
        composableLambda.invoke(composer, 6);
        composer.endReplaceableGroup();
        composer.endNode();
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
