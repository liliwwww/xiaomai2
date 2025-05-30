package android.support.v4.media.session;

import android.os.Bundle;
import android.os.ResultReceiver;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class MediaSessionCompat$MediaSessionImplBase$Command {
    public final String command;
    public final Bundle extras;
    public final ResultReceiver stub;

    public MediaSessionCompat$MediaSessionImplBase$Command(String str, Bundle bundle, ResultReceiver resultReceiver) {
        this.command = str;
        this.extras = bundle;
        this.stub = resultReceiver;
    }
}
