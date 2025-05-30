package androidx.compose.runtime;

import java.util.ArrayList;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class PrioritySet {

    @NotNull
    private final List<Integer> list;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public PrioritySet() {
        /*
            r2 = this;
            r0 = 0
            r1 = 1
            r2.<init>(r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.PrioritySet.<init>():void");
    }

    public PrioritySet(@NotNull List<Integer> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.list = list;
    }

    public final void add(int i) {
        if (!this.list.isEmpty()) {
            if (this.list.get(0).intValue() == i) {
                return;
            }
            if (this.list.get(r0.size() - 1).intValue() == i) {
                return;
            }
        }
        int size = this.list.size();
        this.list.add(Integer.valueOf(i));
        while (size > 0) {
            int i2 = ((size + 1) >>> 1) - 1;
            int intValue = this.list.get(i2).intValue();
            if (i <= intValue) {
                break;
            }
            this.list.set(size, Integer.valueOf(intValue));
            size = i2;
        }
        this.list.set(size, Integer.valueOf(i));
    }

    public final boolean isEmpty() {
        return this.list.isEmpty();
    }

    public final boolean isNotEmpty() {
        return !this.list.isEmpty();
    }

    public final int peek() {
        return ((Number) CollectionsKt.first(this.list)).intValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int takeMax() {
        int intValue;
        if (!(this.list.size() > 0)) {
            ComposerKt.composeRuntimeError("Set is empty".toString());
            throw new KotlinNothingValueException();
        }
        int intValue2 = this.list.get(0).intValue();
        while ((!this.list.isEmpty()) && this.list.get(0).intValue() == intValue2) {
            List<Integer> list = this.list;
            list.set(0, CollectionsKt.last(list));
            List<Integer> list2 = this.list;
            list2.remove(list2.size() - 1);
            int size = this.list.size();
            int size2 = this.list.size() >>> 1;
            int i = 0;
            while (i < size2) {
                int intValue3 = this.list.get(i).intValue();
                int i2 = (i + 1) * 2;
                int i3 = i2 - 1;
                int intValue4 = this.list.get(i3).intValue();
                if (i2 >= size || (intValue = this.list.get(i2).intValue()) <= intValue4) {
                    if (intValue4 > intValue3) {
                        this.list.set(i, Integer.valueOf(intValue4));
                        this.list.set(i3, Integer.valueOf(intValue3));
                        i = i3;
                    }
                } else if (intValue > intValue3) {
                    this.list.set(i, Integer.valueOf(intValue));
                    this.list.set(i2, Integer.valueOf(intValue3));
                    i = i2;
                }
            }
        }
        return intValue2;
    }

    public final void validateHeap() {
        int size = this.list.size();
        int i = size / 2;
        int i2 = 0;
        while (i2 < i) {
            int i3 = i2 + 1;
            int i4 = i3 * 2;
            boolean z = true;
            if (!(this.list.get(i2).intValue() >= this.list.get(i4 + (-1)).intValue())) {
                throw new IllegalStateException("Check failed.".toString());
            }
            if (i4 < size && this.list.get(i2).intValue() < this.list.get(i4).intValue()) {
                z = false;
            }
            if (!z) {
                throw new IllegalStateException("Check failed.".toString());
            }
            i2 = i3;
        }
    }

    public /* synthetic */ PrioritySet(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new ArrayList() : list);
    }
}
