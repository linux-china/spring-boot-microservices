package org.mvnsearch.app4.domain.infra;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

/**
 * http bin response
 *
 * @author linux_china
 */
@Data
public class HttpBinResponse {
    private String uuid;
    @JsonProperty(value = "origin")
    private String ip;
    private Map<String, String> headers;
}
