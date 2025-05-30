package androidx.compose.p004ui.modifier;

import androidx.compose.p004ui.ExperimentalComposeUiApi;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class ModifierLocalNodeKt {
    @ExperimentalComposeUiApi
    @NotNull
    public static final ModifierLocalMap modifierLocalMapOf() {
        return EmptyMap.INSTANCE;
    }

    @ExperimentalComposeUiApi
    @NotNull
    public static final <T> ModifierLocalMap modifierLocalMapOf(@NotNull ModifierLocal<T> modifierLocal) {
        Intrinsics.checkNotNullParameter(modifierLocal, "key");
        return new SingleLocalMap(modifierLocal);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @ExperimentalComposeUiApi
    @NotNull
    public static final <T> ModifierLocalMap modifierLocalMapOf(@NotNull Pair<? extends ModifierLocal<T>, ? extends T> pair) {
        Intrinsics.checkNotNullParameter(pair, "entry");
        SingleLocalMap singleLocalMap = new SingleLocalMap((ModifierLocal) pair.getFirst());
        singleLocalMap.mo4260set$ui_release((ModifierLocal) pair.getFirst(), pair.getSecond());
        return singleLocalMap;
    }

    @ExperimentalComposeUiApi
    @NotNull
    public static final ModifierLocalMap modifierLocalMapOf(@NotNull Pair<? extends ModifierLocal<?>, ? extends Object>... pairArr) {
        Intrinsics.checkNotNullParameter(pairArr, "entries");
        return new MultiLocalMap((Pair[]) Arrays.copyOf(pairArr, pairArr.length));
    }

    @ExperimentalComposeUiApi
    @NotNull
    public static final ModifierLocalMap modifierLocalMapOf(@NotNull ModifierLocal<?>... modifierLocalArr) {
        Intrinsics.checkNotNullParameter(modifierLocalArr, "keys");
        ArrayList arrayList = new ArrayList(modifierLocalArr.length);
        for (ModifierLocal<?> modifierLocal : modifierLocalArr) {
            arrayList.add(TuplesKt.to(modifierLocal, (Object) null));
        }
        Pair[] pairArr = (Pair[]) arrayList.toArray(new Pair[0]);
        return new MultiLocalMap((Pair[]) Arrays.copyOf(pairArr, pairArr.length));
    }
}
