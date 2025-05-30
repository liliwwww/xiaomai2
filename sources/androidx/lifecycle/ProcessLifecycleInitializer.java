package androidx.lifecycle;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.startup.AppInitializer;
import androidx.startup.Initializer;
import java.util.Collections;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class ProcessLifecycleInitializer implements Initializer<LifecycleOwner> {
    @NonNull
    public List<Class<? extends Initializer<?>>> dependencies() {
        return Collections.emptyList();
    }

    @NonNull
    /* renamed from: create, reason: merged with bridge method [inline-methods] */
    public LifecycleOwner m2808create(@NonNull Context context) {
        if (!AppInitializer.getInstance(context).isEagerlyInitialized(ProcessLifecycleInitializer.class)) {
            throw new IllegalStateException("ProcessLifecycleInitializer cannot be initialized lazily. \nPlease ensure that you have: \n<meta-data\n    android:name='androidx.lifecycle.ProcessLifecycleInitializer' \n    android:value='androidx.startup' /> \nunder InitializationProvider in your AndroidManifest.xml");
        }
        LifecycleDispatcher.init(context);
        ProcessLifecycleOwner.init(context);
        return ProcessLifecycleOwner.get();
    }
}
