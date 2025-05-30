package androidx.compose.ui.tooling;

import androidx.compose.runtime.Composer;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class InspectableKt$Inspectable$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ CompositionDataRecord $compositionDataRecord;
    final /* synthetic */ Function2<Composer, Integer, Unit> $content;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    InspectableKt$Inspectable$1(CompositionDataRecord compositionDataRecord, Function2<? super Composer, ? super Integer, Unit> function2, int i) {
        super(2);
        this.$compositionDataRecord = compositionDataRecord;
        this.$content = function2;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i) {
        InspectableKt.Inspectable(this.$compositionDataRecord, this.$content, composer, this.$$changed | 1);
    }
}
