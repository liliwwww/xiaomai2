package androidx.appcompat.widget;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ContentInfoCompat$Builder;
import androidx.core.view.ViewCompat;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class AppCompatReceiveContentHelper {
    private static final String LOG_TAG = "ReceiveContent";

    private AppCompatReceiveContentHelper() {
    }

    static boolean maybeHandleDragEventViaPerformReceiveContent(@NonNull View view, @NonNull DragEvent dragEvent) {
        int i = Build.VERSION.SDK_INT;
        if (i < 31 && i >= 24 && dragEvent.getLocalState() == null && ViewCompat.getOnReceiveContentMimeTypes(view) != null) {
            Activity tryGetActivity = tryGetActivity(view);
            if (tryGetActivity == null) {
                Log.i(LOG_TAG, "Can't handle drop: no activity: view=" + view);
                return false;
            }
            if (dragEvent.getAction() == 1) {
                return !(view instanceof TextView);
            }
            if (dragEvent.getAction() == 3) {
                return view instanceof TextView ? OnDropApi24Impl.onDropForTextView(dragEvent, (TextView) view, tryGetActivity) : OnDropApi24Impl.onDropForView(dragEvent, view, tryGetActivity);
            }
        }
        return false;
    }

    static boolean maybeHandleMenuActionViaPerformReceiveContent(@NonNull TextView textView, int i) {
        if (Build.VERSION.SDK_INT >= 31 || ViewCompat.getOnReceiveContentMimeTypes(textView) == null || !(i == 16908322 || i == 16908337)) {
            return false;
        }
        ClipboardManager clipboardManager = (ClipboardManager) textView.getContext().getSystemService("clipboard");
        ClipData primaryClip = clipboardManager == null ? null : com.alibaba.wireless.security.aopsdk.replace.android.content.ClipboardManager.getPrimaryClip(clipboardManager);
        if (primaryClip != null && primaryClip.getItemCount() > 0) {
            ViewCompat.performReceiveContent(textView, new ContentInfoCompat$Builder(primaryClip, 1).setFlags(i != 16908322 ? 1 : 0).build());
        }
        return true;
    }

    @Nullable
    static Activity tryGetActivity(@NonNull View view) {
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
        }
        return null;
    }
}
