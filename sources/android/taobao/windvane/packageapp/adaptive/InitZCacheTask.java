package android.taobao.windvane.packageapp.adaptive;

import android.app.Application;
import com.taobao.zcache.config.ZCacheAdapterManager;
import java.io.Serializable;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class InitZCacheTask implements Serializable {
    public void init(Application application, HashMap<String, Object> hashMap) {
        ZCacheAdapterManager.getInstance().setUpdateImpl(new ZCacheAdapter());
    }
}
