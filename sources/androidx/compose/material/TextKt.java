package androidx.compose.material;

import androidx.compose.p004ui.text.TextStyle;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class TextKt {

    @NotNull
    private static final ProvidableCompositionLocal<TextStyle> LocalTextStyle = CompositionLocalKt.compositionLocalOf(SnapshotStateKt.structuralEqualityPolicy(), new Function0<TextStyle>() { // from class: androidx.compose.material.TextKt$LocalTextStyle$1
        @NotNull
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final TextStyle m2333invoke() {
            return TextStyle.Companion.getDefault();
        }
    });

    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final void ProvideTextStyle(@NotNull final TextStyle textStyle, @NotNull final Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(textStyle, "value");
        Intrinsics.checkNotNullParameter(function2, "content");
        Composer startRestartGroup = composer.startRestartGroup(1772272796);
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed(textStyle) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= startRestartGroup.changed(function2) ? 32 : 16;
        }
        if ((i2 & 91) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1772272796, i2, -1, "androidx.compose.material.ProvideTextStyle (Text.kt:262)");
            }
            ProvidableCompositionLocal<TextStyle> providableCompositionLocal = LocalTextStyle;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{providableCompositionLocal.provides(((TextStyle) startRestartGroup.consume(providableCompositionLocal)).merge(textStyle))}, function2, startRestartGroup, (i2 & 112) | 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextKt$ProvideTextStyle$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable Composer composer2, int i3) {
                TextKt.ProvideTextStyle(TextStyle.this, function2, composer2, i | 1);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x034f  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x033b  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x02a6  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x02ac  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x02ba  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x02c5  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x02cc  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x02d0  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x02db  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x02e6  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x02f4  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0302  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x030b  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x031c  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0305  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x02fe  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x02f0  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x02e8  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x02e2  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x02c7  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x02c1  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x02b6  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x02a8  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x02a1  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0441  */
    /* JADX WARN: Removed duplicated region for block: B:75:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0330  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x034d  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0352  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0419  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0357  */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    /* renamed from: Text--4IGK_g, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m2331Text4IGK_g(@org.jetbrains.annotations.NotNull final androidx.compose.p004ui.text.AnnotatedString r63, @org.jetbrains.annotations.Nullable androidx.compose.p004ui.Modifier r64, long r65, long r67, @org.jetbrains.annotations.Nullable androidx.compose.p004ui.text.font.FontStyle r69, @org.jetbrains.annotations.Nullable androidx.compose.p004ui.text.font.FontWeight r70, @org.jetbrains.annotations.Nullable androidx.compose.p004ui.text.font.FontFamily r71, long r72, @org.jetbrains.annotations.Nullable androidx.compose.p004ui.text.style.TextDecoration r74, @org.jetbrains.annotations.Nullable androidx.compose.p004ui.text.style.TextAlign r75, long r76, int r78, boolean r79, int r80, @org.jetbrains.annotations.Nullable java.util.Map<java.lang.String, androidx.compose.foundation.text.InlineTextContent> r81, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function1<? super androidx.compose.p004ui.text.TextLayoutResult, kotlin.Unit> r82, @org.jetbrains.annotations.Nullable androidx.compose.p004ui.text.TextStyle r83, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r84, final int r85, final int r86, final int r87) {
        /*
            Method dump skipped, instructions count: 1118
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextKt.m2331Text4IGK_g(androidx.compose.ui.text.AnnotatedString, androidx.compose.ui.Modifier, long, long, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontFamily, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.text.style.TextAlign, long, int, boolean, int, java.util.Map, kotlin.jvm.functions.Function1, androidx.compose.ui.text.TextStyle, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x031a  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0279  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0298  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x029f  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x02a6  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x02b1  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x02bd  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x02c8  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x02d3  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x02d9  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x02e1  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x02e4  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x02dd  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x02d5  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x029b  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x03fc  */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0300  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0318  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x031d  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x03da  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0322  */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    /* renamed from: Text-fLXpl1I, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m2332TextfLXpl1I(@org.jetbrains.annotations.NotNull final java.lang.String r60, @org.jetbrains.annotations.Nullable androidx.compose.p004ui.Modifier r61, long r62, long r64, @org.jetbrains.annotations.Nullable androidx.compose.p004ui.text.font.FontStyle r66, @org.jetbrains.annotations.Nullable androidx.compose.p004ui.text.font.FontWeight r67, @org.jetbrains.annotations.Nullable androidx.compose.p004ui.text.font.FontFamily r68, long r69, @org.jetbrains.annotations.Nullable androidx.compose.p004ui.text.style.TextDecoration r71, @org.jetbrains.annotations.Nullable androidx.compose.p004ui.text.style.TextAlign r72, long r73, int r75, boolean r76, int r77, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function1<? super androidx.compose.p004ui.text.TextLayoutResult, kotlin.Unit> r78, @org.jetbrains.annotations.Nullable androidx.compose.p004ui.text.TextStyle r79, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r80, final int r81, final int r82, final int r83) {
        /*
            Method dump skipped, instructions count: 1057
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextKt.m2332TextfLXpl1I(java.lang.String, androidx.compose.ui.Modifier, long, long, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontFamily, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.text.style.TextAlign, long, int, boolean, int, kotlin.jvm.functions.Function1, androidx.compose.ui.text.TextStyle, androidx.compose.runtime.Composer, int, int, int):void");
    }

    @NotNull
    public static final ProvidableCompositionLocal<TextStyle> getLocalTextStyle() {
        return LocalTextStyle;
    }
}
