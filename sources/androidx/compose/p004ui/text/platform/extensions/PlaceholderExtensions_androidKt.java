package androidx.compose.p004ui.text.platform.extensions;

import android.text.Spannable;
import androidx.compose.p004ui.text.AnnotatedString;
import androidx.compose.p004ui.text.Placeholder;
import androidx.compose.p004ui.text.PlaceholderVerticalAlign;
import androidx.compose.p004ui.text.android.style.PlaceholderSpan;
import androidx.compose.p004ui.unit.Density;
import androidx.compose.p004ui.unit.TextUnit;
import androidx.compose.p004ui.unit.TextUnitType;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class PlaceholderExtensions_androidKt {
    /* renamed from: getSpanUnit--R2X_6o, reason: not valid java name */
    private static final int m4972getSpanUnitR2X_6o(long j) {
        long m5396getTypeUIouoOA = TextUnit.m5396getTypeUIouoOA(j);
        TextUnitType.Companion companion = TextUnitType.Companion;
        if (TextUnitType.m5425equalsimpl0(m5396getTypeUIouoOA, companion.m5430getSpUIouoOA())) {
            return 0;
        }
        return TextUnitType.m5425equalsimpl0(m5396getTypeUIouoOA, companion.m5429getEmUIouoOA()) ? 1 : 2;
    }

    /* renamed from: getSpanUnit--R2X_6o$annotations, reason: not valid java name */
    private static /* synthetic */ void m4973getSpanUnitR2X_6o$annotations(long j) {
    }

    /* renamed from: getSpanVerticalAlign-do9X-Gg, reason: not valid java name */
    private static final int m4974getSpanVerticalAligndo9XGg(int i) {
        PlaceholderVerticalAlign.Companion companion = PlaceholderVerticalAlign.Companion;
        if (PlaceholderVerticalAlign.m4663equalsimpl0(i, companion.m4667getAboveBaselineJ6kI3mc())) {
            return 0;
        }
        if (PlaceholderVerticalAlign.m4663equalsimpl0(i, companion.m4673getTopJ6kI3mc())) {
            return 1;
        }
        if (PlaceholderVerticalAlign.m4663equalsimpl0(i, companion.m4668getBottomJ6kI3mc())) {
            return 2;
        }
        if (PlaceholderVerticalAlign.m4663equalsimpl0(i, companion.m4669getCenterJ6kI3mc())) {
            return 3;
        }
        if (PlaceholderVerticalAlign.m4663equalsimpl0(i, companion.m4672getTextTopJ6kI3mc())) {
            return 4;
        }
        if (PlaceholderVerticalAlign.m4663equalsimpl0(i, companion.m4670getTextBottomJ6kI3mc())) {
            return 5;
        }
        if (PlaceholderVerticalAlign.m4663equalsimpl0(i, companion.m4671getTextCenterJ6kI3mc())) {
            return 6;
        }
        throw new IllegalStateException("Invalid PlaceholderVerticalAlign".toString());
    }

    /* renamed from: getSpanVerticalAlign-do9X-Gg$annotations, reason: not valid java name */
    private static /* synthetic */ void m4975getSpanVerticalAligndo9XGg$annotations(int i) {
    }

    private static final void setPlaceholder(Spannable spannable, Placeholder placeholder, int i, int i2, Density density) {
        SpannableExtensions_androidKt.setSpan(spannable, new PlaceholderSpan(TextUnit.m5397getValueimpl(placeholder.m4659getWidthXSAIIZE()), m4972getSpanUnitR2X_6o(placeholder.m4659getWidthXSAIIZE()), TextUnit.m5397getValueimpl(placeholder.m4657getHeightXSAIIZE()), m4972getSpanUnitR2X_6o(placeholder.m4657getHeightXSAIIZE()), density.getFontScale() * density.getDensity(), m4974getSpanVerticalAligndo9XGg(placeholder.m4658getPlaceholderVerticalAlignJ6kI3mc())), i, i2);
    }

    public static final void setPlaceholders(@NotNull Spannable spannable, @NotNull List<AnnotatedString.Range<Placeholder>> list, @NotNull Density density) {
        Intrinsics.checkNotNullParameter(spannable, "<this>");
        Intrinsics.checkNotNullParameter(list, "placeholders");
        Intrinsics.checkNotNullParameter(density, "density");
        int size = list.size();
        for (int i = 0; i < size; i++) {
            AnnotatedString.Range<Placeholder> range = list.get(i);
            setPlaceholder(spannable, range.component1(), range.component2(), range.component3(), density);
        }
    }
}
