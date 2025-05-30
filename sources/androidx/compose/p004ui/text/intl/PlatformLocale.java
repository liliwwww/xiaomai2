package androidx.compose.p004ui.text.intl;

import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface PlatformLocale {
    @NotNull
    String getLanguage();

    @NotNull
    String getRegion();

    @NotNull
    String getScript();

    @NotNull
    String toLanguageTag();
}
