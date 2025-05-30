package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class StaggeredGridLayoutManager$LazySpanLookup {
    private static final int MIN_SIZE = 10;
    int[] mData;
    List<FullSpanItem> mFullSpanItems;

    StaggeredGridLayoutManager$LazySpanLookup() {
    }

    private int invalidateFullSpansAfter(int i) {
        if (this.mFullSpanItems == null) {
            return -1;
        }
        FullSpanItem fullSpanItem = getFullSpanItem(i);
        if (fullSpanItem != null) {
            this.mFullSpanItems.remove(fullSpanItem);
        }
        int size = this.mFullSpanItems.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                i2 = -1;
                break;
            }
            if (this.mFullSpanItems.get(i2).mPosition >= i) {
                break;
            }
            i2++;
        }
        if (i2 == -1) {
            return -1;
        }
        FullSpanItem fullSpanItem2 = this.mFullSpanItems.get(i2);
        this.mFullSpanItems.remove(i2);
        return fullSpanItem2.mPosition;
    }

    private void offsetFullSpansForAddition(int i, int i2) {
        List<FullSpanItem> list = this.mFullSpanItems;
        if (list == null) {
            return;
        }
        for (int size = list.size() - 1; size >= 0; size--) {
            FullSpanItem fullSpanItem = this.mFullSpanItems.get(size);
            int i3 = fullSpanItem.mPosition;
            if (i3 >= i) {
                fullSpanItem.mPosition = i3 + i2;
            }
        }
    }

    private void offsetFullSpansForRemoval(int i, int i2) {
        List<FullSpanItem> list = this.mFullSpanItems;
        if (list == null) {
            return;
        }
        int i3 = i + i2;
        for (int size = list.size() - 1; size >= 0; size--) {
            FullSpanItem fullSpanItem = this.mFullSpanItems.get(size);
            int i4 = fullSpanItem.mPosition;
            if (i4 >= i) {
                if (i4 < i3) {
                    this.mFullSpanItems.remove(size);
                } else {
                    fullSpanItem.mPosition = i4 - i2;
                }
            }
        }
    }

    public void addFullSpanItem(FullSpanItem fullSpanItem) {
        if (this.mFullSpanItems == null) {
            this.mFullSpanItems = new ArrayList();
        }
        int size = this.mFullSpanItems.size();
        for (int i = 0; i < size; i++) {
            FullSpanItem fullSpanItem2 = this.mFullSpanItems.get(i);
            if (fullSpanItem2.mPosition == fullSpanItem.mPosition) {
                this.mFullSpanItems.remove(i);
            }
            if (fullSpanItem2.mPosition >= fullSpanItem.mPosition) {
                this.mFullSpanItems.add(i, fullSpanItem);
                return;
            }
        }
        this.mFullSpanItems.add(fullSpanItem);
    }

    void clear() {
        int[] iArr = this.mData;
        if (iArr != null) {
            Arrays.fill(iArr, -1);
        }
        this.mFullSpanItems = null;
    }

    void ensureSize(int i) {
        int[] iArr = this.mData;
        if (iArr == null) {
            int[] iArr2 = new int[Math.max(i, 10) + 1];
            this.mData = iArr2;
            Arrays.fill(iArr2, -1);
        } else if (i >= iArr.length) {
            int[] iArr3 = new int[sizeForPosition(i)];
            this.mData = iArr3;
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            int[] iArr4 = this.mData;
            Arrays.fill(iArr4, iArr.length, iArr4.length, -1);
        }
    }

    int forceInvalidateAfter(int i) {
        List<FullSpanItem> list = this.mFullSpanItems;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                if (this.mFullSpanItems.get(size).mPosition >= i) {
                    this.mFullSpanItems.remove(size);
                }
            }
        }
        return invalidateAfter(i);
    }

    public FullSpanItem getFirstFullSpanItemInRange(int i, int i2, int i3, boolean z) {
        List<FullSpanItem> list = this.mFullSpanItems;
        if (list == null) {
            return null;
        }
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            FullSpanItem fullSpanItem = this.mFullSpanItems.get(i4);
            int i5 = fullSpanItem.mPosition;
            if (i5 >= i2) {
                return null;
            }
            if (i5 >= i && (i3 == 0 || fullSpanItem.mGapDir == i3 || (z && fullSpanItem.mHasUnwantedGapAfter))) {
                return fullSpanItem;
            }
        }
        return null;
    }

    public FullSpanItem getFullSpanItem(int i) {
        List<FullSpanItem> list = this.mFullSpanItems;
        if (list == null) {
            return null;
        }
        for (int size = list.size() - 1; size >= 0; size--) {
            FullSpanItem fullSpanItem = this.mFullSpanItems.get(size);
            if (fullSpanItem.mPosition == i) {
                return fullSpanItem;
            }
        }
        return null;
    }

    int getSpan(int i) {
        int[] iArr = this.mData;
        if (iArr == null || i >= iArr.length) {
            return -1;
        }
        return iArr[i];
    }

    int invalidateAfter(int i) {
        int[] iArr = this.mData;
        if (iArr == null || i >= iArr.length) {
            return -1;
        }
        int invalidateFullSpansAfter = invalidateFullSpansAfter(i);
        if (invalidateFullSpansAfter == -1) {
            int[] iArr2 = this.mData;
            Arrays.fill(iArr2, i, iArr2.length, -1);
            return this.mData.length;
        }
        int min = Math.min(invalidateFullSpansAfter + 1, this.mData.length);
        Arrays.fill(this.mData, i, min, -1);
        return min;
    }

    void offsetForAddition(int i, int i2) {
        int[] iArr = this.mData;
        if (iArr == null || i >= iArr.length) {
            return;
        }
        int i3 = i + i2;
        ensureSize(i3);
        int[] iArr2 = this.mData;
        System.arraycopy(iArr2, i, iArr2, i3, (iArr2.length - i) - i2);
        Arrays.fill(this.mData, i, i3, -1);
        offsetFullSpansForAddition(i, i2);
    }

    void offsetForRemoval(int i, int i2) {
        int[] iArr = this.mData;
        if (iArr == null || i >= iArr.length) {
            return;
        }
        int i3 = i + i2;
        ensureSize(i3);
        int[] iArr2 = this.mData;
        System.arraycopy(iArr2, i3, iArr2, i, (iArr2.length - i) - i2);
        int[] iArr3 = this.mData;
        Arrays.fill(iArr3, iArr3.length - i2, iArr3.length, -1);
        offsetFullSpansForRemoval(i, i2);
    }

    void setSpan(int i, StaggeredGridLayoutManager$Span staggeredGridLayoutManager$Span) {
        ensureSize(i);
        this.mData[i] = staggeredGridLayoutManager$Span.mIndex;
    }

    int sizeForPosition(int i) {
        int length = this.mData.length;
        while (length <= i) {
            length *= 2;
        }
        return length;
    }

    /* compiled from: Taobao */
    @SuppressLint({"BanParcelableUsage"})
    static class FullSpanItem implements Parcelable {
        public static final Parcelable.Creator<FullSpanItem> CREATOR = new Parcelable.Creator<FullSpanItem>() { // from class: androidx.recyclerview.widget.StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public FullSpanItem createFromParcel(Parcel parcel) {
                return new FullSpanItem(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public FullSpanItem[] newArray(int i) {
                return new FullSpanItem[i];
            }
        };
        int mGapDir;
        int[] mGapPerSpan;
        boolean mHasUnwantedGapAfter;
        int mPosition;

        FullSpanItem(Parcel parcel) {
            this.mPosition = parcel.readInt();
            this.mGapDir = parcel.readInt();
            this.mHasUnwantedGapAfter = parcel.readInt() == 1;
            int readInt = parcel.readInt();
            if (readInt > 0) {
                int[] iArr = new int[readInt];
                this.mGapPerSpan = iArr;
                parcel.readIntArray(iArr);
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        int getGapForSpan(int i) {
            int[] iArr = this.mGapPerSpan;
            if (iArr == null) {
                return 0;
            }
            return iArr[i];
        }

        public String toString() {
            return "FullSpanItem{mPosition=" + this.mPosition + ", mGapDir=" + this.mGapDir + ", mHasUnwantedGapAfter=" + this.mHasUnwantedGapAfter + ", mGapPerSpan=" + Arrays.toString(this.mGapPerSpan) + '}';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.mPosition);
            parcel.writeInt(this.mGapDir);
            parcel.writeInt(this.mHasUnwantedGapAfter ? 1 : 0);
            int[] iArr = this.mGapPerSpan;
            if (iArr == null || iArr.length <= 0) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(iArr.length);
                parcel.writeIntArray(this.mGapPerSpan);
            }
        }

        FullSpanItem() {
        }
    }
}
