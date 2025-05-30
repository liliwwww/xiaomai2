package androidx.compose.p004ui.layout;

import androidx.compose.p004ui.ExperimentalComposeUiApi;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.unit.Constraints;
import androidx.compose.p004ui.unit.IntSize;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@ExperimentalComposeUiApi
/* loaded from: classes2.dex */
public interface LookaheadLayoutScope {
    @NotNull
    Modifier intermediateLayout(@NotNull Modifier modifier, @NotNull Function4<? super MeasureScope, ? super Measurable, ? super Constraints, ? super IntSize, ? extends MeasureResult> function4);

    @NotNull
    Modifier onPlaced(@NotNull Modifier modifier, @NotNull Function2<? super LookaheadLayoutCoordinates, ? super LookaheadLayoutCoordinates, Unit> function2);
}
