package androidx.core.app;

import androidx.annotation.NonNull;
import androidx.core.util.Consumer;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface OnPictureInPictureModeChangedProvider {
    void addOnPictureInPictureModeChangedListener(@NonNull Consumer<PictureInPictureModeChangedInfo> consumer);

    void removeOnPictureInPictureModeChangedListener(@NonNull Consumer<PictureInPictureModeChangedInfo> consumer);
}
