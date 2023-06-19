<%--
  Created by IntelliJ IDEA.
  User: Tài
  Date: 12/06/2023
  Time: 19:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zxx">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="Sona Template">
    <meta name="keywords" content="Sona, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Lovechair</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css?family=Lora:400,700&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Cabin:400,500,600,700&display=swap" rel="stylesheet">

    <!-- Css Styles -->

    <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css" >
    <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="css/flaticon.css" type="text/css">
    <link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="css/jquery-ui.min.css" type="text/css">
    <link rel="stylesheet" href="css/magnific-popup.css" type="text/css">
    <link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="css/style.css" type="text/css">
</head>

<body>
<!-- Page Preloder -->
<div id="preloder">
    <div class="loader"></div>
</div>

<!-- Offcanvas Menu Section Begin -->
<div class="offcanvas-menu-overlay"></div>
<div class="canvas-open">
    <i class="icon_menu"></i>
</div>
<div class="offcanvas-menu-wrapper">
    <div class="canvas-close">
        <i class="icon_close"></i>
    </div>
    <div class="search-icon  search-switch">
        <i class="icon_search"></i>
    </div>
    <div class="header-configure-area">
        <div class="language-option">
            <img src="img/flag.jpg" alt="">
            <span>EN <i class="fa fa-angle-down"></i></span>
            <div class="flag-dropdown">
                <ul>
                    <li><a href="#">Zi</a></li>
                    <li><a href="#">Fr</a></li>
                </ul>
            </div>
        </div>
        <a href="#" class="bk-btn">Booking Now</a>
    </div>
    <nav class="mainmenu mobile-menu">
        <ul>
            <li class="active"><a href="./index.jsp">Home</a></li>
            <li><a href="./rooms.html">Hotels</a></li>
            <li><a href="./about-us.html">About Us</a></li>
            <li><a href="./pages.html">Pages</a>
                <ul class="dropdown">
                    <li><a href="./room-details.html">Room Details</a></li>
                    <li><a href="#">Deluxe Room</a></li>
                    <li><a href="#">Family Room</a></li>
                    <li><a href="#">Premium Room</a></li>
                </ul>
            </li>
            <li><a href="./blog.html">News</a></li>
            <li><a href="./contact.html">Contact</a></li>
        </ul>
    </nav>
    <div id="mobile-menu-wrap"></div>
    <div class="top-social">
        <a href="#"><i class="fa fa-facebook"></i></a>
        <a href="#"><i class="fa fa-twitter"></i></a>
        <a href="#"><i class="fa fa-tripadvisor"></i></a>
        <a href="#"><i class="fa fa-instagram"></i></a>
    </div>
    <ul class="top-widget">
        <li><i class="fa fa-phone"></i> (12) 345 67890</li>
        <li><i class="fa fa-envelope"></i> Lovechair@gmail.com</li>
    </ul>
</div>
<!-- Offcanvas Menu Section End -->

<!-- Header Section Begin -->
<jsp:include page="header.jsp"></jsp:include>
<!-- Header End -->

<!-- Breadcrumb Section Begin -->
<div class="breadcrumb-section">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="breadcrumb-text">
                    <h2>Our Hotel List</h2>
                    <div class="bt-option">
                        <a href="index.jsp">Home</a>
                        <span>Hotels</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Breadcrumb Section End -->

<!-- Rooms Section Begin -->
<section class="rooms-section spad">
    <div class="container">
        <div class="row">

<c:forEach var="tempHotel" items="${HOTEL_LIST}">

    <c:url var="tempLink" value="HotelControllerServlet">
        <c:param name="command" value="LOAD"/>
        <c:param name="hotelId" value="${tempHotel.hotelId}"/>
    </c:url>

    <c:url var="deleteLink" value="HotelControllerServlet">
        <c:param name="command" value="DELETE"/>
        <c:param name="hotelId" value="${tempHotel.hotelId}"/>
    </c:url>
    <div class="col-lg-4 col-md-6">
        <div class="room-item">
            <img src="${tempHotel.img}" alt="">
            <div class="ri-text">
                <h4>${tempHotel.name}</h4>
                <table>
                    <tbody>
                    <tr>
                        <td class="r-o">Rating:</td>
                        <td>9.0/10</td>
                    </tr>
                    <tr>
                        <td class="r-o">Phone :</td>
                        <td>${tempHotel.phone}
                        </td>
                    </tr>
                    <tr>
                        <td class="r-o">Email :</td>
                        <td>${tempHotel.email}
                        </td>
                    </tr>
                    <tr>
                        <td class="r-o">Address :</td>
                        <td>${tempHotel.address}</td>
                    </tr>
                    </tbody>
                </table>
                <a href="RoomControllerServlet?theHotelId=${tempHotel.hotelId}" class="primary-btn">More Details</a>
            </div>
        </div>
    </div>
