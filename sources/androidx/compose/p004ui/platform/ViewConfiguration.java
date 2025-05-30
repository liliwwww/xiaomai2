package androidx.compose.p004ui.platform;

import org.jetbrains.annotations.NotNull;
import tb.p26;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface ViewConfiguration {

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        @Deprecated
        /* renamed from: getMinimumTouchTargetSize-MYxV2XQ, reason: not valid java name */
        public static long m4567getMinimumTouchTargetSizeMYxV2XQ(@NotNull ViewConfiguration viewConfiguration) {
            return p26.b(viewConfiguration);
        }
    }

    long getDoubleTapMinTimeMillis();

    long getDoubleTapTimeoutMillis();

    long getLongPressTimeoutMillis();

    /* renamed from: getMinimumTouchTargetSize-MYxV2XQ */
    long mo4317getMinimumTouchTargetSizeMYxV2XQ();

    float getTouchSlop();
}
