<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
 
<html>
<head>
<title>${title}</title>
</head>
<body>
 <jsp:include page="/WEB-INF/pages/layout/header.jsp" />
 
    <h2>Admin Page</h2>
 
 
    <h3>Welcome : ${pageContext.request.userPrincipal.name}</h3>
 
    <b>This is protected page!</b>
    <jsp:include page="/WEB-INF/pages/layout/footer.jsp" />  
</body>
</html>