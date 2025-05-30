package androidx.compose.ui.modifier;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class BackwardsCompatLocalMap extends ModifierLocalMap {

    @NotNull
    private ModifierLocalProvider<?> element;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackwardsCompatLocalMap(@NotNull ModifierLocalProvider<?> modifierLocalProvider) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(modifierLocalProvider, "element");
        this.element = modifierLocalProvider;
    }

    public boolean contains$ui_release(@NotNull ModifierLocal<?> modifierLocal) {
        Intrinsics.checkNotNullParameter(modifierLocal, "key");
        return modifierLocal == this.element.getKey();
    }

    @Nullable
    public <T> T get$ui_release(@NotNull ModifierLocal<T> modifierLocal) {
        Intrinsics.checkNotNullParameter(modifierLocal, "key");
        if (modifierLocal == this.element.getKey()) {
            return (T) this.element.getValue();
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    @NotNull
    public final ModifierLocalProvider<?> getElement() {
        return this.element;
    }

    public <T> void set$ui_release(@NotNull ModifierLocal<T> modifierLocal, T t) {
        Intrinsics.checkNotNullParameter(modifierLocal, "key");
        throw new IllegalStateException("Set is not allowed on a backwards compat provider".toString());
    }

    public final void setElement(@NotNull ModifierLocalProvider<?> modifierLocalProvider) {
        Intrinsics.checkNotNullParameter(modifierLocalProvider, "<set-?>");
        this.element = modifierLocalProvider;
    }
}
