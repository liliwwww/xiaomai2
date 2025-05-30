package androidx.compose.material;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class SwitchKt$Switch$2 extends Lambda implements Function2<Boolean, Boolean, ThresholdConfig> {
    public static final SwitchKt$Switch$2 INSTANCE = new SwitchKt$Switch$2();

    SwitchKt$Switch$2() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue());
    }

    @NotNull
    public final ThresholdConfig invoke(boolean z, boolean z2) {
        return new FractionalThreshold(0.5f);
    }
}
