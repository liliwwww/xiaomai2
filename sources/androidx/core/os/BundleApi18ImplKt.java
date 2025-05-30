package androidx.core.os;

import android.os.Bundle;
import android.os.IBinder;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@RequiresApi(18)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class BundleApi18ImplKt {

    @NotNull
    public static final BundleApi18ImplKt INSTANCE = new BundleApi18ImplKt();

    private BundleApi18ImplKt() {
    }

    @JvmStatic
    @DoNotInline
    public static final void putBinder(@NotNull Bundle bundle, @NotNull String str, @Nullable IBinder iBinder) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(str, "key");
        bundle.putBinder(str, iBinder);
    }
}
