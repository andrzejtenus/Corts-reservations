package courts.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import courts.dto.CourtDto;
import courts.models.reservation.Reservation;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Corts")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class Court {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private java.lang.Integer id;

    private char[] label;

    @ManyToOne
    @JoinColumn(name = "centerid", referencedColumnName = "id", nullable=false)
    private Center center;

    @NonNull
    @Column(nullable = false)
    private java.lang.Boolean active;

    @JsonIgnore
    @OneToMany(mappedBy = "cort", cascade = CascadeType.ALL)
    private List<Reservation> reservations = new ArrayList<Reservation>();

    public Court() {
    }

    public Court(CourtDto model, Center center) {
        this.label = model.getLabel();
        this.center = center;
        this.active = model.getActive();
    }

    public char[] getLabel() {
        return label;
    }

    public void setLabel(char[] label) {
        this.label = label;
    }

    public Integer getId() {
        return id;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Center getCenter() {
        return center;
    }

    public void setCenter(Center center) {
        this.center = center;
    }
}
