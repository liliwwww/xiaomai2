package androidx.activity.result.contract;

import androidx.activity.result.contract.ActivityResultContracts;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class ActivityResultContracts$PickVisualMedia$SingleMimeType implements ActivityResultContracts.PickVisualMedia.VisualMediaType {

    @NotNull
    private final String mimeType;

    public ActivityResultContracts$PickVisualMedia$SingleMimeType(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "mimeType");
        this.mimeType = str;
    }

    @NotNull
    public final String getMimeType() {
        return this.mimeType;
    }
}
