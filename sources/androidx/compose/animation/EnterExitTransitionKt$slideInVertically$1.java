package androidx.compose.animation;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class EnterExitTransitionKt$slideInVertically$1 extends Lambda implements Function1<Integer, Integer> {
    public static final EnterExitTransitionKt$slideInVertically$1 INSTANCE = new EnterExitTransitionKt$slideInVertically$1();

    EnterExitTransitionKt$slideInVertically$1() {
        super(1);
    }

    @NotNull
    public final Integer invoke(int i) {
        return Integer.valueOf((-i) / 2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).intValue());
    }
}
