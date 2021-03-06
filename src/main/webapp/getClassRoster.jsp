<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="com.blackboard.developer.apisample.api.B2ApiSample,
				 com.blackboard.developer.apisample.impl.B2ApiSampleImpl,
				 blackboard.platform.context.*,
				 blackboard.data.course.*,
				 blackboard.data.user.*,
				 java.util.*" %>

<%@ taglib uri="/bbNG" prefix="bbNG" %>

<bbNG:genericPage title="Get Class Roster">
	<bbNG:pageHeader>
		<bbNG:breadcrumbBar>
			<bbNG:breadcrumb>Class Roster</bbNG:breadcrumb>
		</bbNG:breadcrumbBar>
		<bbNG:pageTitleBar>Class Roster</bbNG:pageTitleBar>
	</bbNG:pageHeader>
	
	<%
	try {
		Context ctx = ContextManagerFactory.getInstance().getContext();
		B2ApiSample apiSample = new B2ApiSampleImpl();
		Course course = ctx.getCourse();
		
		%>
		<h2>Roster for Course <%=course.getDisplayTitle()%></h2><br />
		<%
		List<User> roster = apiSample.getRosterByCourseId(course.getId());
		ListIterator<User> rosterIt = roster.listIterator();
		
		while(rosterIt.hasNext()) {
			User user = rosterIt.next();
			String fullname = user.getGivenName() + " " + user.getFamilyName();
			String email = user.getEmailAddress();
			String username = user.getUserName();
			String id = user.getId().toExternalString();
			String buid = user.getBatchUid();
			
			%>
			<h2><%=fullname%></h2><br />
			Email: <%=email%><br />
			Username: <%=username%><br />
			User Id: <%=id%><br />
			BatchUid: <%=buid%><br /><br />
			
			<%
		}
	} catch (Exception e) {
		%><%=e.getMessage() %><%
	}
	%>
</bbNG:genericPage>