package androidx.compose.ui.text.platform;

import android.content.Context;
import android.graphics.Typeface;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontListFontFamily;
import androidx.compose.ui.text.font.FontMatcher;
import androidx.compose.ui.text.font.FontSynthesis_androidKt;
import androidx.compose.ui.text.font.FontWeight;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Deprecated(message = "This is not supported after downloadable fonts.")
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class AndroidFontListTypeface implements AndroidTypeface {

    @NotNull
    private static final Companion Companion = new Companion(null);

    @Deprecated
    @NotNull
    private static final FontMatcher fontMatcher = new FontMatcher();

    @NotNull
    private final FontFamily fontFamily;

    @NotNull
    private final FontMatcher fontMatcher$1;

    @NotNull
    private final Map<Font, Typeface> loadedTypefaces;

    /* compiled from: Taobao */
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FontMatcher getFontMatcher() {
            return AndroidFontListTypeface.fontMatcher;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00f6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public AndroidFontListTypeface(@org.jetbrains.annotations.NotNull androidx.compose.ui.text.font.FontListFontFamily r8, @org.jetbrains.annotations.NotNull android.content.Context r9, @org.jetbrains.annotations.Nullable java.util.List<kotlin.Pair<androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontStyle>> r10, @org.jetbrains.annotations.NotNull androidx.compose.ui.text.font.FontMatcher r11) {
        /*
            r7 = this;
            java.lang.String r0 = "fontFamily"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "fontMatcher"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            r7.<init>()
            r7.fontMatcher$1 = r11
            java.util.List r11 = r8.getFonts()
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r11.size()
            r0.<init>(r1)
            int r1 = r11.size()
            r2 = 0
            r3 = 0
        L27:
            if (r3 >= r1) goto L46
            java.lang.Object r4 = r11.get(r3)
            r5 = r4
            androidx.compose.ui.text.font.Font r5 = (androidx.compose.ui.text.font.Font) r5
            int r5 = r5.getLoadingStrategy-PKNRLFQ()
            androidx.compose.ui.text.font.FontLoadingStrategy$Companion r6 = androidx.compose.ui.text.font.FontLoadingStrategy.Companion
            int r6 = r6.m2381getBlockingPKNRLFQ()
            boolean r5 = androidx.compose.ui.text.font.FontLoadingStrategy.m2376equalsimpl0(r5, r6)
            if (r5 == 0) goto L43
            r0.add(r4)
        L43:
            int r3 = r3 + 1
            goto L27
        L46:
            if (r10 == 0) goto Lb2
            java.util.ArrayList r11 = new java.util.ArrayList
            int r1 = r10.size()
            r11.<init>(r1)
            int r1 = r10.size()
            r3 = 0
        L56:
            if (r3 >= r1) goto L80
            java.lang.Object r4 = r10.get(r3)
            kotlin.Pair r4 = (kotlin.Pair) r4
            java.lang.Object r5 = r4.component1()
            androidx.compose.ui.text.font.FontWeight r5 = (androidx.compose.ui.text.font.FontWeight) r5
            java.lang.Object r4 = r4.component2()
            androidx.compose.ui.text.font.FontStyle r4 = (androidx.compose.ui.text.font.FontStyle) r4
            int r4 = r4.unbox-impl()
            androidx.compose.ui.text.font.FontMatcher r6 = r7.fontMatcher$1
            java.util.List r4 = r6.matchFont-RetOiIg(r0, r5, r4)
            java.lang.Object r4 = kotlin.collections.CollectionsKt.firstOrNull(r4)
            androidx.compose.ui.text.font.Font r4 = (androidx.compose.ui.text.font.Font) r4
            r11.add(r4)
            int r3 = r3 + 1
            goto L56
        L80:
            java.util.List r10 = androidx.compose.ui.text.TempListUtilsKt.fastFilterNotNull(r11)
            if (r10 == 0) goto Lb2
            java.util.HashSet r11 = new java.util.HashSet
            int r1 = r10.size()
            r11.<init>(r1)
            java.util.ArrayList r1 = new java.util.ArrayList
            int r3 = r10.size()
            r1.<init>(r3)
            int r3 = r10.size()
            r4 = 0
        L9d:
            if (r4 >= r3) goto Lb3
            java.lang.Object r5 = r10.get(r4)
            r6 = r5
            androidx.compose.ui.text.font.Font r6 = (androidx.compose.ui.text.font.Font) r6
            boolean r6 = r11.add(r6)
            if (r6 == 0) goto Laf
            r1.add(r5)
        Laf:
            int r4 = r4 + 1
            goto L9d
        Lb2:
            r1 = 0
        Lb3:
            if (r1 != 0) goto Lb6
            goto Lb7
        Lb6:
            r0 = r1
        Lb7:
            boolean r10 = r0.isEmpty()
            if (r10 != 0) goto Lf6
            java.util.LinkedHashMap r10 = new java.util.LinkedHashMap
            r10.<init>()
            int r11 = r0.size()
        Lc6:
            if (r2 >= r11) goto Lf1
            java.lang.Object r1 = r0.get(r2)
            androidx.compose.ui.text.font.Font r1 = (androidx.compose.ui.text.font.Font) r1
            androidx.compose.ui.text.platform.AndroidTypefaceCache r3 = androidx.compose.ui.text.platform.AndroidTypefaceCache.INSTANCE     // Catch: java.lang.Exception -> Lda
            android.graphics.Typeface r3 = r3.getOrCreate(r9, r1)     // Catch: java.lang.Exception -> Lda
            r10.put(r1, r3)     // Catch: java.lang.Exception -> Lda
            int r2 = r2 + 1
            goto Lc6
        Lda:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "Cannot create Typeface from "
            r9.append(r10)
            r9.append(r1)
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            throw r8
        Lf1:
            r7.loadedTypefaces = r10
            r7.fontFamily = r8
            return
        Lf6:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "Could not match font"
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.platform.AndroidFontListTypeface.<init>(androidx.compose.ui.text.font.FontListFontFamily, android.content.Context, java.util.List, androidx.compose.ui.text.font.FontMatcher):void");
    }

    @NotNull
    public FontFamily getFontFamily() {
        return this.fontFamily;
    }

    @NotNull
    public final FontMatcher getFontMatcher() {
        return this.fontMatcher$1;
    }

    @NotNull
    /* renamed from: getNativeTypeface-PYhJU0U, reason: not valid java name */
    public Typeface m2460getNativeTypefacePYhJU0U(@NotNull FontWeight fontWeight, int i, int i2) {
        Intrinsics.checkNotNullParameter(fontWeight, "fontWeight");
        Font font = (Font) CollectionsKt.firstOrNull(this.fontMatcher$1.matchFont-RetOiIg(new ArrayList(this.loadedTypefaces.keySet()), fontWeight, i));
        if (font == null) {
            throw new IllegalStateException("Could not load font");
        }
        Typeface typeface = this.loadedTypefaces.get(font);
        if (typeface == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        Object m2398synthesizeTypefaceFxwP2eA = FontSynthesis_androidKt.m2398synthesizeTypefaceFxwP2eA(i2, typeface, font, fontWeight, i);
        Intrinsics.checkNotNull(m2398synthesizeTypefaceFxwP2eA, "null cannot be cast to non-null type android.graphics.Typeface");
        return (Typeface) m2398synthesizeTypefaceFxwP2eA;
    }

    public /* synthetic */ AndroidFontListTypeface(FontListFontFamily fontListFontFamily, Context context, List list, FontMatcher fontMatcher2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(fontListFontFamily, context, (i & 4) != 0 ? null : list, (i & 8) != 0 ? fontMatcher : fontMatcher2);
    }
}
