package androidx.core.os;

import android.os.PersistableBundle;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@RequiresApi(22)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class PersistableBundleApi22ImplKt {

    @NotNull
    public static final PersistableBundleApi22ImplKt INSTANCE = new PersistableBundleApi22ImplKt();

    private PersistableBundleApi22ImplKt() {
    }

    @JvmStatic
    @DoNotInline
    public static final void putBoolean(@NotNull PersistableBundle persistableBundle, @Nullable String str, boolean z) {
        Intrinsics.checkNotNullParameter(persistableBundle, "persistableBundle");
        persistableBundle.putBoolean(str, z);
    }

    @JvmStatic
    @DoNotInline
    public static final void putBooleanArray(@NotNull PersistableBundle persistableBundle, @Nullable String str, @NotNull boolean[] zArr) {
        Intrinsics.checkNotNullParameter(persistableBundle, "persistableBundle");
        Intrinsics.checkNotNullParameter(zArr, "value");
        persistableBundle.putBooleanArray(str, zArr);
    }
}
