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
public final class ComposeViewAdapter$AnimatedVisibilitySearch extends ComposeViewAdapter$Search<Transition<Object>> {
    final /* synthetic */ ComposeViewAdapter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ComposeViewAdapter$AnimatedVisibilitySearch(@NotNull ComposeViewAdapter composeViewAdapter, Function1<Object, Unit> function1) {
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
            if (Intrinsics.areEqual(((Group) obj2).getName(), "AnimatedVisibility")) {
                arrayList.add(obj2);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (true) {
            Object obj3 = null;
            if (!it.hasNext()) {
                break;
            }
            Iterator<T> it2 = ((Group) it.next()).getChildren().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next = it2.next();
                if (Intrinsics.areEqual(((Group) next).getName(), "updateTransition")) {
                    obj3 = next;
                    break;
                }
            }
            Group group = (Group) obj3;
            if (group != null) {
                arrayList2.add(group);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator it3 = arrayList2.iterator();
        while (it3.hasNext()) {
            Group access$firstOrNull = ComposeViewAdapter.access$firstOrNull(composeViewAdapter, (Group) it3.next(), ComposeViewAdapter.findRememberCall.rememberCalls.1.1.INSTANCE);
            if (access$firstOrNull != null) {
                arrayList3.add(access$firstOrNull);
            }
        }
        ArrayList arrayList4 = new ArrayList();
        Iterator it4 = arrayList3.iterator();
        while (it4.hasNext()) {
            Iterator<T> it5 = ((Group) it4.next()).getData().iterator();
            while (true) {
                if (it5.hasNext()) {
                    obj = it5.next();
                    if (obj instanceof Transition) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            if (!(obj instanceof Transition)) {
                obj = null;
            }
            Transition transition = (Transition) obj;
            if (transition != null) {
                arrayList4.add(transition);
            }
        }
        animations.addAll(arrayList4);
    }
}
