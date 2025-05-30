package androidx.compose.ui.tooling;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.tooling.InspectionTablesKt;
import androidx.compose.ui.platform.InspectionModeKt;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class InspectableKt {
    @Deprecated(message = "This method should not be used in application code and will be removed soon.")
    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final void InInspectionModeOnly(@NotNull final Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(function2, "content");
        Composer startRestartGroup = composer.startRestartGroup(-1456071021);
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed(function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 11) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1456071021, i2, -1, "androidx.compose.ui.tooling.InInspectionModeOnly (Inspectable.kt:74)");
            }
            if (((Boolean) startRestartGroup.consume(InspectionModeKt.getLocalInspectionMode())).booleanValue()) {
                function2.invoke(startRestartGroup, Integer.valueOf(i2 & 14));
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.tooling.InspectableKt$InInspectionModeOnly$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable Composer composer2, int i3) {
                InspectableKt.InInspectionModeOnly(function2, composer2, i | 1);
            }
        });
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final void Inspectable(@NotNull CompositionDataRecord compositionDataRecord, @NotNull Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(compositionDataRecord, "compositionDataRecord");
        Intrinsics.checkNotNullParameter(function2, "content");
        Composer startRestartGroup = composer.startRestartGroup(-913922352);
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed(compositionDataRecord) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= startRestartGroup.changed(function2) ? 32 : 16;
        }
        if ((i2 & 91) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-913922352, i2, -1, "androidx.compose.ui.tooling.Inspectable (Inspectable.kt:53)");
            }
            startRestartGroup.collectParameterInformation();
            Set store = ((CompositionDataRecordImpl) compositionDataRecord).getStore();
            store.add(startRestartGroup.getCompositionData());
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{InspectionModeKt.getLocalInspectionMode().provides(Boolean.TRUE), InspectionTablesKt.getLocalInspectionTables().provides(store)}, function2, startRestartGroup, (i2 & 112) | 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Inspectable.1(compositionDataRecord, function2, i));
    }
}
