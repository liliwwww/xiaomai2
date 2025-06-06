package androidx.activity;

import android.view.View;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@RequiresApi(19)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class Api19Impl {

    @NotNull
    public static final Api19Impl INSTANCE = new Api19Impl();

    private Api19Impl() {
    }

    public final boolean isAttachedToWindow(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return view.isAttachedToWindow();
    }
}
