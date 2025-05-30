package androidx.compose.p004ui.input;

import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.modifier.ModifierLocalConsumer;
import androidx.compose.p004ui.modifier.ModifierLocalProvider;
import androidx.compose.p004ui.modifier.ModifierLocalReadScope;
import androidx.compose.p004ui.modifier.ProvidableModifierLocal;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tb.mt2;
import tb.nt2;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
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
        Intrinsics.checkNotNullParameter(scrollContainerInfo, "scrollContainerInfo");
        this.scrollContainerInfo = scrollContainerInfo;
        this.parent$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.key = ScrollContainerInfoKt.getModifierLocalScrollContainerInfo();
        this.value = this;
    }

    private final ScrollContainerInfo getParent() {
        return (ScrollContainerInfo) this.parent$delegate.getValue();
    }

    private final void setParent(ScrollContainerInfo scrollContainerInfo) {
        this.parent$delegate.setValue(scrollContainerInfo);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.p004ui.Modifier
    public /* synthetic */ boolean all(Function1 function1) {
        return nt2.a(this, function1);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.p004ui.Modifier
    public /* synthetic */ boolean any(Function1 function1) {
        return nt2.b(this, function1);
    }

    @Override // androidx.compose.p004ui.input.ScrollContainerInfo
    public boolean canScrollHorizontally() {
        if (!this.scrollContainerInfo.canScrollHorizontally()) {
            ScrollContainerInfo parent = getParent();
            if (!(parent != null && parent.canScrollHorizontally())) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.compose.p004ui.input.ScrollContainerInfo
    public boolean canScrollVertically() {
        if (!this.scrollContainerInfo.canScrollVertically()) {
            ScrollContainerInfo parent = getParent();
            if (!(parent != null && parent.canScrollVertically())) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.p004ui.Modifier
    public /* synthetic */ Object foldIn(Object obj, Function2 function2) {
        return nt2.c(this, obj, function2);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.p004ui.Modifier
    public /* synthetic */ Object foldOut(Object obj, Function2 function2) {
        return nt2.d(this, obj, function2);
    }

    @Override // androidx.compose.p004ui.modifier.ModifierLocalProvider
    @NotNull
    public ProvidableModifierLocal<ScrollContainerInfo> getKey() {
        return this.key;
    }

    @Override // androidx.compose.p004ui.modifier.ModifierLocalConsumer
    public void onModifierLocalsUpdated(@NotNull ModifierLocalReadScope modifierLocalReadScope) {
        Intrinsics.checkNotNullParameter(modifierLocalReadScope, "scope");
        setParent((ScrollContainerInfo) modifierLocalReadScope.getCurrent(ScrollContainerInfoKt.getModifierLocalScrollContainerInfo()));
    }

    @Override // androidx.compose.p004ui.Modifier
    public /* synthetic */ Modifier then(Modifier modifier) {
        return mt2.a(this, modifier);
    }

    @Override // androidx.compose.p004ui.modifier.ModifierLocalProvider
    @NotNull
    public ScrollContainerInfo getValue() {
        return this.value;
    }
}
