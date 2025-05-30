package androidx.compose.ui.text.platform.extensions;

import android.text.Spannable;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.PlaceholderVerticalAlign;
import androidx.compose.ui.text.android.style.PlaceholderSpan;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitType;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class PlaceholderExtensions_androidKt {
    /* renamed from: getSpanUnit--R2X_6o, reason: not valid java name */
    private static final int m2467getSpanUnitR2X_6o(long j) {
        long j2 = TextUnit.getType-UIouoOA(j);
        TextUnitType.Companion companion = TextUnitType.Companion;
        if (TextUnitType.m2694equalsimpl0(j2, companion.m2699getSpUIouoOA())) {
            return 0;
        }
        return TextUnitType.m2694equalsimpl0(j2, companion.m2698getEmUIouoOA()) ? 1 : 2;
    }

    /* renamed from: getSpanUnit--R2X_6o$annotations, reason: not valid java name */
    private static /* synthetic */ void m2468getSpanUnitR2X_6o$annotations(long j) {
    }

    /* renamed from: getSpanVerticalAlign-do9X-Gg, reason: not valid java name */
    private static final int m2469getSpanVerticalAligndo9XGg(int i) {
        PlaceholderVerticalAlign.Companion companion = PlaceholderVerticalAlign.Companion;
        if (PlaceholderVerticalAlign.equals-impl0(i, companion.getAboveBaseline-J6kI3mc())) {
            return 0;
        }
        if (PlaceholderVerticalAlign.equals-impl0(i, companion.getTop-J6kI3mc())) {
            return 1;
        }
        if (PlaceholderVerticalAlign.equals-impl0(i, companion.getBottom-J6kI3mc())) {
            return 2;
        }
        if (PlaceholderVerticalAlign.equals-impl0(i, companion.getCenter-J6kI3mc())) {
            return 3;
        }
        if (PlaceholderVerticalAlign.equals-impl0(i, companion.getTextTop-J6kI3mc())) {
            return 4;
        }
        if (PlaceholderVerticalAlign.equals-impl0(i, companion.getTextBottom-J6kI3mc())) {
            return 5;
        }
        if (PlaceholderVerticalAlign.equals-impl0(i, companion.getTextCenter-J6kI3mc())) {
            return 6;
        }
        throw new IllegalStateException("Invalid PlaceholderVerticalAlign".toString());
    }

    /* renamed from: getSpanVerticalAlign-do9X-Gg$annotations, reason: not valid java name */
    private static /* synthetic */ void m2470getSpanVerticalAligndo9XGg$annotations(int i) {
    }

    private static final void setPlaceholder(Spannable spannable, Placeholder placeholder, int i, int i2, Density density) {
        SpannableExtensions_androidKt.setSpan(spannable, new PlaceholderSpan(TextUnit.getValue-impl(placeholder.getWidth-XSAIIZE()), m2467getSpanUnitR2X_6o(placeholder.getWidth-XSAIIZE()), TextUnit.getValue-impl(placeholder.getHeight-XSAIIZE()), m2467getSpanUnitR2X_6o(placeholder.getHeight-XSAIIZE()), density.getFontScale() * density.getDensity(), m2469getSpanVerticalAligndo9XGg(placeholder.getPlaceholderVerticalAlign-J6kI3mc())), i, i2);
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
