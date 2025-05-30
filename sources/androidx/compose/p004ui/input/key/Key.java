package androidx.compose.p004ui.input.key;

import android.taobao.windvane.extra.p002uc.UCNetworkDelegate;
import androidx.compose.p004ui.ExperimentalComposeUiApi;
import androidx.compose.runtime.ComposerKt;
import androidx.renderscript.ScriptIntrinsicBLAS;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import tb.c8;

/* compiled from: Taobao */
@JvmInline
/* loaded from: classes.dex */
public final class Key {
    private final long keyCode;

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final long Unknown = Key_androidKt.Key(0);
    private static final long SoftLeft = Key_androidKt.Key(1);
    private static final long SoftRight = Key_androidKt.Key(2);
    private static final long Home = Key_androidKt.Key(3);
    private static final long Back = Key_androidKt.Key(4);
    private static final long Help = Key_androidKt.Key(259);
    private static final long NavigatePrevious = Key_androidKt.Key(260);
    private static final long NavigateNext = Key_androidKt.Key(261);
    private static final long NavigateIn = Key_androidKt.Key(262);
    private static final long NavigateOut = Key_androidKt.Key(263);
    private static final long SystemNavigationUp = Key_androidKt.Key(280);
    private static final long SystemNavigationDown = Key_androidKt.Key(281);
    private static final long SystemNavigationLeft = Key_androidKt.Key(282);
    private static final long SystemNavigationRight = Key_androidKt.Key(283);
    private static final long Call = Key_androidKt.Key(5);
    private static final long EndCall = Key_androidKt.Key(6);
    private static final long DirectionUp = Key_androidKt.Key(19);
    private static final long DirectionDown = Key_androidKt.Key(20);
    private static final long DirectionLeft = Key_androidKt.Key(21);
    private static final long DirectionRight = Key_androidKt.Key(22);
    private static final long DirectionCenter = Key_androidKt.Key(23);
    private static final long DirectionUpLeft = Key_androidKt.Key(268);
    private static final long DirectionDownLeft = Key_androidKt.Key(269);
    private static final long DirectionUpRight = Key_androidKt.Key(270);
    private static final long DirectionDownRight = Key_androidKt.Key(271);
    private static final long VolumeUp = Key_androidKt.Key(24);
    private static final long VolumeDown = Key_androidKt.Key(25);
    private static final long Power = Key_androidKt.Key(26);
    private static final long Camera = Key_androidKt.Key(27);
    private static final long Clear = Key_androidKt.Key(28);
    private static final long Zero = Key_androidKt.Key(7);
    private static final long One = Key_androidKt.Key(8);
    private static final long Two = Key_androidKt.Key(9);
    private static final long Three = Key_androidKt.Key(10);
    private static final long Four = Key_androidKt.Key(11);
    private static final long Five = Key_androidKt.Key(12);
    private static final long Six = Key_androidKt.Key(13);
    private static final long Seven = Key_androidKt.Key(14);
    private static final long Eight = Key_androidKt.Key(15);
    private static final long Nine = Key_androidKt.Key(16);
    private static final long Plus = Key_androidKt.Key(81);
    private static final long Minus = Key_androidKt.Key(69);
    private static final long Multiply = Key_androidKt.Key(17);
    private static final long Equals = Key_androidKt.Key(70);
    private static final long Pound = Key_androidKt.Key(18);

    /* renamed from: A */
    private static final long f163A = Key_androidKt.Key(29);

    /* renamed from: B */
    private static final long f165B = Key_androidKt.Key(30);

    /* renamed from: C */
    private static final long f166C = Key_androidKt.Key(31);

    /* renamed from: D */
    private static final long f167D = Key_androidKt.Key(32);

    /* renamed from: E */
    private static final long f168E = Key_androidKt.Key(33);

    /* renamed from: F */
    private static final long f169F = Key_androidKt.Key(34);

    /* renamed from: G */
    private static final long f179G = Key_androidKt.Key(35);

    /* renamed from: H */
    private static final long f180H = Key_androidKt.Key(36);

    /* renamed from: I */
    private static final long f181I = Key_androidKt.Key(37);

    /* renamed from: J */
    private static final long f182J = Key_androidKt.Key(38);

    /* renamed from: K */
    private static final long f183K = Key_androidKt.Key(39);

    /* renamed from: L */
    private static final long f184L = Key_androidKt.Key(40);

    /* renamed from: M */
    private static final long f185M = Key_androidKt.Key(41);

    /* renamed from: N */
    private static final long f186N = Key_androidKt.Key(42);

    /* renamed from: O */
    private static final long f187O = Key_androidKt.Key(43);

    /* renamed from: P */
    private static final long f188P = Key_androidKt.Key(44);

    /* renamed from: Q */
    private static final long f189Q = Key_androidKt.Key(45);

    /* renamed from: R */
    private static final long f190R = Key_androidKt.Key(46);

    /* renamed from: S */
    private static final long f192S = Key_androidKt.Key(47);

    /* renamed from: T */
    private static final long f193T = Key_androidKt.Key(48);

    /* renamed from: U */
    private static final long f195U = Key_androidKt.Key(49);

    /* renamed from: V */
    private static final long f196V = Key_androidKt.Key(50);

    /* renamed from: W */
    private static final long f197W = Key_androidKt.Key(51);

    /* renamed from: X */
    private static final long f198X = Key_androidKt.Key(52);

    /* renamed from: Y */
    private static final long f199Y = Key_androidKt.Key(53);

    /* renamed from: Z */
    private static final long f200Z = Key_androidKt.Key(54);
    private static final long Comma = Key_androidKt.Key(55);
    private static final long Period = Key_androidKt.Key(56);
    private static final long AltLeft = Key_androidKt.Key(57);
    private static final long AltRight = Key_androidKt.Key(58);
    private static final long ShiftLeft = Key_androidKt.Key(59);
    private static final long ShiftRight = Key_androidKt.Key(60);
    private static final long Tab = Key_androidKt.Key(61);
    private static final long Spacebar = Key_androidKt.Key(62);
    private static final long Symbol = Key_androidKt.Key(63);
    private static final long Browser = Key_androidKt.Key(64);
    private static final long Envelope = Key_androidKt.Key(65);
    private static final long Enter = Key_androidKt.Key(66);
    private static final long Backspace = Key_androidKt.Key(67);
    private static final long Delete = Key_androidKt.Key(112);
    private static final long Escape = Key_androidKt.Key(111);
    private static final long CtrlLeft = Key_androidKt.Key(113);
    private static final long CtrlRight = Key_androidKt.Key(114);
    private static final long CapsLock = Key_androidKt.Key(115);
    private static final long ScrollLock = Key_androidKt.Key(116);
    private static final long MetaLeft = Key_androidKt.Key(117);
    private static final long MetaRight = Key_androidKt.Key(118);
    private static final long Function = Key_androidKt.Key(119);
    private static final long PrintScreen = Key_androidKt.Key(120);
    private static final long Break = Key_androidKt.Key(121);
    private static final long MoveHome = Key_androidKt.Key(122);
    private static final long MoveEnd = Key_androidKt.Key(123);
    private static final long Insert = Key_androidKt.Key(124);
    private static final long Cut = Key_androidKt.Key(277);
    private static final long Copy = Key_androidKt.Key(278);
    private static final long Paste = Key_androidKt.Key(279);
    private static final long Grave = Key_androidKt.Key(68);
    private static final long LeftBracket = Key_androidKt.Key(71);
    private static final long RightBracket = Key_androidKt.Key(72);
    private static final long Slash = Key_androidKt.Key(76);
    private static final long Backslash = Key_androidKt.Key(73);
    private static final long Semicolon = Key_androidKt.Key(74);
    private static final long Apostrophe = Key_androidKt.Key(75);

    /* renamed from: At */
    private static final long f164At = Key_androidKt.Key(77);
    private static final long Number = Key_androidKt.Key(78);
    private static final long HeadsetHook = Key_androidKt.Key(79);
    private static final long Focus = Key_androidKt.Key(80);
    private static final long Menu = Key_androidKt.Key(82);
    private static final long Notification = Key_androidKt.Key(83);
    private static final long Search = Key_androidKt.Key(84);
    private static final long PageUp = Key_androidKt.Key(92);
    private static final long PageDown = Key_androidKt.Key(93);
    private static final long PictureSymbols = Key_androidKt.Key(94);
    private static final long SwitchCharset = Key_androidKt.Key(95);
    private static final long ButtonA = Key_androidKt.Key(96);
    private static final long ButtonB = Key_androidKt.Key(97);
    private static final long ButtonC = Key_androidKt.Key(98);
    private static final long ButtonX = Key_androidKt.Key(99);
    private static final long ButtonY = Key_androidKt.Key(100);
    private static final long ButtonZ = Key_androidKt.Key(101);
    private static final long ButtonL1 = Key_androidKt.Key(102);
    private static final long ButtonR1 = Key_androidKt.Key(103);
    private static final long ButtonL2 = Key_androidKt.Key(104);
    private static final long ButtonR2 = Key_androidKt.Key(105);
    private static final long ButtonThumbLeft = Key_androidKt.Key(106);
    private static final long ButtonThumbRight = Key_androidKt.Key(107);
    private static final long ButtonStart = Key_androidKt.Key(108);
    private static final long ButtonSelect = Key_androidKt.Key(109);
    private static final long ButtonMode = Key_androidKt.Key(110);
    private static final long Button1 = Key_androidKt.Key(188);
    private static final long Button2 = Key_androidKt.Key(189);
    private static final long Button3 = Key_androidKt.Key(190);
    private static final long Button4 = Key_androidKt.Key(191);
    private static final long Button5 = Key_androidKt.Key(192);
    private static final long Button6 = Key_androidKt.Key(193);
    private static final long Button7 = Key_androidKt.Key(194);
    private static final long Button8 = Key_androidKt.Key(195);
    private static final long Button9 = Key_androidKt.Key(196);
    private static final long Button10 = Key_androidKt.Key(197);
    private static final long Button11 = Key_androidKt.Key(198);
    private static final long Button12 = Key_androidKt.Key(199);
    private static final long Button13 = Key_androidKt.Key(200);
    private static final long Button14 = Key_androidKt.Key(ComposerKt.providerKey);
    private static final long Button15 = Key_androidKt.Key(ComposerKt.compositionLocalMapKey);
    private static final long Button16 = Key_androidKt.Key(ComposerKt.providerValuesKey);
    private static final long Forward = Key_androidKt.Key(125);

    /* renamed from: F1 */
    private static final long f170F1 = Key_androidKt.Key(ScriptIntrinsicBLAS.NON_UNIT);

    /* renamed from: F2 */
    private static final long f171F2 = Key_androidKt.Key(ScriptIntrinsicBLAS.UNIT);

