package androidx.compose.ui.graphics;

import androidx.compose.ui.graphics.PathOperation;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class PathOperationKt {
    public static final int getDifference(@NotNull PathOperation.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return companion.getDifference-b3I0S0c();
    }

    @Deprecated(message = "Use PathOperation.Difference instead", replaceWith = @ReplaceWith(expression = "PathOperation.Difference", imports = {"androidx.compose.ui.graphics.PathOperation.Difference"}))
    public static /* synthetic */ void getDifference$annotations(PathOperation.Companion companion) {
    }

    public static final int getIntersect(@NotNull PathOperation.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return companion.getIntersect-b3I0S0c();
    }

    @Deprecated(message = "Use PathOperation.Intersect instead", replaceWith = @ReplaceWith(expression = "PathOperation.Intersect", imports = {"androidx.compose.ui.graphics.PathOperation.Intersect"}))
    public static /* synthetic */ void getIntersect$annotations(PathOperation.Companion companion) {
    }

    public static final int getReverseDifference(@NotNull PathOperation.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return companion.getReverseDifference-b3I0S0c();
    }

    @Deprecated(message = "Use PathOperation.ReverseDifference instead", replaceWith = @ReplaceWith(expression = "PathOperation.ReverseDifference", imports = {"androidx.compose.ui.graphics.PathOperation.ReverseDifference"}))
    public static /* synthetic */ void getReverseDifference$annotations(PathOperation.Companion companion) {
    }

    public static final int getUnion(@NotNull PathOperation.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return companion.getUnion-b3I0S0c();
    }

    @Deprecated(message = "Use PathOperation.Union instead", replaceWith = @ReplaceWith(expression = "PathOperation.Union", imports = {"androidx.compose.ui.graphics.PathOperation.Union"}))
    public static /* synthetic */ void getUnion$annotations(PathOperation.Companion companion) {
    }

    public static final int getXor(@NotNull PathOperation.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return companion.getXor-b3I0S0c();
    }

    @Deprecated(message = "Use PathOperation.Xor instead", replaceWith = @ReplaceWith(expression = "PathOperation.Xor", imports = {"androidx.compose.ui.graphics.PathOperation.Xor"}))
    public static /* synthetic */ void getXor$annotations(PathOperation.Companion companion) {
    }
}
