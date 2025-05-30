package androidx.core.view;

import android.app.Activity;
import android.view.DragAndDropPermissions;
import android.view.DragEvent;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* compiled from: Taobao */
@RequiresApi(24)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class DragAndDropPermissionsCompat$Api24Impl {
    private DragAndDropPermissionsCompat$Api24Impl() {
    }

    @DoNotInline
    static void release(DragAndDropPermissions dragAndDropPermissions) {
        dragAndDropPermissions.release();
    }

    @DoNotInline
    static DragAndDropPermissions requestDragAndDropPermissions(Activity activity, DragEvent dragEvent) {
        return activity.requestDragAndDropPermissions(dragEvent);
    }
}
