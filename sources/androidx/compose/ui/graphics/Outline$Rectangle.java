package androidx.compose.ui.graphics;

import androidx.compose.runtime.Immutable;
import androidx.compose.ui.geometry.Rect;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Immutable
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class Outline$Rectangle extends Outline {

    @NotNull
    private final Rect rect;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Outline$Rectangle(@NotNull Rect rect) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(rect, "rect");
        this.rect = rect;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Outline$Rectangle) && Intrinsics.areEqual(this.rect, ((Outline$Rectangle) obj).rect);
    }

    @NotNull
    public Rect getBounds() {
        return this.rect;
    }

    @NotNull
    public final Rect getRect() {
        return this.rect;
    }

    public int hashCode() {
        return this.rect.hashCode();
    }
}
