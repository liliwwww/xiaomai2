package androidx.compose.p004ui.tooling.data;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@UiToolingDataApi
/* loaded from: classes2.dex */
final class SourceInformationContext {
    private final boolean isCall;

    @NotNull
    private final List<SourceLocationInfo> locations;

    @Nullable
    private final String name;
    private int nextLocation;
    private final int packageHash;

    @Nullable
    private final List<Parameter> parameters;
    private final int repeatOffset;

    @Nullable
    private final String sourceFile;

    public SourceInformationContext(@Nullable String str, @Nullable String str2, int i, @NotNull List<SourceLocationInfo> list, int i2, @Nullable List<Parameter> list2, boolean z) {
        Intrinsics.checkNotNullParameter(list, "locations");
        this.name = str;
        this.sourceFile = str2;
        this.packageHash = i;
        this.locations = list;
        this.repeatOffset = i2;
        this.parameters = list2;
        this.isCall = z;
    }

    @NotNull
    public final List<SourceLocationInfo> getLocations() {
        return this.locations;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    public final int getPackageHash() {
        return this.packageHash;
    }

    @Nullable
    public final List<Parameter> getParameters() {
        return this.parameters;
    }

    public final int getRepeatOffset() {
        return this.repeatOffset;
    }

    @Nullable
    public final String getSourceFile() {
        return this.sourceFile;
    }

    public final boolean isCall() {
        return this.isCall;
    }

    @Nullable
    public final SourceLocation nextSourceLocation() {
        int i;
        if (this.nextLocation >= this.locations.size() && (i = this.repeatOffset) >= 0) {
            this.nextLocation = i;
        }
        if (this.nextLocation >= this.locations.size()) {
            return null;
        }
        List<SourceLocationInfo> list = this.locations;
        int i2 = this.nextLocation;
        this.nextLocation = i2 + 1;
        SourceLocationInfo sourceLocationInfo = list.get(i2);
        Integer lineNumber = sourceLocationInfo.getLineNumber();
        int intValue = lineNumber != null ? lineNumber.intValue() : -1;
        Integer offset = sourceLocationInfo.getOffset();
        int intValue2 = offset != null ? offset.intValue() : -1;
        Integer length = sourceLocationInfo.getLength();
        return new SourceLocation(intValue, intValue2, length != null ? length.intValue() : -1, this.sourceFile, this.packageHash);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x007d  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final androidx.compose.p004ui.tooling.data.SourceLocation sourceLocation(int r9, @org.jetbrains.annotations.Nullable androidx.compose.p004ui.tooling.data.SourceInformationContext r10) {
        /*
            r8 = this;
            java.util.List<androidx.compose.ui.tooling.data.SourceLocationInfo> r0 = r8.locations
            int r0 = r0.size()
            if (r9 < r0) goto L22
            int r0 = r8.repeatOffset
            if (r0 < 0) goto L22
            java.util.List<androidx.compose.ui.tooling.data.SourceLocationInfo> r1 = r8.locations
            int r1 = r1.size()
            if (r0 >= r1) goto L22
            int r0 = r8.repeatOffset
            int r9 = r9 - r0
            java.util.List<androidx.compose.ui.tooling.data.SourceLocationInfo> r0 = r8.locations
            int r0 = r0.size()
            int r1 = r8.repeatOffset
            int r0 = r0 - r1
            int r9 = r9 % r0
            int r9 = r9 + r1
        L22:
            java.util.List<androidx.compose.ui.tooling.data.SourceLocationInfo> r0 = r8.locations
            int r0 = r0.size()
            r1 = 0
            if (r9 >= r0) goto L86
            java.util.List<androidx.compose.ui.tooling.data.SourceLocationInfo> r0 = r8.locations
            java.lang.Object r9 = r0.get(r9)
            androidx.compose.ui.tooling.data.SourceLocationInfo r9 = (androidx.compose.p004ui.tooling.data.SourceLocationInfo) r9
            androidx.compose.ui.tooling.data.SourceLocation r0 = new androidx.compose.ui.tooling.data.SourceLocation
            java.lang.Integer r2 = r9.getLineNumber()
            r3 = -1
            if (r2 == 0) goto L42
            int r2 = r2.intValue()
            r4 = r2
            goto L43
        L42:
            r4 = -1
        L43:
            java.lang.Integer r2 = r9.getOffset()
            if (r2 == 0) goto L4f
            int r2 = r2.intValue()
            r5 = r2
            goto L50
        L4f:
            r5 = -1
        L50:
            java.lang.Integer r9 = r9.getLength()
            if (r9 == 0) goto L5b
            int r9 = r9.intValue()
            goto L5c
        L5b:
            r9 = -1
        L5c:
            java.lang.String r2 = r8.sourceFile
            if (r2 != 0) goto L67
            if (r10 == 0) goto L65
            java.lang.String r6 = r10.sourceFile
            goto L68
        L65:
            r6 = r1
            goto L68
        L67:
            r6 = r2
        L68:
            if (r2 != 0) goto L6f
            if (r10 == 0) goto L75
            int r10 = r10.packageHash
            goto L71
        L6f:
            int r10 = r8.packageHash
        L71:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r10)
        L75:
            if (r1 == 0) goto L7d
            int r10 = r1.intValue()
            r7 = r10
            goto L7e
        L7d:
            r7 = -1
        L7e:
            r2 = r0
            r3 = r4
            r4 = r5
            r5 = r9
            r2.<init>(r3, r4, r5, r6, r7)
            return r0
        L86:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.p004ui.tooling.data.SourceInformationContext.sourceLocation(int, androidx.compose.ui.tooling.data.SourceInformationContext):androidx.compose.ui.tooling.data.SourceLocation");
    }
}
