package androidx.core.text.util;

import android.text.Spannable;
import android.text.util.Linkify;
import android.widget.TextView;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import java.util.regex.Pattern;

/* compiled from: Taobao */
@RequiresApi(24)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class LinkifyCompat$Api24Impl {
    private LinkifyCompat$Api24Impl() {
    }

    @DoNotInline
    static void addLinks(TextView textView, Pattern pattern, String str, String[] strArr, Linkify.MatchFilter matchFilter, Linkify.TransformFilter transformFilter) {
        Linkify.addLinks(textView, pattern, str, strArr, matchFilter, transformFilter);
    }

    @DoNotInline
    static boolean addLinks(Spannable spannable, Pattern pattern, String str, String[] strArr, Linkify.MatchFilter matchFilter, Linkify.TransformFilter transformFilter) {
        return Linkify.addLinks(spannable, pattern, str, strArr, matchFilter, transformFilter);
    }
}
