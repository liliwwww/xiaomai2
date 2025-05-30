package android.taobao.windvane.jsbridge.api;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import android.taobao.windvane.connect.api.ApiConstants;
import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;
import android.taobao.windvane.runtimepermission.PermissionProposer;
import android.taobao.windvane.util.TaoLog;
import android.taobao.windvane.webview.IWVWebView;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.app.NotificationCompat;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class WVBluetooth extends WVApiPlugin {
    private static final String TAG = "WVBluetooth";
    private BluetoothAdapter mBTAdapter = null;
    private BluetoothGatt mBluetoothGatt = null;
    private WVCallBackContext mConnectCallback = null;
    private WVCallBackContext mReadValueCallback = null;
    private WVCallBackContext mWriteValueCallback = null;
    private BluetoothAdapter.LeScanCallback mLeScanCallback = null;
    private Set<String> mKnownDevices = new HashSet();
    private WVCallBackContext mGetServiceCallback = null;
    private int mCurrentConnectionState = -1;
    private final BluetoothGattCallback mGattCallback = new BluetoothGattCallback() { // from class: android.taobao.windvane.jsbridge.api.WVBluetooth.4
        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            TaoLog.m24i("WVBluetooth", "onCharacteristicChanged : " + bluetoothGattCharacteristic.getUuid());
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(ApiConstants.DEVICEID, WVBluetooth.this.mBluetoothGatt.getDevice().getAddress());
                jSONObject.put("serviceId", bluetoothGattCharacteristic.getService().getUuid().toString());
                jSONObject.put("characteristicId", bluetoothGattCharacteristic.getUuid().toString());
                jSONObject.put("value", Base64.encodeToString(bluetoothGattCharacteristic.getValue(), 2));
                ((WVApiPlugin) WVBluetooth.this).mWebView.fireEvent("WV.Event.WVBluetooth.characteristicValueChanged", jSONObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            TaoLog.m24i("WVBluetooth", "onCharacteristicRead : " + i);
            if (WVBluetooth.this.mReadValueCallback != null) {
                WVResult wVResult = new WVResult();
                if (i == 0) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("value", Base64.encodeToString(bluetoothGattCharacteristic.getValue(), 2));
                        wVResult.addData("value", jSONObject);
                        WVBluetooth.this.mReadValueCallback.success(wVResult);
                    } catch (Throwable th) {
                        th.printStackTrace();
                        WVBluetooth.this.mReadValueCallback.error();
                    }
                } else {
                    wVResult.addData(NotificationCompat.CATEGORY_MESSAGE, "FAILED_TO_READ: " + i);
                    WVBluetooth.this.mReadValueCallback.error(wVResult);
                }
                WVBluetooth.this.mReadValueCallback = null;
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            TaoLog.m24i("WVBluetooth", "onCharacteristicWrite : " + i);
            if (WVBluetooth.this.mWriteValueCallback != null) {
                WVResult wVResult = new WVResult();
                if (i == 0) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("value", Base64.encodeToString(bluetoothGattCharacteristic.getValue(), 2));
                        wVResult.addData("value", jSONObject);
                        WVBluetooth.this.mWriteValueCallback.success(wVResult);
                    } catch (Throwable th) {
                        th.printStackTrace();
                        WVBluetooth.this.mWriteValueCallback.error(th.getMessage());
                    }
                } else {
                    wVResult.addData(NotificationCompat.CATEGORY_MESSAGE, "FAILED_TO_WRITE: " + i);
                    WVBluetooth.this.mWriteValueCallback.error(wVResult);
                }
            }
            WVBluetooth.this.mWriteValueCallback = null;
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
            WVBluetooth.this.mCurrentConnectionState = i2;
            TaoLog.m24i("WVBluetooth", "onConnectionStateChange: " + i + "," + i2);
            if (WVBluetooth.this.mConnectCallback != null) {
                if (i2 == 2) {
                    WVBluetooth.this.mConnectCallback.success();
                } else {
                    WVBluetooth.this.mConnectCallback.error();
                }
                WVBluetooth.this.mConnectCallback = null;
            }
            if (WVBluetooth.this.mBluetoothGatt == null || i2 != 0) {
                return;
            }
            try {
                new JSONObject().put(ApiConstants.DEVICEID, WVBluetooth.this.mBluetoothGatt.getDevice().getAddress());
                ((WVApiPlugin) WVBluetooth.this).mWebView.fireEvent("WV.Event.WVBluetooth.GATTServerDisconnected", "");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
            TaoLog.m24i("WVBluetooth", "onDescriptorWrite : " + bluetoothGattDescriptor.getCharacteristic().getUuid());
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onReadRemoteRssi(BluetoothGatt bluetoothGatt, int i, int i2) {
            TaoLog.m24i("WVBluetooth", "onReadRemoteRssi : " + i);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
            TaoLog.m24i("WVBluetooth", "onServicesDiscovered : " + i);
            if (WVBluetooth.this.mGetServiceCallback != null) {
                Iterator<BluetoothGattService> it = bluetoothGatt.getServices().iterator();
                JSONArray jSONArray = new JSONArray();
                while (it.hasNext()) {
                    try {
                        jSONArray.put(new JSONObject().put("serviceId", it.next().getUuid()));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                WVResult wVResult = new WVResult();
                wVResult.addData("services", jSONArray);
                WVBluetooth.this.mGetServiceCallback.success(wVResult);
                WVBluetooth.this.mGetServiceCallback = null;
            }
        }
    };

    public boolean connect(String str) {
        BluetoothAdapter bluetoothAdapter = this.mBTAdapter;
        if (bluetoothAdapter == null || str == null) {
            TaoLog.m30w("WVBluetooth", "BluetoothAdapter not initialized or unspecified address.");
            return false;
        }
        BluetoothDevice remoteDevice = bluetoothAdapter.getRemoteDevice(str);
        if (remoteDevice == null) {
            TaoLog.m30w("WVBluetooth", "Device not found.  Unable to connect.");
            return false;
        }
        this.mBluetoothGatt = remoteDevice.connectGatt(this.mContext, false, this.mGattCallback);
        TaoLog.m18d("WVBluetooth", "Trying to create a new connection.");
        return true;
    }

    public void connectDevice(String str, WVCallBackContext wVCallBackContext) {
        WVResult wVResult = new WVResult();
        BluetoothAdapter bluetoothAdapter = this.mBTAdapter;
        if (bluetoothAdapter == null) {
            wVResult.addData(NotificationCompat.CATEGORY_MESSAGE, "DEVICE_NOT_SUPPORT");
            wVCallBackContext.error(wVResult);
            return;
        }
        if (!bluetoothAdapter.isEnabled()) {
            wVResult.addData(NotificationCompat.CATEGORY_MESSAGE, "BLUETOOTH_DISABLED");
            wVCallBackContext.error(wVResult);
            return;
        }
        try {
            String optString = new JSONObject(str).optString(ApiConstants.DEVICEID, "");
            if (!TextUtils.isEmpty(optString)) {
                connect(optString);
                this.mConnectCallback = wVCallBackContext;
                return;
            }
        } catch (Throwable th) {
            th.printStackTrace();
            wVCallBackContext.error();
        }
        wVResult.addData(NotificationCompat.CATEGORY_MESSAGE, "FAILED_TO_CONNECT");
        wVCallBackContext.error(wVResult);
    }

    public void disconnect(String str, WVCallBackContext wVCallBackContext) {
        WVResult wVResult = new WVResult();
        BluetoothAdapter bluetoothAdapter = this.mBTAdapter;
        if (bluetoothAdapter == null) {
            wVResult.addData(NotificationCompat.CATEGORY_MESSAGE, "DEVICE_NOT_SUPPORT");
            wVCallBackContext.error(wVResult);
            return;
        }
        if (!bluetoothAdapter.isEnabled()) {
            wVResult.addData(NotificationCompat.CATEGORY_MESSAGE, "BLUETOOTH_DISABLED");
            wVCallBackContext.error(wVResult);
            return;
        }
        try {
            this.mBluetoothGatt.disconnect();
            this.mBluetoothGatt = null;
            wVCallBackContext.success();
        } catch (Throwable th) {
            th.printStackTrace();
            wVCallBackContext.error();
            wVResult.addData(NotificationCompat.CATEGORY_MESSAGE, "FAILED_TO_CONNECT");
            wVCallBackContext.error(wVResult);
        }
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(String str, String str2, WVCallBackContext wVCallBackContext) {
        if ("requestAuthorization".equals(str)) {
            requestAuthorization(str2, wVCallBackContext);
            return true;
        }
        if ("scan".equals(str)) {
            findDevices(str2, wVCallBackContext);
            return true;
        }
        if ("stopScan".equals(str)) {
            stopScan(str2, wVCallBackContext);
        } else {
            if ("connect".equals(str)) {
                connectDevice(str2, wVCallBackContext);
                return true;
            }
            if ("disconnect".equals(str)) {
                disconnect(str2, wVCallBackContext);
                return true;
            }
            if ("getServices".equals(str)) {
                getServices(str2, wVCallBackContext);
                return true;
            }
            if ("getCharacteristics".equals(str)) {
                getCharacteristics(str2, wVCallBackContext);
                return true;
            }
            if ("writeValue".equals(str)) {
                writeValue(str2, wVCallBackContext);
                return true;
            }
            if ("readValue".equals(str)) {
                readValue(str2, wVCallBackContext);
                return true;
            }
            if ("startNotifications".equals(str)) {
                setNotifications(str2, true, wVCallBackContext);
                return true;
            }
            if ("stopNotifications".equals(str)) {
                setNotifications(str2, false, wVCallBackContext);
                return true;
            }
        }
        return false;
    }

    public void findDevices(String str, WVCallBackContext wVCallBackContext) {
        WVResult wVResult = new WVResult();
        BluetoothAdapter bluetoothAdapter = this.mBTAdapter;
        if (bluetoothAdapter == null) {
            wVResult.addData(NotificationCompat.CATEGORY_MESSAGE, "DEVICE_NOT_SUPPORT");
            wVCallBackContext.error(wVResult);
        } else {
            if (!bluetoothAdapter.isEnabled()) {
                wVResult.addData(NotificationCompat.CATEGORY_MESSAGE, "BLUETOOTH_DISABLED");
                wVCallBackContext.error(wVResult);
                return;
            }
            if (this.mLeScanCallback == null) {
                this.mLeScanCallback = new BluetoothAdapter.LeScanCallback() { // from class: android.taobao.windvane.jsbridge.api.WVBluetooth.3
                    @Override // android.bluetooth.BluetoothAdapter.LeScanCallback
                    public void onLeScan(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
                        try {
                            String address = bluetoothDevice.getAddress();
                            if (WVBluetooth.this.mKnownDevices.contains(address)) {
                                return;
                            }
                            WVBluetooth.this.mKnownDevices.add(address);
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("name", bluetoothDevice.getName());
                            jSONObject.put(ApiConstants.DEVICEID, bluetoothDevice.getAddress());
                            ((WVApiPlugin) WVBluetooth.this).mWebView.fireEvent("WV.Event.WVBluetooth.discoverDevice", jSONObject.toString());
                            TaoLog.m24i("WVBluetooth", "find device : " + bluetoothDevice.getName() + " ads : " + bluetoothDevice.getAddress());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                };
            }
            this.mKnownDevices.clear();
            this.mBTAdapter.startLeScan(this.mLeScanCallback);
            wVCallBackContext.success();
        }
    }

    public void getCharacteristics(String str, WVCallBackContext wVCallBackContext) {
        WVResult wVResult = new WVResult();
        BluetoothAdapter bluetoothAdapter = this.mBTAdapter;
        if (bluetoothAdapter == null) {
            wVResult.addData(NotificationCompat.CATEGORY_MESSAGE, "DEVICE_NOT_SUPPORT");
            wVCallBackContext.error(wVResult);
            return;
        }
        if (bluetoothAdapter.isEnabled()) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString(ApiConstants.DEVICEID, "");
                String optString2 = jSONObject.optString("serviceId", "");
                BluetoothGatt bluetoothGatt = this.mBluetoothGatt;
                if (bluetoothGatt != null && optString.equals(bluetoothGatt.getDevice().getAddress())) {
                    BluetoothGattService service = this.mBluetoothGatt.getService(UUID.fromString(optString2));
                    JSONArray jSONArray = new JSONArray();
                    Iterator<BluetoothGattCharacteristic> it = service.getCharacteristics().iterator();
                    while (it.hasNext()) {
                        jSONArray.put(new JSONObject().put("characteristicId", it.next().getUuid()));
                    }
                    wVResult.addData("characteristics", jSONArray);
                    wVCallBackContext.success(wVResult);
                }
                wVResult.addData(NotificationCompat.CATEGORY_MESSAGE, "DEVICE_NOT_CONNECT");
                wVCallBackContext.error();
                return;
            } catch (Throwable th) {
                th.printStackTrace();
                wVCallBackContext.error(th.getMessage());
            }
        }
        wVCallBackContext.error();
    }

    public void getServices(String str, WVCallBackContext wVCallBackContext) {
        WVResult wVResult = new WVResult();
        BluetoothAdapter bluetoothAdapter = this.mBTAdapter;
        if (bluetoothAdapter == null) {
            wVResult.addData(NotificationCompat.CATEGORY_MESSAGE, "DEVICE_NOT_SUPPORT");
            wVCallBackContext.error(wVResult);
            return;
        }
        if (!bluetoothAdapter.isEnabled()) {
            wVCallBackContext.error();
            return;
        }
        try {
            String optString = new JSONObject(str).optString(ApiConstants.DEVICEID, "");
            BluetoothGatt bluetoothGatt = this.mBluetoothGatt;
            if (bluetoothGatt == null || !optString.equals(bluetoothGatt.getDevice().getAddress())) {
                wVResult.addData(NotificationCompat.CATEGORY_MESSAGE, "DEVICE_NOT_CONNECT");
                wVCallBackContext.error(wVResult);
                return;
            }
        } catch (Throwable th) {
            wVResult.addData(NotificationCompat.CATEGORY_MESSAGE, th.getCause());
            wVCallBackContext.error(wVResult);
        }
        BluetoothGatt bluetoothGatt2 = this.mBluetoothGatt;
        if (bluetoothGatt2 != null) {
            this.mGetServiceCallback = wVCallBackContext;
            bluetoothGatt2.discoverServices();
            TaoLog.m24i("WVBluetooth", "Attempting to start service discovery");
        }
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public void initialize(Context context, IWVWebView iWVWebView) {
        this.mBTAdapter = BluetoothAdapter.getDefaultAdapter();
        super.initialize(context, iWVWebView);
    }

    public void readValue(String str, WVCallBackContext wVCallBackContext) {
        String optString;
        String optString2;
        String optString3;
        BluetoothGatt bluetoothGatt;
        WVResult wVResult = new WVResult();
        BluetoothAdapter bluetoothAdapter = this.mBTAdapter;
        if (bluetoothAdapter == null) {
            wVResult.addData(NotificationCompat.CATEGORY_MESSAGE, "DEVICE_NOT_SUPPORT");
            wVCallBackContext.error(wVResult);
            return;
        }
        if (!bluetoothAdapter.isEnabled()) {
            wVResult.addData(NotificationCompat.CATEGORY_MESSAGE, "BLUETOOTH_DISABLED");
            wVCallBackContext.error(wVResult);
            return;
        }
        if (this.mCurrentConnectionState != 2) {
            wVResult.addData(NotificationCompat.CATEGORY_MESSAGE, "BLUETOOTH_NOT_ACTIVE: " + this.mCurrentConnectionState);
            wVCallBackContext.error(wVResult);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            optString = jSONObject.optString(ApiConstants.DEVICEID, "");
            optString2 = jSONObject.optString("serviceId", "");
            optString3 = jSONObject.optString("characteristicId", "");
            jSONObject.optString("value", "");
            bluetoothGatt = this.mBluetoothGatt;
        } catch (Throwable th) {
            wVCallBackContext.error(th.getMessage());
        }
        if (bluetoothGatt != null && optString.equals(bluetoothGatt.getDevice().getAddress())) {
            BluetoothGattCharacteristic characteristic = this.mBluetoothGatt.getService(UUID.fromString(optString2)).getCharacteristic(UUID.fromString(optString3));
            if (characteristic != null) {
                if (this.mBluetoothGatt.readCharacteristic(characteristic)) {
                    this.mReadValueCallback = wVCallBackContext;
                } else {
                    wVResult.addData(NotificationCompat.CATEGORY_MESSAGE, "FAILED_TO_READ_CHARACTERISTIC: " + characteristic.getProperties());
                    wVCallBackContext.error(wVResult);
                }
            }
            wVResult.addData(NotificationCompat.CATEGORY_MESSAGE, "FAILED_TO_READ");
            wVCallBackContext.error(wVResult);
            return;
        }
        wVResult.addData(NotificationCompat.CATEGORY_MESSAGE, "DEVICE_NOT_CONNECT");
        wVCallBackContext.error(wVResult);
    }

    public void requestAuthorization(String str, final WVCallBackContext wVCallBackContext) {
        try {
            PermissionProposer.buildPermissionTask(this.mContext, new String[]{"android.permission.BLUETOOTH", "android.permission.BLUETOOTH_ADMIN", "android.permission.ACCESS_FINE_LOCATION"}).setTaskOnPermissionGranted(new Runnable() { // from class: android.taobao.windvane.jsbridge.api.WVBluetooth.2
                @Override // java.lang.Runnable
                public void run() {
                    WVResult wVResult = new WVResult();
                    JSONObject jSONObject = new JSONObject();
                    if (WVBluetooth.this.mBTAdapter == null) {
                        wVResult.addData(NotificationCompat.CATEGORY_MESSAGE, "DEVICE_NOT_SUPPORT");
                        wVCallBackContext.error(wVResult);
                    } else {
                        if (!WVBluetooth.this.mBTAdapter.isEnabled() && !WVBluetooth.this.mBTAdapter.enable()) {
                            wVResult.addData(NotificationCompat.CATEGORY_MESSAGE, "BLUETOOTH_POWERED_OFF");
                            wVCallBackContext.error(wVResult);
                            return;
                        }
                        try {
                            jSONObject.put("state", "poweredOn");
                            wVResult.addData("value", jSONObject);
                            wVCallBackContext.success(wVResult);
                        } catch (Throwable unused) {
                            wVCallBackContext.error();
                        }
                    }
                }
            }).setTaskOnPermissionDenied(new Runnable() { // from class: android.taobao.windvane.jsbridge.api.WVBluetooth.1
                @Override // java.lang.Runnable
                public void run() {
                    WVResult wVResult = new WVResult();
                    wVResult.addData(NotificationCompat.CATEGORY_MESSAGE, "HY_USER_DENIED");
                    wVCallBackContext.error(wVResult);
                }
            }).execute();
        } catch (Exception e) {
            e.printStackTrace();
            wVCallBackContext.error(e.getMessage());
        }
    }

    public void setNotifications(String str, boolean z, WVCallBackContext wVCallBackContext) {
        WVResult wVResult = new WVResult();
        BluetoothAdapter bluetoothAdapter = this.mBTAdapter;
        if (bluetoothAdapter == null) {
            wVResult.addData(NotificationCompat.CATEGORY_MESSAGE, "DEVICE_NOT_SUPPORT");
            wVCallBackContext.error(wVResult);
            return;
        }
        if (!bluetoothAdapter.isEnabled()) {
            wVResult.addData(NotificationCompat.CATEGORY_MESSAGE, "BLUETOOTH_DISABLED");
            wVCallBackContext.error(wVResult);
            return;
        }
        if (this.mCurrentConnectionState != 2) {
            wVResult.addData(NotificationCompat.CATEGORY_MESSAGE, "BLUETOOTH_NOT_ACTIVE: " + this.mCurrentConnectionState);
            wVCallBackContext.error(wVResult);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString(ApiConstants.DEVICEID, "");
            String optString2 = jSONObject.optString("serviceId", "");
            String optString3 = jSONObject.optString("characteristicId", "");
            jSONObject.optString("value", "");
            BluetoothGatt bluetoothGatt = this.mBluetoothGatt;
            if (bluetoothGatt != null && optString.equals(bluetoothGatt.getDevice().getAddress())) {
                BluetoothGattCharacteristic characteristic = this.mBluetoothGatt.getService(UUID.fromString(optString2)).getCharacteristic(UUID.fromString(optString3));
                if (characteristic != null) {
                    if (!this.mBluetoothGatt.setCharacteristicNotification(characteristic, z)) {
                        wVResult.addData(NotificationCompat.CATEGORY_MESSAGE, "FAILED_TO_SET_NOTIFICATION");
                        wVCallBackContext.error(wVResult);
                        return;
                    }
                    List<BluetoothGattDescriptor> descriptors = characteristic.getDescriptors();
                    if (descriptors != null && descriptors.size() > 0) {
                        for (BluetoothGattDescriptor bluetoothGattDescriptor : descriptors) {
                            if (z) {
                                bluetoothGattDescriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
                            } else {
                                bluetoothGattDescriptor.setValue(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);
                            }
                            this.mBluetoothGatt.writeDescriptor(bluetoothGattDescriptor);
                        }
                    }
                    wVCallBackContext.success();
                    return;
                }
                return;
            }
            wVResult.addData(NotificationCompat.CATEGORY_MESSAGE, "DEVICE_NOT_CONNECT");
            wVCallBackContext.error(wVResult);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void stopScan(String str, WVCallBackContext wVCallBackContext) {
        WVResult wVResult = new WVResult();
        BluetoothAdapter bluetoothAdapter = this.mBTAdapter;
        if (bluetoothAdapter == null) {
            wVResult.addData(NotificationCompat.CATEGORY_MESSAGE, "DEVICE_NOT_SUPPORT");
            wVCallBackContext.error(wVResult);
        } else if (bluetoothAdapter.isEnabled()) {
            this.mBTAdapter.stopLeScan(this.mLeScanCallback);
            wVCallBackContext.success();
        } else {
            wVResult.addData(NotificationCompat.CATEGORY_MESSAGE, "BLUETOOTH_DISABLED");
            wVCallBackContext.error(wVResult);
        }
    }

    public void writeValue(String str, WVCallBackContext wVCallBackContext) {
        String optString;
        String optString2;
        String optString3;
        String optString4;
        BluetoothGatt bluetoothGatt;
        WVResult wVResult = new WVResult();
        BluetoothAdapter bluetoothAdapter = this.mBTAdapter;
        if (bluetoothAdapter == null) {
            wVResult.addData(NotificationCompat.CATEGORY_MESSAGE, "DEVICE_NOT_SUPPORT");
            wVCallBackContext.error(wVResult);
            return;
        }
        if (!bluetoothAdapter.isEnabled()) {
            wVResult.addData(NotificationCompat.CATEGORY_MESSAGE, "BLUETOOTH_DISABLED");
            wVCallBackContext.error(wVResult);
            return;
        }
        if (this.mCurrentConnectionState != 2) {
            wVResult.addData(NotificationCompat.CATEGORY_MESSAGE, "BLUETOOTH_NOT_ACTIVE: " + this.mCurrentConnectionState);
            wVCallBackContext.error(wVResult);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            optString = jSONObject.optString(ApiConstants.DEVICEID, "");
            optString2 = jSONObject.optString("serviceId", "");
            optString3 = jSONObject.optString("characteristicId", "");
            optString4 = jSONObject.optString("value", "");
            bluetoothGatt = this.mBluetoothGatt;
        } catch (Throwable th) {
            th.printStackTrace();
            wVResult.addData(NotificationCompat.CATEGORY_MESSAGE, th.getCause());
        }
        if (bluetoothGatt != null && optString.equals(bluetoothGatt.getDevice().getAddress())) {
            BluetoothGattCharacteristic characteristic = this.mBluetoothGatt.getService(UUID.fromString(optString2)).getCharacteristic(UUID.fromString(optString3));
            TaoLog.m18d("WVBluetooth", "get characteristic: " + optString3);
            if (characteristic != null) {
                characteristic.setValue(Base64.decode(optString4, 2));
                if (this.mBluetoothGatt.writeCharacteristic(characteristic)) {
                    this.mWriteValueCallback = wVCallBackContext;
                    return;
                }
                wVResult.addData(NotificationCompat.CATEGORY_MESSAGE, "FAILED_TO_WRITE_CHARACTERISTIC: " + characteristic.getProperties());
                wVCallBackContext.error(wVResult);
                return;
            }
            wVResult.addData(NotificationCompat.CATEGORY_MESSAGE, "FAILED_TO_WRITE");
            wVCallBackContext.error(wVResult);
            return;
        }
        wVResult.addData(NotificationCompat.CATEGORY_MESSAGE, "DEVICE_NOT_CONNECT");
        wVCallBackContext.error(wVResult);
    }
}
