package androidx.compose.ui.text.font;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.aa5;
import tb.i80;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class FontListFontFamilyTypefaceAdapter implements FontFamilyTypefaceAdapter {

    @NotNull
    private CoroutineScope asyncLoadScope;

    @NotNull
    private final AsyncTypefaceCache asyncTypefaceCache;

    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @NotNull
    private static final FontMatcher fontMatcher = new FontMatcher();

    @NotNull
    private static final CoroutineExceptionHandler DropExceptionHandler = new FontListFontFamilyTypefaceAdapter$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key);

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public FontListFontFamilyTypefaceAdapter() {
        /*
            r2 = this;
            r0 = 0
            r1 = 3
            r2.<init>(r0, r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.font.FontListFontFamilyTypefaceAdapter.<init>():void");
    }

    public FontListFontFamilyTypefaceAdapter(@NotNull AsyncTypefaceCache asyncTypefaceCache, @NotNull CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(asyncTypefaceCache, "asyncTypefaceCache");
        Intrinsics.checkNotNullParameter(coroutineContext, "injectedContext");
        this.asyncTypefaceCache = asyncTypefaceCache;
        this.asyncLoadScope = i80.a(DropExceptionHandler.plus(coroutineContext).plus(aa5.a(coroutineContext.get(Job.Key))));
    }

    @Nullable
    public final Object preload(@NotNull FontFamily fontFamily, @NotNull PlatformFontLoader platformFontLoader, @NotNull Continuation<? super Unit> continuation) {
        if (!(fontFamily instanceof FontListFontFamily)) {
            return Unit.INSTANCE;
        }
        FontListFontFamily fontListFontFamily = (FontListFontFamily) fontFamily;
        List<Font> fonts = fontListFontFamily.getFonts();
        List<Font> fonts2 = fontListFontFamily.getFonts();
        ArrayList arrayList = new ArrayList(fonts2.size());
        int size = fonts2.size();
        for (int i = 0; i < size; i++) {
            Font font = fonts2.get(i);
            if (FontLoadingStrategy.m2376equalsimpl0(font.getLoadingStrategy-PKNRLFQ(), FontLoadingStrategy.Companion.m2380getAsyncPKNRLFQ())) {
                arrayList.add(font);
            }
        }
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        int size2 = arrayList.size();
        for (int i2 = 0; i2 < size2; i2++) {
            Font font2 = (Font) arrayList.get(i2);
            arrayList2.add(TuplesKt.to(font2.getWeight(), FontStyle.box-impl(font2.getStyle-_-LCdwA())));
        }
        HashSet hashSet = new HashSet(arrayList2.size());
        ArrayList arrayList3 = new ArrayList(arrayList2.size());
        int size3 = arrayList2.size();
        for (int i3 = 0; i3 < size3; i3++) {
            Object obj = arrayList2.get(i3);
            if (hashSet.add((Pair) obj)) {
                arrayList3.add(obj);
            }
        }
        ArrayList arrayList4 = new ArrayList();
        int size4 = arrayList3.size();
        for (int i4 = 0; i4 < size4; i4++) {
            Pair pair = (Pair) arrayList3.get(i4);
            FontWeight fontWeight = (FontWeight) pair.component1();
            int i5 = ((FontStyle) pair.component2()).unbox-impl();
            List list = (List) FontListFontFamilyTypefaceAdapterKt.access$firstImmediatelyAvailable(fontMatcher.matchFont-RetOiIg(fonts, fontWeight, i5), new TypefaceRequest(fontFamily, fontWeight, i5, FontSynthesis.Companion.m2394getAllGVVA2EU(), platformFontLoader.getCacheKey(), (DefaultConstructorMarker) null), this.asyncTypefaceCache, platformFontLoader, preload.2.1.INSTANCE).component1();
            if (list != null) {
                arrayList4.add(CollectionsKt.first(list));
            }
        }
        Object g = i80.g(new FontListFontFamilyTypefaceAdapter$preload$3(arrayList4, this, platformFontLoader, null), continuation);
        return g == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? g : Unit.INSTANCE;
    }

    @Override // androidx.compose.ui.text.font.FontFamilyTypefaceAdapter
    @Nullable
    public TypefaceResult resolve(@NotNull TypefaceRequest typefaceRequest, @NotNull PlatformFontLoader platformFontLoader, @NotNull Function1<? super TypefaceResult$Immutable, Unit> function1, @NotNull Function1<? super TypefaceRequest, ? extends Object> function12) {
        Intrinsics.checkNotNullParameter(typefaceRequest, "typefaceRequest");
        Intrinsics.checkNotNullParameter(platformFontLoader, "platformFontLoader");
        Intrinsics.checkNotNullParameter(function1, "onAsyncCompletion");
        Intrinsics.checkNotNullParameter(function12, "createDefaultTypeface");
        if (!(typefaceRequest.getFontFamily() instanceof FontListFontFamily)) {
            return null;
        }
        Pair access$firstImmediatelyAvailable = FontListFontFamilyTypefaceAdapterKt.access$firstImmediatelyAvailable(fontMatcher.matchFont-RetOiIg(typefaceRequest.getFontFamily().getFonts(), typefaceRequest.getFontWeight(), typefaceRequest.getFontStyle-_-LCdwA()), typefaceRequest, this.asyncTypefaceCache, platformFontLoader, function12);
        List list = (List) access$firstImmediatelyAvailable.component1();
        Object component2 = access$firstImmediatelyAvailable.component2();
        if (list == null) {
            return new TypefaceResult$Immutable(component2, false, 2, null);
        }
        AsyncFontListLoader asyncFontListLoader = new AsyncFontListLoader(list, component2, typefaceRequest, this.asyncTypefaceCache, function1, platformFontLoader);
        d.d(this.asyncLoadScope, (CoroutineContext) null, CoroutineStart.UNDISPATCHED, new resolve.1(asyncFontListLoader, (Continuation) null), 1, (Object) null);
        return new TypefaceResult$Async(asyncFontListLoader);
    }

    public /* synthetic */ FontListFontFamilyTypefaceAdapter(AsyncTypefaceCache asyncTypefaceCache, CoroutineContext coroutineContext, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new AsyncTypefaceCache() : asyncTypefaceCache, (i & 2) != 0 ? EmptyCoroutineContext.INSTANCE : coroutineContext);
    }
}
