package androidx.appcompat.view.menu;

import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

/* compiled from: Taobao */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public interface MenuBuilder$Callback {
    boolean onMenuItemSelected(@NonNull MenuBuilder menuBuilder, @NonNull MenuItem menuItem);

    void onMenuModeChange(@NonNull MenuBuilder menuBuilder);
}
