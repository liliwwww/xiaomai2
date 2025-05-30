package androidx.compose.ui.text.font;

import androidx.compose.runtime.Immutable;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Immutable
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public interface Font {

    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final long MaximumAsyncTimeout = 15000;

    /* compiled from: Taobao */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final long MaximumAsyncTimeout = 15000;

        private Companion() {
        }
    }

    /* compiled from: Taobao */
    @Deprecated(message = "Replaced with FontFamily.Resolver during the introduction of async fonts, all usages should be replaced. Custom subclasses can be converted into a FontFamily.Resolver by calling createFontFamilyResolver(myFontFamilyResolver, context)")
    public interface ResourceLoader {
        @Deprecated(message = "Replaced by FontFamily.Resolver, this method should not be called", replaceWith = @ReplaceWith(expression = "FontFamily.Resolver.resolve(font, )", imports = {}))
        @NotNull
        Object load(@NotNull Font font);
    }

    /* renamed from: getLoadingStrategy-PKNRLFQ */
    int mo1897getLoadingStrategyPKNRLFQ();

    /* renamed from: getStyle-_-LCdwA */
    int mo1915getStyle_LCdwA();

    @NotNull
    FontWeight getWeight();
}
