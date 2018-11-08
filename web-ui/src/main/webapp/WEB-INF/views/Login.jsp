<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<%@ include file="common/Header.jsp" %>
<link href="internal/css/login.css" rel="stylesheet">
<body>
    <div class="site-wrapper">
          <div class="site-wrapper-inner">
            <div class="cover-container">
              <form class="form-signin" action="login" method="POST">
                <img class="mb-4" src="https://getbootstrap.com/assets/brand/bootstrap-solid.svg" alt="" width="72" height="72">
                <h1 class="h3 mb-3 font-weight-normal">Pairing Stories</h1>

                <input type="text" name="name" value="Anand Muley" id="input-name" class="form-control" placeholder="Name" required="" autofocus="">

                <input type="email" name="emailId" value="muley.anand66@gmail.com" id="input-email" class="form-control" placeholder="Email address" required="" autofocus="">

                <input type="tel" maxlength="10" value="8888888888" name="contactNo" id="input-contact-no" class="form-control" placeholder="Contact No" required="" autofocus="">

                <select id="input-years-of-experience" name="experience" class="form-control" required>
                    <option value="-1">Years Of Experience</option>
                    <option value="3" selected>Upto 3 yrs</option>
                    <option value="5">Between 3 yrs to 5 yrs</option>
                    <option value="10">More than 5 yrs</option>
                </select>
                <!--<div class="checkbox mb-3">
                  <label>
                    <input type="checkbox" value="remember-me"> Remember me
                  </label>
                </div>-->
                <br/>
                <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
                <!--<p class="mt-5 mb-3 text-muted">© 2017-2018</p>-->
              </form>
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
