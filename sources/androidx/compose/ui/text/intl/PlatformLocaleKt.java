package androidx.compose.ui.text.intl;

import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class PlatformLocaleKt {

    @NotNull
    private static final PlatformLocaleDelegate platformLocaleDelegate = AndroidPlatformLocale_androidKt.createPlatformLocaleDelegate();

    @NotNull
    public static final PlatformLocaleDelegate getPlatformLocaleDelegate() {
        return platformLocaleDelegate;
    }
}
