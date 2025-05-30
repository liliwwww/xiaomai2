package android.support.v4.media.session;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.media.session.MediaSessionCompat;
import androidx.annotation.RequiresApi;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
@RequiresApi(24)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class MediaSessionCompat$Callback$StubApi24 extends MediaSessionCompat$Callback$StubApi23 implements MediaSessionCompatApi24$Callback {
    final /* synthetic */ MediaSessionCompat.Callback this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MediaSessionCompat$Callback$StubApi24(MediaSessionCompat.Callback callback) {
        super(callback);
        this.this$0 = callback;
    }

    @Override // android.support.v4.media.session.MediaSessionCompatApi24$Callback
    public void onPrepare() {
        this.this$0.onPrepare();
    }

    @Override // android.support.v4.media.session.MediaSessionCompatApi24$Callback
    public void onPrepareFromMediaId(String str, Bundle bundle) {
        this.this$0.onPrepareFromMediaId(str, bundle);
    }

    @Override // android.support.v4.media.session.MediaSessionCompatApi24$Callback
    public void onPrepareFromSearch(String str, Bundle bundle) {
        this.this$0.onPrepareFromSearch(str, bundle);
    }

    @Override // android.support.v4.media.session.MediaSessionCompatApi24$Callback
    public void onPrepareFromUri(Uri uri, Bundle bundle) {
        this.this$0.onPrepareFromUri(uri, bundle);
    }
}
