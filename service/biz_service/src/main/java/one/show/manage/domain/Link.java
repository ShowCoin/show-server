package one.show.manage.domain;

/**
 * Created by Haliaeetus leucocephalus on 18/1/19.
 */
public class Link {
    private String title;
    private String image;
    private String link;
    private int time;
    private long id;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Link link = (Link) o;

        if (time != link.time) return false;
        if (id != link.id) return false;
        if (title != null ? !title.equals(link.title) : link.title != null) return false;
        if (image != null ? !image.equals(link.image) : link.image != null) return false;
        if (this.link != null ? !this.link.equals(link.link) : link.link != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (image != null ? image.hashCode() : 0);
        result = 31 * result + (link != null ? link.hashCode() : 0);
        result = 31 * result + time;
        result = 31 * result + (int) (id ^ (id >>> 32));
        return result;
    }
}
