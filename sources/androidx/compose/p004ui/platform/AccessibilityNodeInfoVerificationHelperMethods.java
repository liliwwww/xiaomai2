package androidx.compose.p004ui.platform;

import android.taobao.windvane.connect.api.ApiConstants;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@RequiresApi(26)
/* loaded from: classes.dex */
public final class AccessibilityNodeInfoVerificationHelperMethods {

    @NotNull
    public static final AccessibilityNodeInfoVerificationHelperMethods INSTANCE = new AccessibilityNodeInfoVerificationHelperMethods();

    private AccessibilityNodeInfoVerificationHelperMethods() {
    }

    @DoNotInline
    @RequiresApi(26)
    public final void setAvailableExtraData(@NotNull AccessibilityNodeInfo accessibilityNodeInfo, @NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(accessibilityNodeInfo, "node");
        Intrinsics.checkNotNullParameter(list, ApiConstants.DATA);
        accessibilityNodeInfo.setAvailableExtraData(list);
    }
}
