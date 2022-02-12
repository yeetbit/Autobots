module dev.obit.watchdog {
    requires javafx.controls;
    requires javafx.fxml;

    opens dev.obit.watchdog.view to javafx.fxml;
    exports dev.obit.watchdog;
}
