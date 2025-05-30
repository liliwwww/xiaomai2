package androidx.compose.ui.text.input;

import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public interface OffsetMapping {

    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;

    /* compiled from: Taobao */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        @NotNull
        private static final OffsetMapping Identity = new Identity.1();

        private Companion() {
        }

        @NotNull
        public final OffsetMapping getIdentity() {
            return Identity;
        }
    }

    int originalToTransformed(int i);

    int transformedToOriginal(int i);
}
