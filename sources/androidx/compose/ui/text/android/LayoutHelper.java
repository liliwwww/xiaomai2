package androidx.compose.ui.text.android;

import android.text.Layout;
import androidx.annotation.IntRange;
import androidx.compose.runtime.internal.StabilityInferred;
import java.text.Bidi;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
@InternalPlatformTextApi
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class LayoutHelper {
    public static final int $stable = 8;

    @NotNull
    private final boolean[] bidiProcessedParagraphs;

    @NotNull
    private final Layout layout;

    @NotNull
    private final List<Bidi> paragraphBidi;
    private final int paragraphCount;

    @NotNull
    private final List<Integer> paragraphEnds;

    @Nullable
    private char[] tmpBuffer;

    /* compiled from: Taobao */
    private static final class BidiRun {
        private final int end;
        private final boolean isRtl;
        private final int start;

        public BidiRun(int i, int i2, boolean z) {
            this.start = i;
            this.end = i2;
            this.isRtl = z;
        }

        public static /* synthetic */ BidiRun copy$default(BidiRun bidiRun, int i, int i2, boolean z, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = bidiRun.start;
            }
            if ((i3 & 2) != 0) {
                i2 = bidiRun.end;
            }
            if ((i3 & 4) != 0) {
                z = bidiRun.isRtl;
            }
            return bidiRun.copy(i, i2, z);
        }

        public final int component1() {
            return this.start;
        }

        public final int component2() {
            return this.end;
        }

        public final boolean component3() {
            return this.isRtl;
        }

        @NotNull
        public final BidiRun copy(int i, int i2, boolean z) {
            return new BidiRun(i, i2, z);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof BidiRun)) {
                return false;
            }
            BidiRun bidiRun = (BidiRun) obj;
            return this.start == bidiRun.start && this.end == bidiRun.end && this.isRtl == bidiRun.isRtl;
        }

        public final int getEnd() {
            return this.end;
        }

        public final int getStart() {
            return this.start;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int i = ((this.start * 31) + this.end) * 31;
            boolean z = this.isRtl;
            int i2 = z;
            if (z != 0) {
                i2 = 1;
            }
            return i + i2;
        }

        public final boolean isRtl() {
            return this.isRtl;
        }

        @NotNull
        public String toString() {
            return "BidiRun(start=" + this.start + ", end=" + this.end + ", isRtl=" + this.isRtl + ')';
        }
    }

    public LayoutHelper(@NotNull Layout layout) {
        Intrinsics.checkNotNullParameter(layout, "layout");
        this.layout = layout;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        do {
            CharSequence text = this.layout.getText();
            Intrinsics.checkNotNullExpressionValue(text, "layout.text");
            int indexOf$default = StringsKt.indexOf$default(text, '\n', i, false, 4, (Object) null);
            i = indexOf$default < 0 ? this.layout.getText().length() : indexOf$default + 1;
            arrayList.add(Integer.valueOf(i));
        } while (i < this.layout.getText().length());
        this.paragraphEnds = arrayList;
        int size = arrayList.size();
        ArrayList arrayList2 = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            arrayList2.add(null);
        }
        this.paragraphBidi = arrayList2;
        this.bidiProcessedParagraphs = new boolean[this.paragraphEnds.size()];
        this.paragraphCount = this.paragraphEnds.size();
    }

    private final float getDownstreamHorizontal(int i, boolean z) {
        return z ? this.layout.getPrimaryHorizontal(i) : this.layout.getSecondaryHorizontal(i);
    }

    public static /* synthetic */ int getParagraphForOffset$default(LayoutHelper layoutHelper, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return layoutHelper.getParagraphForOffset(i, z);
    }

    private final int lineEndToVisibleEnd(int i) {
        while (i > 0 && isLineEndSpace(this.layout.getText().charAt(i - 1))) {
            i--;
        }
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x005d, code lost:
    
        if (r0.getRunCount() == 1) goto L19;
     */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.text.Bidi analyzeBidi(int r12) {
        /*
            r11 = this;
            boolean[] r0 = r11.bidiProcessedParagraphs
            boolean r0 = r0[r12]
            if (r0 == 0) goto Lf
            java.util.List<java.text.Bidi> r0 = r11.paragraphBidi
            java.lang.Object r12 = r0.get(r12)
            java.text.Bidi r12 = (java.text.Bidi) r12
            return r12
        Lf:
            r0 = 0
            if (r12 != 0) goto L14
            r1 = 0
            goto L22
        L14:
            java.util.List<java.lang.Integer> r1 = r11.paragraphEnds
            int r2 = r12 + (-1)
            java.lang.Object r1 = r1.get(r2)
            java.lang.Number r1 = (java.lang.Number) r1
            int r1 = r1.intValue()
        L22:
            java.util.List<java.lang.Integer> r2 = r11.paragraphEnds
            java.lang.Object r2 = r2.get(r12)
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
            int r8 = r2 - r1
            char[] r3 = r11.tmpBuffer
            if (r3 == 0) goto L37
            int r4 = r3.length
            if (r4 >= r8) goto L39
        L37:
            char[] r3 = new char[r8]
        L39:
            r10 = r3
            android.text.Layout r3 = r11.layout
            java.lang.CharSequence r3 = r3.getText()
            android.text.TextUtils.getChars(r3, r1, r2, r10, r0)
            boolean r0 = java.text.Bidi.requiresBidi(r10, r0, r8)
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L5f
            boolean r9 = r11.isRtlParagraph(r12)
            java.text.Bidi r0 = new java.text.Bidi
            r5 = 0
            r6 = 0
            r7 = 0
            r3 = r0
            r4 = r10
            r3.<init>(r4, r5, r6, r7, r8, r9)
            int r3 = r0.getRunCount()
            if (r3 != r2) goto L60
        L5f:
            r0 = r1
        L60:
            java.util.List<java.text.Bidi> r3 = r11.paragraphBidi
            r3.set(r12, r0)
            boolean[] r3 = r11.bidiProcessedParagraphs
            r3[r12] = r2
            if (r0 == 0) goto L72
            char[] r12 = r11.tmpBuffer
            if (r10 != r12) goto L71
            r10 = r1
            goto L72
        L71:
            r10 = r12
        L72:
            r11.tmpBuffer = r10
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.android.LayoutHelper.analyzeBidi(int):java.text.Bidi");
    }

    public final float getHorizontalPosition(int i, boolean z, boolean z2) {
        int i2 = i;
        if (!z2) {
            return getDownstreamHorizontal(i, z);
        }
        int lineForOffset = LayoutCompatKt.getLineForOffset(this.layout, i2, z2);
        int lineStart = this.layout.getLineStart(lineForOffset);
        int lineEnd = this.layout.getLineEnd(lineForOffset);
        if (i2 != lineStart && i2 != lineEnd) {
            return getDownstreamHorizontal(i, z);
        }
        if (i2 == 0 || i2 == this.layout.getText().length()) {
            return getDownstreamHorizontal(i, z);
        }
        int paragraphForOffset = getParagraphForOffset(i2, z2);
        boolean isRtlParagraph = isRtlParagraph(paragraphForOffset);
        int lineEndToVisibleEnd = lineEndToVisibleEnd(lineEnd);
        int paragraphStart = getParagraphStart(paragraphForOffset);
        int i3 = lineStart - paragraphStart;
        int i4 = lineEndToVisibleEnd - paragraphStart;
        Bidi analyzeBidi = analyzeBidi(paragraphForOffset);
        Bidi createLineBidi = analyzeBidi != null ? analyzeBidi.createLineBidi(i3, i4) : null;
        boolean z3 = false;
        if (createLineBidi == null || createLineBidi.getRunCount() == 1) {
            boolean isRtlCharAt = this.layout.isRtlCharAt(lineStart);
            if (z || isRtlParagraph == isRtlCharAt) {
                isRtlParagraph = !isRtlParagraph;
            }
            if (i2 == lineStart) {
                z3 = isRtlParagraph;
            } else if (!isRtlParagraph) {
                z3 = true;
            }
            Layout layout = this.layout;
            return z3 ? layout.getLineLeft(lineForOffset) : layout.getLineRight(lineForOffset);
        }
        int runCount = createLineBidi.getRunCount();
        BidiRun[] bidiRunArr = new BidiRun[runCount];
        for (int i5 = 0; i5 < runCount; i5++) {
            bidiRunArr[i5] = new BidiRun(createLineBidi.getRunStart(i5) + lineStart, createLineBidi.getRunLimit(i5) + lineStart, createLineBidi.getRunLevel(i5) % 2 == 1);
        }
        int runCount2 = createLineBidi.getRunCount();
        byte[] bArr = new byte[runCount2];
        for (int i6 = 0; i6 < runCount2; i6++) {
            bArr[i6] = (byte) createLineBidi.getRunLevel(i6);
        }
        Bidi.reorderVisually(bArr, 0, bidiRunArr, 0, runCount);
        int i7 = -1;
        if (i2 == lineStart) {
            int i8 = 0;
            while (true) {
                if (i8 >= runCount) {
                    break;
                }
                if (bidiRunArr[i8].getStart() == i2) {
                    i7 = i8;
                    break;
                }
                i8++;
            }
            BidiRun bidiRun = bidiRunArr[i7];
            if (z || isRtlParagraph == bidiRun.isRtl()) {
                isRtlParagraph = !isRtlParagraph;
            }
            return (i7 == 0 && isRtlParagraph) ? this.layout.getLineLeft(lineForOffset) : (i7 != ArraysKt.getLastIndex(bidiRunArr) || isRtlParagraph) ? isRtlParagraph ? this.layout.getPrimaryHorizontal(bidiRunArr[i7 - 1].getStart()) : this.layout.getPrimaryHorizontal(bidiRunArr[i7 + 1].getStart()) : this.layout.getLineRight(lineForOffset);
        }
        if (i2 > lineEndToVisibleEnd) {
            i2 = lineEndToVisibleEnd(i);
        }
        int i9 = 0;
        while (true) {
            if (i9 >= runCount) {
                break;
            }
            if (bidiRunArr[i9].getEnd() == i2) {
                i7 = i9;
                break;
            }
            i9++;
        }
        BidiRun bidiRun2 = bidiRunArr[i7];
        if (!z && isRtlParagraph != bidiRun2.isRtl()) {
            isRtlParagraph = !isRtlParagraph;
        }
        return (i7 == 0 && isRtlParagraph) ? this.layout.getLineLeft(lineForOffset) : (i7 != ArraysKt.getLastIndex(bidiRunArr) || isRtlParagraph) ? isRtlParagraph ? this.layout.getPrimaryHorizontal(bidiRunArr[i7 - 1].getEnd()) : this.layout.getPrimaryHorizontal(bidiRunArr[i7 + 1].getEnd()) : this.layout.getLineRight(lineForOffset);
    }

    @NotNull
    public final Layout getLayout() {
        return this.layout;
    }

    public final int getParagraphCount() {
        return this.paragraphCount;
    }

    public final int getParagraphEnd(@IntRange(from = 0) int i) {
        return this.paragraphEnds.get(i).intValue();
    }

    public final int getParagraphForOffset(@IntRange(from = 0) int i, boolean z) {
        int binarySearch$default = CollectionsKt.binarySearch$default(this.paragraphEnds, Integer.valueOf(i), 0, 0, 6, (Object) null);
        int i2 = binarySearch$default < 0 ? -(binarySearch$default + 1) : binarySearch$default + 1;
        if (z && i2 > 0) {
            int i3 = i2 - 1;
            if (i == this.paragraphEnds.get(i3).intValue()) {
                return i3;
            }
        }
        return i2;
    }

    public final int getParagraphStart(@IntRange(from = 0) int i) {
        if (i == 0) {
            return 0;
        }
        return this.paragraphEnds.get(i - 1).intValue();
    }

    public final boolean isLineEndSpace(char c) {
        if (c == ' ' || c == '\n' || c == 5760) {
            return true;
        }
        return ((8192 <= c && c < 8203) && c != 8199) || c == 8287 || c == 12288;
    }

    public final boolean isRtlParagraph(@IntRange(from = 0) int i) {
        return this.layout.getParagraphDirection(this.layout.getLineForOffset(getParagraphStart(i))) == -1;
    }
}
