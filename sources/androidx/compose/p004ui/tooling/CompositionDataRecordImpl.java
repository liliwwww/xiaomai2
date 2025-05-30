package androidx.compose.p004ui.tooling;

import androidx.compose.runtime.tooling.CompositionData;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
final class CompositionDataRecordImpl implements CompositionDataRecord {

    @NotNull
    private final Set<CompositionData> store;

    public CompositionDataRecordImpl() {
        Set<CompositionData> newSetFromMap = Collections.newSetFromMap(new WeakHashMap());
        Intrinsics.checkNotNullExpressionValue(newSetFromMap, "newSetFromMap(WeakHashMap())");
        this.store = newSetFromMap;
    }

    @Override // androidx.compose.p004ui.tooling.CompositionDataRecord
    @NotNull
    public Set<CompositionData> getStore() {
        return this.store;
    }
}
