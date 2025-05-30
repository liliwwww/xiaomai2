package androidx.compose.ui.input.pointer;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class PointerInputChangeEventProducer$PointerInputData {
    private final boolean down;
    private final long positionOnScreen;
    private final int type;
    private final long uptime;

    private PointerInputChangeEventProducer$PointerInputData(long j, long j2, boolean z, int i) {
        this.uptime = j;
        this.positionOnScreen = j2;
        this.down = z;
        this.type = i;
    }

    public /* synthetic */ PointerInputChangeEventProducer$PointerInputData(long j, long j2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, z, i);
    }

    public final boolean getDown() {
        return this.down;
    }

    /* renamed from: getPositionOnScreen-F1C5BW0, reason: not valid java name */
    public final long m1469getPositionOnScreenF1C5BW0() {
        return this.positionOnScreen;
    }

    /* renamed from: getType-T8wyACA, reason: not valid java name */
    public final int m1470getTypeT8wyACA() {
        return this.type;
    }

    public final long getUptime() {
        return this.uptime;
    }
}
