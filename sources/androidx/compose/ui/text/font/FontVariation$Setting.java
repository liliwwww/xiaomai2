package androidx.compose.ui.text.font;

import androidx.compose.runtime.Immutable;
import androidx.compose.ui.unit.Density;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Immutable
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public interface FontVariation$Setting {
    @NotNull
    String getAxisName();

    boolean getNeedsDensity();

    float toVariationValue(@Nullable Density density);
}
