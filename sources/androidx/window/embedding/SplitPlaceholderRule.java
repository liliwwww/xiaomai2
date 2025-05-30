package androidx.window.embedding;

import android.content.Intent;
import androidx.window.core.ExperimentalWindowApi;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@ExperimentalWindowApi
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001BE\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u0012\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0019\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u000b¢\u0006\u0004\b\u001c\u0010\u001dJ\u0018\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0080\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096\u0002J\b\u0010\f\u001a\u00020\u000bH\u0016R\u0019\u0010\u000e\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001e"}, d2 = {"Landroidx/window/embedding/SplitPlaceholderRule;", "Landroidx/window/embedding/SplitRule;", "Landroidx/window/embedding/ActivityFilter;", "filter", "plus$window_release", "(Landroidx/window/embedding/ActivityFilter;)Landroidx/window/embedding/SplitPlaceholderRule;", "plus", "", "other", "", "equals", "", "hashCode", "Landroid/content/Intent;", "placeholderIntent", "Landroid/content/Intent;", "getPlaceholderIntent", "()Landroid/content/Intent;", "", "filters", "Ljava/util/Set;", "getFilters", "()Ljava/util/Set;", "minWidth", "minSmallestWidth", "", "splitRatio", "layoutDirection", "<init>", "(Ljava/util/Set;Landroid/content/Intent;IIFI)V", "window_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class SplitPlaceholderRule extends SplitRule {

    @NotNull
    private final Set<ActivityFilter> filters;

    @NotNull
    private final Intent placeholderIntent;

    public /* synthetic */ SplitPlaceholderRule(Set set, Intent intent, int i, int i2, float f, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(set, intent, (i4 & 4) != 0 ? 0 : i, (i4 & 8) != 0 ? 0 : i2, (i4 & 16) != 0 ? 0.5f : f, (i4 & 32) != 0 ? 3 : i3);
    }

    @Override // androidx.window.embedding.SplitRule
    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SplitPlaceholderRule) || !super.equals(other) || !super.equals(other)) {
            return false;
        }
        SplitPlaceholderRule splitPlaceholderRule = (SplitPlaceholderRule) other;
        return Intrinsics.areEqual(this.filters, splitPlaceholderRule.filters) && Intrinsics.areEqual(this.placeholderIntent, splitPlaceholderRule.placeholderIntent);
    }

    @NotNull
    public final Set<ActivityFilter> getFilters() {
        return this.filters;
    }

    @NotNull
    public final Intent getPlaceholderIntent() {
        return this.placeholderIntent;
    }

    @Override // androidx.window.embedding.SplitRule
    public int hashCode() {
        return (((super.hashCode() * 31) + this.filters.hashCode()) * 31) + this.placeholderIntent.hashCode();
    }

    @NotNull
    public final SplitPlaceholderRule plus$window_release(@NotNull ActivityFilter filter) {
        Intrinsics.checkNotNullParameter(filter, "filter");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.addAll(this.filters);
        linkedHashSet.add(filter);
        return new SplitPlaceholderRule(CollectionsKt.toSet(linkedHashSet), this.placeholderIntent, getMinWidth(), getMinSmallestWidth(), getSplitRatio(), getLayoutDirection());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SplitPlaceholderRule(@NotNull Set<ActivityFilter> set, @NotNull Intent intent, int i, int i2, float f, int i3) {
        super(i, i2, f, i3);
        Intrinsics.checkNotNullParameter(set, "filters");
        Intrinsics.checkNotNullParameter(intent, "placeholderIntent");
        this.placeholderIntent = intent;
        this.filters = CollectionsKt.toSet(set);
    }
}
