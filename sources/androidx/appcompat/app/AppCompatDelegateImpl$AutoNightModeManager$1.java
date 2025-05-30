package androidx.appcompat.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.AppCompatDelegateImpl;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class AppCompatDelegateImpl$AutoNightModeManager$1 extends BroadcastReceiver {
    final /* synthetic */ AppCompatDelegateImpl.AutoNightModeManager this$1;

    AppCompatDelegateImpl$AutoNightModeManager$1(AppCompatDelegateImpl.AutoNightModeManager autoNightModeManager) {
        this.this$1 = autoNightModeManager;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.this$1.onChange();
    }
}
