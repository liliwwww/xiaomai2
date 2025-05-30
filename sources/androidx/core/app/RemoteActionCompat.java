package androidx.core.app;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.app.RemoteAction;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.util.Preconditions;
import androidx.versionedparcelable.VersionedParcelable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class RemoteActionCompat implements VersionedParcelable {

    @NonNull
    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP})
    public PendingIntent mActionIntent;

    @NonNull
    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP})
    public CharSequence mContentDescription;

    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP})
    public boolean mEnabled;

    @NonNull
    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP})
    public IconCompat mIcon;

    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP})
    public boolean mShouldShowIcon;

    @NonNull
    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP})
    public CharSequence mTitle;

    public RemoteActionCompat(@NonNull IconCompat iconCompat, @NonNull CharSequence charSequence, @NonNull CharSequence charSequence2, @NonNull PendingIntent pendingIntent) {
        this.mIcon = (IconCompat) Preconditions.checkNotNull(iconCompat);
        this.mTitle = (CharSequence) Preconditions.checkNotNull(charSequence);
        this.mContentDescription = (CharSequence) Preconditions.checkNotNull(charSequence2);
        this.mActionIntent = (PendingIntent) Preconditions.checkNotNull(pendingIntent);
        this.mEnabled = true;
        this.mShouldShowIcon = true;
    }

    @NonNull
    @RequiresApi(26)
    public static RemoteActionCompat createFromRemoteAction(@NonNull RemoteAction remoteAction) {
        Preconditions.checkNotNull(remoteAction);
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat(IconCompat.createFromIcon(Api26Impl.getIcon(remoteAction)), Api26Impl.getTitle(remoteAction), Api26Impl.getContentDescription(remoteAction), Api26Impl.getActionIntent(remoteAction));
        remoteActionCompat.setEnabled(Api26Impl.isEnabled(remoteAction));
        if (Build.VERSION.SDK_INT >= 28) {
            remoteActionCompat.setShouldShowIcon(Api28Impl.shouldShowIcon(remoteAction));
        }
        return remoteActionCompat;
    }

    @NonNull
    public PendingIntent getActionIntent() {
        return this.mActionIntent;
    }

    @NonNull
    public CharSequence getContentDescription() {
        return this.mContentDescription;
    }

    @NonNull
    public IconCompat getIcon() {
        return this.mIcon;
    }

    @NonNull
    public CharSequence getTitle() {
        return this.mTitle;
    }

    public boolean isEnabled() {
        return this.mEnabled;
    }

    public void setEnabled(boolean z) {
        this.mEnabled = z;
    }

    public void setShouldShowIcon(boolean z) {
        this.mShouldShowIcon = z;
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public boolean shouldShowIcon() {
        return this.mShouldShowIcon;
    }

    @NonNull
    @RequiresApi(26)
    public RemoteAction toRemoteAction() {
        RemoteAction createRemoteAction = Api26Impl.createRemoteAction(this.mIcon.toIcon(), this.mTitle, this.mContentDescription, this.mActionIntent);
        Api26Impl.setEnabled(createRemoteAction, isEnabled());
        if (Build.VERSION.SDK_INT >= 28) {
            Api28Impl.setShouldShowIcon(createRemoteAction, shouldShowIcon());
        }
        return createRemoteAction;
    }

    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP})
    public RemoteActionCompat() {
    }

    public RemoteActionCompat(@NonNull RemoteActionCompat remoteActionCompat) {
        Preconditions.checkNotNull(remoteActionCompat);
        this.mIcon = remoteActionCompat.mIcon;
        this.mTitle = remoteActionCompat.mTitle;
        this.mContentDescription = remoteActionCompat.mContentDescription;
        this.mActionIntent = remoteActionCompat.mActionIntent;
        this.mEnabled = remoteActionCompat.mEnabled;
        this.mShouldShowIcon = remoteActionCompat.mShouldShowIcon;
    }
}
