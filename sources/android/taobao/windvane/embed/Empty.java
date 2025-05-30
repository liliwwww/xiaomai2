package android.taobao.windvane.embed;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class Empty extends BaseEmbedView {
    @Override // android.taobao.windvane.embed.BaseEmbedView
    protected View generateView(Context context) {
        TextView textView = new TextView(context);
        textView.setBackgroundColor(-7829368);
        textView.setText("Empty View");
        textView.setTextColor(SupportMenu.CATEGORY_MASK);
        textView.setTextSize(30.0f);
        textView.setGravity(17);
        return textView;
    }

    @Override // android.taobao.windvane.embed.BaseEmbedView
    protected String getViewType() {
        return "empty";
    }
}
