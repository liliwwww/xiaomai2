package androidx.compose.ui.text.android;

import android.text.BoringLayout;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* compiled from: Taobao */
@RequiresApi(33)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class BoringLayoutConstructor33 {
    private BoringLayoutConstructor33() {
    }

    @NonNull
    public static BoringLayout create(@NonNull CharSequence charSequence, @NonNull TextPaint textPaint, @IntRange(from = 0) int i, @NonNull Layout.Alignment alignment, float f, float f2, @NonNull BoringLayout.Metrics metrics, boolean z, @Nullable TextUtils.TruncateAt truncateAt, @IntRange(from = 0) int i2, boolean z2) {
        return new BoringLayout(charSequence, textPaint, i, alignment, f, f2, metrics, z, truncateAt, i2, z2);
    }
}
