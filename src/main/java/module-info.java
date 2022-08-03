module com.setokk.hourschedulinggui {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens com.setokk.hourschedulinggui to javafx.fxml;
    exports com.setokk.hourschedulinggui;

    opens com.setokk.hourschedulinggui.guicontrollers to javafx.fxml;
    exports com.setokk.hourschedulinggui.guicontrollers;
}