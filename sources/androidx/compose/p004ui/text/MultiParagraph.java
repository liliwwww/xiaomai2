package androidx.compose.p004ui.text;

import android.taobao.windvane.monitor.WVPackageMonitorInterface;
import androidx.compose.p004ui.geometry.Offset;
import androidx.compose.p004ui.geometry.Rect;
import androidx.compose.p004ui.graphics.AndroidPath_androidKt;
import androidx.compose.p004ui.graphics.Brush;
import androidx.compose.p004ui.graphics.Canvas;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.graphics.Path;
import androidx.compose.p004ui.graphics.Shadow;
import androidx.compose.p004ui.graphics.drawscope.DrawStyle;
import androidx.compose.p004ui.text.AnnotatedString;
import androidx.compose.p004ui.text.font.DelegatingFontLoaderForDeprecatedUsage_androidKt;
import androidx.compose.p004ui.text.font.Font;
import androidx.compose.p004ui.text.font.FontFamily;
import androidx.compose.p004ui.text.platform.AndroidMultiParagraphDrawKt;
import androidx.compose.p004ui.text.style.ResolvedTextDirection;
import androidx.compose.p004ui.text.style.TextDecoration;
import androidx.compose.p004ui.unit.Constraints;
import androidx.compose.p004ui.unit.ConstraintsKt;
import androidx.compose.p004ui.unit.Density;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.exifinterface.media.ExifInterface;
import com.alibaba.surgeon.bridge.ISurgeon;
import com.alibaba.surgeon.instrument.InstrumentAPI;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.zn3;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: classes.dex */
public final class MultiParagraph {
    public static final int $stable = 8;
    private static transient /* synthetic */ ISurgeon $surgeonFlag;
    private final boolean didExceedMaxLines;
    private final float height;

    @NotNull
    private final MultiParagraphIntrinsics intrinsics;
    private final int lineCount;
    private final int maxLines;

    @NotNull
    private final List<ParagraphInfo> paragraphInfoList;

    @NotNull
    private final List<Rect> placeholderRects;
    private final float width;

