package androidx.compose.material.ripple;

import android.graphics.drawable.RippleDrawable;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
@RequiresApi(23)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class UnprojectedRipple$MRadiusHelper {

    @NotNull
    public static final UnprojectedRipple$MRadiusHelper INSTANCE = new UnprojectedRipple$MRadiusHelper();

    private UnprojectedRipple$MRadiusHelper() {
    }

    @DoNotInline
    public final void setRadius(@NotNull RippleDrawable rippleDrawable, int i) {
        Intrinsics.checkNotNullParameter(rippleDrawable, "ripple");
        rippleDrawable.setRadius(i);
    }
}
