package androidx.appcompat.view.menu;

import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.MenuPopupWindow;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class CascadingMenuPopup$CascadingMenuInfo {
    public final MenuBuilder menu;
    public final int position;
    public final MenuPopupWindow window;

    public CascadingMenuPopup$CascadingMenuInfo(@NonNull MenuPopupWindow menuPopupWindow, @NonNull MenuBuilder menuBuilder, int i) {
        this.window = menuPopupWindow;
        this.menu = menuBuilder;
        this.position = i;
    }

    public ListView getListView() {
        return this.window.getListView();
    }
}
