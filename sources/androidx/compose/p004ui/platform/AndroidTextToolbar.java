package androidx.compose.p004ui.platform;

import android.os.Build;
import android.view.ActionMode;
import android.view.View;
import androidx.compose.p004ui.geometry.Rect;
import androidx.compose.p004ui.platform.actionmodecallback.FloatingTextActionModeCallback;
import androidx.compose.p004ui.platform.actionmodecallback.PrimaryTextActionModeCallback;
import androidx.compose.p004ui.platform.actionmodecallback.TextActionModeCallback;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class AndroidTextToolbar implements TextToolbar {

    @Nullable
    private ActionMode actionMode;

    @NotNull
    private TextToolbarStatus status;

    @NotNull
    private final TextActionModeCallback textActionModeCallback;

    @NotNull
    private final View view;

    public AndroidTextToolbar(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.view = view;
        this.textActionModeCallback = new TextActionModeCallback(new Function0<Unit>() { // from class: androidx.compose.ui.platform.AndroidTextToolbar$textActionModeCallback$1
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m4486invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m4486invoke() {
                AndroidTextToolbar.this.actionMode = null;
            }
        }, null, null, null, null, null, 62, null);
        this.status = TextToolbarStatus.Hidden;
    }

    @Override // androidx.compose.p004ui.platform.TextToolbar
    @NotNull
    public TextToolbarStatus getStatus() {
        return this.status;
    }

    @Override // androidx.compose.p004ui.platform.TextToolbar
    public void hide() {
        this.status = TextToolbarStatus.Hidden;
        ActionMode actionMode = this.actionMode;
        if (actionMode != null) {
            actionMode.finish();
        }
        this.actionMode = null;
    }

    @Override // androidx.compose.p004ui.platform.TextToolbar
    public void showMenu(@NotNull Rect rect, @Nullable Function0<Unit> function0, @Nullable Function0<Unit> function02, @Nullable Function0<Unit> function03, @Nullable Function0<Unit> function04) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        this.textActionModeCallback.setRect(rect);
        this.textActionModeCallback.setOnCopyRequested(function0);
        this.textActionModeCallback.setOnCutRequested(function03);
        this.textActionModeCallback.setOnPasteRequested(function02);
        this.textActionModeCallback.setOnSelectAllRequested(function04);
        ActionMode actionMode = this.actionMode;
        if (actionMode == null) {
            this.status = TextToolbarStatus.Shown;
            this.actionMode = Build.VERSION.SDK_INT >= 23 ? TextToolbarHelperMethods.INSTANCE.startActionMode(this.view, new FloatingTextActionModeCallback(this.textActionModeCallback), 1) : this.view.startActionMode(new PrimaryTextActionModeCallback(this.textActionModeCallback));
        } else if (actionMode != null) {
            actionMode.invalidate();
        }
    }
}
