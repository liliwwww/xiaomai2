package androidx.core.view;

import android.view.View;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.Collection;

/* compiled from: Taobao */
@RequiresApi(26)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class ViewCompat$Api26Impl {
    private ViewCompat$Api26Impl() {
    }

    @DoNotInline
    static void addKeyboardNavigationClusters(@NonNull View view, Collection<View> collection, int i) {
        view.addKeyboardNavigationClusters(collection, i);
    }

    @DoNotInline
    static int getImportantForAutofill(View view) {
        return view.getImportantForAutofill();
    }

    @DoNotInline
    static int getNextClusterForwardId(@NonNull View view) {
        return view.getNextClusterForwardId();
    }

    @DoNotInline
    static boolean hasExplicitFocusable(@NonNull View view) {
        return view.hasExplicitFocusable();
    }

    @DoNotInline
    static boolean isFocusedByDefault(@NonNull View view) {
        return view.isFocusedByDefault();
    }

    @DoNotInline
    static boolean isImportantForAutofill(View view) {
        return view.isImportantForAutofill();
    }

    @DoNotInline
    static boolean isKeyboardNavigationCluster(@NonNull View view) {
        return view.isKeyboardNavigationCluster();
    }

    @DoNotInline
    static View keyboardNavigationClusterSearch(@NonNull View view, View view2, int i) {
        return view.keyboardNavigationClusterSearch(view2, i);
    }

    @DoNotInline
    static boolean restoreDefaultFocus(@NonNull View view) {
        return view.restoreDefaultFocus();
    }

    @DoNotInline
    static void setAutofillHints(@NonNull View view, String... strArr) {
        view.setAutofillHints(strArr);
    }

    @DoNotInline
    static void setFocusedByDefault(@NonNull View view, boolean z) {
        view.setFocusedByDefault(z);
    }

    @DoNotInline
    static void setImportantForAutofill(View view, int i) {
        view.setImportantForAutofill(i);
    }

    @DoNotInline
    static void setKeyboardNavigationCluster(@NonNull View view, boolean z) {
        view.setKeyboardNavigationCluster(z);
    }

    @DoNotInline
    static void setNextClusterForwardId(View view, int i) {
        view.setNextClusterForwardId(i);
    }

    @DoNotInline
    static void setTooltipText(@NonNull View view, CharSequence charSequence) {
        view.setTooltipText(charSequence);
    }
}
