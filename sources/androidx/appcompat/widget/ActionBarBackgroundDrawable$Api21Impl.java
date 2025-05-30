package androidx.appcompat.widget;

import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import androidx.annotation.RequiresApi;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
@RequiresApi(21)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class ActionBarBackgroundDrawable$Api21Impl {
    private ActionBarBackgroundDrawable$Api21Impl() {
    }

    public static void getOutline(Drawable drawable, Outline outline) {
        drawable.getOutline(outline);
    }
}
