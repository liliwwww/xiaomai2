package android.taobao.windvane.jsbridge.api;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class WVMotion$3 implements SensorEventListener {
    final /* synthetic */ WVMotion this$0;

    WVMotion$3(WVMotion wVMotion) {
        this.this$0 = wVMotion;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (9 == sensorEvent.sensor.getType() && WVMotion.access$100(this.this$0) <= System.currentTimeMillis() - WVMotion.access$200(this.this$0)) {
            float[] fArr = sensorEvent.values;
            String str = "{\"x\":\"" + ((-fArr[0]) / 10.0f) + "\",\"y\":\"" + ((-fArr[1]) / 10.0f) + "\",\"z\":\"" + ((-fArr[2]) / 10.0f) + "\"}";
            if (WVMotion.access$300(this.this$0) != null) {
                WVMotion.access$300(this.this$0).fireEvent("motion.gyro", str);
            } else {
                WVMotion.access$400(this.this$0);
            }
            WVMotion.access$202(this.this$0, System.currentTimeMillis());
        }
    }
}