    /* renamed from: F3 */
    private static final long f172F3 = Key_androidKt.Key(133);

    /* renamed from: F4 */
    private static final long f173F4 = Key_androidKt.Key(134);

    /* renamed from: F5 */
    private static final long f174F5 = Key_androidKt.Key(135);

    /* renamed from: F6 */
    private static final long f175F6 = Key_androidKt.Key(136);

    /* renamed from: F7 */
    private static final long f176F7 = Key_androidKt.Key(137);

    /* renamed from: F8 */
    private static final long f177F8 = Key_androidKt.Key(138);

    /* renamed from: F9 */
    private static final long f178F9 = Key_androidKt.Key(139);
    private static final long F10 = Key_androidKt.Key(140);
    private static final long F11 = Key_androidKt.Key(ScriptIntrinsicBLAS.LEFT);
    private static final long F12 = Key_androidKt.Key(ScriptIntrinsicBLAS.RIGHT);
    private static final long NumLock = Key_androidKt.Key(143);
    private static final long NumPad0 = Key_androidKt.Key(144);
    private static final long NumPad1 = Key_androidKt.Key(145);
    private static final long NumPad2 = Key_androidKt.Key(146);
    private static final long NumPad3 = Key_androidKt.Key(147);
    private static final long NumPad4 = Key_androidKt.Key(148);
    private static final long NumPad5 = Key_androidKt.Key(149);
    private static final long NumPad6 = Key_androidKt.Key(150);
    private static final long NumPad7 = Key_androidKt.Key(151);
    private static final long NumPad8 = Key_androidKt.Key(152);
    private static final long NumPad9 = Key_androidKt.Key(153);
    private static final long NumPadDivide = Key_androidKt.Key(154);
    private static final long NumPadMultiply = Key_androidKt.Key(155);
    private static final long NumPadSubtract = Key_androidKt.Key(156);
    private static final long NumPadAdd = Key_androidKt.Key(157);
    private static final long NumPadDot = Key_androidKt.Key(158);
    private static final long NumPadComma = Key_androidKt.Key(159);
    private static final long NumPadEnter = Key_androidKt.Key(160);
    private static final long NumPadEquals = Key_androidKt.Key(161);
    private static final long NumPadLeftParenthesis = Key_androidKt.Key(162);
    private static final long NumPadRightParenthesis = Key_androidKt.Key(163);
    private static final long MediaPlay = Key_androidKt.Key(126);
    private static final long MediaPause = Key_androidKt.Key(127);
    private static final long MediaPlayPause = Key_androidKt.Key(85);
    private static final long MediaStop = Key_androidKt.Key(86);
    private static final long MediaRecord = Key_androidKt.Key(130);
    private static final long MediaNext = Key_androidKt.Key(87);
    private static final long MediaPrevious = Key_androidKt.Key(88);
    private static final long MediaRewind = Key_androidKt.Key(89);
    private static final long MediaFastForward = Key_androidKt.Key(90);
    private static final long MediaClose = Key_androidKt.Key(128);
    private static final long MediaAudioTrack = Key_androidKt.Key(222);
    private static final long MediaEject = Key_androidKt.Key(129);
    private static final long MediaTopMenu = Key_androidKt.Key(226);
    private static final long MediaSkipForward = Key_androidKt.Key(272);
    private static final long MediaSkipBackward = Key_androidKt.Key(273);
    private static final long MediaStepForward = Key_androidKt.Key(274);
    private static final long MediaStepBackward = Key_androidKt.Key(275);
    private static final long MicrophoneMute = Key_androidKt.Key(91);
    private static final long VolumeMute = Key_androidKt.Key(164);
    private static final long Info = Key_androidKt.Key(165);
    private static final long ChannelUp = Key_androidKt.Key(166);
    private static final long ChannelDown = Key_androidKt.Key(167);
    private static final long ZoomIn = Key_androidKt.Key(168);
    private static final long ZoomOut = Key_androidKt.Key(169);

    /* renamed from: Tv */
    private static final long f194Tv = Key_androidKt.Key(170);
    private static final long Window = Key_androidKt.Key(171);
    private static final long Guide = Key_androidKt.Key(172);
    private static final long Dvr = Key_androidKt.Key(173);
    private static final long Bookmark = Key_androidKt.Key(174);
    private static final long Captions = Key_androidKt.Key(175);
    private static final long Settings = Key_androidKt.Key(176);
    private static final long TvPower = Key_androidKt.Key(177);
    private static final long TvInput = Key_androidKt.Key(178);
    private static final long SetTopBoxPower = Key_androidKt.Key(179);
    private static final long SetTopBoxInput = Key_androidKt.Key(180);
    private static final long AvReceiverPower = Key_androidKt.Key(181);
    private static final long AvReceiverInput = Key_androidKt.Key(182);
    private static final long ProgramRed = Key_androidKt.Key(183);
    private static final long ProgramGreen = Key_androidKt.Key(184);
    private static final long ProgramYellow = Key_androidKt.Key(185);
    private static final long ProgramBlue = Key_androidKt.Key(186);
    private static final long AppSwitch = Key_androidKt.Key(187);
    private static final long LanguageSwitch = Key_androidKt.Key(ComposerKt.providerMapsKey);
    private static final long MannerMode = Key_androidKt.Key(205);
    private static final long Toggle2D3D = Key_androidKt.Key(ComposerKt.referenceKey);
    private static final long Contacts = Key_androidKt.Key(ComposerKt.reuseKey);
    private static final long Calendar = Key_androidKt.Key(208);
    private static final long Music = Key_androidKt.Key(209);
    private static final long Calculator = Key_androidKt.Key(210);
    private static final long ZenkakuHankaru = Key_androidKt.Key(211);
    private static final long Eisu = Key_androidKt.Key(212);
    private static final long Muhenkan = Key_androidKt.Key(213);
    private static final long Henkan = Key_androidKt.Key(214);
    private static final long KatakanaHiragana = Key_androidKt.Key(215);
    private static final long Yen = Key_androidKt.Key(216);

