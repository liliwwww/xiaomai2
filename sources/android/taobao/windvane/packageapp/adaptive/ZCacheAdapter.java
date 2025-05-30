package android.taobao.windvane.packageapp.adaptive;

import android.taobao.windvane.packageapp.WVPackageAppManager;
import androidx.exifinterface.media.ExifInterface;
import com.taobao.zcache.config.IZCacheUpdate;
import com.taobao.zcache.log.ZLog;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class ZCacheAdapter implements IZCacheUpdate {
    private static final String TAG = "ZCacheUpdate";

    public void firstUpdateCount(int i) {
        if (WVPackageAppManager.getInstance().getUpdateFinishCallback() != null) {
            WVPackageAppManager.getInstance().getUpdateFinishCallback().updateCount(ExifInterface.GPS_MEASUREMENT_3D, i);
        }
        ZLog.i("ZCache 3.0 首次更新个数[" + i + "]");
    }
}
