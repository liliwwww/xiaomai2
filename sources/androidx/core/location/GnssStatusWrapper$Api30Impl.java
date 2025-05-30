package androidx.core.location;

import android.location.GnssStatus;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* compiled from: Taobao */
@RequiresApi(30)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class GnssStatusWrapper$Api30Impl {
    private GnssStatusWrapper$Api30Impl() {
    }

    @DoNotInline
    static float getBasebandCn0DbHz(GnssStatus gnssStatus, int i) {
        return gnssStatus.getBasebandCn0DbHz(i);
    }

    @DoNotInline
    static boolean hasBasebandCn0DbHz(GnssStatus gnssStatus, int i) {
        return gnssStatus.hasBasebandCn0DbHz(i);
    }
}
