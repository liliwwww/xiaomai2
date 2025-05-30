package androidx.core.location;

import android.location.Location;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
@RequiresApi(18)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class LocationCompat$Api18Impl {
    private LocationCompat$Api18Impl() {
    }

    @DoNotInline
    static boolean isMock(Location location) {
        return location.isFromMockProvider();
    }
}
