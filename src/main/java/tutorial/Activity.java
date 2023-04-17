package tutorial;

public class Activity {
    private String title;
    private String dueDate;
    private Boolean completed;

    public Activity() {
    }

    public Activity(String title, String dueDate, Boolean completed) {
        this.title = title;
        this.dueDate = dueDate;
        this.completed = completed;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDueDate() {
        return this.dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public Boolean isCompleted() {
        return this.completed;
    }

    public Boolean getCompleted() {
        return this.completed;
    }

    @Override
    public String toString() {
        return "{" +
                " title='" + getTitle() + "'" +
                ", dueDate='" + getDueDate() + "'" +
                ", completed='" + isCompleted() + "'" +
                "}";
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

}
