package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitType;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class SaversKt$TextUnitSaver$1 extends Lambda implements Function2<SaverScope, TextUnit, Object> {
    public static final SaversKt$TextUnitSaver$1 INSTANCE = new SaversKt$TextUnitSaver$1();

    SaversKt$TextUnitSaver$1() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return m1881invokempE4wyQ((SaverScope) obj, ((TextUnit) obj2).m2222unboximpl());
    }

    @Nullable
    /* renamed from: invoke-mpE4wyQ, reason: not valid java name */
    public final Object m1881invokempE4wyQ(@NotNull SaverScope saverScope, long j) {
        Intrinsics.checkNotNullParameter(saverScope, "$this$Saver");
        return CollectionsKt.arrayListOf(new Object[]{SaversKt.save(Float.valueOf(TextUnit.m2213getValueimpl(j))), SaversKt.save(TextUnitType.box-impl(TextUnit.m2212getTypeUIouoOA(j)))});
    }
}
