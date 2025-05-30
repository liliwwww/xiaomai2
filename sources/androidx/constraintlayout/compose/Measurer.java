package androidx.constraintlayout.compose;

import android.util.Log;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.BasicTextFieldKt;
import androidx.compose.foundation.text.BasicTextKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.p004ui.Alignment;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.draw.ClipKt;
import androidx.compose.p004ui.geometry.OffsetKt;
import androidx.compose.p004ui.geometry.Size;
import androidx.compose.p004ui.graphics.Brush;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.graphics.ColorFilter;
import androidx.compose.p004ui.graphics.ColorKt;
import androidx.compose.p004ui.graphics.GraphicsLayerScope;
import androidx.compose.p004ui.graphics.Shadow;
import androidx.compose.p004ui.graphics.TransformOriginKt;
import androidx.compose.p004ui.graphics.drawscope.DrawScope;
import androidx.compose.p004ui.layout.ContentScale;
import androidx.compose.p004ui.layout.LayoutIdKt;
import androidx.compose.p004ui.layout.LayoutKt;
import androidx.compose.p004ui.layout.Measurable;
import androidx.compose.p004ui.layout.MeasurePolicy;
import androidx.compose.p004ui.layout.MeasureScope;
import androidx.compose.p004ui.layout.Placeable;
import androidx.compose.p004ui.node.ComposeUiNode;
import androidx.compose.p004ui.platform.CompositionLocalsKt;
import androidx.compose.p004ui.res.PainterResources_androidKt;
import androidx.compose.p004ui.text.TextStyle;
import androidx.compose.p004ui.text.font.FontFamily;
import androidx.compose.p004ui.text.font.FontStyle;
import androidx.compose.p004ui.text.font.FontSynthesis;
import androidx.compose.p004ui.text.font.FontWeight;
import androidx.compose.p004ui.text.input.VisualTransformation;
import androidx.compose.p004ui.text.intl.LocaleList;
import androidx.compose.p004ui.text.style.BaselineShift;
import androidx.compose.p004ui.text.style.TextAlign;
import androidx.compose.p004ui.text.style.TextDecoration;
import androidx.compose.p004ui.text.style.TextDirection;
import androidx.compose.p004ui.text.style.TextGeometricTransform;
import androidx.compose.p004ui.text.style.TextIndent;
import androidx.compose.p004ui.unit.C0856Dp;
import androidx.compose.p004ui.unit.Constraints;
import androidx.compose.p004ui.unit.Density;
import androidx.compose.p004ui.unit.IntOffsetKt;
import androidx.compose.p004ui.unit.IntSizeKt;
import androidx.compose.p004ui.unit.LayoutDirection;
import androidx.compose.p004ui.unit.TextUnit;
import androidx.compose.p004ui.unit.TextUnitKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.state.WidgetFrame;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Guideline;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.w51;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0011\u0018\u00002\u00020\u00012\u00020\u0002B\b¢\u0006\u0005\b\u008b\u0001\u0010<JH\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0002J!\u0010\u0014\u001a\u00020\u0013*\b\u0012\u0004\u0012\u00020\u00050\u00102\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J)\u0010\u001c\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u0018H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001c\u0010 \u001a\u00020\u001f2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00160\u001dH\u0002J \u0010$\u001a\u00020\u00162\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u0016H\u0016J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010&\u001a\u00020%2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010)\u001a\u00020\u00132\b\u0010(\u001a\u0004\u0018\u00010'J\b\u0010*\u001a\u00020\u0013H\u0016JI\u0010:\u001a\u0002072\u0006\u0010,\u001a\u00020+2\u0006\u0010.\u001a\u00020-2\u0006\u00100\u001a\u00020/2\f\u00103\u001a\b\u0012\u0004\u0012\u000202012\u0006\u00104\u001a\u00020\u00052\u0006\u00106\u001a\u000205ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b8\u00109J\u000f\u0010=\u001a\u00020\u0013H\u0000¢\u0006\u0004\b;\u0010<J\u001d\u0010@\u001a\u00020\u00132\u0006\u0010,\u001a\u00020+H\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b>\u0010?J\u0018\u0010B\u001a\u00020\u0013*\u00020A2\f\u00103\u001a\b\u0012\u0004\u0012\u00020201J\b\u0010C\u001a\u00020\u0013H\u0016J\u001b\u0010G\u001a\u00020\u0013*\u00020D2\u0006\u0010F\u001a\u00020EH\u0007¢\u0006\u0004\bG\u0010HJ\u000f\u0010I\u001a\u00020\u0013H\u0007¢\u0006\u0004\bI\u0010JJ\u000e\u0010K\u001a\u00020\u00132\u0006\u00100\u001a\u00020/R\u0016\u0010L\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010MR$\u0010N\u001a\u0004\u0018\u00010'8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\u001c\u0010U\u001a\u00020T8\u0004@\u0004X\u0084\u0004¢\u0006\f\n\u0004\bU\u0010V\u001a\u0004\bW\u0010XR(\u0010[\u001a\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020Z0Y8\u0004@\u0004X\u0084\u0004¢\u0006\f\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^R(\u0010_\u001a\u0014\u0012\u0004\u0012\u000202\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00100Y8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b_\u0010\\R(\u0010a\u001a\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020`0Y8\u0004@\u0004X\u0084\u0004¢\u0006\f\n\u0004\ba\u0010\\\u001a\u0004\bb\u0010^R\"\u0010d\u001a\u00020c8\u0004@\u0004X\u0084.¢\u0006\u0012\n\u0004\bd\u0010e\u001a\u0004\bf\u0010g\"\u0004\bh\u0010iR\"\u00106\u001a\u0002058\u0004@\u0004X\u0084.¢\u0006\u0012\n\u0004\b6\u0010j\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR\u001d\u0010t\u001a\u00020o8D@\u0004X\u0084\u0084\u0002¢\u0006\f\n\u0004\bp\u0010q\u001a\u0004\br\u0010sR\u0016\u0010u\u001a\u00020\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bu\u0010vR\u0016\u0010w\u001a\u00020\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bw\u0010vR\"\u0010F\u001a\u00020E8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bF\u0010x\u001a\u0004\by\u0010z\"\u0004\b{\u0010|R%\u0010}\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0004\b}\u0010~\u001a\u0005\b\u007f\u0010\u0080\u0001\"\u0006\b\u0081\u0001\u0010\u0082\u0001R(\u0010\u0083\u0001\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b\u0083\u0001\u0010~\u001a\u0006\b\u0084\u0001\u0010\u0080\u0001\"\u0006\b\u0085\u0001\u0010\u0082\u0001R-\u0010\u0089\u0001\u001a\u0016\u0012\u0005\u0012\u00030\u0087\u00010\u0086\u0001j\n\u0012\u0005\u0012\u00030\u0087\u0001`\u0088\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0089\u0001\u0010\u008a\u0001\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u008c\u0001"}, d2 = {"Landroidx/constraintlayout/compose/Measurer;", "Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measurer;", "Landroidx/constraintlayout/compose/DesignInfoProvider;", "Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;", "dimensionBehaviour", "", TypedValues.Custom.S_DIMENSION, "matchConstraintDefaultDimension", "measureStrategy", "", "otherDimensionResolved", "currentDimensionResolved", "rootMaxConstraint", "", "outConstraints", "obtainConstraints", "", "Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;", "measure", "", "copyFrom", "([Ljava/lang/Integer;Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;)V", "", "str", "Landroidx/compose/ui/graphics/Color;", "defaultColor", "getColor-wrIjXm8", "(Ljava/lang/String;J)J", "getColor", "Ljava/util/HashMap;", "params", "Landroidx/compose/ui/text/TextStyle;", "getTextStyle", "startX", "startY", "args", "getDesignInfo", "Landroidx/constraintlayout/core/widgets/ConstraintWidget;", "constraintWidget", "Landroidx/constraintlayout/compose/LayoutInformationReceiver;", "layoutReceiver", "addLayoutInformationReceiver", "computeLayoutResult", "Landroidx/compose/ui/unit/Constraints;", "constraints", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "Landroidx/constraintlayout/compose/ConstraintSet;", "constraintSet", "", "Landroidx/compose/ui/layout/Measurable;", "measurables", "optimizationLevel", "Landroidx/compose/ui/layout/MeasureScope;", "measureScope", "Landroidx/compose/ui/unit/IntSize;", "performMeasure-DjhGOtQ", "(JLandroidx/compose/ui/unit/LayoutDirection;Landroidx/constraintlayout/compose/ConstraintSet;Ljava/util/List;ILandroidx/compose/ui/layout/MeasureScope;)J", "performMeasure", "resetMeasureState$compose_release", "()V", "resetMeasureState", "applyRootSize-BRTryo0", "(J)V", "applyRootSize", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "performLayout", "didMeasures", "Landroidx/compose/foundation/layout/BoxScope;", "", "forcedScaleFactor", "drawDebugBounds", "(Landroidx/compose/foundation/layout/BoxScope;FLandroidx/compose/runtime/Composer;I)V", "createDesignElements", "(Landroidx/compose/runtime/Composer;I)V", "parseDesignElements", "computedLayoutResult", "Ljava/lang/String;", "layoutInformationReceiver", "Landroidx/constraintlayout/compose/LayoutInformationReceiver;", "getLayoutInformationReceiver", "()Landroidx/constraintlayout/compose/LayoutInformationReceiver;", "setLayoutInformationReceiver", "(Landroidx/constraintlayout/compose/LayoutInformationReceiver;)V", "Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;", "root", "Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;", "getRoot", "()Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;", "", "Landroidx/compose/ui/layout/Placeable;", "placeables", "Ljava/util/Map;", "getPlaceables", "()Ljava/util/Map;", "lastMeasures", "Landroidx/constraintlayout/core/state/WidgetFrame;", "frameCache", "getFrameCache", "Landroidx/compose/ui/unit/Density;", "density", "Landroidx/compose/ui/unit/Density;", "getDensity", "()Landroidx/compose/ui/unit/Density;", "setDensity", "(Landroidx/compose/ui/unit/Density;)V", "Landroidx/compose/ui/layout/MeasureScope;", "getMeasureScope", "()Landroidx/compose/ui/layout/MeasureScope;", "setMeasureScope", "(Landroidx/compose/ui/layout/MeasureScope;)V", "Landroidx/constraintlayout/compose/State;", "state$delegate", "Lkotlin/Lazy;", "getState", "()Landroidx/constraintlayout/compose/State;", "state", "widthConstraintsHolder", "[I", "heightConstraintsHolder", "F", "getForcedScaleFactor", "()F", "setForcedScaleFactor", "(F)V", "layoutCurrentWidth", "I", "getLayoutCurrentWidth", "()I", "setLayoutCurrentWidth", "(I)V", "layoutCurrentHeight", "getLayoutCurrentHeight", "setLayoutCurrentHeight", "Ljava/util/ArrayList;", "Landroidx/constraintlayout/compose/DesignElement;", "Lkotlin/collections/ArrayList;", "designElements", "Ljava/util/ArrayList;", "<init>", "compose_release"}, k = 1, mv = {1, 5, 1})
@PublishedApi
/* loaded from: classes.dex */
public class Measurer implements DesignInfoProvider, BasicMeasure.Measurer {

    @NotNull
    private String computedLayoutResult = "";
    protected Density density;

    @NotNull
    private ArrayList<DesignElement> designElements;
    private float forcedScaleFactor;

    @NotNull
    private final Map<Measurable, WidgetFrame> frameCache;

    @NotNull
    private final int[] heightConstraintsHolder;

    @NotNull
    private final Map<Measurable, Integer[]> lastMeasures;
    private int layoutCurrentHeight;
    private int layoutCurrentWidth;

    @Nullable
    private LayoutInformationReceiver layoutInformationReceiver;
    protected MeasureScope measureScope;

    @NotNull
    private final Map<Measurable, Placeable> placeables;

    @NotNull
    private final ConstraintWidgetContainer root;

    /* renamed from: state$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy state;

    @NotNull
    private final int[] widthConstraintsHolder;

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ConstraintWidget.DimensionBehaviour.values().length];
            iArr[ConstraintWidget.DimensionBehaviour.FIXED.ordinal()] = 1;
            iArr[ConstraintWidget.DimensionBehaviour.WRAP_CONTENT.ordinal()] = 2;
            iArr[ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT.ordinal()] = 3;
            iArr[ConstraintWidget.DimensionBehaviour.MATCH_PARENT.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public Measurer() {
        ConstraintWidgetContainer constraintWidgetContainer = new ConstraintWidgetContainer(0, 0);
        constraintWidgetContainer.setMeasurer(this);
        Unit unit = Unit.INSTANCE;
        this.root = constraintWidgetContainer;
        this.placeables = new LinkedHashMap();
        this.lastMeasures = new LinkedHashMap();
        this.frameCache = new LinkedHashMap();
        this.state = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<State>() { // from class: androidx.constraintlayout.compose.Measurer$state$2
            {
                super(0);
            }

            @NotNull
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final State m5537invoke() {
                return new State(Measurer.this.getDensity());
            }
        });
        this.widthConstraintsHolder = new int[2];
        this.heightConstraintsHolder = new int[2];
        this.forcedScaleFactor = Float.NaN;
        this.designElements = new ArrayList<>();
    }

    private final void copyFrom(Integer[] numArr, BasicMeasure.Measure measure) {
        numArr[0] = Integer.valueOf(measure.measuredWidth);
        numArr[1] = Integer.valueOf(measure.measuredHeight);
        numArr[2] = Integer.valueOf(measure.measuredBaseline);
    }

    /* renamed from: getColor-wrIjXm8, reason: not valid java name */
    private final long m5533getColorwrIjXm8(String str, long defaultColor) {
        if (str != null && StringsKt.startsWith$default(str, '#', false, 2, (Object) null)) {
            String substring = str.substring(1);
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
            if (substring.length() == 6) {
                substring = Intrinsics.stringPlus("FF", substring);
            }
            try {
                return ColorKt.Color((int) Long.parseLong(substring, 16));
            } catch (Exception unused) {
            }
        }
        return defaultColor;
    }

    /* renamed from: getColor-wrIjXm8$default, reason: not valid java name */
    static /* synthetic */ long m5534getColorwrIjXm8$default(Measurer measurer, String str, long j, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getColor-wrIjXm8");
        }
        if ((i & 2) != 0) {
            j = Color.Companion.m2813getBlack0d7_KjU();
        }
        return measurer.m5533getColorwrIjXm8(str, j);
    }

    private final TextStyle getTextStyle(HashMap<String, String> params) {
        String str = params.get("size");
        long m5408getUnspecifiedXSAIIZE = TextUnit.Companion.m5408getUnspecifiedXSAIIZE();
        if (str != null) {
            m5408getUnspecifiedXSAIIZE = TextUnitKt.getSp(Float.parseFloat(str));
        }
        return new TextStyle(m5534getColorwrIjXm8$default(this, params.get(TypedValues.Custom.S_COLOR), 0L, 2, null), m5408getUnspecifiedXSAIIZE, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, 262140, (DefaultConstructorMarker) null);
    }

    private final boolean obtainConstraints(ConstraintWidget.DimensionBehaviour dimensionBehaviour, int dimension, int matchConstraintDefaultDimension, int measureStrategy, boolean otherDimensionResolved, boolean currentDimensionResolved, int rootMaxConstraint, int[] outConstraints) {
        boolean z;
        boolean z2;
        int i = WhenMappings.$EnumSwitchMapping$0[dimensionBehaviour.ordinal()];
        if (i == 1) {
            outConstraints[0] = dimension;
            outConstraints[1] = dimension;
        } else {
            if (i == 2) {
                outConstraints[0] = 0;
                outConstraints[1] = rootMaxConstraint;
                return true;
            }
            if (i == 3) {
                z = ConstraintLayoutKt.DEBUG;
                if (z) {
                    Log.d("CCL", Intrinsics.stringPlus("Measure strategy ", Integer.valueOf(measureStrategy)));
                    Log.d("CCL", Intrinsics.stringPlus("DW ", Integer.valueOf(matchConstraintDefaultDimension)));
                    Log.d("CCL", Intrinsics.stringPlus("ODR ", Boolean.valueOf(otherDimensionResolved)));
                    Log.d("CCL", Intrinsics.stringPlus("IRH ", Boolean.valueOf(currentDimensionResolved)));
                }
                boolean z3 = currentDimensionResolved || ((measureStrategy == BasicMeasure.Measure.TRY_GIVEN_DIMENSIONS || measureStrategy == BasicMeasure.Measure.USE_GIVEN_DIMENSIONS) && (measureStrategy == BasicMeasure.Measure.USE_GIVEN_DIMENSIONS || matchConstraintDefaultDimension != 1 || otherDimensionResolved));
                z2 = ConstraintLayoutKt.DEBUG;
                if (z2) {
                    Log.d("CCL", Intrinsics.stringPlus("UD ", Boolean.valueOf(z3)));
                }
                outConstraints[0] = z3 ? dimension : 0;
                if (!z3) {
                    dimension = rootMaxConstraint;
                }
                outConstraints[1] = dimension;
                if (!z3) {
                    return true;
                }
            } else {
                if (i != 4) {
                    throw new IllegalStateException((dimensionBehaviour + " is not supported").toString());
                }
                outConstraints[0] = rootMaxConstraint;
                outConstraints[1] = rootMaxConstraint;
            }
        }
        return false;
    }

    public final void addLayoutInformationReceiver(@Nullable LayoutInformationReceiver layoutReceiver) {
        this.layoutInformationReceiver = layoutReceiver;
        if (layoutReceiver == null) {
            return;
        }
        layoutReceiver.setLayoutInformation(this.computedLayoutResult);
    }

    /* renamed from: applyRootSize-BRTryo0, reason: not valid java name */
    protected final void m5535applyRootSizeBRTryo0(long constraints) {
        this.root.setWidth(Constraints.m5184getMaxWidthimpl(constraints));
        this.root.setHeight(Constraints.m5183getMaxHeightimpl(constraints));
        this.forcedScaleFactor = Float.NaN;
        LayoutInformationReceiver layoutInformationReceiver = this.layoutInformationReceiver;
        if (layoutInformationReceiver != null) {
            Integer valueOf = layoutInformationReceiver == null ? null : Integer.valueOf(layoutInformationReceiver.getForcedWidth());
            if (valueOf == null || valueOf.intValue() != Integer.MIN_VALUE) {
                LayoutInformationReceiver layoutInformationReceiver2 = this.layoutInformationReceiver;
                Intrinsics.checkNotNull(layoutInformationReceiver2);
                int forcedWidth = layoutInformationReceiver2.getForcedWidth();
                if (forcedWidth > this.root.getWidth()) {
                    this.forcedScaleFactor = this.root.getWidth() / forcedWidth;
                } else {
                    this.forcedScaleFactor = 1.0f;
                }
                this.root.setWidth(forcedWidth);
            }
        }
        LayoutInformationReceiver layoutInformationReceiver3 = this.layoutInformationReceiver;
        if (layoutInformationReceiver3 != null) {
            Integer valueOf2 = layoutInformationReceiver3 != null ? Integer.valueOf(layoutInformationReceiver3.getForcedHeight()) : null;
            if (valueOf2 == null || valueOf2.intValue() != Integer.MIN_VALUE) {
                LayoutInformationReceiver layoutInformationReceiver4 = this.layoutInformationReceiver;
                Intrinsics.checkNotNull(layoutInformationReceiver4);
                int forcedHeight = layoutInformationReceiver4.getForcedHeight();
                if (Float.isNaN(this.forcedScaleFactor)) {
                    this.forcedScaleFactor = 1.0f;
                }
                float height = forcedHeight > this.root.getHeight() ? this.root.getHeight() / forcedHeight : 1.0f;
                if (height < this.forcedScaleFactor) {
                    this.forcedScaleFactor = height;
                }
                this.root.setHeight(forcedHeight);
            }
        }
        this.layoutCurrentWidth = this.root.getWidth();
        this.layoutCurrentHeight = this.root.getHeight();
    }

    public void computeLayoutResult() {
        ConstraintWidget constraintWidget;
        StringBuilder sb = new StringBuilder();
        sb.append("{ ");
        sb.append("  root: {");
        sb.append("interpolated: { left:  0,");
        sb.append("  top:  0,");
        sb.append("  right:   " + this.root.getWidth() + " ,");
        sb.append("  bottom:  " + this.root.getHeight() + " ,");
        sb.append(" } }");
        Iterator<ConstraintWidget> it = this.root.getChildren().iterator();
        while (it.hasNext()) {
            ConstraintWidget next = it.next();
            Object companionWidget = next.getCompanionWidget();
            if (companionWidget instanceof Measurable) {
                WidgetFrame widgetFrame = null;
                if (next.stringId == null) {
                    Measurable measurable = (Measurable) companionWidget;
                    Object layoutId = LayoutIdKt.getLayoutId(measurable);
                    if (layoutId == null) {
                        layoutId = ConstraintLayoutTagKt.getConstraintLayoutId(measurable);
                    }
                    next.stringId = layoutId == null ? null : layoutId.toString();
                }
                WidgetFrame widgetFrame2 = this.frameCache.get(companionWidget);
                if (widgetFrame2 != null && (constraintWidget = widgetFrame2.widget) != null) {
                    widgetFrame = constraintWidget.frame;
                }
                if (widgetFrame != null) {
                    sb.append(' ' + ((Object) next.stringId) + ": {");
                    sb.append(" interpolated : ");
                    widgetFrame.serialize(sb, true);
                    sb.append("}, ");
                }
            } else if (next instanceof Guideline) {
                sb.append(' ' + ((Object) next.stringId) + ": {");
                Guideline guideline = (Guideline) next;
                if (guideline.getOrientation() == 0) {
                    sb.append(" type: 'hGuideline', ");
                } else {
                    sb.append(" type: 'vGuideline', ");
                }
                sb.append(" interpolated: ");
                sb.append(" { left: " + guideline.getX() + ", top: " + guideline.getY() + ", right: " + (guideline.getX() + guideline.getWidth()) + ", bottom: " + (guideline.getY() + guideline.getHeight()) + " }");
                sb.append("}, ");
            }
        }
        sb.append(" }");
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "json.toString()");
        this.computedLayoutResult = sb2;
        LayoutInformationReceiver layoutInformationReceiver = this.layoutInformationReceiver;
        if (layoutInformationReceiver == null) {
            return;
        }
        layoutInformationReceiver.setLayoutInformation(sb2);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Composable
    public final void createDesignElements(@Nullable Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(-186576797);
        Iterator<DesignElement> it = this.designElements.iterator();
        while (it.hasNext()) {
            DesignElement next = it.next();
            String id = next.getId();
            Function4<String, HashMap<String, String>, Composer, Integer, Unit> function4 = DesignElements.INSTANCE.getMap().get(next.getType());
            if (function4 != null) {
                startRestartGroup.startReplaceableGroup(-186576600);
                function4.invoke(id, next.getParams(), startRestartGroup, 64);
                startRestartGroup.endReplaceableGroup();
            } else {
                startRestartGroup.startReplaceableGroup(-186576534);
                String type = next.getType();
                switch (type.hashCode()) {
                    case -1377687758:
                        if (type.equals("button")) {
                            startRestartGroup.startReplaceableGroup(-186576462);
                            String str = next.getParams().get("text");
                            if (str == null) {
                                str = "text";
                            }
                            BasicTextKt.m1701BasicTextBpD7jsM(str, PaddingKt.m1394padding3ABfNKs(BackgroundKt.m1116backgroundbw27NRU$default(ClipKt.clip(ConstraintLayoutTagKt.layoutId$default(Modifier.Companion, id, null, 2, null), RoundedCornerShapeKt.RoundedCornerShape(20)), m5533getColorwrIjXm8(next.getParams().get("backgroundColor"), Color.Companion.m2819getLightGray0d7_KjU()), null, 2, null), C0856Dp.m5216constructorimpl(8)), getTextStyle(next.getParams()), null, 0, false, 0, startRestartGroup, 32768, 120);
                            startRestartGroup.endReplaceableGroup();
                            break;
                        }
                        startRestartGroup.startReplaceableGroup(-186574342);
                        startRestartGroup.endReplaceableGroup();
                        break;
                    case -1031434259:
                        if (type.equals("textfield")) {
                            startRestartGroup.startReplaceableGroup(-186575007);
                            String str2 = next.getParams().get("text");
                            if (str2 == null) {
                                str2 = "text";
                            }
                            BasicTextFieldKt.BasicTextField(str2, (Function1) new Function1<String, Unit>() { // from class: androidx.constraintlayout.compose.Measurer$createDesignElements$2
                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((String) obj);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(@NotNull String str3) {
                                    Intrinsics.checkNotNullParameter(str3, "it");
                                }
                            }, ConstraintLayoutTagKt.layoutId$default(Modifier.Companion, id, null, 2, null), false, false, (TextStyle) null, (KeyboardOptions) null, (KeyboardActions) null, false, 0, (VisualTransformation) null, (Function1) null, (MutableInteractionSource) null, (Brush) null, (Function3) null, startRestartGroup, 0, 0, 32760);
                            startRestartGroup.endReplaceableGroup();
                            break;
                        }
                        startRestartGroup.startReplaceableGroup(-186574342);
                        startRestartGroup.endReplaceableGroup();
                        break;
                    case 97739:
                        if (type.equals("box")) {
                            startRestartGroup.startReplaceableGroup(-186575900);
                            String str3 = next.getParams().get("text");
                            if (str3 == null) {
                                str3 = "";
                            }
                            long m5533getColorwrIjXm8 = m5533getColorwrIjXm8(next.getParams().get("backgroundColor"), Color.Companion.m2819getLightGray0d7_KjU());
                            Modifier.Companion companion = Modifier.Companion;
                            Modifier m1116backgroundbw27NRU$default = BackgroundKt.m1116backgroundbw27NRU$default(ConstraintLayoutTagKt.layoutId$default(companion, id, null, 2, null), m5533getColorwrIjXm8, null, 2, null);
                            startRestartGroup.startReplaceableGroup(-1990474327);
                            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, startRestartGroup, 0);
                            startRestartGroup.startReplaceableGroup(1376089335);
                            Density density = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                            LayoutDirection layoutDirection = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                            ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
                            Function0<ComposeUiNode> constructor = companion2.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(m1116backgroundbw27NRU$default);
                            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            startRestartGroup.startReusableNode();
                            if (startRestartGroup.getInserting()) {
                                startRestartGroup.createNode(constructor);
                            } else {
                                startRestartGroup.useNode();
                            }
                            startRestartGroup.disableReusing();
                            Composer m2410constructorimpl = Updater.m2410constructorimpl(startRestartGroup);
                            Updater.m2417setimpl(m2410constructorimpl, rememberBoxMeasurePolicy, companion2.getSetMeasurePolicy());
                            Updater.m2417setimpl(m2410constructorimpl, density, companion2.getSetDensity());
                            Updater.m2417setimpl(m2410constructorimpl, layoutDirection, companion2.getSetLayoutDirection());
                            startRestartGroup.enableReusing();
                            materializerOf.invoke(SkippableUpdater.m2398boximpl(SkippableUpdater.m2399constructorimpl(startRestartGroup)), startRestartGroup, 0);
                            startRestartGroup.startReplaceableGroup(2058660585);
                            startRestartGroup.startReplaceableGroup(-1253629305);
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            BasicTextKt.m1701BasicTextBpD7jsM(str3, PaddingKt.m1394padding3ABfNKs(companion, C0856Dp.m5216constructorimpl(8)), getTextStyle(next.getParams()), null, 0, false, 0, startRestartGroup, 32816, 120);
                            startRestartGroup.endReplaceableGroup();
                            startRestartGroup.endReplaceableGroup();
                            startRestartGroup.endNode();
                            startRestartGroup.endReplaceableGroup();
                            startRestartGroup.endReplaceableGroup();
                            startRestartGroup.endReplaceableGroup();
                            break;
                        }
                        startRestartGroup.startReplaceableGroup(-186574342);
                        startRestartGroup.endReplaceableGroup();
                        break;
                    case 3556653:
                        if (type.equals("text")) {
                            startRestartGroup.startReplaceableGroup(-186575281);
                            String str4 = next.getParams().get("text");
                            if (str4 == null) {
                                str4 = "text";
                            }
                            BasicTextKt.m1701BasicTextBpD7jsM(str4, ConstraintLayoutTagKt.layoutId$default(Modifier.Companion, id, null, 2, null), getTextStyle(next.getParams()), null, 0, false, 0, startRestartGroup, 32768, 120);
                            startRestartGroup.endReplaceableGroup();
                            break;
                        }
                        startRestartGroup.startReplaceableGroup(-186574342);
                        startRestartGroup.endReplaceableGroup();
                        break;
                    case 100313435:
                        if (type.equals("image")) {
                            startRestartGroup.startReplaceableGroup(-186574667);
                            ImageKt.Image(PainterResources_androidKt.painterResource(android.R.drawable.ic_menu_gallery, startRestartGroup, 0), "Placeholder Image", ConstraintLayoutTagKt.layoutId$default(Modifier.Companion, id, null, 2, null), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, startRestartGroup, 56, 120);
                            startRestartGroup.endReplaceableGroup();
                            break;
                        }
                        startRestartGroup.startReplaceableGroup(-186574342);
                        startRestartGroup.endReplaceableGroup();
                        break;
                    default:
                        startRestartGroup.startReplaceableGroup(-186574342);
                        startRestartGroup.endReplaceableGroup();
                        break;
                }
                startRestartGroup.endReplaceableGroup();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.Measurer$createDesignElements$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable Composer composer2, int i2) {
                Measurer.this.createDesignElements(composer2, i | 1);
            }
        });
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measurer
    public void didMeasures() {
    }

    @Composable
    public final void drawDebugBounds(@NotNull final BoxScope boxScope, final float f, @Nullable Composer composer, final int i) {
        Intrinsics.checkNotNullParameter(boxScope, "<this>");
        Composer startRestartGroup = composer.startRestartGroup(-756996390);
        CanvasKt.Canvas(boxScope.matchParentSize(Modifier.Companion), new Function1<DrawScope, Unit>() { // from class: androidx.constraintlayout.compose.Measurer$drawDebugBounds$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((DrawScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull DrawScope drawScope) {
                Intrinsics.checkNotNullParameter(drawScope, "$this$Canvas");
                float layoutCurrentWidth = Measurer.this.getLayoutCurrentWidth() * f;
                float layoutCurrentHeight = Measurer.this.getLayoutCurrentHeight() * f;
                float m2625getWidthimpl = (Size.m2625getWidthimpl(drawScope.mo3205getSizeNHjbRc()) - layoutCurrentWidth) / 2.0f;
                float m2622getHeightimpl = (Size.m2622getHeightimpl(drawScope.mo3205getSizeNHjbRc()) - layoutCurrentHeight) / 2.0f;
                Color.Companion companion = Color.Companion;
                long m2824getWhite0d7_KjU = companion.m2824getWhite0d7_KjU();
                float f2 = m2625getWidthimpl + layoutCurrentWidth;
                w51.C(drawScope, m2824getWhite0d7_KjU, OffsetKt.Offset(m2625getWidthimpl, m2622getHeightimpl), OffsetKt.Offset(f2, m2622getHeightimpl), 0.0f, 0, null, 0.0f, null, 0, TypedValues.PositionType.TYPE_PERCENT_HEIGHT, null);
                long Offset = OffsetKt.Offset(f2, m2622getHeightimpl);
                float f3 = m2622getHeightimpl + layoutCurrentHeight;
                w51.C(drawScope, m2824getWhite0d7_KjU, Offset, OffsetKt.Offset(f2, f3), 0.0f, 0, null, 0.0f, null, 0, TypedValues.PositionType.TYPE_PERCENT_HEIGHT, null);
                w51.C(drawScope, m2824getWhite0d7_KjU, OffsetKt.Offset(f2, f3), OffsetKt.Offset(m2625getWidthimpl, f3), 0.0f, 0, null, 0.0f, null, 0, TypedValues.PositionType.TYPE_PERCENT_HEIGHT, null);
                w51.C(drawScope, m2824getWhite0d7_KjU, OffsetKt.Offset(m2625getWidthimpl, f3), OffsetKt.Offset(m2625getWidthimpl, m2622getHeightimpl), 0.0f, 0, null, 0.0f, null, 0, TypedValues.PositionType.TYPE_PERCENT_HEIGHT, null);
                float f4 = 1;
                float f5 = m2625getWidthimpl + f4;
                float f6 = m2622getHeightimpl + f4;
                long m2813getBlack0d7_KjU = companion.m2813getBlack0d7_KjU();
                float f7 = layoutCurrentWidth + f5;
                w51.C(drawScope, m2813getBlack0d7_KjU, OffsetKt.Offset(f5, f6), OffsetKt.Offset(f7, f6), 0.0f, 0, null, 0.0f, null, 0, TypedValues.PositionType.TYPE_PERCENT_HEIGHT, null);
                long Offset2 = OffsetKt.Offset(f7, f6);
                float f8 = f6 + layoutCurrentHeight;
                w51.C(drawScope, m2813getBlack0d7_KjU, Offset2, OffsetKt.Offset(f7, f8), 0.0f, 0, null, 0.0f, null, 0, TypedValues.PositionType.TYPE_PERCENT_HEIGHT, null);
                w51.C(drawScope, m2813getBlack0d7_KjU, OffsetKt.Offset(f7, f8), OffsetKt.Offset(f5, f8), 0.0f, 0, null, 0.0f, null, 0, TypedValues.PositionType.TYPE_PERCENT_HEIGHT, null);
                w51.C(drawScope, m2813getBlack0d7_KjU, OffsetKt.Offset(f5, f8), OffsetKt.Offset(f5, f6), 0.0f, 0, null, 0.0f, null, 0, TypedValues.PositionType.TYPE_PERCENT_HEIGHT, null);
            }
        }, startRestartGroup, 0);
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.Measurer$drawDebugBounds$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable Composer composer2, int i2) {
                Measurer.this.drawDebugBounds(boxScope, f, composer2, i | 1);
            }
        });
    }

    @NotNull
    protected final Density getDensity() {
        Density density = this.density;
        if (density != null) {
            return density;
        }
        Intrinsics.throwUninitializedPropertyAccessException("density");
        throw null;
    }

    @Override // androidx.constraintlayout.compose.DesignInfoProvider
    @NotNull
    public String getDesignInfo(int startX, int startY, @NotNull String args) {
        Intrinsics.checkNotNullParameter(args, "args");
        return ToolingUtilsKt.parseConstraintsToJson(this.root, getState(), startX, startY, args);
    }

    public final float getForcedScaleFactor() {
        return this.forcedScaleFactor;
    }

    @NotNull
    protected final Map<Measurable, WidgetFrame> getFrameCache() {
        return this.frameCache;
    }

    public final int getLayoutCurrentHeight() {
        return this.layoutCurrentHeight;
    }

    public final int getLayoutCurrentWidth() {
        return this.layoutCurrentWidth;
    }

    @Nullable
    protected final LayoutInformationReceiver getLayoutInformationReceiver() {
        return this.layoutInformationReceiver;
    }

    @NotNull
    protected final MeasureScope getMeasureScope() {
        MeasureScope measureScope = this.measureScope;
        if (measureScope != null) {
            return measureScope;
        }
        Intrinsics.throwUninitializedPropertyAccessException("measureScope");
        throw null;
    }

    @NotNull
    protected final Map<Measurable, Placeable> getPlaceables() {
        return this.placeables;
    }

    @NotNull
    protected final ConstraintWidgetContainer getRoot() {
        return this.root;
    }

    @NotNull
    protected final State getState() {
        return (State) this.state.getValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0106, code lost:
    
        if (r20.mMatchConstraintDefaultHeight == 0) goto L89;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measurer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void measure(@org.jetbrains.annotations.NotNull androidx.constraintlayout.core.widgets.ConstraintWidget r20, @org.jetbrains.annotations.NotNull androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measure r21) {
        /*
            Method dump skipped, instructions count: 733
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.compose.Measurer.measure(androidx.constraintlayout.core.widgets.ConstraintWidget, androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure):void");
    }

    public final void parseDesignElements(@NotNull ConstraintSet constraintSet) {
        Intrinsics.checkNotNullParameter(constraintSet, "constraintSet");
        if (constraintSet instanceof JSONConstraintSet) {
            ((JSONConstraintSet) constraintSet).emitDesignElements(this.designElements);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void performLayout(@NotNull Placeable.PlacementScope placementScope, @NotNull List<? extends Measurable> list) {
        Intrinsics.checkNotNullParameter(placementScope, "<this>");
        Intrinsics.checkNotNullParameter(list, "measurables");
        if (this.frameCache.isEmpty()) {
            Iterator<ConstraintWidget> it = this.root.getChildren().iterator();
            while (it.hasNext()) {
                ConstraintWidget next = it.next();
                Object companionWidget = next.getCompanionWidget();
                if (companionWidget instanceof Measurable) {
                    this.frameCache.put(companionWidget, new WidgetFrame(next.frame.update()));
                }
            }
        }
        int i = 0;
        int size = list.size() - 1;
        if (size >= 0) {
            while (true) {
                int i2 = i + 1;
                Measurable measurable = list.get(i);
                final WidgetFrame widgetFrame = getFrameCache().get(measurable);
                if (widgetFrame == null) {
                    return;
                }
                if (widgetFrame.isDefaultTransform()) {
                    WidgetFrame widgetFrame2 = getFrameCache().get(measurable);
                    Intrinsics.checkNotNull(widgetFrame2);
                    int i3 = widgetFrame2.left;
                    WidgetFrame widgetFrame3 = getFrameCache().get(measurable);
                    Intrinsics.checkNotNull(widgetFrame3);
                    int i4 = widgetFrame3.top;
                    Placeable placeable = getPlaceables().get(measurable);
                    if (placeable != null) {
                        Placeable.PlacementScope.m4223place70tqf50$default(placementScope, placeable, IntOffsetKt.IntOffset(i3, i4), 0.0f, 2, null);
                    }
                } else {
                    Function1<GraphicsLayerScope, Unit> function1 = new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.constraintlayout.compose.Measurer$performLayout$1$layerBlock$1
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((GraphicsLayerScope) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(@NotNull GraphicsLayerScope graphicsLayerScope) {
                            Intrinsics.checkNotNullParameter(graphicsLayerScope, "$this$null");
                            if (!Float.isNaN(WidgetFrame.this.pivotX) || !Float.isNaN(WidgetFrame.this.pivotY)) {
                                graphicsLayerScope.mo2946setTransformOrigin__ExYCQ(TransformOriginKt.TransformOrigin(Float.isNaN(WidgetFrame.this.pivotX) ? 0.5f : WidgetFrame.this.pivotX, Float.isNaN(WidgetFrame.this.pivotY) ? 0.5f : WidgetFrame.this.pivotY));
                            }
                            if (!Float.isNaN(WidgetFrame.this.rotationX)) {
                                graphicsLayerScope.setRotationX(WidgetFrame.this.rotationX);
                            }
                            if (!Float.isNaN(WidgetFrame.this.rotationY)) {
                                graphicsLayerScope.setRotationY(WidgetFrame.this.rotationY);
                            }
                            if (!Float.isNaN(WidgetFrame.this.rotationZ)) {
                                graphicsLayerScope.setRotationZ(WidgetFrame.this.rotationZ);
                            }
                            if (!Float.isNaN(WidgetFrame.this.translationX)) {
                                graphicsLayerScope.setTranslationX(WidgetFrame.this.translationX);
                            }
                            if (!Float.isNaN(WidgetFrame.this.translationY)) {
                                graphicsLayerScope.setTranslationY(WidgetFrame.this.translationY);
                            }
                            if (!Float.isNaN(WidgetFrame.this.translationZ)) {
                                graphicsLayerScope.setShadowElevation(WidgetFrame.this.translationZ);
                            }
                            if (!Float.isNaN(WidgetFrame.this.scaleX) || !Float.isNaN(WidgetFrame.this.scaleY)) {
                                graphicsLayerScope.setScaleX(Float.isNaN(WidgetFrame.this.scaleX) ? 1.0f : WidgetFrame.this.scaleX);
                                graphicsLayerScope.setScaleY(Float.isNaN(WidgetFrame.this.scaleY) ? 1.0f : WidgetFrame.this.scaleY);
                            }
                            if (Float.isNaN(WidgetFrame.this.alpha)) {
                                return;
                            }
                            graphicsLayerScope.setAlpha(WidgetFrame.this.alpha);
                        }
                    };
                    WidgetFrame widgetFrame4 = getFrameCache().get(measurable);
                    Intrinsics.checkNotNull(widgetFrame4);
                    int i5 = widgetFrame4.left;
                    WidgetFrame widgetFrame5 = getFrameCache().get(measurable);
                    Intrinsics.checkNotNull(widgetFrame5);
                    int i6 = widgetFrame5.top;
                    float f = Float.isNaN(widgetFrame.translationZ) ? 0.0f : widgetFrame.translationZ;
                    Placeable placeable2 = getPlaceables().get(measurable);
                    if (placeable2 != null) {
                        placementScope.placeWithLayer(placeable2, i5, i6, f, function1);
                    }
                }
                if (i2 > size) {
                    break;
                } else {
                    i = i2;
                }
            }
        }
        LayoutInformationReceiver layoutInformationReceiver = this.layoutInformationReceiver;
        if ((layoutInformationReceiver == null ? null : layoutInformationReceiver.getLayoutInformationMode()) == LayoutInfoFlags.BOUNDS) {
            computeLayoutResult();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: performMeasure-DjhGOtQ, reason: not valid java name */
    public final long m5536performMeasureDjhGOtQ(long constraints, @NotNull LayoutDirection layoutDirection, @NotNull ConstraintSet constraintSet, @NotNull List<? extends Measurable> measurables, int optimizationLevel, @NotNull MeasureScope measureScope) {
        boolean z;
        boolean z2;
        boolean z3;
        String debugString;
        String debugString2;
        String obj;
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Intrinsics.checkNotNullParameter(constraintSet, "constraintSet");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        Intrinsics.checkNotNullParameter(measureScope, "measureScope");
        setDensity(measureScope);
        setMeasureScope(measureScope);
        getState().width(Constraints.m5182getHasFixedWidthimpl(constraints) ? androidx.constraintlayout.core.state.Dimension.Fixed(Constraints.m5184getMaxWidthimpl(constraints)) : androidx.constraintlayout.core.state.Dimension.Wrap().min(Constraints.m5186getMinWidthimpl(constraints)));
        getState().height(Constraints.m5181getHasFixedHeightimpl(constraints) ? androidx.constraintlayout.core.state.Dimension.Fixed(Constraints.m5183getMaxHeightimpl(constraints)) : androidx.constraintlayout.core.state.Dimension.Wrap().min(Constraints.m5185getMinHeightimpl(constraints)));
        getState().m5572setRootIncomingConstraintsBRTryo0(constraints);
        getState().setLayoutDirection(layoutDirection);
        resetMeasureState$compose_release();
        if (constraintSet.isDirty(measurables)) {
            getState().reset();
            constraintSet.applyTo(getState(), measurables);
            ConstraintLayoutKt.buildMapping(getState(), measurables);
            getState().apply(this.root);
        } else {
            ConstraintLayoutKt.buildMapping(getState(), measurables);
        }
        m5535applyRootSizeBRTryo0(constraints);
        this.root.updateHierarchy();
        z = ConstraintLayoutKt.DEBUG;
        if (z) {
            this.root.setDebugName("ConstraintLayout");
            ArrayList<ConstraintWidget> children = this.root.getChildren();
            Intrinsics.checkNotNullExpressionValue(children, "root.children");
            for (ConstraintWidget constraintWidget : children) {
                Object companionWidget = constraintWidget.getCompanionWidget();
                Measurable measurable = companionWidget instanceof Measurable ? (Measurable) companionWidget : null;
                Object layoutId = measurable == null ? null : LayoutIdKt.getLayoutId(measurable);
                String str = "NOTAG";
                if (layoutId != null && (obj = layoutId.toString()) != null) {
                    str = obj;
                }
                constraintWidget.setDebugName(str);
            }
            Log.d("CCL", Intrinsics.stringPlus("ConstraintLayout is asked to measure with ", Constraints.m5189toStringimpl(constraints)));
            debugString = ConstraintLayoutKt.toDebugString(this.root);
            Log.d("CCL", debugString);
            Iterator<ConstraintWidget> it = this.root.getChildren().iterator();
            while (it.hasNext()) {
                ConstraintWidget next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "child");
                debugString2 = ConstraintLayoutKt.toDebugString(next);
                Log.d("CCL", debugString2);
            }
        }
        this.root.setOptimizationLevel(optimizationLevel);
        ConstraintWidgetContainer constraintWidgetContainer = this.root;
        constraintWidgetContainer.measure(constraintWidgetContainer.getOptimizationLevel(), 0, 0, 0, 0, 0, 0, 0, 0);
        Iterator<ConstraintWidget> it2 = this.root.getChildren().iterator();
        while (it2.hasNext()) {
            ConstraintWidget next2 = it2.next();
            Object companionWidget2 = next2.getCompanionWidget();
            if (companionWidget2 instanceof Measurable) {
                Placeable placeable = this.placeables.get(companionWidget2);
                Integer valueOf = placeable == null ? null : Integer.valueOf(placeable.getWidth());
                Integer valueOf2 = placeable == null ? null : Integer.valueOf(placeable.getHeight());
                int width = next2.getWidth();
                if (valueOf != null && width == valueOf.intValue()) {
                    int height = next2.getHeight();
                    if (valueOf2 != null && height == valueOf2.intValue()) {
                    }
                }
                z3 = ConstraintLayoutKt.DEBUG;
                if (z3) {
                    Log.d("CCL", "Final measurement for " + LayoutIdKt.getLayoutId((Measurable) companionWidget2) + " to confirm size " + next2.getWidth() + ' ' + next2.getHeight());
                }
                getPlaceables().put(companionWidget2, ((Measurable) companionWidget2).mo4187measureBRTryo0(Constraints.Companion.m5192fixedJhjzzOo(next2.getWidth(), next2.getHeight())));
            }
        }
        z2 = ConstraintLayoutKt.DEBUG;
        if (z2) {
            Log.d("CCL", "ConstraintLayout is at the end " + this.root.getWidth() + ' ' + this.root.getHeight());
        }
        return IntSizeKt.IntSize(this.root.getWidth(), this.root.getHeight());
    }

    public final void resetMeasureState$compose_release() {
        this.placeables.clear();
        this.lastMeasures.clear();
        this.frameCache.clear();
    }

    protected final void setDensity(@NotNull Density density) {
        Intrinsics.checkNotNullParameter(density, "<set-?>");
        this.density = density;
    }

    public final void setForcedScaleFactor(float f) {
        this.forcedScaleFactor = f;
    }

    public final void setLayoutCurrentHeight(int i) {
        this.layoutCurrentHeight = i;
    }

    public final void setLayoutCurrentWidth(int i) {
        this.layoutCurrentWidth = i;
    }

    protected final void setLayoutInformationReceiver(@Nullable LayoutInformationReceiver layoutInformationReceiver) {
        this.layoutInformationReceiver = layoutInformationReceiver;
    }

    protected final void setMeasureScope(@NotNull MeasureScope measureScope) {
        Intrinsics.checkNotNullParameter(measureScope, "<set-?>");
        this.measureScope = measureScope;
    }
}
