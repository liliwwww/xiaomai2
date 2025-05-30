package androidx.emoji2.text;

import android.os.Build;
import android.text.Editable;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.TextWatcher;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class SpannableBuilder$WatcherWrapper implements SpanWatcher, TextWatcher {
    private final AtomicInteger mBlockCalls = new AtomicInteger(0);
    final Object mObject;

    SpannableBuilder$WatcherWrapper(Object obj) {
        this.mObject = obj;
    }

    private boolean isEmojiSpan(Object obj) {
        return obj instanceof EmojiSpan;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        ((TextWatcher) this.mObject).afterTextChanged(editable);
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        ((TextWatcher) this.mObject).beforeTextChanged(charSequence, i, i2, i3);
    }

    final void blockCalls() {
        this.mBlockCalls.incrementAndGet();
    }

    @Override // android.text.SpanWatcher
    public void onSpanAdded(Spannable spannable, Object obj, int i, int i2) {
        if (this.mBlockCalls.get() <= 0 || !isEmojiSpan(obj)) {
            ((SpanWatcher) this.mObject).onSpanAdded(spannable, obj, i, i2);
        }
    }

    @Override // android.text.SpanWatcher
    public void onSpanChanged(Spannable spannable, Object obj, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        if (this.mBlockCalls.get() <= 0 || !isEmojiSpan(obj)) {
            if (Build.VERSION.SDK_INT < 28) {
                int i7 = i > i2 ? 0 : i;
                if (i3 > i4) {
                    i5 = i7;
                    i6 = 0;
                } else {
                    i6 = i3;
                    i5 = i7;
                }
            } else {
                i5 = i;
                i6 = i3;
            }
            ((SpanWatcher) this.mObject).onSpanChanged(spannable, obj, i5, i2, i6, i4);
        }
    }

    @Override // android.text.SpanWatcher
    public void onSpanRemoved(Spannable spannable, Object obj, int i, int i2) {
        if (this.mBlockCalls.get() <= 0 || !isEmojiSpan(obj)) {
            ((SpanWatcher) this.mObject).onSpanRemoved(spannable, obj, i, i2);
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        ((TextWatcher) this.mObject).onTextChanged(charSequence, i, i2, i3);
    }

    final void unblockCalls() {
        this.mBlockCalls.decrementAndGet();
    }
}
