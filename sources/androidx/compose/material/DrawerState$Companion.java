package androidx.compose.material;

import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class DrawerState$Companion {
    private DrawerState$Companion() {
    }

    public /* synthetic */ DrawerState$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @NotNull
    public final Saver<DrawerState, DrawerValue> Saver(@NotNull Function1<? super DrawerValue, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "confirmStateChange");
        return SaverKt.Saver(Saver.1.INSTANCE, new Saver.2(function1));
    }
}
