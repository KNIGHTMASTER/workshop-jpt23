<%@ include file="/common/taglibs.jsp" %>

    <div id="divider"><div></div></div>
    <span class="left">Version 1.9.4 |
        <span id="validators">
            <a href="http://validator.w3.org/check?uri=referer">XHTML Valid</a> |
            <a href="http://jigsaw.w3.org/css-validator/validator-uri.html">CSS Valid</a>
        </span>
        <c:if test="${pageContext.request.remoteUser != null}">
        | <fmt:message key="user.status"/> <authz:authentication operation="fullName"/>
        </c:if>
    </span>
    <span class="right">
        &copy; 2014 <a href="http://www.raibledesigns.com">Your Company Here</a>
    </span>
    <!-- Built on Wednesday Apr 30, 2014 at 09:00 PM ICT by Administrator -->
