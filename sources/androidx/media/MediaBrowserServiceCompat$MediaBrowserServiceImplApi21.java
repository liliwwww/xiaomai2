package androidx.media;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Messenger;
import android.os.Parcel;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.MediaSessionCompat$Token;
import androidx.annotation.RequiresApi;
import androidx.core.app.BundleCompat;
import androidx.core.util.Pair;
import androidx.media.MediaBrowserServiceCompat;
import androidx.media.MediaBrowserServiceCompatApi21;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: Taobao */
@RequiresApi(21)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class MediaBrowserServiceCompat$MediaBrowserServiceImplApi21 implements MediaBrowserServiceCompat$MediaBrowserServiceImpl, MediaBrowserServiceCompatApi21.ServiceCompatProxy {
    Messenger mMessenger;
    final List<Bundle> mRootExtrasList = new ArrayList();
    Object mServiceObj;
    final /* synthetic */ MediaBrowserServiceCompat this$0;

    MediaBrowserServiceCompat$MediaBrowserServiceImplApi21(MediaBrowserServiceCompat mediaBrowserServiceCompat) {
        this.this$0 = mediaBrowserServiceCompat;
    }

    @Override // androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImpl
    public Bundle getBrowserRootHints() {
        if (this.mMessenger == null) {
            return null;
        }
        MediaBrowserServiceCompat.ConnectionRecord connectionRecord = this.this$0.mCurConnection;
        if (connectionRecord == null) {
            throw new IllegalStateException("This should be called inside of onGetRoot, onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
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
        throw new IllegalStateException("This should be called inside of onGetRoot, onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
    }

    @Override // androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImpl
    public void notifyChildrenChanged(String str, Bundle bundle) {
        notifyChildrenChangedForFramework(str, bundle);
        notifyChildrenChangedForCompat(str, bundle);
    }

    void notifyChildrenChangedForCompat(final String str, final Bundle bundle) {
        this.this$0.mHandler.post(new Runnable() { // from class: androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi21.3
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = MediaBrowserServiceCompat$MediaBrowserServiceImplApi21.this.this$0.mConnections.keySet().iterator();
                while (it.hasNext()) {
                    MediaBrowserServiceCompat$MediaBrowserServiceImplApi21.this.notifyChildrenChangedForCompatOnHandler((MediaBrowserServiceCompat.ConnectionRecord) MediaBrowserServiceCompat$MediaBrowserServiceImplApi21.this.this$0.mConnections.get((IBinder) it.next()), str, bundle);
                }
            }
        });
    }

    void notifyChildrenChangedForCompatOnHandler(MediaBrowserServiceCompat.ConnectionRecord connectionRecord, String str, Bundle bundle) {
        List<Pair> list = (List) connectionRecord.subscriptions.get(str);
        if (list != null) {
            for (Pair pair : list) {
                if (MediaBrowserCompatUtils.hasDuplicatedItems(bundle, (Bundle) pair.second)) {
                    this.this$0.performLoadChildren(str, connectionRecord, (Bundle) pair.second, bundle);
                }
            }
        }
    }

    void notifyChildrenChangedForFramework(String str, Bundle bundle) {
        MediaBrowserServiceCompatApi21.notifyChildrenChanged(this.mServiceObj, str);
    }

    @Override // androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImpl
    public IBinder onBind(Intent intent) {
        return MediaBrowserServiceCompatApi21.onBind(this.mServiceObj, intent);
    }

    @Override // androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImpl
    public void onCreate() {
        Object createService = MediaBrowserServiceCompatApi21.createService(this.this$0, this);
        this.mServiceObj = createService;
        MediaBrowserServiceCompatApi21.onCreate(createService);
    }

    @Override // androidx.media.MediaBrowserServiceCompatApi21.ServiceCompatProxy
    public MediaBrowserServiceCompatApi21.BrowserRoot onGetRoot(String str, int i, Bundle bundle) {
        Bundle bundle2;
        if (bundle == null || bundle.getInt("extra_client_version", 0) == 0) {
            bundle2 = null;
        } else {
            bundle.remove("extra_client_version");
            this.mMessenger = new Messenger((Handler) this.this$0.mHandler);
            bundle2 = new Bundle();
            bundle2.putInt("extra_service_version", 2);
            BundleCompat.putBinder(bundle2, "extra_messenger", this.mMessenger.getBinder());
            MediaSessionCompat$Token mediaSessionCompat$Token = this.this$0.mSession;
            if (mediaSessionCompat$Token != null) {
                IMediaSession extraBinder = mediaSessionCompat$Token.getExtraBinder();
                BundleCompat.putBinder(bundle2, "extra_session_binder", extraBinder == null ? null : extraBinder.asBinder());
            } else {
                this.mRootExtrasList.add(bundle2);
            }
        }
        MediaBrowserServiceCompat mediaBrowserServiceCompat = this.this$0;
        mediaBrowserServiceCompat.mCurConnection = new MediaBrowserServiceCompat.ConnectionRecord(mediaBrowserServiceCompat, str, -1, i, bundle, (MediaBrowserServiceCompat.ServiceCallbacks) null);
        MediaBrowserServiceCompat$BrowserRoot onGetRoot = this.this$0.onGetRoot(str, i, bundle);
        this.this$0.mCurConnection = null;
        if (onGetRoot == null) {
            return null;
        }
        if (bundle2 == null) {
            bundle2 = onGetRoot.getExtras();
        } else if (onGetRoot.getExtras() != null) {
            bundle2.putAll(onGetRoot.getExtras());
        }
        return new MediaBrowserServiceCompatApi21.BrowserRoot(onGetRoot.getRootId(), bundle2);
    }

    @Override // androidx.media.MediaBrowserServiceCompatApi21.ServiceCompatProxy
    public void onLoadChildren(String str, final MediaBrowserServiceCompatApi21.ResultWrapper<List<Parcel>> resultWrapper) {
        this.this$0.onLoadChildren(str, new MediaBrowserServiceCompat.Result<List<MediaBrowserCompat.MediaItem>>(str) { // from class: androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi21.2
            public void detach() {
                resultWrapper.detach();
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            public void onResultSent(List<MediaBrowserCompat.MediaItem> list) {
                ArrayList arrayList;
                if (list != null) {
                    arrayList = new ArrayList();
                    for (MediaBrowserCompat.MediaItem mediaItem : list) {
                        Parcel obtain = Parcel.obtain();
                        mediaItem.writeToParcel(obtain, 0);
                        arrayList.add(obtain);
                    }
                } else {
                    arrayList = null;
                }
                resultWrapper.sendResult(arrayList);
            }
        });
    }

    @Override // androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImpl
    public void setSessionToken(final MediaSessionCompat$Token mediaSessionCompat$Token) {
        this.this$0.mHandler.postOrRun(new Runnable() { // from class: androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi21.1
            @Override // java.lang.Runnable
            public void run() {
                if (!MediaBrowserServiceCompat$MediaBrowserServiceImplApi21.this.mRootExtrasList.isEmpty()) {
                    IMediaSession extraBinder = mediaSessionCompat$Token.getExtraBinder();
                    if (extraBinder != null) {
                        Iterator<Bundle> it = MediaBrowserServiceCompat$MediaBrowserServiceImplApi21.this.mRootExtrasList.iterator();
                        while (it.hasNext()) {
                            BundleCompat.putBinder(it.next(), "extra_session_binder", extraBinder.asBinder());
                        }
                    }
                    MediaBrowserServiceCompat$MediaBrowserServiceImplApi21.this.mRootExtrasList.clear();
                }
                MediaBrowserServiceCompatApi21.setSessionToken(MediaBrowserServiceCompat$MediaBrowserServiceImplApi21.this.mServiceObj, mediaSessionCompat$Token.getToken());
            }
        });
    }

    void notifyChildrenChangedForCompat(final MediaSessionManager$RemoteUserInfo mediaSessionManager$RemoteUserInfo, final String str, final Bundle bundle) {
        this.this$0.mHandler.post(new Runnable() { // from class: androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi21.4
            @Override // java.lang.Runnable
            public void run() {
                for (int i = 0; i < MediaBrowserServiceCompat$MediaBrowserServiceImplApi21.this.this$0.mConnections.size(); i++) {
                    MediaBrowserServiceCompat.ConnectionRecord connectionRecord = (MediaBrowserServiceCompat.ConnectionRecord) MediaBrowserServiceCompat$MediaBrowserServiceImplApi21.this.this$0.mConnections.valueAt(i);
                    if (connectionRecord.browserInfo.equals(mediaSessionManager$RemoteUserInfo)) {
                        MediaBrowserServiceCompat$MediaBrowserServiceImplApi21.this.notifyChildrenChangedForCompatOnHandler(connectionRecord, str, bundle);
                    }
                }
            }
        });
    }

    @Override // androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImpl
    public void notifyChildrenChanged(MediaSessionManager$RemoteUserInfo mediaSessionManager$RemoteUserInfo, String str, Bundle bundle) {
        notifyChildrenChangedForCompat(mediaSessionManager$RemoteUserInfo, str, bundle);
    }
}
