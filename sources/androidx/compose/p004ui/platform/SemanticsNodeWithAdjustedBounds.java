package androidx.compose.p004ui.platform;

import android.graphics.Rect;
import androidx.compose.p004ui.semantics.SemanticsNode;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class SemanticsNodeWithAdjustedBounds {

    @NotNull
    private final Rect adjustedBounds;

    @NotNull
    private final SemanticsNode semanticsNode;

    public SemanticsNodeWithAdjustedBounds(@NotNull SemanticsNode semanticsNode, @NotNull Rect rect) {
        Intrinsics.checkNotNullParameter(semanticsNode, "semanticsNode");
        Intrinsics.checkNotNullParameter(rect, "adjustedBounds");
        this.semanticsNode = semanticsNode;
        this.adjustedBounds = rect;
    }

    @NotNull
    public final Rect getAdjustedBounds() {
        return this.adjustedBounds;
    }

    @NotNull
    public final SemanticsNode getSemanticsNode() {
        return this.semanticsNode;
    }
}
