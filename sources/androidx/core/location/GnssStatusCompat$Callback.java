package androidx.core.location;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public abstract class GnssStatusCompat$Callback {
    public void onFirstFix(@IntRange(from = 0) int i) {
    }

    public void onSatelliteStatusChanged(@NonNull GnssStatusCompat gnssStatusCompat) {
    }

    public void onStarted() {
    }

    public void onStopped() {
    }
}
