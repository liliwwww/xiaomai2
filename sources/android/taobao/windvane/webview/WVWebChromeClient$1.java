package android.taobao.windvane.webview;

import android.webkit.ConsoleMessage;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
/* synthetic */ class WVWebChromeClient$1 {
    static final /* synthetic */ int[] $SwitchMap$android$webkit$ConsoleMessage$MessageLevel;

    static {
        int[] iArr = new int[ConsoleMessage.MessageLevel.values().length];
        $SwitchMap$android$webkit$ConsoleMessage$MessageLevel = iArr;
        try {
            iArr[ConsoleMessage.MessageLevel.DEBUG.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            $SwitchMap$android$webkit$ConsoleMessage$MessageLevel[ConsoleMessage.MessageLevel.ERROR.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            $SwitchMap$android$webkit$ConsoleMessage$MessageLevel[ConsoleMessage.MessageLevel.WARNING.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            $SwitchMap$android$webkit$ConsoleMessage$MessageLevel[ConsoleMessage.MessageLevel.LOG.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            $SwitchMap$android$webkit$ConsoleMessage$MessageLevel[ConsoleMessage.MessageLevel.TIP.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
    }
}
