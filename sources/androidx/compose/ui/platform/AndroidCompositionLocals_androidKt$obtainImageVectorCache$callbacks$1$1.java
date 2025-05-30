package androidx.compose.ui.platform;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import androidx.compose.ui.res.ImageVectorCache;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class AndroidCompositionLocals_androidKt$obtainImageVectorCache$callbacks$1$1 implements ComponentCallbacks2 {
    final /* synthetic */ Configuration $currentConfiguration;
    final /* synthetic */ ImageVectorCache $imageVectorCache;

    AndroidCompositionLocals_androidKt$obtainImageVectorCache$callbacks$1$1(Configuration configuration, ImageVectorCache imageVectorCache) {
        this.$currentConfiguration = configuration;
        this.$imageVectorCache = imageVectorCache;
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        this.$imageVectorCache.prune(this.$currentConfiguration.updateFrom(configuration));
        this.$currentConfiguration.setTo(configuration);
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        this.$imageVectorCache.clear();
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        this.$imageVectorCache.clear();
    }
}
