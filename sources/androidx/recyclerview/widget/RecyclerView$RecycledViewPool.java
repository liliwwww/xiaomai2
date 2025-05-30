package androidx.recyclerview.widget;

import android.util.SparseArray;
import androidx.annotation.Nullable;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class RecyclerView$RecycledViewPool {
    private static final int DEFAULT_MAX_SCRAP = 5;
    SparseArray<ScrapData> mScrap = new SparseArray<>();
    private int mAttachCount = 0;

    /* compiled from: Taobao */
    static class ScrapData {
        final ArrayList<RecyclerView$ViewHolder> mScrapHeap = new ArrayList<>();
        int mMaxScrap = 5;
        long mCreateRunningAverageNs = 0;
        long mBindRunningAverageNs = 0;

        ScrapData() {
        }
    }

    private ScrapData getScrapDataForType(int i) {
        ScrapData scrapData = this.mScrap.get(i);
        if (scrapData != null) {
            return scrapData;
        }
        ScrapData scrapData2 = new ScrapData();
        this.mScrap.put(i, scrapData2);
        return scrapData2;
    }

    void attach() {
        this.mAttachCount++;
    }

    public void clear() {
        for (int i = 0; i < this.mScrap.size(); i++) {
            this.mScrap.valueAt(i).mScrapHeap.clear();
        }
    }

    void detach() {
        this.mAttachCount--;
    }

    void factorInBindTime(int i, long j) {
        ScrapData scrapDataForType = getScrapDataForType(i);
        scrapDataForType.mBindRunningAverageNs = runningAverage(scrapDataForType.mBindRunningAverageNs, j);
    }

    void factorInCreateTime(int i, long j) {
        ScrapData scrapDataForType = getScrapDataForType(i);
        scrapDataForType.mCreateRunningAverageNs = runningAverage(scrapDataForType.mCreateRunningAverageNs, j);
    }

    @Nullable
    public RecyclerView$ViewHolder getRecycledView(int i) {
        ScrapData scrapData = this.mScrap.get(i);
        if (scrapData == null || scrapData.mScrapHeap.isEmpty()) {
            return null;
        }
        ArrayList<RecyclerView$ViewHolder> arrayList = scrapData.mScrapHeap;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (!arrayList.get(size).isAttachedToTransitionOverlay()) {
                return arrayList.remove(size);
            }
        }
        return null;
    }

    public int getRecycledViewCount(int i) {
        return getScrapDataForType(i).mScrapHeap.size();
    }

    void onAdapterChanged(RecyclerView$Adapter recyclerView$Adapter, RecyclerView$Adapter recyclerView$Adapter2, boolean z) {
        if (recyclerView$Adapter != null) {
            detach();
        }
        if (!z && this.mAttachCount == 0) {
            clear();
        }
        if (recyclerView$Adapter2 != null) {
            attach();
        }
    }

    public void putRecycledView(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        int itemViewType = recyclerView$ViewHolder.getItemViewType();
        ArrayList<RecyclerView$ViewHolder> arrayList = getScrapDataForType(itemViewType).mScrapHeap;
        if (this.mScrap.get(itemViewType).mMaxScrap <= arrayList.size()) {
            return;
        }
        recyclerView$ViewHolder.resetInternal();
        arrayList.add(recyclerView$ViewHolder);
    }

    long runningAverage(long j, long j2) {
        return j == 0 ? j2 : ((j / 4) * 3) + (j2 / 4);
    }

    public void setMaxRecycledViews(int i, int i2) {
        ScrapData scrapDataForType = getScrapDataForType(i);
        scrapDataForType.mMaxScrap = i2;
        ArrayList<RecyclerView$ViewHolder> arrayList = scrapDataForType.mScrapHeap;
        while (arrayList.size() > i2) {
            arrayList.remove(arrayList.size() - 1);
        }
    }

    int size() {
        int i = 0;
        for (int i2 = 0; i2 < this.mScrap.size(); i2++) {
            ArrayList<RecyclerView$ViewHolder> arrayList = this.mScrap.valueAt(i2).mScrapHeap;
            if (arrayList != null) {
                i += arrayList.size();
            }
        }
        return i;
    }

    boolean willBindInTime(int i, long j, long j2) {
        long j3 = getScrapDataForType(i).mBindRunningAverageNs;
        return j3 == 0 || j + j3 < j2;
    }

    boolean willCreateInTime(int i, long j, long j2) {
        long j3 = getScrapDataForType(i).mCreateRunningAverageNs;
        return j3 == 0 || j + j3 < j2;
    }
}
