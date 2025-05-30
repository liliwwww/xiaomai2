package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet;

import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.DeltaCounter;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership;
import java.util.Arrays;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class TrieNode<E> {

    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @NotNull
    private static final TrieNode EMPTY = new TrieNode(0, new Object[0]);
    private int bitmap;

    @NotNull
    private Object[] buffer;

    @Nullable
    private MutabilityOwnership ownedBy;

    public TrieNode(int i, @NotNull Object[] objArr, @Nullable MutabilityOwnership mutabilityOwnership) {
        Intrinsics.checkNotNullParameter(objArr, "buffer");
        this.bitmap = i;
        this.buffer = objArr;
        this.ownedBy = mutabilityOwnership;
    }

    private final TrieNode<E> addElementAt(int i, E e) {
        Object[] addElementAtIndex;
        addElementAtIndex = TrieNodeKt.addElementAtIndex(this.buffer, indexOfCellAt$runtime_release(i), e);
        return new TrieNode<>(i | this.bitmap, addElementAtIndex);
    }

    private final int calculateSize() {
        if (this.bitmap == 0) {
            return this.buffer.length;
        }
        int i = 0;
        for (Object obj : this.buffer) {
            i += obj instanceof TrieNode ? ((TrieNode) obj).calculateSize() : 1;
        }
        return i;
    }

    private final TrieNode<E> collisionAdd(E e) {
        Object[] addElementAtIndex;
        if (collisionContainsElement(e)) {
            return this;
        }
        addElementAtIndex = TrieNodeKt.addElementAtIndex(this.buffer, 0, e);
        return new TrieNode<>(0, addElementAtIndex);
    }

    private final boolean collisionContainsElement(E e) {
        return ArraysKt.contains(this.buffer, e);
    }

    private final TrieNode<E> collisionRemove(E e) {
        int indexOf = ArraysKt.indexOf(this.buffer, e);
        return indexOf != -1 ? collisionRemoveElementAtIndex(indexOf) : this;
    }

    private final TrieNode<E> collisionRemoveElementAtIndex(int i) {
        Object[] removeCellAtIndex;
        removeCellAtIndex = TrieNodeKt.removeCellAtIndex(this.buffer, i);
        return new TrieNode<>(0, removeCellAtIndex);
    }

    private final E elementAtIndex(int i) {
        return (E) this.buffer[i];
    }

    private final boolean elementsIdentityEquals(TrieNode<E> trieNode) {
        if (this == trieNode) {
            return true;
        }
        if (this.bitmap != trieNode.bitmap) {
            return false;
        }
        int length = this.buffer.length;
        for (int i = 0; i < length; i++) {
            if (this.buffer[i] != trieNode.buffer[i]) {
                return false;
            }
        }
        return true;
    }

    private final boolean hasNoCellAt(int i) {
        return (i & this.bitmap) == 0;
    }

    private final TrieNode<E> makeNode(int i, E e, int i2, E e2, int i3, MutabilityOwnership mutabilityOwnership) {
        if (i3 > 30) {
            return new TrieNode<>(0, new Object[]{e, e2}, mutabilityOwnership);
        }
        int indexSegment = TrieNodeKt.indexSegment(i, i3);
        int indexSegment2 = TrieNodeKt.indexSegment(i2, i3);
        if (indexSegment != indexSegment2) {
            return new TrieNode<>((1 << indexSegment) | (1 << indexSegment2), indexSegment < indexSegment2 ? new Object[]{e, e2} : new Object[]{e2, e}, mutabilityOwnership);
        }
        return new TrieNode<>(1 << indexSegment, new Object[]{makeNode(i, e, i2, e2, i3 + 5, mutabilityOwnership)}, mutabilityOwnership);
    }

    private final TrieNode<E> makeNodeAtIndex(int i, int i2, E e, int i3, MutabilityOwnership mutabilityOwnership) {
        E elementAtIndex = elementAtIndex(i);
        return makeNode(elementAtIndex != null ? elementAtIndex.hashCode() : 0, elementAtIndex, i2, e, i3 + 5, mutabilityOwnership);
    }

    private final TrieNode<E> moveElementToNode(int i, int i2, E e, int i3) {
        Object[] objArr = this.buffer;
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        copyOf[i] = makeNodeAtIndex(i, i2, e, i3, null);
        return new TrieNode<>(this.bitmap, copyOf);
    }

    private final TrieNode<E> mutableAddElementAt(int i, E e, MutabilityOwnership mutabilityOwnership) {
        Object[] addElementAtIndex;
        Object[] addElementAtIndex2;
        int indexOfCellAt$runtime_release = indexOfCellAt$runtime_release(i);
        if (this.ownedBy != mutabilityOwnership) {
            addElementAtIndex = TrieNodeKt.addElementAtIndex(this.buffer, indexOfCellAt$runtime_release, e);
            return new TrieNode<>(i | this.bitmap, addElementAtIndex, mutabilityOwnership);
        }
        addElementAtIndex2 = TrieNodeKt.addElementAtIndex(this.buffer, indexOfCellAt$runtime_release, e);
        this.buffer = addElementAtIndex2;
        this.bitmap = i | this.bitmap;
        return this;
    }

    private final TrieNode<E> mutableCollisionAdd(E e, PersistentHashSetBuilder<?> persistentHashSetBuilder) {
        Object[] addElementAtIndex;
        Object[] addElementAtIndex2;
        if (collisionContainsElement(e)) {
            return this;
        }
        persistentHashSetBuilder.setSize(persistentHashSetBuilder.size() + 1);
        if (this.ownedBy != persistentHashSetBuilder.getOwnership$runtime_release()) {
            addElementAtIndex = TrieNodeKt.addElementAtIndex(this.buffer, 0, e);
            return new TrieNode<>(0, addElementAtIndex, persistentHashSetBuilder.getOwnership$runtime_release());
        }
        addElementAtIndex2 = TrieNodeKt.addElementAtIndex(this.buffer, 0, e);
        this.buffer = addElementAtIndex2;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final TrieNode<E> mutableCollisionAddAll(TrieNode<E> trieNode, DeltaCounter deltaCounter, MutabilityOwnership mutabilityOwnership) {
        if (this == trieNode) {
            deltaCounter.plusAssign(this.buffer.length);
            return this;
        }
        Object[] objArr = this.buffer;
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length + trieNode.buffer.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        Object[] objArr2 = trieNode.buffer;
        int length = this.buffer.length;
        int i = 0;
        int i2 = 0;
        while (i < objArr2.length) {
            CommonFunctionsKt.assert(i2 <= i);
            if (!collisionContainsElement(objArr2[i])) {
                copyOf[length + i2] = objArr2[i];
                i2++;
                CommonFunctionsKt.assert(length + i2 <= copyOf.length);
            }
            i++;
        }
        int length2 = i2 + this.buffer.length;
        deltaCounter.plusAssign(copyOf.length - length2);
        if (length2 == this.buffer.length) {
            return this;
        }
        if (length2 == trieNode.buffer.length) {
            return trieNode;
        }
        if (length2 != copyOf.length) {
            copyOf = Arrays.copyOf(copyOf, length2);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        }
        if (!Intrinsics.areEqual(this.ownedBy, mutabilityOwnership)) {
            return new TrieNode<>(0, copyOf, mutabilityOwnership);
        }
        this.buffer = copyOf;
        return this;
    }

    private final TrieNode<E> mutableCollisionRemove(E e, PersistentHashSetBuilder<?> persistentHashSetBuilder) {
        int indexOf = ArraysKt.indexOf(this.buffer, e);
        if (indexOf == -1) {
            return this;
        }
        persistentHashSetBuilder.setSize(persistentHashSetBuilder.size() - 1);
        return mutableCollisionRemoveElementAtIndex(indexOf, persistentHashSetBuilder.getOwnership$runtime_release());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object mutableCollisionRemoveAll(TrieNode<E> trieNode, DeltaCounter deltaCounter, MutabilityOwnership mutabilityOwnership) {
        if (this == trieNode) {
            deltaCounter.plusAssign(this.buffer.length);
            return EMPTY;
        }
        Object[] objArr = Intrinsics.areEqual(mutabilityOwnership, this.ownedBy) ? this.buffer : new Object[this.buffer.length];
        Object[] objArr2 = this.buffer;
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i >= objArr2.length) {
                break;
            }
            CommonFunctionsKt.assert(i2 <= i);
            if (!trieNode.collisionContainsElement(objArr2[i])) {
                objArr[0 + i2] = objArr2[i];
                i2++;
                CommonFunctionsKt.assert(0 + i2 <= objArr.length);
            }
            i++;
        }
        deltaCounter.plusAssign(this.buffer.length - i2);
        if (i2 == 0) {
            return EMPTY;
        }
        if (i2 == 1) {
            return objArr[0];
        }
        if (i2 == this.buffer.length) {
            return this;
        }
        if (i2 == objArr.length) {
            return new TrieNode(0, objArr, mutabilityOwnership);
        }
        Object[] copyOf = Arrays.copyOf(objArr, i2);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        return new TrieNode(0, copyOf, mutabilityOwnership);
    }

    private final TrieNode<E> mutableCollisionRemoveElementAtIndex(int i, MutabilityOwnership mutabilityOwnership) {
        Object[] removeCellAtIndex;
        Object[] removeCellAtIndex2;
        if (this.ownedBy != mutabilityOwnership) {
            removeCellAtIndex = TrieNodeKt.removeCellAtIndex(this.buffer, i);
            return new TrieNode<>(0, removeCellAtIndex, mutabilityOwnership);
        }
        removeCellAtIndex2 = TrieNodeKt.removeCellAtIndex(this.buffer, i);
        this.buffer = removeCellAtIndex2;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object mutableCollisionRetainAll(TrieNode<E> trieNode, DeltaCounter deltaCounter, MutabilityOwnership mutabilityOwnership) {
        if (this == trieNode) {
            deltaCounter.plusAssign(this.buffer.length);
            return this;
        }
        Object[] objArr = Intrinsics.areEqual(mutabilityOwnership, this.ownedBy) ? this.buffer : new Object[Math.min(this.buffer.length, trieNode.buffer.length)];
        Object[] objArr2 = this.buffer;
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i >= objArr2.length) {
                break;
            }
            CommonFunctionsKt.assert(i2 <= i);
            if (trieNode.collisionContainsElement(objArr2[i])) {
                objArr[0 + i2] = objArr2[i];
                i2++;
                CommonFunctionsKt.assert(0 + i2 <= objArr.length);
            }
            i++;
        }
        deltaCounter.plusAssign(i2);
        if (i2 == 0) {
            return EMPTY;
        }
        if (i2 == 1) {
            return objArr[0];
        }
        if (i2 == this.buffer.length) {
            return this;
        }
        if (i2 == trieNode.buffer.length) {
            return trieNode;
        }
        if (i2 == objArr.length) {
            return new TrieNode(0, objArr, mutabilityOwnership);
        }
        Object[] copyOf = Arrays.copyOf(objArr, i2);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        return new TrieNode(0, copyOf, mutabilityOwnership);
    }

    private final TrieNode<E> mutableMoveElementToNode(int i, int i2, E e, int i3, MutabilityOwnership mutabilityOwnership) {
        if (this.ownedBy == mutabilityOwnership) {
            this.buffer[i] = makeNodeAtIndex(i, i2, e, i3, mutabilityOwnership);
            return this;
        }
        Object[] objArr = this.buffer;
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        copyOf[i] = makeNodeAtIndex(i, i2, e, i3, mutabilityOwnership);
        return new TrieNode<>(this.bitmap, copyOf, mutabilityOwnership);
    }

    private final TrieNode<E> mutableRemoveCellAtIndex(int i, int i2, MutabilityOwnership mutabilityOwnership) {
        Object[] removeCellAtIndex;
        Object[] removeCellAtIndex2;
        if (this.ownedBy != mutabilityOwnership) {
            removeCellAtIndex = TrieNodeKt.removeCellAtIndex(this.buffer, i);
            return new TrieNode<>(i2 ^ this.bitmap, removeCellAtIndex, mutabilityOwnership);
        }
        removeCellAtIndex2 = TrieNodeKt.removeCellAtIndex(this.buffer, i);
        this.buffer = removeCellAtIndex2;
        this.bitmap ^= i2;
        return this;
    }

    private final TrieNode<E> mutableUpdateNodeAtIndex(int i, TrieNode<E> trieNode, MutabilityOwnership mutabilityOwnership) {
        Object[] objArr = trieNode.buffer;
        if (objArr.length == 1 && !(objArr[0] instanceof TrieNode)) {
            if (this.buffer.length == 1) {
                trieNode.bitmap = this.bitmap;
                return trieNode;
            }
            trieNode = (TrieNode<E>) objArr[0];
        }
        if (this.ownedBy == mutabilityOwnership) {
            this.buffer[i] = trieNode;
            return this;
        }
        Object[] objArr2 = this.buffer;
        Object[] copyOf = Arrays.copyOf(objArr2, objArr2.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        copyOf[i] = trieNode;
        return new TrieNode<>(this.bitmap, copyOf, mutabilityOwnership);
    }

    private final TrieNode<E> nodeAtIndex(int i) {
        Object obj = this.buffer[i];
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode>");
        return (TrieNode) obj;
    }

    private final TrieNode<E> removeCellAtIndex(int i, int i2) {
        Object[] removeCellAtIndex;
        removeCellAtIndex = TrieNodeKt.removeCellAtIndex(this.buffer, i);
        return new TrieNode<>(i2 ^ this.bitmap, removeCellAtIndex);
    }

    private final TrieNode<E> updateNodeAtIndex(int i, TrieNode<E> trieNode) {
        Object[] objArr = trieNode.buffer;
        if (objArr.length == 1 && !(objArr[0] instanceof TrieNode)) {
            if (this.buffer.length == 1) {
                trieNode.bitmap = this.bitmap;
                return trieNode;
            }
            trieNode = (TrieNode<E>) objArr[0];
        }
        Object[] objArr2 = this.buffer;
        Object[] copyOf = Arrays.copyOf(objArr2, objArr2.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        copyOf[i] = trieNode;
        return new TrieNode<>(this.bitmap, copyOf);
    }

    @NotNull
    public final TrieNode<E> add(int i, E e, int i2) {
        int indexSegment = 1 << TrieNodeKt.indexSegment(i, i2);
        if (hasNoCellAt(indexSegment)) {
            return addElementAt(indexSegment, e);
        }
        int indexOfCellAt$runtime_release = indexOfCellAt$runtime_release(indexSegment);
        Object[] objArr = this.buffer;
        if (!(objArr[indexOfCellAt$runtime_release] instanceof TrieNode)) {
            return Intrinsics.areEqual(e, objArr[indexOfCellAt$runtime_release]) ? this : moveElementToNode(indexOfCellAt$runtime_release, i, e, i2);
        }
        TrieNode<E> nodeAtIndex = nodeAtIndex(indexOfCellAt$runtime_release);
        TrieNode<E> collisionAdd = i2 == 30 ? nodeAtIndex.collisionAdd(e) : nodeAtIndex.add(i, e, i2 + 5);
        return nodeAtIndex == collisionAdd ? this : updateNodeAtIndex(indexOfCellAt$runtime_release, collisionAdd);
    }

    public final boolean contains(int i, E e, int i2) {
        int indexSegment = 1 << TrieNodeKt.indexSegment(i, i2);
        if (hasNoCellAt(indexSegment)) {
            return false;
        }
        int indexOfCellAt$runtime_release = indexOfCellAt$runtime_release(indexSegment);
        Object[] objArr = this.buffer;
        if (!(objArr[indexOfCellAt$runtime_release] instanceof TrieNode)) {
            return Intrinsics.areEqual(e, objArr[indexOfCellAt$runtime_release]);
        }
        TrieNode<E> nodeAtIndex = nodeAtIndex(indexOfCellAt$runtime_release);
        return i2 == 30 ? nodeAtIndex.collisionContainsElement(e) : nodeAtIndex.contains(i, e, i2 + 5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean containsAll(@NotNull TrieNode<E> trieNode, int i) {
        Intrinsics.checkNotNullParameter(trieNode, "otherNode");
        if (this == trieNode) {
            return true;
        }
        if (i > 30) {
            for (Object obj : trieNode.buffer) {
                if (!ArraysKt.contains(this.buffer, obj)) {
                    return false;
                }
            }
            return true;
        }
        int i2 = this.bitmap;
        int i3 = trieNode.bitmap;
        int i4 = i2 & i3;
        if (i4 != i3) {
            return false;
        }
        while (i4 != 0) {
            int lowestOneBit = Integer.lowestOneBit(i4);
            int indexOfCellAt$runtime_release = indexOfCellAt$runtime_release(lowestOneBit);
            int indexOfCellAt$runtime_release2 = trieNode.indexOfCellAt$runtime_release(lowestOneBit);
            Object obj2 = this.buffer[indexOfCellAt$runtime_release];
            Object obj3 = trieNode.buffer[indexOfCellAt$runtime_release2];
            boolean z = obj2 instanceof TrieNode;
            boolean z2 = obj3 instanceof TrieNode;
            if (z && z2) {
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.containsAll$lambda$13>");
                Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.containsAll$lambda$13>");
                if (!((TrieNode) obj2).containsAll((TrieNode) obj3, i + 5)) {
                    return false;
                }
            } else if (z) {
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.containsAll$lambda$13>");
                if (!((TrieNode) obj2).contains(obj3 != null ? obj3.hashCode() : 0, obj3, i + 5)) {
                    return false;
                }
            } else if (z2 || !Intrinsics.areEqual(obj2, obj3)) {
                return false;
            }
            i4 ^= lowestOneBit;
        }
        return true;
    }

    public final int getBitmap() {
        return this.bitmap;
    }

    @NotNull
    public final Object[] getBuffer() {
        return this.buffer;
    }

    @Nullable
    public final MutabilityOwnership getOwnedBy() {
        return this.ownedBy;
    }

    public final int indexOfCellAt$runtime_release(int i) {
        return Integer.bitCount((i - 1) & this.bitmap);
    }

    @NotNull
    public final TrieNode<E> mutableAdd(int i, E e, int i2, @NotNull PersistentHashSetBuilder<?> persistentHashSetBuilder) {
        Intrinsics.checkNotNullParameter(persistentHashSetBuilder, "mutator");
        int indexSegment = 1 << TrieNodeKt.indexSegment(i, i2);
        if (hasNoCellAt(indexSegment)) {
            persistentHashSetBuilder.setSize(persistentHashSetBuilder.size() + 1);
            return mutableAddElementAt(indexSegment, e, persistentHashSetBuilder.getOwnership$runtime_release());
        }
        int indexOfCellAt$runtime_release = indexOfCellAt$runtime_release(indexSegment);
        Object[] objArr = this.buffer;
        if (objArr[indexOfCellAt$runtime_release] instanceof TrieNode) {
            TrieNode<E> nodeAtIndex = nodeAtIndex(indexOfCellAt$runtime_release);
            TrieNode<E> mutableCollisionAdd = i2 == 30 ? nodeAtIndex.mutableCollisionAdd(e, persistentHashSetBuilder) : nodeAtIndex.mutableAdd(i, e, i2 + 5, persistentHashSetBuilder);
            return nodeAtIndex == mutableCollisionAdd ? this : mutableUpdateNodeAtIndex(indexOfCellAt$runtime_release, mutableCollisionAdd, persistentHashSetBuilder.getOwnership$runtime_release());
        }
        if (Intrinsics.areEqual(e, objArr[indexOfCellAt$runtime_release])) {
            return this;
        }
        persistentHashSetBuilder.setSize(persistentHashSetBuilder.size() + 1);
        return mutableMoveElementToNode(indexOfCellAt$runtime_release, i, e, i2, persistentHashSetBuilder.getOwnership$runtime_release());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final TrieNode<E> mutableAddAll(@NotNull TrieNode<E> trieNode, int i, @NotNull DeltaCounter deltaCounter, @NotNull PersistentHashSetBuilder<?> persistentHashSetBuilder) {
        Object[] objArr;
        int i2;
        Object makeNode;
        TrieNode mutableAdd;
        Intrinsics.checkNotNullParameter(trieNode, "otherNode");
        Intrinsics.checkNotNullParameter(deltaCounter, "intersectionSizeRef");
        Intrinsics.checkNotNullParameter(persistentHashSetBuilder, "mutator");
        if (this == trieNode) {
            deltaCounter.setCount(deltaCounter.getCount() + calculateSize());
            return this;
        }
        if (i > 30) {
            return mutableCollisionAddAll(trieNode, deltaCounter, persistentHashSetBuilder.getOwnership$runtime_release());
        }
        int i3 = this.bitmap;
        int i4 = trieNode.bitmap | i3;
        TrieNode<E> trieNode2 = (i4 == i3 && Intrinsics.areEqual(this.ownedBy, persistentHashSetBuilder.getOwnership$runtime_release())) ? this : new TrieNode<>(i4, new Object[Integer.bitCount(i4)], persistentHashSetBuilder.getOwnership$runtime_release());
        int i5 = i4;
        int i6 = 0;
        while (i5 != 0) {
            int lowestOneBit = Integer.lowestOneBit(i5);
            int indexOfCellAt$runtime_release = indexOfCellAt$runtime_release(lowestOneBit);
            int indexOfCellAt$runtime_release2 = trieNode.indexOfCellAt$runtime_release(lowestOneBit);
            Object[] objArr2 = trieNode2.buffer;
            if (hasNoCellAt(lowestOneBit)) {
                makeNode = trieNode.buffer[indexOfCellAt$runtime_release2];
            } else if (trieNode.hasNoCellAt(lowestOneBit)) {
                makeNode = this.buffer[indexOfCellAt$runtime_release];
            } else {
                Object obj = this.buffer[indexOfCellAt$runtime_release];
                Object obj2 = trieNode.buffer[indexOfCellAt$runtime_release2];
                boolean z = obj instanceof TrieNode;
                boolean z2 = obj2 instanceof TrieNode;
                if (z && z2) {
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.mutableAddAll$lambda$6>");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.mutableAddAll$lambda$6>");
                    makeNode = ((TrieNode) obj).mutableAddAll((TrieNode) obj2, i + 5, deltaCounter, persistentHashSetBuilder);
                } else {
                    if (z) {
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.mutableAddAll$lambda$6>");
                        TrieNode trieNode3 = (TrieNode) obj;
                        int size = persistentHashSetBuilder.size();
                        mutableAdd = trieNode3.mutableAdd(obj2 != null ? obj2.hashCode() : 0, obj2, i + 5, persistentHashSetBuilder);
                        if (persistentHashSetBuilder.size() == size) {
                            deltaCounter.setCount(deltaCounter.getCount() + 1);
                        }
                        Unit unit = Unit.INSTANCE;
                    } else if (z2) {
                        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.mutableAddAll$lambda$6>");
                        TrieNode trieNode4 = (TrieNode) obj2;
                        int size2 = persistentHashSetBuilder.size();
                        mutableAdd = trieNode4.mutableAdd(obj != null ? obj.hashCode() : 0, obj, i + 5, persistentHashSetBuilder);
                        if (persistentHashSetBuilder.size() == size2) {
                            deltaCounter.setCount(deltaCounter.getCount() + 1);
                        }
                        Unit unit2 = Unit.INSTANCE;
                    } else if (Intrinsics.areEqual(obj, obj2)) {
                        deltaCounter.setCount(deltaCounter.getCount() + 1);
                        Unit unit3 = Unit.INSTANCE;
                        makeNode = obj;
                    } else {
                        objArr = objArr2;
                        i2 = lowestOneBit;
                        makeNode = makeNode(obj != null ? obj.hashCode() : 0, obj, obj2 != null ? obj2.hashCode() : 0, obj2, i + 5, persistentHashSetBuilder.getOwnership$runtime_release());
                        objArr[i6] = makeNode;
                        i6++;
                        i5 ^= i2;
                    }
                    makeNode = mutableAdd;
                }
            }
            objArr = objArr2;
            i2 = lowestOneBit;
            objArr[i6] = makeNode;
            i6++;
            i5 ^= i2;
        }
        return elementsIdentityEquals(trieNode2) ? this : trieNode.elementsIdentityEquals(trieNode2) ? trieNode : trieNode2;
    }

    @NotNull
    public final TrieNode<E> mutableRemove(int i, E e, int i2, @NotNull PersistentHashSetBuilder<?> persistentHashSetBuilder) {
        Intrinsics.checkNotNullParameter(persistentHashSetBuilder, "mutator");
        int indexSegment = 1 << TrieNodeKt.indexSegment(i, i2);
        if (hasNoCellAt(indexSegment)) {
            return this;
        }
        int indexOfCellAt$runtime_release = indexOfCellAt$runtime_release(indexSegment);
        Object[] objArr = this.buffer;
        if (objArr[indexOfCellAt$runtime_release] instanceof TrieNode) {
            TrieNode<E> nodeAtIndex = nodeAtIndex(indexOfCellAt$runtime_release);
            TrieNode<E> mutableCollisionRemove = i2 == 30 ? nodeAtIndex.mutableCollisionRemove(e, persistentHashSetBuilder) : nodeAtIndex.mutableRemove(i, e, i2 + 5, persistentHashSetBuilder);
            return (this.ownedBy == persistentHashSetBuilder.getOwnership$runtime_release() || nodeAtIndex != mutableCollisionRemove) ? mutableUpdateNodeAtIndex(indexOfCellAt$runtime_release, mutableCollisionRemove, persistentHashSetBuilder.getOwnership$runtime_release()) : this;
        }
        if (!Intrinsics.areEqual(e, objArr[indexOfCellAt$runtime_release])) {
            return this;
        }
        persistentHashSetBuilder.setSize(persistentHashSetBuilder.size() - 1);
        return mutableRemoveCellAtIndex(indexOfCellAt$runtime_release, indexSegment, persistentHashSetBuilder.getOwnership$runtime_release());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public final Object mutableRemoveAll(@NotNull TrieNode<E> trieNode, int i, @NotNull DeltaCounter deltaCounter, @NotNull PersistentHashSetBuilder<?> persistentHashSetBuilder) {
        TrieNode<E> trieNode2;
        Intrinsics.checkNotNullParameter(trieNode, "otherNode");
        Intrinsics.checkNotNullParameter(deltaCounter, "intersectionSizeRef");
        Intrinsics.checkNotNullParameter(persistentHashSetBuilder, "mutator");
        if (this == trieNode) {
            deltaCounter.plusAssign(calculateSize());
            return EMPTY;
        }
        if (i > 30) {
            return mutableCollisionRemoveAll(trieNode, deltaCounter, persistentHashSetBuilder.getOwnership$runtime_release());
        }
        int i2 = this.bitmap & trieNode.bitmap;
        if (i2 == 0) {
            return this;
        }
        if (Intrinsics.areEqual(this.ownedBy, persistentHashSetBuilder.getOwnership$runtime_release())) {
            trieNode2 = this;
        } else {
            int i3 = this.bitmap;
            Object[] objArr = this.buffer;
            Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
            trieNode2 = new TrieNode<>(i3, copyOf, persistentHashSetBuilder.getOwnership$runtime_release());
        }
        int i4 = this.bitmap;
        while (i2 != 0) {
            int lowestOneBit = Integer.lowestOneBit(i2);
            int indexOfCellAt$runtime_release = indexOfCellAt$runtime_release(lowestOneBit);
            int indexOfCellAt$runtime_release2 = trieNode.indexOfCellAt$runtime_release(lowestOneBit);
            Object obj = this.buffer[indexOfCellAt$runtime_release];
            Object obj2 = trieNode.buffer[indexOfCellAt$runtime_release2];
            boolean z = obj instanceof TrieNode;
            boolean z2 = obj2 instanceof TrieNode;
            if (z && z2) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.mutableRemoveAll$lambda$11$lambda$10>");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.mutableRemoveAll$lambda$11$lambda$10>");
                obj = ((TrieNode) obj).mutableRemoveAll((TrieNode) obj2, i + 5, deltaCounter, persistentHashSetBuilder);
            } else if (z) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.mutableRemoveAll$lambda$11$lambda$10>");
                TrieNode trieNode3 = (TrieNode) obj;
                int size = persistentHashSetBuilder.size();
                TrieNode mutableRemove = trieNode3.mutableRemove(obj2 != null ? obj2.hashCode() : 0, obj2, i + 5, persistentHashSetBuilder);
                if (size != persistentHashSetBuilder.size()) {
                    deltaCounter.plusAssign(1);
                    Object[] objArr2 = mutableRemove.buffer;
                    obj = (objArr2.length != 1 || (objArr2[0] instanceof TrieNode)) ? mutableRemove : objArr2[0];
                }
            } else if (z2) {
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.mutableRemoveAll$lambda$11$lambda$10>");
                if (((TrieNode) obj2).contains(obj != null ? obj.hashCode() : 0, obj, i + 5)) {
                    deltaCounter.plusAssign(1);
                    obj = EMPTY;
                }
            } else if (Intrinsics.areEqual(obj, obj2)) {
                deltaCounter.plusAssign(1);
                obj = EMPTY;
            }
            if (obj == EMPTY) {
                i4 ^= lowestOneBit;
            }
            trieNode2.buffer[indexOfCellAt$runtime_release] = obj;
            i2 ^= lowestOneBit;
        }
        int bitCount = Integer.bitCount(i4);
        if (i4 == 0) {
            return EMPTY;
        }
        if (i4 == this.bitmap) {
            return trieNode2.elementsIdentityEquals(this) ? this : trieNode2;
        }
        if (bitCount == 1 && i != 0) {
            Object obj3 = trieNode2.buffer[trieNode2.indexOfCellAt$runtime_release(i4)];
            return obj3 instanceof TrieNode ? new TrieNode(i4, new Object[]{obj3}, persistentHashSetBuilder.getOwnership$runtime_release()) : obj3;
        }
        Object[] objArr3 = new Object[bitCount];
        Object[] objArr4 = trieNode2.buffer;
        int i5 = 0;
        int i6 = 0;
        while (i5 < objArr4.length) {
            CommonFunctionsKt.assert(i6 <= i5);
            if (objArr4[i5] != Companion.getEMPTY$runtime_release()) {
                objArr3[0 + i6] = objArr4[i5];
                i6++;
                CommonFunctionsKt.assert(0 + i6 <= bitCount);
            }
            i5++;
        }
        return new TrieNode(i4, objArr3, persistentHashSetBuilder.getOwnership$runtime_release());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public final Object mutableRetainAll(@NotNull TrieNode<E> trieNode, int i, @NotNull DeltaCounter deltaCounter, @NotNull PersistentHashSetBuilder<?> persistentHashSetBuilder) {
        TrieNode trieNode2;
        Intrinsics.checkNotNullParameter(trieNode, "otherNode");
        Intrinsics.checkNotNullParameter(deltaCounter, "intersectionSizeRef");
        Intrinsics.checkNotNullParameter(persistentHashSetBuilder, "mutator");
        if (this == trieNode) {
            deltaCounter.plusAssign(calculateSize());
            return this;
        }
        if (i > 30) {
            return mutableCollisionRetainAll(trieNode, deltaCounter, persistentHashSetBuilder.getOwnership$runtime_release());
        }
        int i2 = this.bitmap & trieNode.bitmap;
        if (i2 == 0) {
            return EMPTY;
        }
        TrieNode<E> trieNode3 = (Intrinsics.areEqual(this.ownedBy, persistentHashSetBuilder.getOwnership$runtime_release()) && i2 == this.bitmap) ? this : new TrieNode<>(i2, new Object[Integer.bitCount(i2)], persistentHashSetBuilder.getOwnership$runtime_release());
        int i3 = i2;
        int i4 = 0;
        int i5 = 0;
        while (i3 != 0) {
            int lowestOneBit = Integer.lowestOneBit(i3);
            int indexOfCellAt$runtime_release = indexOfCellAt$runtime_release(lowestOneBit);
            int indexOfCellAt$runtime_release2 = trieNode.indexOfCellAt$runtime_release(lowestOneBit);
            Object obj = this.buffer[indexOfCellAt$runtime_release];
            Object obj2 = trieNode.buffer[indexOfCellAt$runtime_release2];
            boolean z = obj instanceof TrieNode;
            boolean z2 = obj2 instanceof TrieNode;
            if (z && z2) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.mutableRetainAll$lambda$9$lambda$8>");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.mutableRetainAll$lambda$9$lambda$8>");
                obj = ((TrieNode) obj).mutableRetainAll((TrieNode) obj2, i + 5, deltaCounter, persistentHashSetBuilder);
            } else if (z) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.mutableRetainAll$lambda$9$lambda$8>");
                if (((TrieNode) obj).contains(obj2 != null ? obj2.hashCode() : 0, obj2, i + 5)) {
                    deltaCounter.plusAssign(1);
                    obj = obj2;
                } else {
                    obj = EMPTY;
                }
            } else if (z2) {
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.mutableRetainAll$lambda$9$lambda$8>");
                if (((TrieNode) obj2).contains(obj != null ? obj.hashCode() : 0, obj, i + 5)) {
                    deltaCounter.plusAssign(1);
                } else {
                    obj = EMPTY;
                }
            } else if (Intrinsics.areEqual(obj, obj2)) {
                deltaCounter.plusAssign(1);
            } else {
                obj = EMPTY;
            }
            if (obj != EMPTY) {
                i4 |= lowestOneBit;
            }
            trieNode3.buffer[i5] = obj;
            i5++;
            i3 ^= lowestOneBit;
        }
        int bitCount = Integer.bitCount(i4);
        if (i4 == 0) {
            return EMPTY;
        }
        if (i4 == i2) {
            return trieNode3.elementsIdentityEquals(this) ? this : trieNode3.elementsIdentityEquals(trieNode) ? trieNode : trieNode3;
        }
        if (bitCount != 1 || i == 0) {
            Object[] objArr = new Object[bitCount];
            Object[] objArr2 = trieNode3.buffer;
            int i6 = 0;
            int i7 = 0;
            while (i6 < objArr2.length) {
                CommonFunctionsKt.assert(i7 <= i6);
                if (objArr2[i6] != Companion.getEMPTY$runtime_release()) {
                    objArr[0 + i7] = objArr2[i6];
                    i7++;
                    CommonFunctionsKt.assert(0 + i7 <= bitCount);
                }
                i6++;
            }
            trieNode2 = new TrieNode(i4, objArr, persistentHashSetBuilder.getOwnership$runtime_release());
        } else {
            Object obj3 = trieNode3.buffer[trieNode3.indexOfCellAt$runtime_release(i4)];
            if (!(obj3 instanceof TrieNode)) {
                return obj3;
            }
            trieNode2 = new TrieNode(i4, new Object[]{obj3}, persistentHashSetBuilder.getOwnership$runtime_release());
        }
        return trieNode2;
    }

    @NotNull
    public final TrieNode<E> remove(int i, E e, int i2) {
        int indexSegment = 1 << TrieNodeKt.indexSegment(i, i2);
        if (hasNoCellAt(indexSegment)) {
            return this;
        }
        int indexOfCellAt$runtime_release = indexOfCellAt$runtime_release(indexSegment);
        Object[] objArr = this.buffer;
        if (!(objArr[indexOfCellAt$runtime_release] instanceof TrieNode)) {
            return Intrinsics.areEqual(e, objArr[indexOfCellAt$runtime_release]) ? removeCellAtIndex(indexOfCellAt$runtime_release, indexSegment) : this;
        }
        TrieNode<E> nodeAtIndex = nodeAtIndex(indexOfCellAt$runtime_release);
        TrieNode<E> collisionRemove = i2 == 30 ? nodeAtIndex.collisionRemove(e) : nodeAtIndex.remove(i, e, i2 + 5);
        return nodeAtIndex == collisionRemove ? this : updateNodeAtIndex(indexOfCellAt$runtime_release, collisionRemove);
    }

    public final void setBitmap(int i) {
        this.bitmap = i;
    }

    public final void setBuffer(@NotNull Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "<set-?>");
        this.buffer = objArr;
    }

    public final void setOwnedBy(@Nullable MutabilityOwnership mutabilityOwnership) {
        this.ownedBy = mutabilityOwnership;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TrieNode(int i, @NotNull Object[] objArr) {
        this(i, objArr, null);
        Intrinsics.checkNotNullParameter(objArr, "buffer");
    }
}
