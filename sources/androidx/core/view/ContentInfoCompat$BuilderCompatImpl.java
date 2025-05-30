package androidx.core.view;

import android.content.ClipData;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContentInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Preconditions;
import androidx.core.view.ContentInfoCompat;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class ContentInfoCompat$BuilderCompatImpl implements ContentInfoCompat$BuilderCompat {

    @NonNull
    ClipData mClip;

    @Nullable
    Bundle mExtras;
    int mFlags;

    @Nullable
    Uri mLinkUri;
    int mSource;

    ContentInfoCompat$BuilderCompatImpl(@NonNull ClipData clipData, int i) {
        this.mClip = clipData;
        this.mSource = i;
    }

    @Override // androidx.core.view.ContentInfoCompat$BuilderCompat
    @NonNull
    public ContentInfoCompat build() {
        return new ContentInfoCompat(new ContentInfoCompat.Compat(this) { // from class: androidx.core.view.ContentInfoCompat$CompatImpl

            @NonNull
            private final ClipData mClip;

            @Nullable
            private final Bundle mExtras;
            private final int mFlags;

            @Nullable
            private final Uri mLinkUri;
            private final int mSource;

            {
                this.mClip = (ClipData) Preconditions.checkNotNull(this.mClip);
                this.mSource = Preconditions.checkArgumentInRange(this.mSource, 0, 5, "source");
                this.mFlags = Preconditions.checkFlagsArgument(this.mFlags, 1);
                this.mLinkUri = this.mLinkUri;
                this.mExtras = this.mExtras;
            }

            @NonNull
            public ClipData getClip() {
                return this.mClip;
            }

            @Nullable
            public Bundle getExtras() {
                return this.mExtras;
            }

            public int getFlags() {
                return this.mFlags;
            }

            @Nullable
            public Uri getLinkUri() {
                return this.mLinkUri;
            }

            public int getSource() {
                return this.mSource;
            }

            @Nullable
            public ContentInfo getWrapped() {
                return null;
            }

            @NonNull
            public String toString() {
                String str;
                StringBuilder sb = new StringBuilder();
                sb.append("ContentInfoCompat{clip=");
                sb.append(this.mClip.getDescription());
                sb.append(", source=");
                sb.append(ContentInfoCompat.sourceToString(this.mSource));
                sb.append(", flags=");
                sb.append(ContentInfoCompat.flagsToString(this.mFlags));
                if (this.mLinkUri == null) {
                    str = "";
                } else {
                    str = ", hasLinkUri(" + this.mLinkUri.toString().length() + ")";
                }
                sb.append(str);
                sb.append(this.mExtras != null ? ", hasExtras" : "");
                sb.append("}");
                return sb.toString();
            }
        });
    }

    @Override // androidx.core.view.ContentInfoCompat$BuilderCompat
    public void setClip(@NonNull ClipData clipData) {
        this.mClip = clipData;
    }

    @Override // androidx.core.view.ContentInfoCompat$BuilderCompat
    public void setExtras(@Nullable Bundle bundle) {
        this.mExtras = bundle;
    }

    @Override // androidx.core.view.ContentInfoCompat$BuilderCompat
    public void setFlags(int i) {
        this.mFlags = i;
    }

    @Override // androidx.core.view.ContentInfoCompat$BuilderCompat
    public void setLinkUri(@Nullable Uri uri) {
        this.mLinkUri = uri;
    }

    @Override // androidx.core.view.ContentInfoCompat$BuilderCompat
    public void setSource(int i) {
        this.mSource = i;
    }

    ContentInfoCompat$BuilderCompatImpl(@NonNull ContentInfoCompat contentInfoCompat) {
        this.mClip = contentInfoCompat.getClip();
        this.mSource = contentInfoCompat.getSource();
        this.mFlags = contentInfoCompat.getFlags();
        this.mLinkUri = contentInfoCompat.getLinkUri();
        this.mExtras = contentInfoCompat.getExtras();
    }
}
