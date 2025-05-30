package androidx.compose.ui.text;

import androidx.compose.ui.text.intl.PlatformLocale;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public interface PlatformStringDelegate {
    @NotNull
    String capitalize(@NotNull String str, @NotNull PlatformLocale platformLocale);

    @NotNull
    String decapitalize(@NotNull String str, @NotNull PlatformLocale platformLocale);

    @NotNull
    String toLowerCase(@NotNull String str, @NotNull PlatformLocale platformLocale);

    @NotNull
    String toUpperCase(@NotNull String str, @NotNull PlatformLocale platformLocale);
}
