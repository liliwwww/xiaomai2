package androidx.constraintlayout.compose;

import androidx.compose.p004ui.layout.LayoutIdKt;
import androidx.compose.p004ui.layout.Measurable;
import androidx.compose.p004ui.semantics.SemanticsPropertyKey;
import androidx.compose.p004ui.semantics.SemanticsPropertyReceiver;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.HelperWidget;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\u001a0\u0010\t\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0000\u001a.\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\f2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0007H\u0002\u001a\u0014\u0010\u0012\u001a\u00020\u0007*\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u001a\u000e\u0010\u0013\u001a\u00020\u0007*\u0004\u0018\u00010\u0011H\u0002\u001a\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0014H\u0002\u001a$\u0010\u0018\u001a\n \u0017*\u0004\u0018\u00010\u00140\u0014*\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002\u001aV\u0010#\u001a\u00020\u000f*\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u001e2\u0006\u0010 \u001a\u00020\u001f2\b\b\u0002\u0010!\u001a\u00020\u001b2\b\b\u0002\u0010\"\u001a\u00020\u001bH\u0002\"\u001f\u0010&\u001a\b\u0012\u0004\u0012\u00020%0$8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"5\u00103\u001a\u00020%*\u00020*2\u0006\u0010+\u001a\u00020%8@@@X\u0081\u008e\u0002¢\u0006\u0018\n\u0004\b,\u0010'\u0012\u0004\b1\u00102\u001a\u0004\b-\u0010.\"\u0004\b/\u00100\"\u0016\u00104\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b4\u00105\"\u0016\u00106\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b6\u00105\"\u0016\u00107\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b7\u00105¨\u00068"}, d2 = {"Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;", "root", "Landroidx/constraintlayout/compose/State;", "state", "", "startX", "startY", "", "args", "parseConstraintsToJson", "Landroidx/constraintlayout/core/widgets/HelperWidget;", "helperWidget", "", "helperReferences", "rootId", "", "addReferencesIds", "Landroidx/constraintlayout/core/widgets/ConstraintWidget;", "getHelperId", "getRefId", "Lorg/json/JSONObject;", "content", "createDesignInfoJson", "kotlin.jvm.PlatformType", "boundsToJson", "viewId", "boxJson", "", "isHelper", "isRoot", "", "Lorg/json/JSONArray;", "constraintsInfoArray", "withConstraints", "withBounds", "putViewIdToBoundsAndConstraints", "Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "Landroidx/constraintlayout/compose/DesignInfoProvider;", "DesignInfoDataKey", "Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "getDesignInfoDataKey", "()Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "<set-?>", "designInfoProvider$delegate", "getDesignInfoProvider", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/constraintlayout/compose/DesignInfoProvider;", "setDesignInfoProvider", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Landroidx/constraintlayout/compose/DesignInfoProvider;)V", "getDesignInfoProvider$annotations", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)V", "designInfoProvider", "CONSTRAINTS_JSON_VERSION", "I", "CONSTRAINTS", "BOUNDS", "compose_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class ToolingUtilsKt {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinPackage(ToolingUtilsKt.class, "compose_release"), "designInfoProvider", "getDesignInfoProvider(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/constraintlayout/compose/DesignInfoProvider;"))};
    private static final int BOUNDS = 1;
    private static final int CONSTRAINTS = 0;
    private static final int CONSTRAINTS_JSON_VERSION = 1;

    @NotNull
    private static final SemanticsPropertyKey<DesignInfoProvider> DesignInfoDataKey;

    @NotNull
    private static final SemanticsPropertyKey designInfoProvider$delegate;

    static {
        SemanticsPropertyKey<DesignInfoProvider> semanticsPropertyKey = new SemanticsPropertyKey<>("DesignInfoProvider", null, 2, null);
        DesignInfoDataKey = semanticsPropertyKey;
        designInfoProvider$delegate = semanticsPropertyKey;
    }

    private static final void addReferencesIds(HelperWidget helperWidget, List<String> list, ConstraintWidgetContainer constraintWidgetContainer, String str) {
        int i = helperWidget.mWidgetsCount;
        if (i <= 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            ConstraintWidget constraintWidget = helperWidget.mWidgets[i2];
            list.add(Intrinsics.areEqual(constraintWidget, constraintWidgetContainer) ? str : getRefId(constraintWidget));
            if (i3 >= i) {
                return;
            } else {
                i2 = i3;
            }
        }
    }

    private static final JSONObject boundsToJson(ConstraintWidget constraintWidget, int i, int i2) {
        return new JSONObject().put("left", constraintWidget.getLeft() + i).put("top", constraintWidget.getTop() + i2).put("right", constraintWidget.getRight() + i).put("bottom", constraintWidget.getBottom() + i2);
    }

    private static final String createDesignInfoJson(JSONObject jSONObject) {
        String jSONObject2 = new JSONObject().put("type", "CONSTRAINTS").put("version", 1).put("content", jSONObject).toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject()\n    .put(\"type\", \"CONSTRAINTS\")\n    .put(\"version\", CONSTRAINTS_JSON_VERSION)\n    .put(\"content\", content).toString()");
        return jSONObject2;
    }

    @NotNull
    public static final SemanticsPropertyKey<DesignInfoProvider> getDesignInfoDataKey() {
        return DesignInfoDataKey;
    }

    @NotNull
    public static final DesignInfoProvider getDesignInfoProvider(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "<this>");
        return (DesignInfoProvider) designInfoProvider$delegate.getValue(semanticsPropertyReceiver, $$delegatedProperties[0]);
    }

    @PublishedApi
    public static /* synthetic */ void getDesignInfoProvider$annotations(SemanticsPropertyReceiver semanticsPropertyReceiver) {
    }

    private static final String getHelperId(ConstraintWidget constraintWidget, State state) {
        return String.valueOf(state.getKeyId$compose_release((HelperWidget) constraintWidget));
    }

    private static final String getRefId(ConstraintWidget constraintWidget) {
        Object layoutId;
        Object companionWidget = constraintWidget == null ? null : constraintWidget.getCompanionWidget();
        Measurable measurable = companionWidget instanceof Measurable ? (Measurable) companionWidget : null;
        String obj = (measurable == null || (layoutId = LayoutIdKt.getLayoutId(measurable)) == null) ? null : layoutId.toString();
        if (obj == null) {
            return String.valueOf(constraintWidget != null ? constraintWidget.stringId : null);
        }
        return obj;
    }

    @NotNull
    public static final String parseConstraintsToJson(@NotNull ConstraintWidgetContainer constraintWidgetContainer, @NotNull State state, int i, int i2, @NotNull String str) {
        boolean z;
        boolean z2;
        String refId;
        State state2 = state;
        Intrinsics.checkNotNullParameter(constraintWidgetContainer, "root");
        Intrinsics.checkNotNullParameter(state2, "state");
        Intrinsics.checkNotNullParameter(str, "args");
        String valueOf = String.valueOf(androidx.constraintlayout.core.state.State.PARENT);
        JSONObject jSONObject = new JSONObject();
        Integer intOrNull = StringsKt.toIntOrNull(str);
        if (intOrNull == null) {
            z = true;
            z2 = true;
        } else {
            int intValue = intOrNull.intValue();
            boolean z3 = (intValue >> 1) == 1;
            z = (intValue >> 0) == 1;
            z2 = z3;
        }
        ArrayList<ConstraintWidget> children = constraintWidgetContainer.getChildren();
        Intrinsics.checkNotNullExpressionValue(children, "root.children");
        for (ConstraintWidget constraintWidget : children) {
            JSONArray jSONArray = new JSONArray();
            ArrayList arrayList = new ArrayList();
            boolean z4 = constraintWidget instanceof HelperWidget;
            String str2 = constraintWidget.stringId;
            if (z4) {
                addReferencesIds((HelperWidget) constraintWidget, arrayList, constraintWidgetContainer, valueOf);
            }
            ArrayList<ConstraintAnchor> anchors = constraintWidget.getAnchors();
            Intrinsics.checkNotNullExpressionValue(anchors, "constraintWidget.anchors");
            for (ConstraintAnchor constraintAnchor : anchors) {
                if (constraintAnchor.isConnected()) {
                    ConstraintWidget owner = constraintAnchor.getTarget().getOwner();
                    boolean z5 = owner instanceof HelperWidget;
                    if (Intrinsics.areEqual(constraintWidgetContainer, owner)) {
                        refId = valueOf;
                    } else if (z5) {
                        Intrinsics.checkNotNullExpressionValue(owner, "targetWidget");
                        refId = getHelperId(owner, state2);
                    } else {
                        refId = getRefId(owner);
                    }
                    JSONObject put = new JSONObject().put("originAnchor", constraintAnchor.getType());
                    ConstraintAnchor target = constraintAnchor.getTarget();
                    Intrinsics.checkNotNull(target);
                    jSONArray.put(put.put("targetAnchor", target.getType()).put(TypedValues.AttributesType.S_TARGET, refId).put("margin", constraintAnchor.getMargin()));
                }
                state2 = state;
            }
            Intrinsics.checkNotNullExpressionValue(str2, "widgetId");
            Intrinsics.checkNotNullExpressionValue(constraintWidget, "constraintWidget");
            JSONObject boundsToJson = boundsToJson(constraintWidget, i, i2);
            Intrinsics.checkNotNullExpressionValue(boundsToJson, "constraintWidget.boundsToJson(startX, startY)");
            putViewIdToBoundsAndConstraints(jSONObject, str2, boundsToJson, constraintWidget instanceof HelperWidget, false, arrayList, jSONArray, z, z2);
            state2 = state;
        }
        JSONObject boundsToJson2 = boundsToJson(constraintWidgetContainer, i, i2);
        Intrinsics.checkNotNullExpressionValue(boundsToJson2, "root.boundsToJson(startX, startY)");
        putViewIdToBoundsAndConstraints(jSONObject, valueOf, boundsToJson2, false, true, CollectionsKt.emptyList(), new JSONArray(), z, z2);
        return createDesignInfoJson(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void putViewIdToBoundsAndConstraints(JSONObject jSONObject, String str, JSONObject jSONObject2, boolean z, boolean z2, List<String> list, JSONArray jSONArray, boolean z3, boolean z4) {
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("viewId", str);
        if (z4) {
            jSONObject3.put("box", jSONObject2);
        }
        jSONObject3.put("isHelper", z);
        jSONObject3.put("isRoot", z2);
        JSONArray jSONArray2 = new JSONArray();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            jSONArray2.put(it.next());
        }
        jSONObject3.put("helperReferences", jSONArray2);
        if (z3) {
            jSONObject3.put("constraints", jSONArray);
        }
        jSONObject.put(str, jSONObject3);
    }

    public static final void setDesignInfoProvider(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, @NotNull DesignInfoProvider designInfoProvider) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "<this>");
        Intrinsics.checkNotNullParameter(designInfoProvider, "<set-?>");
        designInfoProvider$delegate.setValue(semanticsPropertyReceiver, $$delegatedProperties[0], designInfoProvider);
    }
}
