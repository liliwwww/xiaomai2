package androidx.core.app;

import android.app.Activity;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.view.Display;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.LocusIdCompat;

/* compiled from: Taobao */
@RequiresApi(30)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class ActivityCompat$Api30Impl {
    private ActivityCompat$Api30Impl() {
    }

    @DoNotInline
    static Display getDisplay(ContextWrapper contextWrapper) {
        return contextWrapper.getDisplay();
    }

    @DoNotInline
    static void setLocusContext(@NonNull Activity activity, @Nullable LocusIdCompat locusIdCompat, @Nullable Bundle bundle) {
        activity.setLocusContext(locusIdCompat == null ? null : locusIdCompat.toLocusId(), bundle);
    }
}
