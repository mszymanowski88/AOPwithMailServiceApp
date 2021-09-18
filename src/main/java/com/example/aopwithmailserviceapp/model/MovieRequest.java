
package com.example.aopwithmailserviceapp.model;

import com.fasterxml.jackson.annotation.*;
import org.aspectj.lang.annotation.Aspect;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "page",
    "results",
    "total_pages",
    "total_results"
})
@Generated("jsonschema2pojo")
@Aspect
public class MovieRequest {

    @JsonProperty("page")
    private Integer page;
    @JsonProperty("results")
    private List<RequestResult> requestResults = null;
    @JsonProperty("total_pages")
    private Integer totalPages;
    @JsonProperty("total_results")
    private Integer totalResults;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("page")
    public Integer getPage() {
        return page;
    }

    @JsonProperty("page")
    public void setPage(Integer page) {
        this.page = page;
    }

    @JsonProperty("results")
    public List<RequestResult> getResults() {
        return requestResults;
    }

    @JsonProperty("results")
    public void setResults(List<RequestResult> requestResults) {
        this.requestResults = requestResults;
    }

    @JsonProperty("total_pages")
    public Integer getTotalPages() {
        return totalPages;
    }

    @JsonProperty("total_pages")
    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    @JsonProperty("total_results")
    public Integer getTotalResults() {
        return totalResults;
    }

    @JsonProperty("total_results")
    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "MovieRequest{" +
                ", results=" + requestResults +
                '}';
    }
}
