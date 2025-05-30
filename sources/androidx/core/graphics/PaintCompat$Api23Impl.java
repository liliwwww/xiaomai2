package androidx.core.graphics;

import android.graphics.Paint;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* compiled from: Taobao */
@RequiresApi(23)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class PaintCompat$Api23Impl {
    private PaintCompat$Api23Impl() {
    }

    @DoNotInline
    static boolean hasGlyph(Paint paint, String str) {
        return paint.hasGlyph(str);
    }
}
