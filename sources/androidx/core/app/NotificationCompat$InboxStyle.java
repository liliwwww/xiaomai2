package androidx.core.app;

import android.app.Notification;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.app.NotificationCompat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class NotificationCompat$InboxStyle extends NotificationCompat.Style {
    private static final String TEMPLATE_CLASS_NAME = "androidx.core.app.NotificationCompat$InboxStyle";
    private ArrayList<CharSequence> mTexts = new ArrayList<>();

    public NotificationCompat$InboxStyle() {
    }

    @NonNull
    public NotificationCompat$InboxStyle addLine(@Nullable CharSequence charSequence) {
        if (charSequence != null) {
            this.mTexts.add(NotificationCompat.Builder.limitCharSequenceLength(charSequence));
        }
        return this;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        if (Build.VERSION.SDK_INT >= 16) {
            Notification.InboxStyle bigContentTitle = new Notification.InboxStyle(notificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(((NotificationCompat.Style) this).mBigContentTitle);
            if (((NotificationCompat.Style) this).mSummaryTextSet) {
                bigContentTitle.setSummaryText(((NotificationCompat.Style) this).mSummaryText);
            }
            Iterator<CharSequence> it = this.mTexts.iterator();
            while (it.hasNext()) {
                bigContentTitle.addLine(it.next());
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    protected void clearCompatExtraKeys(@NonNull Bundle bundle) {
        super.clearCompatExtraKeys(bundle);
        bundle.remove("android.textLines");
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    protected String getClassName() {
        return TEMPLATE_CLASS_NAME;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    protected void restoreFromCompatExtras(@NonNull Bundle bundle) {
        super.restoreFromCompatExtras(bundle);
        this.mTexts.clear();
        if (bundle.containsKey("android.textLines")) {
            Collections.addAll(this.mTexts, bundle.getCharSequenceArray("android.textLines"));
        }
    }

    @NonNull
    public NotificationCompat$InboxStyle setBigContentTitle(@Nullable CharSequence charSequence) {
        ((NotificationCompat.Style) this).mBigContentTitle = NotificationCompat.Builder.limitCharSequenceLength(charSequence);
        return this;
    }

    @NonNull
    public NotificationCompat$InboxStyle setSummaryText(@Nullable CharSequence charSequence) {
        ((NotificationCompat.Style) this).mSummaryText = NotificationCompat.Builder.limitCharSequenceLength(charSequence);
        ((NotificationCompat.Style) this).mSummaryTextSet = true;
        return this;
    }

    public NotificationCompat$InboxStyle(@Nullable NotificationCompat.Builder builder) {
        setBuilder(builder);
    }
}
