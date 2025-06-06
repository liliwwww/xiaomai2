package androidx.appcompat.widget;

import android.os.Build;
import android.view.View;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class TooltipCompat {

    /* compiled from: Taobao */
    @RequiresApi(26)
    static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        static void setTooltipText(View view, CharSequence charSequence) {
            view.setTooltipText(charSequence);
        }
    }

    private TooltipCompat() {
    }

    public static void setTooltipText(@NonNull View view, @Nullable CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            Api26Impl.setTooltipText(view, charSequence);
        } else {
            TooltipCompatHandler.setTooltipText(view, charSequence);
        }
    }
}
