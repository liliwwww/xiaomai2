package androidx.compose.p004ui.tooling;

import androidx.compose.runtime.tooling.CompositionData;
import java.util.Set;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface CompositionDataRecord {

    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        @NotNull
        public final CompositionDataRecord create() {
            return new CompositionDataRecordImpl();
        }
    }

    @NotNull
    Set<CompositionData> getStore();
}
