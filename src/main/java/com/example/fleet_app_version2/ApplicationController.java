package com.example.fleet_app_version2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {

    @GetMapping("/index")
    public String home(){
        return "index";
    }

    @GetMapping("/_layout")
    public String widget(){
        return "_layout";
    }


    @GetMapping("/index2")
    public String widget2(){
        return "index2";
    }

    @GetMapping("/hr")
    public String indexHR(){
        return "/hr/index";
    }

    @GetMapping("/fleet")
    public String indexFleet(){
        return "/fleet/index";
    }

    @GetMapping("/helpdesk")
    public String indexHelpDesk(){
        return "/helpdesk/index";
    }

    @GetMapping("/accounts")
    public String indexAccounts(){
        return "/accounts/index";
    }

    @GetMapping("/payroll")
    public String indexPayroll(){
        return "/payroll/index";
    }

    @GetMapping("/parameters")
    public String indexParameters(){
        return "/parameters/index";
    }





}
