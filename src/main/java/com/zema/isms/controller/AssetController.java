/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zema.isms.controller;


import com.zema.isms.domain.*;
import com.zema.isms.domain.waranty.Warranty;

import com.zema.isms.dto.AssetDto;


import com.zema.isms.dto.assignedAssetSearchDto;
import com.zema.isms.service.*;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;

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
@RequestMapping("/asset")
public class AssetController {
 public final int Assets_PER_PAGE = 10;
 public  final int ASSET_HISTORY_PER_PAGE =10;
    public  final int ASSET_HISTORY_PER_PAGE_By_ASSETCODE =20;
    @Autowired //user service interface  
    private AssetService assetservice;
  @Autowired
    private CatagoryService catagoryservice;
     @Autowired
    private EmployeeService employeeservice;

    private DepartmentService departmentService;
       @Autowired
       private AssetHistoryService assetHistoryService;
    @Autowired
    public AssetController(DepartmentService departmentService,CatagoryService catagoryservice) {
        this.departmentService = departmentService;
        this.catagoryservice= catagoryservice;
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @RequestMapping(value = "/asset_reg")
    public String assetregistrationForm(Model m) {
         int AssetInStoreResultsCount =assetservice.findAssetCountInStore();
          m.addAttribute("assetInStoreCount",   AssetInStoreResultsCount);
        AssetDto a_cmd = new AssetDto();
        List<Catagory> catagorylist = catagoryservice.getCatagoryList();
        m.addAttribute("command", a_cmd);
        m.addAttribute("catagorylist", catagorylist);
        return "asset";//JSP
    }

    @RequestMapping(value = "/asset_manage")
    public String assetmanageForm(Model m) {

        return "manageAsset";//JSP
    }

    @RequestMapping(value = "/asset_warranty")
    public String assetwarratyForm(Model m) {

        return "warranty";//JSP
    }

    @RequestMapping(value = "/seacrhInfo")
    public String assetSearchForm(Model m) {

        return "search";//JSP
    }

    @RequestMapping(value = "/asset_registration")
    public String assetreg(@Valid @ModelAttribute("command") AssetDto ato, BindingResult result, Model m) {

        if (result.hasErrors()) {
                List<Catagory> catagorylist = catagoryservice.getCatagoryList();
                 m.addAttribute("catagorylist", catagorylist);
            return "asset";
        } if(ato.getCatagory().getCatagoryId()==null){
            m.addAttribute("message_cat", "please select category");
                List<Catagory> catagorylist = catagoryservice.getCatagoryList();
                 m.addAttribute("catagorylist", catagorylist);
            return "asset";
        }else{
            Asset asset = convertAssetDtoToAssetEntity(ato);
            assetservice.registerAsset(ato.getCatagory().getCatagoryId(),asset);
            return "redirect:asset_reg?act=asset_reg";//JSP
        }

    }

//    @RequestMapping(value = "/deleteAsset")
//    public String deleteAsset(@RequestParam("assetId") String assetId) {
//
//        assetservice.removeAsset(assetId);
//        return "financeInfo";
//    }

    @RequestMapping(value = "/assetlist", method = RequestMethod.GET)
    public String getAssetList(Model m) {
        //List<Asset> assetlist = assetservice.getAssetListInStore(false);

       // m.addAttribute("assetlist", assetlist);
        return "warranty"; //JSP
    }
    // get assign asset page
    @RequestMapping(value = "/assignAssetPage")
    public ModelAndView getAssignPge(@RequestParam("employeeId")String employeeId){
        ModelAndView mv = new ModelAndView("manageEmployee");
        mv.addObject("employeeId",employeeId);
        return mv;
    }
    //----------add asset toemployee ----//
    @RequestMapping(value ="/addAssetToEmployee")
    public String addAssetToEmployee(@RequestParam("assetCode")String assetCode,@RequestParam("employeeId") String employeeId, Model m){
        Asset asset = assetservice.searchByAssetCode(assetCode);
        Employee  emp = employeeservice.searchByEmployeeId(employeeId);
        boolean check =asset.isAssigned();
       if(check){
           m.addAttribute("assigndMessage", "asset is alrdy asiign");
       }
       
        assetservice.addAssetToEmp(asset.getAssetId(),emp.getEmployeeId());
   //  Employee  emp1 =  employeeservice.searchEmployeeWithAsset(employeeId);
   
        return "manageEmployee";
    }
    //--------- remove asset from employee -----//
    @RequestMapping(value = "/getEmpAssets")

    public String getAllEmployeeAsset(@RequestParam("empCode")String employeeCode,Model m){
               Employee  emp = employeeservice.searchByEmployeeCode(employeeCode);
               List<Asset> assets =  assetservice.searchEmployeeAsset(emp.getEmployeeId());
                  double sum = 0;
                 for (Asset a :assets){
               // sum=sum+a.getFinanceInfo().getAssetValue();         
                    }
               m.addAttribute("currentOwner", emp);
               m.addAttribute("employeeAsset", assets);
               m.addAttribute("total", sum);
               return "employeeAsset";
    }
    
    
// @RequestMapping(value = "/removeEmpAsset")
// public String removeEmployeeAsset(@RequestParam("assetId")String assetId,Model m){
//        Asset asset= assetservice.searchByAssetId(assetId);
//          Employee emp = asset.getEmployee();
//         assetservice.removeAsset(assetId);
//         String employeeId = emp.getEmployeeId();
//          List<Asset> assets =  assetservice.searchEmployeeAsset(employeeId);
//          m.addAttribute("employeeAsset", assets);
//       return "employeeAsset";
// }
 // for assign task
 @RequestMapping(value = "/assignPage", method = RequestMethod.GET)
 public String getAssignmentPage( Model m ,@RequestParam(value ="assetCode", required = false) String assetCode,@RequestParam(value = "code", required = false) String employeeCode){
      AssignedAsset aa = new   AssignedAsset ();
      m.addAttribute("command", aa);
      m.addAttribute("code", employeeCode);
     return "asignPage";
 }
 // assign asset to emloyee
 @RequestMapping(value = "/assignAssetToEmployee",method = RequestMethod.POST)
 public String registerAssignedAsset(Model m,@Valid @ModelAttribute("command")AssignedAsset aa, BindingResult result,@RequestParam(value ="assetCode", required = false) String assetCode,
       @RequestParam(value = "code", required = false) String employeeCode){
      AssignedAsset a = new   AssignedAsset ();
      if(result.hasErrors()){
          return "asignPage";
      }
           Employee emp = employeeservice.searchByEmployeeCode(employeeCode);
               if(emp==null){
            m.addAttribute("empmessage","employee with " +"\t"+ employeeCode + "\t"+"not found");
                     m.addAttribute("command", a);
              return "asignPage";
               }
      if(employeeCode==null){
          m.addAttribute("noEmpMessage"," Employee code is not found");
                   m.addAttribute("command", a);
          return "asignPage";
      }
     Asset asset =  assetservice.searchByAssetCode(assetCode);
     if(asset == null){
        
         m.addAttribute("command", a);
         m.addAttribute("message", "asset with" + "\t"+ assetCode+ "\t"+ "is not found");
         return "asignPage";
     }
 //   boolean isAssigned =asset.isAssigned();
     if( !asset.isAssigned()){
    
     
         assetservice.assignAssetToemployee(aa, emp.getEmployeeId(), asset.getAssetId());
        
     return "redirect:assignPage?act=assigned";
        
     }
     else{
         
          return "redirect:assignPage?act=error";
     }
 }
     // return asign page
    @RequestMapping(value = "/employee_search",method = RequestMethod.GET)
   public ModelAndView searchEmployee(@RequestParam("searchText")String searchText){
         ModelAndView mv =new ModelAndView("asignPage");
               Employee emps = employeeservice.searchByEmployeeCode(searchText);
               
               if(emps==null){
                               mv.addObject("empMessage","employee with " +"\t"+ searchText + "\t"+" not found");
               }
              AssignedAsset aa = new   AssignedAsset ();
              mv.addObject("command", aa);
               mv.addObject("emps",emps);
               
        return mv;  
       

   }
   //  show employee asset by employee id  
   @RequestMapping(value = "/showEmployeAsset",method = RequestMethod.GET)
   public ModelAndView  retriveEmployeeAssets(@RequestParam(value = "employeeId",required = false) String employeeId
){
        ModelAndView mv =new ModelAndView("employeeAsset");
        int assignAssetResultsCount = 0;
       int assignAssetPageCount = 0;
    
        List<AssignedAsset>  assignedAssets = assetservice.retriveAllAssignedAssetByEmployeeCode(employeeId);
   
        mv.addObject("assignedList", assignedAssets);
       assignAssetResultsCount = assetservice.searchAssignAssetCountByEmployee(employeeId);
       mv.addObject("resultsCount", assignAssetResultsCount);
      
//       assignAssetPageCount = assetservice.searchAssignedAssetPageCountByEmployee(employeeId,Assets_PER_PAGE);
//       mv.addObject("pageCount", assignAssetPageCount);
        return mv;
   }
     //  show assigned asset by department,catagory,or both 
   @RequestMapping(value = "/searchAssignedAsset",method = RequestMethod.GET)
   public ModelAndView  SerchAssignedAssets(@RequestParam(value = "deptName", required = false) String name,
           @RequestParam(value = "catName", required = false) String catname, @ModelAttribute("department") Department department,@ModelAttribute("catagory") Catagory catagory, @RequestParam(value = "pageNo", required = false)
         Integer  pageNo){

        ModelAndView mv =new ModelAndView("assignedAsset");
       Catagory cat = null;

       Department dept = null;

       int assignAssetResultsCount = 0;
       int assignAssetPageCount = 0;
      String catagoryId = catagory.getCatagoryId();
       String departmentId = department.getDepartmentId();
       List<AssignedAsset> assignedAssets = null;
       List<Catagory>  catagorylist=null;
       List<Department> departmentlist = null;


         if(catagoryId!=null && departmentId!= null ){
               if(pageNo == null){
                 pageNo = 1;
             mv.addObject("pageNo", (int) pageNo);
              }
             cat = catagoryservice.searchByCatagoryId(catagoryId);

             String       catId = cat.getCatagoryId();
             dept =departmentService.searchByDepartmentId(departmentId);
             String     depId= dept.getDepartmentId();
             if(cat == null || dept == null){
                 mv.addObject("message", "no value found to your search");
                 catagorylist = catagoryservice.getCatagoryList();
                 mv.addObject("catagorylist",catagorylist);
                 departmentlist = departmentService.getDepartmentList();
                 mv.addObject("departmentlist",departmentlist);
                 return mv;
             }
             else {
                 assignAssetResultsCount = assetservice.searchAssignedAssetCountByDepartmentAndcatagoryId(depId, catId);

                 mv.addObject("resultsCount", assignAssetResultsCount);
                 assignAssetPageCount = assetservice.searchAssignedAssetPageCountByDepartmentAndcatagoryId(depId, catId, Assets_PER_PAGE);
                 mv.addObject("pageCount", assignAssetPageCount);
                 assignedAssets = assetservice.retriveAllAssignedAssetByCatagoryAndDEpartment(catId, depId, pageNo, Assets_PER_PAGE);
                 mv.addObject("assignedList", assignedAssets);
                 catagorylist = catagoryservice.getCatagoryList();
                 mv.addObject("catagorylist",catagorylist);
                 departmentlist = departmentService.getDepartmentList();
                 mv.addObject("departmentlist",departmentlist);
                 return mv;
             }
          }
      // searh assigned asset by catagory
          if(catagoryId!=null && departmentId == null){

              cat = catagoryservice.searchByCatagoryId(catagoryId);

              String       catId = cat.getCatagoryId();
         if(  cat== null){
             mv.addObject("message", "No result with" +catname+ "");
            assignedAssets = null;
             mv.addObject("assignedList", assignedAssets);
             catagorylist = catagoryservice.getCatagoryList();
             mv.addObject("catagorylist",catagorylist);
             departmentlist = departmentService.getDepartmentList();
             mv.addObject("departmentlist",departmentlist);
             return mv;
         }
         if (cat !=null){

		assignAssetResultsCount = assetservice.searchAssignedAssetCountByCatagory(catId);

		mv.addObject("resultsCount", 	assignAssetResultsCount);
		assignAssetPageCount = assetservice.searchAssignedAssetPageCountByCatagory(catId,Assets_PER_PAGE);
	           mv.addObject("pageCount", 	assignAssetPageCount );
               assignedAssets  = assetservice.retriveAllAssignedAssetByCatagory(catId,pageNo,Assets_PER_PAGE );
             mv.addObject("assignedList", assignedAssets);
             catagorylist = catagoryservice.getCatagoryList();
             mv.addObject("catagorylist",catagorylist);
             departmentlist = departmentService.getDepartmentList();
             mv.addObject("departmentlist",departmentlist);
             return mv;
         }

      }
          if(departmentId!= null && catagoryId ==null){

              dept =departmentService.searchByDepartmentId(departmentId);
              String     depId= dept.getDepartmentId();
              // searh assigned asset by department
              if(dept!=null){

                  assignAssetResultsCount = assetservice.searchAssignedAssetCountByDepartment(depId);

                  mv.addObject("resultsCount", 	assignAssetResultsCount);
                  assignAssetPageCount = assetservice.searchAssignedAssetPageCountByDepartment(depId,Assets_PER_PAGE);
                  mv.addObject("pageCount", 	assignAssetPageCount );

                  assignedAssets = assetservice.retriveAllAssignedAssetByDepartment(depId,pageNo,Assets_PER_PAGE );
                  mv.addObject("assignedList", assignedAssets);
                  catagorylist = catagoryservice.getCatagoryList();
                  mv.addObject("catagorylist",catagorylist);
                  departmentlist = departmentService.getDepartmentList();
                  mv.addObject("departmentlist",departmentlist);
                  return mv;
              }
          else{
                mv.addObject("message", "No result with" +name+ "");
               assignedAssets= null;
                  mv.addObject("assignedList", assignedAssets);
                  catagorylist = catagoryservice.getCatagoryList();
                  mv.addObject("catagorylist",catagorylist);
                  departmentlist = departmentService.getDepartmentList();
                  mv.addObject("departmentlist",departmentlist);
                  return mv;
           }

      }

         // assignedAssets =  assetservice.retriveAllAssigedAsset();

       // int empAssetCountResult = assetservice.searchAssignedAssetCountByEmployee(employeeId);
        //mv.addObject("empAssetCount", empAssetCountResult);
       return mv;
   }
   // show assigned assets asset
   @RequestMapping(value = "/showAssignedAssets", method = RequestMethod.GET)
   public ModelAndView  retriveAllAssignedAssets(@RequestParam(value = "pageNo", required = false)Integer pageNo){
      ModelAndView mv =new ModelAndView("assignedAsset");
        int assignAssetResultsCount = 0;
       int assignAssetPageCount = 0;
       List<Catagory>  catagorylist=null;
       List<Department> departmentlist = null;
       List<AssignedAsset>  assignedAssets =null;

Catagory catagory = new Catagory();
Department department = new Department();
mv.addObject("catagory", catagory);
mv.addObject("department",department);
         if(pageNo == null){
             pageNo=1;
             mv.addObject("pageNo", (int) pageNo);
                    assignAssetResultsCount = assetservice.searchAssignAssetCount();
       mv.addObject("resultsCount", assignAssetResultsCount);
       assignAssetPageCount = assetservice.searchAssignedAssetPageCount(Assets_PER_PAGE);
       mv.addObject("pageCount", assignAssetPageCount);
       assignedAssets =  assetservice.retriveAllAssigedAsset(pageNo,Assets_PER_PAGE);
       catagorylist = catagoryservice.getCatagoryList();
       mv.addObject("catagorylist",catagorylist);
       departmentlist = departmentService.getDepartmentList();
       mv.addObject("departmentlist",departmentlist);


         }
         else {
        assignAssetResultsCount = assetservice.searchAssignAssetCount();
       mv.addObject("resultsCount", assignAssetResultsCount);
       assignAssetPageCount = assetservice.searchAssignedAssetPageCount(Assets_PER_PAGE);
       mv.addObject("pageCount", assignAssetPageCount);
       assignedAssets =  assetservice.retriveAllAssigedAsset(pageNo,Assets_PER_PAGE);
       catagorylist = catagoryservice.getCatagoryList();
       mv.addObject("catagorylist",catagorylist);
       departmentlist = departmentService.getDepartmentList();
       mv.addObject("departmentlist",departmentlist);

         }
 
      

    
     mv.addObject("assignedList",assignedAssets );
   
      return mv;
   }
    @RequestMapping(value = "/getReturn", method = RequestMethod.GET)
   public ModelAndView getReturnPage(@RequestParam(value ="assignedId",required =false )String id,@RequestParam(value ="employeeId",required = false)String employeeId,
                                     @RequestParam(value ="assetCode",required =false )String assetCode,@RequestParam(value ="employeeCode",required = false)String employeeCode  ){
       ModelAndView mv = new ModelAndView("return");
        AssetHistory ah= new AssetHistory();
        mv.addObject("command",ah);
        mv.addObject("assignedId", id);
        mv.addObject("employeeId", employeeId);
        mv.addObject("assetCode",assetCode);
        mv.addObject("employeeCode",employeeCode);
        return mv;




   }
      // return assigned assets asset
   @RequestMapping(value = "/returnAssignedAssets", method = RequestMethod.POST)
   public ModelAndView  returnAssignedAssets(@Valid @ModelAttribute("command") AssetHistory assetHistroy,BindingResult  result, @RequestParam(value ="assignedId",required = false)String id,@RequestParam(value ="employeeId",required = false)String employeeId, @RequestParam(value ="assetCode",required =false )String assetCode,@RequestParam(value ="employeeCode",required = false)String employeeCode ){
      ModelAndView mv =new ModelAndView("employeeAsset");
       ModelAndView mv1 =new ModelAndView("return");
      if(result.hasErrors()){
        return mv1;
       }
        int assignAssetResultsCount = 0;
       int assignAssetPageCount = 0;
       Asset asset = assetservice.retriveAssetByAssignedId(id);
       String assetId = asset.getAssetId();
       String assetcode = asset.getAssetCode();
       assetHistoryService.registerAssetHisstory(assetId,employeeId,assetHistroy);
        assetservice.returnAsset(id);

    List<AssignedAsset>  assignedAssets = assetservice.retriveAllAssignedAssetByEmployeeCode(employeeId);
     
        assignAssetResultsCount = assetservice.searchAssignAssetCountByEmployee(employeeId);
       mv.addObject("resultsCount", assignAssetResultsCount);
       assignAssetPageCount = assetservice.searchAssignedAssetPageCountByEmployee(employeeId,Assets_PER_PAGE);
       mv.addObject("pageCount", assignAssetPageCount);
       mv.addObject("assignedList", assignedAssets);
       mv.addObject("returnMessage", "asset with " +"\t" +assetcode  +"\t"+ "is free");
  
      return mv;
   }
   
 private Asset convertAssetDtoToAssetEntity(AssetDto ao){
     Asset assetEntity = new Asset();
   assetEntity.setAssetId(ao.getAssetId());
     assetEntity.setAssetName(ao.getAssetName());
     assetEntity.setAssetCode(ao.getAssetCode());
     assetEntity.setBrand(ao.getBrand());
     assetEntity.setCurrentCondition(ao.getCurrentCondition());
     assetEntity.setQualityCondition(ao.getQualityCondition());
     assetEntity.setModel(ao.getModel());
     assetEntity.setDescription(ao.getDescription());
     assetEntity.setManufacturer(ao.getManufacturer());
     assetEntity.setCatagory(ao.getCatagory());
      assetEntity.setPrice(ao.getPrice());
     return assetEntity;
 }
 public  List<assignedAssetSearchDto> getAssignedAssetsearch(List<Catagory> catagoryList, List<Department> departmentList)
 {

    List<assignedAssetSearchDto> searchDto = new ArrayList<>();
     List<assignedAssetSearchDto> search = new ArrayList<>();
     for(Catagory cat : catagoryList){
         assignedAssetSearchDto assignedAssetSearch = new assignedAssetSearchDto();
         assignedAssetSearch.setCategoryId(cat.getCatagoryId());
         assignedAssetSearch.setCatName(cat.getCatagoryName());
         search.add( assignedAssetSearch);


     for(Department dept : departmentList){

         
         assignedAssetSearch.setDepartmentId(dept.getDepartmentId());
         assignedAssetSearch.setDeptName(dept.getName());
         search.add( assignedAssetSearch);

     }
     }
     searchDto.addAll(search);
   return searchDto;

 }
      @RequestMapping(value = "/search_emp", method = RequestMethod.GET)
    public ModelAndView Searchemployee(@RequestParam(name = "firstName",required = false)String firstName,@RequestParam(name = "middleName",required = false)String middleName,@RequestParam(name = "lastName",required = false)String lastName){
         ModelAndView mv = new ModelAndView("employeeAsset");
          List<Employee> empList = null;
         if(firstName !=null){
            empList = employeeservice.getEmployeeByFirstName(firstName);
         }
           if(middleName !=null){
               empList = employeeservice.getEmployeeByMiddleName(middleName);
           }
         if(lastName !=null){
               empList = employeeservice.getEmployeeByLastName(lastName);
           }
        
        
    
         mv.addObject("empList",empList);
       
         
       
         return mv;
    }
      @RequestMapping(value = "/search_empPage", method = RequestMethod.GET)
    public ModelAndView getEmployeeAssetPage(){
         ModelAndView mv = new ModelAndView("employeeAsset");
          return mv;
    }
    //
    @RequestMapping(value = "/assetHistoryPage1", method = RequestMethod.GET)
    public ModelAndView getAssetHistory(@RequestParam(name ="assetCode",required = false) String assetCode){
        ModelAndView mv = new ModelAndView("assetHistory");
      //  List<AssetHistory> assetHistorys = assetHistoryService.getAssetHistoryList(assetCode);

        return mv;
    }
    // show assigned assets asset
    @RequestMapping(value = "/assetHistoryPage", method = RequestMethod.GET)
    public ModelAndView  getAllAssetHisitory(@RequestParam(value = "pageNo", required = false)Integer pageNo){
        ModelAndView mv =new ModelAndView("assetHistory");
        List<Catagory> catagorylist = null;
        int AssetHistoryResultsCount = 0;
        int AssetHistoryPageCount = 0;
        List<AssetHistory>  assetHistories=null;
        Catagory catagory = new Catagory();
        mv.addObject("catagory",catagory);
        if(pageNo == null){
            pageNo=1;
            mv.addObject("pageNo", (int) pageNo);
            AssetHistoryResultsCount =assetHistoryService.searchAssetHistoryCount();
           // assignAssetResultsCount = assetservice.searchAssignAssetCount();
            mv.addObject("resultsCount",  AssetHistoryResultsCount);
            AssetHistoryPageCount = assetHistoryService.searchAssetHistoryPerPage(ASSET_HISTORY_PER_PAGE);
            //assignAssetPageCount = assetservice.searchAssignedAssetPageCount(Assets_PER_PAGE);
            mv.addObject("pageCount",  AssetHistoryPageCount);
            assetHistories = assetHistoryService.retriveAssetHistorys(pageNo, ASSET_HISTORY_PER_PAGE);
           // assignedAssets =  assetservice.retriveAllAssigedAsset(pageNo,Assets_PER_PAGE);
          catagorylist = catagoryservice.getCatagoryList();
          mv.addObject("catagorylist",catagorylist);



        }
        else {
            AssetHistoryResultsCount =assetHistoryService.searchAssetHistoryCount();
            // assignAssetResultsCount = assetservice.searchAssignAssetCount();
            mv.addObject("resultsCount",  AssetHistoryResultsCount);
            AssetHistoryPageCount = assetHistoryService.searchAssetHistoryPerPage(ASSET_HISTORY_PER_PAGE);
            //assignAssetPageCount = assetservice.searchAssignedAssetPageCount(Assets_PER_PAGE);
            mv.addObject("pageCount",  AssetHistoryPageCount);
            assetHistories = assetHistoryService.retriveAssetHistorys(pageNo, ASSET_HISTORY_PER_PAGE);
            // assignedAssets =  assetservice.retriveAllAssigedAsset(pageNo,Assets_PER_PAGE);
            catagorylist = catagoryservice.getCatagoryList();
            mv.addObject("catagorylist",catagorylist);

        }




        mv.addObject("assetHistory",assetHistories );

        return mv;
    }
    //  show asset  history by asset code or catagory
    @RequestMapping(value = "/searchAssetHistory",method = RequestMethod.GET)
    public ModelAndView  SerchAssetsHistoryByCatagory(@ModelAttribute("catagory")Catagory cat, @RequestParam(value = "catagoryId",required = false)String catagoryId,
                                             @RequestParam(value = "pageNo", required = false)
                                                     Integer  pageNo){
        List<Catagory> catagorylist = null;

        Catagory cata = null;

        ModelAndView mv =new ModelAndView("assetHistory");
        int AssetHistoryResultsCount = 0;
        int AssetHistoryPageCount = 0;
        List<AssetHistory>  assetHistories=null;




        // searh  asset history  by catagory
        if(cat!=null){

            cata = catagoryservice.searchByCatagoryId(cat.getCatagoryId());
            String catname =cata.getCatagoryName();
            catagoryId = cat.getCatagoryId();
            if(  catagoryId== null){
                mv.addObject("message", "No result with" +catname+ "");
                catagorylist = catagoryservice.getCatagoryList();
                mv.addObject("catagorylist",catagorylist);
                assetHistories = null;
            }
            if (catagoryId !=null){

                AssetHistoryResultsCount =assetHistoryService.searchAssetHistoryCountByCategory(catagoryId);

                mv.addObject("resultsCount",  AssetHistoryResultsCount);
                AssetHistoryPageCount = assetHistoryService.searchAssetHistoryPerPageByCategory(catagoryId,ASSET_HISTORY_PER_PAGE);


                mv.addObject("pageCount",  AssetHistoryPageCount);
                assetHistories = assetHistoryService.retriveAssetHistoryByCategory(catagoryId,pageNo,ASSET_HISTORY_PER_PAGE);

                catagorylist = catagoryservice.getCatagoryList();
                mv.addObject("catagorylist",catagorylist);
            }

        }





        mv.addObject("assetHistory", assetHistories);
        return mv;
    }
    //  show asset  history by asset code or catagory id
    @RequestMapping(value = "/searchAssetHistoryByCatagoryId",method = RequestMethod.GET)
    public ModelAndView searchAssetHistoryByCatagoryId(@RequestParam(value =  "catagoryId",required = false)String catagoryId,   @RequestParam(value = "pageNo", required = false)
            Integer  pageNo){
        List<Catagory> catagorylist = null;

        Catagory cata = null;

        ModelAndView mv =new ModelAndView("assetHistory");
        int AssetHistoryResultsCount = 0;
        int AssetHistoryPageCount = 0;
        List<AssetHistory>  assetHistories=null;


        Catagory catagory = new Catagory();
        mv.addObject("catagory",catagory);

        // searh  asset history  by catagory
        if(catagoryId!=null){

            cata = catagoryservice.searchByCatagoryId(catagoryId);
            String catname =cata.getCatagoryName();

            if(  catagoryId== null){
                mv.addObject("message", "No result with" +catname+ "");
                catagorylist = catagoryservice.getCatagoryList();
                mv.addObject("catagorylist",catagorylist);
                assetHistories = null;
            }
            if (catagoryId !=null){

                AssetHistoryResultsCount =assetHistoryService.searchAssetHistoryCountByCategory(catagoryId);

                mv.addObject("resultsCount",  AssetHistoryResultsCount);
                AssetHistoryPageCount = assetHistoryService.searchAssetHistoryPerPageByCategory(catagoryId,ASSET_HISTORY_PER_PAGE);


                mv.addObject("pageCount",  AssetHistoryPageCount);
                assetHistories = assetHistoryService.retriveAssetHistoryByCategory(catagoryId,pageNo,ASSET_HISTORY_PER_PAGE);

                catagorylist = catagoryservice.getCatagoryList();
                mv.addObject("catagorylist",catagorylist);
            }

        }





        mv.addObject("assetHistory", assetHistories);
        return mv;
    }
    //  show asset  history by asset code or asset code
    @RequestMapping(value = "/searchAssetHistoryByAssetCode",method = RequestMethod.GET)
    public ModelAndView searchAssetHistoryByAssetCode(@RequestParam(value =  "assetCode",required = false)String assetCode,   @RequestParam(value = "pageNo", required = false)
            Integer  pageNo){
        List<Catagory> catagorylist = null;

        Catagory cata = null;

        ModelAndView mv =new ModelAndView("assetHistory");
        int AssetHistoryResultsCount = 0;
        int AssetHistoryPageCount = 0;
        List<AssetHistory>  assetHistories=null;


        Catagory catagory = new Catagory();
        mv.addObject("catagory",catagory);



            if (assetCode !=null){

                AssetHistoryResultsCount =assetHistoryService.retriveAssetHistoryCountByAssetCode(assetCode);

                mv.addObject("resultsCount",  AssetHistoryResultsCount);
                AssetHistoryPageCount = assetHistoryService.getAssetHistoryPageCountByAssetCode(assetCode,ASSET_HISTORY_PER_PAGE_By_ASSETCODE);


                mv.addObject("pageCount",  AssetHistoryPageCount);
                assetHistories = assetHistoryService.getAssetHistoryList(assetCode,pageNo,ASSET_HISTORY_PER_PAGE_By_ASSETCODE);

                catagorylist = catagoryservice.getCatagoryList();
                mv.addObject("catagorylist",catagorylist);
            }

        else{
            mv.addObject("message", "No result with" +assetCode+ "");
            catagorylist = catagoryservice.getCatagoryList();
            mv.addObject("catagorylist",catagorylist);
            assetHistories = null;
        }






        mv.addObject("assetHistory", assetHistories);
        return mv;
    }
  // ---  search asset to add warranty --//
       @RequestMapping(value = "/asset_search", method = RequestMethod.GET )
    public String contactSearch(Model m, @RequestParam("freeText") String freeText) {
      
        
       Asset  asset =assetservice.searchByAssetCode(freeText);
          AssetDto a_cmd = new AssetDto();
        List<Catagory> catagorylist = catagoryservice.getCatagoryList();
        m.addAttribute("command", a_cmd);
        m.addAttribute("catagorylist", catagorylist);
     
       if (asset==null){
             m.addAttribute("no_asset", "no such asset with "+ "\t \t"+freeText);
       }
      
        
        m.addAttribute("asset", asset );
    
      return "asset";//JSP
    }
   
            
       @RequestMapping(value = "/assetStorePage", method = RequestMethod.GET)
    public ModelAndView  getAllAssetInStore(@RequestParam(value = "pageNo", required = false)Integer pageNo){
        ModelAndView mv =new ModelAndView("assetInStore");
        List<Catagory> catagorylist = null;
        int AssetInStoreResultsCount = 0;
        int AssetInStorePageCount = 0;
        List<Asset>  assets=null;
        Catagory catagory = new Catagory();
        mv.addObject("catagory",catagory);
        if(pageNo == null){
            pageNo=1;
            mv.addObject("pageNo", (int) pageNo);
           AssetInStoreResultsCount =assetservice.findAssetCountInStore();
           // assignAssetResultsCount = assetservice.searchAssignAssetCount();
            mv.addObject("resultsCount",   AssetInStoreResultsCount);
            AssetInStorePageCount = assetservice.findAssetInStorePageCount(Assets_PER_PAGE);
            //assignAssetPageCount = assetservice.searchAssignedAssetPageCount(Assets_PER_PAGE);
            mv.addObject("pageCount",    AssetInStorePageCount);
            assets = assetservice.getAssetListInStore(pageNo, Assets_PER_PAGE, false);
           // assignedAssets =  assetservice.retriveAllAssigedAsset(pageNo,Assets_PER_PAGE);
          catagorylist = catagoryservice.getCatagoryList();
          mv.addObject("catagorylist",catagorylist);



        }
        else {
            AssetInStoreResultsCount =assetservice.findAssetCountInStore();
           // assignAssetResultsCount = assetservice.searchAssignAssetCount();
            mv.addObject("resultsCount",   AssetInStoreResultsCount);
            AssetInStorePageCount = assetservice.findAssetInStorePageCount(Assets_PER_PAGE);
            //assignAssetPageCount = assetservice.searchAssignedAssetPageCount(Assets_PER_PAGE);
            mv.addObject("pageCount",    AssetInStorePageCount);
            assets = assetservice.getAssetListInStore(pageNo, Assets_PER_PAGE, false);
           // assignedAssets =  assetservice.retriveAllAssigedAsset(pageNo,Assets_PER_PAGE);
          catagorylist = catagoryservice.getCatagoryList();
          mv.addObject("catagorylist",catagorylist);

        }




        mv.addObject("assets",assets );

        return mv;
    }       
            //  show asset  in by asset code or catagory id
    @RequestMapping(value = "/searchAssetInStoreByCatagoryId",method = RequestMethod.GET)
    public ModelAndView searchAssetInStoreByCatagoryId(@RequestParam(value =  "catagoryId",required = false)String catagoryId,   @RequestParam(value = "pageNo", required = false)
            Integer  pageNo){
        List<Catagory> catagorylist = null;

        Catagory cata = null;

          ModelAndView mv =new ModelAndView("assetInStore");
       
        int AssetInStoreResultsCount = 0;
        int AssetInStorePageCount = 0;
        List<Asset>  assets=null;
        Catagory catagory = new Catagory();
        mv.addObject("catagory",catagory);


     

        // searh  asset history  by catagory
        if(catagoryId!=null){

            cata = catagoryservice.searchByCatagoryId(catagoryId);
            String catname =cata.getCatagoryName();

            if(  catagoryId== null){
                mv.addObject("message", "No result with" +catname+ "");
                catagorylist = catagoryservice.getCatagoryList();
                mv.addObject("catagorylist",catagorylist);
                assets = null;
            }
            if (catagoryId !=null){

                AssetInStoreResultsCount =assetservice.AssetInStoreCountByCatagory(catagoryId);

                mv.addObject("resultsCount", AssetInStoreResultsCount);
               AssetInStorePageCount  = assetservice.findAssetInStorePageCountByCatagory(catagoryId, Assets_PER_PAGE);


                mv.addObject("pageCount",  AssetInStorePageCount);
                assets = assetservice.searchAssetInCatagory(catagoryId, pageNo,Assets_PER_PAGE , false);

                catagorylist = catagoryservice.getCatagoryList();
                mv.addObject("catagorylist",catagorylist);
            }

        }





        mv.addObject("assets", assets);
        return mv;
    }  
    // asset in store by asset code
     @RequestMapping(value = "/searchAssetInStoreByAssetCode",method = RequestMethod.GET)
    public ModelAndView searchAssetInStoreByAssetCode(@RequestParam(value =  "assetCode",required = false)String assetCode){
          List<Catagory> catagorylist = null;

        Catagory cata = null;

          ModelAndView mv =new ModelAndView("assetInStore");
       
        
        Asset  asset=null;
        Catagory catagory = new Catagory();
        mv.addObject("catagory",catagory);

            catagorylist = catagoryservice.getCatagoryList();
            mv.addObject("catagorylist",catagorylist);

           

           
              asset = assetservice.searchAssetInStoreByAssetCode(assetCode, false);
            if(asset!=null){
                
               mv.addObject("asset", asset);
 
            
            }
            else{
            mv.addObject("message", "No asset with" +"\t \t"+assetCode+ "");
         
            }
        






        return mv;
    }
   
    @RequestMapping(value = "/assetDelete",method = RequestMethod.GET )
 public String removeAsset(@RequestParam(value ="assetId") String assetId,Model m){
        Asset asset= assetservice.searchByAssetId(assetId);
        
  
          if(asset.isAssigned()){
                m.addAttribute("employeeAssetMessage", "this asset is assigned to employee, you can not delete it");  
             AssetDto a_cmd = new AssetDto();
        List<Catagory> catagorylist = catagoryservice.getCatagoryList();
        m.addAttribute("command", a_cmd);
        m.addAttribute("catagorylist", catagorylist);
                return "asset";
          }
          else{
              
         assetservice.removeAsset(asset);
             AssetDto a_cmd = new AssetDto();
        List<Catagory> catagorylist = catagoryservice.getCatagoryList();
        m.addAttribute("command", a_cmd);
        m.addAttribute("catagorylist", catagorylist);
         
          m.addAttribute("AssetMessage", "Successfully deleted"); 
       return "asset";
          }
 }
   @RequestMapping(value = "/editAsset",method = RequestMethod.GET )
    public String editAsset(@RequestParam("assetId")String assetId, Model m){
           List<Catagory> catagorylist = catagoryservice.getCatagoryList();
                 m.addAttribute("catagorylist", catagorylist);
                 
      Asset a_cmd= assetservice.searchByAssetId(assetId);
      AssetDto  adto = convertAssetEntityToAssetDto(a_cmd);
        m.addAttribute("command",  adto);
        return "editAsset";//JSP
    }
         
      @RequestMapping( value ="/asset_edit", method = RequestMethod.POST)
    public String assetEdit(@ModelAttribute("command")  AssetDto assetdto, Model m)  {
          
           List<Catagory> catagorylist = catagoryservice.getCatagoryList();
                 m.addAttribute("catagorylist", catagorylist);
           
          Asset asset = convertAssetDtoToAssetEntity( assetdto);
      
               assetservice.editAsset(asset);
                return "redirect:/asset/asset_reg?act=success";  
           
    
    }
         
    private AssetDto convertAssetEntityToAssetDto(Asset a){
         
   AssetDto ao = new AssetDto();
   ao.setAssetId(a.getAssetId());
   ao.setAssetCode(a.getAssetCode());
   ao.setAssetName(a.getAssetName());
   ao.setBrand(a.getBrand());
   ao.setCurrentCondition(a.getCurrentCondition());
   ao.setDescription(a.getDescription());
   ao.setModel(a.getModel());
   ao.setQualityCondition(a.getQualityCondition());
   ao.setPrice(a.getPrice());
   ao.setCatagory(a.getCatagory());

 
     return ao;
 }

}
