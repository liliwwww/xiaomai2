package androidx.compose.ui.focus;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Deprecated;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class FocusOrderModifierKt {
    @NotNull
    /* renamed from: customFocusSearch--OM-vw8, reason: not valid java name */
    public static final FocusRequester m826customFocusSearchOMvw8(@NotNull FocusTargetModifierNode focusTargetModifierNode, int i, @NotNull LayoutDirection layoutDirection) {
        FocusRequester end;
        Intrinsics.checkNotNullParameter(focusTargetModifierNode, "$this$customFocusSearch");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        FocusProperties fetchFocusProperties$ui_release = focusTargetModifierNode.fetchFocusProperties$ui_release();
        FocusDirection.Companion companion = FocusDirection.Companion;
        if (FocusDirection.equals-impl0(i, companion.getNext-dhqQ-8s())) {
            return fetchFocusProperties$ui_release.getNext();
        }
        if (FocusDirection.equals-impl0(i, companion.getPrevious-dhqQ-8s())) {
            return fetchFocusProperties$ui_release.getPrevious();
        }
        if (FocusDirection.equals-impl0(i, companion.getUp-dhqQ-8s())) {
            return fetchFocusProperties$ui_release.getUp();
        }
        if (FocusDirection.equals-impl0(i, companion.getDown-dhqQ-8s())) {
            return fetchFocusProperties$ui_release.getDown();
        }
        if (FocusDirection.equals-impl0(i, companion.getLeft-dhqQ-8s())) {
            int i2 = WhenMappings.$EnumSwitchMapping$0[layoutDirection.ordinal()];
            if (i2 == 1) {
                end = fetchFocusProperties$ui_release.getStart();
            } else {
                if (i2 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                end = fetchFocusProperties$ui_release.getEnd();
            }
            if (Intrinsics.areEqual(end, FocusRequester.Companion.getDefault())) {
                end = null;
            }
            if (end == null) {
                return fetchFocusProperties$ui_release.getLeft();
            }
        } else {
            if (!FocusDirection.equals-impl0(i, companion.getRight-dhqQ-8s())) {
                if (FocusDirection.equals-impl0(i, companion.getEnter-dhqQ-8s())) {
                    return (FocusRequester) fetchFocusProperties$ui_release.getEnter().invoke(FocusDirection.box-impl(i));
                }
                if (FocusDirection.equals-impl0(i, companion.getExit-dhqQ-8s())) {
                    return (FocusRequester) fetchFocusProperties$ui_release.getExit().invoke(FocusDirection.box-impl(i));
                }
                throw new IllegalStateException("invalid FocusDirection".toString());
            }
            int i3 = WhenMappings.$EnumSwitchMapping$0[layoutDirection.ordinal()];
            if (i3 == 1) {
                end = fetchFocusProperties$ui_release.getEnd();
            } else {
                if (i3 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                end = fetchFocusProperties$ui_release.getStart();
            }
            if (Intrinsics.areEqual(end, FocusRequester.Companion.getDefault())) {
                end = null;
            }
            if (end == null) {
                return fetchFocusProperties$ui_release.getRight();
            }
        }
        return end;
    }

    @Deprecated(message = "Use focusProperties() instead", replaceWith = @ReplaceWith(expression = "this.focusProperties(focusOrderReceiver)", imports = {"androidx.compose.ui.focus.focusProperties"}))
    @NotNull
    public static final Modifier focusOrder(@NotNull Modifier modifier, @NotNull Function1<? super FocusOrder, Unit> function1) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(function1, "focusOrderReceiver");
        return FocusPropertiesKt.focusProperties(modifier, new FocusOrderToProperties(function1));
    }

    @Deprecated(message = "Use focusRequester() instead", replaceWith = @ReplaceWith(expression = "this.focusRequester(focusRequester)", imports = {"androidx.compose.ui.focus.focusRequester"}))
    @NotNull
    public static final Modifier focusOrder(@NotNull Modifier modifier, @NotNull FocusRequester focusRequester) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(focusRequester, "focusRequester");
        return FocusRequesterModifierKt.focusRequester(modifier, focusRequester);
    }

    @Deprecated(message = "Use focusProperties() and focusRequester() instead", replaceWith = @ReplaceWith(expression = "this.focusRequester(focusRequester).focusProperties(focusOrderReceiver)", imports = {"androidx.compose.ui.focus.focusProperties, androidx.compose.ui.focus.focusRequester"}))
    @NotNull
    public static final Modifier focusOrder(@NotNull Modifier modifier, @NotNull FocusRequester focusRequester, @NotNull Function1<? super FocusOrder, Unit> function1) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(focusRequester, "focusRequester");
        Intrinsics.checkNotNullParameter(function1, "focusOrderReceiver");
        return FocusPropertiesKt.focusProperties(FocusRequesterModifierKt.focusRequester(modifier, focusRequester), new FocusOrderToProperties(function1));
    }
}
