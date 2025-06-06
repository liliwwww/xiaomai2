package androidx.core.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.annotation.NonNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public interface MenuProvider {
    void onCreateMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater);

    void onMenuClosed(@NonNull Menu menu);

    boolean onMenuItemSelected(@NonNull MenuItem menuItem);

    void onPrepareMenu(@NonNull Menu menu);
}
