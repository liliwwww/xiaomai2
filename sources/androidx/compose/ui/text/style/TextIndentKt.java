package androidx.compose.ui.text.style;

import androidx.compose.ui.text.SpanStyleKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class TextIndentKt {
    @NotNull
    public static final TextIndent lerp(@NotNull TextIndent textIndent, @NotNull TextIndent textIndent2, float f) {
        Intrinsics.checkNotNullParameter(textIndent, "start");
        Intrinsics.checkNotNullParameter(textIndent2, "stop");
        return new TextIndent(SpanStyleKt.m1885lerpTextUnitInheritableC3pnCVY(textIndent.getFirstLine-XSAIIZE(), textIndent2.getFirstLine-XSAIIZE(), f), SpanStyleKt.m1885lerpTextUnitInheritableC3pnCVY(textIndent.getRestLine-XSAIIZE(), textIndent2.getRestLine-XSAIIZE(), f), (DefaultConstructorMarker) null);
    }
}
