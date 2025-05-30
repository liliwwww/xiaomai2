package androidx.compose.ui.modifier;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.BackwardsCompatNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.Owner;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class ModifierLocalManager {

    @NotNull
    private final MutableVector<BackwardsCompatNode> inserted;

    @NotNull
    private final MutableVector<ModifierLocal<?>> insertedLocal;
    private boolean invalidated;

    @NotNull
    private final Owner owner;

    @NotNull
    private final MutableVector<LayoutNode> removed;

    @NotNull
    private final MutableVector<ModifierLocal<?>> removedLocal;

    public ModifierLocalManager(@NotNull Owner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        this.owner = owner;
        this.inserted = new MutableVector<>(new BackwardsCompatNode[16], 0);
        this.insertedLocal = new MutableVector<>(new ModifierLocal[16], 0);
        this.removed = new MutableVector<>(new LayoutNode[16], 0);
        this.removedLocal = new MutableVector<>(new ModifierLocal[16], 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void invalidateConsumersOfNodeForKey(Modifier$Node modifier$Node, ModifierLocal<?> modifierLocal, Set<BackwardsCompatNode> set) {
        boolean z;
        int m1660constructorimpl = NodeKind.m1660constructorimpl(32);
        if (!modifier$Node.getNode().isAttached()) {
            throw new IllegalStateException("Check failed.".toString());
        }
        MutableVector mutableVector = new MutableVector(new Modifier$Node[16], 0);
        Modifier$Node child$ui_release = modifier$Node.getNode().getChild$ui_release();
        if (child$ui_release == null) {
            DelegatableNodeKt.addLayoutNodeChildren(mutableVector, modifier$Node.getNode());
        } else {
            mutableVector.add(child$ui_release);
        }
        while (mutableVector.isNotEmpty()) {
            Modifier$Node modifier$Node2 = (Modifier$Node) mutableVector.removeAt(mutableVector.getSize() - 1);
            if ((modifier$Node2.getAggregateChildKindSet$ui_release() & m1660constructorimpl) != 0) {
                for (Modifier$Node modifier$Node3 = modifier$Node2; modifier$Node3 != null; modifier$Node3 = modifier$Node3.getChild$ui_release()) {
                    if ((modifier$Node3.getKindSet$ui_release() & m1660constructorimpl) != 0) {
                        if (modifier$Node3 instanceof ModifierLocalNode) {
                            ModifierLocalNode modifierLocalNode = (ModifierLocalNode) modifier$Node3;
                            if (modifierLocalNode instanceof BackwardsCompatNode) {
                                BackwardsCompatNode backwardsCompatNode = (BackwardsCompatNode) modifierLocalNode;
                                if ((backwardsCompatNode.getElement() instanceof ModifierLocalConsumer) && backwardsCompatNode.getReadValues().contains(modifierLocal)) {
                                    set.add(modifierLocalNode);
                                }
                            }
                            z = !modifierLocalNode.getProvidedValues().contains$ui_release(modifierLocal);
                        } else {
                            z = true;
                        }
                        if (z) {
                        }
                    }
                }
            }
            DelegatableNodeKt.addLayoutNodeChildren(mutableVector, modifier$Node2);
        }
    }

    @NotNull
    public final Owner getOwner() {
        return this.owner;
    }

    public final void insertedProvider(@NotNull BackwardsCompatNode backwardsCompatNode, @NotNull ModifierLocal<?> modifierLocal) {
        Intrinsics.checkNotNullParameter(backwardsCompatNode, "node");
        Intrinsics.checkNotNullParameter(modifierLocal, "key");
        this.inserted.add(backwardsCompatNode);
        this.insertedLocal.add(modifierLocal);
        invalidate();
    }

    public final void invalidate() {
        if (this.invalidated) {
            return;
        }
        this.invalidated = true;
        this.owner.registerOnEndApplyChangesListener(new Function0<Unit>() { // from class: androidx.compose.ui.modifier.ModifierLocalManager$invalidate$1
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m1585invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m1585invoke() {
                ModifierLocalManager.this.triggerUpdates();
            }
        });
    }

    public final void removedProvider(@NotNull BackwardsCompatNode backwardsCompatNode, @NotNull ModifierLocal<?> modifierLocal) {
        Intrinsics.checkNotNullParameter(backwardsCompatNode, "node");
        Intrinsics.checkNotNullParameter(modifierLocal, "key");
        this.removed.add(DelegatableNodeKt.requireLayoutNode(backwardsCompatNode));
        this.removedLocal.add(modifierLocal);
        invalidate();
    }

    public final void triggerUpdates() {
        int i = 0;
        this.invalidated = false;
        HashSet hashSet = new HashSet();
        MutableVector<LayoutNode> mutableVector = this.removed;
        int size = mutableVector.getSize();
        if (size > 0) {
            Object[] content = mutableVector.getContent();
            int i2 = 0;
            do {
                LayoutNode layoutNode = (LayoutNode) content[i2];
                ModifierLocal<?> modifierLocal = (ModifierLocal) this.removedLocal.getContent()[i2];
                if (layoutNode.isAttached()) {
                    invalidateConsumersOfNodeForKey(layoutNode.getNodes$ui_release().getHead$ui_release(), modifierLocal, hashSet);
                }
                i2++;
            } while (i2 < size);
        }
        this.removed.clear();
        this.removedLocal.clear();
        MutableVector<BackwardsCompatNode> mutableVector2 = this.inserted;
        int size2 = mutableVector2.getSize();
        if (size2 > 0) {
            Object[] content2 = mutableVector2.getContent();
            do {
                BackwardsCompatNode backwardsCompatNode = (BackwardsCompatNode) content2[i];
                ModifierLocal<?> modifierLocal2 = (ModifierLocal) this.insertedLocal.getContent()[i];
                if (backwardsCompatNode.isAttached()) {
                    invalidateConsumersOfNodeForKey(backwardsCompatNode, modifierLocal2, hashSet);
                }
                i++;
            } while (i < size2);
        }
        this.inserted.clear();
        this.insertedLocal.clear();
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            ((BackwardsCompatNode) it.next()).updateModifierLocalConsumer();
        }
    }

    public final void updatedProvider(@NotNull BackwardsCompatNode backwardsCompatNode, @NotNull ModifierLocal<?> modifierLocal) {
        Intrinsics.checkNotNullParameter(backwardsCompatNode, "node");
        Intrinsics.checkNotNullParameter(modifierLocal, "key");
        this.inserted.add(backwardsCompatNode);
        this.insertedLocal.add(modifierLocal);
        invalidate();
    }
}
