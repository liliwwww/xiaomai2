package androidx.compose.p004ui.graphics.vector;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class VectorGroup$iterator$1 implements Iterator<VectorNode>, KMappedMarker {

    /* renamed from: it */
    @NotNull
    private final Iterator<VectorNode> f162it;

    VectorGroup$iterator$1(VectorGroup vectorGroup) {
        List list;
        list = vectorGroup.children;
        this.f162it = list.iterator();
    }

    @NotNull
    public final Iterator<VectorNode> getIt() {
        return this.f162it;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f162it.hasNext();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    @NotNull
    public VectorNode next() {
        return this.f162it.next();
    }
}
