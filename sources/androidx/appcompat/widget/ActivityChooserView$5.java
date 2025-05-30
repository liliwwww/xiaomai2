package androidx.appcompat.widget;

import android.database.DataSetObserver;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class ActivityChooserView$5 extends DataSetObserver {
    final /* synthetic */ ActivityChooserView this$0;

    ActivityChooserView$5(ActivityChooserView activityChooserView) {
        this.this$0 = activityChooserView;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        super.onChanged();
        this.this$0.updateAppearance();
    }
}
