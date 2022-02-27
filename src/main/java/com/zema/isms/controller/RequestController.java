/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zema.isms.controller;

import com.zema.isms.domain.Asset;
import com.zema.isms.domain.AssignedAsset;
import com.zema.isms.domain.Catagory;
import com.zema.isms.domain.Department;
import com.zema.isms.domain.Employee;
import com.zema.isms.domain.Request;
import com.zema.isms.domain.User;
import com.zema.isms.service.AssetService;
import com.zema.isms.service.CatagoryService;
import com.zema.isms.service.DepartmentService;
import com.zema.isms.service.EmployeeService;
import com.zema.isms.service.RequestService;
import com.zema.isms.service.UserService;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author ewawuye
 */
@Controller
@RequestMapping("/request")
public class RequestController {
    @Autowired
    private UserService userservice;
            @Autowired
    private CatagoryService catagoryservice;  
        @Autowired
    private DepartmentService deptservice;
          @Autowired
    private RequestService requestservice;
      @Autowired
   private AssetService assetservice;
         @Autowired
    private EmployeeService employeeservice;
       @InitBinder
    public void initBinder(WebDataBinder dataBinder) {

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
    @RequestMapping(value = "/request_page")
   public ModelAndView getRequestPage(@RequestParam(value = "count",required = false ) Integer count){
     
 
  
       ModelAndView mv = new ModelAndView("managerequest");
    
          Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	String currentPrincipalName = authentication.getName();
	User user = userservice.searchUserByName(currentPrincipalName);
        String userId =  user.getUserId();
        Employee employee = user.getEmpployee();
        List<Request> requests =requestservice.getByDeclinBytDirecterAndUser(2, userId);
        List<Request> completedRequests =requestservice.getCompletedRequestBytStatusStageAndUser(5, userId);
        Request request  = new Request();
        Catagory catagory = new    Catagory ();
        Department dept = employee.getDepartment();  
        String deppartmentId = dept.getDepartmentId();
         mv.addObject("dept", dept);
          mv.addObject("request", request);
               mv.addObject("completedRequests", completedRequests);
            mv.addObject("requests", requests);
         mv.addObject("emp", employee);
         mv.addObject("user", user);
          mv.addObject("count", count);
          List<Catagory> catagorylist = catagoryservice.getCatagoryList();
             
         mv.addObject("catagorylist", catagorylist);
         mv.addObject("catagory", catagory);
         mv.addObject("departmentId", deppartmentId);
         mv.addObject("userId", userId);
     
    
      return mv;
   } 
   @RequestMapping(value = "/request_reg",method = RequestMethod.POST)
   public String registerRequest(@Valid @ModelAttribute("request") Request request,BindingResult result, @RequestParam(value = "userId",required = false)String userId,
           @RequestParam(value = "departmentId",required = false)String departmentId,Model m  ){
       if(result.hasErrors()){
            List<Catagory> catagorylist = catagoryservice.getCatagoryList();
            Catagory catagory = new    Catagory ();
             m.addAttribute("catagorylist", catagorylist);
          m.addAttribute("catagory", catagory);
           return "managerequest";
       }
   List<Department> deptList   = new ArrayList<>();
   User u = userservice.searchByUserId(userId);
   Department dept = deptservice.searchByDepartmentId(departmentId);
   deptList.add(dept);
   request.setStatusStage(0);
   request.setUser(u);
 
   request.setDepartments(deptList);
    requestservice.addRequest(request);
 return "redirect:/request/request_page?act=request_reg";   
}
   // directer  rquests list from employee
    @RequestMapping(value = "/request_list",method = RequestMethod.GET)
   public ModelAndView getRequestByDepartment(){
     
 
  
       ModelAndView mv = new ModelAndView("requestList");
    
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	String currentPrincipalName = authentication.getName();
	 User user = userservice.searchUserByName(currentPrincipalName);
         String userId =  user.getUserId();
        Employee employee = user.getEmpployee();
        Request request  = new Request();
        
        Department dept = employee.getDepartment();  
        String deppartmentId = dept.getDepartmentId();
       // List<Request> listrequest =requestservice.getAllRequest();
        List<Request> requests =requestservice.getRequestListByDepartment(dept.getDepartmentId());
         mv.addObject("dept", dept);
         mv.addObject("request", request);
         mv.addObject("emp", employee);
         mv.addObject("user", user);
         mv.addObject("departmentId", deppartmentId);
         mv.addObject("userId", userId);
        // mv.addObject("listrequest", listrequest);
         mv.addObject("requests", requests);
     
    
      return mv;
   } 
   
   
   
   // store kepeer request after manager  manager aproval
   
    @RequestMapping(value = "/store-kepeer-request-list",method = RequestMethod.GET)
   public ModelAndView getRequestFromAllDepartment(){
     
 
  
       ModelAndView mv = new ModelAndView("storeKepeerRequest");
    
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	String currentPrincipalName = authentication.getName();
	 User user = userservice.searchUserByName(currentPrincipalName);
         String userId =  user.getUserId();
        Employee employee = user.getEmpployee();
        Request request  = new Request();
        
        Department dept = employee.getDepartment();  
        String deppartmentId = dept.getDepartmentId();
       // List<Request> listrequest =requestservice.getAllRequest();
        List<Request> requests =requestservice.searchRequestListByStatusStage(3);
         mv.addObject("dept", dept);
         mv.addObject("request", request);
         mv.addObject("emp", employee);
         mv.addObject("user", user);
         mv.addObject("departmentId", deppartmentId);
         mv.addObject("userId", userId);
        // mv.addObject("listrequest", listrequest);
         mv.addObject("requests", requests);
     
    
      return mv;
   } 
   
   
     @RequestMapping(value = "/request_approve_page",method = RequestMethod.GET)
   public ModelAndView viewRequestDetails(@RequestParam("requestId") String requestId){
     
 
  
       ModelAndView mv = new ModelAndView("requestDetail");
    
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	String currentPrincipalName = authentication.getName();
	 User user = userservice.searchUserByName(currentPrincipalName);
         String userId =  user.getUserId();
         Employee employee = user.getEmpployee();
         Request request  = new Request();
        
        Department dept = employee.getDepartment();  
        String deppartmentId = dept.getDepartmentId();
       // List<Request> listrequest =requestservice.getAllRequest();
         Request requests =requestservice.getByRequestId(requestId);
         mv.addObject("dept", dept);
         mv.addObject("request", request);
         mv.addObject("emp", employee);
         mv.addObject("user", user);
         mv.addObject("departmentId", deppartmentId);
         mv.addObject("userId", userId);
        // mv.addObject("listrequest", listrequest);
         mv.addObject("requests", requests);
     
    
      return mv;
   } 
   // request approve by director
   @RequestMapping(value = "/requestApprove",method = RequestMethod.POST)
   public String approveRequestByDirecter(@ModelAttribute("request") Request request,@RequestParam("requestId") String requestId, Model m  ){
        
   requestservice.editRequest(request);
 return "redirect:/request/request_list?act=directer_request_approve";   
}
   // manager request approve 
   @RequestMapping(value="/request-manager-Approve",method= RequestMethod.POST)
   public String approveRequestByMnager(@ModelAttribute("request") Request request,@RequestParam("requestId") String requestId, Model m ){
       requestservice.editRequestByMnager(request);
       
      return "redirect:/request/requestApproveManager?act=manager_request_approve";
   }
    // store kepeer complate request
   @RequestMapping(value="/request-store-kepeer-Completed",method= RequestMethod.POST)
   public String completeRequestByKepeer(@ModelAttribute("request") Request request,@RequestParam("requestId") String requestId, Model m ){
       requestservice.editRequestByKepeer(request);
       
      return "redirect:/request/store-kepeer-request-list?act=kepeer_request_completed";
   }
   // retrive request approved by directer and status equals true
    @RequestMapping(value = "/requestApproveManager",method = RequestMethod.GET)
   public ModelAndView getRequestApproveByManager(){
     
 
     User user1 =null;
       ModelAndView mv = new ModelAndView("requestApprove");
    
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	String currentPrincipalName = authentication.getName();
	 User user = userservice.searchUserByName(currentPrincipalName);
         String userId =  user.getUserId();
        Employee employee = user.getEmpployee();
        Request request  = new Request();
        
        Department dept = employee.getDepartment();  
        String deppartmentId = dept.getDepartmentId();

        //List<Request> requests =requestservice.searchRequestListByStatus(true);
        List<Request> requests =requestservice.searchRequestListByStatusStage(1);
        
         mv.addObject("dept", dept);
         mv.addObject("request", request);
         mv.addObject("emp", employee);
         mv.addObject("user", user);
         mv.addObject("departmentId", deppartmentId);
         mv.addObject("userId", userId);
     
         mv.addObject("requests", requests);
     
    
      return mv;
   } 
   
   // completed request list
   @RequestMapping(value = "/finished-request",method = RequestMethod.GET)
   public ModelAndView getRequestFinishedByKepeer(){
     
 
     User user1 =null;
       ModelAndView mv = new ModelAndView("finishedRequest");
    
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	String currentPrincipalName = authentication.getName();
	 User user = userservice.searchUserByName(currentPrincipalName);
         String userId =  user.getUserId();
        Employee employee = user.getEmpployee();
        Request request  = new Request();
        
        Department dept = employee.getDepartment();  
        String deppartmentId = dept.getDepartmentId();

        //List<Request> requests =requestservice.searchRequestListByStatus(true);
        List<Request> requests =requestservice.searchRequestListByStatusStage(5);
        
         mv.addObject("dept", dept);
         mv.addObject("request", request);
         mv.addObject("emp", employee);
         mv.addObject("user", user);
         mv.addObject("departmentId", deppartmentId);
         mv.addObject("userId", userId);
     
         mv.addObject("requests", requests);
     
    
      return mv;
   } 
   // for request approved by directer asset manager  see details
   @RequestMapping(value = "/requestapprove_page",method = RequestMethod.GET)
   public ModelAndView getApprovedRequestDetails(@RequestParam("requestId") String requestId){
   
       ModelAndView mv = new ModelAndView("directerApproved");
      Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	String currentPrincipalName = authentication.getName();
	 User user = userservice.searchUserByName(currentPrincipalName);
         String userId =  user.getUserId();
         Employee employee = user.getEmpployee();
         Request request  = new Request();
        
        Department dept = employee.getDepartment();  
        String deppartmentId = dept.getDepartmentId();
       
         Request requests =requestservice.getByRequestId(requestId);
         mv.addObject("dept", dept);
         mv.addObject("request", request);
         mv.addObject("emp", employee);
         mv.addObject("user", user);
         mv.addObject("departmentId", deppartmentId);
         mv.addObject("userId", userId);
        
         mv.addObject("requests", requests);
     
    
      return mv;
   } 
   
   // for request approved by manager store kepeer  see details and make complated after
   @RequestMapping(value = "/request-manager-approved-detail-page",method = RequestMethod.GET)
   public ModelAndView getManagerApprovedRequestDetails(@RequestParam("requestId") String requestId){
   
       ModelAndView mv = new ModelAndView("completedRequest");
      Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	String currentPrincipalName = authentication.getName();
	 User user = userservice.searchUserByName(currentPrincipalName);
         String userId =  user.getUserId();
         Employee employee = user.getEmpployee();
         Request request  = new Request();
        
        Department dept = employee.getDepartment();  
        String deppartmentId = dept.getDepartmentId();
       
         Request requests =requestservice.getByRequestId(requestId);
         mv.addObject("dept", dept);
         mv.addObject("request", request);
         mv.addObject("emp", employee);
         mv.addObject("user", user);
         mv.addObject("departmentId", deppartmentId);
         mv.addObject("userId", userId);
        
         mv.addObject("requests", requests);
     
    
      return mv;
   } 
   @RequestMapping(value = "/assetByCatagory",method = RequestMethod.GET)
   public ModelAndView viewAvailableAsset(@ModelAttribute("catagory") Catagory catagory ){
        
  int count = assetservice.AssetInStoreCountByCatagory(catagory.getCatagoryId());
      ModelAndView mv = new ModelAndView("managerequest");
    
          Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	String currentPrincipalName = authentication.getName();
	 User user = userservice.searchUserByName(currentPrincipalName);
        String userId =  user.getUserId();
        Employee employee = user.getEmpployee();
        Request request  = new Request();
        Catagory catagory1 = new   Catagory ();
        Department dept = employee.getDepartment();  
        String deppartmentId = dept.getDepartmentId();
         mv.addObject("dept", dept);
          mv.addObject("request", request);
         mv.addObject("emp", employee);
         mv.addObject("user", user);
          mv.addObject("count", count);
        List<Catagory> catagorylist = catagoryservice.getCatagoryList();
             
       mv.addObject("catagorylist", catagorylist);
       mv.addObject("catagory", catagory1);
        mv.addObject("departmentId", deppartmentId);
         mv.addObject("userId", userId);
  return mv;   
}
   // decline request
    @RequestMapping(value = "/directer-request-decline",method = RequestMethod.GET)
   public String declineRequestByDirecter(@RequestParam("requestId") String requestId, Model m  ){
        
        Request request =requestservice.searchByRequestId(requestId);
        request.setStatusStage(2);
       requestservice.updateRequest(request);
 return "redirect:/request/request_list?act=directer-decline";   
}
   //   request decline by manager
       @RequestMapping(value = "/manager-request-decline",method = RequestMethod.GET)
   public String declineRequestByManager(@RequestParam("requestId") String requestId, Model m  ){
        
        Request request =requestservice.searchByRequestId(requestId);
        request.setStatusStage(4);
       requestservice.updateRequest(request);
 return "redirect:/request/requestApproveManager?act=manager-decline";   
}
   //get approved assign page
     //  assign page request
    @RequestMapping(value = "/asset_assign",method = RequestMethod.GET)
   public String getassignPage( Model m ,@RequestParam(value ="assetCode", required = false) String assetCode,
           @RequestParam(value = "code", required = false) String employeeCode  ){
        Employee emp = employeeservice.searchByEmployeeCode(employeeCode);
        String code = emp.getCode();
        AssignedAsset aa = new   AssignedAsset ();
      m.addAttribute("command", aa);
      m.addAttribute("code",code);
 return "asignPage";   
}
   //  assign page request for the future
    @RequestMapping(value = "/assetassign",method = RequestMethod.POST)
   public String postassignPage( Model m,@ModelAttribute("command")AssignedAsset aa,@RequestParam(value ="assetCode", required = false) String assetCode,
       @RequestParam(value = "code", required = false) String employeeCode ){
        Asset asset =  assetservice.searchByAssetCode(assetCode);
     if(asset == null){
         AssignedAsset a = new   AssignedAsset ();
         m.addAttribute("command", a);
         m.addAttribute("message", "asset with" + "\t"+ assetCode+ "\t"+ "is not found");
         return "aprovedAssign";
     }
 //   boolean isAssigned =asset.isAssigned();
     if( !asset.isAssigned()){
         Employee emp = employeeservice.searchByEmployeeCode(employeeCode);
         if(emp==null){
            m.addAttribute("empMessage","employee with " +"\t"+ employeeCode + "\t"+"not found");
               }
         assetservice.assignAssetToemployee(aa, emp.getEmployeeId(), asset.getAssetId());
 return  "redirect:/request/asset_assign?act=assigned";    
}
     else{
         
          return "redirect:/request/requestApproveManager?act=error";
     }
   }
   //  assign page request
    @RequestMapping(value = "/request_delete",method = RequestMethod.GET)
   public String getRequestDelete( Model m ,@RequestParam(value ="requestId", required = false) String requestId
           ){
        Request requests =requestservice.getByRequestId(requestId);
        requestservice.removeRequest(requests);
    
 return "redirect:/request/request_list";   
}
   
   //  assign page request
    @RequestMapping(value = "/personal_asset",method = RequestMethod.GET)
   public String getPersonalAsset( Model m ){
         int assignAssetResultsCount = 0;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	String currentPrincipalName = authentication.getName();
	User user = userservice.searchUserByName(currentPrincipalName);
        String userId =  user.getUserId();
        Employee employee = user.getEmpployee();
       List<AssignedAsset>  assignedAssets = assetservice.retriveAllAssignedAssetByEmployeeCode(employee.getEmployeeId());
       m.addAttribute("assetlist", assignedAssets);
      assignAssetResultsCount = assetservice.searchAssignAssetCountByEmployee(employee.getEmployeeId());
       
           m.addAttribute("resultsCount",  assignAssetResultsCount);
 return "personalAsset";   
}
   }