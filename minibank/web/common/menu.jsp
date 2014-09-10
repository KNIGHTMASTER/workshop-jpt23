<%@ include file="/common/taglibs.jsp"%>

<menu:useMenuDisplayer name="Velocity"
	config="WEB-INF/classes/cssHorizontalMenu.vm"
	permissions="rolesAdapter">
	<ul id="primary-nav" class="menuList">
		<li class="pad">&nbsp;</li>
		<c:if test="${empty pageContext.request.remoteUser}">
			<li><a href="<c:url value="/login.jsp"/>" class="current"><fmt:message key="login.title" /></a></li>
		</c:if>
		<menu:displayMenu name="MainMenu" />
		<menu:displayMenu name="UserMenu" />
		<menu:displayMenu name="AdminMenu">
			<menu:displayMenu name="Account" />
			<menu:displayMenu name="Product" />
			<menu:displayMenu name="CIF" />	
			<menu:displayMenu name="Transactions" />		
		</menu:displayMenu>
		<menu:displayMenu name="CustomerMenu" />
		<menu:displayMenu name="Logout" />
	</ul>
</menu:useMenuDisplayer>
