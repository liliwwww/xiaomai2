package androidx.compose.ui.graphics;

import android.graphics.Paint;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public /* synthetic */ class AndroidPaint_androidKt$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;
    public static final /* synthetic */ int[] $EnumSwitchMapping$1;
    public static final /* synthetic */ int[] $EnumSwitchMapping$2;

    static {
        int[] iArr = new int[Paint.Style.values().length];
        try {
            iArr[Paint.Style.STROKE.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        $EnumSwitchMapping$0 = iArr;
        int[] iArr2 = new int[Paint.Cap.values().length];
        try {
            iArr2[Paint.Cap.BUTT.ordinal()] = 1;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[Paint.Cap.ROUND.ordinal()] = 2;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr2[Paint.Cap.SQUARE.ordinal()] = 3;
        } catch (NoSuchFieldError unused4) {
        }
        $EnumSwitchMapping$1 = iArr2;
        int[] iArr3 = new int[Paint.Join.values().length];
        try {
            iArr3[Paint.Join.MITER.ordinal()] = 1;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            iArr3[Paint.Join.BEVEL.ordinal()] = 2;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            iArr3[Paint.Join.ROUND.ordinal()] = 3;
        } catch (NoSuchFieldError unused7) {
        }
        $EnumSwitchMapping$2 = iArr3;
    }
}
