package androidx.renderscript;

import android.util.Log;
import androidx.renderscript.RenderScript;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class RenderScript$MessageThread extends Thread {
    static final int RS_ERROR_FATAL_UNKNOWN = 4096;
    static final int RS_MESSAGE_TO_CLIENT_ERROR = 3;
    static final int RS_MESSAGE_TO_CLIENT_EXCEPTION = 1;
    static final int RS_MESSAGE_TO_CLIENT_NONE = 0;
    static final int RS_MESSAGE_TO_CLIENT_RESIZE = 2;
    static final int RS_MESSAGE_TO_CLIENT_USER = 4;
    int[] mAuxData;
    RenderScript mRS;
    boolean mRun;

    RenderScript$MessageThread(RenderScript renderScript) {
        super("RSMessageThread");
        this.mRun = true;
        this.mAuxData = new int[2];
        this.mRS = renderScript;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        int[] iArr = new int[16];
        RenderScript renderScript = this.mRS;
        renderScript.nContextInitToClient(renderScript.mContext);
        while (this.mRun) {
            iArr[0] = 0;
            RenderScript renderScript2 = this.mRS;
            int nContextPeekMessage = renderScript2.nContextPeekMessage(renderScript2.mContext, this.mAuxData);
            int[] iArr2 = this.mAuxData;
            int i = iArr2[1];
            int i2 = iArr2[0];
            if (nContextPeekMessage == 4) {
                if ((i >> 2) >= iArr.length) {
                    iArr = new int[(i + 3) >> 2];
                }
                RenderScript renderScript3 = this.mRS;
                if (renderScript3.nContextGetUserMessage(renderScript3.mContext, iArr) != 4) {
                    throw new RSDriverException("Error processing message from RenderScript.");
                }
                RenderScript.RSMessageHandler rSMessageHandler = this.mRS.mMessageCallback;
                if (rSMessageHandler == null) {
                    throw new RSInvalidStateException("Received a message from the script with no message handler installed.");
                }
                rSMessageHandler.mData = iArr;
                rSMessageHandler.mID = i2;
                rSMessageHandler.mLength = i;
                rSMessageHandler.run();
            } else if (nContextPeekMessage == 3) {
                RenderScript renderScript4 = this.mRS;
                String nContextGetErrorMessage = renderScript4.nContextGetErrorMessage(renderScript4.mContext);
                if (i2 >= 4096) {
                    throw new RSRuntimeException("Fatal error " + i2 + ", details: " + nContextGetErrorMessage);
                }
                RenderScript.RSErrorHandler rSErrorHandler = this.mRS.mErrorCallback;
                if (rSErrorHandler != null) {
                    rSErrorHandler.mErrorMessage = nContextGetErrorMessage;
                    rSErrorHandler.mErrorNum = i2;
                    rSErrorHandler.run();
                } else {
                    Log.e("RenderScript_jni", "non fatal RS error, " + nContextGetErrorMessage);
                }
            } else {
                try {
                    Thread.sleep(1L, 0);
                } catch (InterruptedException unused) {
                }
            }
        }
    }
}
