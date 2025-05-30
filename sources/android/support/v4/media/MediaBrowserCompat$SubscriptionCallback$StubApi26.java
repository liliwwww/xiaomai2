package android.support.v4.media;

import android.os.Bundle;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.MediaBrowserCompatApi21;
import android.support.v4.media.MediaBrowserCompatApi26;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class MediaBrowserCompat$SubscriptionCallback$StubApi26 extends MediaBrowserCompat$SubscriptionCallback$StubApi21 implements MediaBrowserCompatApi26.SubscriptionCallback {
    final /* synthetic */ MediaBrowserCompat.SubscriptionCallback this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MediaBrowserCompat$SubscriptionCallback$StubApi26(final MediaBrowserCompat.SubscriptionCallback subscriptionCallback) {
        new MediaBrowserCompatApi21.SubscriptionCallback() { // from class: android.support.v4.media.MediaBrowserCompat$SubscriptionCallback$StubApi21
            List<MediaBrowserCompat.MediaItem> applyOptions(List<MediaBrowserCompat.MediaItem> list, Bundle bundle) {
                if (list == null) {
                    return null;
                }
                int i = bundle.getInt(MediaBrowserCompat.EXTRA_PAGE, -1);
                int i2 = bundle.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1);
                if (i == -1 && i2 == -1) {
                    return list;
                }
                int i3 = i2 * i;
                int i4 = i3 + i2;
                if (i < 0 || i2 < 1 || i3 >= list.size()) {
                    return Collections.emptyList();
                }
                if (i4 > list.size()) {
                    i4 = list.size();
                }
                return list.subList(i3, i4);
            }

            public void onChildrenLoaded(@NonNull String str, List<?> list) {
                WeakReference weakReference = subscriptionCallback.mSubscriptionRef;
                MediaBrowserCompat.Subscription subscription = weakReference == null ? null : (MediaBrowserCompat.Subscription) weakReference.get();
                if (subscription == null) {
                    subscriptionCallback.onChildrenLoaded(str, MediaBrowserCompat.MediaItem.fromMediaItemList(list));
                    return;
                }
                List<MediaBrowserCompat.MediaItem> fromMediaItemList = MediaBrowserCompat.MediaItem.fromMediaItemList(list);
                List<MediaBrowserCompat.SubscriptionCallback> callbacks = subscription.getCallbacks();
                List<Bundle> optionsList = subscription.getOptionsList();
                for (int i = 0; i < callbacks.size(); i++) {
                    Bundle bundle = optionsList.get(i);
                    if (bundle == null) {
                        subscriptionCallback.onChildrenLoaded(str, fromMediaItemList);
                    } else {
                        subscriptionCallback.onChildrenLoaded(str, applyOptions(fromMediaItemList, bundle), bundle);
                    }
                }
            }

            public void onError(@NonNull String str) {
                subscriptionCallback.onError(str);
            }
        };
        this.this$0 = subscriptionCallback;
    }

    public void onChildrenLoaded(@NonNull String str, List<?> list, @NonNull Bundle bundle) {
        this.this$0.onChildrenLoaded(str, MediaBrowserCompat.MediaItem.fromMediaItemList(list), bundle);
    }

    public void onError(@NonNull String str, @NonNull Bundle bundle) {
        this.this$0.onError(str, bundle);
    }
}
