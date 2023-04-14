package pages;

import java.util.List;

public class createProjectPojos {
    private String id;
    private String created;
    private String lastModified;
    private String userId;
    private String workspaceId;
    private String name;
    private String description;
    private String type;
    private List<String> tags;

    // Default constructor
    public createProjectPojos() {}

    // Getters and Setters
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getCreated() {
        return created;
    }
    public void setCreated(String created) {
        this.created = created;
    }
    public String getLastModified() {
        return lastModified;
    }
    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getWorkspaceId() {
        return workspaceId;
    }
    public void setWorkspaceId(String workspaceId) {
        this.workspaceId = workspaceId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public List<String> getTags() {
        return tags;
    }
    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}