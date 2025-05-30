package android.taobao.windvane.extra.embed.video;

import android.content.Context;
import android.taobao.windvane.embed.BaseEmbedView;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.service.WVEventId;
import android.taobao.windvane.urlintercept.WVURLRuleConstants;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.taobao.mediaplay.MediaPlayCenter;
import com.taobao.mediaplay.MediaPlayScreenType;
import com.taobao.mediaplay.MediaType;
import com.taobao.mediaplay.player.IMediaPlayLifecycleListener;
import com.taobao.mediaplay.player.MediaAspectRatio;
import java.util.HashMap;
import tv.danmaku.ijk.media.player.IMediaPlayer;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class MyTBLiveEmbedView extends BaseEmbedView implements IMediaPlayLifecycleListener {
    private static final String Event_State = "changeState";
    private static final String Event_error = "error";
    private static String FIRST_FRAME = "2006";
    private static String LOADING = "2007";
    public static final String NAME = "wvlivevideo";
    private static String PAUSED = "2005";
    private static String PLAYING = "2004";
    private Context mContext;
    private MediaPlayCenter mMediaPlayCenter;
    private FrameLayout mComponentHostView = null;
    private String mSrc = null;
    private int mScenarioType = 0;
    private MediaType mMediaType = MediaType.LIVE;
    private boolean mAutoPlay = false;
    private boolean mMuted = false;
    private MediaAspectRatio mObjectFit = MediaAspectRatio.DW_CENTER_CROP;
    private String mBizCode = null;
    private String mSubBizCode = null;
    private String mFeedId = null;
    boolean mUsePlayerManager = false;
    private int mWidth = 0;
    private int mHeight = 0;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: Taobao */
    private static class EmbedProperties {
        private static final /* synthetic */ EmbedProperties[] $VALUES;
        public static final EmbedProperties autoplay;
        public static final EmbedProperties bizCode;
        public static final EmbedProperties feedId;
        public static final EmbedProperties muted;
        public static final EmbedProperties objectFit;
        public static final EmbedProperties scenarioType;
        public static final EmbedProperties src;
        public static final EmbedProperties subBizCode;
        public static final EmbedProperties usePlayerManager;

        static {
            EmbedProperties embedProperties = new 1("src", 0);
            src = embedProperties;
            EmbedProperties embedProperties2 = new 2("muted", 1);
            muted = embedProperties2;
            EmbedProperties embedProperties3 = new 3("autoplay", 2);
            autoplay = embedProperties3;
            EmbedProperties embedProperties4 = new 4("scenarioType", 3);
            scenarioType = embedProperties4;
            EmbedProperties embedProperties5 = new 5("objectFit", 4);
            objectFit = embedProperties5;
            EmbedProperties embedProperties6 = new 6("bizCode", 5);
            bizCode = embedProperties6;
            EmbedProperties embedProperties7 = new 7("subBizCode", 6);
            subBizCode = embedProperties7;
            EmbedProperties embedProperties8 = new 8("feedId", 7);
            feedId = embedProperties8;
            EmbedProperties embedProperties9 = new 9("usePlayerManager", 8);
            usePlayerManager = embedProperties9;
            $VALUES = new EmbedProperties[]{embedProperties, embedProperties2, embedProperties3, embedProperties4, embedProperties5, embedProperties6, embedProperties7, embedProperties8, embedProperties9};
        }

        private EmbedProperties(String str, int i) {
        }

        public static EmbedProperties valueOf(String str) {
            return (EmbedProperties) Enum.valueOf(EmbedProperties.class, str);
        }

        public static EmbedProperties[] values() {
            return (EmbedProperties[]) $VALUES.clone();
        }

        public boolean setValue(MyTBLiveEmbedView myTBLiveEmbedView, Object obj, boolean z) {
            return (obj == null || myTBLiveEmbedView == null) ? false : true;
        }
    }

    /* compiled from: Taobao */
    private enum JSMethod {
        setMuted { // from class: android.taobao.windvane.extra.embed.video.MyTBLiveEmbedView.JSMethod.1
            @Override // android.taobao.windvane.extra.embed.video.MyTBLiveEmbedView.JSMethod
            public boolean doSomething(MyTBLiveEmbedView myTBLiveEmbedView, String str, WVCallBackContext wVCallBackContext) {
                JSONObject parseObject;
                if (TextUtils.isEmpty(str) || (parseObject = JSON.parseObject(str)) == null) {
                    return true;
                }
                myTBLiveEmbedView.mute(Boolean.TRUE.equals(parseObject.getBoolean("muted")));
                if (wVCallBackContext == null) {
                    return true;
                }
                wVCallBackContext.success();
                return true;
            }
        },
        play { // from class: android.taobao.windvane.extra.embed.video.MyTBLiveEmbedView.JSMethod.2
            @Override // android.taobao.windvane.extra.embed.video.MyTBLiveEmbedView.JSMethod
            public boolean doSomething(MyTBLiveEmbedView myTBLiveEmbedView, String str, WVCallBackContext wVCallBackContext) {
                if (!super.doSomething(myTBLiveEmbedView, str, wVCallBackContext) && wVCallBackContext != null) {
                    wVCallBackContext.error();
                }
                myTBLiveEmbedView.play();
                if (wVCallBackContext == null) {
                    return true;
                }
                wVCallBackContext.success();
                return true;
            }
        },
        pause { // from class: android.taobao.windvane.extra.embed.video.MyTBLiveEmbedView.JSMethod.3
            @Override // android.taobao.windvane.extra.embed.video.MyTBLiveEmbedView.JSMethod
            public boolean doSomething(MyTBLiveEmbedView myTBLiveEmbedView, String str, WVCallBackContext wVCallBackContext) {
                if (!super.doSomething(myTBLiveEmbedView, str, wVCallBackContext) && wVCallBackContext != null) {
                    wVCallBackContext.error();
                }
                myTBLiveEmbedView.pause();
                if (wVCallBackContext == null) {
                    return true;
                }
                wVCallBackContext.success();
                return true;
            }
        },
        seekTo { // from class: android.taobao.windvane.extra.embed.video.MyTBLiveEmbedView.JSMethod.4
            @Override // android.taobao.windvane.extra.embed.video.MyTBLiveEmbedView.JSMethod
            public boolean doSomething(MyTBLiveEmbedView myTBLiveEmbedView, String str, WVCallBackContext wVCallBackContext) {
                JSONObject parseObject;
                if (!super.doSomething(myTBLiveEmbedView, str, wVCallBackContext) && wVCallBackContext != null) {
                    wVCallBackContext.error();
                }
                boolean z = false;
                if (!TextUtils.isEmpty(str) && (parseObject = JSON.parseObject(str)) != null) {
                    try {
                        myTBLiveEmbedView.seekTo(Integer.parseInt(parseObject.getString("time")) * WVURLRuleConstants.LOGIN);
                        z = true;
                    } catch (Throwable unused) {
                    }
                }
                if (z && wVCallBackContext != null) {
                    wVCallBackContext.success();
                }
                return true;
            }
        };

        public boolean doSomething(MyTBLiveEmbedView myTBLiveEmbedView, String str, WVCallBackContext wVCallBackContext) {
            return (TextUtils.isEmpty(str) || wVCallBackContext == null) ? false : true;
        }
    }

    private synchronized void destroyInner() {
        if (this.mMediaPlayCenter == null) {
            return;
        }
        try {
            log("Embed Video destroy");
            this.mMediaPlayCenter.release();
            this.mMediaPlayCenter.destroy();
            this.mMediaPlayCenter = null;
        } catch (Throwable unused) {
        }
    }

    private void fireEvent(String str, Object obj) {
        log("firent " + str + ":" + String.valueOf(obj));
        HashMap hashMap = new HashMap(1);
        hashMap.put("code", obj);
        EmbedViewEvent.firevent(this.webView, this.id, str, JSON.toJSONString(hashMap));
    }

    private View genVideoView() {
        if (this.mComponentHostView == null) {
            this.mComponentHostView = new 1(this, this.mContext);
        }
        MediaPlayCenter mediaPlayCenter = new MediaPlayCenter(this.mContext);
        this.mMediaPlayCenter = mediaPlayCenter;
        mediaPlayCenter.setMediaUrl(this.mSrc);
        this.mMediaPlayCenter.setScenarioType(this.mScenarioType);
        this.mMediaPlayCenter.setMediaType(this.mMediaType);
        this.mMediaPlayCenter.setMute(this.mMuted);
        MediaAspectRatio mediaAspectRatio = this.mObjectFit;
        if (mediaAspectRatio != null) {
            this.mMediaPlayCenter.setMediaAspectRatio(mediaAspectRatio);
        }
        if (!TextUtils.isEmpty(this.mBizCode)) {
            this.mMediaPlayCenter.setBusinessId(this.mBizCode);
        }
        if (!TextUtils.isEmpty(this.mSubBizCode)) {
            this.mMediaPlayCenter.setBizCode(this.mSubBizCode);
        }
        if (!TextUtils.isEmpty(this.mFeedId)) {
            this.mMediaPlayCenter.setMediaId(this.mFeedId);
        }
        this.mMediaPlayCenter.setConfigGroup("MediaLive");
        this.mMediaPlayCenter.hideController();
        this.mMediaPlayCenter.setNeedPlayControlView(false);
        this.mMediaPlayCenter.setMediaLifecycleListener(this);
        this.mMediaPlayCenter.setPlayerType(3);
        this.mMediaPlayCenter.setup();
        this.mComponentHostView.addView(this.mMediaPlayCenter.getView(), this.mWidth, this.mHeight);
        if (this.mAutoPlay) {
            fireEvent(Event_State, LOADING);
            this.mMediaPlayCenter.start();
        }
        log("init EmbedLive View");
        return this.mComponentHostView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mute(boolean z) {
        MediaPlayCenter mediaPlayCenter = this.mMediaPlayCenter;
        if (mediaPlayCenter != null) {
            mediaPlayCenter.mute(z);
        }
    }

    private void parseParam() {
        setWidth(this.params.mWidth, false);
        setHeight(this.params.mHeight, false);
        for (EmbedProperties embedProperties : EmbedProperties.values()) {
            Object obj = this.params.mObjectParam.get(embedProperties.name());
            if (obj != null) {
                embedProperties.setValue(this, obj, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pause() {
        MediaPlayCenter mediaPlayCenter = this.mMediaPlayCenter;
        if (mediaPlayCenter == null) {
            return;
        }
        if (this.mScenarioType >= 2) {
            mediaPlayCenter.pause();
        } else {
            mediaPlayCenter.release();
            fireEvent(Event_State, PAUSED);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void play() {
        MediaPlayCenter mediaPlayCenter = this.mMediaPlayCenter;
        if (mediaPlayCenter == null) {
            return;
        }
        if (this.mScenarioType < 2) {
            mediaPlayCenter.setup();
            fireEvent(Event_State, Integer.valueOf(WVEventId.PAGE_onCloseWindow));
        }
        this.mMediaPlayCenter.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void seekTo(int i) {
        MediaPlayCenter mediaPlayCenter = this.mMediaPlayCenter;
        if (mediaPlayCenter != null) {
            mediaPlayCenter.seekTo(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAutoPlay(boolean z) {
        this.mAutoPlay = z;
    }

    private void setHeight(int i, boolean z) {
        this.mHeight = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMuted(boolean z, boolean z2) {
        MediaPlayCenter mediaPlayCenter;
        this.mMuted = z;
        if (!z2 || (mediaPlayCenter = this.mMediaPlayCenter) == null) {
            return;
        }
        mediaPlayCenter.setMute(z);
        this.mMediaPlayCenter.mute(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSrc(String str) {
        this.mSrc = str;
    }

    private void setWidth(int i, boolean z) {
        this.mWidth = i;
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
        this.mContext = context;
        parseParam();
        return genVideoView();
    }

    @Override // android.taobao.windvane.embed.BaseEmbedView
    protected String getViewType() {
        return NAME;
    }

    void log(String str) {
        Log.d(NAME, str);
    }

    @Override // android.taobao.windvane.embed.BaseEmbedView
    public void onDestroy() {
        super.onDestroy();
        destroyInner();
    }

    public void onMediaClose() {
    }

    public void onMediaComplete() {
    }

    public void onMediaError(IMediaPlayer iMediaPlayer, int i, int i2) {
        fireEvent(Event_error, Integer.valueOf((-400 <= i || i <= -500) ? (-500 < i || i <= -600) ? i == -5 ? WVEventId.PAGE_InterceptRequestWithHeaders : (i == -10006 || i == -10000) ? WVEventId.PAGE_onResume : 1023 : 1111 : 1110));
    }

    public void onMediaInfo(IMediaPlayer iMediaPlayer, long j, long j2, long j3, Object obj) {
        if (j == 3) {
            fireEvent(Event_State, FIRST_FRAME);
        }
    }

    public void onMediaPause(boolean z) {
        fireEvent(Event_State, PAUSED);
    }

    public void onMediaPlay() {
        fireEvent(Event_State, PLAYING);
    }

    public void onMediaPrepared(IMediaPlayer iMediaPlayer) {
    }

    public void onMediaProgressChanged(int i, int i2, int i3) {
    }

    public void onMediaScreenChanged(MediaPlayScreenType mediaPlayScreenType) {
    }

    public void onMediaSeekTo(int i) {
    }

    public void onMediaStart() {
        fireEvent(Event_State, PLAYING);
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
        log("onParamChanged key:" + str + " Value : " + String.valueOf(str2));
        embedProperties.setValue(this, str2, true);
    }

    public void onPause() {
        super.onPause();
    }

    public void onResume() {
        super.onResume();
    }

    public void setBizCode(String str) {
        this.mBizCode = str;
    }

    public void setFeedId(String str) {
        this.mFeedId = str;
    }

    public void setObjectFit(String str) {
        if (TextUtils.equals(str, "fill")) {
            this.mObjectFit = MediaAspectRatio.DW_CENTER_CROP;
        } else {
            this.mObjectFit = MediaAspectRatio.DW_FIT_CENTER;
        }
    }

    public void setScenarioType(int i) {
        this.mScenarioType = i;
    }

    public void setSubBizCode(String str) {
        this.mSubBizCode = str;
    }

    public void setUsePlayerManager(boolean z) {
        this.mUsePlayerManager = z;
    }
}
