package androidx.compose.ui.platform;

import android.os.Parcel;
import android.util.Base64;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitType;
import androidx.constraintlayout.core.motion.utils.TypedValues$Custom;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class EncodeHelper {

    @NotNull
    private Parcel parcel;

    public EncodeHelper() {
        Parcel obtain = Parcel.obtain();
        Intrinsics.checkNotNullExpressionValue(obtain, "obtain()");
        this.parcel = obtain;
    }

    public final void encode(@NotNull SpanStyle spanStyle) {
        Intrinsics.checkNotNullParameter(spanStyle, "spanStyle");
        long j = spanStyle.getColor-0d7_KjU();
        Color.Companion companion = Color.Companion;
        if (!Color.m1051equalsimpl0(j, companion.getUnspecified-0d7_KjU())) {
            encode((byte) 1);
            m1757encode8_81llA(spanStyle.getColor-0d7_KjU());
        }
        long j2 = spanStyle.getFontSize-XSAIIZE();
        TextUnit.Companion companion2 = TextUnit.Companion;
        if (!TextUnit.m2210equalsimpl0(j2, companion2.m2224getUnspecifiedXSAIIZE())) {
            encode((byte) 2);
            m1754encodeR2X_6o(spanStyle.getFontSize-XSAIIZE());
        }
        FontWeight fontWeight = spanStyle.getFontWeight();
        if (fontWeight != null) {
            encode((byte) 3);
            encode(fontWeight);
        }
        FontStyle fontStyle = spanStyle.getFontStyle-4Lr2A7w();
        if (fontStyle != null) {
            int m1930unboximpl = fontStyle.m1930unboximpl();
            encode((byte) 4);
            m1759encodenzbMABs(m1930unboximpl);
        }
        FontSynthesis fontSynthesis = spanStyle.getFontSynthesis-ZQGJjVo();
        if (fontSynthesis != null) {
            int i = fontSynthesis.unbox-impl();
            encode((byte) 5);
            m1756encode6p3vJLY(i);
        }
        String fontFeatureSettings = spanStyle.getFontFeatureSettings();
        if (fontFeatureSettings != null) {
            encode((byte) 6);
            encode(fontFeatureSettings);
        }
        if (!TextUnit.m2210equalsimpl0(spanStyle.getLetterSpacing-XSAIIZE(), companion2.m2224getUnspecifiedXSAIIZE())) {
            encode((byte) 7);
            m1754encodeR2X_6o(spanStyle.getLetterSpacing-XSAIIZE());
        }
        BaselineShift baselineShift = spanStyle.getBaselineShift-5SSeXJ0();
        if (baselineShift != null) {
            float m2006unboximpl = baselineShift.m2006unboximpl();
            encode((byte) 8);
            m1755encode4Dl_Bck(m2006unboximpl);
        }
        TextGeometricTransform textGeometricTransform = spanStyle.getTextGeometricTransform();
        if (textGeometricTransform != null) {
            encode((byte) 9);
            encode(textGeometricTransform);
        }
        if (!Color.m1051equalsimpl0(spanStyle.getBackground-0d7_KjU(), companion.getUnspecified-0d7_KjU())) {
            encode((byte) 10);
            m1757encode8_81llA(spanStyle.getBackground-0d7_KjU());
        }
        TextDecoration textDecoration = spanStyle.getTextDecoration();
        if (textDecoration != null) {
            encode((byte) 11);
            encode(textDecoration);
        }
        Shadow shadow = spanStyle.getShadow();
        if (shadow != null) {
            encode((byte) 12);
            encode(shadow);
        }
    }

    /* renamed from: encode--R2X_6o, reason: not valid java name */
    public final void m1754encodeR2X_6o(long j) {
        long m2212getTypeUIouoOA = TextUnit.m2212getTypeUIouoOA(j);
        TextUnitType.Companion companion = TextUnitType.Companion;
        byte b = 0;
        if (!TextUnitType.equals-impl0(m2212getTypeUIouoOA, companion.getUnspecified-UIouoOA())) {
            if (TextUnitType.equals-impl0(m2212getTypeUIouoOA, companion.getSp-UIouoOA())) {
                b = 1;
            } else if (TextUnitType.equals-impl0(m2212getTypeUIouoOA, companion.getEm-UIouoOA())) {
                b = 2;
            }
        }
        encode(b);
        if (TextUnitType.equals-impl0(TextUnit.m2212getTypeUIouoOA(j), companion.getUnspecified-UIouoOA())) {
            return;
        }
        encode(TextUnit.m2213getValueimpl(j));
    }

    /* renamed from: encode-4Dl_Bck, reason: not valid java name */
    public final void m1755encode4Dl_Bck(float f) {
        encode(f);
    }

    /* renamed from: encode-6p3vJLY, reason: not valid java name */
    public final void m1756encode6p3vJLY(int i) {
        FontSynthesis.Companion companion = FontSynthesis.Companion;
        byte b = 0;
        if (!FontSynthesis.equals-impl0(i, companion.getNone-GVVA2EU())) {
            if (FontSynthesis.equals-impl0(i, companion.getAll-GVVA2EU())) {
                b = 1;
            } else if (FontSynthesis.equals-impl0(i, companion.getWeight-GVVA2EU())) {
                b = 2;
            } else if (FontSynthesis.equals-impl0(i, companion.getStyle-GVVA2EU())) {
                b = 3;
            }
        }
        encode(b);
    }

    /* renamed from: encode-8_81llA, reason: not valid java name */
    public final void m1757encode8_81llA(long j) {
        m1758encodeVKZWuLQ(j);
    }

    /* renamed from: encode-VKZWuLQ, reason: not valid java name */
    public final void m1758encodeVKZWuLQ(long j) {
        this.parcel.writeLong(j);
    }

    /* renamed from: encode-nzbMABs, reason: not valid java name */
    public final void m1759encodenzbMABs(int i) {
        FontStyle.Companion companion = FontStyle.Companion;
        byte b = 0;
        if (!FontStyle.m1927equalsimpl0(i, companion.getNormal-_-LCdwA()) && FontStyle.m1927equalsimpl0(i, companion.getItalic-_-LCdwA())) {
            b = 1;
        }
        encode(b);
    }

    @NotNull
    public final String encodedString() {
        String encodeToString = Base64.encodeToString(this.parcel.marshall(), 0);
        Intrinsics.checkNotNullExpressionValue(encodeToString, "encodeToString(bytes, Base64.DEFAULT)");
        return encodeToString;
    }

    public final void reset() {
        this.parcel.recycle();
        Parcel obtain = Parcel.obtain();
        Intrinsics.checkNotNullExpressionValue(obtain, "obtain()");
        this.parcel = obtain;
    }

    public final void encode(@NotNull FontWeight fontWeight) {
        Intrinsics.checkNotNullParameter(fontWeight, "fontWeight");
        encode(fontWeight.getWeight());
    }

    public final void encode(@NotNull TextGeometricTransform textGeometricTransform) {
        Intrinsics.checkNotNullParameter(textGeometricTransform, "textGeometricTransform");
        encode(textGeometricTransform.getScaleX());
        encode(textGeometricTransform.getSkewX());
    }

    public final void encode(@NotNull TextDecoration textDecoration) {
        Intrinsics.checkNotNullParameter(textDecoration, "textDecoration");
        encode(textDecoration.getMask());
    }

    public final void encode(@NotNull Shadow shadow) {
        Intrinsics.checkNotNullParameter(shadow, "shadow");
        m1757encode8_81llA(shadow.m1229getColor0d7_KjU());
        encode(Offset.m848getXimpl(shadow.m1230getOffsetF1C5BW0()));
        encode(Offset.m849getYimpl(shadow.m1230getOffsetF1C5BW0()));
        encode(shadow.getBlurRadius());
    }

    public final void encode(byte b) {
        this.parcel.writeByte(b);
    }

    public final void encode(int i) {
        this.parcel.writeInt(i);
    }

    public final void encode(float f) {
        this.parcel.writeFloat(f);
    }

    public final void encode(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, TypedValues$Custom.S_STRING);
        this.parcel.writeString(str);
    }
}
