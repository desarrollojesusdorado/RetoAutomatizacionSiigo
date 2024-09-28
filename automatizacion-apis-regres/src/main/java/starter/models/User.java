package starter.models;

public class User {
    private String name;
    private String job;

    public User() {}

    public User(String name, String job) {
        this.name = name;
        this.job = job;
    }

    // Getters y setters
    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }
}