</c:forEach>

<%--            <div class="col-lg-4 col-md-6">--%>
<%--                <div class="room-item">--%>
<%--                    <img src="WEB-INF/img/room/room-2.jpg" alt="">--%>
<%--                    <div class="ri-text">--%>
<%--                        <h4>Hotel Majestic Saigon</h4>--%>
<%--                        <h3>129$<span>/Pernight</span></h3>--%>
<%--                        <table>--%>
<%--                            <tbody>--%>
<%--                            <tr>--%>
<%--                                <td class="r-o">Rating:</td>--%>
<%--                                <td>9.0/10</td>--%>
<%--                            </tr>--%>
<%--                            <tr>--%>
<%--                                <td class="r-o">Amenities:</td>--%>
<%--                                <td>Restaurant, Pool, Parking, Gym--%>
<%--                                </td>--%>
<%--                            </tr>--%>
<%--                            <tr>--%>
<%--                                <td class="r-o">Arrival / Depart:</td>--%>
<%--                                <td>Check in: 14:00--%>
<%--                                </td>--%>
<%--                            </tr>--%>
<%--                            <tr>--%>
<%--                                <td class="r-o">Services:</td>--%>
<%--                                <td>Wifi, Television, Bathroom,...</td>--%>
<%--                            </tr>--%>
<%--                            </tbody>--%>
<%--                        </table>--%>
<%--                        <a href="#" class="primary-btn">More Details</a>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--            <div class="col-lg-4 col-md-6">--%>
<%--                <div class="room-item">--%>
<%--                    <img src="WEB-INF/img/room/room-3.jpg" alt="">--%>
<%--                    <div class="ri-text">--%>
<%--                        <h4>The Chill Suites</h4>--%>
<%--                        <h3>169$<span>/Pernight</span></h3>--%>
<%--                        <table>--%>
<%--                            <tbody>--%>
<%--                            <tr>--%>
<%--                                <td class="r-o">Rating:</td>--%>
<%--                                <td>9.0/10</td>--%>
<%--                            </tr>--%>
<%--                            <tr>--%>
<%--                                <td class="r-o">Amenities:</td>--%>
<%--                                <td>Restaurant, Pool, Parking, Gym--%>
<%--                                </td>--%>
<%--                            </tr>--%>
<%--                            <tr>--%>
<%--                                <td class="r-o">Arrival / Depart:</td>--%>
<%--                                <td>Check in: 14:00--%>
<%--                                </td>--%>
<%--                            </tr>--%>
<%--                            <tr>--%>
<%--                                <td class="r-o">Services:</td>--%>
<%--                                <td>Wifi, Television, Bathroom,...</td>--%>
<%--                            </tr>--%>
<%--                            </tbody>--%>
<%--                        </table>--%>
<%--                        <a href="#" class="primary-btn">More Details</a>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--            <div class="col-lg-4 col-md-6">--%>
<%--                <div class="room-item">--%>
<%--                    <img src="WEB-INF/img/room/room-4.jpg" alt="">--%>
<%--                    <div class="ri-text">--%>
<%--                        <h4>Hotel Silverland Sakyo</h4>--%>
<%--                        <h3>159$<span>/Pernight</span></h3>--%>
<%--                        <table>--%>
<%--                            <tbody>--%>
<%--                            <tr>--%>
<%--                                <td class="r-o">Rating:</td>--%>
<%--                                <td>9.0/10</td>--%>
<%--                            </tr>--%>
<%--                            <tr>--%>
<%--                                <td class="r-o">Amenities:</td>--%>
<%--                                <td>Restaurant, Pool, Parking, Gym--%>
<%--                                </td>--%>
<%--                            </tr>--%>
<%--                            <tr>--%>
<%--                                <td class="r-o">Arrival / Depart:</td>--%>
<%--                                <td>Check in: 14:00--%>
<%--                                </td>--%>
<%--                            </tr>--%>
<%--                            <tr>--%>
<%--                                <td class="r-o">Services:</td>--%>
<%--                                <td>Wifi, Television, Bathroom,...</td>--%>
<%--                            </tr>--%>
<%--                            </tbody>--%>
<%--                        </table>--%>
<%--                        <a href="#" class="primary-btn">More Details</a>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--            <div class="col-lg-4 col-md-6">--%>
<%--                <div class="room-item">--%>
<%--                    <img src="WEB-INF/img/room/room-5.jpg" alt="">--%>
<%--                    <div class="ri-text">--%>
<%--                        <h4>Room With View</h4>--%>
<%--                        <h3>159$<span>/Pernight</span></h3>--%>
<%--                        <table>--%>
<%--                            <tbody>--%>
<%--                            <tr>--%>
<%--                                <td class="r-o">Rating:</td>--%>
<%--                                <td>9.0/10</td>--%>
<%--                            </tr>--%>
<%--                            <tr>--%>
<%--                                <td class="r-o">Amenities:</td>--%>
<%--                                <td>Restaurant, Pool, Parking, Gym--%>
<%--                                </td>--%>
<%--                            </tr>--%>
<%--                            <tr>--%>
<%--                                <td class="r-o">Arrival / Depart:</td>--%>
<%--                                <td>Check in: 14:00--%>
<%--                                </td>--%>
<%--                            </tr>--%>
<%--                            <tr>--%>
<%--                                <td class="r-o">Services:</td>--%>
<%--                                <td>Wifi, Television, Bathroom,...</td>--%>
<%--                            </tr>--%>
<%--                            </tbody>--%>
<%--                        </table>--%>
<%--                        <a href="#" class="primary-btn">More Details</a>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--            <div class="col-lg-4 col-md-6">--%>
<%--                <div class="room-item">--%>
<%--                    <img src="WEB-INF/img/room/room-6.jpg" alt="">--%>
<%--                    <div class="ri-text">--%>
<%--                        <h4>Small View</h4>--%>
<%--                        <h3>159$<span>/Pernight</span></h3>--%>
<%--                        <table>--%>
<%--                            <tbody>--%>
<%--                            <tr>--%>
<%--                                <td class="r-o">Rating:</td>--%>
<%--                                <td>9.0/10</td>--%>
<%--                            </tr>--%>
<%--                            <tr>--%>
<%--                                <td class="r-o">Amenities:</td>--%>
<%--                                <td>Restaurant, Pool, Parking, Gym--%>
<%--                                </td>--%>
<%--                            </tr>--%>
<%--                            <tr>--%>
<%--                                <td class="r-o">Arrival / Depart:</td>--%>
<%--                                <td>Check in: 14:00--%>
<%--                                </td>--%>
<%--                            </tr>--%>
<%--                            <tr>--%>
<%--                                <td class="r-o">Services:</td>--%>
<%--                                <td>Wifi, Television, Bathroom,...</td>--%>
<%--                            </tr>--%>
<%--                            </tbody>--%>
<%--                        </table>--%>
<%--                        <a href="#" class="primary-btn">More Details</a>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--            <div class="col-lg-12">--%>
<%--                <div class="room-pagination">--%>
<%--                    <a href="#">1</a>--%>
<%--                    <a href="#">2</a>--%>
<%--                    <a href="#">Next <i class="fa fa-long-arrow-right"></i></a>--%>
<%--                </div>--%>
<%--            </div>--%>
        </div>
    </div>
</section>
<!-- Rooms Section End -->

<!-- Footer Section Begin -->
<jsp:include page="footer.jsp"></jsp:include>
<!-- Footer Section End -->

<!-- Search model Begin -->
<div class="search-model">
    <div class="h-100 d-flex align-items-center justify-content-center">
        <div class="search-close-switch"><i class="icon_close"></i></div>

        <form  action="/hotels_1_war_exploded/SearchControlServlet" method="post" class="search-model-form" >
            <input name="txt" type="text" id="search-input" placeholder="Search here.....">
        </form>
    </div>
</div>
<!-- Search model end -->

<!-- Js Plugins -->
<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.magnific-popup.min.js"></script>
<script src="js/jquery.nice-select.min.js"></script>
<script src="js/jquery-ui.min.js"></script>
<script src="js/jquery.slicknav.js"></script>
<script src="js/owl.carousel.min.js"></script>
<script src="js/main.js"></script>
</body>

</html>
