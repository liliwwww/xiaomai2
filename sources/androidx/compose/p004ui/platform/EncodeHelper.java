package androidx.compose.p004ui.platform;

import android.os.Parcel;
import android.util.Base64;
import androidx.compose.p004ui.geometry.Offset;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.graphics.Shadow;
import androidx.compose.p004ui.text.SpanStyle;
import androidx.compose.p004ui.text.font.FontStyle;
import androidx.compose.p004ui.text.font.FontSynthesis;
import androidx.compose.p004ui.text.font.FontWeight;
import androidx.compose.p004ui.text.style.BaselineShift;
import androidx.compose.p004ui.text.style.TextDecoration;
import androidx.compose.p004ui.text.style.TextGeometricTransform;
import androidx.compose.p004ui.unit.TextUnit;
import androidx.compose.p004ui.unit.TextUnitType;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
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
        long m4710getColor0d7_KjU = spanStyle.m4710getColor0d7_KjU();
        Color.Companion companion = Color.Companion;
        if (!Color.m2788equalsimpl0(m4710getColor0d7_KjU, companion.m2823getUnspecified0d7_KjU())) {
            encode((byte) 1);
            m4528encode8_81llA(spanStyle.m4710getColor0d7_KjU());
        }
        long m4711getFontSizeXSAIIZE = spanStyle.m4711getFontSizeXSAIIZE();
        TextUnit.Companion companion2 = TextUnit.Companion;
        if (!TextUnit.m5394equalsimpl0(m4711getFontSizeXSAIIZE, companion2.m5408getUnspecifiedXSAIIZE())) {
            encode((byte) 2);
            m4525encodeR2X_6o(spanStyle.m4711getFontSizeXSAIIZE());
        }
        FontWeight fontWeight = spanStyle.getFontWeight();
        if (fontWeight != null) {
            encode((byte) 3);
            encode(fontWeight);
        }
        FontStyle m4712getFontStyle4Lr2A7w = spanStyle.m4712getFontStyle4Lr2A7w();
        if (m4712getFontStyle4Lr2A7w != null) {
            int m4837unboximpl = m4712getFontStyle4Lr2A7w.m4837unboximpl();
            encode((byte) 4);
            m4530encodenzbMABs(m4837unboximpl);
        }
        FontSynthesis m4713getFontSynthesisZQGJjVo = spanStyle.m4713getFontSynthesisZQGJjVo();
        if (m4713getFontSynthesisZQGJjVo != null) {
            int m4848unboximpl = m4713getFontSynthesisZQGJjVo.m4848unboximpl();
            encode((byte) 5);
            m4527encode6p3vJLY(m4848unboximpl);
        }
        String fontFeatureSettings = spanStyle.getFontFeatureSettings();
        if (fontFeatureSettings != null) {
            encode((byte) 6);
            encode(fontFeatureSettings);
        }
        if (!TextUnit.m5394equalsimpl0(spanStyle.m4714getLetterSpacingXSAIIZE(), companion2.m5408getUnspecifiedXSAIIZE())) {
            encode((byte) 7);
            m4525encodeR2X_6o(spanStyle.m4714getLetterSpacingXSAIIZE());
        }
        BaselineShift m4709getBaselineShift5SSeXJ0 = spanStyle.m4709getBaselineShift5SSeXJ0();
        if (m4709getBaselineShift5SSeXJ0 != null) {
            float m4994unboximpl = m4709getBaselineShift5SSeXJ0.m4994unboximpl();
            encode((byte) 8);
            m4526encode4Dl_Bck(m4994unboximpl);
        }
        TextGeometricTransform textGeometricTransform = spanStyle.getTextGeometricTransform();
        if (textGeometricTransform != null) {
            encode((byte) 9);
            encode(textGeometricTransform);
        }
        if (!Color.m2788equalsimpl0(spanStyle.m4708getBackground0d7_KjU(), companion.m2823getUnspecified0d7_KjU())) {
            encode((byte) 10);
            m4528encode8_81llA(spanStyle.m4708getBackground0d7_KjU());
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
    public final void m4525encodeR2X_6o(long j) {
        long m5396getTypeUIouoOA = TextUnit.m5396getTypeUIouoOA(j);
        TextUnitType.Companion companion = TextUnitType.Companion;
        byte b = 0;
        if (!TextUnitType.m5425equalsimpl0(m5396getTypeUIouoOA, companion.m5431getUnspecifiedUIouoOA())) {
            if (TextUnitType.m5425equalsimpl0(m5396getTypeUIouoOA, companion.m5430getSpUIouoOA())) {
                b = 1;
            } else if (TextUnitType.m5425equalsimpl0(m5396getTypeUIouoOA, companion.m5429getEmUIouoOA())) {
                b = 2;
            }
        }
        encode(b);
        if (TextUnitType.m5425equalsimpl0(TextUnit.m5396getTypeUIouoOA(j), companion.m5431getUnspecifiedUIouoOA())) {
            return;
        }
        encode(TextUnit.m5397getValueimpl(j));
    }

    /* renamed from: encode-4Dl_Bck, reason: not valid java name */
    public final void m4526encode4Dl_Bck(float f) {
        encode(f);
    }

    /* renamed from: encode-6p3vJLY, reason: not valid java name */
    public final void m4527encode6p3vJLY(int i) {
        FontSynthesis.Companion companion = FontSynthesis.Companion;
        byte b = 0;
        if (!FontSynthesis.m4843equalsimpl0(i, companion.m4850getNoneGVVA2EU())) {
            if (FontSynthesis.m4843equalsimpl0(i, companion.m4849getAllGVVA2EU())) {
                b = 1;
            } else if (FontSynthesis.m4843equalsimpl0(i, companion.m4852getWeightGVVA2EU())) {
                b = 2;
            } else if (FontSynthesis.m4843equalsimpl0(i, companion.m4851getStyleGVVA2EU())) {
                b = 3;
            }
        }
        encode(b);
    }

    /* renamed from: encode-8_81llA, reason: not valid java name */
    public final void m4528encode8_81llA(long j) {
        m4529encodeVKZWuLQ(j);
    }

    /* renamed from: encode-VKZWuLQ, reason: not valid java name */
    public final void m4529encodeVKZWuLQ(long j) {
        this.parcel.writeLong(j);
    }

    /* renamed from: encode-nzbMABs, reason: not valid java name */
    public final void m4530encodenzbMABs(int i) {
        FontStyle.Companion companion = FontStyle.Companion;
        byte b = 0;
        if (!FontStyle.m4834equalsimpl0(i, companion.m4839getNormal_LCdwA()) && FontStyle.m4834equalsimpl0(i, companion.m4838getItalic_LCdwA())) {
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
        m4528encode8_81llA(shadow.m3072getColor0d7_KjU());
        encode(Offset.m2556getXimpl(shadow.m3073getOffsetF1C5BW0()));
        encode(Offset.m2557getYimpl(shadow.m3073getOffsetF1C5BW0()));
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
        Intrinsics.checkNotNullParameter(str, TypedValues.Custom.S_STRING);
        this.parcel.writeString(str);
    }
}
