package androidx.compose.ui.graphics;

import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.compose.ui.geometry.Offset;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@RequiresApi(31)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class RenderEffectVerificationHelper {

    @NotNull
    public static final RenderEffectVerificationHelper INSTANCE = new RenderEffectVerificationHelper();

    private RenderEffectVerificationHelper() {
    }

    @DoNotInline
    @NotNull
    /* renamed from: createBlurEffect-8A-3gB4, reason: not valid java name */
    public final android.graphics.RenderEffect m1206createBlurEffect8A3gB4(@Nullable RenderEffect renderEffect, float f, float f2, int i) {
        if (renderEffect == null) {
            android.graphics.RenderEffect createBlurEffect = android.graphics.RenderEffect.createBlurEffect(f, f2, AndroidTileMode_androidKt.toAndroidTileMode-0vamqd0(i));
            Intrinsics.checkNotNullExpressionValue(createBlurEffect, "{\n            android.gr…)\n            )\n        }");
            return createBlurEffect;
        }
        android.graphics.RenderEffect createBlurEffect2 = android.graphics.RenderEffect.createBlurEffect(f, f2, renderEffect.asAndroidRenderEffect(), AndroidTileMode_androidKt.toAndroidTileMode-0vamqd0(i));
        Intrinsics.checkNotNullExpressionValue(createBlurEffect2, "{\n            android.gr…)\n            )\n        }");
        return createBlurEffect2;
    }

    @DoNotInline
    @NotNull
    /* renamed from: createOffsetEffect-Uv8p0NA, reason: not valid java name */
    public final android.graphics.RenderEffect m1207createOffsetEffectUv8p0NA(@Nullable RenderEffect renderEffect, long j) {
        if (renderEffect == null) {
            android.graphics.RenderEffect createOffsetEffect = android.graphics.RenderEffect.createOffsetEffect(Offset.getX-impl(j), Offset.getY-impl(j));
            Intrinsics.checkNotNullExpressionValue(createOffsetEffect, "{\n            android.gr…et.x, offset.y)\n        }");
            return createOffsetEffect;
        }
        android.graphics.RenderEffect createOffsetEffect2 = android.graphics.RenderEffect.createOffsetEffect(Offset.getX-impl(j), Offset.getY-impl(j), renderEffect.asAndroidRenderEffect());
        Intrinsics.checkNotNullExpressionValue(createOffsetEffect2, "{\n            android.gr…)\n            )\n        }");
        return createOffsetEffect2;
    }
}
