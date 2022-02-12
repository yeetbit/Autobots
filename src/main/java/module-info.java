module dev.obit.watchdog {
    requires javafx.controls;
    requires javafx.fxml;
	requires org.jsoup;
	requires org.slf4j;

    opens dev.obit.watchdog.view to javafx.fxml;
    exports dev.obit.watchdog;
}
