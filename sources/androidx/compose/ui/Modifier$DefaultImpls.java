package androidx.compose.ui;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tb.mt2;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class Modifier$DefaultImpls {
    @Deprecated
    @NotNull
    public static Modifier then(@NotNull Modifier modifier, @NotNull Modifier modifier2) {
        Intrinsics.checkNotNullParameter(modifier2, "other");
        return mt2.b(modifier, modifier2);
    }
}
