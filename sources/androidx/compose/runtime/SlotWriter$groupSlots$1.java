package androidx.compose.runtime;

import java.util.Iterator;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class SlotWriter$groupSlots$1 implements Iterator<Object>, KMappedMarker {
    final /* synthetic */ int $end;
    private int current;
    final /* synthetic */ SlotWriter this$0;

    SlotWriter$groupSlots$1(int i, int i2, SlotWriter slotWriter) {
        this.$end = i2;
        this.this$0 = slotWriter;
        this.current = i;
    }

    public final int getCurrent() {
        return this.current;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.current < this.$end;
    }

    @Override // java.util.Iterator
    @Nullable
    public Object next() {
        Object[] objArr;
        int dataIndexToDataAddress;
        if (!hasNext()) {
            return null;
        }
        objArr = this.this$0.slots;
        SlotWriter slotWriter = this.this$0;
        int i = this.current;
        this.current = i + 1;
        dataIndexToDataAddress = slotWriter.dataIndexToDataAddress(i);
        return objArr[dataIndexToDataAddress];
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void setCurrent(int i) {
        this.current = i;
    }
}
