package androidx.compose.ui.text.font;

import android.taobao.windvane.urlintercept.WVURLRuleConstants;
import androidx.compose.runtime.Immutable;
import androidx.constraintlayout.core.motion.utils.TypedValues$Custom;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Immutable
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class FontWeight implements Comparable<FontWeight> {

    @NotNull
    private static final FontWeight Black;

    @NotNull
    private static final FontWeight Bold;

    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @NotNull
    private static final FontWeight ExtraBold;

    @NotNull
    private static final FontWeight ExtraLight;

    @NotNull
    private static final FontWeight Light;

    @NotNull
    private static final FontWeight Medium;

    @NotNull
    private static final FontWeight Normal;

    @NotNull
    private static final FontWeight SemiBold;

    @NotNull
    private static final FontWeight Thin;

    @NotNull
    private static final FontWeight W100;

    @NotNull
    private static final FontWeight W200;

    @NotNull
    private static final FontWeight W300;

    @NotNull
    private static final FontWeight W400;

    @NotNull
    private static final FontWeight W500;

    @NotNull
    private static final FontWeight W600;

    @NotNull
    private static final FontWeight W700;

    @NotNull
    private static final FontWeight W800;

    @NotNull
    private static final FontWeight W900;

    @NotNull
    private static final List<FontWeight> values;
    private final int weight;

    static {
        FontWeight fontWeight = new FontWeight(100);
        W100 = fontWeight;
        FontWeight fontWeight2 = new FontWeight(WVURLRuleConstants.SEARCH);
        W200 = fontWeight2;
        FontWeight fontWeight3 = new FontWeight(WVURLRuleConstants.SHOP);
        W300 = fontWeight3;
        FontWeight fontWeight4 = new FontWeight(WVURLRuleConstants.CART);
        W400 = fontWeight4;
        FontWeight fontWeight5 = new FontWeight(WVURLRuleConstants.ORDER_LIST);
        W500 = fontWeight5;
        FontWeight fontWeight6 = new FontWeight(600);
        W600 = fontWeight6;
        FontWeight fontWeight7 = new FontWeight(700);
        W700 = fontWeight7;
        FontWeight fontWeight8 = new FontWeight(WVURLRuleConstants.ADDRESS);
        W800 = fontWeight8;
        FontWeight fontWeight9 = new FontWeight(TypedValues$Custom.TYPE_INT);
        W900 = fontWeight9;
        Thin = fontWeight;
        ExtraLight = fontWeight2;
        Light = fontWeight3;
        Normal = fontWeight4;
        Medium = fontWeight5;
        SemiBold = fontWeight6;
        Bold = fontWeight7;
        ExtraBold = fontWeight8;
        Black = fontWeight9;
        values = CollectionsKt.listOf(new FontWeight[]{fontWeight, fontWeight2, fontWeight3, fontWeight4, fontWeight5, fontWeight6, fontWeight7, fontWeight8, fontWeight9});
    }

    public FontWeight(int i) {
        this.weight = i;
        boolean z = false;
        if (1 <= i && i < 1001) {
            z = true;
        }
        if (z) {
            return;
        }
        throw new IllegalArgumentException(("Font weight can be in range [1, 1000]. Current value: " + i).toString());
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FontWeight) && this.weight == ((FontWeight) obj).weight;
    }

    public final int getWeight() {
        return this.weight;
    }

    public int hashCode() {
        return this.weight;
    }

    @NotNull
    public String toString() {
        return "FontWeight(weight=" + this.weight + ')';
    }

    @Override // java.lang.Comparable
    public int compareTo(@NotNull FontWeight fontWeight) {
        Intrinsics.checkNotNullParameter(fontWeight, "other");
        return Intrinsics.compare(this.weight, fontWeight.weight);
    }
}
