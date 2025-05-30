package androidx.compose.ui.text;

import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontKt;
import androidx.compose.ui.text.platform.Synchronization_jvmKt;
import androidx.compose.ui.text.platform.SynchronizedObject;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tb.po1;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class DeprecatedBridgeFontResourceLoader implements Font.ResourceLoader {

    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @NotNull
    private static Map<FontFamily.Resolver, Font.ResourceLoader> cache = new LinkedHashMap();

    @NotNull
    private static final SynchronizedObject lock = Synchronization_jvmKt.createSynchronizedObject();

    @NotNull
    private final FontFamily.Resolver fontFamilyResolver;

    private DeprecatedBridgeFontResourceLoader(FontFamily.Resolver resolver) {
        this.fontFamilyResolver = resolver;
    }

    public /* synthetic */ DeprecatedBridgeFontResourceLoader(FontFamily.Resolver resolver, DefaultConstructorMarker defaultConstructorMarker) {
        this(resolver);
    }

    @Deprecated(message = "Replaced by FontFamily.Resolver, this method should not be called", replaceWith = @ReplaceWith(expression = "FontFamily.Resolver.resolve(font, )", imports = {}))
    @NotNull
    public Object load(@NotNull Font font) {
        Intrinsics.checkNotNullParameter(font, "font");
        return po1.a(this.fontFamilyResolver, FontKt.toFontFamily(font), font.getWeight(), font.getStyle-_-LCdwA(), 0, 8, (Object) null).getValue();
    }
}
