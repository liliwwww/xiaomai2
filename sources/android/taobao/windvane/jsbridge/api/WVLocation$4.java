package android.taobao.windvane.jsbridge.api;

import android.location.Address;
import android.location.Location;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;
import android.taobao.windvane.util.TaoLog;
import android.text.TextUtils;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class WVLocation$4 implements Runnable {
    final /* synthetic */ WVLocation this$0;
    final /* synthetic */ Location val$location;

    WVLocation$4(WVLocation wVLocation, Location location) {
        this.this$0 = wVLocation;
        this.val$location = location;
    }

    @Override // java.lang.Runnable
    public void run() {
        WVResult wVResult = new WVResult();
        JSONObject jSONObject = new JSONObject();
        double longitude = com.alibaba.wireless.security.aopsdk.replace.android.location.Location.getLongitude(this.val$location);
        double latitude = com.alibaba.wireless.security.aopsdk.replace.android.location.Location.getLatitude(this.val$location);
        try {
            jSONObject.put("longitude", longitude);
            jSONObject.put("latitude", latitude);
            jSONObject.put("altitude", com.alibaba.wireless.security.aopsdk.replace.android.location.Location.getAltitude(this.val$location));
            jSONObject.put("accuracy", this.val$location.getAccuracy());
            jSONObject.put("heading", this.val$location.getBearing());
            jSONObject.put("speed", this.val$location.getSpeed());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        wVResult.addData("coords", jSONObject);
        if (TaoLog.getLogStatus()) {
            TaoLog.d("WVLocation", " getLocation success. latitude: " + latitude + "; longitude: " + longitude);
        }
        if (WVLocation.access$100(this.this$0)) {
            Address access$200 = WVLocation.access$200(this.this$0, latitude, longitude);
            JSONObject jSONObject2 = new JSONObject();
            if (access$200 != null) {
                try {
                    jSONObject2.put("country", access$200.getCountryName());
                    jSONObject2.put("province", access$200.getAdminArea());
                    jSONObject2.put("city", access$200.getLocality());
                    jSONObject2.put("cityCode", access$200.getPostalCode());
                    jSONObject2.put("area", access$200.getSubLocality());
                    jSONObject2.put("road", access$200.getThoroughfare());
                    StringBuilder sb = new StringBuilder();
                    for (int i = 1; i <= 2; i++) {
                        if (!TextUtils.isEmpty(access$200.getAddressLine(i))) {
                            sb.append(access$200.getAddressLine(i));
                        }
                    }
                    jSONObject2.put("addressLine", sb.toString());
                    if (TaoLog.getLogStatus()) {
                        TaoLog.d("WVLocation", " getAddress success. " + access$200.getAddressLine(0));
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            } else if (TaoLog.getLogStatus()) {
                TaoLog.w("WVLocation", " getAddress fail. ");
            }
            wVResult.addData("address", jSONObject2);
        }
        try {
            Iterator it = WVLocation.access$300(this.this$0).iterator();
            while (it.hasNext()) {
                ((WVCallBackContext) it.next()).success(wVResult);
            }
            WVLocation.access$300(this.this$0).clear();
            if (TaoLog.getLogStatus()) {
                TaoLog.d("WVLocation", "callback success. retString: " + wVResult.toJsonString());
            }
        } catch (Throwable unused) {
        }
    }
}
