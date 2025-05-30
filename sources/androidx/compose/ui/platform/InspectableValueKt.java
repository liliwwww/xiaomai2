package androidx.compose.ui.platform;

import androidx.compose.ui.Modifier;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class InspectableValueKt {

    @NotNull
    private static final Function1<InspectorInfo, Unit> NoInspectorInfo = new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.ui.platform.InspectableValueKt$NoInspectorInfo$1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((InspectorInfo) obj);
            return Unit.INSTANCE;
        }

        public final void invoke(@NotNull InspectorInfo inspectorInfo) {
            Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
        }
    };
    public static final /* synthetic */ int a = 0;
    private static boolean isDebugInspectorInfoEnabled;

    @NotNull
    public static final Function1<InspectorInfo, Unit> debugInspectorInfo(@NotNull final Function1<? super InspectorInfo, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "definitions");
        return isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.ui.platform.InspectableValueKt$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((InspectorInfo) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull InspectorInfo inspectorInfo) {
                Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
                function1.invoke(inspectorInfo);
            }
        } : getNoInspectorInfo();
    }

    @NotNull
    public static final Function1<InspectorInfo, Unit> getNoInspectorInfo() {
        return NoInspectorInfo;
    }

    @NotNull
    public static final Modifier inspectable(@NotNull Modifier modifier, @NotNull Function1<? super InspectorInfo, Unit> function1, @NotNull Function1<? super Modifier, ? extends Modifier> function12) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(function1, "inspectorInfo");
        Intrinsics.checkNotNullParameter(function12, "factory");
        return inspectableWrapper(modifier, function1, (Modifier) function12.invoke(Modifier.Companion));
    }

    @PublishedApi
    @NotNull
    public static final Modifier inspectableWrapper(@NotNull Modifier modifier, @NotNull Function1<? super InspectorInfo, Unit> function1, @NotNull Modifier modifier2) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(function1, "inspectorInfo");
        Intrinsics.checkNotNullParameter(modifier2, "wrapped");
        InspectableModifier inspectableModifier = new InspectableModifier(function1);
        return modifier.then(inspectableModifier).then(modifier2).then(inspectableModifier.getEnd());
    }

    public static final boolean isDebugInspectorInfoEnabled() {
        return isDebugInspectorInfoEnabled;
    }

    public static final void setDebugInspectorInfoEnabled(boolean z) {
        isDebugInspectorInfoEnabled = z;
    }
}
