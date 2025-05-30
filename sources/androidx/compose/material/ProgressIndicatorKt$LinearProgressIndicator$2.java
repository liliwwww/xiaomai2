package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class ProgressIndicatorKt$LinearProgressIndicator$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ long $backgroundColor;
    final /* synthetic */ long $color;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ float $progress;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ProgressIndicatorKt$LinearProgressIndicator$2(float f, Modifier modifier, long j, long j2, int i, int i2) {
        super(2);
        this.$progress = f;
        this.$modifier = modifier;
        this.$color = j;
        this.$backgroundColor = j2;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i) {
        ProgressIndicatorKt.LinearProgressIndicator-eaDK9VM(this.$progress, this.$modifier, this.$color, this.$backgroundColor, composer, this.$$changed | 1, this.$$default);
    }
}
