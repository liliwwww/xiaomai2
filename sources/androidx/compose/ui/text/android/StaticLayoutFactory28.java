package androidx.compose.ui.text.android;

import android.text.StaticLayout;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@RequiresApi(28)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class StaticLayoutFactory28 {

    @NotNull
    public static final StaticLayoutFactory28 INSTANCE = new StaticLayoutFactory28();

    private StaticLayoutFactory28() {
    }

    @JvmStatic
    @DoNotInline
    public static final void setUseLineSpacingFromFallbacks(@NotNull StaticLayout.Builder builder, boolean z) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        builder.setUseLineSpacingFromFallbacks(z);
    }
}
