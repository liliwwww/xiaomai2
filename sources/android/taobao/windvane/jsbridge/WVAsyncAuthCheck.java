package android.taobao.windvane.jsbridge;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface WVAsyncAuthCheck {

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public interface AsyncAuthCheckCallBack {
        void callBackFail(String str, WVCallMethodContext wVCallMethodContext);

        void callBackSuccess(String str, WVCallMethodContext wVCallMethodContext);
    }

    boolean AsyncapiAuthCheck(String str, WVCallMethodContext wVCallMethodContext, AsyncAuthCheckCallBack asyncAuthCheckCallBack);
}
