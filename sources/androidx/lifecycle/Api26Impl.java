package androidx.lifecycle;

import android.taobao.windvane.extra.p002uc.preRender.BasePreInitManager;
import androidx.annotation.RequiresApi;
import java.time.Duration;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@RequiresApi(26)
/* loaded from: classes.dex */
public final class Api26Impl {

    @NotNull
    public static final Api26Impl INSTANCE = new Api26Impl();

    private Api26Impl() {
    }

    public final long toMillis(@NotNull Duration duration) {
        Intrinsics.checkNotNullParameter(duration, BasePreInitManager.TIMEOUT);
        return duration.toMillis();
    }
}
