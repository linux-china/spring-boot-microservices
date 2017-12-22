package org.mvnsearch.app4.domain.infra;

import feign.RequestLine;

/**
 * httpbin feign api
 *
 * @author linux_china
 */
public interface HttpBinServiceFeignAPI {

    @RequestLine("GET /ip")
    HttpBinResponse ip();

}
