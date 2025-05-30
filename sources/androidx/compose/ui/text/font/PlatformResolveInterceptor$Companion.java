package androidx.compose.ui.text.font;

import org.jetbrains.annotations.NotNull;
import tb.kv3;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class PlatformResolveInterceptor$Companion {
    static final /* synthetic */ PlatformResolveInterceptor$Companion $$INSTANCE = new PlatformResolveInterceptor$Companion();

    @NotNull
    private static final PlatformResolveInterceptor Default = new PlatformResolveInterceptor() { // from class: androidx.compose.ui.text.font.PlatformResolveInterceptor$Companion$Default$1
        public /* synthetic */ FontFamily interceptFontFamily(FontFamily fontFamily) {
            return kv3.a(this, fontFamily);
        }

        /* renamed from: interceptFontStyle-T2F_aPo, reason: not valid java name */
        public /* synthetic */ int m1931interceptFontStyleT2F_aPo(int i) {
            return kv3.b(this, i);
        }

        /* renamed from: interceptFontSynthesis-Mscr08Y, reason: not valid java name */
        public /* synthetic */ int m1932interceptFontSynthesisMscr08Y(int i) {
            return kv3.c(this, i);
        }

        public /* synthetic */ FontWeight interceptFontWeight(FontWeight fontWeight) {
            return kv3.d(this, fontWeight);
        }
    };

    private PlatformResolveInterceptor$Companion() {
    }

    @NotNull
    public final PlatformResolveInterceptor getDefault$ui_text_release() {
        return Default;
    }
}
