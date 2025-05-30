package androidx.compose.p004ui.graphics;

import android.graphics.RenderEffect;
import androidx.compose.runtime.Immutable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Immutable
/* loaded from: classes.dex */
public final class AndroidRenderEffect extends RenderEffect {

    @NotNull
    private final RenderEffect androidRenderEffect;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AndroidRenderEffect(@NotNull RenderEffect renderEffect) {
        super(null);
        Intrinsics.checkNotNullParameter(renderEffect, "androidRenderEffect");
        this.androidRenderEffect = renderEffect;
    }

    @Override // androidx.compose.p004ui.graphics.RenderEffect
    @NotNull
    protected RenderEffect createRenderEffect() {
        return this.androidRenderEffect;
    }

    @NotNull
    public final RenderEffect getAndroidRenderEffect() {
        return this.androidRenderEffect;
    }
}
