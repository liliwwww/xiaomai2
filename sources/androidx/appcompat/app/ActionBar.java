package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.SpinnerAdapter;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;
import androidx.annotation.StringRes;
import androidx.appcompat.view.ActionMode;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public abstract class ActionBar {
    public static final int DISPLAY_HOME_AS_UP = 4;
    public static final int DISPLAY_SHOW_CUSTOM = 16;
    public static final int DISPLAY_SHOW_HOME = 2;
    public static final int DISPLAY_SHOW_TITLE = 8;
    public static final int DISPLAY_USE_LOGO = 1;

    @Deprecated
    public static final int NAVIGATION_MODE_LIST = 1;

    @Deprecated
    public static final int NAVIGATION_MODE_STANDARD = 0;

    @Deprecated
    public static final int NAVIGATION_MODE_TABS = 2;

    /* compiled from: Taobao */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
    public @interface DisplayOptions {
    }

    /* compiled from: Taobao */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
    public @interface NavigationMode {
    }

    /* compiled from: Taobao */
    @Deprecated
    public interface OnNavigationListener {
        boolean onNavigationItemSelected(int i, long j);
    }

    /* compiled from: Taobao */
    @Deprecated
    public static abstract class Tab {
        public static final int INVALID_POSITION = -1;

        public abstract CharSequence getContentDescription();

        public abstract View getCustomView();

        public abstract Drawable getIcon();

        public abstract int getPosition();

        public abstract Object getTag();

        public abstract CharSequence getText();

        public abstract void select();

        public abstract Tab setContentDescription(@StringRes int i);

        public abstract Tab setContentDescription(CharSequence charSequence);

        public abstract Tab setCustomView(int i);

        public abstract Tab setCustomView(View view);

        public abstract Tab setIcon(@DrawableRes int i);

        public abstract Tab setIcon(Drawable drawable);

        public abstract Tab setTabListener(TabListener tabListener);

        public abstract Tab setTag(Object obj);

        public abstract Tab setText(int i);

        public abstract Tab setText(CharSequence charSequence);
    }

    public abstract void addOnMenuVisibilityListener(OnMenuVisibilityListener onMenuVisibilityListener);

    @Deprecated
    public abstract void addTab(Tab tab);

    @Deprecated
    public abstract void addTab(Tab tab, int i);

    @Deprecated
    public abstract void addTab(Tab tab, int i, boolean z);

    @Deprecated
    public abstract void addTab(Tab tab, boolean z);

    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
    public boolean closeOptionsMenu() {
        return false;
    }

    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
    public boolean collapseActionView() {
        return false;
    }

    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
    public void dispatchMenuVisibilityChanged(boolean z) {
    }

    public abstract View getCustomView();

    public abstract int getDisplayOptions();

    public float getElevation() {
        return 0.0f;
    }

    public abstract int getHeight();

    public int getHideOffset() {
        return 0;
    }

    @Deprecated
    public abstract int getNavigationItemCount();

    @Deprecated
    public abstract int getNavigationMode();

    @Deprecated
    public abstract int getSelectedNavigationIndex();

    @Nullable
    @Deprecated
    public abstract Tab getSelectedTab();

    @Nullable
    public abstract CharSequence getSubtitle();

    @Deprecated
    public abstract Tab getTabAt(int i);

    @Deprecated
    public abstract int getTabCount();

    public Context getThemedContext() {
        return null;
    }

    @Nullable
    public abstract CharSequence getTitle();

    public abstract void hide();

    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
    public boolean invalidateOptionsMenu() {
        return false;
    }

    public boolean isHideOnContentScrollEnabled() {
        return false;
    }

    public abstract boolean isShowing();

    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
    public boolean isTitleTruncated() {
        return false;
    }

    @Deprecated
    public abstract Tab newTab();

    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
    public void onConfigurationChanged(Configuration configuration) {
    }

    void onDestroy() {
    }

    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
    public boolean onKeyShortcut(int i, KeyEvent keyEvent) {
        return false;
    }

    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
    public boolean onMenuKeyEvent(KeyEvent keyEvent) {
        return false;
    }

    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
    public boolean openOptionsMenu() {
        return false;
    }

    @Deprecated
    public abstract void removeAllTabs();

    public abstract void removeOnMenuVisibilityListener(OnMenuVisibilityListener onMenuVisibilityListener);

    @Deprecated
    public abstract void removeTab(Tab tab);

    @Deprecated
    public abstract void removeTabAt(int i);

    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
    boolean requestFocus() {
        return false;
    }

    @Deprecated
    public abstract void selectTab(Tab tab);

    public abstract void setBackgroundDrawable(@Nullable Drawable drawable);

    public abstract void setCustomView(int i);

    public abstract void setCustomView(View view);

    public abstract void setCustomView(View view, LayoutParams layoutParams);

    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
    public void setDefaultDisplayHomeAsUpEnabled(boolean z) {
    }

    public abstract void setDisplayHomeAsUpEnabled(boolean z);

    public abstract void setDisplayOptions(int i);

    public abstract void setDisplayOptions(int i, int i2);

    public abstract void setDisplayShowCustomEnabled(boolean z);

    public abstract void setDisplayShowHomeEnabled(boolean z);

    public abstract void setDisplayShowTitleEnabled(boolean z);

    public abstract void setDisplayUseLogoEnabled(boolean z);

    public void setElevation(float f) {
        if (f != 0.0f) {
            throw new UnsupportedOperationException("Setting a non-zero elevation is not supported in this action bar configuration.");
        }
    }

    public void setHideOffset(int i) {
        if (i != 0) {
            throw new UnsupportedOperationException("Setting an explicit action bar hide offset is not supported in this action bar configuration.");
        }
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if (z) {
            throw new UnsupportedOperationException("Hide on content scroll is not supported in this action bar configuration.");
        }
    }

    public void setHomeActionContentDescription(@StringRes int i) {
    }

    public void setHomeActionContentDescription(@Nullable CharSequence charSequence) {
    }

    public void setHomeAsUpIndicator(@DrawableRes int i) {
    }

    public void setHomeAsUpIndicator(@Nullable Drawable drawable) {
    }

    public void setHomeButtonEnabled(boolean z) {
    }

    public abstract void setIcon(@DrawableRes int i);

    public abstract void setIcon(Drawable drawable);

    @Deprecated
    public abstract void setListNavigationCallbacks(SpinnerAdapter spinnerAdapter, OnNavigationListener onNavigationListener);

    public abstract void setLogo(@DrawableRes int i);

    public abstract void setLogo(Drawable drawable);

    @Deprecated
    public abstract void setNavigationMode(int i);

    @Deprecated
    public abstract void setSelectedNavigationItem(int i);

    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
    public void setShowHideAnimationEnabled(boolean z) {
    }

    public void setSplitBackgroundDrawable(Drawable drawable) {
    }

    public void setStackedBackgroundDrawable(Drawable drawable) {
    }

    public abstract void setSubtitle(int i);

    public abstract void setSubtitle(CharSequence charSequence);

    public abstract void setTitle(@StringRes int i);

    public abstract void setTitle(CharSequence charSequence);

    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
    public void setWindowTitle(CharSequence charSequence) {
    }

    public abstract void show();

    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
    public ActionMode startActionMode(ActionMode.Callback callback) {
        return null;
    }
}
