package androidx.compose.p004ui.text.intl;

import android.os.Build;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class AndroidPlatformLocale_androidKt {
    @NotNull
    public static final PlatformLocaleDelegate createPlatformLocaleDelegate() {
        return Build.VERSION.SDK_INT >= 24 ? new AndroidLocaleDelegateAPI24() : new AndroidLocaleDelegateAPI23();
    }
}