    /* renamed from: Ro */
    private static final long f191Ro = Key_androidKt.Key(217);
    private static final long Kana = Key_androidKt.Key(218);
    private static final long Assist = Key_androidKt.Key(219);
    private static final long BrightnessDown = Key_androidKt.Key(220);
    private static final long BrightnessUp = Key_androidKt.Key(221);
    private static final long Sleep = Key_androidKt.Key(223);
    private static final long WakeUp = Key_androidKt.Key(224);
    private static final long SoftSleep = Key_androidKt.Key(UCNetworkDelegate.CHANGE_WEBVIEW_URL);
    private static final long Pairing = Key_androidKt.Key(225);
    private static final long LastChannel = Key_androidKt.Key(229);
    private static final long TvDataService = Key_androidKt.Key(230);
    private static final long VoiceAssist = Key_androidKt.Key(231);
    private static final long TvRadioService = Key_androidKt.Key(232);
    private static final long TvTeletext = Key_androidKt.Key(233);
    private static final long TvNumberEntry = Key_androidKt.Key(234);
    private static final long TvTerrestrialAnalog = Key_androidKt.Key(235);
    private static final long TvTerrestrialDigital = Key_androidKt.Key(236);
    private static final long TvSatellite = Key_androidKt.Key(237);
    private static final long TvSatelliteBs = Key_androidKt.Key(238);
    private static final long TvSatelliteCs = Key_androidKt.Key(239);
    private static final long TvSatelliteService = Key_androidKt.Key(240);
    private static final long TvNetwork = Key_androidKt.Key(241);
    private static final long TvAntennaCable = Key_androidKt.Key(242);
    private static final long TvInputHdmi1 = Key_androidKt.Key(243);
    private static final long TvInputHdmi2 = Key_androidKt.Key(244);
    private static final long TvInputHdmi3 = Key_androidKt.Key(245);
    private static final long TvInputHdmi4 = Key_androidKt.Key(246);
    private static final long TvInputComposite1 = Key_androidKt.Key(247);
    private static final long TvInputComposite2 = Key_androidKt.Key(248);
    private static final long TvInputComponent1 = Key_androidKt.Key(249);
    private static final long TvInputComponent2 = Key_androidKt.Key(250);
    private static final long TvInputVga1 = Key_androidKt.Key(251);
    private static final long TvAudioDescription = Key_androidKt.Key(252);
    private static final long TvAudioDescriptionMixingVolumeUp = Key_androidKt.Key(253);
    private static final long TvAudioDescriptionMixingVolumeDown = Key_androidKt.Key(254);
    private static final long TvZoomMode = Key_androidKt.Key(255);
    private static final long TvContentsMenu = Key_androidKt.Key(256);
    private static final long TvMediaContextMenu = Key_androidKt.Key(257);
    private static final long TvTimerProgramming = Key_androidKt.Key(258);
    private static final long StemPrimary = Key_androidKt.Key(264);
    private static final long Stem1 = Key_androidKt.Key(265);
    private static final long Stem2 = Key_androidKt.Key(266);
    private static final long Stem3 = Key_androidKt.Key(267);
    private static final long AllApps = Key_androidKt.Key(284);
    private static final long Refresh = Key_androidKt.Key(285);
    private static final long ThumbsUp = Key_androidKt.Key(286);
    private static final long ThumbsDown = Key_androidKt.Key(287);
    private static final long ProfileSwitch = Key_androidKt.Key(288);

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @ExperimentalComposeUiApi
        /* renamed from: getA-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3373getAEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getAllApps-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3374getAllAppsEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getAltLeft-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3375getAltLeftEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getAltRight-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3376getAltRightEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getApostrophe-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3377getApostropheEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getAppSwitch-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3378getAppSwitchEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getAssist-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3379getAssistEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getAt-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3380getAtEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getAvReceiverInput-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3381getAvReceiverInputEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getAvReceiverPower-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3382getAvReceiverPowerEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getB-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3383getBEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getBack-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3384getBackEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getBackslash-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3385getBackslashEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getBackspace-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3386getBackspaceEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getBookmark-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3387getBookmarkEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getBreak-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3388getBreakEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getBrightnessDown-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3389getBrightnessDownEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getBrightnessUp-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3390getBrightnessUpEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getBrowser-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3391getBrowserEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getButton1-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3392getButton1EK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getButton10-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3393getButton10EK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getButton11-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3394getButton11EK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getButton12-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3395getButton12EK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getButton13-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3396getButton13EK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getButton14-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3397getButton14EK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getButton15-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3398getButton15EK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getButton16-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3399getButton16EK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getButton2-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3400getButton2EK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getButton3-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3401getButton3EK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getButton4-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3402getButton4EK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getButton5-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3403getButton5EK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getButton6-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3404getButton6EK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getButton7-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3405getButton7EK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getButton8-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3406getButton8EK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getButton9-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3407getButton9EK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getButtonA-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3408getButtonAEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getButtonB-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3409getButtonBEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getButtonC-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3410getButtonCEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getButtonL1-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3411getButtonL1EK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getButtonL2-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3412getButtonL2EK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getButtonMode-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3413getButtonModeEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getButtonR1-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3414getButtonR1EK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getButtonR2-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3415getButtonR2EK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getButtonSelect-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3416getButtonSelectEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getButtonStart-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3417getButtonStartEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getButtonThumbLeft-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3418getButtonThumbLeftEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getButtonThumbRight-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3419getButtonThumbRightEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getButtonX-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3420getButtonXEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getButtonY-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3421getButtonYEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getButtonZ-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3422getButtonZEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getC-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3423getCEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getCalculator-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3424getCalculatorEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getCalendar-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3425getCalendarEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getCall-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3426getCallEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getCamera-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3427getCameraEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getCapsLock-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3428getCapsLockEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getCaptions-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3429getCaptionsEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getChannelDown-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3430getChannelDownEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getChannelUp-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3431getChannelUpEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getClear-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3432getClearEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getComma-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3433getCommaEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getContacts-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3434getContactsEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getCopy-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3435getCopyEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getCtrlLeft-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3436getCtrlLeftEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getCtrlRight-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3437getCtrlRightEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getCut-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3438getCutEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getD-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3439getDEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getDelete-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3440getDeleteEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getDirectionCenter-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3441getDirectionCenterEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getDirectionDown-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3442getDirectionDownEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getDirectionDownLeft-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3443getDirectionDownLeftEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getDirectionDownRight-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3444getDirectionDownRightEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getDirectionLeft-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3445getDirectionLeftEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getDirectionRight-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3446getDirectionRightEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getDirectionUp-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3447getDirectionUpEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getDirectionUpLeft-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3448getDirectionUpLeftEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getDirectionUpRight-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3449getDirectionUpRightEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getDvr-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3450getDvrEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getE-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3451getEEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getEight-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3452getEightEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getEisu-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3453getEisuEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getEndCall-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3454getEndCallEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getEnter-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3455getEnterEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getEnvelope-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3456getEnvelopeEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getEquals-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3457getEqualsEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getEscape-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3458getEscapeEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getF-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3459getFEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getF1-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3460getF1EK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getF10-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3461getF10EK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getF11-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3462getF11EK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getF12-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3463getF12EK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getF2-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3464getF2EK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getF3-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3465getF3EK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getF4-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3466getF4EK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getF5-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3467getF5EK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getF6-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3468getF6EK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getF7-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3469getF7EK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getF8-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3470getF8EK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getF9-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3471getF9EK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getFive-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3472getFiveEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getFocus-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3473getFocusEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getForward-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3474getForwardEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getFour-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3475getFourEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getFunction-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3476getFunctionEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getG-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3477getGEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getGrave-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3478getGraveEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getGuide-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3479getGuideEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getH-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3480getHEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getHeadsetHook-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3481getHeadsetHookEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getHelp-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3482getHelpEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getHenkan-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3483getHenkanEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getHome-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3484getHomeEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getI-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3485getIEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getInfo-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3486getInfoEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getInsert-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3487getInsertEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getJ-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3488getJEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getK-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3489getKEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getKana-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3490getKanaEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getKatakanaHiragana-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3491getKatakanaHiraganaEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getL-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3492getLEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getLanguageSwitch-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3493getLanguageSwitchEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getLastChannel-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3494getLastChannelEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getLeftBracket-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3495getLeftBracketEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getM-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3496getMEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getMannerMode-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3497getMannerModeEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getMediaAudioTrack-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3498getMediaAudioTrackEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getMediaClose-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3499getMediaCloseEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getMediaEject-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3500getMediaEjectEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getMediaFastForward-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3501getMediaFastForwardEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getMediaNext-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3502getMediaNextEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getMediaPause-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3503getMediaPauseEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getMediaPlay-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3504getMediaPlayEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getMediaPlayPause-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3505getMediaPlayPauseEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getMediaPrevious-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3506getMediaPreviousEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getMediaRecord-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3507getMediaRecordEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getMediaRewind-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3508getMediaRewindEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getMediaSkipBackward-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3509getMediaSkipBackwardEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getMediaSkipForward-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3510getMediaSkipForwardEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getMediaStepBackward-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3511getMediaStepBackwardEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getMediaStepForward-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3512getMediaStepForwardEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getMediaStop-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3513getMediaStopEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getMediaTopMenu-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3514getMediaTopMenuEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getMenu-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3515getMenuEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getMetaLeft-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3516getMetaLeftEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getMetaRight-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3517getMetaRightEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getMicrophoneMute-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3518getMicrophoneMuteEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getMinus-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3519getMinusEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getMoveEnd-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3520getMoveEndEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getMoveHome-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3521getMoveHomeEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getMuhenkan-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3522getMuhenkanEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getMultiply-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3523getMultiplyEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getMusic-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3524getMusicEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getN-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3525getNEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getNavigateIn-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3526getNavigateInEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getNavigateNext-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3527getNavigateNextEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getNavigateOut-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3528getNavigateOutEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getNavigatePrevious-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3529getNavigatePreviousEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getNine-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3530getNineEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getNotification-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3531getNotificationEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getNumLock-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3532getNumLockEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getNumPad0-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3533getNumPad0EK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getNumPad1-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3534getNumPad1EK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getNumPad2-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3535getNumPad2EK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getNumPad3-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3536getNumPad3EK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getNumPad4-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3537getNumPad4EK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getNumPad5-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3538getNumPad5EK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getNumPad6-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3539getNumPad6EK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getNumPad7-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3540getNumPad7EK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getNumPad8-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3541getNumPad8EK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getNumPad9-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3542getNumPad9EK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getNumPadAdd-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3543getNumPadAddEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getNumPadComma-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3544getNumPadCommaEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getNumPadDivide-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3545getNumPadDivideEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getNumPadDot-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3546getNumPadDotEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getNumPadEnter-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3547getNumPadEnterEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getNumPadEquals-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3548getNumPadEqualsEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getNumPadLeftParenthesis-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3549getNumPadLeftParenthesisEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getNumPadMultiply-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3550getNumPadMultiplyEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getNumPadRightParenthesis-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3551getNumPadRightParenthesisEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getNumPadSubtract-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3552getNumPadSubtractEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getNumber-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3553getNumberEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getO-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3554getOEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getOne-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3555getOneEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getP-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3556getPEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getPageDown-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3557getPageDownEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getPageUp-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3558getPageUpEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getPairing-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3559getPairingEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getPaste-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3560getPasteEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getPeriod-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3561getPeriodEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getPictureSymbols-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3562getPictureSymbolsEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getPlus-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3563getPlusEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getPound-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3564getPoundEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getPower-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3565getPowerEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getPrintScreen-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3566getPrintScreenEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getProfileSwitch-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3567getProfileSwitchEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getProgramBlue-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3568getProgramBlueEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getProgramGreen-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3569getProgramGreenEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getProgramRed-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3570getProgramRedEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getProgramYellow-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3571getProgramYellowEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getQ-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3572getQEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getR-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3573getREK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getRefresh-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3574getRefreshEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getRightBracket-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3575getRightBracketEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getRo-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3576getRoEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getS-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3577getSEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getScrollLock-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3578getScrollLockEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getSearch-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3579getSearchEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getSemicolon-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3580getSemicolonEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getSetTopBoxInput-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3581getSetTopBoxInputEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getSetTopBoxPower-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3582getSetTopBoxPowerEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getSettings-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3583getSettingsEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getSeven-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3584getSevenEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getShiftLeft-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3585getShiftLeftEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getShiftRight-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3586getShiftRightEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getSix-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3587getSixEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getSlash-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3588getSlashEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getSleep-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3589getSleepEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getSoftLeft-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3590getSoftLeftEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getSoftRight-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3591getSoftRightEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getSoftSleep-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3592getSoftSleepEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getSpacebar-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3593getSpacebarEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getStem1-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3594getStem1EK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getStem2-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3595getStem2EK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getStem3-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3596getStem3EK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getStemPrimary-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3597getStemPrimaryEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getSwitchCharset-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3598getSwitchCharsetEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getSymbol-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3599getSymbolEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getSystemNavigationDown-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3600getSystemNavigationDownEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getSystemNavigationLeft-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3601getSystemNavigationLeftEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getSystemNavigationRight-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3602getSystemNavigationRightEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getSystemNavigationUp-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3603getSystemNavigationUpEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getT-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3604getTEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getTab-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3605getTabEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getThree-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3606getThreeEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getThumbsDown-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3607getThumbsDownEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getThumbsUp-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3608getThumbsUpEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getToggle2D3D-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3609getToggle2D3DEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getTv-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3610getTvEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getTvAntennaCable-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3611getTvAntennaCableEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getTvAudioDescription-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3612getTvAudioDescriptionEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getTvAudioDescriptionMixingVolumeDown-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3613getTvAudioDescriptionMixingVolumeDownEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getTvAudioDescriptionMixingVolumeUp-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3614getTvAudioDescriptionMixingVolumeUpEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getTvContentsMenu-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3615getTvContentsMenuEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getTvDataService-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3616getTvDataServiceEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getTvInput-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3617getTvInputEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getTvInputComponent1-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3618getTvInputComponent1EK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getTvInputComponent2-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3619getTvInputComponent2EK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getTvInputComposite1-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3620getTvInputComposite1EK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getTvInputComposite2-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3621getTvInputComposite2EK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getTvInputHdmi1-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3622getTvInputHdmi1EK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getTvInputHdmi2-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3623getTvInputHdmi2EK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getTvInputHdmi3-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3624getTvInputHdmi3EK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getTvInputHdmi4-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3625getTvInputHdmi4EK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getTvInputVga1-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3626getTvInputVga1EK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getTvMediaContextMenu-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3627getTvMediaContextMenuEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getTvNetwork-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3628getTvNetworkEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getTvNumberEntry-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3629getTvNumberEntryEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getTvPower-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3630getTvPowerEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getTvRadioService-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3631getTvRadioServiceEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getTvSatellite-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3632getTvSatelliteEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getTvSatelliteBs-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3633getTvSatelliteBsEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getTvSatelliteCs-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3634getTvSatelliteCsEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getTvSatelliteService-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3635getTvSatelliteServiceEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getTvTeletext-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3636getTvTeletextEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getTvTerrestrialAnalog-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3637getTvTerrestrialAnalogEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getTvTerrestrialDigital-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3638getTvTerrestrialDigitalEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getTvTimerProgramming-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3639getTvTimerProgrammingEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getTvZoomMode-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3640getTvZoomModeEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getTwo-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3641getTwoEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getU-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3642getUEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getUnknown-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3643getUnknownEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getV-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3644getVEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getVoiceAssist-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3645getVoiceAssistEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getVolumeDown-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3646getVolumeDownEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getVolumeMute-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3647getVolumeMuteEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getVolumeUp-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3648getVolumeUpEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getW-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3649getWEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getWakeUp-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3650getWakeUpEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getWindow-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3651getWindowEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getX-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3652getXEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getY-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3653getYEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getYen-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3654getYenEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getZ-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3655getZEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getZenkakuHankaru-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3656getZenkakuHankaruEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getZero-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3657getZeroEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getZoomIn-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3658getZoomInEK5gGoQ$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: getZoomOut-EK5gGoQ$annotations, reason: not valid java name */
        public static /* synthetic */ void m3659getZoomOutEK5gGoQ$annotations() {
        }

