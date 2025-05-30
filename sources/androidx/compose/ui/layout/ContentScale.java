package androidx.compose.ui.layout;

import androidx.compose.runtime.Stable;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Stable
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public interface ContentScale {

    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;

    /* compiled from: Taobao */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        @NotNull
        private static final ContentScale Crop = new ContentScale() { // from class: androidx.compose.ui.layout.ContentScale$Companion$Crop$1
            @Override // androidx.compose.ui.layout.ContentScale
            /* renamed from: computeScaleFactor-H7hwNQA */
            public long mo1512computeScaleFactorH7hwNQA(long j, long j2) {
                float m1518computeFillMaxDimensioniLBOSCw;
                m1518computeFillMaxDimensioniLBOSCw = ContentScaleKt.m1518computeFillMaxDimensioniLBOSCw(j, j2);
                return ScaleFactorKt.ScaleFactor(m1518computeFillMaxDimensioniLBOSCw, m1518computeFillMaxDimensioniLBOSCw);
            }
        };

        @NotNull
        private static final ContentScale Fit = new ContentScale() { // from class: androidx.compose.ui.layout.ContentScale$Companion$Fit$1
            @Override // androidx.compose.ui.layout.ContentScale
            /* renamed from: computeScaleFactor-H7hwNQA */
            public long mo1512computeScaleFactorH7hwNQA(long j, long j2) {
                float m1519computeFillMinDimensioniLBOSCw;
                m1519computeFillMinDimensioniLBOSCw = ContentScaleKt.m1519computeFillMinDimensioniLBOSCw(j, j2);
                return ScaleFactorKt.ScaleFactor(m1519computeFillMinDimensioniLBOSCw, m1519computeFillMinDimensioniLBOSCw);
            }
        };

        @NotNull
        private static final ContentScale FillHeight = new FillHeight.1();

        @NotNull
        private static final ContentScale FillWidth = new FillWidth.1();

        @NotNull
        private static final ContentScale Inside = new Inside.1();

        @NotNull
        private static final FixedScale None = new FixedScale(1.0f);

        @NotNull
        private static final ContentScale FillBounds = new ContentScale() { // from class: androidx.compose.ui.layout.ContentScale$Companion$FillBounds$1
            @Override // androidx.compose.ui.layout.ContentScale
            /* renamed from: computeScaleFactor-H7hwNQA */
            public long mo1512computeScaleFactorH7hwNQA(long j, long j2) {
                float m1520computeFillWidthiLBOSCw;
                float m1517computeFillHeightiLBOSCw;
                m1520computeFillWidthiLBOSCw = ContentScaleKt.m1520computeFillWidthiLBOSCw(j, j2);
                m1517computeFillHeightiLBOSCw = ContentScaleKt.m1517computeFillHeightiLBOSCw(j, j2);
                return ScaleFactorKt.ScaleFactor(m1520computeFillWidthiLBOSCw, m1517computeFillHeightiLBOSCw);
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
    long mo1512computeScaleFactorH7hwNQA(long j, long j2);
}
