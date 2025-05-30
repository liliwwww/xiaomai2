package androidx.compose.runtime;

import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
final class DataIterator implements Iterable<Object>, Iterator<Object>, KMappedMarker {
    private final int end;
    private final int group;
    private int index;
    private final int start;

    @NotNull
    private final SlotTable table;

    public DataIterator(@NotNull SlotTable slotTable, int i) {
        int dataAnchor;
        Intrinsics.checkNotNullParameter(slotTable, "table");
        this.table = slotTable;
        this.group = i;
        dataAnchor = SlotTableKt.dataAnchor(slotTable.getGroups(), i);
        this.start = dataAnchor;
        this.end = i + 1 < slotTable.getGroupsSize() ? SlotTableKt.dataAnchor(slotTable.getGroups(), i + 1) : slotTable.getSlotsSize();
        this.index = dataAnchor;
    }

    public final int getEnd() {
        return this.end;
    }

    public final int getGroup() {
        return this.group;
    }

    public final int getIndex() {
        return this.index;
    }

    public final int getStart() {
        return this.start;
    }

    @NotNull
    public final SlotTable getTable() {
        return this.table;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.end;
    }

    @Override // java.lang.Iterable
    @NotNull
    public Iterator<Object> iterator() {
        return this;
    }

    @Override // java.util.Iterator
    @Nullable
    public Object next() {
        int i = this.index;
        Object obj = (i < 0 || i >= this.table.getSlots().length) ? null : this.table.getSlots()[this.index];
        this.index++;
        return obj;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void setIndex(int i) {
        this.index = i;
    }
}
