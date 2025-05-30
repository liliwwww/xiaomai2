package androidx.compose.ui.graphics;

import androidx.compose.runtime.Immutable;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.geometry.RoundRectKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Immutable
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class Outline$Rounded extends Outline {

    @NotNull
    private final RoundRect roundRect;

    @Nullable
    private final Path roundRectPath;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Outline$Rounded(@NotNull RoundRect roundRect) {
        super((DefaultConstructorMarker) null);
        boolean hasSameCornerRadius;
        Intrinsics.checkNotNullParameter(roundRect, "roundRect");
        Path path = null;
        this.roundRect = roundRect;
        hasSameCornerRadius = OutlineKt.hasSameCornerRadius(roundRect);
        if (!hasSameCornerRadius) {
            path = AndroidPath_androidKt.Path();
            path.addRoundRect(roundRect);
        }
        this.roundRectPath = path;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Outline$Rounded) && Intrinsics.areEqual(this.roundRect, ((Outline$Rounded) obj).roundRect);
    }

    @NotNull
    public Rect getBounds() {
        return RoundRectKt.getBoundingRect(this.roundRect);
    }

    @NotNull
    public final RoundRect getRoundRect() {
        return this.roundRect;
    }

    @Nullable
    public final Path getRoundRectPath$ui_graphics_release() {
        return this.roundRectPath;
    }

    public int hashCode() {
        return this.roundRect.hashCode();
    }
}
