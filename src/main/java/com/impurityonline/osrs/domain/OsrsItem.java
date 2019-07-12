package com.impurityonline.osrs.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author impurity
 */
@Data
@ApiModel(value="Api Error", description="Response for an error that has arisen")
public class OsrsItem {
    @JsonProperty("name")
    private String name;
    @JsonProperty("id")
    private String id;
    @JsonProperty("description")
    private String description;
    @JsonProperty("type")
    private String type;
    @JsonProperty("typeIcon")
    private String typeIcon;
    @JsonProperty("icon")
    private String icon;
    @JsonProperty("icon_large")
    private String iconLarge;
    @JsonProperty("members")
    private Boolean members;
    @JsonProperty("current")
    private OsrsItemPrice current;
    @JsonProperty("today")
    private OsrsItemPrice today;
    @JsonProperty("day30")
    private OsrsItemTrend day30;
    @JsonProperty("day90")
    private OsrsItemTrend day90;
    @JsonProperty("day180")
    private OsrsItemTrend day180;
}
