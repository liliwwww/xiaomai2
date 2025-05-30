package androidx.compose.ui.tooling;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.tooling.data.SourceLocation;
import androidx.compose.ui.unit.IntRect;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class ViewInfo {
    public static final int $stable = 8;

    @NotNull
    private final IntRect bounds;

    @NotNull
    private final List<ViewInfo> children;

    @NotNull
    private final String fileName;
    private final int lineNumber;

    @Nullable
    private final SourceLocation location;

    public ViewInfo(@NotNull String str, int i, @NotNull IntRect intRect, @Nullable SourceLocation sourceLocation, @NotNull List<ViewInfo> list) {
        Intrinsics.checkNotNullParameter(str, "fileName");
        Intrinsics.checkNotNullParameter(intRect, "bounds");
        Intrinsics.checkNotNullParameter(list, "children");
        this.fileName = str;
        this.lineNumber = i;
        this.bounds = intRect;
        this.location = sourceLocation;
        this.children = list;
    }

    public static /* synthetic */ ViewInfo copy$default(ViewInfo viewInfo, String str, int i, IntRect intRect, SourceLocation sourceLocation, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = viewInfo.fileName;
        }
        if ((i2 & 2) != 0) {
            i = viewInfo.lineNumber;
        }
        int i3 = i;
        if ((i2 & 4) != 0) {
            intRect = viewInfo.bounds;
        }
        IntRect intRect2 = intRect;
        if ((i2 & 8) != 0) {
            sourceLocation = viewInfo.location;
        }
        SourceLocation sourceLocation2 = sourceLocation;
        if ((i2 & 16) != 0) {
            list = viewInfo.children;
        }
        return viewInfo.copy(str, i3, intRect2, sourceLocation2, list);
    }

    @NotNull
    public final List<ViewInfo> allChildren() {
        List<ViewInfo> list = this.children;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            CollectionsKt.addAll(arrayList, ((ViewInfo) it.next()).allChildren());
        }
        return CollectionsKt.plus(list, arrayList);
    }

    @NotNull
    public final String component1() {
        return this.fileName;
    }

    public final int component2() {
        return this.lineNumber;
    }

    @NotNull
    public final IntRect component3() {
        return this.bounds;
    }

    @Nullable
    public final SourceLocation component4() {
        return this.location;
    }

    @NotNull
    public final List<ViewInfo> component5() {
        return this.children;
    }

    @NotNull
    public final ViewInfo copy(@NotNull String str, int i, @NotNull IntRect intRect, @Nullable SourceLocation sourceLocation, @NotNull List<ViewInfo> list) {
        Intrinsics.checkNotNullParameter(str, "fileName");
        Intrinsics.checkNotNullParameter(intRect, "bounds");
        Intrinsics.checkNotNullParameter(list, "children");
        return new ViewInfo(str, i, intRect, sourceLocation, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ViewInfo)) {
            return false;
        }
        ViewInfo viewInfo = (ViewInfo) obj;
        return Intrinsics.areEqual(this.fileName, viewInfo.fileName) && this.lineNumber == viewInfo.lineNumber && Intrinsics.areEqual(this.bounds, viewInfo.bounds) && Intrinsics.areEqual(this.location, viewInfo.location) && Intrinsics.areEqual(this.children, viewInfo.children);
    }

    @NotNull
    public final IntRect getBounds() {
        return this.bounds;
    }

    @NotNull
    public final List<ViewInfo> getChildren() {
        return this.children;
    }

    @NotNull
    public final String getFileName() {
        return this.fileName;
    }

    public final int getLineNumber() {
        return this.lineNumber;
    }

    @Nullable
    public final SourceLocation getLocation() {
        return this.location;
    }

    public final boolean hasBounds() {
        return (this.bounds.getBottom() == 0 || this.bounds.getRight() == 0) ? false : true;
    }

    public int hashCode() {
        int hashCode = ((((this.fileName.hashCode() * 31) + this.lineNumber) * 31) + this.bounds.hashCode()) * 31;
        SourceLocation sourceLocation = this.location;
        return ((hashCode + (sourceLocation == null ? 0 : sourceLocation.hashCode())) * 31) + this.children.hashCode();
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x005d, code lost:
    
        if (r1 == null) goto L6;
     */
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String toString() {
        /*
            r4 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 40
            r0.append(r1)
            java.lang.String r2 = r4.fileName
            r0.append(r2)
            r2 = 58
            r0.append(r2)
            int r2 = r4.lineNumber
            r0.append(r2)
            java.lang.String r2 = ",\n            |bounds=(top="
            r0.append(r2)
            androidx.compose.ui.unit.IntRect r2 = r4.bounds
            int r2 = r2.getTop()
            r0.append(r2)
            java.lang.String r2 = ", left="
            r0.append(r2)
            androidx.compose.ui.unit.IntRect r2 = r4.bounds
            int r2 = r2.getLeft()
            r0.append(r2)
            java.lang.String r2 = ",\n            |location="
            r0.append(r2)
            androidx.compose.ui.tooling.data.SourceLocation r2 = r4.location
            if (r2 == 0) goto L5f
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r1)
            int r1 = r2.getOffset()
            r3.append(r1)
            r1 = 76
            r3.append(r1)
            int r1 = r2.getLength()
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            if (r1 != 0) goto L61
        L5f:
            java.lang.String r1 = "<none>"
        L61:
            r0.append(r1)
            java.lang.String r1 = "\n            |bottom="
            r0.append(r1)
            androidx.compose.ui.unit.IntRect r1 = r4.bounds
            int r1 = r1.getBottom()
            r0.append(r1)
            java.lang.String r1 = ", right="
            r0.append(r1)
            androidx.compose.ui.unit.IntRect r1 = r4.bounds
            int r1 = r1.getRight()
            r0.append(r1)
            java.lang.String r1 = "),\n            |childrenCount="
            r0.append(r1)
            java.util.List<androidx.compose.ui.tooling.ViewInfo> r1 = r4.children
            int r1 = r1.size()
            r0.append(r1)
            r1 = 41
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r1 = 1
            r2 = 0
            java.lang.String r0 = kotlin.text.StringsKt.trimMargin$default(r0, r2, r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.tooling.ViewInfo.toString():java.lang.String");
    }
}
