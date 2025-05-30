package androidx.compose.ui.tooling;

import androidx.compose.animation.core.Transition;
import androidx.compose.ui.tooling.ComposeViewAdapter;
import androidx.compose.ui.tooling.data.Group;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class ComposeViewAdapter$TransitionSearch extends ComposeViewAdapter$Search<Transition<Object>> {
    final /* synthetic */ ComposeViewAdapter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ComposeViewAdapter$TransitionSearch(@NotNull ComposeViewAdapter composeViewAdapter, Function1<Object, Unit> function1) {
        super(function1);
        Intrinsics.checkNotNullParameter(function1, "trackAnimation");
        this.this$0 = composeViewAdapter;
    }

    @Override // androidx.compose.ui.tooling.ComposeViewAdapter$Search
    public void parse(@NotNull Collection<? extends Group> collection) {
        Object obj;
        Intrinsics.checkNotNullParameter(collection, "treeWithLocation");
        Set<Transition<Object>> animations = getAnimations();
        ComposeViewAdapter composeViewAdapter = this.this$0;
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : collection) {
            if (Intrinsics.areEqual(((Group) obj2).getName(), "updateTransition")) {
                arrayList.add(obj2);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Group access$firstOrNull = ComposeViewAdapter.access$firstOrNull(composeViewAdapter, (Group) it.next(), ComposeViewAdapter.findRememberCall.rememberCalls.1.1.INSTANCE);
            if (access$firstOrNull != null) {
                arrayList2.add(access$firstOrNull);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            Iterator<T> it3 = ((Group) it2.next()).getData().iterator();
            while (true) {
                if (it3.hasNext()) {
                    obj = it3.next();
                    if (obj instanceof Transition) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            Transition transition = (Transition) (obj instanceof Transition ? obj : null);
            if (transition != null) {
                arrayList3.add(transition);
            }
        }
        animations.addAll(arrayList3);
    }
}
