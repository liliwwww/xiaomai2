package androidx.compose.p004ui.text.intl;

import java.util.List;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface PlatformLocaleDelegate {
    @NotNull
    List<PlatformLocale> getCurrent();

    @NotNull
    PlatformLocale parseLanguageTag(@NotNull String str);
}
