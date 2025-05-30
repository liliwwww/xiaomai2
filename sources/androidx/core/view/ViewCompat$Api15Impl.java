package androidx.core.view;

import android.view.View;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* compiled from: Taobao */
@RequiresApi(15)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class ViewCompat$Api15Impl {
    private ViewCompat$Api15Impl() {
    }

    @DoNotInline
    static boolean hasOnClickListeners(@NonNull View view) {
        return view.hasOnClickListeners();
    }
}