        /* renamed from: getA-EK5gGoQ, reason: not valid java name */
        public final long m3660getAEK5gGoQ() {
            return Key.f163A;
        }

        /* renamed from: getAllApps-EK5gGoQ, reason: not valid java name */
        public final long m3661getAllAppsEK5gGoQ() {
            return Key.AllApps;
        }

        /* renamed from: getAltLeft-EK5gGoQ, reason: not valid java name */
        public final long m3662getAltLeftEK5gGoQ() {
            return Key.AltLeft;
        }

        /* renamed from: getAltRight-EK5gGoQ, reason: not valid java name */
        public final long m3663getAltRightEK5gGoQ() {
            return Key.AltRight;
        }

        /* renamed from: getApostrophe-EK5gGoQ, reason: not valid java name */
        public final long m3664getApostropheEK5gGoQ() {
            return Key.Apostrophe;
        }

        /* renamed from: getAppSwitch-EK5gGoQ, reason: not valid java name */
        public final long m3665getAppSwitchEK5gGoQ() {
            return Key.AppSwitch;
        }

        /* renamed from: getAssist-EK5gGoQ, reason: not valid java name */
        public final long m3666getAssistEK5gGoQ() {
            return Key.Assist;
        }

        /* renamed from: getAt-EK5gGoQ, reason: not valid java name */
        public final long m3667getAtEK5gGoQ() {
            return Key.f164At;
        }

        /* renamed from: getAvReceiverInput-EK5gGoQ, reason: not valid java name */
        public final long m3668getAvReceiverInputEK5gGoQ() {
            return Key.AvReceiverInput;
        }

        /* renamed from: getAvReceiverPower-EK5gGoQ, reason: not valid java name */
        public final long m3669getAvReceiverPowerEK5gGoQ() {
            return Key.AvReceiverPower;
        }

        /* renamed from: getB-EK5gGoQ, reason: not valid java name */
        public final long m3670getBEK5gGoQ() {
            return Key.f165B;
        }

        /* renamed from: getBack-EK5gGoQ, reason: not valid java name */
        public final long m3671getBackEK5gGoQ() {
            return Key.Back;
        }

        /* renamed from: getBackslash-EK5gGoQ, reason: not valid java name */
        public final long m3672getBackslashEK5gGoQ() {
            return Key.Backslash;
        }

        /* renamed from: getBackspace-EK5gGoQ, reason: not valid java name */
        public final long m3673getBackspaceEK5gGoQ() {
            return Key.Backspace;
        }

        /* renamed from: getBookmark-EK5gGoQ, reason: not valid java name */
        public final long m3674getBookmarkEK5gGoQ() {
            return Key.Bookmark;
        }

        /* renamed from: getBreak-EK5gGoQ, reason: not valid java name */
        public final long m3675getBreakEK5gGoQ() {
            return Key.Break;
        }

        /* renamed from: getBrightnessDown-EK5gGoQ, reason: not valid java name */
        public final long m3676getBrightnessDownEK5gGoQ() {
            return Key.BrightnessDown;
        }

        /* renamed from: getBrightnessUp-EK5gGoQ, reason: not valid java name */
        public final long m3677getBrightnessUpEK5gGoQ() {
            return Key.BrightnessUp;
        }

        /* renamed from: getBrowser-EK5gGoQ, reason: not valid java name */
        public final long m3678getBrowserEK5gGoQ() {
            return Key.Browser;
        }

        /* renamed from: getButton1-EK5gGoQ, reason: not valid java name */
        public final long m3679getButton1EK5gGoQ() {
            return Key.Button1;
        }

        /* renamed from: getButton10-EK5gGoQ, reason: not valid java name */
        public final long m3680getButton10EK5gGoQ() {
            return Key.Button10;
        }

        /* renamed from: getButton11-EK5gGoQ, reason: not valid java name */
        public final long m3681getButton11EK5gGoQ() {
            return Key.Button11;
        }

        /* renamed from: getButton12-EK5gGoQ, reason: not valid java name */
        public final long m3682getButton12EK5gGoQ() {
            return Key.Button12;
        }

        /* renamed from: getButton13-EK5gGoQ, reason: not valid java name */
        public final long m3683getButton13EK5gGoQ() {
            return Key.Button13;
        }

        /* renamed from: getButton14-EK5gGoQ, reason: not valid java name */
        public final long m3684getButton14EK5gGoQ() {
            return Key.Button14;
        }

        /* renamed from: getButton15-EK5gGoQ, reason: not valid java name */
        public final long m3685getButton15EK5gGoQ() {
            return Key.Button15;
        }

        /* renamed from: getButton16-EK5gGoQ, reason: not valid java name */
        public final long m3686getButton16EK5gGoQ() {
            return Key.Button16;
        }

        /* renamed from: getButton2-EK5gGoQ, reason: not valid java name */
        public final long m3687getButton2EK5gGoQ() {
            return Key.Button2;
        }

        /* renamed from: getButton3-EK5gGoQ, reason: not valid java name */
        public final long m3688getButton3EK5gGoQ() {
            return Key.Button3;
        }

        /* renamed from: getButton4-EK5gGoQ, reason: not valid java name */
        public final long m3689getButton4EK5gGoQ() {
            return Key.Button4;
        }

        /* renamed from: getButton5-EK5gGoQ, reason: not valid java name */
        public final long m3690getButton5EK5gGoQ() {
            return Key.Button5;
        }

        /* renamed from: getButton6-EK5gGoQ, reason: not valid java name */
        public final long m3691getButton6EK5gGoQ() {
            return Key.Button6;
        }

        /* renamed from: getButton7-EK5gGoQ, reason: not valid java name */
        public final long m3692getButton7EK5gGoQ() {
            return Key.Button7;
        }

        /* renamed from: getButton8-EK5gGoQ, reason: not valid java name */
        public final long m3693getButton8EK5gGoQ() {
            return Key.Button8;
        }

        /* renamed from: getButton9-EK5gGoQ, reason: not valid java name */
        public final long m3694getButton9EK5gGoQ() {
            return Key.Button9;
        }

        /* renamed from: getButtonA-EK5gGoQ, reason: not valid java name */
        public final long m3695getButtonAEK5gGoQ() {
            return Key.ButtonA;
        }

        /* renamed from: getButtonB-EK5gGoQ, reason: not valid java name */
        public final long m3696getButtonBEK5gGoQ() {
            return Key.ButtonB;
        }

        /* renamed from: getButtonC-EK5gGoQ, reason: not valid java name */
        public final long m3697getButtonCEK5gGoQ() {
            return Key.ButtonC;
        }

        /* renamed from: getButtonL1-EK5gGoQ, reason: not valid java name */
        public final long m3698getButtonL1EK5gGoQ() {
            return Key.ButtonL1;
        }

        /* renamed from: getButtonL2-EK5gGoQ, reason: not valid java name */
        public final long m3699getButtonL2EK5gGoQ() {
            return Key.ButtonL2;
        }

        /* renamed from: getButtonMode-EK5gGoQ, reason: not valid java name */
        public final long m3700getButtonModeEK5gGoQ() {
            return Key.ButtonMode;
        }

        /* renamed from: getButtonR1-EK5gGoQ, reason: not valid java name */
        public final long m3701getButtonR1EK5gGoQ() {
            return Key.ButtonR1;
        }

        /* renamed from: getButtonR2-EK5gGoQ, reason: not valid java name */
        public final long m3702getButtonR2EK5gGoQ() {
            return Key.ButtonR2;
        }

        /* renamed from: getButtonSelect-EK5gGoQ, reason: not valid java name */
        public final long m3703getButtonSelectEK5gGoQ() {
            return Key.ButtonSelect;
        }

        /* renamed from: getButtonStart-EK5gGoQ, reason: not valid java name */
        public final long m3704getButtonStartEK5gGoQ() {
            return Key.ButtonStart;
        }

        /* renamed from: getButtonThumbLeft-EK5gGoQ, reason: not valid java name */
        public final long m3705getButtonThumbLeftEK5gGoQ() {
            return Key.ButtonThumbLeft;
        }

        /* renamed from: getButtonThumbRight-EK5gGoQ, reason: not valid java name */
        public final long m3706getButtonThumbRightEK5gGoQ() {
            return Key.ButtonThumbRight;
        }

        /* renamed from: getButtonX-EK5gGoQ, reason: not valid java name */
        public final long m3707getButtonXEK5gGoQ() {
            return Key.ButtonX;
        }

        /* renamed from: getButtonY-EK5gGoQ, reason: not valid java name */
        public final long m3708getButtonYEK5gGoQ() {
            return Key.ButtonY;
        }

        /* renamed from: getButtonZ-EK5gGoQ, reason: not valid java name */
        public final long m3709getButtonZEK5gGoQ() {
            return Key.ButtonZ;
        }

        /* renamed from: getC-EK5gGoQ, reason: not valid java name */
        public final long m3710getCEK5gGoQ() {
            return Key.f166C;
        }

        /* renamed from: getCalculator-EK5gGoQ, reason: not valid java name */
        public final long m3711getCalculatorEK5gGoQ() {
            return Key.Calculator;
        }

        /* renamed from: getCalendar-EK5gGoQ, reason: not valid java name */
        public final long m3712getCalendarEK5gGoQ() {
            return Key.Calendar;
        }

        /* renamed from: getCall-EK5gGoQ, reason: not valid java name */
        public final long m3713getCallEK5gGoQ() {
            return Key.Call;
        }

        /* renamed from: getCamera-EK5gGoQ, reason: not valid java name */
        public final long m3714getCameraEK5gGoQ() {
            return Key.Camera;
        }

        /* renamed from: getCapsLock-EK5gGoQ, reason: not valid java name */
        public final long m3715getCapsLockEK5gGoQ() {
            return Key.CapsLock;
        }

