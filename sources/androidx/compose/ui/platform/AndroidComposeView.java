package androidx.compose.ui.platform;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Trace;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStructure;
import android.view.ViewTreeObserver;
import android.view.animation.AnimationUtils;
import android.view.autofill.AutofillValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.annotation.VisibleForTesting;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.autofill.AndroidAutofill;
import androidx.compose.ui.autofill.AndroidAutofill_androidKt;
import androidx.compose.ui.autofill.Autofill;
import androidx.compose.ui.autofill.AutofillCallback;
import androidx.compose.ui.autofill.AutofillTree;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusOwner;
import androidx.compose.ui.focus.FocusOwnerImpl;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.PlatformHapticFeedback;
import androidx.compose.ui.input.InputMode;
import androidx.compose.ui.input.InputMode$Companion;
import androidx.compose.ui.input.InputModeManager;
import androidx.compose.ui.input.InputModeManagerImpl;
import androidx.compose.ui.input.ScrollContainerInfo;
import androidx.compose.ui.input.ScrollContainerInfoKt;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.input.pointer.MotionEventAdapter;
import androidx.compose.ui.input.pointer.PointerIcon;
import androidx.compose.ui.input.pointer.PointerIconService;
import androidx.compose.ui.input.pointer.PointerInputEvent;
import androidx.compose.ui.input.pointer.PointerInputEventData;
import androidx.compose.ui.input.pointer.PointerInputEventProcessor;
import androidx.compose.ui.input.pointer.PointerInputEventProcessorKt;
import androidx.compose.ui.input.pointer.PointerKeyboardModifiers;
import androidx.compose.ui.input.pointer.PositionCalculator;
import androidx.compose.ui.input.pointer.ProcessResult;
import androidx.compose.ui.input.rotary.RotaryInputModifierKt;
import androidx.compose.ui.input.rotary.RotaryScrollEvent;
import androidx.compose.ui.layout.RootMeasurePolicy;
import androidx.compose.ui.modifier.ModifierLocalManager;
import androidx.compose.ui.modifier.ModifierLocalProvider;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.compose.ui.node.MeasureAndLayoutDelegate;
import androidx.compose.ui.node.OwnedLayer;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.node.OwnerSnapshotObserver;
import androidx.compose.ui.node.RootForTest;
import androidx.compose.ui.platform.ViewLayer;
import androidx.compose.ui.semantics.SemanticsModifierCore;
import androidx.compose.ui.semantics.SemanticsOwner;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontFamilyResolver_androidKt;
import androidx.compose.ui.text.input.TextInputService;
import androidx.compose.ui.text.input.TextInputServiceAndroid;
import androidx.compose.ui.unit.AndroidDensity_androidKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.viewinterop.AndroidViewHolder;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import kotlin.Deprecated;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.mt2;
import tb.nt2;
import tb.ql3;
import tb.u7;
import tb.v7;
import tb.w7;
import tb.wv0;
import tb.x7;

