package android.taobao.windvane.embed;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues$Custom;
import androidx.core.internal.view.SupportMenu;
import com.uc.webview.export.extension.EmbedViewConfig;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class EmbedViewDemo extends BaseEmbedView {
    TextView tv;

    @Override // android.taobao.windvane.embed.BaseEmbedView
    public boolean execute(String str, String str2, WVCallBackContext wVCallBackContext) {
        if (str2 == null) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str2);
            if ("setText".equals(str)) {
                TextView textView = this.tv;
                if (textView != null) {
                    textView.setText(jSONObject.getString("text"));
                    wVCallBackContext.success();
                }
                return true;
            }
            if ("setTextSize".equals(str)) {
                TextView textView2 = this.tv;
                if (textView2 != null) {
                    textView2.setTextSize(Float.valueOf(jSONObject.getString("size")).floatValue());
                    wVCallBackContext.success();
                }
                return true;
            }
            if ("setBackground".equals(str)) {
                TextView textView3 = this.tv;
                if (textView3 != null) {
                    textView3.setBackgroundColor(Color.parseColor(jSONObject.getString(TypedValues$Custom.S_COLOR)));
                    wVCallBackContext.success();
                }
                return true;
            }
            if (!"setTextColor".equals(str)) {
                return false;
            }
            TextView textView4 = this.tv;
            if (textView4 != null) {
                textView4.setTextColor(Color.parseColor(jSONObject.getString(TypedValues$Custom.S_COLOR)));
                wVCallBackContext.success();
            }
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // android.taobao.windvane.embed.BaseEmbedView
    protected View generateView(Context context) {
        int i;
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        EmbedViewConfig embedViewConfig = this.params;
        int i2 = embedViewConfig.mWidth;
        int i3 = embedViewConfig.mHeight;
        if (context instanceof Activity) {
            Display defaultDisplay = ((Activity) context).getWindowManager().getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            com.alibaba.wireless.security.aopsdk.replace.android.view.Display.getMetrics(defaultDisplay, displayMetrics);
            i = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics);
        } else {
            i = 0;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) (i3 * (i / i2)));
        layoutParams.addRule(13);
        TextView textView = new TextView(context);
        this.tv = textView;
        textView.setBackgroundColor(-7829368);
        this.tv.setText("EmbedView DEMO");
        this.tv.setTextColor(SupportMenu.CATEGORY_MASK);
        this.tv.setTextSize(30.0f);
        this.tv.setGravity(17);
        relativeLayout.addView(this.tv, layoutParams);
        return relativeLayout;
    }

    @Override // android.taobao.windvane.embed.BaseEmbedView
    protected String getViewType() {
        return "demo";
    }
}
