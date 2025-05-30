package android.taobao.windvane.jsbridge.api;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class WVMotion$4 implements SensorEventListener {
    final /* synthetic */ WVMotion this$0;

    WVMotion$4(WVMotion wVMotion) {
        this.this$0 = wVMotion;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (4 == sensorEvent.sensor.getType() && WVMotion.access$500(this.this$0) <= System.currentTimeMillis() - WVMotion.access$600(this.this$0)) {
            float[] fArr = sensorEvent.values;
            String str = "{\"alpha\":\"" + fArr[0] + "\",\"beta\":\"" + fArr[1] + "\",\"gama\":\"" + fArr[2] + "\"}";
            if (WVMotion.access$300(this.this$0) != null) {
                WVMotion.access$300(this.this$0).fireEvent("WV.Event.Motion.RotationRate", str);
            } else {
                WVMotion.access$700(this.this$0);
            }
            WVMotion.access$602(this.this$0, System.currentTimeMillis());
        }
    }
}
