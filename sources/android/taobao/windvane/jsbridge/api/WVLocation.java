package android.taobao.windvane.jsbridge.api;

import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;
import android.taobao.windvane.runtimepermission.PermissionProposer;
import android.taobao.windvane.thread.WVThreadPool;
import android.taobao.windvane.util.TaoLog;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class WVLocation extends WVApiPlugin implements LocationListener, Handler.Callback {
    private static final int GPS_TIMEOUT = 15000;
    private static final String TAG = "WVLocation";
    private Handler mHandler;
    private int MIN_TIME = 20000;
    private int MIN_DISTANCE = 30;
    private ArrayList<WVCallBackContext> mCallbacks = new ArrayList<>();
    private boolean getLocationSuccess = false;
    private boolean enableAddress = false;
    private LocationManager locationManager = null;

    public WVLocation() {
        this.mHandler = null;
        this.mHandler = new Handler(Looper.getMainLooper(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Address getAddress(double d, double d2) {
        try {
            List<Address> fromLocation = new Geocoder(((WVApiPlugin) this).mContext).getFromLocation(d, d2, 1);
            if (fromLocation == null || fromLocation.size() <= 0) {
                return null;
            }
            return fromLocation.get(0);
        } catch (Exception e) {
            TaoLog.e("WVLocation", "getAddress: getFromLocation error. " + e.getMessage());
            return null;
        }
    }

    private void registerLocation(boolean z) {
        if (this.locationManager == null) {
            this.locationManager = (LocationManager) ((WVApiPlugin) this).mContext.getSystemService("location");
        }
        try {
            this.getLocationSuccess = false;
            com.alibaba.wireless.security.aopsdk.replace.android.location.LocationManager.requestLocationUpdates(this.locationManager, "network", this.MIN_TIME, this.MIN_DISTANCE, this);
            com.alibaba.wireless.security.aopsdk.replace.android.location.LocationManager.requestLocationUpdates(this.locationManager, "gps", this.MIN_TIME, this.MIN_DISTANCE, this);
            if (TaoLog.getLogStatus()) {
                TaoLog.d("WVLocation", " registerLocation start provider GPS and NETWORK");
            }
        } catch (Exception e) {
            TaoLog.e("WVLocation", "registerLocation error: " + e.getMessage());
        }
    }

    private void wrapResult(Location location) {
        ArrayList<WVCallBackContext> arrayList = this.mCallbacks;
        if (arrayList == null || arrayList.isEmpty()) {
            TaoLog.d("WVLocation", "GetLocation wrapResult callbackContext is null");
            return;
        }
        if (location != null) {
            AsyncTask.execute((Runnable) new 4(this, location));
            return;
        }
        TaoLog.w("WVLocation", "getLocation: location is null");
        Iterator<WVCallBackContext> it = this.mCallbacks.iterator();
        while (it.hasNext()) {
            it.next().error(new WVResult());
        }
        this.mCallbacks.clear();
    }

    public boolean execute(String str, String str2, WVCallBackContext wVCallBackContext) {
        if (!"getLocation".equals(str)) {
            return false;
        }
        getLocation(wVCallBackContext, str2);
        return true;
    }

    public synchronized void getLocation(WVCallBackContext wVCallBackContext, String str) {
        try {
            PermissionProposer.buildPermissionTask(((WVApiPlugin) this).mContext, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}).setTaskOnPermissionGranted(new 2(this, wVCallBackContext, str)).setTaskOnPermissionDenied(new 1(this, wVCallBackContext)).execute();
        } catch (Exception unused) {
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 1) {
            return false;
        }
        LocationManager locationManager = this.locationManager;
        if (locationManager != null) {
            try {
                locationManager.removeUpdates(this);
                ArrayList<WVCallBackContext> arrayList = this.mCallbacks;
                if (arrayList != null && !arrayList.isEmpty()) {
                    if (!this.getLocationSuccess) {
                        Iterator<WVCallBackContext> it = this.mCallbacks.iterator();
                        while (it.hasNext()) {
                            it.next().error(new WVResult());
                        }
                        this.mCallbacks.clear();
                    }
                }
                TaoLog.d("WVLocation", "GetLocation wrapResult callbackContext is null");
                return false;
            } catch (Exception e) {
                TaoLog.e("WVLocation", "GetLocation timeout" + e.getMessage());
                Iterator<WVCallBackContext> it2 = this.mCallbacks.iterator();
                while (it2.hasNext()) {
                    it2.next().error(new WVResult());
                }
                this.mCallbacks.clear();
            }
        }
        return true;
    }

    public void onDestroy() {
        LocationManager locationManager = this.locationManager;
        if (locationManager != null) {
            if (!this.getLocationSuccess) {
                try {
                    locationManager.removeUpdates(this);
                } catch (Exception unused) {
                }
            }
            this.locationManager = null;
        }
        ArrayList<WVCallBackContext> arrayList = this.mCallbacks;
        if (arrayList != null) {
            arrayList.clear();
        }
    }

    @Override // android.location.LocationListener
    public void onLocationChanged(Location location) {
        if (TaoLog.getLogStatus()) {
            TaoLog.d("WVLocation", " onLocationChanged. ");
        }
        if (this.locationManager == null) {
            return;
        }
        wrapResult(location);
        this.locationManager.removeUpdates(this);
        this.getLocationSuccess = true;
    }

    @Override // android.location.LocationListener
    public void onProviderDisabled(String str) {
        if (TaoLog.getLogStatus()) {
            TaoLog.d("WVLocation", " onProviderDisabled. provider: " + str);
        }
    }

    @Override // android.location.LocationListener
    public void onProviderEnabled(String str) {
        if (TaoLog.getLogStatus()) {
            TaoLog.d("WVLocation", " onProviderEnabled. provider: " + str);
        }
    }

    @Override // android.location.LocationListener
    public void onStatusChanged(String str, int i, Bundle bundle) {
        if (TaoLog.getLogStatus()) {
            TaoLog.d("WVLocation", " onStatusChanged. provider: " + str + ";status: " + i);
        }
    }

    public void requestLocation(WVCallBackContext wVCallBackContext, String str) {
        boolean optBoolean;
        if (TextUtils.isEmpty(str)) {
            optBoolean = false;
        } else {
            try {
                JSONObject jSONObject = new JSONObject(str);
                optBoolean = jSONObject.optBoolean("enableHighAcuracy");
                this.enableAddress = jSONObject.optBoolean("address");
            } catch (JSONException unused) {
                TaoLog.e("WVLocation", "getLocation: param parse to JSON error, param=" + str);
                WVResult wVResult = new WVResult();
                wVResult.setResult(WVResult.PARAM_ERR);
                wVCallBackContext.error(wVResult);
                return;
            }
        }
        if (this.mCallbacks == null) {
            this.mCallbacks = new ArrayList<>();
        }
        this.mCallbacks.add(wVCallBackContext);
        registerLocation(optBoolean);
        WVThreadPool.getInstance().execute(new 3(this));
    }
}
