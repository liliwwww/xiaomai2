package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.ForwardingListener;
import androidx.appcompat.widget.TooltipCompat;
import com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect;

/* compiled from: Taobao */
@RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class ActionMenuItemView extends AppCompatTextView implements View.OnClickListener, MenuView$ItemView, ActionMenuView.ActionMenuChildView {
    private static final int MAX_ICON_SIZE = 32;
    private static final String TAG = "ActionMenuItemView";
    private boolean mAllowTextWithIcon;
    private boolean mExpandedFormat;
    private ForwardingListener mForwardingListener;
    private Drawable mIcon;
    MenuItemImpl mItemData;
    MenuBuilder.ItemInvoker mItemInvoker;
    private int mMaxIconSize;
    private int mMinWidth;
    PopupCallback mPopupCallback;
    private int mSavedPaddingLeft;
    private CharSequence mTitle;

    /* compiled from: Taobao */
    private class ActionMenuItemForwardingListener extends ForwardingListener {
        /* JADX WARN: Multi-variable type inference failed */
        public ActionMenuItemForwardingListener() {
            super(ActionMenuItemView.this);
        }

        public ShowableListMenu getPopup() {
            PopupCallback popupCallback = ActionMenuItemView.this.mPopupCallback;
            if (popupCallback != null) {
                return popupCallback.getPopup();
            }
            return null;
        }

        protected boolean onForwardingStarted() {
            ShowableListMenu popup;
            ActionMenuItemView actionMenuItemView = ActionMenuItemView.this;
            MenuBuilder.ItemInvoker itemInvoker = actionMenuItemView.mItemInvoker;
            return itemInvoker != null && itemInvoker.invokeItem(actionMenuItemView.mItemData) && (popup = getPopup()) != null && popup.isShowing();
        }
    }

    public ActionMenuItemView(Context context) {
        this(context, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean shouldAllowTextWithIcon() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i = configuration.screenWidthDp;
        return i >= 480 || (i >= 640 && configuration.screenHeightDp >= 480) || configuration.orientation == 2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void updateTextButtonVisibility() {
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(this.mTitle);
        if (this.mIcon != null && (!this.mItemData.showsTextAsAction() || (!this.mAllowTextWithIcon && !this.mExpandedFormat))) {
            z = false;
        }
        boolean z3 = z2 & z;
        setText(z3 ? this.mTitle : null);
        CharSequence contentDescription = this.mItemData.getContentDescription();
        if (TextUtils.isEmpty(contentDescription)) {
            setContentDescription(z3 ? null : this.mItemData.getTitle());
        } else {
            setContentDescription(contentDescription);
        }
        CharSequence tooltipText = this.mItemData.getTooltipText();
        if (TextUtils.isEmpty(tooltipText)) {
            TooltipCompat.setTooltipText(this, z3 ? null : this.mItemData.getTitle());
        } else {
            TooltipCompat.setTooltipText(this, tooltipText);
        }
    }

    public CharSequence getAccessibilityClassName() {
        return Button.class.getName();
    }

    @Override // androidx.appcompat.view.menu.MenuView$ItemView
    public MenuItemImpl getItemData() {
        return this.mItemData;
    }

    public boolean hasText() {
        return !TextUtils.isEmpty(getText());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.appcompat.view.menu.MenuView$ItemView
    public void initialize(MenuItemImpl menuItemImpl, int i) {
        this.mItemData = menuItemImpl;
        setIcon(menuItemImpl.getIcon());
        setTitle(menuItemImpl.getTitleForItemView(this));
        setId(menuItemImpl.getItemId());
        setVisibility(menuItemImpl.isVisible() ? 0 : 8);
        setEnabled(menuItemImpl.isEnabled());
        if (menuItemImpl.hasSubMenu() && this.mForwardingListener == null) {
            this.mForwardingListener = new ActionMenuItemForwardingListener();
        }
    }

    @Override // androidx.appcompat.widget.ActionMenuView.ActionMenuChildView
    public boolean needsDividerAfter() {
        return hasText();
    }

    @Override // androidx.appcompat.widget.ActionMenuView.ActionMenuChildView
    public boolean needsDividerBefore() {
        return hasText() && this.mItemData.getIcon() == null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MenuBuilder.ItemInvoker itemInvoker = this.mItemInvoker;
        if (itemInvoker != null) {
            itemInvoker.invokeItem(this.mItemData);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onConfigurationChanged(Configuration configuration) {
        super/*android.widget.TextView*/.onConfigurationChanged(configuration);
        this.mAllowTextWithIcon = shouldAllowTextWithIcon();
        updateTextButtonVisibility();
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onMeasure(int i, int i2) {
        int i3;
        boolean hasText = hasText();
        if (hasText && (i3 = this.mSavedPaddingLeft) >= 0) {
            super/*android.widget.TextView*/.setPadding(i3, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int measuredWidth = getMeasuredWidth();
        int min = mode == Integer.MIN_VALUE ? Math.min(size, this.mMinWidth) : this.mMinWidth;
        if (mode != 1073741824 && this.mMinWidth > 0 && measuredWidth < min) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(min, 1073741824), i2);
        }
        if (hasText || this.mIcon == null) {
            return;
        }
        super/*android.widget.TextView*/.setPadding((getMeasuredWidth() - Rect.width(this.mIcon.getBounds())) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onRestoreInstanceState(Parcelable parcelable) {
        super/*android.widget.TextView*/.onRestoreInstanceState(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ForwardingListener forwardingListener;
        if (this.mItemData.hasSubMenu() && (forwardingListener = this.mForwardingListener) != null && forwardingListener.onTouch(this, motionEvent)) {
            return true;
        }
        return super/*android.widget.TextView*/.onTouchEvent(motionEvent);
    }

    @Override // androidx.appcompat.view.menu.MenuView$ItemView
    public boolean prefersCondensedTitle() {
        return true;
    }

    @Override // androidx.appcompat.view.menu.MenuView$ItemView
    public void setCheckable(boolean z) {
    }

    @Override // androidx.appcompat.view.menu.MenuView$ItemView
    public void setChecked(boolean z) {
    }

    public void setExpandedFormat(boolean z) {
        if (this.mExpandedFormat != z) {
            this.mExpandedFormat = z;
            MenuItemImpl menuItemImpl = this.mItemData;
            if (menuItemImpl != null) {
                menuItemImpl.actionFormatChanged();
            }
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView$ItemView
    public void setIcon(Drawable drawable) {
        this.mIcon = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i = this.mMaxIconSize;
            if (intrinsicWidth > i) {
                intrinsicHeight = (int) (intrinsicHeight * (i / intrinsicWidth));
                intrinsicWidth = i;
            }
            if (intrinsicHeight > i) {
                intrinsicWidth = (int) (intrinsicWidth * (i / intrinsicHeight));
            } else {
                i = intrinsicHeight;
            }
            drawable.setBounds(0, 0, intrinsicWidth, i);
        }
        setCompoundDrawables(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        updateTextButtonVisibility();
    }

    public void setItemInvoker(MenuBuilder.ItemInvoker itemInvoker) {
        this.mItemInvoker = itemInvoker;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setPadding(int i, int i2, int i3, int i4) {
        this.mSavedPaddingLeft = i;
        super/*android.widget.TextView*/.setPadding(i, i2, i3, i4);
    }

    public void setPopupCallback(PopupCallback popupCallback) {
        this.mPopupCallback = popupCallback;
    }

    @Override // androidx.appcompat.view.menu.MenuView$ItemView
    public void setShortcut(boolean z, char c) {
    }

    @Override // androidx.appcompat.view.menu.MenuView$ItemView
    public void setTitle(CharSequence charSequence) {
        this.mTitle = charSequence;
        updateTextButtonVisibility();
    }

    @Override // androidx.appcompat.view.menu.MenuView$ItemView
    public boolean showsIcon() {
        return true;
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Resources resources = context.getResources();
        this.mAllowTextWithIcon = shouldAllowTextWithIcon();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ActionMenuItemView, i, 0);
        this.mMinWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ActionMenuItemView_android_minWidth, 0);
        obtainStyledAttributes.recycle();
        this.mMaxIconSize = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.mSavedPaddingLeft = -1;
        setSaveEnabled(false);
    }
}
