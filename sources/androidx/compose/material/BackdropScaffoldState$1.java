package androidx.compose.material;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class BackdropScaffoldState$1 extends Lambda implements Function1<BackdropValue, Boolean> {
    public static final BackdropScaffoldState$1 INSTANCE = new BackdropScaffoldState$1();

    BackdropScaffoldState$1() {
        super(1);
    }

    @NotNull
    public final Boolean invoke(@NotNull BackdropValue backdropValue) {
        Intrinsics.checkNotNullParameter(backdropValue, "it");
        return Boolean.TRUE;
    }
}
