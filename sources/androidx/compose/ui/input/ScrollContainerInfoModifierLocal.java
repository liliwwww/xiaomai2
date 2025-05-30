package androidx.compose.ui.input;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.modifier.ModifierLocalConsumer;
import androidx.compose.ui.modifier.ModifierLocalProvider;
import androidx.compose.ui.modifier.ModifierLocalReadScope;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tb.mt2;
import tb.nt2;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class ScrollContainerInfoModifierLocal implements ScrollContainerInfo, ModifierLocalProvider<ScrollContainerInfo>, ModifierLocalConsumer {

    @NotNull
    private final ProvidableModifierLocal<ScrollContainerInfo> key;

    @NotNull
    private final MutableState parent$delegate;

    @NotNull
    private final ScrollContainerInfo scrollContainerInfo;

    @NotNull
    private final ScrollContainerInfoModifierLocal value;

    public ScrollContainerInfoModifierLocal(@NotNull ScrollContainerInfo scrollContainerInfo) {
        MutableState mutableStateOf$default;
        Intrinsics.checkNotNullParameter(scrollContainerInfo, "scrollContainerInfo");
        this.scrollContainerInfo = scrollContainerInfo;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.parent$delegate = mutableStateOf$default;
        this.key = ScrollContainerInfoKt.getModifierLocalScrollContainerInfo();
        this.value = this;
    }

    private final ScrollContainerInfo getParent() {
        return (ScrollContainerInfo) this.parent$delegate.getValue();
    }

    private final void setParent(ScrollContainerInfo scrollContainerInfo) {
        this.parent$delegate.setValue(scrollContainerInfo);
    }

    public /* synthetic */ boolean all(Function1 function1) {
        return nt2.a(this, function1);
    }

    public /* synthetic */ boolean any(Function1 function1) {
        return nt2.b(this, function1);
    }

    @Override // androidx.compose.ui.input.ScrollContainerInfo
    public boolean canScrollHorizontally() {
        if (!this.scrollContainerInfo.canScrollHorizontally()) {
            ScrollContainerInfo parent = getParent();
            if (!(parent != null && parent.canScrollHorizontally())) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.compose.ui.input.ScrollContainerInfo
    public boolean canScrollVertically() {
        if (!this.scrollContainerInfo.canScrollVertically()) {
            ScrollContainerInfo parent = getParent();
            if (!(parent != null && parent.canScrollVertically())) {
                return false;
            }
        }
        return true;
    }

    public /* synthetic */ Object foldIn(Object obj, Function2 function2) {
        return nt2.c(this, obj, function2);
    }

    public /* synthetic */ Object foldOut(Object obj, Function2 function2) {
        return nt2.d(this, obj, function2);
    }

    @NotNull
    public ProvidableModifierLocal<ScrollContainerInfo> getKey() {
        return this.key;
    }

    public void onModifierLocalsUpdated(@NotNull ModifierLocalReadScope modifierLocalReadScope) {
        Intrinsics.checkNotNullParameter(modifierLocalReadScope, "scope");
        setParent((ScrollContainerInfo) modifierLocalReadScope.getCurrent(ScrollContainerInfoKt.getModifierLocalScrollContainerInfo()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ Modifier then(Modifier modifier) {
        return mt2.a(this, modifier);
    }

    @NotNull
    /* renamed from: getValue, reason: merged with bridge method [inline-methods] */
    public ScrollContainerInfoModifierLocal m1361getValue() {
        return this.value;
    }
}
