package android.media;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import java.util.concurrent.Executor;

/* compiled from: Taobao */
@Keep
/* loaded from: classes.dex */
public interface IVivoSpatializer {
    public static final int SPATIALIZER_IMMERSIVE_LEVEL_MULTICHANNEL = 1;
    public static final int SPATIALIZER_IMMERSIVE_LEVEL_NONE = 0;
    public static final int SPATIALIZER_IMMERSIVE_LEVEL_OTHER = -1;
    public static final int V_SDK_MIN_VERSION = 10000;

    /* compiled from: Taobao */
    @Keep
    /* loaded from: classes2.dex */
    public interface OnHeadTrackerAvailableListener {
        void onHeadTrackerAvailableChanged(@NonNull IVivoSpatializer iVivoSpatializer, boolean z);
    }

    /* compiled from: Taobao */
    @Keep
    public interface OnSpatializerStateChangedListener {
        void onSpatializerAvailableChanged(@NonNull IVivoSpatializer iVivoSpatializer, boolean z);

        void onSpatializerEnabledChanged(@NonNull IVivoSpatializer iVivoSpatializer, boolean z);
    }

    /* compiled from: Taobao */
    @Keep
    public interface OnVHeadToSoundstagePoseUpdatedListener {
        void onHeadToSoundstagePoseUpdated(@NonNull IVivoSpatializer iVivoSpatializer, @NonNull float[] fArr);
    }

    void addOnHeadTrackerAvailableListener(@NonNull Executor executor, @NonNull OnHeadTrackerAvailableListener onHeadTrackerAvailableListener);

    void addOnSpatializerStateChangedListener(@NonNull Executor executor, @NonNull OnSpatializerStateChangedListener onSpatializerStateChangedListener);

    void addOnVHeadToSoundstagePoseUpdatedListener(@NonNull Executor executor, @NonNull OnVHeadToSoundstagePoseUpdatedListener onVHeadToSoundstagePoseUpdatedListener);

    boolean canBeSpatialized(@NonNull AudioAttributes audioAttributes, @NonNull AudioFormat audioFormat);

    int getImmersiveAudioLevel();

    int getVersion();

    boolean isAvailable();

    boolean isEnabled();

    boolean isHeadTrackerAvailable();

    void removeOnHeadTrackerAvailableListener(@NonNull OnHeadTrackerAvailableListener onHeadTrackerAvailableListener);

    void removeOnSpatializerStateChangedListener(@NonNull OnSpatializerStateChangedListener onSpatializerStateChangedListener);

    void removeOnVHeadToSoundstagePoseUpdatedListener(@NonNull OnVHeadToSoundstagePoseUpdatedListener onVHeadToSoundstagePoseUpdatedListener);
}
