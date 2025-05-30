package androidx.compose.p004ui.text.font;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.kv3;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface PlatformResolveInterceptor {

    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        @NotNull
        private static final PlatformResolveInterceptor Default = new PlatformResolveInterceptor() { // from class: androidx.compose.ui.text.font.PlatformResolveInterceptor$Companion$Default$1
            @Override // androidx.compose.p004ui.text.font.PlatformResolveInterceptor
            public /* synthetic */ FontFamily interceptFontFamily(FontFamily fontFamily) {
                return kv3.a(this, fontFamily);
            }

            @Override // androidx.compose.p004ui.text.font.PlatformResolveInterceptor
            /* renamed from: interceptFontStyle-T2F_aPo */
            public /* synthetic */ int mo4787interceptFontStyleT2F_aPo(int i) {
                return kv3.b(this, i);
            }

            @Override // androidx.compose.p004ui.text.font.PlatformResolveInterceptor
            /* renamed from: interceptFontSynthesis-Mscr08Y */
            public /* synthetic */ int mo4788interceptFontSynthesisMscr08Y(int i) {
                return kv3.c(this, i);
            }

            @Override // androidx.compose.p004ui.text.font.PlatformResolveInterceptor
            public /* synthetic */ FontWeight interceptFontWeight(FontWeight fontWeight) {
                return kv3.d(this, fontWeight);
            }
        };

        private Companion() {
        }

        @NotNull
        public final PlatformResolveInterceptor getDefault$ui_text_release() {
            return Default;
        }
    }

    @Nullable
    FontFamily interceptFontFamily(@Nullable FontFamily fontFamily);

    /* renamed from: interceptFontStyle-T2F_aPo */
    int mo4787interceptFontStyleT2F_aPo(int i);

    /* renamed from: interceptFontSynthesis-Mscr08Y */
    int mo4788interceptFontSynthesisMscr08Y(int i);

    @NotNull
    FontWeight interceptFontWeight(@NotNull FontWeight fontWeight);
}
