package androidx.compose.p004ui.text.font;

import androidx.compose.p004ui.text.font.FontFamily;
import androidx.compose.runtime.State;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class FontFamilyResolverImpl implements FontFamily.Resolver {

    @NotNull
    private final Function1<TypefaceRequest, Object> createDefaultTypeface;

    @NotNull
    private final FontListFontFamilyTypefaceAdapter fontListFontFamilyTypefaceAdapter;

    @NotNull
    private final PlatformFontFamilyTypefaceAdapter platformFamilyTypefaceAdapter;

    @NotNull
    private final PlatformFontLoader platformFontLoader;

    @NotNull
    private final PlatformResolveInterceptor platformResolveInterceptor;

    @NotNull
    private final TypefaceRequestCache typefaceRequestCache;

    public FontFamilyResolverImpl(@NotNull PlatformFontLoader platformFontLoader, @NotNull PlatformResolveInterceptor platformResolveInterceptor, @NotNull TypefaceRequestCache typefaceRequestCache, @NotNull FontListFontFamilyTypefaceAdapter fontListFontFamilyTypefaceAdapter, @NotNull PlatformFontFamilyTypefaceAdapter platformFontFamilyTypefaceAdapter) {
        Intrinsics.checkNotNullParameter(platformFontLoader, "platformFontLoader");
        Intrinsics.checkNotNullParameter(platformResolveInterceptor, "platformResolveInterceptor");
        Intrinsics.checkNotNullParameter(typefaceRequestCache, "typefaceRequestCache");
        Intrinsics.checkNotNullParameter(fontListFontFamilyTypefaceAdapter, "fontListFontFamilyTypefaceAdapter");
        Intrinsics.checkNotNullParameter(platformFontFamilyTypefaceAdapter, "platformFamilyTypefaceAdapter");
        this.platformFontLoader = platformFontLoader;
        this.platformResolveInterceptor = platformResolveInterceptor;
        this.typefaceRequestCache = typefaceRequestCache;
        this.fontListFontFamilyTypefaceAdapter = fontListFontFamilyTypefaceAdapter;
        this.platformFamilyTypefaceAdapter = platformFontFamilyTypefaceAdapter;
        this.createDefaultTypeface = new Function1<TypefaceRequest, Object>() { // from class: androidx.compose.ui.text.font.FontFamilyResolverImpl$createDefaultTypeface$1
            {
                super(1);
            }

            @NotNull
            public final Object invoke(@NotNull TypefaceRequest typefaceRequest) {
                State resolve;
                Intrinsics.checkNotNullParameter(typefaceRequest, "it");
                resolve = FontFamilyResolverImpl.this.resolve(TypefaceRequest.m4871copye1PVR60$default(typefaceRequest, null, null, 0, 0, null, 30, null));
                return resolve.getValue();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final State<Object> resolve(final TypefaceRequest typefaceRequest) {
        return this.typefaceRequestCache.runCached(typefaceRequest, new Function1<Function1<? super TypefaceResult, ? extends Unit>, TypefaceResult>() { // from class: androidx.compose.ui.text.font.FontFamilyResolverImpl$resolve$result$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @NotNull
            public final TypefaceResult invoke(@NotNull Function1<? super TypefaceResult, Unit> function1) {
                FontListFontFamilyTypefaceAdapter fontListFontFamilyTypefaceAdapter;
                Function1<? super TypefaceRequest, ? extends Object> function12;
                PlatformFontFamilyTypefaceAdapter platformFontFamilyTypefaceAdapter;
                Function1<? super TypefaceRequest, ? extends Object> function13;
                Intrinsics.checkNotNullParameter(function1, "onAsyncCompletion");
                fontListFontFamilyTypefaceAdapter = FontFamilyResolverImpl.this.fontListFontFamilyTypefaceAdapter;
                TypefaceRequest typefaceRequest2 = typefaceRequest;
                PlatformFontLoader platformFontLoader$ui_text_release = FontFamilyResolverImpl.this.getPlatformFontLoader$ui_text_release();
                function12 = FontFamilyResolverImpl.this.createDefaultTypeface;
                TypefaceResult resolve = fontListFontFamilyTypefaceAdapter.resolve(typefaceRequest2, platformFontLoader$ui_text_release, function1, function12);
                if (resolve == null) {
                    platformFontFamilyTypefaceAdapter = FontFamilyResolverImpl.this.platformFamilyTypefaceAdapter;
                    TypefaceRequest typefaceRequest3 = typefaceRequest;
                    PlatformFontLoader platformFontLoader$ui_text_release2 = FontFamilyResolverImpl.this.getPlatformFontLoader$ui_text_release();
                    function13 = FontFamilyResolverImpl.this.createDefaultTypeface;
                    resolve = platformFontFamilyTypefaceAdapter.resolve(typefaceRequest3, platformFontLoader$ui_text_release2, function1, function13);
                    if (resolve == null) {
                        throw new IllegalStateException("Could not load font");
                    }
                }
                return resolve;
            }
        });
    }

    @NotNull
    public final PlatformFontLoader getPlatformFontLoader$ui_text_release() {
        return this.platformFontLoader;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x006c A[LOOP:0: B:11:0x006a->B:12:0x006c, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // androidx.compose.ui.text.font.FontFamily.Resolver
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object preload(@org.jetbrains.annotations.NotNull androidx.compose.p004ui.text.font.FontFamily r14, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r15) {
        /*
            r13 = this;
            boolean r0 = r15 instanceof androidx.compose.p004ui.text.font.FontFamilyResolverImpl$preload$1
            if (r0 == 0) goto L13
            r0 = r15
            androidx.compose.ui.text.font.FontFamilyResolverImpl$preload$1 r0 = (androidx.compose.p004ui.text.font.FontFamilyResolverImpl$preload$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.ui.text.font.FontFamilyResolverImpl$preload$1 r0 = new androidx.compose.ui.text.font.FontFamilyResolverImpl$preload$1
            r0.<init>(r13, r15)
        L18:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r14 = r0.L$1
            androidx.compose.ui.text.font.FontFamily r14 = (androidx.compose.p004ui.text.font.FontFamily) r14
            java.lang.Object r0 = r0.L$0
            androidx.compose.ui.text.font.FontFamilyResolverImpl r0 = (androidx.compose.p004ui.text.font.FontFamilyResolverImpl) r0
            kotlin.ResultKt.throwOnFailure(r15)
            goto L55
        L31:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L39:
            kotlin.ResultKt.throwOnFailure(r15)
            boolean r15 = r14 instanceof androidx.compose.p004ui.text.font.FontListFontFamily
            if (r15 != 0) goto L43
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            return r14
        L43:
            androidx.compose.ui.text.font.FontListFontFamilyTypefaceAdapter r15 = r13.fontListFontFamilyTypefaceAdapter
            androidx.compose.ui.text.font.PlatformFontLoader r2 = r13.platformFontLoader
            r0.L$0 = r13
            r0.L$1 = r14
            r0.label = r3
            java.lang.Object r15 = r15.preload(r14, r2, r0)
            if (r15 != r1) goto L54
            return r1
        L54:
            r0 = r13
        L55:
            r15 = r14
            androidx.compose.ui.text.font.FontListFontFamily r15 = (androidx.compose.p004ui.text.font.FontListFontFamily) r15
            java.util.List r15 = r15.getFonts()
            java.util.ArrayList r1 = new java.util.ArrayList
            int r2 = r15.size()
            r1.<init>(r2)
            r2 = 0
            int r3 = r15.size()
        L6a:
            if (r2 >= r3) goto La5
            java.lang.Object r4 = r15.get(r2)
            androidx.compose.ui.text.font.Font r4 = (androidx.compose.p004ui.text.font.Font) r4
            androidx.compose.ui.text.font.TypefaceRequest r12 = new androidx.compose.ui.text.font.TypefaceRequest
            androidx.compose.ui.text.font.PlatformResolveInterceptor r5 = r0.platformResolveInterceptor
            androidx.compose.ui.text.font.FontFamily r6 = r5.interceptFontFamily(r14)
            androidx.compose.ui.text.font.PlatformResolveInterceptor r5 = r0.platformResolveInterceptor
            androidx.compose.ui.text.font.FontWeight r7 = r4.getWeight()
            androidx.compose.ui.text.font.FontWeight r7 = r5.interceptFontWeight(r7)
            androidx.compose.ui.text.font.PlatformResolveInterceptor r5 = r0.platformResolveInterceptor
            int r4 = r4.mo4790getStyle_LCdwA()
            int r8 = r5.mo4787interceptFontStyleT2F_aPo(r4)
            androidx.compose.ui.text.font.FontSynthesis$Companion r4 = androidx.compose.p004ui.text.font.FontSynthesis.Companion
            int r9 = r4.m4849getAllGVVA2EU()
            androidx.compose.ui.text.font.PlatformFontLoader r4 = r0.platformFontLoader
            java.lang.Object r10 = r4.getCacheKey()
            r11 = 0
            r5 = r12
            r5.<init>(r6, r7, r8, r9, r10, r11)
            r1.add(r12)
            int r2 = r2 + 1
            goto L6a
        La5:
            androidx.compose.ui.text.font.TypefaceRequestCache r14 = r0.typefaceRequestCache
            androidx.compose.ui.text.font.FontFamilyResolverImpl$preload$2 r15 = new androidx.compose.ui.text.font.FontFamilyResolverImpl$preload$2
            r15.<init>()
            r14.preWarmCache(r1, r15)
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.p004ui.text.font.FontFamilyResolverImpl.preload(androidx.compose.ui.text.font.FontFamily, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // androidx.compose.ui.text.font.FontFamily.Resolver
    @NotNull
    /* renamed from: resolve-DPcqOEQ */
    public State<Object> mo4809resolveDPcqOEQ(@Nullable FontFamily fontFamily, @NotNull FontWeight fontWeight, int i, int i2) {
        Intrinsics.checkNotNullParameter(fontWeight, "fontWeight");
        return resolve(new TypefaceRequest(this.platformResolveInterceptor.interceptFontFamily(fontFamily), this.platformResolveInterceptor.interceptFontWeight(fontWeight), this.platformResolveInterceptor.mo4787interceptFontStyleT2F_aPo(i), this.platformResolveInterceptor.mo4788interceptFontSynthesisMscr08Y(i2), this.platformFontLoader.getCacheKey(), null));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ FontFamilyResolverImpl(androidx.compose.p004ui.text.font.PlatformFontLoader r7, androidx.compose.p004ui.text.font.PlatformResolveInterceptor r8, androidx.compose.p004ui.text.font.TypefaceRequestCache r9, androidx.compose.p004ui.text.font.FontListFontFamilyTypefaceAdapter r10, androidx.compose.p004ui.text.font.PlatformFontFamilyTypefaceAdapter r11, int r12, kotlin.jvm.internal.DefaultConstructorMarker r13) {
        /*
            r6 = this;
            r13 = r12 & 2
            if (r13 == 0) goto La
            androidx.compose.ui.text.font.PlatformResolveInterceptor$Companion r8 = androidx.compose.p004ui.text.font.PlatformResolveInterceptor.Companion
            androidx.compose.ui.text.font.PlatformResolveInterceptor r8 = r8.getDefault$ui_text_release()
        La:
            r2 = r8
            r8 = r12 & 4
            if (r8 == 0) goto L13
            androidx.compose.ui.text.font.TypefaceRequestCache r9 = androidx.compose.p004ui.text.font.FontFamilyResolverKt.getGlobalTypefaceRequestCache()
        L13:
            r3 = r9
            r8 = r12 & 8
            if (r8 == 0) goto L23
            androidx.compose.ui.text.font.FontListFontFamilyTypefaceAdapter r10 = new androidx.compose.ui.text.font.FontListFontFamilyTypefaceAdapter
            androidx.compose.ui.text.font.AsyncTypefaceCache r8 = androidx.compose.p004ui.text.font.FontFamilyResolverKt.getGlobalAsyncTypefaceCache()
            r9 = 0
            r13 = 2
            r10.<init>(r8, r9, r13, r9)
        L23:
            r4 = r10
            r8 = r12 & 16
            if (r8 == 0) goto L2d
            androidx.compose.ui.text.font.PlatformFontFamilyTypefaceAdapter r11 = new androidx.compose.ui.text.font.PlatformFontFamilyTypefaceAdapter
            r11.<init>()
        L2d:
            r5 = r11
            r0 = r6
            r1 = r7
            r0.<init>(r1, r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.p004ui.text.font.FontFamilyResolverImpl.<init>(androidx.compose.ui.text.font.PlatformFontLoader, androidx.compose.ui.text.font.PlatformResolveInterceptor, androidx.compose.ui.text.font.TypefaceRequestCache, androidx.compose.ui.text.font.FontListFontFamilyTypefaceAdapter, androidx.compose.ui.text.font.PlatformFontFamilyTypefaceAdapter, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
