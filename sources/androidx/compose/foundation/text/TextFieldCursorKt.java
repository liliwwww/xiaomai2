package androidx.compose.foundation.text;

import android.taobao.windvane.urlintercept.WVURLRuleConstants;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.KeyframesSpec;
import androidx.compose.p004ui.ComposedModifierKt;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.graphics.Brush;
import androidx.compose.p004ui.text.input.OffsetMapping;
import androidx.compose.p004ui.text.input.TextFieldValue;
import androidx.compose.p004ui.unit.C0856Dp;
import androidx.compose.runtime.Composer;
import androidx.room.RoomDatabase;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class TextFieldCursorKt {

    @NotNull
    private static final AnimationSpec<Float> cursorAnimationSpec = AnimationSpecKt.m1048infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.foundation.text.TextFieldCursorKt$cursorAnimationSpec$1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((KeyframesSpec.KeyframesSpecConfig<Float>) obj);
            return Unit.INSTANCE;
        }

        public final void invoke(@NotNull KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
            Intrinsics.checkNotNullParameter(keyframesSpecConfig, "$this$keyframes");
            keyframesSpecConfig.setDurationMillis(1000);
            Float valueOf = Float.valueOf(1.0f);
            keyframesSpecConfig.m55at(valueOf, 0);
            keyframesSpecConfig.m55at(valueOf, 499);
            Float valueOf2 = Float.valueOf(0.0f);
            keyframesSpecConfig.m55at(valueOf2, WVURLRuleConstants.ORDER_LIST);
            keyframesSpecConfig.m55at(valueOf2, RoomDatabase.MAX_BIND_PARAMETER_CNT);
        }
    }), null, 0, 6, null);
    private static final float DefaultCursorThickness = C0856Dp.m5216constructorimpl(2);

    @NotNull
    public static final Modifier cursor(@NotNull Modifier modifier, @NotNull final TextFieldState textFieldState, @NotNull final TextFieldValue textFieldValue, @NotNull final OffsetMapping offsetMapping, @NotNull final Brush brush, boolean z) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(textFieldState, "state");
        Intrinsics.checkNotNullParameter(textFieldValue, "value");
        Intrinsics.checkNotNullParameter(offsetMapping, "offsetMapping");
        Intrinsics.checkNotNullParameter(brush, "cursorBrush");
        return z ? ComposedModifierKt.composed$default(modifier, null, new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.text.TextFieldCursorKt$cursor$1

            /* compiled from: Taobao */
            @DebugMetadata(c = "androidx.compose.foundation.text.TextFieldCursorKt$cursor$1$1", f = "TextFieldCursor.kt", i = {}, l = {50, 52}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: androidx.compose.foundation.text.TextFieldCursorKt$cursor$1$1 */
            static final class C05881 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ Animatable<Float, AnimationVector1D> $cursorAlpha;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C05881(Animatable<Float, AnimationVector1D> animatable, Continuation<? super C05881> continuation) {
                    super(2, continuation);
                    this.$cursorAlpha = animatable;
                }

                @NotNull
                public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                    return new C05881(this.$cursorAlpha, continuation);
                }

                @Nullable
                public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                    return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
                }

                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    AnimationSpec animationSpec;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        Animatable<Float, AnimationVector1D> animatable = this.$cursorAlpha;
                        Float boxFloat = Boxing.boxFloat(1.0f);
                        this.label = 1;
                        if (animatable.snapTo(boxFloat, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            if (i != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                            return Unit.INSTANCE;
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    Animatable<Float, AnimationVector1D> animatable2 = this.$cursorAlpha;
                    Float boxFloat2 = Boxing.boxFloat(0.0f);
                    animationSpec = TextFieldCursorKt.cursorAnimationSpec;
                    this.label = 2;
                    if (Animatable.animateTo$default(animatable2, boxFloat2, animationSpec, null, null, this, 12, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
            }

            /* JADX WARN: Code restructure failed: missing block: B:12:0x004d, code lost:
            
                if ((((androidx.compose.p004ui.graphics.SolidColor) r12).m3074getValue0d7_KjU() == androidx.compose.p004ui.graphics.Color.Companion.m2823getUnspecified0d7_KjU()) == false) goto L15;
             */
            @androidx.compose.runtime.Composable
            @org.jetbrains.annotations.NotNull
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final androidx.compose.p004ui.Modifier invoke(@org.jetbrains.annotations.NotNull androidx.compose.p004ui.Modifier r10, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r11, int r12) {
                /*
                    r9 = this;
                    java.lang.String r0 = "$this$composed"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
                    r0 = 1634330012(0x6169e59c, float:2.6966478E20)
                    r11.startReplaceableGroup(r0)
                    boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
                    if (r1 == 0) goto L17
                    r1 = -1
                    java.lang.String r2 = "androidx.compose.foundation.text.cursor.<anonymous> (TextFieldCursor.kt:43)"
                    androidx.compose.runtime.ComposerKt.traceEventStart(r0, r12, r1, r2)
                L17:
                    java.lang.Object r12 = r11.rememberedValue()
                    androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
                    java.lang.Object r0 = r0.getEmpty()
                    r1 = 0
                    if (r12 != r0) goto L2f
                    r12 = 1065353216(0x3f800000, float:1.0)
                    r0 = 0
                    r2 = 2
                    androidx.compose.animation.core.Animatable r12 = androidx.compose.animation.core.AnimatableKt.Animatable$default(r12, r0, r2, r1)
                    r11.updateRememberedValue(r12)
                L2f:
                    r3 = r12
                    androidx.compose.animation.core.Animatable r3 = (androidx.compose.animation.core.Animatable) r3
                    androidx.compose.ui.graphics.Brush r12 = androidx.compose.p004ui.graphics.Brush.this
                    boolean r0 = r12 instanceof androidx.compose.p004ui.graphics.SolidColor
                    r2 = 0
                    r4 = 1
                    if (r0 == 0) goto L4f
                    androidx.compose.ui.graphics.SolidColor r12 = (androidx.compose.p004ui.graphics.SolidColor) r12
                    long r5 = r12.m3074getValue0d7_KjU()
                    androidx.compose.ui.graphics.Color$Companion r12 = androidx.compose.p004ui.graphics.Color.Companion
                    long r7 = r12.m2823getUnspecified0d7_KjU()
                    int r12 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                    if (r12 != 0) goto L4c
                    r12 = 1
                    goto L4d
                L4c:
                    r12 = 0
                L4d:
                    if (r12 != 0) goto L50
                L4f:
                    r2 = 1
                L50:
                    androidx.compose.foundation.text.TextFieldState r12 = r2
                    boolean r12 = r12.getHasFocus()
                    if (r12 == 0) goto L93
                    androidx.compose.ui.text.input.TextFieldValue r12 = r3
                    long r4 = r12.m4956getSelectiond9O1mEE()
                    boolean r12 = androidx.compose.p004ui.text.TextRange.m4743getCollapsedimpl(r4)
                    if (r12 == 0) goto L93
                    if (r2 == 0) goto L93
                    androidx.compose.ui.text.input.TextFieldValue r12 = r3
                    androidx.compose.ui.text.AnnotatedString r12 = r12.getAnnotatedString()
                    androidx.compose.ui.text.input.TextFieldValue r0 = r3
                    long r4 = r0.m4956getSelectiond9O1mEE()
                    androidx.compose.ui.text.TextRange r0 = androidx.compose.p004ui.text.TextRange.m4737boximpl(r4)
                    androidx.compose.foundation.text.TextFieldCursorKt$cursor$1$1 r2 = new androidx.compose.foundation.text.TextFieldCursorKt$cursor$1$1
                    r2.<init>(r3, r1)
                    r1 = 512(0x200, float:7.17E-43)
                    androidx.compose.runtime.EffectsKt.LaunchedEffect(r12, r0, r2, r11, r1)
                    androidx.compose.foundation.text.TextFieldCursorKt$cursor$1$2 r12 = new androidx.compose.foundation.text.TextFieldCursorKt$cursor$1$2
                    androidx.compose.ui.text.input.OffsetMapping r4 = r4
                    androidx.compose.ui.text.input.TextFieldValue r5 = r3
                    androidx.compose.foundation.text.TextFieldState r6 = r2
                    androidx.compose.ui.graphics.Brush r7 = androidx.compose.p004ui.graphics.Brush.this
                    r2 = r12
                    r2.<init>()
                    androidx.compose.ui.Modifier r10 = androidx.compose.p004ui.draw.DrawModifierKt.drawWithContent(r10, r12)
                    goto L95
                L93:
                    androidx.compose.ui.Modifier$Companion r10 = androidx.compose.p004ui.Modifier.Companion
                L95:
                    boolean r12 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
                    if (r12 == 0) goto L9e
                    androidx.compose.runtime.ComposerKt.traceEventEnd()
                L9e:
                    r11.endReplaceableGroup()
                    return r10
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.TextFieldCursorKt$cursor$1.invoke(androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int):androidx.compose.ui.Modifier");
            }
        }, 1, null) : modifier;
    }

    public static final float getDefaultCursorThickness() {
        return DefaultCursorThickness;
    }
}
