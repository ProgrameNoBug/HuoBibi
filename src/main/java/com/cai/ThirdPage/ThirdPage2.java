package com.cai.ThirdPage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ThirdPage2")
public class ThirdPage2 extends HttpServlet {
    private static final long serialVersionUID = 1L;
    static Connection con;
    static Statement sql;
    static ResultSet res;
    static String id,url,name,pic,price;

    public ThirdPage2() {
        super();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");//编码部分
        response.setCharacterEncoding("utf-8");
        response.setHeader("content-type", "text/html;charset=utf-8");//解码部分
        PrintWriter printwriter = response.getWriter();//浏览器界面显示
        response.setContentType("text/html;charset=UTF-8");
        String uid = request.getParameter("id");
        PrintWriter out = response.getWriter();
        printwriter.write(uid);
        GetValue logining = new GetValue();
        List<String> value = logining.ProductValue(uid);
        String element = value.get(0);
        String[] e=element.split("\t");
        id = e[0];
        name = e[1];
        price = e[2];
        pic = e[3];
        url = "https:"+e[4];
        write(id, name, price, pic, url);//向history数据库写值
		/*printwriter.write("ID:"+id+"<br>");
		printwriter.write("Name:"+name+"<br>");
		printwriter.write("Price:"+price+"<br>");
		printwriter.write("Picture:"+pic+"<br>");
		printwriter.write("url:"+url+"<br>");
		printwriter.write("<br>");*/

        printwriter.write("<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>hbb-productdetails</title>\n" +
                "    <meta http-equiv=\"X-UA-compatible\" content=\"IE=edge\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                "<link rel=\"stylesheet\" href=\"http://cdn.bootstrapmb.com/bootstrap/3.3.7/css/bootstrap.min.css\">"+
                "<link rel=\"stylesheet\" href=\"style.css\">\n"+
                "</head>\n" +
                "<body class=\"inblog-page\" onload=\"var id=getQueryVariable(id)\">\n" +
                "<header class=\"header style7\">\n" +
                "    <!--网页顶栏（欢迎/语种切换/登录以及注册）-->\n" +
                "    <div class=\"top-bar\">\n" +
                "        <div class=\"container\">\n" +
                "            <div class=\"top-bar-left\">\n" +
                "                <div class=\"header-message\">\n" +
                "                    Welcome to our price comparison space!\n" +
                "                </div>\n" +
                "            </div>\n" +
                "            <div class=\"top-bar-right\">\n" +
                "                <div class=\"header-language\">\n" +
                "                    <div class=\"zentimo-language zentimo-dropdown\">\n" +
                "                        <a href=\"#\" class=\"active language-toggle\" data-zentimo=\"zentimo-dropdown\">\n" +
                "\t\t\t\t\t\t\t\t<span>\n" +
                "\t\t\t\t\t\t\t\t\tEnglish (USD)\n" +
                "\t\t\t\t\t\t\t\t</span>\n" +
                "                        </a>\n" +
                "                        <ul class=\"zentimo-submenu\">\n" +
                "                            <li class=\"switcher-option\">\n" +
                "                                <a href=\"#\">\n" +
                "\t\t\t\t\t\t\t\t\t\t<span>\n" +
                "\t\t\t\t\t\t\t\t\t\t\tFrench (EUR)\n" +
                "\t\t\t\t\t\t\t\t\t\t</span>\n" +
                "                                </a>\n" +
                "                            </li>\n" +
                "                            <li class=\"switcher-option\">\n" +
                "                                <a href=\"#\">\n" +
                "\t\t\t\t\t\t\t\t\t\t<span>\n" +
                "\t\t\t\t\t\t\t\t\t\t\tJapanese (JPY)\n" +
                "\t\t\t\t\t\t\t\t\t\t</span>\n" +
                "                                </a>\n" +
                "                            </li>\n" +
                "                        </ul>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "                <ul class=\"header-user-links\">\n" +
                "                    <li>\n" +
                "                        <a href=\"login.html\">Login or Register</a>\n" +
                "                    </li>\n" +
                "                </ul>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "\n" +
                "\n" +
                "    <!--logo搜索栏等顶部容器-->\n" +
                "    <div class=\"container\">\n" +
                "        <div class=\"main-header\">\n" +
                "            <div class=\"row\">\n" +
                "                <!--logo-->\n" +
                "                <div class=\"col-lg-3 col-sm-4 col-md-3 col-xs-7 col-ts-12 header-element\">\n" +
                "                    <div class=\"logo\">\n" +
                "                        <a href=\"index.html\">\n" +
                "                            <img src=\"assets/images/hbb-logo.png\" alt=\"img\">\n" +
                "                        </a>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "                <!--搜索栏-->\n" +
                "                <div class=\"col-lg-7 col-sm-8 col-md-6 col-xs-5 col-ts-12\">\n" +
                "                    <div class=\"block-search-block\">\n" +
                "                        <form class=\"form-search form-search-width-category\">\n" +
                "                            <div class=\"form-content\">\n" +
                "                                <!--选择搜索-->\n" +
                "                                <div class=\"category\">\n" +
                "                                    <select title=\"cate\" data-placeholder=\"All Categories\" class=\"chosen-select\"\n" +
                "                                            tabindex=\"1\">\n" +
                "                                        <option value=\"United States\">Huawei</option>\n" +
                "                                        <option value=\"United Kingdom\">Apple</option>\n" +
                "                                        <option value=\"Afghanistan\">Samsung</option>\n" +
                "                                    </select>\n" +
                "                                </div>\n" +
                "                                <!--搜索-->\n" +
                "                                <div class=\"inner\">\n" +
                "                                    <input type=\"text\" class=\"input\" name=\"s\" value=\"\" placeholder=\"Search here\">\n" +
                "                                </div>\n" +
                "                                <button class=\"btn-search\" type=\"submit\">\n" +
                "                                    <span class=\"icon-search\"></span>\n" +
                "                                </button>\n" +
                "                            </div>\n" +
                "                        </form>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "                <!--logo-->\n" +
                "                <div class=\"col-lg-2 col-sm-12 col-md-3 col-xs-12 col-ts-12\">\n" +
                "                    <div class=\"header-control\">\n" +
                "                        <!--购物收藏栏-->\n" +
                "                        <div class=\"block-minicart zentimo-mini-cart block-header zentimo-dropdown\">\n" +
                "                            <a href=\"javascript:void(0);\" class=\"shopcart-icon\" data-zentimo=\"zentimo-dropdown\">\n" +
                "                                Cart\n" +
                "                                <span class=\"count\">\n" +
                "\t\t\t\t\t\t\t\t\t0\n" +
                "\t\t\t\t\t\t\t\t\t</span>\n" +
                "                            </a>\n" +
                "                            <div class=\"no-product zentimo-submenu\">\n" +
                "                                <p class=\"text\">\n" +
                "                                    You have\n" +
                "                                    <span>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t 0 item(s)\n" +
                "\t\t\t\t\t\t\t\t\t\t</span>\n" +
                "                                    in your bag\n" +
                "                                </p>\n" +
                "                            </div>\n" +
                "                        </div>\n" +
                "                        <!--用户-->\n" +
                "                        <div class=\"block-account block-header zentimo-dropdown\">\n" +
                "                            <a href=\"javascript:void(0);\" data-zentimo=\"zentimo-dropdown\">\n" +
                "                                <i class=\"fa fa-user-o\" aria-hidden=\"true\"></i>\n" +
                "                            </a>\n" +
                "                            <div class=\"header-account zentimo-submenu\">\n" +
                "                                <div class=\"header-user-form-tabs\">\n" +
                "                                    <ul class=\"tab-link\">\n" +
                "                                        <li class=\"active\">\n" +
                "                                            <a data-toggle=\"tab\" aria-expanded=\"true\" href=\"#header-tab-login\">Login</a>\n" +
                "                                        </li>\n" +
                "                                        <li>\n" +
                "                                            <a data-toggle=\"tab\" aria-expanded=\"true\" href=\"#header-tab-rigister\">Register</a>\n" +
                "                                        </li>\n" +
                "                                    </ul>\n" +
                "                                    <div class=\"tab-container\">\n" +
                "                                        <div id=\"header-tab-login\" class=\"tab-panel active\">\n" +
                "                                            <form method=\"post\" class=\"login form-login\">\n" +
                "                                                <p class=\"form-row form-row-wide\">\n" +
                "                                                    <input type=\"email\" placeholder=\"Email\" class=\"input-text\">\n" +
                "                                                </p>\n" +
                "                                                <p class=\"form-row form-row-wide\">\n" +
                "                                                    <input type=\"password\" class=\"input-text\" placeholder=\"Password\">\n" +
                "                                                </p>\n" +
                "                                                <p class=\"form-row\">\n" +
                "                                                    <label class=\"form-checkbox\">\n" +
                "                                                        <input type=\"checkbox\" class=\"input-checkbox\">\n" +
                "                                                        <span>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tRemember me\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</span>\n" +
                "                                                    </label>\n" +
                "                                                    <input type=\"submit\" class=\"button\" value=\"Login\">\n" +
                "                                                </p>\n" +
                "                                                <p class=\"lost_password\">\n" +
                "                                                    <a href=\"#\">Lost your password?</a>\n" +
                "                                                </p>\n" +
                "                                            </form>\n" +
                "                                        </div>\n" +
                "                                        <div id=\"header-tab-rigister\" class=\"tab-panel\">\n" +
                "                                            <form method=\"post\" class=\"register form-register\">\n" +
                "                                                <p class=\"form-row form-row-wide\">\n" +
                "                                                    <input type=\"email\" placeholder=\"Email\" class=\"input-text\">\n" +
                "                                                </p>\n" +
                "                                                <p class=\"form-row form-row-wide\">\n" +
                "                                                    <input type=\"password\" class=\"input-text\" placeholder=\"Password\">\n" +
                "                                                </p>\n" +
                "                                                <p class=\"form-row\">\n" +
                "                                                    <input type=\"submit\" class=\"button\" value=\"Register\">\n" +
                "                                                </p>\n" +
                "                                            </form>\n" +
                "                                        </div>\n" +
                "                                    </div>\n" +
                "                                </div>\n" +
                "                            </div>\n" +
                "                        </div>\n" +
                "                        <!--可切换菜单-->\n" +
                "                        <a class=\"menu-bar mobile-navigation menu-toggle\" href=\"#\">\n" +
                "                            <span></span>\n" +
                "                            <span></span>\n" +
                "                            <span></span>\n" +
                "                        </a>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "\n" +
                "<body>\n" +
                "<div class=\"main-content main-content-details single no-sidebar\">\n" +
                "    <div class=\"container\">\n" +
                "        <div class=\"row\">\n" +
                "            <div class=\"col-lg-12\">\n" +
                "                <div class=\"breadcrumb-trail breadcrumbs\">\n" +
                "                    <ul class=\"trail-items breadcrumb\">\n" +
                "                        <li class=\"trail-item trail-begin\">\n" +
                "                            <a href=\"index.html\">Home</a>\n" +
                "                        </li>\n" +
                "                        <li class=\"trail-item\">\n" +
                "                            <a href=\"#\">Productlist</a>\n" +
                "                        </li>\n" +
                "                        <li class=\"trail-item trail-end active\">\n" +
                "                            Productdetails\n" +
                "                        </li>\n" +
                "                    </ul>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "        <div class=\"row\">\n" +
                "            <div class=\"content-area content-details full-width col-lg-9 col-md-8 col-sm-12 col-xs-12\">\n" +
                "                <div class=\"site-main\">\n" +
                "                    <div class=\"details-product\">\n" +
                "                        <div class=\"details-thumd\">\n" +
                "                            <div class=\"image-preview-container image-thick-box image_preview_container\">\n" +
                "                                <img id=\"img_zoom\" data-zoom-image=\""+AccurateItem.getItem(id).getPicture()+"\"\n" +
                "                                     src=\""+AccurateItem.getItem(id).getPicture()+"\" alt=\"img\">\n" +
                "                                <a href=\"#\" class=\"btn-zoom open_qv\"><i class=\"fa fa-search\" aria-hidden=\"true\"></i></a>\n" +
                "                            </div>\n" +
                "                        </div>\n" +
                "                        <div class=\"details-infor\">\n" +
                "                            <!--商品名称-->\n" +
                "                            <h1 class=\"product-title\">\n" +
                AccurateItem.getItem(id).getTitle()+"\n" +
                "                            </h1>\n" +
                "                            <!--星数（好评）-->\n" +
                "                            <div class=\"stars-rating\">\n" +
                "                                <div class=\"star-rating\">\n" +
                "                                    <span class=\"star-5\"></span>\n" +
                "                                </div>\n" +
                "                                <div class=\"count-star\">\n" +
                "                                    (7)\n" +
                "                                </div>\n" +
                "                            </div>\n" +
                "                            <!--库存（默认有货）-->\n" +
                "                            <div class=\"availability\">\n" +
                "                                availability:\n" +
                "                                <a href=\"#\">in Stock</a>\n" +
                "                            </div>\n" +
                "                            <!--价格-->\n" +
                "                            <div class=\"price\">\n" +
                "                                <span>"+AccurateItem.getItem(id).getPrice()+"</span>\n" +
                "                            </div>\n" +
                "                            <!--详细信息-->\n" +
                "                            <div class=\"product-info-left\">\n" +
                "                                <ul class=\"product-attributes\">\n" +
                "                                    <li>\n" +
                "                                        <a href=\"#\">Source:"+AccurateItem.getItem(id).getUrl()+"</a>\n" +
                "                                    </li>\n" +
                "                                </ul>\n" +
                "                            </div>\n" +
                "\n" +
                "                            <!--添加想要的按钮class 收藏夹添加-->\n" +
                "                            <div class=\"group-button\">\n" +
                "                                <div class=\"yith-wcwl-add-to-wishlist\">\n" +
                "                                    <div class=\"yith-wcwl-add-button\">\n" +
                "                                        <a href=\"ThirdPage\">Add to Facorites</a>\n" +
                "                                    </div>\n" +
                "                                </div>\n" +
                "                            </div>\n" +
                "                        </div>\n" +
                "                    </div>\n" +
                "                    <div class=\"tab-details-product\">\n" +
                "                        <ul class=\"tab-link\">\n" +
                "                            <li class=\"active\">\n" +
                "                                <a data-toggle=\"tab\" aria-expanded=\"true\" href=\"#product-descriptions\">You may also like </a>\n" +
                "                            </li>\n" +
                "                        </ul>\n" +
                "                        <!--此处添加like文本（相似商品）-->\n" +
                "                        <div class=\"tab-container\">\n" +
                "                            <div id=\"product-descriptions\" class=\"tab-panel active\">\n" +
                "                                <p>\n" +
                LikeItem.likes(AccurateItem.getItem(id).getPrice(), AccurateItem.getItem(id).getBrand()) +
                "                                </p>\n" +
                "                            </div>\n" +
                "                        </div>\n" +
                "                    </div>\n" +
                "                        </div>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</div>\n" +
                "\n" +
                "</body>\n"
                +
                "}");






    }

    public Connection ConnectionFavorite(){
        // TODO Auto-generated method stub
        String Driver="com.mysql.cj.jdbc.Driver";
        String url="jdbc:mysql://localhost:3306/favorite?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8&useSSL=false&allowPublicKeyRetrieval=true";
        String name="root";
        String code="123456";
        try {
            Class.forName(Driver);
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            con= DriverManager.getConnection(url, name, code);
            return con;
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    public void write(String id,String title,String price, String pic, String url) {
        ThirdPage2 c=new ThirdPage2();
        con=c.ConnectionFavorite();
        try {
            sql=con.createStatement();
            String code= "insert into favorite(productID, title, price, pic, url) values(?,?,?,?,?)";
            PreparedStatement pst=con.prepareStatement(code);
            pst.setString(1, id);
            pst.setString(2, title);
            pst.setString(3, price);
            pst.setString(4, pic);
            pst.setString(5, url);
            pst.executeUpdate();
        }

        catch (SQLException e){
            e.printStackTrace();
        }
    }


}
