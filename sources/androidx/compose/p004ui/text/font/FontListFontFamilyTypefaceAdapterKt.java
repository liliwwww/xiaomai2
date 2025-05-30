package androidx.compose.p004ui.text.font;

import androidx.compose.p004ui.text.font.AsyncTypefaceCache;
import androidx.compose.p004ui.text.font.FontLoadingStrategy;
import java.util.List;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class FontListFontFamilyTypefaceAdapterKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair<List<Font>, Object> firstImmediatelyAvailable(List<? extends Font> list, TypefaceRequest typefaceRequest, AsyncTypefaceCache asyncTypefaceCache, PlatformFontLoader platformFontLoader, Function1<? super TypefaceRequest, ? extends Object> function1) {
        Object loadBlocking;
        Object obj;
        int size = list.size();
        List list2 = null;
        for (int i = 0; i < size; i++) {
            Font font = list.get(i);
            int mo4780getLoadingStrategyPKNRLFQ = font.mo4780getLoadingStrategyPKNRLFQ();
            FontLoadingStrategy.Companion companion = FontLoadingStrategy.Companion;
            if (FontLoadingStrategy.m4821equalsimpl0(mo4780getLoadingStrategyPKNRLFQ, companion.m4826getBlockingPKNRLFQ())) {
                synchronized (asyncTypefaceCache.cacheLock) {
                    AsyncTypefaceCache.Key key = new AsyncTypefaceCache.Key(font, platformFontLoader.getCacheKey());
                    AsyncTypefaceCache.AsyncTypefaceResult asyncTypefaceResult = (AsyncTypefaceCache.AsyncTypefaceResult) asyncTypefaceCache.resultCache.get(key);
                    if (asyncTypefaceResult == null) {
                        asyncTypefaceResult = (AsyncTypefaceCache.AsyncTypefaceResult) asyncTypefaceCache.permanentCache.get(key);
                    }
                    if (asyncTypefaceResult != null) {
                        loadBlocking = asyncTypefaceResult.m4799unboximpl();
                    } else {
                        Unit unit = Unit.INSTANCE;
                        try {
                            loadBlocking = platformFontLoader.loadBlocking(font);
                            AsyncTypefaceCache.put$default(asyncTypefaceCache, font, platformFontLoader, loadBlocking, false, 8, null);
                        } catch (Exception e) {
                            throw new IllegalStateException("Unable to load font " + font, e);
                        }
                    }
                }
                if (loadBlocking != null) {
                    return TuplesKt.to(list2, FontSynthesis_androidKt.m4853synthesizeTypefaceFxwP2eA(typefaceRequest.m4876getFontSynthesisGVVA2EU(), loadBlocking, font, typefaceRequest.getFontWeight(), typefaceRequest.m4875getFontStyle_LCdwA()));
                }
                throw new IllegalStateException("Unable to load font " + font);
            }
            if (FontLoadingStrategy.m4821equalsimpl0(mo4780getLoadingStrategyPKNRLFQ, companion.m4827getOptionalLocalPKNRLFQ())) {
                synchronized (asyncTypefaceCache.cacheLock) {
                    AsyncTypefaceCache.Key key2 = new AsyncTypefaceCache.Key(font, platformFontLoader.getCacheKey());
                    AsyncTypefaceCache.AsyncTypefaceResult asyncTypefaceResult2 = (AsyncTypefaceCache.AsyncTypefaceResult) asyncTypefaceCache.resultCache.get(key2);
                    if (asyncTypefaceResult2 == null) {
                        asyncTypefaceResult2 = (AsyncTypefaceCache.AsyncTypefaceResult) asyncTypefaceCache.permanentCache.get(key2);
                    }
                    if (asyncTypefaceResult2 != null) {
                        obj = asyncTypefaceResult2.m4799unboximpl();
                    } else {
                        Unit unit2 = Unit.INSTANCE;
                        try {
                            Result.Companion companion2 = Result.Companion;
                            obj = Result.constructor-impl(platformFontLoader.loadBlocking(font));
                        } catch (Throwable th) {
                            Result.Companion companion3 = Result.Companion;
                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                        }
                        if (Result.isFailure-impl(obj)) {
                            obj = null;
                        }
                        AsyncTypefaceCache.put$default(asyncTypefaceCache, font, platformFontLoader, obj, false, 8, null);
                    }
                }
                if (obj != null) {
                    return TuplesKt.to(list2, FontSynthesis_androidKt.m4853synthesizeTypefaceFxwP2eA(typefaceRequest.m4876getFontSynthesisGVVA2EU(), obj, font, typefaceRequest.getFontWeight(), typefaceRequest.m4875getFontStyle_LCdwA()));
                }
            } else {
                if (!FontLoadingStrategy.m4821equalsimpl0(mo4780getLoadingStrategyPKNRLFQ, companion.m4825getAsyncPKNRLFQ())) {
                    throw new IllegalStateException("Unknown font type " + font);
                }
                AsyncTypefaceCache.AsyncTypefaceResult m4791get1ASDuI8 = asyncTypefaceCache.m4791get1ASDuI8(font, platformFontLoader);
                if (m4791get1ASDuI8 == null) {
                    if (list2 == null) {
                        list2 = CollectionsKt.mutableListOf(new Font[]{font});
                    } else {
                        list2.add(font);
                    }
                } else if (!AsyncTypefaceCache.AsyncTypefaceResult.m4797isPermanentFailureimpl(m4791get1ASDuI8.m4799unboximpl()) && m4791get1ASDuI8.m4799unboximpl() != null) {
                    return TuplesKt.to(list2, FontSynthesis_androidKt.m4853synthesizeTypefaceFxwP2eA(typefaceRequest.m4876getFontSynthesisGVVA2EU(), m4791get1ASDuI8.m4799unboximpl(), font, typefaceRequest.getFontWeight(), typefaceRequest.m4875getFontStyle_LCdwA()));
                }
            }
        }
        return TuplesKt.to(list2, function1.invoke(typefaceRequest));
    }
}
