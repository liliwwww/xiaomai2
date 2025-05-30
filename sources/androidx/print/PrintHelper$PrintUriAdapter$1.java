package androidx.print;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.CancellationSignal;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintDocumentInfo;
import androidx.print.PrintHelper;
import java.io.FileNotFoundException;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class PrintHelper$PrintUriAdapter$1 extends AsyncTask<Uri, Boolean, Bitmap> {
    final /* synthetic */ PrintHelper.PrintUriAdapter this$1;
    final /* synthetic */ CancellationSignal val$cancellationSignal;
    final /* synthetic */ PrintDocumentAdapter.LayoutResultCallback val$layoutResultCallback;
    final /* synthetic */ PrintAttributes val$newPrintAttributes;
    final /* synthetic */ PrintAttributes val$oldPrintAttributes;

    PrintHelper$PrintUriAdapter$1(PrintHelper.PrintUriAdapter printUriAdapter, CancellationSignal cancellationSignal, PrintAttributes printAttributes, PrintAttributes printAttributes2, PrintDocumentAdapter.LayoutResultCallback layoutResultCallback) {
        this.this$1 = printUriAdapter;
        this.val$cancellationSignal = cancellationSignal;
        this.val$newPrintAttributes = printAttributes;
        this.val$oldPrintAttributes = printAttributes2;
        this.val$layoutResultCallback = layoutResultCallback;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        this.val$cancellationSignal.setOnCancelListener(new 1(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public Bitmap doInBackground(Uri... uriArr) {
        try {
            PrintHelper.PrintUriAdapter printUriAdapter = this.this$1;
            return printUriAdapter.this$0.loadConstrainedBitmap(printUriAdapter.mImageFile);
        } catch (FileNotFoundException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public void onCancelled(Bitmap bitmap) {
        this.val$layoutResultCallback.onLayoutCancelled();
        this.this$1.mLoadBitmap = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public void onPostExecute(Bitmap bitmap) {
        PrintAttributes.MediaSize mediaSize;
        super.onPostExecute((PrintHelper$PrintUriAdapter$1) bitmap);
        if (bitmap != null && (!PrintHelper.PRINT_ACTIVITY_RESPECTS_ORIENTATION || this.this$1.this$0.mOrientation == 0)) {
            synchronized (this) {
                mediaSize = this.this$1.mAttributes.getMediaSize();
            }
            if (mediaSize != null && mediaSize.isPortrait() != PrintHelper.isPortrait(bitmap)) {
                Matrix matrix = new Matrix();
                matrix.postRotate(90.0f);
                bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            }
        }
        this.this$1.mBitmap = bitmap;
        if (bitmap != null) {
            this.val$layoutResultCallback.onLayoutFinished(new PrintDocumentInfo.Builder(this.this$1.mJobName).setContentType(1).setPageCount(1).build(), true ^ this.val$newPrintAttributes.equals(this.val$oldPrintAttributes));
        } else {
            this.val$layoutResultCallback.onLayoutFailed(null);
        }
        this.this$1.mLoadBitmap = null;
    }
}
