package androidx.asynclayoutinflater.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class AsyncLayoutInflater$BasicInflater extends LayoutInflater {
    private static final String[] sClassPrefixList = {"android.widget.", "android.webkit.", "android.app."};

    AsyncLayoutInflater$BasicInflater(Context context) {
        super(context);
    }

    @Override // android.view.LayoutInflater
    public LayoutInflater cloneInContext(Context context) {
        return new AsyncLayoutInflater$BasicInflater(context);
    }

    @Override // android.view.LayoutInflater
    protected View onCreateView(String str, AttributeSet attributeSet) throws ClassNotFoundException {
        View createView;
        for (String str2 : sClassPrefixList) {
            try {
                createView = createView(str, str2, attributeSet);
            } catch (ClassNotFoundException unused) {
            }
            if (createView != null) {
                return createView;
            }
        }
        return super.onCreateView(str, attributeSet);
    }
}
