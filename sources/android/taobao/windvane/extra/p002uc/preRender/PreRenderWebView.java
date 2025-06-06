package android.taobao.windvane.extra.p002uc.preRender;

import android.content.Context;
import android.taobao.windvane.extra.p002uc.WVUCWebView;
import android.taobao.windvane.webview.IPreRenderWebView;
import android.text.TextUtils;
import android.util.AttributeSet;
import tb.zy3;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class PreRenderWebView extends WVUCWebView implements IPreRenderWebView {
    private long expireTime;
    public boolean isPreLoad;
    private boolean preRenderSuccess;
    private String realUrl;

    public PreRenderWebView(Context context) {
        super(context);
        this.isPreLoad = false;
        this.preRenderSuccess = false;
        this.expireTime = 0L;
        this.realUrl = null;
    }

    private String getAttachData() {
        if (TextUtils.isEmpty(this.realUrl)) {
            return "{}";
        }
        return "{ \"url\": \"" + this.realUrl + "\" }";
    }

    @Override // android.taobao.windvane.webview.IPreRenderWebView
    public long getExpireTime() {
        return this.expireTime;
    }

    @Override // android.taobao.windvane.webview.IPreRenderWebView
    public boolean isPreLoad() {
        return this.isPreLoad;
    }

    @Override // android.taobao.windvane.webview.IPreRenderWebView
    public boolean isPreRenderSuccess() {
        return this.preRenderSuccess;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.taobao.windvane.extra.p002uc.WVUCWebView
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.isPreLoad) {
            fireEvent(BasePreInitManager.ATTACH_EVENT, getAttachData());
            if (getUCExtension() != null) {
                post(new Runnable() { // from class: android.taobao.windvane.extra.uc.preRender.PreRenderWebView.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (PreRenderWebView.this.getUCExtension() != null) {
                            PreRenderWebView.this.getUCExtension().setIsPreRender(false);
                        }
                    }
                });
            }
            try {
                zy3.b.getProcedure(this).addProperty("H5_URL", getUrl());
            } catch (Throwable th) {
                th.printStackTrace();
            }
            this.isPreLoad = false;
        }
    }

    @Override // android.taobao.windvane.webview.IPreRenderWebView
    public void preRenderInit(String str) {
    }

    @Override // android.taobao.windvane.webview.IPreRenderWebView
    public void setExpireTime(long j) {
        this.expireTime = j;
    }

    @Override // android.taobao.windvane.webview.IPreRenderWebView
    public void setPreRenderSuccess(boolean z) {
        this.preRenderSuccess = z;
    }

    void setRealUrl(String str) {
        this.realUrl = str;
    }

    public PreRenderWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isPreLoad = false;
        this.preRenderSuccess = false;
        this.expireTime = 0L;
        this.realUrl = null;
    }

    public PreRenderWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isPreLoad = false;
        this.preRenderSuccess = false;
        this.expireTime = 0L;
        this.realUrl = null;
    }
}
