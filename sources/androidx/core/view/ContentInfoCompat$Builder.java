package androidx.core.view;

import android.content.ClipData;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ContentInfoCompat;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class ContentInfoCompat$Builder {

    @NonNull
    private final ContentInfoCompat$BuilderCompat mBuilderCompat;

    public ContentInfoCompat$Builder(@NonNull ContentInfoCompat contentInfoCompat) {
        if (Build.VERSION.SDK_INT >= 31) {
            this.mBuilderCompat = new ContentInfoCompat.BuilderCompat31Impl(contentInfoCompat);
        } else {
            this.mBuilderCompat = new ContentInfoCompat$BuilderCompatImpl(contentInfoCompat);
        }
    }

    @NonNull
    public ContentInfoCompat build() {
        return this.mBuilderCompat.build();
    }

    @NonNull
    public ContentInfoCompat$Builder setClip(@NonNull ClipData clipData) {
        this.mBuilderCompat.setClip(clipData);
        return this;
    }

    @NonNull
    public ContentInfoCompat$Builder setExtras(@Nullable Bundle bundle) {
        this.mBuilderCompat.setExtras(bundle);
        return this;
    }

    @NonNull
    public ContentInfoCompat$Builder setFlags(int i) {
        this.mBuilderCompat.setFlags(i);
        return this;
    }

    @NonNull
    public ContentInfoCompat$Builder setLinkUri(@Nullable Uri uri) {
        this.mBuilderCompat.setLinkUri(uri);
        return this;
    }

    @NonNull
    public ContentInfoCompat$Builder setSource(int i) {
        this.mBuilderCompat.setSource(i);
        return this;
    }

    public ContentInfoCompat$Builder(@NonNull ClipData clipData, int i) {
        if (Build.VERSION.SDK_INT >= 31) {
            this.mBuilderCompat = new ContentInfoCompat.BuilderCompat31Impl(clipData, i);
        } else {
            this.mBuilderCompat = new ContentInfoCompat$BuilderCompatImpl(clipData, i);
        }
    }
}
