package androidx.compose.p004ui.tooling.data;

import androidx.compose.p004ui.geometry.Offset;
import androidx.compose.p004ui.layout.LayoutCoordinatesKt;
import androidx.compose.p004ui.layout.LayoutInfo;
import androidx.compose.p004ui.layout.ModifierInfo;
import androidx.compose.p004ui.unit.IntRect;
import androidx.compose.p004ui.unit.IntSize;
import androidx.compose.runtime.tooling.CompositionData;
import androidx.compose.runtime.tooling.CompositionGroup;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.text.CharsKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class SlotTreeKt {
    private static final int BITS_PER_SLOT = 3;
    private static final int SLOT_MASK = 7;
    private static final int STABLE_BITS = 4;
    private static final int STATIC_BITS = 3;

    @NotNull
    private static final String changedFieldName = "$$changed";

    @NotNull
    private static final String defaultFieldName = "$$default";

    @NotNull
    private static final String internalFieldPrefix = "$$";

    @NotNull
    private static final String jacocoDataField = "$jacoco";

    @NotNull
    private static final String parameterPrefix = "$";

    @NotNull
    private static final String recomposeScopeNameSuffix = ".RecomposeScopeImpl";

    @NotNull
    private static final IntRect emptyBox = new IntRect(0, 0, 0, 0);

    @NotNull
    private static final Regex tokenizer = new Regex("(\\d+)|([,])|([*])|([:])|L|(P\\([^)]*\\))|(C(\\(([^)]*)\\))?)|@");

    @NotNull
    private static final Regex parametersInformationTokenizer = new Regex("(\\d+)|,|[!P()]|:([^,!)]+)");

    private static final Field accessibleField(Class<?> cls, String str) {
        Field field;
        Field[] declaredFields = cls.getDeclaredFields();
        Intrinsics.checkNotNullExpressionValue(declaredFields, "declaredFields");
        int length = declaredFields.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                field = null;
                break;
            }
            field = declaredFields[i];
            if (Intrinsics.areEqual(field.getName(), str)) {
                break;
            }
            i++;
        }
        if (field == null) {
            return null;
        }
        field.setAccessible(true);
        return field;
    }

    @UiToolingDataApi
    @NotNull
    public static final Group asTree(@NotNull CompositionData compositionData) {
        Group group;
        Intrinsics.checkNotNullParameter(compositionData, "<this>");
        CompositionGroup compositionGroup = (CompositionGroup) CollectionsKt.firstOrNull(compositionData.getCompositionGroups());
        return (compositionGroup == null || (group = getGroup(compositionGroup, null)) == null) ? EmptyGroup.INSTANCE : group;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IntRect boundsOfLayoutNode(LayoutInfo layoutInfo) {
        if (!layoutInfo.isAttached()) {
            return new IntRect(0, 0, layoutInfo.getWidth(), layoutInfo.getHeight());
        }
        long positionInWindow = LayoutCoordinatesKt.positionInWindow(layoutInfo.getCoordinates());
        long mo4191getSizeYbymL2g = layoutInfo.getCoordinates().mo4191getSizeYbymL2g();
        int roundToInt = MathKt.roundToInt(Offset.m2556getXimpl(positionInWindow));
        int roundToInt2 = MathKt.roundToInt(Offset.m2557getYimpl(positionInWindow));
        return new IntRect(roundToInt, roundToInt2, IntSize.m5376getWidthimpl(mo4191getSizeYbymL2g) + roundToInt, IntSize.m5375getHeightimpl(mo4191getSizeYbymL2g) + roundToInt2);
    }

    private static final String callName(MatchResult matchResult) {
        return (String) matchResult.getGroupValues().get(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0039 A[EDGE_INSN: B:13:0x0039->B:14:0x0039 BREAK  A[LOOP:0: B:4:0x000e->B:86:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c8 A[Catch: all -> 0x0177, TryCatch #0 {all -> 0x0177, blocks: (B:16:0x003b, B:18:0x0047, B:20:0x004d, B:23:0x0062, B:25:0x0073, B:26:0x0082, B:28:0x0094, B:30:0x00a5, B:32:0x00b4, B:36:0x00c8, B:38:0x00cb, B:42:0x00ce, B:44:0x00de, B:46:0x00e8, B:48:0x00ef, B:50:0x00f5, B:51:0x0101, B:53:0x010b, B:56:0x0126, B:61:0x013d, B:64:0x0146, B:68:0x0164, B:77:0x00fc, B:82:0x00e4), top: B:15:0x003b }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00cb A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:? A[LOOP:0: B:4:0x000e->B:86:?, LOOP_END, SYNTHETIC] */
    @androidx.compose.p004ui.tooling.data.UiToolingDataApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.util.List<androidx.compose.p004ui.tooling.data.ParameterInformation> extractParameterInfo(java.util.List<? extends java.lang.Object> r22, androidx.compose.p004ui.tooling.data.SourceInformationContext r23) {
        /*
            Method dump skipped, instructions count: 380
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.p004ui.tooling.data.SlotTreeKt.extractParameterInfo(java.util.List, androidx.compose.ui.tooling.data.SourceInformationContext):java.util.List");
    }

    @UiToolingDataApi
    @NotNull
    public static final List<ParameterInformation> findParameters(@NotNull CompositionGroup compositionGroup, @Nullable ContextCache contextCache) {
        Intrinsics.checkNotNullParameter(compositionGroup, "<this>");
        String sourceInfo = compositionGroup.getSourceInfo();
        if (sourceInfo == null) {
            return CollectionsKt.emptyList();
        }
        SourceInformationContext sourceInformationContext = null;
        if (contextCache == null) {
            sourceInformationContext = sourceInformationContextOf$default(sourceInfo, null, 2, null);
        } else {
            Map<String, Object> contexts$ui_tooling_data_release = contextCache.getContexts$ui_tooling_data_release();
            Object obj = contexts$ui_tooling_data_release.get(sourceInfo);
            if (obj == null) {
                obj = sourceInformationContextOf$default(sourceInfo, null, 2, null);
                contexts$ui_tooling_data_release.put(sourceInfo, obj);
            }
            if (obj instanceof SourceInformationContext) {
                sourceInformationContext = (SourceInformationContext) obj;
            }
        }
        ArrayList arrayList = new ArrayList();
        CollectionsKt.addAll(arrayList, compositionGroup.getData());
        return extractParameterInfo(arrayList, sourceInformationContext);
    }

    public static /* synthetic */ List findParameters$default(CompositionGroup compositionGroup, ContextCache contextCache, int i, Object obj) {
        if ((i & 1) != 0) {
            contextCache = null;
        }
        return findParameters(compositionGroup, contextCache);
    }

    @NotNull
    public static final IntRect getEmptyBox() {
        return emptyBox;
    }

    @UiToolingDataApi
    private static final Group getGroup(CompositionGroup compositionGroup, SourceInformationContext sourceInformationContext) {
        IntRect intRect;
        Object key = compositionGroup.getKey();
        String sourceInfo = compositionGroup.getSourceInfo();
        SourceInformationContext sourceInformationContextOf = sourceInfo != null ? sourceInformationContextOf(sourceInfo, sourceInformationContext) : null;
        Object node = compositionGroup.getNode();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        CollectionsKt.addAll(arrayList, compositionGroup.getData());
        Iterator<CompositionGroup> it = compositionGroup.getCompositionGroups().iterator();
        while (it.hasNext()) {
            arrayList2.add(getGroup(it.next(), sourceInformationContextOf));
        }
        boolean z = node instanceof LayoutInfo;
        List<ModifierInfo> modifierInfo = z ? ((LayoutInfo) node).getModifierInfo() : CollectionsKt.emptyList();
        if (z) {
            intRect = boundsOfLayoutNode((LayoutInfo) node);
        } else if (arrayList2.isEmpty()) {
            intRect = emptyBox;
        } else {
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                arrayList3.add(((Group) it2.next()).getBox());
            }
            Iterator it3 = arrayList3.iterator();
            if (!it3.hasNext()) {
                throw new UnsupportedOperationException("Empty collection can't be reduced.");
            }
            Object next = it3.next();
            while (it3.hasNext()) {
                next = union((IntRect) it3.next(), (IntRect) next);
            }
            intRect = (IntRect) next;
        }
        boolean z2 = true;
        SourceLocation nextSourceLocation = (!(sourceInformationContextOf != null && sourceInformationContextOf.isCall()) || sourceInformationContext == null) ? null : sourceInformationContext.nextSourceLocation();
        if (node != null) {
            return new NodeGroup(key, node, intRect, arrayList, modifierInfo, arrayList2);
        }
        String name = sourceInformationContextOf != null ? sourceInformationContextOf.getName() : null;
        String name2 = sourceInformationContextOf != null ? sourceInformationContextOf.getName() : null;
        if (name2 != null && name2.length() != 0) {
            z2 = false;
        }
        return new CallGroup(key, name, intRect, nextSourceLocation, (z2 || (intRect.getBottom() - intRect.getTop() <= 0 && intRect.getRight() - intRect.getLeft() <= 0)) ? null : compositionGroup.getIdentity(), extractParameterInfo(arrayList, sourceInformationContextOf), arrayList, arrayList2);
    }

    @UiToolingDataApi
    @Nullable
    public static final String getPosition(@NotNull Group group) {
        Intrinsics.checkNotNullParameter(group, "<this>");
        return keyPosition(group.getKey());
    }

    @UiToolingDataApi
    public static /* synthetic */ void getPosition$annotations(Group group) {
    }

    private static final String getText(MatchResult matchResult) {
        return (String) matchResult.getGroupValues().get(0);
    }

    private static final boolean isANumber(MatchResult matchResult) {
        return matchResult.getGroups().get(1) != null;
    }

    private static final boolean isCallWithName(MatchResult matchResult) {
        return matchResult.getGroups().get(6) != null;
    }

    private static final boolean isChar(MatchResult matchResult, String str) {
        return Intrinsics.areEqual(getText(matchResult), str);
    }

    private static final boolean isClassName(MatchResult matchResult) {
        return matchResult.getGroups().get(2) != null;
    }

    private static final boolean isFileName(MatchResult matchResult) {
        return matchResult.getGroups().get(4) != null;
    }

    private static final boolean isNumber(MatchResult matchResult) {
        return matchResult.getGroups().get(1) != null;
    }

    private static final boolean isParameterInformation(MatchResult matchResult) {
        return matchResult.getGroups().get(5) != null;
    }

    @UiToolingDataApi
    private static final String keyPosition(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (!(obj instanceof JoinedKey)) {
            return null;
        }
        JoinedKey joinedKey = (JoinedKey) obj;
        String keyPosition = keyPosition(joinedKey.getLeft());
        return keyPosition == null ? keyPosition(joinedKey.getRight()) : keyPosition;
    }

    @UiToolingDataApi
    @Nullable
    public static final <T> T mapTree(@NotNull CompositionData compositionData, @NotNull Function3<? super CompositionGroup, ? super SourceContext, ? super List<? extends T>, ? extends T> function3, @NotNull ContextCache contextCache) {
        Intrinsics.checkNotNullParameter(compositionData, "<this>");
        Intrinsics.checkNotNullParameter(function3, "factory");
        Intrinsics.checkNotNullParameter(contextCache, "cache");
        CompositionGroup compositionGroup = (CompositionGroup) CollectionsKt.firstOrNull(compositionData.getCompositionGroups());
        if (compositionGroup == null) {
            return null;
        }
        CompositionCallStack compositionCallStack = new CompositionCallStack(function3, contextCache.getContexts$ui_tooling_data_release());
        ArrayList arrayList = new ArrayList();
        compositionCallStack.convert(compositionGroup, 0, arrayList);
        return (T) CollectionsKt.firstOrNull(arrayList);
    }

    public static /* synthetic */ Object mapTree$default(CompositionData compositionData, Function3 function3, ContextCache contextCache, int i, Object obj) {
        if ((i & 2) != 0) {
            contextCache = new ContextCache();
        }
        return mapTree(compositionData, function3, contextCache);
    }

    private static final int number(MatchResult matchResult) {
        return parseToInt((String) matchResult.getGroupValues().get(1));
    }

    private static final List<Parameter> parseParameters(String str) {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = Regex.find$default(parametersInformationTokenizer, str, 0, 2, (Object) null);
        List mutableListOf = CollectionsKt.mutableListOf(new Integer[]{0, 1, 2, 3});
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = mutableListOf.size() - 1;
        ArrayList arrayList = new ArrayList();
        try {
            parseParameters$expect(objectRef, "P");
            parseParameters$expect(objectRef, "(");
            while (!parseParameters$isChar(objectRef, ")")) {
                if (parseParameters$isChar(objectRef, "!")) {
                    parseParameters$next(objectRef);
                    int parseParameters$expectNumber = parseParameters$expectNumber(objectRef);
                    parseParameters$ensureIndexes(intRef, mutableListOf, arrayList.size() + parseParameters$expectNumber);
                    for (int i = 0; i < parseParameters$expectNumber; i++) {
                        arrayList.add(new Parameter(((Number) CollectionsKt.first(mutableListOf)).intValue(), null, 2, null));
                        mutableListOf.remove(0);
                    }
                } else if (parseParameters$isChar(objectRef, ",")) {
                    parseParameters$next(objectRef);
                } else {
                    int parseParameters$expectNumber2 = parseParameters$expectNumber(objectRef);
                    arrayList.add(new Parameter(parseParameters$expectNumber2, parseParameters$isClassName(objectRef) ? parseParameters$expectClassName(objectRef) : null));
                    parseParameters$ensureIndexes(intRef, mutableListOf, parseParameters$expectNumber2);
                    mutableListOf.remove(Integer.valueOf(parseParameters$expectNumber2));
                }
            }
            parseParameters$expect(objectRef, ")");
            while (mutableListOf.size() > 0) {
                arrayList.add(new Parameter(((Number) CollectionsKt.first(mutableListOf)).intValue(), null, 2, null));
                mutableListOf.remove(0);
            }
            return arrayList;
        } catch (ParseError unused) {
            return CollectionsKt.emptyList();
        } catch (NumberFormatException unused2) {
            return CollectionsKt.emptyList();
        }
    }

    private static final void parseParameters$ensureIndexes(Ref.IntRef intRef, List<Integer> list, int i) {
        int i2 = i - intRef.element;
        if (i2 > 0) {
            if (i2 < 4) {
                i2 = 4;
            }
            for (int i3 = 0; i3 < i2; i3++) {
                list.add(Integer.valueOf(intRef.element + i3 + 1));
            }
            intRef.element += i2;
        }
    }

    private static final void parseParameters$expect(Ref.ObjectRef<MatchResult> objectRef, String str) {
        MatchResult matchResult = (MatchResult) objectRef.element;
        if (matchResult == null || !Intrinsics.areEqual(getText(matchResult), str)) {
            throw new ParseError();
        }
        parseParameters$next(objectRef);
    }

    private static final String parseParameters$expectClassName(Ref.ObjectRef<MatchResult> objectRef) {
        MatchResult matchResult = (MatchResult) objectRef.element;
        if (matchResult == null || !isClassName(matchResult)) {
            throw new ParseError();
        }
        parseParameters$next(objectRef);
        String substring = getText(matchResult).substring(1);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
        return replacePrefix(substring, "c#", "androidx.compose.");
    }

    private static final int parseParameters$expectNumber(Ref.ObjectRef<MatchResult> objectRef) {
        MatchResult matchResult = (MatchResult) objectRef.element;
        if (matchResult == null || !isANumber(matchResult)) {
            throw new ParseError();
        }
        parseParameters$next(objectRef);
        return parseToInt(getText(matchResult));
    }

    private static final boolean parseParameters$isChar(Ref.ObjectRef<MatchResult> objectRef, String str) {
        MatchResult matchResult = (MatchResult) objectRef.element;
        return matchResult == null || Intrinsics.areEqual(getText(matchResult), str);
    }

    private static final boolean parseParameters$isClassName(Ref.ObjectRef<MatchResult> objectRef) {
        MatchResult matchResult = (MatchResult) objectRef.element;
        return matchResult != null && isClassName(matchResult);
    }

    private static final MatchResult parseParameters$next(Ref.ObjectRef<MatchResult> objectRef) {
        MatchResult matchResult = (MatchResult) objectRef.element;
        if (matchResult != null) {
            objectRef.element = matchResult.next();
        }
        return (MatchResult) objectRef.element;
    }

    private static final int parseToInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            throw new ParseError();
        }
    }

    private static final String replacePrefix(String str, String str2, String str3) {
        if (!StringsKt.startsWith$default(str, str2, false, 2, (Object) null)) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str3);
        String substring = str.substring(str2.length());
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
        sb.append(substring);
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00e4  */
    @androidx.compose.p004ui.tooling.data.UiToolingDataApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final androidx.compose.p004ui.tooling.data.SourceInformationContext sourceInformationContextOf(java.lang.String r13, androidx.compose.p004ui.tooling.data.SourceInformationContext r14) {
        /*
            Method dump skipped, instructions count: 246
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.p004ui.tooling.data.SlotTreeKt.sourceInformationContextOf(java.lang.String, androidx.compose.ui.tooling.data.SourceInformationContext):androidx.compose.ui.tooling.data.SourceInformationContext");
    }

    static /* synthetic */ SourceInformationContext sourceInformationContextOf$default(String str, SourceInformationContext sourceInformationContext, int i, Object obj) {
        if ((i & 2) != 0) {
            sourceInformationContext = null;
        }
        return sourceInformationContextOf(str, sourceInformationContext);
    }

    /* renamed from: sourceInformationContextOf$next-4, reason: not valid java name */
    private static final MatchResult m5170sourceInformationContextOf$next4(Ref.ObjectRef<MatchResult> objectRef) {
        MatchResult matchResult = (MatchResult) objectRef.element;
        if (matchResult != null) {
            objectRef.element = matchResult.next();
        }
        return (MatchResult) objectRef.element;
    }

    private static final SourceLocationInfo sourceInformationContextOf$parseLocation(Ref.ObjectRef<MatchResult> objectRef) {
        Integer num;
        Integer num2;
        Integer num3;
        try {
            MatchResult matchResult = (MatchResult) objectRef.element;
            if (matchResult == null || !isNumber(matchResult)) {
                num = null;
            } else {
                num = Integer.valueOf(number(matchResult) + 1);
                matchResult = m5170sourceInformationContextOf$next4(objectRef);
            }
            if (matchResult != null && isChar(matchResult, "@")) {
                MatchResult m5170sourceInformationContextOf$next4 = m5170sourceInformationContextOf$next4(objectRef);
                if (m5170sourceInformationContextOf$next4 != null && isNumber(m5170sourceInformationContextOf$next4)) {
                    num3 = Integer.valueOf(number(m5170sourceInformationContextOf$next4));
                    MatchResult m5170sourceInformationContextOf$next42 = m5170sourceInformationContextOf$next4(objectRef);
                    if (m5170sourceInformationContextOf$next42 != null && isChar(m5170sourceInformationContextOf$next42, "L")) {
                        MatchResult m5170sourceInformationContextOf$next43 = m5170sourceInformationContextOf$next4(objectRef);
                        if (m5170sourceInformationContextOf$next43 != null && isNumber(m5170sourceInformationContextOf$next43)) {
                            num2 = Integer.valueOf(number(m5170sourceInformationContextOf$next43));
                        }
                        return null;
                    }
                    num2 = null;
                }
                return null;
            }
            num2 = null;
            num3 = null;
            if (num != null && num3 != null && num2 != null) {
                return new SourceLocationInfo(num, num3, num2);
            }
        } catch (ParseError unused) {
        }
        return null;
    }

    @NotNull
    public static final IntRect union(@NotNull IntRect intRect, @NotNull IntRect intRect2) {
        Intrinsics.checkNotNullParameter(intRect, "<this>");
        Intrinsics.checkNotNullParameter(intRect2, "other");
        IntRect intRect3 = emptyBox;
        if (Intrinsics.areEqual(intRect, intRect3)) {
            return intRect2;
        }
        if (Intrinsics.areEqual(intRect2, intRect3)) {
            return intRect;
        }
        return new IntRect(Math.min(intRect.getLeft(), intRect2.getLeft()), Math.min(intRect.getTop(), intRect2.getTop()), Math.max(intRect.getRight(), intRect2.getRight()), Math.max(intRect.getBottom(), intRect2.getBottom()));
    }

    private static final int parseToInt(String str, int i) {
        try {
            return Integer.parseInt(str, CharsKt.checkRadix(i));
        } catch (NumberFormatException unused) {
            throw new ParseError();
        }
    }
}
