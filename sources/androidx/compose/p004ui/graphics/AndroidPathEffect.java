package androidx.compose.p004ui.graphics;

import android.graphics.PathEffect;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class AndroidPathEffect implements PathEffect {

    @NotNull
    private final PathEffect nativePathEffect;

    public AndroidPathEffect(@NotNull PathEffect pathEffect) {
        Intrinsics.checkNotNullParameter(pathEffect, "nativePathEffect");
        this.nativePathEffect = pathEffect;
    }

    @NotNull
    public final PathEffect getNativePathEffect() {
        return this.nativePathEffect;
    }
}
