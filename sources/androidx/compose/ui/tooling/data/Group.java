package androidx.compose.ui.tooling.data;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.layout.ModifierInfo;
import androidx.compose.ui.unit.IntRect;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
@UiToolingDataApi
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public abstract class Group {
    public static final int $stable = 8;

    @NotNull
    private final IntRect box;

    @NotNull
    private final Collection<Group> children;

    @NotNull
    private final Collection<Object> data;

    @Nullable
    private final Object identity;

    @Nullable
    private final Object key;

    @Nullable
    private final SourceLocation location;

    @Nullable
    private final String name;

    /* JADX WARN: Multi-variable type inference failed */
    private Group(Object obj, String str, SourceLocation sourceLocation, Object obj2, IntRect intRect, Collection<? extends Object> collection, Collection<? extends Group> collection2) {
        this.key = obj;
        this.name = str;
        this.location = sourceLocation;
        this.identity = obj2;
        this.box = intRect;
        this.data = collection;
        this.children = collection2;
    }

    public /* synthetic */ Group(Object obj, String str, SourceLocation sourceLocation, Object obj2, IntRect intRect, Collection collection, Collection collection2, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, str, sourceLocation, obj2, intRect, collection, collection2);
    }

    @NotNull
    public final IntRect getBox() {
        return this.box;
    }

    @NotNull
    public final Collection<Group> getChildren() {
        return this.children;
    }

    @NotNull
    public final Collection<Object> getData() {
        return this.data;
    }

    @Nullable
    public final Object getIdentity() {
        return this.identity;
    }

    @Nullable
    public final Object getKey() {
        return this.key;
    }

    @Nullable
    public final SourceLocation getLocation() {
        return this.location;
    }

    @NotNull
    public List<ModifierInfo> getModifierInfo() {
        return CollectionsKt.emptyList();
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @NotNull
    public List<ParameterInformation> getParameters() {
        return CollectionsKt.emptyList();
    }
}
