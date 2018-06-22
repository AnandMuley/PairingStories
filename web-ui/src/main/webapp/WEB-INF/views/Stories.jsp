<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<%@ include file="common/Header.jsp" %>
<link href="internal/css/stories.css" rel="stylesheet">
<body>
    <div class="site-wrapper">
          <div class="site-wrapper-inner">
            <div class="cover-container">
              <%@ include file="common/NavBar.jsp" %>
              <div class="story">
                <h3>${story.name}</h3>

                <p class="story-description">${story.description}</p>
                <form action="stories" method="POST">
                    <div class="row">
                        <div class="col-md-4">
                            <h4>Story : ${story.currentIteration.serialNo}</h4>
                        </div>
                        <div class="col-md-4">
                            <input class="form-control" name="reviewer" placeholder="Reviewer Name"/>
                        </div>
                        <div class="col-md-4">
                            <button class="btn btn-primary" type="submit">SAVE</button>
                        </div>
                    </div>
                </form>

                <p>${story.currentIteration.content}</p>
              </div>
            </div>
          </div>
    </div>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="external/jquery/dist/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="external/bootstrap/dist/js/bootstrap.min.js"></script>
</body>
</html>
