package com.gateway.zuul.filter;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class PreFilter extends ZuulFilter {

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext context = RequestContext.getCurrentContext();
		HttpServletRequest request = context.getRequest();
			System.out.println("Pre filter Endpoints >>> "+request.getMethod()+" , "+request.getRequestURL());
			if(request.getAttribute("AUTH_HEADER")==null) {
				String sessionId = UUID.randomUUID().toString();
				context.addZuulRequestHeader("AUTH_HEADER", sessionId);
			}
		return null;
	}

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

}
