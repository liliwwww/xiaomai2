package androidx.compose.ui.text.font;

import android.taobao.windvane.urlintercept.WVURLRuleConstants;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class FontWeightKt {
    @NotNull
    public static final FontWeight lerp(@NotNull FontWeight fontWeight, @NotNull FontWeight fontWeight2, float f) {
        Intrinsics.checkNotNullParameter(fontWeight, "start");
        Intrinsics.checkNotNullParameter(fontWeight2, "stop");
        return new FontWeight(RangesKt.coerceIn(MathHelpersKt.lerp(fontWeight.getWeight(), fontWeight2.getWeight(), f), 1, WVURLRuleConstants.LOGIN));
    }
}
