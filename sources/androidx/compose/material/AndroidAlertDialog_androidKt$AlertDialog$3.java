package androidx.compose.material;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class AndroidAlertDialog_androidKt$AlertDialog$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ long $backgroundColor;
    final /* synthetic */ Function2<Composer, Integer, Unit> $buttons;
    final /* synthetic */ long $contentColor;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Shape $shape;
    final /* synthetic */ Function2<Composer, Integer, Unit> $text;
    final /* synthetic */ Function2<Composer, Integer, Unit> $title;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidAlertDialog_androidKt$AlertDialog$3(Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Shape shape, long j, long j2, int i) {
        super(2);
        this.$buttons = function2;
        this.$modifier = modifier;
        this.$title = function22;
        this.$text = function23;
        this.$shape = shape;
        this.$backgroundColor = j;
        this.$contentColor = j2;
        this.$$dirty = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@Nullable Composer composer, int i) {
        if ((i & 11) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1787418772, i, -1, "androidx.compose.material.AlertDialog.<anonymous> (AndroidAlertDialog.android.kt:139)");
        }
        Function2<Composer, Integer, Unit> function2 = this.$buttons;
        Modifier modifier = this.$modifier;
        Function2<Composer, Integer, Unit> function22 = this.$title;
        Function2<Composer, Integer, Unit> function23 = this.$text;
        Shape shape = this.$shape;
        long j = this.$backgroundColor;
        long j2 = this.$contentColor;
        int i2 = this.$$dirty;
        AlertDialogKt.m653AlertDialogContentWMdw5o4(function2, modifier, function22, function23, shape, j, j2, composer, ((i2 >> 3) & 14) | ((i2 >> 3) & 112) | ((i2 >> 3) & 896) | ((i2 >> 3) & 7168) | (57344 & (i2 >> 3)) | (458752 & (i2 >> 3)) | ((i2 >> 3) & 3670016), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
