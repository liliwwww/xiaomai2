package android.support.v4.media;

import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.media.MediaBrowserCompat;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public abstract class MediaBrowserCompat$SubscriptionCallback {
    final Object mSubscriptionCallbackObj;
    WeakReference<MediaBrowserCompat.Subscription> mSubscriptionRef;
    final IBinder mToken = new Binder();

    public MediaBrowserCompat$SubscriptionCallback() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 26) {
            this.mSubscriptionCallbackObj = MediaBrowserCompatApi26.createSubscriptionCallback(new StubApi26(this));
        } else if (i >= 21) {
            this.mSubscriptionCallbackObj = MediaBrowserCompatApi21.createSubscriptionCallback(new StubApi21(this));
        } else {
            this.mSubscriptionCallbackObj = null;
        }
    }

    public void onChildrenLoaded(@NonNull String str, @NonNull List<MediaBrowserCompat$MediaItem> list) {
    }

    public void onChildrenLoaded(@NonNull String str, @NonNull List<MediaBrowserCompat$MediaItem> list, @NonNull Bundle bundle) {
    }

    public void onError(@NonNull String str) {
    }

    public void onError(@NonNull String str, @NonNull Bundle bundle) {
    }

    void setSubscription(MediaBrowserCompat.Subscription subscription) {
        this.mSubscriptionRef = new WeakReference<>(subscription);
    }
}
