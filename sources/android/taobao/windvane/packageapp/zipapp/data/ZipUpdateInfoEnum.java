package android.taobao.windvane.packageapp.zipapp.data;

import android.support.v4.media.session.PlaybackStateCompat;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public enum ZipUpdateInfoEnum {
    ZIP_UPDATE_INFO_DELETE(PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM),
    ZIP_APP_TYPE_NORMAL(0);

    private long value;

    ZipUpdateInfoEnum(long j) {
        this.value = j;
    }

    public long getValue() {
        return this.value;
    }

    public void setValue(long j) {
        this.value = j;
    }
}
