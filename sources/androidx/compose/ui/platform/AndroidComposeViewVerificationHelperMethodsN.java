package androidx.compose.ui.platform;

import android.taobao.windvane.urlintercept.WVURLRuleConstants;
import android.view.View;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.compose.ui.input.pointer.AndroidPointerIcon;
import androidx.compose.ui.input.pointer.AndroidPointerIconType;
import androidx.compose.ui.input.pointer.PointerIcon;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@RequiresApi(24)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class AndroidComposeViewVerificationHelperMethodsN {

    @NotNull
    public static final AndroidComposeViewVerificationHelperMethodsN INSTANCE = new AndroidComposeViewVerificationHelperMethodsN();

    private AndroidComposeViewVerificationHelperMethodsN() {
    }

    @DoNotInline
    @RequiresApi(24)
    public final void setPointerIcon(@NotNull View view, @Nullable PointerIcon pointerIcon) {
        android.view.PointerIcon systemIcon;
        Intrinsics.checkNotNullParameter(view, "view");
        if (pointerIcon instanceof AndroidPointerIcon) {
            systemIcon = ((AndroidPointerIcon) pointerIcon).getPointerIcon();
        } else if (pointerIcon instanceof AndroidPointerIconType) {
            systemIcon = android.view.PointerIcon.getSystemIcon(view.getContext(), ((AndroidPointerIconType) pointerIcon).getType());
            Intrinsics.checkNotNullExpressionValue(systemIcon, "getSystemIcon(view.context, icon.type)");
        } else {
            systemIcon = android.view.PointerIcon.getSystemIcon(view.getContext(), WVURLRuleConstants.LOGIN);
            Intrinsics.checkNotNullExpressionValue(systemIcon, "getSystemIcon(\n         …DEFAULT\n                )");
        }
        if (Intrinsics.areEqual(view.getPointerIcon(), systemIcon)) {
            return;
        }
        view.setPointerIcon(systemIcon);
    }
}
