package androidx.recyclerview.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public abstract class ListAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
    final AsyncListDiffer<T> mDiffer;
    private final AsyncListDiffer.ListListener<T> mListener;

    protected ListAdapter(@NonNull DiffUtil.ItemCallback<T> itemCallback) {
        AsyncListDiffer.ListListener<T> listListener = new 1<>(this);
        this.mListener = listListener;
        AsyncListDiffer<T> asyncListDiffer = new AsyncListDiffer<>((ListUpdateCallback) new AdapterListUpdateCallback(this), (AsyncDifferConfig) new AsyncDifferConfig.Builder(itemCallback).build());
        this.mDiffer = asyncListDiffer;
        asyncListDiffer.addListListener(listListener);
    }

    @NonNull
    public List<T> getCurrentList() {
        return this.mDiffer.getCurrentList();
    }

    protected T getItem(int i) {
        return this.mDiffer.getCurrentList().get(i);
    }

    public int getItemCount() {
        return this.mDiffer.getCurrentList().size();
    }

    public void onCurrentListChanged(@NonNull List<T> list, @NonNull List<T> list2) {
    }

    public void submitList(@Nullable List<T> list) {
        this.mDiffer.submitList(list);
    }

    public void submitList(@Nullable List<T> list, @Nullable Runnable runnable) {
        this.mDiffer.submitList(list, runnable);
    }

    protected ListAdapter(@NonNull AsyncDifferConfig<T> asyncDifferConfig) {
        AsyncListDiffer.ListListener<T> listListener = new 1<>(this);
        this.mListener = listListener;
        AsyncListDiffer<T> asyncListDiffer = new AsyncListDiffer<>((ListUpdateCallback) new AdapterListUpdateCallback(this), (AsyncDifferConfig) asyncDifferConfig);
        this.mDiffer = asyncListDiffer;
        asyncListDiffer.addListListener(listListener);
    }
}
