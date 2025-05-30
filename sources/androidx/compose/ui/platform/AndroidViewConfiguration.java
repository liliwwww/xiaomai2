package androidx.compose.ui.platform;

import android.view.ViewConfiguration;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tb.p26;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class AndroidViewConfiguration implements ViewConfiguration {
    public static final int $stable = 8;

    @NotNull
    private final ViewConfiguration viewConfiguration;

    public AndroidViewConfiguration(@NotNull ViewConfiguration viewConfiguration) {
        Intrinsics.checkNotNullParameter(viewConfiguration, "viewConfiguration");
        this.viewConfiguration = viewConfiguration;
    }

    public long getDoubleTapMinTimeMillis() {
        return 40L;
    }

    public long getDoubleTapTimeoutMillis() {
        return ViewConfiguration.getDoubleTapTimeout();
    }

    public long getLongPressTimeoutMillis() {
        return ViewConfiguration.getLongPressTimeout();
    }

    /* renamed from: getMinimumTouchTargetSize-MYxV2XQ, reason: not valid java name */
    public /* synthetic */ long m2204getMinimumTouchTargetSizeMYxV2XQ() {
        return p26.a(this);
    }

    public float getTouchSlop() {
        return this.viewConfiguration.getScaledTouchSlop();
    }
}
