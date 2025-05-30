package androidx.compose.p004ui.tooling.data;

import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
final class SourceLocationInfo {

    @Nullable
    private final Integer length;

    @Nullable
    private final Integer lineNumber;

    @Nullable
    private final Integer offset;

    public SourceLocationInfo(@Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3) {
        this.lineNumber = num;
        this.offset = num2;
        this.length = num3;
    }

    @Nullable
    public final Integer getLength() {
        return this.length;
    }

    @Nullable
    public final Integer getLineNumber() {
        return this.lineNumber;
    }

    @Nullable
    public final Integer getOffset() {
        return this.offset;
    }
}
