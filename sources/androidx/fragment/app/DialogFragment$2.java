package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import androidx.annotation.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class DialogFragment$2 implements DialogInterface.OnCancelListener {
    final /* synthetic */ DialogFragment this$0;

    DialogFragment$2(DialogFragment dialogFragment) {
        this.this$0 = dialogFragment;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    @SuppressLint({"SyntheticAccessor"})
    public void onCancel(@Nullable DialogInterface dialogInterface) {
        if (DialogFragment.access$000(this.this$0) != null) {
            DialogFragment dialogFragment = this.this$0;
            dialogFragment.onCancel(DialogFragment.access$000(dialogFragment));
        }
    }
}
