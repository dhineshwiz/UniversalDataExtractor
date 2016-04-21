package com.technovanza.ude.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class IndexController {

      @RequestMapping(value="/dologin/welcome/", method = RequestMethod.GET)
        public String getwelcomePage() {
            return "welcome";
        }



      @RequestMapping(value="/dologin/index/", method = RequestMethod.GET)
      public String getIndexPage() {
          return "index";
      }

      @RequestMapping(value="/dologin/index/viewextracts", method = RequestMethod.GET)
      public String getviewextractsPage() {
          return "viewextracts";
      }


      @RequestMapping(value="/", method = RequestMethod.GET)
      public String getlogin_page() {
          return "login";
      }

      @RequestMapping(value="/dologin/success", method = RequestMethod.GET)
      public String getsucess() {
          return "sucess";
      }


}