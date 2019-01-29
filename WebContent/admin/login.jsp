<%--
  Created by IntelliJ IDEA.
  User: AnassBairouk
  Date: 2019-01-12
  Time: 17:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" prefix="og: http://ogp.me/ns#">

<!-- Added by HTTrack --><meta http-equiv="content-type" content="text/html;charset=UTF-8" /><!-- /Added by HTTrack -->
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no, maximum-scale=1.0" />
    <meta name="description" content="Login into your account and manage your polls and your subscription." />
    <meta property='og:type' content='website' />
    <meta property='og:url' content='https://ensias.com' />
    <meta property='og:title' content='Login into your account - Azerf Poll' />
    <meta property='og:description' content='Login into your account and manage your polls and your subscription.' />
    <title>Login into your account - Azerf Poll </title>

    <link href="../themes/default/css/bootstrap.min.css" rel="stylesheet">

    <link rel="stylesheet" type="text/css" href="../themes/default/style.css">
    <link rel="stylesheet" type="text/css" href="../themes/default/css/widgets.css">
    <link rel="stylesheet" type="text/css" href="../static/js/flat/_all.css">
    <link rel="stylesheet" type="text/css" href="../static/js/chosen.min.css">

    <script type="text/javascript" src="../static/js/jquery.min707e.js?v=1.11.0"></script>
    <script type="text/javascript" src="../static/js/chosen.minc118.js?v=0.8.5"></script>
    <script type="text/javascript" src="../static/js/icheck.minf700.js?v=1.0.1"></script>
    <script type="text/javascript" src="../static/js/jquery-ui.min1ff9.js?v=1.10.3"></script>
    <script type="text/javascript" src="../static/bootstrap.min.js"></script>
    <script type="text/javascript" src="../static/application.fnc619.js?v=1.0"></script>
    <script>
        var appurl="https://ensias.com";
        var token="703dbf82c57d85152e84d99365a0494a";
        var max_count= 10;
    </script>
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body class='dark'>
<%
//    this one to  prevent the user from going back to the index.jsp after signing
    if (session.getAttribute("admin_id")!=null){
        response.sendRedirect("../dashboard.admin");
    }
%>
<section>
    <div class="container">
        <div class="centered form">
            <div class="site_logo">
                <h3><a href="https://ensias.com">Azerf Poll</a></h3>
            </div>
            <form  method="get" action="admin.login">
                <div class="form-group">
                    <label for="email">Email address
                    </label>
                    <input type="email" class="form-control" id="email" placeholder="Enter email" name="email">
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" id="pass" placeholder="Password" name="password">
                </div>
                <div class="form-group">
                    <label>
                        <input type="checkbox" name="rememberme" value="1" data-class="blue">
                        <span class="check-box">Remember me</span>
                    </label>
                </div>
                <input type='hidden' name='token' value='de19285e346fe82d9d3d401f522d27e5833a1ecd' /> <button type="submit" class="btn btn-primary">Login</button>
            </form>
        </div>
    </div>
</section> </div>
</div>
</div>
</section>
<script type="text/javascript" src="../static/applicationc619.js?v=1.0"></script>
</body>

</html>