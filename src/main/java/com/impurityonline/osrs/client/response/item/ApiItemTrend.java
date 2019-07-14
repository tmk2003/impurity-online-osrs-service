package com.impurityonline.osrs.client.response.item;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author impurity
 */
@Data
public class ApiItemTrend {
    @JsonProperty("trend")
    private String trend;
    @JsonProperty("change")
    private String change;
}