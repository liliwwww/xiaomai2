package androidx.compose.p004ui.tooling.preview.datasource;

import androidx.compose.p004ui.tooling.preview.PreviewParameterProvider;
import androidx.compose.runtime.internal.StabilityInferred;
import java.util.Collection;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import tb.iy3;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: classes.dex */
public class CollectionPreviewParameterProvider<T> implements PreviewParameterProvider<T> {
    public static final int $stable = 8;

    @NotNull
    private final Collection<T> collection;

    /* JADX WARN: Multi-variable type inference failed */
    public CollectionPreviewParameterProvider(@NotNull Collection<? extends T> collection) {
        Intrinsics.checkNotNullParameter(collection, "collection");
        this.collection = collection;
    }

    @Override // androidx.compose.p004ui.tooling.preview.PreviewParameterProvider
    public /* synthetic */ int getCount() {
        return iy3.a(this);
    }

    @Override // androidx.compose.p004ui.tooling.preview.PreviewParameterProvider
    @NotNull
    public Sequence<T> getValues() {
        return CollectionsKt.asSequence(this.collection);
    }
}
