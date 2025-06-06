package androidx.coordinatorlayout.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;
import androidx.collection.SimpleArrayMap;
import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* compiled from: Taobao */
@RestrictTo({RestrictTo$Scope.LIBRARY})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class DirectedAcyclicGraph<T> {
    private final Pools.Pool<ArrayList<T>> mListPool = new Pools.SimplePool(10);
    private final SimpleArrayMap<T, ArrayList<T>> mGraph = new SimpleArrayMap<>();
    private final ArrayList<T> mSortResult = new ArrayList<>();
    private final HashSet<T> mSortTmpMarked = new HashSet<>();

    /* JADX WARN: Multi-variable type inference failed */
    private void dfs(T t, ArrayList<T> arrayList, HashSet<T> hashSet) {
        if (arrayList.contains(t)) {
            return;
        }
        if (hashSet.contains(t)) {
            throw new RuntimeException("This graph contains cyclic dependencies");
        }
        hashSet.add(t);
        ArrayList arrayList2 = (ArrayList) this.mGraph.get(t);
        if (arrayList2 != null) {
            int size = arrayList2.size();
            for (int i = 0; i < size; i++) {
                dfs(arrayList2.get(i), arrayList, hashSet);
            }
        }
        hashSet.remove(t);
        arrayList.add(t);
    }

    @NonNull
    private ArrayList<T> getEmptyList() {
        ArrayList<T> acquire = this.mListPool.acquire();
        return acquire == null ? new ArrayList<>() : acquire;
    }

    private void poolList(@NonNull ArrayList<T> arrayList) {
        arrayList.clear();
        this.mListPool.release(arrayList);
    }

    public void addEdge(@NonNull T t, @NonNull T t2) {
        if (!this.mGraph.containsKey(t) || !this.mGraph.containsKey(t2)) {
            throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
        }
        ArrayList<T> arrayList = (ArrayList) this.mGraph.get(t);
        if (arrayList == null) {
            arrayList = getEmptyList();
            this.mGraph.put(t, arrayList);
        }
        arrayList.add(t2);
    }

    public void addNode(@NonNull T t) {
        if (this.mGraph.containsKey(t)) {
            return;
        }
        this.mGraph.put(t, (Object) null);
    }

    public void clear() {
        int size = this.mGraph.size();
        for (int i = 0; i < size; i++) {
            ArrayList<T> arrayList = (ArrayList) this.mGraph.valueAt(i);
            if (arrayList != null) {
                poolList(arrayList);
            }
        }
        this.mGraph.clear();
    }

    public boolean contains(@NonNull T t) {
        return this.mGraph.containsKey(t);
    }

    @Nullable
    public List<T> getIncomingEdges(@NonNull T t) {
        ArrayList<T> incomingEdgesInternal = getIncomingEdgesInternal(t);
        if (incomingEdgesInternal == null) {
            return null;
        }
        return new ArrayList(incomingEdgesInternal);
    }

    @Nullable
    ArrayList<T> getIncomingEdgesInternal(@NonNull T t) {
        return (ArrayList) this.mGraph.get(t);
    }

    @Nullable
    public List<T> getOutgoingEdges(@NonNull T t) {
        int size = this.mGraph.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            ArrayList arrayList2 = (ArrayList) this.mGraph.valueAt(i);
            if (arrayList2 != null && arrayList2.contains(t)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(this.mGraph.keyAt(i));
            }
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    public ArrayList<T> getSortedList() {
        this.mSortResult.clear();
        this.mSortTmpMarked.clear();
        int size = this.mGraph.size();
        for (int i = 0; i < size; i++) {
            dfs(this.mGraph.keyAt(i), this.mSortResult, this.mSortTmpMarked);
        }
        return this.mSortResult;
    }

    public boolean hasOutgoingEdges(@NonNull T t) {
        int size = this.mGraph.size();
        for (int i = 0; i < size; i++) {
            ArrayList arrayList = (ArrayList) this.mGraph.valueAt(i);
            if (arrayList != null && arrayList.contains(t)) {
                return true;
            }
        }
        return false;
    }

    int size() {
        return this.mGraph.size();
    }
}
