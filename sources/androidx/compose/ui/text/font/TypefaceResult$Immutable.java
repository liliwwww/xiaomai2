package androidx.compose.ui.text.font;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class TypefaceResult$Immutable implements TypefaceResult {
    public static final int $stable = 0;
    private final boolean cacheable;

    @NotNull
    private final Object value;

    public TypefaceResult$Immutable(@NotNull Object obj, boolean z) {
        Intrinsics.checkNotNullParameter(obj, "value");
        this.value = obj;
        this.cacheable = z;
    }

    public boolean getCacheable() {
        return this.cacheable;
    }

    @NotNull
    public Object getValue() {
        return this.value;
    }

    public /* synthetic */ TypefaceResult$Immutable(Object obj, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, (i & 2) != 0 ? true : z);
    }
}
