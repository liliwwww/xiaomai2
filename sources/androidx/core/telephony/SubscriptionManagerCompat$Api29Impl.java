package androidx.core.telephony;

import android.telephony.SubscriptionManager;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
@RequiresApi(29)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class SubscriptionManagerCompat$Api29Impl {
    private SubscriptionManagerCompat$Api29Impl() {
    }

    @DoNotInline
    static int getSlotIndex(int i) {
        return SubscriptionManager.getSlotIndex(i);
    }
}
