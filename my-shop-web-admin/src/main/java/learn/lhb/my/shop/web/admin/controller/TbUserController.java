package learn.lhb.my.shop.web.admin.controller;

import learn.lhb.my.shop.commons.constant.ConstantUtils;
import learn.lhb.my.shop.commons.dto.BaseResult;
import learn.lhb.my.shop.domain.TbUserDomain;
import learn.lhb.my.shop.web.admin.service.TbUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

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
    public String save (TbUserDomain tbUserDomain, Model model, RedirectAttributes redirectAttributes)  {
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
     * 搜索（单个框）
     * @param keyword
     * @return
     */
    @PostMapping("search")
    public String search(String keyword,Model model)    {
        List<TbUserDomain> tbUserDomains = tbUserService.search(keyword);
        model.addAttribute(ConstantUtils.SESSION_USERS,tbUserDomains);
        return "user_list";
    }
}
// TODO 把jQuery Validation的用法做个笔记，千峰(最好把文档里有关jQuery的用法都移植到我的笔记里面来)