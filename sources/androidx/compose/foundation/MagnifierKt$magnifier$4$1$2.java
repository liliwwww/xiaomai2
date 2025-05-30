package androidx.compose.foundation;

import androidx.compose.foundation.MagnifierKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class MagnifierKt$magnifier$4$1$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ MutableState<Offset> $anchorPositionInRoot$delegate;
    final /* synthetic */ Density $density;
    final /* synthetic */ State<Boolean> $isMagnifierShown$delegate;
    final /* synthetic */ PlatformMagnifier $magnifier;
    final /* synthetic */ Ref.LongRef $previousSize;
    final /* synthetic */ State<Offset> $sourceCenterInRoot$delegate;
    final /* synthetic */ State<Function1<Density, Offset>> $updatedMagnifierCenter$delegate;
    final /* synthetic */ State<Function1<DpSize, Unit>> $updatedOnSizeChanged$delegate;
    final /* synthetic */ State<Float> $updatedZoom$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MagnifierKt$magnifier$4$1$2(PlatformMagnifier platformMagnifier, Density density, State<Boolean> state, State<Offset> state2, State<? extends Function1<? super Density, Offset>> state3, MutableState<Offset> mutableState, State<Float> state4, Ref.LongRef longRef, State<? extends Function1<? super DpSize, Unit>> state5) {
        super(0);
        this.$magnifier = platformMagnifier;
        this.$density = density;
        this.$isMagnifierShown$delegate = state;
        this.$sourceCenterInRoot$delegate = state2;
        this.$updatedMagnifierCenter$delegate = state3;
        this.$anchorPositionInRoot$delegate = mutableState;
        this.$updatedZoom$delegate = state4;
        this.$previousSize = longRef;
        this.$updatedOnSizeChanged$delegate = state5;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m155invoke();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: collision with other method in class */
    public final void m155invoke() {
        if (!MagnifierKt.magnifier.4.access$invoke$lambda$10(this.$isMagnifierShown$delegate)) {
            this.$magnifier.dismiss();
            return;
        }
        PlatformMagnifier platformMagnifier = this.$magnifier;
        long access$invoke$lambda$8 = MagnifierKt.magnifier.4.access$invoke$lambda$8(this.$sourceCenterInRoot$delegate);
        Object invoke = MagnifierKt.magnifier.4.access$invoke$lambda$4(this.$updatedMagnifierCenter$delegate).invoke(this.$density);
        MutableState<Offset> mutableState = this.$anchorPositionInRoot$delegate;
        long j = ((Offset) invoke).unbox-impl();
        platformMagnifier.m165updateWko1d7g(access$invoke$lambda$8, OffsetKt.m1027isSpecifiedk4lQ0M(j) ? Offset.plus-MK-Hz9U(MagnifierKt.magnifier.4.access$invoke$lambda$1(mutableState), j) : Offset.Companion.m1023getUnspecifiedF1C5BW0(), MagnifierKt.magnifier.4.access$invoke$lambda$5(this.$updatedZoom$delegate));
        long m164getSizeYbymL2g = this.$magnifier.m164getSizeYbymL2g();
        Ref.LongRef longRef = this.$previousSize;
        Density density = this.$density;
        State<Function1<DpSize, Unit>> state = this.$updatedOnSizeChanged$delegate;
        if (IntSize.m2683equalsimpl0(m164getSizeYbymL2g, longRef.element)) {
            return;
        }
        longRef.element = m164getSizeYbymL2g;
        Function1 access$invoke$lambda$6 = MagnifierKt.magnifier.4.access$invoke$lambda$6(state);
        if (access$invoke$lambda$6 != null) {
            access$invoke$lambda$6.invoke(DpSize.box-impl(density.toDpSize-k-rfVVM(IntSizeKt.toSize-ozmzZPI(m164getSizeYbymL2g))));
        }
    }
}
