package androidx.compose.p004ui.modifier;

import androidx.compose.p004ui.ExperimentalComposeUiApi;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
@ExperimentalComposeUiApi
/* loaded from: classes2.dex */
public abstract class ModifierLocalMap {
    public static final int $stable = 0;

    private ModifierLocalMap() {
    }

    public /* synthetic */ ModifierLocalMap(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract boolean contains$ui_release(@NotNull ModifierLocal<?> modifierLocal);

    @Nullable
    public abstract <T> T get$ui_release(@NotNull ModifierLocal<T> modifierLocal);

    /* renamed from: set$ui_release */
    public abstract <T> void mo4260set$ui_release(@NotNull ModifierLocal<T> modifierLocal, T t);
}
