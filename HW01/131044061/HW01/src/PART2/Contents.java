package PART2;

import java.applet.AudioClip;
import java.awt.*;
import java.util.ArrayList;

public class Contents implements WebSite {

    private ArrayList<User> subscribers;
    private Photos photos;
    private Texts texts;
    private Audios audios;

    @Override
    public void registerUser() {

    }

    @Override
    public void removeUser() {

    }

    @Override
    public void notifyUsers() {

    }

    public ArrayList<User> getSubscribers() {
        return subscribers;
    }

    private ArrayList<ContentTypes> contentsChanged(){
        return null;
    }

    private boolean changedTexts(Texts texts1, Texts texts2){
        return false;
    }

    private  boolean changedPhotos(Photos photos1, Photos photos2){
        return false;
    }

    private boolean changedAudios(Audios audios1, Audios audios2){
        return false;
    }

    public void setAudios(Audios audios) {
        this.audios = audios;
    }

    public void setPhotos(Photos photos) {
        this.photos = photos;
    }

    public void setTexts(Texts texts) {
        this.texts = texts;
    }

    public void setSubscribers(ArrayList<User> subscribers) {
        this.subscribers = subscribers;
    }

    protected static class Texts{
        private final ContentTypes contentType = ContentTypes.TEXTS;
        private ArrayList<String> texts;
        protected void setTxt(ArrayList<String> texts) {
            this.texts = texts;
        }
        protected ArrayList<String> getTexts() {
            return texts;
        }
    }

    protected static class Photos {
        private final ContentTypes contentType = ContentTypes.PHOTOS;
        private ArrayList<Image> photos;
        protected void setPhotos(ArrayList<Image> photos) {
            this.photos = photos;
        }
        protected ArrayList<Image> getPhotos() {
            return photos;
        }
    }

    protected static class Audios{
        private final ContentTypes contentType = ContentTypes.AUDIOS;
        private ArrayList<AudioClip> audios;
        protected void setAudios(ArrayList<AudioClip> audios) {
            this.audios = audios;
        }
        protected ArrayList<AudioClip> getAudios() {
            return audios;
        }
    }
}
