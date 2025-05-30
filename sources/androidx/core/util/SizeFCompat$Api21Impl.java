package androidx.core.util;

import android.util.SizeF;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
@RequiresApi(21)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class SizeFCompat$Api21Impl {
    private SizeFCompat$Api21Impl() {
    }

    @NonNull
    @DoNotInline
    static SizeF toSizeF(@NonNull SizeFCompat sizeFCompat) {
        Preconditions.checkNotNull(sizeFCompat);
        return new SizeF(sizeFCompat.getWidth(), sizeFCompat.getHeight());
    }

    @NonNull
    @DoNotInline
    static SizeFCompat toSizeFCompat(@NonNull SizeF sizeF) {
        Preconditions.checkNotNull(sizeF);
        return new SizeFCompat(sizeF.getWidth(), sizeF.getHeight());
    }
}
