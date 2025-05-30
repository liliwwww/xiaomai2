package androidx.compose.p004ui.tooling.data;

import androidx.compose.p004ui.unit.IntRect;
import androidx.compose.runtime.tooling.CompositionGroup;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@UiToolingDataApi
/* loaded from: classes2.dex */
final class CompositionCallStack<T> implements SourceContext {

    @NotNull
    private IntRect bounds;

    @NotNull
    private final Map<String, Object> contexts;
    private int currentCallIndex;

    @NotNull
    private final Function3<CompositionGroup, SourceContext, List<? extends T>, T> factory;

    @NotNull
    private final ArrayDeque<CompositionGroup> stack;

    /* JADX WARN: Multi-variable type inference failed */
    public CompositionCallStack(@NotNull Function3<? super CompositionGroup, ? super SourceContext, ? super List<? extends T>, ? extends T> function3, @NotNull Map<String, Object> map) {
        Intrinsics.checkNotNullParameter(function3, "factory");
        Intrinsics.checkNotNullParameter(map, "contexts");
        this.factory = function3;
        this.contexts = map;
        this.stack = new ArrayDeque<>();
        this.bounds = SlotTreeKt.getEmptyBox();
    }

    private final SourceInformationContext contextOf(String str) {
        Map<String, Object> map = this.contexts;
        Object obj = map.get(str);
        if (obj == null) {
            obj = SlotTreeKt.sourceInformationContextOf$default(str, null, 2, null);
            map.put(str, obj);
        }
        if (obj instanceof SourceInformationContext) {
            return (SourceInformationContext) obj;
        }
        return null;
    }

    private final CompositionGroup getCurrent() {
        return (CompositionGroup) this.stack.last();
    }

    private final boolean isCall(CompositionGroup compositionGroup) {
        String sourceInfo = compositionGroup.getSourceInfo();
        if (sourceInfo != null) {
            return StringsKt.startsWith$default(sourceInfo, "C", false, 2, (Object) null);
        }
        return false;
    }

    private final CompositionGroup parentGroup(int i) {
        if (this.stack.size() <= i) {
            return null;
        }
        return (CompositionGroup) this.stack.get((r0.size() - i) - 1);
    }

    private final CompositionGroup pop() {
        return (CompositionGroup) this.stack.removeLast();
    }

    private final void push(CompositionGroup compositionGroup) {
        this.stack.addLast(compositionGroup);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x004b, code lost:
    
        r2 = androidx.compose.p004ui.tooling.data.SlotTreeKt.boundsOfLayoutNode(r2);
     */
    /* JADX WARN: Multi-variable type inference failed */
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final androidx.compose.p004ui.unit.IntRect convert(@org.jetbrains.annotations.NotNull androidx.compose.runtime.tooling.CompositionGroup r7, int r8, @org.jetbrains.annotations.NotNull java.util.List<T> r9) {
        /*
            r6 = this;
            java.lang.String r0 = "group"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "out"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            androidx.compose.ui.unit.IntRect r1 = androidx.compose.p004ui.tooling.data.SlotTreeKt.getEmptyBox()
            r6.push(r7)
            java.lang.Iterable r2 = r7.getCompositionGroups()
            java.util.Iterator r2 = r2.iterator()
            r3 = 0
        L20:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L3d
            java.lang.Object r4 = r2.next()
            androidx.compose.runtime.tooling.CompositionGroup r4 = (androidx.compose.runtime.tooling.CompositionGroup) r4
            androidx.compose.ui.unit.IntRect r5 = r6.convert(r4, r3, r0)
            androidx.compose.ui.unit.IntRect r1 = androidx.compose.p004ui.tooling.data.SlotTreeKt.union(r1, r5)
            boolean r4 = r6.isCall(r4)
            if (r4 == 0) goto L20
            int r3 = r3 + 1
            goto L20
        L3d:
            java.lang.Object r2 = r7.getNode()
            boolean r3 = r2 instanceof androidx.compose.p004ui.layout.LayoutInfo
            if (r3 == 0) goto L48
            androidx.compose.ui.layout.LayoutInfo r2 = (androidx.compose.p004ui.layout.LayoutInfo) r2
            goto L49
        L48:
            r2 = 0
        L49:
            if (r2 == 0) goto L53
            androidx.compose.ui.unit.IntRect r2 = androidx.compose.p004ui.tooling.data.SlotTreeKt.access$boundsOfLayoutNode(r2)
            if (r2 != 0) goto L52
            goto L53
        L52:
            r1 = r2
        L53:
            r6.currentCallIndex = r8
            r6.bounds = r1
            kotlin.jvm.functions.Function3<androidx.compose.runtime.tooling.CompositionGroup, androidx.compose.ui.tooling.data.SourceContext, java.util.List<? extends T>, T> r8 = r6.factory
            java.lang.Object r7 = r8.invoke(r7, r6, r0)
            if (r7 == 0) goto L62
            r9.add(r7)
        L62:
            r6.pop()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.p004ui.tooling.data.CompositionCallStack.convert(androidx.compose.runtime.tooling.CompositionGroup, int, java.util.List):androidx.compose.ui.unit.IntRect");
    }

    @Override // androidx.compose.p004ui.tooling.data.SourceContext
    @NotNull
    public IntRect getBounds() {
        return this.bounds;
    }

    @Override // androidx.compose.p004ui.tooling.data.SourceContext
    public int getDepth() {
        return this.stack.size();
    }

    @Override // androidx.compose.p004ui.tooling.data.SourceContext
    @Nullable
    public SourceLocation getLocation() {
        String sourceInfo;
        SourceInformationContext contextOf;
        String sourceInfo2;
        CompositionGroup parentGroup = parentGroup(1);
        if (parentGroup == null || (sourceInfo = parentGroup.getSourceInfo()) == null || (contextOf = contextOf(sourceInfo)) == null) {
            return null;
        }
        int i = 2;
        SourceInformationContext sourceInformationContext = contextOf;
        while (i < this.stack.size()) {
            if ((sourceInformationContext != null ? sourceInformationContext.getSourceFile() : null) != null) {
                break;
            }
            int i2 = i + 1;
            CompositionGroup parentGroup2 = parentGroup(i);
            sourceInformationContext = (parentGroup2 == null || (sourceInfo2 = parentGroup2.getSourceInfo()) == null) ? null : contextOf(sourceInfo2);
            i = i2;
        }
        return contextOf.sourceLocation(this.currentCallIndex, sourceInformationContext);
    }

    @Override // androidx.compose.p004ui.tooling.data.SourceContext
    @Nullable
    public String getName() {
        int indexOf$default;
        String sourceInfo = getCurrent().getSourceInfo();
        if (sourceInfo == null || !StringsKt.startsWith$default(sourceInfo, "C(", false, 2, (Object) null) || (indexOf$default = StringsKt.indexOf$default(sourceInfo, ')', 0, false, 6, (Object) null)) <= 2) {
            return null;
        }
        String substring = sourceInfo.substring(2, indexOf$default);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    @Override // androidx.compose.p004ui.tooling.data.SourceContext
    @NotNull
    public List<ParameterInformation> getParameters() {
        SourceInformationContext contextOf;
        List<ParameterInformation> extractParameterInfo;
        CompositionGroup current = getCurrent();
        String sourceInfo = current.getSourceInfo();
        if (sourceInfo == null || (contextOf = contextOf(sourceInfo)) == null) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        CollectionsKt.addAll(arrayList, current.getData());
        extractParameterInfo = SlotTreeKt.extractParameterInfo(arrayList, contextOf);
        return extractParameterInfo;
    }
}
