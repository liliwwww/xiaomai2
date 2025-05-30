package android.taobao.windvane.jsbridge.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.taobao.windvane.cache.WVCacheManager;
import android.taobao.windvane.cache.WVFileInfo;
import android.taobao.windvane.file.FileManager;
import android.taobao.windvane.util.DigestUtils;
import android.taobao.windvane.util.TaoLog;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.app.NotificationManagerCompat;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class WVUtils {
    public static final String LOCAL_CAPTURE_IMAGE = "//127.0.0.1/wvcache/photo.jpg?_wvcrc=1&t=";
    public static final String URL_DATA_CHAR = "?";
    public static final String URL_SEPARATOR = "//";

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0033: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:40:0x0033 */
    public static String bitmapToBase64(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        String encodeToString;
        ByteArrayOutputStream byteArrayOutputStream3 = null;
        try {
            if (bitmap != null) {
                try {
                    byteArrayOutputStream2 = new ByteArrayOutputStream();
                    try {
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream2);
                        byteArrayOutputStream2.flush();
                        byteArrayOutputStream2.close();
                        encodeToString = Base64.encodeToString(byteArrayOutputStream2.toByteArray(), 0);
                        byteArrayOutputStream3 = byteArrayOutputStream2;
                    } catch (IOException e) {
                        e = e;
                        e.printStackTrace();
                        if (byteArrayOutputStream2 == null) {
                            return null;
                        }
                        try {
                            byteArrayOutputStream2.flush();
                            byteArrayOutputStream2.close();
                            return null;
                        } catch (Exception unused) {
                            return null;
                        }
                    }
                } catch (IOException e2) {
                    e = e2;
                    byteArrayOutputStream2 = null;
                } catch (Throwable th) {
                    th = th;
                    if (byteArrayOutputStream3 != null) {
                        try {
                            byteArrayOutputStream3.flush();
                            byteArrayOutputStream3.close();
                        } catch (Exception unused2) {
                        }
                    }
                    throw th;
                }
            } else {
                encodeToString = null;
            }
            if (byteArrayOutputStream3 != null) {
                try {
                    byteArrayOutputStream3.flush();
                    byteArrayOutputStream3.close();
                } catch (Exception unused3) {
                }
            }
            return encodeToString;
        } catch (Throwable th2) {
            th = th2;
            byteArrayOutputStream3 = byteArrayOutputStream;
        }
    }

    public static String getHost(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int indexOf = str.indexOf(URL_DATA_CHAR);
        if (indexOf != -1) {
            str = str.substring(0, indexOf);
        }
        if (str.startsWith(URL_SEPARATOR)) {
            str = "http:" + str;
        } else if (!str.contains("://")) {
            str = "http://" + str;
        }
        Uri parse = Uri.parse(str);
        if (parse == null) {
            return null;
        }
        return parse.getHost();
    }

    public static String getVirtualPath(Long l) {
        return "//127.0.0.1/wvcache/photo.jpg?_wvcrc=1&t=" + l;
    }

    public static boolean isNotificationEnabled(Context context) {
        return NotificationManagerCompat.from(context).areNotificationsEnabled();
    }

    public static long saveBitmapToCache(Bitmap bitmap) throws IOException {
        long currentTimeMillis = System.currentTimeMillis();
        WVFileInfo wVFileInfo = new WVFileInfo();
        wVFileInfo.fileName = DigestUtils.md5ToHex("//127.0.0.1/wvcache/photo.jpg?_wvcrc=1&t=" + currentTimeMillis);
        wVFileInfo.mimeType = "image/jpeg";
        wVFileInfo.expireTime = System.currentTimeMillis() + 2592000000L;
        WVCacheManager.getInstance().writeToFile(wVFileInfo, new byte[]{0});
        File file = new File(WVCacheManager.getInstance().getCacheDir(true), wVFileInfo.fileName);
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream2);
                fileOutputStream2.close();
                return currentTimeMillis;
            } catch (Exception unused) {
                fileOutputStream = fileOutputStream2;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                return 0L;
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static long saveBitmapToCache(File file) {
        long currentTimeMillis = System.currentTimeMillis();
        File file2 = new File(WVCacheManager.getInstance().getCacheDir(true), DigestUtils.md5ToHex("//127.0.0.1/wvcache/photo.jpg?_wvcrc=1&t=" + currentTimeMillis));
        if (file != null && file.exists() && FileManager.copy(file, file2)) {
            return currentTimeMillis;
        }
        TaoLog.w("WVUtils", "fail to copy " + file.getAbsolutePath());
        return 0L;
    }
}
