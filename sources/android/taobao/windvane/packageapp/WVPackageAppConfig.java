package android.taobao.windvane.packageapp;

import android.taobao.windvane.WindvaneException;
import android.taobao.windvane.packageapp.zipapp.data.ZipGlobalConfig;
import android.webkit.ValueCallback;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class WVPackageAppConfig implements WVPackageAppConfigInterface {
    public ZipGlobalConfig getGlobalConfig() {
        return null;
    }

    public void requestFullConfigNextTime() {
    }

    public boolean saveLocalConfig(ZipGlobalConfig zipGlobalConfig) {
        return false;
    }

    public void updateGlobalConfig(boolean z, ValueCallback<ZipGlobalConfig> valueCallback, ValueCallback<WindvaneException> valueCallback2, String str, String str2) {
    }
}
