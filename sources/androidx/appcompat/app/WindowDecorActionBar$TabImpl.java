package androidx.appcompat.app;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.RestrictTo;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.content.res.AppCompatResources;

/* compiled from: Taobao */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class WindowDecorActionBar$TabImpl extends ActionBar.Tab {
    private ActionBar$TabListener mCallback;
    private CharSequence mContentDesc;
    private View mCustomView;
    private Drawable mIcon;
    private int mPosition = -1;
    private Object mTag;
    private CharSequence mText;
    final /* synthetic */ WindowDecorActionBar this$0;

    public WindowDecorActionBar$TabImpl(WindowDecorActionBar windowDecorActionBar) {
        this.this$0 = windowDecorActionBar;
    }

    public ActionBar$TabListener getCallback() {
        return this.mCallback;
    }

    public CharSequence getContentDescription() {
        return this.mContentDesc;
    }

    public View getCustomView() {
        return this.mCustomView;
    }

    public Drawable getIcon() {
        return this.mIcon;
    }

    public int getPosition() {
        return this.mPosition;
    }

    public Object getTag() {
        return this.mTag;
    }

    public CharSequence getText() {
        return this.mText;
    }

    public void select() {
        this.this$0.selectTab(this);
    }

    public ActionBar.Tab setContentDescription(int i) {
        return setContentDescription(this.this$0.mContext.getResources().getText(i));
    }

    public ActionBar.Tab setCustomView(View view) {
        this.mCustomView = view;
        int i = this.mPosition;
        if (i >= 0) {
            this.this$0.mTabScrollView.updateTab(i);
        }
        return this;
    }

    public ActionBar.Tab setIcon(Drawable drawable) {
        this.mIcon = drawable;
        int i = this.mPosition;
        if (i >= 0) {
            this.this$0.mTabScrollView.updateTab(i);
        }
        return this;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public ActionBar.Tab setTabListener(ActionBar$TabListener actionBar$TabListener) {
        this.mCallback = actionBar$TabListener;
        return this;
    }

    public ActionBar.Tab setTag(Object obj) {
        this.mTag = obj;
        return this;
    }

    public ActionBar.Tab setText(CharSequence charSequence) {
        this.mText = charSequence;
        int i = this.mPosition;
        if (i >= 0) {
            this.this$0.mTabScrollView.updateTab(i);
        }
        return this;
    }

    public ActionBar.Tab setContentDescription(CharSequence charSequence) {
        this.mContentDesc = charSequence;
        int i = this.mPosition;
        if (i >= 0) {
            this.this$0.mTabScrollView.updateTab(i);
        }
        return this;
    }

    public ActionBar.Tab setCustomView(int i) {
        return setCustomView(LayoutInflater.from(this.this$0.getThemedContext()).inflate(i, (ViewGroup) null));
    }

    public ActionBar.Tab setIcon(int i) {
        return setIcon(AppCompatResources.getDrawable(this.this$0.mContext, i));
    }

    public ActionBar.Tab setText(int i) {
        return setText(this.this$0.mContext.getResources().getText(i));
    }
}
