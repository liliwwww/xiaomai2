package androidx.compose.ui.semantics;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.platform.JvmActuals_jvmKt;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Function;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.l3;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class SemanticsConfiguration implements SemanticsPropertyReceiver, Iterable<Map.Entry<? extends SemanticsPropertyKey<?>, ? extends Object>>, KMappedMarker {
    public static final int $stable = 8;
    private boolean isClearingSemantics;
    private boolean isMergingSemanticsOfDescendants;

    @NotNull
    private final Map<SemanticsPropertyKey<?>, Object> props = new LinkedHashMap();

    public final void collapsePeer$ui_release(@NotNull SemanticsConfiguration semanticsConfiguration) {
        Intrinsics.checkNotNullParameter(semanticsConfiguration, "peer");
        if (semanticsConfiguration.isMergingSemanticsOfDescendants) {
            this.isMergingSemanticsOfDescendants = true;
        }
        if (semanticsConfiguration.isClearingSemantics) {
            this.isClearingSemantics = true;
        }
        for (Map.Entry<SemanticsPropertyKey<?>, Object> entry : semanticsConfiguration.props.entrySet()) {
            SemanticsPropertyKey<?> key = entry.getKey();
            Object value = entry.getValue();
            if (!this.props.containsKey(key)) {
                this.props.put(key, value);
            } else if (value instanceof AccessibilityAction) {
                Object obj = this.props.get(key);
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.ui.semantics.AccessibilityAction<*>");
                AccessibilityAction accessibilityAction = (AccessibilityAction) obj;
                Map<SemanticsPropertyKey<?>, Object> map = this.props;
                String label = accessibilityAction.getLabel();
                if (label == null) {
                    label = ((AccessibilityAction) value).getLabel();
                }
                Function action = accessibilityAction.getAction();
                if (action == null) {
                    action = ((AccessibilityAction) value).getAction();
                }
                map.put(key, new AccessibilityAction(label, action));
            }
        }
    }

    public final <T> boolean contains(@NotNull SemanticsPropertyKey<T> semanticsPropertyKey) {
        Intrinsics.checkNotNullParameter(semanticsPropertyKey, "key");
        return this.props.containsKey(semanticsPropertyKey);
    }

    @NotNull
    public final SemanticsConfiguration copy() {
        SemanticsConfiguration semanticsConfiguration = new SemanticsConfiguration();
        semanticsConfiguration.isMergingSemanticsOfDescendants = this.isMergingSemanticsOfDescendants;
        semanticsConfiguration.isClearingSemantics = this.isClearingSemantics;
        semanticsConfiguration.props.putAll(this.props);
        return semanticsConfiguration;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SemanticsConfiguration)) {
            return false;
        }
        SemanticsConfiguration semanticsConfiguration = (SemanticsConfiguration) obj;
        return Intrinsics.areEqual(this.props, semanticsConfiguration.props) && this.isMergingSemanticsOfDescendants == semanticsConfiguration.isMergingSemanticsOfDescendants && this.isClearingSemantics == semanticsConfiguration.isClearingSemantics;
    }

    public final <T> T get(@NotNull SemanticsPropertyKey<T> semanticsPropertyKey) {
        Intrinsics.checkNotNullParameter(semanticsPropertyKey, "key");
        T t = (T) this.props.get(semanticsPropertyKey);
        if (t != null) {
            return t;
        }
        throw new IllegalStateException("Key not present: " + semanticsPropertyKey + " - consider getOrElse or getOrNull");
    }

    public final <T> T getOrElse(@NotNull SemanticsPropertyKey<T> semanticsPropertyKey, @NotNull Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(semanticsPropertyKey, "key");
        Intrinsics.checkNotNullParameter(function0, "defaultValue");
        T t = (T) this.props.get(semanticsPropertyKey);
        return t == null ? (T) function0.invoke() : t;
    }

    @Nullable
    public final <T> T getOrElseNullable(@NotNull SemanticsPropertyKey<T> semanticsPropertyKey, @NotNull Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(semanticsPropertyKey, "key");
        Intrinsics.checkNotNullParameter(function0, "defaultValue");
        T t = (T) this.props.get(semanticsPropertyKey);
        return t == null ? (T) function0.invoke() : t;
    }

    public int hashCode() {
        return (((this.props.hashCode() * 31) + l3.a(this.isMergingSemanticsOfDescendants)) * 31) + l3.a(this.isClearingSemantics);
    }

    public final boolean isClearingSemantics() {
        return this.isClearingSemantics;
    }

    public final boolean isMergingSemanticsOfDescendants() {
        return this.isMergingSemanticsOfDescendants;
    }

    @Override // java.lang.Iterable
    @NotNull
    public Iterator<Map.Entry<? extends SemanticsPropertyKey<?>, ? extends Object>> iterator() {
        return this.props.entrySet().iterator();
    }

    public final void mergeChild$ui_release(@NotNull SemanticsConfiguration semanticsConfiguration) {
        Intrinsics.checkNotNullParameter(semanticsConfiguration, "child");
        for (Map.Entry<SemanticsPropertyKey<?>, Object> entry : semanticsConfiguration.props.entrySet()) {
            SemanticsPropertyKey<?> key = entry.getKey();
            Object value = entry.getValue();
            Object obj = this.props.get(key);
            Intrinsics.checkNotNull(key, "null cannot be cast to non-null type androidx.compose.ui.semantics.SemanticsPropertyKey<kotlin.Any?>");
            Object merge = key.merge(obj, value);
            if (merge != null) {
                this.props.put(key, merge);
            }
        }
    }

    @Override // androidx.compose.ui.semantics.SemanticsPropertyReceiver
    public <T> void set(@NotNull SemanticsPropertyKey<T> semanticsPropertyKey, T t) {
        Intrinsics.checkNotNullParameter(semanticsPropertyKey, "key");
        this.props.put(semanticsPropertyKey, t);
    }

    public final void setClearingSemantics(boolean z) {
        this.isClearingSemantics = z;
    }

    public final void setMergingSemanticsOfDescendants(boolean z) {
        this.isMergingSemanticsOfDescendants = z;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String str = "";
        if (this.isMergingSemanticsOfDescendants) {
            sb.append("");
            sb.append("mergeDescendants=true");
            str = ", ";
        }
        if (this.isClearingSemantics) {
            sb.append(str);
            sb.append("isClearingSemantics=true");
            str = ", ";
        }
        for (Map.Entry<SemanticsPropertyKey<?>, Object> entry : this.props.entrySet()) {
            SemanticsPropertyKey<?> key = entry.getKey();
            Object value = entry.getValue();
            sb.append(str);
            sb.append(key.getName());
            sb.append(" : ");
            sb.append(value);
            str = ", ";
        }
        return JvmActuals_jvmKt.simpleIdentityToString(this, (String) null) + "{ " + ((Object) sb) + " }";
    }
}
