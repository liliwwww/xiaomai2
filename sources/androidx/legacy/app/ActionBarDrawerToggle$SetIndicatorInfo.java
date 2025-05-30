package androidx.legacy.app;

import android.R;
import android.app.ActionBar;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.lang.reflect.Method;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class ActionBarDrawerToggle$SetIndicatorInfo {
    Method mSetHomeActionContentDescription;
    Method mSetHomeAsUpIndicator;
    ImageView mUpIndicatorView;

    ActionBarDrawerToggle$SetIndicatorInfo(Activity activity) {
        try {
            this.mSetHomeAsUpIndicator = ActionBar.class.getDeclaredMethod("setHomeAsUpIndicator", Drawable.class);
            this.mSetHomeActionContentDescription = ActionBar.class.getDeclaredMethod("setHomeActionContentDescription", Integer.TYPE);
        } catch (NoSuchMethodException unused) {
            View findViewById = activity.findViewById(R.id.home);
            if (findViewById == null) {
                return;
            }
            ViewGroup viewGroup = (ViewGroup) findViewById.getParent();
            if (viewGroup.getChildCount() != 2) {
                return;
            }
            View childAt = viewGroup.getChildAt(0);
            childAt = childAt.getId() == 16908332 ? viewGroup.getChildAt(1) : childAt;
            if (childAt instanceof ImageView) {
                this.mUpIndicatorView = (ImageView) childAt;
            }
        }
    }
}
