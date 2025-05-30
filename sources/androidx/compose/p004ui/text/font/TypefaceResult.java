package androidx.compose.p004ui.text.font;

import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface TypefaceResult extends State<Object> {

    /* compiled from: Taobao */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes2.dex */
    public static final class Async implements TypefaceResult, State<Object> {
        public static final int $stable = 0;

        @NotNull
        private final AsyncFontListLoader current;

        public Async(@NotNull AsyncFontListLoader asyncFontListLoader) {
            Intrinsics.checkNotNullParameter(asyncFontListLoader, "current");
            this.current = asyncFontListLoader;
        }

        @Override // androidx.compose.p004ui.text.font.TypefaceResult
        public boolean getCacheable() {
            return this.current.getCacheable$ui_text_release();
        }

        @NotNull
        public final AsyncFontListLoader getCurrent$ui_text_release() {
            return this.current;
        }

        @Override // androidx.compose.runtime.State
        @NotNull
        public Object getValue() {
            return this.current.getValue();
        }
    }

    boolean getCacheable();

    /* compiled from: Taobao */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes2.dex */
    public static final class Immutable implements TypefaceResult {
        public static final int $stable = 0;
        private final boolean cacheable;

        @NotNull
        private final Object value;

        public Immutable(@NotNull Object obj, boolean z) {
            Intrinsics.checkNotNullParameter(obj, "value");
            this.value = obj;
            this.cacheable = z;
        }

        @Override // androidx.compose.p004ui.text.font.TypefaceResult
        public boolean getCacheable() {
            return this.cacheable;
        }

        @Override // androidx.compose.runtime.State
        @NotNull
        public Object getValue() {
            return this.value;
        }

        public /* synthetic */ Immutable(Object obj, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(obj, (i & 2) != 0 ? true : z);
        }
    }
}
