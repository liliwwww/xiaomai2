package android.taobao.windvane.embed;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class Empty extends BaseEmbedView {
    protected View generateView(Context context) {
        TextView textView = new TextView(context);
        textView.setBackgroundColor(-7829368);
        textView.setText("Empty View");
        textView.setTextColor(-65536);
        textView.setTextSize(30.0f);
        textView.setGravity(17);
        return textView;
    }

    protected String getViewType() {
        return "empty";
    }
}
