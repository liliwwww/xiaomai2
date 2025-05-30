package androidx.core.app;

import android.app.Notification;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.app.NotificationCompat;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class NotificationCompat$BigTextStyle extends NotificationCompat.Style {
    private static final String TEMPLATE_CLASS_NAME = "androidx.core.app.NotificationCompat$BigTextStyle";
    private CharSequence mBigText;

    public NotificationCompat$BigTextStyle() {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void addCompatExtras(@NonNull Bundle bundle) {
        super.addCompatExtras(bundle);
        if (Build.VERSION.SDK_INT < 21) {
            bundle.putCharSequence("android.bigText", this.mBigText);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        if (Build.VERSION.SDK_INT >= 16) {
            Notification.BigTextStyle bigText = new Notification.BigTextStyle(notificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(((NotificationCompat.Style) this).mBigContentTitle).bigText(this.mBigText);
            if (((NotificationCompat.Style) this).mSummaryTextSet) {
                bigText.setSummaryText(((NotificationCompat.Style) this).mSummaryText);
            }
        }
    }

    @NonNull
    public NotificationCompat$BigTextStyle bigText(@Nullable CharSequence charSequence) {
        this.mBigText = NotificationCompat.Builder.limitCharSequenceLength(charSequence);
        return this;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    protected void clearCompatExtraKeys(@NonNull Bundle bundle) {
        super.clearCompatExtraKeys(bundle);
        bundle.remove("android.bigText");
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    protected String getClassName() {
        return TEMPLATE_CLASS_NAME;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    protected void restoreFromCompatExtras(@NonNull Bundle bundle) {
        super.restoreFromCompatExtras(bundle);
        this.mBigText = bundle.getCharSequence("android.bigText");
    }

    @NonNull
    public NotificationCompat$BigTextStyle setBigContentTitle(@Nullable CharSequence charSequence) {
        ((NotificationCompat.Style) this).mBigContentTitle = NotificationCompat.Builder.limitCharSequenceLength(charSequence);
        return this;
    }

    @NonNull
    public NotificationCompat$BigTextStyle setSummaryText(@Nullable CharSequence charSequence) {
        ((NotificationCompat.Style) this).mSummaryText = NotificationCompat.Builder.limitCharSequenceLength(charSequence);
        ((NotificationCompat.Style) this).mSummaryTextSet = true;
        return this;
    }

    public NotificationCompat$BigTextStyle(@Nullable NotificationCompat.Builder builder) {
        setBuilder(builder);
    }
}
