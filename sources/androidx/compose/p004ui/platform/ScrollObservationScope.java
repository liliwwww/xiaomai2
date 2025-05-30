package androidx.compose.p004ui.platform;

import androidx.compose.p004ui.node.OwnerScope;
import androidx.compose.p004ui.semantics.ScrollAxisRange;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class ScrollObservationScope implements OwnerScope {

    @NotNull
    private final List<ScrollObservationScope> allScopes;

    @Nullable
    private ScrollAxisRange horizontalScrollAxisRange;

    @Nullable
    private Float oldXValue;

    @Nullable
    private Float oldYValue;
    private final int semanticsNodeId;

    @Nullable
    private ScrollAxisRange verticalScrollAxisRange;

    public ScrollObservationScope(int i, @NotNull List<ScrollObservationScope> list, @Nullable Float f, @Nullable Float f2, @Nullable ScrollAxisRange scrollAxisRange, @Nullable ScrollAxisRange scrollAxisRange2) {
        Intrinsics.checkNotNullParameter(list, "allScopes");
        this.semanticsNodeId = i;
        this.allScopes = list;
        this.oldXValue = f;
        this.oldYValue = f2;
        this.horizontalScrollAxisRange = scrollAxisRange;
        this.verticalScrollAxisRange = scrollAxisRange2;
    }

    @NotNull
    public final List<ScrollObservationScope> getAllScopes() {
        return this.allScopes;
    }

    @Nullable
    public final ScrollAxisRange getHorizontalScrollAxisRange() {
        return this.horizontalScrollAxisRange;
    }

    @Nullable
    public final Float getOldXValue() {
        return this.oldXValue;
    }

    @Nullable
    public final Float getOldYValue() {
        return this.oldYValue;
    }

    public final int getSemanticsNodeId() {
        return this.semanticsNodeId;
    }

    @Nullable
    public final ScrollAxisRange getVerticalScrollAxisRange() {
        return this.verticalScrollAxisRange;
    }

    @Override // androidx.compose.p004ui.node.OwnerScope
    public boolean isValid() {
        return this.allScopes.contains(this);
    }

    public final void setHorizontalScrollAxisRange(@Nullable ScrollAxisRange scrollAxisRange) {
        this.horizontalScrollAxisRange = scrollAxisRange;
    }

    public final void setOldXValue(@Nullable Float f) {
        this.oldXValue = f;
    }

    public final void setOldYValue(@Nullable Float f) {
        this.oldYValue = f;
    }

    public final void setVerticalScrollAxisRange(@Nullable ScrollAxisRange scrollAxisRange) {
        this.verticalScrollAxisRange = scrollAxisRange;
    }
}
