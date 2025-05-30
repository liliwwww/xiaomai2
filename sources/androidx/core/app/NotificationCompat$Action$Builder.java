package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class NotificationCompat$Action$Builder {
    private boolean mAllowGeneratedReplies;
    private boolean mAuthenticationRequired;
    private final Bundle mExtras;
    private final IconCompat mIcon;
    private final PendingIntent mIntent;
    private boolean mIsContextual;
    private ArrayList<RemoteInput> mRemoteInputs;
    private int mSemanticAction;
    private boolean mShowsUserInterface;
    private final CharSequence mTitle;

    public NotificationCompat$Action$Builder(@Nullable IconCompat iconCompat, @Nullable CharSequence charSequence, @Nullable PendingIntent pendingIntent) {
        this(iconCompat, charSequence, pendingIntent, new Bundle(), null, true, 0, true, false, false);
    }

    private void checkContextualActionNullFields() {
        if (this.mIsContextual) {
            Objects.requireNonNull(this.mIntent, "Contextual Actions must contain a valid PendingIntent");
        }
    }

    @NonNull
    @RequiresApi(19)
    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
    public static NotificationCompat$Action$Builder fromAndroidAction(@NonNull Notification.Action action) {
        RemoteInput[] remoteInputs;
        int i = Build.VERSION.SDK_INT;
        NotificationCompat$Action$Builder notificationCompat$Action$Builder = (i < 23 || action.getIcon() == null) ? new NotificationCompat$Action$Builder(action.icon, action.title, action.actionIntent) : new NotificationCompat$Action$Builder(IconCompat.createFromIcon(action.getIcon()), action.title, action.actionIntent);
        if (i >= 20 && (remoteInputs = action.getRemoteInputs()) != null && remoteInputs.length != 0) {
            for (RemoteInput remoteInput : remoteInputs) {
                notificationCompat$Action$Builder.addRemoteInput(RemoteInput.fromPlatform(remoteInput));
            }
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 24) {
            notificationCompat$Action$Builder.mAllowGeneratedReplies = action.getAllowGeneratedReplies();
        }
        if (i2 >= 28) {
            notificationCompat$Action$Builder.setSemanticAction(action.getSemanticAction());
        }
        if (i2 >= 29) {
            notificationCompat$Action$Builder.setContextual(action.isContextual());
        }
        if (i2 >= 31) {
            notificationCompat$Action$Builder.setAuthenticationRequired(action.isAuthenticationRequired());
        }
        return notificationCompat$Action$Builder;
    }

    @NonNull
    public NotificationCompat$Action$Builder addExtras(@Nullable Bundle bundle) {
        if (bundle != null) {
            this.mExtras.putAll(bundle);
        }
        return this;
    }

    @NonNull
    public NotificationCompat$Action$Builder addRemoteInput(@Nullable RemoteInput remoteInput) {
        if (this.mRemoteInputs == null) {
            this.mRemoteInputs = new ArrayList<>();
        }
        if (remoteInput != null) {
            this.mRemoteInputs.add(remoteInput);
        }
        return this;
    }

    @NonNull
    public NotificationCompat.Action build() {
        checkContextualActionNullFields();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList<RemoteInput> arrayList3 = this.mRemoteInputs;
        if (arrayList3 != null) {
            Iterator<RemoteInput> it = arrayList3.iterator();
            while (it.hasNext()) {
                RemoteInput next = it.next();
                if (next.isDataOnly()) {
                    arrayList.add(next);
                } else {
                    arrayList2.add(next);
                }
            }
        }
        RemoteInput[] remoteInputArr = arrayList.isEmpty() ? null : (RemoteInput[]) arrayList.toArray(new RemoteInput[arrayList.size()]);
        return new NotificationCompat.Action(this.mIcon, this.mTitle, this.mIntent, this.mExtras, arrayList2.isEmpty() ? null : (RemoteInput[]) arrayList2.toArray(new RemoteInput[arrayList2.size()]), remoteInputArr, this.mAllowGeneratedReplies, this.mSemanticAction, this.mShowsUserInterface, this.mIsContextual, this.mAuthenticationRequired);
    }

    @NonNull
    public NotificationCompat$Action$Builder extend(@NonNull NotificationCompat.Action.Extender extender) {
        extender.extend(this);
        return this;
    }

    @NonNull
    public Bundle getExtras() {
        return this.mExtras;
    }

    @NonNull
    public NotificationCompat$Action$Builder setAllowGeneratedReplies(boolean z) {
        this.mAllowGeneratedReplies = z;
        return this;
    }

    @NonNull
    public NotificationCompat$Action$Builder setAuthenticationRequired(boolean z) {
        this.mAuthenticationRequired = z;
        return this;
    }

    @NonNull
    public NotificationCompat$Action$Builder setContextual(boolean z) {
        this.mIsContextual = z;
        return this;
    }

    @NonNull
    public NotificationCompat$Action$Builder setSemanticAction(int i) {
        this.mSemanticAction = i;
        return this;
    }

    @NonNull
    public NotificationCompat$Action$Builder setShowsUserInterface(boolean z) {
        this.mShowsUserInterface = z;
        return this;
    }

    public NotificationCompat$Action$Builder(int i, @Nullable CharSequence charSequence, @Nullable PendingIntent pendingIntent) {
        this(i != 0 ? IconCompat.createWithResource((Resources) null, "", i) : null, charSequence, pendingIntent, new Bundle(), null, true, 0, true, false, false);
    }

    public NotificationCompat$Action$Builder(@NonNull NotificationCompat.Action action) {
        this(action.getIconCompat(), action.title, action.actionIntent, new Bundle(action.mExtras), action.getRemoteInputs(), action.getAllowGeneratedReplies(), action.getSemanticAction(), action.mShowsUserInterface, action.isContextual(), action.isAuthenticationRequired());
    }

    private NotificationCompat$Action$Builder(@Nullable IconCompat iconCompat, @Nullable CharSequence charSequence, @Nullable PendingIntent pendingIntent, @NonNull Bundle bundle, @Nullable RemoteInput[] remoteInputArr, boolean z, int i, boolean z2, boolean z3, boolean z4) {
        this.mAllowGeneratedReplies = true;
        this.mShowsUserInterface = true;
        this.mIcon = iconCompat;
        this.mTitle = NotificationCompat.Builder.limitCharSequenceLength(charSequence);
        this.mIntent = pendingIntent;
        this.mExtras = bundle;
        this.mRemoteInputs = remoteInputArr == null ? null : new ArrayList<>(Arrays.asList(remoteInputArr));
        this.mAllowGeneratedReplies = z;
        this.mSemanticAction = i;
        this.mShowsUserInterface = z2;
        this.mIsContextual = z3;
        this.mAuthenticationRequired = z4;
    }
}
