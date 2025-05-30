package androidx.compose.ui.semantics;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class SemanticsActions {
    public static final int $stable = 0;

    @NotNull
    private static final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> Collapse;

    @NotNull
    private static final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> CopyText;

    @NotNull
    private static final SemanticsPropertyKey<List<CustomAccessibilityAction>> CustomActions;

    @NotNull
    private static final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> CutText;

    @NotNull
    private static final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> Dismiss;

    @NotNull
    private static final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> Expand;

    @NotNull
    private static final SemanticsPropertyKey<AccessibilityAction<Function1<List<TextLayoutResult>, Boolean>>> GetTextLayoutResult;

    @NotNull
    public static final SemanticsActions INSTANCE = new SemanticsActions();

    @NotNull
    private static final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> OnClick;

    @NotNull
    private static final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> OnLongClick;

    @NotNull
    private static final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> PageDown;

    @NotNull
    private static final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> PageLeft;

    @NotNull
    private static final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> PageRight;

    @NotNull
    private static final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> PageUp;

    @NotNull
    private static final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> PasteText;

    @NotNull
    private static final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> RequestFocus;

    @NotNull
    private static final SemanticsPropertyKey<AccessibilityAction<Function2<Float, Float, Boolean>>> ScrollBy;

    @NotNull
    private static final SemanticsPropertyKey<AccessibilityAction<Function1<Integer, Boolean>>> ScrollToIndex;

    @NotNull
    private static final SemanticsPropertyKey<AccessibilityAction<Function1<Float, Boolean>>> SetProgress;

    @NotNull
    private static final SemanticsPropertyKey<AccessibilityAction<Function3<Integer, Integer, Boolean, Boolean>>> SetSelection;

    @NotNull
    private static final SemanticsPropertyKey<AccessibilityAction<Function1<AnnotatedString, Boolean>>> SetText;

    static {
        SemanticsPropertiesKt.ActionPropertyKey.1 r1 = SemanticsPropertiesKt.ActionPropertyKey.1.INSTANCE;
        GetTextLayoutResult = new SemanticsPropertyKey<>("GetTextLayoutResult", r1);
        OnClick = new SemanticsPropertyKey<>("OnClick", r1);
        OnLongClick = new SemanticsPropertyKey<>("OnLongClick", r1);
        ScrollBy = new SemanticsPropertyKey<>("ScrollBy", r1);
        ScrollToIndex = new SemanticsPropertyKey<>("ScrollToIndex", r1);
        SetProgress = new SemanticsPropertyKey<>("SetProgress", r1);
        SetSelection = new SemanticsPropertyKey<>("SetSelection", r1);
        SetText = new SemanticsPropertyKey<>("SetText", r1);
        CopyText = new SemanticsPropertyKey<>("CopyText", r1);
        CutText = new SemanticsPropertyKey<>("CutText", r1);
        PasteText = new SemanticsPropertyKey<>("PasteText", r1);
        Expand = new SemanticsPropertyKey<>("Expand", r1);
        Collapse = new SemanticsPropertyKey<>("Collapse", r1);
        Dismiss = new SemanticsPropertyKey<>("Dismiss", r1);
        RequestFocus = new SemanticsPropertyKey<>("RequestFocus", r1);
        CustomActions = new SemanticsPropertyKey<>("CustomActions", (Function2) null, 2, (DefaultConstructorMarker) null);
        PageUp = new SemanticsPropertyKey<>("PageUp", r1);
        PageLeft = new SemanticsPropertyKey<>("PageLeft", r1);
        PageDown = new SemanticsPropertyKey<>("PageDown", r1);
        PageRight = new SemanticsPropertyKey<>("PageRight", r1);
    }

    private SemanticsActions() {
    }

    @NotNull
    public final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> getCollapse() {
        return Collapse;
    }

    @NotNull
    public final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> getCopyText() {
        return CopyText;
    }

    @NotNull
    public final SemanticsPropertyKey<List<CustomAccessibilityAction>> getCustomActions() {
        return CustomActions;
    }

    @NotNull
    public final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> getCutText() {
        return CutText;
    }

    @NotNull
    public final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> getDismiss() {
        return Dismiss;
    }

    @NotNull
    public final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> getExpand() {
        return Expand;
    }

    @NotNull
    public final SemanticsPropertyKey<AccessibilityAction<Function1<List<TextLayoutResult>, Boolean>>> getGetTextLayoutResult() {
        return GetTextLayoutResult;
    }

    @NotNull
    public final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> getOnClick() {
        return OnClick;
    }

    @NotNull
    public final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> getOnLongClick() {
        return OnLongClick;
    }

    @NotNull
    public final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> getPageDown() {
        return PageDown;
    }

    @NotNull
    public final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> getPageLeft() {
        return PageLeft;
    }

    @NotNull
    public final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> getPageRight() {
        return PageRight;
    }

    @NotNull
    public final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> getPageUp() {
        return PageUp;
    }

    @NotNull
    public final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> getPasteText() {
        return PasteText;
    }

    @NotNull
    public final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> getRequestFocus() {
        return RequestFocus;
    }

    @NotNull
    public final SemanticsPropertyKey<AccessibilityAction<Function2<Float, Float, Boolean>>> getScrollBy() {
        return ScrollBy;
    }

    @NotNull
    public final SemanticsPropertyKey<AccessibilityAction<Function1<Integer, Boolean>>> getScrollToIndex() {
        return ScrollToIndex;
    }

    @NotNull
    public final SemanticsPropertyKey<AccessibilityAction<Function1<Float, Boolean>>> getSetProgress() {
        return SetProgress;
    }

    @NotNull
    public final SemanticsPropertyKey<AccessibilityAction<Function3<Integer, Integer, Boolean, Boolean>>> getSetSelection() {
        return SetSelection;
    }

    @NotNull
    public final SemanticsPropertyKey<AccessibilityAction<Function1<AnnotatedString, Boolean>>> getSetText() {
        return SetText;
    }
}
