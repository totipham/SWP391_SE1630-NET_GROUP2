<%-- 
    Document   : footer
    Created on : Jun 19, 2022, 1:02:30 AM
    Author     : totipham
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <div id="footer">
            <div class="container d-flex justify-content-between align-items-center pt-3">
                <div>
                    <img class="mb-3" src="assets/images/logo-light.png" alt="HouseValley Logo Light">
                    <p>Một dự án được phát triển vì cộng đồng trong quá trình học môn PRJ301</p>
                    <div class="social mt-3">
                        <a href="#" class="d-inline">
                            <i class="fa-brands fa-facebook-f"></i>
                        </a>
                        <a href="#" class="d-inline">
                            <i class="fa-brands fa-youtube"></i>
                        </a>
                    </div>
                </div>
                <div class="mt-5">
                    <h3>About Phạm Trương Minh Đức</h3>
                    <a href="cv">My Curriculum Vitae</a>
                    <a href="projects">My Project</a>
                    <a href="contact">Contact</a>
                </div>
            </div>
            <div class="container copyright mt-5">
                <p>Copyright &copy;HouseValley. 2022. All right reserved.</p>
            </div>
        </div>
    </body>
    <jsp:include page="footerImport.jsp" />
</html>
