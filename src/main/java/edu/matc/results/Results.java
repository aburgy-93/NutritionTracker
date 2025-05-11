package edu.matc.results;

/**
 * The type Results.
 */
public class Results {
    private String username;
    private String email;
    private String sub;
    private String birthdate;

    /**
     * Instantiates a new Results.
     */
    public Results() {}

    /**
     * Instantiates a new Results.
     *
     * @param username  the username
     * @param email     the email
     * @param sub       the sub
     * @param birthdate the birthdate
     */
    public Results(String username, String email, String sub, String birthdate) {
        this.username = username;
        this.email = email;
        this.sub = sub;
        this.birthdate = birthdate;
    }

    /**
     * Gets username.
     *
     * @return the username
     */
    public String getUsername() {return username;}

    /**
     * Sets username.
     *
     * @param username the username
     */
    public void setUsername(String username) {this.username = username;}

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {return email;}

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {this.email = email;}

    /**
     * Gets sub.
     *
     * @return the sub
     */
    public String getSub() {return sub;}

    /**
     * Sets sub.
     *
     * @param sub the sub
     */
    public void setSub(String sub) {this.sub = sub;}

    /**
     * Gets birthdate.
     *
     * @return the birthdate
     */
    public String getBirthdate() {return birthdate;}

    /**
     * Sets birthdate.
     *
     * @param birthdate the birthdate
     */
    public void setBirthdate(String birthdate) {this.birthdate = birthdate;}

    @Override
    public String toString() {
        return "Results [username=" + username + ", email=" + email + ", sub=" + sub + "]";
    }
}
