package courts.dto.roles;

import javax.validation.constraints.*;
import java.util.Set;

public class SignUpForm {
    @NotBlank(message = "Name ie required")
    @Size(min = 3, max = 50)
    private String name;

    @NotBlank(message = "User name ie required")
    @Size(min = 3, max = 50)
    private String username;

    @NotBlank(message = "Email name ie required")
    @Size(max = 60, message = "Max email size is 60")
    @Email
    private String email;

    private Set<String> role;

    @NotBlank
    @Size(min = 6, max = 40)
    //@Pattern(regexp ="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$",message="not valid password")
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getRole() {
        return this.role;
    }

    public void setRole(Set<String> role) {
        this.role = role;
    }
}
