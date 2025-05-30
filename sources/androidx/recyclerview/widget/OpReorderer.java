package androidx.recyclerview.widget;

import java.util.List;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class OpReorderer {
    final Callback mCallback;

    OpReorderer(Callback callback) {
        this.mCallback = callback;
    }

    private int getLastMoveOutOfOrder(List<AdapterHelper$UpdateOp> list) {
        boolean z = false;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (list.get(size).cmd != 8) {
                z = true;
            } else if (z) {
                return size;
            }
        }
        return -1;
    }

    private void swapMoveAdd(List<AdapterHelper$UpdateOp> list, int i, AdapterHelper$UpdateOp adapterHelper$UpdateOp, int i2, AdapterHelper$UpdateOp adapterHelper$UpdateOp2) {
        int i3 = adapterHelper$UpdateOp.itemCount;
        int i4 = adapterHelper$UpdateOp2.positionStart;
        int i5 = i3 < i4 ? -1 : 0;
        int i6 = adapterHelper$UpdateOp.positionStart;
        if (i6 < i4) {
            i5++;
        }
        if (i4 <= i6) {
            adapterHelper$UpdateOp.positionStart = i6 + adapterHelper$UpdateOp2.itemCount;
        }
        int i7 = adapterHelper$UpdateOp2.positionStart;
        if (i7 <= i3) {
            adapterHelper$UpdateOp.itemCount = i3 + adapterHelper$UpdateOp2.itemCount;
        }
        adapterHelper$UpdateOp2.positionStart = i7 + i5;
        list.set(i, adapterHelper$UpdateOp2);
        list.set(i2, adapterHelper$UpdateOp);
    }

    private void swapMoveOp(List<AdapterHelper$UpdateOp> list, int i, int i2) {
        AdapterHelper$UpdateOp adapterHelper$UpdateOp = list.get(i);
        AdapterHelper$UpdateOp adapterHelper$UpdateOp2 = list.get(i2);
        int i3 = adapterHelper$UpdateOp2.cmd;
        if (i3 == 1) {
            swapMoveAdd(list, i, adapterHelper$UpdateOp, i2, adapterHelper$UpdateOp2);
        } else if (i3 == 2) {
            swapMoveRemove(list, i, adapterHelper$UpdateOp, i2, adapterHelper$UpdateOp2);
        } else {
            if (i3 != 4) {
                return;
            }
            swapMoveUpdate(list, i, adapterHelper$UpdateOp, i2, adapterHelper$UpdateOp2);
        }
    }

    void reorderOps(List<AdapterHelper$UpdateOp> list) {
        while (true) {
            int lastMoveOutOfOrder = getLastMoveOutOfOrder(list);
            if (lastMoveOutOfOrder == -1) {
                return;
            } else {
                swapMoveOp(list, lastMoveOutOfOrder, lastMoveOutOfOrder + 1);
            }
        }
    }

    void swapMoveRemove(List<AdapterHelper$UpdateOp> list, int i, AdapterHelper$UpdateOp adapterHelper$UpdateOp, int i2, AdapterHelper$UpdateOp adapterHelper$UpdateOp2) {
        boolean z;
        int i3 = adapterHelper$UpdateOp.positionStart;
        int i4 = adapterHelper$UpdateOp.itemCount;
        boolean z2 = false;
        if (i3 < i4) {
            if (adapterHelper$UpdateOp2.positionStart == i3 && adapterHelper$UpdateOp2.itemCount == i4 - i3) {
                z = false;
                z2 = true;
            } else {
                z = false;
            }
        } else if (adapterHelper$UpdateOp2.positionStart == i4 + 1 && adapterHelper$UpdateOp2.itemCount == i3 - i4) {
            z = true;
            z2 = true;
        } else {
            z = true;
        }
        int i5 = adapterHelper$UpdateOp2.positionStart;
        if (i4 < i5) {
            adapterHelper$UpdateOp2.positionStart = i5 - 1;
        } else {
            int i6 = adapterHelper$UpdateOp2.itemCount;
            if (i4 < i5 + i6) {
                adapterHelper$UpdateOp2.itemCount = i6 - 1;
                adapterHelper$UpdateOp.cmd = 2;
                adapterHelper$UpdateOp.itemCount = 1;
                if (adapterHelper$UpdateOp2.itemCount == 0) {
                    list.remove(i2);
                    this.mCallback.recycleUpdateOp(adapterHelper$UpdateOp2);
                    return;
                }
                return;
            }
        }
        int i7 = adapterHelper$UpdateOp.positionStart;
        int i8 = adapterHelper$UpdateOp2.positionStart;
        AdapterHelper$UpdateOp adapterHelper$UpdateOp3 = null;
        if (i7 <= i8) {
            adapterHelper$UpdateOp2.positionStart = i8 + 1;
        } else {
            int i9 = adapterHelper$UpdateOp2.itemCount;
            if (i7 < i8 + i9) {
                adapterHelper$UpdateOp3 = this.mCallback.obtainUpdateOp(2, i7 + 1, (i8 + i9) - i7, (Object) null);
                adapterHelper$UpdateOp2.itemCount = adapterHelper$UpdateOp.positionStart - adapterHelper$UpdateOp2.positionStart;
            }
        }
        if (z2) {
            list.set(i, adapterHelper$UpdateOp2);
            list.remove(i2);
            this.mCallback.recycleUpdateOp(adapterHelper$UpdateOp);
            return;
        }
        if (z) {
            if (adapterHelper$UpdateOp3 != null) {
                int i10 = adapterHelper$UpdateOp.positionStart;
                if (i10 > adapterHelper$UpdateOp3.positionStart) {
                    adapterHelper$UpdateOp.positionStart = i10 - adapterHelper$UpdateOp3.itemCount;
                }
                int i11 = adapterHelper$UpdateOp.itemCount;
                if (i11 > adapterHelper$UpdateOp3.positionStart) {
                    adapterHelper$UpdateOp.itemCount = i11 - adapterHelper$UpdateOp3.itemCount;
                }
            }
            int i12 = adapterHelper$UpdateOp.positionStart;
            if (i12 > adapterHelper$UpdateOp2.positionStart) {
                adapterHelper$UpdateOp.positionStart = i12 - adapterHelper$UpdateOp2.itemCount;
            }
            int i13 = adapterHelper$UpdateOp.itemCount;
            if (i13 > adapterHelper$UpdateOp2.positionStart) {
                adapterHelper$UpdateOp.itemCount = i13 - adapterHelper$UpdateOp2.itemCount;
            }
        } else {
            if (adapterHelper$UpdateOp3 != null) {
                int i14 = adapterHelper$UpdateOp.positionStart;
                if (i14 >= adapterHelper$UpdateOp3.positionStart) {
                    adapterHelper$UpdateOp.positionStart = i14 - adapterHelper$UpdateOp3.itemCount;
                }
                int i15 = adapterHelper$UpdateOp.itemCount;
                if (i15 >= adapterHelper$UpdateOp3.positionStart) {
                    adapterHelper$UpdateOp.itemCount = i15 - adapterHelper$UpdateOp3.itemCount;
                }
            }
            int i16 = adapterHelper$UpdateOp.positionStart;
            if (i16 >= adapterHelper$UpdateOp2.positionStart) {
                adapterHelper$UpdateOp.positionStart = i16 - adapterHelper$UpdateOp2.itemCount;
            }
            int i17 = adapterHelper$UpdateOp.itemCount;
            if (i17 >= adapterHelper$UpdateOp2.positionStart) {
                adapterHelper$UpdateOp.itemCount = i17 - adapterHelper$UpdateOp2.itemCount;
            }
        }
        list.set(i, adapterHelper$UpdateOp2);
        if (adapterHelper$UpdateOp.positionStart != adapterHelper$UpdateOp.itemCount) {
            list.set(i2, adapterHelper$UpdateOp);
        } else {
            list.remove(i2);
        }
        if (adapterHelper$UpdateOp3 != null) {
            list.add(i, adapterHelper$UpdateOp3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void swapMoveUpdate(java.util.List<androidx.recyclerview.widget.AdapterHelper$UpdateOp> r9, int r10, androidx.recyclerview.widget.AdapterHelper$UpdateOp r11, int r12, androidx.recyclerview.widget.AdapterHelper$UpdateOp r13) {
        /*
            r8 = this;
            int r0 = r11.itemCount
            int r1 = r13.positionStart
            r2 = 4
            r3 = 0
            r4 = 1
            if (r0 >= r1) goto Ld
            int r1 = r1 - r4
            r13.positionStart = r1
            goto L20
        Ld:
            int r5 = r13.itemCount
            int r1 = r1 + r5
            if (r0 >= r1) goto L20
            int r5 = r5 - r4
            r13.itemCount = r5
            androidx.recyclerview.widget.OpReorderer$Callback r0 = r8.mCallback
            int r1 = r11.positionStart
            java.lang.Object r5 = r13.payload
            androidx.recyclerview.widget.AdapterHelper$UpdateOp r0 = r0.obtainUpdateOp(r2, r1, r4, r5)
            goto L21
        L20:
            r0 = r3
        L21:
            int r1 = r11.positionStart
            int r5 = r13.positionStart
            if (r1 > r5) goto L2b
            int r5 = r5 + r4
            r13.positionStart = r5
            goto L41
        L2b:
            int r6 = r13.itemCount
            int r7 = r5 + r6
            if (r1 >= r7) goto L41
            int r5 = r5 + r6
            int r5 = r5 - r1
            androidx.recyclerview.widget.OpReorderer$Callback r3 = r8.mCallback
            int r1 = r1 + r4
            java.lang.Object r4 = r13.payload
            androidx.recyclerview.widget.AdapterHelper$UpdateOp r3 = r3.obtainUpdateOp(r2, r1, r5, r4)
            int r1 = r13.itemCount
            int r1 = r1 - r5
            r13.itemCount = r1
        L41:
            r9.set(r12, r11)
            int r11 = r13.itemCount
            if (r11 <= 0) goto L4c
            r9.set(r10, r13)
            goto L54
        L4c:
            r9.remove(r10)
            androidx.recyclerview.widget.OpReorderer$Callback r11 = r8.mCallback
            r11.recycleUpdateOp(r13)
        L54:
            if (r0 == 0) goto L59
            r9.add(r10, r0)
        L59:
            if (r3 == 0) goto L5e
            r9.add(r10, r3)
        L5e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.OpReorderer.swapMoveUpdate(java.util.List, int, androidx.recyclerview.widget.AdapterHelper$UpdateOp, int, androidx.recyclerview.widget.AdapterHelper$UpdateOp):void");
    }
}
