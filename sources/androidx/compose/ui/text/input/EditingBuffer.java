package androidx.compose.ui.text.input;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.exifinterface.media.ExifInterface;
import com.alibaba.surgeon.bridge.ISurgeon;
import com.alibaba.surgeon.instrument.InstrumentAPI;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class EditingBuffer {
    private static transient /* synthetic */ ISurgeon $surgeonFlag = null;
    public static final int NOWHERE = -1;
    private int compositionEnd;
    private int compositionStart;

    @NotNull
    private final PartialGapBuffer gapBuffer;
    private int selectionEnd;
    private int selectionStart;

    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int $stable = 8;

    private EditingBuffer(AnnotatedString annotatedString, long j) {
        this.gapBuffer = new PartialGapBuffer(annotatedString.getText());
        this.selectionStart = TextRange.getMin-impl(j);
        this.selectionEnd = TextRange.getMax-impl(j);
        this.compositionStart = -1;
        this.compositionEnd = -1;
        int i = TextRange.getMin-impl(j);
        int i2 = TextRange.getMax-impl(j);
        if (i < 0 || i > annotatedString.length()) {
            throw new IndexOutOfBoundsException("start (" + i + ") offset is outside of text region " + annotatedString.length());
        }
        if (i2 < 0 || i2 > annotatedString.length()) {
            throw new IndexOutOfBoundsException("end (" + i2 + ") offset is outside of text region " + annotatedString.length());
        }
        if (i <= i2) {
            return;
        }
        throw new IllegalArgumentException("Do not set reversed range: " + i + " > " + i2);
    }

    public /* synthetic */ EditingBuffer(AnnotatedString annotatedString, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString, j);
    }

    public /* synthetic */ EditingBuffer(String str, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j);
    }

    private final void setSelectionEnd(int i) {
        ISurgeon iSurgeon = $surgeonFlag;
        if (InstrumentAPI.support(iSurgeon, "4")) {
            iSurgeon.surgeon$dispatch("4", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        if (i >= 0) {
            this.selectionEnd = i;
            return;
        }
        throw new IllegalArgumentException(("Cannot set selectionEnd to a negative value: " + i).toString());
    }

    private final void setSelectionStart(int i) {
        ISurgeon iSurgeon = $surgeonFlag;
        if (InstrumentAPI.support(iSurgeon, ExifInterface.GPS_MEASUREMENT_2D)) {
            iSurgeon.surgeon$dispatch(ExifInterface.GPS_MEASUREMENT_2D, new Object[]{this, Integer.valueOf(i)});
            return;
        }
        if (i >= 0) {
            this.selectionStart = i;
            return;
        }
        throw new IllegalArgumentException(("Cannot set selectionStart to a negative value: " + i).toString());
    }

    public final void cancelComposition$ui_text_release() {
        ISurgeon iSurgeon = $surgeonFlag;
        if (InstrumentAPI.support(iSurgeon, "18")) {
            iSurgeon.surgeon$dispatch("18", new Object[]{this});
            return;
        }
        replace$ui_text_release(this.compositionStart, this.compositionEnd, "");
        this.compositionStart = -1;
        this.compositionEnd = -1;
    }

    public final void commitComposition$ui_text_release() {
        ISurgeon iSurgeon = $surgeonFlag;
        if (InstrumentAPI.support(iSurgeon, "19")) {
            iSurgeon.surgeon$dispatch("19", new Object[]{this});
        } else {
            this.compositionStart = -1;
            this.compositionEnd = -1;
        }
    }

    public final void delete$ui_text_release(int i, int i2) {
        if (i < 0 || i2 < 0 || i2 < i) {
            return;
        }
        long TextRange = TextRangeKt.TextRange(i, i2);
        this.gapBuffer.replace(i, i2, "");
        long j = EditingBufferKt.updateRangeAfterDelete-pWDy79M(TextRangeKt.TextRange(this.selectionStart, this.selectionEnd), TextRange);
        setSelectionStart(TextRange.getMin-impl(j));
        setSelectionEnd(TextRange.getMax-impl(j));
        if (hasComposition$ui_text_release()) {
            long j2 = EditingBufferKt.updateRangeAfterDelete-pWDy79M(TextRangeKt.TextRange(this.compositionStart, this.compositionEnd), TextRange);
            if (TextRange.getCollapsed-impl(j2)) {
                commitComposition$ui_text_release();
            } else {
                this.compositionStart = TextRange.getMin-impl(j2);
                this.compositionEnd = TextRange.getMax-impl(j2);
            }
        }
    }

    public final char get$ui_text_release(int i) {
        ISurgeon iSurgeon = $surgeonFlag;
        return InstrumentAPI.support(iSurgeon, "12") ? ((Character) iSurgeon.surgeon$dispatch("12", new Object[]{this, Integer.valueOf(i)})).charValue() : this.gapBuffer.get(i);
    }

    @Nullable
    /* renamed from: getComposition-MzsxiRA$ui_text_release, reason: not valid java name */
    public final TextRange m1942getCompositionMzsxiRA$ui_text_release() {
        ISurgeon iSurgeon = $surgeonFlag;
        if (InstrumentAPI.support(iSurgeon, "8")) {
            return (TextRange) iSurgeon.surgeon$dispatch("8", new Object[]{this});
        }
        if (hasComposition$ui_text_release()) {
            return TextRange.box-impl(TextRangeKt.TextRange(this.compositionStart, this.compositionEnd));
        }
        return null;
    }

    public final int getCompositionEnd$ui_text_release() {
        ISurgeon iSurgeon = $surgeonFlag;
        return InstrumentAPI.support(iSurgeon, "6") ? ((Integer) iSurgeon.surgeon$dispatch("6", new Object[]{this})).intValue() : this.compositionEnd;
    }

    public final int getCompositionStart$ui_text_release() {
        ISurgeon iSurgeon = $surgeonFlag;
        return InstrumentAPI.support(iSurgeon, "5") ? ((Integer) iSurgeon.surgeon$dispatch("5", new Object[]{this})).intValue() : this.compositionStart;
    }

    public final int getCursor$ui_text_release() {
        ISurgeon iSurgeon = $surgeonFlag;
        if (InstrumentAPI.support(iSurgeon, "10")) {
            return ((Integer) iSurgeon.surgeon$dispatch("10", new Object[]{this})).intValue();
        }
        int i = this.selectionStart;
        int i2 = this.selectionEnd;
        if (i == i2) {
            return i2;
        }
        return -1;
    }

    public final int getLength$ui_text_release() {
        ISurgeon iSurgeon = $surgeonFlag;
        return InstrumentAPI.support(iSurgeon, "13") ? ((Integer) iSurgeon.surgeon$dispatch("13", new Object[]{this})).intValue() : this.gapBuffer.getLength();
    }

    /* renamed from: getSelection-d9O1mEE$ui_text_release, reason: not valid java name */
    public final long m1943getSelectiond9O1mEE$ui_text_release() {
        ISurgeon iSurgeon = $surgeonFlag;
        return InstrumentAPI.support(iSurgeon, "9") ? ((Long) iSurgeon.surgeon$dispatch("9", new Object[]{this})).longValue() : TextRangeKt.TextRange(this.selectionStart, this.selectionEnd);
    }

    public final int getSelectionEnd$ui_text_release() {
        ISurgeon iSurgeon = $surgeonFlag;
        return InstrumentAPI.support(iSurgeon, ExifInterface.GPS_MEASUREMENT_3D) ? ((Integer) iSurgeon.surgeon$dispatch(ExifInterface.GPS_MEASUREMENT_3D, new Object[]{this})).intValue() : this.selectionEnd;
    }

    public final int getSelectionStart$ui_text_release() {
        ISurgeon iSurgeon = $surgeonFlag;
        return InstrumentAPI.support(iSurgeon, "1") ? ((Integer) iSurgeon.surgeon$dispatch("1", new Object[]{this})).intValue() : this.selectionStart;
    }

    public final boolean hasComposition$ui_text_release() {
        ISurgeon iSurgeon = $surgeonFlag;
        return InstrumentAPI.support(iSurgeon, "7") ? ((Boolean) iSurgeon.surgeon$dispatch("7", new Object[]{this})).booleanValue() : this.compositionStart != -1;
    }

    public final void replace$ui_text_release(int i, int i2, @NotNull AnnotatedString annotatedString) {
        ISurgeon iSurgeon = $surgeonFlag;
        if (InstrumentAPI.support(iSurgeon, "14")) {
            iSurgeon.surgeon$dispatch("14", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), annotatedString});
        } else {
            Intrinsics.checkNotNullParameter(annotatedString, "text");
            replace$ui_text_release(i, i2, annotatedString.getText());
        }
    }

    public final void setComposition$ui_text_release(int i, int i2) {
        ISurgeon iSurgeon = $surgeonFlag;
        if (InstrumentAPI.support(iSurgeon, "17")) {
            iSurgeon.surgeon$dispatch("17", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        if (i < 0 || i > this.gapBuffer.getLength()) {
            throw new IndexOutOfBoundsException("start (" + i + ") offset is outside of text region " + this.gapBuffer.getLength());
        }
        if (i2 < 0 || i2 > this.gapBuffer.getLength()) {
            throw new IndexOutOfBoundsException("end (" + i2 + ") offset is outside of text region " + this.gapBuffer.getLength());
        }
        if (i < i2) {
            this.compositionStart = i;
            this.compositionEnd = i2;
            return;
        }
        throw new IllegalArgumentException("Do not set reversed or empty range: " + i + " > " + i2);
    }

    public final void setCursor$ui_text_release(int i) {
        ISurgeon iSurgeon = $surgeonFlag;
        if (InstrumentAPI.support(iSurgeon, "11")) {
            iSurgeon.surgeon$dispatch("11", new Object[]{this, Integer.valueOf(i)});
        } else {
            setSelection$ui_text_release(i, i);
        }
    }

    public final void setSelection$ui_text_release(int i, int i2) {
        ISurgeon iSurgeon = $surgeonFlag;
        if (InstrumentAPI.support(iSurgeon, "16")) {
            iSurgeon.surgeon$dispatch("16", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        if (i < 0 || i > this.gapBuffer.getLength()) {
            throw new IndexOutOfBoundsException("start (" + i + ") offset is outside of text region " + this.gapBuffer.getLength());
        }
        if (i2 < 0 || i2 > this.gapBuffer.getLength()) {
            throw new IndexOutOfBoundsException("end (" + i2 + ") offset is outside of text region " + this.gapBuffer.getLength());
        }
        if (i <= i2) {
            setSelectionStart(i);
            setSelectionEnd(i2);
            return;
        }
        throw new IllegalArgumentException("Do not set reversed range: " + i + " > " + i2);
    }

    @NotNull
    public final AnnotatedString toAnnotatedString$ui_text_release() {
        ISurgeon iSurgeon = $surgeonFlag;
        return InstrumentAPI.support(iSurgeon, "21") ? (AnnotatedString) iSurgeon.surgeon$dispatch("21", new Object[]{this}) : new AnnotatedString(toString(), (List) null, (List) null, 6, (DefaultConstructorMarker) null);
    }

    @NotNull
    public String toString() {
        ISurgeon iSurgeon = $surgeonFlag;
        return InstrumentAPI.support(iSurgeon, "20") ? (String) iSurgeon.surgeon$dispatch("20", new Object[]{this}) : this.gapBuffer.toString();
    }

    public final void replace$ui_text_release(int i, int i2, @NotNull String str) {
        ISurgeon iSurgeon = $surgeonFlag;
        if (InstrumentAPI.support(iSurgeon, "15")) {
            iSurgeon.surgeon$dispatch("15", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), str});
            return;
        }
        Intrinsics.checkNotNullParameter(str, "text");
        if (i < 0 || i > this.gapBuffer.getLength()) {
            throw new IndexOutOfBoundsException("start (" + i + ") offset is outside of text region " + this.gapBuffer.getLength());
        }
        if (i2 < 0 || i2 > this.gapBuffer.getLength()) {
            throw new IndexOutOfBoundsException("end (" + i2 + ") offset is outside of text region " + this.gapBuffer.getLength());
        }
        if (i <= i2) {
            this.gapBuffer.replace(i, i2, str);
            setSelectionStart(str.length() + i);
            setSelectionEnd(i + str.length());
            this.compositionStart = -1;
            this.compositionEnd = -1;
            return;
        }
        throw new IllegalArgumentException("Do not set reversed range: " + i + " > " + i2);
    }

    private EditingBuffer(String str, long j) {
        this(new AnnotatedString(str, (List) null, (List) null, 6, (DefaultConstructorMarker) null), j, (DefaultConstructorMarker) null);
    }
}
