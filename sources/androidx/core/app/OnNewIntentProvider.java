package androidx.core.app;

import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.core.util.Consumer;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public interface OnNewIntentProvider {
    void addOnNewIntentListener(@NonNull Consumer<Intent> consumer);

    void removeOnNewIntentListener(@NonNull Consumer<Intent> consumer);
}
