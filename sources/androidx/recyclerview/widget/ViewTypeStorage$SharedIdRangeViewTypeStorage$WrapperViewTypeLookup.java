package androidx.recyclerview.widget;

import androidx.recyclerview.widget.ViewTypeStorage;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class ViewTypeStorage$SharedIdRangeViewTypeStorage$WrapperViewTypeLookup implements ViewTypeStorage.ViewTypeLookup {
    final NestedAdapterWrapper mWrapper;
    final /* synthetic */ ViewTypeStorage.SharedIdRangeViewTypeStorage this$0;

    ViewTypeStorage$SharedIdRangeViewTypeStorage$WrapperViewTypeLookup(ViewTypeStorage.SharedIdRangeViewTypeStorage sharedIdRangeViewTypeStorage, NestedAdapterWrapper nestedAdapterWrapper) {
        this.this$0 = sharedIdRangeViewTypeStorage;
        this.mWrapper = nestedAdapterWrapper;
    }

    public void dispose() {
        this.this$0.removeWrapper(this.mWrapper);
    }

    public int globalToLocal(int i) {
        return i;
    }

    public int localToGlobal(int i) {
        List list = (List) this.this$0.mGlobalTypeToWrapper.get(i);
        if (list == null) {
            list = new ArrayList();
            this.this$0.mGlobalTypeToWrapper.put(i, list);
        }
        if (!list.contains(this.mWrapper)) {
            list.add(this.mWrapper);
        }
        return i;
    }
}
