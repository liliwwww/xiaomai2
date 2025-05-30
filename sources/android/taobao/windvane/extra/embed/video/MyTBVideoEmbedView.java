package android.taobao.windvane.extra.embed.video;

import android.app.Activity;
import android.content.Context;
import android.taobao.windvane.embed.BaseEmbedView;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.taobao.avplayer.DWAspectRatio;
import com.taobao.avplayer.DWInstanceType;
import com.taobao.avplayer.IDWVideoLifecycleListener;
import com.taobao.avplayer.IDWVideoLoopCompleteListener;
import com.taobao.avplayer.TBDWInstance;
import com.taobao.avplayer.TBHighPerformanceDWInstance;
import com.taobao.avplayer.common.IDWMutedChangeListener;
import com.taobao.avplayer.common.IDWRootViewClickListener;
import com.taobao.avplayer.interactivelifecycle.frontcover.model.DWFrontCover;
import com.taobao.avplayer.interactivelifecycle.frontcover.model.DWFrontCoverBean;
import com.taobao.uikit.extend.feature.view.TUrlImageView;
import com.uc.webview.export.extension.EmbedViewConfig;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class MyTBVideoEmbedView extends BaseEmbedView implements IDWVideoLifecycleListener, IDWVideoLoopCompleteListener, IDWMutedChangeListener, IDWRootViewClickListener {
    private static String ERROR = "error";
    private static String FINISH = "finish";
    private static final String FULL_SCREEN_MODE = "fullScreen";
    private static String LANDSCAPE = "landscape";
    private static String METADATA = "meta";
    private static String MUTEDCHANGE = "mutedChange";
    public static final String NAME = "wvvideo";
    private static final String NORMAL_SCREEN_MODE = "inlineScreen";
    private static String PAUSED = "paused";
    private static String PLAYING = "playing";
    private static String PREPARED = "prepared";
    private static String SCREENMODECHANGE = "screenModeChange";
    private static final String SMALL_SCREEN_MODE = "smallScreen";
    private static final String VALUE_FALSE = "false";
    private static final long VALUE_LONG = -1;
    private static final String VALUE_TRUE = "true";
    private static String VIDEOEND = "end";
    private DWAspectRatio mAspectRatio;
    private boolean mAutoPlay;
    private boolean mBackCoverDisPlay;
    private Context mContext;
    private boolean mControlsViewHidden;
    private boolean mGestureViewHidden;
    private boolean mHasDisappear;
    private TBHighPerformanceDWInstance mHigDWInstance;
    private boolean mInit;
    private long mInteractiveId;
    private boolean mIsVideoLoop;
    private boolean mLoadingHidden;
    private boolean mMiniProgressViewHidden;
    private boolean mNetworkErrorViewHidden;
    private boolean mPlayErrorViewHidden;
    private boolean mPlayingIconHidden;
    private ImageView.ScaleType mPosterScaleType;
    private String mScreenMode;
    private boolean mShownMuteBtn;
    private TBDWInstance mTBDWInstance;
    private boolean mToastViewHidden;
    private long mUserId;
    private HashMap<String, String> utParams;
    private int mWidth = 0;
    private int mHeight = 0;
    private String mSrc = null;
    private String mPlayerScene = null;
    private String mThumbnailSrc = null;
    private boolean mShowInteractive = false;
    private String mContentId = null;
    private boolean mMuted = false;
    private String mVideoSource = null;
    private String mVideoId = null;
    private String mFrom = null;
    private String mPreload = null;
    private String mPlayControl = null;
    private String mContentMode = null;
    private boolean mNeedFirstPlayUT = true;
    private DWInstanceType mDWInstanceType = null;
    private int mCurrentTime = 0;
    private boolean mHasPlay = false;
    private boolean mResume = false;
    private boolean mStarted = false;
    private int mVideoDuration = 0;
    private boolean mLandscape = false;
    private FrameLayout mComponentHostView = null;
    private boolean mNeedAD = true;
    private boolean isCompleted = false;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: Taobao */
    private static class JSMethod {
        private static final /* synthetic */ JSMethod[] $VALUES;
        public static final JSMethod getCurrentTime;
        public static final JSMethod getDuration;
        public static final JSMethod getMuted;
        public static final JSMethod getScreenMode;
        public static final JSMethod pause;
        public static final JSMethod play;
        public static final JSMethod setCurrentTime;
        public static final JSMethod setInstanceMode;
        public static final JSMethod setMuted;
        public static final JSMethod setScreenMode;
        public static final JSMethod updateEmbedProperty;

        static {
            JSMethod jSMethod = new JSMethod("getCurrentTime", 0) { // from class: android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.JSMethod.1
                @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.JSMethod
                public boolean doSomething(MyTBVideoEmbedView myTBVideoEmbedView, String str, WVCallBackContext wVCallBackContext) {
                    if (wVCallBackContext == null) {
                        return false;
                    }
                    wVCallBackContext.success("" + (myTBVideoEmbedView.getCurrentPosition() / 1000.0f));
                    return true;
                }
            };
            getCurrentTime = jSMethod;
            JSMethod jSMethod2 = new JSMethod("setCurrentTime", 1) { // from class: android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.JSMethod.2
                /* JADX WARN: Removed duplicated region for block: B:12:0x003a  */
                @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.JSMethod
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public boolean doSomething(android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView r3, java.lang.String r4, android.taobao.windvane.jsbridge.WVCallBackContext r5) {
                    /*
                        r2 = this;
                        boolean r0 = android.text.TextUtils.isEmpty(r4)
                        r1 = 1
                        if (r0 != 0) goto L37
                        com.alibaba.fastjson.JSONObject r4 = com.alibaba.fastjson.JSON.parseObject(r4)
                        if (r4 == 0) goto L37
                        java.lang.String r0 = "time"
                        java.lang.String r4 = r4.getString(r0)
                        int r4 = java.lang.Integer.parseInt(r4)     // Catch: java.lang.Throwable -> L37
                        int r4 = r4 * 1000
                        com.taobao.avplayer.TBDWInstance r0 = android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.access$200(r3)     // Catch: java.lang.Throwable -> L37
                        if (r0 == 0) goto L28
                        com.taobao.avplayer.TBDWInstance r3 = android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.access$200(r3)     // Catch: java.lang.Throwable -> L37
                        r3.seekTo(r4)     // Catch: java.lang.Throwable -> L37
                        goto L35
                    L28:
                        com.taobao.avplayer.TBHighPerformanceDWInstance r0 = android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.access$300(r3)     // Catch: java.lang.Throwable -> L37
                        if (r0 == 0) goto L35
                        com.taobao.avplayer.TBHighPerformanceDWInstance r3 = android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.access$300(r3)     // Catch: java.lang.Throwable -> L37
                        r3.seekTo(r4)     // Catch: java.lang.Throwable -> L37
                    L35:
                        r3 = 1
                        goto L38
                    L37:
                        r3 = 0
                    L38:
                        if (r5 == 0) goto L43
                        if (r3 == 0) goto L40
                        r5.success()
                        goto L43
                    L40:
                        r5.error()
                    L43:
                        return r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.JSMethod.AnonymousClass2.doSomething(android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView, java.lang.String, android.taobao.windvane.jsbridge.WVCallBackContext):boolean");
                }
            };
            setCurrentTime = jSMethod2;
            JSMethod jSMethod3 = new JSMethod("getDuration", 2) { // from class: android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.JSMethod.3
                @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.JSMethod
                public boolean doSomething(MyTBVideoEmbedView myTBVideoEmbedView, String str, WVCallBackContext wVCallBackContext) {
                    if (wVCallBackContext == null) {
                        return true;
                    }
                    wVCallBackContext.success(String.valueOf(myTBVideoEmbedView.mVideoDuration / 1000.0f));
                    return true;
                }
            };
            getDuration = jSMethod3;
            JSMethod jSMethod4 = new JSMethod("getMuted", 3) { // from class: android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.JSMethod.4
                @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.JSMethod
                public boolean doSomething(MyTBVideoEmbedView myTBVideoEmbedView, String str, WVCallBackContext wVCallBackContext) {
                    if (wVCallBackContext == null) {
                        return true;
                    }
                    wVCallBackContext.success(String.valueOf(myTBVideoEmbedView.isMute()));
                    return true;
                }
            };
            getMuted = jSMethod4;
            JSMethod jSMethod5 = new JSMethod("setMuted", 4) { // from class: android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.JSMethod.5
                @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.JSMethod
                public boolean doSomething(MyTBVideoEmbedView myTBVideoEmbedView, String str, WVCallBackContext wVCallBackContext) {
                    JSONObject parseObject;
                    if (TextUtils.isEmpty(str) || (parseObject = JSON.parseObject(str)) == null) {
                        return true;
                    }
                    myTBVideoEmbedView.mute(Boolean.TRUE.equals(parseObject.getBoolean("muted")));
                    if (wVCallBackContext == null) {
                        return true;
                    }
                    wVCallBackContext.success();
                    return true;
                }
            };
            setMuted = jSMethod5;
            JSMethod jSMethod6 = new JSMethod("setScreenMode", 5) { // from class: android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.JSMethod.6
                @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.JSMethod
                public boolean doSomething(MyTBVideoEmbedView myTBVideoEmbedView, String str, WVCallBackContext wVCallBackContext) {
                    JSONObject parseObject;
                    Object obj;
                    if (TextUtils.isEmpty(str) || (parseObject = JSON.parseObject(str)) == null || (obj = parseObject.get("screenMode")) == null) {
                        return false;
                    }
                    myTBVideoEmbedView.setScreenMode(String.valueOf(obj), true);
                    if (wVCallBackContext != null) {
                        wVCallBackContext.success();
                    }
                    return true;
                }
            };
            setScreenMode = jSMethod6;
            JSMethod jSMethod7 = new JSMethod("getScreenMode", 6) { // from class: android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.JSMethod.7
                @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.JSMethod
                public boolean doSomething(MyTBVideoEmbedView myTBVideoEmbedView, String str, WVCallBackContext wVCallBackContext) {
                    if (wVCallBackContext == null) {
                        return true;
                    }
                    wVCallBackContext.success(myTBVideoEmbedView.mScreenMode);
                    return true;
                }
            };
            getScreenMode = jSMethod7;
            JSMethod jSMethod8 = new JSMethod("play", 7) { // from class: android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.JSMethod.8
                @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.JSMethod
                public boolean doSomething(MyTBVideoEmbedView myTBVideoEmbedView, String str, WVCallBackContext wVCallBackContext) {
                    myTBVideoEmbedView.play();
                    if (wVCallBackContext == null) {
                        return true;
                    }
                    wVCallBackContext.success();
                    return true;
                }
            };
            play = jSMethod8;
            JSMethod jSMethod9 = new JSMethod("pause", 8) { // from class: android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.JSMethod.9
                @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView.JSMethod
                public boolean doSomething(MyTBVideoEmbedView myTBVideoEmbedView, String str, WVCallBackContext wVCallBackContext) {
                    if (myTBVideoEmbedView.mTBDWInstance != null) {
                        myTBVideoEmbedView.mTBDWInstance.pauseVideo();
                    } else if (myTBVideoEmbedView.mHigDWInstance != null) {
                        myTBVideoEmbedView.mHigDWInstance.pauseVideo();
                    }
                    if (wVCallBackContext == null) {
                        return true;
                    }
                    wVCallBackContext.success();
                    return true;
                }
            };
            pause = jSMethod9;
            JSMethod jSMethod10 = new 10("setInstanceMode", 9);
            setInstanceMode = jSMethod10;
            JSMethod jSMethod11 = new 11("updateEmbedProperty", 10);
            updateEmbedProperty = jSMethod11;
            $VALUES = new JSMethod[]{jSMethod, jSMethod2, jSMethod3, jSMethod4, jSMethod5, jSMethod6, jSMethod7, jSMethod8, jSMethod9, jSMethod10, jSMethod11};
        }

        private JSMethod(String str, int i) {
        }

        public static JSMethod valueOf(String str) {
            return (JSMethod) Enum.valueOf(JSMethod.class, str);
        }

        public static JSMethod[] values() {
            return (JSMethod[]) $VALUES.clone();
        }

        public boolean doSomething(MyTBVideoEmbedView myTBVideoEmbedView, String str, WVCallBackContext wVCallBackContext) {
            return false;
        }
    }

    private void destroyInner() {
        TBDWInstance tBDWInstance = this.mTBDWInstance;
        if (tBDWInstance == null) {
            TBHighPerformanceDWInstance tBHighPerformanceDWInstance = this.mHigDWInstance;
            if (tBHighPerformanceDWInstance != null) {
                FrameLayout frameLayout = this.mComponentHostView;
                if (frameLayout != null) {
                    frameLayout.removeView(tBHighPerformanceDWInstance.getView());
                }
                this.mHigDWInstance.setVideoLifecycleListener((IDWVideoLifecycleListener) null);
                this.mHigDWInstance.destroy();
                this.mHigDWInstance = null;
                return;
            }
            return;
        }
        boolean z = this.mHasPlay;
        if (!z) {
            z = tBDWInstance.adIsPlaying();
        }
        this.mHasPlay = z;
        if (this.mTBDWInstance.isFullScreen()) {
            ViewGroup view = this.mTBDWInstance.getView();
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(view);
            }
            this.mTBDWInstance.toggleScreen();
        }
        FrameLayout frameLayout2 = this.mComponentHostView;
        if (frameLayout2 != null) {
            frameLayout2.removeView(this.mTBDWInstance.getView());
        }
        this.mTBDWInstance.setVideoLifecycleListener((IDWVideoLifecycleListener) null);
        this.mTBDWInstance.destroy();
        this.mTBDWInstance = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fireEvent(String str, String str2) {
        EmbedViewEvent.firevent(this.webView, this.id, str, str2);
    }

    private View genVideoView() {
        View initNormalInstance;
        boolean z;
        if ("highPerformance".equals(this.mPlayerScene)) {
            initNormalInstance = initHighInstance();
            z = true;
        } else {
            initNormalInstance = initNormalInstance();
            z = false;
        }
        this.mInit = true;
        if (this.mComponentHostView == null) {
            this.mComponentHostView = new 1(this, this.mContext);
        }
        ViewParent parent = initNormalInstance.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(initNormalInstance);
        }
        this.mComponentHostView.addView(initNormalInstance);
        if (this.mAutoPlay) {
            if (z) {
                this.mHigDWInstance.start();
            } else {
                this.mTBDWInstance.start();
            }
            fireEvent(PLAYING, "");
        }
        initNormalInstance.setOnTouchListener(new 2(this));
        return this.mComponentHostView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getCurrentPosition() {
        TBDWInstance tBDWInstance = this.mTBDWInstance;
        if (tBDWInstance != null) {
            return tBDWInstance.getCurrentPosition();
        }
        TBHighPerformanceDWInstance tBHighPerformanceDWInstance = this.mHigDWInstance;
        if (tBHighPerformanceDWInstance != null) {
            return tBHighPerformanceDWInstance.getCurrentPosition();
        }
        return 0;
    }

    private View initHighInstance() {
        TBHighPerformanceDWInstance.TBBuilder tBBuilder = new TBHighPerformanceDWInstance.TBBuilder((Activity) this.mContext);
        tBBuilder.setBizCode(this.mFrom);
        tBBuilder.setContentId(this.mContentId);
        tBBuilder.setUserId(this.mUserId);
        tBBuilder.setVideoUrl(this.mSrc);
        tBBuilder.setMute(this.mMuted);
        tBBuilder.setUTParams(this.utParams);
        tBBuilder.setWidth(this.mWidth);
        tBBuilder.setVideoId(this.mVideoId);
        tBBuilder.setVideoSource(this.mVideoSource);
        tBBuilder.setHeight(this.mHeight);
        tBBuilder.setVideoLoop(this.mIsVideoLoop);
        DWAspectRatio dWAspectRatio = this.mAspectRatio;
        if (dWAspectRatio != null) {
            tBBuilder.setVideoAspectRatio(dWAspectRatio);
        }
        tBBuilder.setDWInstanceType(DWInstanceType.PIC);
        this.mHigDWInstance = tBBuilder.create();
        if (!TextUtils.isEmpty(this.mThumbnailSrc)) {
            TUrlImageView tUrlImageView = new TUrlImageView(this.mContext);
            ImageView.ScaleType scaleType = this.mPosterScaleType;
            if (scaleType != null) {
                tUrlImageView.setScaleType(scaleType);
            }
            tUrlImageView.asyncSetImageUrl(this.mThumbnailSrc);
            this.mHigDWInstance.setPicImageView(tUrlImageView);
        }
        this.mHigDWInstance.setVideoLifecycleListener(this);
        if (this.mIsVideoLoop) {
            this.mHigDWInstance.setIVideoLoopCompleteListener(this);
        }
        this.mHigDWInstance.setRootViewClickListener(this);
        this.mHigDWInstance.setIDWMutedChangeListener(this);
        if (this.mAutoPlay || (this.mResume && this.mStarted)) {
            this.mHigDWInstance.setInstanceType(DWInstanceType.VIDEO);
            this.mStarted = true;
            this.mNeedFirstPlayUT = false;
            this.mHigDWInstance.start();
        } else if (METADATA.equals(this.mPreload)) {
            this.mHigDWInstance.setInstanceType(DWInstanceType.VIDEO);
            this.mHigDWInstance.asyncPrepareVideo();
        }
        return this.mHigDWInstance.getView();
    }

    private View initNormalInstance() {
        TBDWInstance.TBBuilder tBBuilder = new TBDWInstance.TBBuilder((Activity) this.mContext);
        tBBuilder.setVideoUrl(this.mSrc);
        if (!TextUtils.isEmpty(this.mPlayerScene)) {
            tBBuilder.setScene(this.mPlayerScene);
        }
        DWInstanceType dWInstanceType = this.mDWInstanceType;
        if (dWInstanceType != null) {
            tBBuilder.setDWInstanceType(dWInstanceType);
        }
        tBBuilder.setVideoLoop(this.mIsVideoLoop);
        tBBuilder.setMute(this.mMuted);
        if (!TextUtils.isEmpty(this.mContentId)) {
            tBBuilder.setContentId(this.mContentId);
        }
        tBBuilder.setNeedBackCover(this.mBackCoverDisPlay);
        tBBuilder.setVideoSource(this.mVideoSource);
        tBBuilder.setVideoId(this.mVideoId);
        tBBuilder.setBizCode(this.mFrom);
        tBBuilder.setUTParams(this.utParams);
        if (this.mUserId != -1) {
            tBBuilder.setInteractiveId(this.mInteractiveId);
        }
        long j = this.mUserId;
        if (j != -1) {
            tBBuilder.setUserId(j);
        }
        if (!TextUtils.isEmpty(this.mThumbnailSrc)) {
            tBBuilder.setNeedFrontCover(true);
            DWFrontCover dWFrontCover = new DWFrontCover();
            DWFrontCoverBean dWFrontCoverBean = new DWFrontCoverBean(0L, (String) null, this.mThumbnailSrc);
            dWFrontCoverBean.setScaleType(this.mPosterScaleType);
            dWFrontCover.setFrontCoverView(dWFrontCoverBean);
            tBBuilder.setFrontCoverData(dWFrontCover);
        }
        tBBuilder.setMiniProgressAnchorShown(this.mMiniProgressViewHidden);
        tBBuilder.hiddenNetworkErrorView(this.mNetworkErrorViewHidden);
        tBBuilder.hiddenToastView(this.mToastViewHidden);
        tBBuilder.hiddenPlayingIcon(this.mPlayingIconHidden);
        tBBuilder.hiddenGestureView(this.mGestureViewHidden);
        tBBuilder.hiddenLoading(this.mLoadingHidden);
        tBBuilder.hiddenPlayErrorView(this.mPlayErrorViewHidden);
        tBBuilder.setMuteDisplay(this.mShownMuteBtn);
        tBBuilder.setWidth(this.mWidth);
        tBBuilder.setHeight(this.mHeight);
        TBDWInstance create = tBBuilder.create();
        this.mTBDWInstance = create;
        create.setVideoLifecycleListener(this);
        this.mTBDWInstance.setIDWMutedChangeListener(this);
        this.mTBDWInstance.hideCloseView();
        this.mTBDWInstance.hideController();
        return this.mTBDWInstance.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isMute() {
        TBDWInstance tBDWInstance = this.mTBDWInstance;
        return tBDWInstance != null ? tBDWInstance.isMute() : this.mHigDWInstance.isMute();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mute(boolean z) {
        this.mMuted = z;
        if (!this.mInit || this.mHasDisappear) {
            return;
        }
        TBDWInstance tBDWInstance = this.mTBDWInstance;
        if (tBDWInstance != null) {
            tBDWInstance.mute(z);
            return;
        }
        TBHighPerformanceDWInstance tBHighPerformanceDWInstance = this.mHigDWInstance;
        if (tBHighPerformanceDWInstance != null) {
            tBHighPerformanceDWInstance.mute(z);
        }
    }

    private void parseParam() {
        setWidth(this.params.mWidth, false);
        setHeight(this.params.mHeight, false);
        for (Enum r4 : EmbedProperties.values()) {
            r4.setValue(this, this.params.mObjectParam.get(r4.name()), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void play() {
        TBDWInstance tBDWInstance = this.mTBDWInstance;
        if (tBDWInstance != null) {
            if (tBDWInstance.getVideoState() != 0 && this.mTBDWInstance.getVideoState() != 5 && this.mTBDWInstance.getVideoState() != 8 && this.mTBDWInstance.getVideoState() != 4) {
                this.mTBDWInstance.playVideo();
                return;
            } else {
                this.mStarted = true;
                this.mTBDWInstance.start();
                return;
            }
        }
        TBHighPerformanceDWInstance tBHighPerformanceDWInstance = this.mHigDWInstance;
        if (tBHighPerformanceDWInstance != null) {
            tBHighPerformanceDWInstance.setInstanceType(DWInstanceType.VIDEO);
            if (this.mHigDWInstance.getVideoState() != 0 && this.mHigDWInstance.getVideoState() != 5 && this.mHigDWInstance.getVideoState() != 8 && this.mHigDWInstance.getVideoState() != 4) {
                this.mHigDWInstance.playVideo();
                return;
            }
            this.mStarted = true;
            this.mNeedFirstPlayUT = false;
            this.mHigDWInstance.start();
        }
    }

    @Override // android.taobao.windvane.embed.BaseEmbedView
    public boolean execute(String str, String str2, WVCallBackContext wVCallBackContext) {
        JSMethod jSMethod;
        try {
            jSMethod = JSMethod.valueOf(str);
        } catch (Throwable unused) {
            jSMethod = null;
        }
        return jSMethod != null ? jSMethod.doSomething(this, str2, wVCallBackContext) : super.execute(str, str2, wVCallBackContext);
    }

    @Override // android.taobao.windvane.embed.BaseEmbedView
    protected View generateView(Context context) {
        Map map;
        EmbedViewConfig embedViewConfig = this.params;
        if (embedViewConfig == null || (map = embedViewConfig.mObjectParam) == null || map.isEmpty()) {
            return null;
        }
        this.mContext = context;
        parseParam();
        return genVideoView();
    }

    @Override // android.taobao.windvane.embed.BaseEmbedView
    protected String getViewType() {
        return NAME;
    }

    public boolean hook() {
        return false;
    }

    void log(String str) {
        Log.e("dyy", str);
    }

    @Override // android.taobao.windvane.embed.BaseEmbedView
    public void onAttachedToWebView() {
        super.onAttachedToWebView();
    }

    @Override // android.taobao.windvane.embed.BaseEmbedView
    public void onDestroy() {
        super.onDestroy();
        destroyInner();
        this.mInit = false;
        this.mContext = null;
    }

    @Override // android.taobao.windvane.embed.BaseEmbedView
    public void onDetachedFromWebView() {
        super.onDetachedFromWebView();
    }

    public void onLoopCompletion() {
    }

    public void onMutedChange(boolean z) {
        fireEvent(MUTEDCHANGE, z ? "true" : VALUE_FALSE);
    }

    @Override // android.taobao.windvane.embed.BaseEmbedView
    public void onParamChanged(String[] strArr, String[] strArr2) {
        EmbedProperties embedProperties;
        super.onParamChanged(strArr, strArr2);
        if (strArr == null || strArr.length == 0 || strArr2 == null || strArr2.length == 0) {
            return;
        }
        String str = strArr[0];
        String str2 = strArr2[0];
        try {
            embedProperties = EmbedProperties.valueOf(str);
        } catch (Throwable unused) {
            embedProperties = null;
        }
        if (embedProperties == null) {
            return;
        }
        embedProperties.setValue(this, str2, true);
    }

    public void onPause() {
        super.onPause();
    }

    public void onResume() {
        super.onResume();
    }

    public void onVideoClose() {
    }

    public void onVideoComplete() {
        this.mNeedAD = true;
        this.isCompleted = true;
        TBDWInstance tBDWInstance = this.mTBDWInstance;
        if (tBDWInstance != null) {
            tBDWInstance.needAD(true);
        }
        this.mHasPlay = false;
        this.mCurrentTime = 0;
        fireEvent(FINISH, "");
        fireEvent(VIDEOEND, "");
    }

    public void onVideoError(Object obj, int i, int i2) {
        fireEvent(ERROR, "");
    }

    public void onVideoFullScreen() {
        TBDWInstance tBDWInstance = this.mTBDWInstance;
        if (tBDWInstance == null) {
            return;
        }
        tBDWInstance.mute(false);
        this.mLandscape = true;
        this.mTBDWInstance.showOrHideInteractive(true);
        this.mTBDWInstance.showTopEventView();
        this.mTBDWInstance.showGoodsListView();
        fireEvent(SCREENMODECHANGE, FULL_SCREEN_MODE);
        HashMap hashMap = new HashMap(1);
        hashMap.put("landscape", Boolean.TRUE);
        fireEvent(LANDSCAPE, JSON.toJSONString(hashMap));
        this.mScreenMode = FULL_SCREEN_MODE;
    }

    public void onVideoInfo(Object obj, int i, int i2) {
    }

    public void onVideoNormalScreen() {
        TBDWInstance tBDWInstance = this.mTBDWInstance;
        if (tBDWInstance == null) {
            return;
        }
        this.mLandscape = false;
        tBDWInstance.mute(this.mMuted);
        this.mTBDWInstance.showOrHideInteractive(this.mShowInteractive);
        this.mTBDWInstance.hideGoodsListView();
        this.mTBDWInstance.hideTopEventView();
        fireEvent(SCREENMODECHANGE, SMALL_SCREEN_MODE);
        HashMap hashMap = new HashMap(1);
        hashMap.put("landscape", Boolean.FALSE);
        fireEvent(LANDSCAPE, JSON.toJSONString(hashMap));
        this.mScreenMode = SMALL_SCREEN_MODE;
    }

    public void onVideoPause(boolean z) {
        fireEvent(PAUSED, "");
    }

    public void onVideoPlay() {
        this.isCompleted = false;
        fireEvent(PLAYING, "");
    }

    public void onVideoPrepared(Object obj) {
        this.isCompleted = false;
        fireEvent(PREPARED, "");
    }

    public void onVideoProgressChanged(int i, int i2, int i3) {
        this.mCurrentTime = i;
        if (this.mVideoDuration == 0) {
            this.mVideoDuration = i3;
        }
    }

    public void onVideoSeekTo(int i) {
    }

    public void onVideoStart() {
        TBDWInstance tBDWInstance;
        this.mNeedAD = false;
        this.mStarted = true;
        this.isCompleted = false;
        if (this.mResume && !this.mHasPlay && (tBDWInstance = this.mTBDWInstance) != null) {
            tBDWInstance.pauseVideo();
            return;
        }
        this.mHasPlay = true;
        int i = this.mCurrentTime;
        if (i > 0) {
            TBDWInstance tBDWInstance2 = this.mTBDWInstance;
            if (tBDWInstance2 != null) {
                tBDWInstance2.seekTo(i);
                return;
            }
            TBHighPerformanceDWInstance tBHighPerformanceDWInstance = this.mHigDWInstance;
            if (tBHighPerformanceDWInstance != null) {
                tBHighPerformanceDWInstance.seekTo(i);
            }
        }
    }

    @Override // android.taobao.windvane.embed.BaseEmbedView
    public void onVisibilityChanged(int i) {
        super.onVisibilityChanged(i);
    }

    public void setAutoPlay(boolean z, boolean z2) {
        this.mAutoPlay = z;
    }

    public void setBackCoverDisPlay(boolean z, boolean z2) {
        this.mBackCoverDisPlay = z;
    }

    public void setContentId(String str, boolean z) {
        this.mContentId = str;
    }

    public void setContentMode(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            str.hashCode();
            switch (str) {
                case "aspectFit":
                    this.mAspectRatio = DWAspectRatio.DW_FIT_CENTER;
                    this.mPosterScaleType = ImageView.ScaleType.FIT_CENTER;
                    break;
                case "fill":
                    this.mAspectRatio = DWAspectRatio.DW_FIT_X_Y;
                    this.mPosterScaleType = ImageView.ScaleType.FIT_XY;
                    break;
                case "aspectFill":
                    this.mAspectRatio = DWAspectRatio.DW_CENTER_CROP;
                    this.mPosterScaleType = ImageView.ScaleType.CENTER_CROP;
                    break;
            }
        }
        this.mContentMode = str;
    }

    public void setControlsViewHidden(boolean z, boolean z2) {
        this.mControlsViewHidden = z;
    }

    public void setDWInstanceType(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        for (DWInstanceType dWInstanceType : DWInstanceType.values()) {
            if (dWInstanceType != null && str.equals(dWInstanceType.getValue())) {
                this.mDWInstanceType = dWInstanceType;
            }
        }
        TBHighPerformanceDWInstance tBHighPerformanceDWInstance = this.mHigDWInstance;
        if (tBHighPerformanceDWInstance == null || !z) {
            return;
        }
        tBHighPerformanceDWInstance.setInstanceType(DWInstanceType.VIDEO.equals(this.mDWInstanceType) ? DWInstanceType.VIDEO : DWInstanceType.PIC);
    }

    public void setFrom(String str, boolean z) {
        this.mFrom = str;
    }

    public void setGestureViewHidden(boolean z, boolean z2) {
        this.mGestureViewHidden = z;
    }

    public void setHeight(int i, boolean z) {
        this.mHeight = i;
        if (z) {
            TBDWInstance tBDWInstance = this.mTBDWInstance;
            if (tBDWInstance != null) {
                tBDWInstance.setFrame(this.mWidth, i);
                return;
            }
            TBHighPerformanceDWInstance tBHighPerformanceDWInstance = this.mHigDWInstance;
            if (tBHighPerformanceDWInstance != null) {
                tBHighPerformanceDWInstance.setFrame(this.mWidth, i);
            }
        }
    }

    public void setInteractiveHidden(boolean z, boolean z2) {
        TBDWInstance tBDWInstance;
        boolean z3 = !z;
        this.mShowInteractive = z3;
        if (!this.mInit || this.mHasDisappear || (tBDWInstance = this.mTBDWInstance) == null) {
            return;
        }
        tBDWInstance.showOrHideInteractive(z3);
    }

    public void setInteractiveId(long j, boolean z) {
        this.mInteractiveId = j;
    }

    public void setIsVideoLoop(boolean z, boolean z2) {
        this.mIsVideoLoop = z;
    }

    public void setLoadingHidden(boolean z, boolean z2) {
        this.mLoadingHidden = z;
    }

    public void setMiniProgressViewHidden(boolean z, boolean z2) {
        this.mMiniProgressViewHidden = z;
    }

    public void setMuted(boolean z, boolean z2) {
        TBDWInstance tBDWInstance;
        this.mMuted = z;
        if (!z2 || (tBDWInstance = this.mTBDWInstance) == null) {
            return;
        }
        tBDWInstance.mute(z);
    }

    public void setNetworkErrorViewHidden(boolean z, boolean z2) {
        this.mNetworkErrorViewHidden = z;
    }

    public void setPlayControl(String str, boolean z) {
        this.mPlayControl = str;
        if (!z || this.mTBDWInstance == null) {
            return;
        }
        this.mHasPlay = true;
        if (!"play".equals(str)) {
            if ("pause".equals(str)) {
                this.mTBDWInstance.pauseVideo();
            }
        } else if (this.mTBDWInstance.getVideoState() != 0 && this.mTBDWInstance.getVideoState() != 5 && this.mTBDWInstance.getVideoState() != 8 && this.mTBDWInstance.getVideoState() != 4) {
            this.mTBDWInstance.playVideo();
        } else {
            this.mStarted = true;
            this.mTBDWInstance.start();
        }
    }

    public void setPlayErrorViewHidden(boolean z, boolean z2) {
        this.mPlayErrorViewHidden = z;
    }

    public void setPlayerScene(String str, boolean z) {
        this.mPlayerScene = str;
    }

    public void setPlayingIconHidden(boolean z, boolean z2) {
        this.mPlayingIconHidden = z;
    }

    public void setPreLoad(String str, boolean z) {
        this.mPreload = str;
    }

    public void setScreenMode(String str, boolean z) {
        this.mScreenMode = str;
        if (!z || TextUtils.isEmpty(str) || this.mTBDWInstance == null) {
            return;
        }
        str.hashCode();
        switch (str) {
            case "smallScreen":
                if (!this.mTBDWInstance.isFullScreen() && !this.mTBDWInstance.isSmallWindow()) {
                    this.mTBDWInstance.toSmall();
                    break;
                }
                break;
            case "fullScreen":
                if (!this.mTBDWInstance.isFullScreen()) {
                    this.mTBDWInstance.toggleScreen();
                    break;
                }
                break;
            case "inlineScreen":
                if (!this.mTBDWInstance.isFullScreen()) {
                    if (this.mTBDWInstance.isSmallWindow()) {
                        this.mTBDWInstance.toNormal();
                        break;
                    }
                } else {
                    this.mTBDWInstance.toggleScreen();
                    break;
                }
                break;
        }
    }

    public void setShownMuteBtn(boolean z, boolean z2) {
        this.mShownMuteBtn = z;
    }

    public void setSrc(String str, boolean z) {
        this.mSrc = str;
    }

    public void setThumbnailSrc(String str, boolean z) {
        this.mThumbnailSrc = str;
    }

    public void setToastViewHidden(boolean z, boolean z2) {
        this.mToastViewHidden = z;
    }

    public void setUserId(long j, boolean z) {
        this.mUserId = j;
    }

    public void setUtParams(HashMap<String, String> hashMap, boolean z) {
        this.utParams = hashMap;
    }

    public void setVideoId(String str, boolean z) {
        this.mVideoId = str;
    }

    public void setVideoSource(String str, boolean z) {
        this.mVideoSource = str;
    }

    public void setWidth(int i, boolean z) {
        this.mWidth = i;
        if (z) {
            TBDWInstance tBDWInstance = this.mTBDWInstance;
            if (tBDWInstance != null) {
                tBDWInstance.setFrame(i, this.mHeight);
                return;
            }
            TBHighPerformanceDWInstance tBHighPerformanceDWInstance = this.mHigDWInstance;
            if (tBHighPerformanceDWInstance != null) {
                tBHighPerformanceDWInstance.setFrame(i, this.mHeight);
            }
        }
    }
}
