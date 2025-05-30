package androidx.compose.p004ui.graphics;

import android.graphics.Canvas;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class CanvasHolder {

    @NotNull
    private final AndroidCanvas androidCanvas = new AndroidCanvas();

    @PublishedApi
    public static /* synthetic */ void getAndroidCanvas$annotations() {
    }

    public final void drawInto(@NotNull Canvas canvas, @NotNull Function1<? super Canvas, Unit> function1) {
        Intrinsics.checkNotNullParameter(canvas, "targetCanvas");
        Intrinsics.checkNotNullParameter(function1, "block");
        Canvas internalCanvas = getAndroidCanvas().getInternalCanvas();
        getAndroidCanvas().setInternalCanvas(canvas);
        function1.invoke(getAndroidCanvas());
        getAndroidCanvas().setInternalCanvas(internalCanvas);
    }

    @NotNull
    public final AndroidCanvas getAndroidCanvas() {
        return this.androidCanvas;
    }
}
