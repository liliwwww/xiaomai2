package androidx.emoji2.viewsintegration;

import android.widget.EditText;
import androidx.annotation.RequiresApi;
import androidx.emoji2.text.EmojiCompat;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
@RequiresApi(19)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class EmojiTextWatcher$InitCallbackImpl extends EmojiCompat.InitCallback {
    private final Reference<EditText> mViewRef;

    EmojiTextWatcher$InitCallbackImpl(EditText editText) {
        this.mViewRef = new WeakReference(editText);
    }

    public void onInitialized() {
        super.onInitialized();
        EmojiTextWatcher.processTextOnEnablingEvent(this.mViewRef.get(), 1);
    }
}
