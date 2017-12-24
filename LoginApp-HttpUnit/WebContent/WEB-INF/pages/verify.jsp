<% //read form data
  String uname=request.getParameter("uname"); 
  String pwd=request.getParameter("pwd");
  //form validation logic
   if(uname.equalsIgnoreCase("") || pwd.equalsIgnoreCase("")){
      out.println("Provide Inputs");
      return;
   }
  //place authentication logic
   if(uname.equalsIgnoreCase("raja") && pwd.equalsIgnoreCase("rani")){
      out.println("<h1>Valid Credentials</h1>");
   }
   else{
     out.println("<h1>InValid Credentials</h1>");
     }
  %>