package android.media;

import android.media.IVivoSpatializer;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Objects;
import java.util.concurrent.Executor;

/* compiled from: Taobao */
@Keep
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class VivoSpatializerClient implements IVivoSpatializer {
    private static final boolean V_DEBUG = true;
    private static final String V_TAG = "VivoSpatializerClient";
    private static volatile VivoSpatializerClient sVsaClient;
    private boolean mIsSupport;

    @Nullable
    private VivoSpatializer mVSpat;

    private VivoSpatializerClient(@NonNull AudioManager audioManager) {
        Objects.requireNonNull(audioManager, "AudioManager is null for VivoSpatializerClient");
        try {
            this.mVSpat = new VivoSpatializer(audioManager);
            this.mIsSupport = V_DEBUG;
        } catch (Throwable th) {
            this.mIsSupport = false;
            th.printStackTrace();
            Log.e(V_TAG, "new VivoSpatializer API not support, err: " + th.getMessage());
        }
        if (this.mIsSupport) {
            this.mIsSupport = isSupportedInner();
        }
        Log.d(V_TAG, "new VivoSpatializer, final mIsSupport: " + this.mIsSupport + ", mVSpat: " + this.mVSpat);
    }

    @NonNull
    public static VivoSpatializerClient getInstance(@NonNull AudioManager audioManager) {
        if (sVsaClient == null) {
            synchronized (VivoSpatializerClient.class) {
                if (sVsaClient == null) {
                    sVsaClient = new VivoSpatializerClient(audioManager);
                }
            }
        }
        return sVsaClient;
    }

    private boolean isSupportedInner() {
        if (getVersion() >= 10000) {
            return V_DEBUG;
        }
        return false;
    }

    @Override // android.media.IVivoSpatializer
    public void addOnHeadTrackerAvailableListener(@NonNull Executor executor, @NonNull IVivoSpatializer.OnHeadTrackerAvailableListener onHeadTrackerAvailableListener) {
        VivoSpatializer vivoSpatializer;
        if (!this.mIsSupport || (vivoSpatializer = this.mVSpat) == null) {
            Log.e(V_TAG, "addOnHeadTrackerAvailableListener API not support");
            return;
        }
        try {
            vivoSpatializer.addOnHeadTrackerAvailableListener(executor, onHeadTrackerAvailableListener);
            Log.d(V_TAG, "addOnHeadTrackerAvailableListener, called");
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(V_TAG, "addOnHeadTrackerAvailableListener API not support, err: " + e.getMessage());
        }
    }

    @Override // android.media.IVivoSpatializer
    public void addOnSpatializerStateChangedListener(@NonNull Executor executor, @NonNull IVivoSpatializer.OnSpatializerStateChangedListener onSpatializerStateChangedListener) {
        VivoSpatializer vivoSpatializer;
        if (!this.mIsSupport || (vivoSpatializer = this.mVSpat) == null) {
            Log.e(V_TAG, "addOnSpatializerStateChangedListener API not support");
            return;
        }
        try {
            vivoSpatializer.addOnSpatializerStateChangedListener(executor, onSpatializerStateChangedListener);
            Log.d(V_TAG, "addOnSpatializerStateChangedListener, called");
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(V_TAG, "addOnSpatializerStateChangedListener API not support, err: " + e.getMessage());
        }
    }

    @Override // android.media.IVivoSpatializer
    public void addOnVHeadToSoundstagePoseUpdatedListener(@NonNull Executor executor, @NonNull IVivoSpatializer.OnVHeadToSoundstagePoseUpdatedListener onVHeadToSoundstagePoseUpdatedListener) {
        VivoSpatializer vivoSpatializer;
        if (!this.mIsSupport || (vivoSpatializer = this.mVSpat) == null) {
            Log.e(V_TAG, "addOnVHeadToSoundstagePoseUpdatedListener API not support");
            return;
        }
        try {
            vivoSpatializer.addOnVHeadToSoundstagePoseUpdatedListener(executor, onVHeadToSoundstagePoseUpdatedListener);
            Log.d(V_TAG, "addOnVHeadToSoundstagePoseUpdatedListener, called");
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(V_TAG, "addOnVHeadToSoundstagePoseUpdatedListener API not support, err: " + e.getMessage());
        }
    }

    @Override // android.media.IVivoSpatializer
    public boolean canBeSpatialized(@NonNull AudioAttributes audioAttributes, @NonNull AudioFormat audioFormat) {
        VivoSpatializer vivoSpatializer;
        boolean z = false;
        if (!this.mIsSupport || (vivoSpatializer = this.mVSpat) == null) {
            Log.e(V_TAG, "canBeSpatialized API not support");
            return false;
        }
        try {
            z = vivoSpatializer.canBeSpatialized(audioAttributes, audioFormat);
            Log.d(V_TAG, "canBeSpatialized, vCanBeSpatialized: " + z);
            return z;
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(V_TAG, "canBeSpatialized API not support, err: " + e.getMessage());
            return z;
        }
    }

    @Override // android.media.IVivoSpatializer
    public int getImmersiveAudioLevel() {
        VivoSpatializer vivoSpatializer;
        if (!this.mIsSupport || (vivoSpatializer = this.mVSpat) == null) {
            Log.e(V_TAG, "getImmersiveAudioLevel API not support");
            return -1;
        }
        int i = 0;
        try {
            i = vivoSpatializer.getImmersiveAudioLevel();
            Log.d(V_TAG, "getImmersiveAudioLevel, vSpatLevel: " + i);
            return i;
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(V_TAG, "getImmersiveAudioLevel API not support, err: " + e.getMessage());
            return i;
        }
    }

    @Override // android.media.IVivoSpatializer
    public int getVersion() {
        VivoSpatializer vivoSpatializer;
        int i = -1;
        if (!this.mIsSupport || (vivoSpatializer = this.mVSpat) == null) {
            Log.e(V_TAG, "getVersion API not support");
            return -1;
        }
        try {
            i = vivoSpatializer.getVersion();
            Log.d(V_TAG, "getVersion, vSpatVersion: " + i);
            return i;
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(V_TAG, "getVersion API not support, err: " + e.getMessage());
            return i;
        }
    }

    @Override // android.media.IVivoSpatializer
    public boolean isAvailable() {
        VivoSpatializer vivoSpatializer;
        boolean z = false;
        if (!this.mIsSupport || (vivoSpatializer = this.mVSpat) == null) {
            Log.e(V_TAG, "isAvailable API not support");
            return false;
        }
        try {
            z = vivoSpatializer.isAvailable();
            Log.d(V_TAG, "isAvailable, vSpatAvailable: " + z);
            return z;
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(V_TAG, "isAvailable API not support, err: " + e.getMessage());
            return z;
        }
    }

    @Override // android.media.IVivoSpatializer
    public boolean isEnabled() {
        VivoSpatializer vivoSpatializer;
        boolean z = false;
        if (!this.mIsSupport || (vivoSpatializer = this.mVSpat) == null) {
            Log.e(V_TAG, "isEnabled API not support");
            return false;
        }
        try {
            z = vivoSpatializer.isEnabled();
            Log.d(V_TAG, "isEnabled, vSpatEnabled: " + z);
            return z;
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(V_TAG, "isEnabled API not support, err: " + e.getMessage());
            return z;
        }
    }

    @Override // android.media.IVivoSpatializer
    public boolean isHeadTrackerAvailable() {
        VivoSpatializer vivoSpatializer;
        boolean z = false;
        if (!this.mIsSupport || (vivoSpatializer = this.mVSpat) == null) {
            Log.e(V_TAG, "isHeadTrackerAvailable API not support");
            return false;
        }
        try {
            z = vivoSpatializer.isHeadTrackerAvailable();
            Log.d(V_TAG, "isHeadTrackerAvailable, vSpatHeadTrackerAvailable: " + z);
            return z;
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(V_TAG, "isHeadTrackerAvailable API not support, err: " + e.getMessage());
            return z;
        }
    }

    public boolean isSupported() {
        return this.mIsSupport;
    }

    @Override // android.media.IVivoSpatializer
    public void removeOnHeadTrackerAvailableListener(@NonNull IVivoSpatializer.OnHeadTrackerAvailableListener onHeadTrackerAvailableListener) {
        VivoSpatializer vivoSpatializer;
        if (!this.mIsSupport || (vivoSpatializer = this.mVSpat) == null) {
            Log.e(V_TAG, "removeOnHeadTrackerAvailableListener API not support");
            return;
        }
        try {
            vivoSpatializer.removeOnHeadTrackerAvailableListener(onHeadTrackerAvailableListener);
            Log.d(V_TAG, "removeOnHeadTrackerAvailableListener, called");
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(V_TAG, "removeOnHeadTrackerAvailableListener API not support, err: " + e.getMessage());
        }
    }

    @Override // android.media.IVivoSpatializer
    public void removeOnSpatializerStateChangedListener(@NonNull IVivoSpatializer.OnSpatializerStateChangedListener onSpatializerStateChangedListener) {
        VivoSpatializer vivoSpatializer;
        if (!this.mIsSupport || (vivoSpatializer = this.mVSpat) == null) {
            Log.e(V_TAG, "removeOnSpatializerStateChangedListener API not support");
            return;
        }
        try {
            vivoSpatializer.removeOnSpatializerStateChangedListener(onSpatializerStateChangedListener);
            Log.d(V_TAG, "removeOnSpatializerStateChangedListener, called");
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(V_TAG, "removeOnSpatializerStateChangedListener API not support, err: " + e.getMessage());
        }
    }

    @Override // android.media.IVivoSpatializer
    public void removeOnVHeadToSoundstagePoseUpdatedListener(@NonNull IVivoSpatializer.OnVHeadToSoundstagePoseUpdatedListener onVHeadToSoundstagePoseUpdatedListener) {
        VivoSpatializer vivoSpatializer;
        if (!this.mIsSupport || (vivoSpatializer = this.mVSpat) == null) {
            Log.e(V_TAG, "removeOnVHeadToSoundstagePoseUpdatedListener API not support");
            return;
        }
        try {
            vivoSpatializer.removeOnVHeadToSoundstagePoseUpdatedListener(onVHeadToSoundstagePoseUpdatedListener);
            Log.d(V_TAG, "removeOnVHeadToSoundstagePoseUpdatedListener, called");
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(V_TAG, "removeOnVHeadToSoundstagePoseUpdatedListener API not support, err: " + e.getMessage());
        }
    }
}
