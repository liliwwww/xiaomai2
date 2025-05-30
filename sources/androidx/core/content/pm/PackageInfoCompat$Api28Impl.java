package androidx.core.content.pm;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
@RequiresApi(28)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class PackageInfoCompat$Api28Impl {
    private PackageInfoCompat$Api28Impl() {
    }

    @Nullable
    @DoNotInline
    static Signature[] getApkContentsSigners(@NonNull SigningInfo signingInfo) {
        return signingInfo.getApkContentsSigners();
    }

    @DoNotInline
    static long getLongVersionCode(PackageInfo packageInfo) {
        return packageInfo.getLongVersionCode();
    }

    @Nullable
    @DoNotInline
    static Signature[] getSigningCertificateHistory(@NonNull SigningInfo signingInfo) {
        return signingInfo.getSigningCertificateHistory();
    }

    @DoNotInline
    static boolean hasMultipleSigners(@NonNull SigningInfo signingInfo) {
        return signingInfo.hasMultipleSigners();
    }

    @DoNotInline
    static boolean hasSigningCertificate(@NonNull PackageManager packageManager, @NonNull String str, @NonNull byte[] bArr, int i) {
        return packageManager.hasSigningCertificate(str, bArr, i);
    }
}
