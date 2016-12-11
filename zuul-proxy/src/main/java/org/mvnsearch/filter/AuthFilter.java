package org.mvnsearch.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UrlPathHelper;

/**
 * auth zuul filter
 *
 * @author linux_china
 */
@Component
public class AuthFilter extends ZuulFilter {
    private UrlPathHelper urlPathHelper = new UrlPathHelper();

    public String filterType() {
        return "pre";
    }

    public int filterOrder() {
        return 1;
    }

    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        final String requestURI = this.urlPathHelper.getPathWithinApplication(ctx.getRequest());
        return true;
    }

    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        final String requestURI = this.urlPathHelper.getPathWithinApplication(ctx.getRequest());
        String account = ctx.getRequest().getHeader("Token");
        ctx.addZuulRequestHeader("AccountId", "xxx");
        return null;
    }

    /**
     * Reports an error message given a response body and code.
     *
     * @param body http bodybody
     * @param code http status code
     */
    private void setFailedRequest(String body, int code) {
        RequestContext ctx = RequestContext.getCurrentContext();
        ctx.setResponseStatusCode(code);
        if (ctx.getResponseBody() == null) {
            ctx.setResponseBody(body);
        }
        ctx.setSendZuulResponse(false);
    }
}
