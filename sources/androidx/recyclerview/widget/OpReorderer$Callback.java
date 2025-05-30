package androidx.recyclerview.widget;

import androidx.recyclerview.widget.AdapterHelper;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
interface OpReorderer$Callback {
    AdapterHelper.UpdateOp obtainUpdateOp(int i, int i2, int i3, Object obj);

    void recycleUpdateOp(AdapterHelper.UpdateOp updateOp);
}
