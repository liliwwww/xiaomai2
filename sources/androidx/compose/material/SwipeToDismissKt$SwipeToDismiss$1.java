package androidx.compose.material;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class SwipeToDismissKt$SwipeToDismiss$1 extends Lambda implements Function1<DismissDirection, FixedThreshold> {
    public static final SwipeToDismissKt$SwipeToDismiss$1 INSTANCE = new SwipeToDismissKt$SwipeToDismiss$1();

    SwipeToDismissKt$SwipeToDismiss$1() {
        super(1);
    }

    @NotNull
    public final FixedThreshold invoke(@NotNull DismissDirection dismissDirection) {
        Intrinsics.checkNotNullParameter(dismissDirection, "it");
        return new FixedThreshold(SwipeToDismissKt.access$getDISMISS_THRESHOLD$p(), (DefaultConstructorMarker) null);
    }
}
