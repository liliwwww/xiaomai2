package androidx.compose.runtime;

import java.util.ArrayList;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class SlotWriter$Companion {
    private SlotWriter$Companion() {
    }

    public /* synthetic */ SlotWriter$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<Anchor> moveGroup(SlotWriter slotWriter, int i, SlotWriter slotWriter2, boolean z, boolean z2) {
        int locationOf;
        int locationOf2;
        List<Anchor> list;
        boolean z3;
        boolean isNode;
        int locationOf3;
        int i2;
        int i3;
        int access$getSlotsGapStart$p;
        int parentAnchor;
        int groupSize = slotWriter.groupSize(i);
        int i4 = i + groupSize;
        int access$dataIndex = SlotWriter.access$dataIndex(slotWriter, i);
        int access$dataIndex2 = SlotWriter.access$dataIndex(slotWriter, i4);
        int i5 = access$dataIndex2 - access$dataIndex;
        boolean access$containsAnyGroupMarks = SlotWriter.access$containsAnyGroupMarks(slotWriter, i);
        SlotWriter.access$insertGroups(slotWriter2, groupSize);
        SlotWriter.access$insertSlots(slotWriter2, i5, slotWriter2.getCurrentGroup());
        if (SlotWriter.access$getGroupGapStart$p(slotWriter) < i4) {
            SlotWriter.access$moveGroupGapTo(slotWriter, i4);
        }
        if (SlotWriter.access$getSlotsGapStart$p(slotWriter) < access$dataIndex2) {
            SlotWriter.access$moveSlotGapTo(slotWriter, access$dataIndex2, i4);
        }
        int[] access$getGroups$p = SlotWriter.access$getGroups$p(slotWriter2);
        int currentGroup = slotWriter2.getCurrentGroup();
        ArraysKt.copyInto(SlotWriter.access$getGroups$p(slotWriter), access$getGroups$p, currentGroup * 5, i * 5, i4 * 5);
        Object[] access$getSlots$p = SlotWriter.access$getSlots$p(slotWriter2);
        int access$getCurrentSlot$p = SlotWriter.access$getCurrentSlot$p(slotWriter2);
        ArraysKt.copyInto(SlotWriter.access$getSlots$p(slotWriter), access$getSlots$p, access$getCurrentSlot$p, access$dataIndex, access$dataIndex2);
        int parent = slotWriter2.getParent();
        SlotTableKt.updateParentAnchor(access$getGroups$p, currentGroup, parent);
        int i6 = currentGroup - i;
        int i7 = currentGroup + groupSize;
        int access$dataIndex3 = access$getCurrentSlot$p - SlotWriter.access$dataIndex(slotWriter2, access$getGroups$p, currentGroup);
        int access$getSlotsGapOwner$p = SlotWriter.access$getSlotsGapOwner$p(slotWriter2);
        int access$getSlotsGapLen$p = SlotWriter.access$getSlotsGapLen$p(slotWriter2);
        int length = access$getSlots$p.length;
        int i8 = access$getSlotsGapOwner$p;
        int i9 = currentGroup;
        while (true) {
            if (i9 >= i7) {
                break;
            }
            if (i9 != currentGroup) {
                parentAnchor = SlotTableKt.parentAnchor(access$getGroups$p, i9);
                i2 = i7;
                SlotTableKt.updateParentAnchor(access$getGroups$p, i9, parentAnchor + i6);
            } else {
                i2 = i7;
            }
            int access$dataIndex4 = SlotWriter.access$dataIndex(slotWriter2, access$getGroups$p, i9) + access$dataIndex3;
            if (i8 < i9) {
                i3 = access$dataIndex3;
                access$getSlotsGapStart$p = 0;
            } else {
                i3 = access$dataIndex3;
                access$getSlotsGapStart$p = SlotWriter.access$getSlotsGapStart$p(slotWriter2);
            }
            SlotTableKt.updateDataAnchor(access$getGroups$p, i9, SlotWriter.access$dataIndexToDataAnchor(slotWriter2, access$dataIndex4, access$getSlotsGapStart$p, access$getSlotsGapLen$p, length));
            if (i9 == i8) {
                i8++;
            }
            i9++;
            access$dataIndex3 = i3;
            i7 = i2;
        }
        int i10 = i7;
        SlotWriter.access$setSlotsGapOwner$p(slotWriter2, i8);
        locationOf = SlotTableKt.locationOf(SlotWriter.access$getAnchors$p(slotWriter), i, slotWriter.getSize$runtime_release());
        locationOf2 = SlotTableKt.locationOf(SlotWriter.access$getAnchors$p(slotWriter), i4, slotWriter.getSize$runtime_release());
        if (locationOf < locationOf2) {
            ArrayList access$getAnchors$p = SlotWriter.access$getAnchors$p(slotWriter);
            ArrayList arrayList = new ArrayList(locationOf2 - locationOf);
            for (int i11 = locationOf; i11 < locationOf2; i11++) {
                Object obj = access$getAnchors$p.get(i11);
                Intrinsics.checkNotNullExpressionValue(obj, "sourceAnchors[anchorIndex]");
                Anchor anchor = (Anchor) obj;
                anchor.setLocation$runtime_release(anchor.getLocation$runtime_release() + i6);
                arrayList.add(anchor);
            }
            locationOf3 = SlotTableKt.locationOf(SlotWriter.access$getAnchors$p(slotWriter2), slotWriter2.getCurrentGroup(), slotWriter2.getSize$runtime_release());
            SlotWriter.access$getAnchors$p(slotWriter2).addAll(locationOf3, arrayList);
            access$getAnchors$p.subList(locationOf, locationOf2).clear();
            list = arrayList;
        } else {
            list = CollectionsKt.emptyList();
        }
        int parent2 = slotWriter.parent(i);
        if (z) {
            boolean z4 = parent2 >= 0;
            if (z4) {
                slotWriter.startGroup();
                slotWriter.advanceBy(parent2 - slotWriter.getCurrentGroup());
                slotWriter.startGroup();
            }
            slotWriter.advanceBy(i - slotWriter.getCurrentGroup());
            z3 = slotWriter.removeGroup();
            if (z4) {
                slotWriter.skipToGroupEnd();
                slotWriter.endGroup();
                slotWriter.skipToGroupEnd();
                slotWriter.endGroup();
            }
        } else {
            boolean access$removeGroups = SlotWriter.access$removeGroups(slotWriter, i, groupSize);
            SlotWriter.access$removeSlots(slotWriter, access$dataIndex, i5, i - 1);
            z3 = access$removeGroups;
        }
        if (!(!z3)) {
            ComposerKt.composeRuntimeError("Unexpectedly removed anchors".toString());
            throw new KotlinNothingValueException();
        }
        int access$getNodeCount$p = SlotWriter.access$getNodeCount$p(slotWriter2);
        isNode = SlotTableKt.isNode(access$getGroups$p, currentGroup);
        SlotWriter.access$setNodeCount$p(slotWriter2, access$getNodeCount$p + (isNode ? 1 : SlotTableKt.nodeCount(access$getGroups$p, currentGroup)));
        if (z2) {
            SlotWriter.access$setCurrentGroup$p(slotWriter2, i10);
            SlotWriter.access$setCurrentSlot$p(slotWriter2, access$getCurrentSlot$p + i5);
        }
        if (access$containsAnyGroupMarks) {
            SlotWriter.access$updateContainsMark(slotWriter2, parent);
        }
        return list;
    }
}
