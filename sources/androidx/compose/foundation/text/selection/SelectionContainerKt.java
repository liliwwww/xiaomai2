package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.ContextMenu_androidKt;
import androidx.compose.foundation.text.TouchMode_androidKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.platform.ClipboardManager;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.TextToolbar;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class SelectionContainerKt {
    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final void DisableSelection(@NotNull final Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(function2, "content");
        Composer startRestartGroup = composer.startRestartGroup(336063542);
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 11) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(336063542, i2, -1, "androidx.compose.foundation.text.selection.DisableSelection (SelectionContainer.kt:60)");
            }
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{SelectionRegistrarKt.getLocalSelectionRegistrar().provides((Object) null)}, function2, startRestartGroup, ((i2 << 3) & 112) | 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt$DisableSelection$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable Composer composer2, int i3) {
                SelectionContainerKt.DisableSelection(function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x008a, code lost:
    
        if (r5 == r1.getEmpty()) goto L41;
     */
    @androidx.compose.runtime.Composable
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void SelectionContainer(@org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r8, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r9, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r10, int r11, int r12) {
        /*
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            r0 = -1075498320(0xffffffffbfe532b0, float:-1.7906094)
            androidx.compose.runtime.Composer r10 = r10.startRestartGroup(r0)
            r1 = r12 & 1
            r2 = 2
            if (r1 == 0) goto L14
            r3 = r11 | 6
            goto L24
        L14:
            r3 = r11 & 14
            if (r3 != 0) goto L23
            boolean r3 = r10.changed(r8)
            if (r3 == 0) goto L20
            r3 = 4
            goto L21
        L20:
            r3 = 2
        L21:
            r3 = r3 | r11
            goto L24
        L23:
            r3 = r11
        L24:
            r4 = r12 & 2
            if (r4 == 0) goto L2b
            r3 = r3 | 48
            goto L3b
        L2b:
            r4 = r11 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L3b
            boolean r4 = r10.changedInstance(r9)
            if (r4 == 0) goto L38
            r4 = 32
            goto L3a
        L38:
            r4 = 16
        L3a:
            r3 = r3 | r4
        L3b:
            r4 = r3 & 91
            r5 = 18
            if (r4 != r5) goto L4c
            boolean r4 = r10.getSkipping()
            if (r4 != 0) goto L48
            goto L4c
        L48:
            r10.skipToGroupEnd()
            goto Lb3
        L4c:
            if (r1 == 0) goto L50
            androidx.compose.ui.Modifier$Companion r8 = androidx.compose.ui.Modifier.Companion
        L50:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L5c
            r1 = -1
            java.lang.String r4 = "androidx.compose.foundation.text.selection.SelectionContainer (SelectionContainer.kt:41)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r3, r1, r4)
        L5c:
            java.lang.Object r0 = r10.rememberedValue()
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r1.getEmpty()
            if (r0 != r4) goto L70
            r0 = 0
            androidx.compose.runtime.MutableState r0 = androidx.compose.runtime.SnapshotStateKt.mutableStateOf$default(r0, r0, r2, r0)
            r10.updateRememberedValue(r0)
        L70:
            androidx.compose.runtime.MutableState r0 = (androidx.compose.runtime.MutableState) r0
            androidx.compose.foundation.text.selection.Selection r2 = SelectionContainer$lambda$1(r0)
            r4 = 1157296644(0x44faf204, float:2007.563)
            r10.startReplaceableGroup(r4)
            boolean r4 = r10.changed(r0)
            java.lang.Object r5 = r10.rememberedValue()
            if (r4 != 0) goto L8c
            java.lang.Object r1 = r1.getEmpty()
            if (r5 != r1) goto L94
        L8c:
            androidx.compose.foundation.text.selection.SelectionContainerKt$SelectionContainer$1$1 r5 = new androidx.compose.foundation.text.selection.SelectionContainerKt$SelectionContainer$1$1
            r5.<init>(r0)
            r10.updateRememberedValue(r5)
        L94:
            r10.endReplaceableGroup()
            r0 = r5
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r1 = r3 & 14
            int r3 = r3 << 6
            r3 = r3 & 7168(0x1c00, float:1.0045E-41)
            r6 = r1 | r3
            r7 = 0
            r1 = r8
            r3 = r0
            r4 = r9
            r5 = r10
            SelectionContainer(r1, r2, r3, r4, r5, r6, r7)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto Lb3
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        Lb3:
            androidx.compose.runtime.ScopeUpdateScope r10 = r10.endRestartGroup()
            if (r10 != 0) goto Lba
            goto Lc2
        Lba:
            androidx.compose.foundation.text.selection.SelectionContainerKt$SelectionContainer$2 r0 = new androidx.compose.foundation.text.selection.SelectionContainerKt$SelectionContainer$2
            r0.<init>(r8, r9, r11, r12)
            r10.updateScope(r0)
        Lc2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.SelectionContainerKt.SelectionContainer(androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final Selection SelectionContainer$lambda$1(MutableState<Selection> mutableState) {
        return (Selection) mutableState.getValue();
    }

    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    public static final void SelectionContainer(@Nullable Modifier modifier, @Nullable Selection selection, @NotNull Function1<? super Selection, Unit> function1, @NotNull Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Composer composer, int i, int i2) {
        int i3;
        Intrinsics.checkNotNullParameter(function1, "onSelectionChange");
        Intrinsics.checkNotNullParameter(function2, "children");
        Composer startRestartGroup = composer.startRestartGroup(2078139907);
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (startRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            i3 |= startRestartGroup.changed(selection) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 896) == 0) {
            i3 |= startRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if ((i2 & 8) != 0) {
            i3 |= 3072;
        } else if ((i & 7168) == 0) {
            i3 |= startRestartGroup.changedInstance(function2) ? AccessibilityEventCompat.TYPE_WINDOW_CONTENT_CHANGED : AccessibilityEventCompat.TYPE_TOUCH_EXPLORATION_GESTURE_END;
        }
        int i5 = i3;
        if ((i5 & 5851) == 1170 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (i4 != 0) {
                modifier = Modifier.Companion;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2078139907, i5, -1, "androidx.compose.foundation.text.selection.SelectionContainer (SelectionContainer.kt:75)");
            }
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = new SelectionRegistrarImpl();
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            SelectionRegistrarImpl selectionRegistrarImpl = (SelectionRegistrarImpl) rememberedValue;
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = new SelectionManager(selectionRegistrarImpl);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            SelectionManager selectionManager = (SelectionManager) rememberedValue2;
            selectionManager.setHapticFeedBack((HapticFeedback) startRestartGroup.consume(CompositionLocalsKt.getLocalHapticFeedback()));
            selectionManager.setClipboardManager((ClipboardManager) startRestartGroup.consume(CompositionLocalsKt.getLocalClipboardManager()));
            selectionManager.setTextToolbar((TextToolbar) startRestartGroup.consume(CompositionLocalsKt.getLocalTextToolbar()));
            selectionManager.setOnSelectionChange(function1);
            selectionManager.setSelection(selection);
            selectionManager.setTouchMode(TouchMode_androidKt.isInTouchMode());
            ContextMenu_androidKt.ContextMenuArea(selectionManager, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(startRestartGroup, -123806316, true, new SelectionContainer.3(selectionRegistrarImpl, modifier, selectionManager, function2, i5)), startRestartGroup, 56);
            EffectsKt.DisposableEffect(selectionManager, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) new SelectionContainer.4(selectionManager), startRestartGroup, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        Modifier modifier2 = modifier;
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new SelectionContainer.5(modifier2, selection, function1, function2, i, i2));
    }
}
