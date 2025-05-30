package androidx.compose.foundation.layout;

import android.graphics.Insets;
import androidx.annotation.RequiresApi;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@RequiresApi(30)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
interface SideCalculator {

    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;

    @NotNull
    Insets adjustInsets(@NotNull Insets insets, int i);

    /* renamed from: consumedOffsets-MK-Hz9U, reason: not valid java name */
    long mo237consumedOffsetsMKHz9U(long j);

    /* renamed from: consumedVelocity-QWom1Mo, reason: not valid java name */
    long mo238consumedVelocityQWom1Mo(long j, float f);

    float hideMotion(float f, float f2);

    float motionOf(float f, float f2);

    float showMotion(float f, float f2);

    int valueOf(@NotNull Insets insets);
}
