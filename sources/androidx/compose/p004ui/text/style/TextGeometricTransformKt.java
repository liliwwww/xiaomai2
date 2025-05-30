package androidx.compose.p004ui.text.style;

import android.taobao.windvane.extra.p002uc.AliRequestAdapter;
import androidx.compose.p004ui.util.MathHelpersKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class TextGeometricTransformKt {
    @NotNull
    public static final TextGeometricTransform lerp(@NotNull TextGeometricTransform textGeometricTransform, @NotNull TextGeometricTransform textGeometricTransform2, float f) {
        Intrinsics.checkNotNullParameter(textGeometricTransform, "start");
        Intrinsics.checkNotNullParameter(textGeometricTransform2, AliRequestAdapter.PHASE_STOP);
        return new TextGeometricTransform(MathHelpersKt.lerp(textGeometricTransform.getScaleX(), textGeometricTransform2.getScaleX(), f), MathHelpersKt.lerp(textGeometricTransform.getSkewX(), textGeometricTransform2.getSkewX(), f));
    }
}
