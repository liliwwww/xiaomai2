package android.support.v4.media;

import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.os.ResultReceiver;
import androidx.media.MediaBrowserServiceCompat;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class MediaBrowserCompat$SearchResultReceiver extends ResultReceiver {
    private final MediaBrowserCompat.SearchCallback mCallback;
    private final Bundle mExtras;
    private final String mQuery;

    MediaBrowserCompat$SearchResultReceiver(String str, Bundle bundle, MediaBrowserCompat.SearchCallback searchCallback, Handler handler) {
        super(handler);
        this.mQuery = str;
        this.mExtras = bundle;
        this.mCallback = searchCallback;
    }

    protected void onReceiveResult(int i, Bundle bundle) {
        MediaSessionCompat.ensureClassLoader(bundle);
        if (i != 0 || bundle == null || !bundle.containsKey(MediaBrowserServiceCompat.KEY_SEARCH_RESULTS)) {
            this.mCallback.onError(this.mQuery, this.mExtras);
            return;
        }
        Parcelable[] parcelableArray = bundle.getParcelableArray(MediaBrowserServiceCompat.KEY_SEARCH_RESULTS);
        ArrayList arrayList = null;
        if (parcelableArray != null) {
            arrayList = new ArrayList();
            for (Parcelable parcelable : parcelableArray) {
                arrayList.add((MediaBrowserCompat$MediaItem) parcelable);
            }
        }
        this.mCallback.onSearchResult(this.mQuery, this.mExtras, arrayList);
    }
}
