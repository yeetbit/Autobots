module dev.obit.watchdog {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires javafx.graphics;
	requires org.slf4j;
	requires org.jsoup;

	opens dev.obit.watchdog to javafx.fxml;
	exports dev.obit.watchdog;
    

}
