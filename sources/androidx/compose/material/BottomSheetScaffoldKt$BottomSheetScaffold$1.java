package androidx.compose.material;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.p004ui.Alignment;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.graphics.Shape;
import androidx.compose.p004ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.p004ui.layout.LayoutCoordinates;
import androidx.compose.p004ui.layout.LayoutKt;
import androidx.compose.p004ui.layout.MeasurePolicy;
import androidx.compose.p004ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.p004ui.node.ComposeUiNode;
import androidx.compose.p004ui.platform.CompositionLocalsKt;
import androidx.compose.p004ui.platform.ViewConfiguration;
import androidx.compose.p004ui.semantics.SemanticsModifierKt;
import androidx.compose.p004ui.semantics.SemanticsPropertiesKt;
import androidx.compose.p004ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p004ui.unit.C0856Dp;
import androidx.compose.p004ui.unit.Constraints;
import androidx.compose.p004ui.unit.Density;
import androidx.compose.p004ui.unit.IntSize;
import androidx.compose.p004ui.unit.LayoutDirection;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
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
/* loaded from: classes.dex */
final class BottomSheetScaffoldKt$BottomSheetScaffold$1 extends Lambda implements Function3<BoxWithConstraintsScope, Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ int $$dirty1;
    final /* synthetic */ int $$dirty2;
    final /* synthetic */ long $backgroundColor;
    final /* synthetic */ Function3<PaddingValues, Composer, Integer, Unit> $content;
    final /* synthetic */ long $contentColor;
    final /* synthetic */ long $drawerBackgroundColor;
    final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> $drawerContent;
    final /* synthetic */ long $drawerContentColor;
    final /* synthetic */ float $drawerElevation;
    final /* synthetic */ boolean $drawerGesturesEnabled;
    final /* synthetic */ long $drawerScrimColor;
    final /* synthetic */ Shape $drawerShape;
    final /* synthetic */ Function2<Composer, Integer, Unit> $floatingActionButton;
    final /* synthetic */ int $floatingActionButtonPosition;
    final /* synthetic */ BottomSheetScaffoldState $scaffoldState;
    final /* synthetic */ CoroutineScope $scope;
    final /* synthetic */ long $sheetBackgroundColor;
    final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> $sheetContent;
    final /* synthetic */ long $sheetContentColor;
    final /* synthetic */ float $sheetElevation;
    final /* synthetic */ boolean $sheetGesturesEnabled;
    final /* synthetic */ float $sheetPeekHeight;
    final /* synthetic */ Shape $sheetShape;
    final /* synthetic */ Function3<SnackbarHostState, Composer, Integer, Unit> $snackbarHost;
    final /* synthetic */ Function2<Composer, Integer, Unit> $topBar;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    BottomSheetScaffoldKt$BottomSheetScaffold$1(BottomSheetScaffoldState bottomSheetScaffoldState, boolean z, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, boolean z2, Shape shape, float f, long j, long j2, long j3, int i, float f2, CoroutineScope coroutineScope, int i2, int i3, long j4, long j5, int i4, Function2<? super Composer, ? super Integer, Unit> function2, Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function32, Shape shape2, long j6, long j7, float f3, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function33, Function2<? super Composer, ? super Integer, Unit> function22, Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function34) {
        super(3);
        this.$scaffoldState = bottomSheetScaffoldState;
        this.$sheetGesturesEnabled = z;
        this.$drawerContent = function3;
        this.$drawerGesturesEnabled = z2;
        this.$drawerShape = shape;
        this.$drawerElevation = f;
        this.$drawerBackgroundColor = j;
        this.$drawerContentColor = j2;
        this.$drawerScrimColor = j3;
        this.$$dirty1 = i;
        this.$sheetPeekHeight = f2;
        this.$scope = coroutineScope;
        this.$floatingActionButtonPosition = i2;
        this.$$dirty = i3;
        this.$backgroundColor = j4;
        this.$contentColor = j5;
        this.$$dirty2 = i4;
        this.$topBar = function2;
        this.$content = function32;
        this.$sheetShape = shape2;
        this.$sheetBackgroundColor = j6;
        this.$sheetContentColor = j7;
        this.$sheetElevation = f3;
        this.$sheetContent = function33;
        this.$floatingActionButton = function22;
        this.$snackbarHost = function34;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-2, reason: not valid java name */
    public static final float m1960invoke$lambda2(MutableState<Float> mutableState) {
        return mutableState.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-3, reason: not valid java name */
    public static final void m1961invoke$lambda3(MutableState<Float> mutableState, float f) {
        mutableState.setValue(Float.valueOf(f));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((BoxWithConstraintsScope) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@NotNull BoxWithConstraintsScope boxWithConstraintsScope, @Nullable Composer composer, int i) {
        int i2;
        Modifier m2253swipeablepPrIpRY;
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
            ComposerKt.traceEventStart(-440488519, i, -1, "androidx.compose.material.BottomSheetScaffold.<anonymous> (BottomSheetScaffold.kt:284)");
        }
        float m5183getMaxHeightimpl = Constraints.m5183getMaxHeightimpl(boxWithConstraintsScope.mo1365getConstraintsmsEJaDk());
        final float mo1283toPx0680j_4 = ((Density) composer.consume(CompositionLocalsKt.getLocalDensity())).mo1283toPx0680j_4(this.$sheetPeekHeight);
        composer.startReplaceableGroup(-492369756);
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(m5183getMaxHeightimpl), null, 2, null);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        final MutableState mutableState = (MutableState) rememberedValue;
        m2253swipeablepPrIpRY = SwipeableKt.m2253swipeablepPrIpRY(NestedScrollModifierKt.nestedScroll$default(Modifier.Companion, this.$scaffoldState.getBottomSheetState().getNestedScrollConnection$material_release(), null, 2, null), this.$scaffoldState.getBottomSheetState(), r18, Orientation.Vertical, (r26 & 8) != 0 ? true : this.$sheetGesturesEnabled, (r26 & 16) != 0 ? false : false, (r26 & 32) != 0 ? null : null, (r26 & 64) != 0 ? new Function2<T, T, FixedThreshold>() { // from class: androidx.compose.material.SwipeableKt$swipeable$1
            @NotNull
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final FixedThreshold m2258invoke(T t, T t2) {
                return new FixedThreshold(C0856Dp.m5216constructorimpl(56), null);
            }
        } : null, (r26 & 128) != 0 ? SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, MapsKt.mapOf(new Pair[]{TuplesKt.to(Float.valueOf(m5183getMaxHeightimpl - mo1283toPx0680j_4), BottomSheetValue.Collapsed), TuplesKt.to(Float.valueOf(m5183getMaxHeightimpl - m1960invoke$lambda2(mutableState)), BottomSheetValue.Expanded)}).keySet(), 0.0f, 0.0f, 6, null) : null, (r26 & 256) != 0 ? SwipeableDefaults.INSTANCE.m2252getVelocityThresholdD9Ej5fM() : 0.0f);
        final BottomSheetScaffoldState bottomSheetScaffoldState = this.$scaffoldState;
        final CoroutineScope coroutineScope = this.$scope;
        final Modifier semantics$default = SemanticsModifierKt.semantics$default(m2253swipeablepPrIpRY, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$1$swipeable$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((SemanticsPropertyReceiver) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
                float m1960invoke$lambda2;
                Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$semantics");
                float f = mo1283toPx0680j_4;
                m1960invoke$lambda2 = BottomSheetScaffoldKt$BottomSheetScaffold$1.m1960invoke$lambda2(mutableState);
                if (f == m1960invoke$lambda2) {
                    return;
                }
                if (bottomSheetScaffoldState.getBottomSheetState().isCollapsed()) {
                    final BottomSheetScaffoldState bottomSheetScaffoldState2 = bottomSheetScaffoldState;
                    final CoroutineScope coroutineScope2 = coroutineScope;
                    SemanticsPropertiesKt.expand$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$1$swipeable$1.1

                        /* compiled from: Taobao */
                        @DebugMetadata(c = "androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$1$swipeable$1$1$1", f = "BottomSheetScaffold.kt", i = {}, l = {307}, m = "invokeSuspend", n = {}, s = {})
                        /* renamed from: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$1$swipeable$1$1$1, reason: invalid class name */
                        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                            final /* synthetic */ BottomSheetScaffoldState $scaffoldState;
                            int label;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            AnonymousClass1(BottomSheetScaffoldState bottomSheetScaffoldState, Continuation<? super AnonymousClass1> continuation) {
                                super(2, continuation);
                                this.$scaffoldState = bottomSheetScaffoldState;
                            }

                            @NotNull
                            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                                return new AnonymousClass1(this.$scaffoldState, continuation);
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
                                    BottomSheetState bottomSheetState = this.$scaffoldState.getBottomSheetState();
                                    this.label = 1;
                                    if (bottomSheetState.expand(this) == coroutine_suspended) {
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
                        public final Boolean m1962invoke() {
                            if (((Boolean) BottomSheetScaffoldState.this.getBottomSheetState().getConfirmStateChange$material_release().invoke(BottomSheetValue.Expanded)).booleanValue()) {
                                d.d(coroutineScope2, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(BottomSheetScaffoldState.this, null), 3, (Object) null);
                            }
                            return Boolean.TRUE;
                        }
                    }, 1, null);
                } else {
                    final BottomSheetScaffoldState bottomSheetScaffoldState3 = bottomSheetScaffoldState;
                    final CoroutineScope coroutineScope3 = coroutineScope;
                    SemanticsPropertiesKt.collapse$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$1$swipeable$1.2

                        /* compiled from: Taobao */
                        @DebugMetadata(c = "androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$1$swipeable$1$2$1", f = "BottomSheetScaffold.kt", i = {}, l = {314}, m = "invokeSuspend", n = {}, s = {})
                        /* renamed from: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$1$swipeable$1$2$1, reason: invalid class name */
                        /* loaded from: classes2.dex */
                        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                            final /* synthetic */ BottomSheetScaffoldState $scaffoldState;
                            int label;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            AnonymousClass1(BottomSheetScaffoldState bottomSheetScaffoldState, Continuation<? super AnonymousClass1> continuation) {
                                super(2, continuation);
                                this.$scaffoldState = bottomSheetScaffoldState;
                            }

                            @NotNull
                            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                                return new AnonymousClass1(this.$scaffoldState, continuation);
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
                                    BottomSheetState bottomSheetState = this.$scaffoldState.getBottomSheetState();
                                    this.label = 1;
                                    if (bottomSheetState.collapse(this) == coroutine_suspended) {
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
                        public final Boolean m1963invoke() {
                            if (((Boolean) BottomSheetScaffoldState.this.getBottomSheetState().getConfirmStateChange$material_release().invoke(BottomSheetValue.Collapsed)).booleanValue()) {
                                d.d(coroutineScope3, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(BottomSheetScaffoldState.this, null), 3, (Object) null);
                            }
                            return Boolean.TRUE;
                        }
                    }, 1, null);
                }
            }
        }, 1, null);
        final BottomSheetScaffoldState bottomSheetScaffoldState2 = this.$scaffoldState;
        final int i3 = this.$floatingActionButtonPosition;
        final int i4 = this.$$dirty;
        final long j = this.$backgroundColor;
        final long j2 = this.$contentColor;
        final int i5 = this.$$dirty2;
        final Function2<Composer, Integer, Unit> function2 = this.$topBar;
        final Function3<PaddingValues, Composer, Integer, Unit> function3 = this.$content;
        final float f = this.$sheetPeekHeight;
        final Shape shape = this.$sheetShape;
        final long j3 = this.$sheetBackgroundColor;
        final long j4 = this.$sheetContentColor;
        final float f2 = this.$sheetElevation;
        final int i6 = this.$$dirty1;
        final Function3<ColumnScope, Composer, Integer, Unit> function32 = this.$sheetContent;
        final Function2<Composer, Integer, Unit> function22 = this.$floatingActionButton;
        final Function3<SnackbarHostState, Composer, Integer, Unit> function33 = this.$snackbarHost;
        ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer, -455982883, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$1$child$1
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
            public final void invoke(@Nullable Composer composer2, int i7) {
                if ((i7 & 11) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-455982883, i7, -1, "androidx.compose.material.BottomSheetScaffold.<anonymous>.<anonymous> (BottomSheetScaffold.kt:321)");
                }
                final long j5 = j;
                final long j6 = j2;
                final int i8 = i5;
                final Function2<Composer, Integer, Unit> function23 = function2;
                final int i9 = i4;
                final Function3<PaddingValues, Composer, Integer, Unit> function34 = function3;
                final float f3 = f;
                ComposableLambda composableLambda2 = ComposableLambdaKt.composableLambda(composer2, 729683080, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$1$child$1.1
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
                    public final void invoke(@Nullable Composer composer3, int i10) {
                        if ((i10 & 11) == 2 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(729683080, i10, -1, "androidx.compose.material.BottomSheetScaffold.<anonymous>.<anonymous>.<anonymous> (BottomSheetScaffold.kt:323)");
                        }
                        long j7 = j5;
                        long j8 = j6;
                        final Function2<Composer, Integer, Unit> function24 = function23;
                        final int i11 = i9;
                        final Function3<PaddingValues, Composer, Integer, Unit> function35 = function34;
                        final float f4 = f3;
                        final int i12 = i8;
                        ComposableLambda composableLambda3 = ComposableLambdaKt.composableLambda(composer3, 2013303492, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt.BottomSheetScaffold.1.child.1.1.1
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
                            public final void invoke(@Nullable Composer composer4, int i13) {
                                if ((i13 & 11) == 2 && composer4.getSkipping()) {
                                    composer4.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(2013303492, i13, -1, "androidx.compose.material.BottomSheetScaffold.<anonymous>.<anonymous>.<anonymous>.<anonymous> (BottomSheetScaffold.kt:327)");
                                }
                                Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, null);
                                Function2<Composer, Integer, Unit> function25 = function24;
                                int i14 = i11;
                                Function3<PaddingValues, Composer, Integer, Unit> function36 = function35;
                                float f5 = f4;
                                int i15 = i12;
                                composer4.startReplaceableGroup(-483455358);
                                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer4, 0);
                                composer4.startReplaceableGroup(-1323940314);
                                Density density = (Density) composer4.consume(CompositionLocalsKt.getLocalDensity());
                                LayoutDirection layoutDirection = (LayoutDirection) composer4.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                ViewConfiguration viewConfiguration = (ViewConfiguration) composer4.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                ComposeUiNode.Companion companion = ComposeUiNode.Companion;
                                Function0<ComposeUiNode> constructor = companion.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(fillMaxSize$default);
                                if (!(composer4.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer4.startReusableNode();
                                if (composer4.getInserting()) {
                                    composer4.createNode(constructor);
                                } else {
                                    composer4.useNode();
                                }
                                composer4.disableReusing();
                                Composer m2410constructorimpl = Updater.m2410constructorimpl(composer4);
                                Updater.m2417setimpl(m2410constructorimpl, columnMeasurePolicy, companion.getSetMeasurePolicy());
                                Updater.m2417setimpl(m2410constructorimpl, density, companion.getSetDensity());
                                Updater.m2417setimpl(m2410constructorimpl, layoutDirection, companion.getSetLayoutDirection());
                                Updater.m2417setimpl(m2410constructorimpl, viewConfiguration, companion.getSetViewConfiguration());
                                composer4.enableReusing();
                                materializerOf.invoke(SkippableUpdater.m2398boximpl(SkippableUpdater.m2399constructorimpl(composer4)), composer4, 0);
                                composer4.startReplaceableGroup(2058660585);
                                composer4.startReplaceableGroup(-1163856341);
                                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                composer4.startReplaceableGroup(521184014);
                                composer4.startReplaceableGroup(-1579943829);
                                if (function25 != null) {
                                    function25.invoke(composer4, Integer.valueOf((i14 >> 9) & 14));
                                }
                                composer4.endReplaceableGroup();
                                function36.invoke(PaddingKt.m1391PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, f5, 7, null), composer4, Integer.valueOf((i15 >> 3) & 112));
                                composer4.endReplaceableGroup();
                                composer4.endReplaceableGroup();
                                composer4.endReplaceableGroup();
                                composer4.endNode();
                                composer4.endReplaceableGroup();
                                composer4.endReplaceableGroup();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        });
                        int i13 = i8;
                        SurfaceKt.m2242SurfaceFjzlyU(null, null, j7, j8, null, 0.0f, composableLambda3, composer3, 1572864 | ((i13 << 6) & 896) | ((i13 << 6) & 7168), 51);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                });
                final Modifier modifier = semantics$default;
                final float f4 = f;
                final MutableState<Float> mutableState2 = mutableState;
                final Shape shape2 = shape;
                final long j7 = j3;
                final long j8 = j4;
                final float f5 = f2;
                final int i10 = i4;
                final int i11 = i6;
                final Function3<ColumnScope, Composer, Integer, Unit> function35 = function32;
                ComposableLambda composableLambda3 = ComposableLambdaKt.composableLambda(composer2, -1113066167, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$1$child$1.2
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
                    public final void invoke(@Nullable Composer composer3, int i12) {
                        if ((i12 & 11) == 2 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1113066167, i12, -1, "androidx.compose.material.BottomSheetScaffold.<anonymous>.<anonymous>.<anonymous> (BottomSheetScaffold.kt:334)");
                        }
                        Modifier m1428requiredHeightInVpY3zN4$default = SizeKt.m1428requiredHeightInVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.this, 0.0f, 1, null), f4, 0.0f, 2, null);
                        final MutableState<Float> mutableState3 = mutableState2;
                        composer3.startReplaceableGroup(1157296644);
                        boolean changed = composer3.changed(mutableState3);
                        Object rememberedValue2 = composer3.rememberedValue();
                        if (changed || rememberedValue2 == Composer.Companion.getEmpty()) {
                            rememberedValue2 = new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$1$child$1$2$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((LayoutCoordinates) obj);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(@NotNull LayoutCoordinates layoutCoordinates) {
                                    Intrinsics.checkNotNullParameter(layoutCoordinates, "it");
                                    BottomSheetScaffoldKt$BottomSheetScaffold$1.m1961invoke$lambda3(mutableState3, IntSize.m5375getHeightimpl(layoutCoordinates.mo4191getSizeYbymL2g()));
                                }
                            };
                            composer3.updateRememberedValue(rememberedValue2);
                        }
                        composer3.endReplaceableGroup();
                        Modifier onGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(m1428requiredHeightInVpY3zN4$default, (Function1) rememberedValue2);
                        Shape shape3 = shape2;
                        long j9 = j7;
                        long j10 = j8;
                        float f6 = f5;
                        final Function3<ColumnScope, Composer, Integer, Unit> function36 = function35;
                        final int i13 = i10;
                        ComposableLambda composableLambda4 = ComposableLambdaKt.composableLambda(composer3, 170554245, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt.BottomSheetScaffold.1.child.1.2.2
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
                            public final void invoke(@Nullable Composer composer4, int i14) {
                                if ((i14 & 11) == 2 && composer4.getSkipping()) {
                                    composer4.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(170554245, i14, -1, "androidx.compose.material.BottomSheetScaffold.<anonymous>.<anonymous>.<anonymous>.<anonymous> (BottomSheetScaffold.kt:346)");
                                }
                                Function3<ColumnScope, Composer, Integer, Unit> function37 = function36;
                                int i15 = (i13 << 9) & 7168;
                                composer4.startReplaceableGroup(-483455358);
                                Modifier.Companion companion = Modifier.Companion;
                                int i16 = i15 >> 3;
                                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer4, (i16 & 112) | (i16 & 14));
                                composer4.startReplaceableGroup(-1323940314);
                                Density density = (Density) composer4.consume(CompositionLocalsKt.getLocalDensity());
                                LayoutDirection layoutDirection = (LayoutDirection) composer4.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                ViewConfiguration viewConfiguration = (ViewConfiguration) composer4.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
                                Function0<ComposeUiNode> constructor = companion2.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(companion);
                                int i17 = ((((i15 << 3) & 112) << 9) & 7168) | 6;
                                if (!(composer4.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer4.startReusableNode();
                                if (composer4.getInserting()) {
                                    composer4.createNode(constructor);
                                } else {
                                    composer4.useNode();
                                }
                                composer4.disableReusing();
                                Composer m2410constructorimpl = Updater.m2410constructorimpl(composer4);
                                Updater.m2417setimpl(m2410constructorimpl, columnMeasurePolicy, companion2.getSetMeasurePolicy());
                                Updater.m2417setimpl(m2410constructorimpl, density, companion2.getSetDensity());
                                Updater.m2417setimpl(m2410constructorimpl, layoutDirection, companion2.getSetLayoutDirection());
                                Updater.m2417setimpl(m2410constructorimpl, viewConfiguration, companion2.getSetViewConfiguration());
                                composer4.enableReusing();
                                materializerOf.invoke(SkippableUpdater.m2398boximpl(SkippableUpdater.m2399constructorimpl(composer4)), composer4, Integer.valueOf((i17 >> 3) & 112));
                                composer4.startReplaceableGroup(2058660585);
                                composer4.startReplaceableGroup(-1163856341);
                                if (((i17 >> 9) & 14 & 11) == 2 && composer4.getSkipping()) {
                                    composer4.skipToGroupEnd();
                                } else {
                                    function37.invoke(ColumnScopeInstance.INSTANCE, composer4, Integer.valueOf(((i15 >> 6) & 112) | 6));
                                }
                                composer4.endReplaceableGroup();
                                composer4.endReplaceableGroup();
                                composer4.endNode();
                                composer4.endReplaceableGroup();
                                composer4.endReplaceableGroup();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        });
                        int i14 = i10;
                        int i15 = i11;
                        SurfaceKt.m2242SurfaceFjzlyU(onGloballyPositioned, shape3, j9, j10, null, f6, composableLambda4, composer3, 1572864 | ((i14 >> 21) & 112) | ((i15 << 6) & 896) | ((i15 << 6) & 7168) | ((i14 >> 12) & 458752), 16);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                });
                final Function2<Composer, Integer, Unit> function24 = function22;
                final int i12 = i4;
                ComposableLambda composableLambda4 = ComposableLambdaKt.composableLambda(composer2, 1339151882, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$1$child$1.3
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
                    public final void invoke(@Nullable Composer composer3, int i13) {
                        if ((i13 & 11) == 2 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1339151882, i13, -1, "androidx.compose.material.BottomSheetScaffold.<anonymous>.<anonymous>.<anonymous> (BottomSheetScaffold.kt:349)");
                        }
                        Function2<Composer, Integer, Unit> function25 = function24;
                        int i14 = i12;
                        composer3.startReplaceableGroup(733328855);
                        Modifier.Companion companion = Modifier.Companion;
                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, composer3, 0);
                        composer3.startReplaceableGroup(-1323940314);
                        Density density = (Density) composer3.consume(CompositionLocalsKt.getLocalDensity());
                        LayoutDirection layoutDirection = (LayoutDirection) composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
                        ViewConfiguration viewConfiguration = (ViewConfiguration) composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
                        ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
                        Function0<ComposeUiNode> constructor = companion2.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(companion);
                        if (!(composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer3.startReusableNode();
                        if (composer3.getInserting()) {
                            composer3.createNode(constructor);
                        } else {
                            composer3.useNode();
                        }
                        composer3.disableReusing();
                        Composer m2410constructorimpl = Updater.m2410constructorimpl(composer3);
                        Updater.m2417setimpl(m2410constructorimpl, rememberBoxMeasurePolicy, companion2.getSetMeasurePolicy());
                        Updater.m2417setimpl(m2410constructorimpl, density, companion2.getSetDensity());
                        Updater.m2417setimpl(m2410constructorimpl, layoutDirection, companion2.getSetLayoutDirection());
                        Updater.m2417setimpl(m2410constructorimpl, viewConfiguration, companion2.getSetViewConfiguration());
                        composer3.enableReusing();
                        materializerOf.invoke(SkippableUpdater.m2398boximpl(SkippableUpdater.m2399constructorimpl(composer3)), composer3, 0);
                        composer3.startReplaceableGroup(2058660585);
                        composer3.startReplaceableGroup(-2137368960);
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        composer3.startReplaceableGroup(-1521336816);
                        if (function25 != null) {
                            function25.invoke(composer3, Integer.valueOf((i14 >> 15) & 14));
                        }
                        composer3.endReplaceableGroup();
                        composer3.endReplaceableGroup();
                        composer3.endReplaceableGroup();
                        composer3.endNode();
                        composer3.endReplaceableGroup();
                        composer3.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                });
                final Function3<SnackbarHostState, Composer, Integer, Unit> function36 = function33;
                final BottomSheetScaffoldState bottomSheetScaffoldState3 = BottomSheetScaffoldState.this;
                final int i13 = i4;
                BottomSheetScaffoldKt.m1956BottomSheetScaffoldStackSlNgfk0(composableLambda2, composableLambda3, composableLambda4, ComposableLambdaKt.composableLambda(composer2, -503597365, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$1$child$1.4
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
                    public final void invoke(@Nullable Composer composer3, int i14) {
                        if ((i14 & 11) == 2 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-503597365, i14, -1, "androidx.compose.material.BottomSheetScaffold.<anonymous>.<anonymous>.<anonymous> (BottomSheetScaffold.kt:354)");
                        }
                        Function3<SnackbarHostState, Composer, Integer, Unit> function37 = function36;
                        BottomSheetScaffoldState bottomSheetScaffoldState4 = bottomSheetScaffoldState3;
                        int i15 = i13;
                        composer3.startReplaceableGroup(733328855);
                        Modifier.Companion companion = Modifier.Companion;
                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, composer3, 0);
                        composer3.startReplaceableGroup(-1323940314);
                        Density density = (Density) composer3.consume(CompositionLocalsKt.getLocalDensity());
                        LayoutDirection layoutDirection = (LayoutDirection) composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
                        ViewConfiguration viewConfiguration = (ViewConfiguration) composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
                        ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
                        Function0<ComposeUiNode> constructor = companion2.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(companion);
                        if (!(composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer3.startReusableNode();
                        if (composer3.getInserting()) {
                            composer3.createNode(constructor);
                        } else {
                            composer3.useNode();
                        }
                        composer3.disableReusing();
                        Composer m2410constructorimpl = Updater.m2410constructorimpl(composer3);
                        Updater.m2417setimpl(m2410constructorimpl, rememberBoxMeasurePolicy, companion2.getSetMeasurePolicy());
                        Updater.m2417setimpl(m2410constructorimpl, density, companion2.getSetDensity());
                        Updater.m2417setimpl(m2410constructorimpl, layoutDirection, companion2.getSetLayoutDirection());
                        Updater.m2417setimpl(m2410constructorimpl, viewConfiguration, companion2.getSetViewConfiguration());
                        composer3.enableReusing();
                        materializerOf.invoke(SkippableUpdater.m2398boximpl(SkippableUpdater.m2399constructorimpl(composer3)), composer3, 0);
                        composer3.startReplaceableGroup(2058660585);
                        composer3.startReplaceableGroup(-2137368960);
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        composer3.startReplaceableGroup(930881233);
                        function37.invoke(bottomSheetScaffoldState4.getSnackbarHostState(), composer3, Integer.valueOf((i15 >> 9) & 112));
                        composer3.endReplaceableGroup();
                        composer3.endReplaceableGroup();
                        composer3.endReplaceableGroup();
                        composer3.endNode();
                        composer3.endReplaceableGroup();
                        composer3.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), BottomSheetScaffoldState.this.getBottomSheetState().getOffset(), i3, composer2, (458752 & (i4 >> 3)) | 3510);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        });
        if (this.$drawerContent == null) {
            composer.startReplaceableGroup(-249545651);
            composableLambda.invoke(composer, 6);
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(-249545614);
            Function3<ColumnScope, Composer, Integer, Unit> function34 = this.$drawerContent;
            DrawerState drawerState = this.$scaffoldState.getDrawerState();
            boolean z = this.$drawerGesturesEnabled;
            Shape shape2 = this.$drawerShape;
            float f3 = this.$drawerElevation;
            long j5 = this.$drawerBackgroundColor;
            long j6 = this.$drawerContentColor;
            long j7 = this.$drawerScrimColor;
            int i7 = this.$$dirty1;
            DrawerKt.m2067ModalDrawerGs3lGvM(function34, null, drawerState, z, shape2, f3, j5, j6, j7, composableLambda, composer, ((i7 >> 3) & 7168) | ((i7 >> 9) & 14) | 805306368 | ((i7 >> 3) & 57344) | ((i7 >> 3) & 458752) | ((i7 >> 3) & 3670016) | ((i7 >> 3) & 29360128) | ((i7 >> 3) & 234881024), 2);
            composer.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
