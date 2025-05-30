package androidx.appcompat.app;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class ActionBarDrawerToggle$ToolbarCompatDelegate implements ActionBarDrawerToggle.Delegate {
    final CharSequence mDefaultContentDescription;
    final Drawable mDefaultUpIndicator;
    final Toolbar mToolbar;

    ActionBarDrawerToggle$ToolbarCompatDelegate(Toolbar toolbar) {
        this.mToolbar = toolbar;
        this.mDefaultUpIndicator = toolbar.getNavigationIcon();
        this.mDefaultContentDescription = toolbar.getNavigationContentDescription();
    }

    public Context getActionBarThemedContext() {
        return this.mToolbar.getContext();
    }

    public Drawable getThemeUpIndicator() {
        return this.mDefaultUpIndicator;
    }

    public boolean isNavigationVisible() {
        return true;
    }

    public void setActionBarDescription(@StringRes int i) {
        if (i == 0) {
            this.mToolbar.setNavigationContentDescription(this.mDefaultContentDescription);
        } else {
            this.mToolbar.setNavigationContentDescription(i);
        }
    }

    public void setActionBarUpIndicator(Drawable drawable, @StringRes int i) {
        this.mToolbar.setNavigationIcon(drawable);
        setActionBarDescription(i);
    }
}
