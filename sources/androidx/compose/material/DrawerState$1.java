package androidx.compose.material;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class DrawerState$1 extends Lambda implements Function1<DrawerValue, Boolean> {
    public static final DrawerState$1 INSTANCE = new DrawerState$1();

    DrawerState$1() {
        super(1);
    }

    @NotNull
    public final Boolean invoke(@NotNull DrawerValue drawerValue) {
        Intrinsics.checkNotNullParameter(drawerValue, "it");
        return Boolean.TRUE;
    }
}
