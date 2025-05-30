package androidx.compose.foundation;

import android.os.Build;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class MagnifierStyle$Companion {
    private MagnifierStyle$Companion() {
    }

    public /* synthetic */ MagnifierStyle$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @ExperimentalFoundationApi
    public static /* synthetic */ void getDefault$annotations() {
    }

    @ExperimentalFoundationApi
    public static /* synthetic */ void getTextDefault$annotations() {
    }

    public static /* synthetic */ boolean isStyleSupported$foundation_release$default(MagnifierStyle$Companion magnifierStyle$Companion, MagnifierStyle magnifierStyle, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = Build.VERSION.SDK_INT;
        }
        return magnifierStyle$Companion.isStyleSupported$foundation_release(magnifierStyle, i);
    }

    @NotNull
    public final MagnifierStyle getDefault() {
        return MagnifierStyle.access$getDefault$cp();
    }

    @NotNull
    public final MagnifierStyle getTextDefault() {
        return MagnifierStyle.access$getTextDefault$cp();
    }

    public final boolean isStyleSupported$foundation_release(@NotNull MagnifierStyle magnifierStyle, int i) {
        Intrinsics.checkNotNullParameter(magnifierStyle, "style");
        return MagnifierKt.isPlatformMagnifierSupported(i) && !magnifierStyle.getFishEyeEnabled$foundation_release() && (magnifierStyle.getUseTextDefault$foundation_release() || Intrinsics.areEqual(magnifierStyle, getDefault()) || i >= 29);
    }
}
