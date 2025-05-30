package androidx.compose.p004ui.text.input;

import androidx.compose.p004ui.text.InternalTextApi;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
@InternalTextApi
/* loaded from: classes.dex */
public final class PartialGapBuffer {
    public static final int BUF_SIZE = 255;
    public static final int NOWHERE = -1;
    public static final int SURROUNDING_SIZE = 64;
    private int bufEnd;
    private int bufStart;

    @Nullable
    private GapBuffer buffer;

    @NotNull
    private String text;

    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public PartialGapBuffer(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.text = str;
        this.bufStart = -1;
        this.bufEnd = -1;
    }

    public final char get(int i) {
        GapBuffer gapBuffer = this.buffer;
        if (gapBuffer == null) {
            return this.text.charAt(i);
        }
        if (i < this.bufStart) {
            return this.text.charAt(i);
        }
        int length = gapBuffer.length();
        int i2 = this.bufStart;
        return i < length + i2 ? gapBuffer.get(i - i2) : this.text.charAt(i - ((length - this.bufEnd) + i2));
    }

    public final int getLength() {
        GapBuffer gapBuffer = this.buffer;
        return gapBuffer == null ? this.text.length() : (this.text.length() - (this.bufEnd - this.bufStart)) + gapBuffer.length();
    }

    @NotNull
    public final String getText() {
        return this.text;
    }

    public final void replace(int i, int i2, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        if (!(i <= i2)) {
            throw new IllegalArgumentException(("start index must be less than or equal to end index: " + i + " > " + i2).toString());
        }
        if (!(i >= 0)) {
            throw new IllegalArgumentException(("start must be non-negative, but was " + i).toString());
        }
        GapBuffer gapBuffer = this.buffer;
        if (gapBuffer != null) {
            int i3 = this.bufStart;
            int i4 = i - i3;
            int i5 = i2 - i3;
            if (i4 >= 0 && i5 <= gapBuffer.length()) {
                gapBuffer.replace(i4, i5, str);
                return;
            }
            this.text = toString();
            this.buffer = null;
            this.bufStart = -1;
            this.bufEnd = -1;
            replace(i, i2, str);
            return;
        }
        int max = Math.max(255, str.length() + 128);
        char[] cArr = new char[max];
        int min = Math.min(i, 64);
        int min2 = Math.min(this.text.length() - i2, 64);
        int i6 = i - min;
        GapBuffer_jvmKt.toCharArray(this.text, cArr, 0, i6, i);
        int i7 = max - min2;
        int i8 = min2 + i2;
        GapBuffer_jvmKt.toCharArray(this.text, cArr, i7, i2, i8);
        GapBufferKt.toCharArray(str, cArr, min);
        this.buffer = new GapBuffer(cArr, min + str.length(), i7);
        this.bufStart = i6;
        this.bufEnd = i8;
    }

    public final void setText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.text = str;
    }

    @NotNull
    public String toString() {
        GapBuffer gapBuffer = this.buffer;
        if (gapBuffer == null) {
            return this.text;
        }
        StringBuilder sb = new StringBuilder();
        sb.append((CharSequence) this.text, 0, this.bufStart);
        gapBuffer.append(sb);
        String str = this.text;
        sb.append((CharSequence) str, this.bufEnd, str.length());
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "sb.toString()");
        return sb2;
    }
}
