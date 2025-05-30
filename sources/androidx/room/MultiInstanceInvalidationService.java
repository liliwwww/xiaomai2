package androidx.room;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.IMultiInstanceInvalidationService;
import java.util.HashMap;

/* compiled from: Taobao */
@ExperimentalRoomApi
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class MultiInstanceInvalidationService extends Service {
    int mMaxClientId = 0;
    final HashMap<Integer, String> mClientNames = new HashMap<>();
    final RemoteCallbackList<IMultiInstanceInvalidationCallback> mCallbackList = new 1(this);
    private final IMultiInstanceInvalidationService.Stub mBinder = new 2(this);

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(@NonNull Intent intent) {
        return this.mBinder;
    }
}
