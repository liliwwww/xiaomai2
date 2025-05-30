package androidx.compose.p004ui.hapticfeedback;

import android.view.View;
import androidx.compose.p004ui.hapticfeedback.HapticFeedbackType;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class PlatformHapticFeedback implements HapticFeedback {

    @NotNull
    private final View view;

    public PlatformHapticFeedback(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.view = view;
    }

    @Override // androidx.compose.p004ui.hapticfeedback.HapticFeedback
    /* renamed from: performHapticFeedback-CdsT49E */
    public void mo3341performHapticFeedbackCdsT49E(int i) {
        HapticFeedbackType.Companion companion = HapticFeedbackType.Companion;
        if (HapticFeedbackType.m3345equalsimpl0(i, companion.m3349getLongPress5zf0vsI())) {
            this.view.performHapticFeedback(0);
        } else if (HapticFeedbackType.m3345equalsimpl0(i, companion.m3350getTextHandleMove5zf0vsI())) {
            this.view.performHapticFeedback(9);
        }
    }
}
