package android.taobao.windvane.util;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.taobao.windvane.connect.ConnectManager;
import android.util.AndroidRuntimeException;
import android.util.Base64;
import android.webkit.URLUtil;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class ImageTool {
    private static final int MAX_LENGTH = 10240;

    /* compiled from: Taobao */
    public interface ImageSaveCallback {
        void error(String str);

        void success();
    }

    public static byte[] bitmapToBytes(Bitmap bitmap, Bitmap.CompressFormat compressFormat) {
        if (bitmap == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(compressFormat, 100, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static int readRotationDegree(String str) {
        if (str == null) {
            return 0;
        }
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt("Orientation", 1);
            if (attributeInt == 3) {
                return 180;
            }
            if (attributeInt != 6) {
                return attributeInt != 8 ? 0 : 270;
            }
            return 90;
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static Bitmap readZoomImage(String str, int i) {
        if (i > MAX_LENGTH) {
            i = MAX_LENGTH;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        int i2 = options.outHeight;
        int i3 = options.outWidth;
        if (i2 <= i3) {
            i2 = i3;
        }
        int round = Math.round(i2 / i);
        options.inSampleSize = round >= 1 ? round : 1;
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(str, options);
    }

    public static Bitmap rotate(Bitmap bitmap, int i) {
        if (i == 0 || bitmap == null) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.postRotate(i);
        try {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            return bitmap != createBitmap ? createBitmap : bitmap;
        } catch (OutOfMemoryError unused) {
            return bitmap;
        }
    }

    public static boolean saveImage(Context context, Bitmap bitmap) {
        if (Build.VERSION.SDK_INT >= 29) {
            if (saveImageQ(context, bitmap)) {
                return true;
            }
            TaoLog.e("ImageTool", "save image failed");
            return false;
        }
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), String.valueOf(System.currentTimeMillis()) + ".jpg");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            fileOutputStream.close();
            MediaScannerConnection.scanFile(context, new String[]{file.getAbsolutePath()}, new String[]{"image/jpeg"}, null);
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    /* JADX WARN: Not initialized variable reg: 7, insn: 0x00d7: MOVE (r5 I:??[OBJECT, ARRAY]) = (r7 I:??[OBJECT, ARRAY]), block:B:54:0x00d7 */
    @SuppressLint({"NewApi"})
    private static boolean saveImageQ(Context context, Bitmap bitmap) {
        ParcelFileDescriptor parcelFileDescriptor;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        String str = Environment.DIRECTORY_PICTURES + File.separator + "wv_save_image";
        ContentValues contentValues = new ContentValues();
        contentValues.put("_display_name", String.valueOf(System.currentTimeMillis()));
        contentValues.put("mime_type", "image/jpeg");
        contentValues.put("is_pending", (Integer) 1);
        contentValues.put("relative_path", str);
        Uri contentUri = MediaStore.Images.Media.getContentUri("external_primary");
        ContentResolver contentResolver = context.getContentResolver();
        Uri insert = contentResolver.insert(contentUri, contentValues);
        FileOutputStream fileOutputStream3 = null;
        try {
            try {
                if (insert == null) {
                    new AndroidRuntimeException("android Q: save image error for uri is null").printStackTrace();
                    return false;
                }
                parcelFileDescriptor = contentResolver.openFileDescriptor(insert, "w", null);
                try {
                    fileOutputStream = new FileOutputStream(parcelFileDescriptor.getFileDescriptor());
                    try {
                        if (!bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream)) {
                            new AndroidRuntimeException("android Q: save image failed").printStackTrace();
                            try {
                                fileOutputStream.flush();
                                fileOutputStream.close();
                                parcelFileDescriptor.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            return false;
                        }
                        contentValues.clear();
                        contentValues.put("is_pending", (Integer) 0);
                        contentResolver.update(insert, contentValues, null, null);
                        try {
                            fileOutputStream.flush();
                            fileOutputStream.close();
                            parcelFileDescriptor.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                        return true;
                    } catch (IOException e3) {
                        e = e3;
                        e.printStackTrace();
                        contentResolver.delete(insert, null, null);
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.flush();
                                fileOutputStream.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                                return false;
                            }
                        }
                        if (parcelFileDescriptor != null) {
                            parcelFileDescriptor.close();
                        }
                        return false;
                    }
                } catch (IOException e5) {
                    e = e5;
                    fileOutputStream = null;
                } catch (Throwable th) {
                    th = th;
                    if (fileOutputStream3 != null) {
                        try {
                            fileOutputStream3.flush();
                            fileOutputStream3.close();
                        } catch (IOException e6) {
                            e6.printStackTrace();
                            throw th;
                        }
                    }
                    if (parcelFileDescriptor != null) {
                        parcelFileDescriptor.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream3 = fileOutputStream2;
            }
        } catch (IOException e7) {
            e = e7;
            parcelFileDescriptor = null;
            fileOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            parcelFileDescriptor = null;
        }
    }

    public static void saveImageToDCIM(Context context, String str, ImageSaveCallback imageSaveCallback) {
        if (URLUtil.isHttpUrl(str) || URLUtil.isHttpsUrl(str)) {
            ConnectManager.getInstance().connect(str, new 1(context, imageSaveCallback));
            return;
        }
        if (str.startsWith("data:")) {
            try {
                byte[] decode = Base64.decode(str.substring(str.indexOf(",") + 1).getBytes(), 0);
                if (!saveImage(context, BitmapFactory.decodeByteArray(decode, 0, decode.length)) || imageSaveCallback == null) {
                    return;
                }
                imageSaveCallback.success();
            } catch (Throwable th) {
                if (imageSaveCallback != null) {
                    imageSaveCallback.error(th.getMessage());
                }
            }
        }
    }

    public static Drawable toDrawable(Resources resources, String str) {
        if (str == null) {
            return null;
        }
        try {
            try {
                return new BitmapDrawable(resources, BitmapFactory.decodeStream(new ByteArrayInputStream(Base64.decode(str, 0))));
            } catch (OutOfMemoryError e) {
                e.printStackTrace();
                return null;
            }
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public static Bitmap zoomBitmap(Bitmap bitmap, int i) {
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i2 = width > height ? width : height;
        if (i2 <= i) {
            return bitmap;
        }
        float f = i / i2;
        Matrix matrix = new Matrix();
        matrix.postScale(f, f);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    public static Bitmap zoomBitmap(Bitmap bitmap, long j, long j2) {
        int i;
        int i2;
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width > height) {
            i2 = width;
            i = height;
        } else {
            i = width;
            i2 = height;
        }
        if (i2 <= j && i <= j2) {
            return bitmap;
        }
        float f = j / i2;
        float f2 = j2 / i;
        if (f >= f2) {
            f = f2;
        }
        Matrix matrix = new Matrix();
        matrix.postScale(f, f);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    public static void saveImageToDCIM(Context context, String str, Handler handler) {
        saveImageToDCIM(context, str, (ImageSaveCallback) new 2(handler));
    }
}
