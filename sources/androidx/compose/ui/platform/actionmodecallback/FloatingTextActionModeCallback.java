package androidx.compose.ui.platform.actionmodecallback;

import android.graphics.Rect;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@RequiresApi(23)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class FloatingTextActionModeCallback extends ActionMode.Callback2 {

    @NotNull
    private final TextActionModeCallback callback;

    public FloatingTextActionModeCallback(@NotNull TextActionModeCallback textActionModeCallback) {
        Intrinsics.checkNotNullParameter(textActionModeCallback, "callback");
        this.callback = textActionModeCallback;
    }

    @Override // android.view.ActionMode.Callback
    public boolean onActionItemClicked(@Nullable ActionMode actionMode, @Nullable MenuItem menuItem) {
        return this.callback.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    public boolean onCreateActionMode(@Nullable ActionMode actionMode, @Nullable Menu menu) {
        return this.callback.onCreateActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    public void onDestroyActionMode(@Nullable ActionMode actionMode) {
        this.callback.onDestroyActionMode();
    }

    @Override // android.view.ActionMode.Callback2
    public void onGetContentRect(@Nullable ActionMode actionMode, @Nullable View view, @Nullable Rect rect) {
        androidx.compose.ui.geometry.Rect rect2 = this.callback.getRect();
        if (rect != null) {
            rect.set((int) rect2.getLeft(), (int) rect2.getTop(), (int) rect2.getRight(), (int) rect2.getBottom());
        }
    }

    @Override // android.view.ActionMode.Callback
    public boolean onPrepareActionMode(@Nullable ActionMode actionMode, @Nullable Menu menu) {
        return this.callback.onPrepareActionMode(actionMode, menu);
    }
}
