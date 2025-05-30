package androidx.compose.p004ui.tooling.data;

import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
final class Parameter {

    @Nullable
    private final String inlineClass;
    private final int sortedIndex;

    public Parameter(int i, @Nullable String str) {
        this.sortedIndex = i;
        this.inlineClass = str;
    }

    @Nullable
    public final String getInlineClass() {
        return this.inlineClass;
    }

    public final int getSortedIndex() {
        return this.sortedIndex;
    }

    public /* synthetic */ Parameter(int i, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? null : str);
    }
}
