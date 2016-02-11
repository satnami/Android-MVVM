package satnami.com.mvvm.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "url",
        "forks_url",
        "commits_url",
        "id",
        "git_pull_url",
        "git_push_url",
        "html_url",
        "public",
        "created_at",
        "updated_at",
        "description",
        "comments",
        "user",
        "comments_url",
        "owner",
        "truncated"
})
public class Gist {

    @JsonProperty("url")
    private String url;
    @JsonProperty("forks_url")
    private String forksUrl;
    @JsonProperty("commits_url")
    private String commitsUrl;
    @JsonProperty("id")
    private String id;
    @JsonProperty("git_pull_url")
    private String gitPullUrl;
    @JsonProperty("git_push_url")
    private String gitPushUrl;
    @JsonProperty("html_url")
    private String htmlUrl;
    @JsonProperty("public")
    private Boolean _public;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("updated_at")
    private String updatedAt;
    @JsonProperty("description")
    private String description;
    @JsonProperty("comments")
    private Integer comments;
    @JsonProperty("user")
    private Object user;
    @JsonProperty("comments_url")
    private String commentsUrl;
    @JsonProperty("owner")
    private Owner owner;
    @JsonProperty("truncated")
    private Boolean truncated;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The url
     */
    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    /**
     * @param url The url
     */
    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return The forksUrl
     */
    @JsonProperty("forks_url")
    public String getForksUrl() {
        return forksUrl;
    }

    /**
     * @param forksUrl The forks_url
     */
    @JsonProperty("forks_url")
    public void setForksUrl(String forksUrl) {
        this.forksUrl = forksUrl;
    }

    /**
     * @return The commitsUrl
     */
    @JsonProperty("commits_url")
    public String getCommitsUrl() {
        return commitsUrl;
    }

    /**
     * @param commitsUrl The commits_url
     */
    @JsonProperty("commits_url")
    public void setCommitsUrl(String commitsUrl) {
        this.commitsUrl = commitsUrl;
    }

    /**
     * @return The id
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * @param id The id
     */
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return The gitPullUrl
     */
    @JsonProperty("git_pull_url")
    public String getGitPullUrl() {
        return gitPullUrl;
    }

    /**
     * @param gitPullUrl The git_pull_url
     */
    @JsonProperty("git_pull_url")
    public void setGitPullUrl(String gitPullUrl) {
        this.gitPullUrl = gitPullUrl;
    }

    /**
     * @return The gitPushUrl
     */
    @JsonProperty("git_push_url")
    public String getGitPushUrl() {
        return gitPushUrl;
    }

    /**
     * @param gitPushUrl The git_push_url
     */
    @JsonProperty("git_push_url")
    public void setGitPushUrl(String gitPushUrl) {
        this.gitPushUrl = gitPushUrl;
    }

    /**
     * @return The htmlUrl
     */
    @JsonProperty("html_url")
    public String getHtmlUrl() {
        return htmlUrl;
    }

    /**
     * @param htmlUrl The html_url
     */
    @JsonProperty("html_url")
    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    /**
     * @return The _public
     */
    @JsonProperty("public")
    public Boolean getPublic() {
        return _public;
    }

    /**
     * @param _public The public
     */
    @JsonProperty("public")
    public void setPublic(Boolean _public) {
        this._public = _public;
    }

    /**
     * @return The createdAt
     */
    @JsonProperty("created_at")
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * @param createdAt The created_at
     */
    @JsonProperty("created_at")
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * @return The updatedAt
     */
    @JsonProperty("updated_at")
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     * @param updatedAt The updated_at
     */
    @JsonProperty("updated_at")
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * @return The description
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * @param description The description
     */
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return The comments
     */
    @JsonProperty("comments")
    public Integer getComments() {
        return comments;
    }

    /**
     * @param comments The comments
     */
    @JsonProperty("comments")
    public void setComments(Integer comments) {
        this.comments = comments;
    }

    /**
     * @return The user
     */
    @JsonProperty("user")
    public Object getUser() {
        return user;
    }

    /**
     * @param user The user
     */
    @JsonProperty("user")
    public void setUser(Object user) {
        this.user = user;
    }

    /**
     * @return The commentsUrl
     */
    @JsonProperty("comments_url")
    public String getCommentsUrl() {
        return commentsUrl;
    }

    /**
     * @param commentsUrl The comments_url
     */
    @JsonProperty("comments_url")
    public void setCommentsUrl(String commentsUrl) {
        this.commentsUrl = commentsUrl;
    }

    /**
     * @return The owner
     */
    @JsonProperty("owner")
    public Owner getOwner() {
        return owner;
    }

    /**
     * @param owner The owner
     */
    @JsonProperty("owner")
    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    /**
     * @return The truncated
     */
    @JsonProperty("truncated")
    public Boolean getTruncated() {
        return truncated;
    }

    /**
     * @param truncated The truncated
     */
    @JsonProperty("truncated")
    public void setTruncated(Boolean truncated) {
        this.truncated = truncated;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
