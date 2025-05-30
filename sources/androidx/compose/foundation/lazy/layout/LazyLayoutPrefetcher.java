package androidx.compose.foundation.lazy.layout;

import android.os.Trace;
import android.view.Choreographer;
import android.view.Display;
import android.view.View;
import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.layout.SubcomposeLayoutState;
import androidx.compose.ui.layout.SubcomposeLayoutState$PrecomposedSlotHandle;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@ExperimentalFoundationApi
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class LazyLayoutPrefetcher implements Choreographer.FrameCallback, LazyLayoutPrefetchState.Prefetcher, RememberObserver, Runnable {

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static long frameIntervalNs;
    private long averagePrecomposeTimeNs;
    private long averagePremeasureTimeNs;
    private final Choreographer choreographer;
    private boolean isActive;

    @NotNull
    private final LazyLayoutItemContentFactory itemContentFactory;

    @NotNull
    private final MutableVector<PrefetchRequest> prefetchRequests;
    private boolean prefetchScheduled;

    @NotNull
    private final LazyLayoutPrefetchState prefetchState;

    @NotNull
    private final SubcomposeLayoutState subcomposeLayoutState;

    @NotNull
    private final View view;

    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void calculateFrameIntervalIfNeeded(View view) {
            if (LazyLayoutPrefetcher.frameIntervalNs == 0) {
                Display display = view.getDisplay();
                float f = 60.0f;
                if (!view.isInEditMode() && display != null) {
                    float refreshRate = display.getRefreshRate();
                    if (refreshRate >= 30.0f) {
                        f = refreshRate;
                    }
                }
                LazyLayoutPrefetcher.frameIntervalNs = (long) (1000000000 / f);
            }
        }
    }

    /* compiled from: Taobao */
    private static final class PrefetchRequest implements LazyLayoutPrefetchState.PrefetchHandle {
        private boolean canceled;
        private final long constraints;
        private final int index;
        private boolean measured;

        @Nullable
        private SubcomposeLayoutState$PrecomposedSlotHandle precomposeHandle;

        private PrefetchRequest(int i, long j) {
            this.index = i;
            this.constraints = j;
        }

        public /* synthetic */ PrefetchRequest(int i, long j, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, j);
        }

        public void cancel() {
            if (this.canceled) {
                return;
            }
            this.canceled = true;
            SubcomposeLayoutState$PrecomposedSlotHandle subcomposeLayoutState$PrecomposedSlotHandle = this.precomposeHandle;
            if (subcomposeLayoutState$PrecomposedSlotHandle != null) {
                subcomposeLayoutState$PrecomposedSlotHandle.dispose();
            }
            this.precomposeHandle = null;
        }

        public final boolean getCanceled() {
            return this.canceled;
        }

        /* renamed from: getConstraints-msEJaDk, reason: not valid java name */
        public final long m492getConstraintsmsEJaDk() {
            return this.constraints;
        }

        public final int getIndex() {
            return this.index;
        }

        public final boolean getMeasured() {
            return this.measured;
        }

        @Nullable
        public final SubcomposeLayoutState$PrecomposedSlotHandle getPrecomposeHandle() {
            return this.precomposeHandle;
        }

        public final void setCanceled(boolean z) {
            this.canceled = z;
        }

        public final void setMeasured(boolean z) {
            this.measured = z;
        }

        public final void setPrecomposeHandle(@Nullable SubcomposeLayoutState$PrecomposedSlotHandle subcomposeLayoutState$PrecomposedSlotHandle) {
            this.precomposeHandle = subcomposeLayoutState$PrecomposedSlotHandle;
        }
    }

    public LazyLayoutPrefetcher(@NotNull LazyLayoutPrefetchState lazyLayoutPrefetchState, @NotNull SubcomposeLayoutState subcomposeLayoutState, @NotNull LazyLayoutItemContentFactory lazyLayoutItemContentFactory, @NotNull View view) {
        Intrinsics.checkNotNullParameter(lazyLayoutPrefetchState, "prefetchState");
        Intrinsics.checkNotNullParameter(subcomposeLayoutState, "subcomposeLayoutState");
        Intrinsics.checkNotNullParameter(lazyLayoutItemContentFactory, "itemContentFactory");
        Intrinsics.checkNotNullParameter(view, "view");
        this.prefetchState = lazyLayoutPrefetchState;
        this.subcomposeLayoutState = subcomposeLayoutState;
        this.itemContentFactory = lazyLayoutItemContentFactory;
        this.view = view;
        this.prefetchRequests = new MutableVector<>(new PrefetchRequest[16], 0);
        this.choreographer = Choreographer.getInstance();
        Companion.calculateFrameIntervalIfNeeded(view);
    }

    private final long calculateAverageTime(long j, long j2) {
        if (j2 == 0) {
            return j;
        }
        long j3 = 4;
        return (j / j3) + ((j2 / j3) * 3);
    }

    private final boolean enoughTimeLeft(long j, long j2, long j3) {
        return j > j2 || j + j3 < j2;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        if (this.isActive) {
            this.view.post(this);
        }
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onAbandoned() {
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onForgotten() {
        this.isActive = false;
        this.prefetchState.setPrefetcher$foundation_release(null);
        this.view.removeCallbacks(this);
        this.choreographer.removeFrameCallback(this);
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onRemembered() {
        this.prefetchState.setPrefetcher$foundation_release(this);
        this.isActive = true;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.prefetchRequests.isEmpty() || !this.prefetchScheduled || !this.isActive || this.view.getWindowVisibility() != 0) {
            this.prefetchScheduled = false;
            return;
        }
        long nanos = TimeUnit.MILLISECONDS.toNanos(this.view.getDrawingTime()) + frameIntervalNs;
        boolean z = false;
        while (this.prefetchRequests.isNotEmpty() && !z) {
            PrefetchRequest prefetchRequest = this.prefetchRequests.getContent()[0];
            LazyLayoutItemProvider lazyLayoutItemProvider = (LazyLayoutItemProvider) this.itemContentFactory.getItemProvider().invoke();
            if (!prefetchRequest.getCanceled()) {
                int itemCount = lazyLayoutItemProvider.getItemCount();
                int index = prefetchRequest.getIndex();
                if (index >= 0 && index < itemCount) {
                    if (prefetchRequest.getPrecomposeHandle() == null) {
                        Trace.beginSection("compose:lazylist:prefetch:compose");
                        try {
                            long nanoTime = System.nanoTime();
                            if (enoughTimeLeft(nanoTime, nanos, this.averagePrecomposeTimeNs)) {
                                Object key = lazyLayoutItemProvider.getKey(prefetchRequest.getIndex());
                                prefetchRequest.setPrecomposeHandle(this.subcomposeLayoutState.precompose(key, this.itemContentFactory.getContent(prefetchRequest.getIndex(), key)));
                                this.averagePrecomposeTimeNs = calculateAverageTime(System.nanoTime() - nanoTime, this.averagePrecomposeTimeNs);
                            } else {
                                z = true;
                            }
                            Unit unit = Unit.INSTANCE;
                        } finally {
                        }
                    } else {
                        if (!(!prefetchRequest.getMeasured())) {
                            throw new IllegalStateException("Check failed.".toString());
                        }
                        Trace.beginSection("compose:lazylist:prefetch:measure");
                        try {
                            long nanoTime2 = System.nanoTime();
                            if (enoughTimeLeft(nanoTime2, nanos, this.averagePremeasureTimeNs)) {
                                SubcomposeLayoutState$PrecomposedSlotHandle precomposeHandle = prefetchRequest.getPrecomposeHandle();
                                Intrinsics.checkNotNull(precomposeHandle);
                                int placeablesCount = precomposeHandle.getPlaceablesCount();
                                for (int i = 0; i < placeablesCount; i++) {
                                    precomposeHandle.m2090premeasure0kLqBqw(i, prefetchRequest.m492getConstraintsmsEJaDk());
                                }
                                this.averagePremeasureTimeNs = calculateAverageTime(System.nanoTime() - nanoTime2, this.averagePremeasureTimeNs);
                                this.prefetchRequests.removeAt(0);
                            } else {
                                Unit unit2 = Unit.INSTANCE;
                                z = true;
                            }
                        } finally {
                        }
                    }
                }
            }
            this.prefetchRequests.removeAt(0);
        }
        if (z) {
            this.choreographer.postFrameCallback(this);
        } else {
            this.prefetchScheduled = false;
        }
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState.Prefetcher
    @NotNull
    /* renamed from: schedulePrefetch-0kLqBqw */
    public LazyLayoutPrefetchState.PrefetchHandle mo491schedulePrefetch0kLqBqw(int i, long j) {
        PrefetchRequest prefetchRequest = new PrefetchRequest(i, j, null);
        this.prefetchRequests.add(prefetchRequest);
        if (!this.prefetchScheduled) {
            this.prefetchScheduled = true;
            this.view.post(this);
        }
        return prefetchRequest;
    }
}
