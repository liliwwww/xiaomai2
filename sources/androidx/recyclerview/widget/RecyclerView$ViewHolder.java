package androidx.recyclerview.widget;

import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.ViewCompat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public abstract class RecyclerView$ViewHolder {
    static final int FLAG_ADAPTER_FULLUPDATE = 1024;
    static final int FLAG_ADAPTER_POSITION_UNKNOWN = 512;
    static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
    static final int FLAG_BOUNCED_FROM_HIDDEN_LIST = 8192;
    static final int FLAG_BOUND = 1;
    static final int FLAG_IGNORE = 128;
    static final int FLAG_INVALID = 4;
    static final int FLAG_MOVED = 2048;
    static final int FLAG_NOT_RECYCLABLE = 16;
    static final int FLAG_REMOVED = 8;
    static final int FLAG_RETURNED_FROM_SCRAP = 32;
    static final int FLAG_TMP_DETACHED = 256;
    static final int FLAG_UPDATE = 2;
    private static final List<Object> FULLUPDATE_PAYLOADS = Collections.emptyList();
    static final int PENDING_ACCESSIBILITY_STATE_NOT_SET = -1;

    @NonNull
    public final View itemView;
    RecyclerView$Adapter<? extends RecyclerView$ViewHolder> mBindingAdapter;
    int mFlags;
    WeakReference<RecyclerView> mNestedRecyclerView;
    RecyclerView mOwnerRecyclerView;
    int mPosition = -1;
    int mOldPosition = -1;
    long mItemId = -1;
    int mItemViewType = -1;
    int mPreLayoutPosition = -1;
    RecyclerView$ViewHolder mShadowedHolder = null;
    RecyclerView$ViewHolder mShadowingHolder = null;
    List<Object> mPayloads = null;
    List<Object> mUnmodifiedPayloads = null;
    private int mIsRecyclableCount = 0;
    RecyclerView$Recycler mScrapContainer = null;
    boolean mInChangeScrap = false;
    private int mWasImportantForAccessibilityBeforeHidden = 0;

    @VisibleForTesting
    int mPendingAccessibilityState = -1;

    public RecyclerView$ViewHolder(@NonNull View view) {
        if (view == null) {
            throw new IllegalArgumentException("itemView may not be null");
        }
        this.itemView = view;
    }

    private void createPayloadsIfNeeded() {
        if (this.mPayloads == null) {
            ArrayList arrayList = new ArrayList();
            this.mPayloads = arrayList;
            this.mUnmodifiedPayloads = Collections.unmodifiableList(arrayList);
        }
    }

    void addChangePayload(Object obj) {
        if (obj == null) {
            addFlags(1024);
        } else if ((1024 & this.mFlags) == 0) {
            createPayloadsIfNeeded();
            this.mPayloads.add(obj);
        }
    }

    void addFlags(int i) {
        this.mFlags = i | this.mFlags;
    }

    void clearOldPosition() {
        this.mOldPosition = -1;
        this.mPreLayoutPosition = -1;
    }

    void clearPayload() {
        List<Object> list = this.mPayloads;
        if (list != null) {
            list.clear();
        }
        this.mFlags &= -1025;
    }

    void clearReturnedFromScrapFlag() {
        this.mFlags &= -33;
    }

    void clearTmpDetachFlag() {
        this.mFlags &= -257;
    }

    boolean doesTransientStatePreventRecycling() {
        return (this.mFlags & 16) == 0 && ViewCompat.hasTransientState(this.itemView);
    }

    void flagRemovedAndOffsetPosition(int i, int i2, boolean z) {
        addFlags(8);
        offsetPosition(i2, z);
        this.mPosition = i;
    }

    public final int getAbsoluteAdapterPosition() {
        RecyclerView recyclerView = this.mOwnerRecyclerView;
        if (recyclerView == null) {
            return -1;
        }
        return recyclerView.getAdapterPositionInRecyclerView(this);
    }

    @Deprecated
    public final int getAdapterPosition() {
        return getBindingAdapterPosition();
    }

    @Nullable
    public final RecyclerView$Adapter<? extends RecyclerView$ViewHolder> getBindingAdapter() {
        return this.mBindingAdapter;
    }

    public final int getBindingAdapterPosition() {
        RecyclerView recyclerView;
        RecyclerView$Adapter adapter;
        int adapterPositionInRecyclerView;
        if (this.mBindingAdapter == null || (recyclerView = this.mOwnerRecyclerView) == null || (adapter = recyclerView.getAdapter()) == null || (adapterPositionInRecyclerView = this.mOwnerRecyclerView.getAdapterPositionInRecyclerView(this)) == -1) {
            return -1;
        }
        return adapter.findRelativeAdapterPositionIn(this.mBindingAdapter, this, adapterPositionInRecyclerView);
    }

    public final long getItemId() {
        return this.mItemId;
    }

    public final int getItemViewType() {
        return this.mItemViewType;
    }

    public final int getLayoutPosition() {
        int i = this.mPreLayoutPosition;
        return i == -1 ? this.mPosition : i;
    }

    public final int getOldPosition() {
        return this.mOldPosition;
    }

    @Deprecated
    public final int getPosition() {
        int i = this.mPreLayoutPosition;
        return i == -1 ? this.mPosition : i;
    }

    List<Object> getUnmodifiedPayloads() {
        if ((this.mFlags & 1024) != 0) {
            return FULLUPDATE_PAYLOADS;
        }
        List<Object> list = this.mPayloads;
        return (list == null || list.size() == 0) ? FULLUPDATE_PAYLOADS : this.mUnmodifiedPayloads;
    }

    boolean hasAnyOfTheFlags(int i) {
        return (i & this.mFlags) != 0;
    }

    boolean isAdapterPositionUnknown() {
        return (this.mFlags & 512) != 0 || isInvalid();
    }

    boolean isAttachedToTransitionOverlay() {
        return (this.itemView.getParent() == null || this.itemView.getParent() == this.mOwnerRecyclerView) ? false : true;
    }

    boolean isBound() {
        return (this.mFlags & 1) != 0;
    }

    boolean isInvalid() {
        return (this.mFlags & 4) != 0;
    }

    public final boolean isRecyclable() {
        return (this.mFlags & 16) == 0 && !ViewCompat.hasTransientState(this.itemView);
    }

    boolean isRemoved() {
        return (this.mFlags & 8) != 0;
    }

    boolean isScrap() {
        return this.mScrapContainer != null;
    }

    boolean isTmpDetached() {
        return (this.mFlags & 256) != 0;
    }

    boolean isUpdated() {
        return (this.mFlags & 2) != 0;
    }

    boolean needsUpdate() {
        return (this.mFlags & 2) != 0;
    }

    void offsetPosition(int i, boolean z) {
        if (this.mOldPosition == -1) {
            this.mOldPosition = this.mPosition;
        }
        if (this.mPreLayoutPosition == -1) {
            this.mPreLayoutPosition = this.mPosition;
        }
        if (z) {
            this.mPreLayoutPosition += i;
        }
        this.mPosition += i;
        if (this.itemView.getLayoutParams() != null) {
            ((RecyclerView$LayoutParams) this.itemView.getLayoutParams()).mInsetsDirty = true;
        }
    }

    void onEnteredHiddenState(RecyclerView recyclerView) {
        int i = this.mPendingAccessibilityState;
        if (i != -1) {
            this.mWasImportantForAccessibilityBeforeHidden = i;
        } else {
            this.mWasImportantForAccessibilityBeforeHidden = ViewCompat.getImportantForAccessibility(this.itemView);
        }
        recyclerView.setChildImportantForAccessibilityInternal(this, 4);
    }

    void onLeftHiddenState(RecyclerView recyclerView) {
        recyclerView.setChildImportantForAccessibilityInternal(this, this.mWasImportantForAccessibilityBeforeHidden);
        this.mWasImportantForAccessibilityBeforeHidden = 0;
    }

    void resetInternal() {
        this.mFlags = 0;
        this.mPosition = -1;
        this.mOldPosition = -1;
        this.mItemId = -1L;
        this.mPreLayoutPosition = -1;
        this.mIsRecyclableCount = 0;
        this.mShadowedHolder = null;
        this.mShadowingHolder = null;
        clearPayload();
        this.mWasImportantForAccessibilityBeforeHidden = 0;
        this.mPendingAccessibilityState = -1;
        RecyclerView.clearNestedRecyclerViewIfNotNested(this);
    }

    void saveOldPosition() {
        if (this.mOldPosition == -1) {
            this.mOldPosition = this.mPosition;
        }
    }

    void setFlags(int i, int i2) {
        this.mFlags = (i & i2) | (this.mFlags & (~i2));
    }

    public final void setIsRecyclable(boolean z) {
        int i = this.mIsRecyclableCount;
        int i2 = z ? i - 1 : i + 1;
        this.mIsRecyclableCount = i2;
        if (i2 < 0) {
            this.mIsRecyclableCount = 0;
            Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
            return;
        }
        if (!z && i2 == 1) {
            this.mFlags |= 16;
        } else if (z && i2 == 0) {
            this.mFlags &= -17;
        }
    }

    void setScrapContainer(RecyclerView$Recycler recyclerView$Recycler, boolean z) {
        this.mScrapContainer = recyclerView$Recycler;
        this.mInChangeScrap = z;
    }

    boolean shouldBeKeptAsChild() {
        return (this.mFlags & 16) != 0;
    }

    boolean shouldIgnore() {
        return (this.mFlags & 128) != 0;
    }

    void stopIgnoring() {
        this.mFlags &= -129;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((getClass().isAnonymousClass() ? "ViewHolder" : getClass().getSimpleName()) + "{" + Integer.toHexString(hashCode()) + " position=" + this.mPosition + " id=" + this.mItemId + ", oldPos=" + this.mOldPosition + ", pLpos:" + this.mPreLayoutPosition);
        if (isScrap()) {
            sb.append(" scrap ");
            sb.append(this.mInChangeScrap ? "[changeScrap]" : "[attachedScrap]");
        }
        if (isInvalid()) {
            sb.append(" invalid");
        }
        if (!isBound()) {
            sb.append(" unbound");
        }
        if (needsUpdate()) {
            sb.append(" update");
        }
        if (isRemoved()) {
            sb.append(" removed");
        }
        if (shouldIgnore()) {
            sb.append(" ignored");
        }
        if (isTmpDetached()) {
            sb.append(" tmpDetached");
        }
        if (!isRecyclable()) {
            sb.append(" not recyclable(" + this.mIsRecyclableCount + ")");
        }
        if (isAdapterPositionUnknown()) {
            sb.append(" undefined adapter position");
        }
        if (this.itemView.getParent() == null) {
            sb.append(" no parent");
        }
        sb.append("}");
        return sb.toString();
    }

    void unScrap() {
        this.mScrapContainer.unscrapView(this);
    }

    boolean wasReturnedFromScrap() {
        return (this.mFlags & 32) != 0;
    }
}
