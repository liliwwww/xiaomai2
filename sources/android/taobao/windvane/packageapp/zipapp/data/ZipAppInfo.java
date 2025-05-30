package android.taobao.windvane.packageapp.zipapp.data;

import android.support.v4.media.session.PlaybackStateCompat;
import android.taobao.windvane.config.EnvEnum;
import android.taobao.windvane.config.GlobalConfig;
import android.taobao.windvane.config.WVCommonConfig;
import android.taobao.windvane.config.WVCommonConfigData;
import android.taobao.windvane.connect.api.ApiConstants;
import android.taobao.windvane.packageapp.WVPackageAppService;
import android.taobao.windvane.packageapp.zipapp.utils.ZipAppConstants;
import android.taobao.windvane.util.TaoLog;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import com.ali.mobisecenhance.p009ld.multidex.Constants;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class ZipAppInfo {
    private ZipAppTypeEnum appType;
    public String errorCode;
    public boolean isInUse;
    public int tempPriority;
    private ZipUpdateInfoEnum updateInfo;
    private ZipUpdateTypeEnum updateType;
    public String name = "";
    public String installedVersion = "0.0";
    public long installedSeq = 0;
    public int status = -1;
    public boolean isOptional = false;
    public String mappingUrl = "";
    public ArrayList<String> folders = new ArrayList<>();
    public boolean isPreViewApp = false;
    public boolean isDamage = false;
    public boolean isInstantApp = false;
    public ArrayList<String> localFolders = new ArrayList<>();

    /* renamed from: v */
    public String f26v = "";

    /* renamed from: z */
    public String f27z = "";

    /* renamed from: t */
    public long f25t = 0;

    /* renamed from: s */
    public long f24s = 0;

    /* renamed from: f */
    public long f23f = 5;

    /* compiled from: Taobao */
    /* renamed from: android.taobao.windvane.packageapp.zipapp.data.ZipAppInfo$1 */
    /* loaded from: classes2.dex */
    static /* synthetic */ class C02091 {
        static final /* synthetic */ int[] $SwitchMap$android$taobao$windvane$config$EnvEnum;

        static {
            int[] iArr = new int[EnvEnum.values().length];
            $SwitchMap$android$taobao$windvane$config$EnvEnum = iArr;
            try {
                iArr[EnvEnum.ONLINE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$android$taobao$windvane$config$EnvEnum[EnvEnum.PRE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$android$taobao$windvane$config$EnvEnum[EnvEnum.DAILY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public boolean equals(ZipAppInfo zipAppInfo) {
        String str;
        String str2 = this.f26v;
        if (str2 == null || zipAppInfo == null || (str = zipAppInfo.f26v) == null || str2.equals(str)) {
            return zipAppInfo == null || this.f24s == zipAppInfo.f24s;
        }
        return false;
    }

    public String genMidPath(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name);
        sb.append(WVNativeCallbackUtil.SEPERATER);
        sb.append((z || "0.0".equals(this.installedVersion)) ? this.f26v : this.installedVersion);
        return sb.toString();
    }

    public ZipAppTypeEnum getAppType() {
        for (ZipAppTypeEnum zipAppTypeEnum : ZipAppTypeEnum.values()) {
            if (zipAppTypeEnum.getValue() == (this.f23f & 240)) {
                this.appType = zipAppTypeEnum;
                if (zipAppTypeEnum == ZipAppTypeEnum.ZIP_APP_TYPE_MINI_APP) {
                    this.isInstantApp = true;
                    this.appType = ZipAppTypeEnum.ZIP_APP_TYPE_PACKAGEAPP;
                }
                return this.appType;
            }
        }
        return ZipAppTypeEnum.ZIP_APP_TYPE_UNKNOWN;
    }

    public ZipUpdateInfoEnum getInfo() {
        for (ZipUpdateInfoEnum zipUpdateInfoEnum : ZipUpdateInfoEnum.values()) {
            if (zipUpdateInfoEnum.getValue() == (this.f23f & 12288)) {
                this.updateInfo = zipUpdateInfoEnum;
                return zipUpdateInfoEnum;
            }
        }
        return ZipUpdateInfoEnum.ZIP_APP_TYPE_NORMAL;
    }

    public boolean getIs2GUpdate() {
        return (this.f23f & PlaybackStateCompat.ACTION_PREPARE) != 0;
    }

    public boolean getIs3GUpdate() {
        return (this.f23f & PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID) != 0;
    }

    public String getNameAndSeq() {
        return this.name + ApiConstants.SPLIT_LINE + this.installedSeq;
    }

    public String getNameandVersion() {
        return this.name + "_" + this.f26v;
    }

    public int getPriority() {
        return (int) (this.f23f & 15);
    }

    public ZipUpdateTypeEnum getUpdateType() {
        for (ZipUpdateTypeEnum zipUpdateTypeEnum : ZipUpdateTypeEnum.values()) {
            if (zipUpdateTypeEnum.getValue() == (this.f23f & 3840)) {
                this.updateType = zipUpdateTypeEnum;
                return zipUpdateTypeEnum;
            }
        }
        return ZipUpdateTypeEnum.ZIP_UPDATE_TYPE_PASSIVE;
    }

    public String getZipUrl() {
        if (this.f27z.contains("wapp")) {
            this.f27z = "";
        }
        WVPackageAppService.IPackageZipPrefixAdapter packageZipPrefixAdapter = WVPackageAppService.getPackageZipPrefixAdapter();
        if (packageZipPrefixAdapter != null) {
            String packageZipPrefix = packageZipPrefixAdapter.getPackageZipPrefix(GlobalConfig.env, this.isPreViewApp);
            if (!TextUtils.isEmpty(packageZipPrefix)) {
                this.f27z = packageZipPrefix;
                TaoLog.m18d("ZipURL", "Zip url by app config: [" + this.name + "] " + packageZipPrefix);
            }
        }
        if (TextUtils.isEmpty(this.f27z)) {
            if (this.isPreViewApp && (isAppInstalled() || this.isInstantApp)) {
                this.isPreViewApp = false;
            }
            if (this.isPreViewApp) {
                WVCommonConfigData wVCommonConfigData = WVCommonConfig.commonConfig;
                if (TextUtils.isEmpty(wVCommonConfigData.packageZipPreviewPrefix)) {
                    int i = C02091.$SwitchMap$android$taobao$windvane$config$EnvEnum[GlobalConfig.env.ordinal()];
                    if (i == 1) {
                        this.f27z = "http://wapp.m.taobao.com/";
                    } else if (i == 2) {
                        this.f27z = "http://wapp.wapa.taobao.com/";
                    } else if (i != 3) {
                        this.f27z = "http://wapp.m.taobao.com/";
                    } else {
                        this.f27z = "http://wapp.waptest.taobao.com/";
                    }
                } else {
                    this.f27z = wVCommonConfigData.packageZipPreviewPrefix;
                }
            } else {
                WVCommonConfigData wVCommonConfigData2 = WVCommonConfig.commonConfig;
                if (TextUtils.isEmpty(wVCommonConfigData2.packageZipPrefix)) {
                    int i2 = C02091.$SwitchMap$android$taobao$windvane$config$EnvEnum[GlobalConfig.env.ordinal()];
                    if (i2 == 1) {
                        this.f27z = "https://ossgw.alicdn.com/awp/h5.m.taobao.com/";
                    } else if (i2 == 2) {
                        this.f27z = "http://h5.wapa.taobao.com/";
                    } else if (i2 != 3) {
                        this.f27z = "https://ossgw.alicdn.com/awp/h5.m.taobao.com/";
                    } else {
                        this.f27z = "http://h5.waptest.taobao.com/";
                    }
                } else {
                    this.f27z = wVCommonConfigData2.packageZipPrefix;
                }
            }
        }
        StringBuilder sb = new StringBuilder(this.f27z);
        if ('/' != sb.charAt(sb.length() - 1)) {
            sb.append(WVNativeCallbackUtil.SEPERATER);
        }
        sb.append("app/");
        sb.append(this.name);
        sb.append("/app-");
        sb.append(this.f24s);
        if (!this.isPreViewApp && !GlobalConfig.env.equals(EnvEnum.PRE) && this.f26v.equals(this.installedVersion) && this.f24s != this.installedSeq) {
            sb.append("-incr");
        }
        sb.append(Constants.ZIP_SUFFIX);
        return sb.toString();
    }

    public boolean isAppInstalled() {
        return (0 == this.installedSeq || this.status == ZipAppConstants.ZIP_REMOVED) ? false : true;
    }
}
