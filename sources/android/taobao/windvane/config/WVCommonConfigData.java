package android.taobao.windvane.config;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class WVCommonConfigData {
    public String v = "0";
    public double packagePriorityWeight = 0.1d;
    public long updateInterval = 300000;
    public int packageAppStatus = 2;
    public int monitorStatus = 2;
    public int urlRuleStatus = 2;
    public String urlScheme = "http";
    public String verifySampleRate = null;
    public String[] monitoredApps = new String[0];
    public String[] aliNetworkDegradeDomains = new String[0];
    public String[] disableMixViews = new String[0];
    public long disableInstallPeriod_start = 0;
    public long disableInstallPeriod_end = 0;
    public double ucsdk_alinetwork_rate = 1.0d;
    public double ucsdk_image_strategy_rate = 1.0d;
    public boolean useSystemWebView = false;
    public String cookieUrlRule = "";
    public String ucCoreUrl = "";
    public boolean isOpenCombo = true;
    public boolean isCheckCleanup = true;
    public UCParamData ucParam = new UCParamData("{}");
    public boolean enableUcShareCore = true;
    public String shareBlankList = "";
    public int packageDownloadLimit = 30;
    public int packageAccessInterval = 3000;
    public int packageRemoveInterval = 432000000;
    public int recoveryInterval = 432000000;
    public int customsDirectQueryLimit = 10;
    public int customsComboLimit = 1;
    public String packageZipPrefix = "";
    public String packageZipPreviewPrefix = "";
    public boolean isAutoRegisterApp = false;
    public boolean isUseTBDownloader = true;
    public boolean isUseAliNetworkDelegate = true;
    public String excludeUCVersions = "1.12.11.0, 1.15.15.0, 1.14.13.0, 1.13.12.0";
    public int packageMaxAppCount = 100;
    public int zipDegradeMode = 0;
    public String zipDegradeList = "";
    public boolean useUCPlayer = false;
    public boolean ucSkipOldKernel = true;
    public boolean enableUCPrecache = false;
    public String precachePackageName = "";
    public boolean enableUCPrecacheDoc = false;
    public int initUCCorePolicy = 0;
    public int initWebPolicy = 19;
    public int webMultiPolicy = 0;
    public int gpuMultiPolicy = 0;
    public int ucMultiTimeOut = 8000;
    public int ucMultiStartTime = 5000;
    public boolean ucMultiServiceSpeedUp = false;
    public String initOldCoreVersions = "3.*";
    public boolean firstUseSystemWebViewOn7zInit = false;
    public int downloadCoreType = 3;
    public boolean openLog = false;
    public boolean useURLConfig = true;
    public boolean openTLog = true;
    public boolean useOldBridge = false;
    public String ffmegSoPath = "";
    public String[] systemBlacks = new String[0];
    public String[] brandBlacks = new String[0];
    public String[] modelBlacks = new String[0];
    public int recoverMultiInterval = 600000;
    public boolean openExperiment = true;
    public boolean openUCExperiment = false;
    public boolean openUCImageExperiment = false;
    public int ucMultiRetryTimes = 5;
    public boolean enableExtImgDecoder = true;
    public boolean discardableFreeIfHasGpuDecode = false;
    public boolean enableSgRequestCheck = true;
    public boolean filterSgRequestCheck = true;
    public boolean skipPreRenderBackgroundWhitePage = true;
    public boolean fixWhitePageBug = false;
    public boolean enablePreStartup = true;
    public boolean useNewThreadPool = true;
    public boolean enableGpuGoneReload = true;
    public boolean open5GAdapter = true;
    public boolean needZipDegrade = false;
    public boolean targetSdkAdapte = false;
    public long zcacheResponseTimeOut = 20;
    public long sysZcacheResponseTimeOut = 20;
    public boolean enableZCacheAdpter = true;
    public boolean enableMimeTypeSet = true;
    public boolean keepFullUrl = true;
    public boolean fixCameraPermission = true;
    public boolean enableThreadWatchdog = true;
    public boolean enableWVFullTrace = true;
    public boolean reduceCameraPermissionOfStorage = true;
    public boolean reduceGalleryPermissionOfStorageWrite = true;
    public boolean storeCachedDir = true;
    public boolean enableSamsungClipboard = true;
    public boolean enableUCUploadToTlog = true;
    public boolean uploadPPAfterJs = true;
}
