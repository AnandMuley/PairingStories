<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="en">
<%@ include file="common/Header.jsp" %>
<link href="internal/css/stories.css" rel="stylesheet">
<body>
    <div class="site-wrapper">
          <div class="site-wrapper-inner">
            <div class="cover-container">
              <%@ include file="common/NavBar.jsp" %>

              <!-- STORY LOADED HERE -->
              <c:if test="${story.completed == true}">
                <div class="story">
                    <div class="success-message">Congratulations ! You have completed the story</div>
                </div>
              </c:if>
              <c:if test="${story.completed == false}">
                  <div class="story">
                    <h3>${story.name}</h3>
                    <form action="stories" method="POST">
                        <c:if test="${story.errorMessage != null}">
                            <div class="row">
                                <div class="alert alert-danger alert-dismissible show" style="margin-left:2%;" role="alert">
                                    <strong>${story.errorMessage}
                                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                      <span aria-hidden="true">&times;</span>
                                    </button>
                                    <strong>
                                </div>
                            </div>
                        </c:if>
                        <div class="row">

                            <div class="col-md-4">
                                <input class="form-control" value="patrikrocks" type="password" name="reviewer" placeholder="Reviewer Code"/>
                            </div>
                            <div class="col-md-4">
                                <button class="btn btn-primary" type="submit">Reviewed</button>
                            </div>
                        </div>
                    </form>
                    <div class="story-description">${story.description}</div>
                    <c:forEach items="${story.iterations}" var="iteration">
                        <div class="row story-iteration">
                            <div class="col-md-12 heading">
                                <h4>Story : ${iteration.serialNo}</h4>
                            </div>
                            <div class="col-md-12 content">
                                <p>${iteration.content}</p>
                            </div>
                        </div>
                    </c:forEach>
                  </div>
              </c:if>
              <%@ include file="common/Footer.jsp" %>
            </div>
          </div>
    </div>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="external/jquery/dist/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="external/bootstrap/dist/js/bootstrap.min.js"></script>
</body>
</html>
