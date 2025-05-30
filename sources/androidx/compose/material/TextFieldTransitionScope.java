package androidx.compose.material;

import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class TextFieldTransitionScope {

    @NotNull
    public static final TextFieldTransitionScope INSTANCE = new TextFieldTransitionScope();

    /* compiled from: Taobao */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[InputPhase.values().length];
            iArr[InputPhase.Focused.ordinal()] = 1;
            iArr[InputPhase.UnfocusedEmpty.ordinal()] = 2;
            iArr[InputPhase.UnfocusedNotEmpty.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private TextFieldTransitionScope() {
    }

    /* renamed from: Transition_DTcfvLk$lambda-1, reason: not valid java name */
    private static final float m872Transition_DTcfvLk$lambda1(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* renamed from: Transition_DTcfvLk$lambda-3, reason: not valid java name */
    private static final float m873Transition_DTcfvLk$lambda3(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* renamed from: Transition_DTcfvLk$lambda-5, reason: not valid java name */
    private static final long m874Transition_DTcfvLk$lambda5(State<Color> state) {
        return state.getValue().unbox-impl();
    }

    /* renamed from: Transition_DTcfvLk$lambda-6, reason: not valid java name */
    private static final long m875Transition_DTcfvLk$lambda6(State<Color> state) {
        return state.getValue().unbox-impl();
    }

    /* JADX WARN: Code restructure failed: missing block: B:146:0x035c, code lost:
    
        if (r12 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L164;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x01fa, code lost:
    
        if (r32 != false) goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x01bd, code lost:
    
        if (r32 != false) goto L98;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x024a  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x02dd  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x02e9  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x02f4  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0356  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0408  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x02bc  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01c8  */
    @androidx.compose.runtime.Composable
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[0[0][0]]")
    /* renamed from: Transition-DTcfvLk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m876TransitionDTcfvLk(@org.jetbrains.annotations.NotNull final androidx.compose.material.InputPhase r26, final long r27, final long r29, @org.jetbrains.annotations.NotNull final kotlin.jvm.functions.Function3<? super androidx.compose.material.InputPhase, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, androidx.compose.ui.graphics.Color> r31, final boolean r32, @org.jetbrains.annotations.NotNull final kotlin.jvm.functions.Function6<? super java.lang.Float, ? super androidx.compose.ui.graphics.Color, ? super androidx.compose.ui.graphics.Color, ? super java.lang.Float, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r33, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r34, final int r35) {
        /*
            Method dump skipped, instructions count: 1068
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextFieldTransitionScope.m876TransitionDTcfvLk(androidx.compose.material.InputPhase, long, long, kotlin.jvm.functions.Function3, boolean, kotlin.jvm.functions.Function6, androidx.compose.runtime.Composer, int):void");
    }
}
