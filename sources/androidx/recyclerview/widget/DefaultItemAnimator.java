package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class DefaultItemAnimator extends SimpleItemAnimator {
    private static final boolean DEBUG = false;
    private static TimeInterpolator sDefaultInterpolator;
    private ArrayList<RecyclerView$ViewHolder> mPendingRemovals = new ArrayList<>();
    private ArrayList<RecyclerView$ViewHolder> mPendingAdditions = new ArrayList<>();
    private ArrayList<MoveInfo> mPendingMoves = new ArrayList<>();
    private ArrayList<ChangeInfo> mPendingChanges = new ArrayList<>();
    ArrayList<ArrayList<RecyclerView$ViewHolder>> mAdditionsList = new ArrayList<>();
    ArrayList<ArrayList<MoveInfo>> mMovesList = new ArrayList<>();
    ArrayList<ArrayList<ChangeInfo>> mChangesList = new ArrayList<>();
    ArrayList<RecyclerView$ViewHolder> mAddAnimations = new ArrayList<>();
    ArrayList<RecyclerView$ViewHolder> mMoveAnimations = new ArrayList<>();
    ArrayList<RecyclerView$ViewHolder> mRemoveAnimations = new ArrayList<>();
    ArrayList<RecyclerView$ViewHolder> mChangeAnimations = new ArrayList<>();

    /* compiled from: Taobao */
    private static class MoveInfo {
        public int fromX;
        public int fromY;
        public RecyclerView$ViewHolder holder;
        public int toX;
        public int toY;

        MoveInfo(RecyclerView$ViewHolder recyclerView$ViewHolder, int i, int i2, int i3, int i4) {
            this.holder = recyclerView$ViewHolder;
            this.fromX = i;
            this.fromY = i2;
            this.toX = i3;
            this.toY = i4;
        }
    }

    private void animateRemoveImpl(final RecyclerView$ViewHolder recyclerView$ViewHolder) {
        final View view = recyclerView$ViewHolder.itemView;
        final ViewPropertyAnimator animate = view.animate();
        this.mRemoveAnimations.add(recyclerView$ViewHolder);
        animate.setDuration(getRemoveDuration()).alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                animate.setListener(null);
                view.setAlpha(1.0f);
                DefaultItemAnimator.this.dispatchRemoveFinished(recyclerView$ViewHolder);
                DefaultItemAnimator.this.mRemoveAnimations.remove(recyclerView$ViewHolder);
                DefaultItemAnimator.this.dispatchFinishedWhenDone();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                DefaultItemAnimator.this.dispatchRemoveStarting(recyclerView$ViewHolder);
            }
        }).start();
    }

    private void endChangeAnimation(List<ChangeInfo> list, RecyclerView$ViewHolder recyclerView$ViewHolder) {
        for (int size = list.size() - 1; size >= 0; size--) {
            ChangeInfo changeInfo = list.get(size);
            if (endChangeAnimationIfNecessary(changeInfo, recyclerView$ViewHolder) && changeInfo.oldHolder == null && changeInfo.newHolder == null) {
                list.remove(changeInfo);
            }
        }
    }

    private void endChangeAnimationIfNecessary(ChangeInfo changeInfo) {
        RecyclerView$ViewHolder recyclerView$ViewHolder = changeInfo.oldHolder;
        if (recyclerView$ViewHolder != null) {
            endChangeAnimationIfNecessary(changeInfo, recyclerView$ViewHolder);
        }
        RecyclerView$ViewHolder recyclerView$ViewHolder2 = changeInfo.newHolder;
        if (recyclerView$ViewHolder2 != null) {
            endChangeAnimationIfNecessary(changeInfo, recyclerView$ViewHolder2);
        }
    }

    private void resetAnimation(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        if (sDefaultInterpolator == null) {
            sDefaultInterpolator = new ValueAnimator().getInterpolator();
        }
        recyclerView$ViewHolder.itemView.animate().setInterpolator(sDefaultInterpolator);
        endAnimation(recyclerView$ViewHolder);
    }

    public boolean animateAdd(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        resetAnimation(recyclerView$ViewHolder);
        recyclerView$ViewHolder.itemView.setAlpha(0.0f);
        this.mPendingAdditions.add(recyclerView$ViewHolder);
        return true;
    }

    void animateAddImpl(final RecyclerView$ViewHolder recyclerView$ViewHolder) {
        final View view = recyclerView$ViewHolder.itemView;
        final ViewPropertyAnimator animate = view.animate();
        this.mAddAnimations.add(recyclerView$ViewHolder);
        animate.alpha(1.0f).setDuration(getAddDuration()).setListener(new AnimatorListenerAdapter() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                view.setAlpha(1.0f);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                animate.setListener(null);
                DefaultItemAnimator.this.dispatchAddFinished(recyclerView$ViewHolder);
                DefaultItemAnimator.this.mAddAnimations.remove(recyclerView$ViewHolder);
                DefaultItemAnimator.this.dispatchFinishedWhenDone();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                DefaultItemAnimator.this.dispatchAddStarting(recyclerView$ViewHolder);
            }
        }).start();
    }

    public boolean animateChange(RecyclerView$ViewHolder recyclerView$ViewHolder, RecyclerView$ViewHolder recyclerView$ViewHolder2, int i, int i2, int i3, int i4) {
        if (recyclerView$ViewHolder == recyclerView$ViewHolder2) {
            return animateMove(recyclerView$ViewHolder, i, i2, i3, i4);
        }
        float translationX = recyclerView$ViewHolder.itemView.getTranslationX();
        float translationY = recyclerView$ViewHolder.itemView.getTranslationY();
        float alpha = recyclerView$ViewHolder.itemView.getAlpha();
        resetAnimation(recyclerView$ViewHolder);
        int i5 = (int) ((i3 - i) - translationX);
        int i6 = (int) ((i4 - i2) - translationY);
        recyclerView$ViewHolder.itemView.setTranslationX(translationX);
        recyclerView$ViewHolder.itemView.setTranslationY(translationY);
        recyclerView$ViewHolder.itemView.setAlpha(alpha);
        if (recyclerView$ViewHolder2 != null) {
            resetAnimation(recyclerView$ViewHolder2);
            recyclerView$ViewHolder2.itemView.setTranslationX(-i5);
            recyclerView$ViewHolder2.itemView.setTranslationY(-i6);
            recyclerView$ViewHolder2.itemView.setAlpha(0.0f);
        }
        this.mPendingChanges.add(new ChangeInfo(recyclerView$ViewHolder, recyclerView$ViewHolder2, i, i2, i3, i4));
        return true;
    }

    void animateChangeImpl(final ChangeInfo changeInfo) {
        RecyclerView$ViewHolder recyclerView$ViewHolder = changeInfo.oldHolder;
        final View view = recyclerView$ViewHolder == null ? null : recyclerView$ViewHolder.itemView;
        RecyclerView$ViewHolder recyclerView$ViewHolder2 = changeInfo.newHolder;
        final View view2 = recyclerView$ViewHolder2 != null ? recyclerView$ViewHolder2.itemView : null;
        if (view != null) {
            final ViewPropertyAnimator duration = view.animate().setDuration(getChangeDuration());
            this.mChangeAnimations.add(changeInfo.oldHolder);
            duration.translationX(changeInfo.toX - changeInfo.fromX);
            duration.translationY(changeInfo.toY - changeInfo.fromY);
            duration.alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.7
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    duration.setListener(null);
                    view.setAlpha(1.0f);
                    view.setTranslationX(0.0f);
                    view.setTranslationY(0.0f);
                    DefaultItemAnimator.this.dispatchChangeFinished(changeInfo.oldHolder, true);
                    DefaultItemAnimator.this.mChangeAnimations.remove(changeInfo.oldHolder);
                    DefaultItemAnimator.this.dispatchFinishedWhenDone();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    DefaultItemAnimator.this.dispatchChangeStarting(changeInfo.oldHolder, true);
                }
            }).start();
        }
        if (view2 != null) {
            final ViewPropertyAnimator animate = view2.animate();
            this.mChangeAnimations.add(changeInfo.newHolder);
            animate.translationX(0.0f).translationY(0.0f).setDuration(getChangeDuration()).alpha(1.0f).setListener(new AnimatorListenerAdapter() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.8
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    animate.setListener(null);
                    view2.setAlpha(1.0f);
                    view2.setTranslationX(0.0f);
                    view2.setTranslationY(0.0f);
                    DefaultItemAnimator.this.dispatchChangeFinished(changeInfo.newHolder, false);
                    DefaultItemAnimator.this.mChangeAnimations.remove(changeInfo.newHolder);
                    DefaultItemAnimator.this.dispatchFinishedWhenDone();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    DefaultItemAnimator.this.dispatchChangeStarting(changeInfo.newHolder, false);
                }
            }).start();
        }
    }

    public boolean animateMove(RecyclerView$ViewHolder recyclerView$ViewHolder, int i, int i2, int i3, int i4) {
        View view = recyclerView$ViewHolder.itemView;
        int translationX = i + ((int) view.getTranslationX());
        int translationY = i2 + ((int) recyclerView$ViewHolder.itemView.getTranslationY());
        resetAnimation(recyclerView$ViewHolder);
        int i5 = i3 - translationX;
        int i6 = i4 - translationY;
        if (i5 == 0 && i6 == 0) {
            dispatchMoveFinished(recyclerView$ViewHolder);
            return false;
        }
        if (i5 != 0) {
            view.setTranslationX(-i5);
        }
        if (i6 != 0) {
            view.setTranslationY(-i6);
        }
        this.mPendingMoves.add(new MoveInfo(recyclerView$ViewHolder, translationX, translationY, i3, i4));
        return true;
    }

    void animateMoveImpl(final RecyclerView$ViewHolder recyclerView$ViewHolder, int i, int i2, int i3, int i4) {
        final View view = recyclerView$ViewHolder.itemView;
        final int i5 = i3 - i;
        final int i6 = i4 - i2;
        if (i5 != 0) {
            view.animate().translationX(0.0f);
        }
        if (i6 != 0) {
            view.animate().translationY(0.0f);
        }
        final ViewPropertyAnimator animate = view.animate();
        this.mMoveAnimations.add(recyclerView$ViewHolder);
        animate.setDuration(getMoveDuration()).setListener(new AnimatorListenerAdapter() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                if (i5 != 0) {
                    view.setTranslationX(0.0f);
                }
                if (i6 != 0) {
                    view.setTranslationY(0.0f);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                animate.setListener(null);
                DefaultItemAnimator.this.dispatchMoveFinished(recyclerView$ViewHolder);
                DefaultItemAnimator.this.mMoveAnimations.remove(recyclerView$ViewHolder);
                DefaultItemAnimator.this.dispatchFinishedWhenDone();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                DefaultItemAnimator.this.dispatchMoveStarting(recyclerView$ViewHolder);
            }
        }).start();
    }

    public boolean animateRemove(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        resetAnimation(recyclerView$ViewHolder);
        this.mPendingRemovals.add(recyclerView$ViewHolder);
        return true;
    }

    public boolean canReuseUpdatedViewHolder(@NonNull RecyclerView$ViewHolder recyclerView$ViewHolder, @NonNull List<Object> list) {
        return !list.isEmpty() || super/*androidx.recyclerview.widget.RecyclerView.ItemAnimator*/.canReuseUpdatedViewHolder(recyclerView$ViewHolder, list);
    }

    void cancelAll(List<RecyclerView$ViewHolder> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            list.get(size).itemView.animate().cancel();
        }
    }

    void dispatchFinishedWhenDone() {
        if (isRunning()) {
            return;
        }
        dispatchAnimationsFinished();
    }

    public void endAnimation(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        View view = recyclerView$ViewHolder.itemView;
        view.animate().cancel();
        int size = this.mPendingMoves.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            if (this.mPendingMoves.get(size).holder == recyclerView$ViewHolder) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                dispatchMoveFinished(recyclerView$ViewHolder);
                this.mPendingMoves.remove(size);
            }
        }
        endChangeAnimation(this.mPendingChanges, recyclerView$ViewHolder);
        if (this.mPendingRemovals.remove(recyclerView$ViewHolder)) {
            view.setAlpha(1.0f);
            dispatchRemoveFinished(recyclerView$ViewHolder);
        }
        if (this.mPendingAdditions.remove(recyclerView$ViewHolder)) {
            view.setAlpha(1.0f);
            dispatchAddFinished(recyclerView$ViewHolder);
        }
        for (int size2 = this.mChangesList.size() - 1; size2 >= 0; size2--) {
            ArrayList<ChangeInfo> arrayList = this.mChangesList.get(size2);
            endChangeAnimation(arrayList, recyclerView$ViewHolder);
            if (arrayList.isEmpty()) {
                this.mChangesList.remove(size2);
            }
        }
        for (int size3 = this.mMovesList.size() - 1; size3 >= 0; size3--) {
            ArrayList<MoveInfo> arrayList2 = this.mMovesList.get(size3);
            int size4 = arrayList2.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                }
                if (arrayList2.get(size4).holder == recyclerView$ViewHolder) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    dispatchMoveFinished(recyclerView$ViewHolder);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.mMovesList.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        for (int size5 = this.mAdditionsList.size() - 1; size5 >= 0; size5--) {
            ArrayList<RecyclerView$ViewHolder> arrayList3 = this.mAdditionsList.get(size5);
            if (arrayList3.remove(recyclerView$ViewHolder)) {
                view.setAlpha(1.0f);
                dispatchAddFinished(recyclerView$ViewHolder);
                if (arrayList3.isEmpty()) {
                    this.mAdditionsList.remove(size5);
                }
            }
        }
        this.mRemoveAnimations.remove(recyclerView$ViewHolder);
        this.mAddAnimations.remove(recyclerView$ViewHolder);
        this.mChangeAnimations.remove(recyclerView$ViewHolder);
        this.mMoveAnimations.remove(recyclerView$ViewHolder);
        dispatchFinishedWhenDone();
    }

    public void endAnimations() {
        int size = this.mPendingMoves.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            MoveInfo moveInfo = this.mPendingMoves.get(size);
            View view = moveInfo.holder.itemView;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            dispatchMoveFinished(moveInfo.holder);
            this.mPendingMoves.remove(size);
        }
        for (int size2 = this.mPendingRemovals.size() - 1; size2 >= 0; size2--) {
            dispatchRemoveFinished(this.mPendingRemovals.get(size2));
            this.mPendingRemovals.remove(size2);
        }
        int size3 = this.mPendingAdditions.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView$ViewHolder recyclerView$ViewHolder = this.mPendingAdditions.get(size3);
            recyclerView$ViewHolder.itemView.setAlpha(1.0f);
            dispatchAddFinished(recyclerView$ViewHolder);
            this.mPendingAdditions.remove(size3);
        }
        for (int size4 = this.mPendingChanges.size() - 1; size4 >= 0; size4--) {
            endChangeAnimationIfNecessary(this.mPendingChanges.get(size4));
        }
        this.mPendingChanges.clear();
        if (isRunning()) {
            for (int size5 = this.mMovesList.size() - 1; size5 >= 0; size5--) {
                ArrayList<MoveInfo> arrayList = this.mMovesList.get(size5);
                for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                    MoveInfo moveInfo2 = arrayList.get(size6);
                    View view2 = moveInfo2.holder.itemView;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    dispatchMoveFinished(moveInfo2.holder);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.mMovesList.remove(arrayList);
                    }
                }
            }
            for (int size7 = this.mAdditionsList.size() - 1; size7 >= 0; size7--) {
                ArrayList<RecyclerView$ViewHolder> arrayList2 = this.mAdditionsList.get(size7);
                for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                    RecyclerView$ViewHolder recyclerView$ViewHolder2 = arrayList2.get(size8);
                    recyclerView$ViewHolder2.itemView.setAlpha(1.0f);
                    dispatchAddFinished(recyclerView$ViewHolder2);
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.mAdditionsList.remove(arrayList2);
                    }
                }
            }
            for (int size9 = this.mChangesList.size() - 1; size9 >= 0; size9--) {
                ArrayList<ChangeInfo> arrayList3 = this.mChangesList.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    endChangeAnimationIfNecessary(arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.mChangesList.remove(arrayList3);
                    }
                }
            }
            cancelAll(this.mRemoveAnimations);
            cancelAll(this.mMoveAnimations);
            cancelAll(this.mAddAnimations);
            cancelAll(this.mChangeAnimations);
            dispatchAnimationsFinished();
        }
    }

    public boolean isRunning() {
        return (this.mPendingAdditions.isEmpty() && this.mPendingChanges.isEmpty() && this.mPendingMoves.isEmpty() && this.mPendingRemovals.isEmpty() && this.mMoveAnimations.isEmpty() && this.mRemoveAnimations.isEmpty() && this.mAddAnimations.isEmpty() && this.mChangeAnimations.isEmpty() && this.mMovesList.isEmpty() && this.mAdditionsList.isEmpty() && this.mChangesList.isEmpty()) ? false : true;
    }

    public void runPendingAnimations() {
        boolean z = !this.mPendingRemovals.isEmpty();
        boolean z2 = !this.mPendingMoves.isEmpty();
        boolean z3 = !this.mPendingChanges.isEmpty();
        boolean z4 = !this.mPendingAdditions.isEmpty();
        if (z || z2 || z4 || z3) {
            Iterator<RecyclerView$ViewHolder> it = this.mPendingRemovals.iterator();
            while (it.hasNext()) {
                animateRemoveImpl(it.next());
            }
            this.mPendingRemovals.clear();
            if (z2) {
                final ArrayList<MoveInfo> arrayList = new ArrayList<>();
                arrayList.addAll(this.mPendingMoves);
                this.mMovesList.add(arrayList);
                this.mPendingMoves.clear();
                Runnable runnable = new Runnable() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            MoveInfo moveInfo = (MoveInfo) it2.next();
                            DefaultItemAnimator.this.animateMoveImpl(moveInfo.holder, moveInfo.fromX, moveInfo.fromY, moveInfo.toX, moveInfo.toY);
                        }
                        arrayList.clear();
                        DefaultItemAnimator.this.mMovesList.remove(arrayList);
                    }
                };
                if (z) {
                    ViewCompat.postOnAnimationDelayed(arrayList.get(0).holder.itemView, runnable, getRemoveDuration());
                } else {
                    runnable.run();
                }
            }
            if (z3) {
                final ArrayList<ChangeInfo> arrayList2 = new ArrayList<>();
                arrayList2.addAll(this.mPendingChanges);
                this.mChangesList.add(arrayList2);
                this.mPendingChanges.clear();
                Runnable runnable2 = new Runnable() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.2
                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it2 = arrayList2.iterator();
                        while (it2.hasNext()) {
                            DefaultItemAnimator.this.animateChangeImpl((ChangeInfo) it2.next());
                        }
                        arrayList2.clear();
                        DefaultItemAnimator.this.mChangesList.remove(arrayList2);
                    }
                };
                if (z) {
                    ViewCompat.postOnAnimationDelayed(arrayList2.get(0).oldHolder.itemView, runnable2, getRemoveDuration());
                } else {
                    runnable2.run();
                }
            }
            if (z4) {
                final ArrayList<RecyclerView$ViewHolder> arrayList3 = new ArrayList<>();
                arrayList3.addAll(this.mPendingAdditions);
                this.mAdditionsList.add(arrayList3);
                this.mPendingAdditions.clear();
                Runnable runnable3 = new Runnable() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.3
                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it2 = arrayList3.iterator();
                        while (it2.hasNext()) {
                            DefaultItemAnimator.this.animateAddImpl((RecyclerView$ViewHolder) it2.next());
                        }
                        arrayList3.clear();
                        DefaultItemAnimator.this.mAdditionsList.remove(arrayList3);
                    }
                };
                if (z || z2 || z3) {
                    ViewCompat.postOnAnimationDelayed(arrayList3.get(0).itemView, runnable3, (z ? getRemoveDuration() : 0L) + Math.max(z2 ? getMoveDuration() : 0L, z3 ? getChangeDuration() : 0L));
                } else {
                    runnable3.run();
                }
            }
        }
    }

    private boolean endChangeAnimationIfNecessary(ChangeInfo changeInfo, RecyclerView$ViewHolder recyclerView$ViewHolder) {
        boolean z = false;
        if (changeInfo.newHolder == recyclerView$ViewHolder) {
            changeInfo.newHolder = null;
        } else {
            if (changeInfo.oldHolder != recyclerView$ViewHolder) {
                return false;
            }
            changeInfo.oldHolder = null;
            z = true;
        }
        recyclerView$ViewHolder.itemView.setAlpha(1.0f);
        recyclerView$ViewHolder.itemView.setTranslationX(0.0f);
        recyclerView$ViewHolder.itemView.setTranslationY(0.0f);
        dispatchChangeFinished(recyclerView$ViewHolder, z);
        return true;
    }
}
