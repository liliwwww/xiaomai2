package androidx.compose.p004ui.input.pointer;

import android.view.MotionEvent;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.compose.p004ui.geometry.OffsetKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@RequiresApi(29)
/* loaded from: classes.dex */
final class MotionEventHelper {

    @NotNull
    public static final MotionEventHelper INSTANCE = new MotionEventHelper();

    private MotionEventHelper() {
    }

    @DoNotInline
    /* renamed from: toRawOffset-dBAh8RU, reason: not valid java name */
    public final long m4015toRawOffsetdBAh8RU(@NotNull MotionEvent motionEvent, int i) {
        Intrinsics.checkNotNullParameter(motionEvent, "motionEvent");
        return OffsetKt.Offset(motionEvent.getRawX(i), motionEvent.getRawY(i));
    }
}
