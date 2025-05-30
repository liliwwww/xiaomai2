package androidx.core.view.inputmethod;

import android.content.ClipDescription;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.inputmethod.InputContentInfoCompat;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class InputContentInfoCompat$InputContentInfoCompatBaseImpl implements InputContentInfoCompat.InputContentInfoCompatImpl {

    @NonNull
    private final Uri mContentUri;

    @NonNull
    private final ClipDescription mDescription;

    @Nullable
    private final Uri mLinkUri;

    InputContentInfoCompat$InputContentInfoCompatBaseImpl(@NonNull Uri uri, @NonNull ClipDescription clipDescription, @Nullable Uri uri2) {
        this.mContentUri = uri;
        this.mDescription = clipDescription;
        this.mLinkUri = uri2;
    }

    @NonNull
    public Uri getContentUri() {
        return this.mContentUri;
    }

    @NonNull
    public ClipDescription getDescription() {
        return this.mDescription;
    }

    @Nullable
    public Object getInputContentInfo() {
        return null;
    }

    @Nullable
    public Uri getLinkUri() {
        return this.mLinkUri;
    }

    public void releasePermission() {
    }

    public void requestPermission() {
    }
}
