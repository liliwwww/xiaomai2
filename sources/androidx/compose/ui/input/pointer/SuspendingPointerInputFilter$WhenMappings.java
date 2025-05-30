package androidx.compose.ui.input.pointer;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public /* synthetic */ class SuspendingPointerInputFilter$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

    static {
        int[] iArr = new int[PointerEventPass.values().length];
        try {
            iArr[PointerEventPass.Initial.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr[PointerEventPass.Final.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr[PointerEventPass.Main.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        $EnumSwitchMapping$0 = iArr;
    }
}
