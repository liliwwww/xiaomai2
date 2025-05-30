package androidx.compose.p004ui.graphics;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface PathEffect {

    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public static /* synthetic */ PathEffect dashPathEffect$default(Companion companion, float[] fArr, float f, int i, Object obj) {
            if ((i & 2) != 0) {
                f = 0.0f;
            }
            return companion.dashPathEffect(fArr, f);
        }

        @NotNull
        public final PathEffect chainPathEffect(@NotNull PathEffect pathEffect, @NotNull PathEffect pathEffect2) {
            Intrinsics.checkNotNullParameter(pathEffect, "outer");
            Intrinsics.checkNotNullParameter(pathEffect2, "inner");
            return AndroidPathEffect_androidKt.actualChainPathEffect(pathEffect, pathEffect2);
        }

        @NotNull
        public final PathEffect cornerPathEffect(float f) {
            return AndroidPathEffect_androidKt.actualCornerPathEffect(f);
        }

        @NotNull
        public final PathEffect dashPathEffect(@NotNull float[] fArr, float f) {
            Intrinsics.checkNotNullParameter(fArr, "intervals");
            return AndroidPathEffect_androidKt.actualDashPathEffect(fArr, f);
        }

        @NotNull
        /* renamed from: stampedPathEffect-7aD1DOk, reason: not valid java name */
        public final PathEffect m3022stampedPathEffect7aD1DOk(@NotNull Path path, float f, float f2, int i) {
            Intrinsics.checkNotNullParameter(path, "shape");
            return AndroidPathEffect_androidKt.m2693actualStampedPathEffect7aD1DOk(path, f, f2, i);
        }
    }
}
