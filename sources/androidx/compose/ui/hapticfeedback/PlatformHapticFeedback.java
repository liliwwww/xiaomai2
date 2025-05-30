package androidx.compose.ui.hapticfeedback;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class PlatformHapticFeedback implements HapticFeedback {

    @NotNull
    private final View view;

    public PlatformHapticFeedback(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.view = view;
    }

    @Override // androidx.compose.ui.hapticfeedback.HapticFeedback
    /* renamed from: performHapticFeedback-CdsT49E */
    public void mo1348performHapticFeedbackCdsT49E(int i) {
        HapticFeedbackType$Companion hapticFeedbackType$Companion = HapticFeedbackType.Companion;
        if (HapticFeedbackType.equals-impl0(i, hapticFeedbackType$Companion.m1349getLongPress5zf0vsI())) {
            this.view.performHapticFeedback(0);
        } else if (HapticFeedbackType.equals-impl0(i, hapticFeedbackType$Companion.m1350getTextHandleMove5zf0vsI())) {
            this.view.performHapticFeedback(9);
        }
    }
}
