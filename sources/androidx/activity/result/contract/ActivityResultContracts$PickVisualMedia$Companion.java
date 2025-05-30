package androidx.activity.result.contract;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.ext.SdkExtensions;
import androidx.activity.result.contract.ActivityResultContracts;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class ActivityResultContracts$PickVisualMedia$Companion {
    private ActivityResultContracts$PickVisualMedia$Companion() {
    }

    public /* synthetic */ ActivityResultContracts$PickVisualMedia$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Nullable
    public final String getVisualMimeType$activity_release(@NotNull ActivityResultContracts.PickVisualMedia.VisualMediaType visualMediaType) {
        Intrinsics.checkNotNullParameter(visualMediaType, "input");
        if (visualMediaType instanceof ActivityResultContracts.PickVisualMedia.ImageOnly) {
            return "image/*";
        }
        if (visualMediaType instanceof ActivityResultContracts$PickVisualMedia$VideoOnly) {
            return "video/*";
        }
        if (visualMediaType instanceof ActivityResultContracts$PickVisualMedia$SingleMimeType) {
            return ((ActivityResultContracts$PickVisualMedia$SingleMimeType) visualMediaType).getMimeType();
        }
        if (visualMediaType instanceof ActivityResultContracts$PickVisualMedia$ImageAndVideo) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }

    @JvmStatic
    @SuppressLint({"ClassVerificationFailure", "NewApi"})
    public final boolean isPhotoPickerAvailable() {
        int i = Build.VERSION.SDK_INT;
        return i >= 33 || (i >= 30 && SdkExtensions.getExtensionVersion(30) >= 2);
    }
}
