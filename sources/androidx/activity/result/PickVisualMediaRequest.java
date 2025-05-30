package androidx.activity.result;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.activity.result.contract.ActivityResultContracts$PickVisualMedia$ImageAndVideo;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class PickVisualMediaRequest {

    @NotNull
    private ActivityResultContracts.PickVisualMedia.VisualMediaType mediaType = ActivityResultContracts$PickVisualMedia$ImageAndVideo.INSTANCE;

    @NotNull
    public final ActivityResultContracts.PickVisualMedia.VisualMediaType getMediaType() {
        return this.mediaType;
    }

    public final void setMediaType$activity_release(@NotNull ActivityResultContracts.PickVisualMedia.VisualMediaType visualMediaType) {
        Intrinsics.checkNotNullParameter(visualMediaType, "<set-?>");
        this.mediaType = visualMediaType;
    }
}
