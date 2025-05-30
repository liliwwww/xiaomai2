package android.taobao.windvane.packageapp;

import android.content.Context;
import android.taobao.windvane.config.GlobalConfig;
import android.taobao.windvane.extra.p002uc.preRender.BasePreInitManager;
import android.taobao.windvane.file.FileAccesser;
import android.taobao.windvane.file.FileManager;
import android.taobao.windvane.file.NotEnoughSpace;
import android.taobao.windvane.util.CommonUtils;
import android.taobao.windvane.util.TaoLog;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.taobao.android.speed.TBSpeed;
import com.taobao.orange.OrangeConfig;
import com.taobao.orange.OrangeConfigListenerV1;
import com.taobao.zcache.ZCacheManager;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class ZCacheConfigManager {
    private static ZCacheConfigManager instance;
    private AtomicBoolean updateFromLocal = new AtomicBoolean(false);
    private String zType = ExifInterface.GPS_MEASUREMENT_3D;
    private String oldConfig = "false";
    private String slideEnable = "false";
    private String configPath = null;

    public static ZCacheConfigManager getInstance() {
        if (instance == null) {
            synchronized (ZCacheConfigManager.class) {
                if (instance == null) {
                    instance = new ZCacheConfigManager();
                }
            }
        }
        return instance;
    }

    private void initOrange() {
        OrangeConfig.getInstance().registerListener(new String[]{"ZCache"}, new OrangeConfigListenerV1() { // from class: android.taobao.windvane.packageapp.ZCacheConfigManager.1
            public void onConfigUpdate(String str, boolean z) {
                if (str.equals("ZCache")) {
                    String config = OrangeConfig.getInstance().getConfig("ZCache", "slide", "false");
                    String config2 = OrangeConfig.getInstance().getConfig("ZCache", "oldConfigV1", "false");
                    TaoLog.m24i("ZCache", "use old config=[" + config2 + "], enable slide=[" + config + "]");
                    try {
                        FileAccesser.write(ZCacheConfigManager.this.configPath, ByteBuffer.wrap((GlobalConfig.getInstance().getAppVersion() + "," + config2 + "," + config).getBytes("utf-8")));
                    } catch (NotEnoughSpace e) {
                        e.printStackTrace();
                    } catch (UnsupportedEncodingException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        });
    }

    private void triggerLocalConfig() {
        byte[] read;
        if (this.updateFromLocal.compareAndSet(false, true)) {
            String str = null;
            try {
                read = FileAccesser.read(this.configPath);
            } catch (Throwable th) {
                th.printStackTrace();
                this.updateFromLocal.set(false);
            }
            if (read == null) {
                return;
            }
            str = new String(read, "utf-8");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            TaoLog.m24i("ZCache", "get zcache local config=[" + str + "]");
            String[] split = str.split(",");
            if (split.length == 3) {
                if (TextUtils.isEmpty(split[0]) || !TextUtils.equals(GlobalConfig.getInstance().getAppVersion(), split[0])) {
                    TaoLog.m24i("ZCache", "skip local config for dispatching appVersion. require=[" + GlobalConfig.getInstance().getAppVersion() + "], real=[" + split[0] + "]");
                    return;
                }
                if (!TextUtils.isEmpty(split[1])) {
                    if (TextUtils.equals(ExifInterface.GPS_MEASUREMENT_3D, this.zType) && !TextUtils.equals(this.oldConfig, split[2])) {
                        TaoLog.m24i("ZCache", "ZCache 3.0 新旧平台切换，需要刷新本地配置");
                        ZCacheManager.instance().removeAllZCache();
                    }
                    this.oldConfig = split[1];
                }
                if (TextUtils.isEmpty(split[2])) {
                    return;
                }
                this.slideEnable = split[2];
            }
        }
    }

    public String getzType() {
        if ("-1".equals(this.zType)) {
            try {
                this.zType = TBSpeed.isSpeedEdition(GlobalConfig.context, "ZCache3") ? ExifInterface.GPS_MEASUREMENT_3D : ExifInterface.GPS_MEASUREMENT_2D;
            } catch (Throwable unused) {
                this.zType = ExifInterface.GPS_MEASUREMENT_2D;
            }
        }
        return this.zType;
    }

    public void init(Context context) {
        this.zType = GlobalConfig.getInstance().isZcacheType3() ? ExifInterface.GPS_MEASUREMENT_3D : ExifInterface.GPS_MEASUREMENT_2D;
        this.oldConfig = GlobalConfig.getInstance().useZcacheOldConfig() ? BasePreInitManager.PRE_RENDER_URL_ADDITION_VALUE : "false";
        if (CommonUtils.getProcessName(context).equals(context.getApplicationContext().getPackageName())) {
            this.configPath = FileManager.createFolder(context, "ZCache").getPath() + File.separator + "orange";
            File file = new File(this.configPath);
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            triggerLocalConfig();
            try {
                initOrange();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public boolean slideEnable() {
        return TextUtils.equals(BasePreInitManager.PRE_RENDER_URL_ADDITION_VALUE, this.slideEnable);
    }

    public void triggerZCacheConfig() {
    }

    public boolean useOldConfig() {
        return TextUtils.equals(BasePreInitManager.PRE_RENDER_URL_ADDITION_VALUE, this.oldConfig);
    }
}
