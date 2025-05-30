package androidx.compose.ui.tooling.data;

import androidx.compose.runtime.tooling.CompositionGroup;
import androidx.compose.ui.layout.LayoutInfo;
import androidx.compose.ui.unit.IntRect;
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
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
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
            obj = SlotTreeKt.sourceInformationContextOf$default(str, (SourceInformationContext) null, 2, (Object) null);
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

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final IntRect convert(@NotNull CompositionGroup compositionGroup, int i, @NotNull List<T> list) {
        IntRect access$boundsOfLayoutNode;
        Intrinsics.checkNotNullParameter(compositionGroup, "group");
        Intrinsics.checkNotNullParameter(list, "out");
        ArrayList arrayList = new ArrayList();
        IntRect emptyBox = SlotTreeKt.getEmptyBox();
        push(compositionGroup);
        int i2 = 0;
        for (CompositionGroup compositionGroup2 : compositionGroup.getCompositionGroups()) {
            emptyBox = SlotTreeKt.union(emptyBox, convert(compositionGroup2, i2, arrayList));
            if (isCall(compositionGroup2)) {
                i2++;
            }
        }
        Object node = compositionGroup.getNode();
        LayoutInfo layoutInfo = node instanceof LayoutInfo ? (LayoutInfo) node : null;
        if (layoutInfo != null && (access$boundsOfLayoutNode = SlotTreeKt.access$boundsOfLayoutNode(layoutInfo)) != null) {
            emptyBox = access$boundsOfLayoutNode;
        }
        this.currentCallIndex = i;
        this.bounds = emptyBox;
        Object invoke = this.factory.invoke(compositionGroup, this, arrayList);
        if (invoke != null) {
            list.add(invoke);
        }
        pop();
        return emptyBox;
    }

    @Override // androidx.compose.ui.tooling.data.SourceContext
    @NotNull
    public IntRect getBounds() {
        return this.bounds;
    }

    @Override // androidx.compose.ui.tooling.data.SourceContext
    public int getDepth() {
        return this.stack.size();
    }

    @Override // androidx.compose.ui.tooling.data.SourceContext
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

    @Override // androidx.compose.ui.tooling.data.SourceContext
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

    @Override // androidx.compose.ui.tooling.data.SourceContext
    @NotNull
    public List<ParameterInformation> getParameters() {
        SourceInformationContext contextOf;
        CompositionGroup current = getCurrent();
        String sourceInfo = current.getSourceInfo();
        if (sourceInfo == null || (contextOf = contextOf(sourceInfo)) == null) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        CollectionsKt.addAll(arrayList, current.getData());
        return SlotTreeKt.access$extractParameterInfo(arrayList, contextOf);
    }
}
