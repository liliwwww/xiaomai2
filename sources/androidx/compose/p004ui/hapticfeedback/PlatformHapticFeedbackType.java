package androidx.compose.p004ui.hapticfeedback;

import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class PlatformHapticFeedbackType {

    @NotNull
    public static final PlatformHapticFeedbackType INSTANCE = new PlatformHapticFeedbackType();
    private static final int LongPress = HapticFeedbackType.m3343constructorimpl(0);
    private static final int TextHandleMove = HapticFeedbackType.m3343constructorimpl(9);

    private PlatformHapticFeedbackType() {
    }

    /* renamed from: getLongPress-5zf0vsI, reason: not valid java name */
    public final int m3351getLongPress5zf0vsI() {
        return LongPress;
    }

    /* renamed from: getTextHandleMove-5zf0vsI, reason: not valid java name */
    public final int m3352getTextHandleMove5zf0vsI() {
        return TextHandleMove;
    }
}
