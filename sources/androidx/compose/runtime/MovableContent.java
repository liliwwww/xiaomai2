package androidx.compose.runtime;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
@InternalComposeApi
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class MovableContent<P> {
    public static final int $stable = 0;

    @NotNull
    private final Function3<P, Composer, Integer, Unit> content;

    /* JADX WARN: Multi-variable type inference failed */
    public MovableContent(@NotNull Function3<? super P, ? super Composer, ? super Integer, Unit> function3) {
        Intrinsics.checkNotNullParameter(function3, "content");
        this.content = function3;
    }

    @NotNull
    public final Function3<P, Composer, Integer, Unit> getContent() {
        return this.content;
    }
}
