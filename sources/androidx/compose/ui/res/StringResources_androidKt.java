package androidx.compose.ui.res;

import androidx.annotation.ArrayRes;
import androidx.annotation.PluralsRes;
import androidx.annotation.StringRes;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ReadOnlyComposable;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class StringResources_androidKt {
    @Composable
    @ReadOnlyComposable
    @NotNull
    public static final String pluralStringResource(@PluralsRes int i, int i2, @Nullable Composer composer, int i3) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1784741530, i3, -1, "androidx.compose.ui.res.pluralStringResource (StringResources.android.kt:73)");
        }
        String quantityString = Resources_androidKt.resources(composer, 0).getQuantityString(i, i2);
        Intrinsics.checkNotNullExpressionValue(quantityString, "resources.getQuantityString(id, count)");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return quantityString;
    }

    @Composable
    @ReadOnlyComposable
    @NotNull
    public static final String[] stringArrayResource(@ArrayRes int i, @Nullable Composer composer, int i2) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1562162650, i2, -1, "androidx.compose.ui.res.stringArrayResource (StringResources.android.kt:59)");
        }
        String[] stringArray = Resources_androidKt.resources(composer, 0).getStringArray(i);
        Intrinsics.checkNotNullExpressionValue(stringArray, "resources.getStringArray(id)");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return stringArray;
    }

    @Composable
    @ReadOnlyComposable
    @NotNull
    public static final String stringResource(@StringRes int i, @Nullable Composer composer, int i2) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1223887937, i2, -1, "androidx.compose.ui.res.stringResource (StringResources.android.kt:32)");
        }
        String string = Resources_androidKt.resources(composer, 0).getString(i);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(id)");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return string;
    }

    @Composable
    @ReadOnlyComposable
    @NotNull
    public static final String pluralStringResource(@PluralsRes int i, int i2, @NotNull Object[] objArr, @Nullable Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(objArr, "formatArgs");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(523207213, i3, -1, "androidx.compose.ui.res.pluralStringResource (StringResources.android.kt:88)");
        }
        String quantityString = Resources_androidKt.resources(composer, 0).getQuantityString(i, i2, Arrays.copyOf(objArr, objArr.length));
        Intrinsics.checkNotNullExpressionValue(quantityString, "resources.getQuantityStr…g(id, count, *formatArgs)");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return quantityString;
    }

    @Composable
    @ReadOnlyComposable
    @NotNull
    public static final String stringResource(@StringRes int i, @NotNull Object[] objArr, @Nullable Composer composer, int i2) {
        Intrinsics.checkNotNullParameter(objArr, "formatArgs");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2071230100, i2, -1, "androidx.compose.ui.res.stringResource (StringResources.android.kt:46)");
        }
        String string = Resources_androidKt.resources(composer, 0).getString(i, Arrays.copyOf(objArr, objArr.length));
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(id, *formatArgs)");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return string;
    }
}
