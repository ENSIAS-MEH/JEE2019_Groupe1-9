<%--
  Created by IntelliJ IDEA.
  User: AnassBairouk
  Date: 2019-01-12
  Time: 17:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en" prefix="og: http://ogp.me/ns#">
<!-- Added by HTTrack --><meta http-equiv="content-type" content="text/html;charset=UTF-8" /><!-- /Added by HTTrack -->
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no, maximum-scale=1.0" />
  <meta name="description" content="The best poll script that you will ever find on the internet. It comes packed with tones of awesome features. Give it a try!" />
  <meta property='og:type' content='website' />
  <meta property='og:url' content='https://ensias.com' />
  <meta property='og:title' content='ENSIAS' />
  <meta property='og:description' content='The best poll script that you will ever find on the internet. It comes packed with tones of awesome features. Give it a try!' />
  <title>ENSIAS</title>

  <link href="themes/default/css/bootstrap.min.css" rel="stylesheet">

  <link rel="stylesheet" type="text/css" href="themes/default/style.css">
  <link rel="stylesheet" type="text/css" href="themes/default/css/widgets.css">
  <link rel="stylesheet" type="text/css" href="static/js/flat/_all.css">
  <link rel="stylesheet" type="text/css" href="static/js/chosen.min.css">

  <script type="text/javascript" src="static/js/jquery.min707e.js?v=1.11.0"></script>
  <script type="text/javascript" src="static/js/chosen.minc118.js?v=0.8.5"></script>
  <script type="text/javascript" src="static/js/icheck.minf700.js?v=1.0.1"></script>
  <script type="text/javascript" src="static/js/jquery-ui.min1ff9.js?v=1.10.3"></script>
  <script type="text/javascript" src="static/bootstrap.min.js"></script>
  <script type="text/javascript" src="static/application.fnc619.js?v=1.0"></script>
  <script>
    var appurl="https://gempixel.com/polls";
    var token="703dbf82c57d85152e84d99365a0494a";
    var max_count= 10;
  </script>
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
  <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
<body>
<%
  //this one to  prevent the user from going back to the index.jsp after signing
  if (session.getAttribute("_current_user")!=null){
    response.sendRedirect("user/dashboard.jsp");
  }
%>
<header>
  <div class="navbar" role="navigation">
    <div class="container">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
          <span class="glyphicon glyphicon-list"></span>
        </button>
        <div class="site_logo">
          <a class="navbar-brand" href="https://ensias.com">Azerf Poll</a>
        </div>
      </div>
      <div class="navbar-collapse collapse">
        <ul class="nav navbar-nav pull-right">
          <li><a href="user/register.jsp" class="active">Get Started</a></li>
          <li><a href="user/login.jsp">Login</a></li>
        </ul>
      </div>
    </div>
  </div>
  <div class="container">
    <div class="row widget">
      <div class="col-md-8 promo">
        <h2>Simple. Beautiful. Modern.</h2>
        <p>Create beautifully designed polls in under a minute. Choose from a library of templates or customize your own template. With many types of customization, you will make the poll <strong>your</strong> poll. Create an account to unlock even more features.</p>
        <a href="user/create_poll.jsp" class="btn btn-transparent btn-lg">Preview</a>
      </div>
      <div class="col-md-4">
        <div class="box-holder">
          <h4>Login to your account</h4>
          <form method="get" action="user.login">
            <div class="form-group">
              <label for="email">Email address</label>
              <input type="email" class="form-control" id="email" placeholder="Enter email" name="email">
            </div>
            <div class="form-group">
              <label for="pass">Password</label>
              <input type="password" class="form-control" id="pass" placeholder="Password" name="password">
            </div>

            <p class="help-block">I forgot my password <a href="user/forgot.jsp" target="_blank">Get new one</a>.</p>
            <input type='hidden' name='token' value='de19285e346fe82d9d3d401f522d27e5833a1ecd' />
            <input type="hidden" name="terms" value="1">
            <button type="submit" class="btn btn-primary">Login</button>
          </form>
        </div>
      </div>
    </div>
  </div>
