package androidx.core.view;

import android.view.ContentInfo;
import android.view.OnReceiveContentListener;
import android.view.View;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
@RequiresApi(31)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class ViewCompat$Api31Impl {
    private ViewCompat$Api31Impl() {
    }

    @Nullable
    @DoNotInline
    public static String[] getReceiveContentMimeTypes(@NonNull View view) {
        return view.getReceiveContentMimeTypes();
    }

    @Nullable
    @DoNotInline
    public static ContentInfoCompat performReceiveContent(@NonNull View view, @NonNull ContentInfoCompat contentInfoCompat) {
        ContentInfo contentInfo = contentInfoCompat.toContentInfo();
        ContentInfo performReceiveContent = view.performReceiveContent(contentInfo);
        if (performReceiveContent == null) {
            return null;
        }
        return performReceiveContent == contentInfo ? contentInfoCompat : ContentInfoCompat.toContentInfoCompat(performReceiveContent);
    }

    @DoNotInline
    public static void setOnReceiveContentListener(@NonNull View view, @Nullable String[] strArr, @Nullable final OnReceiveContentListener onReceiveContentListener) {
        if (onReceiveContentListener == null) {
            view.setOnReceiveContentListener(strArr, null);
        } else {
            view.setOnReceiveContentListener(strArr, new OnReceiveContentListener(onReceiveContentListener) { // from class: androidx.core.view.ViewCompat$OnReceiveContentListenerAdapter

                @NonNull
                private final OnReceiveContentListener mJetpackListener;

                {
                    this.mJetpackListener = onReceiveContentListener;
                }

                @Override // android.view.OnReceiveContentListener
                @Nullable
                public ContentInfo onReceiveContent(@NonNull View view2, @NonNull ContentInfo contentInfo) {
                    ContentInfoCompat contentInfoCompat = ContentInfoCompat.toContentInfoCompat(contentInfo);
                    ContentInfoCompat onReceiveContent = this.mJetpackListener.onReceiveContent(view2, contentInfoCompat);
                    if (onReceiveContent == null) {
                        return null;
                    }
                    return onReceiveContent == contentInfoCompat ? contentInfo : onReceiveContent.toContentInfo();
                }
            });
        }
    }
}
