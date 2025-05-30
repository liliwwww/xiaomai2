package androidx.compose.foundation.text;

import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.layout.IntrinsicMeasureScope;
import androidx.compose.p004ui.layout.LayoutKt;
import androidx.compose.p004ui.layout.Measurable;
import androidx.compose.p004ui.layout.MeasurePolicy;
import androidx.compose.p004ui.layout.MeasureResult;
import androidx.compose.p004ui.layout.MeasureScope;
import androidx.compose.p004ui.layout.Placeable;
import androidx.compose.p004ui.node.ComposeUiNode;
import androidx.compose.p004ui.platform.CompositionLocalsKt;
import androidx.compose.p004ui.platform.ViewConfiguration;
import androidx.compose.p004ui.text.AnnotatedString;
import androidx.compose.p004ui.text.Placeholder;
import androidx.compose.p004ui.text.TextStyle;
import androidx.compose.p004ui.text.font.FontFamily;
import androidx.compose.p004ui.text.style.TextOverflow;
import androidx.compose.p004ui.unit.Constraints;
import androidx.compose.p004ui.unit.Density;
import androidx.compose.p004ui.unit.LayoutDirection;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.on2;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class CoreTextKt {

    @NotNull
    private static final Pair<List<AnnotatedString.Range<Placeholder>>, List<AnnotatedString.Range<Function3<String, Composer, Integer, Unit>>>> EmptyInlineContent = new Pair<>(CollectionsKt.emptyList(), CollectionsKt.emptyList());

    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    public static final void InlineChildren(@NotNull final AnnotatedString annotatedString, @NotNull final List<AnnotatedString.Range<Function3<String, Composer, Integer, Unit>>> list, @Nullable Composer composer, final int i) {
        Intrinsics.checkNotNullParameter(annotatedString, "text");
        Intrinsics.checkNotNullParameter(list, "inlineContents");
        Composer startRestartGroup = composer.startRestartGroup(-110905764);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-110905764, i, -1, "androidx.compose.foundation.text.InlineChildren (CoreText.kt:75)");
        }
        int size = list.size();
        int i2 = 0;
        while (i2 < size) {
            AnnotatedString.Range<Function3<String, Composer, Integer, Unit>> range = list.get(i2);
            Function3<String, Composer, Integer, Unit> component1 = range.component1();
            int component2 = range.component2();
            int component3 = range.component3();
            CoreTextKt$InlineChildren$1$2 coreTextKt$InlineChildren$1$2 = new MeasurePolicy() { // from class: androidx.compose.foundation.text.CoreTextKt$InlineChildren$1$2
                @Override // androidx.compose.p004ui.layout.MeasurePolicy
                public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list2, int i3) {
                    return on2.a(this, intrinsicMeasureScope, list2, i3);
                }

                @Override // androidx.compose.p004ui.layout.MeasurePolicy
                public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list2, int i3) {
                    return on2.b(this, intrinsicMeasureScope, list2, i3);
                }

                @Override // androidx.compose.p004ui.layout.MeasurePolicy
                @NotNull
                /* renamed from: measure-3p2s80s */
                public final MeasureResult mo944measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull List<? extends Measurable> list2, long j) {
                    Intrinsics.checkNotNullParameter(measureScope, "$this$Layout");
                    Intrinsics.checkNotNullParameter(list2, "children");
                    final ArrayList arrayList = new ArrayList(list2.size());
                    int size2 = list2.size();
                    for (int i3 = 0; i3 < size2; i3++) {
                        arrayList.add(list2.get(i3).mo4187measureBRTryo0(j));
                    }
                    return MeasureScope.CC.m140p(measureScope, Constraints.m5184getMaxWidthimpl(j), Constraints.m5183getMaxHeightimpl(j), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.text.CoreTextKt$InlineChildren$1$2$measure$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((Placeable.PlacementScope) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(@NotNull Placeable.PlacementScope placementScope) {
                            Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
                            List<Placeable> list3 = arrayList;
                            int size3 = list3.size();
                            for (int i4 = 0; i4 < size3; i4++) {
                                Placeable.PlacementScope.placeRelative$default(placementScope, list3.get(i4), 0, 0, 0.0f, 4, null);
                            }
                        }
                    }, 4, null);
                }

                @Override // androidx.compose.p004ui.layout.MeasurePolicy
                public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list2, int i3) {
                    return on2.c(this, intrinsicMeasureScope, list2, i3);
                }

                @Override // androidx.compose.p004ui.layout.MeasurePolicy
                public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list2, int i3) {
                    return on2.d(this, intrinsicMeasureScope, list2, i3);
                }
            };
            startRestartGroup.startReplaceableGroup(-1323940314);
            Modifier.Companion companion = Modifier.Companion;
            Density density = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
            Function0<ComposeUiNode> constructor = companion2.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(companion);
            int i3 = size;
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
            Composer m2410constructorimpl = Updater.m2410constructorimpl(startRestartGroup);
            Updater.m2417setimpl(m2410constructorimpl, coreTextKt$InlineChildren$1$2, companion2.getSetMeasurePolicy());
            Updater.m2417setimpl(m2410constructorimpl, density, companion2.getSetDensity());
            Updater.m2417setimpl(m2410constructorimpl, layoutDirection, companion2.getSetLayoutDirection());
            Updater.m2417setimpl(m2410constructorimpl, viewConfiguration, companion2.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf.invoke(SkippableUpdater.m2398boximpl(SkippableUpdater.m2399constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(-72427749);
            component1.invoke(annotatedString.subSequence(component2, component3).getText(), startRestartGroup, 0);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            i2++;
            size = i3;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextKt$InlineChildren$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable Composer composer2, int i4) {
                CoreTextKt.InlineChildren(AnnotatedString.this, list, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }

    @NotNull
    public static final Pair<List<AnnotatedString.Range<Placeholder>>, List<AnnotatedString.Range<Function3<String, Composer, Integer, Unit>>>> resolveInlineContent(@NotNull AnnotatedString annotatedString, @NotNull Map<String, InlineTextContent> map) {
        Intrinsics.checkNotNullParameter(annotatedString, "text");
        Intrinsics.checkNotNullParameter(map, "inlineContent");
        if (map.isEmpty()) {
            return EmptyInlineContent;
        }
        List<AnnotatedString.Range<String>> stringAnnotations = annotatedString.getStringAnnotations(InlineTextContentKt.INLINE_CONTENT_TAG, 0, annotatedString.length());
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int size = stringAnnotations.size();
        for (int i = 0; i < size; i++) {
            AnnotatedString.Range<String> range = stringAnnotations.get(i);
            InlineTextContent inlineTextContent = map.get(range.getItem());
            if (inlineTextContent != null) {
                arrayList.add(new AnnotatedString.Range(inlineTextContent.getPlaceholder(), range.getStart(), range.getEnd()));
                arrayList2.add(new AnnotatedString.Range(inlineTextContent.getChildren(), range.getStart(), range.getEnd()));
            }
        }
        return new Pair<>(arrayList, arrayList2);
    }

    @NotNull
    /* renamed from: updateTextDelegate-rm0N8CA, reason: not valid java name */
    public static final TextDelegate m1722updateTextDelegaterm0N8CA(@NotNull TextDelegate textDelegate, @NotNull AnnotatedString annotatedString, @NotNull TextStyle textStyle, @NotNull Density density, @NotNull FontFamily.Resolver resolver, boolean z, int i, int i2, int i3, @NotNull List<AnnotatedString.Range<Placeholder>> list) {
        Intrinsics.checkNotNullParameter(textDelegate, "current");
        Intrinsics.checkNotNullParameter(annotatedString, "text");
        Intrinsics.checkNotNullParameter(textStyle, "style");
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(resolver, "fontFamilyResolver");
        Intrinsics.checkNotNullParameter(list, "placeholders");
        if (Intrinsics.areEqual(textDelegate.getText(), annotatedString) && Intrinsics.areEqual(textDelegate.getStyle(), textStyle)) {
            if (textDelegate.getSoftWrap() == z) {
                if (TextOverflow.m5121equalsimpl0(textDelegate.m1780getOverflowgIe3tQ8(), i)) {
                    if (textDelegate.getMaxLines() == i2) {
                        if (textDelegate.getMinLines() == i3 && Intrinsics.areEqual(textDelegate.getDensity(), density) && Intrinsics.areEqual(textDelegate.getPlaceholders(), list) && textDelegate.getFontFamilyResolver() == resolver) {
                            return textDelegate;
                        }
                        return new TextDelegate(annotatedString, textStyle, i2, i3, z, i, density, resolver, list, null);
                    }
                    return new TextDelegate(annotatedString, textStyle, i2, i3, z, i, density, resolver, list, null);
                }
                return new TextDelegate(annotatedString, textStyle, i2, i3, z, i, density, resolver, list, null);
            }
        }
        return new TextDelegate(annotatedString, textStyle, i2, i3, z, i, density, resolver, list, null);
    }

    @NotNull
    /* renamed from: updateTextDelegate-x_uQXYA, reason: not valid java name */
    public static final TextDelegate m1724updateTextDelegatex_uQXYA(@NotNull TextDelegate textDelegate, @NotNull String str, @NotNull TextStyle textStyle, @NotNull Density density, @NotNull FontFamily.Resolver resolver, boolean z, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(textDelegate, "current");
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(textStyle, "style");
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(resolver, "fontFamilyResolver");
        if (Intrinsics.areEqual(textDelegate.getText().getText(), str) && Intrinsics.areEqual(textDelegate.getStyle(), textStyle)) {
            if (textDelegate.getSoftWrap() == z) {
                if (TextOverflow.m5121equalsimpl0(textDelegate.m1780getOverflowgIe3tQ8(), i)) {
                    if (textDelegate.getMaxLines() == i2) {
                        if (textDelegate.getMinLines() == i3 && Intrinsics.areEqual(textDelegate.getDensity(), density) && textDelegate.getFontFamilyResolver() == resolver) {
                            return textDelegate;
                        }
                        return new TextDelegate(new AnnotatedString(str, null, null, 6, null), textStyle, i2, i3, z, i, density, resolver, null, 256, null);
                    }
                    return new TextDelegate(new AnnotatedString(str, null, null, 6, null), textStyle, i2, i3, z, i, density, resolver, null, 256, null);
                }
                return new TextDelegate(new AnnotatedString(str, null, null, 6, null), textStyle, i2, i3, z, i, density, resolver, null, 256, null);
            }
        }
        return new TextDelegate(new AnnotatedString(str, null, null, 6, null), textStyle, i2, i3, z, i, density, resolver, null, 256, null);
    }
}
