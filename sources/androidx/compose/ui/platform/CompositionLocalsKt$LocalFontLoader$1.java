package androidx.compose.ui.platform;

import androidx.compose.ui.text.font.Font;
import kotlin.KotlinNothingValueException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class CompositionLocalsKt$LocalFontLoader$1 extends Lambda implements Function0<Font.ResourceLoader> {
    public static final CompositionLocalsKt$LocalFontLoader$1 INSTANCE = new CompositionLocalsKt$LocalFontLoader$1();

    CompositionLocalsKt$LocalFontLoader$1() {
        super(0);
    }

    @NotNull
    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final Font.ResourceLoader m2211invoke() {
        CompositionLocalsKt.access$noLocalProvidedFor("LocalFontLoader");
        throw new KotlinNothingValueException();
    }
}
