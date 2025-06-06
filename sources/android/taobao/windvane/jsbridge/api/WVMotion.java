package android.taobao.windvane.jsbridge.api;

import android.annotation.TargetApi;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Vibrator;
import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;
import android.taobao.windvane.jsbridge.api.ShakeListener;
import android.taobao.windvane.runtimepermission.PermissionProposer;
import android.taobao.windvane.util.TaoLog;
import android.text.TextUtils;
import java.net.URLDecoder;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class WVMotion extends WVApiPlugin implements Handler.Callback {
    private static final int SHAKE_STOP = 1;
    private static final String TAG = "WVMotion";
    private BlowSensor blowSensor;
    private Vibrator vibrator;
    private ShakeListener mShakeListener = null;
    private SensorManager sm = null;
    private long currentTime = 0;
    private long currentTime2 = 0;
    private long frequency = 0;
    private long frequency2 = 0;
    private WVCallBackContext mCallback = null;
    protected SensorEventListener mSensorListener = new 3(this);
    protected SensorEventListener mSensorListener2 = new 4(this);
    private Handler handler = new Handler(Looper.getMainLooper(), this);

    /* compiled from: Taobao */
    protected class MyShakeListener implements ShakeListener.OnShakeListener {
        private long frequency;
        private long mLastUpdateTime = 0;
        private WVCallBackContext wvCallback;

        public MyShakeListener(WVCallBackContext wVCallBackContext, long j) {
            this.wvCallback = null;
            this.frequency = 0L;
            this.wvCallback = wVCallBackContext;
            this.frequency = j;
        }

        @Override // android.taobao.windvane.jsbridge.api.ShakeListener.OnShakeListener
        public void onShake() {
            if (((WVApiPlugin) WVMotion.this).isAlive) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.mLastUpdateTime < this.frequency) {
                    return;
                }
                WVResult wVResult = new WVResult();
                wVResult.setSuccess();
                WVCallBackContext wVCallBackContext = this.wvCallback;
                if (wVCallBackContext != null) {
                    wVCallBackContext.fireEvent("motion.shake", wVResult.toJsonString());
                }
                this.mLastUpdateTime = currentTimeMillis;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopListenGyro() {
        SensorManager sensorManager = this.sm;
        if (sensorManager != null) {
            SensorEventListener sensorEventListener = this.mSensorListener;
            if (sensorEventListener != null) {
                sensorManager.unregisterListener(sensorEventListener);
            }
            this.sm = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopListenRota() {
        SensorManager sensorManager = this.sm;
        if (sensorManager != null) {
            SensorEventListener sensorEventListener = this.mSensorListener2;
            if (sensorEventListener != null) {
                sensorManager.unregisterListener(sensorEventListener);
            }
            this.sm = null;
        }
    }

    private void stopShake() {
        ShakeListener shakeListener = this.mShakeListener;
        if (shakeListener != null) {
            shakeListener.stop();
            this.mShakeListener = null;
        }
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(String str, String str2, WVCallBackContext wVCallBackContext) {
        if ("listeningShake".equals(str)) {
            listeningShake(wVCallBackContext, str2);
            return true;
        }
        if ("vibrate".equals(str)) {
            vibrate(wVCallBackContext, str2);
            return true;
        }
        if ("listenBlow".equals(str)) {
            try {
                PermissionProposer.buildPermissionTask(this.mContext, new String[]{"android.permission.RECORD_AUDIO"}).setTaskOnPermissionGranted(new 2(this, wVCallBackContext, str2)).setTaskOnPermissionDenied(new 1(this, wVCallBackContext)).execute();
                return true;
            } catch (Exception unused) {
                return true;
            }
        }
        if ("stopListenBlow".equals(str)) {
            stopListenBlow(wVCallBackContext, str2);
            return true;
        }
        if ("listenGyro".equals(str)) {
            listenGyro(wVCallBackContext, str2);
            return true;
        }
        if (!"listenRotationRate".equals(str)) {
            return false;
        }
        listenRotationRate(wVCallBackContext, str2);
        return true;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 1) {
            stopShake();
            Object obj = message.obj;
            if (obj instanceof WVCallBackContext) {
                ((WVCallBackContext) obj).success(new WVResult());
            }
            return true;
        }
        if (i != 4101) {
            if (i != 4102) {
                return false;
            }
            WVCallBackContext wVCallBackContext = this.mCallback;
            if (wVCallBackContext != null) {
                wVCallBackContext.error(new WVResult());
            }
            return true;
        }
        if (!this.isAlive) {
            return true;
        }
        WVResult wVResult = new WVResult();
        wVResult.setSuccess();
        wVResult.addData("pass", "1");
        WVCallBackContext wVCallBackContext2 = this.mCallback;
        if (wVCallBackContext2 != null) {
            wVCallBackContext2.fireEvent("motion.blow", wVResult.toJsonString());
        }
        return true;
    }

    public synchronized void listenBlow(WVCallBackContext wVCallBackContext, String str) {
        if (TaoLog.getLogStatus()) {
            TaoLog.d(TAG, "listenBlow: start. " + str);
        }
        this.mCallback = wVCallBackContext;
        BlowSensor blowSensor = this.blowSensor;
        if (blowSensor != null) {
            blowSensor.stop();
        }
        BlowSensor blowSensor2 = new BlowSensor(this.handler);
        this.blowSensor = blowSensor2;
        blowSensor2.start();
        wVCallBackContext.success(new WVResult());
    }

    public synchronized void listenGyro(WVCallBackContext wVCallBackContext, String str) {
        if (TaoLog.getLogStatus()) {
            TaoLog.d(TAG, "listenGyro:  " + str);
        }
        WVResult wVResult = new WVResult();
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.frequency = jSONObject.optInt("frequency", 100);
            boolean optBoolean = jSONObject.optBoolean("on");
            this.mCallback = wVCallBackContext;
            if (this.sm == null) {
                this.sm = (SensorManager) this.mContext.getSystemService("sensor");
            }
            if (optBoolean) {
                SensorManager sensorManager = this.sm;
                sensorManager.registerListener(this.mSensorListener, com.alibaba.wireless.security.aopsdk.replace.android.hardware.SensorManager.getDefaultSensor(sensorManager, 9), 3);
                this.currentTime = System.currentTimeMillis();
            } else {
                stopListenGyro();
            }
            wVCallBackContext.success(new WVResult());
        } catch (JSONException unused) {
            TaoLog.e(TAG, "vibrate: param parse to JSON error, param=" + str);
            wVResult.setResult("HY_PARAM_ERR");
            wVCallBackContext.error(wVResult);
        }
    }

    public synchronized void listenRotationRate(WVCallBackContext wVCallBackContext, String str) {
        if (TaoLog.getLogStatus()) {
            TaoLog.d(TAG, "listenRotationRate:  " + str);
        }
        WVResult wVResult = new WVResult();
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.frequency2 = jSONObject.optInt("frequency", 100);
            boolean optBoolean = jSONObject.optBoolean("on");
            this.mCallback = wVCallBackContext;
            if (this.sm == null) {
                this.sm = (SensorManager) this.mContext.getSystemService("sensor");
            }
            if (optBoolean) {
                SensorManager sensorManager = this.sm;
                sensorManager.registerListener(this.mSensorListener2, com.alibaba.wireless.security.aopsdk.replace.android.hardware.SensorManager.getDefaultSensor(sensorManager, 4), 3);
                this.currentTime = System.currentTimeMillis();
            } else {
                stopListenRota();
            }
            wVCallBackContext.success(new WVResult());
        } catch (JSONException unused) {
            TaoLog.e(TAG, "vibrate: param parse to JSON error, param=" + str);
            wVResult.setResult("HY_PARAM_ERR");
            wVCallBackContext.error(wVResult);
        }
    }

    public synchronized void listeningShake(WVCallBackContext wVCallBackContext, String str) {
        boolean z;
        WVResult wVResult = new WVResult();
        long j = 500;
        boolean z2 = false;
        if (TextUtils.isEmpty(str)) {
            z = false;
        } else {
            try {
                str = URLDecoder.decode(str, "utf-8");
            } catch (Exception unused) {
                TaoLog.e(TAG, "listeningShake: param decode error, param=" + str);
                z2 = true;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                z = jSONObject.getBoolean("on");
                j = jSONObject.optLong("frequency");
            } catch (JSONException unused2) {
                TaoLog.e(TAG, "listeningShake: param parse to JSON error, param=" + str);
                wVResult.setResult("HY_PARAM_ERR");
                wVCallBackContext.error(wVResult);
                return;
            }
        }
        if (z2) {
            if (TaoLog.getLogStatus()) {
                TaoLog.w(TAG, "listeningShake: isFail");
            }
            wVCallBackContext.error(wVResult);
            return;
        }
        if (z) {
            TaoLog.d(TAG, "listeningShake: start ...");
            if (this.mShakeListener == null) {
                this.mShakeListener = new ShakeListener(this.mContext, j);
            }
            this.mShakeListener.setOnShakeListener(new MyShakeListener(wVCallBackContext, j));
            wVCallBackContext.success(wVResult);
        } else {
            TaoLog.d(TAG, "listeningShake: stop.");
            Message message = new Message();
            message.what = 1;
            message.obj = wVCallBackContext;
            Handler handler = this.handler;
            if (handler != null) {
                handler.sendMessage(message);
            }
        }
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public void onDestroy() {
        stopShake();
        stopListenGyro();
        stopListenRota();
        Vibrator vibrator = this.vibrator;
        if (vibrator != null) {
            vibrator.cancel();
            this.vibrator = null;
        }
        this.mCallback = null;
        BlowSensor blowSensor = this.blowSensor;
        if (blowSensor != null) {
            blowSensor.stop();
        }
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public void onPause() {
        SensorEventListener sensorEventListener;
        SensorManager sensorManager = this.sm;
        if (sensorManager != null && (sensorEventListener = this.mSensorListener) != null) {
            sensorManager.unregisterListener(sensorEventListener);
        }
        ShakeListener shakeListener = this.mShakeListener;
        if (shakeListener != null) {
            shakeListener.pause();
        }
        BlowSensor blowSensor = this.blowSensor;
        if (blowSensor != null) {
            blowSensor.stop();
        }
        super.onPause();
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    @TargetApi(9)
    public void onResume() {
        SensorEventListener sensorEventListener;
        SensorManager sensorManager = this.sm;
        if (sensorManager != null && (sensorEventListener = this.mSensorListener) != null) {
            sensorManager.registerListener(sensorEventListener, com.alibaba.wireless.security.aopsdk.replace.android.hardware.SensorManager.getDefaultSensor(sensorManager, 9), 3);
        }
        ShakeListener shakeListener = this.mShakeListener;
        if (shakeListener != null) {
            shakeListener.resume();
        }
        BlowSensor blowSensor = this.blowSensor;
        if (blowSensor != null) {
            blowSensor.start();
        }
        super.onResume();
    }

    public synchronized void stopListenBlow(WVCallBackContext wVCallBackContext, String str) {
        if (TaoLog.getLogStatus()) {
            TaoLog.d(TAG, "stopListenBlow: stopped. " + str);
        }
        BlowSensor blowSensor = this.blowSensor;
        if (blowSensor != null) {
            blowSensor.stop();
            this.blowSensor = null;
        }
        wVCallBackContext.success(new WVResult());
    }

    public synchronized void vibrate(WVCallBackContext wVCallBackContext, String str) {
        WVResult wVResult = new WVResult();
        try {
            int optInt = new JSONObject(str).optInt("duration", 350);
            int i = optInt >= 0 ? optInt : 350;
            if (this.vibrator == null) {
                this.vibrator = (Vibrator) this.mContext.getSystemService("vibrator");
            }
            this.vibrator.vibrate(i);
            TaoLog.d(TAG, "vibrate: start ...");
            wVCallBackContext.success(new WVResult());
        } catch (JSONException unused) {
            TaoLog.e(TAG, "vibrate: param parse to JSON error, param=" + str);
            wVResult.setResult("HY_PARAM_ERR");
            wVCallBackContext.error(wVResult);
        }
    }
}
