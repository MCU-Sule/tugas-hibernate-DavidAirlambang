module com.uts.uts_2072046 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires jasperreports;
    requires java.persistence;
    requires org.hibernate.orm.core;
    requires java.naming;


    opens com.uts.uts_2072046_Immanuel to javafx.fxml;
    opens com.uts.uts_2072046_Immanuel.controller to javafx.fxml;
    opens com.uts.uts_2072046_Immanuel.dao to javafx.fxml;
    opens com.uts.uts_2072046_Immanuel.entity to javafx.fxml, org.hibernate.orm.core;
    opens com.uts.uts_2072046_Immanuel.util to javafx.fxml;
    exports com.uts.uts_2072046_Immanuel;
    exports com.uts.uts_2072046_Immanuel.controller;
    exports com.uts.uts_2072046_Immanuel.dao;
    exports com.uts.uts_2072046_Immanuel.util;
    exports com.uts.uts_2072046_Immanuel.entity;
}