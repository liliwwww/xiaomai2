package androidx.palette.graphics;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.palette.graphics.Palette;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class Palette$Builder$1 extends AsyncTask<Bitmap, Void, Palette> {
    final /* synthetic */ Palette.Builder this$0;
    final /* synthetic */ Palette.PaletteAsyncListener val$listener;

    Palette$Builder$1(Palette.Builder builder, Palette.PaletteAsyncListener paletteAsyncListener) {
        this.this$0 = builder;
        this.val$listener = paletteAsyncListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    @Nullable
    public Palette doInBackground(Bitmap... bitmapArr) {
        try {
            return this.this$0.generate();
        } catch (Exception e) {
            Log.e("Palette", "Exception thrown during async generate", e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public void onPostExecute(@Nullable Palette palette) {
        this.val$listener.onGenerated(palette);
    }
}
