package androidx.appcompat.view;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.R;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuItemWrapperICS;
import androidx.appcompat.widget.DrawableUtils;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ActionProvider;
import androidx.core.view.MenuItemCompat;
import java.lang.reflect.Constructor;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class SupportMenuInflater$MenuState {
    private static final int defaultGroupId = 0;
    private static final int defaultItemCategory = 0;
    private static final int defaultItemCheckable = 0;
    private static final boolean defaultItemChecked = false;
    private static final boolean defaultItemEnabled = true;
    private static final int defaultItemId = 0;
    private static final int defaultItemOrder = 0;
    private static final boolean defaultItemVisible = true;
    private int groupCategory;
    private int groupCheckable;
    private boolean groupEnabled;
    private int groupId;
    private int groupOrder;
    private boolean groupVisible;
    ActionProvider itemActionProvider;
    private String itemActionProviderClassName;
    private String itemActionViewClassName;
    private int itemActionViewLayout;
    private boolean itemAdded;
    private int itemAlphabeticModifiers;
    private char itemAlphabeticShortcut;
    private int itemCategoryOrder;
    private int itemCheckable;
    private boolean itemChecked;
    private CharSequence itemContentDescription;
    private boolean itemEnabled;
    private int itemIconResId;
    private ColorStateList itemIconTintList = null;
    private PorterDuff.Mode itemIconTintMode = null;
    private int itemId;
    private String itemListenerMethodName;
    private int itemNumericModifiers;
    private char itemNumericShortcut;
    private int itemShowAsAction;
    private CharSequence itemTitle;
    private CharSequence itemTitleCondensed;
    private CharSequence itemTooltipText;
    private boolean itemVisible;
    private Menu menu;
    final /* synthetic */ SupportMenuInflater this$0;

    public SupportMenuInflater$MenuState(SupportMenuInflater supportMenuInflater, Menu menu) {
        this.this$0 = supportMenuInflater;
        this.menu = menu;
        resetGroup();
    }

    private char getShortcut(String str) {
        if (str == null) {
            return (char) 0;
        }
        return str.charAt(0);
    }

    private <T> T newInstance(String str, Class<?>[] clsArr, Object[] objArr) {
        try {
            Constructor<?> constructor = Class.forName(str, false, this.this$0.mContext.getClassLoader()).getConstructor(clsArr);
            constructor.setAccessible(true);
            return (T) constructor.newInstance(objArr);
        } catch (Exception e) {
            Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e);
            return null;
        }
    }

    private void setItem(MenuItem menuItem) {
        boolean z = false;
        menuItem.setChecked(this.itemChecked).setVisible(this.itemVisible).setEnabled(this.itemEnabled).setCheckable(this.itemCheckable >= 1).setTitleCondensed(this.itemTitleCondensed).setIcon(this.itemIconResId);
        int i = this.itemShowAsAction;
        if (i >= 0) {
            menuItem.setShowAsAction(i);
        }
        if (this.itemListenerMethodName != null) {
            if (this.this$0.mContext.isRestricted()) {
                throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
            }
            menuItem.setOnMenuItemClickListener(new SupportMenuInflater.InflatedOnMenuItemClickListener(this.this$0.getRealOwner(), this.itemListenerMethodName));
        }
        if (this.itemCheckable >= 2) {
            if (menuItem instanceof MenuItemImpl) {
                ((MenuItemImpl) menuItem).setExclusiveCheckable(true);
            } else if (menuItem instanceof MenuItemWrapperICS) {
                ((MenuItemWrapperICS) menuItem).setExclusiveCheckable(true);
            }
        }
        String str = this.itemActionViewClassName;
        if (str != null) {
            menuItem.setActionView((View) newInstance(str, SupportMenuInflater.ACTION_VIEW_CONSTRUCTOR_SIGNATURE, this.this$0.mActionViewConstructorArguments));
            z = true;
        }
        int i2 = this.itemActionViewLayout;
        if (i2 > 0) {
            if (z) {
                Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
            } else {
                menuItem.setActionView(i2);
            }
        }
        ActionProvider actionProvider = this.itemActionProvider;
        if (actionProvider != null) {
            MenuItemCompat.setActionProvider(menuItem, actionProvider);
        }
        MenuItemCompat.setContentDescription(menuItem, this.itemContentDescription);
        MenuItemCompat.setTooltipText(menuItem, this.itemTooltipText);
        MenuItemCompat.setAlphabeticShortcut(menuItem, this.itemAlphabeticShortcut, this.itemAlphabeticModifiers);
        MenuItemCompat.setNumericShortcut(menuItem, this.itemNumericShortcut, this.itemNumericModifiers);
        PorterDuff.Mode mode = this.itemIconTintMode;
        if (mode != null) {
            MenuItemCompat.setIconTintMode(menuItem, mode);
        }
        ColorStateList colorStateList = this.itemIconTintList;
        if (colorStateList != null) {
            MenuItemCompat.setIconTintList(menuItem, colorStateList);
        }
    }

    public void addItem() {
        this.itemAdded = true;
        setItem(this.menu.add(this.groupId, this.itemId, this.itemCategoryOrder, this.itemTitle));
    }

    public SubMenu addSubMenuItem() {
        this.itemAdded = true;
        SubMenu addSubMenu = this.menu.addSubMenu(this.groupId, this.itemId, this.itemCategoryOrder, this.itemTitle);
        setItem(addSubMenu.getItem());
        return addSubMenu;
    }

    public boolean hasAddedItem() {
        return this.itemAdded;
    }

    public void readGroup(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.this$0.mContext.obtainStyledAttributes(attributeSet, R.styleable.MenuGroup);
        this.groupId = obtainStyledAttributes.getResourceId(R.styleable.MenuGroup_android_id, 0);
        this.groupCategory = obtainStyledAttributes.getInt(R.styleable.MenuGroup_android_menuCategory, 0);
        this.groupOrder = obtainStyledAttributes.getInt(R.styleable.MenuGroup_android_orderInCategory, 0);
        this.groupCheckable = obtainStyledAttributes.getInt(R.styleable.MenuGroup_android_checkableBehavior, 0);
        this.groupVisible = obtainStyledAttributes.getBoolean(R.styleable.MenuGroup_android_visible, true);
        this.groupEnabled = obtainStyledAttributes.getBoolean(R.styleable.MenuGroup_android_enabled, true);
        obtainStyledAttributes.recycle();
    }

    public void readItem(AttributeSet attributeSet) {
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(this.this$0.mContext, attributeSet, R.styleable.MenuItem);
        this.itemId = obtainStyledAttributes.getResourceId(R.styleable.MenuItem_android_id, 0);
        this.itemCategoryOrder = (obtainStyledAttributes.getInt(R.styleable.MenuItem_android_menuCategory, this.groupCategory) & SupportMenu.CATEGORY_MASK) | (obtainStyledAttributes.getInt(R.styleable.MenuItem_android_orderInCategory, this.groupOrder) & 65535);
        this.itemTitle = obtainStyledAttributes.getText(R.styleable.MenuItem_android_title);
        this.itemTitleCondensed = obtainStyledAttributes.getText(R.styleable.MenuItem_android_titleCondensed);
        this.itemIconResId = obtainStyledAttributes.getResourceId(R.styleable.MenuItem_android_icon, 0);
        this.itemAlphabeticShortcut = getShortcut(obtainStyledAttributes.getString(R.styleable.MenuItem_android_alphabeticShortcut));
        this.itemAlphabeticModifiers = obtainStyledAttributes.getInt(R.styleable.MenuItem_alphabeticModifiers, 4096);
        this.itemNumericShortcut = getShortcut(obtainStyledAttributes.getString(R.styleable.MenuItem_android_numericShortcut));
        this.itemNumericModifiers = obtainStyledAttributes.getInt(R.styleable.MenuItem_numericModifiers, 4096);
        int i = R.styleable.MenuItem_android_checkable;
        if (obtainStyledAttributes.hasValue(i)) {
            this.itemCheckable = obtainStyledAttributes.getBoolean(i, false) ? 1 : 0;
        } else {
            this.itemCheckable = this.groupCheckable;
        }
        this.itemChecked = obtainStyledAttributes.getBoolean(R.styleable.MenuItem_android_checked, false);
        this.itemVisible = obtainStyledAttributes.getBoolean(R.styleable.MenuItem_android_visible, this.groupVisible);
        this.itemEnabled = obtainStyledAttributes.getBoolean(R.styleable.MenuItem_android_enabled, this.groupEnabled);
        this.itemShowAsAction = obtainStyledAttributes.getInt(R.styleable.MenuItem_showAsAction, -1);
        this.itemListenerMethodName = obtainStyledAttributes.getString(R.styleable.MenuItem_android_onClick);
        this.itemActionViewLayout = obtainStyledAttributes.getResourceId(R.styleable.MenuItem_actionLayout, 0);
        this.itemActionViewClassName = obtainStyledAttributes.getString(R.styleable.MenuItem_actionViewClass);
        String string = obtainStyledAttributes.getString(R.styleable.MenuItem_actionProviderClass);
        this.itemActionProviderClassName = string;
        boolean z = string != null;
        if (z && this.itemActionViewLayout == 0 && this.itemActionViewClassName == null) {
            this.itemActionProvider = (ActionProvider) newInstance(string, SupportMenuInflater.ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE, this.this$0.mActionProviderConstructorArguments);
        } else {
            if (z) {
                Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
            }
            this.itemActionProvider = null;
        }
        this.itemContentDescription = obtainStyledAttributes.getText(R.styleable.MenuItem_contentDescription);
        this.itemTooltipText = obtainStyledAttributes.getText(R.styleable.MenuItem_tooltipText);
        int i2 = R.styleable.MenuItem_iconTintMode;
        if (obtainStyledAttributes.hasValue(i2)) {
            this.itemIconTintMode = DrawableUtils.parseTintMode(obtainStyledAttributes.getInt(i2, -1), this.itemIconTintMode);
        } else {
            this.itemIconTintMode = null;
        }
        int i3 = R.styleable.MenuItem_iconTint;
        if (obtainStyledAttributes.hasValue(i3)) {
            this.itemIconTintList = obtainStyledAttributes.getColorStateList(i3);
        } else {
            this.itemIconTintList = null;
        }
        obtainStyledAttributes.recycle();
        this.itemAdded = false;
    }

    public void resetGroup() {
        this.groupId = 0;
        this.groupCategory = 0;
        this.groupOrder = 0;
        this.groupCheckable = 0;
        this.groupVisible = true;
        this.groupEnabled = true;
    }
}
