package androidx.compose.ui.node;

import androidx.compose.ui.modifier.ModifierLocal;
import androidx.compose.ui.modifier.ModifierLocalReadScope;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class BackwardsCompatNodeKt$DetachedModifierLocalReadScope$1 implements ModifierLocalReadScope {
    BackwardsCompatNodeKt$DetachedModifierLocalReadScope$1() {
    }

    public <T> T getCurrent(@NotNull ModifierLocal<T> modifierLocal) {
        Intrinsics.checkNotNullParameter(modifierLocal, "<this>");
        return (T) modifierLocal.getDefaultFactory$ui_release().invoke();
    }
}
