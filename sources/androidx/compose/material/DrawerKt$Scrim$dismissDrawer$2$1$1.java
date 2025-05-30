package androidx.compose.material;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class DrawerKt$Scrim$dismissDrawer$2$1$1 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ Function0<Unit> $onClose;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DrawerKt$Scrim$dismissDrawer$2$1$1(Function0<Unit> function0) {
        super(0);
        this.$onClose = function0;
    }

    @NotNull
    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final Boolean m584invoke() {
        this.$onClose.invoke();
        return Boolean.TRUE;
    }
}
