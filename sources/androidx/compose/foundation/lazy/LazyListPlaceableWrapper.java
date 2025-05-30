package androidx.compose.foundation.lazy;

import androidx.compose.p004ui.layout.Placeable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class LazyListPlaceableWrapper {
    private final long offset;

    @NotNull
    private final Placeable placeable;

    private LazyListPlaceableWrapper(long j, Placeable placeable) {
        this.offset = j;
        this.placeable = placeable;
    }

    public /* synthetic */ LazyListPlaceableWrapper(long j, Placeable placeable, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, placeable);
    }

    /* renamed from: getOffset-nOcc-ac, reason: not valid java name */
    public final long m1516getOffsetnOccac() {
        return this.offset;
    }

    @NotNull
    public final Placeable getPlaceable() {
        return this.placeable;
    }
}
