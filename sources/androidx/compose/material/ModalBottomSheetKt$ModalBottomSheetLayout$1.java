package androidx.compose.material;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode$Companion;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class ModalBottomSheetKt$ModalBottomSheetLayout$1 extends Lambda implements Function3<BoxWithConstraintsScope, Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Function2<Composer, Integer, Unit> $content;
    final /* synthetic */ CoroutineScope $scope;
    final /* synthetic */ long $scrimColor;
    final /* synthetic */ long $sheetBackgroundColor;
    final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> $sheetContent;
    final /* synthetic */ long $sheetContentColor;
    final /* synthetic */ float $sheetElevation;
    final /* synthetic */ Shape $sheetShape;
    final /* synthetic */ ModalBottomSheetState $sheetState;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    ModalBottomSheetKt$ModalBottomSheetLayout$1(ModalBottomSheetState modalBottomSheetState, int i, Shape shape, long j, long j2, float f, Function2<? super Composer, ? super Integer, Unit> function2, long j3, CoroutineScope coroutineScope, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3) {
        super(3);
        this.$sheetState = modalBottomSheetState;
        this.$$dirty = i;
        this.$sheetShape = shape;
        this.$sheetBackgroundColor = j;
        this.$sheetContentColor = j2;
        this.$sheetElevation = f;
        this.$content = function2;
        this.$scrimColor = j3;
        this.$scope = coroutineScope;
        this.$sheetContent = function3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((BoxWithConstraintsScope) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@NotNull BoxWithConstraintsScope boxWithConstraintsScope, @Nullable Composer composer, int i) {
        int i2;
        float f;
        Intrinsics.checkNotNullParameter(boxWithConstraintsScope, "$this$BoxWithConstraints");
        if ((i & 14) == 0) {
            i2 = (composer.changed(boxWithConstraintsScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 91) == 18 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1607356310, i, -1, "androidx.compose.material.ModalBottomSheetLayout.<anonymous> (ModalBottomSheet.kt:325)");
        }
        float m2121getMaxHeightimpl = Constraints.m2121getMaxHeightimpl(boxWithConstraintsScope.getConstraints-msEJaDk());
        composer.startReplaceableGroup(-492369756);
        Object rememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.Companion;
        if (rememberedValue == companion.getEmpty()) {
            rememberedValue = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        MutableState mutableState = (MutableState) rememberedValue;
        Modifier.Companion companion2 = Modifier.Companion;
        Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(companion2, 0.0f, 1, (Object) null);
        Function2<Composer, Integer, Unit> function2 = this.$content;
        int i3 = this.$$dirty;
        long j = this.$scrimColor;
        ModalBottomSheetState modalBottomSheetState = this.$sheetState;
        CoroutineScope coroutineScope = this.$scope;
        composer.startReplaceableGroup(733328855);
        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, composer, 0);
        composer.startReplaceableGroup(-1323940314);
        Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration = (ViewConfiguration) composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
        ComposeUiNode$Companion composeUiNode$Companion = ComposeUiNode.Companion;
        Function0<ComposeUiNode> constructor = composeUiNode$Companion.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(fillMaxSize$default);
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
        Composer m747constructorimpl = Updater.m747constructorimpl(composer);
        Updater.m754setimpl(m747constructorimpl, rememberBoxMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) composeUiNode$Companion.getSetMeasurePolicy());
        Updater.m754setimpl(m747constructorimpl, density, (Function2<? super T, ? super Density, Unit>) composeUiNode$Companion.getSetDensity());
        Updater.m754setimpl(m747constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) composeUiNode$Companion.getSetLayoutDirection());
        Updater.m754setimpl(m747constructorimpl, viewConfiguration, (Function2<? super T, ? super ViewConfiguration, Unit>) composeUiNode$Companion.getSetViewConfiguration());
        composer.enableReusing();
        materializerOf.invoke(SkippableUpdater.box-impl(SkippableUpdater.constructor-impl(composer)), composer, 0);
        composer.startReplaceableGroup(2058660585);
        composer.startReplaceableGroup(-2137368960);
        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
        composer.startReplaceableGroup(-402723888);
        function2.invoke(composer, Integer.valueOf((i3 >> 24) & 14));
        ModalBottomSheetKt.access$Scrim-3J-VO9M(j, new 1.1(modalBottomSheetState, coroutineScope), modalBottomSheetState.getTargetValue() != ModalBottomSheetValue.Hidden, composer, (i3 >> 21) & 14);
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        composer.endNode();
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        Modifier nestedScroll$default = NestedScrollModifierKt.nestedScroll$default(SizeKt.fillMaxWidth$default(companion2, 0.0f, 1, (Object) null), this.$sheetState.getNestedScrollConnection$material_release(), (NestedScrollDispatcher) null, 2, (Object) null);
        Object obj = this.$sheetState;
        Object valueOf = Float.valueOf(m2121getMaxHeightimpl);
        ModalBottomSheetState modalBottomSheetState2 = this.$sheetState;
        composer.startReplaceableGroup(511388516);
        boolean changed = composer.changed(obj) | composer.changed(valueOf);
        Object rememberedValue2 = composer.rememberedValue();
        if (changed || rememberedValue2 == companion.getEmpty()) {
            f = m2121getMaxHeightimpl;
            rememberedValue2 = new 2.1(modalBottomSheetState2, f);
            composer.updateRememberedValue(rememberedValue2);
        } else {
            f = m2121getMaxHeightimpl;
        }
        composer.endReplaceableGroup();
        Modifier access$bottomSheetSwipeable = ModalBottomSheetKt.access$bottomSheetSwipeable(OffsetKt.offset(nestedScroll$default, (Function1) rememberedValue2), this.$sheetState, f, mutableState);
        composer.startReplaceableGroup(1157296644);
        boolean changed2 = composer.changed(mutableState);
        Object rememberedValue3 = composer.rememberedValue();
        if (changed2 || rememberedValue3 == companion.getEmpty()) {
            rememberedValue3 = new 3.1(mutableState);
            composer.updateRememberedValue(rememberedValue3);
        }
        composer.endReplaceableGroup();
        Modifier onGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(access$bottomSheetSwipeable, (Function1) rememberedValue3);
        final ModalBottomSheetState modalBottomSheetState3 = this.$sheetState;
        final CoroutineScope coroutineScope2 = this.$scope;
        Modifier semantics$default = SemanticsModifierKt.semantics$default(onGloballyPositioned, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1.4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                invoke((SemanticsPropertyReceiver) obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
                Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$semantics");
                if (ModalBottomSheetState.this.isVisible()) {
                    final ModalBottomSheetState modalBottomSheetState4 = ModalBottomSheetState.this;
                    final CoroutineScope coroutineScope3 = coroutineScope2;
                    SemanticsPropertiesKt.dismiss$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.material.ModalBottomSheetKt.ModalBottomSheetLayout.1.4.1

                        /* compiled from: Taobao */
                        @DebugMetadata(c = "androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$4$1$1", f = "ModalBottomSheet.kt", i = {}, l = {363}, m = "invokeSuspend", n = {}, s = {})
                        /* renamed from: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$4$1$1, reason: invalid class name and collision with other inner class name */
                        static final class C00061 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                            final /* synthetic */ ModalBottomSheetState $sheetState;
                            int label;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            C00061(ModalBottomSheetState modalBottomSheetState, Continuation<? super C00061> continuation) {
                                super(2, continuation);
                                this.$sheetState = modalBottomSheetState;
                            }

                            @NotNull
                            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                                return new C00061(this.$sheetState, continuation);
                            }

                            @Nullable
                            public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                                return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
                            }

                            @Nullable
                            public final Object invokeSuspend(@NotNull Object obj) {
                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                int i = this.label;
                                if (i == 0) {
                                    ResultKt.throwOnFailure(obj);
                                    ModalBottomSheetState modalBottomSheetState = this.$sheetState;
                                    this.label = 1;
                                    if (modalBottomSheetState.hide(this) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                } else {
                                    if (i != 1) {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    ResultKt.throwOnFailure(obj);
                                }
                                return Unit.INSTANCE;
                            }
                        }

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @NotNull
                        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                        public final Boolean m616invoke() {
                            if (((Boolean) ModalBottomSheetState.this.getConfirmStateChange$material_release().invoke(ModalBottomSheetValue.Hidden)).booleanValue()) {
                                d.d(coroutineScope3, (CoroutineContext) null, (CoroutineStart) null, new C00061(ModalBottomSheetState.this, null), 3, (Object) null);
                            }
                            return Boolean.TRUE;
                        }
                    }, 1, null);
                    if (ModalBottomSheetState.this.getCurrentValue() == ModalBottomSheetValue.HalfExpanded) {
                        final ModalBottomSheetState modalBottomSheetState5 = ModalBottomSheetState.this;
                        final CoroutineScope coroutineScope4 = coroutineScope2;
                        SemanticsPropertiesKt.expand$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.material.ModalBottomSheetKt.ModalBottomSheetLayout.1.4.2

                            /* compiled from: Taobao */
                            @DebugMetadata(c = "androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$4$2$1", f = "ModalBottomSheet.kt", i = {}, l = {370}, m = "invokeSuspend", n = {}, s = {})
                            /* renamed from: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$4$2$1, reason: invalid class name */
                            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                final /* synthetic */ ModalBottomSheetState $sheetState;
                                int label;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                AnonymousClass1(ModalBottomSheetState modalBottomSheetState, Continuation<? super AnonymousClass1> continuation) {
                                    super(2, continuation);
                                    this.$sheetState = modalBottomSheetState;
                                }

                                @NotNull
                                public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                                    return new AnonymousClass1(this.$sheetState, continuation);
                                }

                                @Nullable
                                public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                                    return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
                                }

                                @Nullable
                                public final Object invokeSuspend(@NotNull Object obj) {
                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    int i = this.label;
                                    if (i == 0) {
                                        ResultKt.throwOnFailure(obj);
                                        ModalBottomSheetState modalBottomSheetState = this.$sheetState;
                                        this.label = 1;
                                        if (modalBottomSheetState.expand$material_release(this) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                    } else {
                                        if (i != 1) {
                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                        }
                                        ResultKt.throwOnFailure(obj);
                                    }
                                    return Unit.INSTANCE;
                                }
                            }

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @NotNull
                            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                            public final Boolean m617invoke() {
                                if (((Boolean) ModalBottomSheetState.this.getConfirmStateChange$material_release().invoke(ModalBottomSheetValue.Expanded)).booleanValue()) {
                                    d.d(coroutineScope4, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(ModalBottomSheetState.this, null), 3, (Object) null);
                                }
                                return Boolean.TRUE;
                            }
                        }, 1, null);
                    } else if (ModalBottomSheetState.this.getHasHalfExpandedState$material_release()) {
                        final ModalBottomSheetState modalBottomSheetState6 = ModalBottomSheetState.this;
                        final CoroutineScope coroutineScope5 = coroutineScope2;
                        SemanticsPropertiesKt.collapse$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.material.ModalBottomSheetKt.ModalBottomSheetLayout.1.4.3

                            /* compiled from: Taobao */
                            @DebugMetadata(c = "androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$4$3$1", f = "ModalBottomSheet.kt", i = {}, l = {377}, m = "invokeSuspend", n = {}, s = {})
                            /* renamed from: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$4$3$1, reason: invalid class name */
                            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                final /* synthetic */ ModalBottomSheetState $sheetState;
                                int label;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                AnonymousClass1(ModalBottomSheetState modalBottomSheetState, Continuation<? super AnonymousClass1> continuation) {
                                    super(2, continuation);
                                    this.$sheetState = modalBottomSheetState;
                                }

                                @NotNull
                                public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                                    return new AnonymousClass1(this.$sheetState, continuation);
                                }

                                @Nullable
                                public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                                    return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
                                }

                                @Nullable
                                public final Object invokeSuspend(@NotNull Object obj) {
                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    int i = this.label;
                                    if (i == 0) {
                                        ResultKt.throwOnFailure(obj);
                                        ModalBottomSheetState modalBottomSheetState = this.$sheetState;
                                        this.label = 1;
                                        if (modalBottomSheetState.halfExpand$material_release(this) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                    } else {
                                        if (i != 1) {
                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                        }
                                        ResultKt.throwOnFailure(obj);
                                    }
                                    return Unit.INSTANCE;
                                }
                            }

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @NotNull
                            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                            public final Boolean m618invoke() {
                                if (((Boolean) ModalBottomSheetState.this.getConfirmStateChange$material_release().invoke(ModalBottomSheetValue.HalfExpanded)).booleanValue()) {
                                    d.d(coroutineScope5, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(ModalBottomSheetState.this, null), 3, (Object) null);
                                }
                                return Boolean.TRUE;
                            }
                        }, 1, null);
                    }
                }
            }
        }, 1, null);
        Shape shape = this.$sheetShape;
        long j2 = this.$sheetBackgroundColor;
        long j3 = this.$sheetContentColor;
        float f2 = this.$sheetElevation;
        final Function3<ColumnScope, Composer, Integer, Unit> function3 = this.$sheetContent;
        final int i4 = this.$$dirty;
        ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer, -1793508390, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1.5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                invoke((Composer) obj2, ((Number) obj3).intValue());
                return Unit.INSTANCE;
            }

            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
            @Composable
            public final void invoke(@Nullable Composer composer2, int i5) {
                if ((i5 & 11) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1793508390, i5, -1, "androidx.compose.material.ModalBottomSheetLayout.<anonymous>.<anonymous> (ModalBottomSheet.kt:387)");
                }
                Function3<ColumnScope, Composer, Integer, Unit> function32 = function3;
                int i6 = (i4 << 9) & 7168;
                composer2.startReplaceableGroup(-483455358);
                Modifier.Companion companion3 = Modifier.Companion;
                int i7 = i6 >> 3;
                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer2, (i7 & 112) | (i7 & 14));
                composer2.startReplaceableGroup(-1323940314);
                Density density2 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection2 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration2 = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposeUiNode$Companion composeUiNode$Companion2 = ComposeUiNode.Companion;
                Function0<ComposeUiNode> constructor2 = composeUiNode$Companion2.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf2 = LayoutKt.materializerOf(companion3);
                int i8 = ((((i6 << 3) & 112) << 9) & 7168) | 6;
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor2);
                } else {
                    composer2.useNode();
                }
                composer2.disableReusing();
                Composer m747constructorimpl2 = Updater.m747constructorimpl(composer2);
                Updater.m754setimpl(m747constructorimpl2, columnMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) composeUiNode$Companion2.getSetMeasurePolicy());
                Updater.m754setimpl(m747constructorimpl2, density2, (Function2<? super T, ? super Density, Unit>) composeUiNode$Companion2.getSetDensity());
                Updater.m754setimpl(m747constructorimpl2, layoutDirection2, (Function2<? super T, ? super LayoutDirection, Unit>) composeUiNode$Companion2.getSetLayoutDirection());
                Updater.m754setimpl(m747constructorimpl2, viewConfiguration2, (Function2<? super T, ? super ViewConfiguration, Unit>) composeUiNode$Companion2.getSetViewConfiguration());
                composer2.enableReusing();
                materializerOf2.invoke(SkippableUpdater.box-impl(SkippableUpdater.constructor-impl(composer2)), composer2, Integer.valueOf((i8 >> 3) & 112));
                composer2.startReplaceableGroup(2058660585);
                composer2.startReplaceableGroup(-1163856341);
                if (((i8 >> 9) & 14 & 11) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                } else {
                    function32.invoke(ColumnScopeInstance.INSTANCE, composer2, Integer.valueOf(((i6 >> 6) & 112) | 6));
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
        });
        int i5 = this.$$dirty;
        SurfaceKt.m659SurfaceFjzlyU(semantics$default, shape, j2, j3, null, f2, composableLambda, composer, 1572864 | ((i5 >> 6) & 112) | ((i5 >> 9) & 896) | ((i5 >> 9) & 7168) | ((i5 << 3) & 458752), 16);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
