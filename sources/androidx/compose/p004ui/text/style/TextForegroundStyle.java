package androidx.compose.p004ui.text.style;

import androidx.compose.p004ui.graphics.Brush;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.graphics.ShaderBrush;
import androidx.compose.p004ui.graphics.SolidColor;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface TextForegroundStyle {

    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;

    /* compiled from: Taobao */
    /* renamed from: androidx.compose.ui.text.style.TextForegroundStyle$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        @NotNull
        /* renamed from: a */
        public static TextForegroundStyle m170a(@NotNull final TextForegroundStyle _this, TextForegroundStyle textForegroundStyle) {
            float takeOrElse;
            Intrinsics.checkNotNullParameter(textForegroundStyle, "other");
            boolean z = textForegroundStyle instanceof BrushStyle;
            if (!z || !(_this instanceof BrushStyle)) {
                return (!z || (_this instanceof BrushStyle)) ? (z || !(_this instanceof BrushStyle)) ? textForegroundStyle.takeOrElse(new Function0<TextForegroundStyle>() { // from class: androidx.compose.ui.text.style.TextForegroundStyle$merge$2
                    {
                        super(0);
                    }

                    @NotNull
                    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                    public final TextForegroundStyle m5100invoke() {
                        return TextForegroundStyle.this;
                    }
                }) : _this : textForegroundStyle;
            }
            ShaderBrush value = ((BrushStyle) textForegroundStyle).getValue();
            takeOrElse = TextDrawStyleKt.takeOrElse(textForegroundStyle.getAlpha(), new Function0<Float>() { // from class: androidx.compose.ui.text.style.TextForegroundStyle$merge$1
                {
                    super(0);
                }

                @NotNull
                /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final Float m5099invoke() {
                    return Float.valueOf(TextForegroundStyle.this.getAlpha());
                }
            });
            return new BrushStyle(value, takeOrElse);
        }

        @NotNull
        /* renamed from: b */
        public static TextForegroundStyle m171b(@NotNull TextForegroundStyle _this, Function0 function0) {
            Intrinsics.checkNotNullParameter(function0, "other");
            return !Intrinsics.areEqual(_this, Unspecified.INSTANCE) ? _this : (TextForegroundStyle) function0.invoke();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        @NotNull
        public final TextForegroundStyle from(@Nullable Brush brush, float f) {
            if (brush == null) {
                return Unspecified.INSTANCE;
            }
            if (brush instanceof SolidColor) {
                return m5098from8_81llA(TextDrawStyleKt.m5097modulateDxMtmZc(((SolidColor) brush).m3074getValue0d7_KjU(), f));
            }
            if (brush instanceof ShaderBrush) {
                return new BrushStyle((ShaderBrush) brush, f);
            }
            throw new NoWhenBranchMatchedException();
        }

        @NotNull
        /* renamed from: from-8_81llA, reason: not valid java name */
        public final TextForegroundStyle m5098from8_81llA(long j) {
            return (j > Color.Companion.m2823getUnspecified0d7_KjU() ? 1 : (j == Color.Companion.m2823getUnspecified0d7_KjU() ? 0 : -1)) != 0 ? new ColorStyle(j, null) : Unspecified.INSTANCE;
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

        @Override // androidx.compose.p004ui.text.style.TextForegroundStyle
        public float getAlpha() {
            return Float.NaN;
        }

        @Override // androidx.compose.p004ui.text.style.TextForegroundStyle
        @Nullable
        public Brush getBrush() {
            return null;
        }

        @Override // androidx.compose.p004ui.text.style.TextForegroundStyle
        /* renamed from: getColor-0d7_KjU */
        public long mo5002getColor0d7_KjU() {
            return Color.Companion.m2823getUnspecified0d7_KjU();
        }

        @Override // androidx.compose.p004ui.text.style.TextForegroundStyle
        public /* synthetic */ TextForegroundStyle merge(TextForegroundStyle textForegroundStyle) {
            return CC.m170a(this, textForegroundStyle);
        }

        @Override // androidx.compose.p004ui.text.style.TextForegroundStyle
        public /* synthetic */ TextForegroundStyle takeOrElse(Function0 function0) {
            return CC.m171b(this, function0);
        }
    }

    float getAlpha();

    @Nullable
    Brush getBrush();

    /* renamed from: getColor-0d7_KjU */
    long mo5002getColor0d7_KjU();

    @NotNull
    TextForegroundStyle merge(@NotNull TextForegroundStyle textForegroundStyle);

    @NotNull
    TextForegroundStyle takeOrElse(@NotNull Function0<? extends TextForegroundStyle> function0);
}
