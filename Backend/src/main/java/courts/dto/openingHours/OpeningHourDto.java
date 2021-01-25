package courts.dto.openingHours;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Time;

public class OpeningHourDto {

    private java.lang.Integer day;
    @NotNull(message = "Start can not be empty")
    private java.sql.Time start;
    @NotNull(message = "End can not be empty")
    private java.sql.Time end;
    @NotNull(message = "Open can not be empty")
    private java.lang.Boolean open;

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Time getStart() {
        return start;
    }

    public void setStart(Time start) {
        this.start = start;
    }

    public Time getEnd() {
        return end;
    }

    public void setEnd(Time end) {
        this.end = end;
    }

    public Boolean getOpen() {
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }

}
