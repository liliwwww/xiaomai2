package androidx.compose.foundation;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.unit.Density;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Stable
@ExperimentalFoundationApi
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public interface MarqueeSpacing {

    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;

    @ExperimentalFoundationApi
    int calculateSpacing(@NotNull Density density, int i, int i2);
}
