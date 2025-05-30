package androidx.compose.ui.tooling;

import androidx.compose.animation.core.Animatable;
import androidx.compose.ui.tooling.ComposeViewAdapter;
import androidx.compose.ui.tooling.data.Group;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class ComposeViewAdapter$AnimateXAsStateSearch extends ComposeViewAdapter$Search<Animatable<?, ?>> {
    final /* synthetic */ ComposeViewAdapter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ComposeViewAdapter$AnimateXAsStateSearch(@NotNull ComposeViewAdapter composeViewAdapter, Function1<Object, Unit> function1) {
        super(function1);
        Intrinsics.checkNotNullParameter(function1, "trackAnimation");
        this.this$0 = composeViewAdapter;
    }

    @Override // androidx.compose.ui.tooling.ComposeViewAdapter$Search
    public void parse(@NotNull Collection<? extends Group> collection) {
        Object obj;
        Intrinsics.checkNotNullParameter(collection, "treeWithLocation");
        Set<Animatable<?, ?>> animations = getAnimations();
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : collection) {
            if (Intrinsics.areEqual(((Group) obj2).getName(), "animateValueAsState")) {
                arrayList.add(obj2);
            }
        }
        ComposeViewAdapter composeViewAdapter = this.this$0;
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Collection<Group> children = ((Group) it.next()).getChildren();
            ArrayList arrayList3 = new ArrayList();
            Iterator<T> it2 = children.iterator();
            while (it2.hasNext()) {
                Group access$firstOrNull = ComposeViewAdapter.access$firstOrNull(composeViewAdapter, (Group) it2.next(), ComposeViewAdapter.findRememberCall.rememberCalls.1.1.INSTANCE);
                if (access$firstOrNull != null) {
                    arrayList3.add(access$firstOrNull);
                }
            }
            ArrayList arrayList4 = new ArrayList();
            Iterator it3 = arrayList3.iterator();
            while (it3.hasNext()) {
                Iterator<T> it4 = ((Group) it3.next()).getData().iterator();
                while (true) {
                    if (it4.hasNext()) {
                        obj = it4.next();
                        if (obj instanceof Animatable) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                Animatable animatable = (Animatable) (obj instanceof Animatable ? obj : null);
                if (animatable != null) {
                    arrayList4.add(animatable);
                }
            }
            Animatable animatable2 = (Animatable) CollectionsKt.firstOrNull(arrayList4);
            if (animatable2 != null) {
                arrayList2.add(animatable2);
            }
        }
        animations.addAll(CollectionsKt.toSet(arrayList2));
    }
}
