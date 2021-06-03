package com.cai.favorite;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cai.blursearch.BlurBasic;

/**
 * Servlet implementation class HistoryServlet
 */
@WebServlet("/FavoriteServlet")
public class FavoriteServlet extends HttpServlet {

    /**
     * @see HttpServlet#HttpServlet()
     */
    public FavoriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doPost(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");//编码部分
        response.setCharacterEncoding("utf-8");
        response.setHeader("content-type", "text/html;charset=utf-8");//解码部分
        String str =null;
        str  = request.getParameter("id");//获得html界面的信息
        GetFavorite logining = new GetFavorite();
        List<String> favorite = logining.Get();
        PrintWriter printwriter = response.getWriter();//浏览器界面显示
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //这里大概要写导航栏
//			String title = "Search Reault";
//	        String docType = "<!DOCTYPE html>\n";
//	        out.println(docType +
//	                "<html>\n" +
//	                "<head><title>" + title + "</title></head>\n" +
//	                "<body bgcolor=\"#f0f0f0\">\n" +
//	                "<h1 align=\"center\">" + title + "</h1>\n");

        out.println(
                "<!DOCTYPE html>\n"
                        + "<html lang="+"\""+"en"+"\">\n"
                        + "<head>\n"
                        + "<title>Hbb - Product List</title>\n"
                        + "<meta http-equiv="+"\"Content-Type\""+" content=\"text/html;charset=utf-8\"/>\n"
                        + "<meta http-equiv=\"X-UA-compatible\" content=\"IE=edge\">\n"
                        + "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n"
                        + "<link rel=\"stylesheet\" href=\"http://cdn.bootstrapmb.com/bootstrap/3.3.7/css/bootstrap.min.css\">"
                        + "<link rel=\"stylesheet\" href=\"style.css\">\n"
                        + "<script type=\"text/javascript\" src=\"./js/click.js\"></script>"
                        + "</head>\n"
                        + "<body class=\"inblog-page\">\n"
                        + "<header class=\"header style7\">\n"
                        //这是顶部状态栏
                        + "<div class=\"top-bar\">\n"
                        + "<div class=\"container\">\n"
                        + "<div class=\"top-bar-left\">\n"
                        + "<div class=\"header-message\">\n"
                        + "Welcome to HuoBiBi\n"
                        + "</div>\n"
                        + "</div>\n"
                        + "<div class=\"top-bar-right\">\n"
                        //这里用来选择语言，可以删除（大概）
							/*
								+ "<div class=\"header-language\">\n"
									+ "<div class=\"zentimo-language zentimo-dropdown\">\n"
										+ "<a href=\"#\" class=\"active language-toggle\" data-zentimo=\"zentimo-dropdown\">\n"
											+ "<span>\n"
												+ "English (USD)\n"
											+ "</span>\n"
										+ "</a>\n"
										+ "<ul class=\"zentimo-submenu\">\n"
											+ "<li class=\"switcher-option\">\n"
												+ "<a href=\"#\">\n"
													+ "<span>\n"
														+ "French (EUR)\n"
													+ "</span>\n"
												+ "</a>\n"
											+ "</li>\n"
											+ "<li class=\"switcher-option\">\n"
												+ "<a href=\"#\">\n"
													+ "<span>\n"
														+ "Japanese (JPY)\n"
													+ "</span>\n"
												+ "</a>\n"
											+ "</li>\n"
										+ "</ul>\n"
									+ "</div>\n"
								+ "</div>\n"
								*/
                        //选择语言到这里结束，我待会注释掉(已经注释）
                        + "<ul class=\"header-user-links\">\n"
                        + "<li>\n"
                        + "<a href=\"login.html\">Login</a>\n"
                        + "</li>\n"
                        + "</ul>\n"

                        + "<ul class=\"header-user-links\">\n"
                        + "<li>\n"
                        + "<a href=\"register.html\">Register</a>\n"
                        + "</li>\n"
                        + "</ul>\n"
                        + "</div>\n"
                        + "</div>\n"
                        + "</div>\n"
                        //这里是第二行顶部栏
                        + "<div class=\"container\">\n"
                        + "<div class=\"main-header\">\n"
                        + "<div class=\"row\">\n"
                        //这里是放logo的地方
                        + "<div class=\"col-lg-3 col-sm-4 col-md-3 col-xs-7 col-ts-12 header-element\">\n"
                        + "<div class=\"logo\">\n"
                        + "<a href=\"mainpage.html\">\n"
                        //logo
                        + "<img src=\"mainpage_img/HBBLogo.png\" height=\"602\" width=\"180\" alt=\"img\">\n"
                        + "</a>\n"
                        + "</div>\n"
                        + "</div>\n"
                        //这里是搜索栏
                        + "<div class=\"col-lg-7 col-sm-8 col-md-6 col-xs-5 col-ts-12\">\n"
                        + "<div class=\"block-search-block\">\n"
                        + "<form class=\"form-search form-search-width-category\">\n"
                        //+ "<div class=\"form-content\">\n"
												/*+ "<div class=\"category\">\n"
											//我不知道这里加个选品牌的框干啥，注释掉了，但是文本框有问题，应该要去css文件里面改

													+ "<select title=\"cate\" data-placeholder=\"All Categories\" class=\"chosen-select\" tabindex=\"1\">\n"
														+ "<option value=\"United States\">Huawei</option>\n"
														+ "<option value=\"United Kingdom\">Apple</option>\n"
														+ "<option value=\"Afghanistan\">Samsung</option>\n"
													+ "</select>\n"
												+ "</div>\n"

													//从这里开始输入，待会照着蔡老板的代码改

												+ "<div class=\"inner\">\n"
													+ "<input type=\"text\" class=\"input\" name=\"s\" value=\"\" placeholder=\"Search here\">\n"
												+ "</div>\n"
												+ "<button class=\"btn-search\" type=\"submit\">\n"
													+ "<span class=\"icon-search\"></span>\n"
												+ "</button>\n"
												*/
                        +"<form class=\"compare\" action=\"SearchServlet\" method=\"post\">"
                        +"<input type=\"text\" name= \"id\" value=\"\" placeholder=\"Input Something\"/> "
                        +"</form>"
                        //+ "</div>\n"
                        + "</form>\n"
                        + "</div>\n"
                        + "</div>\n"+
                        //搜索栏到这里结束（下面一堆乱七八糟的东西）
                        "<div class=\"col-lg-2 col-sm-12 col-md-3 col-xs-12 col-ts-12\">\n"+
                        "<div class=\"header-control\">\n"+
                        "<div class=\"block-minicart zentimo-mini-cart block-header zentimo-dropdown\">\n"+
                        //nmd为什么我看到了password....
                        //为什么注册和登录也在这？
					                        	/*
					                            "<a href=\"javascript:void(0);\" class=\"shopcart-icon\" data-zentimo=\"zentimo-dropdown\">\n"+
					                                "Cart\n"+
					                                "<span class=\"count\">\n"+
														"0\n"+
														"</span>\n"+
					                            "</a>\n"+
					                            "<div class=\"no-product zentimo-submenu\">\n"+
					                                "<p class=\"text\">\n"+
					                                    "You have\n"+
					                                    "<span>\n"+
																 "0 item(s)\n"+
															"</span>\n"+
					                                    "in your bag\n"+
					                                "</p>\n"+
					                            "</div>\n"+
					                        "</div>\n"+
					                            */
					                        /*"<div class=\"block-account block-header zentimo-dropdown\">\n"+
					                            "<a href=\"javascript:void(0);\" data-zentimo=\"zentimo-dropdown\">\n"+
					                                "<i class=\"fa fa-user-o\" aria-hidden=\"true\"></i>\n"+
					                            "</a>\n"+
					                            "<div class=\"header-account zentimo-submenu\">\n"+
					                                "<div class=\"header-user-form-tabs\">\n"+
					                                    "<ul class=\"tab-link\">\n"+
					                                        "<li class=\"active\">\n"+
					                                            "<a data-toggle=\"tab\" aria-expanded=\"true\" href=\"#header-tab-login\">Login</a>\n"+
					                                        "</li>\n"+
					                                        "<li>\n"+
					                                            "<a data-toggle=\"tab\" aria-expanded=\"true\" href=\"#header-tab-rigister\">Register</a>\n"+
					                                        "</li>\n"+
					                                    "</ul>\n"+
					                                    "<div class=\"tab-container\">\n"+
					                                        "<div id=\"header-tab-login\" class=\"tab-panel active\">\n"+
					                                            "<form method=\"post\" class=\"login form-login\">\n"+
					                                                "<p class=\"form-row form-row-wide\">\n"+
					                                                    "<input type=\"email\" placeholder=\"Email\" class=\"input-text\">\n"+
					                                                "</p>\n"+
					                                                "<p class=\"form-row form-row-wide\">\n"+
					                                                    "<input type=\"password\" class=\"input-text\" placeholder=\"Password\">\n"+
					                                                "</p>\n"+
					                                                "<p class=\"form-row\">\n"+
					                                                    "<label class=\"form-checkbox\">\n"+
					                                                        "<input type=\"checkbox\" class=\"input-checkbox\">\n"+
					                                                        "<span>\n"+
																					"Remember me\n"+
																				"</span>\n"+
					                                                    "</label>\n"+
					                                                    "<input type=\"submit\" class=\"button\" value=\"Login\">\n"+
					                                                "</p>\n"+
					                                                "<p class=\"lost_password\">\n"+
					                                                    "<a href=\"#\">Lost your password?</a>\n"+
					                                                "</p>\n"+
					                                            "</form>\n"+
					                                        "</div>\n"+
					                                        "<div id=\"header-tab-rigister\" class=\"tab-panel\">\n"+
					                                            "<form method=\"post\" class=\"register form-register\">\n"+
					                                                "<p class=\"form-row form-row-wide\">\n"+
					                                                    "<input type=\"email\" placeholder=\"Email\" class=\"input-text\">\n"+
					                                                "</p>\n"+
					                                                "<p class=\"form-row form-row-wide\">\n"+
					                                                    "<input type=\"password\" class=\"input-text\" placeholder=\"Password\">\n"+
					                                                "</p>\n"+
					                                                "<p class=\"form-row\">\n"+
					                                                    "<input type=\"submit\" class=\"button\" value=\"Register\">\n"+
					                                                "</p>\n"+
					                                            "</form>\n"+
					                                        "</div>\n"+
					                                    "</div>\n"+
					                                "</div>\n"+
					                            "</div>\n"+
					                        "</div>\n"+
					                        "<a class=\"menu-bar mobile-navigation menu-toggle\" href=\"#\">\n"+
					                            "<span></span>\n"+
					                            "<span></span>\n"+
					                            "<span></span>\n"+
					                        "</a>\n"+
					                    "</div>\n"+
					                "</div>\n"+
					            "</div>\n"+
					        "</div>\n"+
					    "</div>\n"+ */

                        "</header>\n"+


                        "<div class=\"main-content main-content-product no-sidebar\">\n"+
                        "<div class=\"container\">\n"+
					/*
					        "<div class=\"row\">\n"+
					            "<div class=\"col-lg-12\">\n"+
					                "<div class=\"breadcrumb-trail breadcrumbs\">\n"+
					                    "<ul class=\"trail-items breadcrumb\">\n"+
					                        "<li class=\"trail-item trail-begin\">\n"+
					                            "<a href=\"index.html\">Home</a>\n"+
					                        "</li>\n"+
					                        "<li class=\"trail-item trail-end active\">\n"+
					                            "Products List\n"+
					                        "</li>\n"+
					                    "</ul>\n"+
					                "</div>\n"+
					            "</div>\n"+
					        "</div>\n"+
					            */
                        "<div class=\"row\">\n"+
                        "<div class=\"content-area  shop-grid-content full-width col-lg-12 col-md-12 col-sm-12 col-xs-12\">\n"+
                        "<div class=\"site-main\">\n"+
                        "<div class=\"shop-top-control\">\n"+
                        "<form class=\"filter-choice select-form\">\n"+
                        "<span class=\"title\">Sort by</span>\n"+
                        "<select title=\"by\" data-placeholder=\"Price: Low to High\" class=\"chosen-select\">\n"+
                        "<option value=\"1\">Default sorting</option>\n"+
                        "<option value=\"2\">Sort by popularity</option>\n"+
                        "<option value=\"3\">Sort by average rating</option>\n"+
                        "<option value=\"4\">Sort by newness</option>\n"+
                        "<option value=\"5\">Sort by price: low to high</option>\n"+
                        "</select>\n"+
                        "</form>\n"+
                        "<form class=\"select-item select-form\">\n"+
                        "<span class=\"title\">Sort</span>\n"+
                        "<select title=\"sort\" data-placeholder=\"12 Products/Page\" class=\"chosen-select\">\n"+
                        "<option value=\"1\">12 Products/Page</option>\n"+
                        "<option value=\"2\">9 Products/Page</option>\n"+
                        "<option value=\"3\">10 Products/Page</option>\n"+
                        "<option value=\"4\">8 Products/Page</option>\n"+
                        "<option value=\"5\">6 Products/Page</option>\n"+
                        "</select>\n"+
                        "</form>\n"+
	/*
					                        "<div class=\"grid-view-mode\">\n"+
					                            "<div class=\"inner\">\n"+
					                                "<a href=\"listproducts.html\" class=\"modes-mode mode-list active\">\n"+
					                                    "<span></span>\n"+
					                                    "<span></span>\n"+
					                                "</a>\n"+
					                                "<a href=\"gridproducts.html\" class=\"modes-mode mode-grid\">\n"+
					                                    "<span></span>\n"+
					                                    "<span></span>\n"+
					                                    "<span></span>\n"+
					                                    "<span></span>\n"+
					                                "</a>\n"+
					                            "</div>\n"+
					                        "</div>\n"+
					                        */
                        "</div>\n"+
                        "<h3 class=\"custom_blog_title\">\n"+
                        "Product List\n"+
                        "</h3>\n"+
                        "<ul class=\"row list-products auto-clear equal-container product-list\">\n"
        );

        //这里用来处理Search后返回的值
        for(int i =0; i<favorite.size(); i++) {
            String element = favorite.get(i);//这里给element赋值
            String id,url,name,pic,price;
            String[] e=element.split("\t");//分割element
            //给产品信息赋值
            id = e[0];
            name = e[1];
            price = e[2];
            pic = e[3];
            String ThirdPage = "ThirdPage?id="+id;
            //url = "https:"+e[4];
            //这里要写产品展示的前端
				/*printwriter.write("ID:"+id+"<br>");
				printwriter.write("Name:"+name+"<br>");
				printwriter.write("Price:"+price+"<br>");
				printwriter.write("Picture:"+pic+"<br>");
				//printwriter.write("url:"+("https:"+url)+"<br>");
				printwriter.write("<br>");*/
            out.println(
                    "<li class=\"product-item style-list col-lg-12 col-lg-12 col-md-12 col-sm-12 col-xs-12 col-ts-12\">\n"+
                            "<div class=\"product-inner equal-element\">\n"+
                            "<div class=\"products-bottom-content\">\n"+
                            "<div class=\"product-thumb\">\n"+
                            "<div class=\"thumb-inner\">\n"+
                            "<a href="+pic+">\n"+
                            "<img src="+pic+" alt=\"img\">\n"+
                            "</a>\n"+
                            "<a href="+pic+" class=\"button quick-wiew-button\">Quick View</a>\n"+
                            "</div>\n"+
                            "</div>\n"+
                            "<div class=\"product-info-left\">\n"+
                            "<h5 class=\"product-name product_title\">\n"+
                            "<button id="+id+" type=\"button\" value="+id+" onclick=\"\">\n"+
                            "<a href="+ThirdPage+">"+name+"</a>\n"+
                            "</button>\n"+
                            //下面写一个js用来点击事件记录
                            "</h5>\n"+
                            "</div>\n"+
                            "<div class=\"product-info-right\">\n"+
                            "<div class=\"price\">\n"+
                            price+"\n"+
                            "</div>\n"+
                            "</div>\n"+
                            "</div>\n"+
                            "</div>\n"+
                            "</li>\n"
            );
        }
        out.println(
                "</ul>\n"+
//	                "<div class=\"pagination clearfix style2\">\n"+
//	                    "<div class=\"nav-link\">\n"+
//	                        "<a href=\"#\" class=\"page-numbers\"><i class=\"icon fa fa-angle-left\"\n"+
//	                                                            "aria-hidden=\"true\"></i></a>\n"+
//	                        "<a href=\"#\" class=\"page-numbers\">1</a>\n"+
//	                        "<a href=\"#\" class=\"page-numbers\">2</a>\n"+
//	                        "<a href=\"#\" class=\"page-numbers current\">3</a>\n"+
//	                        "<a href=\"#\" class=\"page-numbers\"><i class=\"icon fa fa-angle-right\"\n"+
//	                                                            "aria-hidden=\"true\"></i></a>\n"+
//	                    "</div>\n"+
//	                "</div>\n"+
                        "</div>\n"+
                        "</div>\n"+

                        "<div class=\"sidebar col-lg-3 col-md-3 col-sm-12 col-xs-12\">\n"+
                        "<div class=\"wrapper-sidebar shop-sidebar\">\n"+
                        "<div class=\"widget woof_Widget\">\n"+
                        "<div class=\"widget widget-categories\">\n"+
                        "<h3 class=\"widgettitle\">Categories</h3>\n"+
                        "<ul class=\"list-categories\">\n"+
                        "<li>\n"+
                        "<input type=\"checkbox\" id=\"cb1\">\n"+
                        "<label for=\"cb1\" class=\"label-text\">\n"+
                        "New Arrivals\n"+
                        "</label>\n"+
                        "</li>\n"+
                        "<li>\n"+
                        "<input type=\"checkbox\" id=\"cb2\">\n"+
                        "<label for=\"cb2\" class=\"label-text\">\n"+
                        "Electronics\n"+
                        "</label>\n"+
                        "</li>\n"+
                        "<li>\n"+
                        "<input type=\"checkbox\" id=\"cb3\">\n"+
                        "<label for=\"cb3\" class=\"label-text\">\n"+
                        "Tables\n"+
                        "</label>\n"+
                        "</li>\n"+
                        "<li>\n"+
                        "<input type=\"checkbox\" id=\"cb4\">\n"+
                        "<label for=\"cb4\" class=\"label-text\">\n"+
                        "TV & Video\n"+
                        "</label>\n"+
                        "</li>\n"+
                        "<li>\n"+
                        "<input type=\"checkbox\" id=\"cb5\">\n"+
                        "<label for=\"cb5\" class=\"label-text\">\n"+
                        "Accessories\n"+
                        "</label>\n"+
                        "</li>\n"+
                        "<li>\n"+
                        "<input type=\"checkbox\" id=\"cb6\">\n"+
                        "<label for=\"cb6\" class=\"label-text\">\n"+
                        "Headphones\n"+
                        "</label>\n"+
                        "</li>\n"+
                        "</ul>\n"+
                        "</div>\n"+
                        "<div class=\"widget widget_filter_price\">\n"+
                        "<h4 class=\"widgettitle\">\n"+
                        "Price\n"+
                        "</h4>\n"+
                        "<div class=\"price-slider-wrapper\">\n"+
                        "<div data-label-reasult=\"Range:\" data-min=\"0\" data-max=\"3000\" data-unit=\"$\"\n"+
                        "class=\"slider-range-price \" data-value-min=\"0\" data-value-max=\"1000\">\n"+
                        "</div>\n"+
                        "<div class=\"price-slider-amount\">\n"+
                        "<span class=\"from\">$45</span>\n"+
                        "<span class=\"to\">$215</span>\n"+
                        "</div>\n"+
                        "</div>\n"+
                        "</div>\n"+
                        "<div class=\"widget widget-brand\">\n"+
                        "<h3 class=\"widgettitle\">Brand</h3>\n"+
                        "<ul class=\"list-brand\">\n"+
                        "<li>\n"+
                        "<input id=\"cb7\" type=\"checkbox\">\n"+
                        "<label for=\"cb7\" class=\"label-text\">New Arrivals</label>\n"+
                        "</li>\n"+
                        "<li>\n"+
                        "<input id=\"cb8\" type=\"checkbox\">\n"+
                        "<label for=\"cb8\" class=\"label-text\">Electronics</label>\n"+
                        "</li>\n"+
                        "<li>\n"+
                        "<input id=\"cb9\" type=\"checkbox\">\n"+
                        "<label for=\"cb9\" class=\"label-text\">Tables</label>\n"+
                        "</li>\n"+
                        "<li>\n"+
                        "<input id=\"cb10\" type=\"checkbox\">\n"+
                        "<label for=\"cb10\" class=\"label-text\">TV & Video</label>\n"+
                        "</li>\n"+
                        "<li>\n"+
                        "<input id=\"cb11\" type=\"checkbox\">\n"+
                        "<label for=\"cb11\" class=\"label-text\">Accessories</label>\n"+
                        "</li>\n"+
                        "<li>\n"+
                        "<input id=\"cb12\" type=\"checkbox\">\n"+
                        "<label for=\"cb12\" class=\"label-text\">Headphones</label>\n"+
                        "</li>\n"+
                        "</ul>\n"+
                        "</div>\n"+
                        "<div class=\"widget widget_filter_size\">\n"+
                        "<h4 class=\"widgettitle\">Size</h4>\n"+
                        "<ul class=\"list-size\">\n"+
                        "<li>\n"+
                        "<a href=\"#\">xs</a>\n"+
                        "</li>\n"+
                        "<li>\n"+
                        "<a href=\"#\">s</a>\n"+
                        "</li>\n"+
                        "<li class=\"active\">\n"+
                        "<a href=\"#\">m</a>\n"+
                        "</li>\n"+
                        "<li>\n"+
                        "<a href=\"#\">l</a>\n"+
                        "</li>\n"+
                        "<li>\n"+
                        "<a href=\"#\">xl</a>\n"+
                        "</li>\n"+
                        "<li>\n"+
                        "<a href=\"#\">xxl</a>\n"+
                        "</li>\n"+
                        "</ul>\n"+
                        "</div>\n"+
                        "<div class=\"widget widget-color\">\n"+
                        "<h4 class=\"widgettitle\">\n"+
                        "Color\n"+
                        "</h4>\n"+
                        "<div class=\"list-color\">\n"+
                        "<a href=\"#\" class=\"color1\"></a>\n"+
                        "<a href=\"#\" class=\"color2 \"></a>\n"+
                        "<a href=\"#\" class=\"color3 active\"></a>\n"+
                        "<a href=\"#\" class=\"color4\"></a>\n"+
                        "<a href=\"#\" class=\"color5\"></a>\n"+
                        "<a href=\"#\" class=\"color6\"></a>\n"+
                        "<a href=\"#\" class=\"color7\"></a>\n"+
                        "</div>\n"+
                        "</div>\n"+
                        "<div class=\"widget widget-tags\">\n"+
                        "<h3 class=\"widgettitle\">\n"+
                        "Popular Tags\n"+
                        "</h3>\n"+
                        "<ul class=\"tagcloud\">\n"+
                        "<li class=\"tag-cloud-link\">\n"+
                        "<a href=\"#\">Laptop</a>\n"+
                        "</li>\n"+
                        "<li class=\"tag-cloud-link\">\n"+
                        "<a href=\"#\">TV & Video</a>\n"+
                        "</li>\n"+
                        "<li class=\"tag-cloud-link\">\n"+
                        "<a href=\"#\">New</a>\n"+
                        "</li>\n"+
                        "<li class=\"tag-cloud-link active\">\n"+
                        "<a href=\"#\">Accessories</a>\n"+
                        "</li>\n"+
                        "<li class=\"tag-cloud-link\">\n"+
                        "<a href=\"#\">Hot</a>\n"+
                        "</li>\n"+
                        "<li class=\"tag-cloud-link\">\n"+
                        "<a href=\"#\">Headphones</a>\n"+
                        "</li>\n"+
                        "<li class=\"tag-cloud-link\">\n"+
                        "<a href=\"#\">Electronics</a>\n"+
                        "</li>\n"+
                        "</ul>\n"+
                        "</div>\n"+
                        "</div>\n"+
                        "<div class=\"widget newsletter-widget\">\n"+
                        "<div class=\"newsletter-form-wrap \">\n"+
                        "<h3 class=\"title\">Subscribe to Our Newsletter</h3>\n"+
                        "<div class=\"subtitle\">\n"+
                        "More special Deals, Events & Promotions\n"+
                        "</div>\n"+
                        "<input type=\"email\" class=\"email\" placeholder=\"Your email letter\">\n"+
                        "<button type=\"submit\" class=\"button submit-newsletter\">Subscribe</button>\n"+
                        "</div>\n"+
                        "</div>\n"+
                        "</div>\n"+
                        "</div>\n"+
                        "</div>\n"+
                        "</div>\n"+
                        "</div>\n"+

                        "</body>\n"+
                        "</html>\n"
        );
    }
}



