package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.Handle;
import androidx.compose.ui.geometry.Offset;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class SelectionHandleInfo {

    @NotNull
    private final Handle handle;
    private final long position;

    private SelectionHandleInfo(Handle handle, long j) {
        this.handle = handle;
        this.position = j;
    }

    public /* synthetic */ SelectionHandleInfo(Handle handle, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(handle, j);
    }

    /* renamed from: copy-Uv8p0NA$default, reason: not valid java name */
    public static /* synthetic */ SelectionHandleInfo m605copyUv8p0NA$default(SelectionHandleInfo selectionHandleInfo, Handle handle, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            handle = selectionHandleInfo.handle;
        }
        if ((i & 2) != 0) {
            j = selectionHandleInfo.position;
        }
        return selectionHandleInfo.m607copyUv8p0NA(handle, j);
    }

    @NotNull
    public final Handle component1() {
        return this.handle;
    }

    /* renamed from: component2-F1C5BW0, reason: not valid java name */
    public final long m606component2F1C5BW0() {
        return this.position;
    }

    @NotNull
    /* renamed from: copy-Uv8p0NA, reason: not valid java name */
    public final SelectionHandleInfo m607copyUv8p0NA(@NotNull Handle handle, long j) {
        Intrinsics.checkNotNullParameter(handle, "handle");
        return new SelectionHandleInfo(handle, j, null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SelectionHandleInfo)) {
            return false;
        }
        SelectionHandleInfo selectionHandleInfo = (SelectionHandleInfo) obj;
        return this.handle == selectionHandleInfo.handle && Offset.equals-impl0(this.position, selectionHandleInfo.position);
    }

    @NotNull
    public final Handle getHandle() {
        return this.handle;
    }

    /* renamed from: getPosition-F1C5BW0, reason: not valid java name */
    public final long m608getPositionF1C5BW0() {
        return this.position;
    }

    public int hashCode() {
        return (this.handle.hashCode() * 31) + Offset.hashCode-impl(this.position);
    }

    @NotNull
    public String toString() {
        return "SelectionHandleInfo(handle=" + this.handle + ", position=" + ((Object) Offset.toString-impl(this.position)) + ')';
    }
}
