package androidx.room;

import androidx.annotation.VisibleForTesting;
import androidx.lifecycle.LiveData;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
import java.util.concurrent.Callable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class InvalidationLiveDataContainer {
    private final RoomDatabase mDatabase;

    @VisibleForTesting
    final Set<LiveData> mLiveDataSet = Collections.newSetFromMap(new IdentityHashMap());

    InvalidationLiveDataContainer(RoomDatabase roomDatabase) {
        this.mDatabase = roomDatabase;
    }

    <T> LiveData<T> create(String[] strArr, boolean z, Callable<T> callable) {
        return new RoomTrackingLiveData(this.mDatabase, this, z, callable, strArr);
    }

    void onActive(LiveData liveData) {
        this.mLiveDataSet.add(liveData);
    }

    void onInactive(LiveData liveData) {
        this.mLiveDataSet.remove(liveData);
    }
}
