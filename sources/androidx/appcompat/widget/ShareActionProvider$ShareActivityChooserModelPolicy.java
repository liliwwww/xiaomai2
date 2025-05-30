package androidx.appcompat.widget;

import android.content.Intent;
import androidx.appcompat.widget.ActivityChooserModel;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class ShareActionProvider$ShareActivityChooserModelPolicy implements ActivityChooserModel.OnChooseActivityListener {
    final /* synthetic */ ShareActionProvider this$0;

    ShareActionProvider$ShareActivityChooserModelPolicy(ShareActionProvider shareActionProvider) {
        this.this$0 = shareActionProvider;
    }

    public boolean onChooseActivity(ActivityChooserModel activityChooserModel, Intent intent) {
        ShareActionProvider shareActionProvider = this.this$0;
        ShareActionProvider$OnShareTargetSelectedListener shareActionProvider$OnShareTargetSelectedListener = shareActionProvider.mOnShareTargetSelectedListener;
        if (shareActionProvider$OnShareTargetSelectedListener == null) {
            return false;
        }
        shareActionProvider$OnShareTargetSelectedListener.onShareTargetSelected(shareActionProvider, intent);
        return false;
    }
}
