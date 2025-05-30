package androidx.compose.ui;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class ComposedModifierKt$materialize$1 extends Lambda implements Function1<Modifier$Element, Boolean> {
    public static final ComposedModifierKt$materialize$1 INSTANCE = new ComposedModifierKt$materialize$1();

    ComposedModifierKt$materialize$1() {
        super(1);
    }

    @NotNull
    public final Boolean invoke(@NotNull Modifier$Element modifier$Element) {
        Intrinsics.checkNotNullParameter(modifier$Element, "it");
        return Boolean.valueOf(!(modifier$Element instanceof ComposedModifier));
    }
}
