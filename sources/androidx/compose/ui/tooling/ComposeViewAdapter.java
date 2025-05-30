package androidx.compose.ui.tooling;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.FrameLayout;
import androidx.activity.compose.LocalActivityResultRegistryOwner;
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.VisibleForTesting;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.DecayAnimation;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.TargetBasedAnimation;
import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.tooling.CompositionData;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.font.FontFamilyResolver_androidKt;
import androidx.compose.ui.tooling.ComposableSingletons;
import androidx.compose.ui.tooling.animation.PreviewAnimationClock;
import androidx.compose.ui.tooling.animation.UnsupportedComposeAnimation;
import androidx.compose.ui.tooling.data.Group;
import androidx.compose.ui.tooling.data.SlotTreeKt;
import androidx.compose.ui.tooling.data.SourceLocation;
import androidx.compose.ui.tooling.preview.PreviewParameterProvider;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KClasses;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class ComposeViewAdapter extends FrameLayout {

    @NotNull
    private final ComposeViewAdapter$FakeActivityResultRegistryOwner$1 FakeActivityResultRegistryOwner;

    @NotNull
    private final FakeOnBackPressedDispatcherOwner.1 FakeOnBackPressedDispatcherOwner;

    @SuppressLint({"VisibleForTests"})
    @NotNull
    private final FakeSavedStateRegistryOwner.1 FakeSavedStateRegistryOwner;

    @NotNull
    private final FakeViewModelStoreOwner.1 FakeViewModelStoreOwner;

    @NotNull
    private final String TAG;
    public PreviewAnimationClock clock;

    @NotNull
    private String composableName;

    @NotNull
    private final ComposeView composeView;

    @Nullable
    private Composition composition;

    @NotNull
    private final MutableState<Function2<Composer, Integer, Unit>> content;

    @NotNull
    private final Paint debugBoundsPaint;
    private boolean debugPaintBounds;
    private boolean debugViewInfos;

    @NotNull
    private final ThreadSafeException delayedException;

    @NotNull
    private List<String> designInfoList;

    @NotNull
    private String designInfoProvidersArgument;
    private boolean forceCompositionInvalidation;
    private boolean hasAnimations;
    private boolean lookForDesignInfoProviders;

    @NotNull
    private Function0<Unit> onDraw;

    @NotNull
    private Function2<? super Composer, ? super Integer, Unit> previewComposition;

    @NotNull
    private final CompositionDataRecord slotTableRecord;

    @NotNull
    private List<ViewInfo> viewInfos;

    /* compiled from: Taobao */
    private static class RememberSearch<T> extends Search<T> {

        @NotNull
        private final KClass<T> clazz;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RememberSearch(@NotNull KClass<T> kClass, @NotNull Function1<Object, Unit> function1) {
            super(function1);
            Intrinsics.checkNotNullParameter(kClass, "clazz");
            Intrinsics.checkNotNullParameter(function1, "trackAnimation");
            this.clazz = kClass;
        }

        @NotNull
        protected final <T> List<T> findRememberCallWithType(@NotNull Collection<? extends Group> collection, @NotNull KClass<T> kClass) {
            Object obj;
            Intrinsics.checkNotNullParameter(collection, "<this>");
            Intrinsics.checkNotNullParameter(kClass, "clazz");
            ArrayList arrayList = new ArrayList();
            for (T t : collection) {
                if (Intrinsics.areEqual(((Group) t).getName(), "remember")) {
                    arrayList.add(t);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                Iterator<T> it2 = ((Group) it.next()).getData().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    T next = it2.next();
                    if (Intrinsics.areEqual(next != null ? JvmClassMappingKt.getKotlinClass(next.getClass()) : null, kClass)) {
                        obj = next;
                        break;
                    }
                }
                Object safeCast = KClasses.safeCast(kClass, obj);
                if (safeCast != null) {
                    arrayList2.add(safeCast);
                }
            }
            return arrayList2;
        }

        public void parse(@NotNull Collection<? extends Group> collection) {
            Intrinsics.checkNotNullParameter(collection, "treeWithLocation");
            getAnimations().addAll(CollectionsKt.toSet(findRememberCallWithType(collection, this.clazz)));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r8v13, types: [androidx.compose.ui.tooling.ComposeViewAdapter$FakeActivityResultRegistryOwner$1] */
    public ComposeViewAdapter(@NotNull Context context, @NotNull AttributeSet attributeSet) {
        super(context, attributeSet);
        MutableState<Function2<Composer, Integer, Unit>> mutableStateOf$default;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
        this.TAG = "ComposeViewAdapter";
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        this.composeView = new ComposeView(context2, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        this.viewInfos = CollectionsKt.emptyList();
        this.designInfoList = CollectionsKt.emptyList();
        this.slotTableRecord = CompositionDataRecord.Companion.create();
        this.composableName = "";
        this.delayedException = new ThreadSafeException();
        this.previewComposition = ComposableSingletons.ComposeViewAdapterKt.INSTANCE.getLambda-2$ui_tooling_release();
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(ComposeViewAdapterKt.access$getEmptyContent$p(), null, 2, null);
        this.content = mutableStateOf$default;
        this.designInfoProvidersArgument = "";
        this.onDraw = onDraw.1.INSTANCE;
        Paint paint = new Paint();
        paint.setPathEffect(new DashPathEffect(new float[]{5.0f, 10.0f, 15.0f, 20.0f}, 0.0f));
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(ColorKt.toArgb-8_81llA(Color.Companion.m1082getRed0d7_KjU()));
        this.debugBoundsPaint = paint;
        this.FakeSavedStateRegistryOwner = new FakeSavedStateRegistryOwner.1();
        this.FakeViewModelStoreOwner = new FakeViewModelStoreOwner.1();
        this.FakeOnBackPressedDispatcherOwner = new FakeOnBackPressedDispatcherOwner.1(this);
        this.FakeActivityResultRegistryOwner = new ActivityResultRegistryOwner() { // from class: androidx.compose.ui.tooling.ComposeViewAdapter$FakeActivityResultRegistryOwner$1

            @NotNull
            private final ComposeViewAdapter$FakeActivityResultRegistryOwner$1$activityResultRegistry$1 activityResultRegistry = new ActivityResultRegistry() { // from class: androidx.compose.ui.tooling.ComposeViewAdapter$FakeActivityResultRegistryOwner$1$activityResultRegistry$1
                public <I, O> void onLaunch(int i, @NotNull ActivityResultContract<I, O> activityResultContract, I i2, @Nullable ActivityOptionsCompat activityOptionsCompat) {
                    Intrinsics.checkNotNullParameter(activityResultContract, "contract");
                    throw new IllegalStateException("Calling launch() is not supported in Preview");
                }
            };

            @Override // androidx.activity.result.ActivityResultRegistryOwner
            @NotNull
            public ActivityResultRegistry getActivityResultRegistry() {
                return this.activityResultRegistry;
            }
        };
        init(attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    public final void WrapPreview(final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(493526445);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(493526445, i, -1, "androidx.compose.ui.tooling.ComposeViewAdapter.WrapPreview (ComposeViewAdapter.kt:639)");
        }
        ProvidableCompositionLocal localFontLoader = CompositionLocalsKt.getLocalFontLoader();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        ProvidableCompositionLocal localFontFamilyResolver = CompositionLocalsKt.getLocalFontFamilyResolver();
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{localFontLoader.provides(new LayoutlibFontResourceLoader(context)), localFontFamilyResolver.provides(FontFamilyResolver_androidKt.createFontFamilyResolver(context2)), LocalOnBackPressedDispatcherOwner.INSTANCE.provides(this.FakeOnBackPressedDispatcherOwner), LocalActivityResultRegistryOwner.INSTANCE.provides(this.FakeActivityResultRegistryOwner)}, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(startRestartGroup, -1966112531, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.tooling.ComposeViewAdapter$WrapPreview$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return Unit.INSTANCE;
            }

            @Composable
            public final void invoke(@Nullable Composer composer2, int i2) {
                CompositionDataRecord compositionDataRecord;
                if ((i2 & 11) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1966112531, i2, -1, "androidx.compose.ui.tooling.ComposeViewAdapter.WrapPreview.<anonymous> (ComposeViewAdapter.kt:649)");
                }
                compositionDataRecord = ComposeViewAdapter.this.slotTableRecord;
                InspectableKt.Inspectable(compositionDataRecord, function2, composer2, (i << 3) & 112);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), startRestartGroup, 56);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.tooling.ComposeViewAdapter$WrapPreview$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable Composer composer2, int i2) {
                ComposeViewAdapter.this.WrapPreview(function2, composer2, i | 1);
            }
        });
    }

    private final List<Group> findAll(Group group, Function1<? super Group, Boolean> function1) {
        return findGroupsThatMatchPredicate$default(this, group, function1, false, 4, null);
    }

    private final void findAndTrackAnimations() {
        Set<CompositionData> store = this.slotTableRecord.getStore();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(store, 10));
        Iterator<T> it = store.iterator();
        while (it.hasNext()) {
            arrayList.add(SlotTreeKt.asTree((CompositionData) it.next()));
        }
        Search transitionSearch = new TransitionSearch(this, new Function1<Object, Unit>() { // from class: androidx.compose.ui.tooling.ComposeViewAdapter$findAndTrackAnimations$transitionSearch$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                m2547invoke(obj);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2547invoke(@NotNull Object obj) {
                Intrinsics.checkNotNullParameter(obj, "it");
                ComposeViewAdapter.this.getClock$ui_tooling_release().trackTransition((Transition) obj);
            }
        });
        Search animatedContentSearch = new AnimatedContentSearch(this, new findAndTrackAnimations.animatedContentSearch.1(this));
        Search animatedVisibilitySearch = new AnimatedVisibilitySearch(this, new findAndTrackAnimations.animatedVisibilitySearch.1(this));
        boolean z = false;
        Set plus = SetsKt.plus(SetsKt.setOf(new Search[]{transitionSearch, animatedVisibilitySearch}), UnsupportedComposeAnimation.Companion.getApiAvailable() ? SetsKt.setOf(new Search[]{animatedContentSearch, new AnimateXAsStateSearch(this, new Function1<Object, Unit>() { // from class: androidx.compose.ui.tooling.ComposeViewAdapter$findAndTrackAnimations$extraSearch$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                m2542invoke(obj);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2542invoke(@NotNull Object obj) {
                Intrinsics.checkNotNullParameter(obj, "it");
                ComposeViewAdapter.this.getClock$ui_tooling_release().trackAnimateXAsState((Animatable) obj);
            }
        }), new AnimateContentSizeSearch(new Function1<Object, Unit>() { // from class: androidx.compose.ui.tooling.ComposeViewAdapter$findAndTrackAnimations$extraSearch$2
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                m2543invoke(obj);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2543invoke(@NotNull Object obj) {
                Intrinsics.checkNotNullParameter(obj, "it");
                ComposeViewAdapter.this.getClock$ui_tooling_release().trackAnimateContentSize(obj);
            }
        }), new RememberSearch(Reflection.getOrCreateKotlinClass(TargetBasedAnimation.class), new Function1<Object, Unit>() { // from class: androidx.compose.ui.tooling.ComposeViewAdapter$findAndTrackAnimations$extraSearch$3
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                m2544invoke(obj);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2544invoke(@NotNull Object obj) {
                Intrinsics.checkNotNullParameter(obj, "it");
                ComposeViewAdapter.this.getClock$ui_tooling_release().trackTargetBasedAnimations((TargetBasedAnimation) obj);
            }
        }), new RememberSearch(Reflection.getOrCreateKotlinClass(DecayAnimation.class), new Function1<Object, Unit>() { // from class: androidx.compose.ui.tooling.ComposeViewAdapter$findAndTrackAnimations$extraSearch$4
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                m2545invoke(obj);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2545invoke(@NotNull Object obj) {
                Intrinsics.checkNotNullParameter(obj, "it");
                ComposeViewAdapter.this.getClock$ui_tooling_release().trackDecayAnimations((DecayAnimation) obj);
            }
        }), new RememberSearch(Reflection.getOrCreateKotlinClass(InfiniteTransition.class), new Function1<Object, Unit>() { // from class: androidx.compose.ui.tooling.ComposeViewAdapter$findAndTrackAnimations$extraSearch$5
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                m2546invoke(obj);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2546invoke(@NotNull Object obj) {
                Intrinsics.checkNotNullParameter(obj, "it");
                ComposeViewAdapter.this.getClock$ui_tooling_release().trackInfiniteTransition((InfiniteTransition) obj);
            }
        })}) : CollectionsKt.emptyList());
        Set plus2 = SetsKt.plus(plus, SetsKt.setOf(animatedContentSearch));
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            List<Group> findAll = findAll((Group) it2.next(), new Function1<Group, Boolean>() { // from class: androidx.compose.ui.tooling.ComposeViewAdapter$findAndTrackAnimations$1$treeWithLocation$1
                @NotNull
                public final Boolean invoke(@NotNull Group group) {
                    Intrinsics.checkNotNullParameter(group, "it");
                    return Boolean.valueOf(group.getLocation() != null);
                }
            });
            Iterator it3 = plus2.iterator();
            while (it3.hasNext()) {
                ((Search) it3.next()).parse(findAll);
            }
            transitionSearch.getAnimations().removeAll(animatedVisibilitySearch.getAnimations());
            transitionSearch.getAnimations().removeAll(animatedContentSearch.getAnimations());
        }
        if (!(plus instanceof Collection) || !plus.isEmpty()) {
            Iterator it4 = plus.iterator();
            while (true) {
                if (!it4.hasNext()) {
                    break;
                } else if (((Search) it4.next()).hasAnimations()) {
                    z = true;
                    break;
                }
            }
        }
        this.hasAnimations = z;
        if (this.clock != null) {
            Iterator it5 = plus.iterator();
            while (it5.hasNext()) {
                ((Search) it5.next()).track();
            }
        }
    }

    private final void findDesignInfoProviders() {
        String str;
        Set<CompositionData> store = this.slotTableRecord.getStore();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(store, 10));
        Iterator<T> it = store.iterator();
        while (it.hasNext()) {
            arrayList.add(SlotTreeKt.asTree((CompositionData) it.next()));
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            List<Group> findAll = findAll((Group) it2.next(), new Function1<Group, Boolean>() { // from class: androidx.compose.ui.tooling.ComposeViewAdapter$findDesignInfoProviders$1$1
                {
                    super(1);
                }

                /* JADX WARN: Removed duplicated region for block: B:23:0x006b A[EDGE_INSN: B:23:0x006b->B:6:0x006b BREAK  A[LOOP:0: B:10:0x001d->B:24:?], SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:24:? A[LOOP:0: B:10:0x001d->B:24:?, LOOP_END, SYNTHETIC] */
                @org.jetbrains.annotations.NotNull
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Boolean invoke(@org.jetbrains.annotations.NotNull androidx.compose.ui.tooling.data.Group r7) {
                    /*
                        r6 = this;
                        java.lang.String r0 = "group"
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
                        java.util.Collection r7 = r7.getChildren()
                        androidx.compose.ui.tooling.ComposeViewAdapter r0 = androidx.compose.ui.tooling.ComposeViewAdapter.this
                        boolean r1 = r7 instanceof java.util.Collection
                        r2 = 1
                        r3 = 0
                        if (r1 == 0) goto L19
                        boolean r1 = r7.isEmpty()
                        if (r1 == 0) goto L19
                    L17:
                        r2 = 0
                        goto L6b
                    L19:
                        java.util.Iterator r7 = r7.iterator()
                    L1d:
                        boolean r1 = r7.hasNext()
                        if (r1 == 0) goto L17
                        java.lang.Object r1 = r7.next()
                        androidx.compose.ui.tooling.data.Group r1 = (androidx.compose.ui.tooling.data.Group) r1
                        java.lang.String r4 = r1.getName()
                        java.lang.String r5 = "remember"
                        boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r5)
                        if (r4 == 0) goto L68
                        java.util.Collection r1 = r1.getData()
                        boolean r4 = r1 instanceof java.util.Collection
                        if (r4 == 0) goto L46
                        boolean r4 = r1.isEmpty()
                        if (r4 == 0) goto L46
                    L44:
                        r1 = 0
                        goto L64
                    L46:
                        java.util.Iterator r1 = r1.iterator()
                    L4a:
                        boolean r4 = r1.hasNext()
                        if (r4 == 0) goto L44
                        java.lang.Object r4 = r1.next()
                        if (r4 == 0) goto L5b
                        java.lang.reflect.Method r4 = androidx.compose.ui.tooling.ComposeViewAdapter.access$getDesignInfoMethodOrNull(r0, r4)
                        goto L5c
                    L5b:
                        r4 = 0
                    L5c:
                        if (r4 == 0) goto L60
                        r4 = 1
                        goto L61
                    L60:
                        r4 = 0
                    L61:
                        if (r4 == 0) goto L4a
                        r1 = 1
                    L64:
                        if (r1 == 0) goto L68
                        r1 = 1
                        goto L69
                    L68:
                        r1 = 0
                    L69:
                        if (r1 == 0) goto L1d
                    L6b:
                        java.lang.Boolean r7 = java.lang.Boolean.valueOf(r2)
                        return r7
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.tooling.ComposeViewAdapter$findDesignInfoProviders$1$1.invoke(androidx.compose.ui.tooling.data.Group):java.lang.Boolean");
                }
            });
            ArrayList arrayList3 = new ArrayList();
            for (Group group : findAll) {
                Iterator it3 = group.getChildren().iterator();
                while (true) {
                    str = null;
                    if (!it3.hasNext()) {
                        break;
                    }
                    Iterator it4 = ((Group) it3.next()).getData().iterator();
                    while (it4.hasNext()) {
                        Object next = it4.next();
                        if ((next != null ? getDesignInfoMethodOrNull(next) : null) != null) {
                            str = invokeGetDesignInfo(next, group.getBox().getLeft(), group.getBox().getTop());
                            break;
                        }
                    }
                }
                if (str != null) {
                    arrayList3.add(str);
                }
            }
            CollectionsKt.addAll(arrayList2, arrayList3);
        }
        this.designInfoList = arrayList2;
    }

    private final List<Group> findGroupsThatMatchPredicate(Group group, Function1<? super Group, Boolean> function1, boolean z) {
        ArrayList arrayList = new ArrayList();
        List mutableListOf = CollectionsKt.mutableListOf(new Group[]{group});
        while (!mutableListOf.isEmpty()) {
            Group group2 = (Group) CollectionsKt.removeLast(mutableListOf);
            if (((Boolean) function1.invoke(group2)).booleanValue()) {
                if (z) {
                    return CollectionsKt.listOf(group2);
                }
                arrayList.add(group2);
            }
            mutableListOf.addAll(group2.getChildren());
        }
        return arrayList;
    }

    static /* synthetic */ List findGroupsThatMatchPredicate$default(ComposeViewAdapter composeViewAdapter, Group group, Function1 function1, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return composeViewAdapter.findGroupsThatMatchPredicate(group, function1, z);
    }

    private final /* synthetic */ <T> List<T> findRememberCall(Collection<? extends Group> collection) {
        T t;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            Group firstOrNull = firstOrNull((Group) it.next(), new Function1<Group, Boolean>() { // from class: androidx.compose.ui.tooling.ComposeViewAdapter$findRememberCall$rememberCalls$1$1
                @NotNull
                public final Boolean invoke(@NotNull Group group) {
                    Intrinsics.checkNotNullParameter(group, "call");
                    return Boolean.valueOf(Intrinsics.areEqual(group.getName(), "remember"));
                }
            });
            if (firstOrNull != null) {
                arrayList.add(firstOrNull);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            Iterator<T> it3 = ((Group) it2.next()).getData().iterator();
            while (true) {
                if (!it3.hasNext()) {
                    t = null;
                    break;
                }
                t = it3.next();
                Intrinsics.reifiedOperationMarker(3, "T");
                if (t instanceof Object) {
                    break;
                }
            }
            Intrinsics.reifiedOperationMarker(2, "T");
            if (t != null) {
                arrayList2.add(t);
            }
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Group firstOrNull(Group group, Function1<? super Group, Boolean> function1) {
        return (Group) CollectionsKt.firstOrNull(findGroupsThatMatchPredicate(group, function1, true));
    }

    @VisibleForTesting
    public static /* synthetic */ void getClock$ui_tooling_release$annotations() {
    }

    private static /* synthetic */ void getContent$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Method getDesignInfoMethodOrNull(Object obj) {
        try {
            Class<?> cls = obj.getClass();
            Class<?> cls2 = Integer.TYPE;
            return cls.getDeclaredMethod("getDesignInfo", cls2, cls2, String.class);
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    private final String getFileName(Group group) {
        String sourceFile;
        SourceLocation location = group.getLocation();
        return (location == null || (sourceFile = location.getSourceFile()) == null) ? "" : sourceFile;
    }

    private final int getLineNumber(Group group) {
        SourceLocation location = group.getLocation();
        if (location != null) {
            return location.getLineNumber();
        }
        return -1;
    }

    private final boolean hasNullSourcePosition(Group group) {
        return (getFileName(group).length() == 0) && getLineNumber(group) == -1;
    }

    private final void init(AttributeSet attributeSet) {
        long j;
        ViewTreeLifecycleOwner.set(this, this.FakeSavedStateRegistryOwner);
        ViewTreeSavedStateRegistryOwner.set(this, this.FakeSavedStateRegistryOwner);
        ViewTreeViewModelStoreOwner.set(this, this.FakeViewModelStoreOwner);
        addView(this.composeView);
        String attributeValue = attributeSet.getAttributeValue("http://schemas.android.com/tools", "composableName");
        if (attributeValue == null) {
            return;
        }
        String substringBeforeLast$default = StringsKt.substringBeforeLast$default(attributeValue, '.', (String) null, 2, (Object) null);
        String substringAfterLast$default = StringsKt.substringAfterLast$default(attributeValue, '.', (String) null, 2, (Object) null);
        int attributeIntValue = attributeSet.getAttributeIntValue("http://schemas.android.com/tools", "parameterProviderIndex", 0);
        String attributeValue2 = attributeSet.getAttributeValue("http://schemas.android.com/tools", "parameterProviderClass");
        Class asPreviewProviderClass = attributeValue2 != null ? PreviewUtilsKt.asPreviewProviderClass(attributeValue2) : null;
        try {
            String attributeValue3 = attributeSet.getAttributeValue("http://schemas.android.com/tools", "animationClockStartTime");
            Intrinsics.checkNotNullExpressionValue(attributeValue3, "attrs.getAttributeValue(…animationClockStartTime\")");
            j = Long.parseLong(attributeValue3);
        } catch (Exception unused) {
            j = -1;
        }
        init$ui_tooling_release$default(this, substringBeforeLast$default, substringAfterLast$default, asPreviewProviderClass, attributeIntValue, attributeSet.getAttributeBooleanValue("http://schemas.android.com/tools", "paintBounds", this.debugPaintBounds), attributeSet.getAttributeBooleanValue("http://schemas.android.com/tools", "printViewInfos", this.debugViewInfos), j, attributeSet.getAttributeBooleanValue("http://schemas.android.com/tools", "forceCompositionInvalidation", false), attributeSet.getAttributeBooleanValue("http://schemas.android.com/tools", "findDesignInfoProviders", this.lookForDesignInfoProviders), attributeSet.getAttributeValue("http://schemas.android.com/tools", "designInfoProvidersArgument"), null, null, 3072, null);
    }

    public static /* synthetic */ void init$ui_tooling_release$default(ComposeViewAdapter composeViewAdapter, String str, String str2, Class cls, int i, boolean z, boolean z2, long j, boolean z3, boolean z4, String str3, Function0 function0, Function0 function02, int i2, Object obj) {
        composeViewAdapter.init$ui_tooling_release(str, str2, (i2 & 4) != 0 ? null : cls, (i2 & 8) != 0 ? 0 : i, (i2 & 16) != 0 ? false : z, (i2 & 32) != 0 ? false : z2, (i2 & 64) != 0 ? -1L : j, (i2 & 128) != 0 ? false : z3, (i2 & 256) != 0 ? false : z4, (i2 & 512) != 0 ? null : str3, (i2 & AccessibilityEventCompat.TYPE_TOUCH_EXPLORATION_GESTURE_END) != 0 ? init.1.INSTANCE : function0, (i2 & AccessibilityEventCompat.TYPE_WINDOW_CONTENT_CHANGED) != 0 ? init.2.INSTANCE : function02);
    }

    private final void invalidateComposition() {
        this.content.setValue(ComposableSingletons.ComposeViewAdapterKt.INSTANCE.getLambda-3$ui_tooling_release());
        this.content.setValue(this.previewComposition);
        invalidate();
    }

    private final String invokeGetDesignInfo(Object obj, int i, int i2) {
        Method designInfoMethodOrNull = getDesignInfoMethodOrNull(obj);
        if (designInfoMethodOrNull == null) {
            return null;
        }
        try {
            Object invoke = designInfoMethodOrNull.invoke(obj, Integer.valueOf(i), Integer.valueOf(i2), this.designInfoProvidersArgument);
            Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type kotlin.String");
            String str = (String) invoke;
            if (str.length() == 0) {
                return null;
            }
            return str;
        } catch (Exception unused) {
            return null;
        }
    }

    private final boolean isNullGroup(Group group) {
        return hasNullSourcePosition(group) && group.getChildren().isEmpty();
    }

    private final void processViewInfos() {
        Set<CompositionData> store = this.slotTableRecord.getStore();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(store, 10));
        Iterator<T> it = store.iterator();
        while (it.hasNext()) {
            arrayList.add(SlotTreeKt.asTree((CompositionData) it.next()));
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList2.add(toViewInfo((Group) it2.next()));
        }
        List<ViewInfo> list = CollectionsKt.toList(arrayList2);
        this.viewInfos = list;
        if (this.debugViewInfos) {
            Iterator<T> it3 = list.iterator();
            while (it3.hasNext()) {
                walkTable$default(this, (ViewInfo) it3.next(), 0, 2, null);
            }
        }
    }

    private final ViewInfo toViewInfo(Group group) {
        String str;
        if (group.getChildren().size() == 1 && hasNullSourcePosition(group)) {
            return toViewInfo((Group) CollectionsKt.single(group.getChildren()));
        }
        Collection children = group.getChildren();
        ArrayList arrayList = new ArrayList();
        for (Object obj : children) {
            if (!isNullGroup((Group) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(toViewInfo((Group) it.next()));
        }
        SourceLocation location = group.getLocation();
        if (location == null || (str = location.getSourceFile()) == null) {
            str = "";
        }
        String str2 = str;
        SourceLocation location2 = group.getLocation();
        return new ViewInfo(str2, location2 != null ? location2.getLineNumber() : -1, group.getBox(), group.getLocation(), arrayList2);
    }

    private final void walkTable(ViewInfo viewInfo, int i) {
        Log.d(this.TAG, StringsKt.repeat("|  ", i) + "|-" + viewInfo);
        Iterator<T> it = viewInfo.getChildren().iterator();
        while (it.hasNext()) {
            walkTable((ViewInfo) it.next(), i + 1);
        }
    }

    static /* synthetic */ void walkTable$default(ComposeViewAdapter composeViewAdapter, ViewInfo viewInfo, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        composeViewAdapter.walkTable(viewInfo, i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(@Nullable Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.forceCompositionInvalidation) {
            invalidateComposition();
        }
        this.onDraw.invoke();
        if (this.debugPaintBounds) {
            List<ViewInfo> list = this.viewInfos;
            ArrayList<ViewInfo> arrayList = new ArrayList();
            for (ViewInfo viewInfo : list) {
                CollectionsKt.addAll(arrayList, CollectionsKt.plus(CollectionsKt.listOf(viewInfo), viewInfo.allChildren()));
            }
            for (ViewInfo viewInfo2 : arrayList) {
                if (viewInfo2.hasBounds() && canvas != null) {
                    canvas.drawRect(new Rect(viewInfo2.getBounds().getLeft(), viewInfo2.getBounds().getTop(), viewInfo2.getBounds().getRight(), viewInfo2.getBounds().getBottom()), this.debugBoundsPaint);
                }
            }
        }
    }

    public final void dispose$ui_tooling_release() {
        this.composeView.disposeComposition();
        if (this.clock != null) {
            getClock$ui_tooling_release().dispose();
        }
        this.FakeSavedStateRegistryOwner.getLifecycleRegistry().setCurrentState(Lifecycle.State.DESTROYED);
        this.FakeViewModelStoreOwner.getViewModelStore().clear();
    }

    @NotNull
    public final PreviewAnimationClock getClock$ui_tooling_release() {
        PreviewAnimationClock previewAnimationClock = this.clock;
        if (previewAnimationClock != null) {
            return previewAnimationClock;
        }
        Intrinsics.throwUninitializedPropertyAccessException("clock");
        return null;
    }

    @NotNull
    public final List<String> getDesignInfoList$ui_tooling_release() {
        return this.designInfoList;
    }

    @NotNull
    public final List<ViewInfo> getViewInfos$ui_tooling_release() {
        return this.viewInfos;
    }

    public final boolean hasAnimations() {
        return this.hasAnimations;
    }

    @VisibleForTesting
    public final void init$ui_tooling_release(@NotNull String str, @NotNull String str2, @Nullable Class<? extends PreviewParameterProvider<?>> cls, int i, boolean z, boolean z2, long j, boolean z3, boolean z4, @Nullable String str3, @NotNull Function0<Unit> function0, @NotNull Function0<Unit> function02) {
        Intrinsics.checkNotNullParameter(str, "className");
        Intrinsics.checkNotNullParameter(str2, "methodName");
        Intrinsics.checkNotNullParameter(function0, "onCommit");
        Intrinsics.checkNotNullParameter(function02, "onDraw");
        this.debugPaintBounds = z;
        this.debugViewInfos = z2;
        this.composableName = str2;
        this.forceCompositionInvalidation = z3;
        this.lookForDesignInfoProviders = z4;
        this.designInfoProvidersArgument = str3 == null ? "" : str3;
        this.onDraw = function02;
        ComposableLambda composableLambdaInstance = ComposableLambdaKt.composableLambdaInstance(-1704541905, true, new init.3(function0, this, j, str, str2, cls, i));
        this.previewComposition = composableLambdaInstance;
        this.composeView.setContent(composableLambdaInstance);
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        ViewTreeLifecycleOwner.set(this.composeView.getRootView(), this.FakeSavedStateRegistryOwner);
        super.onAttachedToWindow();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.delayedException.throwIfPresent();
        processViewInfos();
        if (this.composableName.length() > 0) {
            findAndTrackAnimations();
            if (this.lookForDesignInfoProviders) {
                findDesignInfoProviders();
            }
        }
    }

    public final void setClock$ui_tooling_release(@NotNull PreviewAnimationClock previewAnimationClock) {
        Intrinsics.checkNotNullParameter(previewAnimationClock, "<set-?>");
        this.clock = previewAnimationClock;
    }

    public final void setDesignInfoList$ui_tooling_release(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.designInfoList = list;
    }

    public final void setViewInfos$ui_tooling_release(@NotNull List<ViewInfo> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.viewInfos = list;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r8v13, types: [androidx.compose.ui.tooling.ComposeViewAdapter$FakeActivityResultRegistryOwner$1] */
    public ComposeViewAdapter(@NotNull Context context, @NotNull AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        MutableState<Function2<Composer, Integer, Unit>> mutableStateOf$default;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
        this.TAG = "ComposeViewAdapter";
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        this.composeView = new ComposeView(context2, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        this.viewInfos = CollectionsKt.emptyList();
        this.designInfoList = CollectionsKt.emptyList();
        this.slotTableRecord = CompositionDataRecord.Companion.create();
        this.composableName = "";
        this.delayedException = new ThreadSafeException();
        this.previewComposition = ComposableSingletons.ComposeViewAdapterKt.INSTANCE.getLambda-2$ui_tooling_release();
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(ComposeViewAdapterKt.access$getEmptyContent$p(), null, 2, null);
        this.content = mutableStateOf$default;
        this.designInfoProvidersArgument = "";
        this.onDraw = onDraw.1.INSTANCE;
        Paint paint = new Paint();
        paint.setPathEffect(new DashPathEffect(new float[]{5.0f, 10.0f, 15.0f, 20.0f}, 0.0f));
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(ColorKt.toArgb-8_81llA(Color.Companion.m1082getRed0d7_KjU()));
        this.debugBoundsPaint = paint;
        this.FakeSavedStateRegistryOwner = new FakeSavedStateRegistryOwner.1();
        this.FakeViewModelStoreOwner = new FakeViewModelStoreOwner.1();
        this.FakeOnBackPressedDispatcherOwner = new FakeOnBackPressedDispatcherOwner.1(this);
        this.FakeActivityResultRegistryOwner = new ActivityResultRegistryOwner() { // from class: androidx.compose.ui.tooling.ComposeViewAdapter$FakeActivityResultRegistryOwner$1

            @NotNull
            private final ComposeViewAdapter$FakeActivityResultRegistryOwner$1$activityResultRegistry$1 activityResultRegistry = new ActivityResultRegistry() { // from class: androidx.compose.ui.tooling.ComposeViewAdapter$FakeActivityResultRegistryOwner$1$activityResultRegistry$1
                public <I, O> void onLaunch(int i2, @NotNull ActivityResultContract<I, O> activityResultContract, I i22, @Nullable ActivityOptionsCompat activityOptionsCompat) {
                    Intrinsics.checkNotNullParameter(activityResultContract, "contract");
                    throw new IllegalStateException("Calling launch() is not supported in Preview");
                }
            };

            @Override // androidx.activity.result.ActivityResultRegistryOwner
            @NotNull
            public ActivityResultRegistry getActivityResultRegistry() {
                return this.activityResultRegistry;
            }
        };
        init(attributeSet);
    }
}
