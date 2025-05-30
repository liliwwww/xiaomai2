package android.taobao.windvane.util;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.taobao.windvane.connect.HttpConnectListener;
import android.taobao.windvane.connect.HttpResponse;
import android.taobao.windvane.util.ImageTool;
import java.io.ByteArrayInputStream;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class ImageTool$1 extends HttpConnectListener<HttpResponse> {
    final /* synthetic */ ImageTool.ImageSaveCallback val$callback;
    final /* synthetic */ Context val$context;

    ImageTool$1(Context context, ImageTool.ImageSaveCallback imageSaveCallback) {
        this.val$context = context;
        this.val$callback = imageSaveCallback;
    }

    @Override // android.taobao.windvane.connect.HttpConnectListener
    public void onError(int i, String str) {
        ImageTool.ImageSaveCallback imageSaveCallback = this.val$callback;
        if (imageSaveCallback != null) {
            imageSaveCallback.error("error get resource, code=[" + i + "],msg=[" + str + "]");
        }
    }

    @Override // android.taobao.windvane.connect.HttpConnectListener
    public void onFinish(HttpResponse httpResponse, int i) {
        try {
            if (httpResponse.isSuccess() && "mounted".equals(Environment.getExternalStorageState())) {
                if (ImageTool.saveImage(this.val$context, BitmapFactory.decodeStream(new ByteArrayInputStream(httpResponse.getData())))) {
                    ImageTool.ImageSaveCallback imageSaveCallback = this.val$callback;
                    if (imageSaveCallback != null) {
                        imageSaveCallback.success();
                        return;
                    }
                    return;
                }
            }
            ImageTool.ImageSaveCallback imageSaveCallback2 = this.val$callback;
            if (imageSaveCallback2 != null) {
                imageSaveCallback2.error("bad resource");
            }
        } catch (Exception e) {
            ImageTool.ImageSaveCallback imageSaveCallback3 = this.val$callback;
            if (imageSaveCallback3 != null) {
                imageSaveCallback3.error(e.getMessage());
            }
        } catch (OutOfMemoryError e2) {
            ImageTool.ImageSaveCallback imageSaveCallback4 = this.val$callback;
            if (imageSaveCallback4 != null) {
                imageSaveCallback4.error(e2.getMessage());
            }
        }
    }
}
