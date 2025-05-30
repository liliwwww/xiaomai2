package androidx.core.content.pm;

import android.content.pm.ShortcutInfo;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.List;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
@RequiresApi(25)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class ShortcutManagerCompat$Api25Impl {
    private ShortcutManagerCompat$Api25Impl() {
    }

    static String getShortcutInfoWithLowestRank(@NonNull List<ShortcutInfo> list) {
        int i = -1;
        String str = null;
        for (ShortcutInfo shortcutInfo : list) {
            if (shortcutInfo.getRank() > i) {
                str = shortcutInfo.getId();
                i = shortcutInfo.getRank();
            }
        }
        return str;
    }
}
