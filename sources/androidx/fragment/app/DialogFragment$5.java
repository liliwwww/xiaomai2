package androidx.fragment.app;

import android.view.View;
import androidx.annotation.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class DialogFragment$5 extends FragmentContainer {
    final /* synthetic */ DialogFragment this$0;
    final /* synthetic */ FragmentContainer val$fragmentContainer;

    DialogFragment$5(DialogFragment dialogFragment, FragmentContainer fragmentContainer) {
        this.this$0 = dialogFragment;
        this.val$fragmentContainer = fragmentContainer;
    }

    @Nullable
    public View onFindViewById(int i) {
        return this.val$fragmentContainer.onHasView() ? this.val$fragmentContainer.onFindViewById(i) : this.this$0.onFindViewById(i);
    }

    public boolean onHasView() {
        return this.val$fragmentContainer.onHasView() || this.this$0.onHasView();
    }
}
