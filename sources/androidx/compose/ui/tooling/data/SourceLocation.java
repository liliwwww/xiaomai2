package androidx.compose.ui.tooling.data;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
@UiToolingDataApi
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class SourceLocation {
    public static final int $stable = 0;
    private final int length;
    private final int lineNumber;
    private final int offset;
    private final int packageHash;

    @Nullable
    private final String sourceFile;

    public SourceLocation(int i, int i2, int i3, @Nullable String str, int i4) {
        this.lineNumber = i;
        this.offset = i2;
        this.length = i3;
        this.sourceFile = str;
        this.packageHash = i4;
    }

    public static /* synthetic */ SourceLocation copy$default(SourceLocation sourceLocation, int i, int i2, int i3, String str, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = sourceLocation.lineNumber;
        }
        if ((i5 & 2) != 0) {
            i2 = sourceLocation.offset;
        }
        int i6 = i2;
        if ((i5 & 4) != 0) {
            i3 = sourceLocation.length;
        }
        int i7 = i3;
        if ((i5 & 8) != 0) {
            str = sourceLocation.sourceFile;
        }
        String str2 = str;
        if ((i5 & 16) != 0) {
            i4 = sourceLocation.packageHash;
        }
        return sourceLocation.copy(i, i6, i7, str2, i4);
    }

    public final int component1() {
        return this.lineNumber;
    }

    public final int component2() {
        return this.offset;
    }

    public final int component3() {
        return this.length;
    }

    @Nullable
    public final String component4() {
        return this.sourceFile;
    }

    public final int component5() {
        return this.packageHash;
    }

    @NotNull
    public final SourceLocation copy(int i, int i2, int i3, @Nullable String str, int i4) {
        return new SourceLocation(i, i2, i3, str, i4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SourceLocation)) {
            return false;
        }
        SourceLocation sourceLocation = (SourceLocation) obj;
        return this.lineNumber == sourceLocation.lineNumber && this.offset == sourceLocation.offset && this.length == sourceLocation.length && Intrinsics.areEqual(this.sourceFile, sourceLocation.sourceFile) && this.packageHash == sourceLocation.packageHash;
    }

    public final int getLength() {
        return this.length;
    }

    public final int getLineNumber() {
        return this.lineNumber;
    }

    public final int getOffset() {
        return this.offset;
    }

    public final int getPackageHash() {
        return this.packageHash;
    }

    @Nullable
    public final String getSourceFile() {
        return this.sourceFile;
    }

    public int hashCode() {
        int i = ((((this.lineNumber * 31) + this.offset) * 31) + this.length) * 31;
        String str = this.sourceFile;
        return ((i + (str == null ? 0 : str.hashCode())) * 31) + this.packageHash;
    }

    @NotNull
    public String toString() {
        return "SourceLocation(lineNumber=" + this.lineNumber + ", offset=" + this.offset + ", length=" + this.length + ", sourceFile=" + this.sourceFile + ", packageHash=" + this.packageHash + ')';
    }
}
