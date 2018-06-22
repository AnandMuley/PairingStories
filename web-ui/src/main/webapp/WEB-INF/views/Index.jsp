<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="en">
<%@ include file="Header.jsp" %>
<body>
    <div class="site-wrapper">
          <div class="site-wrapper-inner">
            <div class="cover-container">
              <%@ include file="NavBar.jsp" %>
              <%@ include file="IndexBody.jsp" %>
              <%@ include file="Footer.jsp" %>
            </div>
          </div>
        </div>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="external/jquery/dist/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="external/bootstrap/dist/js/bootstrap.min.js"></script>
</body>
</html>
