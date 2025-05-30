package androidx.appcompat.widget;

import android.view.View;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
@RequiresApi(18)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class AppCompatTextViewAutoSizeHelper$Api18Impl {
    private AppCompatTextViewAutoSizeHelper$Api18Impl() {
    }

    @DoNotInline
    static boolean isInLayout(@NonNull View view) {
        return view.isInLayout();
    }
}
