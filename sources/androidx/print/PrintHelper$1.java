package androidx.print;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.pdf.PdfDocument;
import android.os.AsyncTask;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.print.PageRange;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.pdf.PrintedPdfDocument;
import android.util.Log;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class PrintHelper$1 extends AsyncTask<Void, Void, Throwable> {
    final /* synthetic */ PrintHelper this$0;
    final /* synthetic */ PrintAttributes val$attributes;
    final /* synthetic */ Bitmap val$bitmap;
    final /* synthetic */ CancellationSignal val$cancellationSignal;
    final /* synthetic */ ParcelFileDescriptor val$fileDescriptor;
    final /* synthetic */ int val$fittingMode;
    final /* synthetic */ PrintAttributes val$pdfAttributes;
    final /* synthetic */ PrintDocumentAdapter.WriteResultCallback val$writeResultCallback;

    PrintHelper$1(PrintHelper printHelper, CancellationSignal cancellationSignal, PrintAttributes printAttributes, Bitmap bitmap, PrintAttributes printAttributes2, int i, ParcelFileDescriptor parcelFileDescriptor, PrintDocumentAdapter.WriteResultCallback writeResultCallback) {
        this.this$0 = printHelper;
        this.val$cancellationSignal = cancellationSignal;
        this.val$pdfAttributes = printAttributes;
        this.val$bitmap = bitmap;
        this.val$attributes = printAttributes2;
        this.val$fittingMode = i;
        this.val$fileDescriptor = parcelFileDescriptor;
        this.val$writeResultCallback = writeResultCallback;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public Throwable doInBackground(Void... voidArr) {
        RectF rectF;
        try {
            if (this.val$cancellationSignal.isCanceled()) {
                return null;
            }
            PrintedPdfDocument printedPdfDocument = new PrintedPdfDocument(this.this$0.mContext, this.val$pdfAttributes);
            Bitmap convertBitmapForColorMode = PrintHelper.convertBitmapForColorMode(this.val$bitmap, this.val$pdfAttributes.getColorMode());
            if (this.val$cancellationSignal.isCanceled()) {
                return null;
            }
            try {
                PdfDocument.Page startPage = printedPdfDocument.startPage(1);
                boolean z = PrintHelper.IS_MIN_MARGINS_HANDLING_CORRECT;
                if (z) {
                    rectF = new RectF(startPage.getInfo().getContentRect());
                } else {
                    PrintedPdfDocument printedPdfDocument2 = new PrintedPdfDocument(this.this$0.mContext, this.val$attributes);
                    PdfDocument.Page startPage2 = printedPdfDocument2.startPage(1);
                    RectF rectF2 = new RectF(startPage2.getInfo().getContentRect());
                    printedPdfDocument2.finishPage(startPage2);
                    printedPdfDocument2.close();
                    rectF = rectF2;
                }
                Matrix matrix = PrintHelper.getMatrix(convertBitmapForColorMode.getWidth(), convertBitmapForColorMode.getHeight(), rectF, this.val$fittingMode);
                if (!z) {
                    matrix.postTranslate(rectF.left, rectF.top);
                    startPage.getCanvas().clipRect(rectF);
                }
                startPage.getCanvas().drawBitmap(convertBitmapForColorMode, matrix, null);
                printedPdfDocument.finishPage(startPage);
                if (this.val$cancellationSignal.isCanceled()) {
                    printedPdfDocument.close();
                    ParcelFileDescriptor parcelFileDescriptor = this.val$fileDescriptor;
                    if (parcelFileDescriptor != null) {
                        try {
                            parcelFileDescriptor.close();
                        } catch (IOException unused) {
                        }
                    }
                    if (convertBitmapForColorMode != this.val$bitmap) {
                        convertBitmapForColorMode.recycle();
                    }
                    return null;
                }
                printedPdfDocument.writeTo(new FileOutputStream(this.val$fileDescriptor.getFileDescriptor()));
                printedPdfDocument.close();
                ParcelFileDescriptor parcelFileDescriptor2 = this.val$fileDescriptor;
                if (parcelFileDescriptor2 != null) {
                    try {
                        parcelFileDescriptor2.close();
                    } catch (IOException unused2) {
                    }
                }
                if (convertBitmapForColorMode != this.val$bitmap) {
                    convertBitmapForColorMode.recycle();
                }
                return null;
            } finally {
            }
        } catch (Throwable th) {
            return th;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public void onPostExecute(Throwable th) {
        if (this.val$cancellationSignal.isCanceled()) {
            this.val$writeResultCallback.onWriteCancelled();
        } else if (th == null) {
            this.val$writeResultCallback.onWriteFinished(new PageRange[]{PageRange.ALL_PAGES});
        } else {
            Log.e("PrintHelper", "Error writing printed content", th);
            this.val$writeResultCallback.onWriteFailed(null);
        }
    }
}
