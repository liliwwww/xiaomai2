package androidx.loader.app;

import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.DebugUtils;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.loader.app.LoaderManager;
import androidx.loader.app.LoaderManagerImpl;
import androidx.loader.content.Loader;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class LoaderManagerImpl$LoaderInfo<D> extends MutableLiveData<D> implements Loader.OnLoadCompleteListener<D> {

    @Nullable
    private final Bundle mArgs;
    private final int mId;
    private LifecycleOwner mLifecycleOwner;

    @NonNull
    private final Loader<D> mLoader;
    private LoaderManagerImpl.LoaderObserver<D> mObserver;
    private Loader<D> mPriorLoader;

    LoaderManagerImpl$LoaderInfo(int i, @Nullable Bundle bundle, @NonNull Loader<D> loader, @Nullable Loader<D> loader2) {
        this.mId = i;
        this.mArgs = bundle;
        this.mLoader = loader;
        this.mPriorLoader = loader2;
        loader.registerListener(i, this);
    }

    @MainThread
    Loader<D> destroy(boolean z) {
        if (LoaderManagerImpl.DEBUG) {
            Log.v("LoaderManager", "  Destroying: " + this);
        }
        this.mLoader.cancelLoad();
        this.mLoader.abandon();
        LoaderManagerImpl.LoaderObserver<D> loaderObserver = this.mObserver;
        if (loaderObserver != null) {
            removeObserver(loaderObserver);
            if (z) {
                loaderObserver.reset();
            }
        }
        this.mLoader.unregisterListener(this);
        if ((loaderObserver == null || loaderObserver.hasDeliveredData()) && !z) {
            return this.mLoader;
        }
        this.mLoader.reset();
        return this.mPriorLoader;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.mId);
        printWriter.print(" mArgs=");
        printWriter.println(this.mArgs);
        printWriter.print(str);
        printWriter.print("mLoader=");
        printWriter.println(this.mLoader);
        this.mLoader.dump(str + "  ", fileDescriptor, printWriter, strArr);
        if (this.mObserver != null) {
            printWriter.print(str);
            printWriter.print("mCallbacks=");
            printWriter.println(this.mObserver);
            this.mObserver.dump(str + "  ", printWriter);
        }
        printWriter.print(str);
        printWriter.print("mData=");
        printWriter.println(getLoader().dataToString(getValue()));
        printWriter.print(str);
        printWriter.print("mStarted=");
        printWriter.println(hasActiveObservers());
    }

    @NonNull
    Loader<D> getLoader() {
        return this.mLoader;
    }

    boolean isCallbackWaitingForData() {
        LoaderManagerImpl.LoaderObserver<D> loaderObserver;
        return (!hasActiveObservers() || (loaderObserver = this.mObserver) == null || loaderObserver.hasDeliveredData()) ? false : true;
    }

    void markForRedelivery() {
        LifecycleOwner lifecycleOwner = this.mLifecycleOwner;
        LoaderManagerImpl.LoaderObserver<D> loaderObserver = this.mObserver;
        if (lifecycleOwner == null || loaderObserver == null) {
            return;
        }
        super/*androidx.lifecycle.LiveData*/.removeObserver(loaderObserver);
        observe(lifecycleOwner, loaderObserver);
    }

    protected void onActive() {
        if (LoaderManagerImpl.DEBUG) {
            Log.v("LoaderManager", "  Starting: " + this);
        }
        this.mLoader.startLoading();
    }

    protected void onInactive() {
        if (LoaderManagerImpl.DEBUG) {
            Log.v("LoaderManager", "  Stopping: " + this);
        }
        this.mLoader.stopLoading();
    }

    public void onLoadComplete(@NonNull Loader<D> loader, @Nullable D d) {
        if (LoaderManagerImpl.DEBUG) {
            Log.v("LoaderManager", "onLoadComplete: " + this);
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            setValue(d);
            return;
        }
        if (LoaderManagerImpl.DEBUG) {
            Log.w("LoaderManager", "onLoadComplete was incorrectly called on a background thread");
        }
        postValue(d);
    }

    public void removeObserver(@NonNull Observer<? super D> observer) {
        super/*androidx.lifecycle.LiveData*/.removeObserver(observer);
        this.mLifecycleOwner = null;
        this.mObserver = null;
    }

    @NonNull
    @MainThread
    Loader<D> setCallback(@NonNull LifecycleOwner lifecycleOwner, @NonNull LoaderManager.LoaderCallbacks<D> loaderCallbacks) {
        LoaderManagerImpl.LoaderObserver<D> loaderObserver = new LoaderManagerImpl.LoaderObserver<>(this.mLoader, loaderCallbacks);
        observe(lifecycleOwner, loaderObserver);
        LoaderManagerImpl.LoaderObserver<D> loaderObserver2 = this.mObserver;
        if (loaderObserver2 != null) {
            removeObserver(loaderObserver2);
        }
        this.mLifecycleOwner = lifecycleOwner;
        this.mObserver = loaderObserver;
        return this.mLoader;
    }

    public void setValue(D d) {
        super.setValue(d);
        Loader<D> loader = this.mPriorLoader;
        if (loader != null) {
            loader.reset();
            this.mPriorLoader = null;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append("LoaderInfo{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" #");
        sb.append(this.mId);
        sb.append(" : ");
        DebugUtils.buildShortClassTag(this.mLoader, sb);
        sb.append("}}");
        return sb.toString();
    }
}
