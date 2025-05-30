package androidx.compose.p004ui.semantics;

import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.platform.InspectableValueKt;
import androidx.compose.p004ui.platform.InspectorInfo;
import androidx.compose.p004ui.platform.InspectorValueInfo;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.gw4;
import tb.mt2;
import tb.nt2;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class SemanticsModifierCore extends InspectorValueInfo implements SemanticsModifier {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static AtomicInteger lastIdentifier = new AtomicInteger(0);

    @NotNull
    private final SemanticsConfiguration semanticsConfiguration;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int generateSemanticsId() {
            return SemanticsModifierCore.lastIdentifier.addAndGet(1);
        }
    }

    public /* synthetic */ SemanticsModifierCore(boolean z, boolean z2, Function1 function1, Function1 function12, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, z2, function1, (i & 8) != 0 ? InspectableValueKt.getNoInspectorInfo() : function12);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.p004ui.Modifier
    public /* synthetic */ boolean all(Function1 function1) {
        return nt2.a(this, function1);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.p004ui.Modifier
    public /* synthetic */ boolean any(Function1 function1) {
        return nt2.b(this, function1);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SemanticsModifierCore) && Intrinsics.areEqual(getSemanticsConfiguration(), ((SemanticsModifierCore) obj).getSemanticsConfiguration());
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.p004ui.Modifier
    public /* synthetic */ Object foldIn(Object obj, Function2 function2) {
        return nt2.c(this, obj, function2);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.p004ui.Modifier
    public /* synthetic */ Object foldOut(Object obj, Function2 function2) {
        return nt2.d(this, obj, function2);
    }

    @Override // androidx.compose.p004ui.semantics.SemanticsModifier
    public /* synthetic */ int getId() {
        return gw4.a(this);
    }

    @Override // androidx.compose.p004ui.semantics.SemanticsModifier
    @NotNull
    public SemanticsConfiguration getSemanticsConfiguration() {
        return this.semanticsConfiguration;
    }

    public int hashCode() {
        return getSemanticsConfiguration().hashCode();
    }

    @Override // androidx.compose.p004ui.Modifier
    public /* synthetic */ Modifier then(Modifier modifier) {
        return mt2.a(this, modifier);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SemanticsModifierCore(boolean z, boolean z2, @NotNull Function1<? super SemanticsPropertyReceiver, Unit> function1, @NotNull Function1<? super InspectorInfo, Unit> function12) {
        super(function12);
        Intrinsics.checkNotNullParameter(function1, "properties");
        Intrinsics.checkNotNullParameter(function12, "inspectorInfo");
        SemanticsConfiguration semanticsConfiguration = new SemanticsConfiguration();
        semanticsConfiguration.setMergingSemanticsOfDescendants(z);
        semanticsConfiguration.setClearingSemantics(z2);
        function1.invoke(semanticsConfiguration);
        this.semanticsConfiguration = semanticsConfiguration;
    }
}
