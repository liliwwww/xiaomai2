package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class ListItemKt$ListItem$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ Function2<Composer, Integer, Unit> $icon;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function2<Composer, Integer, Unit> $overlineText;
    final /* synthetic */ Function2<Composer, Integer, Unit> $secondaryText;
    final /* synthetic */ boolean $singleLineSecondaryText;
    final /* synthetic */ Function2<Composer, Integer, Unit> $text;
    final /* synthetic */ Function2<Composer, Integer, Unit> $trailing;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ListItemKt$ListItem$1(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, boolean z, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, int i, int i2) {
        super(2);
        this.$modifier = modifier;
        this.$icon = function2;
        this.$secondaryText = function22;
        this.$singleLineSecondaryText = z;
        this.$overlineText = function23;
        this.$trailing = function24;
        this.$text = function25;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i) {
        ListItemKt.ListItem(this.$modifier, this.$icon, this.$secondaryText, this.$singleLineSecondaryText, this.$overlineText, this.$trailing, this.$text, composer, this.$$changed | 1, this.$$default);
    }
}
