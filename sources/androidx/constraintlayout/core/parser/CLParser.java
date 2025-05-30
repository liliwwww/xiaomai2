package androidx.constraintlayout.core.parser;

import androidx.appcompat.R;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class CLParser {
    static boolean DEBUG;
    private boolean hasComment = false;
    private int lineNumber;
    private String mContent;

    /* compiled from: Taobao */
    /* renamed from: androidx.constraintlayout.core.parser.CLParser$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$core$parser$CLParser$TYPE;

        static {
            int[] iArr = new int[TYPE.values().length];
            $SwitchMap$androidx$constraintlayout$core$parser$CLParser$TYPE = iArr;
            try {
                iArr[TYPE.OBJECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$parser$CLParser$TYPE[TYPE.ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$parser$CLParser$TYPE[TYPE.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$parser$CLParser$TYPE[TYPE.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$parser$CLParser$TYPE[TYPE.KEY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$parser$CLParser$TYPE[TYPE.TOKEN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public CLParser(String str) {
        this.mContent = str;
    }

    private CLElement createElement(CLElement cLElement, int i, TYPE type, boolean z, char[] cArr) {
        CLElement allocate;
        if (DEBUG) {
            System.out.println("CREATE " + type + " at " + cArr[i]);
        }
        switch (AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$parser$CLParser$TYPE[type.ordinal()]) {
            case 1:
                allocate = CLObject.allocate(cArr);
                i++;
                break;
            case 2:
                allocate = CLArray.allocate(cArr);
                i++;
                break;
            case 3:
                allocate = CLString.allocate(cArr);
                break;
            case 4:
                allocate = CLNumber.allocate(cArr);
                break;
            case 5:
                allocate = CLKey.allocate(cArr);
                break;
            case 6:
                allocate = CLToken.allocate(cArr);
                break;
            default:
                allocate = null;
                break;
        }
        if (allocate == null) {
            return null;
        }
        allocate.setLine(this.lineNumber);
        if (z) {
            allocate.setStart(i);
        }
        if (cLElement instanceof CLContainer) {
            allocate.setContainer((CLContainer) cLElement);
        }
        return allocate;
    }

    private CLElement getNextJsonElement(int i, char c, CLElement cLElement, char[] cArr) throws CLParsingException {
        if (c == '\t' || c == '\n' || c == '\r' || c == ' ') {
            return cLElement;
        }
        if (c == '\"' || c == '\'') {
            return cLElement instanceof CLObject ? createElement(cLElement, i, TYPE.KEY, true, cArr) : createElement(cLElement, i, TYPE.STRING, true, cArr);
        }
        if (c == '[') {
            return createElement(cLElement, i, TYPE.ARRAY, true, cArr);
        }
        if (c != ']') {
            if (c == '{') {
                return createElement(cLElement, i, TYPE.OBJECT, true, cArr);
            }
            if (c != '}') {
                switch (c) {
                    case '+':
                    case '-':
                    case '.':
                    case R.styleable.AppCompatTheme_checkboxStyle /* 48 */:
                    case R.styleable.AppCompatTheme_checkedTextViewStyle /* 49 */:
                    case R.styleable.AppCompatTheme_colorAccent /* 50 */:
                    case R.styleable.AppCompatTheme_colorBackgroundFloating /* 51 */:
                    case R.styleable.AppCompatTheme_colorButtonNormal /* 52 */:
                    case R.styleable.AppCompatTheme_colorControlActivated /* 53 */:
                    case R.styleable.AppCompatTheme_colorControlHighlight /* 54 */:
                    case R.styleable.AppCompatTheme_colorControlNormal /* 55 */:
                    case R.styleable.AppCompatTheme_colorError /* 56 */:
                    case R.styleable.AppCompatTheme_colorPrimary /* 57 */:
                        return createElement(cLElement, i, TYPE.NUMBER, true, cArr);
                    case ',':
                    case R.styleable.AppCompatTheme_colorPrimaryDark /* 58 */:
                        return cLElement;
                    case '/':
                        int i2 = i + 1;
                        if (i2 >= cArr.length || cArr[i2] != '/') {
                            return cLElement;
                        }
                        this.hasComment = true;
                        return cLElement;
                    default:
                        if (!(cLElement instanceof CLContainer) || (cLElement instanceof CLObject)) {
                            return createElement(cLElement, i, TYPE.KEY, true, cArr);
                        }
                        CLToken createElement = createElement(cLElement, i, TYPE.TOKEN, true, cArr);
                        CLToken cLToken = createElement;
                        if (cLToken.validate(c, i)) {
                            return createElement;
                        }
                        throw new CLParsingException("incorrect token <" + c + "> at line " + this.lineNumber, cLToken);
                }
            }
        }
        cLElement.setEnd(i - 1);
        CLElement container = cLElement.getContainer();
        container.setEnd(i);
        return container;
    }

    public static CLObject parse(String str) throws CLParsingException {
        return new CLParser(str).parse();
    }

    public CLObject parse() throws CLParsingException {
        char[] charArray = this.mContent.toCharArray();
        int length = charArray.length;
        int i = 1;
        this.lineNumber = 1;
        boolean z = false;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                i2 = -1;
                break;
            }
            char c = charArray[i2];
            if (c == '{') {
                break;
            }
            if (c == '\n') {
                this.lineNumber++;
            }
            i2++;
        }
        if (i2 == -1) {
            throw new CLParsingException("invalid json content", (CLElement) null);
        }
        CLKey allocate = CLObject.allocate(charArray);
        allocate.setLine(this.lineNumber);
        allocate.setStart(i2);
        int i3 = i2 + 1;
        CLKey cLKey = allocate;
        while (i3 < length) {
            char c2 = charArray[i3];
            if (c2 == '\n') {
                this.lineNumber += i;
            }
            if (this.hasComment) {
                if (c2 == '\n') {
                    this.hasComment = z;
                } else {
                    continue;
                    i3++;
                    i = 1;
                    z = false;
                }
            }
            if (cLKey == null) {
                break;
            }
            if (cLKey.isDone()) {
                cLKey = getNextJsonElement(i3, c2, cLKey, charArray);
            } else if (cLKey instanceof CLObject) {
                if (c2 == '}') {
                    cLKey.setEnd(i3 - 1);
                } else {
                    cLKey = getNextJsonElement(i3, c2, cLKey, charArray);
                }
            } else if (!(cLKey instanceof CLArray)) {
                boolean z2 = cLKey instanceof CLString;
                if (z2) {
                    long j = cLKey.start;
                    if (charArray[(int) j] == c2) {
                        cLKey.setStart(j + 1);
                        cLKey.setEnd(i3 - 1);
                    }
                } else {
                    if (cLKey instanceof CLToken) {
                        CLToken cLToken = (CLToken) cLKey;
                        if (!cLToken.validate(c2, i3)) {
                            throw new CLParsingException("parsing incorrect token " + cLToken.content() + " at line " + this.lineNumber, cLToken);
                        }
                    }
                    if ((cLKey instanceof CLKey) || z2) {
                        long j2 = cLKey.start;
                        char c3 = charArray[(int) j2];
                        if ((c3 == '\'' || c3 == '\"') && c3 == c2) {
                            cLKey.setStart(j2 + 1);
                            cLKey.setEnd(i3 - 1);
                        }
                    }
                    if (!cLKey.isDone() && (c2 == '}' || c2 == ']' || c2 == ',' || c2 == ' ' || c2 == '\t' || c2 == '\r' || c2 == '\n' || c2 == ':')) {
                        long j3 = i3 - 1;
                        cLKey.setEnd(j3);
                        if (c2 == '}' || c2 == ']') {
                            cLKey = cLKey.getContainer();
                            cLKey.setEnd(j3);
                            if (cLKey instanceof CLKey) {
                                cLKey = cLKey.getContainer();
                                cLKey.setEnd(j3);
                            }
                        }
                    }
                }
            } else if (c2 == ']') {
                cLKey.setEnd(i3 - 1);
            } else {
                cLKey = getNextJsonElement(i3, c2, cLKey, charArray);
            }
            if (cLKey.isDone() && (!(cLKey instanceof CLKey) || cLKey.mElements.size() > 0)) {
                cLKey = cLKey.getContainer();
            }
            i3++;
            i = 1;
            z = false;
        }
        while (cLKey != null && !cLKey.isDone()) {
            if (cLKey instanceof CLString) {
                cLKey.setStart(((int) cLKey.start) + 1);
            }
            cLKey.setEnd(length - 1);
            cLKey = cLKey.getContainer();
        }
        if (DEBUG) {
            System.out.println("Root: " + allocate.toJSON());
        }
        return allocate;
    }
}
