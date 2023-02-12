module graalvm.sandbox {

    requires javafx.base;
    requires javafx.controls;
    requires javafx.graphics;

    opens assets.fonts;

    exports me.soknight.graalvm.sandbox to javafx.graphics;

}