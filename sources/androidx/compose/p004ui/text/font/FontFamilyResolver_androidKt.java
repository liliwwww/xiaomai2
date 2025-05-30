package androidx.compose.p004ui.text.font;

import android.content.Context;
import android.graphics.Typeface;
import androidx.compose.p004ui.text.InternalTextApi;
import androidx.compose.p004ui.text.font.FontFamily;
import androidx.compose.runtime.State;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class FontFamilyResolver_androidKt {
    @NotNull
    public static final FontFamily.Resolver createFontFamilyResolver(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new FontFamilyResolverImpl(new AndroidFontLoader(context), AndroidFontResolveInterceptor_androidKt.AndroidFontResolveInterceptor(context), null, null, null, 28, null);
    }

    @InternalTextApi
    @NotNull
    public static final FontFamily.Resolver emptyCacheFontFamilyResolver(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new FontFamilyResolverImpl(new AndroidFontLoader(context), null, new TypefaceRequestCache(), new FontListFontFamilyTypefaceAdapter(new AsyncTypefaceCache(), null, 2, null), null, 18, null);
    }

    @NotNull
    /* renamed from: resolveAsTypeface-Wqqsr6A, reason: not valid java name */
    public static final State<Typeface> m4810resolveAsTypefaceWqqsr6A(@NotNull FontFamily.Resolver resolver, @Nullable FontFamily fontFamily, @NotNull FontWeight fontWeight, int i, int i2) {
        Intrinsics.checkNotNullParameter(resolver, "$this$resolveAsTypeface");
        Intrinsics.checkNotNullParameter(fontWeight, "fontWeight");
        State mo4809resolveDPcqOEQ = resolver.mo4809resolveDPcqOEQ(fontFamily, fontWeight, i, i2);
        Intrinsics.checkNotNull(mo4809resolveDPcqOEQ, "null cannot be cast to non-null type androidx.compose.runtime.State<android.graphics.Typeface>");
        return mo4809resolveDPcqOEQ;
    }

    /* renamed from: resolveAsTypeface-Wqqsr6A$default, reason: not valid java name */
    public static /* synthetic */ State m4811resolveAsTypefaceWqqsr6A$default(FontFamily.Resolver resolver, FontFamily fontFamily, FontWeight fontWeight, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            fontFamily = null;
        }
        if ((i3 & 2) != 0) {
            fontWeight = FontWeight.Companion.getNormal();
        }
        if ((i3 & 4) != 0) {
            i = FontStyle.Companion.m4839getNormal_LCdwA();
        }
        if ((i3 & 8) != 0) {
            i2 = FontSynthesis.Companion.m4849getAllGVVA2EU();
        }
        return m4810resolveAsTypefaceWqqsr6A(resolver, fontFamily, fontWeight, i, i2);
    }

    @NotNull
    public static final FontFamily.Resolver createFontFamilyResolver(@NotNull Context context, @NotNull CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        return new FontFamilyResolverImpl(new AndroidFontLoader(context), AndroidFontResolveInterceptor_androidKt.AndroidFontResolveInterceptor(context), FontFamilyResolverKt.getGlobalTypefaceRequestCache(), new FontListFontFamilyTypefaceAdapter(FontFamilyResolverKt.getGlobalAsyncTypefaceCache(), coroutineContext), null, 16, null);
    }
}
