package androidx.compose.p004ui.text.style;

import android.taobao.windvane.extra.p002uc.AliRequestAdapter;
import androidx.compose.p004ui.text.SpanStyleKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class TextIndentKt {
    @NotNull
    public static final TextIndent lerp(@NotNull TextIndent textIndent, @NotNull TextIndent textIndent2, float f) {
        Intrinsics.checkNotNullParameter(textIndent, "start");
        Intrinsics.checkNotNullParameter(textIndent2, AliRequestAdapter.PHASE_STOP);
        return new TextIndent(SpanStyleKt.m4715lerpTextUnitInheritableC3pnCVY(textIndent.m5103getFirstLineXSAIIZE(), textIndent2.m5103getFirstLineXSAIIZE(), f), SpanStyleKt.m4715lerpTextUnitInheritableC3pnCVY(textIndent.m5104getRestLineXSAIIZE(), textIndent2.m5104getRestLineXSAIIZE(), f), null);
    }
}
