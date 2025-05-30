package androidx.core.content.res;

import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import tb.ec4;
import tb.fc4;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public abstract class ResourcesCompat$FontCallback {
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static Handler getHandler(@Nullable Handler handler) {
        return handler == null ? new Handler(Looper.getMainLooper()) : handler;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public final void callbackFailAsync(int i, @Nullable Handler handler) {
        getHandler(handler).post(new ec4(this, i));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public final void callbackSuccessAsync(@NonNull Typeface typeface, @Nullable Handler handler) {
        getHandler(handler).post(new fc4(this, typeface));
    }

    /* renamed from: onFontRetrievalFailed, reason: merged with bridge method [inline-methods] */
    public abstract void lambda$callbackFailAsync$1(int i);

    /* renamed from: onFontRetrieved, reason: merged with bridge method [inline-methods] */
    public abstract void lambda$callbackSuccessAsync$0(@NonNull Typeface typeface);
}
