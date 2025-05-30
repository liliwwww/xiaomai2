package androidx.compose.p004ui.node;

import android.view.KeyEvent;
import androidx.compose.p004ui.ExperimentalComposeUiApi;
import androidx.compose.p004ui.autofill.Autofill;
import androidx.compose.p004ui.autofill.AutofillTree;
import androidx.compose.p004ui.focus.FocusDirection;
import androidx.compose.p004ui.focus.FocusOwner;
import androidx.compose.p004ui.graphics.Canvas;
import androidx.compose.p004ui.hapticfeedback.HapticFeedback;
import androidx.compose.p004ui.input.InputModeManager;
import androidx.compose.p004ui.input.pointer.PointerIconService;
import androidx.compose.p004ui.modifier.ModifierLocalManager;
import androidx.compose.p004ui.platform.AccessibilityManager;
import androidx.compose.p004ui.platform.ClipboardManager;
import androidx.compose.p004ui.platform.TextToolbar;
import androidx.compose.p004ui.platform.ViewConfiguration;
import androidx.compose.p004ui.platform.WindowInfo;
import androidx.compose.p004ui.text.font.Font;
import androidx.compose.p004ui.text.font.FontFamily;
import androidx.compose.p004ui.text.input.TextInputService;
import androidx.compose.p004ui.unit.Density;
import androidx.compose.p004ui.unit.LayoutDirection;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface Owner {

    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;

    /* compiled from: Taobao */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static boolean enableExtraAssertions;

        private Companion() {
        }

        public final boolean getEnableExtraAssertions() {
            return enableExtraAssertions;
        }

        public final void setEnableExtraAssertions(boolean z) {
            enableExtraAssertions = z;
        }
    }

    /* compiled from: Taobao */
    public interface OnLayoutCompletedListener {
        void onLayoutComplete();
    }

    /* renamed from: calculateLocalPosition-MK-Hz9U, reason: not valid java name */
    long mo4446calculateLocalPositionMKHz9U(long j);

    /* renamed from: calculatePositionInWindow-MK-Hz9U, reason: not valid java name */
    long mo4447calculatePositionInWindowMKHz9U(long j);

    @NotNull
    OwnedLayer createLayer(@NotNull Function1<? super Canvas, Unit> function1, @NotNull Function0<Unit> function0);

    void forceMeasureTheSubtree(@NotNull LayoutNode layoutNode);

    @NotNull
    AccessibilityManager getAccessibilityManager();

    @ExperimentalComposeUiApi
    @Nullable
    Autofill getAutofill();

    @ExperimentalComposeUiApi
    @NotNull
    AutofillTree getAutofillTree();

    @NotNull
    ClipboardManager getClipboardManager();

    @NotNull
    Density getDensity();

    @Nullable
    /* renamed from: getFocusDirection-P8AzH3I, reason: not valid java name */
    FocusDirection mo4448getFocusDirectionP8AzH3I(@NotNull KeyEvent keyEvent);

    @NotNull
    FocusOwner getFocusOwner();

    @NotNull
    FontFamily.Resolver getFontFamilyResolver();

    @NotNull
    Font.ResourceLoader getFontLoader();

    @NotNull
    HapticFeedback getHapticFeedBack();

    @NotNull
    InputModeManager getInputModeManager();

    @NotNull
    LayoutDirection getLayoutDirection();

    long getMeasureIteration();

    @NotNull
    ModifierLocalManager getModifierLocalManager();

    @NotNull
    PointerIconService getPointerIconService();

    @NotNull
    LayoutNode getRoot();

    @NotNull
    RootForTest getRootForTest();

    @NotNull
    LayoutNodeDrawScope getSharedDrawScope();

    boolean getShowLayoutBounds();

    @NotNull
    OwnerSnapshotObserver getSnapshotObserver();

    @NotNull
    TextInputService getTextInputService();

    @NotNull
    TextToolbar getTextToolbar();

    @NotNull
    ViewConfiguration getViewConfiguration();

    @NotNull
    WindowInfo getWindowInfo();

    void measureAndLayout(boolean z);

    /* renamed from: measureAndLayout-0kLqBqw, reason: not valid java name */
    void mo4449measureAndLayout0kLqBqw(@NotNull LayoutNode layoutNode, long j);

    void onAttach(@NotNull LayoutNode layoutNode);

    void onDetach(@NotNull LayoutNode layoutNode);

    void onEndApplyChanges();

    void onLayoutChange(@NotNull LayoutNode layoutNode);

    void onRequestMeasure(@NotNull LayoutNode layoutNode, boolean z, boolean z2);

    void onRequestRelayout(@NotNull LayoutNode layoutNode, boolean z, boolean z2);

    void onSemanticsChange();

    void registerOnEndApplyChangesListener(@NotNull Function0<Unit> function0);

    void registerOnLayoutCompletedListener(@NotNull OnLayoutCompletedListener onLayoutCompletedListener);

    boolean requestFocus();

    void requestOnPositionedCallback(@NotNull LayoutNode layoutNode);

    @InternalCoreApi
    void setShowLayoutBounds(boolean z);
}
