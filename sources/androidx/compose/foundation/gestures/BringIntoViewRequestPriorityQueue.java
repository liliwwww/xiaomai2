package androidx.compose.foundation.gestures;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.geometry.Rect;
import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.CancellableContinuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class BringIntoViewRequestPriorityQueue {

    @NotNull
    private final MutableVector<ContentInViewModifier$Request> requests = new MutableVector<>(new ContentInViewModifier$Request[16], 0);

    public final void cancelAndRemoveAll(@Nullable Throwable th) {
        MutableVector<ContentInViewModifier$Request> mutableVector = this.requests;
        int size = mutableVector.getSize();
        CancellableContinuation[] cancellableContinuationArr = new CancellableContinuation[size];
        for (int i = 0; i < size; i++) {
            cancellableContinuationArr[i] = mutableVector.getContent()[i].getContinuation();
        }
        for (int i2 = 0; i2 < size; i2++) {
            cancellableContinuationArr[i2].cancel(th);
        }
        if (!this.requests.isEmpty()) {
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    public final boolean enqueue(@NotNull ContentInViewModifier$Request contentInViewModifier$Request) {
        Intrinsics.checkNotNullParameter(contentInViewModifier$Request, "request");
        Rect rect = (Rect) contentInViewModifier$Request.getCurrentBounds().invoke();
        if (rect == null) {
            CancellableContinuation<Unit> continuation = contentInViewModifier$Request.getContinuation();
            Result.Companion companion = Result.Companion;
            continuation.resumeWith(Result.constructor-impl(Unit.INSTANCE));
            return false;
        }
        contentInViewModifier$Request.getContinuation().invokeOnCancellation(new enqueue.1(this, contentInViewModifier$Request));
        IntRange intRange = new IntRange(0, this.requests.getSize() - 1);
        int first = intRange.getFirst();
        int last = intRange.getLast();
        if (first <= last) {
            while (true) {
                Rect rect2 = (Rect) this.requests.getContent()[last].getCurrentBounds().invoke();
                if (rect2 != null) {
                    Rect intersect = rect.intersect(rect2);
                    if (Intrinsics.areEqual(intersect, rect)) {
                        this.requests.add(last + 1, contentInViewModifier$Request);
                        return true;
                    }
                    if (!Intrinsics.areEqual(intersect, rect2)) {
                        CancellationException cancellationException = new CancellationException("bringIntoView call interrupted by a newer, non-overlapping call");
                        int size = this.requests.getSize() - 1;
                        if (size <= last) {
                            while (true) {
                                this.requests.getContent()[last].getContinuation().cancel(cancellationException);
                                if (size == last) {
                                    break;
                                }
                                size++;
                            }
                        }
                    }
                }
                if (last == first) {
                    break;
                }
                last--;
            }
        }
        this.requests.add(0, contentInViewModifier$Request);
        return true;
    }

    public final void forEachFromSmallest(@NotNull Function1<? super Rect, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        MutableVector mutableVector = this.requests;
        int size = mutableVector.getSize();
        if (size > 0) {
            int i = size - 1;
            Object[] content = mutableVector.getContent();
            do {
                function1.invoke(((ContentInViewModifier$Request) content[i]).getCurrentBounds().invoke());
                i--;
            } while (i >= 0);
        }
    }

    public final int getSize() {
        return this.requests.getSize();
    }

    public final boolean isEmpty() {
        return this.requests.isEmpty();
    }

    public final void resumeAndRemoveAll() {
        IntRange intRange = new IntRange(0, this.requests.getSize() - 1);
        int first = intRange.getFirst();
        int last = intRange.getLast();
        if (first <= last) {
            while (true) {
                CancellableContinuation<Unit> continuation = this.requests.getContent()[first].getContinuation();
                Unit unit = Unit.INSTANCE;
                Result.Companion companion = Result.Companion;
                continuation.resumeWith(Result.constructor-impl(unit));
                if (first == last) {
                    break;
                } else {
                    first++;
                }
            }
        }
        this.requests.clear();
    }

    public final void resumeAndRemoveWhile(@NotNull Function1<? super Rect, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        while (this.requests.isNotEmpty() && ((Boolean) function1.invoke(((ContentInViewModifier$Request) this.requests.last()).getCurrentBounds().invoke())).booleanValue()) {
            CancellableContinuation<Unit> continuation = ((ContentInViewModifier$Request) this.requests.removeAt(this.requests.getSize() - 1)).getContinuation();
            Unit unit = Unit.INSTANCE;
            Result.Companion companion = Result.Companion;
            continuation.resumeWith(Result.constructor-impl(unit));
        }
    }
}
