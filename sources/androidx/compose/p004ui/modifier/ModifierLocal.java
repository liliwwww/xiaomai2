package androidx.compose.p004ui.modifier;

import androidx.compose.runtime.Stable;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Stable
/* loaded from: classes.dex */
public abstract class ModifierLocal<T> {

    @NotNull
    private final Function0<T> defaultFactory;

    /* JADX WARN: Multi-variable type inference failed */
    private ModifierLocal(Function0<? extends T> function0) {
        this.defaultFactory = function0;
    }

    public /* synthetic */ ModifierLocal(Function0 function0, DefaultConstructorMarker defaultConstructorMarker) {
        this(function0);
    }

    @NotNull
    public final Function0<T> getDefaultFactory$ui_release() {
        return this.defaultFactory;
    }
}
