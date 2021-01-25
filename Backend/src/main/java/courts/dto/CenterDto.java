package courts.dto;

import courts.models.Center;

import javax.validation.constraints.NotNull;

public class CenterDto {

    @NotNull(message = "Name can not be empty")
    private char[] name;

    @NotNull(message = "Active can not be empty")
    private java.lang.Boolean active;


    public char[] getName() {
        return name;
    }

    public Boolean getActive() {
        return active;
    }

    public CenterDto() {
    }

    public CenterDto(Center model) {
        this.name = model.getName();
        this.active = model.getActive();
    }
}
