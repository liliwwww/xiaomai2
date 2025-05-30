package androidx.compose.ui.text.style;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public interface TextForegroundStyle {

    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;

    /* compiled from: Taobao */
    /* renamed from: androidx.compose.ui.text.style.TextForegroundStyle$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        @NotNull
        public static TextForegroundStyle a(@NotNull TextForegroundStyle _this, TextForegroundStyle textForegroundStyle) {
            Intrinsics.checkNotNullParameter(textForegroundStyle, "other");
            boolean z = textForegroundStyle instanceof BrushStyle;
            return (z && (_this instanceof BrushStyle)) ? new BrushStyle(((BrushStyle) textForegroundStyle).getValue(), TextDrawStyleKt.access$takeOrElse(textForegroundStyle.getAlpha(), new merge.1(_this))) : (!z || (_this instanceof BrushStyle)) ? (z || !(_this instanceof BrushStyle)) ? textForegroundStyle.takeOrElse(new merge.2(_this)) : _this : textForegroundStyle;
        }

        @NotNull
        public static TextForegroundStyle b(@NotNull TextForegroundStyle _this, Function0 function0) {
            Intrinsics.checkNotNullParameter(function0, "other");
            return !Intrinsics.areEqual(_this, Unspecified.INSTANCE) ? _this : (TextForegroundStyle) function0.invoke();
        }
    }

    /* compiled from: Taobao */
    @StabilityInferred(parameters = 0)
    public static final class Unspecified implements TextForegroundStyle {
        public static final int $stable = 0;

        @NotNull
        public static final Unspecified INSTANCE = new Unspecified();

        private Unspecified() {
        }

        @Override // androidx.compose.ui.text.style.TextForegroundStyle
        public float getAlpha() {
            return Float.NaN;
        }

        @Override // androidx.compose.ui.text.style.TextForegroundStyle
        @Nullable
        public Brush getBrush() {
            return null;
        }

        @Override // androidx.compose.ui.text.style.TextForegroundStyle
        /* renamed from: getColor-0d7_KjU */
        public long mo2487getColor0d7_KjU() {
            return Color.Companion.m1084getUnspecified0d7_KjU();
        }

        @Override // androidx.compose.ui.text.style.TextForegroundStyle
        public /* synthetic */ TextForegroundStyle merge(TextForegroundStyle textForegroundStyle) {
            return CC.a(this, textForegroundStyle);
        }

        @Override // androidx.compose.ui.text.style.TextForegroundStyle
        public /* synthetic */ TextForegroundStyle takeOrElse(Function0 function0) {
            return CC.b(this, function0);
        }
    }

    float getAlpha();

    @Nullable
    Brush getBrush();

    /* renamed from: getColor-0d7_KjU */
    long mo2487getColor0d7_KjU();

    @NotNull
    TextForegroundStyle merge(@NotNull TextForegroundStyle textForegroundStyle);

    @NotNull
    TextForegroundStyle takeOrElse(@NotNull Function0<? extends TextForegroundStyle> function0);
}
