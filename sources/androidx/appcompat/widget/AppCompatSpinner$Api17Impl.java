package androidx.appcompat.widget;

import android.view.View;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
@RequiresApi(17)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class AppCompatSpinner$Api17Impl {
    private AppCompatSpinner$Api17Impl() {
    }

    @DoNotInline
    static int getTextAlignment(@NonNull View view) {
        return view.getTextAlignment();
    }

    @DoNotInline
    static int getTextDirection(@NonNull View view) {
        return view.getTextDirection();
    }

    @DoNotInline
    static void setTextAlignment(@NonNull View view, int i) {
        view.setTextAlignment(i);
    }

    @DoNotInline
    static void setTextDirection(@NonNull View view, int i) {
        view.setTextDirection(i);
    }
}
