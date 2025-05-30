package androidx.compose.ui.text.font;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public interface PlatformResolveInterceptor {

    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;

    @Nullable
    FontFamily interceptFontFamily(@Nullable FontFamily fontFamily);

    /* renamed from: interceptFontStyle-T2F_aPo, reason: not valid java name */
    int m2402interceptFontStyleT2F_aPo(int i);

    /* renamed from: interceptFontSynthesis-Mscr08Y, reason: not valid java name */
    int m2403interceptFontSynthesisMscr08Y(int i);

    @NotNull
    FontWeight interceptFontWeight(@NotNull FontWeight fontWeight);
}
