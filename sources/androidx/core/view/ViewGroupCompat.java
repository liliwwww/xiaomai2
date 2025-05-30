package androidx.core.view;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.R;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class ViewGroupCompat {
    public static final int LAYOUT_MODE_CLIP_BOUNDS = 0;
    public static final int LAYOUT_MODE_OPTICAL_BOUNDS = 1;

    /* compiled from: Taobao */
    @RequiresApi(18)
    static class Api18Impl {
        private Api18Impl() {
        }

        @DoNotInline
        static int getLayoutMode(ViewGroup viewGroup) {
            return viewGroup.getLayoutMode();
        }

        @DoNotInline
        static void setLayoutMode(ViewGroup viewGroup, int i) {
            viewGroup.setLayoutMode(i);
        }
    }

    private ViewGroupCompat() {
    }

    public static int getLayoutMode(@NonNull ViewGroup viewGroup) {
        if (Build.VERSION.SDK_INT >= 18) {
            return Api18Impl.getLayoutMode(viewGroup);
        }
        return 0;
    }

    public static int getNestedScrollAxes(@NonNull ViewGroup viewGroup) {
        if (Build.VERSION.SDK_INT >= 21) {
            return Api21Impl.getNestedScrollAxes(viewGroup);
        }
        if (viewGroup instanceof NestedScrollingParent) {
            return ((NestedScrollingParent) viewGroup).getNestedScrollAxes();
        }
        return 0;
    }

    public static boolean isTransitionGroup(@NonNull ViewGroup viewGroup) {
        if (Build.VERSION.SDK_INT >= 21) {
            return Api21Impl.isTransitionGroup(viewGroup);
        }
        Boolean bool = (Boolean) viewGroup.getTag(R.id.tag_transition_group);
        return ((bool == null || !bool.booleanValue()) && viewGroup.getBackground() == null && ViewCompat.getTransitionName(viewGroup) == null) ? false : true;
    }

    @Deprecated
    public static boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return viewGroup.onRequestSendAccessibilityEvent(view, accessibilityEvent);
    }

    public static void setLayoutMode(@NonNull ViewGroup viewGroup, int i) {
        if (Build.VERSION.SDK_INT >= 18) {
            Api18Impl.setLayoutMode(viewGroup, i);
        }
    }

    @Deprecated
    public static void setMotionEventSplittingEnabled(ViewGroup viewGroup, boolean z) {
        viewGroup.setMotionEventSplittingEnabled(z);
    }

    public static void setTransitionGroup(@NonNull ViewGroup viewGroup, boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            Api21Impl.setTransitionGroup(viewGroup, z);
        } else {
            viewGroup.setTag(R.id.tag_transition_group, Boolean.valueOf(z));
        }
    }
}
