package androidx.viewpager2.widget;

import android.R;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityActionCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.viewpager2.widget.ViewPager2;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class ViewPager2$PageAwareAccessibilityProvider extends ViewPager2.AccessibilityProvider {
    private final AccessibilityViewCommand mActionPageBackward;
    private final AccessibilityViewCommand mActionPageForward;
    private RecyclerView.AdapterDataObserver mAdapterDataObserver;
    final /* synthetic */ ViewPager2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ViewPager2$PageAwareAccessibilityProvider(ViewPager2 viewPager2) {
        super(viewPager2, (ViewPager2$1) null);
        this.this$0 = viewPager2;
        this.mActionPageForward = new AccessibilityViewCommand() { // from class: androidx.viewpager2.widget.ViewPager2$PageAwareAccessibilityProvider.1
            @Override // androidx.core.view.accessibility.AccessibilityViewCommand
            public boolean perform(@NonNull View view, @Nullable AccessibilityViewCommand.CommandArguments commandArguments) {
                ViewPager2$PageAwareAccessibilityProvider.this.setCurrentItemFromAccessibilityCommand(((ViewPager2) view).getCurrentItem() + 1);
                return true;
            }
        };
        this.mActionPageBackward = new AccessibilityViewCommand() { // from class: androidx.viewpager2.widget.ViewPager2$PageAwareAccessibilityProvider.2
            @Override // androidx.core.view.accessibility.AccessibilityViewCommand
            public boolean perform(@NonNull View view, @Nullable AccessibilityViewCommand.CommandArguments commandArguments) {
                ViewPager2$PageAwareAccessibilityProvider.this.setCurrentItemFromAccessibilityCommand(((ViewPager2) view).getCurrentItem() - 1);
                return true;
            }
        };
    }

    private void addCollectionInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        int i;
        int i2;
        if (this.this$0.getAdapter() == null) {
            i = 0;
        } else {
            if (this.this$0.getOrientation() != 1) {
                i2 = this.this$0.getAdapter().getItemCount();
                i = 0;
                AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(i, i2, false, 0));
            }
            i = this.this$0.getAdapter().getItemCount();
        }
        i2 = 0;
        AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(i, i2, false, 0));
    }

    private void addScrollActions(AccessibilityNodeInfo accessibilityNodeInfo) {
        int itemCount;
        RecyclerView$Adapter adapter = this.this$0.getAdapter();
        if (adapter == null || (itemCount = adapter.getItemCount()) == 0 || !this.this$0.isUserInputEnabled()) {
            return;
        }
        if (this.this$0.mCurrentItem > 0) {
            accessibilityNodeInfo.addAction(AccessibilityEventCompat.TYPE_VIEW_TEXT_SELECTION_CHANGED);
        }
        if (this.this$0.mCurrentItem < itemCount - 1) {
            accessibilityNodeInfo.addAction(AccessibilityEventCompat.TYPE_VIEW_SCROLLED);
        }
        accessibilityNodeInfo.setScrollable(true);
    }

    public boolean handlesGetAccessibilityClassName() {
        return true;
    }

    public boolean handlesPerformAccessibilityAction(int i, Bundle bundle) {
        return i == 8192 || i == 4096;
    }

    public void onAttachAdapter(@Nullable RecyclerView$Adapter<?> recyclerView$Adapter) {
        updatePageAccessibilityActions();
        if (recyclerView$Adapter != null) {
            recyclerView$Adapter.registerAdapterDataObserver(this.mAdapterDataObserver);
        }
    }

    public void onDetachAdapter(@Nullable RecyclerView$Adapter<?> recyclerView$Adapter) {
        if (recyclerView$Adapter != null) {
            recyclerView$Adapter.unregisterAdapterDataObserver(this.mAdapterDataObserver);
        }
    }

    public String onGetAccessibilityClassName() {
        if (handlesGetAccessibilityClassName()) {
            return "androidx.viewpager.widget.ViewPager";
        }
        throw new IllegalStateException();
    }

    public void onInitialize(@NonNull CompositeOnPageChangeCallback compositeOnPageChangeCallback, @NonNull RecyclerView recyclerView) {
        ViewCompat.setImportantForAccessibility(recyclerView, 2);
        this.mAdapterDataObserver = new ViewPager2.DataSetChangeObserver() { // from class: androidx.viewpager2.widget.ViewPager2$PageAwareAccessibilityProvider.3
            public void onChanged() {
                ViewPager2$PageAwareAccessibilityProvider.this.updatePageAccessibilityActions();
            }
        };
        if (ViewCompat.getImportantForAccessibility(this.this$0) == 0) {
            ViewCompat.setImportantForAccessibility(this.this$0, 1);
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        addCollectionInfo(accessibilityNodeInfo);
        if (Build.VERSION.SDK_INT >= 16) {
            addScrollActions(accessibilityNodeInfo);
        }
    }

    public boolean onPerformAccessibilityAction(int i, Bundle bundle) {
        if (!handlesPerformAccessibilityAction(i, bundle)) {
            throw new IllegalStateException();
        }
        setCurrentItemFromAccessibilityCommand(i == 8192 ? this.this$0.getCurrentItem() - 1 : this.this$0.getCurrentItem() + 1);
        return true;
    }

    public void onRestorePendingState() {
        updatePageAccessibilityActions();
    }

    public void onRvInitializeAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
        accessibilityEvent.setSource(this.this$0);
        accessibilityEvent.setClassName(onGetAccessibilityClassName());
    }

    public void onSetLayoutDirection() {
        updatePageAccessibilityActions();
    }

    public void onSetNewCurrentItem() {
        updatePageAccessibilityActions();
    }

    public void onSetOrientation() {
        updatePageAccessibilityActions();
    }

    public void onSetUserInputEnabled() {
        updatePageAccessibilityActions();
        if (Build.VERSION.SDK_INT < 21) {
            this.this$0.sendAccessibilityEvent(AccessibilityEventCompat.TYPE_WINDOW_CONTENT_CHANGED);
        }
    }

    void setCurrentItemFromAccessibilityCommand(int i) {
        if (this.this$0.isUserInputEnabled()) {
            this.this$0.setCurrentItemInternal(i, true);
        }
    }

    void updatePageAccessibilityActions() {
        int itemCount;
        ViewPager2 viewPager2 = this.this$0;
        int i = R.id.accessibilityActionPageLeft;
        ViewCompat.removeAccessibilityAction(viewPager2, R.id.accessibilityActionPageLeft);
        ViewCompat.removeAccessibilityAction(viewPager2, R.id.accessibilityActionPageRight);
        ViewCompat.removeAccessibilityAction(viewPager2, R.id.accessibilityActionPageUp);
        ViewCompat.removeAccessibilityAction(viewPager2, R.id.accessibilityActionPageDown);
        if (this.this$0.getAdapter() == null || (itemCount = this.this$0.getAdapter().getItemCount()) == 0 || !this.this$0.isUserInputEnabled()) {
            return;
        }
        if (this.this$0.getOrientation() != 0) {
            if (this.this$0.mCurrentItem < itemCount - 1) {
                ViewCompat.replaceAccessibilityAction(viewPager2, new AccessibilityNodeInfoCompat$AccessibilityActionCompat(R.id.accessibilityActionPageDown, null), null, this.mActionPageForward);
            }
            if (this.this$0.mCurrentItem > 0) {
                ViewCompat.replaceAccessibilityAction(viewPager2, new AccessibilityNodeInfoCompat$AccessibilityActionCompat(R.id.accessibilityActionPageUp, null), null, this.mActionPageBackward);
                return;
            }
            return;
        }
        boolean isRtl = this.this$0.isRtl();
        int i2 = isRtl ? R.id.accessibilityActionPageLeft : R.id.accessibilityActionPageRight;
        if (isRtl) {
            i = R.id.accessibilityActionPageRight;
        }
        if (this.this$0.mCurrentItem < itemCount - 1) {
            ViewCompat.replaceAccessibilityAction(viewPager2, new AccessibilityNodeInfoCompat$AccessibilityActionCompat(i2, null), null, this.mActionPageForward);
        }
        if (this.this$0.mCurrentItem > 0) {
            ViewCompat.replaceAccessibilityAction(viewPager2, new AccessibilityNodeInfoCompat$AccessibilityActionCompat(i, null), null, this.mActionPageBackward);
        }
    }
}
