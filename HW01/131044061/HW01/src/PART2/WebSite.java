package PART2;

public interface WebSite {
    void registerUser();
    void removeUser();
    void notifyUsers();
    enum ContentTypes{
        TEXTS, PHOTOS, AUDIOS
    }
}
