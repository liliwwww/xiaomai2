package androidx.compose.ui.text.font;

import android.taobao.windvane.urlintercept.WVURLRuleConstants;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.kv3;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class AndroidFontResolveInterceptor implements PlatformResolveInterceptor {
    private final int fontWeightAdjustment;

    public AndroidFontResolveInterceptor(int i) {
        this.fontWeightAdjustment = i;
    }

    private final int component1() {
        return this.fontWeightAdjustment;
    }

    public static /* synthetic */ AndroidFontResolveInterceptor copy$default(AndroidFontResolveInterceptor androidFontResolveInterceptor, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = androidFontResolveInterceptor.fontWeightAdjustment;
        }
        return androidFontResolveInterceptor.copy(i);
    }

    @NotNull
    public final AndroidFontResolveInterceptor copy(int i) {
        return new AndroidFontResolveInterceptor(i);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AndroidFontResolveInterceptor) && this.fontWeightAdjustment == ((AndroidFontResolveInterceptor) obj).fontWeightAdjustment;
    }

    public int hashCode() {
        return this.fontWeightAdjustment;
    }

    public /* synthetic */ FontFamily interceptFontFamily(FontFamily fontFamily) {
        return kv3.a(this, fontFamily);
    }

    /* renamed from: interceptFontStyle-T2F_aPo, reason: not valid java name */
    public /* synthetic */ int m1904interceptFontStyleT2F_aPo(int i) {
        return kv3.b(this, i);
    }

    /* renamed from: interceptFontSynthesis-Mscr08Y, reason: not valid java name */
    public /* synthetic */ int m1905interceptFontSynthesisMscr08Y(int i) {
        return kv3.c(this, i);
    }

    @NotNull
    public FontWeight interceptFontWeight(@NotNull FontWeight fontWeight) {
        Intrinsics.checkNotNullParameter(fontWeight, "fontWeight");
        int i = this.fontWeightAdjustment;
        return (i == 0 || i == Integer.MAX_VALUE) ? fontWeight : new FontWeight(RangesKt.coerceIn(fontWeight.getWeight() + this.fontWeightAdjustment, 1, WVURLRuleConstants.LOGIN));
    }

    @NotNull
    public String toString() {
        return "AndroidFontResolveInterceptor(fontWeightAdjustment=" + this.fontWeightAdjustment + ')';
    }
}
