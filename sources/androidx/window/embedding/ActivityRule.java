package androidx.window.embedding;

import androidx.window.core.ExperimentalWindowApi;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.l3;

/* compiled from: Taobao */
@ExperimentalWindowApi
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u0011\u0012\b\b\u0002\u0010\r\u001a\u00020\t¢\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0080\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096\u0002J\b\u0010\f\u001a\u00020\u000bH\u0016R\u0019\u0010\r\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Landroidx/window/embedding/ActivityRule;", "Landroidx/window/embedding/EmbeddingRule;", "Landroidx/window/embedding/ActivityFilter;", "filter", "plus$window_release", "(Landroidx/window/embedding/ActivityFilter;)Landroidx/window/embedding/ActivityRule;", "plus", "", "other", "", "equals", "", "hashCode", "alwaysExpand", "Z", "getAlwaysExpand", "()Z", "", "filters", "Ljava/util/Set;", "getFilters", "()Ljava/util/Set;", "<init>", "(Ljava/util/Set;Z)V", "window_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class ActivityRule extends EmbeddingRule {
    private final boolean alwaysExpand;

    @NotNull
    private final Set<ActivityFilter> filters;

    public /* synthetic */ ActivityRule(Set set, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(set, (i & 2) != 0 ? false : z);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ActivityRule)) {
            return false;
        }
        ActivityRule activityRule = (ActivityRule) other;
        return Intrinsics.areEqual(this.filters, activityRule.filters) && this.alwaysExpand == activityRule.alwaysExpand;
    }

    public final boolean getAlwaysExpand() {
        return this.alwaysExpand;
    }

    @NotNull
    public final Set<ActivityFilter> getFilters() {
        return this.filters;
    }

    public int hashCode() {
        return (this.filters.hashCode() * 31) + l3.a(this.alwaysExpand);
    }

    @NotNull
    public final ActivityRule plus$window_release(@NotNull ActivityFilter filter) {
        Intrinsics.checkNotNullParameter(filter, "filter");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.addAll(this.filters);
        linkedHashSet.add(filter);
        return new ActivityRule(CollectionsKt.toSet(linkedHashSet), this.alwaysExpand);
    }

    public ActivityRule(@NotNull Set<ActivityFilter> set, boolean z) {
        Intrinsics.checkNotNullParameter(set, "filters");
        this.alwaysExpand = z;
        this.filters = CollectionsKt.toSet(set);
    }
}
