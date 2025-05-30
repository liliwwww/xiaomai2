package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.ExperimentalComposeApi;
import kotlin.coroutines.CoroutineContext;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@ExperimentalComposeApi
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public interface SnapshotContextElement extends CoroutineContext.Element {

    @NotNull
    public static final Key Key = Key.$$INSTANCE;

    /* compiled from: Taobao */
    public static final class Key implements CoroutineContext.Key<SnapshotContextElement> {
        static final /* synthetic */ Key $$INSTANCE = new Key();

        private Key() {
        }
    }
}
