package org.tablet.persistence.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Numele nu poate fi lăsat gol!")
    private String name;

    @NotBlank(message = "Adresa de email este obligatorie!")
    @Email(message = "Te rog să introduci o adresă de email validă (ex: nume@domeniu.com)!")
    @Column(unique = true)
    private String email;

    @NotBlank(message = "Parola este obligatorie!")
    @Size(min = 8, message = "Parola trebuie să conțină cel puțin 8 caractere pentru siguranță!")
    private String password;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}