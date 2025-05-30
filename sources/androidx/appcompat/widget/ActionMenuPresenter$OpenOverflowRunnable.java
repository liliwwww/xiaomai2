package androidx.appcompat.widget;

import android.view.View;
import androidx.appcompat.widget.ActionMenuPresenter;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class ActionMenuPresenter$OpenOverflowRunnable implements Runnable {
    private ActionMenuPresenter.OverflowPopup mPopup;
    final /* synthetic */ ActionMenuPresenter this$0;

    public ActionMenuPresenter$OpenOverflowRunnable(ActionMenuPresenter actionMenuPresenter, ActionMenuPresenter.OverflowPopup overflowPopup) {
        this.this$0 = actionMenuPresenter;
        this.mPopup = overflowPopup;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (ActionMenuPresenter.access$400(this.this$0) != null) {
            ActionMenuPresenter.access$500(this.this$0).changeMenuMode();
        }
        View access$600 = ActionMenuPresenter.access$600(this.this$0);
        if (access$600 != null && access$600.getWindowToken() != null && this.mPopup.tryShow()) {
            this.this$0.mOverflowPopup = this.mPopup;
        }
        this.this$0.mPostedOpenRunnable = null;
    }
}
