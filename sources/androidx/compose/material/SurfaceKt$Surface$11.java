package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class SurfaceKt$Surface$11 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$changed1;
    final /* synthetic */ int $$default;
    final /* synthetic */ BorderStroke $border;
    final /* synthetic */ boolean $checked;
    final /* synthetic */ long $color;
    final /* synthetic */ Function2<Composer, Integer, Unit> $content;
    final /* synthetic */ long $contentColor;
    final /* synthetic */ float $elevation;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function1<Boolean, Unit> $onCheckedChange;
    final /* synthetic */ Shape $shape;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    SurfaceKt$Surface$11(boolean z, Function1<? super Boolean, Unit> function1, Modifier modifier, boolean z2, Shape shape, long j, long j2, BorderStroke borderStroke, float f, MutableInteractionSource mutableInteractionSource, Function2<? super Composer, ? super Integer, Unit> function2, int i, int i2, int i3) {
        super(2);
        this.$checked = z;
        this.$onCheckedChange = function1;
        this.$modifier = modifier;
        this.$enabled = z2;
        this.$shape = shape;
        this.$color = j;
        this.$contentColor = j2;
        this.$border = borderStroke;
        this.$elevation = f;
        this.$interactionSource = mutableInteractionSource;
        this.$content = function2;
        this.$$changed = i;
        this.$$changed1 = i2;
        this.$$default = i3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i) {
        SurfaceKt.Surface-Ny5ogXk(this.$checked, this.$onCheckedChange, this.$modifier, this.$enabled, this.$shape, this.$color, this.$contentColor, this.$border, this.$elevation, this.$interactionSource, this.$content, composer, this.$$changed | 1, this.$$changed1, this.$$default);
    }
}
