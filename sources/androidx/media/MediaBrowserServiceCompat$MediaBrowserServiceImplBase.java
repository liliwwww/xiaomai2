package androidx.media;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Messenger;
import android.support.v4.media.session.MediaSessionCompat$Token;
import androidx.annotation.NonNull;
import androidx.core.util.Pair;
import androidx.media.MediaBrowserServiceCompat;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class MediaBrowserServiceCompat$MediaBrowserServiceImplBase implements MediaBrowserServiceCompat$MediaBrowserServiceImpl {
    private Messenger mMessenger;
    final /* synthetic */ MediaBrowserServiceCompat this$0;

    MediaBrowserServiceCompat$MediaBrowserServiceImplBase(MediaBrowserServiceCompat mediaBrowserServiceCompat) {
        this.this$0 = mediaBrowserServiceCompat;
    }

    @Override // androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImpl
    public Bundle getBrowserRootHints() {
        MediaBrowserServiceCompat.ConnectionRecord connectionRecord = this.this$0.mCurConnection;
        if (connectionRecord == null) {
            throw new IllegalStateException("This should be called inside of onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
        }
        if (connectionRecord.rootHints == null) {
            return null;
        }
        return new Bundle(this.this$0.mCurConnection.rootHints);
    }

    @Override // androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImpl
    public MediaSessionManager$RemoteUserInfo getCurrentBrowserInfo() {
        MediaBrowserServiceCompat.ConnectionRecord connectionRecord = this.this$0.mCurConnection;
        if (connectionRecord != null) {
            return connectionRecord.browserInfo;
        }
        throw new IllegalStateException("This should be called inside of onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
    }

    @Override // androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImpl
    public void notifyChildrenChanged(@NonNull String str, Bundle bundle) {
        this.this$0.mHandler.post(new 2(this, str, bundle));
    }

    void notifyChildrenChangedOnHandler(MediaBrowserServiceCompat.ConnectionRecord connectionRecord, String str, Bundle bundle) {
        List<Pair> list = (List) connectionRecord.subscriptions.get(str);
        if (list != null) {
            for (Pair pair : list) {
                if (MediaBrowserCompatUtils.hasDuplicatedItems(bundle, (Bundle) pair.second)) {
                    this.this$0.performLoadChildren(str, connectionRecord, (Bundle) pair.second, bundle);
                }
            }
        }
    }

    @Override // androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImpl
    public IBinder onBind(Intent intent) {
        if ("android.media.browse.MediaBrowserService".equals(intent.getAction())) {
            return this.mMessenger.getBinder();
        }
        return null;
    }

    @Override // androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImpl
    public void onCreate() {
        this.mMessenger = new Messenger((Handler) this.this$0.mHandler);
    }

    @Override // androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImpl
    public void setSessionToken(MediaSessionCompat$Token mediaSessionCompat$Token) {
        this.this$0.mHandler.post(new 1(this, mediaSessionCompat$Token));
    }

    @Override // androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImpl
    public void notifyChildrenChanged(@NonNull MediaSessionManager$RemoteUserInfo mediaSessionManager$RemoteUserInfo, @NonNull String str, Bundle bundle) {
        this.this$0.mHandler.post(new 3(this, mediaSessionManager$RemoteUserInfo, str, bundle));
    }
}
