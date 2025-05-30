package androidx.core.location;

import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.core.util.Preconditions;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class LocationRequestCompat$Builder {
    private long mDurationMillis;
    private long mIntervalMillis;
    private long mMaxUpdateDelayMillis;
    private int mMaxUpdates;
    private float mMinUpdateDistanceMeters;
    private long mMinUpdateIntervalMillis;
    private int mQuality;

    public LocationRequestCompat$Builder(long j) {
        setIntervalMillis(j);
        this.mQuality = 102;
        this.mDurationMillis = Long.MAX_VALUE;
        this.mMaxUpdates = Integer.MAX_VALUE;
        this.mMinUpdateIntervalMillis = -1L;
        this.mMinUpdateDistanceMeters = 0.0f;
        this.mMaxUpdateDelayMillis = 0L;
    }

    @NonNull
    public LocationRequestCompat build() {
        Preconditions.checkState((this.mIntervalMillis == Long.MAX_VALUE && this.mMinUpdateIntervalMillis == -1) ? false : true, "passive location requests must have an explicit minimum update interval");
        long j = this.mIntervalMillis;
        return new LocationRequestCompat(j, this.mQuality, this.mDurationMillis, this.mMaxUpdates, Math.min(this.mMinUpdateIntervalMillis, j), this.mMinUpdateDistanceMeters, this.mMaxUpdateDelayMillis);
    }

    @NonNull
    public LocationRequestCompat$Builder clearMinUpdateIntervalMillis() {
        this.mMinUpdateIntervalMillis = -1L;
        return this;
    }

    @NonNull
    public LocationRequestCompat$Builder setDurationMillis(@IntRange(from = 1) long j) {
        this.mDurationMillis = Preconditions.checkArgumentInRange(j, 1L, Long.MAX_VALUE, "durationMillis");
        return this;
    }

    @NonNull
    public LocationRequestCompat$Builder setIntervalMillis(@IntRange(from = 0) long j) {
        this.mIntervalMillis = Preconditions.checkArgumentInRange(j, 0L, Long.MAX_VALUE, "intervalMillis");
        return this;
    }

    @NonNull
    public LocationRequestCompat$Builder setMaxUpdateDelayMillis(@IntRange(from = 0) long j) {
        this.mMaxUpdateDelayMillis = j;
        this.mMaxUpdateDelayMillis = Preconditions.checkArgumentInRange(j, 0L, Long.MAX_VALUE, "maxUpdateDelayMillis");
        return this;
    }

    @NonNull
    public LocationRequestCompat$Builder setMaxUpdates(@IntRange(from = 1, to = 2147483647L) int i) {
        this.mMaxUpdates = Preconditions.checkArgumentInRange(i, 1, Integer.MAX_VALUE, "maxUpdates");
        return this;
    }

    @NonNull
    public LocationRequestCompat$Builder setMinUpdateDistanceMeters(@FloatRange(from = 0.0d, to = 3.4028234663852886E38d) float f) {
        this.mMinUpdateDistanceMeters = f;
        this.mMinUpdateDistanceMeters = Preconditions.checkArgumentInRange(f, 0.0f, Float.MAX_VALUE, "minUpdateDistanceMeters");
        return this;
    }

    @NonNull
    public LocationRequestCompat$Builder setMinUpdateIntervalMillis(@IntRange(from = 0) long j) {
        this.mMinUpdateIntervalMillis = Preconditions.checkArgumentInRange(j, 0L, Long.MAX_VALUE, "minUpdateIntervalMillis");
        return this;
    }

    @NonNull
    public LocationRequestCompat$Builder setQuality(int i) {
        Preconditions.checkArgument(i == 104 || i == 102 || i == 100, "quality must be a defined QUALITY constant, not %d", new Object[]{Integer.valueOf(i)});
        this.mQuality = i;
        return this;
    }

    public LocationRequestCompat$Builder(@NonNull LocationRequestCompat locationRequestCompat) {
        this.mIntervalMillis = locationRequestCompat.mIntervalMillis;
        this.mQuality = locationRequestCompat.mQuality;
        this.mDurationMillis = locationRequestCompat.mDurationMillis;
        this.mMaxUpdates = locationRequestCompat.mMaxUpdates;
        this.mMinUpdateIntervalMillis = locationRequestCompat.mMinUpdateIntervalMillis;
        this.mMinUpdateDistanceMeters = locationRequestCompat.mMinUpdateDistanceMeters;
        this.mMaxUpdateDelayMillis = locationRequestCompat.mMaxUpdateDelayMillis;
    }
}