/* compiled from: Taobao */
@SuppressLint({"ViewConstructor", "VisibleForTests"})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class AndroidComposeView extends ViewGroup implements PositionCalculator, Owner, ViewRootForTest, DefaultLifecycleObserver {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final String FocusTag = "Compose Focus";
    private static final int MaximumLayerCacheSize = 10;

    @Nullable
    private static Method getBooleanMethod;

    @Nullable
    private static Class<?> systemPropertiesClass;

    @Nullable
    private AndroidViewsHandler _androidViewsHandler;

    @Nullable
    private final AndroidAutofill _autofill;

    @NotNull
    private final InputModeManagerImpl _inputModeManager;

    @NotNull
    private final WindowInfoImpl _windowInfo;

    @NotNull
    private final AndroidComposeViewAccessibilityDelegateCompat accessibilityDelegate;

    @NotNull
    private final AndroidAccessibilityManager accessibilityManager;

    @NotNull
    private final AutofillTree autofillTree;

    @NotNull
    private final CanvasHolder canvasHolder;

    @NotNull
    private final AndroidClipboardManager clipboardManager;

    @NotNull
    private Function1<? super Configuration, Unit> configurationChangeObserver;
    private int currentFontWeightAdjustment;

    @NotNull
    private Density density;

    @Nullable
    private PointerIcon desiredPointerIcon;

    @NotNull
    private final List<OwnedLayer> dirtyLayers;

    @NotNull
    private final MutableVector<Function0<Unit>> endApplyChangesListeners;

    @NotNull
    private final FocusOwner focusOwner;

    @NotNull
    private final MutableState fontFamilyResolver$delegate;

    @NotNull
    private final Font.ResourceLoader fontLoader;
    private boolean forceUseMatrixCache;

    @NotNull
    private final ViewTreeObserver.OnGlobalLayoutListener globalLayoutListener;
    private long globalPosition;

    @NotNull
    private final HapticFeedback hapticFeedBack;
    private boolean hoverExitReceived;
    private boolean isDrawingContent;
    private boolean isRenderNodeCompatible;

    @NotNull
    private final Modifier keyInputModifier;
    private boolean keyboardModifiersRequireUpdate;
    private long lastDownPointerPosition;
    private long lastMatrixRecalculationAnimationTime;

    @NotNull
    private final WeakCache<OwnedLayer> layerCache;

    @NotNull
    private final MutableState layoutDirection$delegate;

    @NotNull
    private final CalculateMatrixToWindow matrixToWindow;

    @NotNull
    private final MeasureAndLayoutDelegate measureAndLayoutDelegate;

    @NotNull
    private final ModifierLocalManager modifierLocalManager;

    @NotNull
    private final MotionEventAdapter motionEventAdapter;
    private boolean observationClearRequested;

    @Nullable
    private Constraints onMeasureConstraints;

    @Nullable
    private Function1<? super ViewTreeOwners, Unit> onViewTreeOwnersAvailable;

    @NotNull
    private final PointerIconService pointerIconService;

    @NotNull
    private final PointerInputEventProcessor pointerInputEventProcessor;

    @Nullable
    private List<OwnedLayer> postponedDirtyLayers;

    @Nullable
    private MotionEvent previousMotionEvent;
    private long relayoutTime;

    @NotNull
    private final Function0<Unit> resendMotionEventOnLayout;

    @NotNull
    private final resendMotionEventRunnable.1 resendMotionEventRunnable;

    @NotNull
    private final LayoutNode root;

    @NotNull
    private final RootForTest rootForTest;

    @NotNull
    private final Modifier rotaryInputModifier;

    @NotNull
    private final ViewTreeObserver.OnScrollChangedListener scrollChangedListener;

    @NotNull
    private final AndroidComposeView$scrollContainerInfo$1 scrollContainerInfo;

    @NotNull
    private final SemanticsModifierCore semanticsModifier;

    @NotNull
    private final SemanticsOwner semanticsOwner;

    @NotNull
    private final Runnable sendHoverExitEvent;

    @NotNull
    private final LayoutNodeDrawScope sharedDrawScope;
    private boolean showLayoutBounds;

    @NotNull
    private final OwnerSnapshotObserver snapshotObserver;
    private boolean superclassInitComplete;

    @NotNull
    private final TextInputService textInputService;

    @NotNull
    private final TextInputServiceAndroid textInputServiceAndroid;

    @NotNull
    private final TextToolbar textToolbar;

    @NotNull
    private final int[] tmpPositionArray;

    @NotNull
    private final ViewTreeObserver.OnTouchModeChangeListener touchModeChangeListener;

    @NotNull
    private final ViewConfiguration viewConfiguration;

    @Nullable
    private DrawChildContainer viewLayersContainer;

    @NotNull
    private final float[] viewToWindowMatrix;

    @NotNull
    private final MutableState viewTreeOwners$delegate;
    private boolean wasMeasuredWithMultipleConstraints;
    private long windowPosition;

    @NotNull
    private final float[] windowToViewMatrix;

    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @SuppressLint({"PrivateApi", "BanUncheckedReflection"})
        public final boolean getIsShowingLayoutBounds() {
            try {
                if (AndroidComposeView.systemPropertiesClass == null) {
                    AndroidComposeView.systemPropertiesClass = Class.forName("android.os.SystemProperties");
                    Class cls = AndroidComposeView.systemPropertiesClass;
                    AndroidComposeView.getBooleanMethod = cls != null ? cls.getDeclaredMethod("getBoolean", String.class, Boolean.TYPE) : null;
                }
                Method method = AndroidComposeView.getBooleanMethod;
                Object invoke = method != null ? method.invoke(null, "debug.layout", Boolean.FALSE) : null;
                Boolean bool = invoke instanceof Boolean ? (Boolean) invoke : null;
                if (bool != null) {
                    return bool.booleanValue();
                }
                return false;
            } catch (Exception unused) {
                return false;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r7v1, types: [androidx.compose.ui.Modifier, androidx.compose.ui.platform.AndroidComposeView$scrollContainerInfo$1] */
    public AndroidComposeView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Offset.Companion companion = Offset.Companion;
        this.lastDownPointerPosition = companion.getUnspecified-F1C5BW0();
        this.superclassInitComplete = true;
        CanvasDrawScope canvasDrawScope = null;
        this.sharedDrawScope = new LayoutNodeDrawScope(canvasDrawScope, 1, canvasDrawScope);
        this.density = AndroidDensity_androidKt.Density(context);
        SemanticsModifierCore semanticsModifierCore = new SemanticsModifierCore(false, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.ui.platform.AndroidComposeView$semanticsModifier$1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((SemanticsPropertyReceiver) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
                Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$$receiver");
            }
        }, (Function1) null, 8, (DefaultConstructorMarker) null);
        this.semanticsModifier = semanticsModifierCore;
        this.focusOwner = new FocusOwnerImpl(new focusOwner.1(this));
        this._windowInfo = new WindowInfoImpl();
        Modifier.Companion companion2 = Modifier.Companion;
        Modifier onKeyEvent = KeyInputModifierKt.onKeyEvent(companion2, new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$keyInputModifier$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return m1719invokeZmokQxo(((KeyEvent) obj).unbox-impl());
            }

            @NotNull
            /* renamed from: invoke-ZmokQxo, reason: not valid java name */
            public final Boolean m1719invokeZmokQxo(@NotNull android.view.KeyEvent keyEvent) {
                Intrinsics.checkNotNullParameter(keyEvent, "it");
                FocusDirection m1713getFocusDirectionP8AzH3I = AndroidComposeView.this.m1713getFocusDirectionP8AzH3I(keyEvent);
                return (m1713getFocusDirectionP8AzH3I == null || !KeyEventType.equals-impl0(KeyEvent_androidKt.getType-ZmokQxo(keyEvent), KeyEventType.Companion.m1387getKeyDownCS__XNY())) ? Boolean.FALSE : Boolean.valueOf(AndroidComposeView.this.getFocusOwner().moveFocus-3ESFkO8(m1713getFocusDirectionP8AzH3I.unbox-impl()));
            }
        });
        this.keyInputModifier = onKeyEvent;
        Modifier onRotaryScrollEvent = RotaryInputModifierKt.onRotaryScrollEvent(companion2, rotaryInputModifier.1.INSTANCE);
        this.rotaryInputModifier = onRotaryScrollEvent;
        ?? r7 = new ModifierLocalProvider<ScrollContainerInfo>(this) { // from class: androidx.compose.ui.platform.AndroidComposeView$scrollContainerInfo$1

            @NotNull
            private final ProvidableModifierLocal<ScrollContainerInfo> key = ScrollContainerInfoKt.getModifierLocalScrollContainerInfo();

            @NotNull
            private final AndroidComposeView$scrollContainerInfo$1$value$1 value;

            /* JADX WARN: Type inference failed for: r0v1, types: [androidx.compose.ui.platform.AndroidComposeView$scrollContainerInfo$1$value$1] */
            {
                this.value = new ScrollContainerInfo() { // from class: androidx.compose.ui.platform.AndroidComposeView$scrollContainerInfo$1$value$1
                    private final boolean isInScrollableViewGroup(View view) {
                        ViewParent parent = view.getParent();
                        while (parent != null && (parent instanceof ViewGroup)) {
                            ViewGroup viewGroup = (ViewGroup) parent;
                            if (viewGroup.shouldDelayChildPressedState()) {
                                return true;
                            }
                            parent = viewGroup.getParent();
                        }
                        return false;
                    }

                    public boolean canScrollHorizontally() {
                        return isInScrollableViewGroup(AndroidComposeView.this.getView());
                    }

                    public boolean canScrollVertically() {
                        return isInScrollableViewGroup(AndroidComposeView.this.getView());
                    }
                };
            }

            @Override // androidx.compose.ui.Modifier$Element
            public /* synthetic */ boolean all(Function1 function1) {
                return nt2.a(this, function1);
            }

            @Override // androidx.compose.ui.Modifier$Element
            public /* synthetic */ boolean any(Function1 function1) {
                return nt2.b(this, function1);
            }

            @Override // androidx.compose.ui.Modifier$Element
            public /* synthetic */ Object foldIn(Object obj, Function2 function2) {
                return nt2.c(this, obj, function2);
            }

            @Override // androidx.compose.ui.Modifier$Element
            public /* synthetic */ Object foldOut(Object obj, Function2 function2) {
                return nt2.d(this, obj, function2);
            }

            @Override // androidx.compose.ui.modifier.ModifierLocalProvider
            @NotNull
            public ProvidableModifierLocal<ScrollContainerInfo> getKey() {
                return this.key;
            }

            public /* synthetic */ Modifier then(Modifier modifier) {
                return mt2.a(this, modifier);
            }

            @Override // androidx.compose.ui.modifier.ModifierLocalProvider
            @NotNull
            /* renamed from: getValue, reason: merged with bridge method [inline-methods] */
            public ScrollContainerInfo getValue2() {
                return this.value;
            }
        };
        this.scrollContainerInfo = r7;
        this.canvasHolder = new CanvasHolder();
        LayoutNode layoutNode = new LayoutNode(false, 0, 3, (DefaultConstructorMarker) null);
        layoutNode.setMeasurePolicy(RootMeasurePolicy.INSTANCE);
        layoutNode.setDensity(getDensity());
        layoutNode.setModifier(companion2.then(semanticsModifierCore).then(onRotaryScrollEvent).then(getFocusOwner().getModifier()).then(onKeyEvent).then((Modifier) r7));
        this.root = layoutNode;
        this.rootForTest = this;
        this.semanticsOwner = new SemanticsOwner(getRoot());
        AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat = new AndroidComposeViewAccessibilityDelegateCompat(this);
        this.accessibilityDelegate = androidComposeViewAccessibilityDelegateCompat;
        this.autofillTree = new AutofillTree();
        this.dirtyLayers = new ArrayList();
        this.motionEventAdapter = new MotionEventAdapter();
        this.pointerInputEventProcessor = new PointerInputEventProcessor(getRoot());
        this.configurationChangeObserver = configurationChangeObserver.1.INSTANCE;
        this._autofill = autofillSupported() ? new AndroidAutofill(this, getAutofillTree()) : null;
        this.clipboardManager = new AndroidClipboardManager(context);
        this.accessibilityManager = new AndroidAccessibilityManager(context);
        this.snapshotObserver = new OwnerSnapshotObserver(new Function1<Function0<? extends Unit>, Unit>() { // from class: androidx.compose.ui.platform.AndroidComposeView$snapshotObserver$1
            {
                super(1);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void invoke$lambda$0(Function0 function0) {
                Intrinsics.checkNotNullParameter(function0, "$tmp0");
                function0.invoke();
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Function0<Unit>) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull Function0<Unit> function0) {
                Intrinsics.checkNotNullParameter(function0, "command");
                Handler handler = AndroidComposeView.this.getHandler();
                if ((handler != null ? handler.getLooper() : null) == Looper.myLooper()) {
                    function0.invoke();
                    return;
                }
                Handler handler2 = AndroidComposeView.this.getHandler();
                if (handler2 != null) {
                    handler2.post(new a(function0));
                }
            }
        });
        this.measureAndLayoutDelegate = new MeasureAndLayoutDelegate(getRoot());
        android.view.ViewConfiguration viewConfiguration = android.view.ViewConfiguration.get(context);
        Intrinsics.checkNotNullExpressionValue(viewConfiguration, "get(context)");
        this.viewConfiguration = new AndroidViewConfiguration(viewConfiguration);
        this.globalPosition = IntOffsetKt.IntOffset(Integer.MAX_VALUE, Integer.MAX_VALUE);
        this.tmpPositionArray = new int[]{0, 0};
        this.viewToWindowMatrix = Matrix.m1153constructorimpl$default(null, 1, null);
        this.windowToViewMatrix = Matrix.m1153constructorimpl$default(null, 1, null);
        this.lastMatrixRecalculationAnimationTime = -1L;
        this.windowPosition = companion.getInfinite-F1C5BW0();
        this.isRenderNodeCompatible = true;
        this.viewTreeOwners$delegate = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.globalLayoutListener = new u7(this);
        this.scrollChangedListener = new v7(this);
        this.touchModeChangeListener = new w7(this);
        TextInputServiceAndroid textInputServiceAndroid = new TextInputServiceAndroid(this);
        this.textInputServiceAndroid = textInputServiceAndroid;
        this.textInputService = (TextInputService) AndroidComposeView_androidKt.getTextInputServiceFactory().invoke(textInputServiceAndroid);
        this.fontLoader = new AndroidFontResourceLoader(context);
        this.fontFamilyResolver$delegate = SnapshotStateKt.mutableStateOf(FontFamilyResolver_androidKt.createFontFamilyResolver(context), SnapshotStateKt.referentialEqualityPolicy());
        Configuration configuration = context.getResources().getConfiguration();
        Intrinsics.checkNotNullExpressionValue(configuration, "context.resources.configuration");
        this.currentFontWeightAdjustment = getFontWeightAdjustmentCompat(configuration);
        Configuration configuration2 = context.getResources().getConfiguration();
        Intrinsics.checkNotNullExpressionValue(configuration2, "context.resources.configuration");
        this.layoutDirection$delegate = SnapshotStateKt.mutableStateOf$default(AndroidComposeView_androidKt.getLocaleLayoutDirection(configuration2), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.hapticFeedBack = new PlatformHapticFeedback(this);
        this._inputModeManager = new InputModeManagerImpl(isInTouchMode() ? InputMode.Companion.m1376getTouchaOaMEAU() : InputMode.Companion.m1375getKeyboardaOaMEAU(), new Function1<InputMode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$_inputModeManager$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return m1718invokeiuPiT84(((InputMode) obj).unbox-impl());
            }

            @NotNull
            /* renamed from: invoke-iuPiT84, reason: not valid java name */
            public final Boolean m1718invokeiuPiT84(int i) {
                InputMode$Companion inputMode$Companion = InputMode.Companion;
                return Boolean.valueOf(InputMode.equals-impl0(i, inputMode$Companion.m1376getTouchaOaMEAU()) ? AndroidComposeView.this.isInTouchMode() : InputMode.equals-impl0(i, inputMode$Companion.m1375getKeyboardaOaMEAU()) ? AndroidComposeView.this.isInTouchMode() ? AndroidComposeView.this.requestFocusFromTouch() : true : false);
            }
        }, (DefaultConstructorMarker) null);
        this.modifierLocalManager = new ModifierLocalManager(this);
        this.textToolbar = new AndroidTextToolbar(this);
        this.layerCache = new WeakCache<>();
        this.endApplyChangesListeners = new MutableVector<>(new Function0[16], 0);
        this.resendMotionEventRunnable = new resendMotionEventRunnable.1(this);
        this.sendHoverExitEvent = new x7(this);
        this.resendMotionEventOnLayout = new resendMotionEventOnLayout.1(this);
        int i = Build.VERSION.SDK_INT;
        this.matrixToWindow = i >= 29 ? new CalculateMatrixToWindowApi29() : new CalculateMatrixToWindowApi21();
        setWillNotDraw(false);
        setFocusable(true);
        if (i >= 26) {
            AndroidComposeViewVerificationHelperMethodsO.INSTANCE.focusable(this, 1, false);
        }
        setFocusableInTouchMode(true);
        setClipChildren(false);
        ViewCompat.setAccessibilityDelegate(this, androidComposeViewAccessibilityDelegateCompat);
        Function1<ViewRootForTest, Unit> onViewCreatedCallback = ViewRootForTest.Companion.getOnViewCreatedCallback();
        if (onViewCreatedCallback != null) {
            onViewCreatedCallback.invoke(this);
        }
        getRoot().attach$ui_release(this);
        if (i >= 29) {
            AndroidComposeViewForceDarkModeQ.INSTANCE.disallowForceDark(this);
        }
        this.pointerIconService = new PointerIconService() { // from class: androidx.compose.ui.platform.AndroidComposeView$pointerIconService$1
            @NotNull
            public PointerIcon getCurrent() {
                PointerIcon pointerIcon;
                pointerIcon = AndroidComposeView.this.desiredPointerIcon;
                return pointerIcon == null ? PointerIcon.Companion.getDefault() : pointerIcon;
            }

            public void setCurrent(@NotNull PointerIcon pointerIcon) {
                Intrinsics.checkNotNullParameter(pointerIcon, "value");
                AndroidComposeView.this.desiredPointerIcon = pointerIcon;
            }
        };
    }

    private final boolean autofillSupported() {
        return Build.VERSION.SDK_INT >= 26;
    }

    private final void clearChildInvalidObservations(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof AndroidComposeView) {
                ((AndroidComposeView) childAt).onEndApplyChanges();
            } else if (childAt instanceof ViewGroup) {
                clearChildInvalidObservations((ViewGroup) childAt);
            }
        }
    }

    private final Pair<Integer, Integer> convertMeasureSpec(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == Integer.MIN_VALUE) {
            return TuplesKt.to(0, Integer.valueOf(size));
        }
        if (mode == 0) {
            return TuplesKt.to(0, Integer.MAX_VALUE);
        }
        if (mode == 1073741824) {
            return TuplesKt.to(Integer.valueOf(size), Integer.valueOf(size));
        }
        throw new IllegalStateException();
    }

    private final View findViewByAccessibilityIdRootedAtCurrentView(int i, View view) {
        if (Build.VERSION.SDK_INT >= 29) {
            return null;
        }
        Method declaredMethod = View.class.getDeclaredMethod("getAccessibilityViewId", new Class[0]);
        declaredMethod.setAccessible(true);
        if (Intrinsics.areEqual(declaredMethod.invoke(view, new Object[0]), Integer.valueOf(i))) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            Intrinsics.checkNotNullExpressionValue(childAt, "currentView.getChildAt(i)");
            View findViewByAccessibilityIdRootedAtCurrentView = findViewByAccessibilityIdRootedAtCurrentView(i, childAt);
            if (findViewByAccessibilityIdRootedAtCurrentView != null) {
                return findViewByAccessibilityIdRootedAtCurrentView;
            }
        }
        return null;
    }

    @Deprecated(message = "fontLoader is deprecated, use fontFamilyResolver", replaceWith = @ReplaceWith(expression = "fontFamilyResolver", imports = {}))
    public static /* synthetic */ void getFontLoader$annotations() {
    }

    private final int getFontWeightAdjustmentCompat(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 31) {
            return configuration.fontWeightAdjustment;
        }
        return 0;
    }

    @VisibleForTesting
    public static /* synthetic */ void getLastMatrixRecalculationAnimationTime$ui_release$annotations() {
    }

    public static /* synthetic */ void getShowLayoutBounds$annotations() {
    }

    public static /* synthetic */ void getTextInputService$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void globalLayoutListener$lambda$1(AndroidComposeView androidComposeView) {
        Intrinsics.checkNotNullParameter(androidComposeView, "this$0");
        androidComposeView.updatePositionCacheAndDispatch();
    }

    /* renamed from: handleMotionEvent-8iAsVTc, reason: not valid java name */
    private final int m1709handleMotionEvent8iAsVTc(MotionEvent motionEvent) {
        removeCallbacks(this.resendMotionEventRunnable);
        try {
            recalculateWindowPosition(motionEvent);
            boolean z = true;
            this.forceUseMatrixCache = true;
            measureAndLayout(false);
            this.desiredPointerIcon = null;
            Trace.beginSection("AndroidOwner:onTouch");
            try {
                int actionMasked = motionEvent.getActionMasked();
                MotionEvent motionEvent2 = this.previousMotionEvent;
                boolean z2 = motionEvent2 != null && motionEvent2.getToolType(0) == 3;
                if (motionEvent2 != null && hasChangedDevices(motionEvent, motionEvent2)) {
                    if (isDevicePressEvent(motionEvent2)) {
                        this.pointerInputEventProcessor.processCancel();
                    } else if (motionEvent2.getActionMasked() != 10 && z2) {
                        sendSimulatedEvent$default(this, motionEvent2, 10, motionEvent2.getEventTime(), false, 8, null);
                    }
                }
                if (motionEvent.getToolType(0) != 3) {
                    z = false;
                }
                if (!z2 && z && actionMasked != 3 && actionMasked != 9 && isInBounds(motionEvent)) {
                    sendSimulatedEvent$default(this, motionEvent, 9, motionEvent.getEventTime(), false, 8, null);
                }
                if (motionEvent2 != null) {
                    motionEvent2.recycle();
                }
                this.previousMotionEvent = MotionEvent.obtainNoHistory(motionEvent);
                int m1710sendMotionEvent8iAsVTc = m1710sendMotionEvent8iAsVTc(motionEvent);
                Trace.endSection();
                if (Build.VERSION.SDK_INT >= 24) {
                    AndroidComposeViewVerificationHelperMethodsN.INSTANCE.setPointerIcon(this, this.desiredPointerIcon);
                }
                return m1710sendMotionEvent8iAsVTc;
            } catch (Throwable th) {
                Trace.endSection();
                throw th;
            }
        } finally {
            this.forceUseMatrixCache = false;
        }
    }

    private final boolean handleRotaryEvent(MotionEvent motionEvent) {
        android.view.ViewConfiguration viewConfiguration = android.view.ViewConfiguration.get(getContext());
        float f = -motionEvent.getAxisValue(26);
        return getFocusOwner().dispatchRotaryEvent(new RotaryScrollEvent(ViewConfigurationCompat.getScaledVerticalScrollFactor(viewConfiguration, getContext()) * f, f * ViewConfigurationCompat.getScaledHorizontalScrollFactor(viewConfiguration, getContext()), motionEvent.getEventTime()));
    }

    private final boolean hasChangedDevices(MotionEvent motionEvent, MotionEvent motionEvent2) {
        return (motionEvent2.getSource() == motionEvent.getSource() && motionEvent2.getToolType(0) == motionEvent.getToolType(0)) ? false : true;
    }

    private final void invalidateLayers(LayoutNode layoutNode) {
        layoutNode.invalidateLayers$ui_release();
        MutableVector mutableVector = layoutNode.get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            int i = 0;
            Object[] content = mutableVector.getContent();
            do {
                invalidateLayers((LayoutNode) content[i]);
                i++;
            } while (i < size);
        }
    }

    private final void invalidateLayoutNodeMeasurement(LayoutNode layoutNode) {
        int i = 0;
        MeasureAndLayoutDelegate.requestRemeasure$default(this.measureAndLayoutDelegate, layoutNode, false, 2, null);
        MutableVector mutableVector = layoutNode.get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            Object[] content = mutableVector.getContent();
            do {
                invalidateLayoutNodeMeasurement((LayoutNode) content[i]);
                i++;
            } while (i < size);
        }
    }

    private final boolean isBadMotionEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        if (!((Float.isInfinite(x) || Float.isNaN(x)) ? false : true)) {
            return true;
        }
        float y = motionEvent.getY();
        if (!((Float.isInfinite(y) || Float.isNaN(y)) ? false : true)) {
            return true;
        }
        float rawX = motionEvent.getRawX();
        if (!((Float.isInfinite(rawX) || Float.isNaN(rawX)) ? false : true)) {
            return true;
        }
        float rawY = motionEvent.getRawY();
        return !(!Float.isInfinite(rawY) && !Float.isNaN(rawY));
    }

    private final boolean isDevicePressEvent(MotionEvent motionEvent) {
        int actionMasked;
        return motionEvent.getButtonState() != 0 || (actionMasked = motionEvent.getActionMasked()) == 0 || actionMasked == 2 || actionMasked == 6;
    }

    private final boolean isInBounds(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (0.0f <= x && x <= ((float) getWidth())) {
            if (0.0f <= y && y <= ((float) getHeight())) {
                return true;
            }
        }
        return false;
    }

    private final boolean isPositionChanged(MotionEvent motionEvent) {
        MotionEvent motionEvent2;
        if (motionEvent.getPointerCount() != 1 || (motionEvent2 = this.previousMotionEvent) == null) {
            return true;
        }
        if (motionEvent.getRawX() == motionEvent2.getRawX()) {
            return !((motionEvent.getRawY() > motionEvent2.getRawY() ? 1 : (motionEvent.getRawY() == motionEvent2.getRawY() ? 0 : -1)) == 0);
        }
        return true;
    }

    private final void recalculateWindowPosition() {
        if (this.forceUseMatrixCache) {
            return;
        }
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        if (currentAnimationTimeMillis != this.lastMatrixRecalculationAnimationTime) {
            this.lastMatrixRecalculationAnimationTime = currentAnimationTimeMillis;
            recalculateWindowViewTransforms();
            ViewParent parent = getParent();
            View view = this;
            while (parent instanceof ViewGroup) {
                view = (View) parent;
                parent = ((ViewGroup) view).getParent();
            }
            view.getLocationOnScreen(this.tmpPositionArray);
            int[] iArr = this.tmpPositionArray;
            float f = iArr[0];
            float f2 = iArr[1];
            view.getLocationInWindow(iArr);
            int[] iArr2 = this.tmpPositionArray;
            this.windowPosition = OffsetKt.Offset(f - iArr2[0], f2 - iArr2[1]);
        }
    }

    private final void recalculateWindowViewTransforms() {
        this.matrixToWindow.mo1730calculateMatrixToWindowEL8BTi8(this, this.viewToWindowMatrix);
        InvertMatrixKt.m1761invertToJiSxe2E(this.viewToWindowMatrix, this.windowToViewMatrix);
    }

    private final void scheduleMeasureAndLayout(LayoutNode layoutNode) {
        if (isLayoutRequested() || !isAttachedToWindow()) {
            return;
        }
        if (this.wasMeasuredWithMultipleConstraints && layoutNode != null) {
            while (layoutNode != null && layoutNode.getMeasuredByParent$ui_release() == LayoutNode.UsageByParent.InMeasureBlock) {
                layoutNode = layoutNode.getParent$ui_release();
            }
            if (layoutNode == getRoot()) {
                requestLayout();
                return;
            }
        }
        if (getWidth() == 0 || getHeight() == 0) {
            requestLayout();
        } else {
            invalidate();
        }
    }

    static /* synthetic */ void scheduleMeasureAndLayout$default(AndroidComposeView androidComposeView, LayoutNode layoutNode, int i, Object obj) {
        if ((i & 1) != 0) {
            layoutNode = null;
        }
        androidComposeView.scheduleMeasureAndLayout(layoutNode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void scrollChangedListener$lambda$2(AndroidComposeView androidComposeView) {
        Intrinsics.checkNotNullParameter(androidComposeView, "this$0");
        androidComposeView.updatePositionCacheAndDispatch();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendHoverExitEvent$lambda$5(AndroidComposeView androidComposeView) {
        Intrinsics.checkNotNullParameter(androidComposeView, "this$0");
        androidComposeView.hoverExitReceived = false;
        MotionEvent motionEvent = androidComposeView.previousMotionEvent;
        Intrinsics.checkNotNull(motionEvent);
        if (!(motionEvent.getActionMasked() == 10)) {
            throw new IllegalStateException("The ACTION_HOVER_EXIT event was not cleared.".toString());
        }
        androidComposeView.m1710sendMotionEvent8iAsVTc(motionEvent);
    }

    /* renamed from: sendMotionEvent-8iAsVTc, reason: not valid java name */
    private final int m1710sendMotionEvent8iAsVTc(MotionEvent motionEvent) {
        Object obj;
        if (this.keyboardModifiersRequireUpdate) {
            this.keyboardModifiersRequireUpdate = false;
            this._windowInfo.setKeyboardModifiers-5xRPYO0(PointerKeyboardModifiers.m1477constructorimpl(motionEvent.getMetaState()));
        }
        PointerInputEvent convertToPointerInputEvent$ui_release = this.motionEventAdapter.convertToPointerInputEvent$ui_release(motionEvent, this);
        if (convertToPointerInputEvent$ui_release == null) {
            this.pointerInputEventProcessor.processCancel();
            return PointerInputEventProcessorKt.ProcessResult(false, false);
        }
        List pointers = convertToPointerInputEvent$ui_release.getPointers();
        ListIterator listIterator = pointers.listIterator(pointers.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                obj = null;
                break;
            }
            obj = listIterator.previous();
            if (((PointerInputEventData) obj).getDown()) {
                break;
            }
        }
        PointerInputEventData pointerInputEventData = (PointerInputEventData) obj;
        if (pointerInputEventData != null) {
            this.lastDownPointerPosition = pointerInputEventData.getPosition-F1C5BW0();
        }
        int m1472processBIzXfog = this.pointerInputEventProcessor.m1472processBIzXfog(convertToPointerInputEvent$ui_release, this, isInBounds(motionEvent));
        int actionMasked = motionEvent.getActionMasked();
        if ((actionMasked != 0 && actionMasked != 5) || ProcessResult.m1495getDispatchedToAPointerInputModifierimpl(m1472processBIzXfog)) {
            return m1472processBIzXfog;
        }
        this.motionEventAdapter.endStream(motionEvent.getPointerId(motionEvent.getActionIndex()));
        return m1472processBIzXfog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendSimulatedEvent(MotionEvent motionEvent, int i, long j, boolean z) {
        int actionMasked = motionEvent.getActionMasked();
        int i2 = -1;
        if (actionMasked != 1) {
            if (actionMasked == 6) {
                i2 = motionEvent.getActionIndex();
            }
        } else if (i != 9 && i != 10) {
            i2 = 0;
        }
        int pointerCount = motionEvent.getPointerCount() - (i2 >= 0 ? 1 : 0);
        if (pointerCount == 0) {
            return;
        }
        MotionEvent.PointerProperties[] pointerPropertiesArr = new MotionEvent.PointerProperties[pointerCount];
        for (int i3 = 0; i3 < pointerCount; i3++) {
            pointerPropertiesArr[i3] = new MotionEvent.PointerProperties();
        }
        MotionEvent.PointerCoords[] pointerCoordsArr = new MotionEvent.PointerCoords[pointerCount];
        for (int i4 = 0; i4 < pointerCount; i4++) {
            pointerCoordsArr[i4] = new MotionEvent.PointerCoords();
        }
        int i5 = 0;
        while (i5 < pointerCount) {
            int i6 = ((i2 < 0 || i5 < i2) ? 0 : 1) + i5;
            motionEvent.getPointerProperties(i6, pointerPropertiesArr[i5]);
            MotionEvent.PointerCoords pointerCoords = pointerCoordsArr[i5];
            motionEvent.getPointerCoords(i6, pointerCoords);
            long mo1488localToScreenMKHz9U = mo1488localToScreenMKHz9U(OffsetKt.Offset(pointerCoords.x, pointerCoords.y));
            pointerCoords.x = Offset.m848getXimpl(mo1488localToScreenMKHz9U);
            pointerCoords.y = Offset.m849getYimpl(mo1488localToScreenMKHz9U);
            i5++;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent.getDownTime() == motionEvent.getEventTime() ? j : motionEvent.getDownTime(), j, i, pointerCount, pointerPropertiesArr, pointerCoordsArr, motionEvent.getMetaState(), z ? 0 : motionEvent.getButtonState(), motionEvent.getXPrecision(), motionEvent.getYPrecision(), motionEvent.getDeviceId(), motionEvent.getEdgeFlags(), motionEvent.getSource(), motionEvent.getFlags());
        MotionEventAdapter motionEventAdapter = this.motionEventAdapter;
        Intrinsics.checkNotNullExpressionValue(obtain, NotificationCompat.CATEGORY_EVENT);
        PointerInputEvent convertToPointerInputEvent$ui_release = motionEventAdapter.convertToPointerInputEvent$ui_release(obtain, this);
        Intrinsics.checkNotNull(convertToPointerInputEvent$ui_release);
        this.pointerInputEventProcessor.m1472processBIzXfog(convertToPointerInputEvent$ui_release, this, true);
        obtain.recycle();
    }

    static /* synthetic */ void sendSimulatedEvent$default(AndroidComposeView androidComposeView, MotionEvent motionEvent, int i, long j, boolean z, int i2, Object obj) {
        androidComposeView.sendSimulatedEvent(motionEvent, i, j, (i2 & 8) != 0 ? true : z);
    }

    private void setFontFamilyResolver(FontFamily.Resolver resolver) {
        this.fontFamilyResolver$delegate.setValue(resolver);
    }

    private void setLayoutDirection(LayoutDirection layoutDirection) {
        this.layoutDirection$delegate.setValue(layoutDirection);
    }

    private final void setViewTreeOwners(ViewTreeOwners viewTreeOwners) {
        this.viewTreeOwners$delegate.setValue(viewTreeOwners);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void touchModeChangeListener$lambda$3(AndroidComposeView androidComposeView, boolean z) {
        Intrinsics.checkNotNullParameter(androidComposeView, "this$0");
        androidComposeView._inputModeManager.setInputMode-iuPiT84(z ? InputMode.Companion.m1376getTouchaOaMEAU() : InputMode.Companion.m1375getKeyboardaOaMEAU());
    }

    private final void updatePositionCacheAndDispatch() {
        getLocationOnScreen(this.tmpPositionArray);
        long j = this.globalPosition;
        int i = IntOffset.component1-impl(j);
        int i2 = IntOffset.component2-impl(j);
        int[] iArr = this.tmpPositionArray;
        boolean z = false;
        if (i != iArr[0] || i2 != iArr[1]) {
            this.globalPosition = IntOffsetKt.IntOffset(iArr[0], iArr[1]);
            if (i != Integer.MAX_VALUE && i2 != Integer.MAX_VALUE) {
                getRoot().getLayoutDelegate$ui_release().getMeasurePassDelegate$ui_release().notifyChildrenUsingCoordinatesWhilePlacing();
                z = true;
            }
        }
        this.measureAndLayoutDelegate.dispatchOnPositionedCallbacks(z);
    }

    public final void addAndroidView(@NotNull AndroidViewHolder androidViewHolder, @NotNull LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(androidViewHolder, "view");
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        getAndroidViewsHandler$ui_release().getHolderToLayoutNode().put(androidViewHolder, layoutNode);
        getAndroidViewsHandler$ui_release().addView(androidViewHolder);
        getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().put(layoutNode, androidViewHolder);
        ViewCompat.setImportantForAccessibility(androidViewHolder, 1);
        ViewCompat.setAccessibilityDelegate(androidViewHolder, new addAndroidView.1(layoutNode, this, this));
    }

    @Override // android.view.View
    public void autofill(@NotNull SparseArray<AutofillValue> sparseArray) {
        AndroidAutofill androidAutofill;
        Intrinsics.checkNotNullParameter(sparseArray, "values");
        if (!autofillSupported() || (androidAutofill = this._autofill) == null) {
            return;
        }
        AndroidAutofill_androidKt.performAutofill(androidAutofill, sparseArray);
    }

    @Nullable
    public final Object boundsUpdatesEventLoop(@NotNull Continuation<? super Unit> continuation) {
        Object boundsUpdatesEventLoop = this.accessibilityDelegate.boundsUpdatesEventLoop(continuation);
        return boundsUpdatesEventLoop == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? boundsUpdatesEventLoop : Unit.INSTANCE;
    }

    /* renamed from: calculateLocalPosition-MK-Hz9U, reason: not valid java name */
    public long m1711calculateLocalPositionMKHz9U(long j) {
        recalculateWindowPosition();
        return Matrix.m1159mapMKHz9U(this.windowToViewMatrix, j);
    }

    /* renamed from: calculatePositionInWindow-MK-Hz9U, reason: not valid java name */
    public long m1712calculatePositionInWindowMKHz9U(long j) {
        recalculateWindowPosition();
        return Matrix.m1159mapMKHz9U(this.viewToWindowMatrix, j);
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i) {
        return this.accessibilityDelegate.m1720canScroll0AR0LA0$ui_release(false, i, this.lastDownPointerPosition);
    }

    @Override // android.view.View
    public boolean canScrollVertically(int i) {
        return this.accessibilityDelegate.m1720canScroll0AR0LA0$ui_release(true, i, this.lastDownPointerPosition);
    }

    @NotNull
    public OwnedLayer createLayer(@NotNull Function1<? super Canvas, Unit> function1, @NotNull Function0<Unit> function0) {
        DrawChildContainer viewLayerContainer;
        Intrinsics.checkNotNullParameter(function1, "drawBlock");
        Intrinsics.checkNotNullParameter(function0, "invalidateParentLayer");
        OwnedLayer pop = this.layerCache.pop();
        if (pop != null) {
            pop.reuseLayer(function1, function0);
            return pop;
        }
        if (isHardwareAccelerated() && Build.VERSION.SDK_INT >= 23 && this.isRenderNodeCompatible) {
            try {
                return new RenderNodeLayer(this, function1, function0);
            } catch (Throwable unused) {
                this.isRenderNodeCompatible = false;
            }
        }
        if (this.viewLayersContainer == null) {
            ViewLayer.Companion companion = ViewLayer.Companion;
            if (!companion.getHasRetrievedMethod()) {
                companion.updateDisplayList(new View(getContext()));
            }
            if (companion.getShouldUseDispatchDraw()) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                viewLayerContainer = new DrawChildContainer(context);
            } else {
                Context context2 = getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "context");
                viewLayerContainer = new ViewLayerContainer(context2);
            }
            this.viewLayersContainer = viewLayerContainer;
            addView(viewLayerContainer);
        }
        DrawChildContainer drawChildContainer = this.viewLayersContainer;
        Intrinsics.checkNotNull(drawChildContainer);
        return new ViewLayer(this, drawChildContainer, function1, function0);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(@NotNull android.graphics.Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (!isAttachedToWindow()) {
            invalidateLayers(getRoot());
        }
        ql3.a(this, false, 1, (Object) null);
        this.isDrawingContent = true;
        CanvasHolder canvasHolder = this.canvasHolder;
        android.graphics.Canvas internalCanvas = canvasHolder.getAndroidCanvas().getInternalCanvas();
        canvasHolder.getAndroidCanvas().setInternalCanvas(canvas);
        getRoot().draw$ui_release(canvasHolder.getAndroidCanvas());
        canvasHolder.getAndroidCanvas().setInternalCanvas(internalCanvas);
        if (!this.dirtyLayers.isEmpty()) {
            int size = this.dirtyLayers.size();
            for (int i = 0; i < size; i++) {
                this.dirtyLayers.get(i).updateDisplayList();
            }
        }
        if (ViewLayer.Companion.getShouldUseDispatchDraw()) {
            int save = canvas.save();
            canvas.clipRect(0.0f, 0.0f, 0.0f, 0.0f);
            super.dispatchDraw(canvas);
            canvas.restoreToCount(save);
        }
        this.dirtyLayers.clear();
        this.isDrawingContent = false;
        List<OwnedLayer> list = this.postponedDirtyLayers;
        if (list != null) {
            Intrinsics.checkNotNull(list);
            this.dirtyLayers.addAll(list);
            list.clear();
        }
    }

    @Override // android.view.View
    public boolean dispatchGenericMotionEvent(@NotNull MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, NotificationCompat.CATEGORY_EVENT);
        return motionEvent.getActionMasked() == 8 ? motionEvent.isFromSource(InputDeviceCompat.SOURCE_ROTARY_ENCODER) ? handleRotaryEvent(motionEvent) : (isBadMotionEvent(motionEvent) || !isAttachedToWindow()) ? super.dispatchGenericMotionEvent(motionEvent) : ProcessResult.m1495getDispatchedToAPointerInputModifierimpl(m1709handleMotionEvent8iAsVTc(motionEvent)) : super.dispatchGenericMotionEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchHoverEvent(@NotNull MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, NotificationCompat.CATEGORY_EVENT);
        if (this.hoverExitReceived) {
            removeCallbacks(this.sendHoverExitEvent);
            this.sendHoverExitEvent.run();
        }
        if (isBadMotionEvent(motionEvent) || !isAttachedToWindow()) {
            return false;
        }
        if (motionEvent.isFromSource(InputDeviceCompat.SOURCE_TOUCHSCREEN) && motionEvent.getToolType(0) == 1) {
            return this.accessibilityDelegate.dispatchHoverEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 7) {
            if (actionMasked == 10 && isInBounds(motionEvent)) {
                if (motionEvent.getToolType(0) != 3) {
                    MotionEvent motionEvent2 = this.previousMotionEvent;
                    if (motionEvent2 != null) {
                        motionEvent2.recycle();
                    }
                    this.previousMotionEvent = MotionEvent.obtainNoHistory(motionEvent);
                    this.hoverExitReceived = true;
                    post(this.sendHoverExitEvent);
                    return false;
                }
                if (motionEvent.getButtonState() != 0) {
                    return false;
                }
            }
        } else if (!isPositionChanged(motionEvent)) {
            return false;
        }
        return ProcessResult.m1495getDispatchedToAPointerInputModifierimpl(m1709handleMotionEvent8iAsVTc(motionEvent));
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(@NotNull android.view.KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(keyEvent, NotificationCompat.CATEGORY_EVENT);
        if (!isFocused()) {
            return super.dispatchKeyEvent(keyEvent);
        }
        this._windowInfo.setKeyboardModifiers-5xRPYO0(PointerKeyboardModifiers.m1477constructorimpl(keyEvent.getMetaState()));
        return m1715sendKeyEventZmokQxo(KeyEvent.constructor-impl(keyEvent));
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(@NotNull MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "motionEvent");
        if (this.hoverExitReceived) {
            removeCallbacks(this.sendHoverExitEvent);
            MotionEvent motionEvent2 = this.previousMotionEvent;
            Intrinsics.checkNotNull(motionEvent2);
            if (motionEvent.getActionMasked() != 0 || hasChangedDevices(motionEvent, motionEvent2)) {
                this.sendHoverExitEvent.run();
            } else {
                this.hoverExitReceived = false;
            }
        }
        if (isBadMotionEvent(motionEvent) || !isAttachedToWindow()) {
            return false;
        }
        if (motionEvent.getActionMasked() == 2 && !isPositionChanged(motionEvent)) {
            return false;
        }
        int m1709handleMotionEvent8iAsVTc = m1709handleMotionEvent8iAsVTc(motionEvent);
        if (ProcessResult.m1494getAnyMovementConsumedimpl(m1709handleMotionEvent8iAsVTc)) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        return ProcessResult.m1495getDispatchedToAPointerInputModifierimpl(m1709handleMotionEvent8iAsVTc);
    }

    public final void drawAndroidView(@NotNull AndroidViewHolder androidViewHolder, @NotNull android.graphics.Canvas canvas) {
        Intrinsics.checkNotNullParameter(androidViewHolder, "view");
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        getAndroidViewsHandler$ui_release().drawView(androidViewHolder, canvas);
    }

    @Nullable
    public final View findViewByAccessibilityIdTraversal(int i) {
        View view = null;
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                Method declaredMethod = View.class.getDeclaredMethod("findViewByAccessibilityIdTraversal", Integer.TYPE);
                declaredMethod.setAccessible(true);
                Object invoke = declaredMethod.invoke(this, Integer.valueOf(i));
                if (invoke instanceof View) {
                    view = (View) invoke;
                }
            } else {
                view = findViewByAccessibilityIdRootedAtCurrentView(i, this);
            }
        } catch (NoSuchMethodException unused) {
        }
        return view;
    }

    public void forceMeasureTheSubtree(@NotNull LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        this.measureAndLayoutDelegate.forceMeasureTheSubtree(layoutNode);
    }

    @NotNull
    public final AndroidViewsHandler getAndroidViewsHandler$ui_release() {
        if (this._androidViewsHandler == null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            AndroidViewsHandler androidViewsHandler = new AndroidViewsHandler(context);
            this._androidViewsHandler = androidViewsHandler;
            addView(androidViewsHandler);
        }
        AndroidViewsHandler androidViewsHandler2 = this._androidViewsHandler;
        Intrinsics.checkNotNull(androidViewsHandler2);
        return androidViewsHandler2;
    }

    @Nullable
    public Autofill getAutofill() {
        return this._autofill;
    }

    @NotNull
    public AutofillTree getAutofillTree() {
        return this.autofillTree;
    }

    @NotNull
    public final Function1<Configuration, Unit> getConfigurationChangeObserver() {
        return this.configurationChangeObserver;
    }

    @NotNull
    public Density getDensity() {
        return this.density;
    }

    @Nullable
    /* renamed from: getFocusDirection-P8AzH3I, reason: not valid java name */
    public FocusDirection m1713getFocusDirectionP8AzH3I(@NotNull android.view.KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(keyEvent, "keyEvent");
        long j = KeyEvent_androidKt.getKey-ZmokQxo(keyEvent);
        Key.Companion companion = Key.Companion;
        if (Key.m1383equalsimpl0(j, companion.getTab-EK5gGoQ())) {
            return FocusDirection.box-impl(KeyEvent_androidKt.isShiftPressed-ZmokQxo(keyEvent) ? FocusDirection.Companion.getPrevious-dhqQ-8s() : FocusDirection.Companion.getNext-dhqQ-8s());
        }
        if (Key.m1383equalsimpl0(j, companion.getDirectionRight-EK5gGoQ())) {
            return FocusDirection.box-impl(FocusDirection.Companion.getRight-dhqQ-8s());
        }
        if (Key.m1383equalsimpl0(j, companion.getDirectionLeft-EK5gGoQ())) {
            return FocusDirection.box-impl(FocusDirection.Companion.getLeft-dhqQ-8s());
        }
        if (Key.m1383equalsimpl0(j, companion.getDirectionUp-EK5gGoQ())) {
            return FocusDirection.box-impl(FocusDirection.Companion.getUp-dhqQ-8s());
        }
        if (Key.m1383equalsimpl0(j, companion.getDirectionDown-EK5gGoQ())) {
            return FocusDirection.box-impl(FocusDirection.Companion.getDown-dhqQ-8s());
        }
        if (Key.m1383equalsimpl0(j, companion.getDirectionCenter-EK5gGoQ()) ? true : Key.m1383equalsimpl0(j, companion.getEnter-EK5gGoQ()) ? true : Key.m1383equalsimpl0(j, companion.getNumPadEnter-EK5gGoQ())) {
            return FocusDirection.box-impl(FocusDirection.Companion.getEnter-dhqQ-8s());
        }
        if (Key.m1383equalsimpl0(j, companion.getBack-EK5gGoQ()) ? true : Key.m1383equalsimpl0(j, companion.getEscape-EK5gGoQ())) {
            return FocusDirection.box-impl(FocusDirection.Companion.getExit-dhqQ-8s());
        }
        return null;
    }

    @NotNull
    public FocusOwner getFocusOwner() {
        return this.focusOwner;
    }

    @Override // android.view.View
    public void getFocusedRect(@NotNull Rect rect) {
        Unit unit;
        Intrinsics.checkNotNullParameter(rect, "rect");
        androidx.compose.ui.geometry.Rect focusRect = getFocusOwner().getFocusRect();
        if (focusRect != null) {
            rect.left = MathKt.roundToInt(focusRect.getLeft());
            rect.top = MathKt.roundToInt(focusRect.getTop());
            rect.right = MathKt.roundToInt(focusRect.getRight());
            rect.bottom = MathKt.roundToInt(focusRect.getBottom());
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            super.getFocusedRect(rect);
        }
    }

    @NotNull
    public FontFamily.Resolver getFontFamilyResolver() {
        return (FontFamily.Resolver) this.fontFamilyResolver$delegate.getValue();
    }

    @NotNull
    public Font.ResourceLoader getFontLoader() {
        return this.fontLoader;
    }

    @NotNull
    public HapticFeedback getHapticFeedBack() {
        return this.hapticFeedBack;
    }

    @Override // androidx.compose.ui.platform.ViewRootForTest
    public boolean getHasPendingMeasureOrLayout() {
        return this.measureAndLayoutDelegate.getHasPendingMeasureOrLayout();
    }

    @NotNull
    public InputModeManager getInputModeManager() {
        return this._inputModeManager;
    }

    public final long getLastMatrixRecalculationAnimationTime$ui_release() {
        return this.lastMatrixRecalculationAnimationTime;
    }

    @Override // android.view.View, android.view.ViewParent
    @NotNull
    public LayoutDirection getLayoutDirection() {
        return (LayoutDirection) this.layoutDirection$delegate.getValue();
    }

    public long getMeasureIteration() {
        return this.measureAndLayoutDelegate.getMeasureIteration();
    }

    @NotNull
    public ModifierLocalManager getModifierLocalManager() {
        return this.modifierLocalManager;
    }

    @NotNull
    public PointerIconService getPointerIconService() {
        return this.pointerIconService;
    }

    @NotNull
    public LayoutNode getRoot() {
        return this.root;
    }

    @NotNull
    public RootForTest getRootForTest() {
        return this.rootForTest;
    }

    @NotNull
    public SemanticsOwner getSemanticsOwner() {
        return this.semanticsOwner;
    }

    @NotNull
    public LayoutNodeDrawScope getSharedDrawScope() {
        return this.sharedDrawScope;
    }

    public boolean getShowLayoutBounds() {
        return this.showLayoutBounds;
    }

    @NotNull
    public OwnerSnapshotObserver getSnapshotObserver() {
        return this.snapshotObserver;
    }

    @NotNull
    public TextInputService getTextInputService() {
        return this.textInputService;
    }

    @NotNull
    public TextToolbar getTextToolbar() {
        return this.textToolbar;
    }

    @Override // androidx.compose.ui.platform.ViewRootForTest
    @NotNull
    public View getView() {
        return this;
    }

    @NotNull
    public ViewConfiguration getViewConfiguration() {
        return this.viewConfiguration;
    }

    @Nullable
    public final ViewTreeOwners getViewTreeOwners() {
        return (ViewTreeOwners) this.viewTreeOwners$delegate.getValue();
    }

    @NotNull
    public WindowInfo getWindowInfo() {
        return this._windowInfo;
    }

    @Override // androidx.compose.ui.platform.ViewRootForTest
    public void invalidateDescendants() {
        invalidateLayers(getRoot());
    }

    @Override // androidx.compose.ui.platform.ViewRootForTest
    public boolean isLifecycleInResumedState() {
        LifecycleOwner lifecycleOwner;
        Lifecycle lifecycle;
        ViewTreeOwners viewTreeOwners = getViewTreeOwners();
        return ((viewTreeOwners == null || (lifecycleOwner = viewTreeOwners.getLifecycleOwner()) == null || (lifecycle = lifecycleOwner.getLifecycle()) == null) ? null : lifecycle.getCurrentState()) == Lifecycle.State.RESUMED;
    }

    @Nullable
    public final Object keyboardVisibilityEventLoop(@NotNull Continuation<? super Unit> continuation) {
        Object textInputCommandEventLoop = this.textInputServiceAndroid.textInputCommandEventLoop(continuation);
        return textInputCommandEventLoop == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? textInputCommandEventLoop : Unit.INSTANCE;
    }

    @Override // androidx.compose.ui.input.pointer.PositionCalculator
    /* renamed from: localToScreen-MK-Hz9U */
    public long mo1488localToScreenMKHz9U(long j) {
        recalculateWindowPosition();
        long m1159mapMKHz9U = Matrix.m1159mapMKHz9U(this.viewToWindowMatrix, j);
        return OffsetKt.Offset(Offset.m848getXimpl(m1159mapMKHz9U) + Offset.m848getXimpl(this.windowPosition), Offset.m849getYimpl(m1159mapMKHz9U) + Offset.m849getYimpl(this.windowPosition));
    }

    public void measureAndLayout(boolean z) {
        Function0<Unit> function0;
        Trace.beginSection("AndroidOwner:measureAndLayout");
        if (z) {
            try {
                function0 = this.resendMotionEventOnLayout;
            } catch (Throwable th) {
                Trace.endSection();
                throw th;
            }
        } else {
            function0 = null;
        }
        if (this.measureAndLayoutDelegate.measureAndLayout(function0)) {
            requestLayout();
        }
        MeasureAndLayoutDelegate.dispatchOnPositionedCallbacks$default(this.measureAndLayoutDelegate, false, 1, null);
        Unit unit = Unit.INSTANCE;
        Trace.endSection();
    }

    /* renamed from: measureAndLayout-0kLqBqw, reason: not valid java name */
    public void m1714measureAndLayout0kLqBqw(@NotNull LayoutNode layoutNode, long j) {
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        Trace.beginSection("AndroidOwner:measureAndLayout");
        try {
            this.measureAndLayoutDelegate.m1618measureAndLayout0kLqBqw(layoutNode, j);
            MeasureAndLayoutDelegate.dispatchOnPositionedCallbacks$default(this.measureAndLayoutDelegate, false, 1, null);
            Unit unit = Unit.INSTANCE;
        } finally {
            Trace.endSection();
        }
    }

    public void measureAndLayoutForTest() {
        ql3.a(this, false, 1, (Object) null);
    }

    public final void notifyLayerIsDirty$ui_release(@NotNull OwnedLayer ownedLayer, boolean z) {
        Intrinsics.checkNotNullParameter(ownedLayer, "layer");
        if (!z) {
            if (this.isDrawingContent) {
                return;
            }
            this.dirtyLayers.remove(ownedLayer);
            List<OwnedLayer> list = this.postponedDirtyLayers;
            if (list != null) {
                list.remove(ownedLayer);
                return;
            }
            return;
        }
        if (!this.isDrawingContent) {
            this.dirtyLayers.add(ownedLayer);
            return;
        }
        List list2 = this.postponedDirtyLayers;
        if (list2 == null) {
            list2 = new ArrayList();
            this.postponedDirtyLayers = list2;
        }
        list2.add(ownedLayer);
    }

    public void onAttach(@NotNull LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(layoutNode, "node");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        LifecycleOwner lifecycleOwner;
        Lifecycle lifecycle;
        AndroidAutofill androidAutofill;
        super.onAttachedToWindow();
        invalidateLayoutNodeMeasurement(getRoot());
        invalidateLayers(getRoot());
        getSnapshotObserver().startObserving$ui_release();
        if (autofillSupported() && (androidAutofill = this._autofill) != null) {
            AutofillCallback.INSTANCE.register(androidAutofill);
        }
        LifecycleOwner lifecycleOwner2 = ViewTreeLifecycleOwner.get(this);
        LifecycleOwner lifecycleOwner3 = ViewTreeSavedStateRegistryOwner.get(this);
        ViewTreeOwners viewTreeOwners = getViewTreeOwners();
        if (viewTreeOwners == null || !(lifecycleOwner2 == null || lifecycleOwner3 == null || (lifecycleOwner2 == viewTreeOwners.getLifecycleOwner() && lifecycleOwner3 == viewTreeOwners.getLifecycleOwner()))) {
            if (lifecycleOwner2 == null) {
                throw new IllegalStateException("Composed into the View which doesn't propagate ViewTreeLifecycleOwner!");
            }
            if (lifecycleOwner3 == null) {
                throw new IllegalStateException("Composed into the View which doesn't propagateViewTreeSavedStateRegistryOwner!");
            }
            if (viewTreeOwners != null && (lifecycleOwner = viewTreeOwners.getLifecycleOwner()) != null && (lifecycle = lifecycleOwner.getLifecycle()) != null) {
                lifecycle.removeObserver(this);
            }
            lifecycleOwner2.getLifecycle().addObserver(this);
            ViewTreeOwners viewTreeOwners2 = new ViewTreeOwners(lifecycleOwner2, lifecycleOwner3);
            setViewTreeOwners(viewTreeOwners2);
            Function1<? super ViewTreeOwners, Unit> function1 = this.onViewTreeOwnersAvailable;
            if (function1 != null) {
                function1.invoke(viewTreeOwners2);
            }
            this.onViewTreeOwnersAvailable = null;
        }
        ViewTreeOwners viewTreeOwners3 = getViewTreeOwners();
        Intrinsics.checkNotNull(viewTreeOwners3);
        viewTreeOwners3.getLifecycleOwner().getLifecycle().addObserver(this);
        getViewTreeObserver().addOnGlobalLayoutListener(this.globalLayoutListener);
        getViewTreeObserver().addOnScrollChangedListener(this.scrollChangedListener);
        getViewTreeObserver().addOnTouchModeChangeListener(this.touchModeChangeListener);
    }

    @Override // android.view.View
    public boolean onCheckIsTextEditor() {
        return this.textInputServiceAndroid.isEditorFocused();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(@NotNull Configuration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "newConfig");
        super.onConfigurationChanged(configuration);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        this.density = AndroidDensity_androidKt.Density(context);
        if (getFontWeightAdjustmentCompat(configuration) != this.currentFontWeightAdjustment) {
            this.currentFontWeightAdjustment = getFontWeightAdjustmentCompat(configuration);
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            setFontFamilyResolver(FontFamilyResolver_androidKt.createFontFamilyResolver(context2));
        }
        this.configurationChangeObserver.invoke(configuration);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onCreate(LifecycleOwner lifecycleOwner) {
        wv0.a(this, lifecycleOwner);
    }

    @Override // android.view.View
    @Nullable
    public InputConnection onCreateInputConnection(@NotNull EditorInfo editorInfo) {
        Intrinsics.checkNotNullParameter(editorInfo, "outAttrs");
        return this.textInputServiceAndroid.createInputConnection(editorInfo);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onDestroy(LifecycleOwner lifecycleOwner) {
        wv0.b(this, lifecycleOwner);
    }

    public void onDetach(@NotNull LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(layoutNode, "node");
        this.measureAndLayoutDelegate.onNodeDetached(layoutNode);
        requestClearInvalidObservations();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        AndroidAutofill androidAutofill;
        LifecycleOwner lifecycleOwner;
        Lifecycle lifecycle;
        super.onDetachedFromWindow();
        getSnapshotObserver().stopObserving$ui_release();
        ViewTreeOwners viewTreeOwners = getViewTreeOwners();
        if (viewTreeOwners != null && (lifecycleOwner = viewTreeOwners.getLifecycleOwner()) != null && (lifecycle = lifecycleOwner.getLifecycle()) != null) {
            lifecycle.removeObserver(this);
        }
        if (autofillSupported() && (androidAutofill = this._autofill) != null) {
            AutofillCallback.INSTANCE.unregister(androidAutofill);
        }
        getViewTreeObserver().removeOnGlobalLayoutListener(this.globalLayoutListener);
        getViewTreeObserver().removeOnScrollChangedListener(this.scrollChangedListener);
        getViewTreeObserver().removeOnTouchModeChangeListener(this.touchModeChangeListener);
    }

    @Override // android.view.View
    protected void onDraw(@NotNull android.graphics.Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
    }

    public void onEndApplyChanges() {
        if (this.observationClearRequested) {
            getSnapshotObserver().clearInvalidObservations$ui_release();
            this.observationClearRequested = false;
        }
        AndroidViewsHandler androidViewsHandler = this._androidViewsHandler;
        if (androidViewsHandler != null) {
            clearChildInvalidObservations(androidViewsHandler);
        }
        while (this.endApplyChangesListeners.isNotEmpty()) {
            int size = this.endApplyChangesListeners.getSize();
            for (int i = 0; i < size; i++) {
                Function0 function0 = (Function0) this.endApplyChangesListeners.getContent()[i];
                this.endApplyChangesListeners.set(i, (Object) null);
                if (function0 != null) {
                    function0.invoke();
                }
            }
            this.endApplyChangesListeners.removeRange(0, size);
        }
    }

    @Override // android.view.View
    protected void onFocusChanged(boolean z, int i, @Nullable Rect rect) {
        super.onFocusChanged(z, i, rect);
        Log.d(FocusTag, "Owner FocusChanged(" + z + ')');
        if (z) {
            getFocusOwner().takeFocus();
        } else {
            getFocusOwner().releaseFocus();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.measureAndLayoutDelegate.measureAndLayout(this.resendMotionEventOnLayout);
        this.onMeasureConstraints = null;
        updatePositionCacheAndDispatch();
        if (this._androidViewsHandler != null) {
            getAndroidViewsHandler$ui_release().layout(0, 0, i3 - i, i4 - i2);
        }
    }

    public void onLayoutChange(@NotNull LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        this.accessibilityDelegate.onLayoutChange$ui_release(layoutNode);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        Trace.beginSection("AndroidOwner:onMeasure");
        try {
            if (!isAttachedToWindow()) {
                invalidateLayoutNodeMeasurement(getRoot());
            }
            Pair<Integer, Integer> convertMeasureSpec = convertMeasureSpec(i);
            int intValue = ((Number) convertMeasureSpec.component1()).intValue();
            int intValue2 = ((Number) convertMeasureSpec.component2()).intValue();
            Pair<Integer, Integer> convertMeasureSpec2 = convertMeasureSpec(i2);
            long Constraints = ConstraintsKt.Constraints(intValue, intValue2, ((Number) convertMeasureSpec2.component1()).intValue(), ((Number) convertMeasureSpec2.component2()).intValue());
            Constraints constraints = this.onMeasureConstraints;
            boolean z = false;
            if (constraints == null) {
                this.onMeasureConstraints = Constraints.m2110boximpl(Constraints);
                this.wasMeasuredWithMultipleConstraints = false;
            } else {
                if (constraints != null) {
                    z = Constraints.m2115equalsimpl0(constraints.m2128unboximpl(), Constraints);
                }
                if (!z) {
                    this.wasMeasuredWithMultipleConstraints = true;
                }
            }
            this.measureAndLayoutDelegate.m1619updateRootConstraintsBRTryo0(Constraints);
            this.measureAndLayoutDelegate.measureOnly();
            setMeasuredDimension(getRoot().getWidth(), getRoot().getHeight());
            if (this._androidViewsHandler != null) {
                getAndroidViewsHandler$ui_release().measure(View.MeasureSpec.makeMeasureSpec(getRoot().getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getRoot().getHeight(), 1073741824));
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            Trace.endSection();
        }
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onPause(LifecycleOwner lifecycleOwner) {
        wv0.c(this, lifecycleOwner);
    }

    @Override // android.view.View
    public void onProvideAutofillVirtualStructure(@Nullable ViewStructure viewStructure, int i) {
        AndroidAutofill androidAutofill;
        if (!autofillSupported() || viewStructure == null || (androidAutofill = this._autofill) == null) {
            return;
        }
        AndroidAutofill_androidKt.populateViewStructure(androidAutofill, viewStructure);
    }

    public void onRequestMeasure(@NotNull LayoutNode layoutNode, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        if (z) {
            if (this.measureAndLayoutDelegate.requestLookaheadRemeasure(layoutNode, z2)) {
                scheduleMeasureAndLayout(layoutNode);
            }
        } else if (this.measureAndLayoutDelegate.requestRemeasure(layoutNode, z2)) {
            scheduleMeasureAndLayout(layoutNode);
        }
    }

    public void onRequestRelayout(@NotNull LayoutNode layoutNode, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        if (z) {
            if (this.measureAndLayoutDelegate.requestLookaheadRelayout(layoutNode, z2)) {
                scheduleMeasureAndLayout$default(this, null, 1, null);
            }
        } else if (this.measureAndLayoutDelegate.requestRelayout(layoutNode, z2)) {
            scheduleMeasureAndLayout$default(this, null, 1, null);
        }
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onResume(@NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        setShowLayoutBounds(Companion.getIsShowingLayoutBounds());
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        LayoutDirection layoutDirectionFromInt;
        if (this.superclassInitComplete) {
            layoutDirectionFromInt = AndroidComposeView_androidKt.layoutDirectionFromInt(i);
            setLayoutDirection(layoutDirectionFromInt);
            getFocusOwner().setLayoutDirection(layoutDirectionFromInt);
        }
    }

    public void onSemanticsChange() {
        this.accessibilityDelegate.onSemanticsChange$ui_release();
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onStart(LifecycleOwner lifecycleOwner) {
        wv0.e(this, lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onStop(LifecycleOwner lifecycleOwner) {
        wv0.f(this, lifecycleOwner);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        boolean isShowingLayoutBounds;
        this._windowInfo.setWindowFocused(z);
        this.keyboardModifiersRequireUpdate = true;
        super.onWindowFocusChanged(z);
        if (!z || getShowLayoutBounds() == (isShowingLayoutBounds = Companion.getIsShowingLayoutBounds())) {
            return;
        }
        setShowLayoutBounds(isShowingLayoutBounds);
        invalidateDescendants();
    }

    public final boolean recycle$ui_release(@NotNull OwnedLayer ownedLayer) {
        Intrinsics.checkNotNullParameter(ownedLayer, "layer");
        boolean z = this.viewLayersContainer == null || ViewLayer.Companion.getShouldUseDispatchDraw() || Build.VERSION.SDK_INT >= 23 || this.layerCache.getSize() < 10;
        if (z) {
            this.layerCache.push(ownedLayer);
        }
        return z;
    }

    public void registerOnEndApplyChangesListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "listener");
        if (this.endApplyChangesListeners.contains(function0)) {
            return;
        }
        this.endApplyChangesListeners.add(function0);
    }

    public void registerOnLayoutCompletedListener(@NotNull Owner.OnLayoutCompletedListener onLayoutCompletedListener) {
        Intrinsics.checkNotNullParameter(onLayoutCompletedListener, "listener");
        this.measureAndLayoutDelegate.registerOnLayoutCompletedListener(onLayoutCompletedListener);
        scheduleMeasureAndLayout$default(this, null, 1, null);
    }

    public final void removeAndroidView(@NotNull AndroidViewHolder androidViewHolder) {
        Intrinsics.checkNotNullParameter(androidViewHolder, "view");
        registerOnEndApplyChangesListener(new removeAndroidView.1(this, androidViewHolder));
    }

    public final void requestClearInvalidObservations() {
        this.observationClearRequested = true;
    }

    public void requestOnPositionedCallback(@NotNull LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        this.measureAndLayoutDelegate.requestOnPositionedCallback(layoutNode);
        scheduleMeasureAndLayout$default(this, null, 1, null);
    }

    @Override // androidx.compose.ui.input.pointer.PositionCalculator
    /* renamed from: screenToLocal-MK-Hz9U */
    public long mo1489screenToLocalMKHz9U(long j) {
        recalculateWindowPosition();
        return Matrix.m1159mapMKHz9U(this.windowToViewMatrix, OffsetKt.Offset(Offset.m848getXimpl(j) - Offset.m848getXimpl(this.windowPosition), Offset.m849getYimpl(j) - Offset.m849getYimpl(this.windowPosition)));
    }

    /* renamed from: sendKeyEvent-ZmokQxo, reason: not valid java name */
    public boolean m1715sendKeyEventZmokQxo(@NotNull android.view.KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(keyEvent, "keyEvent");
        return getFocusOwner().dispatchKeyEvent-ZmokQxo(keyEvent);
    }

    public final void setConfigurationChangeObserver(@NotNull Function1<? super Configuration, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.configurationChangeObserver = function1;
    }

    public final void setLastMatrixRecalculationAnimationTime$ui_release(long j) {
        this.lastMatrixRecalculationAnimationTime = j;
    }

    public final void setOnViewTreeOwnersAvailable(@NotNull Function1<? super ViewTreeOwners, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "callback");
        ViewTreeOwners viewTreeOwners = getViewTreeOwners();
        if (viewTreeOwners != null) {
            function1.invoke(viewTreeOwners);
        }
        if (isAttachedToWindow()) {
            return;
        }
        this.onViewTreeOwnersAvailable = function1;
    }

    public void setShowLayoutBounds(boolean z) {
        this.showLayoutBounds = z;
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    @NotNull
    public AndroidAccessibilityManager getAccessibilityManager() {
        return this.accessibilityManager;
    }

    @NotNull
    /* renamed from: getClipboardManager, reason: merged with bridge method [inline-methods] */
    public AndroidClipboardManager m1717getClipboardManager() {
        return this.clipboardManager;
    }

    private final void recalculateWindowPosition(MotionEvent motionEvent) {
        this.lastMatrixRecalculationAnimationTime = AnimationUtils.currentAnimationTimeMillis();
        recalculateWindowViewTransforms();
        long m1159mapMKHz9U = Matrix.m1159mapMKHz9U(this.viewToWindowMatrix, OffsetKt.Offset(motionEvent.getX(), motionEvent.getY()));
        this.windowPosition = OffsetKt.Offset(motionEvent.getRawX() - Offset.m848getXimpl(m1159mapMKHz9U), motionEvent.getRawY() - Offset.m849getYimpl(m1159mapMKHz9U));
    }
}
