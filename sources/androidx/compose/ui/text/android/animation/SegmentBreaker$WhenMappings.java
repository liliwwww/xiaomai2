package androidx.compose.ui.text.android.animation;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public /* synthetic */ class SegmentBreaker$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

    static {
        int[] iArr = new int[SegmentType.values().length];
        try {
            iArr[SegmentType.Document.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr[SegmentType.Paragraph.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr[SegmentType.Line.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr[SegmentType.Word.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            iArr[SegmentType.Character.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        $EnumSwitchMapping$0 = iArr;
    }
}
