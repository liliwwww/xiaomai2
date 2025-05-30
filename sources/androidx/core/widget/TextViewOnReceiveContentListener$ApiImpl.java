package androidx.core.widget;

import android.content.ClipData;
import android.content.Context;
import android.text.Spanned;
import androidx.annotation.NonNull;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class TextViewOnReceiveContentListener$ApiImpl {
    private TextViewOnReceiveContentListener$ApiImpl() {
    }

    static CharSequence coerce(@NonNull Context context, @NonNull ClipData.Item item, int i) {
        CharSequence coerceToText = item.coerceToText(context);
        return ((i & 1) == 0 || !(coerceToText instanceof Spanned)) ? coerceToText : coerceToText.toString();
    }
}
