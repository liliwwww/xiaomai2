package androidx.appcompat.widget;

import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
@RequiresApi(26)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class AppCompatTextClassifierHelper$Api26Impl {
    private AppCompatTextClassifierHelper$Api26Impl() {
    }

    @NonNull
    @DoNotInline
    static TextClassifier getTextClassifier(@NonNull TextView textView) {
        TextClassificationManager textClassificationManager = (TextClassificationManager) textView.getContext().getSystemService(TextClassificationManager.class);
        return textClassificationManager != null ? textClassificationManager.getTextClassifier() : TextClassifier.NO_OP;
    }
}
