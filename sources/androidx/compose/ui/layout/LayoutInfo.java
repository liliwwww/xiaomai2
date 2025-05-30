package androidx.compose.ui.layout;

import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public interface LayoutInfo {
    @NotNull
    LayoutCoordinates getCoordinates();

    @NotNull
    Density getDensity();

    int getHeight();

    @NotNull
    LayoutDirection getLayoutDirection();

    @NotNull
    List<ModifierInfo> getModifierInfo();

    @Nullable
    LayoutInfo getParentInfo();

    int getSemanticsId();

    @NotNull
    ViewConfiguration getViewConfiguration();

    int getWidth();

    boolean isAttached();

    boolean isPlaced();
}
