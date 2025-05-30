package androidx.appcompat.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.os.PowerManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDelegateImpl;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class AppCompatDelegateImpl$AutoBatteryNightModeManager extends AppCompatDelegateImpl$AutoNightModeManager {
    private final PowerManager mPowerManager;
    final /* synthetic */ AppCompatDelegateImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AppCompatDelegateImpl$AutoBatteryNightModeManager(@NonNull final AppCompatDelegateImpl appCompatDelegateImpl, Context context) {
        new Object() { // from class: androidx.appcompat.app.AppCompatDelegateImpl$AutoNightModeManager
            private BroadcastReceiver mReceiver;

            void cleanup() {
                BroadcastReceiver broadcastReceiver = this.mReceiver;
                if (broadcastReceiver != null) {
                    try {
                        appCompatDelegateImpl.mContext.unregisterReceiver(broadcastReceiver);
                    } catch (IllegalArgumentException unused) {
                    }
                    this.mReceiver = null;
                }
            }

            @Nullable
            abstract IntentFilter createIntentFilterForBroadcastReceiver();

            abstract int getApplyableNightMode();

            boolean isListening() {
                return this.mReceiver != null;
            }

            abstract void onChange();

            void setup() {
                cleanup();
                IntentFilter createIntentFilterForBroadcastReceiver = createIntentFilterForBroadcastReceiver();
                if (createIntentFilterForBroadcastReceiver == null || createIntentFilterForBroadcastReceiver.countActions() == 0) {
                    return;
                }
                if (this.mReceiver == null) {
                    this.mReceiver = new 1(this);
                }
                appCompatDelegateImpl.mContext.registerReceiver(this.mReceiver, createIntentFilterForBroadcastReceiver);
            }
        };
        this.this$0 = appCompatDelegateImpl;
        this.mPowerManager = (PowerManager) context.getApplicationContext().getSystemService("power");
    }

    @Override // androidx.appcompat.app.AppCompatDelegateImpl$AutoNightModeManager
    IntentFilter createIntentFilterForBroadcastReceiver() {
        if (Build.VERSION.SDK_INT < 21) {
            return null;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
        return intentFilter;
    }

    @Override // androidx.appcompat.app.AppCompatDelegateImpl$AutoNightModeManager
    public int getApplyableNightMode() {
        return (Build.VERSION.SDK_INT < 21 || !AppCompatDelegateImpl.Api21Impl.isPowerSaveMode(this.mPowerManager)) ? 1 : 2;
    }

    @Override // androidx.appcompat.app.AppCompatDelegateImpl$AutoNightModeManager
    public void onChange() {
        this.this$0.applyDayNight();
    }
}
