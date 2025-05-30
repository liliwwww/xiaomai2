package androidx.compose.p004ui.graphics;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Immutable
/* loaded from: classes.dex */
public final class ColorFilter {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private final android.graphics.ColorFilter nativeColorFilter;

    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: tint-xETnrds$default, reason: not valid java name */
        public static /* synthetic */ ColorFilter m2828tintxETnrds$default(Companion companion, long j, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                i = BlendMode.Companion.m2735getSrcIn0nO6VwU();
            }
            return companion.m2831tintxETnrds(j, i);
        }

        @Stable
        @NotNull
        /* renamed from: colorMatrix-jHG-Opc, reason: not valid java name */
        public final ColorFilter m2829colorMatrixjHGOpc(@NotNull float[] fArr) {
            Intrinsics.checkNotNullParameter(fArr, "colorMatrix");
            return AndroidColorFilter_androidKt.m2662actualColorMatrixColorFilterjHGOpc(fArr);
        }

        @Stable
        @NotNull
        /* renamed from: lighting--OWjLjI, reason: not valid java name */
        public final ColorFilter m2830lightingOWjLjI(long j, long j2) {
            return AndroidColorFilter_androidKt.m2663actualLightingColorFilterOWjLjI(j, j2);
        }

        @Stable
        @NotNull
        /* renamed from: tint-xETnrds, reason: not valid java name */
        public final ColorFilter m2831tintxETnrds(long j, int i) {
            return AndroidColorFilter_androidKt.m2664actualTintColorFilterxETnrds(j, i);
        }
    }

    public ColorFilter(@NotNull android.graphics.ColorFilter colorFilter) {
        Intrinsics.checkNotNullParameter(colorFilter, "nativeColorFilter");
        this.nativeColorFilter = colorFilter;
    }

    @NotNull
    public final android.graphics.ColorFilter getNativeColorFilter$ui_graphics_release() {
        return this.nativeColorFilter;
    }
}
