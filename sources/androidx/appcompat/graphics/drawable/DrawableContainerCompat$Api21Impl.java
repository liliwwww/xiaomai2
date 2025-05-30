package androidx.appcompat.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import androidx.annotation.RequiresApi;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
@RequiresApi(21)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class DrawableContainerCompat$Api21Impl {
    private DrawableContainerCompat$Api21Impl() {
    }

    public static boolean canApplyTheme(Drawable.ConstantState constantState) {
        return constantState.canApplyTheme();
    }

    public static void getOutline(Drawable drawable, Outline outline) {
        drawable.getOutline(outline);
    }

    public static Resources getResources(Resources.Theme theme) {
        return theme.getResources();
    }
}
