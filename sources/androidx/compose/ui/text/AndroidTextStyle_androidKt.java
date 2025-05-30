package androidx.compose.ui.text;

import android.taobao.windvane.extra.uc.AliRequestAdapter;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class AndroidTextStyle_androidKt {
    public static final boolean DefaultIncludeFontPadding = true;

    @NotNull
    public static final PlatformTextStyle createPlatformTextStyle(@Nullable PlatformSpanStyle platformSpanStyle, @Nullable PlatformParagraphStyle platformParagraphStyle) {
        return new PlatformTextStyle(platformSpanStyle, platformParagraphStyle);
    }

    @NotNull
    public static final PlatformParagraphStyle lerp(@NotNull PlatformParagraphStyle platformParagraphStyle, @NotNull PlatformParagraphStyle platformParagraphStyle2, float f) {
        Intrinsics.checkNotNullParameter(platformParagraphStyle, "start");
        Intrinsics.checkNotNullParameter(platformParagraphStyle2, AliRequestAdapter.PHASE_STOP);
        return platformParagraphStyle.getIncludeFontPadding() == platformParagraphStyle2.getIncludeFontPadding() ? platformParagraphStyle : new PlatformParagraphStyle(((EmojiSupportMatch) SpanStyleKt.lerpDiscrete(EmojiSupportMatch.box-impl(platformParagraphStyle.m2276getEmojiSupportMatch_3YsG6Y()), EmojiSupportMatch.box-impl(platformParagraphStyle2.m2276getEmojiSupportMatch_3YsG6Y()), f)).unbox-impl(), ((Boolean) SpanStyleKt.lerpDiscrete(Boolean.valueOf(platformParagraphStyle.getIncludeFontPadding()), Boolean.valueOf(platformParagraphStyle2.getIncludeFontPadding()), f)).booleanValue(), (DefaultConstructorMarker) null);
    }

    @NotNull
    public static final PlatformSpanStyle lerp(@NotNull PlatformSpanStyle platformSpanStyle, @NotNull PlatformSpanStyle platformSpanStyle2, float f) {
        Intrinsics.checkNotNullParameter(platformSpanStyle, "start");
        Intrinsics.checkNotNullParameter(platformSpanStyle2, AliRequestAdapter.PHASE_STOP);
        return platformSpanStyle;
    }
}
