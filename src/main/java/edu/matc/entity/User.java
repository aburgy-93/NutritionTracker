package edu.matc.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The type User.
 */
@Entity(name = "User")
@Table(name = "food_user")
public class User {
    // Every Entity must have a unique identifier which is annotated @Id
    // Notice there is no @Column here as the column and instance variable name are the same
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int id;

    @Column(name = "sub")
    private String sub;

    @Column(name = "access_privileges")
    private String accessPrivileges;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "birthDate")
    private String birthDate;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserFood> foodTracker = new ArrayList<>();

    /**
     * Instantiates a new User.
     */
    public User() {}

    /**
     * Instantiates a new User.
     *
     * @param accessPrivileges the access privileges
     * @param email            the email
     * @param birthDate        the birthdate
     */
    public User(String sub, String accessPrivileges, String username, String email, String birthDate) {
        this.sub = sub;
        this.accessPrivileges = accessPrivileges;
        this.username = username;
        this.email = email;
        this.birthDate = birthDate;
    }

    /**
     * Gets food tracker.
     *
     * @return the food tracker
     */
    public List<UserFood> getFoodTracker() {
        return foodTracker;
    }

    /**
     * Gets user's access privileges
     *
     * @return the access privileges of user
     */
    public String getAccessPrivileges() {return accessPrivileges;};

    /**
     * Set user's access privileges
     *
     * @param accessPrivileges user access privileges
     */
    public void setAccessPrivileges(String accessPrivileges) {this.accessPrivileges = accessPrivileges;};

    public String getSub() {return sub;}
    public void setSub(String sub) {this.sub = sub;};

    public String getUsername() {return username;};
    public void setUsername(String username) {this.username = username;};

    /**
     * Gets the user's email
     *
     * @return user's email
     */
    public String getEmail() {return email;};

    /**
     * Sets the user's email
     *
     * @param email user's email address
     */
    public void setEmail(String email) {this.email = email;};

    /**
     * Gets the user's birthdate
     *
     * @return user 's birthdate
     */
    public String getBirthDate() {return birthDate;};

    /**
     * Sets the user's birthdate
     *
     * @param birthDate user's birthdate
     */
    public void setBirthDate(String birthDate) {this.birthDate = birthDate;};

    /**
     * Get user's ID
     *
     * @return the id
     */
    public int getId() {return id;};

    /**
     * Sets the ID of the user
     *
     * @param id user's id
     */
    public void setId(int id) {this.id = id;};

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", accessPrivileges='" + accessPrivileges + '\'' +
                ", email='" + email + '\'' +
                ", birthDate='" + birthDate + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(accessPrivileges, user.accessPrivileges) && Objects.equals(email, user.email) && Objects.equals(birthDate, user.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sub, accessPrivileges, username ,email, birthDate, id);
    }
}


