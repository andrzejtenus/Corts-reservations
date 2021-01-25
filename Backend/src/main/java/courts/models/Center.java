package courts.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import courts.dto.CenterDto;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Centers")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class Center {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private java.lang.Integer id;

    private char[] name;

    @NonNull
    @Column(nullable = false)
    private java.lang.Boolean active;

    @JsonIgnore
    //@OneToMany(mappedBy = "center", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @OneToMany(mappedBy = "center", cascade = CascadeType.ALL)
    private List<Court> items = new ArrayList<Court>();


    public Center() {
    }

    public Center(CenterDto model) {
        this.name = model.getName();
        this.active = model.getActive();
    }

    public char[] getName() {
        return name;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean getActive() {
        return active;
    }

    public Integer getId() {
        return id;
    }


}
