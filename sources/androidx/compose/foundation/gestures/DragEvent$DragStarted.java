package androidx.compose.foundation.gestures;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class DragEvent$DragStarted extends DragEvent {
    public static final int $stable = 0;
    private final long startPoint;

    private DragEvent$DragStarted(long j) {
        super((DefaultConstructorMarker) null);
        this.startPoint = j;
    }

    public /* synthetic */ DragEvent$DragStarted(long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(j);
    }

    /* renamed from: getStartPoint-F1C5BW0, reason: not valid java name */
    public final long m170getStartPointF1C5BW0() {
        return this.startPoint;
    }
}
