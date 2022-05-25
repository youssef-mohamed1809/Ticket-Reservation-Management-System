module com.ticketreservationmanagementsystemgui {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.ticketreservationmanagementsystemgui to javafx.fxml;
    exports com.ticketreservationmanagementsystemgui;
}