    public /* synthetic */ MultiParagraph(AnnotatedString annotatedString, TextStyle textStyle, long j, Density density, FontFamily.Resolver resolver, List list, int i, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString, textStyle, j, density, resolver, (List<AnnotatedString.Range<Placeholder>>) list, i, z);
    }

    private MultiParagraph(MultiParagraphIntrinsics multiParagraphIntrinsics, long j, int i, boolean z) {
        boolean z2;
        this.intrinsics = multiParagraphIntrinsics;
        this.maxLines = i;
        int i2 = 0;
        if (!(Constraints.m5186getMinWidthimpl(j) == 0 && Constraints.m5185getMinHeightimpl(j) == 0)) {
            throw new IllegalArgumentException("Setting Constraints.minWidth and Constraints.minHeight is not supported, these should be the default zero values instead.".toString());
        }
        ArrayList arrayList = new ArrayList();
        List<ParagraphIntrinsicInfo> infoList$ui_text_release = multiParagraphIntrinsics.getInfoList$ui_text_release();
        int size = infoList$ui_text_release.size();
        int i3 = 0;
        int i4 = 0;
        float f = 0.0f;
        while (i3 < size) {
            ParagraphIntrinsicInfo paragraphIntrinsicInfo = infoList$ui_text_release.get(i3);
            Paragraph m4644Paragraph_EkL_Y = ParagraphKt.m4644Paragraph_EkL_Y(paragraphIntrinsicInfo.getIntrinsics(), ConstraintsKt.Constraints$default(0, Constraints.m5184getMaxWidthimpl(j), 0, Constraints.m5179getHasBoundedHeightimpl(j) ? RangesKt.coerceAtLeast(Constraints.m5183getMaxHeightimpl(j) - ParagraphKt.ceilToInt(f), i2) : Constraints.m5183getMaxHeightimpl(j), 5, null), this.maxLines - i4, z);
            float height = f + m4644Paragraph_EkL_Y.getHeight();
            int lineCount = i4 + m4644Paragraph_EkL_Y.getLineCount();
            arrayList.add(new ParagraphInfo(m4644Paragraph_EkL_Y, paragraphIntrinsicInfo.getStartIndex(), paragraphIntrinsicInfo.getEndIndex(), i4, lineCount, f, height));
            if (m4644Paragraph_EkL_Y.getDidExceedMaxLines() || (lineCount == this.maxLines && i3 != CollectionsKt.getLastIndex(this.intrinsics.getInfoList$ui_text_release()))) {
                i4 = lineCount;
                f = height;
                z2 = true;
                break;
            } else {
                i3++;
                i4 = lineCount;
                f = height;
                i2 = 0;
            }
        }
        z2 = false;
        this.height = f;
        this.lineCount = i4;
        this.didExceedMaxLines = z2;
        this.paragraphInfoList = arrayList;
        this.width = Constraints.m5184getMaxWidthimpl(j);
        List<Rect> arrayList2 = new ArrayList<>(arrayList.size());
        int size2 = arrayList.size();
        for (int i5 = 0; i5 < size2; i5++) {
            ParagraphInfo paragraphInfo = (ParagraphInfo) arrayList.get(i5);
            List<Rect> placeholderRects = paragraphInfo.getParagraph().getPlaceholderRects();
            ArrayList arrayList3 = new ArrayList(placeholderRects.size());
            int size3 = placeholderRects.size();
            for (int i6 = 0; i6 < size3; i6++) {
                Rect rect = placeholderRects.get(i6);
                arrayList3.add(rect != null ? paragraphInfo.toGlobal(rect) : null);
            }
            CollectionsKt.addAll(arrayList2, arrayList3);
        }
        if (arrayList2.size() < this.intrinsics.getPlaceholders().size()) {
            int size4 = this.intrinsics.getPlaceholders().size() - arrayList2.size();
            ArrayList arrayList4 = new ArrayList(size4);
            for (int i7 = 0; i7 < size4; i7++) {
                arrayList4.add(null);
            }
            arrayList2 = CollectionsKt.plus(arrayList2, arrayList4);
        }
        this.placeholderRects = arrayList2;
    }

    public /* synthetic */ MultiParagraph(MultiParagraphIntrinsics multiParagraphIntrinsics, long j, int i, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(multiParagraphIntrinsics, j, i, z);
    }

    private final AnnotatedString getAnnotatedString() {
        ISurgeon iSurgeon = $surgeonFlag;
        return InstrumentAPI.support(iSurgeon, ExifInterface.GPS_MEASUREMENT_3D) ? (AnnotatedString) iSurgeon.surgeon$dispatch(ExifInterface.GPS_MEASUREMENT_3D, new Object[]{this}) : this.intrinsics.getAnnotatedString();
    }

    public static /* synthetic */ int getLineEnd$default(MultiParagraph multiParagraph, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return multiParagraph.getLineEnd(i, z);
    }

    /* renamed from: paint-RPmYEkk$default, reason: not valid java name */
    public static /* synthetic */ void m4632paintRPmYEkk$default(MultiParagraph multiParagraph, Canvas canvas, long j, Shadow shadow, TextDecoration textDecoration, int i, Object obj) {
        if ((i & 2) != 0) {
            j = Color.Companion.m2823getUnspecified0d7_KjU();
        }
        multiParagraph.m4636paintRPmYEkk(canvas, j, (i & 4) != 0 ? null : shadow, (i & 8) != 0 ? null : textDecoration);
    }

    /* renamed from: paint-iJQMabo$default, reason: not valid java name */
    public static /* synthetic */ void m4633paintiJQMabo$default(MultiParagraph multiParagraph, Canvas canvas, long j, Shadow shadow, TextDecoration textDecoration, DrawStyle drawStyle, int i, Object obj) {
        if ((i & 2) != 0) {
            j = Color.Companion.m2823getUnspecified0d7_KjU();
        }
        multiParagraph.m4637paintiJQMabo(canvas, j, (i & 4) != 0 ? null : shadow, (i & 8) != 0 ? null : textDecoration, (i & 16) != 0 ? null : drawStyle);
    }

    private final void requireIndexInRange(int i) {
        ISurgeon iSurgeon = $surgeonFlag;
        if (InstrumentAPI.support(iSurgeon, "35")) {
            iSurgeon.surgeon$dispatch("35", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        if (i >= 0 && i < getAnnotatedString().getText().length()) {
            return;
        }
        throw new IllegalArgumentException(("offset(" + i + ") is out of bounds [0, " + getAnnotatedString().length() + ')').toString());
    }

    private final void requireIndexInRangeInclusiveEnd(int i) {
        ISurgeon iSurgeon = $surgeonFlag;
        if (InstrumentAPI.support(iSurgeon, "36")) {
            iSurgeon.surgeon$dispatch("36", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        if (i >= 0 && i <= getAnnotatedString().getText().length()) {
            return;
        }
        throw new IllegalArgumentException(("offset(" + i + ") is out of bounds [0, " + getAnnotatedString().length() + ']').toString());
    }

    private final void requireLineIndexInRange(int i) {
        ISurgeon iSurgeon = $surgeonFlag;
        if (InstrumentAPI.support(iSurgeon, "37")) {
            iSurgeon.surgeon$dispatch("37", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        if (i >= 0 && i < this.lineCount) {
            return;
        }
        throw new IllegalArgumentException(("lineIndex(" + i + ") is out of bounds [0, " + i + ')').toString());
    }

    @NotNull
    public final ResolvedTextDirection getBidiRunDirection(int i) {
        ISurgeon iSurgeon = $surgeonFlag;
        if (InstrumentAPI.support(iSurgeon, WVPackageMonitorInterface.FORCE_ONLINE_FAILED)) {
            return (ResolvedTextDirection) iSurgeon.surgeon$dispatch(WVPackageMonitorInterface.FORCE_ONLINE_FAILED, new Object[]{this, Integer.valueOf(i)});
        }
        requireIndexInRangeInclusiveEnd(i);
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(i == getAnnotatedString().length() ? CollectionsKt.getLastIndex(this.paragraphInfoList) : MultiParagraphKt.findParagraphByIndex(this.paragraphInfoList, i));
        return paragraphInfo.getParagraph().getBidiRunDirection(paragraphInfo.toLocalIndex(i));
    }

    @NotNull
    public final Rect getBoundingBox(int i) {
        if (i >= getAnnotatedString().getText().length()) {
            i = getAnnotatedString().getText().length() - 1;
        }
        if (i < 0) {
            return new Rect(0.0f, 0.0f, 1.0f, 1.0f);
        }
        requireIndexInRange(i);
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByIndex(this.paragraphInfoList, i));
        return paragraphInfo.toGlobal(paragraphInfo.getParagraph().getBoundingBox(paragraphInfo.toLocalIndex(i)));
    }

    @NotNull
    public final Rect getCursorRect(int i) {
        ISurgeon iSurgeon = $surgeonFlag;
        if (InstrumentAPI.support(iSurgeon, WVPackageMonitorInterface.ZIP_REMOVED_BY_CLEAR)) {
            return (Rect) iSurgeon.surgeon$dispatch(WVPackageMonitorInterface.ZIP_REMOVED_BY_CLEAR, new Object[]{this, Integer.valueOf(i)});
        }
        requireIndexInRangeInclusiveEnd(i);
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(i == getAnnotatedString().length() ? CollectionsKt.getLastIndex(this.paragraphInfoList) : MultiParagraphKt.findParagraphByIndex(this.paragraphInfoList, i));
        return paragraphInfo.toGlobal(paragraphInfo.getParagraph().getCursorRect(paragraphInfo.toLocalIndex(i)));
    }

    public final boolean getDidExceedMaxLines() {
        ISurgeon iSurgeon = $surgeonFlag;
        return InstrumentAPI.support(iSurgeon, "6") ? ((Boolean) iSurgeon.surgeon$dispatch("6", new Object[]{this})).booleanValue() : this.didExceedMaxLines;
    }

    public final float getFirstBaseline() {
        ISurgeon iSurgeon = $surgeonFlag;
        if (InstrumentAPI.support(iSurgeon, WVPackageMonitorInterface.UNKNOWN_FAILED)) {
            return ((Float) iSurgeon.surgeon$dispatch(WVPackageMonitorInterface.UNKNOWN_FAILED, new Object[]{this})).floatValue();
        }
        if (this.paragraphInfoList.isEmpty()) {
            return 0.0f;
        }
        return this.paragraphInfoList.get(0).getParagraph().getFirstBaseline();
    }

    public final float getHeight() {
        ISurgeon iSurgeon = $surgeonFlag;
        return InstrumentAPI.support(iSurgeon, "8") ? ((Float) iSurgeon.surgeon$dispatch("8", new Object[]{this})).floatValue() : this.height;
    }

    public final float getHorizontalPosition(int i, boolean z) {
        ISurgeon iSurgeon = $surgeonFlag;
        if (InstrumentAPI.support(iSurgeon, WVPackageMonitorInterface.NOT_INSTALL_FAILED)) {
            return ((Float) iSurgeon.surgeon$dispatch(WVPackageMonitorInterface.NOT_INSTALL_FAILED, new Object[]{this, Integer.valueOf(i), Boolean.valueOf(z)})).floatValue();
        }
        requireIndexInRangeInclusiveEnd(i);
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(i == getAnnotatedString().length() ? CollectionsKt.getLastIndex(this.paragraphInfoList) : MultiParagraphKt.findParagraphByIndex(this.paragraphInfoList, i));
        return paragraphInfo.getParagraph().getHorizontalPosition(paragraphInfo.toLocalIndex(i), z);
    }

    @NotNull
    public final MultiParagraphIntrinsics getIntrinsics() {
        ISurgeon iSurgeon = $surgeonFlag;
        return InstrumentAPI.support(iSurgeon, "1") ? (MultiParagraphIntrinsics) iSurgeon.surgeon$dispatch("1", new Object[]{this}) : this.intrinsics;
    }

    public final float getLastBaseline() {
        ISurgeon iSurgeon = $surgeonFlag;
        if (InstrumentAPI.support(iSurgeon, WVPackageMonitorInterface.SECURITY_FAILED)) {
            return ((Float) iSurgeon.surgeon$dispatch(WVPackageMonitorInterface.SECURITY_FAILED, new Object[]{this})).floatValue();
        }
        if (this.paragraphInfoList.isEmpty()) {
            return 0.0f;
        }
        ParagraphInfo paragraphInfo = (ParagraphInfo) CollectionsKt.last(this.paragraphInfoList);
        return paragraphInfo.toGlobalYPosition(paragraphInfo.getParagraph().getLastBaseline());
    }

    public final float getLineBottom(int i) {
        ISurgeon iSurgeon = $surgeonFlag;
        if (InstrumentAPI.support(iSurgeon, "29")) {
            return ((Float) iSurgeon.surgeon$dispatch("29", new Object[]{this, Integer.valueOf(i)})).floatValue();
        }
        requireLineIndexInRange(i);
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, i));
        return paragraphInfo.toGlobalYPosition(paragraphInfo.getParagraph().getLineBottom(paragraphInfo.toLocalLineIndex(i)));
    }

    public final int getLineCount() {
        ISurgeon iSurgeon = $surgeonFlag;
        return InstrumentAPI.support(iSurgeon, WVPackageMonitorInterface.CREATE_STREAM_FAILED) ? ((Integer) iSurgeon.surgeon$dispatch(WVPackageMonitorInterface.CREATE_STREAM_FAILED, new Object[]{this})).intValue() : this.lineCount;
    }

    public final int getLineEnd(int i, boolean z) {
        ISurgeon iSurgeon = $surgeonFlag;
        if (InstrumentAPI.support(iSurgeon, "33")) {
            return ((Integer) iSurgeon.surgeon$dispatch("33", new Object[]{this, Integer.valueOf(i), Boolean.valueOf(z)})).intValue();
        }
        requireLineIndexInRange(i);
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, i));
        return paragraphInfo.toGlobalIndex(paragraphInfo.getParagraph().getLineEnd(paragraphInfo.toLocalLineIndex(i), z));
    }

    public final int getLineForOffset(int i) {
        ISurgeon iSurgeon = $surgeonFlag;
        int i2 = 0;
        if (InstrumentAPI.support(iSurgeon, WVPackageMonitorInterface.ZIP_REMOVED_BY_CONFIG)) {
            return ((Integer) iSurgeon.surgeon$dispatch(WVPackageMonitorInterface.ZIP_REMOVED_BY_CONFIG, new Object[]{this, Integer.valueOf(i)})).intValue();
        }
        if (i >= getAnnotatedString().length()) {
            i2 = CollectionsKt.getLastIndex(this.paragraphInfoList);
        } else if (i >= 0) {
            i2 = MultiParagraphKt.findParagraphByIndex(this.paragraphInfoList, i);
        }
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(i2);
        return paragraphInfo.toGlobalLineIndex(paragraphInfo.getParagraph().getLineForOffset(paragraphInfo.toLocalIndex(i)));
    }

    public final int getLineForVerticalPosition(float f) {
        ISurgeon iSurgeon = $surgeonFlag;
        if (InstrumentAPI.support(iSurgeon, "18")) {
            return ((Integer) iSurgeon.surgeon$dispatch("18", new Object[]{this, Float.valueOf(f)})).intValue();
        }
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(f <= 0.0f ? 0 : f >= this.height ? CollectionsKt.getLastIndex(this.paragraphInfoList) : MultiParagraphKt.findParagraphByY(this.paragraphInfoList, f));
        return paragraphInfo.getLength() == 0 ? Math.max(0, paragraphInfo.getStartIndex() - 1) : paragraphInfo.toGlobalLineIndex(paragraphInfo.getParagraph().getLineForVerticalPosition(paragraphInfo.toLocalYPosition(f)));
    }

    public final float getLineHeight(int i) {
        ISurgeon iSurgeon = $surgeonFlag;
        if (InstrumentAPI.support(iSurgeon, "30")) {
            return ((Float) iSurgeon.surgeon$dispatch("30", new Object[]{this, Integer.valueOf(i)})).floatValue();
        }
        requireLineIndexInRange(i);
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, i));
        return paragraphInfo.getParagraph().getLineHeight(paragraphInfo.toLocalLineIndex(i));
    }

    public final float getLineLeft(int i) {
        ISurgeon iSurgeon = $surgeonFlag;
        if (InstrumentAPI.support(iSurgeon, WVPackageMonitorInterface.ZIP_CONFIG_EMPTY_FAILED)) {
            return ((Float) iSurgeon.surgeon$dispatch(WVPackageMonitorInterface.ZIP_CONFIG_EMPTY_FAILED, new Object[]{this, Integer.valueOf(i)})).floatValue();
        }
        requireLineIndexInRange(i);
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, i));
        return paragraphInfo.getParagraph().getLineLeft(paragraphInfo.toLocalLineIndex(i));
    }

    public final float getLineRight(int i) {
        ISurgeon iSurgeon = $surgeonFlag;
        if (InstrumentAPI.support(iSurgeon, "27")) {
            return ((Float) iSurgeon.surgeon$dispatch("27", new Object[]{this, Integer.valueOf(i)})).floatValue();
        }
        requireLineIndexInRange(i);
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, i));
        return paragraphInfo.getParagraph().getLineRight(paragraphInfo.toLocalLineIndex(i));
    }

    public final int getLineStart(int i) {
        ISurgeon iSurgeon = $surgeonFlag;
        if (InstrumentAPI.support(iSurgeon, "32")) {
            return ((Integer) iSurgeon.surgeon$dispatch("32", new Object[]{this, Integer.valueOf(i)})).intValue();
        }
        requireLineIndexInRange(i);
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, i));
        return paragraphInfo.toGlobalIndex(paragraphInfo.getParagraph().getLineStart(paragraphInfo.toLocalLineIndex(i)));
    }

    public final float getLineTop(int i) {
        ISurgeon iSurgeon = $surgeonFlag;
        if (InstrumentAPI.support(iSurgeon, "28")) {
            return ((Float) iSurgeon.surgeon$dispatch("28", new Object[]{this, Integer.valueOf(i)})).floatValue();
        }
        requireLineIndexInRange(i);
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, i));
        return paragraphInfo.toGlobalYPosition(paragraphInfo.getParagraph().getLineTop(paragraphInfo.toLocalLineIndex(i)));
    }

    public final float getLineWidth(int i) {
        ISurgeon iSurgeon = $surgeonFlag;
        if (InstrumentAPI.support(iSurgeon, "31")) {
            return ((Float) iSurgeon.surgeon$dispatch("31", new Object[]{this, Integer.valueOf(i)})).floatValue();
        }
        requireLineIndexInRange(i);
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, i));
        return paragraphInfo.getParagraph().getLineWidth(paragraphInfo.toLocalLineIndex(i));
    }

    public final float getMaxIntrinsicWidth() {
        ISurgeon iSurgeon = $surgeonFlag;
        return InstrumentAPI.support(iSurgeon, "5") ? ((Float) iSurgeon.surgeon$dispatch("5", new Object[]{this})).floatValue() : this.intrinsics.getMaxIntrinsicWidth();
    }

    public final int getMaxLines() {
        ISurgeon iSurgeon = $surgeonFlag;
        return InstrumentAPI.support(iSurgeon, ExifInterface.GPS_MEASUREMENT_2D) ? ((Integer) iSurgeon.surgeon$dispatch(ExifInterface.GPS_MEASUREMENT_2D, new Object[]{this})).intValue() : this.maxLines;
    }

    public final float getMinIntrinsicWidth() {
        ISurgeon iSurgeon = $surgeonFlag;
        return InstrumentAPI.support(iSurgeon, "4") ? ((Float) iSurgeon.surgeon$dispatch("4", new Object[]{this})).floatValue() : this.intrinsics.getMaxIntrinsicWidth();
    }

    /* renamed from: getOffsetForPosition-k-4lQ0M, reason: not valid java name */
    public final int m4634getOffsetForPositionk4lQ0M(long j) {
        ISurgeon iSurgeon = $surgeonFlag;
        if (InstrumentAPI.support(iSurgeon, "19")) {
            return ((Integer) iSurgeon.surgeon$dispatch("19", new Object[]{this, Long.valueOf(j)})).intValue();
        }
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(Offset.m2557getYimpl(j) <= 0.0f ? 0 : Offset.m2557getYimpl(j) >= this.height ? CollectionsKt.getLastIndex(this.paragraphInfoList) : MultiParagraphKt.findParagraphByY(this.paragraphInfoList, Offset.m2557getYimpl(j)));
        return paragraphInfo.getLength() == 0 ? Math.max(0, paragraphInfo.getStartIndex() - 1) : paragraphInfo.toGlobalIndex(paragraphInfo.getParagraph().mo4609getOffsetForPositionk4lQ0M(paragraphInfo.m4641toLocalMKHz9U(j)));
    }

    @NotNull
    public final ResolvedTextDirection getParagraphDirection(int i) {
        ISurgeon iSurgeon = $surgeonFlag;
        if (InstrumentAPI.support(iSurgeon, WVPackageMonitorInterface.FORCE_UPDATE_FAILED)) {
            return (ResolvedTextDirection) iSurgeon.surgeon$dispatch(WVPackageMonitorInterface.FORCE_UPDATE_FAILED, new Object[]{this, Integer.valueOf(i)});
        }
        requireIndexInRangeInclusiveEnd(i);
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(i == getAnnotatedString().length() ? CollectionsKt.getLastIndex(this.paragraphInfoList) : MultiParagraphKt.findParagraphByIndex(this.paragraphInfoList, i));
        return paragraphInfo.getParagraph().getParagraphDirection(paragraphInfo.toLocalIndex(i));
    }

    @NotNull
    public final List<ParagraphInfo> getParagraphInfoList$ui_text_release() {
        ISurgeon iSurgeon = $surgeonFlag;
        return InstrumentAPI.support(iSurgeon, WVPackageMonitorInterface.MAPPING_URL_NULL_FAILED) ? (List) iSurgeon.surgeon$dispatch(WVPackageMonitorInterface.MAPPING_URL_NULL_FAILED, new Object[]{this}) : this.paragraphInfoList;
    }

    @NotNull
    public final Path getPathForRange(int i, int i2) {
        ISurgeon iSurgeon = $surgeonFlag;
        if (InstrumentAPI.support(iSurgeon, "17")) {
            return (Path) iSurgeon.surgeon$dispatch("17", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        if (!((i >= 0 && i <= i2) && i2 <= getAnnotatedString().getText().length())) {
            throw new IllegalArgumentException(("Start(" + i + ") or End(" + i2 + ") is out of range [0.." + getAnnotatedString().getText().length() + "), or start > end!").toString());
        }
        if (i == i2) {
            return AndroidPath_androidKt.Path();
        }
        Path Path = AndroidPath_androidKt.Path();
        int size = this.paragraphInfoList.size();
        for (int findParagraphByIndex = MultiParagraphKt.findParagraphByIndex(this.paragraphInfoList, i); findParagraphByIndex < size; findParagraphByIndex++) {
            ParagraphInfo paragraphInfo = this.paragraphInfoList.get(findParagraphByIndex);
            if (paragraphInfo.getStartIndex() >= i2) {
                break;
            }
            if (paragraphInfo.getStartIndex() != paragraphInfo.getEndIndex()) {
                zn3.c(Path, paragraphInfo.toGlobal(paragraphInfo.getParagraph().getPathForRange(paragraphInfo.toLocalIndex(i), paragraphInfo.toLocalIndex(i2))), 0L, 2, (Object) null);
            }
        }
        return Path;
    }

    @NotNull
    public final List<Rect> getPlaceholderRects() {
        ISurgeon iSurgeon = $surgeonFlag;
        return InstrumentAPI.support(iSurgeon, WVPackageMonitorInterface.READ_LOCAL_FILE_FAILED) ? (List) iSurgeon.surgeon$dispatch(WVPackageMonitorInterface.READ_LOCAL_FILE_FAILED, new Object[]{this}) : this.placeholderRects;
    }

    public final float getWidth() {
        ISurgeon iSurgeon = $surgeonFlag;
        return InstrumentAPI.support(iSurgeon, "7") ? ((Float) iSurgeon.surgeon$dispatch("7", new Object[]{this})).floatValue() : this.width;
    }

    /* renamed from: getWordBoundary--jx7JFs, reason: not valid java name */
    public final long m4635getWordBoundaryjx7JFs(int i) {
        ISurgeon iSurgeon = $surgeonFlag;
        if (InstrumentAPI.support(iSurgeon, WVPackageMonitorInterface.CONFIG_CLOSED_FAILED)) {
            return ((Long) iSurgeon.surgeon$dispatch(WVPackageMonitorInterface.CONFIG_CLOSED_FAILED, new Object[]{this, Integer.valueOf(i)})).longValue();
        }
        requireIndexInRangeInclusiveEnd(i);
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(i == getAnnotatedString().length() ? CollectionsKt.getLastIndex(this.paragraphInfoList) : MultiParagraphKt.findParagraphByIndex(this.paragraphInfoList, i));
        return paragraphInfo.m4640toGlobalGEjPoXI(paragraphInfo.getParagraph().mo4610getWordBoundaryjx7JFs(paragraphInfo.toLocalIndex(i)));
    }

    public final boolean isLineEllipsized(int i) {
        ISurgeon iSurgeon = $surgeonFlag;
        if (InstrumentAPI.support(iSurgeon, "34")) {
            return ((Boolean) iSurgeon.surgeon$dispatch("34", new Object[]{this, Integer.valueOf(i)})).booleanValue();
        }
        requireLineIndexInRange(i);
        return this.paragraphInfoList.get(MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, i)).getParagraph().isLineEllipsized(i);
    }

    @ExperimentalTextApi
    public final void paint(@NotNull Canvas canvas, @NotNull Brush brush, float f, @Nullable Shadow shadow, @Nullable TextDecoration textDecoration, @Nullable DrawStyle drawStyle) {
        ISurgeon iSurgeon = $surgeonFlag;
        if (InstrumentAPI.support(iSurgeon, "16")) {
            iSurgeon.surgeon$dispatch("16", new Object[]{this, canvas, brush, Float.valueOf(f), shadow, textDecoration, drawStyle});
            return;
        }
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(brush, "brush");
        AndroidMultiParagraphDrawKt.drawMultiParagraph(this, canvas, brush, f, shadow, textDecoration, drawStyle);
    }

    /* renamed from: paint-RPmYEkk, reason: not valid java name */
    public final void m4636paintRPmYEkk(@NotNull Canvas canvas, long j, @Nullable Shadow shadow, @Nullable TextDecoration textDecoration) {
        ISurgeon iSurgeon = $surgeonFlag;
        if (InstrumentAPI.support(iSurgeon, WVPackageMonitorInterface.MAPPING_URL_MATCH_FAILED)) {
            iSurgeon.surgeon$dispatch(WVPackageMonitorInterface.MAPPING_URL_MATCH_FAILED, new Object[]{this, canvas, Long.valueOf(j), shadow, textDecoration});
            return;
        }
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        canvas.save();
        List<ParagraphInfo> list = this.paragraphInfoList;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ParagraphInfo paragraphInfo = list.get(i);
            paragraphInfo.getParagraph().mo4611paintRPmYEkk(canvas, j, shadow, textDecoration);
            canvas.translate(0.0f, paragraphInfo.getParagraph().getHeight());
        }
        canvas.restore();
    }

    @ExperimentalTextApi
    /* renamed from: paint-iJQMabo, reason: not valid java name */
    public final void m4637paintiJQMabo(@NotNull Canvas canvas, long j, @Nullable Shadow shadow, @Nullable TextDecoration textDecoration, @Nullable DrawStyle drawStyle) {
        ISurgeon iSurgeon = $surgeonFlag;
        if (InstrumentAPI.support(iSurgeon, WVPackageMonitorInterface.READ_COMBO_LOCAL_FILE_FAILED)) {
            iSurgeon.surgeon$dispatch(WVPackageMonitorInterface.READ_COMBO_LOCAL_FILE_FAILED, new Object[]{this, canvas, Long.valueOf(j), shadow, textDecoration, drawStyle});
            return;
        }
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        canvas.save();
        List<ParagraphInfo> list = this.paragraphInfoList;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ParagraphInfo paragraphInfo = list.get(i);
            paragraphInfo.getParagraph().mo4612paintiJQMabo(canvas, j, shadow, textDecoration, drawStyle);
            canvas.translate(0.0f, paragraphInfo.getParagraph().getHeight());
        }
        canvas.restore();
    }

    public /* synthetic */ MultiParagraph(MultiParagraphIntrinsics multiParagraphIntrinsics, long j, int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(multiParagraphIntrinsics, j, (i2 & 4) != 0 ? Integer.MAX_VALUE : i, (i2 & 8) != 0 ? false : z, null);
    }

    public /* synthetic */ MultiParagraph(MultiParagraphIntrinsics multiParagraphIntrinsics, int i, boolean z, float f, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(multiParagraphIntrinsics, (i2 & 2) != 0 ? Integer.MAX_VALUE : i, (i2 & 4) != 0 ? false : z, f);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated(message = "MultiParagraph that takes maximum allowed width is deprecated, pass constraints instead.", replaceWith = @ReplaceWith(expression = "MultiParagraph(intrinsics, Constraints(maxWidth = ceil(width).toInt()), maxLines, ellipsis)", imports = {"kotlin.math.ceil", "androidx.compose.ui.unit.Constraints"}))
    public MultiParagraph(@NotNull MultiParagraphIntrinsics multiParagraphIntrinsics, int i, boolean z, float f) {
        this(multiParagraphIntrinsics, ConstraintsKt.Constraints$default(0, ParagraphKt.ceilToInt(f), 0, 0, 13, null), i, z, null);
        Intrinsics.checkNotNullParameter(multiParagraphIntrinsics, "intrinsics");
    }

    public /* synthetic */ MultiParagraph(AnnotatedString annotatedString, TextStyle textStyle, List list, int i, boolean z, float f, Density density, Font.ResourceLoader resourceLoader, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString, textStyle, (List<AnnotatedString.Range<Placeholder>>) ((i2 & 4) != 0 ? CollectionsKt.emptyList() : list), (i2 & 8) != 0 ? Integer.MAX_VALUE : i, (i2 & 16) != 0 ? false : z, f, density, resourceLoader);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated(message = "Font.ResourceLoader is deprecated, use fontFamilyResolver instead", replaceWith = @ReplaceWith(expression = "MultiParagraph(annotatedString, style, placeholders, maxLines, ellipsis, width, density, fontFamilyResolver)", imports = {}))
    public MultiParagraph(@NotNull AnnotatedString annotatedString, @NotNull TextStyle textStyle, @NotNull List<AnnotatedString.Range<Placeholder>> list, int i, boolean z, float f, @NotNull Density density, @NotNull Font.ResourceLoader resourceLoader) {
        this(new MultiParagraphIntrinsics(annotatedString, textStyle, list, density, DelegatingFontLoaderForDeprecatedUsage_androidKt.createFontFamilyResolver(resourceLoader)), ConstraintsKt.Constraints$default(0, ParagraphKt.ceilToInt(f), 0, 0, 13, null), i, z, null);
        Intrinsics.checkNotNullParameter(annotatedString, "annotatedString");
        Intrinsics.checkNotNullParameter(textStyle, "style");
        Intrinsics.checkNotNullParameter(list, "placeholders");
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(resourceLoader, "resourceLoader");
    }

    public /* synthetic */ MultiParagraph(AnnotatedString annotatedString, TextStyle textStyle, float f, Density density, FontFamily.Resolver resolver, List list, int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString, textStyle, f, density, resolver, (List<AnnotatedString.Range<Placeholder>>) ((i2 & 32) != 0 ? CollectionsKt.emptyList() : list), (i2 & 64) != 0 ? Integer.MAX_VALUE : i, (i2 & 128) != 0 ? false : z);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated(message = "MultiParagraph that takes maximum allowed width is deprecated, pass constraints instead.", replaceWith = @ReplaceWith(expression = "MultiParagraph(annotatedString, style, Constraints(maxWidth = ceil(width).toInt()), density, fontFamilyResolver, placeholders, maxLines, ellipsis)", imports = {"kotlin.math.ceil", "androidx.compose.ui.unit.Constraints"}))
    public MultiParagraph(@NotNull AnnotatedString annotatedString, @NotNull TextStyle textStyle, float f, @NotNull Density density, @NotNull FontFamily.Resolver resolver, @NotNull List<AnnotatedString.Range<Placeholder>> list, int i, boolean z) {
        this(new MultiParagraphIntrinsics(annotatedString, textStyle, list, density, resolver), ConstraintsKt.Constraints$default(0, ParagraphKt.ceilToInt(f), 0, 0, 13, null), i, z, null);
        Intrinsics.checkNotNullParameter(annotatedString, "annotatedString");
        Intrinsics.checkNotNullParameter(textStyle, "style");
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(resolver, "fontFamilyResolver");
        Intrinsics.checkNotNullParameter(list, "placeholders");
    }

    public /* synthetic */ MultiParagraph(AnnotatedString annotatedString, TextStyle textStyle, long j, Density density, FontFamily.Resolver resolver, List list, int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString, textStyle, j, density, resolver, (i2 & 32) != 0 ? CollectionsKt.emptyList() : list, (i2 & 64) != 0 ? Integer.MAX_VALUE : i, (i2 & 128) != 0 ? false : z, null);
    }

    private MultiParagraph(AnnotatedString annotatedString, TextStyle textStyle, long j, Density density, FontFamily.Resolver resolver, List<AnnotatedString.Range<Placeholder>> list, int i, boolean z) {
        this(new MultiParagraphIntrinsics(annotatedString, textStyle, list, density, resolver), j, i, z, null);
    }
}