        /* renamed from: getCaptions-EK5gGoQ, reason: not valid java name */
        public final long m3716getCaptionsEK5gGoQ() {
            return Key.Captions;
        }

        /* renamed from: getChannelDown-EK5gGoQ, reason: not valid java name */
        public final long m3717getChannelDownEK5gGoQ() {
            return Key.ChannelDown;
        }

        /* renamed from: getChannelUp-EK5gGoQ, reason: not valid java name */
        public final long m3718getChannelUpEK5gGoQ() {
            return Key.ChannelUp;
        }

        /* renamed from: getClear-EK5gGoQ, reason: not valid java name */
        public final long m3719getClearEK5gGoQ() {
            return Key.Clear;
        }

        /* renamed from: getComma-EK5gGoQ, reason: not valid java name */
        public final long m3720getCommaEK5gGoQ() {
            return Key.Comma;
        }

        /* renamed from: getContacts-EK5gGoQ, reason: not valid java name */
        public final long m3721getContactsEK5gGoQ() {
            return Key.Contacts;
        }

        /* renamed from: getCopy-EK5gGoQ, reason: not valid java name */
        public final long m3722getCopyEK5gGoQ() {
            return Key.Copy;
        }

        /* renamed from: getCtrlLeft-EK5gGoQ, reason: not valid java name */
        public final long m3723getCtrlLeftEK5gGoQ() {
            return Key.CtrlLeft;
        }

        /* renamed from: getCtrlRight-EK5gGoQ, reason: not valid java name */
        public final long m3724getCtrlRightEK5gGoQ() {
            return Key.CtrlRight;
        }

        /* renamed from: getCut-EK5gGoQ, reason: not valid java name */
        public final long m3725getCutEK5gGoQ() {
            return Key.Cut;
        }

        /* renamed from: getD-EK5gGoQ, reason: not valid java name */
        public final long m3726getDEK5gGoQ() {
            return Key.f167D;
        }

        /* renamed from: getDelete-EK5gGoQ, reason: not valid java name */
        public final long m3727getDeleteEK5gGoQ() {
            return Key.Delete;
        }

        /* renamed from: getDirectionCenter-EK5gGoQ, reason: not valid java name */
        public final long m3728getDirectionCenterEK5gGoQ() {
            return Key.DirectionCenter;
        }

        /* renamed from: getDirectionDown-EK5gGoQ, reason: not valid java name */
        public final long m3729getDirectionDownEK5gGoQ() {
            return Key.DirectionDown;
        }

        /* renamed from: getDirectionDownLeft-EK5gGoQ, reason: not valid java name */
        public final long m3730getDirectionDownLeftEK5gGoQ() {
            return Key.DirectionDownLeft;
        }

        /* renamed from: getDirectionDownRight-EK5gGoQ, reason: not valid java name */
        public final long m3731getDirectionDownRightEK5gGoQ() {
            return Key.DirectionDownRight;
        }

        /* renamed from: getDirectionLeft-EK5gGoQ, reason: not valid java name */
        public final long m3732getDirectionLeftEK5gGoQ() {
            return Key.DirectionLeft;
        }

        /* renamed from: getDirectionRight-EK5gGoQ, reason: not valid java name */
        public final long m3733getDirectionRightEK5gGoQ() {
            return Key.DirectionRight;
        }

        /* renamed from: getDirectionUp-EK5gGoQ, reason: not valid java name */
        public final long m3734getDirectionUpEK5gGoQ() {
            return Key.DirectionUp;
        }

        /* renamed from: getDirectionUpLeft-EK5gGoQ, reason: not valid java name */
        public final long m3735getDirectionUpLeftEK5gGoQ() {
            return Key.DirectionUpLeft;
        }

        /* renamed from: getDirectionUpRight-EK5gGoQ, reason: not valid java name */
        public final long m3736getDirectionUpRightEK5gGoQ() {
            return Key.DirectionUpRight;
        }

        /* renamed from: getDvr-EK5gGoQ, reason: not valid java name */
        public final long m3737getDvrEK5gGoQ() {
            return Key.Dvr;
        }

        /* renamed from: getE-EK5gGoQ, reason: not valid java name */
        public final long m3738getEEK5gGoQ() {
            return Key.f168E;
        }

        /* renamed from: getEight-EK5gGoQ, reason: not valid java name */
        public final long m3739getEightEK5gGoQ() {
            return Key.Eight;
        }

        /* renamed from: getEisu-EK5gGoQ, reason: not valid java name */
        public final long m3740getEisuEK5gGoQ() {
            return Key.Eisu;
        }

        /* renamed from: getEndCall-EK5gGoQ, reason: not valid java name */
        public final long m3741getEndCallEK5gGoQ() {
            return Key.EndCall;
        }

        /* renamed from: getEnter-EK5gGoQ, reason: not valid java name */
        public final long m3742getEnterEK5gGoQ() {
            return Key.Enter;
        }

        /* renamed from: getEnvelope-EK5gGoQ, reason: not valid java name */
        public final long m3743getEnvelopeEK5gGoQ() {
            return Key.Envelope;
        }

        /* renamed from: getEquals-EK5gGoQ, reason: not valid java name */
        public final long m3744getEqualsEK5gGoQ() {
            return Key.Equals;
        }

        /* renamed from: getEscape-EK5gGoQ, reason: not valid java name */
        public final long m3745getEscapeEK5gGoQ() {
            return Key.Escape;
        }

        /* renamed from: getF-EK5gGoQ, reason: not valid java name */
        public final long m3746getFEK5gGoQ() {
            return Key.f169F;
        }

        /* renamed from: getF1-EK5gGoQ, reason: not valid java name */
        public final long m3747getF1EK5gGoQ() {
            return Key.f170F1;
        }

        /* renamed from: getF10-EK5gGoQ, reason: not valid java name */
        public final long m3748getF10EK5gGoQ() {
            return Key.F10;
        }

        /* renamed from: getF11-EK5gGoQ, reason: not valid java name */
        public final long m3749getF11EK5gGoQ() {
            return Key.F11;
        }

        /* renamed from: getF12-EK5gGoQ, reason: not valid java name */
        public final long m3750getF12EK5gGoQ() {
            return Key.F12;
        }

        /* renamed from: getF2-EK5gGoQ, reason: not valid java name */
        public final long m3751getF2EK5gGoQ() {
            return Key.f171F2;
        }

        /* renamed from: getF3-EK5gGoQ, reason: not valid java name */
        public final long m3752getF3EK5gGoQ() {
            return Key.f172F3;
        }

        /* renamed from: getF4-EK5gGoQ, reason: not valid java name */
        public final long m3753getF4EK5gGoQ() {
            return Key.f173F4;
        }

        /* renamed from: getF5-EK5gGoQ, reason: not valid java name */
        public final long m3754getF5EK5gGoQ() {
            return Key.f174F5;
        }

        /* renamed from: getF6-EK5gGoQ, reason: not valid java name */
        public final long m3755getF6EK5gGoQ() {
            return Key.f175F6;
        }

        /* renamed from: getF7-EK5gGoQ, reason: not valid java name */
        public final long m3756getF7EK5gGoQ() {
            return Key.f176F7;
        }

        /* renamed from: getF8-EK5gGoQ, reason: not valid java name */
        public final long m3757getF8EK5gGoQ() {
            return Key.f177F8;
        }

        /* renamed from: getF9-EK5gGoQ, reason: not valid java name */
        public final long m3758getF9EK5gGoQ() {
            return Key.f178F9;
        }

        /* renamed from: getFive-EK5gGoQ, reason: not valid java name */
        public final long m3759getFiveEK5gGoQ() {
            return Key.Five;
        }

        /* renamed from: getFocus-EK5gGoQ, reason: not valid java name */
        public final long m3760getFocusEK5gGoQ() {
            return Key.Focus;
        }

        /* renamed from: getForward-EK5gGoQ, reason: not valid java name */
        public final long m3761getForwardEK5gGoQ() {
            return Key.Forward;
        }

        /* renamed from: getFour-EK5gGoQ, reason: not valid java name */
        public final long m3762getFourEK5gGoQ() {
            return Key.Four;
        }

        /* renamed from: getFunction-EK5gGoQ, reason: not valid java name */
        public final long m3763getFunctionEK5gGoQ() {
            return Key.Function;
        }

        /* renamed from: getG-EK5gGoQ, reason: not valid java name */
        public final long m3764getGEK5gGoQ() {
            return Key.f179G;
        }

        /* renamed from: getGrave-EK5gGoQ, reason: not valid java name */
        public final long m3765getGraveEK5gGoQ() {
            return Key.Grave;
        }

        /* renamed from: getGuide-EK5gGoQ, reason: not valid java name */
        public final long m3766getGuideEK5gGoQ() {
            return Key.Guide;
        }

        /* renamed from: getH-EK5gGoQ, reason: not valid java name */
        public final long m3767getHEK5gGoQ() {
            return Key.f180H;
        }

        /* renamed from: getHeadsetHook-EK5gGoQ, reason: not valid java name */
        public final long m3768getHeadsetHookEK5gGoQ() {
            return Key.HeadsetHook;
        }

        /* renamed from: getHelp-EK5gGoQ, reason: not valid java name */
        public final long m3769getHelpEK5gGoQ() {
            return Key.Help;
        }

        /* renamed from: getHenkan-EK5gGoQ, reason: not valid java name */
        public final long m3770getHenkanEK5gGoQ() {
            return Key.Henkan;
        }

        /* renamed from: getHome-EK5gGoQ, reason: not valid java name */
        public final long m3771getHomeEK5gGoQ() {
            return Key.Home;
        }

        /* renamed from: getI-EK5gGoQ, reason: not valid java name */
        public final long m3772getIEK5gGoQ() {
            return Key.f181I;
        }

        /* renamed from: getInfo-EK5gGoQ, reason: not valid java name */
        public final long m3773getInfoEK5gGoQ() {
            return Key.Info;
        }

        /* renamed from: getInsert-EK5gGoQ, reason: not valid java name */
        public final long m3774getInsertEK5gGoQ() {
            return Key.Insert;
        }

        /* renamed from: getJ-EK5gGoQ, reason: not valid java name */
        public final long m3775getJEK5gGoQ() {
            return Key.f182J;
        }

        /* renamed from: getK-EK5gGoQ, reason: not valid java name */
        public final long m3776getKEK5gGoQ() {
            return Key.f183K;
        }

        /* renamed from: getKana-EK5gGoQ, reason: not valid java name */
        public final long m3777getKanaEK5gGoQ() {
            return Key.Kana;
        }

        /* renamed from: getKatakanaHiragana-EK5gGoQ, reason: not valid java name */
        public final long m3778getKatakanaHiraganaEK5gGoQ() {
            return Key.KatakanaHiragana;
        }

