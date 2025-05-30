package androidx.recyclerview.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
interface NestedAdapterWrapper$Callback {
    void onChanged(@NonNull NestedAdapterWrapper nestedAdapterWrapper);

    void onItemRangeChanged(@NonNull NestedAdapterWrapper nestedAdapterWrapper, int i, int i2);

    void onItemRangeChanged(@NonNull NestedAdapterWrapper nestedAdapterWrapper, int i, int i2, @Nullable Object obj);

    void onItemRangeInserted(@NonNull NestedAdapterWrapper nestedAdapterWrapper, int i, int i2);

    void onItemRangeMoved(@NonNull NestedAdapterWrapper nestedAdapterWrapper, int i, int i2);

    void onItemRangeRemoved(@NonNull NestedAdapterWrapper nestedAdapterWrapper, int i, int i2);

    void onStateRestorationPolicyChanged(NestedAdapterWrapper nestedAdapterWrapper);
}
