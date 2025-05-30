package androidx.compose.p004ui.text;

import androidx.compose.p004ui.text.font.Font;
import androidx.compose.p004ui.text.font.FontFamily;
import androidx.compose.p004ui.text.font.FontKt;
import androidx.compose.p004ui.text.platform.Synchronization_jvmKt;
import androidx.compose.p004ui.text.platform.SynchronizedObject;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tb.po1;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
final class DeprecatedBridgeFontResourceLoader implements Font.ResourceLoader {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static Map<FontFamily.Resolver, Font.ResourceLoader> cache = new LinkedHashMap();

    @NotNull
    private static final SynchronizedObject lock = Synchronization_jvmKt.createSynchronizedObject();

    @NotNull
    private final FontFamily.Resolver fontFamilyResolver;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Font.ResourceLoader from(@NotNull FontFamily.Resolver resolver) {
            Intrinsics.checkNotNullParameter(resolver, "fontFamilyResolver");
            synchronized (getLock()) {
                Companion companion = DeprecatedBridgeFontResourceLoader.Companion;
                Font.ResourceLoader resourceLoader = companion.getCache().get(resolver);
                if (resourceLoader != null) {
                    return resourceLoader;
                }
                DeprecatedBridgeFontResourceLoader deprecatedBridgeFontResourceLoader = new DeprecatedBridgeFontResourceLoader(resolver, null);
                companion.getCache().put(resolver, deprecatedBridgeFontResourceLoader);
                return deprecatedBridgeFontResourceLoader;
            }
        }

        @NotNull
        public final Map<FontFamily.Resolver, Font.ResourceLoader> getCache() {
            return DeprecatedBridgeFontResourceLoader.cache;
        }

        @NotNull
        public final SynchronizedObject getLock() {
            return DeprecatedBridgeFontResourceLoader.lock;
        }

        public final void setCache(@NotNull Map<FontFamily.Resolver, Font.ResourceLoader> map) {
            Intrinsics.checkNotNullParameter(map, "<set-?>");
            DeprecatedBridgeFontResourceLoader.cache = map;
        }
    }

    private DeprecatedBridgeFontResourceLoader(FontFamily.Resolver resolver) {
        this.fontFamilyResolver = resolver;
    }

    public /* synthetic */ DeprecatedBridgeFontResourceLoader(FontFamily.Resolver resolver, DefaultConstructorMarker defaultConstructorMarker) {
        this(resolver);
    }

    @Override // androidx.compose.ui.text.font.Font.ResourceLoader
    @Deprecated(message = "Replaced by FontFamily.Resolver, this method should not be called", replaceWith = @ReplaceWith(expression = "FontFamily.Resolver.resolve(font, )", imports = {}))
    @NotNull
    public Object load(@NotNull Font font) {
        Intrinsics.checkNotNullParameter(font, "font");
        return po1.a(this.fontFamilyResolver, FontKt.toFontFamily(font), font.getWeight(), font.mo4790getStyle_LCdwA(), 0, 8, (Object) null).getValue();
    }
}
