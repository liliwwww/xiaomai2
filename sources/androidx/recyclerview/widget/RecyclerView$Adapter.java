package androidx.recyclerview.widget;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.os.TraceCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public abstract class RecyclerView$Adapter<VH extends RecyclerView$ViewHolder> {
    private final RecyclerView.AdapterDataObservable mObservable = new RecyclerView.AdapterDataObservable();
    private boolean mHasStableIds = false;
    private StateRestorationPolicy mStateRestorationPolicy = StateRestorationPolicy.ALLOW;

    /* JADX WARN: Multi-variable type inference failed */
    public final void bindViewHolder(@NonNull VH vh, int i) {
        boolean z = vh.mBindingAdapter == null;
        if (z) {
            vh.mPosition = i;
            if (hasStableIds()) {
                vh.mItemId = getItemId(i);
            }
            vh.setFlags(1, 519);
            TraceCompat.beginSection("RV OnBindView");
        }
        vh.mBindingAdapter = this;
        onBindViewHolder(vh, i, vh.getUnmodifiedPayloads());
        if (z) {
            vh.clearPayload();
            ViewGroup.LayoutParams layoutParams = vh.itemView.getLayoutParams();
            if (layoutParams instanceof RecyclerView$LayoutParams) {
                ((RecyclerView$LayoutParams) layoutParams).mInsetsDirty = true;
            }
            TraceCompat.endSection();
        }
    }

    boolean canRestoreState() {
        int i = RecyclerView$7.$SwitchMap$androidx$recyclerview$widget$RecyclerView$Adapter$StateRestorationPolicy[this.mStateRestorationPolicy.ordinal()];
        if (i != 1) {
            return i != 2 || getItemCount() > 0;
        }
        return false;
    }

    @NonNull
    public final VH createViewHolder(@NonNull ViewGroup viewGroup, int i) {
        try {
            TraceCompat.beginSection("RV CreateView");
            VH onCreateViewHolder = onCreateViewHolder(viewGroup, i);
            if (onCreateViewHolder.itemView.getParent() != null) {
                throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
            }
            onCreateViewHolder.mItemViewType = i;
            return onCreateViewHolder;
        } finally {
            TraceCompat.endSection();
        }
    }

    public int findRelativeAdapterPositionIn(@NonNull RecyclerView$Adapter<? extends RecyclerView$ViewHolder> recyclerView$Adapter, @NonNull RecyclerView$ViewHolder recyclerView$ViewHolder, int i) {
        if (recyclerView$Adapter == this) {
            return i;
        }
        return -1;
    }

    public abstract int getItemCount();

    public long getItemId(int i) {
        return -1L;
    }

    public int getItemViewType(int i) {
        return 0;
    }

    @NonNull
    public final StateRestorationPolicy getStateRestorationPolicy() {
        return this.mStateRestorationPolicy;
    }

    public final boolean hasObservers() {
        return this.mObservable.hasObservers();
    }

    public final boolean hasStableIds() {
        return this.mHasStableIds;
    }

    public final void notifyDataSetChanged() {
        this.mObservable.notifyChanged();
    }

    public final void notifyItemChanged(int i) {
        this.mObservable.notifyItemRangeChanged(i, 1);
    }

    public final void notifyItemInserted(int i) {
        this.mObservable.notifyItemRangeInserted(i, 1);
    }

    public final void notifyItemMoved(int i, int i2) {
        this.mObservable.notifyItemMoved(i, i2);
    }

    public final void notifyItemRangeChanged(int i, int i2) {
        this.mObservable.notifyItemRangeChanged(i, i2);
    }

    public final void notifyItemRangeInserted(int i, int i2) {
        this.mObservable.notifyItemRangeInserted(i, i2);
    }

    public final void notifyItemRangeRemoved(int i, int i2) {
        this.mObservable.notifyItemRangeRemoved(i, i2);
    }

    public final void notifyItemRemoved(int i) {
        this.mObservable.notifyItemRangeRemoved(i, 1);
    }

    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
    }

    public abstract void onBindViewHolder(@NonNull VH vh, int i);

    public void onBindViewHolder(@NonNull VH vh, int i, @NonNull List<Object> list) {
        onBindViewHolder(vh, i);
    }

    @NonNull
    public abstract VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i);

    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
    }

    public boolean onFailedToRecycleView(@NonNull VH vh) {
        return false;
    }

    public void onViewAttachedToWindow(@NonNull VH vh) {
    }

    public void onViewDetachedFromWindow(@NonNull VH vh) {
    }

    public void onViewRecycled(@NonNull VH vh) {
    }

    public void registerAdapterDataObserver(@NonNull RecyclerView.AdapterDataObserver adapterDataObserver) {
        this.mObservable.registerObserver(adapterDataObserver);
    }

    public void setHasStableIds(boolean z) {
        if (hasObservers()) {
            throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
        }
        this.mHasStableIds = z;
    }

    public void setStateRestorationPolicy(@NonNull StateRestorationPolicy stateRestorationPolicy) {
        this.mStateRestorationPolicy = stateRestorationPolicy;
        this.mObservable.notifyStateRestorationPolicyChanged();
    }

    public void unregisterAdapterDataObserver(@NonNull RecyclerView.AdapterDataObserver adapterDataObserver) {
        this.mObservable.unregisterObserver(adapterDataObserver);
    }

    public final void notifyItemChanged(int i, @Nullable Object obj) {
        this.mObservable.notifyItemRangeChanged(i, 1, obj);
    }

    public final void notifyItemRangeChanged(int i, int i2, @Nullable Object obj) {
        this.mObservable.notifyItemRangeChanged(i, i2, obj);
    }
}