        /* renamed from: getL-EK5gGoQ, reason: not valid java name */
        public final long m3779getLEK5gGoQ() {
            return Key.f184L;
        }

        /* renamed from: getLanguageSwitch-EK5gGoQ, reason: not valid java name */
        public final long m3780getLanguageSwitchEK5gGoQ() {
            return Key.LanguageSwitch;
        }

        /* renamed from: getLastChannel-EK5gGoQ, reason: not valid java name */
        public final long m3781getLastChannelEK5gGoQ() {
            return Key.LastChannel;
        }

        /* renamed from: getLeftBracket-EK5gGoQ, reason: not valid java name */
        public final long m3782getLeftBracketEK5gGoQ() {
            return Key.LeftBracket;
        }

        /* renamed from: getM-EK5gGoQ, reason: not valid java name */
        public final long m3783getMEK5gGoQ() {
            return Key.f185M;
        }

        /* renamed from: getMannerMode-EK5gGoQ, reason: not valid java name */
        public final long m3784getMannerModeEK5gGoQ() {
            return Key.MannerMode;
        }

        /* renamed from: getMediaAudioTrack-EK5gGoQ, reason: not valid java name */
        public final long m3785getMediaAudioTrackEK5gGoQ() {
            return Key.MediaAudioTrack;
        }

        /* renamed from: getMediaClose-EK5gGoQ, reason: not valid java name */
        public final long m3786getMediaCloseEK5gGoQ() {
            return Key.MediaClose;
        }

        /* renamed from: getMediaEject-EK5gGoQ, reason: not valid java name */
        public final long m3787getMediaEjectEK5gGoQ() {
            return Key.MediaEject;
        }

        /* renamed from: getMediaFastForward-EK5gGoQ, reason: not valid java name */
        public final long m3788getMediaFastForwardEK5gGoQ() {
            return Key.MediaFastForward;
        }

        /* renamed from: getMediaNext-EK5gGoQ, reason: not valid java name */
        public final long m3789getMediaNextEK5gGoQ() {
            return Key.MediaNext;
        }

        /* renamed from: getMediaPause-EK5gGoQ, reason: not valid java name */
        public final long m3790getMediaPauseEK5gGoQ() {
            return Key.MediaPause;
        }

        /* renamed from: getMediaPlay-EK5gGoQ, reason: not valid java name */
        public final long m3791getMediaPlayEK5gGoQ() {
            return Key.MediaPlay;
        }

        /* renamed from: getMediaPlayPause-EK5gGoQ, reason: not valid java name */
        public final long m3792getMediaPlayPauseEK5gGoQ() {
            return Key.MediaPlayPause;
        }

        /* renamed from: getMediaPrevious-EK5gGoQ, reason: not valid java name */
        public final long m3793getMediaPreviousEK5gGoQ() {
            return Key.MediaPrevious;
        }

        /* renamed from: getMediaRecord-EK5gGoQ, reason: not valid java name */
        public final long m3794getMediaRecordEK5gGoQ() {
            return Key.MediaRecord;
        }

        /* renamed from: getMediaRewind-EK5gGoQ, reason: not valid java name */
        public final long m3795getMediaRewindEK5gGoQ() {
            return Key.MediaRewind;
        }

        /* renamed from: getMediaSkipBackward-EK5gGoQ, reason: not valid java name */
        public final long m3796getMediaSkipBackwardEK5gGoQ() {
            return Key.MediaSkipBackward;
        }

        /* renamed from: getMediaSkipForward-EK5gGoQ, reason: not valid java name */
        public final long m3797getMediaSkipForwardEK5gGoQ() {
            return Key.MediaSkipForward;
        }

        /* renamed from: getMediaStepBackward-EK5gGoQ, reason: not valid java name */
        public final long m3798getMediaStepBackwardEK5gGoQ() {
            return Key.MediaStepBackward;
        }

        /* renamed from: getMediaStepForward-EK5gGoQ, reason: not valid java name */
        public final long m3799getMediaStepForwardEK5gGoQ() {
            return Key.MediaStepForward;
        }

        /* renamed from: getMediaStop-EK5gGoQ, reason: not valid java name */
        public final long m3800getMediaStopEK5gGoQ() {
            return Key.MediaStop;
        }

        /* renamed from: getMediaTopMenu-EK5gGoQ, reason: not valid java name */
        public final long m3801getMediaTopMenuEK5gGoQ() {
            return Key.MediaTopMenu;
        }

        /* renamed from: getMenu-EK5gGoQ, reason: not valid java name */
        public final long m3802getMenuEK5gGoQ() {
            return Key.Menu;
        }

        /* renamed from: getMetaLeft-EK5gGoQ, reason: not valid java name */
        public final long m3803getMetaLeftEK5gGoQ() {
            return Key.MetaLeft;
        }

        /* renamed from: getMetaRight-EK5gGoQ, reason: not valid java name */
        public final long m3804getMetaRightEK5gGoQ() {
            return Key.MetaRight;
        }

        /* renamed from: getMicrophoneMute-EK5gGoQ, reason: not valid java name */
        public final long m3805getMicrophoneMuteEK5gGoQ() {
            return Key.MicrophoneMute;
        }

        /* renamed from: getMinus-EK5gGoQ, reason: not valid java name */
        public final long m3806getMinusEK5gGoQ() {
            return Key.Minus;
        }

        /* renamed from: getMoveEnd-EK5gGoQ, reason: not valid java name */
        public final long m3807getMoveEndEK5gGoQ() {
            return Key.MoveEnd;
        }

        /* renamed from: getMoveHome-EK5gGoQ, reason: not valid java name */
        public final long m3808getMoveHomeEK5gGoQ() {
            return Key.MoveHome;
        }

        /* renamed from: getMuhenkan-EK5gGoQ, reason: not valid java name */
        public final long m3809getMuhenkanEK5gGoQ() {
            return Key.Muhenkan;
        }

        /* renamed from: getMultiply-EK5gGoQ, reason: not valid java name */
        public final long m3810getMultiplyEK5gGoQ() {
            return Key.Multiply;
        }

        /* renamed from: getMusic-EK5gGoQ, reason: not valid java name */
        public final long m3811getMusicEK5gGoQ() {
            return Key.Music;
        }

        /* renamed from: getN-EK5gGoQ, reason: not valid java name */
        public final long m3812getNEK5gGoQ() {
            return Key.f186N;
        }

        /* renamed from: getNavigateIn-EK5gGoQ, reason: not valid java name */
        public final long m3813getNavigateInEK5gGoQ() {
            return Key.NavigateIn;
        }

        /* renamed from: getNavigateNext-EK5gGoQ, reason: not valid java name */
        public final long m3814getNavigateNextEK5gGoQ() {
            return Key.NavigateNext;
        }

        /* renamed from: getNavigateOut-EK5gGoQ, reason: not valid java name */
        public final long m3815getNavigateOutEK5gGoQ() {
            return Key.NavigateOut;
        }

        /* renamed from: getNavigatePrevious-EK5gGoQ, reason: not valid java name */
        public final long m3816getNavigatePreviousEK5gGoQ() {
            return Key.NavigatePrevious;
        }

        /* renamed from: getNine-EK5gGoQ, reason: not valid java name */
        public final long m3817getNineEK5gGoQ() {
            return Key.Nine;
        }

        /* renamed from: getNotification-EK5gGoQ, reason: not valid java name */
        public final long m3818getNotificationEK5gGoQ() {
            return Key.Notification;
        }

        /* renamed from: getNumLock-EK5gGoQ, reason: not valid java name */
        public final long m3819getNumLockEK5gGoQ() {
            return Key.NumLock;
        }

        /* renamed from: getNumPad0-EK5gGoQ, reason: not valid java name */
        public final long m3820getNumPad0EK5gGoQ() {
            return Key.NumPad0;
        }

        /* renamed from: getNumPad1-EK5gGoQ, reason: not valid java name */
        public final long m3821getNumPad1EK5gGoQ() {
            return Key.NumPad1;
        }

        /* renamed from: getNumPad2-EK5gGoQ, reason: not valid java name */
        public final long m3822getNumPad2EK5gGoQ() {
            return Key.NumPad2;
        }

        /* renamed from: getNumPad3-EK5gGoQ, reason: not valid java name */
        public final long m3823getNumPad3EK5gGoQ() {
            return Key.NumPad3;
        }

        /* renamed from: getNumPad4-EK5gGoQ, reason: not valid java name */
        public final long m3824getNumPad4EK5gGoQ() {
            return Key.NumPad4;
        }

        /* renamed from: getNumPad5-EK5gGoQ, reason: not valid java name */
        public final long m3825getNumPad5EK5gGoQ() {
            return Key.NumPad5;
        }

        /* renamed from: getNumPad6-EK5gGoQ, reason: not valid java name */
        public final long m3826getNumPad6EK5gGoQ() {
            return Key.NumPad6;
        }

        /* renamed from: getNumPad7-EK5gGoQ, reason: not valid java name */
        public final long m3827getNumPad7EK5gGoQ() {
            return Key.NumPad7;
        }

        /* renamed from: getNumPad8-EK5gGoQ, reason: not valid java name */
        public final long m3828getNumPad8EK5gGoQ() {
            return Key.NumPad8;
        }

        /* renamed from: getNumPad9-EK5gGoQ, reason: not valid java name */
        public final long m3829getNumPad9EK5gGoQ() {
            return Key.NumPad9;
        }

        /* renamed from: getNumPadAdd-EK5gGoQ, reason: not valid java name */
        public final long m3830getNumPadAddEK5gGoQ() {
            return Key.NumPadAdd;
        }

        /* renamed from: getNumPadComma-EK5gGoQ, reason: not valid java name */
        public final long m3831getNumPadCommaEK5gGoQ() {
            return Key.NumPadComma;
        }

        /* renamed from: getNumPadDivide-EK5gGoQ, reason: not valid java name */
        public final long m3832getNumPadDivideEK5gGoQ() {
            return Key.NumPadDivide;
        }

        /* renamed from: getNumPadDot-EK5gGoQ, reason: not valid java name */
        public final long m3833getNumPadDotEK5gGoQ() {
            return Key.NumPadDot;
        }

        /* renamed from: getNumPadEnter-EK5gGoQ, reason: not valid java name */
        public final long m3834getNumPadEnterEK5gGoQ() {
            return Key.NumPadEnter;
        }

        /* renamed from: getNumPadEquals-EK5gGoQ, reason: not valid java name */
        public final long m3835getNumPadEqualsEK5gGoQ() {
            return Key.NumPadEquals;
        }

