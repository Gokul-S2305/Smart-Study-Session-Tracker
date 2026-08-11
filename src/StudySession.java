public class StudySession {

    private String subject;
    private int duration;
    private int focusLevel;
    private String notes;

    public StudySession(String subject, int duration, int focusLevel, String notes) {
        this.subject = subject;
        this.duration = duration;
        this.focusLevel = focusLevel;
        this.notes = notes;
    }

    public String getSubject() {
        return subject;
    }

    public int getDuration() {
        return duration;
    }

    public int getFocusLevel() {
        return focusLevel;
    }

    public String getNotes() {
        return notes;
    }
}