package androidx.core.view;

import android.content.ClipData;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public interface ContentInfoCompat$BuilderCompat {
    @NonNull
    ContentInfoCompat build();

    void setClip(@NonNull ClipData clipData);

    void setExtras(@Nullable Bundle bundle);

    void setFlags(int i);

    void setLinkUri(@Nullable Uri uri);

    void setSource(int i);
}
