package androidx.compose.ui.input.pointer.util;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public /* synthetic */ class VelocityTracker1D$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

    static {
        int[] iArr = new int[VelocityTracker1D$Strategy.values().length];
        try {
            iArr[VelocityTracker1D$Strategy.Impulse.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr[VelocityTracker1D$Strategy.Lsq2.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        $EnumSwitchMapping$0 = iArr;
    }
}
