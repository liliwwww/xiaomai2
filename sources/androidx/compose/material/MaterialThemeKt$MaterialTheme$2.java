package androidx.compose.material;

import androidx.compose.runtime.Composer;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class MaterialThemeKt$MaterialTheme$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ Colors $colors;
    final /* synthetic */ Function2<Composer, Integer, Unit> $content;
    final /* synthetic */ Shapes $shapes;
    final /* synthetic */ Typography $typography;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MaterialThemeKt$MaterialTheme$2(Colors colors, Typography typography, Shapes shapes, Function2<? super Composer, ? super Integer, Unit> function2, int i, int i2) {
        super(2);
        this.$colors = colors;
        this.$typography = typography;
        this.$shapes = shapes;
        this.$content = function2;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i) {
        MaterialThemeKt.MaterialTheme(this.$colors, this.$typography, this.$shapes, this.$content, composer, this.$$changed | 1, this.$$default);
    }
}
