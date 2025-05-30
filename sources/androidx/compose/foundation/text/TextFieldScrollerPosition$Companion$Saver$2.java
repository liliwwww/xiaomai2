package androidx.compose.foundation.text;

import androidx.compose.foundation.gestures.Orientation;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class TextFieldScrollerPosition$Companion$Saver$2 extends Lambda implements Function1<List<? extends Object>, TextFieldScrollerPosition> {
    public static final TextFieldScrollerPosition$Companion$Saver$2 INSTANCE = new TextFieldScrollerPosition$Companion$Saver$2();

    TextFieldScrollerPosition$Companion$Saver$2() {
        super(1);
    }

    @Nullable
    public final TextFieldScrollerPosition invoke(@NotNull List<? extends Object> list) {
        Intrinsics.checkNotNullParameter(list, "restored");
        Object obj = list.get(1);
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
        Orientation orientation = ((Boolean) obj).booleanValue() ? Orientation.Vertical : Orientation.Horizontal;
        Object obj2 = list.get(0);
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Float");
        return new TextFieldScrollerPosition(orientation, ((Float) obj2).floatValue());
    }
}