        /* renamed from: getNumPadLeftParenthesis-EK5gGoQ, reason: not valid java name */
        public final long m3836getNumPadLeftParenthesisEK5gGoQ() {
            return Key.NumPadLeftParenthesis;
        }

        /* renamed from: getNumPadMultiply-EK5gGoQ, reason: not valid java name */
        public final long m3837getNumPadMultiplyEK5gGoQ() {
            return Key.NumPadMultiply;
        }

        /* renamed from: getNumPadRightParenthesis-EK5gGoQ, reason: not valid java name */
        public final long m3838getNumPadRightParenthesisEK5gGoQ() {
            return Key.NumPadRightParenthesis;
        }

        /* renamed from: getNumPadSubtract-EK5gGoQ, reason: not valid java name */
        public final long m3839getNumPadSubtractEK5gGoQ() {
            return Key.NumPadSubtract;
        }

        /* renamed from: getNumber-EK5gGoQ, reason: not valid java name */
        public final long m3840getNumberEK5gGoQ() {
            return Key.Number;
        }

        /* renamed from: getO-EK5gGoQ, reason: not valid java name */
        public final long m3841getOEK5gGoQ() {
            return Key.f187O;
        }

        /* renamed from: getOne-EK5gGoQ, reason: not valid java name */
        public final long m3842getOneEK5gGoQ() {
            return Key.One;
        }

        /* renamed from: getP-EK5gGoQ, reason: not valid java name */
        public final long m3843getPEK5gGoQ() {
            return Key.f188P;
        }

        /* renamed from: getPageDown-EK5gGoQ, reason: not valid java name */
        public final long m3844getPageDownEK5gGoQ() {
            return Key.PageDown;
        }

        /* renamed from: getPageUp-EK5gGoQ, reason: not valid java name */
        public final long m3845getPageUpEK5gGoQ() {
            return Key.PageUp;
        }

        /* renamed from: getPairing-EK5gGoQ, reason: not valid java name */
        public final long m3846getPairingEK5gGoQ() {
            return Key.Pairing;
        }

        /* renamed from: getPaste-EK5gGoQ, reason: not valid java name */
        public final long m3847getPasteEK5gGoQ() {
            return Key.Paste;
        }

        /* renamed from: getPeriod-EK5gGoQ, reason: not valid java name */
        public final long m3848getPeriodEK5gGoQ() {
            return Key.Period;
        }

        /* renamed from: getPictureSymbols-EK5gGoQ, reason: not valid java name */
        public final long m3849getPictureSymbolsEK5gGoQ() {
            return Key.PictureSymbols;
        }

        /* renamed from: getPlus-EK5gGoQ, reason: not valid java name */
        public final long m3850getPlusEK5gGoQ() {
            return Key.Plus;
        }

        /* renamed from: getPound-EK5gGoQ, reason: not valid java name */
        public final long m3851getPoundEK5gGoQ() {
            return Key.Pound;
        }

        /* renamed from: getPower-EK5gGoQ, reason: not valid java name */
        public final long m3852getPowerEK5gGoQ() {
            return Key.Power;
        }

        /* renamed from: getPrintScreen-EK5gGoQ, reason: not valid java name */
        public final long m3853getPrintScreenEK5gGoQ() {
            return Key.PrintScreen;
        }

        /* renamed from: getProfileSwitch-EK5gGoQ, reason: not valid java name */
        public final long m3854getProfileSwitchEK5gGoQ() {
            return Key.ProfileSwitch;
        }

        /* renamed from: getProgramBlue-EK5gGoQ, reason: not valid java name */
        public final long m3855getProgramBlueEK5gGoQ() {
            return Key.ProgramBlue;
        }

        /* renamed from: getProgramGreen-EK5gGoQ, reason: not valid java name */
        public final long m3856getProgramGreenEK5gGoQ() {
            return Key.ProgramGreen;
        }

        /* renamed from: getProgramRed-EK5gGoQ, reason: not valid java name */
        public final long m3857getProgramRedEK5gGoQ() {
            return Key.ProgramRed;
        }

        /* renamed from: getProgramYellow-EK5gGoQ, reason: not valid java name */
        public final long m3858getProgramYellowEK5gGoQ() {
            return Key.ProgramYellow;
        }

        /* renamed from: getQ-EK5gGoQ, reason: not valid java name */
        public final long m3859getQEK5gGoQ() {
            return Key.f189Q;
        }

        /* renamed from: getR-EK5gGoQ, reason: not valid java name */
        public final long m3860getREK5gGoQ() {
            return Key.f190R;
        }

        /* renamed from: getRefresh-EK5gGoQ, reason: not valid java name */
        public final long m3861getRefreshEK5gGoQ() {
            return Key.Refresh;
        }

        /* renamed from: getRightBracket-EK5gGoQ, reason: not valid java name */
        public final long m3862getRightBracketEK5gGoQ() {
            return Key.RightBracket;
        }

        /* renamed from: getRo-EK5gGoQ, reason: not valid java name */
        public final long m3863getRoEK5gGoQ() {
            return Key.f191Ro;
        }

        /* renamed from: getS-EK5gGoQ, reason: not valid java name */
        public final long m3864getSEK5gGoQ() {
            return Key.f192S;
        }

        /* renamed from: getScrollLock-EK5gGoQ, reason: not valid java name */
        public final long m3865getScrollLockEK5gGoQ() {
            return Key.ScrollLock;
        }

        /* renamed from: getSearch-EK5gGoQ, reason: not valid java name */
        public final long m3866getSearchEK5gGoQ() {
            return Key.Search;
        }

        /* renamed from: getSemicolon-EK5gGoQ, reason: not valid java name */
        public final long m3867getSemicolonEK5gGoQ() {
            return Key.Semicolon;
        }

        /* renamed from: getSetTopBoxInput-EK5gGoQ, reason: not valid java name */
        public final long m3868getSetTopBoxInputEK5gGoQ() {
            return Key.SetTopBoxInput;
        }

        /* renamed from: getSetTopBoxPower-EK5gGoQ, reason: not valid java name */
        public final long m3869getSetTopBoxPowerEK5gGoQ() {
            return Key.SetTopBoxPower;
        }

        /* renamed from: getSettings-EK5gGoQ, reason: not valid java name */
        public final long m3870getSettingsEK5gGoQ() {
            return Key.Settings;
        }

        /* renamed from: getSeven-EK5gGoQ, reason: not valid java name */
        public final long m3871getSevenEK5gGoQ() {
            return Key.Seven;
        }

        /* renamed from: getShiftLeft-EK5gGoQ, reason: not valid java name */
        public final long m3872getShiftLeftEK5gGoQ() {
            return Key.ShiftLeft;
        }

        /* renamed from: getShiftRight-EK5gGoQ, reason: not valid java name */
        public final long m3873getShiftRightEK5gGoQ() {
            return Key.ShiftRight;
        }

        /* renamed from: getSix-EK5gGoQ, reason: not valid java name */
        public final long m3874getSixEK5gGoQ() {
            return Key.Six;
        }

        /* renamed from: getSlash-EK5gGoQ, reason: not valid java name */
        public final long m3875getSlashEK5gGoQ() {
            return Key.Slash;
        }

        /* renamed from: getSleep-EK5gGoQ, reason: not valid java name */
        public final long m3876getSleepEK5gGoQ() {
            return Key.Sleep;
        }

        /* renamed from: getSoftLeft-EK5gGoQ, reason: not valid java name */
        public final long m3877getSoftLeftEK5gGoQ() {
            return Key.SoftLeft;
        }

        /* renamed from: getSoftRight-EK5gGoQ, reason: not valid java name */
        public final long m3878getSoftRightEK5gGoQ() {
            return Key.SoftRight;
        }

        /* renamed from: getSoftSleep-EK5gGoQ, reason: not valid java name */
        public final long m3879getSoftSleepEK5gGoQ() {
            return Key.SoftSleep;
        }

        /* renamed from: getSpacebar-EK5gGoQ, reason: not valid java name */
        public final long m3880getSpacebarEK5gGoQ() {
            return Key.Spacebar;
        }

        /* renamed from: getStem1-EK5gGoQ, reason: not valid java name */
        public final long m3881getStem1EK5gGoQ() {
            return Key.Stem1;
        }

        /* renamed from: getStem2-EK5gGoQ, reason: not valid java name */
        public final long m3882getStem2EK5gGoQ() {
            return Key.Stem2;
        }

        /* renamed from: getStem3-EK5gGoQ, reason: not valid java name */
        public final long m3883getStem3EK5gGoQ() {
            return Key.Stem3;
        }

        /* renamed from: getStemPrimary-EK5gGoQ, reason: not valid java name */
        public final long m3884getStemPrimaryEK5gGoQ() {
            return Key.StemPrimary;
        }

        /* renamed from: getSwitchCharset-EK5gGoQ, reason: not valid java name */
        public final long m3885getSwitchCharsetEK5gGoQ() {
            return Key.SwitchCharset;
        }

        /* renamed from: getSymbol-EK5gGoQ, reason: not valid java name */
        public final long m3886getSymbolEK5gGoQ() {
            return Key.Symbol;
        }

        /* renamed from: getSystemNavigationDown-EK5gGoQ, reason: not valid java name */
        public final long m3887getSystemNavigationDownEK5gGoQ() {
            return Key.SystemNavigationDown;
        }

        /* renamed from: getSystemNavigationLeft-EK5gGoQ, reason: not valid java name */
        public final long m3888getSystemNavigationLeftEK5gGoQ() {
            return Key.SystemNavigationLeft;
        }

        /* renamed from: getSystemNavigationRight-EK5gGoQ, reason: not valid java name */
        public final long m3889getSystemNavigationRightEK5gGoQ() {
            return Key.SystemNavigationRight;
        }

        /* renamed from: getSystemNavigationUp-EK5gGoQ, reason: not valid java name */
        public final long m3890getSystemNavigationUpEK5gGoQ() {
            return Key.SystemNavigationUp;
        }

        /* renamed from: getT-EK5gGoQ, reason: not valid java name */
        public final long m3891getTEK5gGoQ() {
            return Key.f193T;
        }

        /* renamed from: getTab-EK5gGoQ, reason: not valid java name */
        public final long m3892getTabEK5gGoQ() {
            return Key.Tab;
        }

        /* renamed from: getThree-EK5gGoQ, reason: not valid java name */
        public final long m3893getThreeEK5gGoQ() {
            return Key.Three;
        }

        /* renamed from: getThumbsDown-EK5gGoQ, reason: not valid java name */
        public final long m3894getThumbsDownEK5gGoQ() {
            return Key.ThumbsDown;
        }

        /* renamed from: getThumbsUp-EK5gGoQ, reason: not valid java name */
        public final long m3895getThumbsUpEK5gGoQ() {
            return Key.ThumbsUp;
        }

