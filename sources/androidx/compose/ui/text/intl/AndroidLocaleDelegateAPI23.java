package androidx.compose.ui.text.intl;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class AndroidLocaleDelegateAPI23 implements PlatformLocaleDelegate {
    @NotNull
    public List<PlatformLocale> getCurrent() {
        java.util.Locale locale = java.util.Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        return CollectionsKt.listOf(new AndroidLocale(locale));
    }

    @NotNull
    public PlatformLocale parseLanguageTag(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "languageTag");
        java.util.Locale forLanguageTag = java.util.Locale.forLanguageTag(str);
        Intrinsics.checkNotNullExpressionValue(forLanguageTag, "forLanguageTag(languageTag)");
        return new AndroidLocale(forLanguageTag);
    }
}
