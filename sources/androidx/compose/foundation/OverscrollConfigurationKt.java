package androidx.compose.foundation;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class OverscrollConfigurationKt {

    @NotNull
    private static final ProvidableCompositionLocal<OverscrollConfiguration> LocalOverscrollConfiguration = CompositionLocalKt.compositionLocalOf$default(null, new Function0<OverscrollConfiguration>() { // from class: androidx.compose.foundation.OverscrollConfigurationKt$LocalOverscrollConfiguration$1
        @Nullable
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final OverscrollConfiguration m163invoke() {
            return new OverscrollConfiguration(0L, (PaddingValues) null, 3, (DefaultConstructorMarker) null);
        }
    }, 1, null);

    @ExperimentalFoundationApi
    @NotNull
    public static final ProvidableCompositionLocal<OverscrollConfiguration> getLocalOverscrollConfiguration() {
        return LocalOverscrollConfiguration;
    }

    @ExperimentalFoundationApi
    public static /* synthetic */ void getLocalOverscrollConfiguration$annotations() {
    }
}
