package edu.matc.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "food_user")
public class User {
    @Column(name = "access_privileges")
    private String accessPrivileges;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "user_weight")
    private int userWeight;

    @Column(name = "birthDate")
    private String birthDate;

    // Every Entity must have a unique identifier which is annotated @Id
    // Notice there is no @Column here as the column and instance variable name are the same
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int id;

    public User() {}

    public User(String accessPrivileges,String firstName, String lastName, String email, int userWeight, String birthDate) {
        this.accessPrivileges = accessPrivileges;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userWeight = userWeight;
        this.birthDate = birthDate;
    }

    /**
     * Gets user's access privileges
     * @return the access privileges of user
     */
    public String getAccessPrivileges() {return accessPrivileges;};

    /**
     * Set user's access privileges
     *
     * @param accessPrivileges user access privileges
     */
    public void setAccessPrivileges(String accessPrivileges) {this.accessPrivileges = accessPrivileges;};

    /**
     * Gets the user's first name
     *
     * @return user's first name
     */
    public String getFirstName() {return firstName;};

    /**
     * Sets the user's first name
     *
     * @param firstName user's first name
     */
    public void setFirstName(String firstName) {this.firstName = firstName;};

    /**
     * Get the user's last name
     *
     * @return user's last name
     */
    public String getLastName() {return lastName;};

    /**
     * Sets the user's last name
     * @param lastName user's last name
     */
    public void setLastName(String lastName) {this.lastName = lastName;};

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
     * Gets the user's weight
     *
     * @return user's weight
     */
    public int getUserWeight() {return userWeight;};

    /**
     * Sets the user's weight
     *
     * @param userWeight user's weight
     */
    public void setUserWeight(int userWeight) {this.userWeight = userWeight;};

    /**
     * Gets the user's birthdate
     * @return user's birthdate
     */
    public String getBirthDate() {return birthDate;};

    /**
     * Sets the user's birthdate
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
     * @param id user's id
     */
    public void setId(int id) {this.id = id;};

}
