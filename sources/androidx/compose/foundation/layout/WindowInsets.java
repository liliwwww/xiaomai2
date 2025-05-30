package androidx.compose.foundation.layout;

import androidx.compose.p004ui.unit.Density;
import androidx.compose.p004ui.unit.LayoutDirection;
import androidx.compose.runtime.Stable;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Stable
/* loaded from: classes2.dex */
public interface WindowInsets {

    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;

    /* compiled from: Taobao */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }
    }

    int getBottom(@NotNull Density density);

    int getLeft(@NotNull Density density, @NotNull LayoutDirection layoutDirection);

    int getRight(@NotNull Density density, @NotNull LayoutDirection layoutDirection);

    int getTop(@NotNull Density density);
}
