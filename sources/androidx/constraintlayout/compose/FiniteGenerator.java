package androidx.constraintlayout.compose;

import android.taobao.windvane.extra.p002uc.AliRequestAdapter;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005¢\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006R\u0016\u0010\b\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0016\u0010\r\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\tR\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\tR\u0016\u0010\u0012\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\t¨\u0006\u0017"}, d2 = {"Landroidx/constraintlayout/compose/FiniteGenerator;", "Landroidx/constraintlayout/compose/GeneratedValue;", "", "value", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "array", "step", "F", "prefix", "Ljava/lang/String;", "postfix", "current", "", AliRequestAdapter.PHASE_STOP, "Z", "initial", "max", TypedValues.TransitionType.S_FROM, TypedValues.TransitionType.S_TO, "<init>", "(FFFLjava/lang/String;Ljava/lang/String;)V", "compose_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class FiniteGenerator implements GeneratedValue {
    private float current;
    private float initial;
    private float max;

    @NotNull
    private String postfix;

    @NotNull
    private String prefix;
    private float step;
    private boolean stop;

    public FiniteGenerator(float f, float f2, float f3, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "prefix");
        Intrinsics.checkNotNullParameter(str2, "postfix");
        this.step = f3;
        this.prefix = str;
        this.postfix = str2;
        this.current = f;
        this.initial = f;
        this.max = f2;
    }

    @NotNull
    public final ArrayList<String> array() {
        ArrayList<String> arrayList = new ArrayList<>();
        float f = this.initial;
        int i = (int) f;
        int i2 = (int) f;
        int i3 = (int) this.max;
        if (i2 <= i3) {
            while (true) {
                int i4 = i2 + 1;
                arrayList.add(this.prefix + i + this.postfix);
                i += (int) this.step;
                if (i2 == i3) {
                    break;
                }
                i2 = i4;
            }
        }
        return arrayList;
    }

    @Override // androidx.constraintlayout.compose.GeneratedValue
    public float value() {
        float f = this.current;
        if (f >= this.max) {
            this.stop = true;
        }
        if (!this.stop) {
            this.current = f + this.step;
        }
        return this.current;
    }

    public /* synthetic */ FiniteGenerator(float f, float f2, float f3, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, (i & 4) != 0 ? 1.0f : f3, (i & 8) != 0 ? "" : str, (i & 16) != 0 ? "" : str2);
    }
}
