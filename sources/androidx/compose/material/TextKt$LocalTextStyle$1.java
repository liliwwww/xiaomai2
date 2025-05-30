package androidx.compose.material;

import androidx.compose.ui.text.TextStyle;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class TextKt$LocalTextStyle$1 extends Lambda implements Function0<TextStyle> {
    public static final TextKt$LocalTextStyle$1 INSTANCE = new TextKt$LocalTextStyle$1();

    TextKt$LocalTextStyle$1() {
        super(0);
    }

    @NotNull
    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final TextStyle m698invoke() {
        return TextStyle.Companion.getDefault();
    }
}
