package androidx.compose.ui.draw;

import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt$drawWithCache$;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class DrawModifierKt {
    @NotNull
    public static final Modifier drawBehind(@NotNull Modifier modifier, @NotNull final Function1<? super DrawScope, Unit> function1) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(function1, "onDraw");
        return modifier.then(new DrawBackgroundModifier(function1, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.ui.draw.DrawModifierKt$drawBehind$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((InspectorInfo) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull InspectorInfo inspectorInfo) {
                Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
                inspectorInfo.setName("drawBehind");
                inspectorInfo.getProperties().set("onDraw", function1);
            }
        } : InspectableValueKt.getNoInspectorInfo()));
    }

    @NotNull
    public static final Modifier drawWithCache(@NotNull Modifier modifier, @NotNull Function1<? super CacheDrawScope, DrawResult> function1) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(function1, "onBuildDrawCache");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new DrawModifierKt$drawWithCache$.inlined.debugInspectorInfo.1(function1) : InspectableValueKt.getNoInspectorInfo(), new drawWithCache.2(function1));
    }

    @NotNull
    public static final Modifier drawWithContent(@NotNull Modifier modifier, @NotNull final Function1<? super ContentDrawScope, Unit> function1) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(function1, "onDraw");
        return modifier.then(new DrawWithContentModifier(function1, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.ui.draw.DrawModifierKt$drawWithContent$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((InspectorInfo) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull InspectorInfo inspectorInfo) {
                Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
                inspectorInfo.setName("drawWithContent");
                inspectorInfo.getProperties().set("onDraw", function1);
            }
        } : InspectableValueKt.getNoInspectorInfo()));
    }
}
