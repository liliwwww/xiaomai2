package androidx.appcompat.widget;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.widget.AppCompatSpinner;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class AppCompatSpinner$DropdownPopup$1 implements AdapterView.OnItemClickListener {
    final /* synthetic */ AppCompatSpinner.DropdownPopup this$1;
    final /* synthetic */ AppCompatSpinner val$this$0;

    AppCompatSpinner$DropdownPopup$1(AppCompatSpinner.DropdownPopup dropdownPopup, AppCompatSpinner appCompatSpinner) {
        this.this$1 = dropdownPopup;
        this.val$this$0 = appCompatSpinner;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.this$1.this$0.setSelection(i);
        if (this.this$1.this$0.getOnItemClickListener() != null) {
            AppCompatSpinner.DropdownPopup dropdownPopup = this.this$1;
            dropdownPopup.this$0.performItemClick(view, i, dropdownPopup.mAdapter.getItemId(i));
        }
        this.this$1.dismiss();
    }
}
