package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier$Element;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public interface OnPlacedModifier extends Modifier$Element {
    void onPlaced(@NotNull LayoutCoordinates layoutCoordinates);
}
