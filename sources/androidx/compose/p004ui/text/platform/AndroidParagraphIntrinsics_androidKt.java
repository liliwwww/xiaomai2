package androidx.compose.p004ui.text.platform;

import androidx.compose.p004ui.text.AnnotatedString;
import androidx.compose.p004ui.text.EmojiSupportMatch;
import androidx.compose.p004ui.text.ParagraphIntrinsics;
import androidx.compose.p004ui.text.Placeholder;
import androidx.compose.p004ui.text.PlatformParagraphStyle;
import androidx.compose.p004ui.text.PlatformTextStyle;
import androidx.compose.p004ui.text.SpanStyle;
import androidx.compose.p004ui.text.TextStyle;
import androidx.compose.p004ui.text.font.FontFamily;
import androidx.compose.p004ui.text.intl.LocaleList;
import androidx.compose.p004ui.text.style.TextDirection;
import androidx.compose.p004ui.unit.Density;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class AndroidParagraphIntrinsics_androidKt {
    @NotNull
    public static final ParagraphIntrinsics ActualParagraphIntrinsics(@NotNull String str, @NotNull TextStyle textStyle, @NotNull List<AnnotatedString.Range<SpanStyle>> list, @NotNull List<AnnotatedString.Range<Placeholder>> list2, @NotNull Density density, @NotNull FontFamily.Resolver resolver) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(textStyle, "style");
        Intrinsics.checkNotNullParameter(list, "spanStyles");
        Intrinsics.checkNotNullParameter(list2, "placeholders");
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(resolver, "fontFamilyResolver");
        return new AndroidParagraphIntrinsics(str, textStyle, list, list2, resolver, density);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getHasEmojiCompat(TextStyle textStyle) {
        PlatformParagraphStyle paragraphStyle;
        PlatformTextStyle platformStyle = textStyle.getPlatformStyle();
        return !(((platformStyle == null || (paragraphStyle = platformStyle.getParagraphStyle()) == null) ? null : EmojiSupportMatch.m4623boximpl(paragraphStyle.m4674getEmojiSupportMatch_3YsG6Y())) == null ? false : EmojiSupportMatch.m4626equalsimpl0(r1.m4629unboximpl(), EmojiSupportMatch.Companion.m4631getNone_3YsG6Y()));
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0062, code lost:
    
        if (r6 == null) goto L22;
     */
    /* renamed from: resolveTextDirectionHeuristics-9GRLPo0, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final int m4964resolveTextDirectionHeuristics9GRLPo0(@org.jetbrains.annotations.Nullable androidx.compose.p004ui.text.style.TextDirection r6, @org.jetbrains.annotations.Nullable androidx.compose.p004ui.text.intl.LocaleList r7) {
        /*
            if (r6 == 0) goto L7
            int r6 = r6.m5091unboximpl()
            goto Ld
        L7:
            androidx.compose.ui.text.style.TextDirection$Companion r6 = androidx.compose.p004ui.text.style.TextDirection.Companion
            int r6 = r6.m5092getContents_7Xco()
        Ld:
            androidx.compose.ui.text.style.TextDirection$Companion r0 = androidx.compose.p004ui.text.style.TextDirection.Companion
            int r1 = r0.m5093getContentOrLtrs_7Xco()
            boolean r1 = androidx.compose.p004ui.text.style.TextDirection.m5088equalsimpl0(r6, r1)
            r2 = 1
            r3 = 0
            r4 = 3
            r5 = 2
            if (r1 == 0) goto L1f
        L1d:
            r2 = 2
            goto L71
        L1f:
            int r1 = r0.m5094getContentOrRtls_7Xco()
            boolean r1 = androidx.compose.p004ui.text.style.TextDirection.m5088equalsimpl0(r6, r1)
            if (r1 == 0) goto L2b
        L29:
            r2 = 3
            goto L71
        L2b:
            int r1 = r0.m5095getLtrs_7Xco()
            boolean r1 = androidx.compose.p004ui.text.style.TextDirection.m5088equalsimpl0(r6, r1)
            if (r1 == 0) goto L37
            r2 = 0
            goto L71
        L37:
            int r1 = r0.m5096getRtls_7Xco()
            boolean r1 = androidx.compose.p004ui.text.style.TextDirection.m5088equalsimpl0(r6, r1)
            if (r1 == 0) goto L42
            goto L71
        L42:
            int r0 = r0.m5092getContents_7Xco()
            boolean r6 = androidx.compose.p004ui.text.style.TextDirection.m5088equalsimpl0(r6, r0)
            if (r6 == 0) goto L72
            if (r7 == 0) goto L64
            androidx.compose.ui.text.intl.Locale r6 = r7.get(r3)
            androidx.compose.ui.text.intl.PlatformLocale r6 = r6.getPlatformLocale$ui_text_release()
            java.lang.String r7 = "null cannot be cast to non-null type androidx.compose.ui.text.intl.AndroidLocale"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6, r7)
            androidx.compose.ui.text.intl.AndroidLocale r6 = (androidx.compose.p004ui.text.intl.AndroidLocale) r6
            java.util.Locale r6 = r6.getJavaLocale()
            if (r6 != 0) goto L68
        L64:
            java.util.Locale r6 = java.util.Locale.getDefault()
        L68:
            int r6 = androidx.core.text.TextUtilsCompat.getLayoutDirectionFromLocale(r6)
            if (r6 == 0) goto L1d
            if (r6 == r2) goto L29
            goto L1d
        L71:
            return r2
        L72:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "Invalid TextDirection."
            java.lang.String r7 = r7.toString()
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.p004ui.text.platform.AndroidParagraphIntrinsics_androidKt.m4964resolveTextDirectionHeuristics9GRLPo0(androidx.compose.ui.text.style.TextDirection, androidx.compose.ui.text.intl.LocaleList):int");
    }

    /* renamed from: resolveTextDirectionHeuristics-9GRLPo0$default, reason: not valid java name */
    public static /* synthetic */ int m4965resolveTextDirectionHeuristics9GRLPo0$default(TextDirection textDirection, LocaleList localeList, int i, Object obj) {
        if ((i & 1) != 0) {
            textDirection = null;
        }
        if ((i & 2) != 0) {
            localeList = null;
        }
        return m4964resolveTextDirectionHeuristics9GRLPo0(textDirection, localeList);
    }
}
