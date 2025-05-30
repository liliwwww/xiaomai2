package androidx.core.os;

import android.os.Bundle;
import android.util.Size;
import android.util.SizeF;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@RequiresApi(21)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class BundleApi21ImplKt {

    @NotNull
    public static final BundleApi21ImplKt INSTANCE = new BundleApi21ImplKt();

    private BundleApi21ImplKt() {
    }

    @JvmStatic
    @DoNotInline
    public static final void putSize(@NotNull Bundle bundle, @NotNull String str, @Nullable Size size) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(str, "key");
        bundle.putSize(str, size);
    }

    @JvmStatic
    @DoNotInline
    public static final void putSizeF(@NotNull Bundle bundle, @NotNull String str, @Nullable SizeF sizeF) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(str, "key");
        bundle.putSizeF(str, sizeF);
    }
}
