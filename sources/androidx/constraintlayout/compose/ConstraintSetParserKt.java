package androidx.constraintlayout.compose;

import android.taobao.windvane.util.NetWork;
import androidx.compose.p004ui.unit.C0856Dp;
import androidx.constraintlayout.core.motion.utils.TypedBundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.parser.CLArray;
import androidx.constraintlayout.core.parser.CLElement;
import androidx.constraintlayout.core.parser.CLKey;
import androidx.constraintlayout.core.parser.CLNumber;
import androidx.constraintlayout.core.parser.CLObject;
import androidx.constraintlayout.core.parser.CLParser;
import androidx.constraintlayout.core.parser.CLParsingException;
import androidx.constraintlayout.core.parser.CLString;
import androidx.constraintlayout.core.state.ConstraintReference;
import androidx.constraintlayout.core.state.State;
import androidx.constraintlayout.core.state.helpers.BarrierReference;
import androidx.constraintlayout.core.state.helpers.Facade;
import androidx.constraintlayout.core.state.helpers.GuidelineReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0000\u001a\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0000\u001a\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0000\u001a\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0000\u001a \u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0000\u001a\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\fH\u0000\u001a\u0018\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0001\u001a\u00020\u0014H\u0000\u001a \u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0000H\u0000\u001a\u0018\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0001\u001a\u00020\u0014H\u0000\u001a\u0018\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0001\u001a\u00020\u0014H\u0000\u001a \u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001dH\u0000\u001a \u0010\u001f\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0001\u001a\u00020\u0014H\u0000\u001a(\u0010$\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0016\u0010#\u001a\u0012\u0012\u0004\u0012\u00020!0 j\b\u0012\u0004\u0012\u00020!`\"H\u0000\u001a \u0010&\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\u0014H\u0000\u001a \u0010'\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0001\u001a\u00020\u0014H\u0000\u001a(\u0010,\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020\u001d2\u0006\u0010+\u001a\u00020*H\u0000\u001a \u0010-\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020*H\u0000\u001a(\u00100\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020\f2\u0006\u0010/\u001a\u00020\u0000H\u0002\u001a \u00102\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u001c2\u0006\u00101\u001a\u00020\f2\u0006\u0010%\u001a\u00020\u0000H\u0000\u001a(\u00103\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u00101\u001a\u00020\f2\u0006\u0010%\u001a\u00020\u0000H\u0000\u001a \u00107\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u00002\u0006\u00105\u001a\u0002042\u0006\u00106\u001a\u00020\fH\u0002\u001a0\u00108\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\u00002\u0006\u00105\u001a\u0002042\u0006\u00106\u001a\u00020\fH\u0002\u001a\u0010\u0010;\u001a\u00020:2\u0006\u00109\u001a\u00020\fH\u0002\u001a \u0010<\u001a\u00020:2\u0006\u0010%\u001a\u00020\u00002\u0006\u00106\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u001cH\u0002\u001a\u0019\u0010>\u001a\u0004\u0018\u00010\u000e2\u0006\u0010=\u001a\u00020\fH\u0002¢\u0006\u0004\b>\u0010?\u001a\u0012\u0010@\u001a\u0004\u0018\u00010\f2\u0006\u0010%\u001a\u00020\u0000H\u0000\"\u0016\u0010B\u001a\u00020A8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\bB\u0010C¨\u0006D"}, d2 = {"Landroidx/constraintlayout/core/parser/CLObject;", "json", "Landroidx/constraintlayout/core/state/Transition;", "transition", "", "parseTransition", "keyPosition", "parseKeyPosition", "keyAttribute", "parseKeyAttribute", "keyCycleData", "parseKeyCycle", "", "content", "", "state", "parseJSON", "Landroidx/constraintlayout/compose/MotionScene;", "scene", "parseMotionSceneJSON", "", "parseConstraintSets", "baseJson", "name", "overrideValue", "override", "parseTransitions", "parseHeader", "Landroidx/constraintlayout/compose/State;", "Landroidx/constraintlayout/compose/LayoutVariables;", "layoutVariables", "parseVariables", "Ljava/util/ArrayList;", "Landroidx/constraintlayout/compose/DesignElement;", "Lkotlin/collections/ArrayList;", "list", "parseDesignElementsJSON", "element", "parseHelpers", "parseGenerate", "orientation", "margins", "Landroidx/constraintlayout/core/parser/CLArray;", "helper", "parseChain", "parseGuideline", "guidelineId", "params", "parseGuidelineParams", "elementName", "parseBarrier", "parseWidget", "Landroidx/constraintlayout/core/state/ConstraintReference;", "reference", "constraintName", "parseCustomProperties", "parseConstraint", "dimensionString", "Landroidx/constraintlayout/core/state/Dimension;", "parseDimensionMode", "parseDimension", "value", "parseColorString", "(Ljava/lang/String;)Ljava/lang/Integer;", "lookForType", "", "PARSER_DEBUG", "Z", "compose_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConstraintSetParserKt {
    public static final boolean PARSER_DEBUG = false;

    @Nullable
    public static final String lookForType(@NotNull CLObject cLObject) {
        Intrinsics.checkNotNullParameter(cLObject, "element");
        ArrayList<String> names = cLObject.names();
        if (names == null) {
            return null;
        }
        IntIterator it = RangesKt.until(0, names.size()).iterator();
        while (it.hasNext()) {
            if (names.get(it.nextInt()).equals("type")) {
                return cLObject.getString("type");
            }
        }
        return null;
    }

    public static final void override(@NotNull CLObject cLObject, @NotNull String str, @NotNull CLObject cLObject2) {
        Intrinsics.checkNotNullParameter(cLObject, "baseJson");
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(cLObject2, "overrideValue");
        if (!cLObject.has(str)) {
            cLObject.put(str, cLObject2);
            return;
        }
        CLObject object = cLObject.getObject(str);
        Iterator<String> it = cLObject2.names().iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (next.equals("clear")) {
                CLArray array = cLObject2.getArray("clear");
                IntIterator it2 = RangesKt.until(0, array.size()).iterator();
                while (it2.hasNext()) {
                    String stringOrNull = array.getStringOrNull(it2.nextInt());
                    if (stringOrNull != null) {
                        int hashCode = stringOrNull.hashCode();
                        if (hashCode != -1727069561) {
                            if (hashCode != -1606703562) {
                                if (hashCode == 414334925 && stringOrNull.equals("dimensions")) {
                                    object.remove("width");
                                    object.remove("height");
                                }
                                object.remove(stringOrNull);
                            } else if (stringOrNull.equals("constraints")) {
                                object.remove("start");
                                object.remove("end");
                                object.remove("top");
                                object.remove("bottom");
                                object.remove("baseline");
                                object.remove("center");
                                object.remove("centerHorizontally");
                                object.remove("centerVertically");
                            } else {
                                object.remove(stringOrNull);
                            }
                        } else if (stringOrNull.equals("transforms")) {
                            object.remove("visibility");
                            object.remove("alpha");
                            object.remove("pivotX");
                            object.remove("pivotY");
                            object.remove("rotationX");
                            object.remove("rotationY");
                            object.remove("rotationZ");
                            object.remove("scaleX");
                            object.remove("scaleY");
                            object.remove("translationX");
                            object.remove("translationY");
                        } else {
                            object.remove(stringOrNull);
                        }
                    }
                }
            } else {
                object.put(next, cLObject2.get(next));
            }
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    public static final void parseBarrier(@NotNull State state, @NotNull String str, @NotNull CLObject cLObject) {
        CLArray arrayOrNull;
        int size;
        String string;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(str, "elementName");
        Intrinsics.checkNotNullParameter(cLObject, "element");
        BarrierReference barrier = state.barrier(str, State.Direction.END);
        ArrayList<String> names = cLObject.names();
        if (names == null) {
            return;
        }
        IntIterator it = RangesKt.until(0, names.size()).iterator();
        while (it.hasNext()) {
            String str2 = names.get(it.nextInt());
            if (str2 != null) {
                int hashCode = str2.hashCode();
                if (hashCode != -1081309778) {
                    if (hashCode == -962590849) {
                        if (str2.equals("direction") && (string = cLObject.getString(str2)) != null) {
                            switch (string.hashCode()) {
                                case -1383228885:
                                    if (!string.equals("bottom")) {
                                        break;
                                    } else {
                                        barrier.setBarrierDirection(State.Direction.BOTTOM);
                                        break;
                                    }
                                case 100571:
                                    if (!string.equals("end")) {
                                        break;
                                    } else {
                                        barrier.setBarrierDirection(State.Direction.END);
                                        break;
                                    }
                                case 115029:
                                    if (!string.equals("top")) {
                                        break;
                                    } else {
                                        barrier.setBarrierDirection(State.Direction.TOP);
                                        break;
                                    }
                                case 3317767:
                                    if (!string.equals("left")) {
                                        break;
                                    } else {
                                        barrier.setBarrierDirection(State.Direction.LEFT);
                                        break;
                                    }
                                case 108511772:
                                    if (!string.equals("right")) {
                                        break;
                                    } else {
                                        barrier.setBarrierDirection(State.Direction.RIGHT);
                                        break;
                                    }
                                case 109757538:
                                    if (!string.equals("start")) {
                                        break;
                                    } else {
                                        barrier.setBarrierDirection(State.Direction.START);
                                        break;
                                    }
                            }
                        }
                    } else if (hashCode == -567445985 && str2.equals("contains") && (arrayOrNull = cLObject.getArrayOrNull(str2)) != null && (size = arrayOrNull.size()) > 0) {
                        int i = 0;
                        while (true) {
                            int i2 = i + 1;
                            barrier.add(state.constraints(arrayOrNull.get(i).content()));
                            if (i2 >= size) {
                                break;
                            } else {
                                i = i2;
                            }
                        }
                    }
                } else if (str2.equals("margin")) {
                    float floatOrNaN = cLObject.getFloatOrNaN(str2);
                    if (!Float.isNaN(floatOrNaN)) {
                        barrier.margin((int) floatOrNaN);
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00d1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00cb A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void parseChain(int r7, @org.jetbrains.annotations.NotNull androidx.constraintlayout.compose.State r8, @org.jetbrains.annotations.NotNull androidx.constraintlayout.compose.LayoutVariables r9, @org.jetbrains.annotations.NotNull androidx.constraintlayout.core.parser.CLArray r10) {
        /*
            java.lang.String r0 = "state"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "margins"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "helper"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            if (r7 != 0) goto L17
            androidx.constraintlayout.core.state.helpers.HorizontalChainReference r7 = r8.horizontalChain()
            goto L1b
        L17:
            androidx.constraintlayout.core.state.helpers.VerticalChainReference r7 = r8.verticalChain()
        L1b:
            r0 = 1
            androidx.constraintlayout.core.parser.CLElement r1 = r10.get(r0)
            boolean r2 = r1 instanceof androidx.constraintlayout.core.parser.CLArray
            if (r2 == 0) goto Lf6
            androidx.constraintlayout.core.parser.CLArray r1 = (androidx.constraintlayout.core.parser.CLArray) r1
            int r2 = r1.size()
            if (r2 >= r0) goto L2e
            goto Lf6
        L2e:
            int r2 = r1.size()
            r3 = 0
            kotlin.ranges.IntRange r2 = kotlin.ranges.RangesKt.until(r3, r2)
            java.util.Iterator r2 = r2.iterator()
        L3b:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L54
            r4 = r2
            kotlin.collections.IntIterator r4 = (kotlin.collections.IntIterator) r4
            int r4 = r4.nextInt()
            java.lang.Object[] r5 = new java.lang.Object[r0]
            java.lang.String r4 = r1.getString(r4)
            r5[r3] = r4
            r7.add(r5)
            goto L3b
        L54:
            int r1 = r10.size()
            r2 = 2
            if (r1 <= r2) goto Lf6
            androidx.constraintlayout.core.parser.CLElement r10 = r10.get(r2)
            boolean r1 = r10 instanceof androidx.constraintlayout.core.parser.CLObject
            if (r1 != 0) goto L64
            return
        L64:
            androidx.constraintlayout.core.parser.CLObject r10 = (androidx.constraintlayout.core.parser.CLObject) r10
            java.util.ArrayList r1 = r10.names()
            if (r1 != 0) goto L6d
            return
        L6d:
            int r2 = r1.size()
            kotlin.ranges.IntRange r2 = kotlin.ranges.RangesKt.until(r3, r2)
            java.util.Iterator r2 = r2.iterator()
        L79:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto Lf6
            r4 = r2
            kotlin.collections.IntIterator r4 = (kotlin.collections.IntIterator) r4
            int r4 = r4.nextInt()
            java.lang.Object r4 = r1.get(r4)
            java.lang.String r4 = (java.lang.String) r4
            java.lang.String r5 = "style"
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r5)
            if (r5 == 0) goto Le6
            androidx.constraintlayout.core.parser.CLElement r4 = r10.get(r4)
            boolean r5 = r4 instanceof androidx.constraintlayout.core.parser.CLArray
            if (r5 == 0) goto Lb8
            r5 = r4
            androidx.constraintlayout.core.parser.CLArray r5 = (androidx.constraintlayout.core.parser.CLArray) r5
            int r6 = r5.size()
            if (r6 <= r0) goto Lb8
            java.lang.String r4 = r5.getString(r3)
            java.lang.String r6 = "styleObject.getString(0)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r6)
            float r5 = r5.getFloat(r0)
            r7.bias(r5)
            goto Lc2
        Lb8:
            java.lang.String r4 = r4.content()
            java.lang.String r5 = "styleObject.content()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
        Lc2:
            java.lang.String r5 = "packed"
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r5)
            if (r5 == 0) goto Ld1
            androidx.constraintlayout.core.state.State$Chain r4 = androidx.constraintlayout.core.state.State.Chain.PACKED
            r7.style(r4)
            goto L79
        Ld1:
            java.lang.String r5 = "spread_inside"
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r5)
            if (r4 == 0) goto Le0
            androidx.constraintlayout.core.state.State$Chain r4 = androidx.constraintlayout.core.state.State.Chain.SPREAD_INSIDE
            r7.style(r4)
            goto L79
        Le0:
            androidx.constraintlayout.core.state.State$Chain r4 = androidx.constraintlayout.core.state.State.Chain.SPREAD
            r7.style(r4)
            goto L79
        Le6:
            java.lang.String r5 = "null cannot be cast to non-null type androidx.constraintlayout.core.state.ConstraintReference"
            java.util.Objects.requireNonNull(r7, r5)
            java.lang.String r5 = "constraintName"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            parseConstraint(r8, r9, r10, r7, r4)
            goto L79
        Lf6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.compose.ConstraintSetParserKt.parseChain(int, androidx.constraintlayout.compose.State, androidx.constraintlayout.compose.LayoutVariables, androidx.constraintlayout.core.parser.CLArray):void");
    }

    private static final Integer parseColorString(String str) {
        if (!StringsKt.startsWith$default(str, '#', false, 2, (Object) null)) {
            return null;
        }
        Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
        String substring = str.substring(1);
        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
        if (substring.length() == 6) {
            substring = Intrinsics.stringPlus("FF", substring);
        }
        return Integer.valueOf((int) Long.parseLong(substring, 16));
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    private static final void parseConstraint(State state, LayoutVariables layoutVariables, CLObject cLObject, ConstraintReference constraintReference, String str) {
        float f;
        float f2;
        CLArray arrayOrNull = cLObject.getArrayOrNull(str);
        if (arrayOrNull == null || arrayOrNull.size() <= 1) {
            String stringOrNull = cLObject.getStringOrNull(str);
            if (stringOrNull != null) {
                ConstraintReference constraints = stringOrNull.equals("parent") ? state.constraints(androidx.constraintlayout.core.state.State.PARENT) : state.constraints(stringOrNull);
                switch (str.hashCode()) {
                    case -1720785339:
                        if (str.equals("baseline")) {
                            Object key = constraintReference.getKey();
                            Intrinsics.checkNotNullExpressionValue(key, "reference.key");
                            state.baselineNeededFor$compose_release(key);
                            Object key2 = constraints.getKey();
                            Intrinsics.checkNotNullExpressionValue(key2, "targetReference.key");
                            state.baselineNeededFor$compose_release(key2);
                            constraintReference.baselineToBaseline(constraints);
                            break;
                        }
                        break;
                    case -1383228885:
                        if (str.equals("bottom")) {
                            constraintReference.bottomToBottom(constraints);
                            break;
                        }
                        break;
                    case 100571:
                        if (str.equals("end")) {
                            constraintReference.endToEnd(constraints);
                            break;
                        }
                        break;
                    case 115029:
                        if (str.equals("top")) {
                            constraintReference.topToTop(constraints);
                            break;
                        }
                        break;
                    case 109757538:
                        if (str.equals("start")) {
                            constraintReference.startToStart(constraints);
                            break;
                        }
                        break;
                }
                return;
            }
            return;
        }
        String string = arrayOrNull.getString(0);
        String stringOrNull2 = arrayOrNull.getStringOrNull(1);
        if (arrayOrNull.size() > 2) {
            CLElement orNull = arrayOrNull.getOrNull(2);
            Intrinsics.checkNotNull(orNull);
            f = state.convertDimension(C0856Dp.m5214boximpl(C0856Dp.m5216constructorimpl(layoutVariables.get(orNull))));
        } else {
            f = 0.0f;
        }
        if (arrayOrNull.size() > 3) {
            CLElement orNull2 = arrayOrNull.getOrNull(3);
            Intrinsics.checkNotNull(orNull2);
            f2 = state.convertDimension(C0856Dp.m5214boximpl(C0856Dp.m5216constructorimpl(layoutVariables.get(orNull2))));
        } else {
            f2 = 0.0f;
        }
        ConstraintReference constraints2 = string.equals("parent") ? state.constraints(androidx.constraintlayout.core.state.State.PARENT) : state.constraints(string);
        float f3 = f2;
        switch (str.hashCode()) {
            case -1720785339:
                if (str.equals("baseline") && stringOrNull2 != null) {
                    int hashCode = stringOrNull2.hashCode();
                    if (hashCode == -1720785339) {
                        if (stringOrNull2.equals("baseline")) {
                            Object key3 = constraintReference.getKey();
                            Intrinsics.checkNotNullExpressionValue(key3, "reference.key");
                            state.baselineNeededFor$compose_release(key3);
                            Object key4 = constraints2.getKey();
                            Intrinsics.checkNotNullExpressionValue(key4, "targetReference.key");
                            state.baselineNeededFor$compose_release(key4);
                            constraintReference.baselineToBaseline(constraints2);
                            break;
                        }
                    } else if (hashCode == -1383228885) {
                        if (stringOrNull2.equals("bottom")) {
                            Object key5 = constraintReference.getKey();
                            Intrinsics.checkNotNullExpressionValue(key5, "reference.key");
                            state.baselineNeededFor$compose_release(key5);
                            Object key6 = constraints2.getKey();
                            Intrinsics.checkNotNullExpressionValue(key6, "targetReference.key");
                            state.baselineNeededFor$compose_release(key6);
                            constraintReference.baselineToBottom(constraints2);
                            break;
                        }
                    } else if (hashCode == 115029 && stringOrNull2.equals("top")) {
                        Object key7 = constraintReference.getKey();
                        Intrinsics.checkNotNullExpressionValue(key7, "reference.key");
                        state.baselineNeededFor$compose_release(key7);
                        Object key8 = constraints2.getKey();
                        Intrinsics.checkNotNullExpressionValue(key8, "targetReference.key");
                        state.baselineNeededFor$compose_release(key8);
                        constraintReference.baselineToTop(constraints2);
                        break;
                    }
                }
                break;
            case -1498085729:
                if (str.equals("circular")) {
                    CLElement cLElement = arrayOrNull.get(1);
                    Intrinsics.checkNotNullExpressionValue(cLElement, "constraint.get(1)");
                    constraintReference.circularConstraint(constraints2, layoutVariables.get(cLElement), 0.0f);
                    break;
                }
                break;
            case -1383228885:
                if (str.equals("bottom")) {
                    if (!Intrinsics.areEqual(stringOrNull2, "top")) {
                        if (Intrinsics.areEqual(stringOrNull2, "bottom")) {
                            constraintReference.bottomToBottom(constraints2);
                            break;
                        }
                    } else {
                        constraintReference.bottomToTop(constraints2);
                        break;
                    }
                }
                break;
            case 100571:
                if (str.equals("end")) {
                    if (!Intrinsics.areEqual(stringOrNull2, "start")) {
                        if (Intrinsics.areEqual(stringOrNull2, "end")) {
                            constraintReference.endToEnd(constraints2);
                            break;
                        }
                    } else {
                        constraintReference.endToStart(constraints2);
                        break;
                    }
                }
                break;
            case 115029:
                if (str.equals("top")) {
                    if (!Intrinsics.areEqual(stringOrNull2, "top")) {
                        if (Intrinsics.areEqual(stringOrNull2, "bottom")) {
                            constraintReference.topToBottom(constraints2);
                            break;
                        }
                    } else {
                        constraintReference.topToTop(constraints2);
                        break;
                    }
                }
                break;
            case 3317767:
                if (str.equals("left")) {
                    if (!Intrinsics.areEqual(stringOrNull2, "left")) {
                        if (Intrinsics.areEqual(stringOrNull2, "right")) {
                            constraintReference.leftToRight(constraints2);
                            break;
                        }
                    } else {
                        constraintReference.leftToLeft(constraints2);
                        break;
                    }
                }
                break;
            case 108511772:
                if (str.equals("right")) {
                    if (!Intrinsics.areEqual(stringOrNull2, "left")) {
                        if (Intrinsics.areEqual(stringOrNull2, "right")) {
                            constraintReference.rightToRight(constraints2);
                            break;
                        }
                    } else {
                        constraintReference.rightToLeft(constraints2);
                        break;
                    }
                }
                break;
            case 109757538:
                if (str.equals("start")) {
                    if (!Intrinsics.areEqual(stringOrNull2, "start")) {
                        if (Intrinsics.areEqual(stringOrNull2, "end")) {
                            constraintReference.startToEnd(constraints2);
                            break;
                        }
                    } else {
                        constraintReference.startToStart(constraints2);
                        break;
                    }
                }
                break;
        }
        constraintReference.margin(Float.valueOf(f)).marginGone((int) f3);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00ae A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0026 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void parseConstraintSets(@org.jetbrains.annotations.NotNull androidx.constraintlayout.compose.MotionScene r13, @org.jetbrains.annotations.NotNull java.lang.Object r14) {
        /*
            java.lang.String r0 = "scene"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "json"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            boolean r0 = r14 instanceof androidx.constraintlayout.core.parser.CLObject
            if (r0 != 0) goto L10
            return
        L10:
            androidx.constraintlayout.core.parser.CLObject r14 = (androidx.constraintlayout.core.parser.CLObject) r14
            java.util.ArrayList r0 = r14.names()
            if (r0 != 0) goto L19
            return
        L19:
            int r1 = r0.size()
            r2 = 0
            kotlin.ranges.IntRange r1 = kotlin.ranges.RangesKt.until(r2, r1)
            java.util.Iterator r1 = r1.iterator()
        L26:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto Lbf
            r3 = r1
            kotlin.collections.IntIterator r3 = (kotlin.collections.IntIterator) r3
            int r3 = r3.nextInt()
            java.lang.Object r3 = r0.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            androidx.constraintlayout.core.parser.CLObject r4 = r14.getObject(r3)
            java.lang.String r5 = "Extends"
            java.lang.String r5 = r4.getStringOrNull(r5)
            r6 = 1
            java.lang.String r7 = "csName"
            if (r5 == 0) goto Lab
            int r8 = r5.length()
            if (r8 <= 0) goto L50
            r8 = 1
            goto L51
        L50:
            r8 = 0
        L51:
            if (r8 == 0) goto Lab
            java.lang.String r5 = r13.getConstraintSet(r5)
            if (r5 == 0) goto Lab
            androidx.constraintlayout.core.parser.CLObject r5 = androidx.constraintlayout.core.parser.CLParser.parse(r5)
            java.util.ArrayList r8 = r4.names()
            if (r8 == 0) goto Lab
            int r9 = r8.size()
            kotlin.ranges.IntRange r9 = kotlin.ranges.RangesKt.until(r2, r9)
            java.util.Iterator r9 = r9.iterator()
        L6f:
            boolean r10 = r9.hasNext()
            if (r10 == 0) goto L9b
            r10 = r9
            kotlin.collections.IntIterator r10 = (kotlin.collections.IntIterator) r10
            int r10 = r10.nextInt()
            java.lang.Object r10 = r8.get(r10)
            java.lang.String r10 = (java.lang.String) r10
            androidx.constraintlayout.core.parser.CLElement r11 = r4.get(r10)
            boolean r12 = r11 instanceof androidx.constraintlayout.core.parser.CLObject
            if (r12 == 0) goto L6f
            java.lang.String r12 = "baseJson"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r12)
            java.lang.String r12 = "widgetOverrideName"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r12)
            androidx.constraintlayout.core.parser.CLObject r11 = (androidx.constraintlayout.core.parser.CLObject) r11
            override(r5, r10, r11)
            goto L6f
        L9b:
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r7)
            java.lang.String r5 = r5.toJSON()
            java.lang.String r8 = "baseJson.toJSON()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r8)
            r13.setConstraintSetContent(r3, r5)
            goto Lac
        Lab:
            r6 = 0
        Lac:
            if (r6 != 0) goto L26
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r7)
            java.lang.String r4 = r4.toJSON()
            java.lang.String r5 = "constraintSet.toJSON()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            r13.setConstraintSetContent(r3, r4)
            goto L26
        Lbf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.compose.ConstraintSetParserKt.parseConstraintSets(androidx.constraintlayout.compose.MotionScene, java.lang.Object):void");
    }

    private static final void parseCustomProperties(CLObject cLObject, ConstraintReference constraintReference, String str) {
        ArrayList<String> names;
        CLObject objectOrNull = cLObject.getObjectOrNull(str);
        if (objectOrNull == null || (names = objectOrNull.names()) == null) {
            return;
        }
        IntIterator it = RangesKt.until(0, names.size()).iterator();
        while (it.hasNext()) {
            String str2 = names.get(it.nextInt());
            CLElement cLElement = objectOrNull.get(str2);
            if (cLElement instanceof CLNumber) {
                constraintReference.addCustomFloat(str2, cLElement.getFloat());
            } else if (cLElement instanceof CLString) {
                String content = cLElement.content();
                Intrinsics.checkNotNullExpressionValue(content, "value.content()");
                Integer parseColorString = parseColorString(content);
                if (parseColorString != null) {
                    constraintReference.addCustomColor(str2, parseColorString.intValue());
                }
            }
        }
    }

    public static final void parseDesignElementsJSON(@NotNull String str, @NotNull ArrayList<DesignElement> arrayList) {
        CLObject cLObject;
        ArrayList<String> arrayList2;
        Intrinsics.checkNotNullParameter(str, "content");
        Intrinsics.checkNotNullParameter(arrayList, "list");
        CLObject parse = CLParser.parse(str);
        ArrayList<String> names = parse.names();
        if (names == null) {
            return;
        }
        int i = 0;
        IntIterator it = RangesKt.until(0, names.size()).iterator();
        while (it.hasNext()) {
            String str2 = names.get(it.nextInt());
            CLElement cLElement = parse.get(str2);
            if (Intrinsics.areEqual(str2, "Design")) {
                Objects.requireNonNull(cLElement, "null cannot be cast to non-null type androidx.constraintlayout.core.parser.CLObject");
                CLObject cLObject2 = (CLObject) cLElement;
                ArrayList<String> names2 = cLObject2.names();
                if (names2 == null) {
                    return;
                }
                IntIterator it2 = RangesKt.until(i, names2.size()).iterator();
                while (it2.hasNext()) {
                    String str3 = names2.get(it2.nextInt());
                    CLElement cLElement2 = cLObject2.get(str3);
                    Objects.requireNonNull(cLElement2, "null cannot be cast to non-null type androidx.constraintlayout.core.parser.CLObject");
                    CLObject cLObject3 = (CLObject) cLElement2;
                    System.out.printf("element found <" + ((Object) str3) + '>', new Object[i]);
                    String stringOrNull = cLObject3.getStringOrNull("type");
                    if (stringOrNull != null) {
                        HashMap hashMap = new HashMap();
                        int size = cLObject3.size() - 1;
                        if (size >= 0) {
                            int i2 = 0;
                            while (true) {
                                int i3 = i2 + 1;
                                CLElement cLElement3 = cLObject3.get(i2);
                                cLObject = parse;
                                Objects.requireNonNull(cLElement3, "null cannot be cast to non-null type androidx.constraintlayout.core.parser.CLKey");
                                CLKey cLKey = (CLKey) cLElement3;
                                String content = cLKey.content();
                                CLElement value = cLKey.getValue();
                                String content2 = value == null ? null : value.content();
                                arrayList2 = names;
                                if (content2 != null) {
                                    Intrinsics.checkNotNullExpressionValue(content, "paramName");
                                    hashMap.put(content, content2);
                                }
                                if (i2 == size) {
                                    break;
                                }
                                i2 = i3;
                                parse = cLObject;
                                names = arrayList2;
                            }
                        } else {
                            cLObject = parse;
                            arrayList2 = names;
                        }
                        Intrinsics.checkNotNullExpressionValue(str3, "elementName");
                        arrayList.add(new DesignElement(str3, stringOrNull, hashMap));
                    } else {
                        cLObject = parse;
                        arrayList2 = names;
                    }
                    parse = cLObject;
                    names = arrayList2;
                    i = 0;
                }
            }
            parse = parse;
            names = names;
            i = 0;
        }
    }

    private static final androidx.constraintlayout.core.state.Dimension parseDimension(CLObject cLObject, String str, State state) {
        CLElement cLElement = cLObject.get(str);
        androidx.constraintlayout.core.state.Dimension Fixed = androidx.constraintlayout.core.state.Dimension.Fixed(0);
        Intrinsics.checkNotNullExpressionValue(Fixed, "Fixed(0)");
        if (cLElement instanceof CLString) {
            String content = cLElement.content();
            Intrinsics.checkNotNullExpressionValue(content, "dimensionElement.content()");
            return parseDimensionMode(content);
        }
        if (cLElement instanceof CLNumber) {
            androidx.constraintlayout.core.state.Dimension Fixed2 = androidx.constraintlayout.core.state.Dimension.Fixed(state.convertDimension(C0856Dp.m5214boximpl(C0856Dp.m5216constructorimpl(cLObject.getFloat(str)))));
            Intrinsics.checkNotNullExpressionValue(Fixed2, "Fixed(\n            state.convertDimension(\n                Dp(\n                    element.getFloat(constraintName)\n                )\n            )\n        )");
            return Fixed2;
        }
        if (!(cLElement instanceof CLObject)) {
            return Fixed;
        }
        CLObject cLObject2 = (CLObject) cLElement;
        String stringOrNull = cLObject2.getStringOrNull("value");
        if (stringOrNull != null) {
            Fixed = parseDimensionMode(stringOrNull);
        }
        CLElement orNull = cLObject2.getOrNull("min");
        if (orNull != null) {
            if (orNull instanceof CLNumber) {
                Fixed.min(state.convertDimension(C0856Dp.m5214boximpl(C0856Dp.m5216constructorimpl(orNull.getFloat()))));
            } else if (orNull instanceof CLString) {
                Fixed.min(androidx.constraintlayout.core.state.Dimension.WRAP_DIMENSION);
            }
        }
        CLElement orNull2 = cLObject2.getOrNull("max");
        if (orNull2 == null) {
            return Fixed;
        }
        if (orNull2 instanceof CLNumber) {
            Fixed.max(state.convertDimension(C0856Dp.m5214boximpl(C0856Dp.m5216constructorimpl(orNull2.getFloat()))));
            return Fixed;
        }
        if (!(orNull2 instanceof CLString)) {
            return Fixed;
        }
        Fixed.max(androidx.constraintlayout.core.state.Dimension.WRAP_DIMENSION);
        return Fixed;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:31)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visit(SwitchOverStringVisitor.java:60)
     */
    private static final androidx.constraintlayout.core.state.Dimension parseDimensionMode(String str) {
        androidx.constraintlayout.core.state.Dimension Fixed = androidx.constraintlayout.core.state.Dimension.Fixed(0);
        Intrinsics.checkNotNullExpressionValue(Fixed, "Fixed(0)");
        switch (str.hashCode()) {
            case -1460244870:
                if (str.equals("preferWrap")) {
                    androidx.constraintlayout.core.state.Dimension Suggested = androidx.constraintlayout.core.state.Dimension.Suggested(androidx.constraintlayout.core.state.Dimension.WRAP_DIMENSION);
                    Intrinsics.checkNotNullExpressionValue(Suggested, "Suggested(WRAP_DIMENSION)");
                    return Suggested;
                }
                break;
            case -995424086:
                if (str.equals("parent")) {
                    androidx.constraintlayout.core.state.Dimension Parent = androidx.constraintlayout.core.state.Dimension.Parent();
                    Intrinsics.checkNotNullExpressionValue(Parent, "Parent()");
                    return Parent;
                }
                break;
            case -895684237:
                if (str.equals("spread")) {
                    androidx.constraintlayout.core.state.Dimension Suggested2 = androidx.constraintlayout.core.state.Dimension.Suggested(androidx.constraintlayout.core.state.Dimension.SPREAD_DIMENSION);
                    Intrinsics.checkNotNullExpressionValue(Suggested2, "Suggested(SPREAD_DIMENSION)");
                    return Suggested2;
                }
                break;
            case 3657802:
                if (str.equals("wrap")) {
                    androidx.constraintlayout.core.state.Dimension Wrap = androidx.constraintlayout.core.state.Dimension.Wrap();
                    Intrinsics.checkNotNullExpressionValue(Wrap, "Wrap()");
                    return Wrap;
                }
                break;
        }
        if (StringsKt.endsWith$default(str, '%', false, 2, (Object) null)) {
            androidx.constraintlayout.core.state.Dimension suggested = androidx.constraintlayout.core.state.Dimension.Percent(0, Float.parseFloat(StringsKt.substringBefore$default(str, '%', (String) null, 2, (Object) null)) / 100.0f).suggested(0);
            Intrinsics.checkNotNullExpressionValue(suggested, "Percent(0, percentValue).suggested(0)");
            return suggested;
        }
        if (!StringsKt.contains$default(str, ':', false, 2, (Object) null)) {
            return Fixed;
        }
        androidx.constraintlayout.core.state.Dimension suggested2 = androidx.constraintlayout.core.state.Dimension.Ratio(str).suggested(androidx.constraintlayout.core.state.Dimension.SPREAD_DIMENSION);
        Intrinsics.checkNotNullExpressionValue(suggested2, "Ratio(dimensionString).suggested(SPREAD_DIMENSION)");
        return suggested2;
    }

    public static final void parseGenerate(@NotNull State state, @NotNull LayoutVariables layoutVariables, @NotNull Object obj) {
        CLObject cLObject;
        ArrayList<String> names;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(layoutVariables, "layoutVariables");
        Intrinsics.checkNotNullParameter(obj, "json");
        if ((obj instanceof CLObject) && (names = (cLObject = (CLObject) obj).names()) != null) {
            IntIterator it = RangesKt.until(0, names.size()).iterator();
            while (it.hasNext()) {
                String str = names.get(it.nextInt());
                CLElement cLElement = cLObject.get(str);
                Intrinsics.checkNotNullExpressionValue(str, "elementName");
                ArrayList<String> list = layoutVariables.getList(str);
                if (list != null && (cLElement instanceof CLObject)) {
                    Iterator<String> it2 = list.iterator();
                    while (it2.hasNext()) {
                        String next = it2.next();
                        Intrinsics.checkNotNullExpressionValue(next, "id");
                        parseWidget(state, layoutVariables, next, (CLObject) cLElement);
                    }
                }
            }
        }
    }

    public static final void parseGuideline(int i, @NotNull State state, @NotNull CLArray cLArray) {
        CLObject cLObject;
        String stringOrNull;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(cLArray, "helper");
        CLElement cLElement = cLArray.get(1);
        if ((cLElement instanceof CLObject) && (stringOrNull = (cLObject = (CLObject) cLElement).getStringOrNull("id")) != null) {
            parseGuidelineParams(i, state, stringOrNull, cLObject);
        }
    }

    private static final void parseGuidelineParams(int i, State state, String str, CLObject cLObject) {
        ArrayList<String> names = cLObject.names();
        if (names == null) {
            return;
        }
        ConstraintReference constraints = state.constraints(str);
        if (i == 0) {
            state.horizontalGuideline(str);
        } else {
            state.verticalGuideline(str);
        }
        Facade facade = constraints.getFacade();
        Objects.requireNonNull(facade, "null cannot be cast to non-null type androidx.constraintlayout.core.state.helpers.GuidelineReference");
        GuidelineReference guidelineReference = (GuidelineReference) facade;
        IntIterator it = RangesKt.until(0, names.size()).iterator();
        while (it.hasNext()) {
            String str2 = names.get(it.nextInt());
            if (str2 != null) {
                int hashCode = str2.hashCode();
                if (hashCode != -678927291) {
                    if (hashCode != 100571) {
                        if (hashCode == 109757538 && str2.equals("start")) {
                            guidelineReference.start(Integer.valueOf(state.convertDimension(C0856Dp.m5214boximpl(C0856Dp.m5216constructorimpl(cLObject.getFloat(str2))))));
                        }
                    } else if (str2.equals("end")) {
                        guidelineReference.end(Integer.valueOf(state.convertDimension(C0856Dp.m5214boximpl(C0856Dp.m5216constructorimpl(cLObject.getFloat(str2))))));
                    }
                } else if (str2.equals("percent")) {
                    guidelineReference.percent(cLObject.getFloat(str2));
                }
            }
        }
    }

    public static final void parseHeader(@NotNull MotionScene motionScene, @NotNull Object obj) {
        String stringOrNull;
        Intrinsics.checkNotNullParameter(motionScene, "scene");
        Intrinsics.checkNotNullParameter(obj, "json");
        if ((obj instanceof CLObject) && (stringOrNull = ((CLObject) obj).getStringOrNull("export")) != null) {
            motionScene.setDebugName(stringOrNull);
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    public static final void parseHelpers(@NotNull State state, @NotNull LayoutVariables layoutVariables, @NotNull Object obj) {
        String string;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(layoutVariables, "layoutVariables");
        Intrinsics.checkNotNullParameter(obj, "element");
        if (obj instanceof CLArray) {
            CLArray cLArray = (CLArray) obj;
            IntIterator it = RangesKt.until(0, cLArray.size()).iterator();
            while (it.hasNext()) {
                CLElement cLElement = cLArray.get(it.nextInt());
                if (cLElement instanceof CLArray) {
                    CLArray cLArray2 = (CLArray) cLElement;
                    if (cLArray2.size() > 1 && (string = cLArray2.getString(0)) != null) {
                        switch (string.hashCode()) {
                            case -1785507558:
                                if (!string.equals("vGuideline")) {
                                    break;
                                } else {
                                    parseGuideline(1, state, cLArray2);
                                    break;
                                }
                            case -1252464839:
                                if (!string.equals("hChain")) {
                                    break;
                                } else {
                                    parseChain(0, state, layoutVariables, cLArray2);
                                    break;
                                }
                            case -851656725:
                                if (!string.equals("vChain")) {
                                    break;
                                } else {
                                    parseChain(1, state, layoutVariables, cLArray2);
                                    break;
                                }
                            case 965681512:
                                if (!string.equals("hGuideline")) {
                                    break;
                                } else {
                                    parseGuideline(0, state, cLArray2);
                                    break;
                                }
                        }
                    }
                }
            }
        }
    }

    public static final void parseJSON(@NotNull String str, @NotNull androidx.constraintlayout.core.state.Transition transition, int i) {
        CLObject objectOrNull;
        Intrinsics.checkNotNullParameter(str, "content");
        Intrinsics.checkNotNullParameter(transition, "transition");
        try {
            CLObject parse = CLParser.parse(str);
            ArrayList<String> names = parse.names();
            if (names == null) {
                return;
            }
            IntIterator it = RangesKt.until(0, names.size()).iterator();
            while (it.hasNext()) {
                String str2 = names.get(it.nextInt());
                CLElement cLElement = parse.get(str2);
                if ((cLElement instanceof CLObject) && (objectOrNull = ((CLObject) cLElement).getObjectOrNull("custom")) != null) {
                    ArrayList<String> names2 = objectOrNull.names();
                    if (names2 == null) {
                        return;
                    }
                    IntIterator it2 = RangesKt.until(0, names2.size()).iterator();
                    while (it2.hasNext()) {
                        String str3 = names2.get(it2.nextInt());
                        CLElement cLElement2 = objectOrNull.get(str3);
                        if (cLElement2 instanceof CLNumber) {
                            transition.addCustomFloat(i, str2, str3, cLElement2.getFloat());
                        } else if (cLElement2 instanceof CLString) {
                            String content = cLElement2.content();
                            Intrinsics.checkNotNullExpressionValue(content, "value.content()");
                            Integer parseColorString = parseColorString(content);
                            if (parseColorString != null) {
                                transition.addCustomColor(i, str2, str3, parseColorString.intValue());
                            }
                        }
                    }
                }
            }
        } catch (CLParsingException e) {
            System.err.println(Intrinsics.stringPlus("Error parsing JSON ", e));
        }
    }

    public static final void parseKeyAttribute(@NotNull CLObject cLObject, @NotNull androidx.constraintlayout.core.state.Transition transition) {
        CLArray arrayOrNull;
        Intrinsics.checkNotNullParameter(cLObject, "keyAttribute");
        Intrinsics.checkNotNullParameter(transition, "transition");
        CLArray arrayOrNull2 = cLObject.getArrayOrNull(TypedValues.AttributesType.S_TARGET);
        if (arrayOrNull2 == null || (arrayOrNull = cLObject.getArrayOrNull("frames")) == null) {
            return;
        }
        String stringOrNull = cLObject.getStringOrNull("transitionEasing");
        ArrayList arrayListOf = CollectionsKt.arrayListOf(new String[]{"scaleX", "scaleY", "translationX", "translationY", "translationZ", "rotationX", "rotationY", "rotationZ", "alpha"});
        ArrayList arrayListOf2 = CollectionsKt.arrayListOf(new Integer[]{311, 312, 304, 305, 306, 308, 309, 310, 303});
        ArrayList arrayList = new ArrayList();
        IntIterator it = RangesKt.until(0, arrayOrNull.size()).iterator();
        while (it.hasNext()) {
            it.nextInt();
            arrayList.add(new TypedBundle());
        }
        int size = arrayListOf.size();
        if (size > 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                Object obj = arrayListOf.get(i);
                Intrinsics.checkNotNullExpressionValue(obj, "attrNames[k]");
                String str = (String) obj;
                Object obj2 = arrayListOf2.get(i);
                Intrinsics.checkNotNullExpressionValue(obj2, "attrIds[k]");
                int intValue = ((Number) obj2).intValue();
                CLArray arrayOrNull3 = cLObject.getArrayOrNull(str);
                if (arrayOrNull3 != null && arrayOrNull3.size() != arrayList.size()) {
                    throw new CLParsingException("incorrect size for " + str + " array, not matching targets array!", cLObject);
                }
                if (arrayOrNull3 != null) {
                    IntIterator it2 = RangesKt.until(0, arrayList.size()).iterator();
                    while (it2.hasNext()) {
                        int nextInt = it2.nextInt();
                        ((TypedBundle) arrayList.get(nextInt)).add(intValue, arrayOrNull3.getFloat(nextInt));
                    }
                } else {
                    float floatOrNaN = cLObject.getFloatOrNaN(str);
                    if (!Float.isNaN(floatOrNaN)) {
                        IntIterator it3 = RangesKt.until(0, arrayList.size()).iterator();
                        while (it3.hasNext()) {
                            ((TypedBundle) arrayList.get(it3.nextInt())).add(intValue, floatOrNaN);
                        }
                    }
                }
                if (i2 >= size) {
                    break;
                } else {
                    i = i2;
                }
            }
        }
        String stringOrNull2 = cLObject.getStringOrNull("curveFit");
        IntIterator it4 = RangesKt.until(0, arrayOrNull2.size()).iterator();
        while (it4.hasNext()) {
            int nextInt2 = it4.nextInt();
            IntIterator it5 = RangesKt.until(0, arrayList.size()).iterator();
            while (it5.hasNext()) {
                int nextInt3 = it5.nextInt();
                String string = arrayOrNull2.getString(nextInt2);
                Object obj3 = arrayList.get(nextInt3);
                Intrinsics.checkNotNullExpressionValue(obj3, "bundles[j]");
                TypedBundle typedBundle = (TypedBundle) obj3;
                if (stringOrNull2 != null) {
                    if (Intrinsics.areEqual(stringOrNull2, "spline")) {
                        typedBundle.add(TypedValues.PositionType.TYPE_CURVE_FIT, 0);
                    } else if (Intrinsics.areEqual(stringOrNull2, "linear")) {
                        typedBundle.add(TypedValues.PositionType.TYPE_CURVE_FIT, 1);
                        typedBundle.addIfNotNull(TypedValues.PositionType.TYPE_TRANSITION_EASING, stringOrNull);
                        typedBundle.add(100, arrayOrNull.getInt(nextInt3));
                        transition.addKeyAttribute(string, typedBundle);
                    }
                }
                typedBundle.addIfNotNull(TypedValues.PositionType.TYPE_TRANSITION_EASING, stringOrNull);
                typedBundle.add(100, arrayOrNull.getInt(nextInt3));
                transition.addKeyAttribute(string, typedBundle);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0231  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0236 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void parseKeyCycle(@org.jetbrains.annotations.NotNull androidx.constraintlayout.core.parser.CLObject r18, @org.jetbrains.annotations.NotNull androidx.constraintlayout.core.state.Transition r19) {
        /*
            Method dump skipped, instructions count: 585
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.compose.ConstraintSetParserKt.parseKeyCycle(androidx.constraintlayout.core.parser.CLObject, androidx.constraintlayout.core.state.Transition):void");
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    public static final void parseKeyPosition(@NotNull CLObject cLObject, @NotNull androidx.constraintlayout.core.state.Transition transition) {
        int i;
        Intrinsics.checkNotNullParameter(cLObject, "keyPosition");
        Intrinsics.checkNotNullParameter(transition, "transition");
        TypedBundle typedBundle = new TypedBundle();
        CLArray array = cLObject.getArray(TypedValues.AttributesType.S_TARGET);
        CLArray array2 = cLObject.getArray("frames");
        CLArray arrayOrNull = cLObject.getArrayOrNull("percentX");
        CLArray arrayOrNull2 = cLObject.getArrayOrNull("percentY");
        CLArray arrayOrNull3 = cLObject.getArrayOrNull("percentWidth");
        CLArray arrayOrNull4 = cLObject.getArrayOrNull("percentHeight");
        String stringOrNull = cLObject.getStringOrNull(TypedValues.TransitionType.S_PATH_MOTION_ARC);
        String stringOrNull2 = cLObject.getStringOrNull("transitionEasing");
        String stringOrNull3 = cLObject.getStringOrNull("curveFit");
        String stringOrNull4 = cLObject.getStringOrNull("type");
        if (stringOrNull4 == null) {
            stringOrNull4 = "parentRelative";
        }
        if (arrayOrNull == null || array2.size() == arrayOrNull.size()) {
            if (arrayOrNull2 == null || array2.size() == arrayOrNull2.size()) {
                Iterator it = RangesKt.until(0, array.size()).iterator();
                while (it.hasNext()) {
                    String string = array.getString(((IntIterator) it).nextInt());
                    typedBundle.clear();
                    int hashCode = stringOrNull4.hashCode();
                    CLArray cLArray = array;
                    Iterator it2 = it;
                    if (hashCode != -1740452335) {
                        if (hashCode == -960240988) {
                            stringOrNull4.equals("deltaRelative");
                        } else if (hashCode == 1700994454 && stringOrNull4.equals("parentRelative")) {
                            i = 2;
                        }
                        i = 0;
                    } else {
                        if (stringOrNull4.equals("pathRelative")) {
                            i = 1;
                        }
                        i = 0;
                    }
                    typedBundle.add(TypedValues.PositionType.TYPE_POSITION_TYPE, i);
                    if (stringOrNull3 != null) {
                        if (Intrinsics.areEqual(stringOrNull3, "spline")) {
                            typedBundle.add(TypedValues.PositionType.TYPE_CURVE_FIT, 0);
                        } else if (Intrinsics.areEqual(stringOrNull3, "linear")) {
                            typedBundle.add(TypedValues.PositionType.TYPE_CURVE_FIT, 1);
                        }
                    }
                    typedBundle.addIfNotNull(TypedValues.PositionType.TYPE_TRANSITION_EASING, stringOrNull2);
                    if (stringOrNull != null) {
                        switch (stringOrNull.hashCode()) {
                            case -1857024520:
                                if (stringOrNull.equals("startVertical")) {
                                    typedBundle.add(509, 1);
                                    break;
                                }
                                break;
                            case -1007052250:
                                if (stringOrNull.equals("startHorizontal")) {
                                    typedBundle.add(509, 2);
                                    break;
                                }
                                break;
                            case 3145837:
                                if (stringOrNull.equals("flip")) {
                                    typedBundle.add(509, 3);
                                    break;
                                }
                                break;
                            case 3387192:
                                if (stringOrNull.equals(NetWork.CONN_TYPE_NONE)) {
                                    typedBundle.add(509, 0);
                                    break;
                                }
                                break;
                        }
                    }
                    IntIterator it3 = RangesKt.until(0, array2.size()).iterator();
                    while (it3.hasNext()) {
                        int nextInt = it3.nextInt();
                        String str = stringOrNull4;
                        typedBundle.add(100, array2.getInt(nextInt));
                        if (arrayOrNull != null) {
                            typedBundle.add(TypedValues.PositionType.TYPE_PERCENT_X, arrayOrNull.getFloat(nextInt));
                        }
                        if (arrayOrNull2 != null) {
                            typedBundle.add(TypedValues.PositionType.TYPE_PERCENT_Y, arrayOrNull2.getFloat(nextInt));
                        }
                        if (arrayOrNull3 != null) {
                            typedBundle.add(TypedValues.PositionType.TYPE_PERCENT_WIDTH, arrayOrNull3.getFloat(nextInt));
                        }
                        if (arrayOrNull4 != null) {
                            typedBundle.add(TypedValues.PositionType.TYPE_PERCENT_HEIGHT, arrayOrNull4.getFloat(nextInt));
                        }
                        transition.addKeyPosition(string, typedBundle);
                        stringOrNull4 = str;
                    }
                    array = cLArray;
                    it = it2;
                }
            }
        }
    }

    public static final void parseMotionSceneJSON(@NotNull MotionScene motionScene, @NotNull String str) {
        Intrinsics.checkNotNullParameter(motionScene, "scene");
        Intrinsics.checkNotNullParameter(str, "content");
        try {
            CLObject parse = CLParser.parse(str);
            ArrayList<String> names = parse.names();
            if (names == null) {
                return;
            }
            IntIterator it = RangesKt.until(0, names.size()).iterator();
            while (it.hasNext()) {
                String str2 = names.get(it.nextInt());
                CLElement cLElement = parse.get(str2);
                if (str2 != null) {
                    int hashCode = str2.hashCode();
                    if (hashCode != -2137403731) {
                        if (hashCode != -241441378) {
                            if (hashCode == 1101852654 && str2.equals("ConstraintSets")) {
                                Intrinsics.checkNotNullExpressionValue(cLElement, "element");
                                parseConstraintSets(motionScene, cLElement);
                            }
                        } else if (str2.equals(TypedValues.TransitionType.NAME)) {
                            Intrinsics.checkNotNullExpressionValue(cLElement, "element");
                            parseTransitions(motionScene, cLElement);
                        }
                    } else if (str2.equals("Header")) {
                        Intrinsics.checkNotNullExpressionValue(cLElement, "element");
                        parseHeader(motionScene, cLElement);
                    }
                }
            }
        } catch (CLParsingException e) {
            System.err.println(Intrinsics.stringPlus("Error parsing JSON ", e));
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    public static final void parseTransition(@NotNull CLObject cLObject, @NotNull androidx.constraintlayout.core.state.Transition transition) {
        boolean z;
        Intrinsics.checkNotNullParameter(cLObject, "json");
        Intrinsics.checkNotNullParameter(transition, "transition");
        String stringOrNull = cLObject.getStringOrNull(TypedValues.TransitionType.S_PATH_MOTION_ARC);
        TypedBundle typedBundle = new TypedBundle();
        boolean z2 = true;
        if (stringOrNull != null) {
            switch (stringOrNull.hashCode()) {
                case -1857024520:
                    if (stringOrNull.equals("startVertical")) {
                        typedBundle.add(509, 1);
                        break;
                    }
                    break;
                case -1007052250:
                    if (stringOrNull.equals("startHorizontal")) {
                        typedBundle.add(509, 2);
                        break;
                    }
                    break;
                case 3145837:
                    if (stringOrNull.equals("flip")) {
                        typedBundle.add(509, 3);
                        break;
                    }
                    break;
                case 3387192:
                    if (stringOrNull.equals(NetWork.CONN_TYPE_NONE)) {
                        typedBundle.add(509, 0);
                        break;
                    }
                    break;
            }
            z = true;
        } else {
            z = false;
        }
        String stringOrNull2 = cLObject.getStringOrNull("interpolator");
        if (stringOrNull2 != null) {
            typedBundle.add(TypedValues.TransitionType.TYPE_INTERPOLATOR, stringOrNull2);
            z = true;
        }
        float floatOrNaN = cLObject.getFloatOrNaN(TypedValues.TransitionType.S_STAGGERED);
        if (Float.isNaN(floatOrNaN)) {
            z2 = z;
        } else {
            typedBundle.add(TypedValues.TransitionType.TYPE_STAGGERED, floatOrNaN);
        }
        if (z2) {
            transition.setTransitionProperties(typedBundle);
        }
        CLObject objectOrNull = cLObject.getObjectOrNull("KeyFrames");
        if (objectOrNull == null) {
            return;
        }
        CLArray arrayOrNull = objectOrNull.getArrayOrNull("KeyPositions");
        if (arrayOrNull != null) {
            IntIterator it = RangesKt.until(0, arrayOrNull.size()).iterator();
            while (it.hasNext()) {
                CLElement cLElement = arrayOrNull.get(it.nextInt());
                if (cLElement instanceof CLObject) {
                    parseKeyPosition((CLObject) cLElement, transition);
                }
            }
        }
        CLArray arrayOrNull2 = objectOrNull.getArrayOrNull(TypedValues.AttributesType.NAME);
        if (arrayOrNull2 != null) {
            IntIterator it2 = RangesKt.until(0, arrayOrNull2.size()).iterator();
            while (it2.hasNext()) {
                CLElement cLElement2 = arrayOrNull2.get(it2.nextInt());
                if (cLElement2 instanceof CLObject) {
                    parseKeyAttribute((CLObject) cLElement2, transition);
                }
            }
        }
        CLArray arrayOrNull3 = objectOrNull.getArrayOrNull("KeyCycles");
        if (arrayOrNull3 != null) {
            IntIterator it3 = RangesKt.until(0, arrayOrNull3.size()).iterator();
            while (it3.hasNext()) {
                CLElement cLElement3 = arrayOrNull3.get(it3.nextInt());
                if (cLElement3 instanceof CLObject) {
                    parseKeyCycle((CLObject) cLElement3, transition);
                }
            }
        }
    }

    public static final void parseTransitions(@NotNull MotionScene motionScene, @NotNull Object obj) {
        CLObject cLObject;
        ArrayList<String> names;
        Intrinsics.checkNotNullParameter(motionScene, "scene");
        Intrinsics.checkNotNullParameter(obj, "json");
        if ((obj instanceof CLObject) && (names = (cLObject = (CLObject) obj).names()) != null) {
            IntIterator it = RangesKt.until(0, names.size()).iterator();
            while (it.hasNext()) {
                String str = names.get(it.nextInt());
                CLObject object = cLObject.getObject(str);
                Intrinsics.checkNotNullExpressionValue(str, "elementName");
                String json = object.toJSON();
                Intrinsics.checkNotNullExpressionValue(json, "element.toJSON()");
                motionScene.setTransitionContent(str, json);
            }
        }
    }

    public static final void parseVariables(@NotNull State state, @NotNull LayoutVariables layoutVariables, @NotNull Object obj) {
        CLObject cLObject;
        ArrayList<String> names;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(layoutVariables, "layoutVariables");
        Intrinsics.checkNotNullParameter(obj, "json");
        if ((obj instanceof CLObject) && (names = (cLObject = (CLObject) obj).names()) != null) {
            IntIterator it = RangesKt.until(0, names.size()).iterator();
            while (it.hasNext()) {
                String str = names.get(it.nextInt());
                CLElement cLElement = cLObject.get(str);
                if (cLElement instanceof CLNumber) {
                    Intrinsics.checkNotNullExpressionValue(str, "elementName");
                    layoutVariables.put(str, ((CLNumber) cLElement).getInt());
                } else if (cLElement instanceof CLObject) {
                    CLObject cLObject2 = (CLObject) cLElement;
                    if (cLObject2.has(TypedValues.TransitionType.S_FROM) && cLObject2.has(TypedValues.TransitionType.S_TO)) {
                        CLElement cLElement2 = cLObject2.get(TypedValues.TransitionType.S_FROM);
                        Intrinsics.checkNotNullExpressionValue(cLElement2, "element[\"from\"]");
                        float f = layoutVariables.get(cLElement2);
                        CLElement cLElement3 = cLObject2.get(TypedValues.TransitionType.S_TO);
                        Intrinsics.checkNotNullExpressionValue(cLElement3, "element[\"to\"]");
                        float f2 = layoutVariables.get(cLElement3);
                        String stringOrNull = cLObject2.getStringOrNull("prefix");
                        String str2 = stringOrNull == null ? "" : stringOrNull;
                        String stringOrNull2 = cLObject2.getStringOrNull("postfix");
                        if (stringOrNull2 == null) {
                            stringOrNull2 = "";
                        }
                        Intrinsics.checkNotNullExpressionValue(str, "elementName");
                        layoutVariables.put(str, f, f2, 1.0f, str2, stringOrNull2);
                    } else if (cLObject2.has(TypedValues.TransitionType.S_FROM) && cLObject2.has("step")) {
                        CLElement cLElement4 = cLObject2.get(TypedValues.TransitionType.S_FROM);
                        Intrinsics.checkNotNullExpressionValue(cLElement4, "element[\"from\"]");
                        float f3 = layoutVariables.get(cLElement4);
                        CLElement cLElement5 = cLObject2.get("step");
                        Intrinsics.checkNotNullExpressionValue(cLElement5, "element[\"step\"]");
                        float f4 = layoutVariables.get(cLElement5);
                        Intrinsics.checkNotNullExpressionValue(str, "elementName");
                        layoutVariables.put(str, f3, f4);
                    } else if (cLObject2.has("ids")) {
                        CLArray array = cLObject2.getArray("ids");
                        ArrayList<String> arrayList = new ArrayList<>();
                        int size = array.size();
                        if (size > 0) {
                            int i = 0;
                            while (true) {
                                int i2 = i + 1;
                                arrayList.add(array.getString(i));
                                if (i2 >= size) {
                                    break;
                                } else {
                                    i = i2;
                                }
                            }
                        }
                        Intrinsics.checkNotNullExpressionValue(str, "elementName");
                        layoutVariables.put(str, arrayList);
                    } else if (cLObject2.has("tag")) {
                        ArrayList<String> idsForTag = state.getIdsForTag(cLObject2.getString("tag"));
                        Intrinsics.checkNotNullExpressionValue(str, "elementName");
                        Intrinsics.checkNotNullExpressionValue(idsForTag, "arrayIds");
                        layoutVariables.put(str, idsForTag);
                    }
                }
            }
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final void parseWidget(@NotNull State state, @NotNull LayoutVariables layoutVariables, @NotNull String str, @NotNull CLObject cLObject) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(layoutVariables, "layoutVariables");
        Intrinsics.checkNotNullParameter(str, "elementName");
        Intrinsics.checkNotNullParameter(cLObject, "element");
        ConstraintReference constraints = state.constraints(str);
        if (constraints.getWidth() == null) {
            constraints.setWidth(androidx.constraintlayout.core.state.Dimension.Wrap());
        }
        if (constraints.getHeight() == null) {
            constraints.setHeight(androidx.constraintlayout.core.state.Dimension.Wrap());
        }
        ArrayList<String> names = cLObject.names();
        if (names == null) {
            return;
        }
        IntIterator it = RangesKt.until(0, names.size()).iterator();
        while (it.hasNext()) {
            String str2 = names.get(it.nextInt());
            if (str2 != null) {
                switch (str2.hashCode()) {
                    case -1448775240:
                        if (!str2.equals("centerVertically")) {
                            break;
                        } else {
                            String string = cLObject.getString(str2);
                            ConstraintReference constraints2 = string.equals("parent") ? state.constraints(androidx.constraintlayout.core.state.State.PARENT) : state.constraints(string);
                            constraints.topToTop(constraints2);
                            constraints.bottomToBottom(constraints2);
                            break;
                        }
                    case -1364013995:
                        if (!str2.equals("center")) {
                            break;
                        } else {
                            String string2 = cLObject.getString(str2);
                            ConstraintReference constraints3 = string2.equals("parent") ? state.constraints(androidx.constraintlayout.core.state.State.PARENT) : state.constraints(string2);
                            constraints.startToStart(constraints3);
                            constraints.endToEnd(constraints3);
                            constraints.topToTop(constraints3);
                            constraints.bottomToBottom(constraints3);
                            break;
                        }
                    case -1349088399:
                        if (!str2.equals("custom")) {
                            break;
                        } else {
                            Intrinsics.checkNotNullExpressionValue(constraints, "reference");
                            parseCustomProperties(cLObject, constraints, str2);
                            break;
                        }
                    case -1249320806:
                        if (!str2.equals("rotationX")) {
                            break;
                        } else {
                            CLElement cLElement = cLObject.get(str2);
                            Intrinsics.checkNotNullExpressionValue(cLElement, "element[constraintName]");
                            constraints.rotationX(layoutVariables.get(cLElement));
                            break;
                        }
                    case -1249320805:
                        if (!str2.equals("rotationY")) {
                            break;
                        } else {
                            CLElement cLElement2 = cLObject.get(str2);
                            Intrinsics.checkNotNullExpressionValue(cLElement2, "element[constraintName]");
                            constraints.rotationY(layoutVariables.get(cLElement2));
                            break;
                        }
                    case -1249320804:
                        if (!str2.equals("rotationZ")) {
                            break;
                        } else {
                            CLElement cLElement3 = cLObject.get(str2);
                            Intrinsics.checkNotNullExpressionValue(cLElement3, "element[constraintName]");
                            constraints.rotationZ(layoutVariables.get(cLElement3));
                            break;
                        }
                    case -1225497657:
                        if (!str2.equals("translationX")) {
                            break;
                        } else {
                            CLElement cLElement4 = cLObject.get(str2);
                            Intrinsics.checkNotNullExpressionValue(cLElement4, "element[constraintName]");
                            constraints.translationX(layoutVariables.get(cLElement4));
                            break;
                        }
                    case -1225497656:
                        if (!str2.equals("translationY")) {
                            break;
                        } else {
                            CLElement cLElement5 = cLObject.get(str2);
                            Intrinsics.checkNotNullExpressionValue(cLElement5, "element[constraintName]");
                            constraints.translationY(layoutVariables.get(cLElement5));
                            break;
                        }
                    case -1225497655:
                        if (!str2.equals("translationZ")) {
                            break;
                        } else {
                            CLElement cLElement6 = cLObject.get(str2);
                            Intrinsics.checkNotNullExpressionValue(cLElement6, "element[constraintName]");
                            constraints.translationZ(layoutVariables.get(cLElement6));
                            break;
                        }
                    case -1221029593:
                        if (!str2.equals("height")) {
                            break;
                        } else {
                            constraints.setHeight(parseDimension(cLObject, str2, state));
                            break;
                        }
                    case -987906986:
                        if (!str2.equals("pivotX")) {
                            break;
                        } else {
                            CLElement cLElement7 = cLObject.get(str2);
                            Intrinsics.checkNotNullExpressionValue(cLElement7, "element[constraintName]");
                            constraints.pivotX(layoutVariables.get(cLElement7));
                            break;
                        }
                    case -987906985:
                        if (!str2.equals("pivotY")) {
                            break;
                        } else {
                            CLElement cLElement8 = cLObject.get(str2);
                            Intrinsics.checkNotNullExpressionValue(cLElement8, "element[constraintName]");
                            constraints.pivotY(layoutVariables.get(cLElement8));
                            break;
                        }
                    case -908189618:
                        if (!str2.equals("scaleX")) {
                            break;
                        } else {
                            CLElement cLElement9 = cLObject.get(str2);
                            Intrinsics.checkNotNullExpressionValue(cLElement9, "element[constraintName]");
                            constraints.scaleX(layoutVariables.get(cLElement9));
                            break;
                        }
                    case -908189617:
                        if (!str2.equals("scaleY")) {
                            break;
                        } else {
                            CLElement cLElement10 = cLObject.get(str2);
                            Intrinsics.checkNotNullExpressionValue(cLElement10, "element[constraintName]");
                            constraints.scaleY(layoutVariables.get(cLElement10));
                            break;
                        }
                    case -61505906:
                        if (!str2.equals("vWeight")) {
                            break;
                        } else {
                            CLElement cLElement11 = cLObject.get(str2);
                            Intrinsics.checkNotNullExpressionValue(cLElement11, "element[constraintName]");
                            constraints.setVerticalChainWeight(layoutVariables.get(cLElement11));
                            break;
                        }
                    case 92909918:
                        if (!str2.equals("alpha")) {
                            break;
                        } else {
                            CLElement cLElement12 = cLObject.get(str2);
                            Intrinsics.checkNotNullExpressionValue(cLElement12, "element[constraintName]");
                            constraints.alpha(layoutVariables.get(cLElement12));
                            break;
                        }
                    case 98116417:
                        if (!str2.equals("hBias")) {
                            break;
                        } else {
                            CLElement cLElement13 = cLObject.get(str2);
                            Intrinsics.checkNotNullExpressionValue(cLElement13, "element[constraintName]");
                            constraints.horizontalBias(layoutVariables.get(cLElement13));
                            break;
                        }
                    case 111045711:
                        if (!str2.equals("vBias")) {
                            break;
                        } else {
                            CLElement cLElement14 = cLObject.get(str2);
                            Intrinsics.checkNotNullExpressionValue(cLElement14, "element[constraintName]");
                            constraints.verticalBias(layoutVariables.get(cLElement14));
                            break;
                        }
                    case 113126854:
                        if (!str2.equals("width")) {
                            break;
                        } else {
                            constraints.setWidth(parseDimension(cLObject, str2, state));
                            break;
                        }
                    case 398344448:
                        if (!str2.equals("hWeight")) {
                            break;
                        } else {
                            CLElement cLElement15 = cLObject.get(str2);
                            Intrinsics.checkNotNullExpressionValue(cLElement15, "element[constraintName]");
                            constraints.setHorizontalChainWeight(layoutVariables.get(cLElement15));
                            break;
                        }
                    case 1404070310:
                        if (!str2.equals("centerHorizontally")) {
                            break;
                        } else {
                            String string3 = cLObject.getString(str2);
                            ConstraintReference constraints4 = string3.equals("parent") ? state.constraints(androidx.constraintlayout.core.state.State.PARENT) : state.constraints(string3);
                            constraints.startToStart(constraints4);
                            constraints.endToEnd(constraints4);
                            break;
                        }
                    case 1941332754:
                        if (!str2.equals("visibility")) {
                            break;
                        } else {
                            String string4 = cLObject.getString(str2);
                            if (string4 != null) {
                                int hashCode = string4.hashCode();
                                if (hashCode == -1901805651) {
                                    if (!string4.equals("invisible")) {
                                        break;
                                    } else {
                                        constraints.visibility(4);
                                        break;
                                    }
                                } else if (hashCode == 3178655) {
                                    if (!string4.equals("gone")) {
                                        break;
                                    } else {
                                        constraints.visibility(8);
                                        break;
                                    }
                                } else if (hashCode == 466743410 && string4.equals("visible")) {
                                    constraints.visibility(0);
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                        break;
                }
            }
            Intrinsics.checkNotNullExpressionValue(constraints, "reference");
            Intrinsics.checkNotNullExpressionValue(str2, "constraintName");
            parseConstraint(state, layoutVariables, cLObject, constraints, str2);
        }
    }

    public static final void parseJSON(@NotNull String str, @NotNull State state, @NotNull LayoutVariables layoutVariables) {
        Intrinsics.checkNotNullParameter(str, "content");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(layoutVariables, "layoutVariables");
        try {
            CLObject parse = CLParser.parse(str);
            ArrayList<String> names = parse.names();
            if (names == null) {
                return;
            }
            IntIterator it = RangesKt.until(0, names.size()).iterator();
            while (it.hasNext()) {
                String str2 = names.get(it.nextInt());
                CLElement cLElement = parse.get(str2);
                if (str2 != null) {
                    int hashCode = str2.hashCode();
                    if (hashCode != -1824489883) {
                        if (hashCode != 1875016085) {
                            if (hashCode == 1921490263 && str2.equals("Variables")) {
                                Intrinsics.checkNotNullExpressionValue(cLElement, "element");
                                parseVariables(state, layoutVariables, cLElement);
                            }
                        } else if (str2.equals("Generate")) {
                            Intrinsics.checkNotNullExpressionValue(cLElement, "element");
                            parseGenerate(state, layoutVariables, cLElement);
                        }
                    } else if (str2.equals("Helpers")) {
                        Intrinsics.checkNotNullExpressionValue(cLElement, "element");
                        parseHelpers(state, layoutVariables, cLElement);
                    }
                }
                if (cLElement instanceof CLObject) {
                    String lookForType = lookForType((CLObject) cLElement);
                    if (lookForType != null) {
                        int hashCode2 = lookForType.hashCode();
                        if (hashCode2 != -1785507558) {
                            if (hashCode2 != -333143113) {
                                if (hashCode2 == 965681512 && lookForType.equals("hGuideline")) {
                                    Intrinsics.checkNotNullExpressionValue(str2, "elementName");
                                    parseGuidelineParams(0, state, str2, (CLObject) cLElement);
                                }
                            } else if (lookForType.equals("barrier")) {
                                Intrinsics.checkNotNullExpressionValue(str2, "elementName");
                                parseBarrier(state, str2, (CLObject) cLElement);
                            }
                        } else if (lookForType.equals("vGuideline")) {
                            Intrinsics.checkNotNullExpressionValue(str2, "elementName");
                            parseGuidelineParams(1, state, str2, (CLObject) cLElement);
                        }
                    } else {
                        Intrinsics.checkNotNullExpressionValue(str2, "elementName");
                        parseWidget(state, layoutVariables, str2, (CLObject) cLElement);
                    }
                } else if (cLElement instanceof CLNumber) {
                    Intrinsics.checkNotNullExpressionValue(str2, "elementName");
                    layoutVariables.put(str2, ((CLNumber) cLElement).getInt());
                }
            }
        } catch (CLParsingException e) {
            System.err.println(Intrinsics.stringPlus("Error parsing JSON ", e));
        }
    }
}
