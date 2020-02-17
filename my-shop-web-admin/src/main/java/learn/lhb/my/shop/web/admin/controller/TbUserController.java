package learn.lhb.my.shop.web.admin.controller;

import learn.lhb.my.shop.commons.constant.ConstantUtils;
import learn.lhb.my.shop.commons.dto.BaseResult;
import learn.lhb.my.shop.commons.dto.DataTablePageInfo;
import learn.lhb.my.shop.domain.TbUserDomain;
import learn.lhb.my.shop.web.admin.service.TbUserService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户管理
 *
 * @author 梁鸿斌
 * @date 2020/2/15.
 * @time 00:35
 */
@Controller
@RequestMapping(value = "user")
public class TbUserController {

    public static final Logger logger = LoggerFactory.getLogger(TbUserController.class);

    @Autowired
    private TbUserService tbUserService;

    /**
     * 把实体类 tbUserDomain 放到model
     * @param id
     * @return
     */
    @ModelAttribute
    public TbUserDomain getTbUser(Long id) {
        TbUserDomain tbUserDomain = new TbUserDomain();
        return tbUserDomain;
    }

//    /**
//     * 传一个空的结果集给前端
//     * @return
//     */
//    @ModelAttribute
//    public BaseResult baseResult()  {
//        BaseResult baseResult = BaseResult.toNull();
//        return baseResult;
//    }

    /**
     * 跳转到用户列表页
     * @return
     */
    @GetMapping("list")
    public String list(Model model)    {

        List<TbUserDomain> tbUserDomains = tbUserService.selectAll();
        model.addAttribute(ConstantUtils.SESSION_USERS,tbUserDomains);
        // TODO for 和 foreach做个笔记,list里面的遍历也做个笔记
//        for (int i=0;i<tbUserDomains.size();i++)  {
//            logger.debug("id = {}",tbUserDomains.get(i).getId());
//        }
        return "user_list";
    }

    /**
     * 跳转用户表单页（新增编辑操作）
     * @return
     */
    @GetMapping("form")
    public String form(Model model)    {

//        TbUserDomain tbUserDomain = new TbUserDomain();
//        model.addAttribute(ConstantUtils.SESSION_USER,tbUserDomain);
        return "user_form";
    }

    // TODO 看千峰的springMVC的笔记，把我的笔记有关 model补全
    /**
     * 保存用户信息(包括新增和编辑)
     * @param tbUserDomain
     * @param redirectAttributes
     * @return
     */
    @PostMapping("save")
    public String save (@ModelAttribute(value = "tbUser") TbUserDomain tbUserDomain, Model model, RedirectAttributes redirectAttributes)  {
        BaseResult baseResult = tbUserService.save(tbUserDomain);

        // 保存成功
        if (baseResult.getStatus() == 200)  {
            redirectAttributes.addFlashAttribute(ConstantUtils.BASERESULT,baseResult);
            return "redirect:/user/list";
        }
        // 保存失败
            else {
            model.addAttribute(ConstantUtils.BASERESULT,baseResult);
            return "user_form";
        }
    }

    /**
     * 搜索
     * @param tbUserDomain
     * @return
     */
    @PostMapping("search")
    public String search(TbUserDomain tbUserDomain,Model model)    {
        List<TbUserDomain> tbUserDomains = tbUserService.search(tbUserDomain);
        model.addAttribute(ConstantUtils.SESSION_USERS,tbUserDomains);
        return "user_list";
    }

    /**
     * 删除用户信息
     * @param ids
     * @return
     */
    @ResponseBody
    @PostMapping("delete")
    public BaseResult delete(String ids)    {
        BaseResult baseResult = null;
        if (StringUtils.isNoneBlank(ids))   {
            baseResult = BaseResult.ok("删除用户成功");
            String[] idArray = ids.split(",");
            tbUserService.deleteMulti(idArray);
        }   else {
            baseResult = BaseResult.error("删除用户失败");
        }
        return baseResult;
    }

    // TODO java 枚举

    /**
     * 分页查询
     * @return
     */
    @ResponseBody
    @GetMapping("page")
    public DataTablePageInfo<TbUserDomain> page(HttpServletRequest request)    {


        String strDraw = request.getParameter("draw");
        String strStart = request.getParameter("start");
        String strLength = request.getParameter("length");

        int draw = strDraw == null ? 0 : Integer.parseInt(strDraw);
        int start = strStart == null ? 0 : Integer.parseInt(strStart);
        int length = strLength == null ? 10 : Integer.parseInt(strLength);

        // 封装 Databales 需要的结果
        DataTablePageInfo<TbUserDomain> pageInfo = tbUserService.page(draw, start, length);

        return pageInfo;
    }
}
// TODO 把jQuery Validation的用法做个笔记，千峰(最好把文档里有关jQuery的用法都移植到我的笔记里面来)