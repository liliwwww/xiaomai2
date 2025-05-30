package androidx.compose.ui;

import androidx.compose.runtime.Stable;
import kotlin.coroutines.CoroutineContext;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Stable
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public interface MotionDurationScale extends CoroutineContext.Element {

    @NotNull
    public static final Key Key = Key.$$INSTANCE;

    /* compiled from: Taobao */
    public static final class Key implements CoroutineContext.Key<MotionDurationScale> {
        static final /* synthetic */ Key $$INSTANCE = new Key();

        private Key() {
        }
    }

    @NotNull
    CoroutineContext.Key<?> getKey();

    float getScaleFactor();
}
