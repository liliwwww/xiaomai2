package androidx.compose.ui.graphics;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class AndroidPathEffect implements PathEffect {

    @NotNull
    private final android.graphics.PathEffect nativePathEffect;

    public AndroidPathEffect(@NotNull android.graphics.PathEffect pathEffect) {
        Intrinsics.checkNotNullParameter(pathEffect, "nativePathEffect");
        this.nativePathEffect = pathEffect;
    }

    @NotNull
    public final android.graphics.PathEffect getNativePathEffect() {
        return this.nativePathEffect;
    }
}
