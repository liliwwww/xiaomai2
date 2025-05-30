package androidx.compose.p004ui.node;

import androidx.compose.p004ui.layout.AlignmentLine;
import androidx.compose.p004ui.layout.Measurable;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface AlignmentLinesOwner extends Measurable {
    @NotNull
    Map<AlignmentLine, Integer> calculateAlignmentLines();

    void forEachChildAlignmentLinesOwner(@NotNull Function1<? super AlignmentLinesOwner, Unit> function1);

    @NotNull
    AlignmentLines getAlignmentLines();

    @NotNull
    NodeCoordinator getInnerCoordinator();

    @Nullable
    AlignmentLinesOwner getParentAlignmentLinesOwner();

    boolean isPlaced();

    void layoutChildren();

    void requestLayout();

    void requestMeasure();
}