</header>
<section>
  <div class="calltoaction">
    <div class="container">
      <div class="row">
        <div class="col-md-6">
          <span>296</span> Polls were created and successfully delivered. </div>
        <div class="col-md-6">
          <span>1501</span> Users have answered questions. </div>
      </div>
    </div>
  </div>
  <div class="container">
    <div class="row promo">
      <div class="col-md-7">
        <h2 class="promo-heading">Full-Featured. <span class="text-muted">Seriously.</span></h2>
        <p class="lead">Our polls have many unique features that you will not find anywhere else. This allows you to create the most beautiful yet simple poll. Customize everything to make it your poll and say once and for all bye to those ugly polls.</p>
      </div>
      <div class="col-md-5 promo-icon">
        <div class="row">
          <div class="col-xs-4">
            <span class="glyphicon glyphicon-stats"></span>
            <p>Advanced Statistics</p>
          </div>
          <div class="col-xs-4">
            <span class="glyphicon glyphicon-lock"></span>
            <p>Password Protect</p>
          </div>
          <div class="col-xs-4">
            <span class="glyphicon glyphicon-eye-open"></span>
            <p>Customizable Polls</p>
          </div>
        </div>
      </div>
    </div>
    <div class="row promo">
      <div class="col-md-5 promo-icon">
        <div class="row">
          <div class="col-xs-4">
            <span class="glyphicon glyphicon-phone"></span>
            <p>Adaptive Design</p>
          </div>
          <div class="col-xs-4">
            <span class="glyphicon glyphicon-flash"></span>
            <p>Blazing-Fast Loading</p>
          </div>
          <div class="col-xs-4">
            <span class="glyphicon glyphicon-hd-video"></span>
            <p>Pixel-Perfect Themes</p>
          </div>
        </div>
      </div>
      <div class="col-md-7">
        <h2 class="promo-heading">Responsive. <span class="text-muted">Try it yourself.</span></h2>
        <p class="lead">Our polls are desgined to fit your design and all screens. Each theme will automatically adjust itself to the size of the screen of the user, regardless of the device. We've also made them to work with older browsers, giving you the peace of mind.</p>
      </div>
    </div>
    <div class="row promo">
      <div class="col-md-7">
        <h2 class="promo-heading">Simple. <span class="text-muted">You won't believe it.</span></h2>
        <p class="lead">We've designed our polls to be as simple as possible by giving you the options to easily customize them as you or your company requires.</p>
      </div>
      <div class="col-md-5 promo-icon">
        <div class="row">
          <div class="col-xs-4">
            <span class="glyphicon glyphicon-align-justify"></span>
            <p>Manage Polls</p>
          </div>
          <div class="col-xs-4">
            <span class="glyphicon glyphicon-user"></span>
            <p>Analyze Data</p>
          </div>
          <div class="col-xs-4">
            <span class="glyphicon glyphicon-download-alt"></span>
            <p>Export Data</p>
          </div>
        </div>
      </div>
    </div>
  </div>
</section> <section>
  <div class="container">
    <footer class="row">
      <div class="pull-right footer">
        <div class="languages">
          <a href="#lang" class="active" id="show-language"><i class="glyphicon glyphicon-globe"></i> Language</a>
          <div class="langs">
            <a href='index9ed2.html?lang=en'>English</a><a href='indexf368.html?lang=jp'>Japanese</a><a href='index3322.html?lang=de'>German</a><a href='indexadee.html?lang=vn'>Vietnamese</a><a href='indexcf53.html?lang=it'>Italian</a><a href='index9977.html?lang=kr'>Korean</a><a href='index0b5e.html?lang=ro'>Romanian</a><a href='index79bd.html?lang=tu'>Turkish</a><a href='index2139.html?lang=ru'>Russian</a><a href='indexc69a.html?lang=es'>Spanish</a><a href='indexc249.html?lang=sw'>Swedish</a><a href='indexe68f.html?lang=fr'>French</a> </div>
        </div>
      </div>
      <p>&copy; 2019 <a href="https://ensias.com">ENSIAS</a></p>
    </footer>
  </div>
</section>
<script type="text/javascript" src="static/applicationc619.js?v=1.0"></script>
</body>

</html>
