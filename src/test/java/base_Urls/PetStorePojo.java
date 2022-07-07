package base_Urls;

import java.util.List;
import java.util.Map;

public class PetStorePojo {

    private int id;
    private Map<String,Object> category;
    private String name;
    private List<String> photoUrls;
    private List<Map<String,Object>> tags;
    private String status;

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public Map<String, Object> getCategory() {return category;}
    public void setCategory(Map<String, Object> category) {this.category = category;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(List<String> photoUrls) {
        this.photoUrls = photoUrls;
    }

    public List<Map<String, Object>> getTags() {
        return tags;
    }

    public void setTags(List<Map<String, Object>> tags) {
        this.tags = tags;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PetStorePojo{" +
                "id=" + id +
                ", category=" + category +
                ", name='" + name + '\'' +
                ", photoUrls=" + photoUrls +
                ", tags=" + tags +
                ", status='" + status + '\'' +
                '}';
    }
}
