package androidx.core.view.accessibility;

import android.graphics.Region;
import android.view.accessibility.AccessibilityWindowInfo;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
@RequiresApi(33)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class AccessibilityWindowInfoCompat$Api33Impl {
    private AccessibilityWindowInfoCompat$Api33Impl() {
    }

    @DoNotInline
    static int getDisplayId(AccessibilityWindowInfo accessibilityWindowInfo) {
        return accessibilityWindowInfo.getDisplayId();
    }

    @DoNotInline
    static void getRegionInScreen(AccessibilityWindowInfo accessibilityWindowInfo, Region region) {
        accessibilityWindowInfo.getRegionInScreen(region);
    }

    @DoNotInline
    static boolean isInPictureInPictureMode(AccessibilityWindowInfo accessibilityWindowInfo) {
        return accessibilityWindowInfo.isInPictureInPictureMode();
    }
}
