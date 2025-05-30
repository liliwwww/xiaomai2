package androidx.appcompat.widget;

import android.view.View;
import android.widget.AdapterView;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class ListPopupWindow$3 implements AdapterView.OnItemSelectedListener {
    final /* synthetic */ ListPopupWindow this$0;

    ListPopupWindow$3(ListPopupWindow listPopupWindow) {
        this.this$0 = listPopupWindow;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        DropDownListView dropDownListView;
        if (i == -1 || (dropDownListView = this.this$0.mDropDownList) == null) {
            return;
        }
        dropDownListView.setListSelectionHidden(false);
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
