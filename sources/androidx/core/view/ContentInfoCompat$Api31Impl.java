package androidx.core.view;

import android.content.ClipData;
import android.util.Pair;
import android.view.ContentInfo;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.Objects;
import java.util.function.Predicate;
import tb.d70;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
@RequiresApi(31)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class ContentInfoCompat$Api31Impl {
    private ContentInfoCompat$Api31Impl() {
    }

    @NonNull
    @DoNotInline
    public static Pair<ContentInfo, ContentInfo> partition(@NonNull ContentInfo contentInfo, @NonNull Predicate<ClipData.Item> predicate) {
        ClipData clip = contentInfo.getClip();
        if (clip.getItemCount() != 1) {
            Objects.requireNonNull(predicate);
            Pair partition = ContentInfoCompat.partition(clip, new d70(predicate));
            return partition.first == null ? Pair.create(null, contentInfo) : partition.second == null ? Pair.create(contentInfo, null) : Pair.create(new ContentInfo.Builder(contentInfo).setClip((ClipData) partition.first).build(), new ContentInfo.Builder(contentInfo).setClip((ClipData) partition.second).build());
        }
        boolean test = predicate.test(clip.getItemAt(0));
        ContentInfo contentInfo2 = test ? contentInfo : null;
        if (test) {
            contentInfo = null;
        }
        return Pair.create(contentInfo2, contentInfo);
    }
}
