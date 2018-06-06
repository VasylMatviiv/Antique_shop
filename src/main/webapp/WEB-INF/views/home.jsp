<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <title>The Antique Shop</title>
    <link rel="stylesheet" href="style.css" />
    <link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
</head>
<body>
    <div class="header">
        <div class="logo">
            <a href="index.html"><img class="graficlogo" src="img\antique_logo.png" alt="_logo" /></a>
            <div class="sign">
                <a href="register.html" class="register">Sign up</a>
                <a href="login.html" class="login">Sign in</a>
            </div>
            
        </div>
        <div class="nav">
            <div class="topnav" id="myTopnav">
                <a href="index.html">HOME</a>
                <a href="goods.html">GOODS</a>
                <a href="location.html">LOCATION</a>
                <a id="menu" href="#" class="icon">&#9776;</a>
            </div>
        </div><br><br>
    </div>
    
    
    <div class="main">
            <div class="slideshow">
                <div class="mySlides">
                    <div class="numberText">1/3</div>
                    <img src="img/slide_1.jpg" style="width: 100%" alt="">
                </div>

                <div class="mySlides">
                    <div class="numberText">2/3</div>
                    <img src="img/slide_2.jpg" style="width: 100%" alt="">
                </div>

                <div class="mySlides">
                    <div class="numberText">3/3</div>
                    <img src="img/slide_3.png" style="width: 100%" alt="">
                </div>
                <a  class="prev" onclick="plusSlide(-1)">&#10094</a>
                <a  class="next" onclick="plusSlide(1)">&#10095</a>
            </div>
            <br>

            <div style="text-align: center;">
                <span class="dot" onclick="currentSlide(1)"></span>
                <span class="dot" onclick="currentSlide(2)"></span>
                <span class="dot" onclick="currentSlide(3)"></span>
            </div><br><br>
        
        
        <div class="about"><h2>About Shop</h2></div>
        
        <div class="advantages_container">
             
            <div class="advantages">
                    <div class="advantages_item">
                        <img src="img/clock.jpg" alt="" />
                        <p>In our antique store you can find some interesting and vintage goods.</p>

                    </div>
                    <div class="advantages_item">
                        <img src="img/clock.jpg" alt="" />
                        <p>You can add your own antique goods.</p>

                    </div>
            </div>
        </div>
    </div>
    
    <div class = "footer">
        <div class="nav">
            <a href="index.html">HOME</a>
            <a href="goods.html">GOODS</a>
            <a href="location.html">LOCATION</a>
        </div>
        <p class="footName">The Antique Shop</p><br>
        <p class="footContacts">Contact us: <span style="font-family:sans-serif">+380976429124</span></p>
        <br><br>
    </div>
    
    
    
    
    <script src="js/script.js"></script>
</body>
</html>