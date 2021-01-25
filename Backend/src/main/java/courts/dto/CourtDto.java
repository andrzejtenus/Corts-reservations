package courts.dto;

import courts.models.Court;

import javax.validation.constraints.NotNull;

public class CourtDto {

    private java.lang.Integer id;

    private char[] label;
    @NotNull(message = "Center id required")
    private java.lang.Integer centerid;

    @NotNull(message = "Active is required")
    private java.lang.Boolean active;

    public char[] getLabel() {
        return label;
    }

    public Boolean getActive() {
        return active;
    }   

    public Integer getCenterid() {
        return centerid;
    }

    public Integer getId() { return id; }

    public CourtDto() {
    }

    public CourtDto(Court model) {
        this.id = model.getId();
        this.label = model.getLabel();
        this.centerid = model.getCenter().getId();
        this.active = model.getActive();
    }
}
