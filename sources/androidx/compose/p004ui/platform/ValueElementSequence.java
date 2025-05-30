package androidx.compose.p004ui.platform;

import androidx.compose.runtime.internal.StabilityInferred;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: classes.dex */
public final class ValueElementSequence implements Sequence<ValueElement> {
    public static final int $stable = 8;

    @NotNull
    private final List<ValueElement> elements = new ArrayList();

    @NotNull
    public Iterator<ValueElement> iterator() {
        return this.elements.iterator();
    }

    public final void set(@NotNull String str, @Nullable Object obj) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.elements.add(new ValueElement(str, obj));
    }
}
