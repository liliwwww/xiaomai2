package androidx.compose.p004ui.graphics;

import android.graphics.RenderEffect;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.compose.p004ui.geometry.Offset;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@RequiresApi(31)
/* loaded from: classes2.dex */
final class RenderEffectVerificationHelper {

    @NotNull
    public static final RenderEffectVerificationHelper INSTANCE = new RenderEffectVerificationHelper();

    private RenderEffectVerificationHelper() {
    }

    @DoNotInline
    @NotNull
    /* renamed from: createBlurEffect-8A-3gB4, reason: not valid java name */
    public final RenderEffect m3057createBlurEffect8A3gB4(@Nullable RenderEffect renderEffect, float f, float f2, int i) {
        if (renderEffect == null) {
            RenderEffect createBlurEffect = RenderEffect.createBlurEffect(f, f2, AndroidTileMode_androidKt.m2700toAndroidTileMode0vamqd0(i));
            Intrinsics.checkNotNullExpressionValue(createBlurEffect, "{\n            android.gr…)\n            )\n        }");
            return createBlurEffect;
        }
        RenderEffect createBlurEffect2 = RenderEffect.createBlurEffect(f, f2, renderEffect.asAndroidRenderEffect(), AndroidTileMode_androidKt.m2700toAndroidTileMode0vamqd0(i));
        Intrinsics.checkNotNullExpressionValue(createBlurEffect2, "{\n            android.gr…)\n            )\n        }");
        return createBlurEffect2;
    }

    @DoNotInline
    @NotNull
    /* renamed from: createOffsetEffect-Uv8p0NA, reason: not valid java name */
    public final RenderEffect m3058createOffsetEffectUv8p0NA(@Nullable RenderEffect renderEffect, long j) {
        if (renderEffect == null) {
            RenderEffect createOffsetEffect = RenderEffect.createOffsetEffect(Offset.m2556getXimpl(j), Offset.m2557getYimpl(j));
            Intrinsics.checkNotNullExpressionValue(createOffsetEffect, "{\n            android.gr…et.x, offset.y)\n        }");
            return createOffsetEffect;
        }
        RenderEffect createOffsetEffect2 = RenderEffect.createOffsetEffect(Offset.m2556getXimpl(j), Offset.m2557getYimpl(j), renderEffect.asAndroidRenderEffect());
        Intrinsics.checkNotNullExpressionValue(createOffsetEffect2, "{\n            android.gr…)\n            )\n        }");
        return createOffsetEffect2;
    }
}
