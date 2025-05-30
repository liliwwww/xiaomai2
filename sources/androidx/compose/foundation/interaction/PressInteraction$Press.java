package androidx.compose.foundation.interaction;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class PressInteraction$Press implements PressInteraction {
    public static final int $stable = 0;
    private final long pressPosition;

    private PressInteraction$Press(long j) {
        this.pressPosition = j;
    }

    public /* synthetic */ PressInteraction$Press(long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(j);
    }

    /* renamed from: getPressPosition-F1C5BW0, reason: not valid java name */
    public final long m261getPressPositionF1C5BW0() {
        return this.pressPosition;
    }
}
