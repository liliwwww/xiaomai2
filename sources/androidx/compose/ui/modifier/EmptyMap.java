package androidx.compose.ui.modifier;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class EmptyMap extends ModifierLocalMap {

    @NotNull
    public static final EmptyMap INSTANCE = new EmptyMap();

    private EmptyMap() {
        super((DefaultConstructorMarker) null);
    }

    public boolean contains$ui_release(@NotNull ModifierLocal<?> modifierLocal) {
        Intrinsics.checkNotNullParameter(modifierLocal, "key");
        return false;
    }

    @Nullable
    public <T> T get$ui_release(@NotNull ModifierLocal<T> modifierLocal) {
        Intrinsics.checkNotNullParameter(modifierLocal, "key");
        throw new IllegalStateException("".toString());
    }

    /* renamed from: set$ui_release, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ void m1584set$ui_release(ModifierLocal modifierLocal, Object obj) {
        set$ui_release((ModifierLocal<ModifierLocal>) modifierLocal, (ModifierLocal) obj);
    }

    @NotNull
    public <T> Void set$ui_release(@NotNull ModifierLocal<T> modifierLocal, T t) {
        Intrinsics.checkNotNullParameter(modifierLocal, "key");
        throw new IllegalStateException("".toString());
    }
}
