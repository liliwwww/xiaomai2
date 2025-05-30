package androidx.compose.p004ui.layout;

import androidx.compose.p004ui.geometry.Size;
import androidx.compose.runtime.Stable;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Stable
/* loaded from: classes.dex */
public interface ContentScale {

    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;

    /* compiled from: Taobao */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        @NotNull
        private static final ContentScale Crop = new ContentScale() { // from class: androidx.compose.ui.layout.ContentScale$Companion$Crop$1
            @Override // androidx.compose.p004ui.layout.ContentScale
            /* renamed from: computeScaleFactor-H7hwNQA */
            public long mo4178computeScaleFactorH7hwNQA(long j, long j2) {
                float m4184computeFillMaxDimensioniLBOSCw;
                m4184computeFillMaxDimensioniLBOSCw = ContentScaleKt.m4184computeFillMaxDimensioniLBOSCw(j, j2);
                return ScaleFactorKt.ScaleFactor(m4184computeFillMaxDimensioniLBOSCw, m4184computeFillMaxDimensioniLBOSCw);
            }
        };

        @NotNull
        private static final ContentScale Fit = new ContentScale() { // from class: androidx.compose.ui.layout.ContentScale$Companion$Fit$1
            @Override // androidx.compose.p004ui.layout.ContentScale
            /* renamed from: computeScaleFactor-H7hwNQA */
            public long mo4178computeScaleFactorH7hwNQA(long j, long j2) {
                float m4185computeFillMinDimensioniLBOSCw;
                m4185computeFillMinDimensioniLBOSCw = ContentScaleKt.m4185computeFillMinDimensioniLBOSCw(j, j2);
                return ScaleFactorKt.ScaleFactor(m4185computeFillMinDimensioniLBOSCw, m4185computeFillMinDimensioniLBOSCw);
            }
        };

        @NotNull
        private static final ContentScale FillHeight = new ContentScale() { // from class: androidx.compose.ui.layout.ContentScale$Companion$FillHeight$1
            @Override // androidx.compose.p004ui.layout.ContentScale
            /* renamed from: computeScaleFactor-H7hwNQA */
            public long mo4178computeScaleFactorH7hwNQA(long j, long j2) {
                float m4183computeFillHeightiLBOSCw;
                m4183computeFillHeightiLBOSCw = ContentScaleKt.m4183computeFillHeightiLBOSCw(j, j2);
                return ScaleFactorKt.ScaleFactor(m4183computeFillHeightiLBOSCw, m4183computeFillHeightiLBOSCw);
            }
        };

        @NotNull
        private static final ContentScale FillWidth = new ContentScale() { // from class: androidx.compose.ui.layout.ContentScale$Companion$FillWidth$1
            @Override // androidx.compose.p004ui.layout.ContentScale
            /* renamed from: computeScaleFactor-H7hwNQA */
            public long mo4178computeScaleFactorH7hwNQA(long j, long j2) {
                float m4186computeFillWidthiLBOSCw;
                m4186computeFillWidthiLBOSCw = ContentScaleKt.m4186computeFillWidthiLBOSCw(j, j2);
                return ScaleFactorKt.ScaleFactor(m4186computeFillWidthiLBOSCw, m4186computeFillWidthiLBOSCw);
            }
        };

        @NotNull
        private static final ContentScale Inside = new ContentScale() { // from class: androidx.compose.ui.layout.ContentScale$Companion$Inside$1
            @Override // androidx.compose.p004ui.layout.ContentScale
            /* renamed from: computeScaleFactor-H7hwNQA */
            public long mo4178computeScaleFactorH7hwNQA(long j, long j2) {
                float m4185computeFillMinDimensioniLBOSCw;
                if (Size.m2625getWidthimpl(j) <= Size.m2625getWidthimpl(j2) && Size.m2622getHeightimpl(j) <= Size.m2622getHeightimpl(j2)) {
                    return ScaleFactorKt.ScaleFactor(1.0f, 1.0f);
                }
                m4185computeFillMinDimensioniLBOSCw = ContentScaleKt.m4185computeFillMinDimensioniLBOSCw(j, j2);
                return ScaleFactorKt.ScaleFactor(m4185computeFillMinDimensioniLBOSCw, m4185computeFillMinDimensioniLBOSCw);
            }
        };

        @NotNull
        private static final FixedScale None = new FixedScale(1.0f);

        @NotNull
        private static final ContentScale FillBounds = new ContentScale() { // from class: androidx.compose.ui.layout.ContentScale$Companion$FillBounds$1
            @Override // androidx.compose.p004ui.layout.ContentScale
            /* renamed from: computeScaleFactor-H7hwNQA */
            public long mo4178computeScaleFactorH7hwNQA(long j, long j2) {
                float m4186computeFillWidthiLBOSCw;
                float m4183computeFillHeightiLBOSCw;
                m4186computeFillWidthiLBOSCw = ContentScaleKt.m4186computeFillWidthiLBOSCw(j, j2);
                m4183computeFillHeightiLBOSCw = ContentScaleKt.m4183computeFillHeightiLBOSCw(j, j2);
                return ScaleFactorKt.ScaleFactor(m4186computeFillWidthiLBOSCw, m4183computeFillHeightiLBOSCw);
            }
        };

        private Companion() {
        }

        @Stable
        public static /* synthetic */ void getCrop$annotations() {
        }

        @Stable
        public static /* synthetic */ void getFillBounds$annotations() {
        }

        @Stable
        public static /* synthetic */ void getFillHeight$annotations() {
        }

        @Stable
        public static /* synthetic */ void getFillWidth$annotations() {
        }

        @Stable
        public static /* synthetic */ void getFit$annotations() {
        }

        @Stable
        public static /* synthetic */ void getInside$annotations() {
        }

        @Stable
        public static /* synthetic */ void getNone$annotations() {
        }

        @NotNull
        public final ContentScale getCrop() {
            return Crop;
        }

        @NotNull
        public final ContentScale getFillBounds() {
            return FillBounds;
        }

        @NotNull
        public final ContentScale getFillHeight() {
            return FillHeight;
        }

        @NotNull
        public final ContentScale getFillWidth() {
            return FillWidth;
        }

        @NotNull
        public final ContentScale getFit() {
            return Fit;
        }

        @NotNull
        public final ContentScale getInside() {
            return Inside;
        }

        @NotNull
        public final FixedScale getNone() {
            return None;
        }
    }

    /* renamed from: computeScaleFactor-H7hwNQA, reason: not valid java name */
    long mo4178computeScaleFactorH7hwNQA(long j, long j2);
}
