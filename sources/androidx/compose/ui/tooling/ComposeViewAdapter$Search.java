package androidx.compose.ui.tooling;

import androidx.compose.ui.tooling.data.Group;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class ComposeViewAdapter$Search<T> {

    @NotNull
    private final Set<T> animations;

    @NotNull
    private final Function1<Object, Unit> trackAnimation;

    public ComposeViewAdapter$Search(@NotNull Function1<Object, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "trackAnimation");
        this.trackAnimation = function1;
        this.animations = new LinkedHashSet();
    }

    @NotNull
    public final Set<T> getAnimations() {
        return this.animations;
    }

    @NotNull
    public final Function1<Object, Unit> getTrackAnimation() {
        return this.trackAnimation;
    }

    public final boolean hasAnimations() {
        return !this.animations.isEmpty();
    }

    public void parse(@NotNull Collection<? extends Group> collection) {
        Intrinsics.checkNotNullParameter(collection, "treeWithLocation");
    }

    public final void track() {
        Iterator<T> it = CollectionsKt.reversed(this.animations).iterator();
        while (it.hasNext()) {
            this.trackAnimation.invoke(it.next());
        }
    }
}
