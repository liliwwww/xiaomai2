package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewDebug;
import android.view.ViewGroup;
import androidx.appcompat.widget.LinearLayoutCompat;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class ActionMenuView$LayoutParams extends LinearLayoutCompat.LayoutParams {

    @ViewDebug.ExportedProperty
    public int cellsUsed;

    @ViewDebug.ExportedProperty
    public boolean expandable;
    boolean expanded;

    @ViewDebug.ExportedProperty
    public int extraPixels;

    @ViewDebug.ExportedProperty
    public boolean isOverflowButton;

    @ViewDebug.ExportedProperty
    public boolean preventEdgeOffset;

    public ActionMenuView$LayoutParams(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ActionMenuView$LayoutParams(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
    }

    public ActionMenuView$LayoutParams(ActionMenuView$LayoutParams actionMenuView$LayoutParams) {
        super((ViewGroup.LayoutParams) actionMenuView$LayoutParams);
        this.isOverflowButton = actionMenuView$LayoutParams.isOverflowButton;
    }

    public ActionMenuView$LayoutParams(int i, int i2) {
        super(i, i2);
        this.isOverflowButton = false;
    }

    ActionMenuView$LayoutParams(int i, int i2, boolean z) {
        super(i, i2);
        this.isOverflowButton = z;
    }
}
