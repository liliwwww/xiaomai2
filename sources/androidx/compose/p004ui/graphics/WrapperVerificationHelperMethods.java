package androidx.compose.p004ui.graphics;

import android.graphics.Paint;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@RequiresApi(29)
/* loaded from: classes.dex */
public final class WrapperVerificationHelperMethods {

    @NotNull
    public static final WrapperVerificationHelperMethods INSTANCE = new WrapperVerificationHelperMethods();

    private WrapperVerificationHelperMethods() {
    }

    @DoNotInline
    /* renamed from: setBlendMode-GB0RdKg, reason: not valid java name */
    public final void m3142setBlendModeGB0RdKg(@NotNull Paint paint, int i) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        paint.setBlendMode(AndroidBlendMode_androidKt.m2648toAndroidBlendModes9anfk8(i));
    }
}
