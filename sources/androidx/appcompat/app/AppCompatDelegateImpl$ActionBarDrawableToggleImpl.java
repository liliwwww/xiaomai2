package androidx.appcompat.app;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.R;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.TintTypedArray;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class AppCompatDelegateImpl$ActionBarDrawableToggleImpl implements ActionBarDrawerToggle.Delegate {
    final /* synthetic */ AppCompatDelegateImpl this$0;

    AppCompatDelegateImpl$ActionBarDrawableToggleImpl(AppCompatDelegateImpl appCompatDelegateImpl) {
        this.this$0 = appCompatDelegateImpl;
    }

    public Context getActionBarThemedContext() {
        return this.this$0.getActionBarThemedContext();
    }

    public Drawable getThemeUpIndicator() {
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(getActionBarThemedContext(), (AttributeSet) null, new int[]{R.attr.homeAsUpIndicator});
        Drawable drawable = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
        return drawable;
    }

    public boolean isNavigationVisible() {
        ActionBar supportActionBar = this.this$0.getSupportActionBar();
        return (supportActionBar == null || (supportActionBar.getDisplayOptions() & 4) == 0) ? false : true;
    }

    public void setActionBarDescription(int i) {
        ActionBar supportActionBar = this.this$0.getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setHomeActionContentDescription(i);
        }
    }

    public void setActionBarUpIndicator(Drawable drawable, int i) {
        ActionBar supportActionBar = this.this$0.getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setHomeAsUpIndicator(drawable);
            supportActionBar.setHomeActionContentDescription(i);
        }
    }
}