        /* renamed from: getToggle2D3D-EK5gGoQ, reason: not valid java name */
        public final long m3896getToggle2D3DEK5gGoQ() {
            return Key.Toggle2D3D;
        }

        /* renamed from: getTv-EK5gGoQ, reason: not valid java name */
        public final long m3897getTvEK5gGoQ() {
            return Key.f194Tv;
        }

        /* renamed from: getTvAntennaCable-EK5gGoQ, reason: not valid java name */
        public final long m3898getTvAntennaCableEK5gGoQ() {
            return Key.TvAntennaCable;
        }

        /* renamed from: getTvAudioDescription-EK5gGoQ, reason: not valid java name */
        public final long m3899getTvAudioDescriptionEK5gGoQ() {
            return Key.TvAudioDescription;
        }

        /* renamed from: getTvAudioDescriptionMixingVolumeDown-EK5gGoQ, reason: not valid java name */
        public final long m3900getTvAudioDescriptionMixingVolumeDownEK5gGoQ() {
            return Key.TvAudioDescriptionMixingVolumeDown;
        }

        /* renamed from: getTvAudioDescriptionMixingVolumeUp-EK5gGoQ, reason: not valid java name */
        public final long m3901getTvAudioDescriptionMixingVolumeUpEK5gGoQ() {
            return Key.TvAudioDescriptionMixingVolumeUp;
        }

        /* renamed from: getTvContentsMenu-EK5gGoQ, reason: not valid java name */
        public final long m3902getTvContentsMenuEK5gGoQ() {
            return Key.TvContentsMenu;
        }

        /* renamed from: getTvDataService-EK5gGoQ, reason: not valid java name */
        public final long m3903getTvDataServiceEK5gGoQ() {
            return Key.TvDataService;
        }

        /* renamed from: getTvInput-EK5gGoQ, reason: not valid java name */
        public final long m3904getTvInputEK5gGoQ() {
            return Key.TvInput;
        }

        /* renamed from: getTvInputComponent1-EK5gGoQ, reason: not valid java name */
        public final long m3905getTvInputComponent1EK5gGoQ() {
            return Key.TvInputComponent1;
        }

        /* renamed from: getTvInputComponent2-EK5gGoQ, reason: not valid java name */
        public final long m3906getTvInputComponent2EK5gGoQ() {
            return Key.TvInputComponent2;
        }

        /* renamed from: getTvInputComposite1-EK5gGoQ, reason: not valid java name */
        public final long m3907getTvInputComposite1EK5gGoQ() {
            return Key.TvInputComposite1;
        }

        /* renamed from: getTvInputComposite2-EK5gGoQ, reason: not valid java name */
        public final long m3908getTvInputComposite2EK5gGoQ() {
            return Key.TvInputComposite2;
        }

        /* renamed from: getTvInputHdmi1-EK5gGoQ, reason: not valid java name */
        public final long m3909getTvInputHdmi1EK5gGoQ() {
            return Key.TvInputHdmi1;
        }

        /* renamed from: getTvInputHdmi2-EK5gGoQ, reason: not valid java name */
        public final long m3910getTvInputHdmi2EK5gGoQ() {
            return Key.TvInputHdmi2;
        }

        /* renamed from: getTvInputHdmi3-EK5gGoQ, reason: not valid java name */
        public final long m3911getTvInputHdmi3EK5gGoQ() {
            return Key.TvInputHdmi3;
        }

        /* renamed from: getTvInputHdmi4-EK5gGoQ, reason: not valid java name */
        public final long m3912getTvInputHdmi4EK5gGoQ() {
            return Key.TvInputHdmi4;
        }

        /* renamed from: getTvInputVga1-EK5gGoQ, reason: not valid java name */
        public final long m3913getTvInputVga1EK5gGoQ() {
            return Key.TvInputVga1;
        }

        /* renamed from: getTvMediaContextMenu-EK5gGoQ, reason: not valid java name */
        public final long m3914getTvMediaContextMenuEK5gGoQ() {
            return Key.TvMediaContextMenu;
        }

        /* renamed from: getTvNetwork-EK5gGoQ, reason: not valid java name */
        public final long m3915getTvNetworkEK5gGoQ() {
            return Key.TvNetwork;
        }

        /* renamed from: getTvNumberEntry-EK5gGoQ, reason: not valid java name */
        public final long m3916getTvNumberEntryEK5gGoQ() {
            return Key.TvNumberEntry;
        }

        /* renamed from: getTvPower-EK5gGoQ, reason: not valid java name */
        public final long m3917getTvPowerEK5gGoQ() {
            return Key.TvPower;
        }

        /* renamed from: getTvRadioService-EK5gGoQ, reason: not valid java name */
        public final long m3918getTvRadioServiceEK5gGoQ() {
            return Key.TvRadioService;
        }

        /* renamed from: getTvSatellite-EK5gGoQ, reason: not valid java name */
        public final long m3919getTvSatelliteEK5gGoQ() {
            return Key.TvSatellite;
        }

        /* renamed from: getTvSatelliteBs-EK5gGoQ, reason: not valid java name */
        public final long m3920getTvSatelliteBsEK5gGoQ() {
            return Key.TvSatelliteBs;
        }

        /* renamed from: getTvSatelliteCs-EK5gGoQ, reason: not valid java name */
        public final long m3921getTvSatelliteCsEK5gGoQ() {
            return Key.TvSatelliteCs;
        }

        /* renamed from: getTvSatelliteService-EK5gGoQ, reason: not valid java name */
        public final long m3922getTvSatelliteServiceEK5gGoQ() {
            return Key.TvSatelliteService;
        }

        /* renamed from: getTvTeletext-EK5gGoQ, reason: not valid java name */
        public final long m3923getTvTeletextEK5gGoQ() {
            return Key.TvTeletext;
        }

        /* renamed from: getTvTerrestrialAnalog-EK5gGoQ, reason: not valid java name */
        public final long m3924getTvTerrestrialAnalogEK5gGoQ() {
            return Key.TvTerrestrialAnalog;
        }

        /* renamed from: getTvTerrestrialDigital-EK5gGoQ, reason: not valid java name */
        public final long m3925getTvTerrestrialDigitalEK5gGoQ() {
            return Key.TvTerrestrialDigital;
        }

        /* renamed from: getTvTimerProgramming-EK5gGoQ, reason: not valid java name */
        public final long m3926getTvTimerProgrammingEK5gGoQ() {
            return Key.TvTimerProgramming;
        }

        /* renamed from: getTvZoomMode-EK5gGoQ, reason: not valid java name */
        public final long m3927getTvZoomModeEK5gGoQ() {
            return Key.TvZoomMode;
        }

        /* renamed from: getTwo-EK5gGoQ, reason: not valid java name */
        public final long m3928getTwoEK5gGoQ() {
            return Key.Two;
        }

        /* renamed from: getU-EK5gGoQ, reason: not valid java name */
        public final long m3929getUEK5gGoQ() {
            return Key.f195U;
        }

        /* renamed from: getUnknown-EK5gGoQ, reason: not valid java name */
        public final long m3930getUnknownEK5gGoQ() {
            return Key.Unknown;
        }

        /* renamed from: getV-EK5gGoQ, reason: not valid java name */
        public final long m3931getVEK5gGoQ() {
            return Key.f196V;
        }

        /* renamed from: getVoiceAssist-EK5gGoQ, reason: not valid java name */
        public final long m3932getVoiceAssistEK5gGoQ() {
            return Key.VoiceAssist;
        }

        /* renamed from: getVolumeDown-EK5gGoQ, reason: not valid java name */
        public final long m3933getVolumeDownEK5gGoQ() {
            return Key.VolumeDown;
        }

        /* renamed from: getVolumeMute-EK5gGoQ, reason: not valid java name */
        public final long m3934getVolumeMuteEK5gGoQ() {
            return Key.VolumeMute;
        }

        /* renamed from: getVolumeUp-EK5gGoQ, reason: not valid java name */
        public final long m3935getVolumeUpEK5gGoQ() {
            return Key.VolumeUp;
        }

        /* renamed from: getW-EK5gGoQ, reason: not valid java name */
        public final long m3936getWEK5gGoQ() {
            return Key.f197W;
        }

        /* renamed from: getWakeUp-EK5gGoQ, reason: not valid java name */
        public final long m3937getWakeUpEK5gGoQ() {
            return Key.WakeUp;
        }

        /* renamed from: getWindow-EK5gGoQ, reason: not valid java name */
        public final long m3938getWindowEK5gGoQ() {
            return Key.Window;
        }

        /* renamed from: getX-EK5gGoQ, reason: not valid java name */
        public final long m3939getXEK5gGoQ() {
            return Key.f198X;
        }

        /* renamed from: getY-EK5gGoQ, reason: not valid java name */
        public final long m3940getYEK5gGoQ() {
            return Key.f199Y;
        }

        /* renamed from: getYen-EK5gGoQ, reason: not valid java name */
        public final long m3941getYenEK5gGoQ() {
            return Key.Yen;
        }

        /* renamed from: getZ-EK5gGoQ, reason: not valid java name */
        public final long m3942getZEK5gGoQ() {
            return Key.f200Z;
        }

        /* renamed from: getZenkakuHankaru-EK5gGoQ, reason: not valid java name */
        public final long m3943getZenkakuHankaruEK5gGoQ() {
            return Key.ZenkakuHankaru;
        }

        /* renamed from: getZero-EK5gGoQ, reason: not valid java name */
        public final long m3944getZeroEK5gGoQ() {
            return Key.Zero;
        }

        /* renamed from: getZoomIn-EK5gGoQ, reason: not valid java name */
        public final long m3945getZoomInEK5gGoQ() {
            return Key.ZoomIn;
        }

        /* renamed from: getZoomOut-EK5gGoQ, reason: not valid java name */
        public final long m3946getZoomOutEK5gGoQ() {
            return Key.ZoomOut;
        }
    }

    private /* synthetic */ Key(long j) {
        this.keyCode = j;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Key m3366boximpl(long j) {
        return new Key(j);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m3367constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m3368equalsimpl(long j, Object obj) {
        return (obj instanceof Key) && j == ((Key) obj).m3372unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m3369equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m3370hashCodeimpl(long j) {
        return c8.a(j);
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m3371toStringimpl(long j) {
        return "Key code: " + j;
    }

    public boolean equals(Object obj) {
        return m3368equalsimpl(this.keyCode, obj);
    }

    public final long getKeyCode() {
        return this.keyCode;
    }

    public int hashCode() {
        return m3370hashCodeimpl(this.keyCode);
    }

    @NotNull
    public String toString() {
        return m3371toStringimpl(this.keyCode);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m3372unboximpl() {
        return this.keyCode;
    }
}
