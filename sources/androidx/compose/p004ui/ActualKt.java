package androidx.compose.p004ui;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class ActualKt {
    public static final boolean areObjectsOfSameType(@NotNull Object obj, @NotNull Object obj2) {
        Intrinsics.checkNotNullParameter(obj, "a");
        Intrinsics.checkNotNullParameter(obj2, "b");
        return obj.getClass() == obj2.getClass();
    }
}
