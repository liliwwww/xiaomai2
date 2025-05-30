package androidx.compose.p004ui.modifier;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class SingleLocalMap extends ModifierLocalMap {

    @NotNull
    private final ModifierLocal<?> key;

    @NotNull
    private final MutableState value$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SingleLocalMap(@NotNull ModifierLocal<?> modifierLocal) {
        super(null);
        Intrinsics.checkNotNullParameter(modifierLocal, "key");
        this.key = modifierLocal;
        this.value$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
    }

    private final Object getValue() {
        return this.value$delegate.getValue();
    }

    private final void setValue(Object obj) {
        this.value$delegate.setValue(obj);
    }

    @Override // androidx.compose.p004ui.modifier.ModifierLocalMap
    public boolean contains$ui_release(@NotNull ModifierLocal<?> modifierLocal) {
        Intrinsics.checkNotNullParameter(modifierLocal, "key");
        return modifierLocal == this.key;
    }

    public final void forceValue$ui_release(@Nullable Object obj) {
        setValue(obj);
    }

    @Override // androidx.compose.p004ui.modifier.ModifierLocalMap
    @Nullable
    public <T> T get$ui_release(@NotNull ModifierLocal<T> modifierLocal) {
        Intrinsics.checkNotNullParameter(modifierLocal, "key");
        if (!(modifierLocal == this.key)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        T t = (T) getValue();
        if (t == null) {
            return null;
        }
        return t;
    }

    @Override // androidx.compose.p004ui.modifier.ModifierLocalMap
    /* renamed from: set$ui_release */
    public <T> void mo4260set$ui_release(@NotNull ModifierLocal<T> modifierLocal, T t) {
        Intrinsics.checkNotNullParameter(modifierLocal, "key");
        if (!(modifierLocal == this.key)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        setValue(t);
    }
}
