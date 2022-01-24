module Autobots {
	requires javafx.controls;
	requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.web;
    requires javafx.base;
    requires javafx.media;
    requires java.desktop;

    opens dev.obit.tools.autobots;
    opens dev.obit.tools.autobots.model;
    opens dev.obit.tools.autobots.view;
    opens dev.obit.tools.autobots.view.style;
    opens dev.obit.tools.autobots.controller;
  
}
