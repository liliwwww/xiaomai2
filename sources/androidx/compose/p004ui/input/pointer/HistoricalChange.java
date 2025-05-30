package androidx.compose.p004ui.input.pointer;

import androidx.compose.p004ui.ExperimentalComposeUiApi;
import androidx.compose.p004ui.geometry.Offset;
import androidx.compose.runtime.Immutable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Immutable
@ExperimentalComposeUiApi
/* loaded from: classes2.dex */
public final class HistoricalChange {
    private final long position;
    private final long uptimeMillis;

    private HistoricalChange(long j, long j2) {
        this.uptimeMillis = j;
        this.position = j2;
    }

    public /* synthetic */ HistoricalChange(long j, long j2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2);
    }

    /* renamed from: getPosition-F1C5BW0, reason: not valid java name */
    public final long m4011getPositionF1C5BW0() {
        return this.position;
    }

    public final long getUptimeMillis() {
        return this.uptimeMillis;
    }

    @NotNull
    public String toString() {
        return "HistoricalChange(uptimeMillis=" + this.uptimeMillis + ", position=" + ((Object) Offset.m2564toStringimpl(this.position)) + ')';
    }
}
