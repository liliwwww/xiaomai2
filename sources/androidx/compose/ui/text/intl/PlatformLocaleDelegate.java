package androidx.compose.ui.text.intl;

import java.util.List;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public interface PlatformLocaleDelegate {
    @NotNull
    List<PlatformLocale> getCurrent();

    @NotNull
    PlatformLocale parseLanguageTag(@NotNull String str);
}
