package androidx.compose.ui.tooling.preview.datasource;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.tooling.preview.PreviewParameterProvider;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.iy3;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class LoremIpsum implements PreviewParameterProvider<String> {
    public static final int $stable = 0;
    private final int words;

    public LoremIpsum(int i) {
        this.words = i;
    }

    private final String generateLoremIpsum(int i) {
        List list;
        final Ref.IntRef intRef = new Ref.IntRef();
        list = LoremIpsumKt.LOREM_IPSUM_SOURCE;
        final int size = list.size();
        return SequencesKt.joinToString$default(SequencesKt.take(SequencesKt.generateSequence(new Function0<String>() { // from class: androidx.compose.ui.tooling.preview.datasource.LoremIpsum$generateLoremIpsum$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Nullable
            public final String invoke() {
                List list2;
                list2 = LoremIpsumKt.LOREM_IPSUM_SOURCE;
                Ref.IntRef intRef2 = intRef;
                int i2 = intRef2.element;
                intRef2.element = i2 + 1;
                return (String) list2.get(i2 % size);
            }
        }), i), " ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }

    @Override // androidx.compose.ui.tooling.preview.PreviewParameterProvider
    public /* synthetic */ int getCount() {
        return iy3.a(this);
    }

    @Override // androidx.compose.ui.tooling.preview.PreviewParameterProvider
    @NotNull
    public Sequence<String> getValues() {
        return SequencesKt.sequenceOf(new String[]{generateLoremIpsum(this.words)});
    }

    public LoremIpsum() {
        this(500);
    }
}
