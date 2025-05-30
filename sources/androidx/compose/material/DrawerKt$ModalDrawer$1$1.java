package androidx.compose.material;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class DrawerKt$ModalDrawer$1$1 extends Lambda implements Function2<DrawerValue, DrawerValue, ThresholdConfig> {
    public static final DrawerKt$ModalDrawer$1$1 INSTANCE = new DrawerKt$ModalDrawer$1$1();

    DrawerKt$ModalDrawer$1$1() {
        super(2);
    }

    @NotNull
    public final ThresholdConfig invoke(@NotNull DrawerValue drawerValue, @NotNull DrawerValue drawerValue2) {
        Intrinsics.checkNotNullParameter(drawerValue, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(drawerValue2, "<anonymous parameter 1>");
        return new FractionalThreshold(0.5f);
    }
}
