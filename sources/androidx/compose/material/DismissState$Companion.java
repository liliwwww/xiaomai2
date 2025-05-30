package androidx.compose.material;

import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class DismissState$Companion {
    private DismissState$Companion() {
    }

    public /* synthetic */ DismissState$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @NotNull
    public final Saver<DismissState, DismissValue> Saver(@NotNull Function1<? super DismissValue, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "confirmStateChange");
        return SaverKt.Saver(Saver.1.INSTANCE, new Saver.2(function1));
    }
}
