package androidx.compose.ui.platform;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.SpannableString;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.DoNotInline;
import androidx.annotation.IntRange;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.collection.ArraySet;
import androidx.collection.SparseArrayCompat;
import androidx.compose.ui.R;
import androidx.compose.ui.TempListUtilsKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.HitTestResult;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.platform.AccessibilityIterators;
import androidx.compose.ui.platform.AccessibilityIterators$CharacterTextSegmentIterator;
import androidx.compose.ui.platform.AccessibilityIterators$WordTextSegmentIterator;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.ScrollAxisRange;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsConfigurationKt;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsNodeKt;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.state.ToggleableState;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.platform.AndroidAccessibilitySpannableString_androidKt;
import androidx.compose.ui.viewinterop.AndroidViewHolder;
import androidx.core.app.NotificationCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.a8;
import tb.gs;
import tb.ql3;
import tb.y7;
import tb.z7;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class AndroidComposeViewAccessibilityDelegateCompat extends AccessibilityDelegateCompat {
    public static final int AccessibilityCursorPositionUndefined = -1;
    public static final int AccessibilitySliderStepsCount = 20;

    @NotNull
    public static final String ClassName = "android.view.View";

    @NotNull
    public static final String ExtraDataTestTagKey = "androidx.compose.ui.semantics.testTag";
    public static final int InvalidId = Integer.MIN_VALUE;

    @NotNull
    public static final String LogTag = "AccessibilityDelegate";
    public static final int ParcelSafeTextLength = 100000;
    public static final long SendRecurringAccessibilityEventsIntervalMillis = 100;

    @NotNull
    public static final String TextClassName = "android.widget.TextView";

    @NotNull
    public static final String TextFieldClassName = "android.widget.EditText";
    public static final long TextTraversedEventTimeoutMillis = 1000;

    @NotNull
    private final String EXTRA_DATA_TEST_TRAVERSALBEFORE_VAL;
    private int accessibilityCursorPosition;
    private boolean accessibilityForceEnabledForTesting;

    @NotNull
    private final AccessibilityManager accessibilityManager;

    @NotNull
    private SparseArrayCompat<SparseArrayCompat<CharSequence>> actionIdToLabel;

    @NotNull
    private final Channel<Unit> boundsUpdateChannel;
    private boolean checkingForSemanticsChanges;

    @NotNull
    private Map<Integer, SemanticsNodeWithAdjustedBounds> currentSemanticsNodes;
    private boolean currentSemanticsNodesInvalidated;
    private List<AccessibilityServiceInfo> enabledServices;

    @NotNull
    private final AccessibilityManager.AccessibilityStateChangeListener enabledStateListener;
    private int focusedVirtualViewId;

    @NotNull
    private final Handler handler;
    private int hoveredVirtualViewId;

    @NotNull
    private HashMap<Integer, Integer> idToBeforeMap;

    @NotNull
    private SparseArrayCompat<Map<CharSequence, Integer>> labelToActionId;

    @NotNull
    private AccessibilityNodeProviderCompat nodeProvider;

    @NotNull
    private ArraySet<Integer> paneDisplayed;

    @Nullable
    private PendingTextTraversedEvent pendingTextTraversedEvent;

    @NotNull
    private Map<Integer, SemanticsNodeCopy> previousSemanticsNodes;

    @NotNull
    private SemanticsNodeCopy previousSemanticsRoot;

    @Nullable
    private Integer previousTraversedNode;

    @NotNull
    private final List<ScrollObservationScope> scrollObservationScopes;

    @NotNull
    private final Runnable semanticsChangeChecker;

    @NotNull
    private final Function1<ScrollObservationScope, Unit> sendScrollEventIfNeededLambda;

    @NotNull
    private final ArraySet<LayoutNode> subtreeChangedLayoutNodes;

    @NotNull
    private final AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateListener;

    @NotNull
    private final AndroidComposeView view;

    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @NotNull
    private static final int[] AccessibilityActionsResourceIds = {R.id.accessibility_custom_action_0, R.id.accessibility_custom_action_1, R.id.accessibility_custom_action_2, R.id.accessibility_custom_action_3, R.id.accessibility_custom_action_4, R.id.accessibility_custom_action_5, R.id.accessibility_custom_action_6, R.id.accessibility_custom_action_7, R.id.accessibility_custom_action_8, R.id.accessibility_custom_action_9, R.id.accessibility_custom_action_10, R.id.accessibility_custom_action_11, R.id.accessibility_custom_action_12, R.id.accessibility_custom_action_13, R.id.accessibility_custom_action_14, R.id.accessibility_custom_action_15, R.id.accessibility_custom_action_16, R.id.accessibility_custom_action_17, R.id.accessibility_custom_action_18, R.id.accessibility_custom_action_19, R.id.accessibility_custom_action_20, R.id.accessibility_custom_action_21, R.id.accessibility_custom_action_22, R.id.accessibility_custom_action_23, R.id.accessibility_custom_action_24, R.id.accessibility_custom_action_25, R.id.accessibility_custom_action_26, R.id.accessibility_custom_action_27, R.id.accessibility_custom_action_28, R.id.accessibility_custom_action_29, R.id.accessibility_custom_action_30, R.id.accessibility_custom_action_31};

    /* compiled from: Taobao */
    @RequiresApi(28)
    private static final class Api28Impl {

        @NotNull
        public static final Api28Impl INSTANCE = new Api28Impl();

        private Api28Impl() {
        }

        @JvmStatic
        @DoNotInline
        public static final void setScrollEventDelta(@NotNull AccessibilityEvent accessibilityEvent, int i, int i2) {
            Intrinsics.checkNotNullParameter(accessibilityEvent, NotificationCompat.CATEGORY_EVENT);
            accessibilityEvent.setScrollDeltaX(i);
            accessibilityEvent.setScrollDeltaY(i2);
        }
    }

    /* compiled from: Taobao */
    private static final class PendingTextTraversedEvent {
        private final int action;
        private final int fromIndex;
        private final int granularity;

        @NotNull
        private final SemanticsNode node;
        private final int toIndex;
        private final long traverseTime;

        public PendingTextTraversedEvent(@NotNull SemanticsNode semanticsNode, int i, int i2, int i3, int i4, long j) {
            Intrinsics.checkNotNullParameter(semanticsNode, "node");
            this.node = semanticsNode;
            this.action = i;
            this.granularity = i2;
            this.fromIndex = i3;
            this.toIndex = i4;
            this.traverseTime = j;
        }

        public final int getAction() {
            return this.action;
        }

        public final int getFromIndex() {
            return this.fromIndex;
        }

        public final int getGranularity() {
            return this.granularity;
        }

        @NotNull
        public final SemanticsNode getNode() {
            return this.node;
        }

        public final int getToIndex() {
            return this.toIndex;
        }

        public final long getTraverseTime() {
            return this.traverseTime;
        }
    }

    /* compiled from: Taobao */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ToggleableState.values().length];
            try {
                iArr[ToggleableState.On.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ToggleableState.Off.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ToggleableState.Indeterminate.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public AndroidComposeViewAccessibilityDelegateCompat(@NotNull AndroidComposeView androidComposeView) {
        Intrinsics.checkNotNullParameter(androidComposeView, "view");
        this.view = androidComposeView;
        this.hoveredVirtualViewId = Integer.MIN_VALUE;
        Object systemService = androidComposeView.getContext().getSystemService("accessibility");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");
        AccessibilityManager accessibilityManager = (AccessibilityManager) systemService;
        this.accessibilityManager = accessibilityManager;
        this.enabledStateListener = new y7(this);
        this.touchExplorationStateListener = new z7(this);
        this.enabledServices = accessibilityManager.getEnabledAccessibilityServiceList(-1);
        this.handler = new Handler(Looper.getMainLooper());
        this.nodeProvider = new AccessibilityNodeProviderCompat(new MyNodeProvider(this));
        this.focusedVirtualViewId = Integer.MIN_VALUE;
        this.actionIdToLabel = new SparseArrayCompat<>();
        this.labelToActionId = new SparseArrayCompat<>();
        this.accessibilityCursorPosition = -1;
        this.subtreeChangedLayoutNodes = new ArraySet<>();
        this.boundsUpdateChannel = gs.b(-1, (BufferOverflow) null, (Function1) null, 6, (Object) null);
        this.currentSemanticsNodesInvalidated = true;
        this.currentSemanticsNodes = MapsKt.emptyMap();
        this.paneDisplayed = new ArraySet<>();
        this.idToBeforeMap = new HashMap<>();
        this.EXTRA_DATA_TEST_TRAVERSALBEFORE_VAL = "android.view.accessibility.extra.EXTRA_DATA_TEST_TRAVERSALBEFORE_VAL";
        this.previousSemanticsNodes = new LinkedHashMap();
        this.previousSemanticsRoot = new SemanticsNodeCopy(androidComposeView.getSemanticsOwner().getUnmergedRootSemanticsNode(), MapsKt.emptyMap());
        androidComposeView.addOnAttachStateChangeListener(new 1(this));
        this.semanticsChangeChecker = new a8(this);
        this.scrollObservationScopes = new ArrayList();
        this.sendScrollEventIfNeededLambda = new sendScrollEventIfNeededLambda.1(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addExtraDataToAccessibilityNodeInfoHelper(int i, AccessibilityNodeInfo accessibilityNodeInfo, String str, Bundle bundle) {
        SemanticsNode semanticsNode;
        String str2;
        SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = getCurrentSemanticsNodes().get(Integer.valueOf(i));
        if (semanticsNodeWithAdjustedBounds == null || (semanticsNode = semanticsNodeWithAdjustedBounds.getSemanticsNode()) == null) {
            return;
        }
        String iterableTextForAccessibility = getIterableTextForAccessibility(semanticsNode);
        if (Intrinsics.areEqual(str, this.EXTRA_DATA_TEST_TRAVERSALBEFORE_VAL)) {
            Integer num = this.idToBeforeMap.get(Integer.valueOf(i));
            if (num != null) {
                accessibilityNodeInfo.getExtras().putInt(str, num.intValue());
                return;
            }
            return;
        }
        SemanticsConfiguration unmergedConfig$ui_release = semanticsNode.getUnmergedConfig$ui_release();
        SemanticsActions semanticsActions = SemanticsActions.INSTANCE;
        if (!unmergedConfig$ui_release.contains(semanticsActions.getGetTextLayoutResult()) || bundle == null || !Intrinsics.areEqual(str, "android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_KEY")) {
            SemanticsConfiguration unmergedConfig$ui_release2 = semanticsNode.getUnmergedConfig$ui_release();
            SemanticsProperties semanticsProperties = SemanticsProperties.INSTANCE;
            if (!unmergedConfig$ui_release2.contains(semanticsProperties.getTestTag()) || bundle == null || !Intrinsics.areEqual(str, ExtraDataTestTagKey) || (str2 = (String) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), semanticsProperties.getTestTag())) == null) {
                return;
            }
            accessibilityNodeInfo.getExtras().putCharSequence(str, str2);
            return;
        }
        int i2 = bundle.getInt("android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_ARG_START_INDEX", -1);
        int i3 = bundle.getInt("android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_ARG_LENGTH", -1);
        if (i3 > 0 && i2 >= 0) {
            if (i2 < (iterableTextForAccessibility != null ? iterableTextForAccessibility.length() : Integer.MAX_VALUE)) {
                ArrayList arrayList = new ArrayList();
                Function1 action = ((AccessibilityAction) semanticsNode.getUnmergedConfig$ui_release().get(semanticsActions.getGetTextLayoutResult())).getAction();
                if (Intrinsics.areEqual(action != null ? (Boolean) action.invoke(arrayList) : null, Boolean.TRUE)) {
                    TextLayoutResult textLayoutResult = (TextLayoutResult) arrayList.get(0);
                    ArrayList arrayList2 = new ArrayList();
                    for (int i4 = 0; i4 < i3; i4++) {
                        int i5 = i2 + i4;
                        if (i5 >= textLayoutResult.getLayoutInput().getText().length()) {
                            arrayList2.add(null);
                        } else {
                            arrayList2.add(toScreenCoords(semanticsNode, textLayoutResult.getBoundingBox(i5)));
                        }
                    }
                    accessibilityNodeInfo.getExtras().putParcelableArray(str, (Parcelable[]) arrayList2.toArray(new RectF[0]));
                    return;
                }
                return;
            }
        }
        Log.e(LogTag, "Invalid arguments for accessibility character locations");
    }

    private final void checkForSemanticsChanges() {
        sendSemanticsStructureChangeEvents(this.view.getSemanticsOwner().getUnmergedRootSemanticsNode(), this.previousSemanticsRoot);
        sendSemanticsPropertyChangeEvents$ui_release(getCurrentSemanticsNodes());
        updateSemanticsNodesCopyAndPanes();
    }

    private final boolean clearAccessibilityFocus(int i) {
        if (!isAccessibilityFocused(i)) {
            return false;
        }
        this.focusedVirtualViewId = Integer.MIN_VALUE;
        this.view.invalidate();
        sendEventForVirtualView$default(this, i, AccessibilityNodeInfoCompat.ACTION_CUT, null, null, 12, null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AccessibilityNodeInfo createNodeInfo(int i) {
        LifecycleOwner lifecycleOwner;
        Lifecycle lifecycle;
        AndroidComposeView.ViewTreeOwners viewTreeOwners = this.view.getViewTreeOwners();
        if (((viewTreeOwners == null || (lifecycleOwner = viewTreeOwners.getLifecycleOwner()) == null || (lifecycle = lifecycleOwner.getLifecycle()) == null) ? null : lifecycle.getCurrentState()) == Lifecycle.State.DESTROYED) {
            return null;
        }
        AccessibilityNodeInfoCompat obtain = AccessibilityNodeInfoCompat.obtain();
        Intrinsics.checkNotNullExpressionValue(obtain, "obtain()");
        SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = getCurrentSemanticsNodes().get(Integer.valueOf(i));
        if (semanticsNodeWithAdjustedBounds == null) {
            return null;
        }
        SemanticsNode semanticsNode = semanticsNodeWithAdjustedBounds.getSemanticsNode();
        if (i == -1) {
            Object parentForAccessibility = ViewCompat.getParentForAccessibility(this.view);
            obtain.setParent(parentForAccessibility instanceof View ? (View) parentForAccessibility : null);
        } else {
            if (semanticsNode.getParent() == null) {
                throw new IllegalStateException("semanticsNode " + i + " has null parent");
            }
            SemanticsNode parent = semanticsNode.getParent();
            Intrinsics.checkNotNull(parent);
            int id = parent.getId();
            obtain.setParent(this.view, id != this.view.getSemanticsOwner().getUnmergedRootSemanticsNode().getId() ? id : -1);
        }
        obtain.setSource(this.view, i);
        Rect adjustedBounds = semanticsNodeWithAdjustedBounds.getAdjustedBounds();
        long mo1488localToScreenMKHz9U = this.view.mo1488localToScreenMKHz9U(OffsetKt.Offset(adjustedBounds.left, adjustedBounds.top));
        long mo1488localToScreenMKHz9U2 = this.view.mo1488localToScreenMKHz9U(OffsetKt.Offset(adjustedBounds.right, adjustedBounds.bottom));
        obtain.setBoundsInScreen(new Rect((int) Math.floor(Offset.m848getXimpl(mo1488localToScreenMKHz9U)), (int) Math.floor(Offset.m849getYimpl(mo1488localToScreenMKHz9U)), (int) Math.ceil(Offset.m848getXimpl(mo1488localToScreenMKHz9U2)), (int) Math.ceil(Offset.m849getYimpl(mo1488localToScreenMKHz9U2))));
        populateAccessibilityNodeInfoProperties(i, obtain, semanticsNode);
        return obtain.unwrap();
    }

    private final AccessibilityEvent createTextSelectionChangedEvent(int i, Integer num, Integer num2, Integer num3, CharSequence charSequence) {
        AccessibilityEvent createEvent$ui_release = createEvent$ui_release(i, 8192);
        if (num != null) {
            createEvent$ui_release.setFromIndex(num.intValue());
        }
        if (num2 != null) {
            createEvent$ui_release.setToIndex(num2.intValue());
        }
        if (num3 != null) {
            createEvent$ui_release.setItemCount(num3.intValue());
        }
        if (charSequence != null) {
            createEvent$ui_release.getText().add(charSequence);
        }
        return createEvent$ui_release;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void enabledStateListener$lambda$0(AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat, boolean z) {
        Intrinsics.checkNotNullParameter(androidComposeViewAccessibilityDelegateCompat, "this$0");
        androidComposeViewAccessibilityDelegateCompat.enabledServices = z ? androidComposeViewAccessibilityDelegateCompat.accessibilityManager.getEnabledAccessibilityServiceList(-1) : CollectionsKt.emptyList();
    }

    @VisibleForTesting
    public static /* synthetic */ void getAccessibilityManager$ui_release$annotations() {
    }

    private final int getAccessibilitySelectionEnd(SemanticsNode semanticsNode) {
        SemanticsConfiguration unmergedConfig$ui_release = semanticsNode.getUnmergedConfig$ui_release();
        SemanticsProperties semanticsProperties = SemanticsProperties.INSTANCE;
        return (unmergedConfig$ui_release.contains(semanticsProperties.getContentDescription()) || !semanticsNode.getUnmergedConfig$ui_release().contains(semanticsProperties.getTextSelectionRange())) ? this.accessibilityCursorPosition : TextRange.getEnd-impl(((TextRange) semanticsNode.getUnmergedConfig$ui_release().get(semanticsProperties.getTextSelectionRange())).unbox-impl());
    }

    private final int getAccessibilitySelectionStart(SemanticsNode semanticsNode) {
        SemanticsConfiguration unmergedConfig$ui_release = semanticsNode.getUnmergedConfig$ui_release();
        SemanticsProperties semanticsProperties = SemanticsProperties.INSTANCE;
        return (unmergedConfig$ui_release.contains(semanticsProperties.getContentDescription()) || !semanticsNode.getUnmergedConfig$ui_release().contains(semanticsProperties.getTextSelectionRange())) ? this.accessibilityCursorPosition : TextRange.getStart-impl(((TextRange) semanticsNode.getUnmergedConfig$ui_release().get(semanticsProperties.getTextSelectionRange())).unbox-impl());
    }

    private final Map<Integer, SemanticsNodeWithAdjustedBounds> getCurrentSemanticsNodes() {
        if (this.currentSemanticsNodesInvalidated) {
            this.currentSemanticsNodesInvalidated = false;
            this.currentSemanticsNodes = AndroidComposeViewAccessibilityDelegateCompat_androidKt.getAllUncoveredSemanticsNodesToMap(this.view.getSemanticsOwner());
            setTraversalValues();
        }
        return this.currentSemanticsNodes;
    }

    @VisibleForTesting
    public static /* synthetic */ void getEnabledStateListener$ui_release$annotations() {
    }

    private final String getIterableTextForAccessibility(SemanticsNode semanticsNode) {
        boolean isTextField;
        AnnotatedString annotatedString;
        if (semanticsNode == null) {
            return null;
        }
        SemanticsConfiguration unmergedConfig$ui_release = semanticsNode.getUnmergedConfig$ui_release();
        SemanticsProperties semanticsProperties = SemanticsProperties.INSTANCE;
        if (unmergedConfig$ui_release.contains(semanticsProperties.getContentDescription())) {
            return TempListUtilsKt.fastJoinToString$default((List) semanticsNode.getUnmergedConfig$ui_release().get(semanticsProperties.getContentDescription()), ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        }
        isTextField = AndroidComposeViewAccessibilityDelegateCompat_androidKt.isTextField(semanticsNode);
        if (isTextField) {
            AnnotatedString textForTextField = getTextForTextField(semanticsNode.getUnmergedConfig$ui_release());
            if (textForTextField != null) {
                return textForTextField.getText();
            }
            return null;
        }
        List list = (List) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), semanticsProperties.getText());
        if (list == null || (annotatedString = (AnnotatedString) CollectionsKt.firstOrNull(list)) == null) {
            return null;
        }
        return annotatedString.getText();
    }

    private final AccessibilityIterators$TextSegmentIterator getIteratorForGranularity(SemanticsNode semanticsNode, int i) {
        if (semanticsNode == null) {
            return null;
        }
        String iterableTextForAccessibility = getIterableTextForAccessibility(semanticsNode);
        if (iterableTextForAccessibility == null || iterableTextForAccessibility.length() == 0) {
            return null;
        }
        if (i == 1) {
            AccessibilityIterators$CharacterTextSegmentIterator.Companion companion = AccessibilityIterators$CharacterTextSegmentIterator.Companion;
            Locale locale = this.view.getContext().getResources().getConfiguration().locale;
            Intrinsics.checkNotNullExpressionValue(locale, "view.context.resources.configuration.locale");
            AccessibilityIterators$CharacterTextSegmentIterator companion2 = companion.getInstance(locale);
            companion2.initialize(iterableTextForAccessibility);
            return companion2;
        }
        if (i == 2) {
            AccessibilityIterators$WordTextSegmentIterator.Companion companion3 = AccessibilityIterators$WordTextSegmentIterator.Companion;
            Locale locale2 = this.view.getContext().getResources().getConfiguration().locale;
            Intrinsics.checkNotNullExpressionValue(locale2, "view.context.resources.configuration.locale");
            AccessibilityIterators$WordTextSegmentIterator companion4 = companion3.getInstance(locale2);
            companion4.initialize(iterableTextForAccessibility);
            return companion4;
        }
        if (i != 4) {
            if (i == 8) {
                AccessibilityIterators.ParagraphTextSegmentIterator companion5 = AccessibilityIterators.ParagraphTextSegmentIterator.Companion.getInstance();
                companion5.initialize(iterableTextForAccessibility);
                return companion5;
            }
            if (i != 16) {
                return null;
            }
        }
        SemanticsConfiguration unmergedConfig$ui_release = semanticsNode.getUnmergedConfig$ui_release();
        SemanticsActions semanticsActions = SemanticsActions.INSTANCE;
        if (!unmergedConfig$ui_release.contains(semanticsActions.getGetTextLayoutResult())) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Function1 action = ((AccessibilityAction) semanticsNode.getUnmergedConfig$ui_release().get(semanticsActions.getGetTextLayoutResult())).getAction();
        if (!Intrinsics.areEqual(action != null ? (Boolean) action.invoke(arrayList) : null, Boolean.TRUE)) {
            return null;
        }
        TextLayoutResult textLayoutResult = (TextLayoutResult) arrayList.get(0);
        if (i == 4) {
            AccessibilityIterators.LineTextSegmentIterator accessibilityIterators$LineTextSegmentIterator$Companion = AccessibilityIterators.LineTextSegmentIterator.Companion.getInstance();
            accessibilityIterators$LineTextSegmentIterator$Companion.initialize(iterableTextForAccessibility, textLayoutResult);
            return accessibilityIterators$LineTextSegmentIterator$Companion;
        }
        AccessibilityIterators$PageTextSegmentIterator companion6 = AccessibilityIterators$PageTextSegmentIterator.Companion.getInstance();
        companion6.initialize(iterableTextForAccessibility, textLayoutResult, semanticsNode);
        return companion6;
    }

    @VisibleForTesting
    public static /* synthetic */ void getPreviousSemanticsNodes$ui_release$annotations() {
    }

    private final AnnotatedString getTextForTextField(SemanticsConfiguration semanticsConfiguration) {
        return (AnnotatedString) SemanticsConfigurationKt.getOrNull(semanticsConfiguration, SemanticsProperties.INSTANCE.getEditableText());
    }

    @VisibleForTesting
    public static /* synthetic */ void getTouchExplorationStateListener$ui_release$annotations() {
    }

    private final boolean isAccessibilityFocused(int i) {
        return this.focusedVirtualViewId == i;
    }

    private final boolean isAccessibilitySelectionExtendable(SemanticsNode semanticsNode) {
        SemanticsConfiguration unmergedConfig$ui_release = semanticsNode.getUnmergedConfig$ui_release();
        SemanticsProperties semanticsProperties = SemanticsProperties.INSTANCE;
        return !unmergedConfig$ui_release.contains(semanticsProperties.getContentDescription()) && semanticsNode.getUnmergedConfig$ui_release().contains(semanticsProperties.getEditableText());
    }

    @VisibleForTesting
    public static /* synthetic */ void isEnabled$ui_release$annotations() {
    }

    private final boolean isTouchExplorationEnabled() {
        return this.accessibilityForceEnabledForTesting || (this.accessibilityManager.isEnabled() && this.accessibilityManager.isTouchExplorationEnabled());
    }

    private final void notifySubtreeAccessibilityStateChangedIfNeeded(LayoutNode layoutNode) {
        if (this.subtreeChangedLayoutNodes.add(layoutNode)) {
            this.boundsUpdateChannel.trySend-JP2dKIU(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:106:0x019e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0180 A[ADDED_TO_REGION] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:116:0x017d -> B:80:0x017e). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean performActionHelper(int r13, int r14, android.os.Bundle r15) {
        /*
            Method dump skipped, instructions count: 1608
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.performActionHelper(int, int, android.os.Bundle):boolean");
    }

    private static final boolean performActionHelper$canScroll(ScrollAxisRange scrollAxisRange, float f) {
        return (f < 0.0f && ((Number) scrollAxisRange.getValue().invoke()).floatValue() > 0.0f) || (f > 0.0f && ((Number) scrollAxisRange.getValue().invoke()).floatValue() < ((Number) scrollAxisRange.getMaxValue().invoke()).floatValue());
    }

    private static final float performActionHelper$scrollDelta(float f, float f2) {
        if (Math.signum(f) == Math.signum(f2)) {
            return Math.abs(f) < Math.abs(f2) ? f : f2;
        }
        return 0.0f;
    }

    private static final boolean populateAccessibilityNodeInfoProperties$canScrollBackward(ScrollAxisRange scrollAxisRange) {
        return (((Number) scrollAxisRange.getValue().invoke()).floatValue() > 0.0f && !scrollAxisRange.getReverseScrolling()) || (((Number) scrollAxisRange.getValue().invoke()).floatValue() < ((Number) scrollAxisRange.getMaxValue().invoke()).floatValue() && scrollAxisRange.getReverseScrolling());
    }

    private static final boolean populateAccessibilityNodeInfoProperties$canScrollForward(ScrollAxisRange scrollAxisRange) {
        return (((Number) scrollAxisRange.getValue().invoke()).floatValue() < ((Number) scrollAxisRange.getMaxValue().invoke()).floatValue() && !scrollAxisRange.getReverseScrolling()) || (((Number) scrollAxisRange.getValue().invoke()).floatValue() > 0.0f && scrollAxisRange.getReverseScrolling());
    }

    private final boolean registerScrollingId(int i, List<ScrollObservationScope> list) {
        boolean z;
        ScrollObservationScope findById = AndroidComposeViewAccessibilityDelegateCompat_androidKt.findById(list, i);
        if (findById != null) {
            z = false;
        } else {
            findById = new ScrollObservationScope(i, this.scrollObservationScopes, (Float) null, (Float) null, (ScrollAxisRange) null, (ScrollAxisRange) null);
            z = true;
        }
        this.scrollObservationScopes.add(findById);
        return z;
    }

    private final boolean requestAccessibilityFocus(int i) {
        if (!isTouchExplorationEnabled() || isAccessibilityFocused(i)) {
            return false;
        }
        int i2 = this.focusedVirtualViewId;
        if (i2 != Integer.MIN_VALUE) {
            sendEventForVirtualView$default(this, i2, AccessibilityNodeInfoCompat.ACTION_CUT, null, null, 12, null);
        }
        this.focusedVirtualViewId = i;
        this.view.invalidate();
        sendEventForVirtualView$default(this, i, AccessibilityNodeInfoCompat.ACTION_PASTE, null, null, 12, null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void semanticsChangeChecker$lambda$32(AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat) {
        Intrinsics.checkNotNullParameter(androidComposeViewAccessibilityDelegateCompat, "this$0");
        ql3.a(androidComposeViewAccessibilityDelegateCompat.view, false, 1, (Object) null);
        androidComposeViewAccessibilityDelegateCompat.checkForSemanticsChanges();
        androidComposeViewAccessibilityDelegateCompat.checkingForSemanticsChanges = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int semanticsNodeIdToAccessibilityVirtualNodeId(int i) {
        if (i == this.view.getSemanticsOwner().getUnmergedRootSemanticsNode().getId()) {
            return -1;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean sendEvent(AccessibilityEvent accessibilityEvent) {
        if (isEnabled$ui_release()) {
            return this.view.getParent().requestSendAccessibilityEvent(this.view, accessibilityEvent);
        }
        return false;
    }

    private final boolean sendEventForVirtualView(int i, int i2, Integer num, List<String> list) {
        if (i == Integer.MIN_VALUE || !isEnabled$ui_release()) {
            return false;
        }
        AccessibilityEvent createEvent$ui_release = createEvent$ui_release(i, i2);
        if (num != null) {
            createEvent$ui_release.setContentChangeTypes(num.intValue());
        }
        if (list != null) {
            createEvent$ui_release.setContentDescription(TempListUtilsKt.fastJoinToString$default(list, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
        }
        return sendEvent(createEvent$ui_release);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ boolean sendEventForVirtualView$default(AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat, int i, int i2, Integer num, List list, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            num = null;
        }
        if ((i3 & 8) != 0) {
            list = null;
        }
        return androidComposeViewAccessibilityDelegateCompat.sendEventForVirtualView(i, i2, num, list);
    }

    private final void sendPaneChangeEvents(int i, int i2, String str) {
        AccessibilityEvent createEvent$ui_release = createEvent$ui_release(semanticsNodeIdToAccessibilityVirtualNodeId(i), 32);
        createEvent$ui_release.setContentChangeTypes(i2);
        if (str != null) {
            createEvent$ui_release.getText().add(str);
        }
        sendEvent(createEvent$ui_release);
    }

    private final void sendPendingTextTraversedAtGranularityEvent(int i) {
        PendingTextTraversedEvent pendingTextTraversedEvent = this.pendingTextTraversedEvent;
        if (pendingTextTraversedEvent != null) {
            if (i != pendingTextTraversedEvent.getNode().getId()) {
                return;
            }
            if (SystemClock.uptimeMillis() - pendingTextTraversedEvent.getTraverseTime() <= 1000) {
                AccessibilityEvent createEvent$ui_release = createEvent$ui_release(semanticsNodeIdToAccessibilityVirtualNodeId(pendingTextTraversedEvent.getNode().getId()), AccessibilityNodeInfoCompat.ACTION_SET_SELECTION);
                createEvent$ui_release.setFromIndex(pendingTextTraversedEvent.getFromIndex());
                createEvent$ui_release.setToIndex(pendingTextTraversedEvent.getToIndex());
                createEvent$ui_release.setAction(pendingTextTraversedEvent.getAction());
                createEvent$ui_release.setMovementGranularity(pendingTextTraversedEvent.getGranularity());
                createEvent$ui_release.getText().add(getIterableTextForAccessibility(pendingTextTraversedEvent.getNode()));
                sendEvent(createEvent$ui_release);
            }
        }
        this.pendingTextTraversedEvent = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendScrollEventIfNeeded(ScrollObservationScope scrollObservationScope) {
        if (scrollObservationScope.isValid()) {
            this.view.getSnapshotObserver().observeReads$ui_release(scrollObservationScope, this.sendScrollEventIfNeededLambda, new sendScrollEventIfNeeded.1(scrollObservationScope, this));
        }
    }

    private final void sendSemanticsStructureChangeEvents(SemanticsNode semanticsNode, SemanticsNodeCopy semanticsNodeCopy) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        List replacedChildren$ui_release = semanticsNode.getReplacedChildren$ui_release();
        int size = replacedChildren$ui_release.size();
        for (int i = 0; i < size; i++) {
            SemanticsNode semanticsNode2 = (SemanticsNode) replacedChildren$ui_release.get(i);
            if (getCurrentSemanticsNodes().containsKey(Integer.valueOf(semanticsNode2.getId()))) {
                if (!semanticsNodeCopy.getChildren().contains(Integer.valueOf(semanticsNode2.getId()))) {
                    notifySubtreeAccessibilityStateChangedIfNeeded(semanticsNode.getLayoutNode$ui_release());
                    return;
                }
                linkedHashSet.add(Integer.valueOf(semanticsNode2.getId()));
            }
        }
        Iterator it = semanticsNodeCopy.getChildren().iterator();
        while (it.hasNext()) {
            if (!linkedHashSet.contains(Integer.valueOf(((Number) it.next()).intValue()))) {
                notifySubtreeAccessibilityStateChangedIfNeeded(semanticsNode.getLayoutNode$ui_release());
                return;
            }
        }
        List replacedChildren$ui_release2 = semanticsNode.getReplacedChildren$ui_release();
        int size2 = replacedChildren$ui_release2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            SemanticsNode semanticsNode3 = (SemanticsNode) replacedChildren$ui_release2.get(i2);
            if (getCurrentSemanticsNodes().containsKey(Integer.valueOf(semanticsNode3.getId()))) {
                SemanticsNodeCopy semanticsNodeCopy2 = this.previousSemanticsNodes.get(Integer.valueOf(semanticsNode3.getId()));
                Intrinsics.checkNotNull(semanticsNodeCopy2);
                sendSemanticsStructureChangeEvents(semanticsNode3, semanticsNodeCopy2);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0039, code lost:
    
        r8 = androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat_androidKt.findClosestParentNode(r8, androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$1.INSTANCE);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void sendSubtreeChangeAccessibilityEvents(androidx.compose.ui.node.LayoutNode r8, androidx.collection.ArraySet<java.lang.Integer> r9) {
        /*
            r7 = this;
            boolean r0 = r8.isAttached()
            if (r0 != 0) goto L7
            return
        L7:
            androidx.compose.ui.platform.AndroidComposeView r0 = r7.view
            androidx.compose.ui.platform.AndroidViewsHandler r0 = r0.getAndroidViewsHandler$ui_release()
            java.util.HashMap r0 = r0.getLayoutNodeToHolder()
            boolean r0 = r0.containsKey(r8)
            if (r0 == 0) goto L18
            return
        L18:
            androidx.compose.ui.node.SemanticsModifierNode r0 = androidx.compose.ui.semantics.SemanticsNodeKt.getOuterSemantics(r8)
            if (r0 != 0) goto L2f
            androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$semanticsWrapper$1 r0 = androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.sendSubtreeChangeAccessibilityEvents.semanticsWrapper.1.INSTANCE
            androidx.compose.ui.node.LayoutNode r0 = androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat_androidKt.access$findClosestParentNode(r8, r0)
            if (r0 == 0) goto L2b
            androidx.compose.ui.node.SemanticsModifierNode r0 = androidx.compose.ui.semantics.SemanticsNodeKt.getOuterSemantics(r0)
            goto L2c
        L2b:
            r0 = 0
        L2c:
            if (r0 != 0) goto L2f
            return
        L2f:
            androidx.compose.ui.semantics.SemanticsConfiguration r1 = androidx.compose.ui.node.SemanticsModifierNodeKt.collapsedSemanticsConfiguration(r0)
            boolean r1 = r1.isMergingSemanticsOfDescendants()
            if (r1 != 0) goto L48
            androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$1 r1 = new kotlin.jvm.functions.Function1<androidx.compose.ui.node.LayoutNode, java.lang.Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$1
                static {
                    /*
                        androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$1 r0 = new androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$1
                        r0.<init>()
                        
                        // error: 0x0005: SPUT 
  (r0 I:androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$1)
 androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$1.INSTANCE androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$1
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$1.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 1
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$1.<init>():void");
                }

                public /* bridge */ /* synthetic */ java.lang.Object invoke(java.lang.Object r1) {
                    /*
                        r0 = this;
                        androidx.compose.ui.node.LayoutNode r1 = (androidx.compose.ui.node.LayoutNode) r1
                        java.lang.Boolean r1 = r0.invoke(r1)
                        return r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$1.invoke(java.lang.Object):java.lang.Object");
                }

                @org.jetbrains.annotations.NotNull
                public final java.lang.Boolean invoke(@org.jetbrains.annotations.NotNull androidx.compose.ui.node.LayoutNode r3) {
                    /*
                        r2 = this;
                        java.lang.String r0 = "it"
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                        androidx.compose.ui.node.SemanticsModifierNode r3 = androidx.compose.ui.semantics.SemanticsNodeKt.getOuterSemantics(r3)
                        r0 = 1
                        r1 = 0
                        if (r3 == 0) goto L1a
                        androidx.compose.ui.semantics.SemanticsConfiguration r3 = androidx.compose.ui.node.SemanticsModifierNodeKt.collapsedSemanticsConfiguration(r3)
                        if (r3 == 0) goto L1a
                        boolean r3 = r3.isMergingSemanticsOfDescendants()
                        if (r3 != r0) goto L1a
                        goto L1b
                    L1a:
                        r0 = 0
                    L1b:
                        java.lang.Boolean r3 = java.lang.Boolean.valueOf(r0)
                        return r3
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$1.invoke(androidx.compose.ui.node.LayoutNode):java.lang.Boolean");
                }
            }
            androidx.compose.ui.node.LayoutNode r8 = androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat_androidKt.access$findClosestParentNode(r8, r1)
            if (r8 == 0) goto L48
            androidx.compose.ui.node.SemanticsModifierNode r8 = androidx.compose.ui.semantics.SemanticsNodeKt.getOuterSemantics(r8)
            if (r8 == 0) goto L48
            r0 = r8
        L48:
            androidx.compose.ui.node.LayoutNode r8 = androidx.compose.ui.node.DelegatableNodeKt.requireLayoutNode(r0)
            int r8 = r8.getSemanticsId()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r8)
            boolean r9 = r9.add(r0)
            if (r9 != 0) goto L5b
            return
        L5b:
            int r1 = r7.semanticsNodeIdToAccessibilityVirtualNodeId(r8)
            r2 = 2048(0x800, float:2.87E-42)
            r8 = 1
            java.lang.Integer r3 = java.lang.Integer.valueOf(r8)
            r4 = 0
            r5 = 8
            r6 = 0
            r0 = r7
            sendEventForVirtualView$default(r0, r1, r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.sendSubtreeChangeAccessibilityEvents(androidx.compose.ui.node.LayoutNode, androidx.collection.ArraySet):void");
    }

    private final boolean setAccessibilitySelection(SemanticsNode semanticsNode, int i, int i2, boolean z) {
        String iterableTextForAccessibility;
        boolean enabled;
        SemanticsConfiguration unmergedConfig$ui_release = semanticsNode.getUnmergedConfig$ui_release();
        SemanticsActions semanticsActions = SemanticsActions.INSTANCE;
        if (unmergedConfig$ui_release.contains(semanticsActions.getSetSelection())) {
            enabled = AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode);
            if (enabled) {
                Function3 action = ((AccessibilityAction) semanticsNode.getUnmergedConfig$ui_release().get(semanticsActions.getSetSelection())).getAction();
                if (action != null) {
                    return ((Boolean) action.invoke(Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z))).booleanValue();
                }
                return false;
            }
        }
        if ((i == i2 && i2 == this.accessibilityCursorPosition) || (iterableTextForAccessibility = getIterableTextForAccessibility(semanticsNode)) == null) {
            return false;
        }
        if (i < 0 || i != i2 || i2 > iterableTextForAccessibility.length()) {
            i = -1;
        }
        this.accessibilityCursorPosition = i;
        boolean z2 = iterableTextForAccessibility.length() > 0;
        sendEvent(createTextSelectionChangedEvent(semanticsNodeIdToAccessibilityVirtualNodeId(semanticsNode.getId()), z2 ? Integer.valueOf(this.accessibilityCursorPosition) : null, z2 ? Integer.valueOf(this.accessibilityCursorPosition) : null, z2 ? Integer.valueOf(iterableTextForAccessibility.length()) : null, iterableTextForAccessibility));
        sendPendingTextTraversedAtGranularityEvent(semanticsNode.getId());
        return true;
    }

    private final void setContentInvalid(SemanticsNode semanticsNode, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        SemanticsConfiguration unmergedConfig$ui_release = semanticsNode.getUnmergedConfig$ui_release();
        SemanticsProperties semanticsProperties = SemanticsProperties.INSTANCE;
        if (unmergedConfig$ui_release.contains(semanticsProperties.getError())) {
            accessibilityNodeInfoCompat.setContentInvalid(true);
            accessibilityNodeInfoCompat.setError((CharSequence) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), semanticsProperties.getError()));
        }
    }

    private final void setText(SemanticsNode semanticsNode, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        AnnotatedString annotatedString;
        FontFamily.Resolver fontFamilyResolver = this.view.getFontFamilyResolver();
        AnnotatedString textForTextField = getTextForTextField(semanticsNode.getUnmergedConfig$ui_release());
        SpannableString spannableString = null;
        SpannableString spannableString2 = (SpannableString) trimToSize(textForTextField != null ? AndroidAccessibilitySpannableString_androidKt.toAccessibilitySpannableString(textForTextField, this.view.getDensity(), fontFamilyResolver) : null, ParcelSafeTextLength);
        List list = (List) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getText());
        if (list != null && (annotatedString = (AnnotatedString) CollectionsKt.firstOrNull(list)) != null) {
            spannableString = AndroidAccessibilitySpannableString_androidKt.toAccessibilitySpannableString(annotatedString, this.view.getDensity(), fontFamilyResolver);
        }
        SpannableString spannableString3 = (SpannableString) trimToSize(spannableString, ParcelSafeTextLength);
        if (spannableString2 == null) {
            spannableString2 = spannableString3;
        }
        accessibilityNodeInfoCompat.setText(spannableString2);
    }

    private final void setTraversalValues() {
        SemanticsNode semanticsNode;
        List replacedChildrenSortedByBounds$ui_release;
        this.idToBeforeMap.clear();
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = new ArrayList();
        SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = getCurrentSemanticsNodes().get(-1);
        if (semanticsNodeWithAdjustedBounds != null && (semanticsNode = semanticsNodeWithAdjustedBounds.getSemanticsNode()) != null && (replacedChildrenSortedByBounds$ui_release = semanticsNode.getReplacedChildrenSortedByBounds$ui_release()) != null) {
            int size = replacedChildrenSortedByBounds$ui_release.size();
            for (int i = 0; i < size; i++) {
                setTraversalValues$depthFirstSearch(objectRef, (SemanticsNode) replacedChildrenSortedByBounds$ui_release.get(i));
            }
        }
        int lastIndex = CollectionsKt.getLastIndex((List) objectRef.element);
        int i2 = 1;
        if (1 > lastIndex) {
            return;
        }
        while (true) {
            this.idToBeforeMap.put(Integer.valueOf(((Number) ((Pair) ((List) objectRef.element).get(i2 - 1)).getFirst()).intValue()), Integer.valueOf(((Number) ((Pair) ((List) objectRef.element).get(i2)).getFirst()).intValue()));
            if (i2 == lastIndex) {
                return;
            } else {
                i2++;
            }
        }
    }

    private static final void setTraversalValues$depthFirstSearch(Ref.ObjectRef<List<Pair<Integer, androidx.compose.ui.geometry.Rect>>> objectRef, SemanticsNode semanticsNode) {
        LayoutNode layoutNode$ui_release;
        NodeCoordinator innerCoordinator$ui_release;
        SemanticsNode parent = semanticsNode.getParent();
        if (((parent == null || (layoutNode$ui_release = parent.getLayoutNode$ui_release()) == null || (innerCoordinator$ui_release = layoutNode$ui_release.getInnerCoordinator$ui_release()) == null || !innerCoordinator$ui_release.isAttached()) ? false : true) && semanticsNode.getLayoutNode$ui_release().getInnerCoordinator$ui_release().isAttached()) {
            ((List) objectRef.element).add(new Pair(Integer.valueOf(semanticsNode.getId()), LayoutCoordinatesKt.boundsInWindow(semanticsNode.getLayoutNode$ui_release().getCoordinates())));
        }
        List replacedChildrenSortedByBounds$ui_release = semanticsNode.getReplacedChildrenSortedByBounds$ui_release();
        int size = replacedChildrenSortedByBounds$ui_release.size();
        for (int i = 0; i < size; i++) {
            setTraversalValues$depthFirstSearch(objectRef, (SemanticsNode) replacedChildrenSortedByBounds$ui_release.get(i));
        }
    }

    private final RectF toScreenCoords(SemanticsNode semanticsNode, androidx.compose.ui.geometry.Rect rect) {
        if (semanticsNode == null) {
            return null;
        }
        androidx.compose.ui.geometry.Rect m871translatek4lQ0M = rect.m871translatek4lQ0M(semanticsNode.getPositionInRoot-F1C5BW0());
        androidx.compose.ui.geometry.Rect boundsInRoot = semanticsNode.getBoundsInRoot();
        androidx.compose.ui.geometry.Rect intersect = m871translatek4lQ0M.overlaps(boundsInRoot) ? m871translatek4lQ0M.intersect(boundsInRoot) : null;
        if (intersect == null) {
            return null;
        }
        long mo1488localToScreenMKHz9U = this.view.mo1488localToScreenMKHz9U(OffsetKt.Offset(intersect.getLeft(), intersect.getTop()));
        long mo1488localToScreenMKHz9U2 = this.view.mo1488localToScreenMKHz9U(OffsetKt.Offset(intersect.getRight(), intersect.getBottom()));
        return new RectF(Offset.m848getXimpl(mo1488localToScreenMKHz9U), Offset.m849getYimpl(mo1488localToScreenMKHz9U), Offset.m848getXimpl(mo1488localToScreenMKHz9U2), Offset.m849getYimpl(mo1488localToScreenMKHz9U2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void touchExplorationStateListener$lambda$1(AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat, boolean z) {
        Intrinsics.checkNotNullParameter(androidComposeViewAccessibilityDelegateCompat, "this$0");
        androidComposeViewAccessibilityDelegateCompat.enabledServices = androidComposeViewAccessibilityDelegateCompat.accessibilityManager.getEnabledAccessibilityServiceList(-1);
    }

    private final boolean traverseAtGranularity(SemanticsNode semanticsNode, int i, boolean z, boolean z2) {
        AccessibilityIterators$TextSegmentIterator iteratorForGranularity;
        int i2;
        int i3;
        int id = semanticsNode.getId();
        Integer num = this.previousTraversedNode;
        if (num == null || id != num.intValue()) {
            this.accessibilityCursorPosition = -1;
            this.previousTraversedNode = Integer.valueOf(semanticsNode.getId());
        }
        String iterableTextForAccessibility = getIterableTextForAccessibility(semanticsNode);
        if ((iterableTextForAccessibility == null || iterableTextForAccessibility.length() == 0) || (iteratorForGranularity = getIteratorForGranularity(semanticsNode, i)) == null) {
            return false;
        }
        int accessibilitySelectionEnd = getAccessibilitySelectionEnd(semanticsNode);
        if (accessibilitySelectionEnd == -1) {
            accessibilitySelectionEnd = z ? 0 : iterableTextForAccessibility.length();
        }
        int[] following = z ? iteratorForGranularity.following(accessibilitySelectionEnd) : iteratorForGranularity.preceding(accessibilitySelectionEnd);
        if (following == null) {
            return false;
        }
        int i4 = following[0];
        int i5 = following[1];
        if (z2 && isAccessibilitySelectionExtendable(semanticsNode)) {
            i2 = getAccessibilitySelectionStart(semanticsNode);
            if (i2 == -1) {
                i2 = z ? i4 : i5;
            }
            i3 = z ? i5 : i4;
        } else {
            i2 = z ? i5 : i4;
            i3 = i2;
        }
        this.pendingTextTraversedEvent = new PendingTextTraversedEvent(semanticsNode, z ? 256 : 512, i, i4, i5, SystemClock.uptimeMillis());
        setAccessibilitySelection(semanticsNode, i2, i3, true);
        return true;
    }

    private final <T extends CharSequence> T trimToSize(T t, @IntRange(from = 1) int i) {
        boolean z = true;
        if (!(i > 0)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (t != null && t.length() != 0) {
            z = false;
        }
        if (z || t.length() <= i) {
            return t;
        }
        int i2 = i - 1;
        if (Character.isHighSurrogate(t.charAt(i2)) && Character.isLowSurrogate(t.charAt(i))) {
            i = i2;
        }
        T t2 = (T) t.subSequence(0, i);
        Intrinsics.checkNotNull(t2, "null cannot be cast to non-null type T of androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.trimToSize");
        return t2;
    }

    private final void updateHoveredVirtualView(int i) {
        int i2 = this.hoveredVirtualViewId;
        if (i2 == i) {
            return;
        }
        this.hoveredVirtualViewId = i;
        sendEventForVirtualView$default(this, i, 128, null, null, 12, null);
        sendEventForVirtualView$default(this, i2, 256, null, null, 12, null);
    }

    private final void updateSemanticsNodesCopyAndPanes() {
        boolean hasPaneTitle;
        SemanticsConfiguration unmergedConfig;
        boolean hasPaneTitle2;
        Iterator<Integer> it = this.paneDisplayed.iterator();
        while (it.hasNext()) {
            Integer next = it.next();
            SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = getCurrentSemanticsNodes().get(next);
            String str = null;
            SemanticsNode semanticsNode = semanticsNodeWithAdjustedBounds != null ? semanticsNodeWithAdjustedBounds.getSemanticsNode() : null;
            if (semanticsNode != null) {
                hasPaneTitle2 = AndroidComposeViewAccessibilityDelegateCompat_androidKt.hasPaneTitle(semanticsNode);
                if (!hasPaneTitle2) {
                }
            }
            this.paneDisplayed.remove(next);
            Intrinsics.checkNotNullExpressionValue(next, "id");
            int intValue = next.intValue();
            SemanticsNodeCopy semanticsNodeCopy = this.previousSemanticsNodes.get(next);
            if (semanticsNodeCopy != null && (unmergedConfig = semanticsNodeCopy.getUnmergedConfig()) != null) {
                str = (String) SemanticsConfigurationKt.getOrNull(unmergedConfig, SemanticsProperties.INSTANCE.getPaneTitle());
            }
            sendPaneChangeEvents(intValue, 32, str);
        }
        this.previousSemanticsNodes.clear();
        for (Map.Entry<Integer, SemanticsNodeWithAdjustedBounds> entry : getCurrentSemanticsNodes().entrySet()) {
            hasPaneTitle = AndroidComposeViewAccessibilityDelegateCompat_androidKt.hasPaneTitle(entry.getValue().getSemanticsNode());
            if (hasPaneTitle && this.paneDisplayed.add(entry.getKey())) {
                sendPaneChangeEvents(entry.getKey().intValue(), 16, (String) entry.getValue().getSemanticsNode().getUnmergedConfig$ui_release().get(SemanticsProperties.INSTANCE.getPaneTitle()));
            }
            this.previousSemanticsNodes.put(entry.getKey(), new SemanticsNodeCopy(entry.getValue().getSemanticsNode(), getCurrentSemanticsNodes()));
        }
        this.previousSemanticsRoot = new SemanticsNodeCopy(this.view.getSemanticsOwner().getUnmergedRootSemanticsNode(), getCurrentSemanticsNodes());
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0071 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x007d A[Catch: all -> 0x0051, TryCatch #0 {all -> 0x0051, blocks: (B:12:0x0034, B:14:0x0063, B:19:0x0075, B:21:0x007d, B:23:0x0086, B:25:0x008f, B:27:0x00a0, B:29:0x00a7, B:30:0x00b0, B:39:0x004d), top: B:7:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x00c3 -> B:13:0x0037). Please report as a decompilation issue!!! */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object boundsUpdatesEventLoop(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            Method dump skipped, instructions count: 214
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.boundsUpdatesEventLoop(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* renamed from: canScroll-0AR0LA0$ui_release, reason: not valid java name */
    public final boolean m1720canScroll0AR0LA0$ui_release(boolean z, int i, long j) {
        return m1721canScrollmoWRBKg$ui_release(getCurrentSemanticsNodes().values(), z, i, j);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00b0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[LOOP:0: B:11:0x0038->B:21:?, LOOP_END, SYNTHETIC] */
    @androidx.annotation.VisibleForTesting(otherwise = 2)
    /* renamed from: canScroll-moWRBKg$ui_release, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean m1721canScrollmoWRBKg$ui_release(@org.jetbrains.annotations.NotNull java.util.Collection<androidx.compose.ui.platform.SemanticsNodeWithAdjustedBounds> r6, boolean r7, int r8, long r9) {
        /*
            r5 = this;
            java.lang.String r0 = "currentSemanticsNodes"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            androidx.compose.ui.geometry.Offset$Companion r0 = androidx.compose.ui.geometry.Offset.Companion
            long r0 = r0.getUnspecified-F1C5BW0()
            boolean r0 = androidx.compose.ui.geometry.Offset.m845equalsimpl0(r9, r0)
            r1 = 0
            if (r0 != 0) goto Lb8
            boolean r0 = androidx.compose.ui.geometry.Offset.m851isValidimpl(r9)
            if (r0 != 0) goto L1a
            goto Lb8
        L1a:
            r0 = 1
            if (r7 != r0) goto L24
            androidx.compose.ui.semantics.SemanticsProperties r7 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r7 = r7.getVerticalScrollAxisRange()
            goto L2c
        L24:
            if (r7 != 0) goto Lb2
            androidx.compose.ui.semantics.SemanticsProperties r7 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r7 = r7.getHorizontalScrollAxisRange()
        L2c:
            boolean r2 = r6.isEmpty()
            if (r2 == 0) goto L34
            goto Lb1
        L34:
            java.util.Iterator r6 = r6.iterator()
        L38:
            boolean r2 = r6.hasNext()
            if (r2 == 0) goto Lb1
            java.lang.Object r2 = r6.next()
            androidx.compose.ui.platform.SemanticsNodeWithAdjustedBounds r2 = (androidx.compose.ui.platform.SemanticsNodeWithAdjustedBounds) r2
            android.graphics.Rect r3 = r2.getAdjustedBounds()
            androidx.compose.ui.geometry.Rect r3 = androidx.compose.ui.graphics.RectHelper_androidKt.toComposeRect(r3)
            boolean r3 = r3.m860containsk4lQ0M(r9)
            if (r3 != 0) goto L54
        L52:
            r2 = 0
            goto Lae
        L54:
            androidx.compose.ui.semantics.SemanticsNode r2 = r2.getSemanticsNode()
            androidx.compose.ui.semantics.SemanticsConfiguration r2 = r2.getConfig()
            java.lang.Object r2 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r2, r7)
            androidx.compose.ui.semantics.ScrollAxisRange r2 = (androidx.compose.ui.semantics.ScrollAxisRange) r2
            if (r2 != 0) goto L65
            goto L52
        L65:
            boolean r3 = r2.getReverseScrolling()
            if (r3 == 0) goto L6d
            int r3 = -r8
            goto L6e
        L6d:
            r3 = r8
        L6e:
            if (r8 != 0) goto L77
            boolean r4 = r2.getReverseScrolling()
            if (r4 == 0) goto L77
            r3 = -1
        L77:
            if (r3 >= 0) goto L8d
            kotlin.jvm.functions.Function0 r2 = r2.getValue()
            java.lang.Object r2 = r2.invoke()
            java.lang.Number r2 = (java.lang.Number) r2
            float r2 = r2.floatValue()
            r3 = 0
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 <= 0) goto L52
            goto Lad
        L8d:
            kotlin.jvm.functions.Function0 r3 = r2.getValue()
            java.lang.Object r3 = r3.invoke()
            java.lang.Number r3 = (java.lang.Number) r3
            float r3 = r3.floatValue()
            kotlin.jvm.functions.Function0 r2 = r2.getMaxValue()
            java.lang.Object r2 = r2.invoke()
            java.lang.Number r2 = (java.lang.Number) r2
            float r2 = r2.floatValue()
            int r2 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r2 >= 0) goto L52
        Lad:
            r2 = 1
        Lae:
            if (r2 == 0) goto L38
            r1 = 1
        Lb1:
            return r1
        Lb2:
            kotlin.NoWhenBranchMatchedException r6 = new kotlin.NoWhenBranchMatchedException
            r6.<init>()
            throw r6
        Lb8:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.m1721canScrollmoWRBKg$ui_release(java.util.Collection, boolean, int, long):boolean");
    }

    @VisibleForTesting
    @NotNull
    public final AccessibilityEvent createEvent$ui_release(int i, int i2) {
        boolean isPassword;
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i2);
        Intrinsics.checkNotNullExpressionValue(obtain, "obtain(eventType)");
        obtain.setEnabled(true);
        obtain.setClassName(ClassName);
        obtain.setPackageName(this.view.getContext().getPackageName());
        obtain.setSource(this.view, i);
        SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = getCurrentSemanticsNodes().get(Integer.valueOf(i));
        if (semanticsNodeWithAdjustedBounds != null) {
            isPassword = AndroidComposeViewAccessibilityDelegateCompat_androidKt.isPassword(semanticsNodeWithAdjustedBounds.getSemanticsNode());
            obtain.setPassword(isPassword);
        }
        return obtain;
    }

    public final boolean dispatchHoverEvent(@NotNull MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, NotificationCompat.CATEGORY_EVENT);
        if (!isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 7 || action == 9) {
            int hitTestSemanticsAt$ui_release = hitTestSemanticsAt$ui_release(motionEvent.getX(), motionEvent.getY());
            boolean dispatchGenericMotionEvent = this.view.getAndroidViewsHandler$ui_release().dispatchGenericMotionEvent(motionEvent);
            updateHoveredVirtualView(hitTestSemanticsAt$ui_release);
            if (hitTestSemanticsAt$ui_release == Integer.MIN_VALUE) {
                return dispatchGenericMotionEvent;
            }
            return true;
        }
        if (action != 10) {
            return false;
        }
        if (this.hoveredVirtualViewId == Integer.MIN_VALUE) {
            return this.view.getAndroidViewsHandler$ui_release().dispatchGenericMotionEvent(motionEvent);
        }
        updateHoveredVirtualView(Integer.MIN_VALUE);
        return true;
    }

    public final boolean getAccessibilityForceEnabledForTesting$ui_release() {
        return this.accessibilityForceEnabledForTesting;
    }

    @NotNull
    public final AccessibilityManager getAccessibilityManager$ui_release() {
        return this.accessibilityManager;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    @NotNull
    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "host");
        return this.nodeProvider;
    }

    @NotNull
    public final AccessibilityManager.AccessibilityStateChangeListener getEnabledStateListener$ui_release() {
        return this.enabledStateListener;
    }

    public final int getHoveredVirtualViewId$ui_release() {
        return this.hoveredVirtualViewId;
    }

    @NotNull
    public final Map<Integer, SemanticsNodeCopy> getPreviousSemanticsNodes$ui_release() {
        return this.previousSemanticsNodes;
    }

    @NotNull
    public final AccessibilityManager.TouchExplorationStateChangeListener getTouchExplorationStateListener$ui_release() {
        return this.touchExplorationStateListener;
    }

    @NotNull
    public final AndroidComposeView getView() {
        return this.view;
    }

    @VisibleForTesting
    public final int hitTestSemanticsAt$ui_release(float f, float f2) {
        LayoutNode requireLayoutNode;
        SemanticsModifierNode semanticsModifierNode = null;
        ql3.a(this.view, false, 1, (Object) null);
        HitTestResult hitTestResult = new HitTestResult();
        LayoutNode.hitTestSemantics-M_7yMNQ$ui_release$default(this.view.getRoot(), OffsetKt.Offset(f, f2), hitTestResult, false, false, 12, (Object) null);
        SemanticsModifierNode semanticsModifierNode2 = (SemanticsModifierNode) CollectionsKt.lastOrNull(hitTestResult);
        if (semanticsModifierNode2 != null && (requireLayoutNode = DelegatableNodeKt.requireLayoutNode(semanticsModifierNode2)) != null) {
            semanticsModifierNode = SemanticsNodeKt.getOuterSemantics(requireLayoutNode);
        }
        if (semanticsModifierNode == null) {
            return Integer.MIN_VALUE;
        }
        SemanticsNode semanticsNode = new SemanticsNode(semanticsModifierNode, false, (LayoutNode) null, 4, (DefaultConstructorMarker) null);
        NodeCoordinator findCoordinatorToGetBounds$ui_release = semanticsNode.findCoordinatorToGetBounds$ui_release();
        if (semanticsNode.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getInvisibleToUser()) || findCoordinatorToGetBounds$ui_release.isTransparent()) {
            return Integer.MIN_VALUE;
        }
        LayoutNode requireLayoutNode2 = DelegatableNodeKt.requireLayoutNode(semanticsModifierNode);
        if (((AndroidViewHolder) this.view.getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().get(requireLayoutNode2)) == null) {
            return semanticsNodeIdToAccessibilityVirtualNodeId(requireLayoutNode2.getSemanticsId());
        }
        return Integer.MIN_VALUE;
    }

    public final boolean isEnabled$ui_release() {
        if (this.accessibilityForceEnabledForTesting) {
            return true;
        }
        if (this.accessibilityManager.isEnabled()) {
            Intrinsics.checkNotNullExpressionValue(this.enabledServices, "enabledServices");
            if (!r0.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public final void onLayoutChange$ui_release(@NotNull LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        this.currentSemanticsNodesInvalidated = true;
        if (isEnabled$ui_release()) {
            notifySubtreeAccessibilityStateChangedIfNeeded(layoutNode);
        }
    }

    public final void onSemanticsChange$ui_release() {
        this.currentSemanticsNodesInvalidated = true;
        if (!isEnabled$ui_release() || this.checkingForSemanticsChanges) {
            return;
        }
        this.checkingForSemanticsChanges = true;
        this.handler.post(this.semanticsChangeChecker);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x02ed  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0330  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x035f  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0387  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x039a  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x03c6  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x03fe  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x043e  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0467  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x047d  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0502  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x057e  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x05de  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x0746  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x0775  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x078d  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x0796  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x07e0  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x07f8  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x0801  */
    /* JADX WARN: Removed duplicated region for block: B:315:0x0825  */
    /* JADX WARN: Removed duplicated region for block: B:318:0x083f  */
    /* JADX WARN: Removed duplicated region for block: B:373:0x0a1b  */
    /* JADX WARN: Removed duplicated region for block: B:378:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:383:0x039f  */
    /* JADX WARN: Removed duplicated region for block: B:385:0x0394  */
    /* JADX WARN: Removed duplicated region for block: B:388:0x02d2  */
    /* JADX WARN: Removed duplicated region for block: B:390:0x02d9  */
    /* JADX WARN: Removed duplicated region for block: B:391:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x025e  */
    @androidx.annotation.VisibleForTesting
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void populateAccessibilityNodeInfoProperties(int r19, @org.jetbrains.annotations.NotNull androidx.core.view.accessibility.AccessibilityNodeInfoCompat r20, @org.jetbrains.annotations.NotNull androidx.compose.ui.semantics.SemanticsNode r21) {
        /*
            Method dump skipped, instructions count: 2626
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.populateAccessibilityNodeInfoProperties(int, androidx.core.view.accessibility.AccessibilityNodeInfoCompat, androidx.compose.ui.semantics.SemanticsNode):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:124:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0301 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0345 A[ADDED_TO_REGION] */
    @androidx.annotation.VisibleForTesting
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void sendSemanticsPropertyChangeEvents$ui_release(@org.jetbrains.annotations.NotNull java.util.Map<java.lang.Integer, androidx.compose.ui.platform.SemanticsNodeWithAdjustedBounds> r29) {
        /*
            Method dump skipped, instructions count: 1354
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.sendSemanticsPropertyChangeEvents$ui_release(java.util.Map):void");
    }

    public final void setAccessibilityForceEnabledForTesting$ui_release(boolean z) {
        this.accessibilityForceEnabledForTesting = z;
    }

    public final void setHoveredVirtualViewId$ui_release(int i) {
        this.hoveredVirtualViewId = i;
    }

    public final void setPreviousSemanticsNodes$ui_release(@NotNull Map<Integer, SemanticsNodeCopy> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.previousSemanticsNodes = map;
    }
}
