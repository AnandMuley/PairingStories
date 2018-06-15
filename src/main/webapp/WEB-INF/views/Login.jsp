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
                <label for="inputEmail" class="sr-only">Email address</label>
                <input type="email" name="emailId" id="inputEmail" class="form-control" placeholder="Email address" required="" autofocus="">
                <label for="inputPassword" class="sr-only">Password</label>
                <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Password" required="">
                <label for="input-years-of-experience" class="sr-only">Password</label>
                <select id="input-years-of-experience" name="yearsOfExperience" class="form-control" required="">
                    <option>Years Of Experience</option>
                    <option value="3">Upto 3 yrs</option>
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
              <!--<%@ include file="common/Footer.jsp" %>-->
            </div>
          </div>
        </div>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="external/jquery/dist/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="external/bootstrap/dist/js/bootstrap.min.js"></script>
</body>
</html>
