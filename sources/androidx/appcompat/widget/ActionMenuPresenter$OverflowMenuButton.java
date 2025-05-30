package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.appcompat.widget.ActionMenuPresenter;
import androidx.appcompat.widget.ActionMenuView;
import androidx.core.graphics.drawable.DrawableCompat;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class ActionMenuPresenter$OverflowMenuButton extends AppCompatImageView implements ActionMenuView.ActionMenuChildView {
    final /* synthetic */ ActionMenuPresenter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ActionMenuPresenter$OverflowMenuButton(final ActionMenuPresenter actionMenuPresenter, Context context) {
        super(context, (AttributeSet) null, R.attr.actionOverflowButtonStyle);
        this.this$0 = actionMenuPresenter;
        setClickable(true);
        setFocusable(true);
        setVisibility(0);
        setEnabled(true);
        TooltipCompat.setTooltipText(this, getContentDescription());
        setOnTouchListener(new ForwardingListener(this) { // from class: androidx.appcompat.widget.ActionMenuPresenter$OverflowMenuButton.1
            public ShowableListMenu getPopup() {
                ActionMenuPresenter.OverflowPopup overflowPopup = ActionMenuPresenter$OverflowMenuButton.this.this$0.mOverflowPopup;
                if (overflowPopup == null) {
                    return null;
                }
                return overflowPopup.getPopup();
            }

            public boolean onForwardingStarted() {
                ActionMenuPresenter$OverflowMenuButton.this.this$0.showOverflowMenu();
                return true;
            }

            public boolean onForwardingStopped() {
                ActionMenuPresenter actionMenuPresenter2 = ActionMenuPresenter$OverflowMenuButton.this.this$0;
                if (actionMenuPresenter2.mPostedOpenRunnable != null) {
                    return false;
                }
                actionMenuPresenter2.hideOverflowMenu();
                return true;
            }
        });
    }

    @Override // androidx.appcompat.widget.ActionMenuView.ActionMenuChildView
    public boolean needsDividerAfter() {
        return false;
    }

    @Override // androidx.appcompat.widget.ActionMenuView.ActionMenuChildView
    public boolean needsDividerBefore() {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean performClick() {
        if (super/*android.widget.ImageView*/.performClick()) {
            return true;
        }
        playSoundEffect(0);
        this.this$0.showOverflowMenu();
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected boolean setFrame(int i, int i2, int i3, int i4) {
        boolean frame = super/*android.widget.ImageView*/.setFrame(i, i2, i3, i4);
        Drawable drawable = getDrawable();
        Drawable background = getBackground();
        if (drawable != null && background != null) {
            int width = getWidth();
            int height = getHeight();
            int max = Math.max(width, height) / 2;
            int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
            int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
            DrawableCompat.setHotspotBounds(background, paddingLeft - max, paddingTop - max, paddingLeft + max, paddingTop + max);
        }
        return frame;
    }
}
