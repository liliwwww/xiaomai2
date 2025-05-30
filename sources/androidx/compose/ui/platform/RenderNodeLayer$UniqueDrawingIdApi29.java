package androidx.compose.ui.platform;

import android.view.View;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
@RequiresApi(29)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class RenderNodeLayer$UniqueDrawingIdApi29 {

    @NotNull
    public static final RenderNodeLayer$UniqueDrawingIdApi29 INSTANCE = new RenderNodeLayer$UniqueDrawingIdApi29();

    private RenderNodeLayer$UniqueDrawingIdApi29() {
    }

    @JvmStatic
    @DoNotInline
    public static final long getUniqueDrawingId(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return view.getUniqueDrawingId();
    }
}
