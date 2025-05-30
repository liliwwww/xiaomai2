package androidx.activity.result;

import androidx.activity.result.contract.ActivityResultContracts;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class PickVisualMediaRequest$Builder {

    @NotNull
    private ActivityResultContracts.PickVisualMedia.VisualMediaType mediaType = ActivityResultContracts.PickVisualMedia.ImageAndVideo.INSTANCE;

    @NotNull
    public final PickVisualMediaRequest build() {
        PickVisualMediaRequest pickVisualMediaRequest = new PickVisualMediaRequest();
        pickVisualMediaRequest.setMediaType$activity_release(this.mediaType);
        return pickVisualMediaRequest;
    }

    @NotNull
    public final PickVisualMediaRequest$Builder setMediaType(@NotNull ActivityResultContracts.PickVisualMedia.VisualMediaType visualMediaType) {
        Intrinsics.checkNotNullParameter(visualMediaType, "mediaType");
        this.mediaType = visualMediaType;
        return this;
    }
}
