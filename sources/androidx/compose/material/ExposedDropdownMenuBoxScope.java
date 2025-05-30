package androidx.compose.material;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.p004ui.Modifier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@ExperimentalMaterialApi
/* loaded from: classes2.dex */
public interface ExposedDropdownMenuBoxScope {

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static final class DefaultImpls {
        /* JADX WARN: Removed duplicated region for block: B:13:0x006d  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0084  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x01ab  */
        /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00b5  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00c2  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x00da  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x019f  */
        /* JADX WARN: Removed duplicated region for block: B:47:0x011a  */
        /* JADX WARN: Removed duplicated region for block: B:54:0x00ba  */
        /* JADX WARN: Removed duplicated region for block: B:55:0x0089  */
        /* JADX WARN: Removed duplicated region for block: B:62:0x0070  */
        @androidx.compose.runtime.Composable
        @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static void ExposedDropdownMenu(@org.jetbrains.annotations.NotNull final androidx.compose.material.ExposedDropdownMenuBoxScope r23, final boolean r24, @org.jetbrains.annotations.NotNull final kotlin.jvm.functions.Function0<kotlin.Unit> r25, @org.jetbrains.annotations.Nullable androidx.compose.p004ui.Modifier r26, @org.jetbrains.annotations.NotNull final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r27, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r28, final int r29, final int r30) {
            /*
                Method dump skipped, instructions count: 449
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ExposedDropdownMenuBoxScope.DefaultImpls.ExposedDropdownMenu(androidx.compose.material.ExposedDropdownMenuBoxScope, boolean, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
        }

        public static /* synthetic */ Modifier exposedDropdownSize$default(ExposedDropdownMenuBoxScope exposedDropdownMenuBoxScope, Modifier modifier, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: exposedDropdownSize");
            }
            if ((i & 1) != 0) {
                z = true;
            }
            return exposedDropdownMenuBoxScope.exposedDropdownSize(modifier, z);
        }
    }

    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    void ExposedDropdownMenu(boolean z, @NotNull Function0<Unit> function0, @Nullable Modifier modifier, @NotNull Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, @Nullable Composer composer, int i, int i2);

    @NotNull
    Modifier exposedDropdownSize(@NotNull Modifier modifier, boolean z);
}
