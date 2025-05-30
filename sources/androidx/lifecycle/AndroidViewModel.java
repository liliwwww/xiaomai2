package androidx.lifecycle;

import android.annotation.SuppressLint;
import android.app.Application;
import androidx.annotation.NonNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class AndroidViewModel extends ViewModel {

    @SuppressLint({"StaticFieldLeak"})
    private Application mApplication;

    public AndroidViewModel(@NonNull Application application) {
        this.mApplication = application;
    }

    @NonNull
    public <T extends Application> T getApplication() {
        return (T) this.mApplication;
    }
}
