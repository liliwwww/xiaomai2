package android.taobao.windvane.extra.embed.video;

import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: private */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class MyTBVideoEmbedView$EmbedProperties {
    private static final /* synthetic */ MyTBVideoEmbedView$EmbedProperties[] $VALUES;
    public static final MyTBVideoEmbedView$EmbedProperties autoplay;
    public static final MyTBVideoEmbedView$EmbedProperties backCoverDisplay;
    public static final MyTBVideoEmbedView$EmbedProperties contentId;
    public static final MyTBVideoEmbedView$EmbedProperties contentMode;
    public static final MyTBVideoEmbedView$EmbedProperties controlsViewHidden;
    public static final MyTBVideoEmbedView$EmbedProperties from;
    public static final MyTBVideoEmbedView$EmbedProperties gestureViewHidden;
    public static final MyTBVideoEmbedView$EmbedProperties instanceType;
    public static final MyTBVideoEmbedView$EmbedProperties interactiveHidden;
    public static final MyTBVideoEmbedView$EmbedProperties interactiveId;
    public static final MyTBVideoEmbedView$EmbedProperties loadingHidden;
    public static final MyTBVideoEmbedView$EmbedProperties loop;
    public static final MyTBVideoEmbedView$EmbedProperties miniProgressViewHidden;
    public static final MyTBVideoEmbedView$EmbedProperties muted;
    public static final MyTBVideoEmbedView$EmbedProperties networkErrorViewHidden;
    public static final MyTBVideoEmbedView$EmbedProperties playControl;
    public static final MyTBVideoEmbedView$EmbedProperties playErrorViewHidden;
    public static final MyTBVideoEmbedView$EmbedProperties playerScene;
    public static final MyTBVideoEmbedView$EmbedProperties playingIconHidden;
    public static final MyTBVideoEmbedView$EmbedProperties poster;
    public static final MyTBVideoEmbedView$EmbedProperties preload;
    public static final MyTBVideoEmbedView$EmbedProperties setHeight;
    public static final MyTBVideoEmbedView$EmbedProperties setWidth;
    public static final MyTBVideoEmbedView$EmbedProperties shownMuteBtn;
    public static final MyTBVideoEmbedView$EmbedProperties src;
    public static final MyTBVideoEmbedView$EmbedProperties thumbnailSrc;
    public static final MyTBVideoEmbedView$EmbedProperties toastViewHidden;
    public static final MyTBVideoEmbedView$EmbedProperties userId;
    public static final MyTBVideoEmbedView$EmbedProperties utParams;
    public static final MyTBVideoEmbedView$EmbedProperties videoId;
    public static final MyTBVideoEmbedView$EmbedProperties videoSource;

    static {
        MyTBVideoEmbedView$EmbedProperties myTBVideoEmbedView$EmbedProperties = new 1("playerScene", 0);
        playerScene = myTBVideoEmbedView$EmbedProperties;
        MyTBVideoEmbedView$EmbedProperties myTBVideoEmbedView$EmbedProperties2 = new 2("instanceType", 1);
        instanceType = myTBVideoEmbedView$EmbedProperties2;
        MyTBVideoEmbedView$EmbedProperties myTBVideoEmbedView$EmbedProperties3 = new 3("src", 2);
        src = myTBVideoEmbedView$EmbedProperties3;
        MyTBVideoEmbedView$EmbedProperties myTBVideoEmbedView$EmbedProperties4 = new 4("loop", 3);
        loop = myTBVideoEmbedView$EmbedProperties4;
        MyTBVideoEmbedView$EmbedProperties myTBVideoEmbedView$EmbedProperties5 = new 5("autoplay", 4);
        autoplay = myTBVideoEmbedView$EmbedProperties5;
        MyTBVideoEmbedView$EmbedProperties myTBVideoEmbedView$EmbedProperties6 = new 6("thumbnailSrc", 5);
        thumbnailSrc = myTBVideoEmbedView$EmbedProperties6;
        MyTBVideoEmbedView$EmbedProperties myTBVideoEmbedView$EmbedProperties7 = new 7("poster", 6);
        poster = myTBVideoEmbedView$EmbedProperties7;
        MyTBVideoEmbedView$EmbedProperties myTBVideoEmbedView$EmbedProperties8 = new 8("interactiveHidden", 7);
        interactiveHidden = myTBVideoEmbedView$EmbedProperties8;
        MyTBVideoEmbedView$EmbedProperties myTBVideoEmbedView$EmbedProperties9 = new MyTBVideoEmbedView$EmbedProperties("contentId", 8) { // from class: android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView$EmbedProperties.9
            {
                MyTBVideoEmbedView$1 myTBVideoEmbedView$1 = null;
            }

            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView$EmbedProperties
            public boolean setValue(MyTBVideoEmbedView myTBVideoEmbedView, Object obj, boolean z) {
                if (!super.setValue(myTBVideoEmbedView, obj, z)) {
                    return true;
                }
                myTBVideoEmbedView.setContentId(String.valueOf(obj), z);
                return true;
            }
        };
        contentId = myTBVideoEmbedView$EmbedProperties9;
        MyTBVideoEmbedView$EmbedProperties myTBVideoEmbedView$EmbedProperties10 = new MyTBVideoEmbedView$EmbedProperties("backCoverDisplay", 9) { // from class: android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView$EmbedProperties.10
            {
                MyTBVideoEmbedView$1 myTBVideoEmbedView$1 = null;
            }

            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView$EmbedProperties
            public boolean setValue(MyTBVideoEmbedView myTBVideoEmbedView, Object obj, boolean z) {
                if (!super.setValue(myTBVideoEmbedView, obj, z)) {
                    return true;
                }
                myTBVideoEmbedView.setBackCoverDisPlay(toBoolean(obj), z);
                return true;
            }
        };
        backCoverDisplay = myTBVideoEmbedView$EmbedProperties10;
        MyTBVideoEmbedView$EmbedProperties myTBVideoEmbedView$EmbedProperties11 = new MyTBVideoEmbedView$EmbedProperties("muted", 10) { // from class: android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView$EmbedProperties.11
            {
                MyTBVideoEmbedView$1 myTBVideoEmbedView$1 = null;
            }

            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView$EmbedProperties
            public boolean setValue(MyTBVideoEmbedView myTBVideoEmbedView, Object obj, boolean z) {
                if (!super.setValue(myTBVideoEmbedView, obj, z)) {
                    return true;
                }
                myTBVideoEmbedView.setMuted(toBoolean(obj), z);
                return true;
            }
        };
        muted = myTBVideoEmbedView$EmbedProperties11;
        MyTBVideoEmbedView$EmbedProperties myTBVideoEmbedView$EmbedProperties12 = new MyTBVideoEmbedView$EmbedProperties("preload", 11) { // from class: android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView$EmbedProperties.12
            {
                MyTBVideoEmbedView$1 myTBVideoEmbedView$1 = null;
            }

            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView$EmbedProperties
            public boolean setValue(MyTBVideoEmbedView myTBVideoEmbedView, Object obj, boolean z) {
                if (!super.setValue(myTBVideoEmbedView, obj, z)) {
                    return true;
                }
                myTBVideoEmbedView.setPreLoad(String.valueOf(obj), z);
                return true;
            }
        };
        preload = myTBVideoEmbedView$EmbedProperties12;
        MyTBVideoEmbedView$EmbedProperties myTBVideoEmbedView$EmbedProperties13 = new MyTBVideoEmbedView$EmbedProperties("videoSource", 12) { // from class: android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView$EmbedProperties.13
            {
                MyTBVideoEmbedView$1 myTBVideoEmbedView$1 = null;
            }

            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView$EmbedProperties
            public boolean setValue(MyTBVideoEmbedView myTBVideoEmbedView, Object obj, boolean z) {
                if (!super.setValue(myTBVideoEmbedView, obj, z)) {
                    return true;
                }
                myTBVideoEmbedView.setVideoSource(String.valueOf(obj), z);
                return true;
            }
        };
        videoSource = myTBVideoEmbedView$EmbedProperties13;
        MyTBVideoEmbedView$EmbedProperties myTBVideoEmbedView$EmbedProperties14 = new MyTBVideoEmbedView$EmbedProperties("videoId", 13) { // from class: android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView$EmbedProperties.14
            {
                MyTBVideoEmbedView$1 myTBVideoEmbedView$1 = null;
            }

            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView$EmbedProperties
            public boolean setValue(MyTBVideoEmbedView myTBVideoEmbedView, Object obj, boolean z) {
                if (!super.setValue(myTBVideoEmbedView, obj, z)) {
                    return true;
                }
                myTBVideoEmbedView.setVideoId(String.valueOf(obj), z);
                return true;
            }
        };
        videoId = myTBVideoEmbedView$EmbedProperties14;
        MyTBVideoEmbedView$EmbedProperties myTBVideoEmbedView$EmbedProperties15 = new MyTBVideoEmbedView$EmbedProperties("from", 14) { // from class: android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView$EmbedProperties.15
            {
                MyTBVideoEmbedView$1 myTBVideoEmbedView$1 = null;
            }

            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView$EmbedProperties
            public boolean setValue(MyTBVideoEmbedView myTBVideoEmbedView, Object obj, boolean z) {
                if (!super.setValue(myTBVideoEmbedView, obj, z)) {
                    return true;
                }
                myTBVideoEmbedView.setFrom(String.valueOf(obj), z);
                return true;
            }
        };
        from = myTBVideoEmbedView$EmbedProperties15;
        MyTBVideoEmbedView$EmbedProperties myTBVideoEmbedView$EmbedProperties16 = new MyTBVideoEmbedView$EmbedProperties("utParams", 15) { // from class: android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView$EmbedProperties.16
            {
                MyTBVideoEmbedView$1 myTBVideoEmbedView$1 = null;
            }

            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView$EmbedProperties
            public boolean setValue(MyTBVideoEmbedView myTBVideoEmbedView, Object obj, boolean z) {
                if (!super.setValue(myTBVideoEmbedView, obj, z)) {
                    return true;
                }
                myTBVideoEmbedView.setUtParams(new HashMap(), z);
                return true;
            }
        };
        utParams = myTBVideoEmbedView$EmbedProperties16;
        MyTBVideoEmbedView$EmbedProperties myTBVideoEmbedView$EmbedProperties17 = new MyTBVideoEmbedView$EmbedProperties("playControl", 16) { // from class: android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView$EmbedProperties.17
            {
                MyTBVideoEmbedView$1 myTBVideoEmbedView$1 = null;
            }

            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView$EmbedProperties
            public boolean setValue(MyTBVideoEmbedView myTBVideoEmbedView, Object obj, boolean z) {
                if (!super.setValue(myTBVideoEmbedView, obj, z)) {
                    return true;
                }
                myTBVideoEmbedView.setPlayControl(String.valueOf(obj), z);
                return true;
            }
        };
        playControl = myTBVideoEmbedView$EmbedProperties17;
        MyTBVideoEmbedView$EmbedProperties myTBVideoEmbedView$EmbedProperties18 = new MyTBVideoEmbedView$EmbedProperties("contentMode", 17) { // from class: android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView$EmbedProperties.18
            {
                MyTBVideoEmbedView$1 myTBVideoEmbedView$1 = null;
            }

            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView$EmbedProperties
            public boolean setValue(MyTBVideoEmbedView myTBVideoEmbedView, Object obj, boolean z) {
                if (!super.setValue(myTBVideoEmbedView, obj, z)) {
                    return true;
                }
                myTBVideoEmbedView.setContentMode(String.valueOf(obj), z);
                return true;
            }
        };
        contentMode = myTBVideoEmbedView$EmbedProperties18;
        MyTBVideoEmbedView$EmbedProperties myTBVideoEmbedView$EmbedProperties19 = new MyTBVideoEmbedView$EmbedProperties("interactiveId", 18) { // from class: android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView$EmbedProperties.19
            {
                MyTBVideoEmbedView$1 myTBVideoEmbedView$1 = null;
            }

            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView$EmbedProperties
            public boolean setValue(MyTBVideoEmbedView myTBVideoEmbedView, Object obj, boolean z) {
                if (!super.setValue(myTBVideoEmbedView, obj, z)) {
                    return true;
                }
                myTBVideoEmbedView.setInteractiveId(toLong(obj), z);
                return true;
            }
        };
        interactiveId = myTBVideoEmbedView$EmbedProperties19;
        MyTBVideoEmbedView$EmbedProperties myTBVideoEmbedView$EmbedProperties20 = new MyTBVideoEmbedView$EmbedProperties("userId", 19) { // from class: android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView$EmbedProperties.20
            {
                MyTBVideoEmbedView$1 myTBVideoEmbedView$1 = null;
            }

            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView$EmbedProperties
            public boolean setValue(MyTBVideoEmbedView myTBVideoEmbedView, Object obj, boolean z) {
                if (!super.setValue(myTBVideoEmbedView, obj, z)) {
                    return true;
                }
                myTBVideoEmbedView.setUserId(toLong(obj), z);
                return true;
            }
        };
        userId = myTBVideoEmbedView$EmbedProperties20;
        MyTBVideoEmbedView$EmbedProperties myTBVideoEmbedView$EmbedProperties21 = new MyTBVideoEmbedView$EmbedProperties("miniProgressViewHidden", 20) { // from class: android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView$EmbedProperties.21
            {
                MyTBVideoEmbedView$1 myTBVideoEmbedView$1 = null;
            }

            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView$EmbedProperties
            public boolean setValue(MyTBVideoEmbedView myTBVideoEmbedView, Object obj, boolean z) {
                if (!super.setValue(myTBVideoEmbedView, obj, z)) {
                    return true;
                }
                myTBVideoEmbedView.setMiniProgressViewHidden(toBoolean(obj), z);
                return true;
            }
        };
        miniProgressViewHidden = myTBVideoEmbedView$EmbedProperties21;
        MyTBVideoEmbedView$EmbedProperties myTBVideoEmbedView$EmbedProperties22 = new MyTBVideoEmbedView$EmbedProperties("networkErrorViewHidden", 21) { // from class: android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView$EmbedProperties.22
            {
                MyTBVideoEmbedView$1 myTBVideoEmbedView$1 = null;
            }

            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView$EmbedProperties
            public boolean setValue(MyTBVideoEmbedView myTBVideoEmbedView, Object obj, boolean z) {
                if (!super.setValue(myTBVideoEmbedView, obj, z)) {
                    return true;
                }
                myTBVideoEmbedView.setNetworkErrorViewHidden(toBoolean(obj), z);
                return true;
            }
        };
        networkErrorViewHidden = myTBVideoEmbedView$EmbedProperties22;
        MyTBVideoEmbedView$EmbedProperties myTBVideoEmbedView$EmbedProperties23 = new MyTBVideoEmbedView$EmbedProperties("toastViewHidden", 22) { // from class: android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView$EmbedProperties.23
            {
                MyTBVideoEmbedView$1 myTBVideoEmbedView$1 = null;
            }

            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView$EmbedProperties
            public boolean setValue(MyTBVideoEmbedView myTBVideoEmbedView, Object obj, boolean z) {
                if (!super.setValue(myTBVideoEmbedView, obj, z)) {
                    return true;
                }
                myTBVideoEmbedView.setToastViewHidden(toBoolean(obj), z);
                return true;
            }
        };
        toastViewHidden = myTBVideoEmbedView$EmbedProperties23;
        MyTBVideoEmbedView$EmbedProperties myTBVideoEmbedView$EmbedProperties24 = new MyTBVideoEmbedView$EmbedProperties("playingIconHidden", 23) { // from class: android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView$EmbedProperties.24
            {
                MyTBVideoEmbedView$1 myTBVideoEmbedView$1 = null;
            }

            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView$EmbedProperties
            public boolean setValue(MyTBVideoEmbedView myTBVideoEmbedView, Object obj, boolean z) {
                if (!super.setValue(myTBVideoEmbedView, obj, z)) {
                    return true;
                }
                myTBVideoEmbedView.setPlayingIconHidden(toBoolean(obj), z);
                return true;
            }
        };
        playingIconHidden = myTBVideoEmbedView$EmbedProperties24;
        MyTBVideoEmbedView$EmbedProperties myTBVideoEmbedView$EmbedProperties25 = new MyTBVideoEmbedView$EmbedProperties("gestureViewHidden", 24) { // from class: android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView$EmbedProperties.25
            {
                MyTBVideoEmbedView$1 myTBVideoEmbedView$1 = null;
            }

            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView$EmbedProperties
            public boolean setValue(MyTBVideoEmbedView myTBVideoEmbedView, Object obj, boolean z) {
                if (!super.setValue(myTBVideoEmbedView, obj, z)) {
                    return true;
                }
                myTBVideoEmbedView.setGestureViewHidden(toBoolean(obj), z);
                return true;
            }
        };
        gestureViewHidden = myTBVideoEmbedView$EmbedProperties25;
        MyTBVideoEmbedView$EmbedProperties myTBVideoEmbedView$EmbedProperties26 = new MyTBVideoEmbedView$EmbedProperties("controlsViewHidden", 25) { // from class: android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView$EmbedProperties.26
            {
                MyTBVideoEmbedView$1 myTBVideoEmbedView$1 = null;
            }

            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView$EmbedProperties
            public boolean setValue(MyTBVideoEmbedView myTBVideoEmbedView, Object obj, boolean z) {
                if (!super.setValue(myTBVideoEmbedView, obj, z)) {
                    return true;
                }
                myTBVideoEmbedView.setControlsViewHidden(toBoolean(obj), z);
                return true;
            }
        };
        controlsViewHidden = myTBVideoEmbedView$EmbedProperties26;
        MyTBVideoEmbedView$EmbedProperties myTBVideoEmbedView$EmbedProperties27 = new MyTBVideoEmbedView$EmbedProperties("loadingHidden", 26) { // from class: android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView$EmbedProperties.27
            {
                MyTBVideoEmbedView$1 myTBVideoEmbedView$1 = null;
            }

            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView$EmbedProperties
            public boolean setValue(MyTBVideoEmbedView myTBVideoEmbedView, Object obj, boolean z) {
                if (!super.setValue(myTBVideoEmbedView, obj, z)) {
                    return true;
                }
                myTBVideoEmbedView.setLoadingHidden(toBoolean(obj), z);
                return true;
            }
        };
        loadingHidden = myTBVideoEmbedView$EmbedProperties27;
        MyTBVideoEmbedView$EmbedProperties myTBVideoEmbedView$EmbedProperties28 = new MyTBVideoEmbedView$EmbedProperties("playErrorViewHidden", 27) { // from class: android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView$EmbedProperties.28
            {
                MyTBVideoEmbedView$1 myTBVideoEmbedView$1 = null;
            }

            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView$EmbedProperties
            public boolean setValue(MyTBVideoEmbedView myTBVideoEmbedView, Object obj, boolean z) {
                if (!super.setValue(myTBVideoEmbedView, obj, z)) {
                    return true;
                }
                myTBVideoEmbedView.setPlayErrorViewHidden(toBoolean(obj), z);
                return true;
            }
        };
        playErrorViewHidden = myTBVideoEmbedView$EmbedProperties28;
        MyTBVideoEmbedView$EmbedProperties myTBVideoEmbedView$EmbedProperties29 = new MyTBVideoEmbedView$EmbedProperties("setWidth", 28) { // from class: android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView$EmbedProperties.29
            {
                MyTBVideoEmbedView$1 myTBVideoEmbedView$1 = null;
            }

            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView$EmbedProperties
            public boolean setValue(MyTBVideoEmbedView myTBVideoEmbedView, Object obj, boolean z) {
                if (super.setValue(myTBVideoEmbedView, obj, z)) {
                    myTBVideoEmbedView.setWidth((int) toLong(obj), true);
                }
                return true;
            }
        };
        setWidth = myTBVideoEmbedView$EmbedProperties29;
        MyTBVideoEmbedView$EmbedProperties myTBVideoEmbedView$EmbedProperties30 = new MyTBVideoEmbedView$EmbedProperties("setHeight", 29) { // from class: android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView$EmbedProperties.30
            {
                MyTBVideoEmbedView$1 myTBVideoEmbedView$1 = null;
            }

            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView$EmbedProperties
            public boolean setValue(MyTBVideoEmbedView myTBVideoEmbedView, Object obj, boolean z) {
                if (super.setValue(myTBVideoEmbedView, obj, z)) {
                    myTBVideoEmbedView.setHeight((int) toLong(obj), true);
                }
                return true;
            }
        };
        setHeight = myTBVideoEmbedView$EmbedProperties30;
        MyTBVideoEmbedView$EmbedProperties myTBVideoEmbedView$EmbedProperties31 = new MyTBVideoEmbedView$EmbedProperties("shownMuteBtn", 30) { // from class: android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView$EmbedProperties.31
            {
                MyTBVideoEmbedView$1 myTBVideoEmbedView$1 = null;
            }

            @Override // android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView$EmbedProperties
            public boolean setValue(MyTBVideoEmbedView myTBVideoEmbedView, Object obj, boolean z) {
                if (!super.setValue(myTBVideoEmbedView, obj, z)) {
                    return true;
                }
                myTBVideoEmbedView.setShownMuteBtn(toBoolean(obj), z);
                return true;
            }
        };
        shownMuteBtn = myTBVideoEmbedView$EmbedProperties31;
        $VALUES = new MyTBVideoEmbedView$EmbedProperties[]{myTBVideoEmbedView$EmbedProperties, myTBVideoEmbedView$EmbedProperties2, myTBVideoEmbedView$EmbedProperties3, myTBVideoEmbedView$EmbedProperties4, myTBVideoEmbedView$EmbedProperties5, myTBVideoEmbedView$EmbedProperties6, myTBVideoEmbedView$EmbedProperties7, myTBVideoEmbedView$EmbedProperties8, myTBVideoEmbedView$EmbedProperties9, myTBVideoEmbedView$EmbedProperties10, myTBVideoEmbedView$EmbedProperties11, myTBVideoEmbedView$EmbedProperties12, myTBVideoEmbedView$EmbedProperties13, myTBVideoEmbedView$EmbedProperties14, myTBVideoEmbedView$EmbedProperties15, myTBVideoEmbedView$EmbedProperties16, myTBVideoEmbedView$EmbedProperties17, myTBVideoEmbedView$EmbedProperties18, myTBVideoEmbedView$EmbedProperties19, myTBVideoEmbedView$EmbedProperties20, myTBVideoEmbedView$EmbedProperties21, myTBVideoEmbedView$EmbedProperties22, myTBVideoEmbedView$EmbedProperties23, myTBVideoEmbedView$EmbedProperties24, myTBVideoEmbedView$EmbedProperties25, myTBVideoEmbedView$EmbedProperties26, myTBVideoEmbedView$EmbedProperties27, myTBVideoEmbedView$EmbedProperties28, myTBVideoEmbedView$EmbedProperties29, myTBVideoEmbedView$EmbedProperties30, myTBVideoEmbedView$EmbedProperties31};
    }

    private MyTBVideoEmbedView$EmbedProperties(String str, int i) {
    }

    public static MyTBVideoEmbedView$EmbedProperties valueOf(String str) {
        return (MyTBVideoEmbedView$EmbedProperties) Enum.valueOf(MyTBVideoEmbedView$EmbedProperties.class, str);
    }

    public static MyTBVideoEmbedView$EmbedProperties[] values() {
        return (MyTBVideoEmbedView$EmbedProperties[]) $VALUES.clone();
    }

    public boolean setValue(MyTBVideoEmbedView myTBVideoEmbedView, Object obj, boolean z) {
        return (obj == null || myTBVideoEmbedView == null) ? false : true;
    }

    public boolean toBoolean(Object obj) {
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        String valueOf = String.valueOf(obj);
        return "true".equals(valueOf) || "1".equals(valueOf);
    }

    public long toLong(Object obj) {
        if (obj instanceof Long) {
            return ((Long) obj).longValue();
        }
        try {
            return Long.parseLong(String.valueOf(obj));
        } catch (Throwable unused) {
            return -1L;
        }
    }

    /* synthetic */ MyTBVideoEmbedView$EmbedProperties(String str, int i, MyTBVideoEmbedView$1 myTBVideoEmbedView$1) {
        this(str, i);
    }
}
