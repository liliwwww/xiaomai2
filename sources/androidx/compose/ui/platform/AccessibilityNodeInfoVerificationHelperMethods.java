package androidx.compose.ui.platform;

import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@RequiresApi(26)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class AccessibilityNodeInfoVerificationHelperMethods {

    @NotNull
    public static final AccessibilityNodeInfoVerificationHelperMethods INSTANCE = new AccessibilityNodeInfoVerificationHelperMethods();

    private AccessibilityNodeInfoVerificationHelperMethods() {
    }

    @DoNotInline
    @RequiresApi(26)
    public final void setAvailableExtraData(@NotNull AccessibilityNodeInfo accessibilityNodeInfo, @NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(accessibilityNodeInfo, "node");
        Intrinsics.checkNotNullParameter(list, "data");
        accessibilityNodeInfo.setAvailableExtraData(list);
    }
}
