package androidx.compose.ui.text;

import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.platform.SynchronizedObject;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class DeprecatedBridgeFontResourceLoader$Companion {
    private DeprecatedBridgeFontResourceLoader$Companion() {
    }

    public /* synthetic */ DeprecatedBridgeFontResourceLoader$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @NotNull
    public final Font.ResourceLoader from(@NotNull FontFamily.Resolver resolver) {
        Intrinsics.checkNotNullParameter(resolver, "fontFamilyResolver");
        synchronized (getLock()) {
            DeprecatedBridgeFontResourceLoader$Companion deprecatedBridgeFontResourceLoader$Companion = DeprecatedBridgeFontResourceLoader.Companion;
            Font.ResourceLoader resourceLoader = deprecatedBridgeFontResourceLoader$Companion.getCache().get(resolver);
            if (resourceLoader != null) {
                return resourceLoader;
            }
            DeprecatedBridgeFontResourceLoader deprecatedBridgeFontResourceLoader = new DeprecatedBridgeFontResourceLoader(resolver, (DefaultConstructorMarker) null);
            deprecatedBridgeFontResourceLoader$Companion.getCache().put(resolver, deprecatedBridgeFontResourceLoader);
            return deprecatedBridgeFontResourceLoader;
        }
    }

    @NotNull
    public final Map<FontFamily.Resolver, Font.ResourceLoader> getCache() {
        return DeprecatedBridgeFontResourceLoader.access$getCache$cp();
    }

    @NotNull
    public final SynchronizedObject getLock() {
        return DeprecatedBridgeFontResourceLoader.access$getLock$cp();
    }

    public final void setCache(@NotNull Map<FontFamily.Resolver, Font.ResourceLoader> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        DeprecatedBridgeFontResourceLoader.access$setCache$cp(map);
    }
}
