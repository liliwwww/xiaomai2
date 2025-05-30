package androidx.compose.p004ui.modifier;

import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.node.BackwardsCompatNode;
import androidx.compose.p004ui.node.DelegatableNodeKt;
import androidx.compose.p004ui.node.LayoutNode;
import androidx.compose.p004ui.node.NodeKind;
import androidx.compose.p004ui.node.Owner;
import androidx.compose.runtime.collection.MutableVector;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
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
    private final void invalidateConsumersOfNodeForKey(Modifier.Node node, ModifierLocal<?> modifierLocal, Set<BackwardsCompatNode> set) {
        boolean z;
        int m4398constructorimpl = NodeKind.m4398constructorimpl(32);
        if (!node.getNode().isAttached()) {
            throw new IllegalStateException("Check failed.".toString());
        }
        MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child$ui_release = node.getNode().getChild$ui_release();
        if (child$ui_release == null) {
            DelegatableNodeKt.addLayoutNodeChildren(mutableVector, node.getNode());
        } else {
            mutableVector.add(child$ui_release);
        }
        while (mutableVector.isNotEmpty()) {
            Modifier.Node node2 = (Modifier.Node) mutableVector.removeAt(mutableVector.getSize() - 1);
            if ((node2.getAggregateChildKindSet$ui_release() & m4398constructorimpl) != 0) {
                for (Modifier.Node node3 = node2; node3 != null; node3 = node3.getChild$ui_release()) {
                    if ((node3.getKindSet$ui_release() & m4398constructorimpl) != 0) {
                        if (node3 instanceof ModifierLocalNode) {
                            ModifierLocalNode modifierLocalNode = (ModifierLocalNode) node3;
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
            DelegatableNodeKt.addLayoutNodeChildren(mutableVector, node2);
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
                m4261invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m4261invoke() {
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
            LayoutNode[] content = mutableVector.getContent();
            int i2 = 0;
            do {
                LayoutNode layoutNode = content[i2];
                ModifierLocal<?> modifierLocal = this.removedLocal.getContent()[i2];
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
            BackwardsCompatNode[] content2 = mutableVector2.getContent();
            do {
                BackwardsCompatNode backwardsCompatNode = content2[i];
                ModifierLocal<?> modifierLocal2 = this.insertedLocal.getContent()[i];
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
