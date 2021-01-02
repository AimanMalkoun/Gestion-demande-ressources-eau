package Classes;

import java.time.LocalDate;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.util.Callback;

public class CostumDatePicker extends DatePicker {

    public CostumDatePicker(LocalDate startingDate){
        final Callback<DatePicker, DateCell> dayCellFactory =
                new Callback<DatePicker, DateCell>() {
                    @Override
                    public DateCell call(final DatePicker datePicker) {
                        return new DateCell() {
                            @Override
                            public void updateItem(LocalDate item, boolean empty) {
                                super.updateItem(item, empty);

                                if (item.isBefore(startingDate)) {
                                    setDisable(true);
                                }
                            }
                        };
                    }
                };
        this.setDayCellFactory(dayCellFactory);
    }

}
