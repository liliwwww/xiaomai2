package androidx.profileinstaller;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;
import androidx.profileinstaller.ProfileInstaller;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.Executor;
import tb.cx0;

/* compiled from: Taobao */
@RequiresApi(19)
@RestrictTo({RestrictTo$Scope.LIBRARY})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class DeviceProfileWriter {

    @NonNull
    private final String mApkName;

    @NonNull
    private final AssetManager mAssetManager;

    @NonNull
    private final File mCurProfile;

    @NonNull
    private final ProfileInstaller.DiagnosticsCallback mDiagnostics;

    @NonNull
    private final Executor mExecutor;

    @Nullable
    private DexProfileData[] mProfile;

    @NonNull
    private final String mProfileMetaSourceLocation;

    @NonNull
    private final String mProfileSourceLocation;

    @Nullable
    private byte[] mTranscodedProfile;
    private boolean mDeviceSupportsAotProfile = false;

    @Nullable
    private final byte[] mDesiredVersion = desiredVersion();

    @RestrictTo({RestrictTo$Scope.LIBRARY})
    public DeviceProfileWriter(@NonNull AssetManager assetManager, @NonNull Executor executor, @NonNull ProfileInstaller.DiagnosticsCallback diagnosticsCallback, @NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull File file) {
        this.mAssetManager = assetManager;
        this.mExecutor = executor;
        this.mDiagnostics = diagnosticsCallback;
        this.mApkName = str;
        this.mProfileSourceLocation = str2;
        this.mProfileMetaSourceLocation = str3;
        this.mCurProfile = file;
    }

    private void assertDeviceAllowsProfileInstallerAotWritesCalled() {
        if (!this.mDeviceSupportsAotProfile) {
            throw new IllegalStateException("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
        }
    }

    @Nullable
    private static byte[] desiredVersion() {
        int i = Build.VERSION.SDK_INT;
        if (i < 24) {
            return null;
        }
        switch (i) {
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$result$0(int i, Object obj) {
        this.mDiagnostics.onResultReceived(i, obj);
    }

    private static boolean requiresMetadata() {
        int i = Build.VERSION.SDK_INT;
        if (i < 24) {
            return false;
        }
        if (i != 24 && i != 25) {
            switch (i) {
            }
            return false;
        }
        return true;
    }

    private void result(int i, @Nullable Object obj) {
        this.mExecutor.execute(new cx0(this, i, obj));
    }

    @RestrictTo({RestrictTo$Scope.LIBRARY})
    public boolean deviceAllowsProfileInstallerAotWrites() {
        if (this.mDesiredVersion == null) {
            result(3, Integer.valueOf(Build.VERSION.SDK_INT));
            return false;
        }
        if (this.mCurProfile.canWrite()) {
            this.mDeviceSupportsAotProfile = true;
            return true;
        }
        result(4, null);
        return false;
    }

    @NonNull
    @RestrictTo({RestrictTo$Scope.LIBRARY})
    public DeviceProfileWriter read() {
        assertDeviceAllowsProfileInstallerAotWritesCalled();
        if (this.mDesiredVersion == null) {
            return this;
        }
        try {
            AssetFileDescriptor openFd = this.mAssetManager.openFd(this.mProfileSourceLocation);
            try {
                FileInputStream createInputStream = openFd.createInputStream();
                try {
                    this.mProfile = ProfileTranscoder.readProfile(createInputStream, ProfileTranscoder.readHeader(createInputStream, ProfileTranscoder.MAGIC_PROF), this.mApkName);
                    if (createInputStream != null) {
                        createInputStream.close();
                    }
                    openFd.close();
                } finally {
                }
            } finally {
            }
        } catch (FileNotFoundException e) {
            this.mDiagnostics.onResultReceived(6, e);
        } catch (IOException e2) {
            this.mDiagnostics.onResultReceived(7, e2);
        } catch (IllegalStateException e3) {
            this.mDiagnostics.onResultReceived(8, e3);
        }
        DexProfileData[] dexProfileDataArr = this.mProfile;
        if (dexProfileDataArr != null && requiresMetadata()) {
            try {
                AssetFileDescriptor openFd2 = this.mAssetManager.openFd(this.mProfileMetaSourceLocation);
                try {
                    FileInputStream createInputStream2 = openFd2.createInputStream();
                    try {
                        this.mProfile = ProfileTranscoder.readMeta(createInputStream2, ProfileTranscoder.readHeader(createInputStream2, ProfileTranscoder.MAGIC_PROFM), this.mDesiredVersion, dexProfileDataArr);
                        if (createInputStream2 != null) {
                            createInputStream2.close();
                        }
                        openFd2.close();
                        return this;
                    } finally {
                    }
                } catch (Throwable th) {
                    if (openFd2 != null) {
                        try {
                            openFd2.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException e4) {
                this.mDiagnostics.onResultReceived(9, e4);
            } catch (IOException e5) {
                this.mDiagnostics.onResultReceived(7, e5);
            } catch (IllegalStateException e6) {
                this.mProfile = null;
                this.mDiagnostics.onResultReceived(8, e6);
            }
        }
        return this;
    }

    @NonNull
    @RestrictTo({RestrictTo$Scope.LIBRARY})
    public DeviceProfileWriter transcodeIfNeeded() {
        ByteArrayOutputStream byteArrayOutputStream;
        DexProfileData[] dexProfileDataArr = this.mProfile;
        byte[] bArr = this.mDesiredVersion;
        if (dexProfileDataArr != null && bArr != null) {
            assertDeviceAllowsProfileInstallerAotWritesCalled();
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    ProfileTranscoder.writeHeader(byteArrayOutputStream, bArr);
                } catch (Throwable th) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (IOException e) {
                this.mDiagnostics.onResultReceived(7, e);
            } catch (IllegalStateException e2) {
                this.mDiagnostics.onResultReceived(8, e2);
            }
            if (!ProfileTranscoder.transcodeAndWriteBody(byteArrayOutputStream, bArr, dexProfileDataArr)) {
                this.mDiagnostics.onResultReceived(5, null);
                this.mProfile = null;
                byteArrayOutputStream.close();
                return this;
            }
            this.mTranscodedProfile = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            this.mProfile = null;
        }
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @RestrictTo({RestrictTo$Scope.LIBRARY})
    public boolean write() {
        byte[] bArr = this.mTranscodedProfile;
        if (bArr == null) {
            return false;
        }
        assertDeviceAllowsProfileInstallerAotWritesCalled();
        try {
            try {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(this.mCurProfile);
                    try {
                        Encoding.writeAll(byteArrayInputStream, fileOutputStream);
                        result(1, null);
                        fileOutputStream.close();
                        byteArrayInputStream.close();
                        return true;
                    } finally {
                    }
                } catch (Throwable th) {
                    try {
                        byteArrayInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } finally {
                this.mTranscodedProfile = null;
                this.mProfile = null;
            }
        } catch (FileNotFoundException e) {
            result(6, e);
            return false;
        } catch (IOException e2) {
            result(7, e2);
            return false;
        }
    }
}
