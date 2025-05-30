package androidx.compose.ui.platform;

import android.os.Parcel;
import android.util.Base64;
import androidx.compose.ui.geometry.OffsetKt;
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
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.unit.TextUnitType;
import androidx.constraintlayout.core.motion.utils.TypedValues$Custom;
import kotlin.ULong;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class DecodeHelper {

    @NotNull
    private final Parcel parcel;

    public DecodeHelper(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, TypedValues$Custom.S_STRING);
        Parcel obtain = Parcel.obtain();
        Intrinsics.checkNotNullExpressionValue(obtain, "obtain()");
        this.parcel = obtain;
        byte[] decode = Base64.decode(str, 0);
        obtain.unmarshall(decode, 0, decode.length);
        obtain.setDataPosition(0);
    }

    private final int dataAvailable() {
        return this.parcel.dataAvail();
    }

    /* renamed from: decodeBaselineShift-y9eOQZs, reason: not valid java name */
    private final float m1742decodeBaselineShifty9eOQZs() {
        return BaselineShift.m2001constructorimpl(decodeFloat());
    }

    private final byte decodeByte() {
        return this.parcel.readByte();
    }

    private final float decodeFloat() {
        return this.parcel.readFloat();
    }

    private final int decodeInt() {
        return this.parcel.readInt();
    }

    private final Shadow decodeShadow() {
        return new Shadow(m1744decodeColor0d7_KjU(), OffsetKt.Offset(decodeFloat(), decodeFloat()), decodeFloat(), null);
    }

    private final String decodeString() {
        return this.parcel.readString();
    }

    private final TextDecoration decodeTextDecoration() {
        int decodeInt = decodeInt();
        TextDecoration.Companion companion = TextDecoration.Companion;
        boolean z = (companion.getLineThrough().getMask() & decodeInt) != 0;
        boolean z2 = (decodeInt & companion.getUnderline().getMask()) != 0;
        return (z && z2) ? companion.combine(CollectionsKt.listOf(new TextDecoration[]{companion.getLineThrough(), companion.getUnderline()})) : z ? companion.getLineThrough() : z2 ? companion.getUnderline() : companion.getNone();
    }

    private final TextGeometricTransform decodeTextGeometricTransform() {
        return new TextGeometricTransform(decodeFloat(), decodeFloat());
    }

    /* renamed from: decodeULong-s-VKNKU, reason: not valid java name */
    private final long m1743decodeULongsVKNKU() {
        return ULong.constructor-impl(this.parcel.readLong());
    }

    /* renamed from: decodeColor-0d7_KjU, reason: not valid java name */
    public final long m1744decodeColor0d7_KjU() {
        return Color.m1046constructorimpl(m1743decodeULongsVKNKU());
    }

    /* renamed from: decodeFontStyle-_-LCdwA, reason: not valid java name */
    public final int m1745decodeFontStyle_LCdwA() {
        byte decodeByte = decodeByte();
        return decodeByte == 0 ? FontStyle.Companion.getNormal-_-LCdwA() : decodeByte == 1 ? FontStyle.Companion.getItalic-_-LCdwA() : FontStyle.Companion.getNormal-_-LCdwA();
    }

    /* renamed from: decodeFontSynthesis-GVVA2EU, reason: not valid java name */
    public final int m1746decodeFontSynthesisGVVA2EU() {
        byte decodeByte = decodeByte();
        return decodeByte == 0 ? FontSynthesis.Companion.getNone-GVVA2EU() : decodeByte == 1 ? FontSynthesis.Companion.getAll-GVVA2EU() : decodeByte == 3 ? FontSynthesis.Companion.getStyle-GVVA2EU() : decodeByte == 2 ? FontSynthesis.Companion.getWeight-GVVA2EU() : FontSynthesis.Companion.getNone-GVVA2EU();
    }

    @NotNull
    public final FontWeight decodeFontWeight() {
        return new FontWeight(decodeInt());
    }

    @NotNull
    public final SpanStyle decodeSpanStyle() {
        MutableSpanStyle mutableSpanStyle;
        MutableSpanStyle mutableSpanStyle2 = r15;
        MutableSpanStyle mutableSpanStyle3 = new MutableSpanStyle(0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, 16383, null);
        while (this.parcel.dataAvail() > 1) {
            byte decodeByte = decodeByte();
            if (decodeByte != 1) {
                mutableSpanStyle = mutableSpanStyle2;
                if (decodeByte == 2) {
                    if (dataAvailable() < 5) {
                        break;
                    }
                    mutableSpanStyle.m1776setFontSizeR2X_6o(m1747decodeTextUnitXSAIIZE());
                    mutableSpanStyle2 = mutableSpanStyle;
                } else if (decodeByte == 3) {
                    if (dataAvailable() < 4) {
                        break;
                    }
                    mutableSpanStyle.setFontWeight(decodeFontWeight());
                    mutableSpanStyle2 = mutableSpanStyle;
                } else if (decodeByte == 4) {
                    if (dataAvailable() < 1) {
                        break;
                    }
                    mutableSpanStyle.m1777setFontStylemLjRB2g(FontStyle.m1924boximpl(m1745decodeFontStyle_LCdwA()));
                    mutableSpanStyle2 = mutableSpanStyle;
                } else if (decodeByte != 5) {
                    if (decodeByte != 6) {
                        if (decodeByte != 7) {
                            if (decodeByte != 8) {
                                if (decodeByte != 9) {
                                    if (decodeByte != 10) {
                                        if (decodeByte != 11) {
                                            if (decodeByte == 12) {
                                                if (dataAvailable() < 20) {
                                                    break;
                                                }
                                                mutableSpanStyle.setShadow(decodeShadow());
                                            }
                                        } else {
                                            if (dataAvailable() < 4) {
                                                break;
                                            }
                                            mutableSpanStyle.setTextDecoration(decodeTextDecoration());
                                        }
                                    } else {
                                        if (dataAvailable() < 8) {
                                            break;
                                        }
                                        mutableSpanStyle.m1773setBackground8_81llA(m1744decodeColor0d7_KjU());
                                    }
                                } else {
                                    if (dataAvailable() < 8) {
                                        break;
                                    }
                                    mutableSpanStyle.setTextGeometricTransform(decodeTextGeometricTransform());
                                }
                            } else {
                                if (dataAvailable() < 4) {
                                    break;
                                }
                                mutableSpanStyle.m1774setBaselineShift_isdbwI(BaselineShift.m2000boximpl(m1742decodeBaselineShifty9eOQZs()));
                            }
                        } else {
                            if (dataAvailable() < 5) {
                                break;
                            }
                            mutableSpanStyle.m1779setLetterSpacingR2X_6o(m1747decodeTextUnitXSAIIZE());
                        }
                    } else {
                        mutableSpanStyle.setFontFeatureSettings(decodeString());
                    }
                    mutableSpanStyle2 = mutableSpanStyle;
                } else {
                    if (dataAvailable() < 1) {
                        break;
                    }
                    mutableSpanStyle.m1778setFontSynthesistDdu0R4(FontSynthesis.box-impl(m1746decodeFontSynthesisGVVA2EU()));
                    mutableSpanStyle2 = mutableSpanStyle;
                }
            } else {
                if (dataAvailable() < 8) {
                    break;
                }
                mutableSpanStyle2.m1775setColor8_81llA(m1744decodeColor0d7_KjU());
            }
        }
        mutableSpanStyle = mutableSpanStyle2;
        return mutableSpanStyle.toSpanStyle();
    }

    /* renamed from: decodeTextUnit-XSAIIZE, reason: not valid java name */
    public final long m1747decodeTextUnitXSAIIZE() {
        byte decodeByte = decodeByte();
        long j = decodeByte == 1 ? TextUnitType.Companion.getSp-UIouoOA() : decodeByte == 2 ? TextUnitType.Companion.getEm-UIouoOA() : TextUnitType.Companion.getUnspecified-UIouoOA();
        return TextUnitType.equals-impl0(j, TextUnitType.Companion.getUnspecified-UIouoOA()) ? TextUnit.Companion.m2224getUnspecifiedXSAIIZE() : TextUnitKt.m2225TextUnitanM5pPY(decodeFloat(), j);
    }
}
