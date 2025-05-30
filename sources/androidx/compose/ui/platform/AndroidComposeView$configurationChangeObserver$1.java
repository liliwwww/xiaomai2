package androidx.compose.ui.platform;

import android.content.res.Configuration;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class AndroidComposeView$configurationChangeObserver$1 extends Lambda implements Function1<Configuration, Unit> {
    public static final AndroidComposeView$configurationChangeObserver$1 INSTANCE = new AndroidComposeView$configurationChangeObserver$1();

    AndroidComposeView$configurationChangeObserver$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Configuration) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Configuration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "it");
    }
}
