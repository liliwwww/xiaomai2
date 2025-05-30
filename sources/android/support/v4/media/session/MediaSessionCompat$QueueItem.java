package android.support.v4.media.session;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.session.MediaSessionCompatApi21;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class MediaSessionCompat$QueueItem implements Parcelable {
    public static final Parcelable.Creator<MediaSessionCompat$QueueItem> CREATOR = new 1();
    public static final int UNKNOWN_ID = -1;
    private final MediaDescriptionCompat mDescription;
    private final long mId;
    private Object mItem;

    public MediaSessionCompat$QueueItem(MediaDescriptionCompat mediaDescriptionCompat, long j) {
        this(null, mediaDescriptionCompat, j);
    }

    public static MediaSessionCompat$QueueItem fromQueueItem(Object obj) {
        if (obj == null || Build.VERSION.SDK_INT < 21) {
            return null;
        }
        return new MediaSessionCompat$QueueItem(obj, MediaDescriptionCompat.fromMediaDescription(MediaSessionCompatApi21.QueueItem.getDescription(obj)), MediaSessionCompatApi21.QueueItem.getQueueId(obj));
    }

    public static List<MediaSessionCompat$QueueItem> fromQueueItemList(List<?> list) {
        if (list == null || Build.VERSION.SDK_INT < 21) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<?> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(fromQueueItem(it.next()));
        }
        return arrayList;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public MediaDescriptionCompat getDescription() {
        return this.mDescription;
    }

    public long getQueueId() {
        return this.mId;
    }

    public Object getQueueItem() {
        Object obj = this.mItem;
        if (obj != null || Build.VERSION.SDK_INT < 21) {
            return obj;
        }
        Object createItem = MediaSessionCompatApi21.QueueItem.createItem(this.mDescription.getMediaDescription(), this.mId);
        this.mItem = createItem;
        return createItem;
    }

    public String toString() {
        return "MediaSession.QueueItem {Description=" + this.mDescription + ", Id=" + this.mId + " }";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        this.mDescription.writeToParcel(parcel, i);
        parcel.writeLong(this.mId);
    }

    private MediaSessionCompat$QueueItem(Object obj, MediaDescriptionCompat mediaDescriptionCompat, long j) {
        if (mediaDescriptionCompat == null) {
            throw new IllegalArgumentException("Description cannot be null.");
        }
        if (j == -1) {
            throw new IllegalArgumentException("Id cannot be QueueItem.UNKNOWN_ID");
        }
        this.mDescription = mediaDescriptionCompat;
        this.mId = j;
        this.mItem = obj;
    }

    MediaSessionCompat$QueueItem(Parcel parcel) {
        this.mDescription = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
        this.mId = parcel.readLong();
    }
}
