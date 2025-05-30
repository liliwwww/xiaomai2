package androidx.compose.ui.tooling;

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
public final class ComposeViewAdapter$AnimateContentSizeSearch extends ComposeViewAdapter$Search<Object> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ComposeViewAdapter$AnimateContentSizeSearch(@NotNull Function1<Object, Unit> function1) {
        super(function1);
        Intrinsics.checkNotNullParameter(function1, "trackAnimation");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.ui.tooling.ComposeViewAdapter$Search
    public void parse(@NotNull Collection<? extends Group> collection) {
        String str;
        Intrinsics.checkNotNullParameter(collection, "treeWithLocation");
        Set<Object> animations = getAnimations();
        ArrayList arrayList = new ArrayList();
        for (Object obj : collection) {
            if (Intrinsics.areEqual(((Group) obj).getName(), "remember")) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Iterator<T> it2 = ((Group) it.next()).getData().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next = it2.next();
                if (Intrinsics.areEqual(next != 0 ? next.getClass().getName() : null, "androidx.compose.animation.SizeAnimationModifier")) {
                    str = next;
                    break;
                }
            }
            if (str != null) {
                arrayList2.add(str);
            }
        }
        animations.addAll(CollectionsKt.toSet(arrayList2));
    }
}
