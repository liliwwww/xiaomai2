package androidx.appcompat.resources;

import android.content.res.Resources;
import android.util.TypedValue;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* compiled from: Taobao */
@RequiresApi(15)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class Compatibility$Api15Impl {
    private Compatibility$Api15Impl() {
    }

    @DoNotInline
    public static void getValueForDensity(@NonNull Resources resources, int i, int i2, @NonNull TypedValue typedValue, boolean z) {
        resources.getValueForDensity(i, i2, typedValue, z);
    }
}
